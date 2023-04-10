package run.halo.live2d.openai;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import run.halo.live2d.Live2dSetting;
import run.halo.live2d.openai.service.OpenAiService;
import run.halo.live2d.openai.service.impl.OpenAIServiceImpl;

@Component
public class OpenAiConfiguration  {

    private final Live2dSetting live2dSetting;

    public OpenAiConfiguration(Live2dSetting live2dSetting) {
        this.live2dSetting = live2dSetting;
    }
    
    @Lazy
    @Bean
    @ConditionalOnMissingBean
    public OpenAiService openAiService() {
        return new OpenAIServiceImpl(live2dSetting.getGroup("openai"));
    }
}
