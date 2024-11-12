package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {

    @Test
    void ruleSupported(){

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
    void rulesNotNull(){

        DeathNote note = new DeathNoteImplementation();
        for(int i=0;i<DeathNote.RULES.size();i++){
            assertFalse(note.getRule(i).isBlank());
            assertFalse(note.getRule(i).isEmpty());
        }
    }

    @Test
    void humanDie(){

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
    void causeDeath() throws InterruptedException{

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
    }




}