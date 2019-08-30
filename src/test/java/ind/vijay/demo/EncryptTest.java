package ind.vijay.demo;

import ind.vijay.demo.util.MyEncryptPasswordEncoder;

public class EncryptTest {

    /**
     * 密码测试，也可用作生成密码
     * @param args
     */
    public static void main(String[] args) {
        MyEncryptPasswordEncoder encoder = new MyEncryptPasswordEncoder();

        String anonPassword = "123456";     //需要加密的密码

        String encryptedStr = encoder.encode(anonPassword);     //存数据库的最新密码

        System.out.println("encrypted： " + encryptedStr);

        String anonPassword2 = "123456";        //前端密码原件

        System.out.println("matched? : " + encoder.matches(encoder.encode(anonPassword2), encryptedStr));
    }
}
