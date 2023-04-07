import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.*;

public class DrinkCalc{
    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(6,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,600);
        frame.setLocation(0,0);
        frame.setTitle("Получить кофе");
        frame.setVisible(true);

        final JComboBox drinkType = new JComboBox<String>(new String[] {"Американо", "Мокачино", "Эспрессо"});
        final JTextField drinkNum = new JTextField();
        final JRadioButton sugarNum = new JRadioButton("Нужен сахар");
        final JCheckBox isMilkNeeded = new JCheckBox("Нужны сливки");
        final JButton submitBtn = new JButton("Заказать!");
        final JTextField endField = new JTextField();

        frame.add(drinkType);
        frame.add(drinkNum);
        frame.add(sugarNum);
        frame.add(isMilkNeeded);
        frame.add(submitBtn);
        frame.add(endField);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float end = 0;
                int drink = Integer.parseInt(drinkNum.getText());

                switch(drinkType.getSelectedItem().toString()) {
                    case "Американо": end += 100 * drink; break;
                    case "Мокачино": end += 200 * drink; break;
                    case "Эспрессо": end += 300 * drink; break;
                }

                if (sugarNum.isSelected()) end +=20 * drink;

                if (isMilkNeeded.isSelected()) end +=10 * drink;

                frame.add(endField);

                endField.setText("Итог по заказу: " + String.valueOf(end));
            }
        });
    }
}