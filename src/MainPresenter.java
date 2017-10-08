import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Serg on 08.10.2017.
 */
public class MainPresenter implements MaincContract.IMainPresenter {

    public MainPresenter() {

    }

    @Override
    public void open_file() {
        JFileChooser fileopen = new JFileChooser(System.getProperty("user.home"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileopen.setFileFilter(filter);
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            String data = read_file( file.getAbsolutePath());
            parse_data(data);
        }
    }

    @Override
    public void parse_data(String data) {
        System.out.println(data);
    }

    @Override
    public String read_file(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    @Override
    public void calculate_fly_params() {

    }

    @Override
    public void build_map() {

    }

}
