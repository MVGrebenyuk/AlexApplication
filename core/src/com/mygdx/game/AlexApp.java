package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.LOGIN.LoginScreen;
import com.mygdx.game.Utils.NotificationHandler;

public class AlexApp extends Game {

	private NotificationHandler notificationHandler;

	@Override
	public void create() {

		setScreen(new LoginScreen(this, notificationHandler)


		);
	}

	public void setNotificationHandler(NotificationHandler handler) {
		this.notificationHandler = handler;
	}
}

