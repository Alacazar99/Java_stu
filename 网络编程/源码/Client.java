package Image;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
 
public class Client {
    public static void main(String[] args) throws Exception {
    	
    	System.out.println("【客户端】尝试连接中...");
        //设置地址端口
        Socket client = new Socket("127.0.0.2", 10001);
        Scanner input = new Scanner(System.in);
        //scan对象传入输入方法
        Scanner scan = new Scanner(client.getInputStream());
        //使用输出流打印
        PrintStream out = new PrintStream(client.getOutputStream());
        input.useDelimiter("\n");    //使用换行符表示输入完成
        scan.useDelimiter("\n");     //将换行符之前的数据读取
        //设置标志，根据输入的条件判断是否结束循环
        boolean flag = true;  
        System.out.println("【客户端】已连接成功...");
        System.out.println("【服务器端升级啦】 会对你发送的消息进行回复哦，快来撩一撩吧~");
        while (flag) {
            if (input.hasNext()) {
                //使用next()读取str字符串
                String str = input.next().trim();
                out.println(str);
                if (str.equalsIgnoreCase("exit")) {
                    flag = false;
                }
               //扫描流对象读取的字符串
                if (scan.hasNext()) {
                    System.out.println(scan.next());
                }
            }
        }
        input.close();
        out.close();
        scan.close();
    }
}