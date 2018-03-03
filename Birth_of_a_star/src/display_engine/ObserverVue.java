package display_engine;

import resources.DisplayInfo;

/**
 * @author BIZOT Loïc
 */
public class ObserverVue implements DisplayInfo{

	private int x;
	private int y;
	private int scale;
	
	private IWindow windowAffectedView;
	
	public ObserverVue() {
		x = -1;
		y = -1;
		scale = -1;
	}
	
	public void setCoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setScale(int scale) {
		this.scale = scale;
	}

	@Override // form DisplayInfo
	public int getViewX() {
		return x;
	}

	@Override // form DisplayInfo
	public int getViewY() {
		return y;
	}

	@Override // form DisplayInfo
	public int getScale() {
		return scale;
	}

	@Override
	public int getWindowWidth() {
		return windowAffectedView.getWindowWidth();
	}

	@Override
	public int getWindowHeight() {
		return windowAffectedView.getWindowHeight();
	}
	
}
