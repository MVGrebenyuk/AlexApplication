package com.mygdx.game.LOGIN;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class LoginScreen extends BaseScreen {
    public Game game;
    public Background background;
    public Texture backgroundTexture;
    public LoginButton loginButton;
    public Texture loginButtonTexture;
    public TextureRegion loginButtonTextureRegion;

    public LoginScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("textures/loginPage.jpg");
        background = new Background(backgroundTexture);
        loginButtonTexture = new Texture("textures/loginButton.png");
        loginButtonTextureRegion = new TextureRegion(loginButtonTexture);
        loginButton = new LoginButton(loginButtonTextureRegion, this.game, this);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        loginButton.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        loginButton.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        loginButton.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, IOException, ClassNotFoundException {
        loginButton.touchUp(touch, pointer, button);
        return super.touchUp(touch, pointer, button);
    }
}
