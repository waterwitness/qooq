package ct;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.NeighboringCellInfo;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  private static b c;
  public c a;
  public d b = new d();
  
  public b()
  {
    this.b.a();
    this.a = new c();
    this.a.a();
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6178.137D * 10000.0D) / 10000.0D * 1000.0D;
  }
  
  public static double a(double paramDouble, int paramInt)
  {
    try
    {
      if (Double.isNaN(paramDouble)) {
        return 0.0D;
      }
      paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
      return paramDouble;
    }
    catch (Exception localException) {}
    return 0.0D;
  }
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (int i = 1; i != 0; i = 0) {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        i = paramContext.getType();
        return i;
      }
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static b a()
  {
    try
    {
      if (c == null) {
        c = new b();
      }
      b localb = c;
      return localb;
    }
    finally {}
  }
  
  public static String a(ck paramck, boolean paramBoolean)
  {
    if (paramck == null) {
      return "[]";
    }
    int j = paramck.b;
    int k = paramck.c;
    int m = paramck.a;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramck.a();
    int i;
    int n;
    int i1;
    if (cx.a(m, j, k, paramck.d, paramck.e))
    {
      i = paramck.d;
      int i2 = paramck.e;
      int i3 = paramck.f;
      n = paramck.g;
      i1 = paramck.h;
      paramck = new StringBuilder();
      paramck.append("{");
      paramck.append("\"mcc\":");
      paramck.append(j);
      paramck.append(",\"mnc\":");
      paramck.append(k);
      paramck.append(",\"lac\":");
      paramck.append(i);
      paramck.append(",\"cellid\":");
      paramck.append(i2);
      paramck.append(",\"rss\":");
      paramck.append(i3);
      paramck.append(",\"seed\":");
      if (paramBoolean)
      {
        i = 1;
        paramck.append(i);
        if ((n != Integer.MAX_VALUE) && (i1 != Integer.MAX_VALUE))
        {
          paramck.append(",\"stationLat\":");
          paramck.append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
          paramck.append(",\"stationLng\":");
          paramck.append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
        }
        paramck.append("}");
        ((ArrayList)localObject1).add(paramck.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramck = ((List)localObject2).iterator();
        if (paramck.hasNext())
        {
          localObject2 = (NeighboringCellInfo)paramck.next();
          i = ((NeighboringCellInfo)localObject2).getLac();
          n = ((NeighboringCellInfo)localObject2).getCid();
          if (!cx.a(m, j, k, i, n)) {
            break label549;
          }
          i1 = ((NeighboringCellInfo)localObject2).getRssi();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{");
          ((StringBuilder)localObject2).append("\"mcc\":");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(",\"mnc\":");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(",\"lac\":");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",\"cellid\":");
          ((StringBuilder)localObject2).append(n);
          ((StringBuilder)localObject2).append(",\"rss\":");
          ((StringBuilder)localObject2).append((i1 << 1) - 113);
          ((StringBuilder)localObject2).append("}");
          ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
          continue;
        }
        i = 0;
      }
      catch (Exception paramck)
      {
        paramck = new StringBuilder("[");
        localObject2 = new da(",");
        localObject1 = ((Iterable)localObject1).iterator();
        paramck.append(((da)localObject2).a(new StringBuilder(), (Iterator)localObject1).toString());
        paramck.append("]");
        return paramck.toString();
      }
      break;
      a("illeagal main cell! ", j, k, m, paramck.d, paramck.e);
      continue;
      label549:
      a("illeagal neighboringCell! ", j, k, m, i, n);
    }
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCellInfoWithJsonFormat: ");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.append("isGsm=");
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramString.append(bool);
      localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
      localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
      return;
      bool = false;
    }
  }
  
  public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
  {
    int n = (int)(paramLocation.getLatitude() * 1000000.0D);
    int i1 = (int)(paramLocation.getLongitude() * 1000000.0D);
    paramLocation = c("tencent_loc_lib");
    int k = 0;
    int m = 0;
    while (k < paramLocation.length())
    {
      int i2 = paramLocation.charAt(k);
      int j = 256;
      int i = j;
      if (i2 >= 65)
      {
        i = j;
        if (i2 <= 90) {
          i = i2 - 65;
        }
      }
      j = i;
      if (i2 >= 97)
      {
        j = i;
        if (i2 <= 122) {
          j = i2 - 97 + 64;
        }
      }
      i = j;
      if (i2 >= 48)
      {
        i = j;
        if (i2 <= 57) {
          i = i2 + 128 - 48;
        }
      }
      m += i;
      k += 1;
    }
    paramLocation = new double[2];
    try
    {
      e.b(n ^ m, m ^ i1, paramLocation);
      paramArrayOfDouble[0] = paramLocation[0];
      paramArrayOfDouble[1] = paramLocation[1];
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == null) || (paramObject2 == null);
  }
  
  /* Error */
  public static byte[] a(java.io.File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: new 318	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 319	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: sipush 8192
    //   11: newarray <illegal type>
    //   13: astore_3
    //   14: new 321	java/io/BufferedInputStream
    //   17: dup
    //   18: new 323	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: invokespecial 329	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: aload_3
    //   34: invokevirtual 333	java/io/BufferedInputStream:read	([B)I
    //   37: istore 4
    //   39: iload 4
    //   41: iconst_m1
    //   42: if_icmpeq +34 -> 76
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: aload_3
    //   49: iconst_0
    //   50: iload 4
    //   52: invokevirtual 337	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -25 -> 30
    //   58: astore_2
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: astore_1
    //   63: aload_1
    //   64: athrow
    //   65: astore_2
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: astore_0
    //   70: aload_1
    //   71: invokestatic 339	ct/b:a	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: athrow
    //   76: aload_1
    //   77: astore_0
    //   78: aload_2
    //   79: invokevirtual 343	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   82: astore_2
    //   83: aload_1
    //   84: invokestatic 339	ct/b:a	(Ljava/io/Closeable;)V
    //   87: aload_2
    //   88: areturn
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -22 -> 70
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: goto -35 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramFile	java.io.File
    //   29	63	1	localObject1	Object
    //   95	1	1	localIOException1	IOException
    //   7	41	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   58	4	2	localIOException2	IOException
    //   65	14	2	localObject2	Object
    //   82	6	2	arrayOfByte1	byte[]
    //   13	36	3	arrayOfByte2	byte[]
    //   37	14	4	i	int
    // Exception table:
    //   from	to	target	type
    //   32	39	58	java/io/IOException
    //   47	55	58	java/io/IOException
    //   78	83	58	java/io/IOException
    //   32	39	65	finally
    //   47	55	65	finally
    //   63	65	65	finally
    //   78	83	65	finally
    //   14	30	89	finally
    //   14	30	95	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    int i = 1;
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {}
    while (i != 0)
    {
      return false;
      i = 0;
    }
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)localObject).getNetworkInfo(0);
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if (localObject != null)
        {
          boolean bool2 = ((NetworkInfo)localObject).isConnected();
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = bool2;
            if (paramContext != null) {
              bool1 = paramContext.isConnected();
            }
          }
          return bool1;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  public static boolean b(String paramString)
  {
    do
    {
      JSONObject localJSONObject;
      do
      {
        try
        {
          localJSONObject = new JSONObject(paramString);
          if (paramString.contains("latitude")) {
            return true;
          }
        }
        catch (Exception paramString)
        {
          return false;
        }
        paramString = localJSONObject.optJSONArray("cells");
      } while ((paramString != null) && (paramString.length() > 0));
      paramString = localJSONObject.optJSONArray("wifis");
    } while ((paramString != null) && (paramString.length() > 0));
    return false;
  }
  
  @Nullable
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
    paramArrayOfByte = new byte[0];
    byte[] arrayOfByte2 = new byte['Ѐ'];
    for (;;)
    {
      try
      {
        int j = localInflaterInputStream.read(arrayOfByte2);
        if (j > 0)
        {
          i += j;
          byte[] arrayOfByte1 = new byte[i];
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
          paramArrayOfByte = arrayOfByte1;
          if (j <= 0) {
            try
            {
              localByteArrayInputStream.close();
              localInflaterInputStream.close();
              return paramArrayOfByte;
            }
            catch (IOException paramArrayOfByte)
            {
              return null;
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */