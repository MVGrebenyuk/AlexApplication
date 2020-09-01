package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.NewsScreen;

public class AlexApp extends Game {

	@Override
	public void create() {

		setScreen(new NewsScreen(this)

		);
	}
}

