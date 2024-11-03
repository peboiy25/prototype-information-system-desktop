/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import controller.FKeluarController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.DetailFKeluar;
import model.FKeluar;

/**
 *
 * @author LENOVO
 */
public class FKeluarView extends javax.swing.JInternalFrame {private final FKeluar fKeluar;
    private final FKeluarController fKeluarController;
    private List<DetailFKeluar> listDetailFKeluar;
    /**
     * Creates new form FKeluarView
     */
    public FKeluarView() {
        initComponents();
        
        fKeluar = new FKeluar();
        fKeluarController = new FKeluarController(this);
        listDetailFKeluar = new ArrayList<>();
        refreshTable();
    }

    public JTable getTabelFKeluar() {
        return tabelFKeluar;
    }

    public void setTabelFKeluar(JTable tabelFKeluar) {
        this.tabelFKeluar = tabelFKeluar;
    }

    public JDateChooser getTanggalFKeluar() {
        return tanggalFKeluar;
    }

    public void setTanggalFKeluar(JDateChooser tanggalFKeluar) {
        this.tanggalFKeluar = tanggalFKeluar;
    }

    public JTextField getTextBerat() {
        return textBerat;
    }

    public void setTextBerat(JTextField textBerat) {
        this.textBerat = textBerat;
    }

    public JTextField getTextJumlah() {
        return textJumlah;
    }

    public void setTextJumlah(JTextField textJumlah) {
        this.textJumlah = textJumlah;
    }

    public JTextField getTextKode() {
        return textKode;
    }

    public void setTextKode(JTextField textKode) {
        this.textKode = textKode;
    }

    public JTextField getTextNamaPelanggan() {
        return textNamaPelanggan;
    }

    public void setTextNamaPelanggan(JTextField textNamaPelanggan) {
        this.textNamaPelanggan = textNamaPelanggan;
    }

    public JTextField getTextNoFKeluar() {
        return textNoFKeluar;
    }

    public void setTextNoFKeluar(JTextField textNoFKeluar) {
        this.textNoFKeluar = textNoFKeluar;
    }

    public JTextField getTextNomor() {
        return textNomor;
    }

    public void setTextNomor(JTextField textNomor) {
        this.textNomor = textNomor;
    }

    public JTextField getTextTotal() {
        return textTotal;
    }

    public void setTextTotal(JTextField textTotal) {
        this.textTotal = textTotal;
    }

    public JTextField getTextWarna() {
        return textWarna;
    }

    public void setTextWarna(JTextField textWarna) {
        this.textWarna = textWarna;
    }

    public JTextField getTextHarga() {
        return textHarga;
    }

    public void setTextHarga(JTextField textHarga) {
        this.textHarga = textHarga;
    }

    public JButton getTombolCari() {
        return tombolCari;
    }

    public void setTombolCari(JButton tombolCari) {
        this.tombolCari = tombolCari;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public void setTombolHapus(JButton tombolHapus) {
        this.tombolHapus = tombolHapus;
    }

    public JButton getTombolSimpan() {
        return tombolSimpan;
    }

    public void setTombolSimpan(JButton tombolSimpan) {
        this.tombolSimpan = tombolSimpan;
    }

    public JButton getTombolTambah() {
        return tombolTambah;
    }

    public void setTombolTambah(JButton tombolTambah) {
        this.tombolTambah = tombolTambah;
    }
    
    public void refreshTable(){
        tabelFKeluar.setModel(new FKeluarTableModel(listDetailFKeluar));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNoFKeluar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanggalFKeluar = new com.toedter.calendar.JDateChooser();
        textNamaPelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textKode = new javax.swing.JTextField();
        tombolCari = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textJumlah = new javax.swing.JTextField();
        textWarna = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textBerat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textNomor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tombolTambah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelFKeluar = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        tombolSimpan = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("FAKTUR KELUAR");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setBackground(new java.awt.Color(204, 204, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("FAKTUR KELUAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nomor Faktur");

        textNoFKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNoFKeluarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tanggal");

        textNamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaPelangganActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Pelanggan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(textNoFKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggalFKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tanggalFKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(textNoFKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setText("Kode Barang");

        tombolCari.setText("Cari");
        tombolCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCariActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah ");

        textWarna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWarnaActionPerformed(evt);
            }
        });

        jLabel6.setText("Warna");

        jLabel7.setText("Berat");

        textNomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomorActionPerformed(evt);
            }
        });

