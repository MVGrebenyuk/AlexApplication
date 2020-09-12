package com.mygdx.game.Vote;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Vote.VoteScreen;
import com.mygdx.game.math.Rect;


public class VoteButton extends ScaledButton {

    private Game game;

    public VoteButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setRight(worldBounds.getRight() - 0.15f);
        setBottom(worldBounds.getBottom() + 0.02f);
    }

    @Override
    public void action() {
        game.setScreen(new VoteScreen(game));
    }
}
