import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RuleFrame {
      JFrame frame;
     JPanel pan1, pan2;

     public RuleFrame(){
         frame = new JFrame("���� ���!!");
       pan1 = new JPanel();
       pan1.setBackground(new Color(0,252,210));

       JLabel title = new JLabel("���� ���!!",JLabel.CENTER);
         title.setFont(new Font("����ǹ��� �־�", Font.BOLD, 80));

       JLabel contents = new JLabel("<html><p>1.��ŷ ����: ������ ���̽��� ����� user���� ��ŷ�� �� �� �ֽ��ϴ�.</p><br /><p>2.���� ����</p><br /><p style='color:red;'>Ÿ�̸��� ���ڰ� 0�� �Ǽ� ������ ����ǰų�</p> <p>�� �� �����ų� ������ ���� �ʾ� �ؾ�� Ÿ�� ��Ʈ 1���� ����.</p><p style='color:red;'>��Ʈ�� ��� �����Ǹ� ���ӿ���</p><br /><p>���� �Ͼӱ� ������ ���� ��ư�� ������ Ŀ�� ����� ���մϴ�.</p><p>Ŀ���� �ٲ� ���¿��� �ؾƲ�� �����ϴ�.</p><p style='color:red;'>���� -> �Ͼӱ� -> ������ -> ���� ������ ������ �մϴ�.</p><br /><p style='color:blue;'>���װ� �Ͼӱ��� �ְ� ���� �ð��� ������ �; ���� ���� �� ��������մϴ�.</p><p>������ ���� �����ð��� ������ �; ���� ���ϰ� �� ��, ������ �ϸ� �˴ϴ�.</p><p style='color:red;'>�Ǹ��ϱ� ��ư�� ������ �ؾ �ǸŰ� �˴ϴ�.</p><p style='color:blue;'>1���� 100������ ȯ��˴ϴ�.</p></html>",JLabel.CENTER);
         contents.setFont(new Font("����ǹ��� �־�", Font.BOLD, 30));
   
       pan1.add(title);
       pan1.add(contents);
       frame.add(pan1);

       frame.setSize(1200,750);     
         frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}