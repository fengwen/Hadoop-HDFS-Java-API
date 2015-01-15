import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

public class GetDatanodeInfo {
	
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml"));
		FileSystem fs = FileSystem.get(conf);
		
		//always check the file system
		System.out.println(conf.get("fs.defaultFS"));
		
		DistributedFileSystem hdfs = (DistributedFileSystem)fs;
		DatanodeInfo[] dataNodeStats = hdfs.getDataNodeStats();
		String[] names = new String[dataNodeStats.length];
		
		for(int i = 0; i < dataNodeStats.length; i++){
			names[i] = dataNodeStats[i].getHostName();
			System.out.println("Node " + i + " Name " + names[i]);
		}
		
	}

}
