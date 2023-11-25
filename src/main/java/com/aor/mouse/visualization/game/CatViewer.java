package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.Cat;

public class CatViewer implements ElementViewer<Cat> {
    @Override
    public void draw(Cat cat, GUI gui) {
        gui.drawCat(cat.getPosition());
    }
}
