
package cafe_shop;

import backend.customerBackend;
import backend.orderBackend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import types.employee;
import types.order;
import types.payment;
import utils.customHooks;


public class servingPage extends javax.swing.JFrame {
    private employee myEmployee;
    private orderBackend orderClass = new orderBackend();
    private customerBackend customerBackend = new customerBackend();
    
    public servingPage(employee params) {
        initComponents();
        this.myEmployee = params;
        
        
        ArrayList<order> orders = orderClass.getOrders("serving", "to claim");
        
        orderContainer.setLayout(new GridLayout(0, 1, 15, 15)); // Increased spacing
        orderContainer.setBackground(new Color(230, 230, 230)); // Light background

        for(order currrentOrder : orders) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
            productPanel.setPreferredSize(new Dimension(200, 130));
            productPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            productPanel.setBackground(new Color(240, 240, 240));
            
            JLabel customerText = new JLabel("Customer: " + customerBackend.getName(currrentOrder.getCustomerId()));
            JLabel statusText = new JLabel("Customer: " + currrentOrder.getOrderStatus());
            JLabel orderIdText = new JLabel("Order ID: " + currrentOrder.getOrderId());
            JLabel dateText = new JLabel("Date: " + currrentOrder.getOrderDate());
           

            Font textFont = new Font("Arial", Font.BOLD, 14);
            customerText.setFont(textFont);
            orderIdText.setFont(new Font("Arial", Font.PLAIN, 13));
            dateText.setFont(new Font("Arial", Font.PLAIN, 13));
            

            JButton toClaim = new JButton("to claim");
            JButton completed = new JButton("completed");

            toClaim.setPreferredSize(new Dimension(220, 30));
            completed.setPreferredSize(new Dimension(220, 30));

            toClaim.setBackground(new Color(100, 200, 100));
            completed.setBackground(new Color(100, 100, 200));
            toClaim.setForeground(Color.WHITE);
            completed.setForeground(Color.WHITE);
            toClaim.setBorderPainted(false);
            completed.setBorderPainted(false);
            toClaim.setOpaque(true);
      
            
            
            toClaim.addActionListener(e -> {
                orderClass.changeStatus(currrentOrder.getOrderId(), "to claim");
                customHooks.changeFrame(this, new servingPage(myEmployee));
            });
            
       
            

            completed.addActionListener(e -> {
                orderClass.changeStatus(currrentOrder.getOrderId(), "completed");
                customHooks.changeFrame(this, new servingPage(myEmployee));
            });

        

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
            
            if(currrentOrder.getOrderStatus().equals("serving"))
            {
               buttonPanel.add(toClaim); 
            }
            else
            {
                 buttonPanel.add(completed); 
            }
            
    
            buttonPanel.setOpaque(false);

            productPanel.add(customerText);
            productPanel.add(statusText);
            productPanel.add(orderIdText);
            productPanel.add(dateText);
          
            productPanel.add(buttonPanel);

            orderContainer.add(productPanel);
        }

        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderContainerLayout = new javax.swing.GroupLayout(orderContainer);
        orderContainer.setLayout(orderContainerLayout);
        orderContainerLayout.setHorizontalGroup(
            orderContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        orderContainerLayout.setVerticalGroup(
            orderContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(orderContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       customHooks.changeFrame(this, new cashierPage(myEmployee));
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new servingPage(new employee()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel orderContainer;
    // End of variables declaration//GEN-END:variables
}
