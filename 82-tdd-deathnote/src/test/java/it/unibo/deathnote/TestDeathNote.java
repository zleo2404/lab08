package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {

    @Test
    void test1(){

        DeathNote note = new DeathNoteImplementation();
        note.getRule(1);
        try{
            note.getRule(-1);
        }catch(IllegalArgumentException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
            assertFalse(e.getMessage().isBlank());
        }
        try{
            note.getRule(0);
        }catch(IllegalArgumentException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
            assertFalse(e.getMessage().isBlank());
        }
        try{
            note.getRule(DeathNote.RULES.size()+1);
        }catch(IllegalArgumentException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
            assertFalse(e.getMessage().isBlank());
        }


    }

    @Test
    void test2(){

        DeathNote note = new DeathNoteImplementation();
        for(int i=1;i<DeathNote.RULES.size();i++){
            assertFalse(note.getRule(i).isBlank());
            assertFalse(note.getRule(i).isEmpty());
        }
    }

    @Test
    void test3(){

        DeathNote note = new DeathNoteImplementation();
        String name = "Luca";
        assertFalse(note.isNameWritten(name));
        note.writeName(name);
        assertFalse(!note.isNameWritten(name));
        String name2 = "Giovanni";
        assertFalse(note.isNameWritten(name2));
        assertFalse(note.isNameWritten(""));

    }

    @Test
    void test4() throws InterruptedException{

        DeathNote note = new DeathNoteImplementation();
        try{
            note.writeDeathCause("Prova");
        }catch(IllegalStateException e){

        }
        String name = "Luca";
        note.writeName(name);
        assertNotEquals("Hearth Attack", note.getDeathCause(name));
        note.writeName("Alberto");
        note.writeDeathCause("karting accident");
        assertEquals("karting accident", note.getDeathCause("Alberto"));
        Thread.sleep(100);
        note.writeDeathCause("change");
        assertEquals("karting accident", note.getDeathCause("Alberto"));

    }

    @Test
    void test5() throws InterruptedException{

        DeathNote note = new DeathNoteImplementation();

        assertThrows( IllegalStateException.class, ()-> {
            note.writeDetails("try");
        });

        note.writeName("Ste");
        assertFalse(!note.getDeathDetails("Ste").isEmpty());
        assertEquals(true, note.writeDetails("ran for too long"));
        assertEquals("ran for too long", note.getDeathDetails("Ste"));
        note.writeName("Luci");
        Thread.sleep(6100);
        assertEquals(false, note.writeDetails("test"));
        assertTrue(note.getDeathDetails("Luci").isEmpty());

    }




}