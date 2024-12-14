package com.green.userservice.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class MyMeterBinderConfigutraion {

    @Bean
    public MeterBinder queueSize(Queue queue){
        return registry -> Gauge.builder("queueSize",queue::size).register(registry);
    }

    @Bean
    public MeterBinder myStockMeterBinder(MyStockManager myStockManager) {
        return new MeterBinder() {
            @Override
            public void bindTo(MeterRegistry registry) {
                Gauge.builder("myStockCount", myStockManager, value -> {
                    return value.getStock();
                }).register(registry);
            }
        };
    }

}
