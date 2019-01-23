package data.structure;

import redis.clients.jedis.Jedis;

/**
 * ��ʾredis��string���͵Ĳ���
 * @author shenzhanwang
 *
 */
public class Stringdemo {
	public static void main(String[] args) {
		Jedis conn = new Jedis("192.168.197.128");
        conn.select(15);
        
        conn.set("wsz", "5");
        System.out.println(conn.get("wsz"));
        // ����
        conn.incr("wsz");
        System.out.println(conn.get("wsz"));
        // �Լ�
        conn.decr("wsz");
        System.out.println(conn.get("wsz"));
        // ׷��
        conn.append("wsz", "asddasfsad");
        System.out.println(conn.get("wsz"));
        // ���Ӵ�
        System.out.println(conn.substr("wsz",0,2));
        // ��Χ����
        conn.setrange("wsz", 2, "nihao");
        System.out.println(conn.get("wsz"));
        
        // ��ʾ����ʱ��ʹ��,10�����
        conn.expire("wsz", 10);
        // ���key��ʣ��ʱ��
        System.out.println(conn.ttl("wsz"));
	}
}
