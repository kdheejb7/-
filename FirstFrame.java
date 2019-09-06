
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FirstFrame
{
   JFrame f_frame;
   JPanel j_panel1, j_panel2;
   JLabel j_lab1, j_lab2, j_lab3;
   JButton g_start, g_rule, g_rank;

   public FirstFrame(){
      //������, �г�, ��ư ���� �� ���̱�
      f_frame = new JFrame("�ؾ�ؾ�");
      j_panel1 = new JPanel();//�����г�
      j_panel2 = new JPanel();//�����г�
      
      f_frame.setLayout(new GridLayout(1,2,0,0));
      f_frame.add(j_panel1);//���� ���� ����
      f_frame.add(j_panel2);//��ư ����

      j_lab1 = new JLabel("�ؾ�� ������", JLabel.CENTER);
      j_lab2 = new JLabel("<html><h2 style='text-align='center'>������</h2><p>�赵��, ������, �̼���</p></html>",JLabel.CENTER);
      j_lab3 = new JLabel(new ImageIcon("fish.png"));
      j_panel1.add(j_lab1);
      j_panel1.add(j_lab3);
      j_panel2.add(j_lab2);

      g_start = new JButton("���ӽ���");
      g_rule = new JButton("���ӹ��");
      g_rank = new JButton("��ŷ����");

      j_panel1.setBackground(new Color(250, 237, 125));
      j_panel2.setBackground(new Color(250, 237, 125));
      
      j_lab1.setFont(new Font("����ǹ��� �־�", Font.BOLD, 90));
      j_lab2.setFont(new Font("����ǹ��� �־�", Font.BOLD, 38));

      g_start.setBackground(new Color(250, 250, 250));
      g_rule.setBackground(new Color(250, 250, 250));
      g_rank.setBackground(new Color(250, 250, 250));
      
      g_start.setFont(new Font("����ǹ��� �־�", Font.BOLD,30));
      g_rule.setFont(new Font("����ǹ��� �־�", Font.BOLD,30));
      g_rank.setFont(new Font("����ǹ��� �־�", Font.BOLD,30));

      j_panel1.setBorder(BorderFactory.createEmptyBorder(120 , 120 , 120 , 120));
      j_panel2.setLayout(new GridLayout(4, 1, 20, 20));
      j_panel2.setBorder(BorderFactory.createEmptyBorder(120 , 70 , 170 , 170));

      j_panel2.add(g_start);
      j_panel2.add(g_rule);
      j_panel2.add(g_rank);

      g_start.addActionListener(new ActionListener(){
    	  	
			public void actionPerformed(ActionEvent e){
				JButton button = (JButton)e.getSource();
				MainFrame mf = new MainFrame();
			}
	
      });
      g_rule.addActionListener(new ActionListener(){
  	  	
			public void actionPerformed(ActionEvent e){
				JButton button = (JButton)e.getSource();
				RuleFrame rulef = new RuleFrame();
			}
	
      });
      
      g_rank.addActionListener(new ActionListener(){
    	  	
  			public void actionPerformed(ActionEvent e){
  				JButton button = (JButton)e.getSource();
  				RankFrame rankf = new RankFrame();
  			}
  	
        });
     
      f_frame.setSize(1200, 800);
      f_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f_frame.setVisible(true);


   }



}
