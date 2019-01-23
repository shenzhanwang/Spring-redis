package transaction;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * redis����������ִ��һ�������;�������������������
 * ����һ���Է��Ͷ�����Ȼ��ȴ����лظ���������Ϊ��ˮ�ߣ�pipelining��,��
 * ������ͨ�Ŵ��������������
 * @author shenzhanwang
 */
public class TransactionDemo {
	public static void main(String[] args) {
		Jedis conn = new Jedis("192.168.197.128");
        conn.select(15);
        conn.set("tracn", "5");
        // ����watch�����tracn��ֵ�����仯���������ύʧ��
        String watch = conn.watch("tracn");
        // ��������
        Transaction transaction2=conn.multi();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        transaction2.set("tracn","100");
        // �ύ����
        List<Object> list = transaction2.exec();
        System.out.println(list);
        System.out.println(conn.get("tracn"));
	}
}
