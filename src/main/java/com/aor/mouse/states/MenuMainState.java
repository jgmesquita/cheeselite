package com.aor.mouse.states;

import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.dynamic.menu.MenuMainController;
import com.aor.mouse.modelization.menu.MenuMain;
import com.aor.mouse.visualization.Viewer;
import com.aor.mouse.visualization.menu.MenuMainViewer;

public class MenuMainState extends State<MenuMain> {
    public MenuMainState(MenuMain model) {
        super(model);
    }

    @Override
    protected Viewer<MenuMain> getViewer() {
        return new MenuMainViewer(getModel());
    }

    @Override
    protected Controller<MenuMain> getController() {
        return new MenuMainController(getModel());
    }
}
