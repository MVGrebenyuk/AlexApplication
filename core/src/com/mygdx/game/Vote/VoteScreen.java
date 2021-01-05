package com.mygdx.game.Vote;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class VoteScreen extends StartScreen {

    private Texture voteTexture;
    private Texture voteImageTexture;
    private Texture starstexture;
    private Texture buttonNoTexture;
    private TextureRegion voteRegion;
    private TextureRegion imageRegion;
    private TextureRegion starsRegion;
    private TextureRegion buttonNoTextureRegion;
    private Vote voteBorder;
    private VoteImage voteImage;
    private VoteStars stars;
    private VoteButtonNo buttonNo;
    private Font descriptionFont;

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
        voteTexture = new Texture("textures/voteBorder.png");
        voteImageTexture = new Texture("data/news1.jpg");
        starstexture = new Texture("textures/yesButton.png");
        buttonNoTexture = new Texture("textures/noButton.png");
        voteRegion = new TextureRegion(voteTexture);
        imageRegion = new TextureRegion(voteImageTexture);
        starsRegion = new TextureRegion(starstexture);
        buttonNoTextureRegion = new TextureRegion(buttonNoTexture);
        voteBorder = new Vote(voteRegion, 1);
        voteImage = new VoteImage(imageRegion, voteBorder);
        stars = new VoteStars(starsRegion, voteBorder);
        buttonNo = new VoteButtonNo(buttonNoTextureRegion, voteBorder);
        descriptionFont = new Font("textNews.fnt", "textNews.png");
        setPageName("Голосования");
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        voteBorder.resize(worldBounds);
        voteImage.resize(worldBounds);
        stars.resize(worldBounds);
        buttonNo.resize(worldBounds);
        descriptionFont.setSize(0.015f);
    }

    @Override
    public void render(float delta) {

        super.render(delta);
        batch.begin();
        voteBorder.draw(batch);
        voteImage.draw(batch);
        stars.draw(batch);
        buttonNo.draw(batch);
        descriptionFont.draw(batch, voteBorder.getDescription(), voteImage.getLeft() + 0.01f, voteImage.getBottom() - 0.007f);
        batch.end();
        drawTopMenu();
        drawBottomMenu();

    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, screenY, pointer, button);
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
