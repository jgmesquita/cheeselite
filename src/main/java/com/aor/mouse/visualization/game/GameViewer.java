package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.elements.Element;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.visualization.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Room> {
    public GameViewer(Room room) {
        super(room);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getCats(), new CatViewer());
        drawElement(gui, getModel().getMouse(), new MouseViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElement(gui, getModel().getHeal(), new HealViewer());
        drawElement(gui, getModel().getCheese(), new CheeseViewer());
        drawElement(gui, getModel().getHole(), new HoleViewer());

        gui.drawText(new Position(0, 0), "HP:" + getModel().getMouse().getHP(), "#FFD700");
        gui.drawText(new Position(8,0), "Score:" + getModel().getMouse().getScore(), "#FFD700");
        gui.drawText(new Position(20,0), "Cheese:" + getModel().getMouse().getCheese(), "#FFD700");
        gui.drawText(new Position(32,0), "Level:" + getModel().getLevel() , "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
