package Image;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
 
public class Client {
    public static void main(String[] args) throws Exception {
    	
    	System.out.println("���ͻ��ˡ�����������...");
        //���õ�ַ�˿�
        Socket client = new Socket("127.0.0.2", 10001);
        Scanner input = new Scanner(System.in);
        //scan���������뷽��
        Scanner scan = new Scanner(client.getInputStream());
        //ʹ���������ӡ
        PrintStream out = new PrintStream(client.getOutputStream());
        input.useDelimiter("\n");    //ʹ�û��з���ʾ�������
        scan.useDelimiter("\n");     //�����з�֮ǰ�����ݶ�ȡ
        //���ñ�־����������������ж��Ƿ����ѭ��
        boolean flag = true;  
        System.out.println("���ͻ��ˡ������ӳɹ�...");
        System.out.println("������������������ ����㷢�͵���Ϣ���лظ�Ŷ��������һ�ð�~");
        while (flag) {
            if (input.hasNext()) {
                //ʹ��next()��ȡstr�ַ���
                String str = input.next().trim();
                out.println(str);
                if (str.equalsIgnoreCase("exit")) {
                    flag = false;
                }
               //ɨ���������ȡ���ַ���
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