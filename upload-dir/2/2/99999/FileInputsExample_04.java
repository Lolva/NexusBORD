package com.atosSyntel.IOStreamBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputsExample_04 {

	public static void main(String[] args) {
		//Try with resources - introduced after Java 1.7
		try(InputStream fileIOStream = new FileInputStream("C:/Examples/Databases/PLSQL.txt")) {			
			int c;
			while((c=fileIOStream.read())!=-1){
				System.out.println((char)c);
			}
		}catch (FileNotFoundException e) {
			System.out.println("File Exception:"+e.getMessage());
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Exception while Reading the file:"+e.getMessage());
			e.printStackTrace();
		}
	}

}
