
//导入包
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
 
 
public class Login{
	public static void main (String []args){
 
        AFrame f = new AFrame("学生信息管理系统");
        f.setSize(1000 , 500);
		f.setLocation(300 , 300);
		f.setVisible(true);
        f.setLocationRelativeTo(null);   //让窗口居中显示；
		f.setResizable(false);           //为了美观定死了窗口的大小；
		f.setIconImage(f.getToolkit().getImage("Image/LOGE.jpg")); //设置标题logo
 
    }
}
 
 //建立私有变量（按钮）
class AFrame extends JFrame{
    JButton b1;
    JButton b2;
    JTextField t1;
    JTextField t2;
 
    public AFrame(String title){
        super(title);
        this.setLayout(null);
        Panel p = new Panel(); 
        b1 =new JButton("登陆");
        b2 =new JButton("取消");//添加button
    
        t1 =new JTextField(25);
        t1.setFont(new Font("宋体",Font.BOLD,25));
 
        t2 =new JPasswordField(25);
        t2.setFont(new Font("宋体",Font.BOLD,25));//添加textfield
			
 
        JLabel nameLabel = new JLabel("账号");
        nameLabel.setFont(new Font("宋体",Font.BOLD,25));
        nameLabel.setHorizontalAlignment(JTextField.CENTER);
        JLabel pwdLabel = new JLabel("密码");
        pwdLabel.setFont(new Font("宋体",Font.BOLD,25));
        pwdLabel.setHorizontalAlignment(JTextField.CENTER);
 
        this.setBounds(300,300,1000,500);
        this.add(nameLabel);
        this.add(t1);
        this.add(pwdLabel);
        this.add(t2);
        this.add(b1);
        this.add(b2);
        //设置位置
        nameLabel.setBounds(100,100,200,50);
        pwdLabel.setBounds(100,200,200,50);
        t1.setBounds(600,100,200,50);
        t2.setBounds(600,200,200,50);
        b1.setBounds(100,300,200,50);
        b2.setBounds(600,300,200,50);
 
        b1.addActionListener (new ResponseButton());
 
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"单击确定退出");
                System.exit(0);
            }
        });
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
 
        getRootPane().setDefaultButton(b1);
        b1.addKeyListener (new KeyAdapter(){
        //设置登录账号和密码，初始化账号和密码都为123456
			public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
                    AFrame2 f1 = new AFrame2();
                    f1.AFrame2a();
                
				}else{
 
                    JOptionPane.showMessageDialog(null, "账号或者密码错误", "Error.mxy",JOptionPane.ERROR_MESSAGE); 
            
                }
            }
        });
 
        
 
    }
 
    public class ResponseButton  implements ActionListener{
        public void actionPerformed(ActionEvent e){
                String str ="123456";
                if(t1.getText().equals(str)&&t2.getText().equals(str) ){
 
                    AFrame2 f1 = new AFrame2();
                    f1.AFrame2a();
 
                }else{
 
                    JOptionPane.showMessageDialog(null, "账号或者密码错误", "Error.mxy",JOptionPane.ERROR_MESSAGE); 
            
                }
        }
    }
    //登录成功之后显示信息的四个功能
    class AFrame2 extends JFrame{
        JButton b3;
        JButton b4;
        JButton b5;
        JButton b6;
        public void AFrame2a(){
 
            this.setTitle("学生信息管理系统"); 
            //添加标签
            b3 =new JButton("信息增加");
            b4 =new JButton("信息查询");
            b5 =new JButton("信息修改");
            b6 =new JButton("信息删除");
    
            this.add(b3);
            this.add(b4);
            this.add(b5);
            this.add(b6);
            //设置随机颜色
            int R = (int) (Math.random()*256);
            int G = (int) (Math.random()*256);
            int B = (int) (Math.random()*256);
            Color color1 = new Color(R, G, B);
            Color color2 = new Color(B, G, R);
            Color color3 = new Color(G, B, R);
            
            b3.setBounds(100,80,150,100);
            b4.setBounds(100,290,150,100);
            b5.setBounds(300,80,150,100);
            b6.setBounds(300,290,150,100);
 
            b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame3 f2 = new AFrame3();
                f2.AFrame3a();
            }
        });
            b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame4 f3 = new AFrame4();
                f3.AFrame4a();
            }
        });
            b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame5 f4 = new AFrame5();
                
            }
        });
            b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame6 f5 = new AFrame6();
 
                
            }
        });
    
            this.setLayout(null);
            this.setBounds(300,300,600,500);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
 
    class AFrame3 extends JFrame{
        JTextField t3;
        JTextField t4;
        JTextField t5;
        JTextField t6;
        JTextField t7;
        JLabel nameLabel2;
        JLabel studentnumber;
        JLabel major;
        JLabel age;
        JLabel sex;
        JButton b7;
        JButton b8;
        JLabel l1;
        java.util.List <String> list = new ArrayList <String> ();
       //"信息添加“功能的信息内容
        public void AFrame3a(){
            this.setLayout(null);
 
            this.setTitle("学生信息管理系统");
 
            l1 = new JLabel("增加信息");
            l1.setForeground(Color.gray);
            l1.setFont(new Font("宋体",Font.BOLD,20));
            l1.setHorizontalAlignment(JTextField.CENTER);
            nameLabel2 =new JLabel("姓名：");
            nameLabel2.setFont(new Font("宋体",Font.BOLD,25));
            nameLabel2.setHorizontalAlignment(JTextField.CENTER);
            major =new JLabel("专业：");
            major.setFont(new Font("宋体",Font.BOLD,25));
            major.setHorizontalAlignment(JTextField.CENTER);
            age =new JLabel("年龄：");
            age.setFont(new Font("宋体",Font.BOLD,25));
            age.setHorizontalAlignment(JTextField.CENTER);
            sex =new JLabel("性别：");
            sex.setFont(new Font("宋体",Font.BOLD,25));
            sex.setHorizontalAlignment(JTextField.CENTER);
            studentnumber = new JLabel("学号：");
            studentnumber.setFont(new Font("宋体",Font.BOLD,25));
            studentnumber.setHorizontalAlignment(JTextField.CENTER);
 
            t3 =new JTextField(25);
            t3.setFont(new Font("宋体",Font.BOLD,25));
            t4 =new JTextField(25);
            t4.setFont(new Font("宋体",Font.BOLD,25));
            t5 =new JTextField(25);
            t5.setFont(new Font("宋体",Font.BOLD,25));
            t6 =new JTextField(25);
            t6.setFont(new Font("宋体",Font.BOLD,25));
            t7 =new JTextField(25);
            t7.setFont(new Font("宋体",Font.BOLD,25));
 
            b7 = new JButton("录入");
            b8 = new JButton("取消");
 
            File file = new File("Login_data.txt");
 
            b8.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null,"单击确定退出");
                    System.exit(0);
                }
            });
    
            this.add(t3);
            this.add(t4);
            this.add(t5);
            this.add(t6);
            this.add(t7);
            this.add(nameLabel2);
            this.add(major);
            this.add(age);
            this.add(sex);
            this.add(studentnumber);
            this.add(l1);
            this.add(b8);
            this.add(b7);
 
    
            t3.setBounds(180,40,180,50);
            t4.setBounds(180,100,180,50);
            t5.setBounds(180,160,180,50);
            t6.setBounds(180,220,180,50);
            t7.setBounds(180,280,180,50);
            nameLabel2.setBounds(0,40,180,50);
            age.setBounds(0,100,180,50);
            sex.setBounds(0,160,180,50);
            studentnumber.setBounds(0,220,180,50);
            major.setBounds(0,280,180,50);
            l1.setBounds(0,0,360,40);
            b7.setBounds(50,360,100,50);
            b8.setBounds(220,360,100,50);
 
                          
 
            b7.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){ 
 
                try{
                String str[] = new String[5];
 
                str[0] =t3.getText();
                str[1] =t4.getText();
                str[2] =t5.getText();
                str[3] =t6.getText();
                str[4] =t7.getText();
                
                
 
                BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Login_data.txt",true), "utf-8"));
                FileInputStream in1 = new FileInputStream("Login_data.txt");
                BufferedReader in =new BufferedReader(new InputStreamReader(in1,"UTF-8"));
 
 
                    for(int i =0;i<str.length;i++){
 
                        br.write(str[i]+".");
                    }
                br.newLine();
                br.close();
 
 
 
                if(!t3.getText().equals("")&&!t4.getText().equals("")&&!t5.getText().equals("")&&!t6.getText().equals("")&&!t7.getText().equals("")){
                
                JOptionPane.showMessageDialog(null,"录入完成！");
                
 
                }
            }catch(Exception b){
                b.printStackTrace();//可能抛异常
            }
                }
            });
            System.out.println(list);
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
    //查询功能
    class AFrame4 extends JFrame{
        JButton b9;
        JButton b10;
        JTextField t8;
        JLabel l2;
        JLabel l3;
        public void AFrame4a(){
 
            this.setTitle("学生信息管理系统");
 
            b9 = new JButton("查询");
            b10 = new JButton("取消");
            t8 = new JTextField(25);
            t8.setFont(new Font("宋体",Font.BOLD,25));
            l2 = new JLabel("输入学号：");
            l2.setFont(new Font("宋体",Font.BOLD,25));
            l2.setHorizontalAlignment(JTextField.CENTER);
            l3 = new JLabel("查询系统");
            l3.setForeground(Color.gray);
            l3.setFont(new Font("宋体",Font.BOLD,20));
            l3.setHorizontalAlignment(JTextField.CENTER);
    
            this.add(b9);
            this.add(b10);
            this.add(t8);
            this.add(l2);
            this.add(l3);
    
            b9.setBounds(50,300,100,50);
            b10.setBounds(200,300,100,50);
            t8.setBounds(180,160,180,50);
            l2.setBounds(0,160,180,50);
            l3.setBounds(0,0,360,40);
 
            b9.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                try{
                StringBuffer sb = null;
                sb = new StringBuffer();
                FileInputStream in1 = new FileInputStream("Login_data.txt");
                BufferedReader in =new BufferedReader(new InputStreamReader(in1,"UTF-8"));
                String name =null;
                int number = 1; 
                AFrame7 fd1 =new AFrame7(); 
                fd1.AFrame7a();
                while((name = in.readLine())!=null) {
 
                    String[] array =name.split("\\.");
 
 
                        if( array[3].equals(t8.getText()) ){
                            
 
                            fd1.TA1.append("姓名："+array[0]+"\n"+"年龄："+array[1]+"\n"+"性别："+array[2]+"\n"+"学号："+array[3]+"\n"+"专业："+array[4]+"\n");
                            sb.append("1");
 
                        }
                       
                }
                String data =new String(sb); 
                if(!(data.equals("1"))){
                    System.out.print(fd1.TA1.getText());
                    fd1.TA1.append("暂无该学生信息");
 
                }
                in.close();
                repaint();
            }catch(Exception e1){
 
                    e1.printStackTrace();
                    
                }
            
            }
            });
 
            b10.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null,"单击确定退出");
                    System.exit(0);
                }
            });
    
            this.setLayout(null);
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
    //信息修改
    class AFrame5 extends AFrameK{
        public AFrame5(){
            AFrameK a =new  AFrameK();
            a.AFrame4a();
            a.l3.setText("修改系统");
            
 
        }       
    }
    //信息修改
    class AFrame6 extends AFrame4{
        public AFrame6(){
            AFrameJ a =new  AFrameJ();
            a.AFrame4a();
            a.l3.setText("删除系统");
        }
    }
    class AFrame7 extends JFrame{
 
        JLabel l4;
        JPanel jPanelText = new JPanel();
        JTextArea TA1 = new JTextArea(20,10);
 
 
        public void AFrame7a(){
            this.setTitle("学生信息管理系统");
 
            jPanelText.setSize(200, 200);
            jPanelText.setBounds(0,100,400,400);
            jPanelText.setBackground(Color.white);
            this.getContentPane().add(jPanelText);
            jPanelText.add(TA1);
 
            TA1.setEditable(false);
            Font x = new Font("宋体",0,20);
            TA1.setFont(x);
 
            l4 = new JLabel("查询结果如下");
            l4.setFont(new Font("宋体",Font.BOLD,25));
            l4.setHorizontalAlignment(JTextField.CENTER);
 
            this.add(l4);
 
            l4.setBounds(0,0,360,40);
 
            this.setLayout(null);
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
 
    }
    class AFrameK extends JFrame{
        JButton b9;
        JButton b10;
        JTextField t8;
        JLabel l2;
        JLabel l3;
 
        public void AFrame4a(){
 
            this.setTitle("学生信息管理系统");
 
            b9 = new JButton("查询");
            b10 = new JButton("取消");
            t8 = new JTextField(25);
            t8.setFont(new Font("宋体",Font.BOLD,25));
            l2 = new JLabel("输入学号：");
            l2.setFont(new Font("宋体",Font.BOLD,25));
            l2.setHorizontalAlignment(JTextField.CENTER);
            l3 = new JLabel("查询系统");
            l3.setForeground(Color.gray);
            l3.setFont(new Font("宋体",Font.BOLD,20));
            l3.setHorizontalAlignment(JTextField.CENTER);
    
            this.add(b9);
            this.add(b10);
            this.add(t8);
            this.add(l2);
            this.add(l3);
    
            b9.setBounds(50,300,100,50);
            b10.setBounds(200,300,100,50);
            t8.setBounds(180,160,180,50);
            l2.setBounds(0,160,180,50);
            l3.setBounds(0,0,360,40);
 
            b9.addActionListener(new ActionListener(){
                
                public void actionPerformed(ActionEvent e){
 
                StringBuffer sb = null;
                try{
                sb = new StringBuffer();
                FileInputStream in1 = new FileInputStream("Login_data.txt");
                BufferedReader in =new BufferedReader(new InputStreamReader(in1,"UTF-8"));
                String name =null;
                
 
                AFrame3 XiuGai =new AFrame3();
                XiuGai.AFrame3a();
                while((name = in.readLine())!=null) {
 
                    String[] array =name.split("\\.");
                    
 
                        if( array[3].equals(t8.getText()) ){
                           
                            XiuGai.t3.setText(array[0]);
                            XiuGai.t4.setText(array[1]);
                            XiuGai.t5.setText(array[2]);
                            XiuGai.t6.setText(array[3]);
                            XiuGai.t7.setText(array[4]);
                            
                        }else{
                            
                            sb.append(name+",");
 
                        }
                    
 
                }
                
                in.close();
 
                String data =new String(sb); 
                String[] data2 = data.split("\\,");
 
                BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Login_data.txt"), "utf-8"));
 
                for(int i=0;i<data2.length;i++ ){
 
                br.write(data2[i]);
 
                    if(i==(data2.length-1)){}
 
                    else{
 
                br.newLine();
 
                    }
                }
                br.newLine();
                br.close();
 
                repaint();
                }catch(Exception e1){
 
                    e1.printStackTrace();
                    
                }
            
            }
            });
 
            b10.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null,"单击确定退出");
                    System.exit(0);
                }
            });
    
            this.setLayout(null);
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
    //信息修改
    class AFrameJ extends JFrame{
        JButton b9;
        JButton b10;
        JTextField t8;
        JLabel l2;
        JLabel l3;
 
        public void AFrame4a(){
 
            this.setTitle("学生信息管理系统");
 
            b9 = new JButton("删除");
            b10 = new JButton("取消");
            t8 = new JTextField(25);
            t8.setFont(new Font("宋体",Font.BOLD,25));
            l2 = new JLabel("输入学号：");
            l2.setFont(new Font("宋体",Font.BOLD,25));
            l2.setHorizontalAlignment(JTextField.CENTER);
            l3 = new JLabel("修改系统");
            l3.setForeground(Color.gray);
            l3.setFont(new Font("宋体",Font.BOLD,20));
            l3.setHorizontalAlignment(JTextField.CENTER);
    
            this.add(b9);
            this.add(b10);
            this.add(t8);
            this.add(l2);
            this.add(l3);
    
            b9.setBounds(50,300,100,50);
            b10.setBounds(200,300,100,50);
            t8.setBounds(180,160,180,50);
            l2.setBounds(0,160,180,50);
            l3.setBounds(0,0,360,40);
 
            b9.addActionListener(new ActionListener(){
                
               //信息删除
            	public void actionPerformed(ActionEvent e){
 
                StringBuffer sb = null;
                try{
                sb = new StringBuffer();
                FileInputStream in1 = new FileInputStream("Login_data.txt");
                BufferedReader in =new BufferedReader(new InputStreamReader(in1,"UTF-8"));
                String name =null;
                while((name = in.readLine())!=null) {
 
                    String[] array =name.split("\\.");
                    
 
                        if( array[3].equals(t8.getText()) ){
 
                            JOptionPane.showMessageDialog(null, "警告：已经找到相关数据并删除","成功删除数据",JOptionPane.WARNING_MESSAGE); 
                            
                        }else{
                            
                            sb.append(name+",");
 
                        }
                    
 
                }
                
                in.close();
 
                String data =new String(sb); 
                String[] data2 = data.split("\\,");
 
                BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Login_data.txt"), "utf-8"));
 
                for(int i=0;i<data2.length;i++ ){
 
                br.write(data2[i]);
 
                    if(i==(data2.length-1)){}
 
                    else{
 
                br.newLine();
 
                    }
                }
                br.newLine();
                br.close();
 
                repaint();
                }catch(Exception e1){
 
                    e1.printStackTrace();
                    
                }
            
            }
            });
 
            b10.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null,"单击确定退出");
                    System.exit(0);
                }
            });
    
            this.setLayout(null);
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
    
    @Override
    protected void processWindowEvent(WindowEvent e){
        //最后对进来的WindowEvent进行判断
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
   
            int option = JOptionPane.showConfirmDialog(null, "王子健老师天下最帅？！", "【审美提问】", JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.OK_OPTION){ 
                super.processWindowEvent(e);
            }
            else {
                //用户选择【取消】，因此可以继续留在本窗口
            }
        }
//        else {
//            super.processWindowEvent(e);
//        }
    }
}

