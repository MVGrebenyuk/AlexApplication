package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class LsScreen extends StartScreen {
    @Override
    public void setPageName(String pageName) {
        super.setPageName(pageName);
    }

    public LsScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        setPageName("Личные сообщения");
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        return super.touchUp(touch, pointer, button);
    }
}
