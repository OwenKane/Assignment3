import processing.core.PApplet;
import processing.core.PImage;

public class Screen{
	PApplet parent;
	PImage startImg;
	PImage endImg;
	boolean splash;
	boolean end;
	
	Screen(PApplet p) {
	    parent = p;
	    startImg = parent.loadImage("start.png");
	    endImg = parent.loadImage("end.png");
	    splash = true;
	    	    
	}
	
	void display() {
		
		if(splash){
			parent.image(startImg, 0, 0);
			
			keyPressed();
			
			if(Main.option < 0){
				Main.option = 0;
			}
			else if(Main.option > 2){
				Main.option = 2;
			}
			
			parent.println("Option is"+ Main.option);
		}
		
		if(end){
			parent.image(endImg, 0, 0);
		}
	}
	
	void keyPressed() {
		if (parent.key == parent.CODED) {
		    if (parent.keyCode == parent.RIGHT) {
		    	Main.option = Main.option + 1;
		    } else if (parent.keyCode == parent.LEFT) {
		    	Main.option = Main.option - 1;
		    } 
		}
	}
}
