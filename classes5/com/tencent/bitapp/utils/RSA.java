package com.tencent.bitapp.utils;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import junit.framework.Assert;

public class RSA
{
  public static final String KEY_MD5 = "MD5";
  public static final String KEY_RSA = "RSA";
  public static final String MD5_WITH_RSA = "MD5withRSA";
  private static final String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALi6rU/YTAvH9bdnVD/NFznlgsG0\nOLERbmnbHo0CzL1yNa5+VtY0MS7q9KDRlUyrQu+ndIM2jDnR7ZGnaFhxUZOaPh0Kz82+9sqQIlL+\nj0MPbdwIqozVQ1NQ4agPel62K8QW86Q5AJyPHoOF4VZ/sd1oPM/dv5Lv8/NlduY/aWHRAgMBAAEC\ngYAWls1GrD5wWl1TthD5VEz4yXX51d3w2R7VVvQfbi43JFYoJk7cFrnE8PpFCBvnqjGfOKzotqzj\nDSat3vjFh+Xfnzpx7GZUQeQY9N2Yly7vxfovpfZ8zpo4NRZ8Rr/iw5jS+DUBvpySvu3STsplCTGr\nJYkYmikXQAF6oWPqeG8h2QJBAPRvC5zmqjDHsV8ynrSrhodjp6gq1zhnsvur7PzpkRmIPBaY3jdj\nfWFh0zkQRRZyqzUwMaiObAePYjLnwIdyRIMCQQDBeGYeO+rAc+EAruAG8yq1l+uq3EJCfLn5YWL+\nwU9SST04ITY0xy5FrVDlO0F32tEdYijuzAkqLKUJ+QO4CrgbAkAi2qa8Q8Pm2sK3AV/SAVdYfORO\nPXWc7GSAMH7FfYScMGnpCvk8yqn5NdrJm0FOtyEkn2+lSlGrLk3hVlyEs82DAkBW/egM2Cwp9PDK\n+dbJyTT/ChxxazBv7N1CgMOegRVFjqD0SBqziIwJ0HB7YjWByuYULDrzhNLqH8Dlxw4hBtDZAkBm\nC3+BSvG7GVVkmhGu63rFVir/GwSg7GrCN6PUH0fw9u0hyKXoQYOm1SPb4WB7fudmw7rIvRhPT5Uf\n15yiCKYe";
  public static final String PRI_KEY = "RSAPrivateKey";
  private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4uq1P2EwLx/W3Z1Q/zRc55YLBtDixEW5p2x6N\nAsy9cjWuflbWNDEu6vSg0ZVMq0Lvp3SDNow50e2Rp2hYcVGTmj4dCs/NvvbKkCJS/o9DD23cCKqM\n1UNTUOGoD3petivEFvOkOQCcjx6DheFWf7HdaDzP3b+S7/PzZXbmP2lh0QIDAQAB";
  public static final String PUB_KEY = "RSAPublicKey";
  
  public static byte[] decryptBase64(String paramString)
  {
    return Base64.decode(paramString, 0);
  }
  
  public static byte[] decryptByPrivateKey(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    Object localObject = new PKCS8EncodedKeySpec(decryptBase64(paramString));
    paramString = KeyFactory.getInstance("RSA");
    localObject = paramString.generatePrivate((KeySpec)localObject);
    paramString = Cipher.getInstance(paramString.getAlgorithm());
    paramString.init(2, (Key)localObject);
    return paramString.doFinal(paramArrayOfByte);
  }
  
  public static byte[] decryptByPublicKey(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    Object localObject = new X509EncodedKeySpec(decryptBase64(paramString));
    paramString = KeyFactory.getInstance("RSA");
    localObject = paramString.generatePublic((KeySpec)localObject);
    paramString = Cipher.getInstance(paramString.getAlgorithm());
    paramString.init(2, (Key)localObject);
    return paramString.doFinal(paramArrayOfByte);
  }
  
