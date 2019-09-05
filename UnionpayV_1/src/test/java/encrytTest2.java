import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import java.io.UnsupportedEncodingException;

public class encrytTest2 {

    public static void main(String[] args) throws Exception {
        String key = "123456";
        String encrytData = "abcdef";

//        DESUtil xxx = new DESUtil();
//        String fsad = xxx.encryptWithBase64(key, encrytData);
//        System.out.println(fsad);
//
//        byte[] encryptByte = new BASE64Decoder().decodeBuffer(encrytData);
//
//        System.out.println(String.valueOf(encryptByte));

        byte[] fsda = getKeyByte(key);
        System.out.println(StrUtil.str(fsda, CharsetUtil.CHARSET_UTF_8));
        System.out.println(String.valueOf(fsda).length());
    }



    private static byte[] getKeyByte(String key) throws UnsupportedEncodingException {
        byte[] data = key.getBytes();
        int len = data.length;
        byte[] newdata = new byte[24];
        System.arraycopy(data, 0, newdata, 0, len > 24 ? 24 : len);
        return newdata;
    }



}
