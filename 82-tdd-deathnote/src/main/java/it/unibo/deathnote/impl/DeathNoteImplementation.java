package it.unibo.deathnote.impl;

//./gradlew test -t gradle reagisce ad ogni modifica

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{
    

    public DeathNoteImplementation(){
        throw new UnsupportedOperationException("CIAO");
    }

    @Override
    public String getRule(int ruleNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRule'");
    }

    @Override
    public void writeName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeName'");
    }

    @Override
    public boolean writeDeathCause(String cause) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeDeathCause'");
    }

    @Override
    public boolean writeDetails(String details) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeDetails'");
    }

    @Override
    public String getDeathCause(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathCause'");
    }

    @Override
    public String getDeathDetails(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDetails'");
    }

    @Override
    public boolean isNameWritten(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNameWritten'");
    }

}