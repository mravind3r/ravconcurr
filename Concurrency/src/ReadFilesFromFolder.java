
	

import java.io.File;


public class ReadFilesFromFolder {
  public static File folder = new File("/home/ravi");
  static String temp = "";

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
    listFilesForFolder(folder);
  }

  public static void listFilesForFolder(final File folder) {

    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.isDirectory()) {
        // System.out.println("Reading files under the folder "+folder.getAbsolutePath());
        listFilesForFolder(fileEntry);
      } else {
        if (fileEntry.isFile()) {
          temp = fileEntry.getName();
          if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt"))
            System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
        }

      }
    }
  }
}

