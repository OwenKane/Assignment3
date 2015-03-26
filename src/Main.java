import processing.core.*;

import processing.video.*;

import processing.core.PImage;
 
 
public class Main extends PApplet {

	Capture video;
	 
	PImage prevFrame;
	 
	
	float threshold = 200;
	int Mx = 0;
	int My = 0;
	int ave = 0;
	 
	int ballX = width/8;
	int ballY = height/8;
	int rsp = 5;
	
	public void setup() {
	  size(640, 480);
	  video = new Capture(this, width, height, 30);
	  video.start();
	  prevFrame = createImage(video.width, video.height, RGB);
	}
	 
	public void draw() {
	 
	 
	  if (video.available()) {
	 
	    prevFrame.copy(video, 0, 0, video.width, video.height, 0, 0, video.width, video.height); 
	    prevFrame.updatePixels();
	    video.read();
	  }
	 
	  loadPixels();
	  video.loadPixels();
	  prevFrame.loadPixels();
	 
	  Mx = 0;
	  My = 0;
	  ave = 0;
	 
	 
	  for (int x = 0; x < video.width; x ++ ) {
	    for (int y = 0; y < video.height; y ++ ) {
	 
	      int loc = x + y*video.width;            
	      int current = video.pixels[loc];      
	      int previous = prevFrame.pixels[loc]; 
	 
	      float r1 = red(current); 
	      float g1 = green(current); 
	      float b1 = blue(current);
	      float r2 = red(previous); 
	      float g2 = green(previous); 
	      float b2 = blue(previous);
	      float diff = dist(r1, g1, b1, r2, g2, b2);
	
	 
	      if (diff > threshold) { 
	        pixels[loc] = video.pixels[loc];
	        Mx += x;
	        My += y;
	        ave++;
	      } 
	      else {
	 
	        pixels[loc] = video.pixels[loc];
	      }
	    }
	  }
	
	  if (ave != 0) { 
	    Mx = Mx/ave;
	    My = My/ave;
	  }
	  if (Mx > ballX + rsp/2 && Mx > 50) {
	    ballX+= rsp;
	  }
	  else if (Mx < ballX - rsp/2 && Mx > 50) {
	    ballX-= rsp;
	  }
	  if (My > ballY + rsp/2 && My > 50) {
	    ballY+= rsp;
	  }
	  else if (My < ballY - rsp/2 && My > 50) {
	    ballY-= rsp;
	  }
	 
	  updatePixels();
	  noStroke();
	  fill(0, 0, 255);
	  ellipse(ballX, ballY, 20, 20);
	  
	  if(ballX > width/2 + 40)
	  {
	    rect(width/2 + 130, height/2 - 80, 60, 40);
	  }
	  
	  if(ballX < width/2 - 40)
	  {  
	    rect(width/2 - 190, height/2 - 80, 60, 40);
	  }
	}
}








