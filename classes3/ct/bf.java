package ct;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import android.util.Pair;
import java.io.File;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class bf
{
  private static int a = 1;
  private static int b = 3;
  private static int c = 4;
  private static int d = 5;
  private static int e = 6;
  private static CertificateFactory f;
  private static b g;
  private static b h;
  private static KeyStore i;
  private static KeyStore j;
  private static File k;
  private static Set l;
  private static boolean m;
  private static final Object n = new Object();
  private static final char[] o = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  public static int a(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 51	ct/bf:n	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: getstatic 85	ct/bf:f	Ljava/security/cert/CertificateFactory;
    //   9: ifnonnull +11 -> 20
    //   12: ldc 87
    //   14: invokestatic 93	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   17: putstatic 85	ct/bf:f	Ljava/security/cert/CertificateFactory;
    //   20: getstatic 95	ct/bf:g	Lct/bf$b;
    //   23: ifnonnull +10 -> 33
    //   26: aconst_null
    //   27: invokestatic 98	ct/bf:a	(Ljava/security/KeyStore;)Lct/bf$b;
    //   30: putstatic 95	ct/bf:g	Lct/bf$b;
    //   33: getstatic 100	ct/bf:m	Z
    //   36: istore 6
    //   38: iload 6
    //   40: ifne +55 -> 95
    //   43: ldc 102
    //   45: invokestatic 107	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   48: putstatic 109	ct/bf:j	Ljava/security/KeyStore;
    //   51: getstatic 109	ct/bf:j	Ljava/security/KeyStore;
    //   54: aconst_null
    //   55: invokevirtual 113	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   58: new 115	java/io/File
    //   61: dup
    //   62: new 117	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   69: ldc 120
    //   71: invokestatic 126	java/lang/System:getenv	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc -124
    //   79: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: putstatic 141	ct/bf:k	Ljava/io/File;
    //   91: iconst_1
    //   92: putstatic 100	ct/bf:m	Z
    //   95: getstatic 143	ct/bf:l	Ljava/util/Set;
    //   98: ifnonnull +13 -> 111
    //   101: new 145	java/util/HashSet
    //   104: dup
    //   105: invokespecial 146	java/util/HashSet:<init>	()V
    //   108: putstatic 143	ct/bf:l	Ljava/util/Set;
    //   111: getstatic 148	ct/bf:i	Ljava/security/KeyStore;
    //   114: ifnonnull +19 -> 133
    //   117: invokestatic 151	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   120: invokestatic 107	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   123: putstatic 148	ct/bf:i	Ljava/security/KeyStore;
    //   126: getstatic 148	ct/bf:i	Ljava/security/KeyStore;
    //   129: aconst_null
    //   130: invokevirtual 113	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   133: getstatic 153	ct/bf:h	Lct/bf$b;
    //   136: ifnonnull +12 -> 148
    //   139: getstatic 148	ct/bf:i	Ljava/security/KeyStore;
    //   142: invokestatic 98	ct/bf:a	(Ljava/security/KeyStore;)Lct/bf$b;
    //   145: putstatic 153	ct/bf:h	Lct/bf$b;
    //   148: aload_3
    //   149: monitorexit
    //   150: aload_0
    //   151: iconst_0
    //   152: aaload
    //   153: invokevirtual 158	java/security/cert/X509Certificate:checkValidity	()V
    //   156: aload_0
    //   157: iconst_0
    //   158: aaload
    //   159: invokestatic 161	ct/bf:b	(Ljava/security/cert/X509Certificate;)Z
    //   162: ifne +46 -> 208
    //   165: getstatic 40	ct/bf:b	I
    //   168: istore 5
    //   170: iload 5
    //   172: ireturn
    //   173: astore_0
    //   174: aload_3
    //   175: monitorexit
    //   176: aload_0
    //   177: athrow
    //   178: astore_0
    //   179: getstatic 38	ct/bf:a	I
    //   182: ireturn
    //   183: astore_0
    //   184: getstatic 38	ct/bf:a	I
    //   187: ireturn
    //   188: astore_0
    //   189: getstatic 38	ct/bf:a	I
    //   192: ireturn
    //   193: astore_0
    //   194: getstatic 42	ct/bf:c	I
    //   197: ireturn
    //   198: astore_0
    //   199: getstatic 44	ct/bf:d	I
    //   202: ireturn
    //   203: astore_0
    //   204: getstatic 38	ct/bf:a	I
    //   207: ireturn
    //   208: getstatic 51	ct/bf:n	Ljava/lang/Object;
    //   211: astore 4
    //   213: aload 4
    //   215: monitorenter
    //   216: getstatic 95	ct/bf:g	Lct/bf$b;
    //   219: ifnonnull +20 -> 239
    //   222: getstatic 38	ct/bf:a	I
    //   225: istore 5
    //   227: aload 4
    //   229: monitorexit
    //   230: iload 5
    //   232: ireturn
    //   233: astore_0
    //   234: aload 4
    //   236: monitorexit
    //   237: aload_0
    //   238: athrow
    //   239: getstatic 95	ct/bf:g	Lct/bf$b;
    //   242: aload_0
    //   243: aload_1
    //   244: aload_2
    //   245: invokeinterface 164 4 0
    //   250: astore_3
    //   251: aload_3
    //   252: astore_0
    //   253: aload_0
    //   254: invokeinterface 170 1 0
    //   259: ifle +26 -> 285
    //   262: aload_0
    //   263: aload_0
    //   264: invokeinterface 170 1 0
    //   269: iconst_1
    //   270: isub
    //   271: invokeinterface 174 2 0
    //   276: checkcast 155	java/security/cert/X509Certificate
    //   279: astore_0
    //   280: aload_0
    //   281: invokestatic 176	ct/bf:a	(Ljava/security/cert/X509Certificate;)Z
    //   284: pop
    //   285: aload 4
    //   287: monitorexit
    //   288: iconst_0
    //   289: ireturn
    //   290: astore_3
    //   291: getstatic 153	ct/bf:h	Lct/bf$b;
    //   294: aload_0
    //   295: aload_1
    //   296: aload_2
    //   297: invokeinterface 164 4 0
    //   302: astore_0
    //   303: goto -50 -> 253
    //   306: astore_0
    //   307: new 117	java/lang/StringBuilder
    //   310: dup
    //   311: ldc -78
    //   313: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload_3
    //   317: invokevirtual 182	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: getstatic 46	ct/bf:e	I
    //   327: istore 5
    //   329: aload 4
    //   331: monitorexit
    //   332: iload 5
    //   334: ireturn
    //   335: astore_0
    //   336: getstatic 38	ct/bf:a	I
    //   339: istore 5
    //   341: aload 4
    //   343: monitorexit
    //   344: iload 5
    //   346: ireturn
    //   347: astore_0
    //   348: getstatic 38	ct/bf:a	I
    //   351: istore 5
    //   353: aload 4
    //   355: monitorexit
    //   356: iload 5
    //   358: ireturn
    //   359: astore 4
    //   361: goto -228 -> 133
    //   364: astore 4
    //   366: goto -275 -> 91
    //   369: astore 4
    //   371: goto -313 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramArrayOfX509Certificate	X509Certificate[]
    //   0	374	1	paramString1	String
    //   0	374	2	paramString2	String
    //   3	249	3	localObject1	Object
    //   290	27	3	localCertificateException	CertificateException
    //   359	1	4	localIOException1	java.io.IOException
    //   364	1	4	localKeyStoreException	KeyStoreException
    //   369	1	4	localIOException2	java.io.IOException
    //   168	189	5	i1	int
    //   36	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	20	173	finally
    //   20	33	173	finally
    //   33	38	173	finally
    //   43	51	173	finally
    //   51	58	173	finally
    //   58	91	173	finally
    //   91	95	173	finally
    //   95	111	173	finally
    //   111	126	173	finally
    //   126	133	173	finally
    //   133	148	173	finally
    //   148	150	173	finally
    //   0	6	178	java/security/cert/CertificateException
    //   174	178	178	java/security/cert/CertificateException
    //   0	6	183	java/security/NoSuchAlgorithmException
    //   174	178	183	java/security/NoSuchAlgorithmException
    //   0	6	188	java/security/KeyStoreException
    //   174	178	188	java/security/KeyStoreException
    //   150	170	193	java/security/cert/CertificateExpiredException
    //   150	170	198	java/security/cert/CertificateNotYetValidException
    //   150	170	203	java/security/cert/CertificateException
    //   216	230	233	finally
    //   239	251	233	finally
    //   253	280	233	finally
    //   280	285	233	finally
    //   291	303	233	finally
    //   307	332	233	finally
    //   336	344	233	finally
    //   348	356	233	finally
    //   239	251	290	java/security/cert/CertificateException
    //   291	303	306	java/security/cert/CertificateException
    //   280	285	335	java/security/NoSuchAlgorithmException
    //   280	285	347	java/security/KeyStoreException
    //   126	133	359	java/io/IOException
    //   43	51	364	java/security/KeyStoreException
    //   51	58	364	java/security/KeyStoreException
    //   58	91	364	java/security/KeyStoreException
    //   51	58	369	java/io/IOException
  }
  
  private static b a(KeyStore paramKeyStore)
    throws KeyStoreException, NoSuchAlgorithmException
  {
    Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject).init(paramKeyStore);
    paramKeyStore = ((TrustManagerFactory)localObject).getTrustManagers();
    int i2 = paramKeyStore.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = paramKeyStore[i1];
      if ((localObject instanceof X509TrustManager)) {
        try
        {
          if (Build.VERSION.SDK_INT >= 17) {
            return new c((X509TrustManager)localObject);
          }
          a locala = new a((X509TrustManager)localObject);
          return locala;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject = localObject.getClass().getName();
          new StringBuilder("Error creating trust manager (").append((String)localObject).append("): ").append(localIllegalArgumentException);
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  private static String a(X500Principal paramX500Principal)
    throws NoSuchAlgorithmException
  {
    paramX500Principal = MessageDigest.getInstance("MD5").digest(paramX500Principal.getEncoded());
    char[] arrayOfChar = new char[8];
    int i1 = 0;
    while (i1 < 4)
    {
      arrayOfChar[(i1 * 2)] = o[(paramX500Principal[(3 - i1)] >> 4 & 0xF)];
      arrayOfChar[(i1 * 2 + 1)] = o[(paramX500Principal[(3 - i1)] & 0xF)];
      i1 += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static boolean a(X509Certificate paramX509Certificate)
    throws NoSuchAlgorithmException, KeyStoreException
  {
    if (j == null) {}
    Pair localPair;
    int i1;
    Object localObject1;
    do
    {
      return false;
      localPair = new Pair(paramX509Certificate.getSubjectX500Principal(), paramX509Certificate.getPublicKey());
      if (l.contains(localPair)) {
        return true;
      }
      String str = a(paramX509Certificate.getSubjectX500Principal());
      i1 = 0;
      localObject1 = str + '.' + i1;
    } while (!new File(k, (String)localObject1).exists());
    Object localObject2 = j.getCertificate("system:" + (String)localObject1);
    if (localObject2 != null)
    {
      if ((localObject2 instanceof X509Certificate)) {
        break label174;
      }
      localObject2 = localObject2.getClass().getName();
      new StringBuilder("Anchor ").append((String)localObject1).append(" not an X509Certificate: ").append((String)localObject2);
    }
    label174:
    do
    {
      i1 += 1;
      break;
      localObject1 = (X509Certificate)localObject2;
    } while ((!paramX509Certificate.getSubjectX500Principal().equals(((X509Certificate)localObject1).getSubjectX500Principal())) || (!paramX509Certificate.getPublicKey().equals(((X509Certificate)localObject1).getPublicKey())));
    l.add(localPair);
    return true;
  }
  
  private static boolean b(X509Certificate paramX509Certificate)
    throws CertificateException
  {
    try
    {
      paramX509Certificate = paramX509Certificate.getExtendedKeyUsage();
      if (paramX509Certificate == null) {
        return true;
      }
    }
    catch (NullPointerException paramX509Certificate)
    {
      return false;
    }
    paramX509Certificate = paramX509Certificate.iterator();
    while (paramX509Certificate.hasNext())
    {
      String str = (String)paramX509Certificate.next();
      if ((str.equals("1.3.6.1.5.5.7.3.1")) || (str.equals("2.5.29.37.0")) || (str.equals("2.16.840.1.113730.4.1")) || (str.equals("1.3.6.1.4.1.311.10.3.3"))) {
        return true;
      }
    }
    return false;
  }
  
  static final class a
    implements bf.b
  {
    private final X509TrustManager a;
    
    public a(X509TrustManager paramX509TrustManager)
    {
      this.a = paramX509TrustManager;
    }
    
    public final List a(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
      throws CertificateException
    {
      try
      {
        this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString1);
        return Collections.emptyList();
      }
      catch (RuntimeException paramArrayOfX509Certificate)
      {
        throw new CertificateException("Verify the certification failed");
      }
    }
  }
  
  static abstract interface b
  {
    public abstract List a(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
      throws CertificateException;
  }
  
  static final class c
    implements bf.b
  {
    private X509TrustManagerExtensions a;
    
    public c(X509TrustManager paramX509TrustManager)
    {
      try
      {
        this.a = new X509TrustManagerExtensions(paramX509TrustManager);
        return;
      }
      catch (NoClassDefFoundError paramX509TrustManager)
      {
        this.a = null;
      }
    }
    
    public final List a(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
      throws CertificateException
    {
      if (this.a != null) {
        return this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString1, paramString2);
      }
      throw new CertificateException("Verify the certification failed due to can't found class X509TrustManagerExtensions definition.");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */