
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
      //프레임, 패널, 버튼 생성 및 붙이기
      f_frame = new JFrame("붕어붕어");
      j_panel1 = new JPanel();//좌측패널
      j_panel2 = new JPanel();//우측패널
      
      f_frame.setLayout(new GridLayout(1,2,0,0));
      f_frame.add(j_panel1);//게임 제목 삽입
      f_frame.add(j_panel2);//버튼 삽입

      j_lab1 = new JLabel("붕어빵을 구워라", JLabel.CENTER);
      j_lab2 = new JLabel("<html><h2 style='text-align='center'>개발자</h2><p>김도희, 박유진, 이소진</p></html>",JLabel.CENTER);
      j_lab3 = new JLabel(new ImageIcon("fish.png"));
      j_panel1.add(j_lab1);
      j_panel1.add(j_lab3);
      j_panel2.add(j_lab2);

      g_start = new JButton("게임시작");
      g_rule = new JButton("게임방법");
      g_rank = new JButton("랭킹보기");

      j_panel1.setBackground(new Color(250, 237, 125));
      j_panel2.setBackground(new Color(250, 237, 125));
      
      j_lab1.setFont(new Font("배달의민족 주아", Font.BOLD, 90));
      j_lab2.setFont(new Font("배달의민족 주아", Font.BOLD, 38));

      g_start.setBackground(new Color(250, 250, 250));
      g_rule.setBackground(new Color(250, 250, 250));
      g_rank.setBackground(new Color(250, 250, 250));
      
      g_start.setFont(new Font("배달의민족 주아", Font.BOLD,30));
      g_rule.setFont(new Font("배달의민족 주아", Font.BOLD,30));
      g_rank.setFont(new Font("배달의민족 주아", Font.BOLD,30));

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
