package com.hand;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class AnalysisXML extends Thread {
    @Override
    public void run() {

        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sh601006");
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(httpEntity,"UTF-8");
            String[] info = result.split(",");

            //创建
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            //设置根标签
            Element root = document.createElement("xml");

            //创建子标签
            Element stock = document.createElement("stock");
            Element name = document.createElement("name");
            name.setTextContent(info[0]);
            Element open = document.createElement("open");
            open.setTextContent(info[1]);
            Element close = document.createElement("close");
            close.setTextContent(info[2]);
            Element current = document.createElement("current");
            current.setTextContent(info[3]);
            Element high = document.createElement("high");
            high.setTextContent(info[4]);
            Element low = document.createElement("low");
            low.setTextContent(info[5]);
            stock.appendChild(name);
            stock.appendChild(open);
            stock.appendChild(close);
            stock.appendChild(current);
            stock.appendChild(high);
            stock.appendChild(low);

            root.appendChild(stock);
            document.appendChild(root);

            //输出
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            File file = new File("Exam3/tmp");
            if(!file.exists()){
                file.mkdirs();
            }
            transformer.transform(new DOMSource(document),
                    new StreamResult(new File("Exam3/tmp/sz300170.xml")));
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (TransformerException e){
            e.printStackTrace();
        }
    }
}
