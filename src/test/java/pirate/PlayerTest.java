package pirate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void InitializeDicetest() {
        Player p = new Player(0,0);
        assertNotNull(p.getDice());
    }

    @Test
    void InitializeSkullsTest(){
        Player p = new Player(0,0);
        assertNotNull(p.getSkulls());
    }
    @Test
    void addSkullsIndicesTest(){
        Player p = new Player(0,0);
        ArrayList<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "),new Die("skull  "),
                new Die("skull  "),new Die("skull  "),new Die("skull  "),new Die("skull  "),
                new Die("skull  "), new Die("skull  ")));
        p.addSkulls(dice);
        assertEquals(8, p.getSkulls().size());
    }

    @Test
    void rollSomeTest(){
        Player p = new Player(0,0);
        assertNotNull(p.getDice());
        List<Die> l = p.getDice();

        p.rerollSome(new String[]{"0","1","2","3"});
        assertEquals(l.get(4).getFace(), p.getDice().get(4).getFace());
        assertEquals(l.get(5).getFace(),p.getDice().get(5).getFace());
        assertEquals(l.get(6).getFace(),p.getDice().get(6).getFace());
        assertEquals(l.get(7).getFace(),p.getDice().get(7).getFace());
    }

    @Test
    void rollAllTest(){
        Player p = new Player(0,0);
        assertNotNull(p.getDice());
        ArrayList<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin  "),new Die("coin  "),
                new Die("coin  "),new Die("skull  "),new Die("skull  "),new Die("skull  "),
                new Die("skull  "), new Die("skull  ")));

        p.setDice(dice);
        p.addSkulls(dice);
        p.rerollAll();
        assertTrue(p.getSkulls().size() >= 5);

    }

    @Test
    void skullCheckTest(){
        Player p = new Player(0,0);
        ArrayList<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "),new Die("coin   "),
                new Die("coin   "),new Die("skull  "),new Die("skull  "),new Die("skull  "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.addSkulls(dice);
        p.skullCheck();
        assertTrue(p.getSkulls().size()==3);
        assertTrue(p.isEnd());
    }
    @Test
    void fullChestTest(){
        Player p = new Player(0,0);
        ArrayList<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "),new Die("monkey "),
                new Die("monkey "),new Die("monkey "),new Die("monkey "),new Die("skull  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        assertFalse(p.checkFullChest());

        dice = new ArrayList<>(Arrays.asList(new Die("monkey "),new Die("monkey "),
                new Die("monkey "),new Die("monkey "),new Die("monkey "),new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        assertTrue(p.checkFullChest());
    }

    @Test
    void getFCTest(){
        Player p = new Player(0,0);
        FortuneCard fc = new FortuneCard();
        String card = fc.drawCard();
        p.setCard(card);
        assertEquals(card, p.getCard());
    }

    @Test
    void setScoreTest(){
        Player p = new Player(0,0);
        p.setScore(200);
        assertEquals(200, p.getScore());
        p.setScore(300);
        assertEquals(500, p.getScore());
        p.setScore(-500);
        assertEquals(0, p.getScore());
        p.setScore(-100);
        assertEquals(0, p.getScore());
    }
}
