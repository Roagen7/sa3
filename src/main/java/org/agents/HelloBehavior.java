package org.agents;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.swing.*;

public class HelloBehavior extends OneShotBehaviour {
    public HelloBehavior(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        JOptionPane.showMessageDialog(null, "Hello there!\nMy name is "
                + myAgent.getAID().getLocalName()
                + "\nbut you can contact me via "
                + myAgent.getName());
    }

}
