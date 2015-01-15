import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.BlockLocation;

public class GetFileLocation {

	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml"));
		FileSystem hdfs = FileSystem.get(conf);
		
		//always check the file system
		System.out.println(conf.get("fs.defaultFS"));
		
		Path fpath = new Path("/user/kouchikarabun/in/tidyData.txt");
		FileStatus fileStatus = hdfs.getFileStatus(fpath);
		
		BlockLocation[] blockLocation = hdfs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
		
		int blockLen = blockLocation.length;
		for (int i=0; i<blockLen; i++){
			String[] hosts = blockLocation[i].getHosts();
			System.out.println("Block: " +i + " Location: "+ hosts[i]);
		}
	}

}