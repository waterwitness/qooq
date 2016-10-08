package com.tencent.tmdownloader.internal.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmdownloader.internal.d.a;
import com.tencent.tmdownloader.internal.d.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public String A = "";
  public String B = "";
  public String C = "";
  public String D = "";
  public String E = "";
  public int F = 0;
  public String G = "";
  public String H = "";
  public String I = "";
  public int J = 0;
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  boolean g;
  public int h;
  public int i;
  public long j;
  public long k;
  public String l;
  protected String m;
  public int n;
  public int o;
  public String p;
  public long q;
  protected HashMap<String, String> r;
  protected String s;
  public long t = 0L;
  public String u = "";
  public String v = "";
  public String w = "";
  public long x = 0L;
  public long y = 0L;
  public long z = 0L;
  
  public d()
  {
    this.g = false;
  }
  
  public d(String paramString1, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.c = c.a(paramString1);
    this.f = UUID.randomUUID().toString();
    this.n = paramInt;
    this.i = 0;
    this.o = 0;
    this.g = false;
    this.a = paramString2;
    this.p = c.b();
    this.q = 0L;
  }
  
  public static d a(Cursor paramCursor)
  {
    d locald = new d();
    locald.h = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    locald.f = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    locald.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    locald.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    locald.l = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    locald.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    locald.e = paramCursor.getInt(paramCursor.getColumnIndex("redirectCnt"));
    locald.d = paramCursor.getInt(paramCursor.getColumnIndex("retryCnt"));
    locald.k = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    locald.i = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    locald.j = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    locald.n = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    locald.p = paramCursor.getString(paramCursor.getColumnIndex("netType"));
    locald.o = paramCursor.getInt(paramCursor.getColumnIndex("downloadFailedErrCode"));
    locald.q = paramCursor.getLong(paramCursor.getColumnIndex("downloadFailedTime"));
    locald.s = paramCursor.getString(paramCursor.getColumnIndex("headerParams"));
    locald.t = paramCursor.getLong(paramCursor.getColumnIndex("appId"));
    locald.u = paramCursor.getString(paramCursor.getColumnIndex("taskPakcageName"));
    locald.v = paramCursor.getString(paramCursor.getColumnIndex("taskVersioncode"));
    locald.w = paramCursor.getString(paramCursor.getColumnIndex("clientIp"));
    locald.x = paramCursor.getLong(paramCursor.getColumnIndex("startTime"));
    locald.y = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
    locald.F = paramCursor.getInt(paramCursor.getColumnIndex("downloadType"));
    locald.z = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    locald.A = paramCursor.getString(paramCursor.getColumnIndex("uintype"));
    locald.B = paramCursor.getString(paramCursor.getColumnIndex("via"));
    locald.C = paramCursor.getString(paramCursor.getColumnIndex("channelId"));
    locald.D = paramCursor.getString(paramCursor.getColumnIndex("traceId"));
    locald.E = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
    locald.H = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
    locald.I = paramCursor.getString(paramCursor.getColumnIndex("appName"));
    return locald;
  }
  
  public static void a(ContentValues paramContentValues, d paramd)
  {
    if ((paramd != null) && (paramContentValues != null))
    {
      paramContentValues.put("taskId", Integer.valueOf(paramd.h));
      paramContentValues.put("uId", paramd.f);
      paramContentValues.put("finalUrl", paramd.c);
      paramContentValues.put("taskUrl", paramd.b);
      paramContentValues.put("fileName", paramd.l);
      paramContentValues.put("contentType", paramd.a);
      paramContentValues.put("redirectCnt", Integer.valueOf(paramd.e));
      paramContentValues.put("retryCnt", Integer.valueOf(paramd.d));
      paramContentValues.put("totalBytes", Long.valueOf(paramd.k));
      paramContentValues.put("status", Integer.valueOf(paramd.i));
      paramContentValues.put("receivedBytes", Long.valueOf(paramd.j));
      paramContentValues.put("priority", Integer.valueOf(paramd.n));
      paramContentValues.put("netType", paramd.p);
      paramContentValues.put("downloadFailedErrCode", Integer.valueOf(paramd.o));
      paramContentValues.put("downloadFailedTime", Long.valueOf(paramd.q));
      paramContentValues.put("headerParams", paramd.s);
      paramContentValues.put("appId", Long.valueOf(paramd.t));
      paramContentValues.put("taskPakcageName", paramd.u);
      paramContentValues.put("taskVersioncode", paramd.v);
      paramContentValues.put("clientIp", paramd.w);
      paramContentValues.put("startTime", Long.valueOf(paramd.x));
      paramContentValues.put("endTime", Long.valueOf(paramd.y));
      paramContentValues.put("downloadType", Integer.valueOf(paramd.F));
      paramContentValues.put("uin", Long.valueOf(paramd.z));
      paramContentValues.put("uintype", paramd.A);
      paramContentValues.put("via", paramd.B);
      paramContentValues.put("channelId", paramd.C);
      paramContentValues.put("traceId", paramd.D);
      paramContentValues.put("extraData", paramd.E);
      paramContentValues.put("iconUrl", paramd.H);
      paramContentValues.put("appName", paramd.I);
    }
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = c();
        if (bool) {
          return;
        }
        this.i = paramInt;
        if ((this.i != 6) && (this.i != 6))
        {
          if (this.i == 5) {
            this.q = System.currentTimeMillis();
          }
          a.a().a(this);
          e.a().a(this.b, this.i, this.o, "");
          continue;
        }
        a.a().a(this.b);
      }
      finally {}
      e.a().a(String.valueOf(this.t));
    }
  }
  
  public void a(long paramLong)
  {
    if (0L == paramLong) {
      this.j = 0L;
    }
    this.k = paramLong;
    a.a().a(this);
  }
  
  public void a(String paramString)
  {
    m.c(paramString, "--------dump DownloadInfo-----------");
    m.c(paramString, "mContentType: " + this.a);
    m.c(paramString, "mURL: " + this.b);
    m.c(paramString, "mRetryCnt: " + this.d);
    m.c(paramString, "mRedirectCnt: " + this.e);
    m.c(paramString, "mTotalBytes: " + this.k);
    m.c(paramString, "mUUID: " + this.f);
    m.c(paramString, "mStatus: " + this.i);
    m.c(paramString, "mReceivedBytes: " + this.j);
    m.c(paramString, "mFileName: " + this.l);
    m.c(paramString, "mDownloadFailedErrCode: " + this.o);
    m.c(paramString, "mNetType:" + this.p);
    m.c(paramString, "mDownloadFailedTime:" + this.q);
    m.c(paramString, "mHeaderParamString:" + this.s);
    m.c(paramString, "mAppid:" + this.t + " mpackageName:" + this.u + " mVersioncode:" + this.v + " via:" + this.B);
    m.c(paramString, "mChannelid:" + this.C + " traceId:" + this.D + " extraData:" + this.E + " downloadType:" + this.F + " mIconUrl:" + this.H + " mAppName:" + this.I + " showNotification:" + this.J);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.r = paramHashMap;
      this.s = new JSONObject(paramHashMap).toString();
    }
  }
  
  boolean a()
  {
    return (this.k != 0L) && (this.j == this.k);
  }
  
  public void b(long paramLong)
  {
    this.j += paramLong;
    e.a().a(this.b, this.j, this.k);
  }
  
  boolean b()
  {
    return this.d <= 5;
  }
  
  boolean c()
  {
    return (this.i > 3) && (this.i != 6);
  }
  
  public int d()
  {
    m.c("_DownloadInfo", "url: " + this.b);
    if ((!TextUtils.isEmpty(this.s)) && ((this.r == null) || (this.r.size() <= 0)))
    {
      HashMap localHashMap = new HashMap();
      try
      {
        JSONObject localJSONObject = new JSONObject(this.s);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
          continue;
          if (!this.g) {
            break label156;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        m.b("_DownloadInfo", "exception: ", localJSONException);
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      return 5;
      if (localJSONException.size() > 0) {
        this.r = localJSONException;
      }
    }
    label156:
    if (this.l == null) {
      this.l = c.a(this.b, this.a);
    }
    if (this.m == null) {
      this.m = c.a(this.b, this.a);
    }
    if (this.k == 0L) {
      new b(this.m, this.l).b();
    }
    if (this.i == 5) {
      this.c = this.b;
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.l))
    {
      localObject = new b(this.m, this.l);
      long l1 = ((b)localObject).c();
      m.c("_DownloadInfo", "FileLen: " + l1 + " filename: " + this.l);
      if (l1 > this.k) {
        ((b)localObject).b();
      }
      for (this.j = 0L; a(); this.j = l1)
      {
        ((b)localObject).g();
        a(4);
        return 4;
      }
    }
    if (this.i == 5)
    {
      this.e = 0;
      this.d = 0;
      this.i = 0;
      this.o = 0;
    }
    m.c("_DownloadInfo", "startDownloadIfReady...");
    a("_DownloadInfo");
    if (h.a().a(this.b) == null)
    {
      localObject = new g(this);
      a(1);
      this.h = h.a().a((g)localObject);
    }
    return 0;
  }
  
  public void e()
  {
    m.c("_DownloadInfo", "DownloadInfo::pauseDownload url: " + this.b);
    h.a().a(this.h);
    a(3);
  }
  
  public void f()
  {
    m.c("_DownloadInfo", "DownloadInfo::stopDownload url: " + this.b);
    h.a().a(this.h);
    a(6);
  }
  
  public void g()
  {
    m.c("_DownloadInfo", "DownloadInfo::deleteDownload url: " + this.b + ",mFileName: " + this.l);
    h.a().a(this.h);
    if (this.l != null) {
      new b(this.m, this.l).a();
    }
    a(6);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */