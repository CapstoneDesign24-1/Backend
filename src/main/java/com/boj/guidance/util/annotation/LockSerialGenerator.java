package com.boj.guidance.util.annotation;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

import static org.hibernate.generator.EventTypeSets.INSERT_ONLY;

@Slf4j
@Component
@NoArgsConstructor
public class LockSerialGenerator implements BeforeExecutionGenerator {

    @Override
    public EnumSet<EventType> getEventTypes() {
        return INSERT_ONLY;
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue, EventType eventType) {
        CustomIdGeneratorStrategy strategy = new CustomIdGeneratorStrategy();
        return strategy.generateThreadId(session);
    }
}
