package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.LOGIN.LoginScreen;
import com.mygdx.game.News.NewsScreen;

public class AlexApp extends Game {

	@Override
	public void create() {

		setScreen(new LoginScreen(this)

		);
	}
}

