// Example from: https://www.mkyong.com/swing/java-swing-jfilechooser-example/

package fileUpload;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class StudentFileUpload {
	
	public static void main(String[] args){
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView());
		 
		int returnVal = jfc.showOpenDialog(null);
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
	}
}
