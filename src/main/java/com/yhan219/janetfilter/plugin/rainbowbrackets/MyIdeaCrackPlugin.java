package com.yhan219.janetfilter.plugin.rainbowbrackets;

import com.janetfilter.core.Environment;
import com.janetfilter.core.plugin.MyTransformer;
import com.janetfilter.core.plugin.PluginConfig;
import com.janetfilter.core.plugin.PluginEntry;

import java.util.ArrayList;
import java.util.List;

public class MyIdeaCrackPlugin implements PluginEntry {

    private final List<MyTransformer> transformers = new ArrayList<>();

    @Override
    public void init(Environment environment, PluginConfig config) {
        transformers.add(new RainbowBracketsTransformer());
        transformers.add(new RequestFastTransformer());
    }

    @Override
    public String getName() {
        return "MyIdeaCrackPlugin";
    }

    @Override
    public String getAuthor() {
        return "https://github.com/yhan219";
    }

    @Override
    public String getVersion() {
        return "v1.0.0";
    }

    @Override
    public List<MyTransformer> getTransformers() {
        return transformers;
    }
}
