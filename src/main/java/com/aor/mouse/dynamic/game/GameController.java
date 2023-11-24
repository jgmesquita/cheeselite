package com.aor.mouse.dynamic.game;

import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.modelization.game.room.Room;

public abstract class GameController extends Controller<Room> {
    public GameController(Room room) {
        super(room);
    }
}
