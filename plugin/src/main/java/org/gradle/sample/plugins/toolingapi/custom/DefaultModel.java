package org.gradle.sample.plugins.toolingapi.custom;

import java.io.Serializable;
import java.util.List;

public class DefaultModel implements Serializable {
    private final List<Class> plugins;
    
    public DefaultModel(List<Class> plugins) {
        this.plugins = plugins;
    }
    
    public boolean hasPlugin(Class type) {
        return plugins.contains(type);
    }
}
