package com.aor.mouse.gui;

import com.aor.mouse.modelization.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawMouse(Position position);

    void drawWall(Position position);

    void drawCat(Position position);

    void drawCoin(Position position);

    void drawCheese(Position position);

    void drawHeal(Position position);

    void drawHole(Position position);
    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
