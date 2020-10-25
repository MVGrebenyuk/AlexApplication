package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		AdapterAndroid adapterAndroid = new AdapterAndroid(this);
		AlexApp alex = new AlexApp();
		alex.setNotificationHandler(adapterAndroid);

		initialize(alex, config);

	}
}
