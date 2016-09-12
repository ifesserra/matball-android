package br.com.matball;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import br.com.matball.scenes.SplashScreen;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define Layout portrait (Em pé)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Define a Activity como Full Screen sem título
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Configura um surface view na activity
        CCGLSurfaceView surfaceView = new CCGLSurfaceView(this);
        setContentView(surfaceView);
        CCDirector.sharedDirector().attachInView(surfaceView);

        // Configura a resolução da tela por meio do Director do Cocos2D
        CCDirector.sharedDirector().setScreenSize(Device.WIDTH, Device.HEIGHT);

        // Inicia a carga dos recursos da aplicação
        ResourcesPreload.start();

        // Carrega a Cena da Home com o menu
        CCScene scene = new SplashScreen().scene();
        CCDirector.sharedDirector().runWithScene(scene);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SplashScreen.stop();
        //HomeScreen.stop();
        //GameScreen.stop();
    }
}
