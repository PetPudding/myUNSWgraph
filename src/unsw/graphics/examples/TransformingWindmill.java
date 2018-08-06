package unsw.graphics.examples;
import com.jogamp.opengl.GL3;
import unsw.graphics.Application2D;
import unsw.graphics.CoordFrame2D;
import unsw.graphics.geometry.Line2D;
import unsw.graphics.geometry.LineStrip2D;
import unsw.graphics.geometry.Point2D;
/**
 * Draws poles and windmill vanes
 * @author rubybie
 *
 */
public class TransformingWindmill extends Application2D{
	
	public TransformingWindmill() { 
		super("Transforming Windmill!!", 800, 800);
	}
	
	public static void main(String[] args) { 
		TransformingWindmill example = new TransformingWindmill();
		example.start();
	}
	
	@Override 
	public void display(GL3 gl) { 
		super.display(gl);
		CoordFrame2D frame1 = CoordFrame2D.identity();
		drawRotatingWindmill(gl, frame1);
		
	}

	public void drawPole(GL3 gl, CoordFrame2D frame) { 
		LineStrip2D pole = new LineStrip2D(-0.05f,0, -0.05f,2, 0.05f,2, 0.05f,0, -0.05f,0);
		pole.draw(gl, frame);
	}
	
	public void drawVane(GL3 gl, CoordFrame2D frame) { 
		LineStrip2D vane = new LineStrip2D(0,0, 0.5f,0.1f, 1,0, 0.5f,-0.1f, 0,0);
		vane.draw(gl, frame);
	}
	
	public void drawWindmill(GL3 gl, CoordFrame2D frame) { 
        CoordFrame2D poleFrame = CoordFrame2D.identity()
        		.scale(0.2f, 0.2f);
        CoordFrame2D vaneFrame1 = CoordFrame2D.identity()
        		.scale(0.2f, 0.2f)
        		.translate(0,2);
        CoordFrame2D vaneFrame2 = vaneFrame1.rotate(120);
        CoordFrame2D vaneFrame3 = vaneFrame2.rotate(120);
        
        drawPole(gl, poleFrame);
        drawVane(gl, vaneFrame1);
        drawVane(gl, vaneFrame2);
        drawVane(gl, vaneFrame3);
	}
	
//	public void drawWindmills(GL3 gl, CoordFrame2D frame) { 
//        CoordFrame2D frame1 = CoordFrame2D.identity()
//        		.scale(0.5f, 2);
//        drawWindmill(gl, frame1);
//        CoordFrame2D frame2 = CoordFrame2D.identity()
//        		.translate(0.2f,0.2f);
//        drawWindmill(gl, frame2);
//	}
	
	public void drawRotatingWindmill(GL3 gl, CoordFrame2D frame) { 
        CoordFrame2D poleFrame = CoordFrame2D.identity()
        		.scale(0.2f, 0.2f);
        CoordFrame2D vaneFrame1 = CoordFrame2D.identity()
        		.scale(0.2f, 0.2f)
        		.translate(0,2); // initial loc of vane1
        CoordFrame2D vaneFrame2 = vaneFrame1.rotate(120); // initial loc of vane2
        CoordFrame2D vaneFrame3 = vaneFrame2.rotate(120); // initial loc of vane3
        
        long degrees = (System.currentTimeMillis() / 100 % 360);
        System.out.println(degrees);
        
        CoordFrame2D vaner1 = vaneFrame1.rotate(degrees);
        CoordFrame2D vaner2 = vaneFrame2.rotate(degrees);
        CoordFrame2D vaner3 = vaneFrame3.rotate(degrees);
        
        drawPole(gl, poleFrame);
        drawVane(gl, vaner1);
        drawVane(gl, vaner2);
        drawVane(gl, vaner3);
	}
}
