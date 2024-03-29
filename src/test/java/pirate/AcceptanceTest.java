package pirate;


import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AcceptanceTest {
    @BeforeAll
    public static void beforeTestCaseOneClass() {
        System.out.println("————————————————");
        System.out.println();
        System.out.println("Executing Test methods of Test Case One class…");
        System.out.println("————————————————");
        System.out.println();
    }

    @Test
    @Order(1)
    public void Test45() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        // set to 3 skulls
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("skull  "), new Die("diamond"), new Die("diamond"), new Die("diamond"),
                new Die("diamond"), new Die("diamond"))));
        // check # skulls after first roll
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        assertEquals(0, p.getScore());
        System.out.println("TEST 44 passed");
    }

    @Test
    @Order(2)
    public void Test46() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());

        //1 skull, 4 parrots, 3 swords
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("saber  "),
                new Die("saber  "), new Die("saber  "))));

        p.rerollSome(new String[]{"5", "6", "7"});
        assertEquals("parrot ", p.getDice().get(1).getFace());
        assertEquals("parrot ", p.getDice().get(2).getFace());
        assertEquals("parrot ", p.getDice().get(3).getFace());
        assertEquals("parrot ", p.getDice().get(4).getFace());
        p.reset();
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("skull  "),
                new Die("skull  "), new Die("saber  "))));
        // check # skulls after re roll
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        assertEquals(0, p.getScore());
        System.out.println("TEST 45 passed");
    }

    @Test
    @Order(3)
    public void Test47() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());

        //2 skull, 4 parrots, 2 swords
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("saber  "), new Die("saber  "))));

        p.rerollSome(new String[]{"6", "7"});
        assertEquals("parrot ", p.getDice().get(5).getFace());
        assertEquals("parrot ", p.getDice().get(2).getFace());
        assertEquals("parrot ", p.getDice().get(3).getFace());
        assertEquals("parrot ", p.getDice().get(4).getFace());
        p.reset();
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("skull  "), new Die("saber  "))));
        // check # skulls after re roll
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        assertEquals(0, p.getScore());
        System.out.println("TEST 46 passed");
    }

    @Test
    @Order(4)
    public void Test48() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());

        //1 skull, 4 parrots, 3 swords
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("saber  "),
                new Die("saber  "), new Die("saber  "))));

        p.rerollSome(new String[]{"5", "6", "7"});
        assertEquals("parrot ", p.getDice().get(1).getFace());
        assertEquals("parrot ", p.getDice().get(2).getFace());
        assertEquals("parrot ", p.getDice().get(3).getFace());
        assertEquals("parrot ", p.getDice().get(4).getFace());
        p.reset();
        // 2 skulls 4 parrots 2 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("skull  "),
                new Die("monkey "), new Die("monkey "))));

        p.rerollSome(new String[]{"6", "7"});
        assertEquals("skull  ", p.getDice().get(0).getFace());
        assertEquals("skull  ", p.getDice().get(5).getFace());
        assertEquals("parrot ", p.getDice().get(1).getFace());
        assertEquals("parrot ", p.getDice().get(2).getFace());
        assertEquals("parrot ", p.getDice().get(3).getFace());
        assertEquals("parrot ", p.getDice().get(4).getFace());
        p.reset();
        // 3 skulls 4 parrots 1 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("skull  "),
                new Die("skull  "), new Die("monkey "))));
        // check # skulls after re roll
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        assertEquals(0, p.getScore());
        System.out.println("TEST 48 passed");
    }

    @Test
    public void Test50() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 2 parrots, 3 swords 2 coins
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("coin   "), new Die("coin   "), new Die("saber  "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"1", "2"});
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("coin   "),
                new Die("coin   "), new Die("coin   "), new Die("coin   "), new Die("saber  "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.rerollSome(new String[]{"5", "6", "7"});
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("coin   "),
                new Die("coin   "), new Die("coin   "), new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(4800, p.getScore());
        System.out.println("TEST 50 passed");
    }

    @Test
    public void Test52() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 2 parrots, 1 swords 2 coins 2 diamonds
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("coin   "), new Die("coin   "), new Die("saber  "),
                new Die("diamond"), new Die("diamond")));
        p.setDice(dice);
        p.setCard("captain");
        p.calculateScore(dice);
        assertEquals(800, p.getInfo()[0]);
        System.out.println("TEST 52 passed");
    }

    @Test
    public void Test53() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 2 parrots, 2 swords 0 coins 0 diamonds 2 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"1"});
        // 3 monkeys
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("monkey "),
                new Die("parrot "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(200, p.getInfo()[0]);
        System.out.println("TEST 53 passed");
    }

    @Test
    public void Test54() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 3 swords 0 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("monkey "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.calculateScore(dice);
        assertEquals(300, p.getInfo()[0]);
        System.out.println("TEST 54 passed");
    }

    @Test
    public void Test55() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 1 parrots, 2 swords 0 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("monkey "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"1"});
        // 3 monkeys 3 sabers
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("monkey "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(300, p.getInfo()[0]);
        System.out.println("TEST 55 passed");
    }

    @Test
    public void Test56() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 2 swords 0 coins 3 diamonds 1 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("monkey "), new Die("skull  "), new Die("saber  "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.setDice(dice);
        p.setCard("coin");
        p.calculateScore(dice);
        assertEquals(500, p.getInfo()[0]);
        System.out.println("TEST 56 passed");
    }

    @Test
    public void Test57() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 1 swords 4 coins 0 diamonds 1 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("monkey "), new Die("skull  "), new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.setCard("diamond");
        p.calculateScore(dice);
        assertEquals(700, p.getInfo()[0]);
        System.out.println("TEST 57 passed");
    }

    @Test
    public void Test58() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 4 parrots, 3 swords 0 coins 0 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("parrot "), new Die("parrot "), new Die("saber  "), new Die("saber  "),
                new Die("parrot "), new Die("parrot ")));
        p.setDice(dice);
        p.setCard("coin");
        p.calculateScore(dice);
        assertEquals(400, p.getInfo()[0]);
        System.out.println("TEST 58 passed");
    }

    @Test
    public void Test59() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 1 parrots, 2 swords 0 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"0", "1", "2", "6", "7"});
        // 3 coins 4 sabers
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("coin   "),
                new Die("coin   "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("coin   "), new Die("saber  ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(800, p.getInfo()[0]);
        System.out.println("TEST 59 passed");
    }

    @Test
    public void Test60() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 1 parrots, 2 swords 0 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("captain");
        p.rerollSome(new String[]{"0", "1", "2", "6", "7"});
        // 3 coins 4 sabers
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("coin   "),
                new Die("coin   "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("coin   "), new Die("saber  ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(1200, p.getInfo()[0]);
        System.out.println("TEST 60 passed");
    }

    @Test
    public void Test61() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 1 parrots, 2 swords 0 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"0", "1", "2", "6", "7"});
        // 3 coins 4 sabers
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("coin   "),
                new Die("coin   "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("coin   "), new Die("saber  ")));

        p.rerollSome(new String[]{"1", "2", "6"});
        //  5 sabers
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("monkey "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("saber  ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(600, p.getInfo()[0]);
        System.out.println("TEST 61 passed");
    }

    @Test
    public void Test62() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 0 swords 0 coins 0 diamonds 6 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.calculateScore(dice);
        assertEquals(1100, p.getInfo()[0]);
        System.out.println("TEST 62 passed");
    }

    @Test
    public void Test63() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 7 parrots, 0 swords 0 coins 0 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("parrot "), new Die("parrot ")));
        p.setDice(dice);
        p.setCard("coin");
        p.calculateScore(dice);
        assertEquals(2100, p.getInfo()[0]);
        System.out.println("TEST 63 passed");
    }

    @Test
    public void Test64() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 0 swords 8 coins 0 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   "), new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.setCard("coin");
        p.calculateScore(dice);
        assertEquals(5400, p.getInfo()[0]);
        System.out.println("TEST 64 passed");
    }

    @Test
    public void Test65() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 0 swords 8 coins 0 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   "), new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.setCard("diamond");
        p.calculateScore(dice);
        assertEquals(5400, p.getInfo()[0]);
        System.out.println("TEST 65 passed");
    }

    @Test
    public void Test66() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 8 swords 0 coins 0 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.setCard("captain");
        p.calculateScore(dice);
        assertEquals(9000, p.getInfo()[0]);
        System.out.println("TEST 66 passed");
    }

    @Test
    public void Test67() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 2 parrots, 3 swords 0 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"0", "1", "3", "4", "5"});
        //  6 monkeys
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("coin   "),
                new Die("monkey "), new Die("saber  "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.rerollSome(new String[]{"1", "3"});
        //  8 monkeys
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(4600, p.getInfo()[0]);
        System.out.println("TEST 67 passed");
    }

    @Test
    public void Test68() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 4 swords 0 coins 1 diamonds 1 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("diamond"), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("diamond");
        p.rerollSome(new String[]{"3", "4"});
        // 2 diamonds
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("diamond"), new Die("diamond"), new Die("monkey "), new Die("saber  "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(400, p.getInfo()[0]);
        System.out.println("TEST 68 passed");
    }

    @Test
    public void Test69() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 4 swords 0 coins 1 diamonds 1 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("diamond"), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"3", "4"});
        // 3 diamonds
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("diamond"), new Die("diamond"), new Die("diamond"), new Die("saber  "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(500, p.getInfo()[0]);
        System.out.println("TEST 69 passed");
    }

    @Test
    public void Test70() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 4 swords 1 coins 0 diamonds 1 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");
        p.rerollSome(new String[]{"3", "4", "5"});
        // 3 coins
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("coin   "), new Die("coin   "), new Die("monkey "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(600, p.getInfo()[0]);
        System.out.println("TEST 70 passed");
    }

    @Test
    public void Test71() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 4 swords 1 coins 0 diamonds 1 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("diamond");
        p.rerollSome(new String[]{"3", "4", "5"});
        // 3 coins
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("coin   "), new Die("coin   "), new Die("monkey "),
                new Die("saber  "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(500, p.getInfo()[0]);
        System.out.println("TEST 71 passed");
    }

    @Test
    public void Test72() {
        Player p = new Player(0, 0);
        p.initializeDice();
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 0 parrots, 1 swords 3 coins 0 diamonds 4 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("skull  "),
                new Die("saber  "), new Die("coin   "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.setCard("coin");

        p.calculateScore(dice);
        assertEquals(600, p.getInfo()[0]);
        System.out.println("TEST 72 passed");
    }

    @Test
    public void Test77() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("sorceress");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 1 swords 1 coins 0 diamonds 4 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("skull  "),
                new Die("saber  "), new Die("skull  "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(2, p.getSkullSize());
        p.removeSkull("1");
        assertEquals(1, p.getSkullSize());
        p.rerollSome(new String[]{"1"});
        System.out.println("TEST 77 passed");
    }

    @Test
    public void Test78() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("sorceress");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 1 swords 2 coins 0 diamonds 5 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("coin   "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(0, p.getSkullSize());
        p.rerollSome(new String[]{"3"});
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("skull  "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(1, p.getSkullSize());
        p.removeSkull("3");
        assertEquals(0, p.getSkullSize());
        p.rerollSome(new String[]{"1"});
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("skull  "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(600, p.getInfo()[0]);
        System.out.println("TEST 78 passed");
    }

    @Test
    public void Test79() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("sorceress");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 1 swords 2 coins 0 diamonds 5 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("coin   "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(0, p.getSkullSize());
        p.rerollSome(new String[]{"3"});
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("skull  "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(1, p.getSkullSize());
        p.removeSkull("3");
        assertEquals(0, p.getSkullSize());
        p.rerollSome(new String[]{"1"});
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("skull  "), new Die("coin   "), new Die("monkey "),
                new Die("monkey "), new Die("monkey ")));
        p.setDice(dice);
        System.out.println("TEST 79 passed");
    }

    @Test
    public void Test82() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("MP");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 3 parrots, 0 swords 1 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("skull  "), new Die("coin   "), new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("parrot ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(1100, p.getInfo()[0]);
        System.out.println("TEST 82 passed");
    }

    @Test
    public void Test83() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("MP");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 2 parrots, 1 swords 2 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("coin   "), new Die("coin   "), new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("saber  ")));
        p.setDice(dice);
        p.rerollAll();
        //0 skull, 1 parrots, 3 swords 2 coins 0 diamonds 2 monkeys
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("coin   "), new Die("parrot "), new Die("coin   "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.rerollSome(new String[]{"2"});
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("diamond"), new Die("coin   "), new Die("parrot "), new Die("coin   "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(400, p.getInfo()[0]);
        System.out.println("TEST 83 passed");
    }

    @Test
    public void Test84() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("MP");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 2 parrots, 1 swords 2 coins 0 diamonds 3 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("coin   "), new Die("coin   "), new Die("parrot "), new Die("parrot "),
                new Die("monkey "), new Die("saber  ")));
        p.setDice(dice);
        p.rerollAll();
        //0 skull, 1 parrots, 3 swords 2 coins 0 diamonds 2 monkeys
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("coin   "), new Die("parrot "), new Die("coin   "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.rerollAll();
        dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("saber  "), new Die("parrot ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(2000, p.getInfo()[0]);
        System.out.println("TEST 84 passed");
    }

    @Test
    public void Test87() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("chest");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 3 parrots, 2 swords 1 coins 2 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("diamond"), new Die("diamond"),
                new Die("coin   "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("saber  "), new Die("saber  ")));
        p.setDice(dice);
        p.addToTreasures(new String[]{"0", "1", "2"});
        assertEquals(3, p.getTreasures().size());
        p.rerollSome(new String[]{"6", "7"});
        dice = new ArrayList<>(Arrays.asList(new Die("diamond"), new Die("diamond"),
                new Die("coin   "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("parrot "), new Die("parrot ")));
        p.setDice(dice);
        p.addToTreasures(new String[]{"3", "4", "5", "6", "7"});
        assertEquals(8, p.getTreasures().size());
        p.removeFromTreasures(new String[]{"0", "1", "2"});
        assertEquals(5, p.getTreasures().size());
        p.rerollSome(new String[]{"0", "1", "2"});
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("coin   "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("parrot "), new Die("parrot ")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(1100, p.getInfo()[0]);
        System.out.println("TEST 87 passed");
    }

    @Test
    public void Test92() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("chest");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 3 parrots, 0 swords 3 coins 0 diamonds 0 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("parrot "), new Die("parrot "), new Die("parrot "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.addSkulls(dice);
        p.addToTreasures(new String[]{"2", "6", "7"});
        assertEquals(3, p.getTreasures().size());
        p.rerollSome(new String[]{"3", "4", "5"});
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("diamond"), new Die("diamond"), new Die("coin   "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.addSkulls(dice);
        p.addToTreasures(new String[]{"5"});
        assertEquals(4, p.getTreasures().size());
        p.rerollSome(new String[]{"0", "1", "2"});
        dice = new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("skull  "),
                new Die("coin   "), new Die("skull "), new Die("coin   "), new Die("coin   "),
                new Die("coin   "), new Die("coin   ")));
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(3, p.getSkullSize());
        p.setEnd();
        assertTrue(p.isEnd());
        List<Die> treasures = p.buildTreasureList();
        p.calculateScore(treasures);
        assertEquals(600, p.getInfo()[0]);
        System.out.println("TEST 92 passed");
    }

    @Test
    public void Test98() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("coin");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 1 parrots, 3 swords 0 coins 1 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("parrot "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("diamond"))));
        p.calculateScore(p.getDice());
        assertEquals(400, p.getInfo()[0]);
        System.out.println("TEST 98 passed");
    }

    @Test
    public void Test99() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("captain");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 3 swords 2 coins 0 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("coin   "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("coin   "))));
        p.calculateScore(p.getDice());
        assertEquals(1800, p.getInfo()[0]);
        System.out.println("TEST 99 passed");
    }

    @Test
    public void Test100() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("coin");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 0 parrots, 4 swords 0 coins 1 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("saber  "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("diamond"))));
        p.calculateScore(p.getDice());
        assertEquals(1000, p.getInfo()[0]);
        System.out.println("TEST 100 passed");
    }

    @Test
    public void Test101() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-sword");
        p.activateSeaBattles(2);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 2 parrots, 1 swords 1 coins 0 diamonds 4 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("parrot "),
                new Die("parrot "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("coin   "))));
        p.activateSeaBattles(2);
        p.rerollSome(new String[]{"1", "2"});
        //0 skull, 0 parrots, 2 swords 2 coins 0 diamonds 4 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("coin   "),
                new Die("saber  "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("monkey "), new Die("coin   "))));
        p.calculateScore(p.getDice());
        assertEquals(1200, p.getInfo()[0]);
        System.out.println("TEST 101 passed");
    }

    @Test
    public void Test104(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("MP");
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 1 parrots, 0 swords 2 coins 3 diamonds 2 monkeys
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("monkey "), new Die("monkey "),
                new Die("coin   "), new Die("coin   "), new Die("parrot "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.setDice(dice);
        p.calculateScore(dice);
        assertEquals(1200, p.getInfo()[0]);
        System.out.println("TEST 104 passed");
    }

    @Test
    public void Test107(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-skull");
//        String[] ss = p.setSkulls(new String[]{"2", "skull"});
        p.setSkulls(new String[]{"2","skull"});
        p.addSkulls(p.getDice());
        assertEquals(2, p.getSkullSize());
//        p.rerollSome(ss);
        p.getDice().forEach(d -> d.roll());
        //3 skull
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("skull  "), new Die("coin   "), new Die("parrot "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.reset();
        p.setSkulls(new String[]{"2","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        System.out.println("TEST 107 passed");
    }

    @Test
    public void Test108(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("1-skull");
        p.setSkulls(new String[]{"1","skull"});
        p.addSkulls(p.getDice());
        assertEquals(1, p.getSkullSize());
        p.getDice().forEach(d -> d.roll());
        //3 skull
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("skull  "),
                new Die("skull  "), new Die("coin   "), new Die("parrot "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.reset();
        p.setSkulls(new String[]{"1","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        System.out.println("TEST 108 passed");
    }
    @Test
    public void Test109(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-skull");
        p.setSkulls(new String[]{"2","skull"});
        p.addSkulls(p.getDice());
        assertEquals(2, p.getSkullSize());
        p.getDice().forEach(d -> d.roll());
        // 4 skulls
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("skull  "), new Die("skull  "), new Die("parrot "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.reset();
        p.setSkulls(new String[]{"2","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(4, p.getSkullSize());

        p.rerollSome(new String[]{"6","7"});
        // 6 skulls
        dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("skull  "), new Die("skull  "), new Die("parrot "), new Die("diamond"),
                new Die("skull  "), new Die("skull  ")));

        p.reset();
        p.setSkulls(new String[]{"2","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(6, p.getSkullSize());
        p.rerollSome(new String[]{"5"});
        // 7 skulls
        dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("skull  "), new Die("skull  "), new Die("parrot "), new Die("skull  "),
                new Die("skull  "), new Die("skull  ")));

        p.reset();
        p.setSkulls(new String[]{"2","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(7, p.getSkullSize());
        p.deductPoints(p.getSkullSize());
        assertEquals(-700, p.getInfo()[1]);
        System.out.println("TEST 109 passed");
    }
    @Test
    public void Test110(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-skull");
        p.setSkulls(new String[]{"2","skull"});
        p.addSkulls(p.getDice());
        assertEquals(2, p.getSkullSize());
        p.getDice().forEach(d -> d.roll());
        // 5 skulls
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("skull  "), new Die("skull  "), new Die("skull  "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.reset();
        p.setSkulls(new String[]{"2","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(5, p.getSkullSize());

        p.rerollSome(new String[]{"6","7"});
        // 5 skulls
        dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("coin   "),
                new Die("skull  "), new Die("skull  "), new Die("skull  "), new Die("diamond"),
                new Die("saber  "), new Die("saber  ")));

        p.reset();
        p.setSkulls(new String[]{"2","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(5, p.getSkullSize());
        p.rerollSome(new String[]{"5"});

        p.deductPoints(p.getSkullSize());
        assertEquals(-500, p.getInfo()[1]);
        System.out.println("TEST 110 passed");
    }
    @Test
    public void Test111(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("1-skull");
        p.setSkulls(new String[]{"1","skull"});
        p.addSkulls(p.getDice());
        assertEquals(1, p.getSkullSize());
//        p.rerollSome(ss);
        p.getDice().forEach(d -> d.roll());
        // 4 skulls
        List<Die> dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("skull  "),
                new Die("skull  "), new Die("skull  "), new Die("parrot "), new Die("diamond"),
                new Die("diamond"), new Die("diamond")));
        p.reset();
        p.setSkulls(new String[]{"1","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(4, p.getSkullSize());

        p.rerollSome(new String[]{"6"});
        // 5 skulls
        dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("skull  "),
                new Die("skull  "), new Die("skull  "), new Die("parrot "), new Die("diamond"),
                new Die("skull  "), new Die("diamond")));

        p.reset();
        p.setSkulls(new String[]{"1","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(5, p.getSkullSize());
        p.rerollSome(new String[]{"5"});
        // 5 skulls
        dice = new ArrayList<>(Arrays.asList(new Die("coin   "), new Die("skull  "),
                new Die("skull  "), new Die("skull  "), new Die("parrot "), new Die("coin   "),
                new Die("skull  "), new Die("diamond")));

        p.reset();
        p.setSkulls(new String[]{"1","skull"});
        p.setDice(dice);
        p.addSkulls(dice);
        assertEquals(5, p.getSkullSize());
        p.deductPoints(p.getSkullSize());
        assertEquals(-500, p.getInfo()[1]);
        System.out.println("TEST 111 passed");
    }

    @Test
    public void Test114() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-sword");
        p.activateSeaBattles(2);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //3 skull, 2 parrots, 1 swords 1 coins 0 diamonds 1 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("parrot "),
                new Die("parrot "), new Die("skull  "), new Die("skull  "), new Die("monkey "),
                new Die("skull  "), new Die("coin   "))));
        p.activateSeaBattles(2);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertTrue(p.isEnd());
        p.calculateScore(p.getDice());
        assertEquals(-300, p.getInfo()[1]);
        System.out.println("TEST 114 passed");
    }
    @Test
    public void Test115(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("3-sword");
        p.activateSeaBattles(3);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 4 parrots, 2 swords 0 coins 0 diamonds 0 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("parrot "), new Die("skull  "), new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "))));
        p.activateSeaBattles(3);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertEquals(2, p.getSkullSize());
        p.rerollSome(new String[]{"2", "5", "6","7"});
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("skull  "), new Die("skull  "), new Die("parrot "),
                new Die("parrot "), new Die("parrot "))));
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertEquals(3, p.getSkullSize());
        assertTrue(p.isEnd());
        p.calculateScore(p.getDice());
        assertEquals(-500, p.getInfo()[1]);
        System.out.println("TEST 115 passed");
    }
    @Test
    public void Test116() {
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("4-sword");
        p.activateSeaBattles(4);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //3 skull, 2 parrots, 3 swords 0 coins 0 diamonds 0 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("parrot "),
                new Die("parrot "), new Die("skull  "), new Die("skull  "), new Die("saber  "),
                new Die("skull  "), new Die("saber  "))));
        p.activateSeaBattles(4);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertTrue(p.isEnd());
        p.calculateScore(p.getDice());
        assertEquals(-1000, p.getInfo()[1]);
        p.setScore(-1000);
        assertEquals(0,p.getScore());
        System.out.println("TEST 116 passed");
    }
    @Test
    public void Test118(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-sword");
        p.activateSeaBattles(2);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //0 skull, 2 parrots, 2 swords 1 coins 0 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("parrot "),
                new Die("parrot "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("coin   "), new Die("saber  "))));
        p.activateSeaBattles(2);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        p.calculateScore(p.getDice());
        assertEquals(500, p.getInfo()[0]);
        System.out.println("TEST 118 passed");
    }
    @Test
    public void Test119(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("2-sword");
        p.activateSeaBattles(2);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 2 parrots, 1 swords 0 coins 0 diamonds 4 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("parrot "),
                new Die("parrot "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("skull  "), new Die("monkey "))));
        p.activateSeaBattles(2);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        p.rerollSome(new String[]{"1", "2"});
        //1 skull, 2 parrots, 1 swords 0 coins 0 diamonds 4 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("skull  "),
                new Die("saber  "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("skull  "), new Die("monkey "))));
        p.calculateScore(p.getDice());
        assertEquals(500, p.getInfo()[0]);
        System.out.println("TEST 119 passed");
    }
    @Test
    public void Test121(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("3-sword");
        p.activateSeaBattles(3);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 0 parrots, 4 swords 0 coins 0 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("saber  "), new Die("monkey "), new Die("monkey "),
                new Die("skull  "), new Die("monkey "))));
        p.activateSeaBattles(3);
        p.addSkulls(p.getDice());
        p.skullCheck(false);

        p.calculateScore(p.getDice());
        assertEquals(800, p.getInfo()[0]);
        System.out.println("TEST 121 passed");
    }
    @Test
    public void Test122(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("3-sword");
        p.activateSeaBattles(3);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 2 swords 0 coins 0 diamonds 4 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("skull  "), new Die("monkey "))));
        p.activateSeaBattles(3);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        p.rerollSome(new String[]{"3", "4", "5", "7"});
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("skull  "))));
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        assertTrue(p.isEnd());
        p.calculateScore(p.getDice());
        assertEquals(-500, p.getInfo()[1]);
        System.out.println("TEST 122 passed");
    }
    @Test
    public void Test124(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("4-sword");
        p.activateSeaBattles(4);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 0 parrots, 4 swords 0 coins 0 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("saber  "))));
        p.activateSeaBattles(4);
        p.calculateScore(p.getDice());
        assertEquals(1300, p.getInfo()[0]);
        System.out.println("TEST 124 passed");
    }
    @Test
    public void Test125(){
        Player p = new Player(0, 0);
        p.initializeDice();
        p.setCard("4-sword");
        p.activateSeaBattles(4);
        // on first roll
        p.getDice().forEach(d -> d.roll());
        //1 skull, 2 parrots, 1 swords 0 coins 1 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("diamond"),
                new Die("skull  "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("parrot "), new Die("parrot "))));
        p.activateSeaBattles(4);
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        p.rerollSome(new String[]{"6","7"});
        //1 skull, 0 parrots, 3 swords 0 coins 1 diamonds 3 monkeys
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("diamond"),
                new Die("skull  "), new Die("monkey "), new Die("monkey "), new Die("monkey "),
                new Die("saber  "), new Die("saber  "))));
        p.addSkulls(p.getDice());
        p.skullCheck(false);
        p.rerollSome(new String[]{"3","4","5"});
        p.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("diamond"),
                new Die("skull  "), new Die("saber  "), new Die("parrot "), new Die("parrot "),
                new Die("saber  "), new Die("saber  "))));
        p.calculateScore(p.getDice());
        assertEquals(1300, p.getInfo()[0]);
        assertEquals(0, p.getInfo()[1]);
        System.out.println("TEST 125 passed");
    }
    @Test
    public void Test131(){
        Player p1 = new Player(1,0);
        Player p2 = new Player(2,0);
        Player p3 = new Player(3,0);

        p1.initializeDice();
        p1.setCard("captain");
        // on first roll
        p1.getDice().forEach(d -> d.roll());
        //1 skull, 0 parrots, 7 swords 0 coins 0 diamonds 0 monkeys
        p1.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("saber  "), new Die("saber  "))));
        p2.initializeDice();
        p2.setCard("coin");
        // on first roll
        p2.getDice().forEach(d -> d.roll());
        //2 skull, 2 parrots, 3 swords 0 coins 0 diamonds 1 monkeys
        p2.setDice(new ArrayList<>(Arrays.asList(new Die("parrot "), new Die("parrot "),
                new Die("skull  "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("monkey "))));
        p3.initializeDice();
        p3.setCard("coin");
        // on first roll
        p3.getDice().forEach(d -> d.roll());
        //3 skull, 0 parrots, 7 swords 0 coins 0 diamonds 0 monkeys
        p3.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber "),
                new Die("skull  "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("saber  "))));
        p3.addSkulls(p3.getDice());
        p1.calculateScore(p1.getDice());
        p2.calculateScore(p2.getDice());
        p3.calculateScore(p3.getDice());
        assertEquals(4000, p1.getInfo()[0]);
        assertEquals(200, p2.getInfo()[0]);
    }
    @Test
    public void Test134(){
        Player p1 = new Player(1,0);
        Player p2 = new Player(2,0);
        Player p3 = new Player(3,0);

        p1.initializeDice();
        p1.setCard("captain");
        // on first roll
        p1.getDice().forEach(d -> d.roll());
        //2 skull, 0 parrots, 6 swords 0 coins 0 diamonds 0 monkeys
        p1.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber "),
                new Die("skull  "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("saber  "))));
        assertEquals(0, p1.getInfo()[0]);
        p2.initializeDice();
        p2.setCard("coin");
        // on first roll
        p2.getDice().forEach(d -> d.roll());
        //3 skull, 1 parrots, 3 swords 0 coins 0 diamonds 1 monkeys
        p2.setDice(new ArrayList<>(Arrays.asList(new Die("skull  "), new Die("parrot "),
                new Die("skull  "), new Die("saber  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("monkey "))));
        p2.addSkulls(p2.getDice());
        p2.skullCheck(false);

        p3.initializeDice();
        p3.setCard("1-skull");
//        String[] ss = p3.setSkulls(new String[]{"1", "skull"});
        p3.setSkulls(new String[]{"1", "skull"});
        p3.addSkulls(p3.getDice());
        // on first roll
        p3.getDice().forEach(d -> d.roll());
        //4 skull, 0 parrots, 4 swords 0 coins 0 diamonds 0 monkeys
        p3.setDice(new ArrayList<>(Arrays.asList(new Die("saber  "), new Die("saber "),
                new Die("skull  "), new Die("skull  "), new Die("saber  "), new Die("saber  "),
                new Die("skull  "), new Die("skull  "))));
        p3.addSkulls(p3.getDice());
        p3.deductPoints(p3.getSkullSize());
        p1.calculateScore(p1.getDice());
        p2.calculateScore(p2.getDice());
        p3.calculateScore(p3.getDice());

        assertEquals(-500, p3.getInfo()[1]);
    }
}
