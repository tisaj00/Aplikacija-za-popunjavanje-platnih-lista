/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisaj.obracunplace.view;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import tisaj.obracunplace.controller.ObradaIsplata;
import tisaj.obracunplace.controller.ObradaObracun;
import tisaj.obracunplace.controller.ObradaRadnik;
import tisaj.obracunplace.controller.ObradaVrstaPrimanja;
import tisaj.obracunplace.model.Isplata;
import tisaj.obracunplace.model.Obracun;
import tisaj.obracunplace.model.Radnik;
import tisaj.obracunplace.model.VrstaPrimanja;
import tisaj.obracunplace.pomocno.ObracunPlaceException;

/**
 *
 * @author Josip
 */
public class Obracuni extends javax.swing.JFrame {

    private final ObradaObracun obradaObracun;
    private final ObradaRadnik obradaRadnik;
    private final ObradaIsplata obradaIsplata;
    private static DefaultComboBoxModel<VrstaPrimanja> modelVrstaPrimanja;
    private Obracun obracun;
    private Isplata isplata;
    private Radnik radnik;
    private VrstaPrimanja vrstaPrimanja;

    /**
     * Creates new form Obracuni
     */
    public Obracuni() {
        initComponents();
        obradaObracun = new ObradaObracun();
        obradaRadnik = new ObradaRadnik();
        obradaIsplata = new ObradaIsplata();

        DefaultComboBoxModel<VrstaPrimanja> ms = new DefaultComboBoxModel<>();
        VrstaPrimanja vp = new VrstaPrimanja();
        vp.setId(1);
        vp.setNazivVrstePrimanja("Odaberite vrstu primanja");
        ms.addElement(vp);
        new ObradaVrstaPrimanja().getLista().forEach((s) -> {
            ms.addElement(s);
        });
        cmbVrstaPrimanja.setModel(ms);
        ucitajRadnike();
        ucitajIsplate();
        seticon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        lstRadniciNaObracunu = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstIsplata = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRadnici = new javax.swing.JList<>();
        btnObrisi = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        txtUvjet = new javax.swing.JTextField();
        chbLimitator = new javax.swing.JCheckBox();
        cmbVrstaPrimanja = new javax.swing.JComboBox<>();
        btnOčisti = new javax.swing.JButton();
        txtKolicina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnMakniSObracuna = new javax.swing.JButton();
        btnDodajNaObracun = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnIzracun = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Obračuni");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lstRadniciNaObracunu.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstRadniciNaObracunuValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstRadniciNaObracunu);

        lstIsplata.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstIsplata.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstIsplataValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstIsplata);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Vrsta Primanja");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Količina sati");

        jScrollPane2.setViewportView(lstRadnici);

        btnObrisi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnObrisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tisaj/obracunplace/pomocno/Button-Delete-icon.png"))); // NOI18N
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPromjeni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPromjeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tisaj/obracunplace/pomocno/Button-Refresh-icon.png"))); // NOI18N
        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUvjetKeyReleased(evt);
            }
        });

        chbLimitator.setSelected(true);
        chbLimitator.setText("Limitiraj na 25");

        btnOčisti.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOčisti.setText("Očisti");
        btnOčisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOčistiActionPerformed(evt);
            }
        });

        txtKolicina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtKolicina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKolicina.setText("0.0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Radnici u bazi");

        btnMakniSObracuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tisaj/obracunplace/pomocno/right.png"))); // NOI18N
        btnMakniSObracuna.setToolTipText("");
        btnMakniSObracuna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnMakniSObracuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakniSObracunaActionPerformed(evt);
            }
        });

        btnDodajNaObracun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tisaj/obracunplace/pomocno/left.png"))); // NOI18N
        btnDodajNaObracun.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnDodajNaObracun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNaObracunActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Radnici na obracunu");

        btnIzracun.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIzracun.setText("Izračunaj plaću");
        btnIzracun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Isplate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodajNaObracun, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMakniSObracuna, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(231, 231, 231)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chbLimitator, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(63, 63, 63))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPromjeni, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(btnOčisti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(cmbVrstaPrimanja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3)))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIzracun, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(btnDodajNaObracun, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(btnMakniSObracuna, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chbLimitator))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbVrstaPrimanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPromjeni)
                                .addGap(13, 13, 13)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOčisti, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIzracun, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Isplata entitet = lstIsplata.getSelectedValue();

        if (entitet == null) {
            JOptionPane.showConfirmDialog(null, "Prvo odaberite isplatu");
        }

        try {
            obradaIsplata.delete(entitet);
            ucitajIsplate();
            ocistiPolja();
        } catch (ObracunPlaceException ex) {
            JOptionPane.showMessageDialog(null, "Ne mogu obrisati isplatu,isplata mora bit prazna");
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        obracun = lstRadniciNaObracunu.getSelectedValue();
        if (obracun == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite obračun");
            return;
        }
        obracun = preuzmiVrijednosti(obracun);
        spremi(obracun);
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void lstIsplataValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstIsplataValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }

        Isplata i = lstIsplata.getSelectedValue();
        DefaultListModel<Obracun> m = new DefaultListModel<>();

        try {
            List<Obracun> obracuni = obradaObracun.getLista(i.getId());
            obracuni.forEach((o) -> {
                m.addElement(o);
            });
        } catch (Exception e) {
        }

