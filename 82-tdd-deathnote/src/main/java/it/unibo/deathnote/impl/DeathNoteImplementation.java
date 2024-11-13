package it.unibo.deathnote.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//./gradlew test -t gradle reagisce ad ogni modifica

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{
    

    long insertTimeMillis;
    String currentName;
    Map<String,Person> test;

    public DeathNoteImplementation(){
        test = new HashMap<>();
    }

    @Override
    public String getRule(int ruleNumber) {
        
        if(ruleNumber>DeathNote.RULES.size() || ruleNumber <= 0) throw new IllegalArgumentException("Invalid number");
        return DeathNote.RULES.get(ruleNumber);

    }

    @Override
    public void writeName(String name) {
        
        if(name.isBlank() || name .isEmpty()) throw new NullPointerException("Invalid name");

        test.put(name, new Person());
        currentName=name;
        this.insertTimeMillis = System.currentTimeMillis();

    }

    @Override
    public boolean writeDeathCause(String cause) {
        
        long check = System.currentTimeMillis()-insertTimeMillis;
        if(test.size()==0 || cause.isEmpty() || cause.isBlank()) throw new IllegalStateException("Retry");
        if(check > 40) return false;
        else{
            test.get(currentName).setCauseOfDeath(cause);
            return true;
        }

        

    }

    @Override
    public boolean writeDetails(String details) {
        long time = System.currentTimeMillis() - insertTimeMillis;
        if(details.isBlank() || details.isEmpty() || test.size()==0) throw new IllegalStateException("Invalid details");
        if(time > 6040) return false;

        test.get(currentName).setDetailOfDeath(details);
        return true;

    }

    @Override
    public String getDeathCause(String name) {
        
        if(!test.containsKey(name)) throw new IllegalArgumentException("Insert the name first");
        return test.get(name).getCauseOfDeath();
    

    }

    @Override
    public String getDeathDetails(String name) {
        
        if(!test.containsKey(name)) throw new IllegalArgumentException("Insert the name first");
        return test.get(name).getDetailOfDeath();

    }

    @Override
    public boolean isNameWritten(String name) {
        
        if(test.containsKey(name))return true;
        return false;

    }

}