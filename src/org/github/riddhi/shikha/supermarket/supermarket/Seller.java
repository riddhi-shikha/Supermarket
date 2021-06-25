/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.riddhi.shikha.supermarket.supermarket;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.apache.commons.lang3.StringUtils;
import org.github.riddhi.shikha.supermarket.config.DBConfig;
import org.github.riddhi.shikha.supermarket.utility.Utilities;

public class Seller extends javax.swing.JFrame {

    /**
     * Creates new form Seller
     */
    
    static int uId = 0;
    static int userId = 0;
    
    static String uName = null; 
    static String img_name = null;
    static String img_url = null;
    
    public Seller(int u_id, String name) {
        initComponents();
        SellId.setVisible(false);
        jLogo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/github/riddhi/shikha/supermarket/images/shopping-bag.jpg"))
                                                    .getImage().getScaledInstance(jLogo.getWidth(), jLogo.getHeight(), Image.SCALE_SMOOTH)));
        
        uId = u_id;
        uName = name;
        jLabel6.setText("User: "+uName);
        getDateTime();
        getUsers();
        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search by ID, Name or Mobile")) {
                    search.setText("");
                    search.setForeground(Color.decode("#FF6600"));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (search.getText().isEmpty()) {
                    search.setForeground(Color.LIGHT_GRAY);
                    search.setText("Search by ID, Name or Mobile");
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
                        jLabel8.setText("Date: " + Utilities.getDateWithTime());
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
    
    public void getUsers() {
        try {
            String query  = null;
            con = DBConfig.getDBConnection();
            st = con.createStatement();
            if(!search.getText().equals("Search by ID, Name or Mobile")){
                if(StringUtils.isNumeric(search.getText())){
                    query = "SELECT u.u_id AS ID,u.name AS NAME, u.user_id AS USER_ID, u.role AS ROLE, u.gender AS GENDER,"
                                        +" u.contact AS CONTACT, u.address AS ADDRESS, u.photo AS PHOTO,"
                                        +" u.dob AS DOB, u.id_type AS ID_TYPE, u.id_number AS ID_NUM,"
                                        +" (SELECT NAME FROM user WHERE u_id = (SELECT CREATED_BY FROM user WHERE u_id = u.u_id))"
                                        + " AS CREATED_BY," 
                                        +" u.created_on AS CREATED_ON," 
                                        +" (SELECT NAME FROM user WHERE u_id = (SELECT MODIFIED_BY FROM user WHERE u_id = u.u_id))"
                                        + " AS MODIFIED_BY," 
                                        +" u.modified_on AS MODIFIED_ON" 
                                        +" FROM user u"
                                        + " WHERE u.u_id = "+Integer.parseInt(search.getText())+" ";
                }else{
                    query = "SELECT u.u_id AS ID,u.name AS NAME, u.user_id AS USER_ID, u.role AS ROLE, u.gender AS GENDER,"
                                        +" u.contact AS CONTACT, u.address AS ADDRESS, u.photo AS PHOTO,"
                                        +" u.dob AS DOB, u.id_type AS ID_TYPE, u.id_number AS ID_NUM,"
                                        +" (SELECT NAME FROM user WHERE u_id = (SELECT CREATED_BY FROM user WHERE u_id = u.u_id))"
                                        + " AS CREATED_BY," 
                                        +" u.created_on AS CREATED_ON," 
                                        +" (SELECT NAME FROM user WHERE u_id = (SELECT MODIFIED_BY FROM user WHERE u_id = u.u_id))"
                                        + " AS MODIFIED_BY," 
                                        +" u.modified_on AS MODIFIED_ON" 
                                        +" FROM user u"
                                        + " WHERE u.name LIKE '"+search.getText()+"%' OR u.contact = '"+search.getText()+"'";
                }
            }else{
                query = "SELECT u.u_id AS ID,u.name AS NAME, u.user_id AS USER_ID, u.role AS ROLE, u.gender AS GENDER,"
                                        +" u.contact AS CONTACT, u.address AS ADDRESS, u.photo AS PHOTO,"
                                        +" u.dob AS DOB, u.id_type AS ID_TYPE, u.id_number AS ID_NUM,"
                                        +" (SELECT NAME FROM user WHERE u_id = (SELECT CREATED_BY FROM user WHERE u_id = u.u_id))"
                                        + " AS CREATED_BY," 
                                        +" u.created_on AS CREATED_ON," 
                                        +" (SELECT NAME FROM user WHERE u_id = (SELECT MODIFIED_BY FROM user WHERE u_id = u.u_id))"
                                        + " AS MODIFIED_BY," 
                                        +" u.modified_on AS MODIFIED_ON" 
                                        +" FROM user u";
                                        
            }
            rs = st.executeQuery(query);
            SellerTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SellId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SellName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        GenderCb = new javax.swing.JComboBox();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SellerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        roleCB = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sellAdd = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPhoto = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        webcamBtn = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        SellDob = new com.toedter.calendar.JDateChooser();
        IdTypeCb = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SellIdNumber = new javax.swing.JTextField();
        Sellcontact = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLogo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 127, 198));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Manage Users");

        SellId.setEditable(false);
        SellId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SellId.setForeground(new java.awt.Color(255, 102, 0));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Name");

        SellName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SellName.setForeground(new java.awt.Color(255, 102, 0));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Role");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Gender");

        GenderCb.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        GenderCb.setForeground(new java.awt.Color(255, 102, 0));
        GenderCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-- Select --", "Male", "Female", "Others" }));

        AddBtn.setBackground(new java.awt.Color(255, 102, 0));
        AddBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add");
        AddBtn.setBorder(null);
        AddBtn.setBorderPainted(false);
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });

        EditBtn.setBackground(new java.awt.Color(255, 102, 0));
        EditBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditBtn.setText("Update");
        EditBtn.setBorder(null);
        EditBtn.setBorderPainted(false);
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
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

        DeleteBtn.setBackground(new java.awt.Color(255, 102, 0));
        DeleteBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBtn.setText("Delete");
        DeleteBtn.setBorder(null);
        DeleteBtn.setBorderPainted(false);
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });

        SellerTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        SellerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PASSWORD", "GENDER"
            }
        ));
        SellerTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        SellerTable.setRowHeight(25);
        SellerTable.setSelectionBackground(new java.awt.Color(255, 102, 0));
        SellerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SellerTable);

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("User List");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        roleCB.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        roleCB.setForeground(new java.awt.Color(255, 102, 0));
        roleCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Select --", "Seller", "Admin", }));

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 0));
        jLabel13.setText("Mobile");

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 0));
        jLabel14.setText("Address");

        sellAdd.setColumns(18);
        sellAdd.setRows(3);
        jScrollPane2.setViewportView(sellAdd);

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jPhoto.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jPhoto.setText("          ");
        jPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Take Photo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        webcamBtn.setBackground(new java.awt.Color(255, 102, 0));
        webcamBtn.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        webcamBtn.setForeground(new java.awt.Color(255, 255, 255));
        webcamBtn.setText("Webcam");
        webcamBtn.setBorder(null);
        webcamBtn.setBorderPainted(false);
        webcamBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webcamBtnMouseClicked(evt);
            }
        });
        webcamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webcamBtnActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        search.setForeground(java.awt.Color.lightGray);
        search.setText("Search by ID, Name or Mobile");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 102, 0));
        jLabel15.setText("DOB");

        SellDob.setForeground(new java.awt.Color(255, 102, 0));
        SellDob.setDateFormatString("dd-MM-yyyy");
        SellDob.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        IdTypeCb.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        IdTypeCb.setForeground(new java.awt.Color(255, 102, 0));
        IdTypeCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-- Select ID Type --", "Pan Card", "Driving Liecnse", "Voter ID", "Aadhar Card", "Passport", "Ration Card", "Narega Card", "Bank Passbook" }));

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 102, 0));
        jLabel16.setText("ID Type");

        jLabel17.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 0));
        jLabel17.setText("ID Number");

        SellIdNumber.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SellIdNumber.setForeground(new java.awt.Color(255, 102, 0));

        Sellcontact.setColumns(10);
        Sellcontact.setForeground(new java.awt.Color(255, 102, 0));
        try {
            Sellcontact.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########## ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Sellcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellcontactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(216, 216, 216)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(webcamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel13)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(SellName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Sellcontact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(GenderCb, 0, 249, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IdTypeCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SellDob, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roleCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(SellIdNumber))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(SellId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(75, 75, 75))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(roleCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SellIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(SellId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SellName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Sellcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(SellDob, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(webcamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Product");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Category");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sub-category");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)))
                    .addComponent(jLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        // TODO add your handling code here:
        if (SellName.getText().isEmpty() || GenderCb.getSelectedItem().toString().equals("-- Select --") 
                || roleCB.getSelectedItem().toString().equals("-- Select --") || Sellcontact.getText().isEmpty() 
                || sellAdd.getText().isEmpty()|| IdTypeCb.getSelectedItem().toString().equals("-- Select ID Type --")
                || SellIdNumber.getText().isEmpty() || SellDob.getDate().equals("")) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            try {
                //String userId = 
                con = DBConfig.getDBConnection();
                String query = "INSERT INTO user (name, user_id, role, password, gender, contact, address, photo,dob, id_type, id_number, created_on, created_by) "
                                + "values('"+SellName.getText()+"','"+Utilities.getUserId()+"','"+roleCB.getSelectedItem().toString()+"',"
                                + " '"+Utilities.getPassword()+"', '"+GenderCb.getSelectedItem().toString()+"', '"+Sellcontact.getText()+"',"
                                + " '"+sellAdd.getText()+"', '"+img_url+"', '"+Utilities.getDate(SellDob.getDate())+"',"
                                + " '"+IdTypeCb.getSelectedItem().toString()+"', '"+SellIdNumber.getText()+"',"
                                + " '"+Utilities.getSQLDateWithTime()+"',"+uId+" )";
                PreparedStatement ps = con.prepareStatement(query);

                int row = ps.executeUpdate();
                if(row == 1){
                    JOptionPane.showMessageDialog(this, "Successfully Added");
                    clearData();
                }else{
                    JOptionPane.showMessageDialog(this, "User Creation Failed");
                }
                
                con.close();
                getUsers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    
    
    private void SellerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellerTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) SellerTable.getModel();
        int Myindex = SellerTable.getSelectedRow();
        String uid = model.getValueAt(Myindex, 0).toString();
        SellId.setText(uid);
        SellName.setText(model.getValueAt(Myindex, 1).toString());
        roleCB.setSelectedItem(model.getValueAt(Myindex, 3).toString());
        GenderCb.setSelectedItem(model.getValueAt(Myindex, 4).toString());
        Sellcontact.setText(model.getValueAt(Myindex, 5).toString());
        sellAdd.setText(model.getValueAt(Myindex, 6).toString());
        img_url = model.getValueAt(Myindex, 7).toString();
        jPhoto.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/org/github/riddhi/shikha/supermarket/profile/USER_" +uid+".png"))
                                            .getImage().getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH)));
        LocalDate date =  LocalDate.parse(model.getValueAt(Myindex, 8).toString());
        SellDob.setDate(Utilities.localDateToDate(date));
        IdTypeCb.setSelectedItem(model.getValueAt(Myindex, 9).toString());
        SellIdNumber.setText(model.getValueAt(Myindex, 10).toString());
        
    }//GEN-LAST:event_SellerTableMouseClicked

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        clearData();
    }//GEN-LAST:event_ClearBtnMouseClicked

    public void clearData(){
        SellId.setText("");
        SellName.setText("");
        sellAdd.setText("");
        Sellcontact.setText("");
        
        jPhoto.setText("");
        roleCB.setSelectedItem("-- Select --");
        GenderCb.setSelectedItem("-- Select --");
        IdTypeCb.setSelectedItem("-- Select ID Type --");
        SellIdNumber.setText("");
        SellDob.setDate(null);
    }
    
    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        if (SellId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            int res  = JOptionPane.showConfirmDialog(this, "Do you want to delete", "Confirm", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                try {
                
                    con = DBConfig.getDBConnection();
                    String SId = SellId.getText();
                    String Query = "DELETE FROM user WHERE u_id = " + SId;
                    Statement st = con.createStatement();
                    st.executeUpdate(Query);
                    con.close();
                    getUsers();
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    clearData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                clearData();
            }
            
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
        if (SellId.getText().isEmpty() || SellName.getText().isEmpty() || GenderCb.getSelectedItem().toString().equals("-- Select --") 
                || roleCB.getSelectedItem().toString().equals("-- Select --") || Sellcontact.getText().isEmpty() 
                || sellAdd.getText().isEmpty() || IdTypeCb.getSelectedItem().toString().equals("-- Select ID Type --")
                || SellIdNumber.getText().isEmpty() || SellDob.getDate().equals("")) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            try {
                System.out.print(SellDob.getDate().toString());
                con = DBConfig.getDBConnection();
                String query = "UPDATE user SET name = '" + SellName.getText() + "'" 
                                    +", role ='"+roleCB.getSelectedItem().toString()+"' , gender = '" + GenderCb.getSelectedItem().toString() + "'"
                                    +", contact = '"+Sellcontact.getText()+"', address = '"+sellAdd.getText()+"', photo = '"+img_url+"'"
                                    +", dob = '"+Utilities.getDate(SellDob.getDate())+"', id_type = '"+IdTypeCb.getSelectedItem().toString()+"'"
                                    +", id_number = '"+SellIdNumber.getText()+"'"
                                    +", modified_on = '"+Utilities.getSQLDateWithTime()+"', modified_by = "+uId+" "
                                    + " WHERE u_id = " + SellId.getText();
                Statement st = con.createStatement();
                st.executeUpdate(query);
                con.close();
                JOptionPane.showMessageDialog(this, "Successfully Updated");
                clearData();
                getUsers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_EditBtnMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new Products(uId, uName).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new Category(uId,uName).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new SubCategory(uId, uName).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    JFrame window = new JFrame("Test webcam panel");
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        capturePhoto(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    public void capturePhoto(){
        
        try{
            Webcam webcam = Webcam.getDefault();
            webcam.open();
            //get Image
            BufferedImage image = webcam.getImage();
            Image img = image.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
            
            if(img_url == null){
                
                Connection con = DBConfig.getDBConnection();
                String query = "SELECT u_id FROM user ORDER BY u_id DESC";
                PreparedStatement ps = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = ps.executeQuery();

                if(rs.first()){
                    userId = rs.getInt(1);
                }

                //save image
                img_name = "USER_"+(userId+1)+".png";
                img_url = Utilities.IMAGEURL+""+img_name;
            }
            
            ImageIO.write(image, "PNG", new File(img_url));
            ImageIcon img_ico = new ImageIcon(img);
            jPhoto.setIcon(img_ico);
            window.setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void jPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPhotoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPhotoMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void webcamBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webcamBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_webcamBtnMouseClicked

    private void webcamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webcamBtnActionPerformed
        // TODO add your handling code here:
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        
    }//GEN-LAST:event_webcamBtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        getUsers();
    }//GEN-LAST:event_searchActionPerformed

    private void SellcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SellcontactActionPerformed

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
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller(uId,uName).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JComboBox GenderCb;
    private javax.swing.JComboBox IdTypeCb;
    private com.toedter.calendar.JDateChooser SellDob;
    private javax.swing.JTextField SellId;
    private javax.swing.JTextField SellIdNumber;
    private javax.swing.JTextField SellName;
    private javax.swing.JFormattedTextField Sellcontact;
    private javax.swing.JTable SellerTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPhoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox roleCB;
    private javax.swing.JTextField search;
    private javax.swing.JTextArea sellAdd;
    private javax.swing.JButton webcamBtn;
    // End of variables declaration//GEN-END:variables
}