//        Collections.sort(obracuni, new Comparator<Obracun>() {
//
//            public int compare(Obracun s1, Obracun s2) {
//                return s1.getRadnik().getPrezime().compareTo(s2.getRadnik().getPrezime());
//            }
//        });
        lstRadniciNaObracunu.setModel(m);
        lstRadniciNaObracunu.setCellRenderer(new ObracunRenderer());

    }//GEN-LAST:event_lstIsplataValueChanged

    public class ObracunRenderer extends JLabel implements ListCellRenderer<Obracun> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Obracun> list, Obracun obracun, int index,
                boolean isSelected, boolean cellHasFocus) {

            setText(obracun.getRadnik().getIme() + " " + obracun.getRadnik().getPrezime()
                    + "  (" + obracun.getVrstaPrimanja().getNazivVrstePrimanja() + ")  " + obracun.getKolicinaSati());

            return this;
        }

    }

    private void btnOčistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOčistiActionPerformed
        ocistiPolja();
    }//GEN-LAST:event_btnOčistiActionPerformed

    private void txtUvjetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyReleased
        ucitajEntitete();
    }//GEN-LAST:event_txtUvjetKeyReleased

    private void btnMakniSObracunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakniSObracunaActionPerformed
        Isplata ii = lstIsplata.getSelectedValue();
        obracun = lstRadniciNaObracunu.getSelectedValue();
        if (obracun == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite radnika na isplati");
            return;
        }

        Obracun obra = lstRadniciNaObracunu.getSelectedValue();

        try {
            obradaObracun.delete(obra);
            ucitajIsplate();
            ocistiPolja();
        } catch (ObracunPlaceException e) {
            JOptionPane.showConfirmDialog(null, "Obračun nije obrisan");
        }
    }//GEN-LAST:event_btnMakniSObracunaActionPerformed

    private void lstRadniciNaObracunuValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstRadniciNaObracunuValueChanged

        if (evt.getValueIsAdjusting()) {
            return;
        }

        obracun = lstRadniciNaObracunu.getSelectedValue();
        if (obracun == null) {
            return;
        }
        modelVrstaPrimanja = (DefaultComboBoxModel<VrstaPrimanja>) cmbVrstaPrimanja.getModel();
        for (int i = 0; i < modelVrstaPrimanja.getSize(); i++) {
            if (modelVrstaPrimanja.getElementAt(i).getId() == obracun.getVrstaPrimanja().getId()) {
                cmbVrstaPrimanja.setSelectedIndex(i);
                break;
            }
        }
        txtKolicina.setText(String.valueOf(obracun.getKolicinaSati()));


    }//GEN-LAST:event_lstRadniciNaObracunuValueChanged

    private void btnDodajNaObracunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNaObracunActionPerformed
        if (lstIsplata.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite isplatu");
            return;
        }
        if (lstRadnici.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite radnika");
            return;
        }

        Obracun o = new Obracun();
        try {
            o.setIsplata(lstIsplata.getSelectedValue());
            o.setRadnik(lstRadnici.getSelectedValue());
            o.setVrstaPrimanja((VrstaPrimanja) cmbVrstaPrimanja.getSelectedItem());
            o.setKolicinaSati(Double.parseDouble(txtKolicina.getText()));
        } catch (NumberFormatException e) {
        }

        try {
            obradaObracun.save(o);
            ocistiPolja();
            ucitajIsplate();
        } catch (ObracunPlaceException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnDodajNaObracunActionPerformed

    private void btnIzracunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunActionPerformed
        
            isplata = lstIsplata.getSelectedValue();
            if (isplata == null) {
                JOptionPane.showMessageDialog(null, "Odaberit isplatu za izračun");
                return;
            }
            
             Obracun radnik = lstRadniciNaObracunu.getSelectedValue();
            if(radnik==null){
                JOptionPane.showMessageDialog(null, "Odaberite radnika za obračun plaće");
                return;
            }
            
            

            try {
                XWPFDocument document = new XWPFDocument(new FileInputStream(new File("ObracunPlacePredlozak.docx")));

                for (XWPFParagraph p : document.getParagraphs()) {
                    List<XWPFRun> runs = p.getRuns();
                    if (runs != null) {
                        for (XWPFRun r : runs) {
                            
                            
                            String text = r.getText(0);
                            if (text != null && text.contains("<<imeprezime>>")) {
                                text = text.replace("<<imeprezime>>", radnik.getRadnik().getIme() + " " + radnik.getRadnik().getPrezime() );
                                r.setText(text, 0);
                            }

                            

                            if (text != null && text.contains("<<isplata>>")) {
                                text = text.replace("<<isplata>>", isplata.getNazivIsplate());
                                r.setText(text, 0);
                            }
                            
                            if (text != null && text.contains("<<oib>>")) {
                                text = text.replace("<<oib>>", radnik.getRadnik().getOib());
                                r.setText(text, 0);
                            }
                            
                            if (text != null && text.contains("<<osnovicaposatu>>")) {
                                text = text.replace("<<osnovicaposatu>>", radnik.getRadnik().getOsnovicaPoSatu());
                                r.setText(text, 0);
                            }
                            
                            if (text != null && text.contains("<<kolicinasati>>")) {
                                text = text.replace("<<kolicinasati>>", String.valueOf(obracun.getKolicinaSati()));
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("<<koeficijent>>")) {
                                text = text.replace("<<koeficijent>>", String.valueOf(obracun.getVrstaPrimanja().getKoeficijent()));
                                r.setText(text, 0);
                            }
                            if (text != null && text.contains("<<iban>>")) {
                                text = text.replace("<<iban>>", radnik.getRadnik().getIban());
                                r.setText(text, 0);
                            }
                
                            

                            if (text != null && text.contains("<<iznos>>")) {
                                
                                Double a = radnik.getKolicinaSati();
                                Double b = obracun.getVrstaPrimanja().getKoeficijent().doubleValue();
                                Double c = Double.parseDouble(radnik.getRadnik().getOsnovicaPoSatu());
                                
                                Double rez = a * b *c;

                                text = text.replace("<<iznos>>",String.valueOf(rez) );
                                r.setText(text, 0);
                            }
                            
                        }
                    }
                }

                JFileChooser j = new JFileChooser();
                if (j.showSaveDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
                    try {
                        document.write(new FileOutputStream(j.getSelectedFile()));
                        document.close();
                    } catch (Exception e) {
                        System.err.println("An exception occured in creating the DOCX document." + e.getMessage());
                    }
                }

            } catch (IOException ex) {

            }

           
         
         

    }//GEN-LAST:event_btnIzracunActionPerformed

    private void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("obracun.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNaObracun;
    private javax.swing.JButton btnIzracun;
    private javax.swing.JButton btnMakniSObracuna;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOčisti;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JCheckBox chbLimitator;
    private javax.swing.JComboBox<VrstaPrimanja> cmbVrstaPrimanja;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Isplata> lstIsplata;
    private javax.swing.JList<Radnik> lstRadnici;
    private javax.swing.JList<Obracun> lstRadniciNaObracunu;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

    private void ocistiPolja() {

        cmbVrstaPrimanja.setSelectedIndex(0);
        txtKolicina.setText("0.0");
    }

    private Obracun preuzmiVrijednosti(Obracun o) {
        o.setVrstaPrimanja((VrstaPrimanja) cmbVrstaPrimanja.getSelectedItem());
        o.setKolicinaSati(Double.parseDouble(txtKolicina.getText()));

        return o;
    }

    private void ucitajEntitete() {
        if (chbLimitator.isSelected()) {
            DefaultListModel<Radnik> m = new DefaultListModel<>();
            for (Radnik s : obradaRadnik.getLista(txtUvjet.getText().trim(), chbLimitator.isSelected())) {
                m.addElement(s);
            }
            lstRadnici.setModel(m);
        } else {
            DefaultListModel<Radnik> r = new DefaultListModel<>();
            Radnik rr = new Radnik();
            rr.setIme("Molim");
            rr.setPrezime("pričekati");
            r.addElement(rr);
            lstRadnici.setModel(r);
            DuzeUcitanjeEntiteta d = new DuzeUcitanjeEntiteta();
            d.start();
        }

    }

    private class DuzeUcitanjeEntiteta extends Thread {

        @Override
        public void run() {
            DefaultListModel<Radnik> m = new DefaultListModel<>();
            for (Radnik s : obradaRadnik.getLista(txtUvjet.getText().trim(), chbLimitator.isSelected())) {
                m.addElement(s);
            }
            lstRadnici.setModel(m);
        }

    }

    private void spremi(Obracun o) {
        try {
            obradaObracun.save(o);
            ocistiPolja();
            ucitajIsplate();
        } catch (ObracunPlaceException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void ucitajIsplate() {
        DefaultListModel<Isplata> ob = new DefaultListModel<>();
        obradaIsplata.getLista().forEach((o) -> {
            ob.addElement(o);
        });
        lstIsplata.setModel(ob);
    }

    private void ucitajRadnike() {
        DefaultListModel<Radnik> r = new DefaultListModel<>();
        for (Radnik m : obradaRadnik.getLista()) {
            r.addElement(m);
        }
        lstRadnici.setModel(r);
    }
}
