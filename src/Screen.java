import processing.core.PApplet;
import processing.core.PImage;

public class Screen{
	PApplet parent;
	PImage startImg;
	PImage instructImg;
	PImage endImg;
	int option;
	boolean pressed;
	int time;
	
	Screen(PApplet p) {
	    parent = p;
	    option = 1;
	    startImg = parent.loadImage("start.png");
	    instructImg = parent.loadImage("instructions.png");
	    endImg = parent.loadImage("end.png");	
	    time = 0;
	}
	
	void display() {
		if(Main.splash){
			parent.frameRate(10);
			parent.image(startImg, 0, 0);
			
			if(option < 0){
				option = 0;
			}
			else if(option > 2){
				option = 2;
			}
			
			parent.textSize(32);
			
			if(option == 0){//Changes the colour of the title that the user is currently over
				parent.fill(204, 0, 0);
		    }
		    else{
		    	parent.fill(128, 0, 0);
		    }
			parent.rect(64, 320, 128, 80, 7);
			parent.fill(255, 204, 0);
			parent.text("Normal", 70, 400 - 30);
		      
		    if(option == 1){
		    	  parent.fill(204, 0, 0);
		    }
		    else{		     
		    	  parent.fill(128, 0, 0);
		    }
		    parent.rect(256, 320, 128, 80, 7);
		    parent.fill(255, 204, 0);
		    parent.textSize(19);
		    parent.text("Instructions", 264, 400 - 30);
		      
		    if(option == 2){
		    	parent.fill(204, 0, 0);
		    }
		    else{
		    	parent.fill(128, 0, 0);
		     }
		     parent.rect(448, 320, 128, 80, 7);
		     parent.fill(255, 204, 0);
		     parent.textSize(32);
		     parent.text("Hard", 474, 400 - 30);

		}
		
		if(Main.end){
			parent.image(endImg, 0, 0);
			parent.fill(255,0,0);
			parent.textSize(70);
	    	parent.text("SCORE: "+ Main.points, parent.width/2 - 150, parent.height / 2 + 120);
		}
		
		if(Main.instruct){
			parent.image(instructImg, 0, 0);
		}
	}
}
