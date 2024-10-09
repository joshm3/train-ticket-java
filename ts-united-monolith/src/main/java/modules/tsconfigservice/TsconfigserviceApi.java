package modules.tsconfigservice;
import modules.tsconfigservice.config.controller.ConfigController;
import modules.tsconfigservice.config.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsconfigserviceApi {
    @Autowired
    ConfigController configController;

    public HttpEntity<?> postApiV1ConfigserviceConfigs(Config info, HttpHeaders headers) {
        return configController.createConfig(info, headers);
    }

    public HttpEntity getApiV1ConfigserviceConfigs(HttpHeaders headers) {
        return configController.queryAll(headers);
    }

    public HttpEntity deleteApiV1ConfigserviceConfigsPathvariable(String configName, HttpHeaders headers) {
        return configController.deleteConfig(configName, headers);
    }

    public HttpEntity putApiV1ConfigserviceConfigs(Config info, HttpHeaders headers) {
        return configController.updateConfig(info, headers);
    }

    public HttpEntity getApiV1ConfigserviceConfigsPathvariable(String configName, HttpHeaders headers) {
        return configController.retrieve(configName, headers);
    }
}