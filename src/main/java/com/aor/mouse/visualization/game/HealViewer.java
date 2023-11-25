package com.aor.mouse.visualization.game;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.Heal;

public class HealViewer implements ElementViewer<Heal> {
    @Override
    public void draw(Heal heal, GUI gui) {
        gui.drawHeal(heal.getPosition());
    }
}
