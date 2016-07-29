package com.hybrid.fx;

import com.gluonhq.particle.application.ParticleApplication;
import com.hybrid.MosaicWeb2Application;

import javafx.application.Platform;
import javafx.scene.Scene;
import static org.controlsfx.control.action.ActionMap.actions;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApplication extends ParticleApplication {

    public MainApplication() {
        super("Gluon Desktop Application");
    }

    @Override
    public void postInit(Scene scene) {
        scene.getStylesheets().add(MainApplication.class.getResource("style.css").toExternalForm());

        setTitle("Gluon Desktop Application");

        getParticle().buildMenu("File -> [exit]", "Help -> [about]");
        
        getParticle().getToolBarActions().addAll(actions("---", "about", "exit"));
        
        setShowCloseConfirmation(false);
        
        Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println("Platform.runLater()...");
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
				
				getPrimaryStage().setOnCloseRequest(event -> {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println("ctx.close()...");
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
					ctx.close();
				});
				
			}
			
		});
    }
    
    public static ConfigurableApplicationContext ctx;
    
    public static void main(String[] args) {
    	 ctx = SpringApplication.run(MosaicWeb2Application.class, args);
    	 launch(args);
    }
    
}