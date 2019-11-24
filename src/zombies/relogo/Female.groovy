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

class Female extends Human {
	
	def pregnant = false;
	def pregnancyTime = 0;
	def pregnancyPeriod = 9
	
	@Override
	def step() {
		if (pregnant) {
			pregnancyTime++;
			this.color = Utility.white();
			if (pregnancyTime > pregnancyPeriod) {
				hatchChildren(1) {
					color = Utility.white()
				}
				pregnant = false;
				pregnancyTime = 0;
				this.color = Utility.red()
			}
		}
		
		super.step()
	}
}