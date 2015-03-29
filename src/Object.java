import processing.core.PApplet;

public class Object {
  PApplet parent;
  float ballX;
  float ballY;
  float sizeR;
  float sizeG;
  float green;
  float red;

  Object(PApplet p) {
    parent = p;
    sizeR = 40;
    sizeG = 80;
    ballX = parent.random(0, parent.width);
    ballY = parent.random(0, parent.height);
  }

  void display() {
	  
	  sizeR += .10; 
	  parent.fill(255, 0, 0);
	  parent.ellipse(ballX, ballY, sizeR, sizeR);
	  
	  if(sizeG != 0){
		  sizeG -= .10;
	  }  
		  
		  parent.fill(0, 255, 0);
		  parent.ellipse(ballX, ballY, sizeG, sizeG);
		 
  }

}