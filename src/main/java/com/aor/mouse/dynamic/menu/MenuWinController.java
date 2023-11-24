package com.aor.mouse.dynamic.menu;

import com.aor.mouse.Game;
import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.room.CreateRoom;
import com.aor.mouse.modelization.menu.MenuWin;
import com.aor.mouse.states.GameState;

import java.io.IOException;

public class MenuWinController extends Controller<MenuWin> {
    public MenuWinController(MenuWin menu) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new CreateRoom(1,0).createArena()));
        }
    }
}
