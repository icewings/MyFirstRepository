package priv.tsing.demoProject.fileOperation;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		File files = null;
		String filesName = null;
		
		FileObject fo = new FileObject();		
		filesName = fo.getSelectedFilesPath();
		if(null==filesName){
			System.out.println("已取消选择");
		} else {
			files = new File(filesName);
			// 若文件或目录存在
			if (files.exists()) { // 如果文件或目录存在，则删除
				fo.deleteFiles(files);
				System.out.println("Deleted Successfully!");
			}
		}
	}

}
