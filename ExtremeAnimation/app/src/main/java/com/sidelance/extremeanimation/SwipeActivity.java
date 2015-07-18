package com.sidelance.extremeanimation;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SwipeActivity extends Activity implements Animation.AnimationListener {

    /**
     * Screen coordinates
     * */
    float x1, x2;
    float y1, y2;

    /**
     * Animation
     * */
    Animation blink;

    /**
     * View Reference
     */
    @Bind(R.id.description) protected TextView textDisplay;
    @Bind(R.id.explanation) protected TextView explainDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        ButterKnife.bind(this);

        blink = AnimationUtils.loadAnimation(this, R.anim.blink);

        blink.setAnimationListener(this);

        textDisplay.setText("Detect Swipe Event Demo");
    }


    @Override
    public boolean onTouchEvent(MotionEvent touchEvent) {

        switch (touchEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();

                Toast.makeText(this, "Welcome Stranger", Toast.LENGTH_SHORT).show();
                break;
            }
            case MotionEvent.ACTION_UP:
            {


                x2 = touchEvent.getX();
                y2 = touchEvent.getY();

                if(x1 < x2){

                    Toast.makeText(this, "Left <-- to Right --> Swipe Performed", Toast.LENGTH_SHORT).show();

                    onAnimationStart(blink);
                }
                if (x1 > x2){

                    Toast.makeText(this, "Right <-- to Left --> Swipe Performed", Toast.LENGTH_SHORT).show();

                }
                if (y1 < y2){

                    Toast.makeText(this, "Top <-- to Bottom --> Swipe Performed", Toast.LENGTH_SHORT).show();

                }
                if (y2 < y1){

                    Toast.makeText(this, "Bottom <-- to Top --> Swipe Performed", Toast.LENGTH_SHORT).show();

                }



                break;

            }

        }

        return false;

    }


    /**
     * <p>Notifies the start of the animation.</p>
     *
     * @param animation The started animation.
     */
    @Override
    public void onAnimationStart(Animation animation) {

        textDisplay.startAnimation(blink);

    }

    /**
     * <p>Notifies the end of the animation. This callback is not invoked
     * for animations with repeat count set to INFINITE.</p>
     *
     * @param animation The animation which reached its end.
     */
    @Override
    public void onAnimationEnd(Animation animation) {

    }

    /**
     * <p>Notifies the repetition of the animation.</p>
     *
     * @param animation The animation which was repeated.
     */
    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
