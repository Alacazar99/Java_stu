package Image;

//服务端；

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
class Demo_Thread implements Runnable {
    private Socket client;
    
    public Demo_Thread(Socket client) {
        this.client = client;
    }
 
    @Override
    public void run() {
        try {
            Scanner scan = new Scanner(client.getInputStream());
            PrintStream out = new PrintStream(client.getOutputStream());
            boolean flag = true;
            while (flag) {
                if (scan.hasNext()) {
                	//如果接收的方法是bye，结束循环
                    String str = scan.next().trim();
                    if (str.equalsIgnoreCase("exit")) {
                        out.println("【客户端】已断开连接......");

                    } else {
                    //以下为接收的str，调用equalsIgnoreCase()方法判断字符串内容；
                    	System.out.println(scan);
                    	String strs = new String("【服务端】：");
                    	
                        if (str.equalsIgnoreCase("你好")) {
                            out.println(strs+"你好!");
                            
                        } else if (str.equalsIgnoreCase("吃饭了吗")) {
                            out.println(strs + "吃啦!");
                            
                        } else if (str.equalsIgnoreCase("你是机器人吗")) {
                            out.println(strs + "你才是机器人。。。");
                            
                        } else if (str.equalsIgnoreCase("上课了")) {
                            out.println(strs + "你不是已经翘课了吗？");
                            
                        } else if (str.equalsIgnoreCase("天气如何")) {
                            out.println(strs + "今天天气真好");
                        } else {
                            out.println(strs + "嗯......你说啥？ 我没听懂，你再说一遍...");
                            out.println(strs + "亲，这边建议您回厂维修一下再来和我对话...");
//                            out.println(strs + "不好意思，我困了，机器人也是要睡觉哒....");
                        }
                    }
                }
            }
            scan.close();
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(10001);
        System.out.println("这里是【服务端】10001号端口...");
        System.out.println("正在等待【客户端】的连接...");
        boolean flag = true;
        while (flag) {
            //初始化服务器接收方法与客户端进行Socekt通信
        	
            Socket client = server.accept();
            //开启和客户端的通信，使用向上转型创建线程对象并启动
            new Thread(new Demo_Thread(client)).start();
            System.out.println("【客户端】连接成功...可以数据传输");
        }
        server.close();        //最后需要关闭服务器
    }
}