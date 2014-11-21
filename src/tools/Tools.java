package tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tools {

    /**
     * Returns the character encoding of an input stream containin an XML file.<br/>
     *
     * The encoding is detected using the guidelines specified in the
     * <a href='http://www.w3.org/TR/xml/#sec-guessing'>XML W3C Specification</a>, and the method was designed to be as fast as possible, without extensive string operations or regular
     * expressions<br/> <br/>
     *
     * <code>
     * A sample use would be<br/><br/>
     * InputStream in = ...; <br/>
     * String encoding = detectEncoding(in);<br/>
     * BufferedReader reader = new BufferedReader(new InputStreamReader(in,encoding)); <br/>
     * </code><br/>
     *
     * and from that point you can happily read text from the input stream.
     *
     * @param in Stream containing the data to be read. The stream must support mark()/reset(), otherwise the caller should wrap that stream in a {@link BufferedInputStream} before invokin the method.
     * After the call, the stream is positioned at the &lt; character (this means that if there were any byte-order-marks, they are skipped).
     *
     * @return Detected encoding, using the canonical name in java.io (see <a href= 'http://java.sun.com/j2se/1.4.2/docs/guide/intl/encoding.doc.html'>Supported Encodings</a> ).
     *
     * @throws java.io.IOException
     */
    public static String detectEncoding(InputStream in) throws IOException {
        int read;
        String encoding = null;
        in.mark(400);
        boolean readEncoding = false;
        byte[] buffer = new byte[400];
        in.read(buffer, 0, 4);
        switch (buffer[0]) {
            case (byte) 0x00:
                if (buffer[1] == (byte) 0x00 && buffer[2] == (byte) 0xFE
                        && buffer[3] == (byte) 0xFF) {
                    encoding = "UTF-32BE";
                } else if (buffer[1] == (byte) 0x00 && buffer[2] == (byte) 0x00
                        && buffer[3] == (byte) 0x3C) {
                    encoding = "UTF-32BE";
                    readEncoding = true;
                } else if (buffer[1] == (byte) 0x3C && buffer[2] == (byte) 0x00
                        && buffer[3] == (byte) 0x3F) {
                    encoding = "UTF-32BE"; //"UnicodeBigUnmarked";
                    readEncoding = true;
                }
                break;
            case (byte) 0xFF:
                if (buffer[1] == (byte) 0xFE && buffer[2] == (byte) 0x00
                        && buffer[3] == (byte) 0x00) {
                    encoding = "UTF-32LE";
                } else if (buffer[1] == (byte) 0xFE) {
                    encoding = "UTF-32LE"; //"UnicodeLittleUnmarked";
                }
                break;

            case (byte) 0x3C:
                readEncoding = true;
                if (buffer[1] == (byte) 0x00 && buffer[2] == (byte) 0x00
                        && buffer[3] == (byte) 0x00) {
                    encoding = "UTF-32LE";
                } else if (buffer[1] == (byte) 0x00 && buffer[2] == (byte) 0x3F
                        && buffer[3] == (byte) 0x00) {
                    encoding = "UTF-32LE"; //"UnicodeLittleUnmarked";
                } else if (buffer[1] == (byte) 0x3F && buffer[2] == (byte) 0x78
                        && buffer[3] == (byte) 0x6D) {
                    encoding = "ASCII";
                }
                break;
            case (byte) 0xFE:
                if (buffer[1] == (byte) 0xFF) {
                    encoding = "UTF-32BE"; //"UnicodeBigUnmarked";
                }
                break;
            case (byte) 0xEF:
                if (buffer[1] == (byte) 0xBB && buffer[2] == (byte) 0xBF) {
                    encoding = "UTF-8";
                }
                break;
            case (byte) 0x4C:
                if (buffer[1] == (byte) 0x6F && buffer[2] == (byte) 0xA7
                        && buffer[3] == (byte) 0x94) {
                    encoding = "IBM037";
                }
                break;
            case (byte) 0x3F:
                if (buffer[1] == (byte) 0x3F) {
                    encoding = "windows-1252";
                }
                break;
        }
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }
        if (readEncoding) {
            read = in.read(buffer, 4, buffer.length - 4);
            Charset cs = Charset.forName(encoding);
            String s = new String(buffer, 4, read, cs);
            int pos = s.indexOf("encoding");
            if (pos == -1) {
                encoding = System.getProperty("file.encoding");
            } else {
                char delim = '\'';
                int startA = s.indexOf('\'', pos);
                int startB = s.indexOf('\"', pos);
                if (startA == -1) {
                    delim = '\"';
                    startA = startB;
                }
                if (startA > startB) {
                    delim = '\"';
                }
                int start = Math.min(startA, startB);
                int end = s.indexOf(delim, start + 1);
                if (end == -1) {
                    System.err.println("notifyEncodingError(buffer)");
                }
                encoding = s.substring(start + 1, end);
            }
        }

        in.close();

        return encoding;
    }

    public static String detectEncoding(File file) throws FileNotFoundException, IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        String guessedEncoding = Tools.detectEncoding(bis);
        bis.close();

        return guessedEncoding;
    }

    public static void main(String[] args) {
        try {
            File[] files = new File(System.getProperty("user.dir")).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    FileInputStream fis = new FileInputStream(file);
                    String guessedEncoding = Tools.detectEncoding(fis);
                    System.out.println(String.format("%s -> %s", file.getName(), guessedEncoding));
                    fis.close();
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
