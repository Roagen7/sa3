package org.bhv;

import jade.core.Location;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import org.agents.MigratingAgent;

public class MigratingBehaviour extends OneShotBehaviour {

    protected final MigratingAgent myAgent;
    int index;


    public MigratingBehaviour(MigratingAgent agent, int index_) {
        super(agent);
        myAgent = agent;
        index = index_;
    }

    @Override
    public void action() {
        Location location = myAgent.getLocations().get(index);
        myAgent.doMove(location);
    }
}
