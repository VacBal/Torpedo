import org.junit.jupiter.api.Test;
import vaczi.balazs.SegedMetodusok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static vaczi.balazs.SegedMetodusok.*;

class SegedMetodusokTest {

    @Test
    void igazHamisTest() {
        assertTrue (true);
    }

    @Test
    void betubolSzamTest() {
        SegedMetodusok sajatClass = new SegedMetodusok();

        assertEquals(0,sajatClass.betubolSzam("A"),"Az A-nál hiba van");
        assertEquals(1,sajatClass.betubolSzam("B"),"A B-nél hiba van");
        assertEquals(2,sajatClass.betubolSzam("C"),"A C-nél hiba van");
        assertEquals(3,sajatClass.betubolSzam("D"),"A D-nél hiba van");
        assertEquals(4,sajatClass.betubolSzam("E"),"Az E-nél hiba van");
        assertEquals(5,sajatClass.betubolSzam("F"),"Az F-nél hiba van");
        assertEquals(6,sajatClass.betubolSzam("G"),"A G-nél hiba van");
        assertEquals(7,sajatClass.betubolSzam("H"),"A H-nál hiba van");
        assertEquals(8,sajatClass.betubolSzam("I"),"Az I-nél hiba van");
        assertEquals(9,sajatClass.betubolSzam("J"),"A J-nél hiba van");

    }

    @Test
    void egeszbolBetuTest() {
        SegedMetodusok sajatClass = new SegedMetodusok();
        assertEquals("A",sajatClass.egeszbolBetu(0),"0-nál hiba van");
        assertEquals("B",sajatClass.egeszbolBetu(1),"1-nél hiba van");
        assertEquals("C",sajatClass.egeszbolBetu(2),"2-nél hiba van");
        assertEquals("D",sajatClass.egeszbolBetu(3),"3-nál hiba van");
        assertEquals("E",sajatClass.egeszbolBetu(4),"4-nél hiba van");
        assertEquals("F",sajatClass.egeszbolBetu(5),"5-nél hiba van");
        assertEquals("G",sajatClass.egeszbolBetu(6),"6-nál hiba van");
        assertEquals("H",sajatClass.egeszbolBetu(7),"7-nél hiba van");
        assertEquals("I",sajatClass.egeszbolBetu(8),"8-nál hiba van");
        assertEquals("J",sajatClass.egeszbolBetu(9),"9-nél hiba van");
    }

    @Test
    void oszlopKonvertalTest() {
        assertEquals(0,oszlopKonvertal(1),"1-nél hiba van");
        assertEquals(1,oszlopKonvertal(2),"2-nél hiba van");
        assertEquals(2,oszlopKonvertal(3),"3-nál hiba van");
        assertEquals(3,oszlopKonvertal(4),"4-nél hiba van");
        assertEquals(4,oszlopKonvertal(5),"5-nél hiba van");
        assertEquals(5,oszlopKonvertal(6),"6-nál hiba van");
        assertEquals(6,oszlopKonvertal(7),"7-nél hiba van");
        assertEquals(7,oszlopKonvertal(8),"8-nál hiba van");
        assertEquals(8,oszlopKonvertal(9),"9-nél hiba van");
        assertEquals(9,oszlopKonvertal(10),"10-nél hiba van");
        assertEquals(-1,oszlopKonvertal(0),"0-nál hiba van");
        assertEquals(-1,oszlopKonvertal(11),"11-nél hiba van");
    }

    @Test
    void oszlopbolBetuTest() {
        assertEquals(1,oszlopbolBetu(0),"0-nál hiba van");
        assertEquals(2,oszlopbolBetu(1),"1-nél hiba van");
        assertEquals(3,oszlopbolBetu(2),"2-nél hiba van");
        assertEquals(4,oszlopbolBetu(3),"3-nál hiba van");
        assertEquals(5,oszlopbolBetu(4),"4-nél hiba van");
        assertEquals(6,oszlopbolBetu(5),"5-nél hiba van");
        assertEquals(7,oszlopbolBetu(6),"6-nál hiba van");
        assertEquals(8,oszlopbolBetu(7),"7-nél hiba van");
        assertEquals(9,oszlopbolBetu(8),"8-nál hiba van");
        assertEquals(10,oszlopbolBetu(9),"9-nél hiba van");
        assertEquals(-1,oszlopbolBetu(10),"10-nél hiba van");
    }

    @Test
    void szamlaloTombKonvertalTest() {
        SegedMetodusok sajatClass = new SegedMetodusok();

        for (int i = 65; i < 91; i++) {
            assertEquals(i-65,sajatClass.szamlaloTombKonvertal(i));
        }

    }
}