package io.github.gogozs.config;

import com.baomidou.mybatisplus.generator.config.*;
import lombok.Data;

@Data
public class MpCodeGeneratorConfig {

    private GlobalConfig globalConfig;
    private DataSourceConfig dataSourceConfig;
    private PackageConfig packageConfig;
    private StrategyConfig strategyConfig;
    private TemplateConfig templateConfig;
    private Template templateEngine;

    public Boolean useFreeMarker() {
        return templateEngine == Template.FREEMARKER;
    }

    public Boolean useBeetl() {
        return templateEngine == Template.BEETL;
    }

    public enum Template
    {
        FREEMARKER, BEETL, VELOCITY;
    }
}
