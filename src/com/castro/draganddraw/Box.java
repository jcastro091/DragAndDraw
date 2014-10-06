package com.castro.draganddraw;

import android.graphics.PointF;

public class Box {

	private PointF mOrigin;
	private PointF mCurrent;

	public Box (PointF origin) {
		setOrigin(mCurrent = origin);
	}
	
	/**
	 * @return the current
	 */
	public PointF getCurrent() {
		return mCurrent;
	}
	/**
	 * @param current the current to set
	 */
	public void setCurrent(PointF current) {
		mCurrent = current;
	}

	/**
	 * @return the origin
	 */
	public PointF getOrigin() {
		return mOrigin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(PointF origin) {
		mOrigin = origin;
	}
	
}
