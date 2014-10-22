package org.gradle.sample.plugins.toolingapi.custom;

import java.util.List;
import org.gradle.tooling.model.Model;

public interface CustomModel extends Model {
    boolean hasPlugin(Class type);
}
