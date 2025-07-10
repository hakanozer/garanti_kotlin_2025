package com.works.configs

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppBeans {

    @Bean
    fun modelMapper(): ModelMapper {
        val modelMapper = ModelMapper()
        return modelMapper
    }

}