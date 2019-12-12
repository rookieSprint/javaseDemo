package com.dyl.fastDFS;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSTestDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		//加载配置文件/fastDFSdome/src/main/resources/fdfs_client.conf
		//ClientGlobal.init("D:\\javaEE1708\\32heimajava\\15.luncene&solr（77-78天）\\31.品优购电商系统开发\\资源\\配置文件\\fastDFS\\配置文件\\fdfs_client.conf");
		ClientGlobal.init("D:/Users/uu/demoWorkspace/fastDFSdome/src/main/resources/fdfs_client.conf");
		// 2、创建一个 TrackerClient 对象。直接 new 一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个 StorageServer 的引用，值为 null
		StorageServer storageServer = null;
		// 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用 StorageClient 对象上传图片。
		//扩展名不带“.”
		String[] strings = storageClient.upload_file("D:/code/img.png", "png",
			null);
		// 7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}
		
		FastDFSClient fastDFSClient = new FastDFSClient("classpath:fdfs_client.conf");
		String strpath = fastDFSClient.uploadFile("D:/code/img.png");
		System.out.println(strpath);
		
		String string="abd";
		System.out.println(string.contains("n"));
		fast fast1= new fast();
		
	}
}

class fast{
	public fast() {
		//获取绝对路径
		System.out.println(this.getClass().getResource("/").getPath());
	}
}

