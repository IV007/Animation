package com.sidelance.extremeanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class InitializationActivity extends Activity implements Animation.AnimationListener {

    @Bind(R.id.textView) TextView initText;
    @Bind(R.id.imageView)ImageView image;
    @Bind(R.id.button)Button proceedButton;
    Animation fadeIn, rotateAnimation, fadeOut, blink, move;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        blink = AnimationUtils.loadAnimation(this, R.anim.blink);
        move = AnimationUtils.loadAnimation(this, R.anim.move_view);


        initText.setVisibility(View.GONE);
        image.setVisibility(View.GONE);
        proceedButton.setVisibility(View.GONE);


        rotateAnimation.setAnimationListener(this);
        fadeIn.setAnimationListener(this);
        fadeOut.setAnimationListener(this);
        blink.setAnimationListener(this);
        move.setAnimationListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        initText.setVisibility(View.VISIBLE);
        image.setVisibility(View.VISIBLE);
        proceedButton.setVisibility(View.GONE);

        image.startAnimation(fadeIn);
        initText.startAnimation(fadeIn);

    }

    /**
     * <p>Notifies the start of the fadeIn.</p>
     *
     * @param animation The started fadeIn.
     */
    @Override
    public void onAnimationStart(Animation animation) {
        if(animation == fadeIn) {
            image.startAnimation(rotateAnimation);
            initText.startAnimation(blink);


        }

    }

    /**
     * <p>Notifies the end of the fadeIn. This callback is not invoked
     * for animations with repeat count set to INFINITE.</p>
     *
     * @param animation The fadeIn which reached its end.
     */
    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == rotateAnimation){

            image.startAnimation(fadeOut);
            initText.startAnimation(fadeOut);

        }


    }

    /**
     * <p>Notifies the repetition of the fadeIn.</p>
     *
     * @param animation The fadeIn which was repeated.
     */
    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
