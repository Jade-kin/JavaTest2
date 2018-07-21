package com.hand;

import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class AnalysisJSON extends Thread {
    @Override
    public void run() {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sh601006");
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity, "UTF-8");
            String[] info = result.split(",");

            //创建JSON数据
            JsonObject jsonObject = new JsonObject();
            //添加属性
            jsonObject.addProperty("name", info[0]);
            jsonObject.addProperty("open", info[1]);
            jsonObject.addProperty("close", info[2]);
            jsonObject.addProperty("current", info[3]);
            jsonObject.addProperty("high", info[4]);
            jsonObject.addProperty("low", info[5]);

            //输出文件
            File file = new File("Exam3/tmp");
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(new File("Exam3/tmp/sz300170.json"));
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(jsonObject.toString());

            bw.close();
            osw.close();
            fos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
