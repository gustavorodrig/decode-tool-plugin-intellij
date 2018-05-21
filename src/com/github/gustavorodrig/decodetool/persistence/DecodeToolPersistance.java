package com.github.gustavorodrig.decodetool.persistence;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
    name = "DecodeToolPersistance",
    storages = {
    @Storage("DecodeToolPersistance.xml")}
)
public class DecodeToolPersistance implements PersistentStateComponent<DecodeToolPersistance> {

    private String url;
    private String defaultMethod;

    @Nullable
    @Override
    public DecodeToolPersistance getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull DecodeToolPersistance decodeToolPersistance) {
        XmlSerializerUtil.copyBean(decodeToolPersistance, this);
    }

    @Nullable
    public static DecodeToolPersistance getInstance() {
        return ServiceManager.getService(DecodeToolPersistance.class);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDefaultMethod() {
        return defaultMethod;
    }

    public void setDefaultMethod(String defaultMethod) {
        this.defaultMethod = defaultMethod;
    }
}
