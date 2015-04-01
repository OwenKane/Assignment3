import processing.core.PApplet;
import processing.core.PImage;

public class Screen{
	PApplet parent;
	PImage startImg;
	PImage endImg;
	int option;
	boolean pressed;
	int time;
	
	Screen(PApplet p) {
	    parent = p;
	    option = 1;
	    startImg = parent.loadImage("start.png");
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
				parent.fill(217, 218, 2);
		    }
		    else{
		    	parent.fill(237, 117, 36);
		    }
			parent.rect(64, 320, 128, 80, 7);
			parent.fill(0, 102, 153);
			parent.text("Normal", 70, 400 - 30);
		      
		    if(option == 1){
		    	  parent.fill(217, 218, 2);
		    }
		    else{		     
		    	  parent.fill(237, 117, 36);
		    }
		    parent.rect(256, 320, 128, 80, 7);
		    parent.fill(0, 102, 153);
		    parent.textSize(19);
		    parent.text("Instructions", 264, 400 - 30);
		      
		    if(option == 2){
		    	parent.fill(217, 218, 2);
		    }
		    else{
		    	parent.fill(237, 117, 36);
		     }
		     parent.rect(448, 320, 128, 80, 7);
		     parent.fill(0, 102, 153);
		     parent.textSize(32);
		     parent.text("Hard", 474, 400 - 30);

		}
		
		if(Main.end){
			parent.image(endImg, 0, 0);
		}
	}
}
