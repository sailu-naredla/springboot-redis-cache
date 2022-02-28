package com.redis.cache;

import java.io.Serializable;

public interface Cacheable extends Serializable {

    public String getCacheKey();

    public String getObjectKey();

}
