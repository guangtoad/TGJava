package com.toad.beyondcompare.helper.tool.bsSprict;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BSCConfig {

    /**
     * 对保存实例的变量添加volatile的修饰
     */

    private volatile static BSCConfig instance = null;

    public class Path{

    }

    public class Setting{

    }

    public class Style{
        /**
         * 样式 .
         */
        public String layout = "side-by-side";
        /**
         * 对比设置.
         */
        public String options = "display-all,line-numbers";
        /**
         * 输出设置.
         */
        public String output_options = "html-color";
        /**
         * 输出路径.
         */
        public String output_to = "";
        /**
         * 左边的.
         */
        public String left = "";
        /**
         * 右边的.
         */
        public String right = "";
        /**
         * 标题？.
         */
        public String title = "";
        

    }

    public Path path ;
    public Style style;
    public Setting setting;


    private BSCConfig(){

    }

    protected void reloadConfig() {
        try {
            // String path = BSCConfig.class.getClassLoader().getResource("config.properties").getPath();
            InputStream in = this.getClass().getResourceAsStream("/config.properties");
            Properties config = new Properties();
            config.load(new FileInputStream("config.properties"));
        }
        catch (IOException exc){
            System.out.println(exc.toString());

        }
        catch (Exception exc){
            System.out.println(exc.toString());
        }
        finally {

        }
    }

    public static BSCConfig getInstance(){
        // 先检查实例是否存在，如果不存在才进入下面的同步块
        if(instance == null){
            //同步块，线程安全的创建实例
            synchronized(BSCConfig.class){
                //再次检查实例是否存在，如果不存在才真的创建实例
                if(instance == null){
                    instance = new BSCConfig();
                    instance.reloadConfig();
                }
            }
        }
        return instance;
    }

    static public void loadConfig(){
        BSCConfig.getInstance().reloadConfig();
    }
}
