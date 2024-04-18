package com.service.WasteManagerService.Config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WasteManagerConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper model = new ModelMapper();
    model.getConfiguration().setDeepCopyEnabled(true);
    model.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    return model;
  }
}
