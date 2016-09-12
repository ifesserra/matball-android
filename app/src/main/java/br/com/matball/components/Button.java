package br.com.matball.components;

import android.view.MotionEvent;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

public class Button extends CCLayer {
    private CCLabel label;
    private ButtonDelegate delegate;

    public Button(CCLabel label) {
        this.label = label;
        setIsTouchEnabled(true);
        addChild(this.label);
    }

    public void setDelegate(ButtonDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void registerWithTouchDispatcher() {
        CCTouchDispatcher.sharedDispatcher().addTargetedDelegate(this, 0, false);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {
        CGPoint localToque = CCDirector.sharedDirector().convertToGL(
                CGPoint.make(event.getX(), event.getY())
        );

        localToque = this.convertToNodeSpace(localToque);

        // Verifica se a área de tela tocada corresponde a imagem do botão
        if(CGRect.containsPoint(this.label.getBoundingBox(), localToque)){
            this.delegate.buttonClicked(this);
        }

        return true;
    }

    public CCSprite getLabel() {
        return label;
    }
}
