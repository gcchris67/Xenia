package ui;

import com.Grenzebach.Maorch.Tools.Lib;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.batik.util.gui.xmleditor.XMLEditorKit;
import org.apache.batik.util.gui.xmleditor.XMLTextEditor;
import tools.FileIOcharSet;

public class XmlEditFrame extends javax.swing.JInternalFrame {

    private final XMLTextEditor xmlTextEditor;
    private File loadedFile;
    String docType; //xml, xsl, result

    public XmlEditFrame(String docType) {
        initComponents();

        xmlTextEditor = new XMLTextEditor();

        this.docType = docType;
        updateTitle();

        jScrollPane1.setViewportView(xmlTextEditor);
        xmlTextEditor.setEditorKitForContentType(XMLEditorKit.XML_MIME_TYPE, xmlTextEditor.getEditorKit());
        xmlTextEditor.setContentType(XMLEditorKit.XML_MIME_TYPE);
    }

    private void updateTitle() {
        if (getLoadedFile() != null) {
            setTitle(String.format("XML-Editor [%s]: %s", docType, getLoadedFile().getAbsolutePath()));
        } else {
            setTitle(String.format("XML-Editor [%s]", docType));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuEditRemoveAll = new javax.swing.JMenu();
        jMenuItemUndo = new javax.swing.JMenuItem();
        jMenuItemRedo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemRemoveAll = new javax.swing.JMenuItem();
        jMenuItemGotoLine = new javax.swing.JMenuItem();
        jMenuFormat = new javax.swing.JMenu();
        jMenuItemPretty = new javax.swing.JMenuItem();
        jMenuItemCompact = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jScrollPane1.setViewportView(jEditorPane1);

        jMenuEditRemoveAll.setText("Edit");

        jMenuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUndo.setText("Undo");
        jMenuItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUndoActionPerformed(evt);
            }
        });
        jMenuEditRemoveAll.add(jMenuItemUndo);

        jMenuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRedo.setText("Redo");
        jMenuItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRedoActionPerformed(evt);
            }
        });
        jMenuEditRemoveAll.add(jMenuItemRedo);
        jMenuEditRemoveAll.add(jSeparator1);

        jMenuItemRemoveAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRemoveAll.setText("Remove all");
        jMenuItemRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoveAllActionPerformed(evt);
            }
        });
        jMenuEditRemoveAll.add(jMenuItemRemoveAll);

        jMenuItemGotoLine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGotoLine.setText("Goto line");
        jMenuItemGotoLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGotoLineActionPerformed(evt);
            }
        });
        jMenuEditRemoveAll.add(jMenuItemGotoLine);

        jMenuBar1.add(jMenuEditRemoveAll);

        jMenuFormat.setText("Format");

        jMenuItemPretty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemPretty.setText("Pretty");
        jMenuItemPretty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrettyActionPerformed(evt);
            }
        });
        jMenuFormat.add(jMenuItemPretty);

        jMenuItemCompact.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemCompact.setText("Compact");
        jMenuItemCompact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompactActionPerformed(evt);
            }
        });
        jMenuFormat.add(jMenuItemCompact);

        jMenuBar1.add(jMenuFormat);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String trimContent(String content) {
        String[] lines = content.split("\n");
        String ret = "";
        for (String line : lines) {
            line = line.replace("\t", "");
            ret += line.trim();
        }

        return ret;
    }

    private void jMenuItemUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUndoActionPerformed
        getXmlTextEditor().undo();
    }//GEN-LAST:event_jMenuItemUndoActionPerformed

    private void jMenuItemRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRedoActionPerformed
        getXmlTextEditor().redo();
    }//GEN-LAST:event_jMenuItemRedoActionPerformed

    private void jMenuItemPrettyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrettyActionPerformed
        try {
            String compactContent = trimContent(getXmlTextEditor().getText());

            Source xmlInput = new StreamSource(new StringReader(compactContent));
            StreamResult xmlOutput = new StreamResult(new StringWriter());

            // Configure transformer
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
//            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(xmlInput, xmlOutput);
            String newContent = xmlOutput.getWriter().toString();

            getXmlTextEditor().setText(newContent);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, Lib.getExceptionStack(ex));
        }
    }//GEN-LAST:event_jMenuItemPrettyActionPerformed

    private void jMenuItemCompactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompactActionPerformed
        String content = trimContent(getXmlTextEditor().getText());
        getXmlTextEditor().setText(content);
    }//GEN-LAST:event_jMenuItemCompactActionPerformed

    private void jMenuItemRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoveAllActionPerformed
        getXmlTextEditor().setText("");
    }//GEN-LAST:event_jMenuItemRemoveAllActionPerformed

    public XMLTextEditor getXmlTextEditor() {
        return xmlTextEditor;
    }

    public void setText(String txt, boolean pretty) {
        getXmlTextEditor().setText(txt);
        if (pretty) {
            jMenuItemPrettyActionPerformed(null);
        }
    }

    public void save(String encoding) throws Exception {
        new FileIOcharSet().string2file(getLoadedFile(), getXmlTextEditor().getText(), encoding);
    }

    public void saveAs(File selectedFile, String encoding) throws Exception {
        new FileIOcharSet().string2file(selectedFile, getXmlTextEditor().getText(), encoding);
    }
    private void jMenuItemGotoLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGotoLineActionPerformed
        try {
            int lineNbr = Integer.parseInt(JOptionPane.showInputDialog("Line-Number"));
            getXmlTextEditor().gotoLine(lineNbr - 1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jMenuItemGotoLineActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEditRemoveAll;
    private javax.swing.JMenu jMenuFormat;
    private javax.swing.JMenuItem jMenuItemCompact;
    private javax.swing.JMenuItem jMenuItemGotoLine;
    private javax.swing.JMenuItem jMenuItemPretty;
    private javax.swing.JMenuItem jMenuItemRedo;
    private javax.swing.JMenuItem jMenuItemRemoveAll;
    private javax.swing.JMenuItem jMenuItemUndo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public File getLoadedFile() {
        return loadedFile;
    }

    public void setLoadedFile(File loadedFile) {
        this.loadedFile = loadedFile;
        updateTitle();
    }
}
