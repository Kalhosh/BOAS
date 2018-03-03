package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <p> trash class </p>
 * @author BIZOT Loïc
 */
public class BasicControls{
	
	protected IControlled controlled;
	
	public void setIControlled(IControlled c) {
		this.controlled = c;
	}
	
	public static class ControlsKeyBoard extends BasicControls implements KeyListener{

		public void keyPressed(KeyEvent arg0) {
			
			System.out.println("Lul");
			controlled.ActionKey(arg0.getKeyCode());
			
		}

		public void keyReleased(KeyEvent arg0) {
			
		}

		public void keyTyped(KeyEvent arg0) {
			
		}
		
	}
	
}
