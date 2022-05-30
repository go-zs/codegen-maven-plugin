package io.github.gogozs.mojo;

import io.github.gogozs.config.MpCodeGeneratorConfig;
import io.github.gogozs.util.CodeGenerator;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@Mojo(name = "generate", defaultPhase = LifecyclePhase.COMPILE)
public class MpCodeGeneratorMojo extends AbstractMojo {

    private static final String DEFAULT_PATH = "generator-config.yaml";

    @Parameter
    private String configurationFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        InputStream inputStream = null;
        if (!StringUtils.isEmpty(configurationFile)) {
            try {
                inputStream = new FileInputStream(configurationFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            inputStream = MpCodeGeneratorMojo.class.getClassLoader().getResourceAsStream(DEFAULT_PATH);
        }

        MpCodeGeneratorConfig config = yaml2Config(inputStream);
        CodeGenerator.execute(config);
    }


    public MpCodeGeneratorConfig yaml2Config(InputStream inputStream) {
        Yaml yaml = new Yaml();
        yaml.setBeanAccess(BeanAccess.FIELD);
        return yaml.loadAs(inputStream, MpCodeGeneratorConfig.class);
    }
}
