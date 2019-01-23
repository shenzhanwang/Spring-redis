package data.structure;

import redis.clients.jedis.Jedis;

public class MapDemo {
	public static void main(String[] args) {
		Jedis conn = new Jedis("192.168.197.128");
        conn.select(15);
        // ����һ��hashmap
        conn.hset("hehe", "ww", "asd");
        conn.hset("hehe", "tencent", "liangbo");
        conn.hset("hehe", "baidu", "liyan");
        conn.hset("hehe", "ali", "mayun");
        // ��ȡhashmap
        System.out.println(conn.hget("hehe", "ww"));
        // ��ȡmap�ĳ���
        System.out.println(conn.hlen("hehe"));
        // ɾ��map
        conn.hdel("hehe", "tencent");
        // ����key
        System.out.println(conn.hkeys("hehe"));
        // ����value
        System.out.println(conn.hvals("hehe"));
        // ����map
        System.out.println(conn.hgetAll("hehe"));
	}
}
