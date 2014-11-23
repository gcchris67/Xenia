package xsltjava;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import tools.Tools;

public class XsltJava {

    Properties transformerSettings = new Properties();
    static final Logger logger = Logger.getLogger(XsltJava.class.getName());
    HashSet<String> errorText = new HashSet<String>();
    StringBuilder errors = new StringBuilder();

    public void setTransformSettings(Properties settings) {
        transformerSettings.clear();
        transformerSettings.putAll(settings);
    }

    public void xsltProc(File xmlFile, File xslFile, File outputFile) throws IOException, URISyntaxException, TransformerException {
        TransformerFactory.newInstance().newTransformer(
                new StreamSource(xslFile)).transform(
                        new StreamSource(xmlFile), new StreamResult(outputFile));
    }

    public String xsltProc(String xmlData, String xslData) throws Exception {
        StringWriter writer = new StringWriter();

        Source src = new StreamSource(new StringReader(xslData));

        TransformerFactory factory = TransformerFactory.newInstance();
//        TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);

        errorText.clear();
        factory.setErrorListener(new ErrorListener() {
            @Override
            public void warning(TransformerException te) throws TransformerException {
                String err = te.getMessageAndLocation();
                if (!errorText.contains(err)) {
                    errorText.add(err);
                    errors.append(err);
                    errors.append("\n");
                }
            }

            @Override
            public void error(TransformerException te) throws TransformerException {
                String err = te.getMessageAndLocation();
                if (!errorText.contains(err)) {
                    errorText.add(err);
                    errors.append(err);
                    errors.append("\n");
                }
            }

            @Override
            public void fatalError(TransformerException te) throws TransformerException {
                String err = te.getMessageAndLocation();
                if (!errorText.contains(err)) {
                    errorText.add(err);
                    errors.append(err);
                    errors.append("\n");
                }
            }
        });

        Transformer transformer;
        try {
            transformer = factory.newTransformer(src);
            transformer.setOutputProperties(transformerSettings);
            transformer.transform(new StreamSource(new StringReader(xmlData)), new StreamResult(writer));
        } catch (TransformerConfigurationException ex) {
            throw new Exception(errors.toString());
        } catch (TransformerException ex) {
            throw new Exception(errors.toString());
        }

        return writer.toString();
    }

    public static void main(String[] args) {
        try {
            File xslFile = new File("stylesheet.xsl");
            File xmlFile = new File("data.xml");
            File outputFile = new File("output.html");
            new XsltJava().xsltProc(xmlFile, xslFile, outputFile);
        } catch (IOException ex) {
            logger.severe(Tools.getExceptionStack(ex));
        } catch (URISyntaxException ex) {
            logger.severe(Tools.getExceptionStack(ex));
        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(null, Tools.getExceptionStack(ex));
        }
    }
}
