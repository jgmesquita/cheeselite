package com.aor.mouse.dynamic.game;

import com.aor.mouse.Game;
import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.modelization.game.elements.Cat;

import java.io.IOException;

public class CatController extends GameController {
    private long lastMovement;

    public CatController(Room room) {
        super(room);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Cat cat : getModel().getCats())
                moveCat(cat, cat.getPosition().getRandom());
            this.lastMovement = time;
        }
    }

    private void moveCat(Cat cat, Position position) {
        if (getModel().isEmpty(position)) {
            cat.setPosition(position);
            if (getModel().getMouse().getPosition().equals(position))
                getModel().getMouse().decreaseHP(30);
        }
    }
}
