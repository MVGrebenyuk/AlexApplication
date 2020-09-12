package com.mygdx.game.Vote;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.sql.SQLException;

public class VoteStars extends ScaledButton {
    public Vote vote;

    public VoteStars(TextureRegion region, Vote vote) {
        super(region);
        this.vote = vote;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setTop(vote.getBottom() - 0.01f);
    }

    @Override
    public void action() throws SQLException, ClassNotFoundException, IOException {

    }
}
