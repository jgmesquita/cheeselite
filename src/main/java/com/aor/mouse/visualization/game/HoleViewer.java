package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.Hole;

public class HoleViewer implements ElementViewer<Hole> {
    @Override
    public void draw(Hole hole, GUI gui) {gui.drawHole(hole.getPosition());
    }
}
