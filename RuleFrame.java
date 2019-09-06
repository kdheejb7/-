import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RuleFrame {
      JFrame frame;
     JPanel pan1, pan2;

     public RuleFrame(){
         frame = new JFrame("게임 방법!!");
       pan1 = new JPanel();
       pan1.setBackground(new Color(0,252,210));

       JLabel title = new JLabel("게임 방법!!",JLabel.CENTER);
         title.setFont(new Font("배달의민족 주아", Font.BOLD, 80));

       JLabel contents = new JLabel("<html><p>1.랭킹 보기: 데이터 베이스에 저장된 user들의 랭킹을 볼 수 있습니다.</p><br /><p>2.게임 시작</p><br /><p style='color:red;'>타이머의 숫자가 0이 되서 게임이 종료되거나</p> <p>제 때 뒤집거나 포장을 하지 않아 붕어빵이 타면 하트 1개씩 감소.</p><p style='color:red;'>하트가 모두 소진되면 게임오버</p><br /><p>반죽 팥앙금 뒤집기 포장 버튼을 누르면 커서 모양이 변합니다.</p><p>커서가 바뀐 상태에서 붕어빵틀을 누릅니다.</p><p style='color:red;'>반죽 -> 팥앙금 -> 뒤집기 -> 포장 순으로 눌러야 합니다.</p><br /><p style='color:blue;'>반죽과 팥앙금을 넣고 일정 시간이 지나면 익어서 색이 변할 때 뒤집어야합니다.</p><p>뒤집고 나서 일정시간이 지나면 익어서 색이 변하고 그 때, 포장을 하면 됩니다.</p><p style='color:red;'>판매하기 버튼을 누르면 붕어빵 판매가 됩니다.</p><p style='color:blue;'>1개당 100점으로 환산됩니다.</p></html>",JLabel.CENTER);
         contents.setFont(new Font("배달의민족 주아", Font.BOLD, 30));
   
       pan1.add(title);
       pan1.add(contents);
       frame.add(pan1);

       frame.setSize(1200,750);     
         frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}