package com.example.changeseat.activities;

import com.example.changeseat.R;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_welcome);
		
		//VolleyUtil.init(getApplicationContext());
		
		TextView textview = (TextView) findViewById(R.id.welcome_text);
		AnimationSet animationSet = new AnimationSet(true);
		Animation translate=AnimationUtils.loadAnimation(this, R.anim.trans_anim);
        Animation scale=AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        //animationSet.addAnimation(translate);
        animationSet.addAnimation(scale);
        textview.startAnimation(animationSet);
        
        new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
				//overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
			}
        	
        }, 3500);
	}

	public class FragmentWelcome extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

            return rootView;
        }
    }

}
