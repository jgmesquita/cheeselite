import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.game.elements.*;
import com.aor.mouse.visualization.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestElementVisualization {
    private Mouse mouse;
    private Coin coin;
    private Hole hole;
    private Cheese cheese;
    private Wall wall;
    private Cat cat;
    private Heal heal;
    private MouseViewer mouseViewer;
    private CatViewer catViewer;
    private HealViewer healViewer;
    private WallViewer wallViewer;
    private CoinViewer coinViewer;
    private HoleViewer holeViewer;
    private CheeseViewer cheeseViewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        mouse = new Mouse(10, 10);
        cat = new Cat(20,20);
        coin = new Coin(30,30);
        hole = new Hole(40,40);
        cheese = new Cheese(50,50);
        wall = new Wall(60,60);
        heal = new Heal(70,70);
        mouseViewer = new MouseViewer();
        catViewer = new CatViewer();
        coinViewer = new CoinViewer();
        holeViewer = new HoleViewer();
        cheeseViewer = new CheeseViewer();
        wallViewer = new WallViewer();
        healViewer = new HealViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawMouse() {
        mouseViewer.draw(mouse, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMouse(mouse.getPosition());
    }
    @Test
    void drawCat() {
        catViewer.draw(cat, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCat(cat.getPosition());
    }
    @Test
    void drawCoin() {
        coinViewer.draw(coin, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCoin(coin.getPosition());
    }
    @Test
    void drawHole() {
        holeViewer.draw(hole, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHole(hole.getPosition());
    }
    @Test
    void drawCheese() {
        cheeseViewer.draw(cheese, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCheese(cheese.getPosition());
    }
    @Test
    void drawWall() {
        wallViewer.draw(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
    @Test
    void drawHeal() {
        healViewer.draw(heal, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHeal(heal.getPosition());
    }
}

