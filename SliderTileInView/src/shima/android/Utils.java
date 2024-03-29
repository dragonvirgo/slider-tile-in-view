package shima.android;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;

public class Utils {
	public static Matrix adjustingMatrix(float srcWidth, float srcHeight, float dstWidth, float dstHeight) {
		float scale;
		float dx = 0f, dy = 0f;
		if (dstWidth/dstHeight > srcWidth/srcHeight) {	// vertically fit
			scale = dstHeight/srcHeight;
			dx = (dstWidth - scale*srcWidth) / 2f;
		} else {										// horizontally fit
			scale = dstWidth/srcWidth;
			dy = (dstHeight - scale*srcHeight) / 2f;
		}
		Matrix matrix = new Matrix();
		matrix.setScale(scale, scale);
		matrix.postTranslate(dx, dy);
		return matrix;
	}
	public static Rect translated(Rect src, Point offset) {
		Rect dst = new Rect(src);
		if (offset == null) return dst;
		dst.top		+= offset.y;
		dst.left	+= offset.x;
		dst.bottom	+= offset.y;
		dst.right	+= offset.x;
		return dst;
	}
}
