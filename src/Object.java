import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Object {
  PApplet parent;
  float objX;
  float objY;
  float pointBX;
  float pointBY;
  float pointS;
  float sizeR;
  float sizeG;
  float dect;
  float dect2;
  boolean reset;
  boolean reset2;

  Object(PApplet p) {
    parent = p;
    sizeR = 40;
    sizeG = 80;
    pointS = 40;
    objX = parent.random(0, parent.width);
    objY = parent.random(0, parent.height);
    pointBX = parent.random(0, parent.width);
    pointBY = parent.random(0, parent.height);
  }

  void display() {
	  
	  sizeR += .10; 
	  pointS += .10;
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
	  
	  parent.fill(0, 255, 0);
	  parent.ellipse(pointBX, pointBY, pointS, pointS);
	  
	  if(sizeR > 100){
		  reset = true;
	  }
	  
	  if(pointS > 100){
		  reset2 = true;
	  }
	  
	  if(reset){
		  objX = parent.random(0, parent.width);
		  objY = parent.random(0, parent.height);
		  sizeR = 40;
		  sizeG = 80;
		  reset = false;
	  }
	  
	  if(reset2){
		  pointBX = parent.random(0, parent.width);
		  pointBY = parent.random(0, parent.height);
		  pointS = 40;
		  reset2 = false;
	  }
  }
  
  void dection(){
	  dect = parent.dist(Main.ballX, Main.ballY, objX, objY);
	  if(dect < sizeR && sizeG < 5){
		  reset = true;
	  }
	  
	  dect2 = parent.dist(Main.ballX, Main.ballY, pointBX, pointBY);	  
	  if(dect2 < pointS){
		  reset2 = true;
		  Main.points = Main.points + 2;
	  }
	  
  }
}