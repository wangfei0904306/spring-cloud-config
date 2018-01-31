package com.iciyun.adi.microframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ConfigApplication {
    private static String userDir = System.getProperty("user.dir") ;
    private static String classesDir = userDir + "/target/classes";
    private static String configRepoDir = userDir.replace("convert-config", "config-repo");

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

    public static void convertFiles()
    {
        File classesDirFile = new File(classesDir);
        if(!classesDirFile.exists()) {
            System.out.println("找不到这个文件夹");
            return;
        }
        File configRepoDirFile = new File(configRepoDir);
        if(configRepoDirFile.exists()) {
            deleteFile(configRepoDirFile);
        }
        configRepoDirFile.mkdirs();

        if(!classesDirFile.isDirectory()) {
            System.out.println("不是文件夹？");
            return;
        }
        File[] list = classesDirFile.listFiles();
        if(null == list) {
            System.out.println("classes目录下没有文件");
            return;
        }
        // 如果目录下文件存在
        for (File file : list)
        {
            if(!file.isDirectory()) {
                continue; //略过文件
            }
            String dirName = file.getName();
            if("com".equalsIgnoreCase(dirName)){
                System.out.println("跳过包文件");
                continue;
            }
            if(null == file.listFiles()){
                System.out.println(dirName + "下没有文件");
                continue;
            }
            for(File configFile : file.listFiles()){
                String serviceName = dirName + "-service";
                String destName = configFile.getName().replace("application", serviceName);
                File dest = new File(configRepoDir + "/" + destName);
                configFile.renameTo(dest);
            }
        }
    }

    //递归删除文件夹
    private static void deleteFile(File file) {
        if (file.exists()) {//判断文件是否存在
            if (file.isFile()) {//判断是否是文件
                file.delete();//删除文件
            } else if (file.isDirectory()) {//否则如果它是一个目录
                File[] files = file.listFiles();//声明目录下所有的文件 files[];
                for (int i = 0;i < files.length;i ++) {//遍历目录下所有的文件
                    deleteFile(files[i]);//把每个文件用这个方法进行迭代
                }
                file.delete();//删除文件夹
            }
        } else {
            System.out.println("所删除的文件不存在");
        }
    }

}
