package zombies.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		addSliderWL("numHumans", "Number of Humans", 1, 1, 100, 50)
		addSliderWL("numZombies", "Number of Zombies", 1, 1, 10, 5)
		addSliderWL("numHunters", "Number of Hunters", 1, 1, 10, 5)
		addSliderWL("gestationPeriod", "Gestation", 5, 1, 30, 5)
		
		addMonitorWL("remainingHumans", "Remaining humans", 10)
		addMonitorWL("remainingHunters", "Remaining hunters", 10)
		addMonitorWL("remainingZombies", "Remaining zombies", 10)
		addMonitorWL("remainingInfectees", "Remaining infectees", 10)

	}
}