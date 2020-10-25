package com.mygdx.game.Ads;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygdx.game.Base.Font;
import com.mygdx.game.Base.StartScreen;
import com.mygdx.game.math.Rect;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private AdsBorder[] adsBorder;
    private Ads[] ads;
    private Font[] descriptionFont;
    private Font[] titleFont;
    private int count;
    //
    private static FileHandle handle = Gdx.files.local("/ads.txt");
    private ArrayList<String> list = new ArrayList<>();
    private Socket adsSocket;
    private ObjectEncoderOutputStream os;
    private ObjectDecoderInputStream in;
    //
    private List<AdsServer> listAds;



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
            adsSocket = new Socket("192.168.0.100", 8189);
            in = new ObjectDecoderInputStream(adsSocket.getInputStream());
            os = new ObjectEncoderOutputStream(adsSocket.getOutputStream());
            String getAds = new String("/getAds");
            os.writeObject(getAds);
            String result = (String) in.readObject();
            handle.writeBytes(result.getBytes(), false);
            System.out.println("\n\n_______Объявления загружены_____\n\n");
            ObjectMapper mapper = new ObjectMapper();
            listAds = mapper.readValue(result, new TypeReference<List<AdsServer>>(){});
            System.out.println(listAds.get(0).getDescription());
            System.out.println("\n\n_______Уведомления загружены_____\n\n");
        } catch (IOException | ClassNotFoundException e) {
            String probka = "В Алексеевке разлилась речка какашек! Алерт!\n" +
                    "<>Сегодня будут проходить слушания на тему \"Запах родины моей\". Адрес: Площадь Ленина 1а\n" +
                    "<>С 12 по 14 сентября вода по ул.Маяковского может быть окрашена в коричневый цвет. Проводятся работы против ржавчины";
            handle.writeString(probka, false);
        }
        adsBorderTexture = new Texture("textures/adsBorder.png");
        adsTexture = new Texture("textures/alert.png");
        adsRegion = new TextureRegion(adsTexture);
        adsBorderRegion = new TextureRegion(adsBorderTexture);
        adsBorder = new AdsBorder[count];
        //Fonts
        descriptionFont = new Font[count];
        titleFont = new Font[count];
        count = listAds.size();
        showAds();

        setPageName("Оповещения");


    }

    public void drawAds(){
        for(int i = 0; i <= count-1; i++){
            adsBorder[i].draw(batch);
            ads[i].draw(batch);
            descriptionFont[i].draw(batch, ads[i].getDescription(), ads[i].getRight() + 0.01f, ads[i].getTop() - 0.02f);
            titleFont[i].draw(batch, "Администрация", ads[i].getRight() + 0.03f, adsBorder[i].getTop()- 0.005f);
        }
    }

    public void showAds(){
        adsBorder = new AdsBorder[count];
        ads = new Ads[count];
        descriptionFont = new Font[count];
        titleFont = new Font[count];
        for(int i = 0; i <=count-1; i++){
            adsBorder[i] = new AdsBorder(adsBorderRegion, (i+1));
            ads[i] = new Ads(adsRegion, adsBorder[i], listAds.get(i).getDescription());
            descriptionFont[i] = new Font("textNews.fnt", "textNews.png");
            titleFont[i] = new Font("adsTitle.fnt", "adsTitle.png");
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        for(int i = 0; i <=count-1; i++){
            adsBorder[i].resize(worldBounds);
            ads[i].resize(worldBounds);
            descriptionFont[i].setSize(0.014f);
            titleFont[i].setSize(0.015f);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        drawAds();
        batch.end();
        drawTopMenu();
        drawBottomMenu();
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
