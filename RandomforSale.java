import java.awt.*;
import javax.swing.*;

class RandomforSale extends JPanel {
    Image bg = new ImageIcon("ballon.png").getImage();
    
   RandomforSale() {
      int value = (int)(Math.random() * 10);
      JLabel jlab = new JLabel("ºØ¾î»§\n"+ value + "°³ \nÁÖ¼¼¿ä");
      add(jlab);
        setOpaque(false);
//      setLayout(new BorderLayout(10,10));
////        jlab.setLocation(0,0);   
//        jlab.setLocation(0,100);

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}