package lambda;
import java.io.File;
import java.io.FileFilter;

public class Lambda {
  public static void main(String[] args) {
    FileFilter filter = new FileFilter() {

      @Override
      public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
      }

    };

    File dir = new File("c:/tmp");
    File[] files = dir.listFiles(filter);
    for (File f : files) {
      System.out.println(f);
    }


    //Lambda
    FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");

    File[] filesLambda = dir.listFiles(filterLambda);
    for (File f : filesLambda) {
      System.out.println(f);
    }
  }
}