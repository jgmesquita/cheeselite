package com.aor.mouse.dynamic.game;

import com.aor.mouse.Game;
import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.modelization.game.room.CreateRoom;
import com.aor.mouse.modelization.menu.MenuLose;
import com.aor.mouse.modelization.menu.MenuWin;
import com.aor.mouse.states.GameState;
import com.aor.mouse.states.MenuLoseState;
import com.aor.mouse.states.MenuWinState;

import java.io.IOException;

public class RoomController extends GameController {
    private final MouseController mouseController;
    private final CatController catController;

    public RoomController(Room room) {
        super(room);
        this.mouseController = new MouseController(room);
        this.catController = new CatController(room);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getMouse().getHP() == 0)
            game.setState(new MenuLoseState(new MenuLose()));
        else if (getModel().isCompleted() && getModel().getLevel() == 3) {
            game.setState(new MenuWinState(new MenuWin()));
        }
        else if (getModel().isCompleted() && getModel().getLevel() == 1) {
            game.setScore(getModel().getScore());
            game.setState(new GameState(new CreateRoom(2, game.getScore()).createArena()));
        }
        else if (getModel().isCompleted() && getModel().getLevel() == 2) {
            game.setScore(getModel().getScore());
            game.setState(new GameState(new CreateRoom(3, game.getScore()).createArena()));
        }
        else {
            mouseController.step(game, action, time);
            catController.step(game, action, time);
        }
    }
}