import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

 
public class TimTest extends Thread{
   int k;
   JLabel timerLabel = null;
   JFrame scoreInsert;
   
   int score;
   
    public TimTest(JPanel jp, int t)
    {
      k = t;
      timerLabel = new JLabel("100");
      jp.add(timerLabel);
      timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
      scoreInsert = new JFrame("���� �Է�â");
      scoreInsert.setLayout(new BorderLayout());
      JLabel jname = new JLabel("�̸��� �Է��ϼ���:");
      JLabel jend = new JLabel("������ ����Ǿ����ϴ�.");
      JTextField jfname = new JTextField(20);
      JButton jbsave = new JButton("�����ϱ�");
      JPanel p0 = new JPanel();
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
      p0.add(jend);
      p1.add(jname);
      p1.add(jfname);
      p2.add(jbsave);
      scoreInsert.add("North", p0);
      scoreInsert.add("Center",p1);
      scoreInsert.add("South",p2);
      scoreInsert.setSize(500,300);
      jbsave.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  String name = jfname.getText();
    		  try {
		      Connection con = getConnection();
			  PreparedStatement posted = con.prepareStatement
						("INSERT INTO rank VALUES('"+name+"','"+score+"')");
			  posted.executeUpdate();
    		  }catch(Exception e1) {
    		  System.out.println(e1);
    		  }
    	}
      });
   }
    public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3307/gamedb?useSSL=false&serverTimezone=Asia/Seoul";
			String username = "root";
			String password = "dbejr1804z";
			
			Class.forName(driver);
			Connection  conn = DriverManager.getConnection(url, username, password);
			//System.out.println("Connected");
			return conn;
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
    
   public void run()
   {
      while(true)
        {
            timerLabel.setText(""+k);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            k--; 
            if(k==-1)
            {	
                scoreInsert.setVisible(true);
            	break;
            }
        }

    }
}
 

