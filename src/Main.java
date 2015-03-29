import processing.core.PApplet;
import processing.video.*;
import processing.core.*;

public class Main extends PApplet {

  Tracking tracking;
  Object object;

  public static Capture video;
  
  public void setup() {
	  size(640, 480);
	  video = new Capture(this, width, height, 30);
	  tracking = new Tracking(this);
	  object = new Object(this);
  }

  public void draw() {
	  tracking.display();
	  
	  object.display();
  }
}