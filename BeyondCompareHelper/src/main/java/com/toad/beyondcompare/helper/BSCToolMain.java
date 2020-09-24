/*
 * *
 * @Description $description$
 * @Param $params$
 * @Return $returns$
 * @Author Mr.Ren
 * @Date $date$
 * @Time $time$
 * /
 */

package com.toad.beyondcompare.helper;
import com.toad.beyondcompare.helper.tool.BSCConfig;
import com.toad.beyondcompare.helper.tool.BSCMenu;

/**
 * The type Bsc tool.
 */
public class BSCToolMain {
    public static void run(String[] args) throws Exception{
        try {

        }
        catch (Exception exc){
            throw exc;
        }
        finally {
        }
    }

    public static void runConsloe() throws Exception{
        BSCMenu.showMenu();
    }

    public static void main(String[] args) {
        try {
            BSCConfig config = BSCConfig.getInstance();
            if (args.length > 0){
                run(args);
            }
            else {
                runConsloe();
            }
        }
        catch (Exception exc){

        }

    }
}