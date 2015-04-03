import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Main extends PApplet {

  Tracking tracking;
  Screen screen;
  Score score;
  Object[] object = new Object[5];
  
  public static Capture video;
  public static int ballX;
  public static int ballY;
  public static int points;
  public static int lives;
  public static boolean splash;
  public static boolean instruct;
  public static boolean end;
  int difficulty;
  
  public void setup() {
	  size(640, 480);
	  lives = 1;
	  difficulty = 3;
	  video = new Capture(this, width, height, 30);
	  
	  score = new Score(this);
	  tracking = new Tracking(this);
	  screen = new Screen(this);
	  for (int i = 0; i < object.length; i++) {
		  object[i] = new Object(this);
	  }
	  
	  splash = true;
	  end = false;
  }

  public void draw() {
	  screen.display();
	  
	  if(splash == false && instruct == false){
		  tracking.display();
		  score.update();
		  for (int i = 0; i < difficulty; i++) {
			  object[i].enemy();
			  object[i].dection();
		  }
		  for (int i = 0; i < 3; i++) {
			  object[i].friendly();
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
		    		lives = 1;
		    		points = 0;
		    	}
		    	
		    }else if (keyCode == DOWN && instruct == true){
		    	splash = true;
	    		instruct = false;
		    }
		}
  }
}