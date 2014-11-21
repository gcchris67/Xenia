package ui;

import java.util.ArrayList;
import java.util.Properties;
import tools.FileIOcharSet;

public class TransformerSettings extends javax.swing.JDialog {

    private boolean canceled = true;
    private Properties settings = new Properties();

    public TransformerSettings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        ArrayList<String> charsetNames = FileIOcharSet.getCharsetNames();
        for (String charsetName : charsetNames) {
            jComboBoxEncoding.addItem(charsetName);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMethod = new javax.swing.ButtonGroup();
        buttonGroupIndent = new javax.swing.ButtonGroup();
        buttonGroupOmitXmlDeclaration = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonIndentYes = new javax.swing.JRadioButton();
        jRadioButtonIndentNo = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonXml = new javax.swing.JRadioButton();
        jRadioButtonHtml = new javax.swing.JRadioButton();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxEncoding = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jRadioButtonOmitXmlYes = new javax.swing.JRadioButton();
        jRadioButtonOmitXmlNo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transformer Settings");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Indent"));

        buttonGroupIndent.add(jRadioButtonIndentYes);
        jRadioButtonIndentYes.setSelected(true);
        jRadioButtonIndentYes.setText("yes");

        buttonGroupIndent.add(jRadioButtonIndentNo);
        jRadioButtonIndentNo.setText("no");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonIndentYes)
                    .addComponent(jRadioButtonIndentNo))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonIndentYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonIndentNo)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));

        buttonGroupMethod.add(jRadioButtonXml);
        jRadioButtonXml.setSelected(true);
        jRadioButtonXml.setText("XML");
        jRadioButtonXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonXmlActionPerformed(evt);
            }
        });

        buttonGroupMethod.add(jRadioButtonHtml);
        jRadioButtonHtml.setText("HTML");
        jRadioButtonHtml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonHtmlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonXml)
                    .addComponent(jRadioButtonHtml))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonXml)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonHtml)
                .addContainerGap())
        );

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Encoding"));

        jComboBoxEncoding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTF-8", "UTF-16", "UTF-32" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxEncoding, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxEncoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Omit XML declaration"));

        buttonGroupOmitXmlDeclaration.add(jRadioButtonOmitXmlYes);
        jRadioButtonOmitXmlYes.setText("yes");

        buttonGroupOmitXmlDeclaration.add(jRadioButtonOmitXmlNo);
        jRadioButtonOmitXmlNo.setSelected(true);
        jRadioButtonOmitXmlNo.setText("no");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonOmitXmlYes)
                    .addComponent(jRadioButtonOmitXmlNo))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonOmitXmlYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonOmitXmlNo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonXmlActionPerformed
        updateOmit();
    }//GEN-LAST:event_jRadioButtonXmlActionPerformed

    private void updateOmit() {
        boolean omitEnabled = jRadioButtonXml.isSelected();
        jRadioButtonOmitXmlYes.setEnabled(omitEnabled);
        jRadioButtonOmitXmlNo.setEnabled(omitEnabled);
    }

    private void jRadioButtonHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonHtmlActionPerformed
        updateOmit();
    }//GEN-LAST:event_jRadioButtonHtmlActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        canceled = false;

        if (jRadioButtonXml.isSelected()) {
            settings.setProperty("method", "xml");
        } else {
            settings.setProperty("method", "html");
        }

        if (jRadioButtonIndentYes.isSelected()) {
            settings.setProperty("indent", "yes");
        } else {
            settings.setProperty("indent", "no");
        }

        if (jRadioButtonOmitXmlYes.isSelected()) {
            settings.setProperty("omit-xml-declaration", "yes");
        } else {
            settings.setProperty("omit-xml-declaration", "no");
        }

        settings.setProperty("encoding", jComboBoxEncoding.getSelectedItem().toString());

        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(TransformerSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransformerSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransformerSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransformerSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransformerSettings dialog = new TransformerSettings(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupIndent;
    private javax.swing.ButtonGroup buttonGroupMethod;
    private javax.swing.ButtonGroup buttonGroupOmitXmlDeclaration;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox jComboBoxEncoding;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonHtml;
    private javax.swing.JRadioButton jRadioButtonIndentNo;
    private javax.swing.JRadioButton jRadioButtonIndentYes;
    private javax.swing.JRadioButton jRadioButtonOmitXmlNo;
    private javax.swing.JRadioButton jRadioButtonOmitXmlYes;
    private javax.swing.JRadioButton jRadioButtonXml;
    // End of variables declaration//GEN-END:variables

    public boolean isCanceled() {
        return canceled;
    }

    public Properties getSettings() {
        return settings;
    }

    public void setSettings(Properties settings) {
        if (settings == null) {
            return;
        }

        this.settings = settings;

        if (settings.getProperty("method") != null && settings.getProperty("method").equalsIgnoreCase("xml")) {
            jRadioButtonXml.setSelected(true);
            jRadioButtonHtml.setSelected(false);
        } else {
            jRadioButtonXml.setSelected(false);
            jRadioButtonHtml.setSelected(true);
        }

        if (settings.getProperty("indent") != null && settings.getProperty("indent").equalsIgnoreCase("yes")) {
            jRadioButtonIndentYes.setSelected(true);
            jRadioButtonIndentNo.setSelected(false);
        } else {
            jRadioButtonIndentYes.setSelected(false);
            jRadioButtonIndentNo.setSelected(true);
        }

        if (settings.getProperty("omit-xml-declaration") != null && settings.getProperty("omit-xml-declaration").equalsIgnoreCase("yes")) {
            jRadioButtonOmitXmlYes.setSelected(true);
            jRadioButtonOmitXmlNo.setSelected(false);
        } else {
            jRadioButtonOmitXmlYes.setSelected(false);
            jRadioButtonOmitXmlNo.setSelected(true);
        }

        jComboBoxEncoding.setSelectedItem(settings.getProperty("encoding"));
    }
}
