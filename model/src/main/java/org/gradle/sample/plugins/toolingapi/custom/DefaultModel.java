package org.gradle.sample.plugins.toolingapi.custom;

import java.io.Serializable;
import java.util.List;

public class DefaultModel implements Serializable {
    private final List<String> pluginClassNames;
    
    public DefaultModel(List<String> pluginClassNames) {
        this.pluginClassNames = pluginClassNames;        
    }
    
    public boolean hasPlugin(Class type) {              
        return pluginClassNames.contains(type.getName());
    }
}
