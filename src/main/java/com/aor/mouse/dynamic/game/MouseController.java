package com.aor.mouse.dynamic.game;

import com.aor.mouse.Game;
import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.modelization.game.elements.Cheese;
import com.aor.mouse.modelization.game.elements.Heal;

public class MouseController extends GameController {
    public MouseController(Room room) {
        super(room);
    }

    public void moveMouseLeft() {
        moveMouse(getModel().getMouse().getPosition().getLeft());
    }

    public void moveMouseRight() {
        moveMouse(getModel().getMouse().getPosition().getRight());
    }

    public void moveMouseUp() {moveMouse(getModel().getMouse().getPosition().getUp());
    }

    public void moveMouseDown() {
        moveMouse(getModel().getMouse().getPosition().getDown());
    }

    public void moveMouse(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getMouse().setPosition(position);
            if (getModel().isCat(position)) {
                getModel().getMouse().decreaseHP(30);}
            if (getModel().isCheese(position)) {
                getModel().setCheese(new Cheese(1000,1000));
                getModel().getMouse().incrCheese();
            }
            if (getModel().isHeal(position)) {
                getModel().getMouse().increaseHP(20);
                getModel().setHeal(new Heal(1000,1000));
            }
            if (getModel().isCoin(position)) {
                getModel().getMouse().incrScore(100);
            }
            if (getModel().isHole(position) && getModel().getMouse().getCheese() == 1) {
                getModel().setCompleted();
            }
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveMouseUp();
        if (action == GUI.ACTION.RIGHT) moveMouseRight();
        if (action == GUI.ACTION.DOWN) moveMouseDown();
        if (action == GUI.ACTION.LEFT) moveMouseLeft();
    }
}
