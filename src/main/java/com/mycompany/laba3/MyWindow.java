/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.laba3;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author gribu
 */
public class MyWindow extends javax.swing.JFrame {

    /**
     * Creates new form MyWindow
     */
    public MyWindow() {
        initComponents();
        System.out.println("das ist meine Faben: "+Thread.currentThread().getName());  
        Point p = generateStartLocation();
        makeMovingPanel(p);
    }

    private Point generateStartLocation(){
        int start_x = getRandomNumber(0, this.getWidth() - 16 - jPanel1.getWidth() );
        int start_y = getRandomNumber(0, this.getHeight() - 36 - jPanel1.getHeight() );
        return new Point (start_x, start_y);
    }
    
    private int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max-min)) + min ); 
    }
    
    private Color getRandomColor(){
        int red = getRandomNumber(0,255);
        int green = getRandomNumber(0,255);
        int blue = getRandomNumber(0,255);
        return new Color(red,green,blue);
    } 
    private void makeMovingPanel(Point p){
        Runnable colorRunnable = () -> {
            System.out.println("das ist color thread: "+Thread.currentThread().getName());
            while (true) {
                Color c = getRandomColor(); 
                jPanel1.setBackground(c);
                try{ 
                 Thread.sleep(200);
                } catch (Exception e ){System.out.println(e.getMessage() );}
            }
        };
        
        Runnable moveRunnable = () -> {
            System.out.println("das ist move thread: "+Thread.currentThread().getName());
            
            int x_step, y_step;
            if (p.x > 0){x_step= -1;} else{x_step = 1;}
            if (p.y > 0){y_step= -1;} else{y_step = 1;}
            while (true) {
                if (jPanel1.getLocation().x == (this.getWidth() -16 -jPanel1.getWidth())) {
                    x_step = -1;
                } else if (jPanel1.getLocation().x == 0){
                    x_step = 1;
                }
                
                if (jPanel1.getLocation().y == (this.getHeight() -36 -jPanel1.getHeight())) {
                    y_step = -1;
                } else if (jPanel1.getLocation().y == 0){
                    y_step = 1;
                }
                
                jPanel1.setLocation(jPanel1.getLocation().x + x_step, jPanel1.getLocation().y + y_step);
                try{Thread.sleep(5);} catch (Exception e ){System.out.println(e.getMessage() );}
            }
        };
              
       this.setLayout(null);
       jPanel1.setLocation(p.x, p.y);
       
       Thread colorThread = new Thread(colorRunnable);
       colorThread.start();
       
       Thread moveThread = new Thread(moveRunnable);
       moveThread.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 304, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
