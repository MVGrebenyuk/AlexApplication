package com.mygdx.game.Ads;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Ads.AdsBorder;
import com.mygdx.game.Utils.StrBuilder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class Ads extends ScaledButton {

    public AdsBorder adsBorder;
    public String description;
    public String title;
    public String data = "01.01.2021";
    private Font dataFont;

    public Ads(TextureRegion region, AdsBorder adsBorder, String description) {
        super(region);
        this.adsBorder = adsBorder;
        this.description = StrBuilder.createAdsDescription(description);
        dataFont = new Font("commonFont.fnt", "commonFont.png");
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return super.touchDragged(touch, pointer);
    }

    public void drawTitle(SpriteBatch batch) {
        dataFont.draw(batch, data, adsBorder.getRight() + 0.001f, adsBorder.getBottom() + 0.001f);

    }

    @Override
    public void draw(SpriteBatch batch) {
        dataFont.draw(batch, data, adsBorder.getRight() + 0.001f, adsBorder.getBottom() + 0.001f);
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.06f);
        setTop(adsBorder.getTop() - 0.04f);
        setLeft(adsBorder.getLeft() + 0.01f);
        dataFont.setSize(0.14f);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException {

    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
