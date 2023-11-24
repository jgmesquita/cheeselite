import com.aor.mouse.dynamic.game.CatController;
import com.aor.mouse.gui.GUI;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.modelization.game.elements.Cat;
import com.aor.mouse.modelization.game.elements.Mouse;
import com.aor.mouse.modelization.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestCatDynamic {
    private CatController controller;
    private Mouse mouse;
    private Room room;
    private Game game;

    @BeforeEach
    void setUp() {
        room = new Room(10,10, 1, 0);
        mouse = new Mouse(5, 5);
        room.setMouse(mouse);
        room.setWalls(Arrays.asList());
        room.setCats(Arrays.asList());
        controller = new CatController(room);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveCat() throws IOException {
        Cat cat = new Cat(5, 5);
        room.setCats(Arrays.asList(cat));
        controller.step(game, GUI.ACTION.NONE, 1000);
        assertNotEquals(new Position(5, 5), cat.getPosition());
    }
    @Test
    void moveCatClosed() throws IOException {
        Cat cat = new Cat(2, 2);
        room.setCats(Arrays.asList(cat));
        room.setWalls(Arrays.asList(new Wall(3, 2), new Wall(1, 2), new Wall(2, 3), new Wall(2, 1)));
        for (int i = 0; i < 10; i++) {
            controller.step(game, GUI.ACTION.NONE, 1000);
        }
        assertEquals(new Position(2, 2), cat.getPosition());
    }
}
