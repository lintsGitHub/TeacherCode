package ttt;

import org.junit.Ignore;
import org.junit.Test;
import xxx.Suanfa;

public class SuanfaTest {

    Suanfa sf = new Suanfa();

    @Test
    public void testRot13() {
        assert "Uryyb".equals(sf.rot13("Hello"));
        assert "FgevatHgvy".equals(sf.rot13("StringUtil"));
        assert "Fg22evat中文Hgvy".equals(sf.rot13("St22ring中文Util"));
        assert sf.rot13(null) == null;
    }

    @Test
    public void testReverse() {
        assert "olleh".equals(sf.reverse("hello"));
        assert "123".equals(sf.reverse("321"));
        assert sf.reverse(null) == null;
    }

    @Test
    public void testIsEmpty() {
        assert sf.isEmpty("");
        assert sf.isEmpty(null);
        assert sf.isEmpty("       ");
        assert sf.isEmpty("null");
        assert !sf.isEmpty("hello");
        assert !sf.isEmpty("123  ");
    }

    @Test
    public void testFirstNotDupCharOfString () {
        assert sf.firstNotDupCharOfString2("hello") == 'h';
        assert sf.firstNotDupCharOfString2("hello, how r you") == 'e';
        assert sf.firstNotDupCharOfString2("he232hllo") == 'e';
        assert sf.firstNotDupCharOfString2("h5e232hllo") == '5';
        assert sf.firstNotDupCharOfString2("h你e232hllo") == '你';
        assert sf.firstNotDupCharOfString2("") == 0;
        assert sf.firstNotDupCharOfString2(null) == 0;
        assert sf.firstNotDupCharOfString2("rrrrrrr") == 0;
    }


    @Test @Ignore
    public void testFirstNotDupCharOfStringTime() {
        // 1. 构造一个非常非常大的随机字符串
        String str = sf.randStr(111111111);

        // 2. 计算，调用 ... 执行时间
        long start = System.currentTimeMillis();

        sf.firstNotDupCharOfString2(str);

        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    public void testRandStr() {
        String s1 = sf.randStr(6);
        assert s1.length() == 6;

        String s2 = sf.randStr(6);
        assert s2.length() == 6;

        assert !s1.equals(s2);
    }

}
