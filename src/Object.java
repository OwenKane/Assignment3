import processing.core.PApplet;

public class Object {
  PApplet parent;
  float objX;
  float objY;
  float sizeR;
  float sizeG;
  float dect;
  boolean reset;

  Object(PApplet p) {
    parent = p;
    sizeR = 40;
    sizeG = 80;
    objX = parent.random(0, parent.width);
    objY = parent.random(0, parent.height);
  }

  void display() {
	  
	  sizeR += .10; 
	  parent.fill(255, 0, 0);
	  parent.ellipse(objX, objY, sizeR, sizeR);
	  
	  if(sizeG > 10){
		  sizeG -= .20;
	  }
	  else{
		  sizeG = 0;
	  }
	  
	  parent.fill(0, 255, 0);
	  parent.ellipse(objX, objY, sizeG, sizeG);
	  
	  if(sizeR > 100){
		  reset = true;
	  }
	  
	  if(reset){
		  objX = parent.random(0, parent.width);
		  objY = parent.random(0, parent.height);
		  sizeR = 40;
		  sizeG = 80;
		  reset = false;
	  }
	  
	  
  }
  
  void dection(){
	  dect = parent.dist(Main.ballX, Main.ballY, objX, objY);
	  
	  if(dect < sizeR){
		  reset = true;
	  }
	  
  }

}