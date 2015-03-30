import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.core.PImage;


public class Screen {
	PApplet parent;
	PImage startImg;
	PImage endImg;
	boolean splash;
	boolean end;
	int option;
	
	Screen(PApplet p) {
	    parent = p;
	    startImg = parent.loadImage("start.png");
	    endImg = parent.loadImage("end.png");
	}
	
	void display() {
		
		if(option < 0){
	      option = 0;
	    }
	    else if(option > 2){
	      option = 2;
	    }
		
		if(splash){
			parent.image(startImg, 0, 0);
		}
		
		if(end){
			parent.image(endImg, 0, 0);
		}
	}
}
