package com.mygdx.game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.math.Rect;


public class ExitButton extends ScaledButton {

    private static final float MARGIN = 0.05f;

    public ExitButton(TextureRegion region) {
        super(region);
    }

   @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.08f);
        setBottom(worldBounds.getBottom() + 0.1f);
    }

    @Override
    public void action() {
        System.out.println("Выход из приложения");
        Gdx.app.exit();
    }
}
