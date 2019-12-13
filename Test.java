package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Test{
	public static void main(String [] args){
		AFrame f = new AFrame("ѧ����Ϣ����ϵͳ");
		f.setLocationRelativeTo(null);   //�ô��ھ�����ʾ��
		f.setResizable(false);           //Ϊ�����۶����˴��ڵĴ�С��
		f.setIconImage(f.getToolkit().getImage("Image/2.jpg"));   
	}
}

class AFrame extends JFrame{
	//����˽�б�������ť����
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;

	JPanel panel1 = new JPanel();
	 
	public AFrame(String title){
		super(title);
		
		b1 = new Button("��Ϣ����");
		b2 = new Button("��Ϣɾ��");
		b3 = new Button("��Ϣ�޸�");
		b4 = new Button("��Ϣ��ѯ");

		//������ɫ��������ɣ���
//		int R = (int) (Math.random()*256);
//        int G = (int) (Math.random()*256);
//        int B = (int) (Math.random()*256);
//        Color color1 = new Color(R, G, B);
//        Color color2 = new Color(B, G, R);
//        Color color3 = new Color(G, B, R);
        
        
		ImageIcon background = new ImageIcon("Image/123.jpg");	//����һ������ͼƬ
		JLabel label = new JLabel(background);		                //�ѱ���ͼƬ��ӵ���ǩ��
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//�ѱ�ǩ����Ϊ��ͼƬ�ȸߵȿ�
		this.setBounds(1200, 750, background.getIconWidth(), background.getIconHeight());
			
		JPanel myPanel = (JPanel)this.getContentPane();		//���ҵ��������Ϊ�������
		myPanel.setOpaque(false);					    //���ҵ��������Ϊ������
		myPanel.setLayout(new FlowLayout());		    //���ҵ��������Ϊ��������
		
		this.getLayeredPane().setLayout(null);	     	//�ѷֲ����Ĳ����ÿ�
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//�ѱ�ǩ��ӵ��ֲ�������ײ�
		
		//���ý�������
		JLabel MainName = new JLabel("ѧ����Ϣ����ϵͳ", JLabel.CENTER);
		MainName.setSize(500,100);MainName.setLocation(300,10);
		MainName.setFont(new java.awt.Font("Dialog",1,56));          //���ñ�ǩ�е�����
		MainName.setForeground(Color.pink);                          //���ñ�ǩ�е�������ɫ
		myPanel.add(MainName,BorderLayout.NORTH);                                     // ��������뵽���֮��
		
			
		
		b1.setFont(new java.awt.Font("Dialog",1,24));
		b2.setFont(new java.awt.Font("Dialog",1,24));
		b3.setFont(new java.awt.Font("Dialog",1,24));
		b4.setFont(new java.awt.Font("Dialog",1,24));

		this.setSize(1000 , 750);this.setLocation(200 , 200);
		
		b1.setSize(150,70);b1.setLocation(50,140);
		b2.setSize(150,70);b2.setLocation(50,260);
		b3.setSize(150,70);b3.setLocation(50,380);
		b4.setSize(150,70);b4.setLocation(50,500);
		
	    //  ���ñ߿�(һ��Ϊ������)
		JTextField tf = new JTextField();
//		tf.setBounds(300,140,620,450);
		tf.setBounds(0,0,620,450);
		tf.setOpaque(false);
//		myPanel.add(tf);
		
		
		myPanel.add(b1);myPanel.add(b2);
		myPanel.add(b3);myPanel.add(b4);
		myPanel.setLayout(null);
		
		//���ý�����Ϣ��
		JLabel Maindata = new JLabel("",JLabel.CENTER);
		Maindata.setBounds(300,140,620,450);
		myPanel.add(Maindata);
//		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] options ={ "����Ů��", "��Ư����" };  
				int m = JOptionPane.showOptionDialog(null, "�������ҵ�Ů�񣿣�", "��������������",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);   
				if (m == JOptionPane.OK_OPTION){
					
					
					Maindata.removeAll();
					Maindata.repaint();
					Maindata.revalidate();
					Maindata.setBounds(300,140,620,450);
					Label name = new Label("  ��   ��  ");
					Label id = new Label("  ѧ   ��  ");
					Label Result = new Label("��ϵ��ʽ");
					JTextField fieldAdd = new JTextField(1);
					JTextField fieldAug = new JTextField(1);
					JTextField areaResult = new JTextField(1);
					
					name.setBackground(Color.green);
					id.setBackground(Color.orange);
					Result.setBackground(Color.cyan);
					
					Button but = new Button(" ��   �� ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but);
					
					name.setBounds(160, 60, 90, 40);
					id.setBounds(160, 160, 90, 40);
					Result.setBounds(160, 260, 90, 40);
					fieldAdd.setBounds(300, 60, 180, 40);
					fieldAug.setBounds(300, 160, 180, 40);
					areaResult.setBounds(300, 260, 180, 40);
										
					name.setFont(new java.awt.Font("�꿬��",3,20));
					id.setFont(new java.awt.Font("�꿬��",3,20));
					Result.setFont(new java.awt.Font("�꿬��",3,20));
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
	                //����ѧ����Ϣ��ӵĴ��루����..��
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "ȷ��", "ȡ��" };  
							int m = JOptionPane.showOptionDialog(null, "�Ƿ�ȷ�ϱ����ѧ����Ϣ��", "�����顿",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
							}
						}
					});
	            }
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] options ={ "����Ů��", "��ֵ+1" };  
				int m = JOptionPane.showOptionDialog(null, "����Ů�����ͽ��", "��������������",JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);   
				if (m == JOptionPane.OK_OPTION){
	                //����ѧ����Ϣɾ���Ĵ��루����..��
					
					Maindata.removeAll();
					Maindata.repaint();
					Maindata.revalidate();
					Maindata.setBounds(300,140,620,450);
					
					JLabel msg = new JLabel("ֻҪ����ѧ���Լ�����������ɾ��Ŷ", JLabel.CENTER);
					msg.setSize(500,40);msg.setLocation(60,45);
					msg.setFont(new java.awt.Font("Dialog",1,24));          //���ñ�ǩ�е�����
					msg.setForeground(Color.cyan);                          //���ñ�ǩ�е�������ɫ
					Maindata.add(msg,BorderLayout.NORTH); 
					
					Label Addend = new Label("  ��   ��  ");
					Label Augend = new Label("  ѧ   ��  ");
//					Label Result = new Label("��ϵ��ʽ");
					JTextField fieldAdd = new JTextField(1);
					JTextField fieldAug = new JTextField(1);
//					JTextField areaResult = new JTextField(1);
					
					Addend.setBackground(Color.pink);
					Augend.setBackground(Color.pink);
//					Result.setBackground(Color.pink);
					
					Button but = new Button(" ɾ   �� ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but,BorderLayout.CENTER);
					
					Addend.setBounds(160, 160, 90, 40);
					Augend.setBounds(160, 260, 90, 40);
//					Result.setBounds(160, 260, 90, 40);
					fieldAdd.setBounds(300, 160, 180, 40);
					fieldAug.setBounds(300, 260, 180, 40);
//					areaResult.setBounds(300, 260, 180, 40);
					
					
					Addend.setFont(new java.awt.Font("�꿬��",3,20));
					Augend.setFont(new java.awt.Font("�꿬��",3,20));
//					Result.setFont(new java.awt.Font("�꿬��",3,20));
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

	                //����ѧ����Ϣ��ӵĴ��루����..��
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "ȷ��", "ȡ��" };  
							int m = JOptionPane.showOptionDialog(null, "�Ƿ�ȷ��ɾ����", "����ʾ��",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
							}
						}
					});
	            }
			}
		});
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
//				Object[] options ={ "���ҵ�Ů�񰡣�", "��ֵ+1" };  
//				int m = JOptionPane.showOptionDialog(null, "��Ů����������", "���Ұ���������",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);   
//				if (m == JOptionPane.OK_OPTION){
					Maindata.removeAll();
					Maindata.repaint();
					Maindata.revalidate();
					Maindata.setBounds(300,140,620,450);
					
					JLabel msg = new JLabel("��˵�޸�ѧ����ϢҲ�������...", JLabel.CENTER);
					msg.setSize(500,40);msg.setLocation(10,20);
					msg.setFont(new java.awt.Font("Dialog",1,24));          //���ñ�ǩ�е�����
					msg.setForeground(Color.cyan);                          //���ñ�ǩ�е�������ɫ
					Maindata.add(msg,BorderLayout.NORTH);
					
					
					Label Addend = new Label("  ��   ��  ");
					Label Augend = new Label("  ѧ   ��  ");
					Label Result = new Label("��ϵ��ʽ");
					JTextField fieldAdd = new JTextField(1);
					JTextField fieldAug = new JTextField(1);
					JTextField areaResult = new JTextField(1);
					
					
					Addend.setBackground(Color.pink);
					Augend.setBackground(Color.pink);
					Result.setBackground(Color.pink);
					
					Button but = new Button(" ��   �� ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but,BorderLayout.CENTER);
					
					Addend.setBounds(160, 80, 90, 40);
					Augend.setBounds(160, 160, 90, 40);
					Result.setBounds(160, 240, 90, 40);
					fieldAdd.setBounds(300, 80, 180, 40);
					fieldAug.setBounds(300, 160, 180, 40);
					areaResult.setBounds(300, 240, 180, 40);
					
					
					Addend.setFont(new java.awt.Font("�꿬��",3,20));
					Augend.setFont(new java.awt.Font("�꿬��",3,20));
					Result.setFont(new java.awt.Font("�꿬��",3,20));
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
							Object[] options ={ "ȷ��", "ȡ��" };  
							int m = JOptionPane.showOptionDialog(null, "�Ƿ�ȷ���޸ģ�", "�����顿",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
							}
						}
					});
	                //����ѧ����Ϣ�޸ĵĴ��루����..��
