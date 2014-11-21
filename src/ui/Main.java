package ui;

import com.Grenzebach.Maorch.Tools.Lib;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import tools.FileIOcharSet;
import tools.Tools;
import xsltjava.XsltJava;

public class Main extends javax.swing.JFrame {

    static final Logger logger = Logger.getLogger(Main.class.getName());
    XmlEditFrame xmlFrame = new XmlEditFrame("xml");
    XmlEditFrame xslFrame = new XmlEditFrame("xsl");
    XmlEditFrame resultFrame = new XmlEditFrame("result");
    File transformerPropertiesFile = new File("transformerSettings.properties");
    Properties transformerProperties = new Properties();
    File xeniaPropertiesFile = new File("xenia.properties");
    Properties xeniaProperties = new Properties();

    public Main() {
        initComponents();

        jMenuItemResultActionPerformed(null);
        setLocationRelativeTo(null);

        setTransferHandler(new OpenTransferHandler(this));

        try {
            transformerProperties.load(new FileInputStream(transformerPropertiesFile));
            xeniaProperties.load(new FileInputStream(xeniaPropertiesFile));
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.severe(ex.getMessage());
        }
        try {
            transformerProperties.store(new FileOutputStream(transformerPropertiesFile), "");
            xeniaProperties.store(new FileOutputStream(xeniaPropertiesFile), "");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.severe(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new DesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpenXml = new javax.swing.JMenuItem();
        jMenuItemOpenXsl = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuWindow = new javax.swing.JMenu();
        jMenuItemResult = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemVertically = new javax.swing.JMenuItem();
        jMenuItemHorizontally = new javax.swing.JMenuItem();
        jMenuItemCascade = new javax.swing.JMenuItem();
        jMenuProcess = new javax.swing.JMenu();
        jMenuItemProcess = new javax.swing.JMenuItem();
        jMenuItemTransformerSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Xenia");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 128));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        jMenuFile.setText("File");

        jMenuItemOpenXml.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenXml.setText("Open XML (data)");
        jMenuItemOpenXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenXmlActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenXml);

        jMenuItemOpenXsl.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpenXsl.setText("Open XSL (stylesheet)");
        jMenuItemOpenXsl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenXslActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenXsl);

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveAs.setText("Save as");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveAs);
        jMenuFile.add(jSeparator2);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar1.add(jMenuFile);

        jMenuWindow.setText("Window");

