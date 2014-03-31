package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * 
 * @author cainli
 *
 */
public class Circle extends View {
	private float radius = 0;
	private Paint paintFill;
	private Paint paintStroke;
	public Circle(Context context, float radius, int colorFill) {
		super(context);
		this.radius = radius;
		paintFill = new Paint();
		paintFill.setColor(colorFill);
		paintFill.setAntiAlias(true);
	}
	
	/**
	 * 设置半径
	 * @param radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	/**
	 * 设置填充颜色
	 * @param colorFill
	 */
	public void setColorFill(int colorFill) {
		paintFill.setColor(colorFill);
	}

	/**
	 * 设置描边颜色
	 * @param colorStroke
	 */
	public void setColorStroke(int colorStroke) {
		if (paintStroke == null) {
			paintStroke = new Paint();
			paintStroke.setStyle(Paint.Style.STROKE);
			paintStroke.setAntiAlias(true);
		}
		paintStroke.setColor(colorStroke);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int width = getWidth();
		int height = getHeight();
		canvas.drawCircle(width / 2, height / 2, radius, paintFill);
		
		if (paintStroke != null) {
			canvas.drawCircle(width / 2, height / 2, radius, paintStroke);
		}
		
		super.onDraw(canvas);
	}
}
