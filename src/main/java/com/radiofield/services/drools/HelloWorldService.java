package com.radiofield.services.drools;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.radiofield.services.drools.configurations.HelloWorldConfiguration;
import com.radiofield.services.drools.resources.HelloWorldResource;
import com.yammer.dropwizard.Bundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.setName("drools");
        //bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/dashboard/"));
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
            Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
    }

}
