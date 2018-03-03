package display_engine;

import resources.DisplayInfo;

/**
 * @author BIZOT Loïc
 */
public class ObserverVue implements DisplayInfo{

	private int x;
	private int y;
	private int scale;
	
	private IFollowable followed;
	
	private IWindow windowAffectedView;
	
	public ObserverVue(IWindow w) {
		
		x = -1;
		y = -1;
		scale = 128;
		followed = null;
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
		
		if(followed != null)
			return followed.getX();
		else
			return x;
		
	}

	@Override // form DisplayInfo
	public int getViewY() {
		
		if(followed != null)
			return followed.getY();
		else
			return y;
		
	}
	
	public void follow(IFollowable f) {
		this.followed = f;
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
