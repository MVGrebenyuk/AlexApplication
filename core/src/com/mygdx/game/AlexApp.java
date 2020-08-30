package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.Screens.HomeScreen;

public class AlexApp extends Game {

	@Override
	public void create() {

		setScreen(new HomeScreen(this)

		);
	}
}

