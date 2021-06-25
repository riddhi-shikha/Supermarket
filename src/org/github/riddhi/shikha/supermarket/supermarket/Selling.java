/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.riddhi.shikha.supermarket.supermarket;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.apache.commons.lang3.StringUtils;
import org.github.riddhi.shikha.supermarket.config.DBConfig;
import org.github.riddhi.shikha.supermarket.utility.Utilities;

public class Selling extends javax.swing.JFrame {

    /**
     * Creates new form Selling
     */
    
    static int uId = 0;
    static String uName = null; 
    
    public Selling(int u_id, String name) {
        initComponents();
        ProductTable.setVisible(false);
        jPanel3.setVisible(false);
        jLogo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/github/riddhi/shikha/supermarket/images/shopping-bag.jpg"))
                                                .getImage().getScaledInstance(jLogo.getWidth(), jLogo.getHeight(), Image.SCALE_SMOOTH)));
        
        uId = u_id;
        uName = name;
        jLabel15.setText("User: "+uName);
        //jLabel4.setText("Date: "+Utilities.getDateWithTime());
        getDateTime();
        getProduct();
        GetCat();
        
        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search by product ID or Name")) {
                    search.setText("");
                    search.setForeground(Color.decode("#FF6600"));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (search.getText().isEmpty()) {
                    search.setForeground(Color.LIGHT_GRAY);
                    search.setText("Search by product ID or Name");
                }
            }
        });
    }

    public final void getDateTime(){
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) { 
                        jLabel14.setText("Date: " + Utilities.getDateWithTime());
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    List<List<String>> prodList = new ArrayList<>();
    String invoiceNo;
    String cust_Mob;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Grdtotlbl = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ProdName = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTxt = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        ProdDiscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ProdQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ProdGst = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        custMob = new javax.swing.JFormattedTextField();
        ProdPrice = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Grdtotallbl = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tfTax = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tfPay = new javax.swing.JTextField();
        tfBal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLogo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 127, 188));

        Grdtotlbl.setBackground(new java.awt.Color(255, 255, 255));

        search.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        search.setForeground(java.awt.Color.lightGray);
        search.setText("Search by product ID or Name");
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Name");

        ProdName.setEditable(false);
        ProdName.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ProdName.setForeground(new java.awt.Color(255, 102, 0));

        AddBtn.setBackground(new java.awt.Color(255, 102, 0));
        AddBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add To Bill");
        AddBtn.setBorder(null);
        AddBtn.setBorderPainted(false);
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setBackground(new java.awt.Color(255, 102, 0));
        UpdateBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBtn.setText("Generate Bill");
        UpdateBtn.setBorder(null);
        UpdateBtn.setBorderPainted(false);
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(255, 102, 0));
        ClearBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("Clear");
        ClearBtn.setBorder(null);
        ClearBtn.setBorderPainted(false);
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Products List");

        BillTxt.setColumns(20);
        BillTxt.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        BillTxt.setRows(5);
        jScrollPane2.setViewportView(BillTxt);

        jSeparator1.setBackground(new java.awt.Color(255, 102, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 0));

        ProdDiscount.setEditable(false);
        ProdDiscount.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ProdDiscount.setForeground(new java.awt.Color(255, 102, 0));
        ProdDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Discount (%)");

        ProdQty.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ProdQty.setForeground(new java.awt.Color(255, 102, 0));
        ProdQty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Qunatity");

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Price");

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("GST (%)");

        ProdGst.setEditable(false);
        ProdGst.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        ProdGst.setForeground(new java.awt.Color(255, 102, 0));
        ProdGst.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setText("Cust Mobile");

        custMob.setColumns(10);
        custMob.setForeground(new java.awt.Color(255, 102, 0));
        try {
            custMob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########## ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        custMob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custMobActionPerformed(evt);
            }
        });

        ProdPrice.setEditable(false);
        ProdPrice.setForeground(new java.awt.Color(255, 102, 0));
        ProdPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        ProdPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total");

        Grdtotallbl.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Grdtotallbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Grdtotallbl.setText("0.00");
        Grdtotallbl.setEnabled(false);
        Grdtotallbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrdtotallblActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tax Amt.");

        tfTax.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tfTax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTax.setText("0.00");
        tfTax.setEnabled(false);
        tfTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaxActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total Cost");

        tfTotal.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotal.setText("0.00");
        tfTotal.setEnabled(false);
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Pay");

        tfPay.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tfPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPayFocusLost(evt);
            }
        });
        tfPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPayActionPerformed(evt);
            }
        });

        tfBal.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tfBal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfBal.setText("0.00");
        tfBal.setEnabled(false);
        tfBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBalActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Balance");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfTax)
                                .addComponent(Grdtotallbl)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(tfPay, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(tfBal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Grdtotallbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTax, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(19, 19, 19))
        );

        ProductTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE (Rs.)", "DISCOUNT (%)", "GST (%)", "Total (Rs.)"
            }
        ));
        ProductTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductTable.setRowHeight(25);
        ProductTable.setSelectionBackground(new java.awt.Color(255, 102, 0));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout GrdtotlblLayout = new javax.swing.GroupLayout(Grdtotlbl);
        Grdtotlbl.setLayout(GrdtotlblLayout);
        GrdtotlblLayout.setHorizontalGroup(
            GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(GrdtotlblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GrdtotlblLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GrdtotlblLayout.createSequentialGroup()
                                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))))
                    .addGroup(GrdtotlblLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GrdtotlblLayout.createSequentialGroup()
                                .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(GrdtotlblLayout.createSequentialGroup()
                                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GrdtotlblLayout.createSequentialGroup()
                                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(31, 31, 31)
                                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(custMob)
                                            .addGroup(GrdtotlblLayout.createSequentialGroup()
                                                .addComponent(ProdDiscount)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ProdGst, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(GrdtotlblLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(ProdQty, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GrdtotlblLayout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(118, 118, 118))
                                                    .addComponent(ProdPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GrdtotlblLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GrdtotlblLayout.setVerticalGroup(
            GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(GrdtotlblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrdtotlblLayout.createSequentialGroup()
                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(GrdtotlblLayout.createSequentialGroup()
                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(custMob, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(ProdQty, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(ProdGst, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(GrdtotlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GrdtotlblLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("X");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Logout");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILLING POINT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Grdtotlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 816, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grdtotlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void getProduct() {
        try {
            if(!search.getText().equals("Search by product ID or Name")){
                String query  = null;
                con = DBConfig.getDBConnection();
                
                if(StringUtils.isNumeric(search.getText())){
                    query = "SELECT prod_id AS ID, prod_name AS Name, quantity AS Qty, price AS Price, description AS Description, "
                                        + " discount AS Discount, gst AS GST FROM product "
                                        + "WHERE prod_id = "+Integer.parseInt(search.getText())+"";
                }else{
                    query = "SELECT prod_id AS ID, prod_name AS Name, quantity AS Qty, price AS Price, description AS Description, "
                                        + " discount AS Discount, gst AS GST FROM product "
                                        + "WHERE prod_name LIKE '"+search.getText()+"%'";
                }
                PreparedStatement ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                rs = ps.executeQuery(query);
                int numRows, numCols;
                rs.last();
                numRows = rs.getRow();
                numCols = rs.getMetaData().getColumnCount();
                rs.beforeFirst();
                if(numRows <= 0){
                    JOptionPane.showMessageDialog(this, "Product Not Found","Not Found",JOptionPane.ERROR_MESSAGE);
                }else{
                    ProductTable.setModel(DbUtils.resultSetToTableModel(rs));
                    ProductTable.setVisible(true);
                    JOptionPane.showMessageDialog(this, ProductTable,"Product List",JOptionPane.PLAIN_MESSAGE);
                    //jPanel3.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    int Prid, newQty;

    public void update() {
        newQty = AvailQty - Integer.valueOf(ProdQty.getText());
        try {
            
            con = DBConfig.getDBConnection();
            String Query = "UPDATE product SET quantity = " + newQty + "" + " WHERE prod_id = " + Prid;
            Statement Add = con.createStatement();
            Add.executeUpdate(Query);
            //JOptionPane.showMessageDialog(this, "Product Updated");
            //getProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GetCat() {
        try {
            
            con = DBConfig.getDBConnection();
            st = con.createStatement();
            String query = "SELECT * FROM category";
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Mycat = rs.getString("cat_name");
                //CatCb.addItem(Mycat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Double Uprice = 0.0, ProdTot = 0.0, GrdTotal = 0.0, tax = 0.0, discount = 0.0, totalCost = 0.0;
    int AvailQty = 0;
    
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    public final void clearData(){
        ProdQty.setText("");
        ProdPrice.setText("");
        ProdName.setText("");
        ProdDiscount.setText("");
        ProdGst.setText("");
        search.setForeground(Color.LIGHT_GRAY);
        search.setText("Search by product ID or Name");
    }
    
    int i = 0;
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBalActionPerformed

    private void custMobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custMobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custMobActionPerformed

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        //BillId.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        try {
            
            invoice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_UpdateBtnMouseClicked
   
    public void invoice(){
        
        try {
            String[][] array = prodList.stream()
                    .map(l -> l.stream().toArray(String[]::new))
                    .toArray(String[][]::new);
            invoiceNo = Utilities.getInvoiceNo();
            cust_Mob  = custMob.getText();
            
            String bill =    "\t         SHOPPING BAG SUPERMARKET \t\t\n"
                            +"\t                 143,Park Street M.P Nagar \t\n"
                            +"\t             BHOPAL, MADHYA PRADESH \t\n"
                            +"\t                     PHONE: 99999 99999\t\n"
                            +"\t               GSTIN: 33AAAGP0685F1ZH \t\n\n\n";
            bill = bill+ "Bill No: "+invoiceNo+"\t\t\t                  Date:"+Utilities.getDateWithTime()+"\n";
            bill = bill+"-------------------------------------------------------------------------------------------------------------------------------\n";
            bill = bill+"Item\t\tQty\tRate\tDiscount\tAmount\t\n";
            bill = bill+"-------------------------------------------------------------------------------------------------------------------------------\n";
            
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[0].length; j++){
                    bill = bill +""+array[i][j]+"\t"; 
                }
                bill = bill+"\n";
            }
            bill = bill+"\n\n";
            bill = bill+"-------------------------------------------------------------------------------------------------------------------------------\n";
            bill = bill+"SubTotal\t\t"+array.length+"\t\t                 "+Grdtotallbl.getText()+"\t\n\n";
            bill = bill+"-------------------------------------------------------------------------------------------------------------------------------\n";
            
            
            bill = bill+"Tax Amt.\t\t\t\t                 "+tfTax.getText()+"\t\n\n";
            bill = bill+"-------------------------------------------------------------------------------------------------------------------------------\n";
            
            
            bill = bill+"Total\t\t\t\t                 "+tfTotal.getText()+"\t\n";
            bill = bill+"Pay\t\t\t\t                 "+tfPay.getText()+"\t\n";
            bill = bill+"Balance\t\t\t\t                 "+tfBal.getText()+"\t\n";
            bill = bill+"-------------------------------------------------------------------------------------------------------------------------------\n";
            bill = bill+"\t\t\t\t\tE & O.E\n";
            bill = bill+"\t\t        Thank You! \t\t\n";
            printBill(bill);
        } catch (Exception ex) {
            Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void printBill(String billl) {
        new Bill(billl,uName).setVisible(true);
        this.dispose();
    }
    
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed
    
    
    
    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        if (ProdQty.getText().isEmpty() || Integer.valueOf(ProdQty.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity.");
        } else if (AvailQty <= Integer.valueOf(ProdQty.getText())) {
            JOptionPane.showMessageDialog(this, "Out of Stock","Stock Error",JOptionPane.ERROR_MESSAGE);
        } else {
            i++;
            ProdTot = Uprice * Double.valueOf(ProdQty.getText());
            ProdTot = ProdTot - ((ProdTot * Double.valueOf(ProdDiscount.getText()))/100);
            tax += (ProdTot * Double.valueOf(ProdGst.getText()))/100;
            GrdTotal = GrdTotal + ProdTot;
            StringBuilder sb = new StringBuilder(ProdName.getText());

                int j = 0;
                while ((j = sb.indexOf(" ", j + 15)) != -1) {
                    sb.replace(j, j + 1, "\n");
            }
            if (i == 1) {
                BillTxt.setText(
                    BillTxt.getText()   
                            + " =============================== SUPERMARKET ==============================\n"
                            + " S.no      Item Name                                                       Qty             Rate                          Amount(Rs)\n"
                            + " =========================================================================\n"
                            + " "+String.format("%03d",i)+"      "+ProdName.getText() + "\t\t    " +String.format("%5s", ProdQty.getText())  
                            + " \t"+String.format("%.2f", Uprice) + "\t      " + String.format("%.2f", ProdTot) + "\n");
            } else {
                BillTxt.setText(
                    BillTxt.getText()
                            + " "+String.format("%03d",i)+"      "+ProdName.getText() + "\t\t   " + String.format("%5s", ProdQty.getText())
                            + " \t"+ String.format("%.2f", Uprice) + "\t      " + String.format("%.2f", ProdTot) + "\n");
            }
            Grdtotallbl.setText(String.format("₹ %.2f", GrdTotal));
            tfTax.setText(String.format("₹ %.2f", tax));
            totalCost = GrdTotal+tax;
            tfTotal.setText(String.format("₹ %.2f", totalCost));
            
            addProdList();
            update();
            clearData();
        }
    }//GEN-LAST:event_AddBtnMouseClicked
    
    public final void addProdList(){
            List<String> ls = new ArrayList<>();
            
            ls.add(ProdName.getText());
            ls.add(ProdQty.getText().toString());
            ls.add(ProdPrice.getText().toString());
            ls.add(ProdDiscount.getText().toString());
            //ls.add(ProdGst.getText().toString());
            ls.add(ProdTot.toString());
            prodList.add(ls);
        
    }
    
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        getProduct();
    }//GEN-LAST:event_searchActionPerformed

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFocusLost

    private void GrdtotallblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrdtotallblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GrdtotallblActionPerformed

    private void tfTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTaxActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void tfPayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPayFocusLost
        // TODO add your handling code here:
        double bal = Double.parseDouble(tfPay.getText()) - totalCost;
        tfBal.setText(String.format("₹ %.2f", bal));
        tfPay.setText(String.format("₹ %.2f", Double.parseDouble(tfPay.getText())));
    }//GEN-LAST:event_tfPayFocusLost

    private void tfPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPayActionPerformed
        // TODO add your handling code here:
        double bal = Double.parseDouble(tfPay.getText()) - totalCost;
        tfBal.setText(String.format("₹ %.2f", bal));
        tfPay.setText(String.format("₹ %.2f", Double.parseDouble(tfPay.getText())));
    }//GEN-LAST:event_tfPayActionPerformed

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        int Myindex = ProductTable.getSelectedRow();
        Prid = Integer.valueOf(model.getValueAt(Myindex, 0).toString());

        ProdName.setText(model.getValueAt(Myindex, 1).toString());
        AvailQty = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        ProdPrice.setText(String.format("%.2f",Double.parseDouble(model.getValueAt(Myindex, 3).toString())));
        Uprice = Double.valueOf(model.getValueAt(Myindex, 3).toString());
        ProdDiscount.setText(model.getValueAt(Myindex, 5).toString());
        ProdGst.setText(model.getValueAt(Myindex, 6).toString());
    }//GEN-LAST:event_ProductTableMouseClicked

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling(uId,uName).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextArea BillTxt;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTextField Grdtotallbl;
    private javax.swing.JPanel Grdtotlbl;
    private javax.swing.JTextField ProdDiscount;
    private javax.swing.JTextField ProdGst;
    private javax.swing.JTextField ProdName;
    private javax.swing.JFormattedTextField ProdPrice;
    private javax.swing.JTextField ProdQty;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JFormattedTextField custMob;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField tfBal;
    private javax.swing.JTextField tfPay;
    private javax.swing.JTextField tfTax;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