//	            }
			}
		});
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object[] options ={ "ƨ�����..", "����Ҫ��" };  
				int m = JOptionPane.showOptionDialog(null, "��������˧����������Ч", "����ֵ���顿",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
				if (m == JOptionPane.OK_OPTION){
					
					
                  // ��������뵽���֮��
//					
					Maindata.removeAll();
					Maindata.setBounds(300,140,620,450);
					Maindata.repaint();
					Maindata.revalidate();
					
					JLabel msg = new JLabel("��ǰû��ѧ����Ϣ...�Ͽ�ȥ¼���", JLabel.CENTER);
					msg.setSize(400,100);msg.setLocation(120,100);
					msg.setFont(new java.awt.Font("Dialog",1,24));          //���ñ�ǩ�е�����
					msg.setForeground(Color.black);                          //���ñ�ǩ�е�������ɫ
					Maindata.add(msg,BorderLayout.NORTH);     
					
					Button but = new Button(" ��  ѯ ");
					but.setFont(new java.awt.Font("Dialog",1,24));
					but.setBounds(250, 350, 120,50);
					Maindata.add(but,BorderLayout.CENTER);
					
					Maindata.add(tf,BorderLayout.CENTER);
					
					but.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							Object[] options ={ "ƨ�����..", "����Ҫ��" };  
							int m = JOptionPane.showOptionDialog(null, "�Ƿ�ȷ�ϲ�ѯ��", "�����顿",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
							if (m == JOptionPane.OK_OPTION){
								
							}
						}
					});
	                //����ѧ����Ϣ��ѯ�Ĵ��루����..��
	            }
			}
		});
		this.setVisible(true);
	}
	
	//�˳���ť  ��ع������á�
    @Override
    protected void processWindowEvent(WindowEvent e){
        //������Ҫ�Խ�����WindowEvent�����жϣ���Ϊ���������д��ڹرյ�WindowEvent��������������������WindowEvent����
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            int option = JOptionPane.showConfirmDialog(null, "�ҵ�Ů��������������", "���������ʡ�", JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.OK_OPTION){ 
                super.processWindowEvent(e);
            }
            else {
                //�û�ѡ��ȡ��������˿��Լ������ڱ�����
            }
        }
    }
}


