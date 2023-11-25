package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.Mouse;

public class MouseViewer implements ElementViewer<Mouse> {
    @Override
    public void draw(Mouse mouse, GUI gui) {gui.drawMouse(mouse.getPosition());
    }
}
