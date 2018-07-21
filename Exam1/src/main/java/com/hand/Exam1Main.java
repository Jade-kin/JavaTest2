package com.hand;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 缓冲流读写pdf
 *
 */
public class Exam1Main {
    public static void main( String[] args ) {

        try {
            URL url = new URL("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");
            URLConnection connection = url.openConnection();
            //读
            InputStream is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is,1000);

            //写
            File file = new File("Exam1/tmp");
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("Exam1/tmp/SampleChapter1.pdf");
            BufferedOutputStream bos = new BufferedOutputStream(fos,1000);

            byte[] input = new byte[100000];
            while (bis.read(input) != -1){
                bos.write(input);
            }

            System.out.println("下载成功！");

            bos.close();
            fos.close();
            bis.close();
            is.close();

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
