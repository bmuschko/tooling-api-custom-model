package org.gradle.sample.toolingapi;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.ModelBuilder;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.sample.plugins.toolingapi.custom.CustomModel;

import java.io.File;

public class ToolingApiRunner {
    public static void main(String[] args) {
        GradleConnector connector = GradleConnector.newConnector();
        connector.forProjectDirectory(new File("../sample"));
        ProjectConnection connection = null;
        
        try {
            connection = connector.connect();
            ModelBuilder<CustomModel> customModelBuilder = connection.model(CustomModel.class);
            customModelBuilder.withArguments("--init-script", "init.gradle"); 
            CustomModel model = customModelBuilder.get();        
            assert model.hasPlugin(JavaPlugin.class);
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
}