package com.github.gustavorodrig.decodetool.action;

import com.github.gustavorodrig.decodetool.persistence.DecodeToolPersistance;
import com.github.gustavorodrig.decodetool.view.MainPopUpGUI;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class OpenPopUpAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        MainPopUpGUI mainPopUpGUI = new MainPopUpGUI();
        mainPopUpGUI.setSavedDecodeMethod(DecodeToolPersistance.getInstance().getDefaultMethod());
        mainPopUpGUI.show();

    }
}
