import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Main extends PApplet {

  Tracking tracking;
  Screen screen;
  Object[] object = new Object[3];

  public static Capture video;
  public static int ballX;
  public static int ballY;
  
  public void setup() {
	  size(640, 480);
	  video = new Capture(this, width, height, 30);
	  
	  tracking = new Tracking(this);
	  screen = new Screen(this);
	  for (int i = 0; i < object.length; i++) {
		  object[i] = new Object(this);
	  }
  }

  public void draw() {
	  screen.SplashS();
	  tracking.display();
	  for (int i = 0; i < object.length; i++) {
		  object[i].display();
		  object[i].dection();
	  }
  }
}