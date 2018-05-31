import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GooseGameTest {


    private GooseGame game;

    @Before
    public void setUp() throws Exception {
        game = new GooseGame();
        Player player1= new Player("pippo");
        Player player2 = new Player("pluto");

    }

    @Test
    public void add_one_player_return_string() {

        assertEquals("players: pippo", game.writeInstruction("add player pippo"));
    }

    @Test
    public void add_two_player_return_string() {
         game.writeInstruction("add player pippo");
        assertEquals("players: pippo, pluto", game.writeInstruction("add player pluto"));
    }

    @Test
    public void add_duplicate_players_return_string() {
        game.writeInstruction("add player pippo");
        game.writeInstruction("add player pluto");

        assertEquals("pippo: already existing player", game.writeInstruction("add player pippo"));
    }

    @Test
    public void move_player_from_Start_to_6() {
        assertEquals("pippo rolls 4, 2. pippo moves from Start to 6", game.writeInstruction("move pippo 4, 2"));
    }

    @Test
    public void move_player_from_Start_to_4() {
        assertEquals("pluto rolls 2, 2. pippo moves from Start to 4", game.writeInstruction("move pluto 2, 2"));
    }

    @Test
    @Ignore
    public void move_player_from_last_position_to_next() {
        assertEquals("pippo rolls 2, 3. pippo moves from 6 to 11", game.writeInstruction("move pippo 6, 11"));
    }


}