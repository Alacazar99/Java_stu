package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Test{
	public static void main(String [] args){
		AFrame f = new AFrame("学生信息管理系统");
		f.setLocationRelativeTo(null);   //让窗口居中显示；
		f.setResizable(false);           //为了美观定死了窗口的大小；
		f.setIconImage(f.getToolkit().getImage("Image/2.jpg"));   
	}
}

class AFrame extends JFrame{
	//建立私有变量（按钮）；
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;

	JPanel panel1 = new JPanel();
	 
	public AFrame(String title){
		super(title);
		
		b1 = new Button("信息增加");
		b2 = new Button("信息删除");
		b3 = new Button("信息修改");
		b4 = new Button("信息查询");

		//设置颜色（随机生成）；
//		int R = (int) (Math.random()*256);
//        int G = (int) (Math.random()*256);
//        int B = (int) (Math.random()*256);
//        Color color1 = new Color(R, G, B);
//        Color color2 = new Color(B, G, R);
//        Color color3 = new Color(G, B, R);
        
        
		ImageIcon background = new ImageIcon("Image/123.jpg");	//创建一个背景图片
		JLabel label = new JLabel(background);		                //把背景图片添加到标签里
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
		this.setBounds(1200, 750, background.getIconWidth(), background.getIconHeight());
			
		JPanel myPanel = (JPanel)this.getContentPane();		//把我的面板设置为内容面板
		myPanel.setOpaque(false);					    //把我的面板设置为不可视
		myPanel.setLayout(new FlowLayout());		    //把我的面板设置为流动布局
		
		this.getLayeredPane().setLayout(null);	     	//把分层面板的布局置空
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//把标签添加到分层面板的最底层
		
		//设置界面属性
		JLabel MainName = new JLabel("学生信息管理系统", JLabel.CENTER);
		MainName.setSize(500,100);MainName.setLocation(300,10);
		MainName.setFont(new java.awt.Font("Dialog",1,56));          //设置标签中的字体
		MainName.setForeground(Color.pink);                          //设置标签中的文字颜色
		myPanel.add(MainName,BorderLayout.NORTH);                                     // 将组件件入到面板之中
		
			
		
		b1.setFont(new java.awt.Font("Dialog",1,24));
		b2.setFont(new java.awt.Font("Dialog",1,24));
		b3.setFont(new java.awt.Font("Dialog",1,24));
		b4.setFont(new java.awt.Font("Dialog",1,24));

		this.setSize(1000 , 750);this.setLocation(200 , 200);
		
		b1.setSize(150,70);b1.setLocation(50,140);
		b2.setSize(150,70);b2.setLocation(50,260);
		b3.setSize(150,70);b3.setLocation(50,380);
		b4.setSize(150,70);b4.setLocation(50,500);
		
	    //  设置边框(一切为了美观)
		JTextField tf = new JTextField();
//		tf.setBounds(300,140,620,450);
		tf.setBounds(0,0,620,450);
		tf.setOpaque(false);
//		myPanel.add(tf);
		
		
		myPanel.add(b1);myPanel.add(b2);
		myPanel.add(b3);myPanel.add(b4);
		myPanel.setLayout(null);
		
		//设置交互信息框；
		JLabel Maindata = new JLabel("",JLabel.CENTER);
		Maindata.setBounds(300,140,620,450);
		myPanel.add(Maindata);
//		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] options ={ "赞美女神！", "真漂亮啊" };  
				int m = JOptionPane.showOptionDialog(null, "请赞美我的女神？！", "【冰公主最美】",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);   
				if (m == JOptionPane.OK_OPTION){
					
					
					Maindata.removeAll();
					Maindata.repaint();
					Maindata.revalidate();
					Maindata.setBounds(300,140,620,450);
					Label name = new Label("  姓   名  ");
					Label id = new Label("  学   号  ");
					Label Result = new Label("联系方式");
					JTextField fieldAdd = new JTextField(1);
					JTextField fieldAug = new JTextField(1);
					JTextField areaResult = new JTextField(1);
					
					name.setBackground(Color.green);
					id.setBackground(Color.orange);
					Result.setBackground(Color.cyan);
					
					Button but = new Button(" 添   加 ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but);
					
					name.setBounds(160, 60, 90, 40);
					id.setBounds(160, 160, 90, 40);
					Result.setBounds(160, 260, 90, 40);
					fieldAdd.setBounds(300, 60, 180, 40);
					fieldAug.setBounds(300, 160, 180, 40);
					areaResult.setBounds(300, 260, 180, 40);
										
					name.setFont(new java.awt.Font("标楷体",3,20));
					id.setFont(new java.awt.Font("标楷体",3,20));
					Result.setFont(new java.awt.Font("标楷体",3,20));
					fieldAdd.setFont(new java.awt.Font("Dialog",2,20));
					fieldAug.setFont(new java.awt.Font("Dialog",2,20));
					areaResult.setFont(new java.awt.Font("Dialog",2,20));
					
					Maindata.add(name,BorderLayout.CENTER);
					Maindata.add(id,BorderLayout.CENTER);
					Maindata.add(Result,BorderLayout.CENTER);
					Maindata.add(fieldAdd,BorderLayout.CENTER);
					Maindata.add(fieldAug,BorderLayout.CENTER);
					Maindata.add(areaResult,BorderLayout.CENTER);
					Maindata.add(tf,BorderLayout.CENTER);
					
					myPanel.add(Maindata);
	                //关于学生信息添加的代码（待续..）
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "确认", "取消" };  
							int m = JOptionPane.showOptionDialog(null, "是否确认保存该学生信息？", "【检验】",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
							}
						}
					});
	            }
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] options ={ "赞美女神！", "颜值+1" };  
				int m = JOptionPane.showOptionDialog(null, "你是女神的信徒吗？", "【冰公主最美】",JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);   
				if (m == JOptionPane.OK_OPTION){
	                //关于学生信息删除的代码（待续..）
					
					Maindata.removeAll();
					Maindata.repaint();
					Maindata.revalidate();
					Maindata.setBounds(300,140,620,450);
					
					JLabel msg = new JLabel("只要输入学号以及姓名，即可删除哦", JLabel.CENTER);
					msg.setSize(500,40);msg.setLocation(60,45);
					msg.setFont(new java.awt.Font("Dialog",1,24));          //设置标签中的字体
					msg.setForeground(Color.cyan);                          //设置标签中的文字颜色
					Maindata.add(msg,BorderLayout.NORTH); 
					
					Label Addend = new Label("  姓   名  ");
					Label Augend = new Label("  学   号  ");
//					Label Result = new Label("联系方式");
					JTextField fieldAdd = new JTextField(1);
					JTextField fieldAug = new JTextField(1);
//					JTextField areaResult = new JTextField(1);
					
					Addend.setBackground(Color.pink);
					Augend.setBackground(Color.pink);
//					Result.setBackground(Color.pink);
					
					Button but = new Button(" 删   除 ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but,BorderLayout.CENTER);
					
					Addend.setBounds(160, 160, 90, 40);
					Augend.setBounds(160, 260, 90, 40);
//					Result.setBounds(160, 260, 90, 40);
					fieldAdd.setBounds(300, 160, 180, 40);
					fieldAug.setBounds(300, 260, 180, 40);
//					areaResult.setBounds(300, 260, 180, 40);
					
					
					Addend.setFont(new java.awt.Font("标楷体",3,20));
					Augend.setFont(new java.awt.Font("标楷体",3,20));
//					Result.setFont(new java.awt.Font("标楷体",3,20));
					fieldAdd.setFont(new java.awt.Font("Dialog",2,20));
					fieldAug.setFont(new java.awt.Font("Dialog",2,20));
//					areaResult.setFont(new java.awt.Font("Dialog",2,20));
					
										
					Maindata.add(Addend,BorderLayout.CENTER);
					Maindata.add(Augend,BorderLayout.CENTER);
//					Maindata.add(Result,BorderLayout.CENTER);
					Maindata.add(fieldAdd,BorderLayout.CENTER);
					Maindata.add(fieldAug,BorderLayout.CENTER);
//					Maindata.add(areaResult,BorderLayout.CENTER);
					Maindata.add(tf,BorderLayout.CENTER);

	                //关于学生信息添加的代码（待续..）
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "确认", "取消" };  
							int m = JOptionPane.showOptionDialog(null, "是否确认删除？", "【提示】",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
							}
						}
					});
	            }
			}
		});
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
//				Object[] options ={ "是我的女神啊！", "颜值+1" };  
//				int m = JOptionPane.showOptionDialog(null, "我女神最美？！", "【我爱冰公主】",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);   
//				if (m == JOptionPane.OK_OPTION){
					Maindata.removeAll();
					Maindata.repaint();
					Maindata.revalidate();
					Maindata.setBounds(300,140,620,450);
					
					JLabel msg = new JLabel("听说修改学生信息也超级简单嗷...", JLabel.CENTER);
					msg.setSize(500,40);msg.setLocation(10,20);
					msg.setFont(new java.awt.Font("Dialog",1,24));          //设置标签中的字体
					msg.setForeground(Color.cyan);                          //设置标签中的文字颜色
					Maindata.add(msg,BorderLayout.NORTH);
					
					
					Label Addend = new Label("  姓   名  ");
					Label Augend = new Label("  学   号  ");
					Label Result = new Label("联系方式");
					JTextField fieldAdd = new JTextField(1);
					JTextField fieldAug = new JTextField(1);
					JTextField areaResult = new JTextField(1);
					
					
					Addend.setBackground(Color.pink);
					Augend.setBackground(Color.pink);
					Result.setBackground(Color.pink);
					
					Button but = new Button(" 修   改 ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but,BorderLayout.CENTER);
					
					Addend.setBounds(160, 80, 90, 40);
					Augend.setBounds(160, 160, 90, 40);
					Result.setBounds(160, 240, 90, 40);
					fieldAdd.setBounds(300, 80, 180, 40);
					fieldAug.setBounds(300, 160, 180, 40);
					areaResult.setBounds(300, 240, 180, 40);
					
					
					Addend.setFont(new java.awt.Font("标楷体",3,20));
					Augend.setFont(new java.awt.Font("标楷体",3,20));
					Result.setFont(new java.awt.Font("标楷体",3,20));
					fieldAdd.setFont(new java.awt.Font("Dialog",2,20));
					fieldAug.setFont(new java.awt.Font("Dialog",2,20));
					areaResult.setFont(new java.awt.Font("Dialog",2,20));
					
					
					Maindata.add(Addend,BorderLayout.CENTER);
					Maindata.add(Augend,BorderLayout.CENTER);
					Maindata.add(Result,BorderLayout.CENTER);
					Maindata.add(fieldAdd,BorderLayout.CENTER);
					Maindata.add(fieldAug,BorderLayout.CENTER);
					Maindata.add(areaResult,BorderLayout.CENTER);
					Maindata.add(tf,BorderLayout.CENTER);

					
					
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "确认", "取消" };  
							int m = JOptionPane.showOptionDialog(null, "是否确认修改？", "【检验】",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
							}
						}
					});
	                //关于学生信息修改的代码（待续..）
