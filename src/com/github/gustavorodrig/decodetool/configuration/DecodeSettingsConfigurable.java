package com.github.gustavorodrig.decodetool.configuration;

import com.github.gustavorodrig.decodetool.persistence.DecodeToolPersistance;
import com.github.gustavorodrig.decodetool.view.DecodeSettingsGUI;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import javax.swing.*;

public class DecodeSettingsConfigurable implements SearchableConfigurable {

    private DecodeSettingsGUI gui;
    private final DecodeToolPersistance persistance;

    public DecodeSettingsConfigurable() {
        persistance = DecodeToolPersistance.getInstance();
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Decode Tool";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "preference.DecodeSettingsConfigurable";
    }

    @NotNull
    @Override
    public String getId() {
        return "preference.DecodeSettingsConfigurable";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String s) {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        gui = new DecodeSettingsGUI();
        gui.setSavedUrlText(persistance.getUrl());
        gui.setSavedDefaultMethod(persistance.getDefaultMethod());
        return gui.getRootPanel();
    }

    @Override
    public boolean isModified() {
        if(!gui.getText().equals(persistance.getUrl()) || !gui.getSelectedDefaultMethod().equals(persistance.getDefaultMethod())){
            return true;
        }
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {
        persistance.setUrl(gui.getText());
        persistance.setDefaultMethod(gui.getSelectedDefaultMethod());
    }

    @Override
    public void reset() {
    }

    @Override
    public void disposeUIResources() {
        gui = null;
    }
}
