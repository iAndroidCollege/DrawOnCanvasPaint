package college.edu.tomer.recognizer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by master on 19/02/16.
 */
public class PaintView extends View {
    private Path path;
    private int PAINT_COLOR = 0xff000000;
    private Paint paint;
    private float STROKE_WIDTH = 20;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    private void initPaint() {
        path = new Path();
        paint = new Paint();
        paint.setColor(PAINT_COLOR);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawPath(path, paint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getAction();
        float x = e.getX();
        float y = e.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                invalidate();
                path.lineTo(x,y);
            return true;
            case MotionEvent.ACTION_UP:
                invalidate();
                return  false;
            default:
                return false;


        }

    }
}