//	            }
			}
		});
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] options ={ "屁话真多..", "臭不要脸" };  
				int m = JOptionPane.showOptionDialog(null, "黄世祥最帅？！反驳无效", "【颜值检验】",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
				if (m == JOptionPane.OK_OPTION){
					
					
                  // 将组件件入到面板之中
//					
					Maindata.removeAll();
					Maindata.setBounds(300,140,620,450);
					Maindata.repaint();
					Maindata.revalidate();
					
					JLabel msg = new JLabel("当前没有学生信息...赶快去录入吧", JLabel.CENTER);
					msg.setSize(400,100);msg.setLocation(120,100);
					msg.setFont(new java.awt.Font("Dialog",1,24));          //设置标签中的字体
					msg.setForeground(Color.black);                          //设置标签中的文字颜色
					Maindata.add(msg,BorderLayout.NORTH);     
					
					Button but = new Button(" 查  询 ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but,BorderLayout.CENTER);
					
					Maindata.add(tf,BorderLayout.CENTER);
					
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "屁话真多..", "臭不要脸" };  
							int m = JOptionPane.showOptionDialog(null, "是否确认查询？", "【检验】",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
								
							}
						}
					});
	                //关于学生信息查询的代码（待续..）
	            }
			}
		});
		this.setVisible(true);
	}
	
	//退出按钮  相关功能设置。
    @Override
    protected void processWindowEvent(WindowEvent e){
        //这里需要对进来的WindowEvent进行判断，因为，不仅会有窗口关闭的WindowEvent进来，还可能有其他的WindowEvent进来
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            int option = JOptionPane.showConfirmDialog(null, "我的女神天下最美？！", "【审美提问】", JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.OK_OPTION){ 
                super.processWindowEvent(e);
            }
            else {
                //用户选择【取消】，因此可以继续留在本窗口
            }
        }
    }
}


