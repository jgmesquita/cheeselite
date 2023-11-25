package com.aor.mouse.visualization.menu;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.menu.MenuGuide;

import com.aor.mouse.visualization.Viewer;

public class MenuGuideViewer extends Viewer<MenuGuide> {
    public MenuGuideViewer(MenuGuide menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(3, 3), "Cheeseland", "#FFFF00");
        gui.drawText(new Position(1,7), "Welcome to Cheeseland!", "#FFFFFF");
        gui.drawText(new Position(1, 9), "You were chosen to save the world!", "#FFFFFF");
        gui.drawText(new Position (1, 11), "Grab the cheese and the coins!", "#FFFF00");
        gui.drawText(new Position(1, 13),"Bring them back to the hole", "#FFFFFF");
        gui.drawText(new Position(1, 15), "Be careful the red Cats!", "#FFFFFF");
        gui.drawText(new Position(1, 17),"They will try to hurt you!", "#FF0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(30, 3 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00FF00" : "#FFFFFF");
    }
}

