package com.mygdx.game.LOGIN;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.News.NewsScreen;
import com.mygdx.game.Utils.NotificationHandler;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class LoginButton extends ScaledButton {

    private Game game;
    private LoginScreen screen;
    private NotificationHandler notificationHandler;

    public LoginButton(TextureRegion region, Game game, LoginScreen screen, NotificationHandler notificationHandler) {
        super(region);
        this.game = game;
        this.screen = screen;
        this.notificationHandler = notificationHandler;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setTop(worldBounds.getTop() - 0.5f);
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException, IOException {
        game.setScreen(new NewsScreen(game, notificationHandler));
    }
}
