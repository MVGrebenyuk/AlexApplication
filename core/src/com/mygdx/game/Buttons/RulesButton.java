package com.mygdx.game.Buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.Base.ScaledButton;
import com.mygdx.game.Screens.HomeScreen;
import com.mygdx.game.math.Rect;


public class RulesButton extends ScaledButton {

    private Game game;
    private static final float MARGIN = 0.05f;
    private Input.TextInputListener listener;
    private TextField field;

    public RulesButton(TextureRegion region, Game game) {
        super(region);
        this.game = game;

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        setBottom(worldBounds.getBottom() + 0.01f);
    }

    @Override
    public void action() {
      /*  Input.TextInputListener textListener = new Input.TextInputListener()
        {
            @Override
            public void input(String input)
            {
                System.out.println(input);
            }

            @Override
            public void canceled()
            {
                System.out.println("Aborted");
            }
        };

        Gdx.input.getTextInput(textListener, "Your login: ", "placeholder", ""); */

        game.setScreen(new HomeScreen(game));
    }
}
