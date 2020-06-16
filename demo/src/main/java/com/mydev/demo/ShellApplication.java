package com.mydev.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 执行Shell脚本。
 * /*
 * #!/bin/bash
 * source ~/.bash_profile
 * mysqldump -uroot -p'123qwe!@' --databases versiontrace>~/database/versiontrace.sql
 */
public class ShellApplication {
    public static void main(String[] args) {
        File file = new File("/Users/pengchenyi/database/dbbackup.sh");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            StringBuffer sb = new StringBuffer();
            byte[] buf = new byte[1024];
            int length = 0;
            //循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
            //当文件读取到结尾时返回 -1,循环结束。
            while((length = inputStream.read(buf)) != -1) {
                sb.append(new String(buf, 0, length));
                System.out.print(new String(buf, 0, length));
            }

            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",sb.toString()},null,null);
            int exitValue = process.waitFor();
            if (0 != exitValue) {
                System.out.println("call shell failed. error code is :" + exitValue);
            }
        } catch (Throwable e) {
            System.out.println("call shell failed. " + e);
        }finally {
            try{
                if(inputStream !=null) inputStream.close();
            }catch (IOException e){

            }

        }
    }
}


