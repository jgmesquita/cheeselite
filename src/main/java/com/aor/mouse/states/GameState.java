package com.aor.mouse.states;

import com.aor.mouse.dynamic.Controller;
import com.aor.mouse.dynamic.game.ArenaController;
import com.aor.mouse.modelization.game.arena.Arena;
import com.aor.mouse.visualization.Viewer;
import com.aor.mouse.visualization.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
