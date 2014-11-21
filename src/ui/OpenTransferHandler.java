package ui;

import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY;

public class OpenTransferHandler extends TransferHandler {

    Main main;

    public OpenTransferHandler(Main main) {
        this.main = main;
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        support.setDropAction(COPY); //accept only COPY
        return true;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        if (info.getTransferable().isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            try {
                List<File> droppedFilesList = (List<File>) info.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                for (File file : droppedFilesList) {
                    main.loadXfile(file);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return true;
    }
}
