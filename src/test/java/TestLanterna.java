import com.aor.mouse.gui.LanternaGUI;
import com.aor.mouse.modelization.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestLanterna {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }
    @Test
    void drawMouse() {
        gui.drawMouse(new Position(5, 5));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 6, "M");
    }
    @Test
    void drawCoin() {
        gui.drawCoin(new Position(20,20));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0,255,0));
        Mockito.verify(tg, Mockito.times(1)).putString(20,21, "o");
    }
    @Test
    void drawWall() {
        gui.drawWall(new Position(15,15));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0,255,255));
        Mockito.verify(tg, Mockito.times(1)).putString(15,16, "#");
    }
    @Test
    void drawHole() {
        gui.drawHole(new Position(30,30));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,255,255));
        Mockito.verify(tg, Mockito.times(1)).putString(30,31, "^");
    }
    @Test
    void drawCat() {
        gui.drawCat(new Position(40,40));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,0,0));
        Mockito.verify(tg, Mockito.times(1)).putString(40,41, "=");
    }
    @Test
    void drawCheese() {
        gui.drawCheese(new Position(50,50));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,255,0));
        Mockito.verify(tg, Mockito.times(1)).putString(50,51, "*");
    }
    @Test
    void drawHeal() {
        gui.drawHeal(new Position(60,60));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0,0,255));
        Mockito.verify(tg, Mockito.times(1)).putString(60,61,"+");
    }
    @Test
    void drawText() {
        gui.drawText(new Position(10, 10), "Text", "#FFFFFF");
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(10, 10, "Text");
    }
}

