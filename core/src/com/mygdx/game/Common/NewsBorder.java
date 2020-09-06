package com.mygdx.game.Common;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;

import java.sql.SQLException;

public class NewsBorder extends ScaledButton {

    private int count;
    private float step = 0.16f;

    public NewsBorder(TextureRegion region, int count) {
        super(region);
        this.count = count;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer, int button) {
        return super.touchDragged(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void resize(Rect worldBounds) {
        if(count == 1) {
            setHeightProportion(0.165f);
            setTop(worldBounds.getTop() - 0.07f);
            //this.pos.x = this.getLeft();
        } else if(count > 1){
            setHeightProportion(0.165f);
            setTop(worldBounds.getTop() - (0.07f + step * (count - 1)));
        } else {
            setHeightProportion(0.165f);
            setTop(worldBounds.getTop());
        }
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException {

    }
}
