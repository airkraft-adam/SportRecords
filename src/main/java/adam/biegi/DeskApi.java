package adam.biegi;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@Component
public class DeskApi extends JFrame implements ActionListener {


    Controler controler;


    TextField jeden;
    TextField dwa;
    TextField trzy;
    String imie;
    String nazwisko;
    String czas;
    Label label1;
    Label label2;
    Label label3;
    DefaultTableModel defaultTableModel;

    public DeskApi(Controler contr) {
        controler = contr;

        setLayout(null);
        setSize(900, 800);
        setTitle("Bieg Api");

        ImageIcon imgicon = new ImageIcon("c:/ws/biegi/biegacz.jpg", "zdj");
        JLabel image = new JLabel(imgicon);
        image.setBounds(500, 10, 300, 385);
        add(image);

        Label hedder = new Label("Wyniki biegu 10km");
        hedder.setBounds(100, 0, 400, 30);
        hedder.setVisible(true);
        Font fontBold = new Font("TimesNewRoman", Font.BOLD, 28);
        hedder.setFont(fontBold);
        Label opis = new Label("Api organizatora");
        opis.setBounds(100, 40, 300, 30);
        opis.setVisible(true);
        Font font = new Font("Courier", Font.ITALIC, 22);
        opis.setFont(font);
        label1 = new Label("podaj imie");
        label1.setBounds(50, 150, 100, 30);
        label2 = new Label("podaj nazwisko");
        label2.setBounds(175, 1500, 100, 30);
        label3 = new Label("podaj czas: HH:mm:ss");
        label3.setBounds(300, 150, 130, 30);

        jeden = new TextField();
        jeden.setBounds(50, 180, 100, 30);
        jeden.setText("imie");
        dwa = new TextField();
        dwa.setText("nazwisko");
        dwa.setBounds(175, 180, 100, 30);
        trzy = new TextField();
        trzy.setText("czas");
        trzy.setBounds(300, 180, 100, 30);

        JButton button1 = new JButton("OK");
        button1.setBounds(350, 250, 80, 20);
        button1.addActionListener(this);

       addtable();

        add(label1);
        add(label2);
        add(label3);
        add(dwa);
        add(trzy);
        add(jeden);
        add(opis);
        add(hedder);
        add(button1);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String imie = jeden.getText();
        String nazwisko = dwa.getText();
        String czas = trzy.getText();
        Runner runner = new Runner(imie, nazwisko, czas);
        controler.addRunner(runner);
        addtable();
    }
    public void addtable(){

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        JTable tabela = new JTable(defaultTableModel);

        defaultTableModel.addColumn("id");
        defaultTableModel.addColumn("imie");
        defaultTableModel.addColumn("nazwisko");
        defaultTableModel.addColumn("czas");

        for (Runner runne : controler.getAllRunners()) {
            defaultTableModel.addRow(new Object[]{
                            runne.getId(),
                            runne.getImie(),
                            runne.getNazwisko(),
                            runne.getCzas()
                    }
            );
        }
        JScrollPane jScrollPane = new JScrollPane(tabela);
        jScrollPane.setBounds(80, 400, 700, 200);
        add(jScrollPane);
    }
}

