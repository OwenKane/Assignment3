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
		
		Main.bd.findBlobs(Main.video.pixels,Main.video.width,Main.video.height);
		Main.bd.loadBlobsFeatures();
		Main.bd.weightBlobs(true);
		
		int total = Main.bd.getBlobsNumber();
		parent.println("total blobs is "+ total);
		for(int i = 0; i < Main.bd.getBlobsNumber(); i++)
        {
            if(Main.bd.getBlobWeight(i) > 5000){
              PVector[] cornerA = Main.bd.getA();
              parent.fill(0,0,255);
              
              Main.ballX = cornerA[i].x;
              Main.ballY = cornerA[i].y;
              parent.ellipse( cornerA[i].x, cornerA[i].y, 40, 40);
              //Player nPlayer = new Player(parent, cornerA[i].x, cornerA[i].y);
              //Main.players.add(nPlayer);
              //Main.players.add(new Player(parent, cornerA[i].x, cornerA[i].y));
              
            }
        }
		//parent.println(parent.frameRate);
	}//avoids flickering
}
 