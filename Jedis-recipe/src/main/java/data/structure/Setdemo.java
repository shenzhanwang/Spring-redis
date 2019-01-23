package data.structure;

import redis.clients.jedis.Jedis;

/**
 * ����set�Ĳ�����ʾ
 * @author shenzhanwang
 *
 */
public class Setdemo {
	public static void main(String[] args) {
		Jedis conn = new Jedis("192.168.197.128");
        conn.select(15);
        // ����һ������
        conn.sadd("xiaomi", "leijun","liuqi","xiaobai");
        // �Ƴ�����Ԫ��
        conn.srem("xiaomi", "leijun");
        // ��������Ԫ��
        System.out.println(conn.smembers("xiaomi"));
        
        conn.sadd("baidu", "liyanhong","zhangge","liuqi");
        // ���ز
        System.out.println(conn.sdiff("xiaomi", "baidu"));
        // ���ؽ���
        System.out.println(conn.sinter("xiaomi", "baidu"));
        // ���ز���
        System.out.println(conn.sunion("xiaomi", "baidu"));
	}
}
