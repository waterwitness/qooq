package com.tencent.upload.network.b;

import com.tencent.upload.common.UploadConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements d
{
  private List<m> a;
  private List<Integer> b;
  private Iterator<m> c;
  private Iterator<Integer> d;
  private String e;
  private h f;
  private int g = hashCode();
  private String h = getClass().getSimpleName();
  private List<a> i;
  private boolean j = false;
  
  private m b(m paramm)
  {
    m localm1;
    if (paramm == null)
    {
      if (this.c.hasNext()) {}
      for (paramm = (m)this.c.next();; paramm = null)
      {
        com.tencent.upload.a.b.b(this.h, this.g + " doChangeRoute: lastRoute == null now = " + paramm);
        localm1 = paramm;
        label64:
        return localm1;
      }
    }
    paramm = paramm.h();
    com.tencent.upload.a.b.b(this.h, this.g + " doChangeRoute: currentRoute:" + paramm);
    if (this.d.hasNext())
    {
      paramm.b(((Integer)this.d.next()).intValue());
      com.tencent.upload.a.b.b(this.h, this.g + " doChangeRoute:, to next port" + paramm);
    }
    for (;;)
    {
      m localm2 = e();
      localm1 = paramm;
      if (localm2 == null) {
        break label64;
      }
      localm1 = paramm;
      if (!localm2.a(paramm)) {
        break label64;
      }
      com.tencent.upload.a.b.b(this.h, this.g + " isDuplicate with recent, doChangeRoute:" + paramm.toString());
      break;
      if (this.c.hasNext())
      {
        this.d = this.b.iterator();
        if (this.d.hasNext())
        {
          paramm = ((m)this.c.next()).h();
          paramm.b(((Integer)this.d.next()).intValue());
          com.tencent.upload.a.b.b(this.h, this.g + " doChangeRoute: to next ip" + paramm);
        }
        else
        {
          com.tencent.upload.a.b.d(this.h, this.g + " doChangeRoute: to next ip, but no port. exception");
          paramm = null;
        }
      }
      else
      {
        com.tencent.upload.a.b.b(this.h, this.g + " doChangeRoute: finish, return null");
        paramm = null;
      }
    }
  }
  
  private m e()
  {
    if (this.f == null) {}
    m localm;
    do
    {
      return null;
      localm = this.f.a();
      if (localm != null)
      {
        com.tencent.upload.a.b.b(this.h, this.g + " doRetrieveRecentRoute: " + localm.toString());
        return localm;
      }
      localm = this.f.b();
    } while (localm == null);
    com.tencent.upload.a.b.b(this.h, this.g + " doRetrieveRecentRoute: " + localm.toString());
    return localm;
  }
  
  private m f()
  {
    if ((!this.c.hasNext()) || (!this.d.hasNext()))
    {
      com.tencent.upload.a.b.b(this.h, this.g + " doRetrieveFirstRoute return null");
      return null;
    }
    m localm1 = (m)this.c.next();
    localm1.b(((Integer)this.d.next()).intValue());
    m localm2 = e();
    if ((localm2 != null) && (localm2.a(localm1)))
    {
      com.tencent.upload.a.b.b(this.h, this.g + " doRetrieveFirstRoute isDuplicate with recent, doChangeRoute:" + localm1.toString());
      return b(localm1);
    }
    com.tencent.upload.a.b.b(this.h, this.g + " doRetrieveFirstRoute return:" + localm1.toString());
    return localm1;
  }
  
  public boolean a(m paramm)
  {
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      com.tencent.upload.a.b.b(this.h, "save, unknown key");
      return false;
    }
    if ((str != null) && (str.length() > 0))
    {
      com.tencent.upload.a.b.b(this.h, this.g + " save: as recent:" + paramm + " recentApnKey:" + str);
      this.f = UploadConfiguration.saveAsRecentIp(d(), str, paramm);
      return true;
    }
    com.tencent.upload.a.b.b(this.h, this.g + " save: apnKey isNullOrEmpty");
    return true;
  }
  
  public m[] a()
  {
    this.j = false;
    this.a = UploadConfiguration.getUploadRoutes(d());
    if ((this.a == null) || (this.a.size() == 0)) {
      throw new RuntimeException(this.h + this.g + " doInitParams, getUploadRoutes illegel");
    }
    this.b = UploadConfiguration.getUploadRoutePorts();
    if ((this.b == null) || (this.b.size() == 0)) {
      throw new RuntimeException(this.h + this.g + " doInitParams, getUploadRoutePorts illegel");
    }
    this.c = this.a.iterator();
    this.d = this.b.iterator();
    Object localObject = new StringBuffer(this.a.size());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ((StringBuffer)localObject).append(localm.toString() + " ");
    }
    com.tencent.upload.a.b.b(this.h, this.g + " doInitParams:" + ((StringBuffer)localObject).toString());
    this.i = new ArrayList();
    int k;
    if ((this.e == null) || (this.e.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0))
    {
      k = 1;
      if (k != 0)
      {
        this.e = UploadConfiguration.getCurrentApn();
        localObject = UploadConfiguration.getRecentRouteApnKey();
        if (localObject != null) {
          break label416;
        }
        com.tencent.upload.a.b.b(this.h, this.g + " doLoadRecentRouteSet, unknown key");
      }
    }
    for (;;)
    {
      localObject = e();
      if (localObject == null) {
        break label438;
      }
      com.tencent.upload.a.b.b(this.h, this.g + " recentRoute reset: return: " + ((m)localObject).toString());
      return new m[] { localObject };
      k = 0;
      break;
      label416:
      this.f = new i(d()).a((String)localObject);
    }
    label438:
    localObject = f();
    if (localObject != null)
    {
      com.tencent.upload.a.b.b(this.h, this.g + " doRetrieveFirstRoute reset: return" + localObject);
      return new m[] { localObject };
    }
    com.tencent.upload.a.b.b(this.h, this.g + " reset: return null");
    return null;
  }
  
  public m[] a(m paramm, int paramInt)
  {
    if (paramm == null)
    {
      com.tencent.upload.a.b.b(this.h, this.g + " next: null, route == null");
      return null;
    }
    this.i.add(new a(paramm.h(), paramInt));
    boolean bool2 = UploadConfiguration.isNetworkAvailable();
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.j = bool1;
      if (bool2) {
        break;
      }
      com.tencent.upload.a.b.b(this.h, this.g + " next: null, !isNetworkAvailable");
      return null;
    }
    if ((this.e == null) || (this.e.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.j = bool1;
      if (!bool1) {
        break;
      }
      com.tencent.upload.a.b.b(this.h, this.g + " next: null, isApnChanged:true");
      return null;
    }
    m localm;
    if ((paramInt != 4) && (paramm.a() == 3))
    {
      localm = f();
      if (localm != null)
      {
        com.tencent.upload.a.b.b(this.h, this.g + " next: return" + localm);
        return new m[] { localm };
      }
    }
    label276:
    boolean bool3;
    label287:
    boolean bool4;
    if (paramm.d() != null)
    {
      bool1 = true;
      if (paramm.f() != 1) {
        break label472;
      }
      bool2 = true;
      if (paramm.f() != 2) {
        break label478;
      }
      bool3 = true;
      bool4 = UploadConfiguration.isWapSetting();
      com.tencent.upload.a.b.b(this.h, this.g + " next start: " + b.b(paramInt) + " wap:" + bool4 + " tcp:" + bool2 + " http:" + bool3 + " proxy:" + bool1);
      if (paramInt != 4) {
        break label484;
      }
      com.tencent.upload.a.b.b(this.h, this.g + " NETWORK_NDK_SOCKET_ERROR next: change route " + b.b(paramInt));
      paramm.g();
      paramm.c(1);
      paramm = b(paramm);
    }
    for (;;)
    {
      if (paramm != null) {
        break label1049;
      }
      com.tencent.upload.a.b.b(this.h, this.g + " next return: null");
      return null;
      bool1 = false;
      break;
      label472:
      bool2 = false;
      break label276;
      label478:
      bool3 = false;
      break label287;
      label484:
      if (paramInt == 0)
      {
        if ((bool4) && (bool2))
        {
          com.tencent.upload.a.b.b(this.h, this.g + " CONNECTION_FAILED next: wap tcp -> proxy http, " + b.b(paramInt));
          paramm.c(2);
          UploadConfiguration.setRouteProxy(paramm);
        }
        else
        {
          com.tencent.upload.a.b.b(this.h, this.g + " CONNECTION_FAILED next: change route " + b.b(paramInt));
          paramm.g();
          paramm.c(1);
          paramm = b(paramm);
        }
      }
      else if (paramInt == 1)
      {
        if ((bool4) && (!bool1) && (bool3))
        {
          com.tencent.upload.a.b.b(this.h, this.g + " HANDSHAKE_FAILED next: wap direct http -> proxy http " + b.b(paramInt));
          paramm.c(2);
          UploadConfiguration.setRouteProxy(paramm);
        }
        else
        {
          com.tencent.upload.a.b.b(this.h, this.g + " HANDSHAKE_FAILED next: change route " + b.b(paramInt));
          paramm.g();
          paramm.c(1);
          paramm = b(paramm);
        }
      }
      else if (paramInt == 2)
      {
        if (bool2)
        {
          com.tencent.upload.a.b.b(this.h, this.g + " UNPACKET_FAILED next: tcp -> direct http " + b.b(paramInt));
          paramm.c(2);
          paramm.g();
        }
        else if ((bool4) && (!bool1) && (bool3))
        {
          com.tencent.upload.a.b.b(this.h, this.g + " UNPACKET_FAILED next: wap direct http -> proxy http " + b.b(paramInt));
          paramm.c(2);
          UploadConfiguration.setRouteProxy(paramm);
        }
        else
        {
          com.tencent.upload.a.b.b(this.h, this.g + " UNPACKET_FAILED next: change route " + b.b(paramInt));
          paramm.g();
          paramm.c(1);
          paramm = b(paramm);
        }
      }
      else if (paramInt == 3)
      {
        while (this.d.hasNext()) {
          this.d.next();
        }
        localm = b(paramm);
        com.tencent.upload.a.b.b(this.h, this.g + " TIMEOUT_FAILED " + b.b(paramInt));
        if (localm != null)
        {
          localm.a(paramm.d(), paramm.e());
          localm.c(paramm.f());
          localm.a(paramm.a());
        }
        paramm = localm;
      }
      else
      {
        com.tencent.upload.a.b.e(this.h, this.g + " next: failureCode exception");
        paramm = null;
      }
    }
    label1049:
    com.tencent.upload.a.b.b(this.h, this.g + " next return: " + paramm.toString());
    return new m[] { paramm };
  }
  
  public final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      localStringBuffer.append(((a)localIterator.next()).toString());
    }
    return localStringBuffer.toString();
  }
  
  public final boolean c()
  {
    return this.j;
  }
  
  static final class a
  {
    private m a;
    private int b;
    
    public a(m paramm, int paramInt)
    {
      this.a = paramm;
      this.b = paramInt;
    }
    
    public final String toString()
    {
      return String.format("[%1$s, %2$s]", new Object[] { this.a.toString(), b.b(this.b) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */