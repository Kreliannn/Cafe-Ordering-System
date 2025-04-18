/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe_shop;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import types.*;
import utils.customHooks;
import backend.orderBackend;
import java.awt.GridLayout;
import java.util.*;
import backend.customerBackend;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import javax.swing.SwingUtilities;
import java.util.concurrent.*;
/**
 *
 * @author U
 */
public class cashierPage extends javax.swing.JFrame {
    private employee myEmployee;
    private orderBackend orderClass = new orderBackend();
    private customerBackend customerBackend = new customerBackend();
    /**
     * Creates new form cashierPage
     */
    public cashierPage(employee params) {
        initComponents();
        this.myEmployee = params;

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            ArrayList<order> orders = orderClass.getOrders("waiting", "none");

            SwingUtilities.invokeLater(() -> {
                orderContainer.removeAll(); // Clear previous orders
                orderContainer.setLayout(new GridLayout(0, 1, 15, 15));
                orderContainer.setBackground(new Color(230, 230, 230));

                for (order currrentOrder : orders) {
                    JPanel productPanel = new JPanel();
                    productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
                    productPanel.setPreferredSize(new Dimension(200, 130));
                    productPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(180, 180, 180), 2),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
                    productPanel.setBackground(new Color(240, 240, 240));

                    JLabel customerText = new JLabel("Customer: " + customerBackend.getName(currrentOrder.getCustomerId()));
                    JLabel orderIdText = new JLabel("Order ID: " + currrentOrder.getOrderId());
                    JLabel dateText = new JLabel("Date: " + currrentOrder.getOrderDate());
                    JLabel totalText = new JLabel("Total: " + currrentOrder.getTotalAmount());

                    Font textFont = new Font("Arial", Font.BOLD, 14);
                    customerText.setFont(textFont);
                    orderIdText.setFont(new Font("Arial", Font.PLAIN, 13));
                    dateText.setFont(new Font("Arial", Font.PLAIN, 13));
                    totalText.setFont(new Font("Arial", Font.PLAIN, 13));
                    totalText.setForeground(new Color(50, 50, 50));

                    JButton saveButton = new JButton("Payed");
                    JButton rejectButton = new JButton("Remove");

                    saveButton.setPreferredSize(new Dimension(100, 30));
                    rejectButton.setPreferredSize(new Dimension(100, 30));

                    saveButton.setBackground(new Color(100, 200, 100));
                    rejectButton.setBackground(new Color(200, 100, 100));
                    saveButton.setForeground(Color.WHITE);
                    rejectButton.setForeground(Color.WHITE);
                    saveButton.setBorderPainted(false);
                    rejectButton.setBorderPainted(false);
                    saveButton.setOpaque(true);
                    rejectButton.setOpaque(true);

                    saveButton.addActionListener(e -> {
                        LocalDate currentDate = LocalDate.now();
                        String date = currentDate.toString();
                        orderClass.changeStatus(currrentOrder.getOrderId(), "serving");
                        orderClass.addPayment(new payment(0, currrentOrder.getOrderId(), "cash", currrentOrder.getTotalAmount(), date));
                      
                    });

                    rejectButton.addActionListener(e -> {
                        orderClass.rejectOrder(currrentOrder.getOrderId());
                    
                    });

                    JPanel buttonPanel = new JPanel();
                    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
                    buttonPanel.add(saveButton);
                    buttonPanel.add(rejectButton);
                    buttonPanel.setOpaque(false);

                    productPanel.add(customerText);
                    productPanel.add(orderIdText);
                    productPanel.add(dateText);
                    productPanel.add(totalText);
                    productPanel.add(buttonPanel);

                    orderContainer.add(productPanel);
                }

                orderContainer.revalidate();
                orderContainer.repaint();
            });

        }, 0, 5, TimeUnit.SECONDS); // Fetch and refresh every 2 seconds
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dashboard = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderContainer = new javax.swing.JPanel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setText("inventory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("serving");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dashboard.setText("dashboard");
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });

        jButton4.setText("products");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton2)
                .addGap(15, 15, 15)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(dashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(dashboard)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout orderContainerLayout = new javax.swing.GroupLayout(orderContainer);
        orderContainer.setLayout(orderContainerLayout);
        orderContainerLayout.setHorizontalGroup(
            orderContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );
        orderContainerLayout.setVerticalGroup(
            orderContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(orderContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        customHooks.changeFrame(this, new inventory(this.myEmployee));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         customHooks.changeFrame(this, new servingPage(this.myEmployee));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        customHooks.changeFrame(this, new productPage(this.myEmployee));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
       customHooks.changeFrame(this, new dashboard(this.myEmployee));
    }//GEN-LAST:event_dashboardActionPerformed

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
            java.util.logging.Logger.getLogger(cashierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierPage(new employee()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel orderContainer;
    // End of variables declaration//GEN-END:variables
}
