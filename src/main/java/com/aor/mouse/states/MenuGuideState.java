package com.aor.mouse.states;

import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.dynamic.menu.MenuGuideController;
import com.aor.mouse.modelization.menu.MenuGuide;
import com.aor.mouse.visualization.Viewer;
import com.aor.mouse.visualization.menu.MenuGuideViewer;

public class MenuGuideState extends State<MenuGuide> {
    public MenuGuideState(MenuGuide model) {
        super(model);
    }

    @Override
    protected Viewer<MenuGuide> getViewer() {
        return new MenuGuideViewer(getModel());
    }

    @Override
    protected Controller<MenuGuide> getController() {
        return new MenuGuideController(getModel());
    }
}

