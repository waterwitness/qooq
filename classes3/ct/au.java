package ct;

import android.content.Context;
import android.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class au
{
  private static int a = 5;
  private static int b = 15;
  private static List c;
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    try
    {
      paramString = i.a(paramString);
      a(paramHashMap);
      paramString.a(paramHashMap);
      if (c == null) {
        c = new ArrayList();
      }
      c.add(paramString);
      if (aq.b(p.a()))
      {
        paramString = i.a("rqd_applaunched");
        paramHashMap = new HashMap();
        a(paramHashMap);
        if (!aq.b(p.a())) {
          break label121;
        }
        paramHashMap.put("A21", "Y");
      }
      for (;;)
      {
        paramString.a(paramHashMap);
        c.add(paramString);
        if (c.size() < a) {
          break;
        }
        a(c);
        return;
        label121:
        paramHashMap.put("A21", "N");
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static void a(HashMap paramHashMap)
  {
    ar localar = ar.f();
    if (localar != null)
    {
      paramHashMap.put("A1", p.e());
      paramHashMap.put("A2", localar.d());
      paramHashMap.put("A4", localar.a);
      paramHashMap.put("A6", localar.b);
      paramHashMap.put("A7", localar.c);
      paramHashMap.put("A23", p.g());
      StringBuilder localStringBuilder = new StringBuilder();
      Context localContext = p.a();
      String str = "null";
      if (as.a(localContext) != null) {
        str = as.f(localContext);
      }
      paramHashMap.put("A33", str);
      paramHashMap.put("A10", localar.e);
      paramHashMap.put("A9", localar.d);
      paramHashMap.put("A19", bb.b);
      paramHashMap.put("A20", bb.c);
    }
  }
  
  private static void a(List paramList)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        ((StringBuilder)localObject1).append(i.a((at)paramList.next()));
      }
      Object localObject2;
      int i;
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      do
      {
        return;
        paramList = i.a(((StringBuilder)localObject1).toString().getBytes());
        localObject1 = new ap("ABC1234567890DEF".getBytes()).a(paramList);
        if (localObject1.length > 0)
        {
          paramList = new BasicHttpParams();
          HttpConnectionParams.setConnectionTimeout(paramList, 30000);
          HttpConnectionParams.setSoTimeout(paramList, 30000);
          paramList = new DefaultHttpClient(paramList);
          localObject2 = new ByteArrayEntity((byte[])localObject1);
          localObject1 = new HttpPost("http://zxcv.3g.qq.com/sdk/beacon.jsp?type=real&size=" + localObject1.length);
          ((HttpPost)localObject1).setEntity((HttpEntity)localObject2);
          if (bb.d)
          {
            localObject2 = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
            paramList.getParams().setParameter("http.route.default-proxy", localObject2);
          }
          paramList = paramList.execute((HttpUriRequest)localObject1);
          i = paramList.getStatusLine().getStatusCode();
          if ((paramList != null) && (i == 200)) {
            c.removeAll(localArrayList);
          }
        }
      } while (c.size() < b);
      c.clear();
      return;
    }
    catch (OutOfMemoryError paramList)
    {
      c.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */