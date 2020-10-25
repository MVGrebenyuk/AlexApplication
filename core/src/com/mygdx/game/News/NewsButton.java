package com.mygdx.game.News;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Common.ScreenRepository;
import com.mygdx.game.Utils.NotificationHandler;
import com.mygdx.game.math.Rect;


public class NewsButton extends ScaledButton {

    private Game game;
    private NotificationHandler notificationHandler;

    public NewsButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setBottom(worldBounds.getBottom());
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void action() {
        if (ScreenRepository.newsScreen == null) {
            game.setScreen(new NewsScreen(game, notificationHandler));
        } else {
            game.setScreen(ScreenRepository.newsScreen);
        }

    }
}
