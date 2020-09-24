package com.toad.beyondcompare.helper.tool;

import com.toad.java.utils.TGFileUtils;
import com.toad.java.utils.TGStringUtils;

import java.io.IOException;

public class BSCMenu {
    public void consloeInput(byte input[]) throws IOException {
        System.in.read(input);
    }

    public void consloeOutln(){
        System.out.println();
    }
    public void consloeOut(String msg){
        System.out.println(msg);
    }

    /**
     * 按行读取输入流第一行文字.
     *
     * @param disp    要显示的文字
     * @param maxByte 缓冲区大小：128～4096
     * @return 用户数据
     * @throws Exception 不应定啥异常
     */
    public String readLine(String disp,int maxByte) throws Exception {

        try {
            consloeOut(disp);
            byte[] input = new byte[Math.min(Math.max(128, maxByte), 4096)];
            consloeOutln();
            consloeInput(input);
            String s = new String(input);
            String[] sa = s.split("\n");
            if (sa.length > 0) {
                return  sa[0];
            }
        }
        catch (Exception exc) {
            throw exc;
        }
        return null;
    }
    /**
     * 按行读取输入流第一行文字.
     * 缓冲区默认大小2048
     * @param disp    要显示的文字
     * @return 用户数据
     * @throws Exception 不应定啥异常
     */
    public String readLine(String disp) throws Exception{
        return readLine(disp,2048);
    }
    public boolean diffDir(String leftPath, String rightPath, String outPath) throws BSCException,Exception{
        boolean result = false;
        try {
            consloeOut(String.format("左边：%s",leftPath));
            consloeOut(String.format("右边：%s",rightPath));
            consloeOut(String.format("输出路径：%s",rightPath));
            String s = readLine(String.format("\n%s确认其他返回:输入:",BSCConfig.ENTER_OK));
            if (BSCConfig.ENTER_OK.equals(s)){
//bsct.out;
//                        bsct.left = left;
//                        bsct.right = right;
//                        bsct.out = out;
//                        bsct.diffDir();
                result = true;
            }
            else {
                result =  false;
            }
        }
        catch (Exception exc){
            throw exc;
        }
        return result;
    }
    public void diffDirMenu(){

        int step = 0;
        BSCTool bsct = new BSCTool();
        String left = "";
        String right = "";
        String out = "";
        while (true) {
            try {
                switch (step){
                    case 0:{
                        String s = readLine("\n左边的用啥:输入:");
                        if (TGStringUtils.isNullOrEmpty(s)) {
                            throw new BSCException("输入的啥呀");
                        }
                        if (!TGFileUtils.isExistDirectory(s)) {
                            throw new BSCException("路径不对");
                        }
                        left = s.trim();
                    }
                    break;
                    case 1:{
                        String s = readLine("\n右边的用啥:输入:");
                        if (TGStringUtils.isNullOrEmpty(s)) {
                            throw new BSCException("输入的啥呀");
                        }
                        if (!TGFileUtils.isExistDirectory(s)) {
                            throw new BSCException("路径不对");
                        }
                        right = s.trim();
                    }
                    break;
                    case 2:{
                        String s = readLine("\n输出到哪这个可以不输:");
                        if (!TGStringUtils.isNullOrEmpty(s)) {
                            if (!TGFileUtils.isExistDirectory(s)) {
                                throw new BSCException("输入就给正确路径");
                            }
                            out = s.trim();
                        }
                        break;
                    }
                    case 3:{
                        String s = readLine("\n左边的用:" + left + "\n右边的用：" + right + "\n临时文件报告啥的输出到:" + out + "\n随便输入点啥继续");
                        if (diffDir(left, right, out)) {
                            return;
                        }
                        step = 0;
                        break;
                    }
                    default:{
                        System.out.println("不知道你干啥了");
                        return;
                    }
                }
                step++;
            }
            catch (BSCException exc){
                System.out.println(exc.getMessage());
            }
            catch (Exception exc) {

            }
        }
    }
    public void diffFilesMenu(){

    }
    public void show(){
        int step = 0;
        while (true) {
            try {
                switch (step) {
                    case 0:
                        String s = readLine("\n干嘛？\n1.创建文件加比较\n2.创建文件比较列表\n输入:");
                        if (!TGStringUtils.isNullOrEmpty(s ))                             {
                            int i = Integer.parseInt(s);
                            switch (i) {
                                case 1:
                                    diffDirMenu();
                                    break;
                                case 2:
                                    diffFilesMenu();
                                    break;
                            }
                        }
                        break;
                    default:
                        System.out.println("\n拜拜。。、\n");
                        break;
                }
            }
            catch (NumberFormatException exc){
                System.out.println("输入错误");
            }
            catch (Exception exc){

            }
        }
    }
    static public void showMenu(){
        new BSCMenu().show();
    }
}
