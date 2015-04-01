import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Tracking {
  PApplet parent; // The parent PApplet allows us to uses classes while being able to use processing funtions outside main class
  
  PImage prevFrame;
  
  float threshold;//Used to determine how sensitive to movement the ball is
  int Mx;
  int My;
  int ave;
	 
  int rsp;//Used to control the speed the tracking ball moves at
  
  
  Tracking(PApplet p) {
    parent = p;
    Main.video.start();
	prevFrame = parent.createImage(Main.video.width, Main.video.height, parent.RGB);//Creates a new PImage
	
	threshold = 200;
	Main.ballX = parent.width/8;
	Main.ballY = parent.height/8;
	rsp = 6;
  }

  // Draw stripe
  void display() {
	  
	  if (Main.video.available()) {
			 
		    prevFrame.copy(Main.video, 0, 0, Main.video.width, Main.video.height, 0, 0, Main.video.width, Main.video.height); 
		    prevFrame.updatePixels();
		    Main.video.read();
		  }

	  	  parent.frameRate(60);
	      parent.loadPixels();
		  Main.video.loadPixels();
		  prevFrame.loadPixels();
		  
		  Mx = 0;
		  My = 0;
		  ave = 0;
		 
		 
		  for (int x = 0; x < Main.video.width; x ++ )//Checks each pixel and compares the color changes to detect movement (loop for x axis pixels)
		  {
		    for (int y = 0; y < Main.video.height; y ++ ) 
		    {
		 
		      int loc = x + y*Main.video.width;            
		      int current = Main.video.pixels[loc];      
		      int previous = prevFrame.pixels[loc]; 
		 
		      float r1 = parent.red(current); 
		      float g1 = parent.green(current); 
		      float b1 = parent.blue(current);
		      float r2 = parent.red(previous); 
		      float g2 = parent.green(previous); 
		      float b2 = parent.blue(previous);
		      float diff = parent.dist(r1, g1, b1, r2, g2, b2);//Using dist to compare the colour changes to detect movement
		
		 
		      if (diff > threshold) 
		      { 
		    	  parent.pixels[loc] = Main.video.pixels[loc];
		          Mx += x;
		          My += y;
		          ave++;
		      } 
		      else 
		      {
		 
		    	  parent.pixels[loc] = Main.video.pixels[loc];
		      }
		    }
		  }
		
		  if (ave != 0) 
		  { 
		    Mx = Mx/ave;
		    My = My/ave;
		  }
		  if (Mx > Main.ballX + rsp/2 && Mx > 50) 
		  {
			  Main.ballX+= rsp;
		  }
		  else if (Mx < Main.ballX - rsp/2 && Mx > 50) 
		  {
			  Main.ballX-= rsp;
		  }
		  if (My > Main.ballY + rsp/2 && My > 50) 
		  {
			  Main.ballY+= rsp;
		  }
		  else if (My < Main.ballY - rsp/2 && My > 50) 
		  {
			  Main.ballY-= rsp;
		  }
		  
		  parent.updatePixels();
		  parent.noStroke();
		  parent.fill(0, 0, 255);
		  parent.ellipse(Main.ballX, Main.ballY, 40, 40);
		  

  }
}