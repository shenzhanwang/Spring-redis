package data.structure;

import redis.clients.jedis.Jedis;

public class SortedSetDemo {
	public static void main(String[] args) {
		Jedis conn = new Jedis("192.168.197.128");
        conn.select(15);
        // ����һ�����򼯺�
        conn.zadd("sets",3 , "a");
        conn.zadd("sets",4 , "b");
        conn.zadd("sets",5 , "c");
        // ͳ�Ƹ���
        System.out.println(conn.zcard("sets"));
        // ��ĳ��Ԫ�ؼӷ�
        System.out.println(conn.zincrby("sets", 10, "a"));
        // ��ȡ��ֵ
        System.out.println(conn.zscore("sets", "a"));
        // ��ȡԪ������,��С��������0��ʼ
        System.out.println(conn.zrank("sets", "a"));
        // ͳ�Ƹ�������ķ�ֵ��Ŀ
        System.out.println(conn.zcount("sets", 4, 11));
        // �Ƴ�ĳ��Ԫ��
        conn.zrem("sets", "a");
        // �������򼯺�
        System.out.println(conn.zrange("sets", 0, -1));
	}
}