        jMenuItemResult.setText("Result");
        jMenuItemResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemResultActionPerformed(evt);
            }
        });
        jMenuWindow.add(jMenuItemResult);
        jMenuWindow.add(jSeparator1);

        jMenuItemVertically.setText("Tile vertically");
        jMenuItemVertically.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerticallyActionPerformed(evt);
            }
        });
        jMenuWindow.add(jMenuItemVertically);

        jMenuItemHorizontally.setText("Tile horizontally");
        jMenuItemHorizontally.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHorizontallyActionPerformed(evt);
            }
        });
        jMenuWindow.add(jMenuItemHorizontally);

        jMenuItemCascade.setText("Cascade");
        jMenuItemCascade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCascadeActionPerformed(evt);
            }
        });
        jMenuWindow.add(jMenuItemCascade);

        jMenuBar1.add(jMenuWindow);

        jMenuProcess.setText("Process");

        jMenuItemProcess.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItemProcess.setText("Process stylesheet on xml");
        jMenuItemProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProcessActionPerformed(evt);
            }
        });
        jMenuProcess.add(jMenuItemProcess);

        jMenuItemTransformerSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItemTransformerSettings.setText("Transformer settings");
        jMenuItemTransformerSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransformerSettingsActionPerformed(evt);
            }
        });
        jMenuProcess.add(jMenuItemTransformerSettings);

        jMenuBar1.add(jMenuProcess);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenXslActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenXslActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            if (xeniaProperties.getProperty("xslFile") != null) {
                fc.setCurrentDirectory(new File(xeniaProperties.getProperty("xslFile")));
            }
            fc.setAcceptAllFileFilterUsed(true);
            fc.setMultiSelectionEnabled(false);
            fc.setFileFilter(new FileNameExtensionFilter("xsl", "xsl"));

            int ret = fc.showOpenDialog(this);
            if (ret == JFileChooser.CANCEL_OPTION) {
                return;
            }

            File xslFile = fc.getSelectedFile();
            xeniaProperties.setProperty("xslFile", xslFile.getParentFile().getAbsolutePath());
            loadXfile(xslFile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Arrays.toString(ex.getStackTrace()));
        }
    }//GEN-LAST:event_jMenuItemOpenXslActionPerformed

    private void jMenuItemVerticallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerticallyActionPerformed
        try {
            JInternalFrame[] internalFrames = jDesktopPane1.getAllFrames();

            //tile vertically:
            int delta = jDesktopPane1.getHeight();
            for (int i = 0; i < internalFrames.length; i++) {
                JInternalFrame internalFrame = internalFrames[i];
                tidyUpFrame(internalFrame);
                internalFrame.setLocation(0, delta / internalFrames.length * i);
                internalFrame.setSize(jDesktopPane1.getWidth(), delta / internalFrames.length);
            }

            internalFrames[internalFrames.length - 1].setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemVerticallyActionPerformed

    private void jMenuItemCascadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCascadeActionPerformed
        try {
            JInternalFrame[] internalFrames = jDesktopPane1.getAllFrames();

            //cascade:
            int delta = ((javax.swing.plaf.basic.BasicInternalFrameUI) xmlFrame.getUI()).getNorthPane().getPreferredSize().height;
            for (int i = 0; i < internalFrames.length; i++) {
                JInternalFrame internalFrame = internalFrames[i];
                tidyUpFrame(internalFrame);
                internalFrame.setLocation(i * delta, i * delta);
                internalFrame.setSize(300, 300);
                internalFrame.setSelected(true);
                internalFrame.toFront();
            }

            internalFrames[internalFrames.length - 1].setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemCascadeActionPerformed

    private void tidyUpFrame(JInternalFrame internalFrame) {
        if (internalFrame.isVisible()) {
            if (internalFrame.isMaximum()) {
                jDesktopPane1.getDesktopManager().minimizeFrame(internalFrame);
            }
            if (internalFrame.isIcon()) {
                jDesktopPane1.getDesktopManager().deiconifyFrame(internalFrame);
            }
        }
    }

    private void jMenuItemHorizontallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHorizontallyActionPerformed
        try {
            JInternalFrame[] internalFrames = jDesktopPane1.getAllFrames();

            //tile horizontally:
            int delta = jDesktopPane1.getWidth();
            for (int i = 0; i < internalFrames.length; i++) {
                JInternalFrame internalFrame = internalFrames[i];
                tidyUpFrame(internalFrame);

                internalFrame.setLocation(delta / internalFrames.length * i, 0);
                internalFrame.setSize(delta / internalFrames.length, jDesktopPane1.getHeight());
            }

            internalFrames[internalFrames.length - 1].setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemHorizontallyActionPerformed

    private void jMenuItemProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProcessActionPerformed
        try {
            String xmlContent = xmlFrame.getXmlTextEditor().getText();
            String xslContent = xslFrame.getXmlTextEditor().getText();

            XsltJava xsltJava = new XsltJava();
            xsltJava.setTransformSettings(transformerProperties);
            String result = xsltJava.xsltProc(xmlContent, xslContent);
            resultFrame.setText(result, false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Lib.getExceptionStack(ex));
        }
    }//GEN-LAST:event_jMenuItemProcessActionPerformed

    private void jMenuItemResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemResultActionPerformed
        if (resultFrame.getParent() == null) {
            if (resultFrame.isIcon() & resultFrame.isVisible()) {
                jDesktopPane1.getDesktopManager().deiconifyFrame(resultFrame);
            } else {
                resultFrame.setVisible(true);
                jDesktopPane1.add(resultFrame);
            }
        }

        jDesktopPane1.getDesktopManager().activateFrame(resultFrame);
    }//GEN-LAST:event_jMenuItemResultActionPerformed

    private void jMenuItemTransformerSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransformerSettingsActionPerformed
        TransformerSettings transformerSettingsDlg = new TransformerSettings(this, true);
        transformerSettingsDlg.setSettings(transformerProperties);
        transformerSettingsDlg.setVisible(true);

        if (!transformerSettingsDlg.isCanceled()) {
            transformerProperties = transformerSettingsDlg.getSettings();
            try {
                transformerProperties.store(new FileOutputStream(transformerPropertiesFile), "");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItemTransformerSettingsActionPerformed

    public void loadXfile(File xFile) throws IOException, Exception {
        XmlEditFrame internalFrame;
        if (xFile.getName().toLowerCase().endsWith(".xml")) {
            internalFrame = xmlFrame;
        } else if (xFile.getName().toLowerCase().endsWith(".xsl")) {
            internalFrame = xslFrame;
        } else {
            return;
        }

        String encoding = Tools.detectEncoding(xFile);
        String content = new FileIOcharSet().file2String(xFile, encoding);

        if (internalFrame.getParent() == null) {
            if (internalFrame.isIcon() & internalFrame.isVisible()) {
                jDesktopPane1.getDesktopManager().deiconifyFrame(internalFrame);
            } else {
                internalFrame.setVisible(true);
                jDesktopPane1.add(internalFrame);
            }
        }

        internalFrame.getXmlTextEditor().setText(content);
        internalFrame.getXmlTextEditor().setCaretPosition(0);
        internalFrame.setLoadedFile(xFile);

        jDesktopPane1.getDesktopManager().activateFrame(internalFrame);
    }

    private void jMenuItemOpenXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenXmlActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            if (xeniaProperties.getProperty("xmlFile") != null) {
                fc.setCurrentDirectory(new File(xeniaProperties.getProperty("xmlFile")));
            }
            fc.setAcceptAllFileFilterUsed(true);
            fc.setMultiSelectionEnabled(false);
            fc.setFileFilter(new FileNameExtensionFilter("xml", "xml"));

            int ret = fc.showOpenDialog(this);
            if (ret == JFileChooser.CANCEL_OPTION) {
                return;
            }

            File xmlFile = fc.getSelectedFile();
            xeniaProperties.setProperty("xmlFile", xmlFile.getParentFile().getAbsolutePath());
            loadXfile(xmlFile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Arrays.toString(ex.getStackTrace()));
        }
    }//GEN-LAST:event_jMenuItemOpenXmlActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            xeniaProperties.store(new FileOutputStream(xeniaPropertiesFile), "");
        } catch (IOException ex) {
            logger.severe(Arrays.toString(ex.getStackTrace()));
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        JInternalFrame jif = jDesktopPane1.getSelectedFrame();
        if (!(jif instanceof XmlEditFrame)) {
            return;
        }

        XmlEditFrame xmlEditFrame = (XmlEditFrame) jif;
        try {
            String encoding;
            EncodingDialog dlg = new EncodingDialog(this, true);
            dlg.setEncoding("UTF-8");
            dlg.setVisible(true);
            if (dlg.isCanceled()) {
                return;
            }
            encoding = dlg.getEncoding();

            xmlEditFrame.save(encoding);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveAsActionPerformed
        JInternalFrame jif = jDesktopPane1.getSelectedFrame();
        if (!(jif instanceof XmlEditFrame)) {
            return;
        }
        XmlEditFrame xmlEditFrame = (XmlEditFrame) jif;

        JFileChooser fc = new JFileChooser(xmlEditFrame.getLoadedFile());
        File dir = new File(xeniaProperties.getProperty("xslFile",
                xmlEditFrame.getLoadedFile().getParentFile().getAbsolutePath()));
        fc.setCurrentDirectory(dir);
        fc.setSelectedFile(xmlEditFrame.getLoadedFile());

        int ret = fc.showSaveDialog(this);
        if (ret == JFileChooser.CANCEL_OPTION) {
            return;
        }

        try {
            String encoding;
            EncodingDialog dlg = new EncodingDialog(this, true);
            dlg.setEncoding("UTF-8");
            dlg.setVisible(true);
            if (dlg.isCanceled()) {
                return;
            }
            encoding = dlg.getEncoding();

            xmlEditFrame.saveAs(fc.getSelectedFile(), encoding);
            xmlEditFrame.setLoadedFile(fc.getSelectedFile());

            String path = xmlEditFrame.getLoadedFile().getParentFile().getAbsolutePath();
            if (xmlEditFrame.getLoadedFile().getName().toLowerCase().endsWith(".xml")) {
                xeniaProperties.setProperty("xmlFile", path);
            }

            if (xmlEditFrame.getLoadedFile().getName().toLowerCase().endsWith(".xsl")) {
                xeniaProperties.setProperty("xslFile", path);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItemSaveAsActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemCascade;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemHorizontally;
    private javax.swing.JMenuItem jMenuItemOpenXml;
    private javax.swing.JMenuItem jMenuItemOpenXsl;
    private javax.swing.JMenuItem jMenuItemProcess;
    private javax.swing.JMenuItem jMenuItemResult;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemTransformerSettings;
    private javax.swing.JMenuItem jMenuItemVertically;
    private javax.swing.JMenu jMenuProcess;
    private javax.swing.JMenu jMenuWindow;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
