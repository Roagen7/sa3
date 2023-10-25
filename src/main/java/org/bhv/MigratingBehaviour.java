package org.bhv;

import jade.core.Location;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import org.agents.MigratingAgent;

public class MigratingBehaviour extends CyclicBehaviour {

    protected final MigratingAgent myAgent;
    int index = 0;


    public MigratingBehaviour(MigratingAgent agent) {
        super(agent);
        myAgent = agent;
    }

    @Override
    public void action() {
        Location location = myAgent.getLocations().get(index);
        myAgent.doMove(location);
        index = (index + 1) % myAgent.getLocations().size();
    }
}