  public static String encryptBase64(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 0);
  }
  
  public static byte[] encryptByPriKey(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    Object localObject = new PKCS8EncodedKeySpec(decryptBase64(paramString));
    paramString = KeyFactory.getInstance("RSA");
    localObject = paramString.generatePrivate((KeySpec)localObject);
    paramString = Cipher.getInstance(paramString.getAlgorithm());
    paramString.init(1, (Key)localObject);
    return paramString.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encryptByPublicKey(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    Object localObject = new X509EncodedKeySpec(decryptBase64(paramString));
    paramString = KeyFactory.getInstance("RSA");
    localObject = paramString.generatePublic((KeySpec)localObject);
    paramString = Cipher.getInstance(paramString.getAlgorithm());
    paramString.init(1, (Key)localObject);
    return paramString.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encryptMD5(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static Key getKey(String paramString)
    throws Exception
  {
    paramString = new X509EncodedKeySpec(paramString.getBytes());
    return KeyFactory.getInstance("RSA").generatePublic(paramString);
  }
  
  public static String getPriKey(Map<String, Key> paramMap)
  {
    return encryptBase64(((Key)paramMap.get("RSAPrivateKey")).getEncoded());
  }
  
  public static String getPubKey(Map<String, Key> paramMap)
  {
    return encryptBase64(((Key)paramMap.get("RSAPublicKey")).getEncoded());
  }
  
  public static Map<String, Key> initKey()
    throws NoSuchAlgorithmException
  {
    Object localObject1 = KeyPairGenerator.getInstance("RSA");
    ((KeyPairGenerator)localObject1).initialize(1024);
    Object localObject2 = ((KeyPairGenerator)localObject1).generateKeyPair();
    localObject1 = (RSAPublicKey)((KeyPair)localObject2).getPublic();
    localObject2 = (RSAPrivateKey)((KeyPair)localObject2).getPrivate();
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("RSAPublicKey", localObject1);
    localHashMap.put("RSAPrivateKey", localObject2);
    return localHashMap;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = sign("Hello,World".getBytes(), "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALi6rU/YTAvH9bdnVD/NFznlgsG0\nOLERbmnbHo0CzL1yNa5+VtY0MS7q9KDRlUyrQu+ndIM2jDnR7ZGnaFhxUZOaPh0Kz82+9sqQIlL+\nj0MPbdwIqozVQ1NQ4agPel62K8QW86Q5AJyPHoOF4VZ/sd1oPM/dv5Lv8/NlduY/aWHRAgMBAAEC\ngYAWls1GrD5wWl1TthD5VEz4yXX51d3w2R7VVvQfbi43JFYoJk7cFrnE8PpFCBvnqjGfOKzotqzj\nDSat3vjFh+Xfnzpx7GZUQeQY9N2Yly7vxfovpfZ8zpo4NRZ8Rr/iw5jS+DUBvpySvu3STsplCTGr\nJYkYmikXQAF6oWPqeG8h2QJBAPRvC5zmqjDHsV8ynrSrhodjp6gq1zhnsvur7PzpkRmIPBaY3jdj\nfWFh0zkQRRZyqzUwMaiObAePYjLnwIdyRIMCQQDBeGYeO+rAc+EAruAG8yq1l+uq3EJCfLn5YWL+\nwU9SST04ITY0xy5FrVDlO0F32tEdYijuzAkqLKUJ+QO4CrgbAkAi2qa8Q8Pm2sK3AV/SAVdYfORO\nPXWc7GSAMH7FfYScMGnpCvk8yqn5NdrJm0FOtyEkn2+lSlGrLk3hVlyEs82DAkBW/egM2Cwp9PDK\n+dbJyTT/ChxxazBv7N1CgMOegRVFjqD0SBqziIwJ0HB7YjWByuYULDrzhNLqH8Dlxw4hBtDZAkBm\nC3+BSvG7GVVkmhGu63rFVir/GwSg7GrCN6PUH0fw9u0hyKXoQYOm1SPb4WB7fudmw7rIvRhPT5Uf\n15yiCKYe");
      Assert.assertEquals(verify("Hello,World".getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4uq1P2EwLx/W3Z1Q/zRc55YLBtDixEW5p2x6N\nAsy9cjWuflbWNDEu6vSg0ZVMq0Lvp3SDNow50e2Rp2hYcVGTmj4dCs/NvvbKkCJS/o9DD23cCKqM\n1UNTUOGoD3petivEFvOkOQCcjx6DheFWf7HdaDzP3b+S7/PzZXbmP2lh0QIDAQAB", paramArrayOfString), true);
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  public static String sign(byte[] paramArrayOfByte, String paramString)
    throws Exception
  {
    paramString = new PKCS8EncodedKeySpec(decryptBase64(paramString));
    paramString = KeyFactory.getInstance("RSA").generatePrivate(paramString);
    Signature localSignature = Signature.getInstance("MD5withRSA");
    localSignature.initSign(paramString);
    localSignature.update(paramArrayOfByte);
    return encryptBase64(localSignature.sign());
  }
  
  public static boolean verify(byte[] paramArrayOfByte, String paramString1, String paramString2)
    throws Exception
  {
    paramString1 = new X509EncodedKeySpec(decryptBase64(paramString1));
    paramString1 = KeyFactory.getInstance("RSA").generatePublic(paramString1);
    Signature localSignature = Signature.getInstance("MD5withRSA");
    localSignature.initVerify(paramString1);
    localSignature.update(paramArrayOfByte);
    return localSignature.verify(decryptBase64(paramString2));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\RSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */