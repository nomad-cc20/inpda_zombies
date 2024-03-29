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

class Zombie extends UserTurtle {

	@Override
	def step( ) {
		def winner = maxOneOf(neighbors()) { 
			count(humansOn(it))
		}
		
		face(winner)
		forward(0.1)
		
		if (count(humansHere()) > 0) {
			this.label = "Brains!"
			def infectee = oneOf(humansHere())
			infect(infectee)
			createInfectionTo(infectee)
		} else {
			this.label = ""
		}
	}
	
	def infect (Human human) {
		human.infected = true
	}
}
