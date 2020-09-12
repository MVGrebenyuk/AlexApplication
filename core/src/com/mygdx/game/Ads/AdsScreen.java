package com.mygdx.game.Ads;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.News.NewsBorder;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

public class AdsScreen extends StartScreen {
    //Текстуры
    private Texture adsBorderTexture;
    private Texture adsTexture;
    //Регионы
    private TextureRegion adsBorderRegion;
    private TextureRegion adsRegion;
    //Спрайты
    private NewsBorder[] adsBorder;
    private Ads[] ads;
    private Font[] descriptionFont;
    private Font titleFont;
    private int count;
    //
    private static FileHandle handle = Gdx.files.local("/ads.txt");
    private ArrayList<String> list = new ArrayList<>();
    private Socket adsSocket;
    private ObjectEncoderOutputStream os;
    private ObjectDecoderInputStream in;


    @Override
    public void setPageName(String pageName) {
        super.setPageName(pageName);
    }

    public AdsScreen(Game game)  {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        try {
            adsSocket = new Socket("192.168.0.101", 8189);
            in = new ObjectDecoderInputStream(adsSocket.getInputStream());
            os = new ObjectEncoderOutputStream(adsSocket.getOutputStream());
            String getAds = new String("/getAds");
            os.writeObject(getAds);
            byte[] bytes = new byte[in.available()];
            bytes = (byte[]) in.readObject();
            System.out.println("Файл прочитан, размер: "+ bytes.length);
            String local = Gdx.files.getLocalStoragePath();
            System.out.println("Local path: " + local);
            handle.writeBytes(bytes, false);
            System.out.println("\n\n_______Уведомления загружены_____\n\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        adsBorderTexture = new Texture("textures/newsBorder.png");
        adsTexture = new Texture("textures/alert.png");
        adsRegion = new TextureRegion(adsTexture);
        adsBorderRegion = new TextureRegion(adsBorderTexture);
        adsBorder = new NewsBorder[count];
        //Fonts
        descriptionFont = new Font[count];//("textNews.fnt", "textNews.png");
        String loadShortcut = handle.readString();
        String[] loadShort = loadShortcut.split("<>");
        for(String i: loadShort){
            list.add(i);
        }
        count = loadShort.length;
        showAds();

        setPageName("Оповещения");


    }

    public void drawAds(){
        for(int i = 0; i <= count-1; i++){
            adsBorder[i].draw(batch);
            ads[i].draw(batch);
            descriptionFont[i].draw(batch, ads[i].getDescription(), ads[i].getRight() + 0.01f, ads[i].getTop() - 0.01f);
        }
    }

    public void showAds(){
        adsBorder = new NewsBorder[count];
        ads = new Ads[count];
        descriptionFont = new Font[count];
        for(int i = 0; i <=count-1; i++){
            adsBorder[i] = new NewsBorder(adsBorderRegion, (i+1));
            ads[i] = new Ads(adsRegion, adsBorder[i], list.get(i));
            System.out.println(list.get(i));
            descriptionFont[i] = new Font("textNews.fnt", "textNews.png");
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        for(int i = 0; i <=count-1; i++){
            adsBorder[i].resize(worldBounds);
            ads[i].resize(worldBounds);
            descriptionFont[i].setSize(0.014f);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        drawAds();
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) throws SQLException, ClassNotFoundException, IOException {
        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
