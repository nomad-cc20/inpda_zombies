package zombies.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import zombies.ReLogoTurtle

@Plural("Children")
class Child extends Human {
	
	int growthTime = 0
	int growthPeriod = 120
	
	@Override
	def step() {
		growthTime++;
		
		if (growthTime > growthPeriod) {
			if (Math.random() < 0.9) {
				if (Math.random() < 0.5)
					hatchMales(1) {
						color = Utility.blue()
					}
				else
					hatchFemales(1) {
						color = Utility.red()
					}
			} else {
				hatchHunters(1) {
					color = Utility.yellow();
				}
			}
			die();
			return;
		}
		
		super.step();
	}
}
