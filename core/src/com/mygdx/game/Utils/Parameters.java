package com.mygdx.game.Utils;

import java.net.Socket;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

public abstract class Parameters {

    public static Socket socket;
    public static ObjectDecoderInputStream is;
    public static ObjectEncoderOutputStream os;

}
