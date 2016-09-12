package br.com.matball.multimedia;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCSpriteFrameCache;

public class Sprites {
    public static void load(){
        String []paths = {
                "img/logotipo.png",
                "img/background.png"
        };

        for (String p: paths) {
            String []splits = p.split("/");
            String name = splits[splits.length - 1];
            name = name.split("\\.")[0];
            CCSpriteFrameCache.sharedSpriteFrameCache().addSpriteFrame(
                    CCSprite.sprite(p).displayedFrame(), name
            );
        }
    }

    public static CCSpriteFrame getSpriteFrameByName(String name){
        return CCSpriteFrameCache.sharedSpriteFrameCache().getSpriteFrame(name);
    }

    public static CCSprite getByName(String name){
        return CCSprite.sprite(getSpriteFrameByName(name));
    }

}
