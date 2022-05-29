package io.github.gogozs;

import io.github.gogozs.config.MpCodeGeneratorConfig;
import io.github.gogozs.util.CodeGenerator;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MpCodeGenerator {

    private static final String DEFAULT_PATH = "generator-config.yaml";

    public MpCodeGenerator() {
    }

    public static void main(String[] args) throws Exception {
        InputStream inputStream;
        if (args.length > 0 && !StringUtils.isEmpty(args[0])) {
            inputStream = Files.newInputStream(Paths.get(args[0]));
        } else {
            inputStream = MpCodeGenerator.class.getClassLoader().getResourceAsStream(DEFAULT_PATH);
        }

        MpCodeGeneratorConfig config = yaml2Config(inputStream);
        CodeGenerator.execute(config);
    }

    private static MpCodeGeneratorConfig yaml2Config(InputStream inputStream) {
        Yaml yaml = new Yaml();
        yaml.setBeanAccess(BeanAccess.FIELD);
        return yaml.loadAs(inputStream, MpCodeGeneratorConfig.class);
    }
}
