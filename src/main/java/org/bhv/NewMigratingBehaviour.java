package org.bhv;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.JADEAgentManagement.QueryPlatformLocationsAction;
import jade.domain.mobility.MobilityOntology;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.java.Log;

import java.util.UUID;
import java.util.logging.Level;


@Log
public class NewMigratingBehaviour  extends CyclicBehaviour {

    boolean waiting = false;
    @Override
    public void action() {

        if(waiting){


        }

       QueryPlatformLocationsAction query = new QueryPlatformLocationsAction();
        Action action = new Action(myAgent.getAMS(), query);

        String conversationId = UUID.randomUUID().toString();

        ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
        request.setLanguage(new SLCodec().getName());
        request.setOntology(MobilityOntology.getInstance().getName());
        request.addReceiver(myAgent.getAMS());
        request.setConversationId(conversationId);

        try {
            myAgent.getContentManager().fillContent(request, action);
            myAgent.send(request);
            MessageTemplate mt = MessageTemplate.MatchConversationId(conversationId);
            ACLMessage msg = myAgent.receive(mt);

        } catch (Codec.CodecException | OntologyException ex) {
            //log.log(Level.WARNING, ex.getMessage(), ex);
        }
    }



}
