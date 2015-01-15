import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;

public class RenameFile {

	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml"));
		System.out.println(conf.get("fs.defaultFS"));
		
		FileSystem hdfs = FileSystem.get(conf);
		Path frPath = new Path("/user/test");
		Path toPath = new Path("/user/test1");
		
		if(hdfs.exists(toPath)){
			FileStatus fileStatus = hdfs.getFileStatus(toPath);
			//Get the last modification time
			long modificationTime = fileStatus.getModificationTime();
			System.out.println("File exists");
			System.out.println(toPath + "'s modification time is " + modificationTime);
		}
		else{
			if(hdfs.rename(frPath, toPath)){
				System.out.println("File has been renamed.");

			}
			else{
				System.out.println("Renaming File Failed.");
			}	
		}
		

		
		
	}

}
