import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Generator {

    private static String fileOutputPath = null;
    // read template

    public static void generate() {
        System.out.println("files will be generated ...");

        // Select File

        // Read File
        String result = null;
        try {
            result = readFile(fileOutputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = result.replaceAll("cooperation", "XXXXXXXXXXXXXXXXXXXXXX");

        // Process String
        System.out.println(result);
        // create header

        // replace template
        genDoc(result);
        // output to doc

    }

    public static void setOutputFilePath(String fileOutputPath) {
        // TODO Auto-generated method stub
        Generator.fileOutputPath = fileOutputPath;
    }

    private static String readFile(String file) throws IOException {
        System.out.println(fileOutputPath);
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    private static void genDoc(String string) {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText(string);
        tmpRun.setFontSize(18);
        try {
            document.write(new FileOutputStream(new File(System.getProperty("user.home") + File.separator + "DESKTOP" + File.separator + "aaaa.docx")));
            System.out.println("DONE");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
