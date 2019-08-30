package ind.vijay.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @// TODO: 2019/8/12 计算权限码，包括编码解码的若干方法
 * @author Vijay Wong
 * @datetime 2019年8月12日15:54:32
 */
public class AccessCodeUtils {
    /**
     * 把id列表，使用累加，使其生成符合【加法编码算法】的规则的值
     * @param idList
     * @return
     */
    public static int encodeToCode(List<Integer> idList) {
        int accessCode = 0;
        for (int id:idList) {
            accessCode += id;
        }
        return accessCode;
    }

    /**
     * 根据【加法编码算法】(暂不知这种算法叫乜名)把加法权限码拆分出来，还原成id列表
     * @param accessCode
     * @return
     */
    public static List<Integer> decodeToList(Integer accessCode) {
        ArrayList<Integer> res=new ArrayList<>();//结果
        int tempCode=accessCode;
        while(true)
        {
            int i=1;
            while(true)
            {
                if(i>tempCode)
                {
                    res.add(i/2);
                    tempCode=tempCode-(i/2);
                    break;
                }
                else
                {
                    i*=2;
                }
            }
            if(tempCode==0)
            {
                break;
            }
        }
        return res;
    }
}