        jLabel9.setText("No Urut");

        jLabel10.setText("Bal");

        tombolTambah.setText("Tambah Barang");
        tombolTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus Barang");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jLabel11.setText("Kg");

        jLabel13.setText("Harga");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textWarna, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tombolCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(tombolTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolHapus)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolCari)
                    .addComponent(jLabel4)
                    .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textWarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolTambah)
                    .addComponent(tombolHapus)
                    .addComponent(jLabel11)
                    .addComponent(textBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelFKeluar.setBackground(new java.awt.Color(204, 204, 255));
        tabelFKeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelFKeluar);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("GRAND TOTAL");

        textTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        tombolSimpan.setText("SIMPAN FAKTUR KELUAR");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tombolSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSimpan)
                    .addComponent(jLabel8)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNoFKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNoFKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNoFKeluarActionPerformed

    private void tombolCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariActionPerformed
        // TODO add your handling code here:
        fKeluarController.cariWarna(textKode.getText());
    }//GEN-LAST:event_tombolCariActionPerformed

    private void textNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaPelangganActionPerformed

    private void textWarnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWarnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textWarnaActionPerformed

    private void textNomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomorActionPerformed

    private void tombolTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTambahActionPerformed
        // TODO add your handling code here:
        fKeluarController.tambahBeli(listDetailFKeluar, textWarna.getText(), textNomor.getText(), Double.parseDouble(textBerat.getText()));
        refreshTable();
    }//GEN-LAST:event_tombolTambahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        fKeluarController.deleteItem(listDetailFKeluar);
        refreshTable();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        fKeluar.setNoFakturKeluar(textNoFKeluar.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fKeluar.setTanggalKeluar(sdf.format(tanggalFKeluar.getDate()));
        fKeluar.setNamaPelanggan(textNamaPelanggan.getText());
        fKeluar.setGrandTotal(Integer.parseInt(textTotal.getText()));
        App.fakturService.simpanFakturKeluar(fKeluar);
        
        for (DetailFKeluar detailFKeluar : listDetailFKeluar) {
            DetailFKeluar dfk = new DetailFKeluar();
            dfk.setfKeluar(fKeluar);
            dfk.setWarna(detailFKeluar.getWarna());
            dfk.setJumlah(detailFKeluar.getJumlah());
            dfk.setSubTotal(detailFKeluar.getSubTotal());
            App.fakturService.simpanDetailFKeluar(dfk);
        }
        fKeluarController.clearForm();
        listDetailFKeluar = new ArrayList<>();
        refreshTable();
        JOptionPane.showMessageDialog(this, "Faktur Keluar berhasil disimpan!");
    }//GEN-LAST:event_tombolSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelFKeluar;
    private com.toedter.calendar.JDateChooser tanggalFKeluar;
    private javax.swing.JTextField textBerat;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textKode;
    private javax.swing.JTextField textNamaPelanggan;
    private javax.swing.JTextField textNoFKeluar;
    private javax.swing.JTextField textNomor;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textWarna;
    private javax.swing.JButton tombolCari;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolTambah;
    // End of variables declaration//GEN-END:variables

    public class FKeluarTableModel extends AbstractTableModel{
        
        private List<DetailFKeluar> listDetailFKeluar = new ArrayList<>();
        private final String HEADER[] = {"Kode Barang", "Warna", "No Urut", "Berat", "Jumlah", "Sub Total"};
        
        public FKeluarTableModel (List<DetailFKeluar> listDetailFKeluar){
            this.listDetailFKeluar = listDetailFKeluar;
        }

        @Override
        public int getRowCount() {
            return this.listDetailFKeluar.size();
        }

        @Override
        public int getColumnCount() {
            return HEADER.length;
        }
        
        @Override
        public String getColumnName(int i) {
            return HEADER[i];
        }

        @Override
        public Object getValueAt(int i, int i1) {
            DetailFKeluar detail = listDetailFKeluar.get(i);
            switch(i1){
                case 0:
                    return detail.getWarna().getBarang().getKodeBarang();
                case 1:
                    return detail.getWarna().getWarna();
                case 2:
                    return detail.getWarna().getNo_urut();
                case 3:
                    return detail.getWarna().getBerat();
                case 4:
                    return detail.getJumlah();
                case 5:
                    return detail.getSubTotal();
                default:
                    return "";
            }
        }
    }   
}