import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Object {
  PApplet parent;
  float pointBX;
  float pointBY;
  float pointS;
  float sizeR;
  float sizeG;
  float dect2;
  boolean reset2;

  Object(PApplet p) {
    parent = p;
    sizeR = 40;
    sizeG = 80;
    pointS = 40;
    
    pointBX = parent.random(0, parent.width);
    pointBY = parent.random(0, parent.height);
  }

  void friendly(){
	  pointS += .40;
	  
	  parent.fill(0, 255, 0);
	  parent.ellipse(pointBX, pointBY, pointS, pointS);
	  
	  if(pointS > 100){
		  reset2 = true;
	  }
	  
	  if(reset2){//resets the the ball to a random cords and back to the default size;
		  pointBX = parent.random(0, parent.width);
		  pointBY = parent.random(0, parent.height);
		  pointS = 40;
		  reset2 = false;
	  }
  }
  
  void dection(){	  
	  dect2 = parent.dist(Main.ballX, Main.ballY, pointBX, pointBY);	  
	  if(dect2 < pointS){//dects if the ball is touched by the player
		  reset2 = true;
		  Main.points = Main.points + 2;
	  }
	  
  }
}