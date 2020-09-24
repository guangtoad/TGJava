package com.toad.beyondcompare.helper.tool;

import com.toad.java.utils.TGStringUtils;

public class BSCTool {

    public String leftPath = null;
    public String rightPath = null;
    public String outPath = null;

    public boolean createDirSprict() throws BSCException{
        return createDirSprict(this.leftPath, this.rightPath, this.outPath);
    }

    public boolean createDirSprict(String leftPath, String rightPath, String outPath) throws BSCException{
        boolean restult = false;
        if (TGStringUtils.isNullOrEmpty(leftPath)){
            restult = false;
            throw new BSCException(String.format("左边路径不对：%s", leftPath));
        }
        if (TGStringUtils.isNullOrEmpty(rightPath)){
            restult = false;
            throw new BSCException(String.format("右边路径不对：%s", leftPath));
        }
        if (TGStringUtils.isNullOrEmpty(rightPath)){
            restult = false;
            throw new BSCException(String.format("输出路径不对：%s", leftPath));
        }
        return restult;
    }

    public boolean createFileSprict(String dirdiffPath, String outPath) throws BSCException{
        boolean restult = false;
        return restult;
    }

    public boolean createFilesSprict(String dirdiffPath, String outPath) throws BSCException{
        boolean restult = false;
        return restult;
    }
}
