package thuc_hanh_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }





    private static void copyFileUsingStream(File source, File dest)throws IOException{
        InputStream is=null;
        OutputStream os=null;
        try{
            is=new FileInputStream(source);
            os=new FileOutputStream(dest);
            byte[] bufffer=new byte[1024];
            int length;
            while ((length=is.read(bufffer))>0){
                os.write(bufffer,0,length);
            }

        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter soure file: ");
        String sourcePath=in.nextLine();
        System.out.println("Enter destination file: ");
        String destPath=in.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile=new File(destPath);
        try{
            copyFileUsingJava7Files(sourceFile, destFile);
        }
        catch (IOException e){
            System.out.println("copy completed");
            System.out.println("Can't copy that file");
        }
    }
}
