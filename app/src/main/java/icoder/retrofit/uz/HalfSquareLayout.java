package icoder.retrofit.uz;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/** A RelativeLayout that will always be square -- same width and height,
 * where the height is based off the width. */
public class HalfSquareLayout extends LinearLayout {

    public HalfSquareLayout(Context context) {
        super(context);
    }

    public HalfSquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HalfSquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HalfSquareLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        super.onMeasure((int) (widthMeasureSpec*3/5), (int) (widthMeasureSpec*3/5));
    }

}