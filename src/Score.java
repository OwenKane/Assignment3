import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

class Score{
	PApplet parent;
	int savedTime;
	int totalTime;
	int passedTime;
	
	Score(PApplet p) {
	    parent = p;
		savedTime = parent.second();  
		totalTime = 2; 
	}
  
	void update()
	{
		passedTime = parent.second() - savedTime;
   
		if (passedTime > totalTime)//Addes 1 to point every 2 seconds
		{
			Main.points = Main.points + 1;
			savedTime = parent.second(); // Save the current time to restart the timer
		}   
		
		parent.fill(255,255, 0);
		parent.textSize(32);
	    parent.text("Score: " + Main.points, 10, 30);
	    parent.textSize(32);
	    parent.text("Lives: " + Main.lives, 10, 65);
	    
	    if(Main.lives < 1){
	    	Main.splash = true;
	    	Main.end = true;
	    }
	}
}