package com.tencent.component.network.module.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.utils.a.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessReport
{
  private static Random a = new Random();
  private static final Object[] b = new Object[12];
  private static final Object c = new Object();
  private static volatile boolean d = false;
  private static long e = SystemClock.uptimeMillis();
  private static SparseArray<ArrayList<ReportObj>> f = new SparseArray(12);
  private static b g = new b("BusinessReport");
  
  public static void init()
  {
    int j = 0;
    if (d) {
      return;
    }
    synchronized (c)
    {
      if (d) {
        return;
      }
    }
    d = true;
    int i = 0;
    break label102;
    for (;;)
    {
      if (i >= b.length)
      {
        return;
        label49:
        f.append(i, new a());
        break;
        label66:
        f.append(i, new ArrayList());
        break;
      }
      b[i] = new Object();
      i += 1;
    }
    for (;;)
    {
      label102:
      if (i >= 12)
      {
        i = j;
        break;
      }
      if (i == 1) {
        break label49;
      }
      if (i != 11) {
        break label66;
      }
      break label49;
      i += 1;
    }
  }
  
  public static void uploadReport(ReportObj paramReportObj, int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 9)) && (paramInt1 % 2 != 0)) {}
    for (;;)
    {
      return;
      if ((paramInt2 == 0) || (paramInt2 == 1))
      {
        int i = paramInt1 + paramInt2;
        long l1 = SystemClock.uptimeMillis();
        long l2 = e;
        ArrayList localArrayList = (ArrayList)f.get(i);
        synchronized (b[i])
        {
          localArrayList.add(paramReportObj);
          switch (i)
          {
          default: 
            return;
          case 1: 
          case 7: 
          case 11: 
            if ((localArrayList.size() >= 10) || (l1 - l2 >= 600000L))
            {
              uploadReportImmediately(paramInt1, paramInt2);
              return;
            }
            break;
          }
        }
      }
    }
    uploadReportImmediately(paramInt1, paramInt2);
  }
  
  public static void uploadReportImmediately(int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 11)) && (paramInt1 % 2 != 0)) {}
    int i;
    ArrayList localArrayList1;
    do
    {
      do
      {
        return;
      } while (((paramInt2 != 0) && (paramInt2 != 1)) || (!NetworkManager.isNetworkAvailable()));
      i = paramInt1 + paramInt2;
      localArrayList1 = (ArrayList)f.get(i);
    } while (localArrayList1.isEmpty());
    synchronized (b[i])
    {
      ArrayList localArrayList2 = new ArrayList(localArrayList1);
      if ((i == 1) || (i == 11))
      {
        f.setValueAt(i, new a());
        localArrayList1.clear();
        e = SystemClock.uptimeMillis();
        g.a(new ReportRunnable(localArrayList2, paramInt1, paramInt2));
        return;
      }
      f.setValueAt(i, new ArrayList());
    }
  }
  
  public static class ReportRunnable
    implements Runnable
  {
    private boolean a = false;
    private boolean b = false;
    private int c = 0;
    private ArrayList<ReportObj> d;
    private int e;
    private int f;
    private String g;
    private String h;
    
    public ReportRunnable(ArrayList<ReportObj> paramArrayList, int paramInt1, int paramInt2)
    {
      this.d = paramArrayList;
      this.e = paramInt1;
      this.f = paramInt2;
    }
    
    public void run()
    {
      if (!this.a)
      {
        if (this.d.isEmpty()) {
          com.tencent.component.network.downloader.common.a.d("BusinessReport", "listToSend is empty.");
        }
      }
      else {
        if ((!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h))) {
          break label228;
        }
      }
      for (;;)
      {
        return;
        Object localObject2 = this.d;
        Object localObject1 = new JSONObject();
        for (;;)
        {
          try
          {
            ((JSONObject)localObject1).put("count", ((ArrayList)localObject2).size());
            localJSONArray = new JSONArray();
            localObject2 = ((ArrayList)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              continue;
            }
            ((JSONObject)localObject1).put("data", localJSONArray);
          }
          catch (JSONException localJSONException)
          {
            JSONArray localJSONArray;
            localObject1 = null;
            com.tencent.component.network.downloader.common.a.b("BusinessReport", "JSONException when uploadReport.", localJSONException);
            continue;
          }
          this.g = ReportObj.getReportUrl(this.e, this.f);
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("BusinessReport", "url : " + this.g);
          }
          if (localObject1 != null) {
            this.h = ((JSONObject)localObject1).toString();
          }
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("BusinessReport", "json : " + this.h);
          }
          this.a = true;
          break;
          localJSONArray.put(((ReportObj)((Iterator)localObject2).next()).toJSON());
        }
        label228:
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("BusinessReport", "start report thread.");
        }
        try
        {
          localObject1 = e.a(Global.getContext(), this.g, new StringEntity(this.h));
          if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
          {
            this.d.clear();
            this.b = true;
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("BusinessReport", "report success.");
            }
          }
          while ((!this.b) && (this.c <= 3))
          {
            BusinessReport.a().b(this);
            return;
            this.c += 1;
            com.tencent.component.network.downloader.common.a.d("BusinessReport", "HttpStatus error when report : " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            this.c += 1;
            com.tencent.component.network.downloader.common.a.a("BusinessReport", "exception when report", localUnsupportedEncodingException);
          }
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          for (;;)
          {
            this.c += 1;
            com.tencent.component.network.downloader.common.a.a("BusinessReport", "exception when report", localClientProtocolException);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.c += 1;
            com.tencent.component.network.downloader.common.a.a("BusinessReport", "exception when report", localIOException);
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            this.c += 1;
            com.tencent.component.network.downloader.common.a.a("BusinessReport", "exception when report", localIllegalArgumentException);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.c += 1;
            com.tencent.component.network.downloader.common.a.a("BusinessReport", "exception when report", localException);
          }
        }
        catch (Error localError)
        {
          for (;;)
          {
            this.c += 1;
            com.tencent.component.network.downloader.common.a.a("BusinessReport", "error when report", localError);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\report\BusinessReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */