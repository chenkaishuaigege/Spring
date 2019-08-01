import org.junit.Before;
import org.junit.Test;


public class SQLFileTest {


    //AhGaYa,AhTaNa,BaKaNa,BaMaNa,DaPhaYa,HaPaNa,KaMaNa,KaMaTa,KhaLaPha,KhaPhaNa,LaGaNa,MaGaDa,MaKaNa,MaKaTa,MaKaTha,MaKhaBa,MaMaNa,MaNyaNa,MaSaNa,MaTaNa,NaMaNa,PaMaNa,PaTaAh,PhaKaNa,SaBaNa,SaBaTa,SaKaNa,SaLaNa,SaPaBa,TaNaNa,WaMaNa,YaKaNa

    //String params = "伊洛瓦底省,马圭省,曼德勒省,勃固省,仰光省,实皆省,德林达依省,克钦邦,掸邦,钦邦,克伦邦,克耶邦,孟邦,若开邦";
    String params = "Ayeyarwady,Magway,Mandalay,Bago,Yangon,Sagaing,Tanintharyi,Kachin,Shan,Chin,Kayin,Kayah,Mon,Rakhine";

    @Before
    public void before() throws ClassNotFoundException {
        //创建一个SQL 文件
    }

    @Test
    public void test(){
        String[] param = params.split(",");
        int i = 0;

        while (i < param.length){
            int index = i + 1;
            System.out.println("INSERT INTO MULTILINGUAL_TRANSLATION_INF (MTF_FIELD_NAME, MTF_LANGUAGE, MTF_FIELD_VALUE, MTF_MESSAGE)\n" +
                    "VALUES ('province','en_US', '" + index + "','"+ param[i] +"');");
            i++;
        }




    }


}
