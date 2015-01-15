import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

public class CreateFile {

	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml"));
		FileSystem hdfs = FileSystem.get(conf);
		
		//always check the file system
		System.out.println(conf.get("fs.defaultFS"));
		
		FileStatus files[] = hdfs.listStatus(new Path("/"));
		for (FileStatus file:files){
			System.out.println(file.getPath());
		}
		
		
		byte[] buff = "Hello World!".getBytes();
		Path dfs = new Path("/user/test");
		FSDataOutputStream outputStream = hdfs.create(dfs);
		outputStream.write(buff, 0, buff.length);

	}

}
