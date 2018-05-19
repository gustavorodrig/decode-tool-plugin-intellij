package com.github.gustavorodrig.decodetool.view;

import com.github.gustavorodrig.decodetool.util.DecodeUtil;
import com.github.gustavorodrig.decodetool.util.SystemUtil;

import javax.swing.*;
import java.awt.event.*;

public class MainPopUp extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton decodeButton;
    private JTextArea textArea;
    private JCheckBox copyToClipboardCheckBox;

    public MainPopUp() {
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
        String textDecoded = DecodeUtil.decodeBase64(text);
        SystemUtil.copyToClipBoard(textDecoded);
        textArea.setText(textDecoded);
    }

    private void onCancel() {
         dispose();
    }

    public static void main(String[] args) {
        MainPopUp dialog = new MainPopUp();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
