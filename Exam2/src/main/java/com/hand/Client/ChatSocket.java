package com.hand.Client;

import java.io.*;
import java.net.Socket;

public class ChatSocket extends Thread{

    @Override
    public void run() {
        try {
            FileInputStream fis = new FileInputStream("Exam1/tmp/SampleChapter1.pdf");
            File file = new File("Exam2/tmp");
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("Exam2/tmp/SampleChapter1.pdf");

            byte[] input = new byte[50];
            while (fis.read(input) != -1){
                fos.write(input);
            }

            System.out.println("传输成功,并断开链接！");
            fos.close();
            fis.close();

        }catch (FileNotFoundException e){
            System.out.println("文件未找到！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
