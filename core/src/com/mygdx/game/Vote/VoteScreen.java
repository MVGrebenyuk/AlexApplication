package com.mygdx.game.Vote;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class VoteScreen extends StartScreen {

    private Texture voteTexture;
    private Texture voteImageTexture;
    private Texture starstexture;
    private TextureRegion voteRegion;
    private TextureRegion imageRegion;
    private TextureRegion starsRegion;
    private Vote voteBorder;
    private VoteImage voteImage;
    private VoteStars stars;

    @Override
    public void setPageName(String pageName) {
        super.setPageName(pageName);
    }

    public VoteScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        voteTexture = new Texture("textures/vote.png");
        voteImageTexture = new Texture("data/news4.jpg");
        starstexture = new Texture("textures/fakeStars.png");
        voteRegion = new TextureRegion(voteTexture);
        imageRegion = new TextureRegion(voteImageTexture);
        starsRegion = new TextureRegion(starstexture);
        voteBorder = new Vote(voteRegion, 1);
        voteImage = new VoteImage(imageRegion, voteBorder);
        stars = new VoteStars(starsRegion, voteBorder);
        setPageName("Голосования");
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        voteBorder.resize(worldBounds);
        voteImage.resize(worldBounds);
        stars.resize(worldBounds);
    }

    @Override
    public void render(float delta) {

        super.render(delta);
        batch.begin();
        voteBorder.draw(batch);
        voteImage.draw(batch);
        stars.draw(batch);
        batch.end();

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
