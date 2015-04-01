import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Main extends PApplet {

  Tracking tracking;
  Screen screen;
  Score score;
  Object[] object = new Object[3];
  
  public static Capture video;
  public static int ballX;
  public static int ballY;
  public static boolean splash;
  public static boolean end;
  
  public void setup() {
	  size(640, 480);
	  video = new Capture(this, width, height, 30);
	  
	  score = new Score(this);
	  tracking = new Tracking(this);
	  screen = new Screen(this);
	  for (int i = 0; i < object.length; i++) {
		  object[i] = new Object(this);
	  }
	  
	  splash = true;
  }

  public void draw() {
	  screen.display();
	  
	  if(splash == false){
		  tracking.display();
		  score.update();
		  for (int i = 0; i < object.length; i++) {
			  object[i].display();
			  object[i].dection();
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
		    	if(screen.option == 0 || screen.option == 2){
		    		splash = false;
		    	}
		    }
		}
  }
}