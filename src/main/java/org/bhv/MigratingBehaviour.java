package org.bhv;

import jade.core.Location;
import jade.core.behaviours.Behaviour;
import org.agents.MigratingAgent;

public class MigratingBehaviour extends Behaviour {

    protected final MigratingAgent myAgent;

    public MigratingBehaviour(MigratingAgent agent) {
        super(agent);
        myAgent = agent;
    }

    @Override
    public void action() {
        Location location = myAgent.getLocations().get(0);
        myAgent.getLocations().remove(location);
        myAgent.doMove(location);
    }

    @Override
    public boolean done() {
        return myAgent.getLocations().isEmpty();
    }

}
