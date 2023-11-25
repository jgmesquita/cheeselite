package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
