package org.agents;

import jade.content.ContentManager;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.Location;
import jade.domain.mobility.MobilityOntology;
import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;
import org.bhv.RequestContainersListBehaviour;


public class MigratingAgent extends Agent {

    @Setter
    @Getter
    private List<Location> locations;

    public MigratingAgent() {
    }

    @Override
    protected void setup() {
        super.setup();
        registerCodecs();
        this.addBehaviour(new RequestContainersListBehaviour(this));
    }

    @Override
    protected void afterMove() {
        super.afterMove();
        //registerCodecs();
        //resume threads
        JOptionPane.showMessageDialog(null, "Przybywam!");
    }

    @Override
    protected void beforeMove() {
        JOptionPane.showMessageDialog(null, "Odchodzę!");
        //stop threads
        //save state
        super.beforeMove();
    }

    private void registerCodecs(){
        ContentManager cm = getContentManager();
        cm.registerLanguage(new SLCodec());
        cm.registerOntology(MobilityOntology.getInstance());
    }

}
