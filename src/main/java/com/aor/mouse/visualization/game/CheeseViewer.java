package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.Cheese;

public class CheeseViewer implements ElementViewer<Cheese> {
    @Override
    public void draw(Cheese cheese, GUI gui) {gui.drawCheese(cheese.getPosition());
    }
}
