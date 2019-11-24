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

class Male extends Human {
	
	@Override
	def step() {
		if (count(femalesHere()) > 0) {
			impregnate(oneOf(femalesHere()))
		}
		
		super.step();
	}
	
	def impregnate (Female female) {
		female.pregnant = true
	}
}
