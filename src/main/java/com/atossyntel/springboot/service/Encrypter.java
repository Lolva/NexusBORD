package com.atossyntel.springboot.service;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Encrypter {
	private static final String ALGORITHM = "PBKDF2WithHmacSHA1"; // encryption algorithm used
	private static final int STRENGTH = 65536; // higher number = slower, but more secure
	private static final int SIZE = 128; // size of the hash created from a password
	
	// this encrypter can throw an error if the algorithm given by name stored in static string ALGORITHM does not exist
	//  as well as if the KeySpec created with the user input cannot be used by the hash generator
	// I don't see this happening, but these errors should be handled correctly by any functions making use of the Encrypter
	
	public static String encryptPassword(char[] input) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// no salt was specified in the input parameters, so create one at random (used for creating new passwords)
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		// Store information in a key structure to be used in encryption, then instantiate an object for encrypting key structures
		KeySpec spec = new PBEKeySpec(input, salt, STRENGTH, SIZE);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
		
		byte[] hash = factory.generateSecret(spec).getEncoded(); // this turns the key structure into an encrypted, hashed byte array
		
		byte[] finalHash = new byte[salt.length + hash.length]; // concatenate salt and hashed password for storage and retrieval of salt
		System.arraycopy(salt, 0, finalHash, 0, salt.length);	//  (salt must be stored for later comparison) (salt is first 16 bytes of final hash)
		System.arraycopy(hash, 0, finalHash, salt.length, hash.length);
		
		Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding(); // create object for converting byte arrays for very friendly string objects
		return enc.encodeToString(finalHash); // convert hashed byte array to a String so friendly that it can even be parsed as a url
	}
	
	public static String encryptPassword(char[] input, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// salt was specified in the input parameters, use given salt (used when comparing passwords to other passwords)
		// Besides not creating a new salt, this method is equivalent to encryptPassword(char[]) above
		KeySpec spec = new PBEKeySpec(input, salt, STRENGTH, SIZE);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
		
		byte[] hash = factory.generateSecret(spec).getEncoded();
		
		byte[] finalHash = new byte[salt.length + hash.length];
		System.arraycopy(salt, 0, finalHash, 0, salt.length);
		System.arraycopy(hash, 0, finalHash, salt.length, hash.length);
		
		Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
		return enc.encodeToString(finalHash);
	}
	
	public static boolean matchPassword(char[] input, String hashed) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] hash = Base64.getUrlDecoder().decode(hashed); // convert hashed String back into a byte array
		byte[] salt = Arrays.copyOfRange(hash, 0, 16); // use this newly-converted byte array to retrieve salt
		
		String inputHash = encryptPassword(input, salt); // encrypt user input using salt stored in database
		return inputHash.equals(hashed); // return whether or not the newly-encrypted user input matches the stored hashed password
	}
}