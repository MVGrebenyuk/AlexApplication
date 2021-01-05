package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.AlexApp;
import com.mygdx.game.Utils.NotificationHandler;

public class DesktopLauncher implements NotificationHandler {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 700;
		config.width = 400;
		config.resizable = false;
		new LwjglApplication(new AlexApp(), config);
	}

	@Override
	public void showNotification(String title, String text) {
		System.out.println(title + text);
	}
}
