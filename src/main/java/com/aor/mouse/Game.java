package com.aor.mouse;

import com.aor.mouse.gui.LanternaGUI;
import com.aor.mouse.modelization.menu.MenuMain;
import com.aor.mouse.states.MenuMainState;
import com.aor.mouse.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    int score;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(41, 21);
        this.state = new MenuMainState(new MenuMain());
        this.score = 0;
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {

        this.state = state;
    }
    public void setScore(int value) {
        score += value;
    }
    public int getScore() {
        return this.score;
    }

    private void start() throws IOException {
        int FPS = 20;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
