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
	
	public ObserverVue(IWindow w) {
		x = 9;
		y = 9;
		scale = 128;
		windowAffectedView = w;
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

	@Override // form DisplayInfo
	public int getWindowWidth() {
		return windowAffectedView.getWindowWidth();
	}

	@Override // form DisplayInfo
	public int getWindowHeight() {
		return windowAffectedView.getWindowHeight();
	}
	
}
