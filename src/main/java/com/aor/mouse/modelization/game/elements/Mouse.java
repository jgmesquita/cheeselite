package com.aor.mouse.modelization.game.elements;

public class Mouse extends Element {
    private int HP;
    private int cheese;
    private int score;

    public Mouse(int x, int y) {
        super(x, y);
        this.HP = 100;
        this.cheese = 0;
        this.score = 0;
    }

    public void decreaseHP(int value) {
        if (this.HP - value <= 0) {
            this.HP = 0;
        }
        else {
            this.HP -= value;
        }
    }
    public void increaseHP(int value) {
        if (this.HP + value > 100) {
            this.HP = 100;
        }
        else {
            this.HP += value;
        }
    }

    public int getHP() {
        return HP;
    }
    public void setHP(int value) {
        this.HP = value;
    }
    public int getCheese() {
        return cheese;
    }

    public int getScore() {
        return score;
    }
    public void incrCheese() {
        this.cheese +=  1;
    }
    public void incrScore(int value) {
        this.score += value;
    }
}
