/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Annas
 */
public class MainApps extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model;
    
    public MainApps() {
        initComponents();
        tampilTabelMaskapai();
        tampilTabelKota();
        tampilTabelBandara();
        tampilTabelPesawat();
        tampilTabelPenerbangan();
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnCreate.setEnabled(true);
    }
    public void tampilTabelKota(){
        conn=DBConnector.ConnectToDB("TransportasiUmum");
        try {
        String[]title = {"Kode Kota","Nama Kota"};

        String sql="SELECT * FROM ViewKota";
        model=new DefaultTableModel(null,title);
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        String[]data = new String[2];

        while(rs.next()){
            data[0] = rs.getString("IdKota");
            data[1] = rs.getString("NamaKota");
     
            model.addRow(data);
        }
        tableKota.setModel(model);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tampilTabelBandara(){
        conn=DBConnector.ConnectToDB("TransportasiUmum");
        try {
        String[]title = {"Kode Bandara","Nama Bandara","Jenis Bandara", "Jumlah Gate","Jumlah Terminal"};

        String sql="SELECT * FROM ViewBandara";
        model=new DefaultTableModel(null,title);
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        String[]data = new String[6];

        while(rs.next()){
            data[0] = rs.getString("IdBandara");
            data[1] = rs.getString("NamaBandara");
            data[2] = rs.getString("JenisBandara");
            data[3] = rs.getString("Gate");
            data[4] = rs.getString("Terminal");
            data[5] = rs.getString("NamaKota");
            
            model.addRow(data);
        }
        tableBandara.setModel(model);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tampilTabelPesawat(){
        conn=DBConnector.ConnectToDB("TransportasiUmum");
        try {
        String[]title = {"No Lambung","Jenis Pesawat","Bagasi Reguler(kg)"};

        String sql="SELECT * FROM ViewPesawat";
        model=new DefaultTableModel(null,title);
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        String[]data = new String[3];

        while(rs.next()){
            data[0] = rs.getString("NoLambung");
            data[1] = rs.getString("JenisPesawat");
            data[2] = rs.getString("KapasitasBagasiReg");
            
            model.addRow(data);
        }
        tablePesawat.setModel(model);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tampilTabelMaskapai(){
        conn=DBConnector.ConnectToDB("TransportasiUmum");
        try {
        String[]title = {"Kode Maskapai","Nama Maskapai","Nomor Telpon","Kepemilikan","Tanggal Berdiri"};

        String sql="SELECT * FROM ViewPerusahaan";
        model=new DefaultTableModel(null,title);
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        String[]data = new String[5];

        while(rs.next()){
            data[0] = rs.getString("IdPerusahaan");
            data[1] = rs.getString("NamaPerusahaan");
            data[2] = rs.getString("NomorTelp");
            data[3] = rs.getString("Pemilik");
            data[4] = rs.getString("TahunBerdiri");
     
            model.addRow(data);
        }
        tableMaskapai.setModel(model);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tampilTabelPenerbangan(){
        conn=DBConnector.ConnectToDB("TransportasiUmum");
        try {
        String[]title = {"Id Penerbangan","Tanggal Berangkat","Boarding","Berangkat","Tanggal Tiba", "Tiba", "Tarif Dewasa", "Tarif Anak", "Jenis Rute", "Dari", "Ke","Maskapai", "Pesawat"};

        String sql="SELECT * FROM ViewPenerbangan";
        model=new DefaultTableModel(null,title);
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        String[]data = new String[13];

        while(rs.next()){
            data[0] = rs.getString("IdPenerbangan");
            data[1] = rs.getString("TglBerangkat");
            data[2] = rs.getString("WaktuBoarding");
            data[3] = rs.getString("WaktuBerangkat");
            data[4] = rs.getString("TglTiba");
            data[5] = rs.getString("WaktuTiba"); 
            data[6] = rs.getString("TarifDewasa");
            data[7] = rs.getString("TarifAnak");
            data[8] = rs.getString("JenisRute");
            data[9] = rs.getString("DariKota");
            data[10] = rs.getString("KeKota");
            data[11] = rs.getString("Maskapai");
            data[12] = rs.getString("Pesawat");
            model.addRow(data);
        }
        tablePenerbangan.setModel(model);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTab = new javax.swing.JTabbedPane();
        panelPenerbangan = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtBoarding = new javax.swing.JTextField();
        txtBerangkat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        datBerangkat = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePenerbangan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTiba = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDewasa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAnak = new javax.swing.JTextField();
        optDirect = new javax.swing.JRadioButton();
        optIndirect = new javax.swing.JRadioButton();
        datTiba = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDari = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtKe = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPesawat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMaskapai = new javax.swing.JTextField();
        panelMaskapai = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMaskapai = new javax.swing.JTable();
        panelKota = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableKota = new javax.swing.JTable();
        panelBandara = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBandara = new javax.swing.JTable();
        panelPesawat = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePesawat = new javax.swing.JTable();
        labelTitle = new javax.swing.JLabel();
        btnReload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelPenerbangan.setBackground(new java.awt.Color(255, 255, 255));

        txtId.setText("IdPenerbangan");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtBoarding.setText("Waktu Boarding");

        txtBerangkat.setText("Waktu Berangkat");
        txtBerangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBerangkatActionPerformed(evt);
            }
        });

        jLabel1.setText("IdPenerbangan");

        jLabel2.setText("Boarding");

        jLabel3.setText("Berangkat");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        datBerangkat.setDateFormatString("yyyy-MM-d");
        datBerangkat.setMaxSelectableDate(new java.util.Date(253370739669000L));
        datBerangkat.setMinSelectableDate(new java.util.Date(631126869000L));

        tablePenerbangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePenerbangan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablePenerbangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerbanganMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePenerbangan);

        jLabel4.setText("Tiba");

        txtTiba.setText("Waktu Tiba");
        txtTiba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTibaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tarif Dewasa");

        txtDewasa.setText("Tarif Dewasa");
        txtDewasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDewasaActionPerformed(evt);
            }
        });

        jLabel6.setText("Tarif Anak");

        txtAnak.setText("Tarif Anak");
        txtAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnakActionPerformed(evt);
            }
        });

        optDirect.setText("Direct");
        optDirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDirectActionPerformed(evt);
            }
        });

        optIndirect.setText("Indirect");
        optIndirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optIndirectActionPerformed(evt);
            }
        });

        datTiba.setDateFormatString("yyyy-MM-d");
        datTiba.setMaxSelectableDate(new java.util.Date(253370739669000L));
        datTiba.setMinSelectableDate(new java.util.Date(631126869000L));

        jLabel7.setText("Tanggal Berangkat");

        jLabel8.setText("Tanggal Tiba");

        jLabel9.setText("Dari");

        txtDari.setText("Dari Kota");
        txtDari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDariActionPerformed(evt);
            }
        });

        jLabel13.setText("Ke");

        txtKe.setText("Ke Kota");
        txtKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeActionPerformed(evt);
            }
        });

        jLabel14.setText("Pesawat");

        txtPesawat.setText("Pesawat");
        txtPesawat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesawatActionPerformed(evt);
            }
        });

        jLabel15.setText("Maskapai");

        txtMaskapai.setText("Maskapai");
        txtMaskapai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaskapaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPenerbanganLayout = new javax.swing.GroupLayout(panelPenerbangan);
        panelPenerbangan.setLayout(panelPenerbanganLayout);
        panelPenerbanganLayout.setHorizontalGroup(
            panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPenerbanganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelPenerbanganLayout.createSequentialGroup()
                        .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(txtDewasa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(35, 35, 35)
                                            .addComponent(txtBoarding, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtTiba, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPenerbanganLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAnak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtKe, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(optIndirect)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(optDirect)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datTiba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datBerangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelPenerbanganLayout.createSequentialGroup()
                                        .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPesawat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 47, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        panelPenerbanganLayout.setVerticalGroup(
            panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPenerbanganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtDewasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(datBerangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBoarding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(txtAnak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(datTiba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(txtMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesawat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPenerbanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(optIndirect, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optDirect, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        mainTab.addTab("Penerbangan", panelPenerbangan);

        tableMaskapai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableMaskapai);

        javax.swing.GroupLayout panelMaskapaiLayout = new javax.swing.GroupLayout(panelMaskapai);
        panelMaskapai.setLayout(panelMaskapaiLayout);
        panelMaskapaiLayout.setHorizontalGroup(
            panelMaskapaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        panelMaskapaiLayout.setVerticalGroup(
            panelMaskapaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        mainTab.addTab("Maskapai", panelMaskapai);

        tableKota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableKota);

        javax.swing.GroupLayout panelKotaLayout = new javax.swing.GroupLayout(panelKota);
        panelKota.setLayout(panelKotaLayout);
        panelKotaLayout.setHorizontalGroup(
            panelKotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        panelKotaLayout.setVerticalGroup(
            panelKotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        mainTab.addTab("Kota", panelKota);

        tableBandara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableBandara);

        javax.swing.GroupLayout panelBandaraLayout = new javax.swing.GroupLayout(panelBandara);
        panelBandara.setLayout(panelBandaraLayout);
        panelBandaraLayout.setHorizontalGroup(
            panelBandaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        panelBandaraLayout.setVerticalGroup(
            panelBandaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        mainTab.addTab("Bandara", panelBandara);

        tablePesawat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablePesawat);

        javax.swing.GroupLayout panelPesawatLayout = new javax.swing.GroupLayout(panelPesawat);
        panelPesawat.setLayout(panelPesawatLayout);
        panelPesawatLayout.setHorizontalGroup(
            panelPesawatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        panelPesawatLayout.setVerticalGroup(
            panelPesawatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        mainTab.addTab("Pesawat", panelPesawat);

        labelTitle.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        labelTitle.setText("CRUD Penerbangan");

        btnReload.setText("Muat Ulang Tabel");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(mainTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTab))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        tampilTabelMaskapai();
        tampilTabelKota();
        tampilTabelBandara();
        tampilTabelPesawat();
        tampilTabelPenerbangan();
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnCreate.setEnabled(true);
    }//GEN-LAST:event_btnReloadActionPerformed

    private void txtPesawatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesawatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesawatActionPerformed

    private void txtKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeActionPerformed

    private void txtDariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDariActionPerformed

    private void optIndirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optIndirectActionPerformed
        optDirect.setSelected(false);
    }//GEN-LAST:event_optIndirectActionPerformed

    private void optDirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDirectActionPerformed
        optIndirect.setSelected(false);
    }//GEN-LAST:event_optDirectActionPerformed

    private void txtAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnakActionPerformed

    private void txtDewasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDewasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDewasaActionPerformed

    private void txtTibaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTibaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTibaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(
            txtId.getText() == ("") ||
            txtBerangkat.getText() == ("")||
            txtBoarding.getText() ==("")||
            txtTiba.getText() ==("")||
            txtDewasa.getText() ==("")||
            txtAnak.getText() ==("")||
            txtDari.getText() ==("")||
            txtKe.getText() == ("")||
            txtMaskapai.getText() ==("")||
            txtPesawat.getText() == ("")||
            (optDirect.isSelected() == false && optIndirect.isSelected() == false ) == true||
            (optDirect.isSelected() == true && optIndirect.isSelected() == true) == true||
            (((JTextField)datTiba.getDateEditor().getUiComponent()).getText()) == "" || 
            (((JTextField)datBerangkat.getDateEditor().getUiComponent()).getText()) == ""){
            JOptionPane.showMessageDialog(null, "Data belum lengkap!","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                String txtDirect = null;
                if(optDirect.isSelected() == false && optIndirect.isSelected() == true ) txtDirect = "Indirect";  
                if(optDirect.isSelected() == true && optIndirect.isSelected() == false ) txtDirect = "Direct"; 
                conn=DBConnector.ConnectToDB("TransportasiUmum");
                String sql = "UPDATE ViewPenerbangan SET "
                            + "TglBerangkat = ?, "
                            + "WaktuBoarding = ?, "
                            + "WaktuBerangkat = ?, "
                            + "TglTiba = ?, "
                            + "WaktuTiba = ?, "
                            + "TarifDewasa = ?, "
                            + "TarifAnak = ?, "
                            + "JenisRute = ?, "
                            + "DariKota = ?, "
                            + "KeKota = ?, "
                            + "Maskapai = ?, "
                            + "Pesawat = ? "
                            + "WHERE IdPenerbangan = ?;"
                            ;
                pst=conn.prepareStatement(sql);
                pst.setString(1,(((JTextField)datBerangkat.getDateEditor().getUiComponent()).getText()).toString());
                pst.setString(2,txtBoarding.getText());
                pst.setString(3,txtBerangkat.getText());
                pst.setString(4,(((JTextField)datTiba.getDateEditor().getUiComponent()).getText()).toString());
                pst.setString(5,txtTiba.getText());
                pst.setString(6,txtDewasa.getText());
                pst.setString(7,txtAnak.getText().toString());
                pst.setString(8,txtDirect.toString());
                pst.setString(9,txtDari.getText().toUpperCase());
                pst.setString(10,txtKe.getText().toUpperCase());
                pst.setString(11,txtMaskapai.getText().toUpperCase());
                pst.setString(12,txtPesawat.getText().toUpperCase());
                pst.setString(13,txtId.getText().toUpperCase());
                pst.execute();     
                tampilTabelPenerbangan();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }               
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if(
            txtId.getText() == ("") ||
            txtBerangkat.getText() == ("")||
            txtBoarding.getText() ==("")||
            txtTiba.getText() ==("")||
            txtDewasa.getText() ==("")||
            txtAnak.getText() ==("")||
            txtDari.getText() ==("")||
            txtKe.getText() == ("")||
            txtMaskapai.getText() ==("")||
            txtPesawat.getText() == ("")||
            (optDirect.isSelected() == false && optIndirect.isSelected() == false ) == true||
            (optDirect.isSelected() == true && optIndirect.isSelected() == true) == true||
            (((JTextField)datTiba.getDateEditor().getUiComponent()).getText()) == "" || 
            (((JTextField)datBerangkat.getDateEditor().getUiComponent()).getText()) == ""){
            JOptionPane.showMessageDialog(null, "Data belum lengkap!","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                String txtDirect = null;
                if(optDirect.isSelected() == false && optIndirect.isSelected() == true ) txtDirect = "Indirect";  
                if(optDirect.isSelected() == true && optIndirect.isSelected() == false ) txtDirect = "Direct"; 
                conn=DBConnector.ConnectToDB("TransportasiUmum");
                String sql = "INSERT INTO ViewPenerbangan(IdPenerbangan, TglBerangkat, WaktuBoarding, WaktuBerangkat, TglTiba, WaktuTiba, TarifDewasa, TarifAnak, JenisRute, DariKota, KeKota, Maskapai, Pesawat)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);"
                            ;
                pst=conn.prepareStatement(sql);
                pst.setString(1,txtId.getText().toUpperCase());
                pst.setString(2,(((JTextField)datBerangkat.getDateEditor().getUiComponent()).getText()).toString());
                pst.setString(3,txtBoarding.getText());
                pst.setString(4,txtBerangkat.getText());
                pst.setString(5,(((JTextField)datTiba.getDateEditor().getUiComponent()).getText()).toString());
                pst.setString(6,txtTiba.getText());
                pst.setString(7,txtDewasa.getText());
                pst.setString(8,txtAnak.getText().toString());
                pst.setString(9,txtDirect.toString());
                pst.setString(10,txtDari.getText().toUpperCase());
                pst.setString(11,txtKe.getText().toUpperCase());
                pst.setString(12,txtMaskapai.getText().toUpperCase());
                pst.setString(13,txtPesawat.getText().toUpperCase());
                pst.execute();     
                tampilTabelPenerbangan();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }               
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtId.enable();
        txtId.setText("");
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnCreate.setEnabled(true);
        txtBerangkat.setText("");
        txtBoarding.setText("");
        txtTiba.setText("");
        txtDewasa.setText("");
        txtAnak.setText("");
        txtDari.setText("");
        txtKe.setText("");
        txtMaskapai.setText("");
        txtPesawat.setText("");
        optDirect.setSelected(false);
        optIndirect.setSelected(false);
        
        ((JTextField)datBerangkat.getDateEditor().getUiComponent()).setText("");
        ((JTextField)datTiba.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(
            txtId.getText() == ("") ||
            txtBerangkat.getText() == ("")||
            txtBoarding.getText() ==("")||
            txtTiba.getText() ==("")||
            txtDewasa.getText() ==("")||
            txtAnak.getText() ==("")||
            txtDari.getText() ==("")||
            txtKe.getText() == ("")||
            txtMaskapai.getText() ==("")||
            txtPesawat.getText() == ("")||
            (optDirect.isSelected() == false && optIndirect.isSelected() == false ) == true||
            (optDirect.isSelected() == true && optIndirect.isSelected() == true) == true||
            (((JTextField)datTiba.getDateEditor().getUiComponent()).getText()) == "" || 
            (((JTextField)datBerangkat.getDateEditor().getUiComponent()).getText()) == ""){
            JOptionPane.showMessageDialog(null, "Data belum lengkap!","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                String txtDirect = null;
                if(optDirect.isSelected() == false && optIndirect.isSelected() == true ) txtDirect = "Indirect";  
                if(optDirect.isSelected() == true && optIndirect.isSelected() == false ) txtDirect = "Direct"; 
                conn=DBConnector.ConnectToDB("TransportasiUmum");
                String sql = "DELETE FROM ViewPenerbangan "
                            + "WHERE IdPenerbangan = ?;"
                            ;
                pst=conn.prepareStatement(sql);
                pst.setString(1,txtId.getText());
                pst.execute();     
                tampilTabelPenerbangan();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }               
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtBerangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBerangkatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBerangkatActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtMaskapaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaskapaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaskapaiActionPerformed

    private void tablePenerbanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerbanganMouseClicked
        conn=DBConnector.ConnectToDB("TransportasiUmum");
        try{
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnCreate.setEnabled(false);
            int row = tablePenerbangan.getSelectedRow();
            String Table_click=(tablePenerbangan.getModel().getValueAt(row, 0).toString());
            txtId.disable();
            String sql = "SELECT * FROM ViewPenerbangan WHERE IdPenerbangan='"+Table_click+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()) {
                txtId.setText(rs.getString("IdPenerbangan"));
                txtBerangkat.setText(rs.getString("WaktuBerangkat"));
                txtBoarding.setText(rs.getString("WaktuBoarding"));
                txtTiba.setText(rs.getString("WaktuTiba"));
                txtDewasa.setText(rs.getString("TarifDewasa"));
                txtAnak.setText(rs.getString("TarifAnak"));
                txtDari.setText(rs.getString("DariKota"));
                txtKe.setText(rs.getString("KeKota"));
                txtMaskapai.setText(rs.getString("Maskapai"));
                txtPesawat.setText(rs.getString("Pesawat"));
                String opt = rs.getString("JenisRute");
                if("Direct".equals(opt)){
                    optDirect.setSelected(true);
                    optIndirect.setSelected(false);
                }else if("Indirect".equals(opt)){
                    optIndirect.setSelected(true);
                    optDirect.setSelected(false);
                }
                ((JTextField)datBerangkat.getDateEditor().getUiComponent()).setText(rs.getString("TglBerangkat"));
                ((JTextField)datTiba.getDateEditor().getUiComponent()).setText(rs.getString("TglTiba"));
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tablePenerbanganMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApps().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser datBerangkat;
    private com.toedter.calendar.JDateChooser datTiba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTabbedPane mainTab;
    private javax.swing.JRadioButton optDirect;
    private javax.swing.JRadioButton optIndirect;
    private javax.swing.JPanel panelBandara;
    private javax.swing.JPanel panelKota;
    private javax.swing.JPanel panelMaskapai;
    private javax.swing.JPanel panelPenerbangan;
    private javax.swing.JPanel panelPesawat;
    private javax.swing.JTable tableBandara;
    private javax.swing.JTable tableKota;
    private javax.swing.JTable tableMaskapai;
    private javax.swing.JTable tablePenerbangan;
    private javax.swing.JTable tablePesawat;
    private javax.swing.JTextField txtAnak;
    private javax.swing.JTextField txtBerangkat;
    private javax.swing.JTextField txtBoarding;
    private javax.swing.JTextField txtDari;
    private javax.swing.JTextField txtDewasa;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKe;
    private javax.swing.JTextField txtMaskapai;
    private javax.swing.JTextField txtPesawat;
    private javax.swing.JTextField txtTiba;
    // End of variables declaration//GEN-END:variables
}
