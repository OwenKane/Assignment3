import processing.core.PApplet;
import processing.video.*;
import processing.core.*;
import blobscanner.*;
import java.util.ArrayList;

public class Blob {
	PApplet parent;
	
	Blob(PApplet p) {
		parent = p;
	    Main.video.start();
	     
	}
	
	void display(){
		Main.video.read();
		parent.image(Main.video,0,0);
		
		Main.video.filter(5);
		Main.video.loadPixels();
		
		Main.bd.findBlobs(Main.video.pixels,Main.video.width,Main.video.height);//Function to find blobs
		Main.bd.loadBlobsFeatures();//loads ability to to draw boxes around blobs and other funtionality
		Main.bd.weightBlobs(true);//Allows us to measure weight of blobs
		
		//int total = Main.bd.getBlobsNumber();//for debugging
		//parent.println("total blobs is "+ total);
		
		for(int i = 0; i < Main.bd.getBlobsNumber(); i++)//Loops to check every blob
        {
            if(Main.bd.getBlobWeight(i) > 5000){//if a blob has a "weight" over 5000
              parent.fill(0,0,255);
              Main.ballX = Main.bd.getBoxCentX(i);//sets the x, y cords to the center of the "blob"
              Main.ballY = Main.bd.getBoxCentY(i);
              parent.ellipse(Main.ballX, Main.ballY, 40, 40);    
            }
        }
		//parent.println(parent.frameRate);
	}
}
 