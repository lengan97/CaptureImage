/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Huong Giang
 */
public class Capture {

    /**
     * @param args the command line arguments
     */
    void listFolder(File dir) throws IOException {
        File fn = new File("C:\\Users\\Huong Giang\\Desktop\\KetQua.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory() && file.isHidden() == false) {
                System.out.println("thumuc: " + file.getCanonicalPath());
                fw = new FileWriter(fn);
                bw = new BufferedWriter(fw);
                bw.write(dir.getAbsolutePath() + "\\" + file.getName() + "\r\n");
                listFolder(file);
            } else if (file.isFile() && file.isHidden() == false) {
                System.out.println("file: " + file.getCanonicalPath());
//                fw = new FileWriter(fn.getAbsoluteFile(), true);
//                bw = new BufferedWriter(fw);
//                bw.write(dir.getAbsolutePath() + "\\" + file.getName() + "\r\n");
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file), "UTF8"));
                String str;

                while ((str = br.readLine()) != null) {

                    System.out.println(str);

                    //   System.out.println(file.getAbsolutePath());
                    if (!fn.exists()) {
                        fn.createNewFile();
                    }
//                    fw = new FileWriter(fn.getAbsoluteFile(), true);
//                    bw = new BufferedWriter(fw);
//                    bw.write(dir.getAbsolutePath() + "\\" + file.getName() + "\r\n");
                    break;

                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Nhap thu muc ban muon tim kim (D:\\ABC):");
        String a = sc.nextLine();

        new Capture().listFolder(new File(a));
    }

}
