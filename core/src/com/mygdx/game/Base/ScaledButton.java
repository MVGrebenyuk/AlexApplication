package com.mygdx.game.Base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.sql.SQLException;

public abstract class ScaledButton extends Sprite {

    private static final float SCALE = 0.9f;

    private boolean pressed;
    private int pointer;
    private Vector2 touch = new Vector2(0, 0);

    public ScaledButton(TextureRegion region) {
        super(region);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (pressed || !isMe(touch)) {
            return false;
        }
        this.pointer = pointer;
        this.touch = touch;
        pressed = true;
        scale = SCALE;
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer, int button) {
      /*  if (pressed || !isMe(touch)) {
            return false;
        }
        this.pos.y = touch.y;*/
    /*  if(this.touch.y != touch.y){
          this.pos.y = touch.y;
      } */
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException {
        if (this.pointer != pointer || !pressed) {
            return false;
        }
        if (isMe(touch)) {
            action();
        }
        pressed = false;
        scale = 1f;
        return false;
    }

    public abstract void action() throws SQLException, ClassNotFoundException;
}
