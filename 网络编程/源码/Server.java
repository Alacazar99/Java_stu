package Image;

//����ˣ�

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
                	//������յķ�����bye������ѭ��
                    String str = scan.next().trim();
                    if (str.equalsIgnoreCase("exit")) {
                        out.println("���ͻ��ˡ��ѶϿ�����......");

                    } else {
                    //����Ϊ���յ�str������equalsIgnoreCase()�����ж��ַ������ݣ�
                    	System.out.println(scan);
                    	String strs = new String("������ˡ���");
                    	
                        if (str.equalsIgnoreCase("���")) {
                            out.println(strs+"���!");
                            
                        } else if (str.equalsIgnoreCase("�Է�����")) {
                            out.println(strs + "����!");
                            
                        } else if (str.equalsIgnoreCase("���ǻ�������")) {
                            out.println(strs + "����ǻ����ˡ�����");
                            
                        } else if (str.equalsIgnoreCase("�Ͽ���")) {
                            out.println(strs + "�㲻���Ѿ��̿�����");
                            
                        } else if (str.equalsIgnoreCase("�������")) {
                            out.println(strs + "�����������");
                        } else {
                            out.println(strs + "��......��˵ɶ�� ��û����������˵һ��...");
                            out.println(strs + "�ף���߽������س�ά��һ���������ҶԻ�...");
//                            out.println(strs + "������˼�������ˣ�������Ҳ��Ҫ˯����....");
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
        System.out.println("�����ǡ�����ˡ�10001�Ŷ˿�...");
        System.out.println("���ڵȴ����ͻ��ˡ�������...");
        boolean flag = true;
        while (flag) {
            //��ʼ�����������շ�����ͻ��˽���Socektͨ��
        	
            Socket client = server.accept();
            //�����Ϳͻ��˵�ͨ�ţ�ʹ������ת�ʹ����̶߳�������
            new Thread(new Demo_Thread(client)).start();
            System.out.println("���ͻ��ˡ����ӳɹ�...�������ݴ���");
        }
        server.close();        //�����Ҫ�رշ�����
    }
}