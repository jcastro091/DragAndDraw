/**
 * 
 */
package com.castro.draganddraw;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author John
 *
 */
public class BoxDrawingView extends View {
	
	
	public static final String TAG ="BoxDrawingView";
	
	private Box mCurrentBox;
	private ArrayList<Box> mBoxes = new ArrayList<Box>();
	private Paint mBoxPaint;
	private Paint mBackgroundPaint;
	
	
	//Used when craeting the view in code
	public BoxDrawingView (Context context){
		this (context, null);
	}
	//Used when inflating the view from XML
	public BoxDrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		//Paint the boxes with a nice semitransparent red
		mBoxPaint = new Paint();
		mBoxPaint.setColor(0x22ff0000);;
		
		//Paint the background off-white
		mBackgroundPaint = new Paint();
		mBackgroundPaint.setColor(0xfff8efe0);
		
		
	}
	
	@Override
	public boolean onTouchEvent (MotionEvent event) {
		PointF curr = new PointF(event.getX(), event.getY());
		
		Log.i(TAG, "Recieved event at x =" +curr.x + ", y=" +curr.y + ":");
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.i(TAG, " ACTION_DOWN");
			//Reset drawing state
			mCurrentBox = new Box(curr);
			mBoxes.add(mCurrentBox);
			break;
		case MotionEvent.ACTION_MOVE:
			Log.i(TAG, " ACTION_MOVE");
			if (mCurrentBox != null)	 {
				mCurrentBox.setCurrent(curr);
				invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			Log.i(TAG, " ACTION_UP");
			mCurrentBox = null;
			break;
		case	MotionEvent.ACTION_CANCEL:
			Log.i(TAG, " ACTION_CANCEL");
			mCurrentBox = null;
			break;
		}
		
		
		return true;
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//Fill the background
		canvas.drawPaint(mBackgroundPaint);
		
		for (Box box : mBoxes) {
			float left = Math.min(box.getOrigin().x, box.getCurrent().x);
			float right = Math.max(box.getOrigin().x, box.getCurrent().x);
			float top = Math.min(box.getOrigin().y, box.getCurrent().y);
			float bottom = Math.max(box.getOrigin().y, box.getCurrent().y);
		
			canvas.drawRect(left, top, right, bottom, mBoxPaint);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
