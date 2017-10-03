import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Administrator on 02/10/2017.
 */
public class Yleistieto2017GUI extends JFrame {

    public Yleistieto2017GUI(Visailu visa) {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel otsikko = new JLabel("Yleistieto2017\n");
        otsikko.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        JLabel kysymys = new JLabel(visa.getKysymysTeksti());

        JRadioButton rb1 = new JRadioButton(visa.getVastausVaihtoehdot().get(0).toString());
        JRadioButton rb2 = new JRadioButton(visa.getVastausVaihtoehdot().get(1).toString());
        JRadioButton rb3 = new JRadioButton(visa.getVastausVaihtoehdot().get(2).toString());

        rb1.setBounds(100, 50, 100, 30);
        rb2.setBounds(100, 100, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);


        JButton b = new JButton("Vastaa");
        b.addActionListener((ActionEvent event) -> {
            if (rb1.isSelected()) {
                visa.tarkistaVastaus("0");
            }
            if (rb2.isSelected()) {
                visa.tarkistaVastaus("1");
            }
            if (rb3.isSelected()) {
                visa.tarkistaVastaus("2");
            }
            if (visa.hasNextQuestion()) {
//                System.out.println("Vastaukset" + visa.getVastausVaihtoehdot());
                kysymys.setText(visa.getKysymysTeksti());

                rb1.setText(visa.getVastausVaihtoehdot().get(0).toString());
                rb2.setText(visa.getVastausVaihtoehdot().get(1).toString());
                rb3.setText(visa.getVastausVaihtoehdot().get(2).toString());
                bg.clearSelection();
            } else {
                JOptionPane.showMessageDialog(this, "Peli päättyi. Sait " + visa.getPisteet() + " pistettä kymmenestä!");
                System.exit(0);
            }
        });

        add(otsikko);
        add(kysymys);
        add(rb1);
        add(rb2);
        add(rb3);
        add(b);


        setTitle("GUI Test");
        setSize(600, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Visailu v = new Visailu();
        Yleistieto2017GUI game = new Yleistieto2017GUI(v);
    }
}
