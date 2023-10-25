package org.agents;

import jade.core.Agent;

public class HelloAgent extends Agent {
    public HelloAgent(){}

    @Override
    protected void setup(){
        super.setup();
        this.addBehaviour(new HelloBehavior(this));
    }
}