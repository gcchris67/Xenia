package xsltjava;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltJava {

    Properties transformerSettings = new Properties();

    public void setTransformSettings(Properties settings) {
        transformerSettings.clear();
        transformerSettings.putAll(settings);
    }

    public void xsltProc(File xmlFile, File xslFile, File outputFile) throws IOException, URISyntaxException, TransformerException {
        TransformerFactory.newInstance().newTransformer(
                new StreamSource(xslFile)).transform(
                        new StreamSource(xmlFile), new StreamResult(outputFile));
    }

    public String xsltProc(String xmlData, String xslData) throws IOException, URISyntaxException, TransformerException {
        StringWriter writer = new StringWriter();

        Source src = new StreamSource(new StringReader(xslData));
        Transformer transformer = TransformerFactory.newInstance().newTransformer(src);
        transformer.setOutputProperties(transformerSettings);
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new StreamSource(new StringReader(xmlData)), new StreamResult(writer));

        return writer.toString();
    }

    public static void main(String[] args) {
        try {
            File xslFile = new File("stylesheet.xsl");
            File xmlFile = new File("data.xml");
            File outputFile = new File("output.html");
            new XsltJava().xsltProc(xmlFile, xslFile, outputFile);
        } catch (Exception ex) {
            Logger.getLogger(XsltJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
