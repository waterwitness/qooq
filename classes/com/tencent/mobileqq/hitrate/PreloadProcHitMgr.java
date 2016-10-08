package com.tencent.mobileqq.hitrate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PreloadProcHitMgr
{
  public static ConcurrentHashMap a = new ConcurrentHashMap();
  public static ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    Object localObject = new HashSet();
    Iterator localIterator1 = a.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)localIterator2.next();
        localPreloadProcHitSession.d();
        ((HashSet)localObject).add(localPreloadProcHitSession.d);
      }
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      c((String)((Iterator)localObject).next());
    }
  }
  
  public static void a(PreloadProcHitSession paramPreloadProcHitSession)
  {
    String str = paramPreloadProcHitSession.a();
    ArrayList localArrayList = (ArrayList)a.get(str);
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      localArrayList.add(paramPreloadProcHitSession);
      a.put(str, localArrayList);
    }
    while (localArrayList.contains(paramPreloadProcHitSession)) {
      return;
    }
    localArrayList.add(paramPreloadProcHitSession);
  }
  
  public static void a(String paramString)
  {
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).endsWith("plugin"))
      {
        localObject = ((ArrayList)a.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)((Iterator)localObject).next();
          if (((PreloadProcHitPluginSession)localPreloadProcHitSession).a.equals(paramString))
          {
            localPreloadProcHitSession.b();
            localPreloadProcHitSession.d();
          }
        }
      }
    }
  }
  
  public static void b(PreloadProcHitSession paramPreloadProcHitSession)
  {
    Object localObject = paramPreloadProcHitSession.a();
    localObject = (ArrayList)a.get(localObject);
    if (localObject != null) {
      ((ArrayList)localObject).remove(paramPreloadProcHitSession);
    }
  }
  
  public static void b(String paramString)
  {
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(paramString))
      {
        localObject = ((ArrayList)a.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((PreloadProcHitSession)((Iterator)localObject).next()).d();
        }
      }
    }
    c(paramString);
  }
  
  public static void c(String paramString)
  {
    PreloadProcHitPluginSessionProc localPreloadProcHitPluginSessionProc = (PreloadProcHitPluginSessionProc)b.get(paramString);
    if (localPreloadProcHitPluginSessionProc != null)
    {
      localPreloadProcHitPluginSessionProc.d();
      b.remove(paramString);
    }
  }
  
  public static void d(String paramString)
  {
    paramString = (PreloadProcHitPluginSessionProc)b.get(paramString);
    if (paramString != null) {
      paramString.b();
    }
  }
  
  public static void e(String paramString)
  {
    if ((PreloadProcHitPluginSessionProc)b.get(paramString) == null)
    {
      PreloadProcHitPluginSessionProc localPreloadProcHitPluginSessionProc = new PreloadProcHitPluginSessionProc(paramString);
      b.put(paramString, localPreloadProcHitPluginSessionProc);
      localPreloadProcHitPluginSessionProc.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\hitrate\PreloadProcHitMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */