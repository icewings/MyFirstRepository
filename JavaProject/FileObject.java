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
		if(returnVal == JFileChooser.APPROVE_OPTION){	//Selected successfully
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
		if (deleteFiles.isFile()) { // 若是文件，则直接删除
			deleteFiles.delete();
			System.out.println(deleteFiles);
		}
		if (deleteFiles.isDirectory()) { 	// 若是目录
			File[] childFile = deleteFiles.listFiles();
			if(childFile.length > 0){			// 删除非空目录
				for (int i = 0; i < childFile.length; i++) { // 遍历目录
					if (childFile[i].isFile()) { 	// 若子目录是文件或空目录，则直接删除
						childFile[i].delete();
						System.out.println(childFile[i]);
					} else { 							// 若是非空目录，则递归删除子文件
						deleteFiles(childFile[i]);
					}
				} // for
			}			
			if(deleteFiles.delete()){			// 删除空目录
				System.out.println(deleteFiles);
			};
		}
	}
	
}
