package com.boj.guidance.domain.base;

import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.IdGeneratorException;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class IdGenerator implements IdentifierGenerator, Configurable {

    private final RedissonClient redissonClient;

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        final String lockName = "IDLock";
        final RLock lock = redissonClient.getLock(lockName);
        final String uuid;

        try {
            if (!lock.tryLock(1, 3, TimeUnit.SECONDS)) {
                return null;
            }
            uuid = UUID.randomUUID().toString();
        } catch (InterruptedException e) {
            throw new IdGeneratorException(ResponseCode.REDIS_LOCK_FAIL);
        } finally {
            if (lock != null && lock.isLocked()) {
                lock.unlock();
            }
        }

        return uuid;
    }
}
