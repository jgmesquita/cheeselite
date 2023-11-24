package com.aor.mouse.modelization.game.room;
import com.aor.mouse.modelization.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRoom {
    int level;
    int score;
    public CreateRoom(int level, int score) {

        this.level = level;
        this.score = score;
    }
    public Mouse createMouse() {
        Mouse mouse = new Mouse(1,2);
        return mouse;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c <= 40; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, 20));
        }
        for (int r = 1; r <= 20; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(40, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            coins.add(new Coin(random.nextInt(30 - 2) + 1,random.nextInt(20 - 2) + 1));
        return coins;
    }
    private List<Cat> createCats() {
        int total_monster = 4;
        Random random = new Random();
        ArrayList<Cat> cats = new ArrayList<>();
        for (int i = 0; i < total_monster; i++)
            cats.add(new Cat(random.nextInt(30 - 2) + 1,random.nextInt(20 - 2) + 1));
        return cats;
    }

    private Cheese createCheese() {
        Random random = new Random();
        return new Cheese(random.nextInt(30 - 2) + 1,random.nextInt(20 - 2) + 1);

    }
    private Heal createHeal() {
        Random random = new Random();
        return new Heal(random.nextInt(30 - 2) + 1,random.nextInt(20 - 2) + 1);
    }

    public Room createArena() {
        Room room = new Room(40, 20, level, score);
        room.setMouse(createMouse());
        room.setCats(createCats());
        room.setWalls(createWalls());
        room.setCoins(createCoins());
        room.setCheese(createCheese());
        room.setHeal(createHeal());
        room.setHole(new Hole(1,1));
        return room;
    }
}
