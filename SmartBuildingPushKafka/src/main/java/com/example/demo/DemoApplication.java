package com.example.demo;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //  SpringApplication.run(DemoApplication.class, args);

        String dataPath = "C:\\newcastle\\data.txt";
        // readFile(dataPath);
        //readFileByChars(dataPath);
        readChangeLine(dataPath);
    }


    /**
     * 读入TXT文件
     */
    public static void readFile(String pathName) {
        // String pathname = "input.txt";
        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT文件
     */
  /*      public static void writeFile() {
            try {
                File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
                writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
                try (FileWriter writer = new FileWriter(writeName);
                     BufferedWriter out = new BufferedWriter(writer)
                ) {
                    out.write("我会写入文件啦1\r\n"); // \r\n即为换行
                    out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                    out.flush(); // 把缓存区内容压入文件
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            char[] str=text.toCharArray();
        }*/


    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void readChangeLine(String fileName) {

        try {
            Scanner in = new Scanner(new File(fileName));

            // PrintWriter out = new PrintWriter(new File("C:\\result.txt"));
            //将处理后的文件output.txt创建到该地址下

            while (in.hasNext()) {
                String str = in.nextLine();
                //按行读取，遇到换行符停止。将读取到的内容赋值到str中
                PrintWriter out = new PrintWriter(new File("C:\\temperature.txt"));
                PrintWriter out1 = new PrintWriter(new File("C:\\humidity.txt"));
                PrintWriter out2 = new PrintWriter(new File("C:\\co2.txt"));
                PrintWriter out3 = new PrintWriter(new File("C:\\lighting.txt"));
                String[] ss = str.split(" b'");//按照指定字符将字符串分割，并将分割后的字符串放入数组中

                for (String s : ss) {
                    if (s.length() > 36) {
                        System.out.println(s.length());
                        s = s.substring(0 , s.length() - 36);
                        if (s.toLowerCase().contains("temperature")) {
                            out.write(s + "\r\n");//在子字符串后加上‘}’和换行符并输出文本
                        } else if (s.toLowerCase().contains("humidity")) {
                            out1.write(s + "\r\n");//在子字符串后加上‘}’和换行符并输出文本
                        } else if (s.toLowerCase().contains("co2")) {
                            out2.write(s + "\r\n");//在子字符串后加上‘}’和换行符并输出文本
                        } else if (s.toLowerCase().contains("lighting")) {
                            out3.write(s + "\r\n");//在子字符串后加上‘}’和换行符并输出文本
                        }
                    }

                }
                out.close(); //关闭写入的文本
                out1.close(); //关闭写入的文本
                out2.close(); //关闭写入的文本
                out3.close(); //关闭写入的文本
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
