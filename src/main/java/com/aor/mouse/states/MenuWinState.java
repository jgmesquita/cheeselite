package com.aor.mouse.states;

import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.dynamic.menu.MenuWinController;
import com.aor.mouse.modelization.menu.MenuWin;
import com.aor.mouse.visualization.Viewer;
import com.aor.mouse.visualization.menu.MenuWinViewer;

public class MenuWinState extends State<MenuWin> {
    public MenuWinState(MenuWin model) {
        super(model);
    }

    @Override
    protected Viewer<MenuWin> getViewer() {
        return new MenuWinViewer(getModel());
    }

    @Override
    protected Controller<MenuWin> getController() {
        return new MenuWinController(getModel());
    }
}
