import java.util.ArrayList;
import processing.core.PApplet;
import processing.video.Capture;
import blobscanner.Detector;

public class Main extends PApplet {

  Tracking tracking;
  Blob blob;
  Screen screen;
  Score score;
  Object[] object = new Object[3];
  Object2[] object2 = new Object2[5];
  public static ArrayList<Player> players = new ArrayList<Player>();
  
  public static Capture video;
  public static Detector bd;
  public static Capture frame;
  public static float ballX;
  public static float ballY;
  public static int points;
  public static int lives;
  public static boolean splash;
  public static boolean instruct;
  public static boolean end;
  int difficulty;

  
  public void setup() {
	  size(640, 480);
	  lives = 10;
	  difficulty = 3;
	  //video = new Capture(this, width, height, 30);
	  video = new Capture(this, width, height, 30);
	  bd = new Detector( this, 255 );
	  
	  score = new Score(this);
	  blob = new Blob(this);
	  tracking = new Tracking(this);
	  screen = new Screen(this);
	  for (int i = 0; i < object.length; i++) {
		  object[i] = new Object(this);
	  }
	  for (int i = 0; i < object2.length; i++) {
		  object2[i] = new Object2(this);
	  }
	  
	  splash = true;
	  end = false;
  }

  public void draw() {
	  screen.display();
	  
	  if(splash == false && instruct == false){
		  //tracking.display();
		  blob.display();
		  score.update();
		  for (int i = 0; i < difficulty; i++) {
			  object2[i].enemy();
			  object2[i].dection();
		  }
		  for (int i = 0; i < 3; i++) {
			  object[i].friendly();
			  object[i].dection();
		  }
		  
		  for(int i = 0; i < players.size(); i++){
			  //println("you made it to 4");
			  Player part = players.get(i);
			  part.display();
			  //println("you made it to 4.2");
		  }
	  }
  }
  
  public void keyPressed() {
	  if (key == CODED) {
		    if (keyCode == RIGHT) {
		    	screen.option = screen.option + 1;
		    } else if (keyCode == LEFT) {
		    	screen.option = screen.option - 1;
		    } else if (keyCode == UP){
		    	if(screen.option == 0 && end == false){
		    		splash = false;
		    		instruct = false;
		    		difficulty = 3;
		    	}
		    	if(screen.option == 2 && end == false){
		    		splash = false;
		    		instruct = false;
		    		difficulty = 5;
		    	}
		    	if(screen.option == 1 && end == false){
		    		splash = false;
		    		instruct = true;
		    	}
		    	if(end == true){
		    		splash = true;
		    		instruct = false;
		    		end = false;
		    		lives = 10;
		    		points = 0;
		    	}
		    	
		    }else if (keyCode == DOWN && instruct == true){
		    	splash = true;
	    		instruct = false;
		    }
		}
  }
}