package com.hand;

/**
 * Exam3
 * 文本解析器
 *
 */
public class Exam3Main {
    public static void main( String[] args ) {
        System.out.println("股票编码：");
        System.out.println("开始获取数据。。。。。。");
        //解析XML
        AnalysisXML analysisXML = new AnalysisXML();
        analysisXML.start();
        //解析JSON
        AnalysisJSON analysisJSON = new AnalysisJSON();
        analysisJSON.start();
        System.out.println("获取数据成功！");
        System.out.println("解析为xml成功！");
        System.out.println("解析为json成功！");
    }
}
