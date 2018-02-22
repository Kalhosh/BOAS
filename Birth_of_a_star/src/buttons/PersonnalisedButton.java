package buttons;

import javax.swing.JButton;

/**
 * @author BIZOT Loïc
 */
public class PersonnalisedButton extends JButton{

	// serivalVersion de la classe
	private static final long serialVersionUID = 8240758619692049431L;

	private PersonnalisedButton() {
		
		// caracteristiques communes
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		
	}
	
	/**
	 * @author BIZOT Loïc
	 */
	public static class MenuButton1 extends PersonnalisedButton{

		// serivalVersion de la classe
		private static final long serialVersionUID = 3109852508290650174L;
		
		public MenuButton1() {
			
			// caracteristiques specifiques
			
		}
		
	}
	
}
