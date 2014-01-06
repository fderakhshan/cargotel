package com.radiofield.services.drools.configurations;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.yammer.dropwizard.config.Configuration;
import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration  implements AssetsBundleConfiguration{
    @NotEmpty
        @JsonProperty
            private String template;

    @NotEmpty
        @JsonProperty
            private String defaultName = "Stranger";

    public String getTemplate() {
            return template;
        }

    public String getDefaultName() {
            return defaultName;
        }
    
    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    public AssetsConfiguration getAssetsConfiguration() {
      return assets;
    }
}
