package com.github.gustavorodrig.decodetool.action;

import com.github.gustavorodrig.decodetool.view.MainPopUp;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class OpenPopUpAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        MainPopUp mainPopUp = new MainPopUp();
        mainPopUp.show();

    }
}
