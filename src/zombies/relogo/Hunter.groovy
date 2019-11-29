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

class Hunter extends Human {

	@Override
	def step() {
		if (infected) {
			die();
			return;
		}
		
		Zombie winner;
		double distanceMin = Double.MAX_VALUE;
		for (Zombie zombie : zombies()) {
			if (distance(zombie) < distanceMin) {
				winner = zombie;
				distanceMin = distance(zombie);
			}
		}
		
		if (winner == null)
			return;
		
		face(winner)
		forward(0.2)
		
		if (count(zombiesHere()) > 0) {
			this.label = "For honor!"
			kill(oneOf(zombiesHere()))
		} else {
			this.label = ""
		}
	}
	
	def kill (Zombie zombie) {
		zombie.die();
	}
	
}
