package com.aor.mouse.dynamic.menu;

import com.aor.mouse.Game;
import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.menu.MenuGuide;
import com.aor.mouse.modelization.menu.MenuMain;
import com.aor.mouse.states.MenuMainState;

import java.io.IOException;

public class MenuGuideController extends Controller<MenuGuide> {
    public MenuGuideController(MenuGuide menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                }
                if (getModel().isSelectedBack()) {
                    game.setState(new MenuMainState(new MenuMain()));
                }
        }
    }
}
