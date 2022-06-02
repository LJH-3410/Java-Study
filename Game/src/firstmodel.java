// ��ɵ��� �ҷ���.
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*; 


public class firstmodel extends JFrame implements Runnable, KeyListener {
   private static BufferedImage bi = null;
   private static ArrayList ultimateList = null;  //�ʻ�� ����
   private static ArrayList msList = null;
   private static ArrayList enList = null;
   private static BufferedImage plane = null, bullet = null, png = null, background = null, ultimate = null;;
   private static boolean left = false, right = false, up = false, down = false, fire = false, shift = false, start = true, end = false, ultimate_fire =false;;
   private static int w = 600, h = 600, x = 250, y = 500, xw = 20, xh = 20, life = 3;
   public static int sum = 0;   //���� ó�� ����
   
   // ���������� ���̴� ���� ����.
   
   
   public firstmodel() {
      bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); // ���ȭ�� �� ����
      msList = new ArrayList(); // �Ѿ� �⺻ ����
      enList = new ArrayList(); // ���� �⺻ ����
      ultimateList = new ArrayList();   //�ʻ�� ��ü ��� ����Ʈ
      this.addKeyListener(this); // Ű ���
      this.setSize(600, 600);  // �⺻ ȭ�� ũ��
      this.setTitle("Shooting Game"); // ȭ�� �̸�
      this.setResizable(false); // â ũ�� ���� ����
      this.setLocationRelativeTo(null); // ȭ�鿡 ����� ����
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ â ����� ���μ����� ������ �ݴ´�
      this.setVisible(true); // â�� ��Ÿ���� ����
      try {
         plane = ImageIO.read(new File("image\\my_plane.png"));
         bullet = ImageIO.read(new File("image\\bullet.png"));
         png = ImageIO.read(new File("image\\en_plane.png"));      // �̹����� ����ϴ� ����, ���� �߻��� �ؿ��� ó����
         background = ImageIO.read(new File("image\\back.png"));
         ultimate = ImageIO.read(new File("image\\ultimate.png"));
      } catch (IOException e) { }
   }   
   
   public void run() { // �����ϴ� �κ�
      try {

         int msCnt = 0;
         int enCnt = 0;
         while(start) {
            Thread.sleep(10);
            if(true) {
               if(enCnt > 2000) {
                  enCreate();
                  enCnt = 0;
               }
               if(msCnt >= 100) {
                  fireMs();
                  ultimate_fireMs();   //�ʻ�� ���
                  msCnt = 0;
               }
               msCnt += 10;
               
               if(sum >= 0 && sum < 1000) 
                  enCnt += 10;
                  else if(sum >= 1000 && sum <2000)
                     enCnt += 20;
                     else if(sum >= 2000 && sum < 4000)
                        enCnt += 30;      // ���̵� ���� �Ϸ�
               else
                  enCnt += 100;
               keyControl();
               crashChk();
               ultimatecrashChk();
            }
            draw();   
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
   }

   public void fireMs() { // ���� �Ѿ� ������Ű�� �޼ҵ�
      if(fire) {
         if(msList.size() < 100) {
            Ms m = new Ms(this.x, this.y);
            msList.add(m);
         }
      }
   }

      
      public void ultimate_fireMs() { //�ʻ�� ��������� �ѹ߾� �����°�
            if(ultimate_fire) {
                  if(ultimateList.size() < 1) {
                        Us n = new Us(this.x, this.y);
                        ultimateList.add(n);
                  }
         }
      }
   
   public static void enCreate() { // ���� ������Ű�� �޼ҵ�
         for(int i = 0; i < 9; i++) {
         double rx = Math.random() * (w - xw) - 20;
         double ry = Math.random() * 50;
         Enemy en = new Enemy((int)rx, (int)ry);
         enList.add(en);
      }
   }
   
   public void crashChk() { // ����� �Ѿ��� ������� ����� �Ѿ��� ������� ���� ����
      Graphics g = this.getGraphics();
      Polygon p = null;
      for(int i = 0; i < msList.size(); i++) {
         Ms m = (Ms)msList.get(i);
         for(int j = 0; j < enList.size(); j++) {
            Enemy e = (Enemy)enList.get(j);
            int[] xpoints = {m.x, (m.x + m.w), (m.x + m.w), m.x};
            int[] ypoints = {m.y, m.y, (m.y + m.h), (m.y + m.h)};
            p = new Polygon(xpoints, ypoints, 4);
            try { 
               if(p.intersects((double)e.x-5, (double)e.y, (double)e.w, (double)e.h+30)) {
                  msList.remove(i);
                  enList.remove(j);
                  sum += 50;  // ���� �Ǿ��� �� ���� ����
               }
            }catch (IndexOutOfBoundsException e1) { e1.printStackTrace(); }
         }
      }
   }
        
   public void ultimatecrashChk() {    //�ʻ�� �¾����� ���� �������� ���� ������ �ϴ� ��
                Graphics g = this.getGraphics();
                Polygon p = null;
                for(int i = 0; i < ultimateList.size(); i++) {
                   Us u = (Us)ultimateList.get(i);
                     for(int j = 0; j < enList.size(); j++) {
                         Enemy e = (Enemy)enList.get(j);
                         int[] xpoints = {u.x, (u.x + u.w+1000), (u.x + u.w-1000), u.x}; // �ʻ�� ������ �� ������ ����
                        int[] ypoints = {u.y, u.y, (u.y + u.h), (u.y + u.h)};
                         p = new Polygon(xpoints, ypoints, 4); 
                         try { 
                               if(p.intersects((double)e.x-5, (double)e.y, (double)e.w, (double)e.h+30)) {
                                     enList.remove(j); // �ʻ���� ��� ����� ��������� �Ѿ��� ����ؼ� ����
                                     sum += 50; 
                               }
                         }catch (IndexOutOfBoundsException e1) { e1.printStackTrace(); }
                   }
                }
 
      
      for(int i = 0; i < enList.size(); i++) { // ����� �Ʊ��Ⱑ ����� �� life ���ҿ� life�� 0�Ͻ� ���� ���� + ���� �ʱ�ȭ
         Enemy e = (Enemy)enList.get(i);
         int[] xpoints = {x, (x + xw), (x + xw), x};
         int[] ypoints = {y, y, (y + xh), (y + xh)};
         p = new Polygon(xpoints, ypoints, 4);
         if(p.intersects((double)e.x-10, (double)e.y, (double)e.w, (double)e.h)) {
            enList.remove(i);
            if(life != 0) {
               --life;
            }
            if(life == 0) {
               start = false; 
               end = true;
               sum = 0;
            }
         }
      }
   }
   
   public void draw() { // â �ȿ� ��Ʈ ����, �⺻ �� ����, ������ ��� ǥ�� 
      Polygon pa = null;
      Graphics gs = bi.getGraphics();
      gs.setColor(new Color(6,88,144));
      gs.drawImage(background, 0, 0, this);
      gs.setColor(Color.white);
      gs.setFont(new Font("Pixeboy", Font.PLAIN, 40));
      gs.drawString(sum+"", 15, 110);
      gs.drawString("LIFE : " + life, 450, 70);
      
      if(end) // end �ÿ� GAME OVER �����ġ ���� 
         gs.drawString("G A M E     O V E R", 120, 250);
      gs.drawString("Single", 15, 70);
      gs.drawImage(plane, x, y, null);
      
      for(int i = 0; i < msList.size(); i++) { // �⺻ �Ѿ��� ��ġ ����
         Ms m = (Ms)msList.get(i);
         gs.setColor(Color.blue);
         gs.drawImage(bullet, m.x+33, m.y-15, null);
         if(m.y < 0) msList.remove(i);
         m.moveMs();
      }


      for(int i = 0; i < ultimateList.size(); i++) { // �ʻ�� ��ġ ����
              Us u = (Us)ultimateList.get(i);
              gs.setColor(Color.blue);
              gs.drawImage(ultimate, u.x-170, u.y-205, null);
              if(u.y < 0) ultimateList.remove(i);
              u.moveUs();
      }
      
      gs.setColor(Color.black); // ���� �ǰ� ���� ���� ����
      for(int i = 0; i < enList.size(); i++) {
         Enemy e = (Enemy)enList.get(i);
         gs.drawImage(png, e.x, e.y, null);
         if(e.y > h) enList.remove(i);
         e.moveEn();
      }
      
      Graphics ge = this.getGraphics();
      ge.drawImage(bi, 0, 0, w, h, this); // ��� ��ġ ����
   }
   
   public void keyControl() { // ������ ������ ���� ���ο� ��� ������ ���� ����Ʈ ���� �ӵ� ����
      if(0 < x) {
         if(shift&&left) {
            x -= 2;
         }
         else if(left) {
            x -= 6;
         }
      }
      if(w > x + 100) {
         if(right&&shift) {
            x += 2;
         }
         else if(right) {
            x += 6;
         }
      }
      if(25 < y) {
         if(up&&shift) { 
            y -= 2;
         }
         else if(up) { 
            y -= 6;
         }
      }
      if(h > y + 100) {
         if(down&&shift) {
            y += 2;
         }
         else if(down) { 
            y += 6;
         }
      }
   }
   
   public void keyPressed(KeyEvent ke) { // �⺻���� Ű ��Ʈ�� ����Ű 4���� ���� Ű ���� �޼ҵ�
      switch(ke.getKeyCode()) {
      case KeyEvent.VK_LEFT:
         left = true;
         break;      
      case KeyEvent.VK_RIGHT:
         right = true;
         break;
      case KeyEvent.VK_UP:
         up = true;
         break;
      case KeyEvent.VK_DOWN:
         down = true;
         break;
      case KeyEvent.VK_SPACE:
         fire = true;
         break;
      case KeyEvent.VK_A:   //aŰ ������ �ʻ��
         ultimate_fire = true;
         break;
      case KeyEvent.VK_ENTER:
         if(end) {
            System.exit(0);
            break;
         }
         break;
      case KeyEvent.VK_SHIFT :
         shift = true;
         break;
      }
   }
   
   public void keyReleased(KeyEvent ke) { // �⺻ Ű Ÿ��
      switch(ke.getKeyCode()) {
      case KeyEvent.VK_LEFT:
         left = false;
         break;
      case KeyEvent.VK_RIGHT:
         right = false;
         break;
      case KeyEvent.VK_UP:
         up = false;
         break;
      case KeyEvent.VK_DOWN:
         down = false;
         break;
      case KeyEvent.VK_A:   
         ultimate_fire = false;
         break;
      case KeyEvent.VK_SPACE:
         fire = false;
         break;
      case KeyEvent.VK_SHIFT :
         shift = false;
         break;
      }
   }
   
   public void keyTyped(KeyEvent ke) {} // Ű �Է� �� ��ǥ ��ȯ
   
   public static int getCondX() {
      return x;
   }
   public static int getCondY() {
      return y;
   }
   
   public static void setX(int x) {
	  firstmodel.x = x;
   }
   public static void setY(int y) {
	   firstmodel.y = y;
   }
   public static void main(String[] args) {
        Thread t = new Thread(new firstmodel());
        t.start();
       }
}

class Ms { // �⺻ �Ѿ� �����̰� �ϴ� �޼ҵ�
   int x, y, w =20, h=20, speed = 5;
   
   public Ms(int x, int y) {
      this.x = x;
      this.y = y;
   }
   public void moveMs() { y-=5; } // �Ѿ� �ӵ� ����
}

class Us {      // �ʻ�� �Ѿ� �����̰� �ϴ� �޼ҵ�
   int x, y, w = 20, h=20, speed = 5;
      
      public Us(int x, int y) {
         this.x = x;
         this.y = y;
      }
      public void moveUs() { y-=5; } // �Ѿ� �ӵ� ����
}
   
class Enemy { // ���� �����̰� �ϴ� �޼ҵ�
   int x, y, w = 30, h = 30;
   public Enemy(int x, int y) {
      this.x = x;
      this.y = y;
   }
   public void moveEn() { y+=2;} // ���� �ӵ� ���� 
}