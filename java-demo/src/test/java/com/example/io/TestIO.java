package com.example.io;

import junit.framework.TestCase;

import java.io.*;

/**
 * io流基础
 * 有缓冲实现可以更快实现传输，可以验证下
 * @auther wendongchao
 * @date 2023/6/15 16:13
 **/
public class TestIO extends TestCase {

    /**
     * 字符输入流
     * 读取外部数据（磁盘、光盘等存储设备）
     *
     * @throws IOException
     */
    public void test01() throws IOException {
        //1.实例化File类的对象
        File file = new File("../doc/io.txt");
        //2.提供具体的流
        FileReader fr = new FileReader(file);
        //3.数据的读入
        int data = fr.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fr.read();
        }
        //4.关闭流
        fr.close();
    }

    /**
     * 字符输入流
     * 将程序（内存）数据写入到磁盘上
     *
     * @throws IOException
     */
    public void test02() throws IOException {
        File file = new File("../doc/io.txt");
        FileWriter fw = new FileWriter(file);
        String data = "io writer";
        char[] charArray = data.toCharArray();
        for (char c : charArray) {
            fw.write(c);
        }
        fw.close();
    }

    /**
     * 字节输入流
     * @throws IOException
     */
    public void test03() throws IOException {
        InputStream fileInputStream = new FileInputStream("../doc/io.txt");

        int data = fileInputStream.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fileInputStream.read();
        }
        fileInputStream.close();
    }

    /**
     * 字节输出流
     * @throws IOException
     */
    public void test04() throws IOException {
        OutputStream fileOutputStream = new FileOutputStream("../doc/io.txt");

        String data = "io outputStream";
        byte[] bytes = data.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }


}
