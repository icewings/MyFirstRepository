package priv.tsing.demoProject.fileOperation;

import java.io.File;

import javax.swing.JFileChooser;

public class FileObject {	
	/**
	 * Browse and select file or directory
	 * @return Selected file or directory path
	 */
	public String getSelectedFilesPath(){
		String selectedFilePath = null;
		//Create a file browser
		JFileChooser fileChooser = new JFileChooser();
		//mode: FILES_ONLY , DIRECTORIES_ONLY, FILES_AND_DIRECTORIES
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//Show browser for selecting file or directory
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){			//Selected successfully
			//Get the path of selected file or directory
			File selectedFile = fileChooser.getSelectedFile();
			selectedFilePath = selectedFile.getPath();
		}else{	//Nothing is selected
			System.out.println("No File or Directory is selected!");
		}
		return selectedFilePath;
	}
	
	/**
	 * Delete file or directory
	 * @return Null
	 */
	public void deleteFiles(File deleteFiles) {
		if (deleteFiles.isFile()) { 					//若是文件，则直接删除
			deleteFiles.delete();
			System.out.println(deleteFiles);
		}
		if (deleteFiles.isDirectory()) { 		//若是目录：包含2种目录，即空目录和非空目录
			File[] childFile = deleteFiles.listFiles();
			if(childFile.length > 0){				//若是非空目录，则递归删除
				for (int i = 0; i < childFile.length; i++) { 		// 遍历目录
					deleteFiles(childFile[i]);		//递归删除子文件或子目录
				} 
			}			
			if(deleteFiles.delete()){				//若是空目录，则直接删除
				System.out.println(deleteFiles);
			};
		}
	}
	
}
