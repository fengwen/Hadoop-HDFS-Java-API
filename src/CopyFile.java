import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class CopyFile {

	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		FileSystem localsys = FileSystem.get(conf);
		System.out.println("This is the local file system " + conf.get("fs.defaultFS"));
		
		Path src = new Path("/Users/kouchikarabun/Desktop/GettingandCleaningData/CourseProject/tidyData.txt");
		FileStatus files1[] = localsys.listStatus(src);
		for (FileStatus file:files1){
			System.out.println("The file to upload");
			System.out.println(file.getPath());
		}
		
		
		conf.addResource(new Path("/usr/local/Cellar/hadoop/2.6.0/libexec/etc/hadoop/core-site.xml"));
		
		System.out.println("Upload to " + conf.get("fs.defaultFS"));
		
		FileSystem hdfs = FileSystem.get(conf);
		
		Path dst = new Path("/user/kouchikarabun/in");
		
		FileStatus files[] = hdfs.listStatus(dst);
		System.out.println("Before Uploading");
		for (FileStatus file:files){
			System.out.println(file.getPath());
		}
		
		hdfs.copyFromLocalFile(src, dst);
		System.out.println("After Uploading");
		for (FileStatus file:files){
			System.out.println(file.getPath());
		}
	

	}

}
