package clips; 

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.*;

public class ClipsAgent extends Agent {

  Environment clips;

  protected void setup() {

    System.out.println("=========================");
    System.out.println("AGENTE " + getLocalName() + " INICIADO");
    System.out.println("=========================");

    clips = new Environment();

    addBehaviour(new TellBehaviour());
    addBehaviour(new AskBehaviour());

  } 

  private class TellBehaviour extends Behaviour {
      
    boolean isTellBehaviourDone = false; 

    public void action() {

        try{

          // clips.eval("(clear)");

          clips.build("(deftemplate person (slot name) (slot nationality))");
          clips.build("(deffacts persons (person (name rodrigo) (nationality mexican)))");

          clips.build("(defrule my-nationality (person (name ?n) (nationality mexican)) => (printout t ?n ' es mexicano'  crlf ))");
          clips.reset();
        
          // MARKET
          // clips.load("/Users/roaloch/Desktop/KBS/C2/src/market/templates.clp");
          // clips.load("/Users/roaloch/Desktop/KBS/C2/src/market/facts.clp");
          // clips.load("/Users/roaloch/Desktop/KBS/C2/src/market/rules.clp");

          // PERSONS
          // clips.load("/Users/roaloch/Desktop/KBS/C2/src/persons/load-persons.clp");
          //clips.load("/Users/roaloch/Desktop/KBS/C2/src/persons/load-persons-rules.clp");

          // PRODCUST
          // clips.load("/Users/roaloch/Desktop/KBS/C2/src/prodcust/load-prod-cust.clp");
          // clips.load("/Users/roaloch/Desktop/KBS/C2/src/prodcust/load-prod-cust-rules.clp");     
           

        }catch(Exception e){}

        isTellBehaviourDone = true;
    } 
    
    public boolean done() {
        if (isTellBehaviourDone) return true;
        return false;
    } 

  }
  
  private class AskBehaviour extends Behaviour {

    boolean isAskBehaviourDone = false; 

    public void action() {

        try{

          clips.eval("(facts)"); 
          clips.eval("(rules)");

          clips.run();

        }catch(Exception e){}

        isAskBehaviourDone = true;
    } 
    
    public boolean done() {
        if (isAskBehaviourDone) return true;
	      return false;
    }
   
    public int onEnd() {

      System.out.println("=========================");
      System.out.println("AGENTE " + getLocalName() + " TERMINADO");
      System.out.println("=========================");

      myAgent.doDelete();
      return super.onEnd();
    } 
  }
}
