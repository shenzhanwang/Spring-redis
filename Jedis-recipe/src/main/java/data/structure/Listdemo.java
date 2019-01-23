package data.structure;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

/**
 * ��ʾjedis�����б����ݽṹ�Ĳ���
 * @author shenzhanwang
 *
 */
public class Listdemo {
	public static void main(String[] args) {
		Jedis conn = new Jedis("192.168.197.128");
        conn.select(15);
        // ���б�β��׷��Ԫ��
        conn.rpush("bbq", "qq");
        conn.rpush("bbq", "sad");
        conn.rpush("bbq", "dsf");
        conn.rpush("bbq", "rf");
        conn.rpush("bbq", "vf");
        conn.rpush("bbq", "asdas");
        // ���б�ͷ��׷��Ԫ��
        conn.lpush("bbq", "dy");
        // չʾ�����б�
        System.out.println(conn.lrange("bbq", 0, -1));
        // ɾ��ͷ��Ԫ��
        conn.lpop("bbq");
        // ɾ��β��Ԫ��
        conn.rpop("bbq");
        System.out.println(conn.lrange("bbq", 0, -1));
        // ʹ��sort���ֵ�˳���������
        SortingParams sortingParameters = new SortingParams();
        sortingParameters.alpha();
        System.out.println(conn.sort("bbq",sortingParameters));
	}
}
