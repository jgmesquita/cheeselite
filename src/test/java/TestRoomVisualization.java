import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.modelization.game.elements.*;
import com.aor.mouse.visualization.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class TestRoomVisualization {
    private GUI gui;
    private GameViewer viewer;
    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room(20, 20, 1, 0);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(room);
        room.setMouse(new Mouse(1, 1));
        room.setCats(Arrays.asList(new Cat(2, 2), new Cat(3, 3)));
        room.setWalls(Arrays.asList(new Wall(0, 0), new Wall(1, 0)));
        room.setCheese(new Cheese(9,9));
        room.setCoins(Arrays.asList(new Coin(1,0), new Coin(10,10)));
        room.setHeal(new Heal(5,5));
        room.setHole(new Hole(6,6));
    }

    @Test
    void drawMouse() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawMouse(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawMouse(Mockito.any(Position.class));
    }

    @Test
    void drawCats() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawCat(new Position(2, 2));
        Mockito.verify(gui, Mockito.times(1)).drawCat(new Position(3, 3));
        Mockito.verify(gui, Mockito.times(2)).drawCat(Mockito.any(Position.class));
    }

    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(0, 0));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(0, 0));
        Mockito.verify(gui, Mockito.times(2)).drawWall(Mockito.any(Position.class));
    }
    @Test
    void drawCoins() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(1, 0));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(10, 10));
        Mockito.verify(gui, Mockito.times(2)).drawCoin(Mockito.any(Position.class));
    }
    @Test
    void drawCheese() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawCheese(new Position(9, 9));
        Mockito.verify(gui, Mockito.times(1)).drawCheese(Mockito.any(Position.class));
    }
    @Test
    void drawHeal() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawHeal(new Position(5, 5));
        Mockito.verify(gui, Mockito.times(1)).drawHeal(Mockito.any(Position.class));
    }
    @Test
    void drawHole() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawHole(new Position(6, 6));
        Mockito.verify(gui, Mockito.times(1)).drawHole(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}

