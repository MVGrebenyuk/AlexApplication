package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.LOGIN.LoginScreen;
import com.mygdx.game.Utils.NotificationHandler;

import java.io.IOException;

public class AlexApp extends Game {

	private NotificationHandler notificationHandler;

	@Override
	public void create() {

		try {
			setScreen(new LoginScreen(this, notificationHandler)


			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setNotificationHandler(NotificationHandler handler) {
		this.notificationHandler = handler;
	}
}

