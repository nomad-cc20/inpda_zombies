package zombies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import zombies.ReLogoObserver;

class UserObserver extends ReLogoObserver{


	@Setup
	def setup(){
		clearAll()
		setDefaultShape(Male, "person")
		createMales((int)(numHumans / 2)) {
			setxy(randomXcor(), randomYcor())
			setColor(Utility.blue())
		}
		setDefaultShape(Female, "person")
		createFemales((int)(numHumans / 2)) {
			setxy(randomXcor(), randomYcor())
			setColor(Utility.red())
		}
		setDefaultShape(Child, "child")
		setDefaultShape(Zombie, "zombie")
		createZombies(numZombies) {
			setxy(randomXcor(), randomYcor())
			setColor(Utility.green())
		}
		setDefaultShape(Hunter, "zombie_killer")
		createHunters(numHunters) {
			setxy(randomXcor(), randomYcor())
			setColor(Utility.yellow())
		}
	}

	@Go
	def go(){
		ask(hunters()) {
			step()
		}		
		ask(zombies()) {
			step()
		}
		ask(males()) {
			step()
		}
		ask(females()) {
			step()
		}
		ask(children()) {
			step();
		}
	}
	
	def remainingHumans() {
		count(humans())
	}
	
}