
package nl.ordina.springcourse;

import nl.ordina.springcourse.model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private Game game;
    private Person player1;
    private Person player2;

    @Before
    public void setUp() {
        this.player1 = mock(Person.class);
        this.player2 = mock(Person.class);
        this.game = new Game(this.player1, this.player2);
    }

    @Test
    public void player1() {
        when(this.player1.getValue()).thenReturn(1);
        when(this.player2.getValue()).thenReturn(0);
        final String play = this.game.play();
        assertEquals("Player1 has won", play);
    }
    @Test
    public void player2() {
        when(this.player1.getValue()).thenReturn(0);
        when(this.player2.getValue()).thenReturn(1);
        final String play = this.game.play();
        assertEquals("Player2 has won", play);
    }
}