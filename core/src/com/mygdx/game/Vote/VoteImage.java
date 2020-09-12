package com.mygdx.game.Vote;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;

public class VoteImage extends Sprite {

    private Vote vote;

    public VoteImage(TextureRegion texture, Vote vote) {
        super(texture);
        this.vote = vote;
    }

    @Override
    public void resize(Rect worldBounds) {
        setSize(vote.getWidth() - 0.1f, vote.getHeight()- 0.1f);
        //setHeightProportion(0.4f);
        setTop(vote.getTop() - 0.04f);
        setLeft(vote.getLeft() + 0.05f);
    }
}
