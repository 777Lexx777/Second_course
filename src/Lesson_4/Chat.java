package Lesson_4;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Chat extends JFrame {
    public Chat() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(5, 5, 300, 500));
        setLayout(new GridLayout(2, 1));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout());
        JTextArea inputField = new JTextArea();
        inputField.setEditable(false);
        inputPanel.add(inputField);

        JPanel dialPanel = new JPanel();
        dialPanel.setLayout(new GridLayout(2, 1));
        JTextField dialField = new JTextField();
        JButton button = new JButton("Enter");

        dialPanel.add(dialField);
        dialPanel.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {

                inputField.setText(inputField.getText() + "\n" + dialField.getText());
                dialField.setText(" ");
            }
        });
        dialField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {

                inputField.setText(inputField.getText() + "\n" + dialField.getText());
                dialField.setText(" ");
            }
        });

        add(inputPanel);
        add(dialPanel);
        setVisible(true);
    }
}
