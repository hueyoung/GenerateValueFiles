package com.ytl.myapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Author: HueYoung
 * E-mail: yangtaolue@xuechengjf.com
 * Date: 2017/8/22.
 * <p/>
 * Description : 生成65k方法测试类
 */
public class GenerateValueFiles {
    /** 存放路径 */
    private String dirStr = "./res";
    /** 多少个函数 */
    private final int mothods = 66000;
    /** 切割成多少个文件 */
    private String[] fileName = new String[]{  "Mothod_65k_1.java"
                                                ,"Mothod_65k_2.java"
                                                ,"Mothod_65k_3.java"
                                                ,"Mothod_65k_4.java"
                                                ,"Mothod_65k_5.java"
                                                ,"Mothod_65k_6.java" };

    public GenerateValueFiles() {
        File dir = new File(dirStr);
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println(dir.getAbsoluteFile());
    }

    private void generateJavaFile() {
        int times = fileName.length;
        while(--times >= 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("public class " + fileName[times].replace(".java", "") + " {\n");
            for (int i = 0; i < mothods / fileName.length; i++) {
                sb.append("  public void test" + i + "() {\n");
                sb.append("    System.out.println(\"\");\n");
                sb.append("  }\n");
            }
            sb.append("}\n");
            File fileDir = new File(dirStr + File.separator);
            fileDir.mkdir();
            File file = new File(fileDir.getAbsolutePath(), fileName[times]);
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(file));
                pw.print(sb.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new  GenerateValueFiles().generateJavaFile();
    }
}