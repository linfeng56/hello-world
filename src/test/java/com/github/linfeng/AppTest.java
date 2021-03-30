package com.github.linfeng;

import com.github.linfeng.hash.MD5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void md5SignWithTrue() {
        String sign = MD5.sign("abc", "def", "UTF-8");
        String result = "e80b5017098950fc58aad83c8c14978e";
        Assert.assertEquals(sign, result);
    }


    @Test
    public void md5SignWithoutCharset() {
        String sign = MD5.sign("abc", "def", "");
        String result = "e80b5017098950fc58aad83c8c14978e";
        Assert.assertEquals(sign, result);
    }

    @Test
    public void md5SignWithNullCharset() {
        String sign = MD5.sign("abc", "def", null);
        String result = "e80b5017098950fc58aad83c8c14978e";
        Assert.assertEquals(sign, result);
    }

    @Test
    public void md5SignWithErrorCharset() {
        try {
            String sign = MD5.sign("abc", "def", "error");
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("指定的编码集不对"));
            return;
        }
        Assert.fail();

    }

    @Test
    public void md5VerifyWithCharset() {
        boolean result = MD5.verify("abc", "e80b5017098950fc58aad83c8c14978e", "def", "UTF-8");
        Assert.assertTrue(result);
    }

    @Test
    public void md5VerifyWithNullCharset() {
        boolean result = MD5.verify("abc", "e80b5017098950fc58aad83c8c14978e", "def", null);
        Assert.assertTrue(result);
    }

    @Test
    public void md5VerifyTrue() {
        boolean result = MD5.verify("abc", "e80b5017098950fc58aad83c8c14978e", "def", "UTF-8");
        Assert.assertTrue(result);
    }

    @Test
    public void md5VerifyFail() {
        boolean result = MD5.verify("abc", "e80b5017098950fc58aad83c8c14978e", "error", "UTF-8");
        Assert.assertFalse(result);
    }
}
