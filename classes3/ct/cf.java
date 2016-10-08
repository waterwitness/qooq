package ct;

import android.content.Context;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class cf
  implements TencentHttpClient
{
  private static final List<String> a = Arrays.asList(new String[] { "lbssp.map.qq.com", "lbs.map.qq.com", "ls.map.qq.com" });
  private static x b;
  
  public cf(Context paramContext, String paramString)
  {
    try
    {
      List localList = a;
      paramContext = h.a(paramContext, "0M3006CS7U0ZC2K3", paramString, "test_uuid");
      if (paramContext != null) {
        paramContext.a(localList);
      }
      b = y.a();
      return;
    }
    catch (l paramContext) {}
  }
  
  private static String a(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  public final Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    if (b == null) {
      throw new IOException("can not init net sdk");
    }
    for (;;)
    {
      try
      {
        x localx = b;
        paramString = x.a(paramString, paramArrayOfByte);
        paramString.a();
        paramString = localx.a(paramString);
        if (paramString == null) {
          throw new IOException("null response");
        }
      }
      catch (ah paramString)
      {
        throw new IOException(paramString.getMessage());
        switch (paramString.a())
        {
        case -1: 
          throw new IOException("net sdk error: " + paramString.a());
        }
      }
      catch (Exception paramString)
      {
        throw new IOException(paramString.getMessage());
      }
      paramArrayOfByte = a(paramString.a("content-type"));
      return Pair.create(paramString.b(), paramArrayOfByte);
      paramString = Pair.create("{}".getBytes(), "utf-8");
      return paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */