package zombies.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import org.apache.poi.hssf.util.HSSFColor.GREEN

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import zombies.ReLogoTurtle

class Human extends UserTurtle {
	
	def infected = false
	def infectionTime = 0

	@Override
	def step() {
		def winner = minOneOf(neighbors()) { 
			count(zombiesOn(it))
		}
		face(winner)
		forward(0.3)
		
		if (infected) {
			infectionTime++;
			if (infectionTime > gestationPeriod) {
				hatchZombies(1) {
					color=Utility.green();
				}
				die()
			}
		}
	}
}
