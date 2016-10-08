package ct;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.Deflater;

public final class i
{
  boolean a;
  
  public i(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public static at a(String paramString)
  {
    if (paramString == null) {}
    ar localar;
    do
    {
      return null;
      localar = ar.f();
    } while (localar == null);
    long l = new Date().getTime();
    Object localObject2 = bb.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("A23", d(localar.e()));
    at localat = new at();
    localat.a(paramString);
    localat.a = l;
    localat.a((Map)localObject2);
    localat.b = localar.a();
    localat.c = ((String)localObject1);
    return localat;
  }
  
  public static av a(bj parambj)
  {
    parambj = new ba(parambj);
    try
    {
      Object localObject1 = parambj.a;
      Object localObject3 = new bh(0);
      ((bh)localObject3).b = ((bj)localObject1).b;
      ((bh)localObject3).a(((bj)localObject1).a, 0);
      ((bj)localObject1).c.a = 3;
      Object localObject2 = ((bj)localObject1).c;
      localObject3 = ((bh)localObject3).a;
      byte[] arrayOfByte = new byte[((ByteBuffer)localObject3).position()];
      System.arraycopy(((ByteBuffer)localObject3).array(), 0, arrayOfByte, 0, arrayOfByte.length);
      ((bk)localObject2).e = arrayOfByte;
      localObject2 = new bh(0);
      ((bh)localObject2).b = ((bj)localObject1).b;
      ((bj)localObject1).c.a((bh)localObject2);
      localObject2 = ((bh)localObject2).a;
      localObject1 = new byte[((ByteBuffer)localObject2).position()];
      System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
      int i = localObject1.length;
      localObject2 = ByteBuffer.allocate(i + 4);
      ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
      parambj.b = ((ByteBuffer)localObject2).array();
      return parambj;
    }
    catch (Exception localException)
    {
      parambj.e = -2;
      parambj.f = be.a(localException);
    }
    return parambj;
  }
  
  public static String a(at paramat)
  {
    localStringBuilder = new StringBuilder();
    Object localObject1 = new StringBuilder();
    long l = System.currentTimeMillis();
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTimeInMillis(l);
    localStringBuilder.append(((SimpleDateFormat)localObject2).format(((Calendar)localObject3).getTime()) + "|");
    localStringBuilder.append("INFO|");
    localStringBuilder.append(p.b() + "|");
    localObject3 = ar.f();
    if (localObject3 != null) {
      localStringBuilder.append(ar.f().c() + "|");
    }
    for (;;)
    {
      localStringBuilder.append("beacon|");
      localStringBuilder.append("1.8.1|");
      localObject1 = paramat.b;
      try
      {
        localObject2 = URLEncoder.encode(paramat.b, "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          continue;
          localStringBuilder.append("unknow\n");
        }
      }
      localStringBuilder.append((String)localObject1 + "|");
      localStringBuilder.append("qua|");
      localStringBuilder.append("upload_ip|");
      localStringBuilder.append("unknown|");
      localStringBuilder.append(paramat.c + "|");
      localStringBuilder.append(paramat.a() + "|");
      localStringBuilder.append(paramat.d + "|");
      localStringBuilder.append("0|");
      localStringBuilder.append("0|");
      localObject1 = a(paramat.b());
      localStringBuilder.append((String)localObject1 + "|");
      localObject1 = new StringBuilder();
      l = paramat.a;
      paramat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(l);
      localStringBuilder.append(paramat.format(((Calendar)localObject2).getTime()) + "|");
      localStringBuilder.append("upload_time|");
      if (localObject3 == null) {
        break;
      }
      localStringBuilder.append(((ar)localObject3).b() + "\n");
      return localStringBuilder.toString();
      localStringBuilder.append("unknow|");
    }
  }
  
  private static String a(Map paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuffer.append("&");
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append((String)paramMap.get(str));
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static HashMap a(ao paramao)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("B50", paramao.d);
    localHashMap.put("B51", c(paramao.g));
    localHashMap.put("B69", c(paramao.e));
    localHashMap.put("B52", paramao.h);
    localHashMap.put("B53", c(paramao.j));
    localHashMap.put("B54", paramao.k);
    localHashMap.put("B55", paramao.m);
    localHashMap.put("B56", paramao.n);
    if (!TextUtils.isEmpty(paramao.o)) {
      localHashMap.put("B57", c(paramao.o));
    }
    if ((!TextUtils.isEmpty(paramao.p)) && (!paramao.p.equals("null"))) {
      localHashMap.put("B58", c(paramao.p));
    }
    localHashMap.put("B59", paramao.q);
    localHashMap.put("B63", paramao.z);
    localHashMap.put("B60", paramao.r);
    localHashMap.put("B61", paramao.s);
    localHashMap.put("B62", paramao.t);
    localHashMap.put("B71", paramao.w);
    localHashMap.put("B76", paramao.x);
    return localHashMap;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte['Ā'];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    localDeflater.finish();
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  public static boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: new 433	java/net/Socket
    //   9: dup
    //   10: invokespecial 434	java/net/Socket:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: new 436	java/net/InetSocketAddress
    //   20: dup
    //   21: aload_0
    //   22: bipush 80
    //   24: invokespecial 439	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   27: sipush 5000
    //   30: invokevirtual 443	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 446	java/net/Socket:isConnected	()Z
    //   39: istore 6
    //   41: iload 6
    //   43: ifeq +6 -> 49
    //   46: iconst_1
    //   47: istore 4
    //   49: aload_2
    //   50: invokevirtual 449	java/net/Socket:close	()V
    //   53: iload 4
    //   55: ireturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 450	java/lang/Throwable:printStackTrace	()V
    //   61: iload 4
    //   63: ireturn
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 450	java/lang/Throwable:printStackTrace	()V
    //   73: iload 5
    //   75: istore 4
    //   77: aload_0
    //   78: ifnull -25 -> 53
    //   81: aload_0
    //   82: invokevirtual 449	java/net/Socket:close	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 450	java/lang/Throwable:printStackTrace	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 449	java/net/Socket:close	()V
    //   105: aload_0
    //   106: athrow
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 450	java/lang/Throwable:printStackTrace	()V
    //   112: goto -7 -> 105
    //   115: astore_0
    //   116: goto -19 -> 97
    //   119: astore_3
    //   120: aload_2
    //   121: astore_0
    //   122: goto -55 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   15	87	1	localObject	Object
    //   107	2	1	localThrowable1	Throwable
    //   13	108	2	localSocket	java.net.Socket
    //   64	6	3	localThrowable2	Throwable
    //   119	1	3	localThrowable3	Throwable
    //   4	72	4	bool1	boolean
    //   1	73	5	bool2	boolean
    //   39	3	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   49	53	56	java/lang/Throwable
    //   6	14	64	java/lang/Throwable
    //   81	85	87	java/lang/Throwable
    //   6	14	94	finally
    //   101	105	107	java/lang/Throwable
    //   16	33	115	finally
    //   35	41	115	finally
    //   69	73	115	finally
    //   16	33	119	java/lang/Throwable
    //   35	41	119	java/lang/Throwable
  }
  
  private static String c(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
    }
    return str;
  }
  
  private static String d(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = URLEncoder.encode(paramString, "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */