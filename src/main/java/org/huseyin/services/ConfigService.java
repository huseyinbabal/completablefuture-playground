package org.huseyin.services;

import java.util.concurrent.ThreadLocalRandom;

public abstract class ConfigService {

    protected int getByRewardId(int rewardId) {
        int randNum = ThreadLocalRandom.current().nextInt(0, rewardId + 1);
        try {
            Thread.sleep((long) randNum * 1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Random num is " + randNum);
        return randNum;
    }
}
