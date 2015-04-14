import processing.core.PApplet;
import java.util.ArrayList;

public class Player {
	PApplet parent;
	float x;
	float y;
	
	Player(PApplet p, float _x, float _y){
		x = _x;
		y = _y;
	}
	
	void display(){
		parent.println("you made it to 3 x: "+ x);
		parent.ellipse(x, y, 40, 40);
		parent.println("you made it to 3.2 y:"+ y);
	}
}
