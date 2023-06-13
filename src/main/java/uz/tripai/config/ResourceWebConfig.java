package uz.tripai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceWebConfig implements WebMvcConfigurer {

    private final String uploadsFolder;

    public ResourceWebConfig(@Value("${uploads.folder}") String uploadsFolder) {
        this.uploadsFolder = uploadsFolder;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(String.format("file://%s", uploadsFolder));
    }
}
