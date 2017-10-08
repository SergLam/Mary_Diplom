import tools.ColumnsAutoSizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

public class MainView implements MaincContract.IMainView{

    static JTabbedPane tabPane = new JTabbedPane();
    static MainPresenter mainPresenter;

    public static void main(String[] args) {
        init_main_frame();
        mainPresenter = new MainPresenter();
    }

    public static void init_main_frame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(800,600));

        frame.setContentPane(tabPane);
        frame.setTitle("Mary_Zinchenko_Magister_Work");

        init_calculations_tab();
        init_map_tab();

    }

    public static void init_calculations_tab(){
        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Широта");
        model.addColumn("Довгота");
        model.addColumn("Висота");
        model.addColumn("Час_польоту");
        model.addColumn("Номенклатура");
        model.addColumn("Кут тангажу");
        model.addColumn("Кут крену");
        model.addColumn("Kут нишпорення");



        JTable table = new JTable(model);
//        table.getModel().addTableModelListener(new TableModelListener() {
//            public void tableChanged(TableModelEvent e) {
//                ColumnsAutoSizer.sizeColumnsToFit(table);
//            }
//        });

        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        table.setFont(new Font("Serif", Font.PLAIN, 20));

        table.setFillsViewportHeight(true);

        JScrollPane spTable = new JScrollPane(table);

//        for(int i=0;i<100;i++){
//            model.addRow(new Object[] { String.valueOf(i),"2","3","4","5","6","7","8" });
//        }

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 2;
        c.ipady = 450;
        c.gridx = 0;
        c.gridy = 0;
        panel1.add(spTable,c);

        c.anchor = GridBagConstraints.SOUTHWEST;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.weightx = 0.1;
        c.gridy = 0;
        c.ipady =10;

        JPanel panel_btn = new JPanel(new FlowLayout());

        JButton open_btn = new JButton("Відкрити файл з вхідними даними");
        open_btn.setFont(new Font("Serif", Font.BOLD, 16));
        panel_btn.add(open_btn);
        open_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mainPresenter.open_file();
            }
        });


        JButton calc_btn = new JButton("Вирахувати параметри польоту");
        calc_btn.setFont(new Font("Serif", Font.BOLD, 16));
        panel_btn.add(calc_btn);

        JButton map_btn = new JButton("Побудувати траєкторію");
        map_btn.setFont(new Font("Serif", Font.BOLD, 16));
        panel_btn.add(map_btn);

        panel1.add(panel_btn,c);
//        panel1.add(new JButton("button"));

        tabPane.add("Обчислення", panel1);
    }



    public static void init_map_tab(){
        JPanel panel2 = new JPanel(new GridLayout());
        JLabel label2 = new JLabel("екенкуе");
        panel2.add(label2);
        tabPane.add("Траєкторія ЛА", panel2);
    }

    @Override
    public void show_input_data() {

    }

    @Override
    public void show_calculations() {

    }

    @Override
    public void show_map() {

    }
}
