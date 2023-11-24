package com.aor.mouse.modelization.game.room;

import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.elements.*;

import java.util.List;

public class Room {
    private final int width;
    private final int height;

    private Mouse mouse;

    private List<Cat> cats;
    private List<Wall> walls;
    private List<Coin> coins;
    private Cheese cheese;
    private Heal heal;
    private Hole hole;
    int level;
    int score;
    boolean completed;

    public Room(int width, int height, int level, int score) {
        this.width = width;
        this.height = height;
        this.level = level;
        this.completed = false;
        this.score = score;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Cheese getCheese() {
        return this.cheese;
    }

    public void setHeal(Heal heal) {
        this.heal = heal;
    }

    public Heal getHeal() {
        return this.heal;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public Hole getHole() {
        return this.hole;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position)) {
                return false;
            }
        return true;
    }

    public boolean isCat(Position position) {
        for (Cat cat : cats)
            if (cat.getPosition().equals(position)) {
                return true;
            }
        return false;
    }

    public boolean isCoin(Position position) {
        boolean flag = false;
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean isCheese(Position position) {
        if (cheese.getPosition().equals(position)) {
            return true;
        }
        return false;
    }
    public boolean isHole(Position position) {
        if (hole.getPosition().equals(position)) {
            return true;
        }
        return false;
    }
    public boolean isHeal(Position position) {
        if (heal.getPosition().equals(position)) {
            return true;
        }
        return false;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return this.completed;
    }
    public int getLevel() {
        return this.level;
    }
    public int getScore() {return this.mouse.getScore();}
}

