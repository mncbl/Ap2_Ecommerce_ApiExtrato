package api.ibmec.Ecommerce.config;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CosmosProperties.class)
@EnableCosmosRepositories(basePackages = "api.ibmec.Ecommerce.repository")
public class CosmosConfiguration extends AbstractCosmosConfiguration {
    private final CosmosProperties properties;

    public CosmosConfiguration(CosmosProperties properties) {
        this.properties = properties;
    }

    @Bean
    public CosmosClientBuilder cosmosBuildClient() {
        return new CosmosClientBuilder()
                .endpoint(properties.getUri())
                .key(properties.getKey())
                .directMode(DirectConnectionConfig.getDefaultConfig());
    }

    @Bean
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                .enableQueryMetrics(properties.isQueryMetricsEnabled())
                .build();
    }

    @Override
    protected String getDatabaseName() {
        return properties.getDatabase();
    }
}
