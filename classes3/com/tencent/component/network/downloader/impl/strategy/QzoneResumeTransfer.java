package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.cache.a.b;
import com.tencent.component.network.utils.Base64;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class QzoneResumeTransfer
  implements ResumeTransfer
{
  private Context a;
  private String b;
  private b c;
  private boolean d = false;
  private Map<String, CacheFileAttribute> e = new ConcurrentHashMap();
  private final Object f = new Object();
  private SharedPreferences g;
  private List<String> h = Collections.synchronizedList(new ArrayList());
  private com.tencent.component.network.downloader.a i;
  private String[] j = { "a[0-9].qpic.cn", "m.qpic.cn", ".*qzonestyle.gtimg.cn", ".*qzs.qq.com", ".*i.gtimg.cn", "a\\d+.photo.store.qq.com", "b\\d+.photo.store.qq.com", "vqzone.tc.qq.com", "vwecam.tc.qq.com" };
  public Map<String, Pattern> mDominPatterns = new HashMap();
  public boolean mForceEnable = false;
  
  public QzoneResumeTransfer(Context paramContext, String paramString, b paramb, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramb;
    this.d = paramBoolean;
    b();
    if (this.d)
    {
      this.g = PreferenceManager.getDefaultSharedPreferences(this.a);
      paramb = this.g.getString("contenttype_" + this.b, null);
      if (paramb != null)
      {
        paramContext = (Context)localObject2;
        paramString = (String)localObject1;
      }
    }
    try
    {
      paramb = com.tencent.component.network.downloader.common.a.a(Base64.decode(paramb, 0));
      paramContext = paramb;
      paramString = paramb;
      this.e.clear();
      paramContext = paramb;
      paramString = paramb;
      paramb.readMap(this.e, this.a.getClassLoader());
    }
    catch (Throwable paramb)
    {
      for (;;)
      {
        paramString = paramContext;
        com.tencent.component.network.downloader.common.a.b("download", "download", paramb);
        if (paramContext != null) {
          paramContext.recycle();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label306;
      }
      paramString.recycle();
    }
    if (this.e == null) {
      this.e = new HashMap();
    }
  }
  
  private static CacheFileAttribute a(HttpResponse paramHttpResponse)
  {
    Object localObject2 = null;
    if (paramHttpResponse == null) {
      return null;
    }
    Object localObject1 = paramHttpResponse.getEntity();
    if (localObject1 != null)
    {
      localObject1 = ((HttpEntity)localObject1).getContentType();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((Header)localObject1).getValue();; localObject1 = null)
    {
      Header localHeader = paramHttpResponse.getFirstHeader("Last-Modified");
      paramHttpResponse = (HttpResponse)localObject2;
      if (localHeader != null) {
        paramHttpResponse = localHeader.getValue();
      }
      return new CacheFileAttribute((String)localObject1, paramHttpResponse);
    }
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.i;
    if (localObject == null)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label44;
      }
    }
    for (;;)
    {
      return String.valueOf(paramString.hashCode());
      localObject = ((com.tencent.component.network.downloader.a)localObject).a(paramString);
      break;
      label44:
      paramString = (String)localObject;
    }
  }
  
  private void a()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localParcel;
      localObject3 = localParcel;
      localParcel.writeMap(this.e);
      localObject1 = localParcel;
      localObject3 = localParcel;
      String str = new String(Base64.encode(localParcel.marshall(), 0));
      localObject1 = localParcel;
      localObject3 = localParcel;
      this.g.edit().putString("contenttype_" + this.b, str).commit();
      if (localParcel != null) {
        localParcel.recycle();
      }
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      com.tencent.component.network.downloader.common.a.a("QzoneResumeTransfer", "saveConfig", localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        ((Parcel)localObject3).recycle();
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.mForceEnable) {}
    do
    {
      return true;
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return false;
      }
    } while (this.h.contains(paramString2));
    paramString1 = this.mDominPatterns.entrySet().iterator();
    if (!paramString1.hasNext()) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      if (!com.tencent.component.network.downloader.common.a.a((Pattern)((Map.Entry)paramString1.next()).getValue(), paramString2)) {
        break;
      }
      this.h.add(paramString2);
    }
  }
  
  private boolean a(String paramString, HttpResponse paramHttpResponse)
  {
    long l4 = 0L;
    if ((paramHttpResponse == null) || (paramHttpResponse.getStatusLine().getStatusCode() != 206)) {
      return true;
    }
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (localHttpEntity != null) {}
    for (long l1 = localHttpEntity.getContentLength();; l1 = 0L)
    {
      paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Range");
      int k;
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getValue();
        if (!TextUtils.isEmpty(paramHttpResponse)) {
          k = paramHttpResponse.indexOf("/");
        }
      }
      for (;;)
      {
        try
        {
          k = Integer.valueOf(paramHttpResponse.substring(k + 1)).intValue();
          l2 = k;
          paramString = a(paramString);
          paramString = this.c.b(paramString);
          long l3 = l4;
          if (paramString != null)
          {
            l3 = l4;
            if (paramString.exists()) {
              l3 = paramString.length();
            }
          }
          if (l1 + l3 != l2) {
            break;
          }
          return true;
        }
        catch (Exception paramHttpResponse) {}
        long l2 = 0L;
      }
      return false;
    }
  }
  
  private void b()
  {
    this.mDominPatterns.clear();
    int k = 0;
    for (;;)
    {
      if (k >= this.j.length) {
        return;
      }
      Pattern localPattern = Pattern.compile(this.j[k], 2);
      this.mDominPatterns.put(this.j[k], localPattern);
      k += 1;
    }
  }
  
  public void addCacheTmpFile(String paramString1, String arg2, HttpResponse paramHttpResponse)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {}
    do
    {
      return;
      ??? = new File(???);
    } while ((!???.exists()) || (???.length() <= 0L) || (!this.c.c(a(paramString1))) || (!this.d) || (paramHttpResponse == null));
    paramHttpResponse = a(paramHttpResponse);
    StringBuilder localStringBuilder;
    if (com.tencent.component.network.downloader.common.a.a())
    {
      localStringBuilder = new StringBuilder("Downloader Resume Response url:").append(paramString1).append(" curr:");
      if (paramHttpResponse == null) {
        break label186;
      }
    }
    label186:
    for (??? = paramHttpResponse.toString();; ??? = "N/A")
    {
      com.tencent.component.network.downloader.common.a.a("downloader", ???);
      if (paramHttpResponse == null) {
        break;
      }
      synchronized (this.f)
      {
        if (!paramHttpResponse.equals((CacheFileAttribute)this.e.get(a(paramString1))))
        {
          this.e.put(a(paramString1), paramHttpResponse);
          a();
        }
        return;
      }
    }
  }
  
  public void cleanCache()
  {
    this.c.b();
    synchronized (this.f)
    {
      this.e.clear();
      a();
      return;
    }
  }
  
  public void cleanCache(String arg1)
  {
    String str = a(???);
    this.c.d(str);
    synchronized (this.f)
    {
      this.e.remove(str);
      a();
      return;
    }
  }
  
  public String getResumeTmpFile(String paramString)
  {
    paramString = this.c.b(a(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    if ((!this.d) || (!a(paramString1, paramString2))) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramHttpResponse == null)) {
      return false;
    }
    if (!a(paramString1, paramHttpResponse)) {
      return false;
    }
    paramString2 = a(paramString1);
    if (paramString2 == null) {}
    for (paramString2 = null; paramString2 == null; paramString2 = (CacheFileAttribute)this.e.get(paramString2)) {
      return true;
    }
    paramHttpResponse = a(paramHttpResponse);
    StringBuilder localStringBuilder;
    if (com.tencent.component.network.downloader.common.a.b())
    {
      localStringBuilder = new StringBuilder("download content-type check url:").append(paramString1).append(" old:");
      if (paramString2 == null) {
        break label167;
      }
      paramString1 = paramString2.toString();
      localStringBuilder = localStringBuilder.append(paramString1).append(" curr:");
      if (paramHttpResponse == null) {
        break label174;
      }
    }
    label167:
    label174:
    for (paramString1 = paramHttpResponse.toString();; paramString1 = "N/A")
    {
      com.tencent.component.network.downloader.common.a.b("downloader", paramString1);
      if (!paramString2.equals(paramHttpResponse)) {
        break label181;
      }
      return true;
      paramString1 = "N/A";
      break;
    }
    label181:
    return false;
  }
  
  public void onDownloadResult(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.c)
      {
        this.c.d(a(paramString));
        if (!this.d) {}
      }
    }
    synchronized (this.f)
    {
      if (this.e.containsKey(a(paramString)))
      {
        this.e.remove(a(paramString));
        a();
      }
      return;
      paramString = finally;
      throw paramString;
    }
  }
  
  public void prepareRequest(HttpGet paramHttpGet, String paramString1, String paramString2)
  {
    int m = 0;
    if (!a(paramString1, paramString2)) {}
    label75:
    label108:
    label249:
    label263:
    label268:
    label323:
    for (;;)
    {
      return;
      paramString2 = a(paramString1);
      File localFile = this.c.b(paramString2);
      int k;
      long l;
      if ((localFile != null) && (localFile.exists()))
      {
        k = m;
        if (localFile != null)
        {
          if (!localFile.exists()) {
            k = m;
          }
        }
        else
        {
          if (k == 0) {
            break label249;
          }
          l = localFile.length();
          paramString2 = a(paramString1);
          if (paramString2 == null) {
            break label263;
          }
          paramString2 = (CacheFileAttribute)this.e.get(paramString2);
          if (paramString2 == null) {
            break label263;
          }
          paramString2 = paramString2.ContentType;
          if (l > 0L)
          {
            if (this.d) {
              break label268;
            }
            paramHttpGet.addHeader("Range", "bytes=" + l + "-");
          }
        }
      }
      for (;;)
      {
        if (!com.tencent.component.network.downloader.common.a.b()) {
          break label323;
        }
        com.tencent.component.network.downloader.common.a.b("downloader", "Downloader Resume --- begin range:" + l + " Accept:" + paramString2 + " url:" + paramString1);
        return;
        l = localFile.lastModified();
        l = System.currentTimeMillis() - l;
        k = m;
        if (l < 0L) {
          break;
        }
        k = m;
        if (l > 86400000L) {
          break;
        }
        k = 1;
        break;
        this.c.d(paramString2);
        l = 0L;
        break label75;
        paramString2 = null;
        break label108;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramHttpGet.addHeader("Range", "bytes=" + l + "-");
          paramHttpGet.addHeader("Accept", paramString2);
          paramHttpGet.addHeader("Q-Accept", paramString2);
        }
      }
    }
  }
  
  public void setSupportDomains(String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return;
    }
    if (!paramBoolean) {}
    int k;
    String[] arrayOfString;
    for (this.j = paramArrayOfString;; this.j = arrayOfString)
    {
      b();
      return;
      k = this.j.length;
      int m = paramArrayOfString.length + k;
      arrayOfString = new String[m];
      k = 0;
      if (k < m) {
        break;
      }
    }
    if (k < this.j.length) {
      arrayOfString[k] = this.j[k];
    }
    for (;;)
    {
      k += 1;
      break;
      arrayOfString[k] = paramArrayOfString[(k - this.j.length)];
    }
  }
  
  public void setUrlKeyGenerator(com.tencent.component.network.downloader.a parama)
  {
    this.i = parama;
  }
  
  public static class CacheFileAttribute
    implements Parcelable
  {
    public static final Parcelable.Creator<CacheFileAttribute> CREATOR = new QzoneResumeTransfer.CacheFileAttribute.1();
    public String ContentType;
    public String LastModifyTime;
    
    public CacheFileAttribute(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.ContentType = paramParcel.readString();
      this.LastModifyTime = paramParcel.readString();
    }
    
    public CacheFileAttribute(String paramString1, String paramString2)
    {
      this.ContentType = paramString1;
      this.LastModifyTime = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof CacheFileAttribute))) {
          break;
        }
        paramObject = (CacheFileAttribute)paramObject;
      } while ((TextUtils.equals(this.ContentType, ((CacheFileAttribute)paramObject).ContentType)) && (TextUtils.equals(this.LastModifyTime, ((CacheFileAttribute)paramObject).LastModifyTime)));
      return false;
      return false;
    }
    
    public final String toString()
    {
      return "CacheFileAttr --- ContentType:" + this.ContentType + " LastModify:" + this.LastModifyTime;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeString(this.ContentType);
      paramParcel.writeString(this.LastModifyTime);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\strategy\QzoneResumeTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */