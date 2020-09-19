package Lesson_4_Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModeListener implements ActionListener {
    private final JButton hexButton = new JButton("HEX");
    private final JButton sqrtButton = new JButton("sqrt");
    private final List<JButton> currentButtons;
    private final JPanel currentPanel;

    public ModeListener(List<JButton> currentButtons, JPanel currentPanel) {
        this.currentButtons = currentButtons;
        this.currentPanel = currentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonMode mode = (ButtonMode)
                ((JComboBox<String>) e.getSource()).getModel().getSelectedItem();
        switch (mode) {
            case BASIC: {
                currentPanel.remove(hexButton);
                currentPanel.remove(sqrtButton);
                break;
            }
            case ENGINEER: {
                currentPanel.remove(hexButton);
                currentPanel.add(sqrtButton);
                break;
            }
            case PROGRAMMING: {
                currentPanel.remove(sqrtButton);
                currentPanel.add(hexButton);
                break;
            }
        }

        currentPanel.revalidate();
        currentPanel.repaint();

    }
}
