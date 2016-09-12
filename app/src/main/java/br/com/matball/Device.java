package br.com.matball;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGSize;

public class Device {
    public static final float WIDTH = 540f;
    public static final float HEIGHT = 960f;

    public static CGSize getWinSize() {
        return CCDirector.sharedDirector().winSize();
    }

    public static float getScreenWidth() {
        return getWinSize().width;
    }

    public static float getScreenHeight() {
        return getWinSize().height;
    }
}
