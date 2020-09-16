package com.mygdx.game.Ads;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class AdsBorder extends ScaledButton {

    private int count;
    private float step = 0.16f;
    private com.mygdx.game.News.NewsBorder[] previousNext = new com.mygdx.game.News.NewsBorder[2];

    public AdsBorder(TextureRegion region, int count, com.mygdx.game.News.NewsBorder previous) {
        super(region);
        this.previousNext[0] = previous;
        this.count = count;
    }

    public AdsBorder(TextureRegion region, int count){
        super(region);
        this.count = count;
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
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        return super.touchUp(touch, pointer, button);
    }

    public void dragSupport(com.mygdx.game.News.NewsBorder i){
        if(!i.equals(this)){
            if (previousNext[0] != null) {
                previousNext[0].pos.y = this.pos.y + 0.16f; //setTop(this.getTop() + 0.16f);
            }
            if (previousNext[1] != null) {
                previousNext[1].pos.y = this.pos.y - 0.16f; //setTop(this.getTop() - 0.16f);
            }
        }
    }

    public boolean dragged(Vector2 touch){
        if (previousNext[1] != null) {
            previousNext[1].pos.y = this.pos.y - 0.16f; //setTop(this.getTop() - 0.16f);
        }
        if(isMe(touch)) {
            this.pos.y = touch.y;
        }
        if (previousNext[0] != null) {
            previousNext[0].pos.y = this.pos.y + 0.16f; //setTop(this.getTop() + 0.16f);
        }
        return false;
    }

    public void setNextBorder(com.mygdx.game.News.NewsBorder next){
        this.previousNext[1] = next;
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
            setHeightProportion(0.35f);
            setTop(worldBounds.getTop());
        }
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException {

    }

}
