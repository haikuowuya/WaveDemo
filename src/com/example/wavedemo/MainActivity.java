package com.example.wavedemo;

import java.util.Random;

import com.example.wavedemo.WaveView.VolumeCallBack;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	WaveView waveView;
	Handler handler = new Handler();
	Random random = new Random();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		waveView = (WaveView) findViewById(R.id.wave_view);
		waveView.setVoiceCircleColor(0x60dedede, 0x70dedede);
		waveView.setVoiceSurroundColor(0x80dedede);
		waveView.setVolumeCallback(new VolumeCallBack() {
			@Override
			public int getAmplitude() {
				
				//test
				///recorder.getMaxAmplitude();
				return random.nextInt(100);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if (waveView != null) {
			handler.removeCallbacks(showWaveViewRunnable);
			waveView.setVisibility(View.GONE);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		handler.removeCallbacks(showWaveViewRunnable);
		handler.postDelayed(showWaveViewRunnable, 200);
	}
	
	private Runnable showWaveViewRunnable = new Runnable() {
		@Override
		public void run() {
			waveView.setVisibility(View.VISIBLE);
			waveView.startAnimation();
		}
	};

}
