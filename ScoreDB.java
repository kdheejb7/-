import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;

//타이머가 0이 되면 새 프레임이 뜸. 
public class ScoreDB {
	public void ScoreDB() {
		JFrame scoreFrame = new JFrame("점수표");
		scoreFrame.setSize(500,500);
		scoreFrame.setVisible(true);
		
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
	
	
}
