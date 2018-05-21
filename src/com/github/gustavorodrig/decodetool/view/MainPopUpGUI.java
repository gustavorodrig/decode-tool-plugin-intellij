package com.github.gustavorodrig.decodetool.view;

import com.github.gustavorodrig.decodetool.model.DecodeType;
import com.github.gustavorodrig.decodetool.service.DecodeService;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.event.*;

public class MainPopUpGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton decodeButton;
    private JTextArea textArea;
    private JCheckBox copyToClipboardCheckBox;
    private JComboBox decodeMethod;

    public MainPopUpGUI() {
        setContentPane(contentPane);
        setTitle("Decode Tool");
        setSize(900,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        decodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDecrypt();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onDecrypt() {
        String text = textArea.getText();
        String decodeMethod = this.decodeMethod.getSelectedItem().toString();

        DecodeService service = new DecodeService();
        String textDecoded = service.decode(text, DecodeType.getByValue(decodeMethod), copyToClipboardCheckBox.isSelected());
        textArea.setText(textDecoded);
    }

    private void onCancel() {
         dispose();
    }

    public static void main(String[] args) {
        MainPopUpGUI dialog = new MainPopUpGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void setSavedDecodeMethod(String value){
        if(StringUtils.isNotEmpty(value)) {
            this.decodeMethod.setSelectedItem(value);
        }
    }
}
