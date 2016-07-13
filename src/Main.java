import java.io.File;
import java.nio.file.FileSystemLoopException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {

    private Shell shell;
    private Text text_company;
    private Text text_company_short_name;
    private Text text_HR;
    private Text text_position_name;

    private static String strDesktop = "DESKTOP";

    // MAIN class here
    public static void main(String[] args) {
        try {
            Main window = new Main();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();

        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {

        // shells ------------------------------------------------------------------
        shell = new Shell((SWT.CLOSE | SWT.MIN | SWT.TITLE) & (~SWT.RESIZE));
        shell.setSize(450, 450);
        shell.setText("Cover Letter Generator");

        // buttons ------------------------------------------------------------------
        Button btnGenerate = new Button(shell, SWT.NONE);
        btnGenerate.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                Generator.generate();

            }

        });
        btnGenerate.setBounds(340, 387, 94, 25);
        btnGenerate.setText("Generate");

        Button btnLoadTemplates = new Button(shell, SWT.NONE);
        btnLoadTemplates.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                FileDialog dialog = new FileDialog(shell, SWT.OPEN);
                dialog.setFilterPath(System.getProperty("user.home") + File.separator + strDesktop);
                String fileOutputPath = dialog.open();
                
                Generator.setOutputFilePath(fileOutputPath);
                System.out.println(fileOutputPath);
                
                
                System.out.println(fileOutputPath);
            }
        });
        btnLoadTemplates.setBounds(239, 20, 94, 25);
        btnLoadTemplates.setText("Load templates");

        Button btnOutputFolder = new Button(shell, SWT.NONE);
        btnOutputFolder.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);
                dialog.setFilterPath(System.getProperty("user.home") + File.separator + strDesktop);
                String fileOutputPath = dialog.open();
              

            }
        });
        btnOutputFolder.setBounds(239, 108, 94, 25);
        btnOutputFolder.setText("Output folder");

        Button btnSample = new Button(shell, SWT.NONE);
        btnSample.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                // reset the text after clicking the reset btn
                text_company.setText("XYZ_CORP");

                text_company_short_name.setText("XYZ");

                text_HR.setText("Mr. Smith");

                text_position_name.setText("Junior Software Developer");
            }
        });
        btnSample.setBounds(10, 387, 110, 25);
        btnSample.setText("Sample");

        Button btnReset = new Button(shell, SWT.NONE);
        btnReset.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                text_company.setText("");

                text_company_short_name.setText("");

                text_HR.setText("");

                text_position_name.setText("");
            }
        });
        btnReset.setBounds(10, 356, 110, 25);
        btnReset.setText("Empty");

        // labels ------------------------------------------------------------------
        Label lblCompanyName = new Label(shell, SWT.NONE);
        lblCompanyName.setBounds(10, 10, 103, 21);
        lblCompanyName.setText("Company Name");

        Label lblShortCompanyName = new Label(shell, SWT.NONE);
        lblShortCompanyName.setBounds(10, 64, 128, 20);
        lblShortCompanyName.setText("Short Company Name");

        Label lblHrName = new Label(shell, SWT.NONE);
        lblHrName.setBounds(10, 113, 65, 21);
        lblHrName.setText("HR name");

        Label lblPositionName = new Label(shell, SWT.NONE);
        lblPositionName.setBounds(10, 167, 94, 15);
        lblPositionName.setText("Position Name");
        
        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setBounds(239, 51, 195, 33);
        lblNewLabel.setText("Template Path");
        
        Label lblNewLabel_1 = new Label(shell, SWT.NONE);
        lblNewLabel_1.setBounds(239, 146, 195, 36);
        lblNewLabel_1.setText("Output folder");
        
        

        // vertical bar ------------------------------------------------------------------
        Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
        label.setBounds(231, 10, 2, 402);

        // text fields ------------------------------------------------------------------
        text_company = new Text(shell, SWT.BORDER);
        text_company.setBounds(10, 37, 203, 21);
        text_company.setText("XYZ_CORP");

        text_company_short_name = new Text(shell, SWT.BORDER);
        text_company_short_name.setBounds(10, 86, 203, 21);
        text_company_short_name.setText("XYZ");

        text_HR = new Text(shell, SWT.BORDER);
        text_HR.setBounds(10, 140, 203, 21);
        text_HR.setText("Mr. Smith");

        text_position_name = new Text(shell, SWT.BORDER);
        text_position_name.setBounds(10, 188, 203, 21);
        text_position_name.setText("Junior Software Developer");
        


    }
}
