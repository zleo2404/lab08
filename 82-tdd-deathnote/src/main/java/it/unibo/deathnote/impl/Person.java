package it.unibo.deathnote.impl;

public class Person {
    
    
    private String causeOfDeath = "heart attack";
    private String detailOfDeath = "";
    
    
    public Person(){
        
    }

    
    public String getCauseOfDeath() {
        return causeOfDeath;
    }
    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }
    public String getDetailOfDeath() {
        return detailOfDeath;
    }
    public void setDetailOfDeath(String detailOfDeath) {
        this.detailOfDeath = detailOfDeath;
    }



}
