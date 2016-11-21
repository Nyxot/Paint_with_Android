package com.example.nyxot.paint;
/**
 * Created by Nyxot on 20/11/2016.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.example.nyxot.paint.R;

import static android.R.attr.x;
import static android.R.attr.y;

public class PaintCanvas extends View implements OnTouchListener {

    List<Point> points = new ArrayList<Point>();
    Paint paint = new Paint();
    Bitmap puntero;
    Resources mRes;

    public PaintCanvas(Context context)
    {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);
        mRes = context.getResources();

        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);

        //puntero = BitmapFactory.decodeResource(mRes,R.mipmap.ic_launcher);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        for(Point point:points)
        {
            canvas.drawCircle(point.x, point.y, 5, paint);
        }
        canvas.drawBitmap(puntero, 10, 0, paint);
    }

    public boolean onTouch(View view, MotionEvent event)
    {
        Point point = new Point();
        point.x = (int)event.getX();
        point.y = (int)event.getY();
        points.add(point);
        invalidate();
        return  true;
    }

    @Override
    public String toString()
    {
        return x+","+y;
    }
}
