package com.example.animation_kiss;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	 boolean isHeads;
	    ScaleAnimation shrink, grow;
	    ImageView flipImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        flipImage = (ImageView)findViewById(R.id.kiss_image);
        flipImage.setImageResource(R.drawable.red_lips);
        isHeads = true;

        shrink = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f,
                           ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                           ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        shrink.setDuration(150);
        shrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isHeads) {
                    isHeads = false;
                    flipImage.setImageResource(R.drawable.red_lips);
                } else {
                    isHeads = true;
                    flipImage.setImageResource(R.drawable.red_lips);
                }
                flipImage.startAnimation(grow);
            }
        });
        grow = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f,
                         ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                         ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        grow.setDuration(150);

	}

	 @Override
	    public boolean onTouchEvent(MotionEvent event) {
	        if(event.getAction() == MotionEvent.ACTION_DOWN) {
	            flipImage.startAnimation(shrink);
	            return true;
	        }
	        return super.onTouchEvent(event);
	    }

}
