import com.aor.mouse.modelization.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPosition {
    private Position p;

    @BeforeEach
    void setUp() {
        p = new Position(5,5);
    }

    @Test
    void getRight() {
        assertEquals(p.getRight(), new Position(6,5));
    }
    @Test
    void getLeft() {
        assertEquals(p.getLeft(), new Position(4,5));
    }
    @Test
    void getUp() {
        assertEquals(p.getUp(), new Position(5,4));
    }
    @Test
    void getDown() {
        assertEquals(p.getDown(), new Position(5,6));
    }
}
