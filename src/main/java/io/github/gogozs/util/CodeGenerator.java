package io.github.gogozs.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import io.github.gogozs.config.MpCodeGeneratorConfig;

public class CodeGenerator {
    public static void execute(MpCodeGeneratorConfig config) {
        AutoGenerator g = new AutoGenerator();
        g.setDataSource(config.getDataSourceConfig());
        g.setGlobalConfig(config.getGlobalConfig());
        g.setPackageInfo(config.getPackageConfig());
        g.setTemplate(config.getTemplateConfig());
        g.setStrategy(config.getStrategyConfig());

        if (config.useFreeMarker()) {
            g.setTemplateEngine(new FreemarkerTemplateEngine());
        } else if (config.useBeetl()) {
            g.setTemplateEngine(new BeetlTemplateEngine());
        }
        g.execute();
    }
}
