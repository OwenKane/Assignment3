import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

class Score{
	PApplet parent;
	int savedTime;
	int totalTime;
	int passedTime;
	int points;

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
			points = points + 1;
			savedTime = parent.second(); // Save the current time to restart the timer
		}   
		
		parent.textSize(32);
	    parent.text("Score: " + points, 10, 30);
	}
}