package org.gradle.sample.plugins.toolingapi.custom;

import javax.inject.Inject;
import java.util.List;
import java.util.ArrayList;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.tooling.provider.model.ToolingModelBuilder;
import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;

public class ToolingApiCustomModelPlugin implements Plugin<Project> {
    private final ToolingModelBuilderRegistry registry;
   
    @Inject
    public ToolingApiCustomModelPlugin(ToolingModelBuilderRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void apply(Project project) {
        registry.register(new CustomToolingModelBuilder());
    }

    private static class CustomToolingModelBuilder implements ToolingModelBuilder {
        @Override
        public boolean canBuild(String modelName) {
            return modelName.equals(CustomModel.class.getName());
        }

        @Override
        public Object buildAll(String modelName, Project project) {
            List<String> pluginClassNames = new ArrayList<String>();

            for(Plugin plugin : project.getPlugins()) {
                pluginClassNames.add(plugin.getClass().getName());
            }

            return new DefaultModel(pluginClassNames);
        }
    }
}
