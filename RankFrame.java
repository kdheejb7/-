import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


public class RankFrame{
	  JFrame frame;
	  JPanel jp1,jp2;
	  JTable rankTable;					//ranking 테이블
	  String sb[][];	
	  //DefaultTableModel model;//데이터가 들어갈 배열
	  //db 연결
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
	  
	  public RankFrame(){
	      frame = new JFrame();
	      frame.setSize(1200,850);    
	      frame.setLayout(new BorderLayout(10,10));
	      jp1 = new JPanel();
	      jp2 = new JPanel();
	      JLabel jtitle = new JLabel("붕어빵 랭킹",JLabel.CENTER);
	      jtitle.setFont(new Font("배달의민족 주아", Font.BOLD, 90));
	      JLabel jranktable = new JLabel("붕어빵 랭킹",JLabel.CENTER);
	      jranktable.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
	      rankTable = new JTable();
	      String fieldName[] = {
	    		  "순위",
	    		  "이름",
	    		  "점수"
	      };
	      
	      
	      String name="";
	      int score = 0;
	      
	      try {
		      Connection con = getConnection();

		      Statement stmt = con.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM rank ORDER BY score DESC");
		      int ranking = 1;
		      int numb=0;
		      rs.last();
		      sb = new String[rs.getRow()][3];
		      //model = new DefaultTableModel(fieldName,rs.getRow()); 
		      rs.beforeFirst();
		      while(rs.next())
		      {
		    	  System.out.println("S");
		    	  
		    	  name = rs.getString("user_name");
		    	  score = rs.getInt("score");
		    	  
		    	  String r[] = {Integer.toString(ranking), name, Integer.toString(score)};
		    	  sb[numb] = r;
		    	  numb++;
		    	  ranking++;
		    	  
		      }
				
		      //System.out.println(sb);
	      }catch(Exception e) {
	    	  System.out.println(e);
	      }
	      
	      //jranktable.setText("애안돼냐\n줄바꾸기");
	      rankTable = new JTable(sb,fieldName);
	      rankTable.getColumnModel().getColumn(0).setPreferredWidth(200);
	      rankTable.getColumnModel().getColumn(1).setPreferredWidth(300);
	      rankTable.getColumnModel().getColumn(2).setPreferredWidth(200);
	      rankTable.setRowHeight(100);
	      rankTable.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
	      
	      
	      //내용 가운데 정렬
	      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	      TableColumnModel tcm = rankTable.getColumnModel();
	      
	      for(int i=0; i<tcm.getColumnCount(); i++)
	    	  tcm.getColumn(i).setCellRenderer(dtcr);

	      JScrollPane sp = new JScrollPane(rankTable);
	      sp.setPreferredSize(new Dimension(800, 600));
	      sp.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
	      jp2.add(sp);
	      jp1.add(jtitle);
	      //jp2.add(jranktable);
	      
	      jp1.setBackground(new Color(250, 237, 125));
	      jp2.setBackground(new Color(250, 237, 125));
	      frame.add("North",jp1);
	      frame.add("Center",jp2);
	      frame.setVisible(true);
	  }
	  

}
