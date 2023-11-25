package com.aor.mouse.visualization.menu;

import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.menu.MenuLose;
import com.aor.mouse.modelization.menu.MenuWin;
import com.aor.mouse.visualization.Viewer;

public class MenuLoseViewer extends Viewer<MenuLose> {
    public MenuLoseViewer(MenuLose menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Cheeseland", "#FFFF00");
        gui.drawText(new Position(5,7), "You lost the game!", "#FF0000");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 10 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00FF00" : "#FFFFFF");
    }
}
