import com.aor.mouse.dynamic.game.MouseController;
import com.aor.mouse.modelization.Position;
import com.aor.mouse.modelization.game.room.Room;
import com.aor.mouse.modelization.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestMouseDynamic {
    private MouseController controller;
    private Mouse mouse;
    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room(20, 20, 0 ,1);
        mouse = new Mouse(2,2);
        room.setMouse(mouse);
        room.setWalls(Arrays.asList(new Wall(2, 3)));
        room.setCats(Arrays.asList(new Cat(1,1)));
        room.setCoins(Arrays.asList(new Coin(5,5)));
        room.setCheese(new Cheese(10,10));
        room.setHole(new Hole(0,0));
        room.setHeal(new Heal(6,6));
        controller = new MouseController(room);
    }

    @Test
    void moveHeroEmpty() {
        controller.moveMouseRight();
        controller.moveMouseRight();
        controller.moveMouseLeft();
        controller.moveMouseUp();
        controller.moveMouseDown();
        assertEquals(new Position(3,2), mouse.getPosition());
    }

    @Test
    void moveHeroNotEmpty() {
        controller.moveMouseDown();
        assertEquals(new Position(2, 2), mouse.getPosition());
    }

    @Test
    void interactCoin() {
        controller.moveMouse(new Position(5,5));
        assertEquals(100, mouse.getScore());
        assertEquals(0, room.getCoins().size());
    }

    @Test
    void interactCheese() {
        room.setCheese(new Cheese(4,2));
        controller.moveMouse(new Position(4,2));
        assertEquals(1, mouse.getCheese());
    }
    @Test
    void interactHeal() {
        mouse.setHP(60);
        controller.moveMouse(new Position(6,6));
        assertEquals(80, mouse.getHP());
    }
    @Test
    void interactMonster() {
        mouse.setHP(100);
        controller.moveMouse(new Position(1,1));
        assertEquals(70, mouse.getHP());
    }
    @Test
    void interactHoleWithoutCheese() {
        controller.moveMouse(new Position(0,0));
        assertFalse(room.isCompleted());
    }
    @Test
    void completeGame() {
        mouse.incrCheese();
        controller.moveMouse(new Position(0,0));
        assertTrue(room.isCompleted());
    }

}
