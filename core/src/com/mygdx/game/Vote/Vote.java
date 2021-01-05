package com.mygdx.game.Vote;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Utils.StrBuilder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class Vote extends ScaledButton {

    private Texture background;
    private String description =
            StrBuilder.createVoteDescr("Комитет ЦККПСС предлагает перестроить парк имени 40 ЛЕТИЯ ВЛКСМ в озеро, которое будет включать в себя аквапарк, взлётно-посадочную полосу, современный бизнес центр и космодром. Также, выдать каждому гражданину по 1 губозакатывательной машине. Поддерживаете?");

    private int count;
    private float step = 0.16f;
    private com.mygdx.game.News.NewsBorder[] previousNext = new com.mygdx.game.News.NewsBorder[2];

    public Vote(TextureRegion region, int count, com.mygdx.game.News.NewsBorder previous) {
        super(region);
        this.previousNext[0] = previous;
        this.count = count;
    }

    public Vote(TextureRegion region, int count){
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

    @Override
    public void resize(Rect worldBounds) {
        if(count == 1) {
            setHeightProportion(0.8f);
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

    public String getDescription() {
        return description;
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException {

    }

}
