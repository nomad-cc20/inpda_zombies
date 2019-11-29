package zombies.relogo

import static repast.simphony.relogo.Utility.*;

import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import zombies.ReLogoObserver;
import repast.simphony.engine.environment.RunEnvironment;

class UserObserver extends ReLogoObserver{
	
	boolean humanitySaved = false;

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
		
		if (remainingHumans() == 0 || (remainingZombies() == 0 && remainingInfectees() == 0)) {
			if (remainingHumans() > 0) {
				humanitySaved = true;
			}
			RunEnvironment.getInstance().endRun();
		}
			
	}
	
	def remainingHumans() {
		count(humans())
	}
	
	def remainingZombies() {
		count(zombies())
	}
	
	def remainingHunters() {
		count(hunters())
	}
	
	def remainingInfectees() {
		humans().count {
			it.infected;
		}
	}
	
	boolean isHumanitySaved() {
		return humanitySaved;
	}
}