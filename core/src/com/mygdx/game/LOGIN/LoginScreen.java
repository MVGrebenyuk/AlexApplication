package com.mygdx.game.LOGIN;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.Utils.NotificationHandler;
import com.mygdx.game.Utils.Parameters;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

public class LoginScreen extends BaseScreen {
    public Game game;
    public Background background;
    public Texture backgroundTexture;
    public LoginButton loginButton;
    public Texture loginButtonTexture;
    public TextureRegion loginButtonTextureRegion;
    private NotificationHandler notificationHandler;

    // NETWORK

    public static Socket socket;
    public static ObjectDecoderInputStream is;
    public static ObjectEncoderOutputStream os;

    public LoginScreen(Game game, NotificationHandler notificationHandler) throws IOException {
        this.game = game;
        this.notificationHandler = notificationHandler;
        socket = new Socket("192.168.0.100", 8189);
        os = new ObjectEncoderOutputStream(socket.getOutputStream());
        is = new ObjectDecoderInputStream(socket.getInputStream());
        Parameters.socket = socket;
        Parameters.is = is;
        Parameters.os = os;
        runNotificationThread();
    }

    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("textures/loginPage.jpg");
        background = new Background(backgroundTexture);
        loginButtonTexture = new Texture("textures/loginButton.png");
        loginButtonTextureRegion = new TextureRegion(loginButtonTexture);
        loginButton = new LoginButton(loginButtonTextureRegion, this.game, this, notificationHandler);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        loginButton.draw(batch);
        batch.end();
    }

    private void runNotificationThread() {new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Создан новый поток");
            while (true){
                try {
                    os.writeObject("/update");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    String update = (String) is.readObject();
                    if(update.startsWith("AdsUpdate")){
                        notificationHandler.showNotification("Алексеевка", "Пришло новое уведомление");
                        Thread.sleep(50000);
                    } else if(update.startsWith("NewsUpdate")) {
                        notificationHandler.showNotification("Алексеевка", "Пришла новая новость");
                        Thread.sleep(50000);
                    }
                    else {
                        Thread.sleep(30000);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        loginButton.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        loginButton.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, IOException, ClassNotFoundException {
        loginButton.touchUp(touch, pointer, button);
        return super.touchUp(touch, pointer, button);
    }
}
