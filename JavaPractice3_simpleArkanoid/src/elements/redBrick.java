package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import core.Game;

public class redBrick extends Brick{

	public redBrick(Game game, int x, int y) {
		super(game, x, y);
		super.lifes = 2;
		super.type = "red";
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics2D g, Color color) {
		super.paint(g, color.red);
	}
	
	@Override
	public int checkHit() {
		return super.checkHit();
	}

	@Override
	public void brickAction() {
		y = y+1;
		
		boolean brickIntersectingRacquet = game.racquet.getBounds().intersects(this.getBounds());
		
		if(brickIntersectingRacquet && super.hasHitRacquetOREndOfScreenOnFall==false) {
			super.hasHitRacquetOREndOfScreenOnFall = true;
				game.lifes--;
				game.ball.x = 0;
				game.ball.y = 0;
				System.out.println("VIDAS: " + game.lifes);
		} else if(this.getTopSide(y, HEIGHT) == game.getHeight()) { // if the brick past the screen it is removed 
			super.hasHitRacquetOREndOfScreenOnFall = true;
		}
	}
}
