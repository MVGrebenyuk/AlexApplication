package com.mygdx.game.Vote;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class VoteButtonNo extends ScaledButton {
    public Vote vote;

    public VoteButtonNo(TextureRegion region, Vote vote) {
        super(region);
        this.vote = vote;
    }

    @Override
    public void resize(Rect worldBounds) {
        setSize(vote.getWidth()/2, vote.getHeight()/6);
        setBottom(vote.getBottom());
        setRight(vote.getRight()-0.005f);
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException, IOException {

    }
}
