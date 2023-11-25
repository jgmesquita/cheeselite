package com.aor.mouse.states;

import com.aor.mouse.modelization.menu.MenuLose;
import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.dynamic.menu.MenuLoseController;
import com.aor.mouse.visualization.Viewer;
import com.aor.mouse.visualization.menu.MenuLoseViewer;

public class MenuLoseState extends State<MenuLose> {
    public MenuLoseState(MenuLose model) {
        super(model);
    }

    @Override
    protected Viewer<MenuLose> getViewer() {
        return new MenuLoseViewer(getModel());
    }

    @Override
    protected Controller<MenuLose> getController() {
        return new MenuLoseController(getModel());
    }
}
