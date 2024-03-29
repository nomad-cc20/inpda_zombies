package zombies.context;

import javax.swing.JPanel;
import repast.simphony.context.Context;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
import repast.simphony.relogo.Observer;
import repast.simphony.relogo.factories.LinkFactory;
import repast.simphony.relogo.factories.ObserverFactory;
import repast.simphony.relogo.factories.PatchFactory;
import repast.simphony.relogo.factories.RLWorldDimensions;
import repast.simphony.relogo.factories.ReLogoWorldFactory;
import repast.simphony.relogo.factories.TurtleFactory;
import zombies.relogo.UserLink;
import zombies.relogo.UserObserver;
import zombies.relogo.UserPatch;
import zombies.relogo.UserTurtle;
import zombies.relogo.UserGlobalsAndPanelFactory;

public class SimBuilder implements ContextBuilder {
	
	public Context build(Context context) {
	
		if (RunEnvironment.instance.isBatch()){
            UserGlobalsAndPanelFactory ugpf = new UserGlobalsAndPanelFactory();
            ugpf.initialize(new JPanel());
            ugpf.addGlobalsAndPanelComponents();
        }
		 
		Parameters p = RunEnvironment.getInstance().getParameters();
		
		// NOTE: minPxcor and minPycor must be <= 0
		int minPxcor = -16;
		int maxPxcor = 16;
		int minPycor = -16;
		int maxPycor = 16;
		RLWorldDimensions rLWorldDimensions = new RLWorldDimensions(minPxcor, maxPxcor, minPycor, maxPycor, new repast.simphony.space.continuous.StickyBorders());
		
		LinkFactory lf = new LinkFactory(UserLink);
		TurtleFactory tf = new TurtleFactory(UserTurtle);
		PatchFactory pf = new PatchFactory(UserPatch);		
		ReLogoWorldFactory wf = new ReLogoWorldFactory(context,"default_observer_context", rLWorldDimensions, tf, pf, lf);
		
		ObserverFactory oF = new ObserverFactory("default_observer",UserObserver,wf);
		Observer dO = oF.createObserver();
		
		context.add(dO);
		return context;
	}
}
