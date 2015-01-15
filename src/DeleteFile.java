import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class DeleteFile {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml"));
		System.out.println(conf.get("fs.defaultFS"));
		
		Path deletePath = new Path("/user/test1");
		
		FileSystem hdfs = FileSystem.get(conf);
		
		if(hdfs.exists(deletePath)){
			System.out.println("File Exists");
		}
		else{
			System.out.println("No File Found");
		}
		
		if(hdfs.delete(deletePath, false)){
			System.out.println("File Deleted");
		}
		else{
			System.out.println("Deleting File Failed");
		}
		
		if(hdfs.exists(deletePath)){
			System.out.println("File Exists");
		}
		else{
			System.out.println("No File Found");
		}
		
	}

}
