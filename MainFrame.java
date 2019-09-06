import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends Thread implements ActionListener
{
   JFrame frame;
   JPanel left_panel, right_panel, panel1, panel2,panel3,panel4,panel5,panel6;
   JLabel lab1, lab2, lab3, lab_img, jlab, stock, sales, heartLabel[];
   JTextField score;
   JButton g_start, g_rule, g_rank;
   JButton fish[];
   int fishCount[];
   Cursor cursor;
   Image imgCursor;
   Toolkit tk = Toolkit.getDefaultToolkit();
   JButton bean, kettle, turner, wrap, OK;
   boolean bean_flag, kettle_flag, turner_flag, wrap_flag;
   int thread_flag = 0;
   TimTest test; //Ÿ�̸� ��ü ȣ��
   RankFrame2 rank2;
   RandomforSale ransale;
   int stockCount, val, sumScore, heartnum = 5;
   public int soldCount;
   int number = 12;
   int[] flag = new int[number];
   int[] startb= new int[number];
   Thread[] ths = new FishThread[12];
   ImageIcon heart1, emptyheart;
   ImageIcon fish1 = new ImageIcon("fish1.png");//���׻���
   ImageIcon fish2 = new ImageIcon("fish2.png");//����������
   ImageIcon fish3 = new ImageIcon("fish3.png");//�ؾ����
   ImageIcon fish4 = new ImageIcon("fish4.png");//Ȳ�ݺؾ
   ImageIcon icon5 = new ImageIcon("");
   int tempp;
   public MainFrame() {
	      frame = new JFrame();
	      frame.setSize(1200,850);     

	      left_panel = new JPanel();//�����г� �¿� �г��ǻ����� 600*400
	      right_panel = new JPanel();//�����г�

	      frame.add(left_panel);
	      frame.add(right_panel);

	      left_panel.setLayout(null);
	      right_panel.setLayout(null);
	      left_panel.setBounds(0,0,600,800);
	      right_panel.setBounds(0,0,600,800);
      
      ///////////panel1~ 6�� ���ϴ� ���� ������ ��~!!
      panel1 = new JPanel();
      panel2 = new JPanel();
      panel3 = new JPanel();
      panel4 = new JPanel();
      panel5 = new JPanel();
      panel6 = new JPanel();
      
      // ����ġ
      heart1 = new ImageIcon("heart.png");
      emptyheart = new ImageIcon("empty_heart.png");
      heartLabel = new JLabel[5];
    
    //��Ʈ ���ַ��� ����� ����
     for(int i = 0; i < 5; i++){
      heartLabel[i] = new JLabel();
      heartLabel[i].setIcon(heart1);
      panel1.add(heartLabel[i]);
     
     for(int k=0; k<10; k++)
     {
    	 flag[k]=0;
    	 startb[k]=0;
     }
     
     }

      JLabel blank1 = new JLabel("     ");
      panel1.add(blank1);
      
      test = new TimTest(panel1,450);//Ÿ�̸� �߰�~!
      test.start();
      
//      JLabel score = new JLabel("Score");
      score = new JTextField("score : 0");
      score.setFont(new Font("����ǹ��� �־�", Font.BOLD, 34));
      JLabel blank2 = new JLabel("     ");
      panel1.add(blank2);
      panel1.add(score);
      
      soldCount = 0;
      sales = new JLabel("�ؾ �Ǹŷ�     " + soldCount);
      sales.setFont(new Font("����ǹ��� �־�", Font.BOLD, 34));
      stockCount = 0;
      stock = new JLabel("�ؾ ���:   " + stockCount);
      stock.setFont(new Font("����ǹ��� �־�", Font.BOLD, 34));
      
      panel2.setLayout(new GridLayout(4,3));
      fish = new JButton[12];
      for(int i=0; i<12; i++)
      {
         fish[i] = new JButton("");
         fish[i].addActionListener(this);
         panel2.add(fish[i]);
         ths[i] = new  FishThread();
      }
      
      fishCount = new int[12];
      for(int i=0; i<12; i++)
      {
         fishCount[i] = 0;
      }
      
      kettle_flag = false;
      bean_flag = false;
      turner_flag = false;
      wrap_flag = false;
      
      panel3.add(sales);
      panel4.add(stock);
      
      ImageIcon sale = new ImageIcon("sale.jpg");
      ImageIcon ic[] = new ImageIcon[10];
      for (int i = 0; i<10; i++)
         ic[i] = new ImageIcon("c" + String.valueOf(i) + ".png");
      lab_img = new JLabel();
      OK = new JButton("");
      OK.setBackground(Color.WHITE);
      OK.setIcon(sale);
      OK.addActionListener(new MyListener());
      
      panel5.add(lab_img);
      panel5.setLayout(new GridLayout(2,1,0,0));
     
      val = (int)(Math.random() * 10);
      lab_img = new JLabel();
      lab_img.setIcon(ic[val]);
      
      OK.addActionListener(new MyListener());
      panel5.setLayout(new BorderLayout(5,5));
      panel5.add(lab_img, BorderLayout.WEST);
      JLabel jlab = new JLabel("�ؾ\n"+ val + "\n" + "�� \n�ּ���!");
      jlab.setFont(new Font("����ǹ��� �־�", Font.BOLD, 34));

      panel5.add(OK, BorderLayout.SOUTH);
      panel5.add(jlab, BorderLayout.CENTER);

      
      kettle = new JButton("");
      bean = new JButton("");
      turner = new JButton("");
      wrap = new JButton("");
      kettle.addActionListener(new MyListener());
      bean.addActionListener(new MyListener());
      turner.addActionListener(new MyListener());
      wrap.addActionListener(new MyListener());
      ImageIcon icon1 = new ImageIcon("kettle.png");
      ImageIcon icon2 = new ImageIcon("bean.jpg");
      ImageIcon icon3 = new ImageIcon("turner.png");
      ImageIcon icon4 = new ImageIcon("wrap.png");
      
      kettle.setIcon(icon1);
      bean.setIcon(icon2);
      turner.setIcon(icon3);
      wrap.setIcon(icon4);
      panel6.add(kettle);
      panel6.add(bean);
      panel6.add(turner);
      panel6.add(wrap);
      
      
      panel1.setBounds(0,0,600,200);
      panel2.setBounds(0,200,600,600);
      panel3.setBounds(600,0,300,100);
      panel4.setBounds(900,0,300,100);
      panel5.setBounds(600,100,600,500);
      panel6.setBounds(600,600,600,200);

      panel1.setBackground(new Color(250, 167, 167));
      panel2.setBackground(new Color(0, 250, 0));
      panel3.setBackground(new Color(250, 237, 125));
      panel4.setBackground(new Color(206, 242, 121));
      panel5.setBackground(new Color(255, 255, 255));
      panel6.setBackground(new Color(209, 178, 255));


      left_panel.add(panel1);
      left_panel.add(panel2);
      right_panel.add(panel3);
      right_panel.add(panel4);
      right_panel.add(panel5);
      right_panel.add(panel6);
      
      frame.setVisible(true);    
   }
   
   public void run(){
      System.out.println("�ȴ�?");
     
      for(int i=0; i<12; i++)
         if(this.getName()=="ths[i]")
         {
            System.out.println(this.getName());
            if(fish[i].isEnabled())
               fish[i].setEnabled(false);
            else
               fish[i].setEnabled(true);
            while(true)
            { 
               try {
                  Thread.sleep(3000);
                  
               }catch(Exception e) {
                  System.out.println(e);
               }
            }
         }
        
      
   }
 

   @SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
       for(int i=0; i<12; i++){
           if(e.getSource() == fish[i]){
              if(kettle_flag == true && fishCount[i] == 0) {
                    ImageIcon changed_icon1 = new ImageIcon("kettle.png");
                    fish[i].setIcon(changed_icon1);
                    fishCount[i] = 1;
                    startb[i]=1;
              }
              
              if(bean_flag == true && fishCount[i] == 1) {
                    ImageIcon changed_icon2 = new ImageIcon("bean.jpg");
                    fish[i].setIcon(changed_icon2);
                    fishCount[i] = 2;
                    startb[i]=1;
              }
              
              if(turner_flag == true && fishCount[i] == 2) {
                    ImageIcon changed_icon3 = new ImageIcon("fish4.png");
                    fish[i].setIcon(changed_icon3);
                    fishCount[i] = 3;
                    startb[i]=0;
                    System.out.println("������ ���� startb = "+startb[i]);
	                if(flag[i] == 0){//ù��°�� thread start�Ҷ��� �� if���� ��
	                  ths[i].start();
	                  flag[i]++;
	                  System.out.println("ù��° ������ ���ͼ� ����");
	               }
	                else {
	                	//ths[i].resume();
	                }
              }

              if(wrap_flag == true && fishCount[i] == 3) {
            	
                ImageIcon changed_icon4 = new ImageIcon("");
                fish[i].setIcon(changed_icon4);
                stockCount++;
                stock.setText("�ؾ ���:   " + stockCount);
                fishCount[i] = 0;
                startb[i]=1;
                //ths[i].suspend();
              }
              
           }
       }
   }
   
   public class FishThread extends Thread
   {

   public void run(){
      
   
      for(int i=2; i<14; i++){
         
         String name = this.getName();
         String bname = name.substring(7);
         System.out.println(bname);
         if(Integer.valueOf(bname) == i)
         {      System.out.println("�ȴ�22222"+Integer.valueOf(bname) );
            startb[i-2] = 0;
            int tempk=0;
            while(true)
            { 
            	
            	if(startb[i-2]==0 && fishCount[i-2] == 3)
            	{       
            		try {
            			Thread.sleep(5000);
            			if(startb[i-2]==0 && fishCount[i-2] == 3)
            			{
            				 Thread.sleep(1000);
	            		 fish[i-2].setIcon(fish3);
	            		 heartnum--;            
	                     heartLabel[heartnum].setIcon(emptyheart);
	                     if(heartnum == 0) 
	                     {
	                    	 new RankFrame2(soldCount*100);
	                    	 frame.setVisible(false); 
	                     }
	                     Thread.sleep(1000);
	                     
                    	
            			}
                     }catch(Exception e) {
                    	 System.out.println(e);
                     }
            		fish[i-2].setIcon(icon5);
                    startb[i-2]=1;
                    fishCount[i-2]=0;
                     
            	}
            	
            	/*
            	System.out.println("eeeeeee");
               if(startb[i-2]<2)
               {
                
              System.out.println("�־ȵǳ�");
              System.out.println(fish[i-2].isEnabled());
                  if(fish[i-2].isEnabled())
                  {
                	  fish[i-2].setEnabled(false);
                	  System.out.println("��Ȱ��ȭ");
                  }
                  else
                  {
                	  fish[i-2].setEnabled(true);
                	  System.out.println("Ȱ��ȭ");
                  }
       
                     try {
                        Thread.sleep(3000);
                        System.out.println("^^�ٲ����startb = " + startb[i-2]);
                        fish[i-2].setIcon(fish4);
                        System.out.println("^^�ٲ����startb = " + startb[i-2]);
                        Thread.sleep(4000);
                        startb[i-2]++;
                     }catch(Exception e) {
                        System.out.println(e);
                     }
                     
                    
               }
               //��� �ؾ ȭ��
               if(startb[i-2]==2)
               {
            	  
                  System.out.println("�ڴ���");
                  try {
                       Thread.sleep(5000);       
                  }catch(Exception e) {
                        System.out.println(e);
                  }
                  
                  //5�ʰ� �����µ��� 
                  if(fishCount[i-2]==3)
                  {
                	  System.out.println(fishCount[i-2]);
                	  System.out.println("�ι�°  "+startb[i-2]);
                	  startb[i-2]++;
                  }                 
                  
               }
               if(startb[i-2]==3){
                   System.out.println("startb ==3 ����");
                   try {
                         //Thread.sleep(2000);
                         fish[i-2].setIcon(fish3);
                   heartnum--;            
                   heartLabel[heartnum].setIcon(emptyheart);
                      
                   if(heartnum == 0) //��Ʈ0���̸� ���ο� �����Ӱ����� ��µǰԲ��� ����ٲ��ּ���~~!~!~!~!~!~!~!~!~!
                      tt = new TimTest(panel1,11);
                   startb[i-2] = 0;
                   break;

                  }catch(Exception e) {
                         System.out.println(e);
                  }    
             
             
             }
             */
            }
         }
     }
   }





   }
   
   public class MyListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           if(e.getSource()==kettle) {
              imgCursor = tk.getImage("kettle.png");
              Point point = new Point(0,0);
              cursor = tk.createCustomCursor(imgCursor,  point, "kettle");
              frame.setCursor(cursor);
              kettle_flag = true;
              bean_flag = false;
              turner_flag = false;
              wrap_flag = false;
           }
           if(e.getSource()==bean) {
              imgCursor = tk.getImage("bean.jpg");
              Point point = new Point(0,0);
              cursor = tk.createCustomCursor(imgCursor,  point, "bean");
              frame.setCursor(cursor);  
              bean_flag = true;
              kettle_flag = false;
              turner_flag = false;
              wrap_flag = false;
           }
           if(e.getSource()==turner) {
                 imgCursor = tk.getImage("turner.png");
                 Point point = new Point(0,0);
                 cursor = tk.createCustomCursor(imgCursor,  point, "turner");
                 frame.setCursor(cursor);  
                 turner_flag = true;
                 kettle_flag = false;
                 bean_flag = false;
                 wrap_flag = false;
 
          }
           if(e.getSource()==wrap) {
                 imgCursor = tk.getImage("wrap.png");
                 Point point = new Point(0,0);
                 cursor = tk.createCustomCursor(imgCursor,  point, "turner");
                 frame.setCursor(cursor);  
                 wrap_flag = true;
                 kettle_flag = false;
                 bean_flag = false;
                 turner_flag = false;
          }
           if(e.getSource()==OK) {
              if(stockCount >= val) {
              stockCount = stockCount - val;
              soldCount = soldCount + val;
              score.setText("score:" + soldCount*100);
             
              stock.setText("�ؾ ���:   " + stockCount);
              sales.setText("�ؾ �Ǹŷ�     " + soldCount);
              val = (int)(Math.random() * 10 + 1);

              jlab.setText("�ؾ\n"+ val + "�� \n�ּ���");




              }
          }
        }
   }

}