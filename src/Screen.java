import processing.core.PApplet;
import processing.core.PImage;
import processing.video.*;
import processing.core.*;


public class Screen {
	PApplet parent;
	PImage startImg;
	PImage endImg;
	boolean spash;
	boolean end;
	int option;
	
	Screen(PApplet p) {
	    parent = p;
	    startImg = parent.loadImage("start.png");
	    endImg = parent.loadImage("end.png");
	}
	
	void SplashS() {
		/*
		if(option < 0){
	      option = 0;
	    }
	    else if(option > 2){
	      option = 2;
	    }
	    */
		parent.image(startImg, 0, 0);
	}
	
	void GameO(){
		
	}
}
