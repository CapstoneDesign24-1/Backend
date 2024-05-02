package com.boj.guidance.util.annotation;

import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.IdGeneratorException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Component
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class CustomIdGeneratorStrategy {

    private final RedissonClient redissonClient;
    private static final ThreadLocal<Lock> localLock = ThreadLocal.withInitial(ReentrantLock::new);

    public String generateRedisId(SharedSessionContractImplementor session) {

        final RLock lock;
        final String uuid;

        String lockKey = "IdGenerator";
        lock = redissonClient.getLock(lockKey);

        try {
            if (!lock.tryLock(1, 3, TimeUnit.SECONDS)) {
                return null;
            }
            log.info("Redis LOCKED");
            uuid = UUID.randomUUID().toString();
        } catch (InterruptedException e) {
            throw new IdGeneratorException(ResponseCode.REDIS_LOCK_FAIL);
        } finally {
            if (lock != null && lock.isLocked()) {
                lock.unlock();
                log.info("Redis UNLOCKED");
            }
        }

        return uuid;
    }

    public String generateThreadId(SharedSessionContractImplementor session) {
        String uuid;

        Lock lock = localLock.get();
        lock.lock();
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
//                    log.info("Thread LOCKED");
                    uuid = UUID.randomUUID().toString();
                } finally {
                    lock.unlock();
//                    log.info("Thread UNLOCKED");
                }
            } else {
                throw new IdGeneratorException(ResponseCode.REDIS_LOCK_FAIL);
            }
        } catch (InterruptedException e) {
            throw new IdGeneratorException(ResponseCode.REDIS_LOCK_FAIL);
        }

        return uuid;
    }
}
