/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Client;
import org.json.JSONException;
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dinha
 */
public class ClientView extends javax.swing.JFrame {
    private Client client;
    /**
     * Creates new form ClientView
     */
    public ClientView() {
        initComponents();
        this.setComboxCategory();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverconnection = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        serverconnectionip = new javax.swing.JTextField();
        serverconnectionbtn = new javax.swing.JButton();
        serverconnectionport = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loginpanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        loginra = new javax.swing.JTextField();
        loginsignupbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        loginbtn = new javax.swing.JButton();
        loginsenha = new javax.swing.JPasswordField();
        signuppanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        signupnome = new javax.swing.JTextField();
        signupbtn = new javax.swing.JButton();
        Descricao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        signupcategoria = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        signupra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        signupdescricao = new javax.swing.JTextField();
        signupsenha = new javax.swing.JPasswordField();
        signupcancelbtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        homepanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        homebtnlogout = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Endereço IP");

        serverconnectionbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serverconnectionbtn.setText("Conectar");
        serverconnectionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverconnectionbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Porta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(serverconnectionbtn)
                .addContainerGap(126, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(serverconnectionip)
            .addComponent(serverconnectionport)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverconnectionip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(serverconnectionport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(serverconnectionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conexão");

        javax.swing.GroupLayout serverconnectionLayout = new javax.swing.GroupLayout(serverconnection);
        serverconnection.setLayout(serverconnectionLayout);
        serverconnectionLayout.setHorizontalGroup(
            serverconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverconnectionLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        serverconnectionLayout.setVerticalGroup(
            serverconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverconnectionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        getContentPane().add(serverconnection, "card2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Login");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("UserName");

        loginsignupbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginsignupbtn.setText("SignUp");
        loginsignupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginsignupbtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Senha");

        loginbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loginra)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(loginsignupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addComponent(loginsenha)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginsignupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginpanelLayout = new javax.swing.GroupLayout(loginpanel);
        loginpanel.setLayout(loginpanelLayout);
        loginpanelLayout.setHorizontalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginpanelLayout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginpanelLayout.setVerticalGroup(
            loginpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );

        getContentPane().add(loginpanel, "card3");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nome");

        signupbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupbtn.setText("SignUp");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Descricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Descricao.setText("Descricao");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Categoria");

        signupcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ra");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Senha");

        signupdescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        signupcancelbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupcancelbtn.setText("Cancel");
        signupcancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupcancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(signupnome, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signupcancelbtn)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(signupdescricao)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signupcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(signupra)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signupsenha)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(signupbtn)
                        .addGap(105, 105, 105))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Descricao)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(signupcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signupra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signupsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(signupdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupcancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cadastro");

        javax.swing.GroupLayout signuppanelLayout = new javax.swing.GroupLayout(signuppanel);
        signuppanel.setLayout(signuppanelLayout);
        signuppanelLayout.setHorizontalGroup(
            signuppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addGroup(signuppanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signuppanelLayout.setVerticalGroup(
            signuppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signuppanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(signuppanel, "card2");

        homebtnlogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homebtnlogout.setText("Logout");
        homebtnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnlogoutActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Já está saindo?");
        jLabel14.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(homebtnlogout)
                .addGap(109, 109, 109))
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addComponent(homebtnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Olá");

        javax.swing.GroupLayout homepanelLayout = new javax.swing.GroupLayout(homepanel);
        homepanel.setLayout(homepanelLayout);
        homepanelLayout.setHorizontalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        homepanelLayout.setVerticalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(homepanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serverconnectionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverconnectionbtnActionPerformed
        if(!this.serverconnectionip.getText().equals("")&&
            !this.serverconnectionport.getText().equals("")){
            try{
                this.client = new Client(this);
                this.client.connect(this.serverconnectionip.getText(),
                                Integer.valueOf(this.serverconnectionport.getText()));
                this.serverconnection.setVisible(false);
                this.loginpanel.setVisible(true);
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "An error occurred while trying to connect to the server.","Connection error",
                    JOptionPane.OK_OPTION);
                System.out.println("Connection error");
            }
        }
    }//GEN-LAST:event_serverconnectionbtnActionPerformed

    private void loginsignupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginsignupbtnActionPerformed
        this.loginpanel.setVisible(false);
        this.signuppanel.setVisible(true);
    }//GEN-LAST:event_loginsignupbtnActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
           
        JSONObject jsonobj = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            if(!this.loginra.getText().isEmpty()&&
               !(this.loginsenha.getPassword().length == 0)){
                
                this.client.userName = this.loginra.getText();
                this.client.senha = new String(this.loginsenha.getPassword());
                
                data.put("ra", this.loginra.getText());
                data.put("senha", new String(this.loginsenha.getPassword()));
                
                jsonobj.put("parametros", data);
                jsonobj.put("operacao", "login");
                this.client.sendMessage(jsonobj);
                
                
            }else{
                if(this.loginra.getText().isEmpty()){
                    this.loginra.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                if(this.loginsenha.getPassword().length == 0){
                    this.loginsenha.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_loginbtnActionPerformed

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        // TODO add your handling code here:
        JSONObject jsonobj = new JSONObject();
        JSONObject data = new JSONObject();
        //private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        try {
            if(!this.signupnome.getText().isEmpty()&&
               this.signupra.getText().matches("\\d{7}") &&
               !this.signupdescricao.getText().isEmpty()&&
               !this.signupcategoria.getSelectedItem().toString().equals("none") &&
               !(this.signupsenha.getPassword().length == 0)){
                
                
                data.put("nome", this.signupnome.getText());
                data.put("ra", this.signupra.getText());
                data.put("descricao", this.signupdescricao.getText());
                data.put("categoria_id", Categoria.valueOf(String.valueOf(this.signupcategoria.getSelectedItem())).ordinal());
                data.put("senha", new String(this.signupsenha.getPassword()));
                
                jsonobj.put("parametros", data);
                jsonobj.put("operacao", "cadastrar");
                this.client.sendMessage(jsonobj);
                
            }else{
                if(!this.signupra.getText().matches("\\d{7}")){
                    JOptionPane.showMessageDialog(null, "Valor  RA incorreto", "Erro Cadastro",
                    JOptionPane.WARNING_MESSAGE);
                }
                if(this.signupnome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo NOME vazio", "Erro Cadastro",
                    JOptionPane.WARNING_MESSAGE);
                }
                if(this.signupdescricao.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo DESCRICAO vazio", "Erro Cadastro",
                    JOptionPane.WARNING_MESSAGE);
                }
                if(this.signupcategoria.getSelectedItem().toString().equals("none")){
                    JOptionPane.showMessageDialog(null, "Campo CATEGORIA vazio", "Erro Cadastro",
                    JOptionPane.WARNING_MESSAGE);
                }
                if(this.signupsenha.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Campo SENHA vazio", "Erro Cadastro",
                    JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            //show error window
            System.out.println("Erro cadastro");
        }
    }//GEN-LAST:event_signupbtnActionPerformed

    private void homebtnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnlogoutActionPerformed
        JSONObject jsonobj = new JSONObject();
        JSONObject data = new JSONObject();
        try{
            data.put("ra",this.client.userName);
            data.put("senha",this.client.senha);
            
            jsonobj.put("parametros", data);
            jsonobj.put("operacao", "logout");
            this.client.sendMessage(jsonobj);
            
        }catch(JSONException | IOException e){
            e.printStackTrace();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_homebtnlogoutActionPerformed

    private void signupcancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupcancelbtnActionPerformed
        this.signuppanel.setVisible(false);
        this.loginpanel.setVisible(true);
        
    }//GEN-LAST:event_signupcancelbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientView().setVisible(true);
                
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao;
    private javax.swing.JButton homebtnlogout;
    private javax.swing.JPanel homepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JTextField loginra;
    private javax.swing.JPasswordField loginsenha;
    private javax.swing.JButton loginsignupbtn;
    private javax.swing.JPanel serverconnection;
    private javax.swing.JButton serverconnectionbtn;
    private javax.swing.JTextField serverconnectionip;
    private javax.swing.JTextField serverconnectionport;
    private javax.swing.JButton signupbtn;
    private javax.swing.JButton signupcancelbtn;
    private javax.swing.JComboBox<String> signupcategoria;
    private javax.swing.JTextField signupdescricao;
    private javax.swing.JTextField signupnome;
    private javax.swing.JPanel signuppanel;
    private javax.swing.JTextField signupra;
    private javax.swing.JPasswordField signupsenha;
    // End of variables declaration//GEN-END:variables

    public void setServerconnectionVisibility(boolean state){
        this.serverconnection.setVisible(true);
    }
    
    public void setLoginpanelVisibility(boolean state) {
        this.serverconnection.setVisible(false);
        this.loginpanel.setVisible(state);
        this.signuppanel.setVisible(false);
        this.homepanel.setVisible(false);
    }
    
    public void setHomepanelVisibility(boolean state) {
        this.serverconnection.setVisible(false);
        this.loginpanel.setVisible(false);
        this.homepanel.setVisible(state);
    }
    
    public void setComboxCategory(){
        ArrayList<String> categorias = new ArrayList<>();
        for (Categoria categoria : Categoria.values())
            {
                categorias.add(String.valueOf(categoria));
            }
        categorias.add(0,"none");
        Object[] objects = categorias.toArray();
        //JComboBox signupcategoria = new JComboBox(objects);
        DefaultComboBoxModel model = new DefaultComboBoxModel(objects);
        signupcategoria.setModel( model );
        
    }

}