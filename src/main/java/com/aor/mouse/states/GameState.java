package com.aor.mouse.states;

import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.dynamic.game.RoomController;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.visualization.Viewer;
import com.aor.mouse.visualization.game.GameViewer;

public class GameState extends State<Room> {
    public GameState(Room room) {
        super(room);
    }

    @Override
    protected Viewer<Room> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Room> getController() {
        return new RoomController(getModel());
    }
}
