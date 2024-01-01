package com.anilerc.publication.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfig {

    // Log configuration for the circuit breaker
    // When it changes state (i.e, OPEN - HALF OPEN - CLOSED); we will see the logs
    @Bean
    public RegistryEventConsumer<CircuitBreaker> getLog() {
        return new RegistryEventConsumer<CircuitBreaker>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                entryAddedEvent
                        .getAddedEntry()
                        .getEventPublisher()
                        .onStateTransition(System.out::println);
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {

            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

            }
        };
    }

}
