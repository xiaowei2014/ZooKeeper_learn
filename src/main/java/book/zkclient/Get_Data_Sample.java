package book.zkclient;

import com.github.zkclient.IZkDataListener;
import com.github.zkclient.ZkClient;

//ZkClient获取节点数据
public class Get_Data_Sample {
    public static void main(String[] args) throws Exception {
    	
    	String path = "/zk-book";
        ZkClient zkClient = new ZkClient("domain1.book.zookeeper:2181", 5000);
        zkClient.createEphemeral(path, "123".getBytes());
        
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            public void handleDataChange(String dataPath, byte[] bytes) throws Exception {
                System.out.println("Node " + dataPath + " changed, new data: " + bytes);
            }

            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("Node " + dataPath + " deleted.");
            }

        });
        
        System.out.println(zkClient.readData(path));
        zkClient.writeData(path,"456".getBytes());
        Thread.sleep(1000);
        zkClient.delete(path);
        Thread.sleep( Integer.MAX_VALUE );
    }
}