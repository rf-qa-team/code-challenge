package util.redis;

import redis.clients.jedis.Jedis;

/**
 * Jedis client.
 */

public final class JedisClient {
    private JedisClient() {
    }

    public static Jedis jedisClient(String url, Integer port, String user) {
        Jedis jc = new Jedis(url, port);
        jc.auth(user);
        return jc;
    }
}
