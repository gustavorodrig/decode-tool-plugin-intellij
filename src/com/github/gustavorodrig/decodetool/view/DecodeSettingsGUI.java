package com.github.gustavorodrig.decodetool.view;

import org.apache.commons.lang.StringUtils;

import javax.swing.*;

public class DecodeSettingsGUI {

    private JPanel rootPanel;
    private JTextField urlText;
    private JComboBox defaultMethodComboBox;

    public DecodeSettingsGUI() {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getText() {
        return this.urlText.getText();
    }

    public String getSelectedDefaultMethod() {
        return this.defaultMethodComboBox.getSelectedItem().toString();
    }

    public void setSavedUrlText(String text) {
        if (StringUtils.isNotEmpty(text)) {
            this.urlText.setText(text);
        }
    }

    public void setSavedDefaultMethod(String text) {
        if (StringUtils.isNotEmpty(text)) {
            this.defaultMethodComboBox.setSelectedItem(text);
        }
    }
}
