package com.mygdx.game.Ads;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.News.NewsBorder;
import com.mygdx.game.Utils.StrBuilder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class Ads extends ScaledButton {

    public com.mygdx.game.News.NewsBorder adsBorder;
    public String description;
    public String title;

    public Ads(TextureRegion region, NewsBorder adsBorder, String description) {
        super(region);
        this.adsBorder = adsBorder;
        this.description = StrBuilder.createShortDescr(description);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return super.touchDragged(touch, pointer);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.06f);
        setTop(adsBorder.getTop() - 0.04f);
        setLeft(adsBorder.getLeft() + 0.01f);
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
