package unsw.graphics.examples;
import com.jogamp.opengl.GL3;
import unsw.graphics.Application2D;
import unsw.graphics.CoordFrame2D;
import unsw.graphics.geometry.Line2D;
import unsw.graphics.geometry.LineStrip2D;
import unsw.graphics.geometry.Point2D;
/**
 * Draw more than one house
 * @author Ruby
 *
 */
public class TransformingHouse extends Application2D{
    public TransformingHouse() {
        super("Transforming House!!", 800, 800);
    }
    
    public static void main(String[] args) {
        TransformingHouse example = new TransformingHouse();
        example.start();
    }
    
    @Override
    public void display(GL3 gl) {
        super.display(gl);
        // original house 
        CoordFrame2D genFrame = CoordFrame2D.identity().scale(0.1f, 0.1f);
//        drawHouse(gl, genFrame);
        
        // first transform
        CoordFrame2D transFrame1 = genFrame
        		.translate (-1,2)
        		.rotate(45)
        		.scale(2,-1);
        drawHouse(gl, transFrame1);
        
        // second 
        CoordFrame2D transFrame2 = genFrame
        		.translate (-1,2)
        		.scale(2,-1)
        		.rotate(45);
        drawHouse(gl, transFrame2);
        
        // third 
        CoordFrame2D transFrame3 = genFrame
        		.rotate(45)
        		.translate (-1,2)
        		.scale(2,-1);
        drawHouse(gl, transFrame3);
      
        // fourth
        CoordFrame2D transFrame4 = genFrame
        		.rotate(45)
        		.scale(2,-1)
        		.translate (-1,2);
        drawHouse(gl, transFrame4);
        
        
        // fifth 
        CoordFrame2D transFrame5 = genFrame
        		.scale(2,-1)
        		.rotate(45)
        		.translate (-1,2);
        drawHouse(gl, transFrame5);
        
        // sixth
        CoordFrame2D transFrame6 = genFrame
        		.scale(2,-1)
        		.translate (-1,2)
        		.rotate(45);
        drawHouse(gl, transFrame6);
    }
    
    public void drawHouse(GL3 gl, CoordFrame2D frame) { 
    		LineStrip2D houseBody = new LineStrip2D(-1,-1, -1,1, 1,1, 1,-1, -1,-1);
    		LineStrip2D roof = new LineStrip2D(-1,1, 0,3, 1,1);
    		LineStrip2D door = new LineStrip2D(0.4f,-1, 0.4f,0, 0.8f,0 ,0.8f,-1);
    		houseBody.draw(gl, frame);
    		roof.draw(gl, frame);
    		door.draw(gl, frame);
    }

}
