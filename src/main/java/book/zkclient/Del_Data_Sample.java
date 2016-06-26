package book.zkclient;


import com.github.zkclient.ZkClient;

//ZkClient删除节点数据
public class Del_Data_Sample {
	public static void main(String[] args) throws Exception {
		String path = "/zk-book";
    	ZkClient zkClient = new ZkClient("domain1.book.zookeeper:2181", 2000);
        zkClient.createPersistent(path, "".getBytes());
        zkClient.createPersistent(path+"/c1", "".getBytes());
        zkClient.deleteRecursive(path);
    }
}