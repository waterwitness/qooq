package com.tencent.biz.pubaccount;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ViewCache
{
  private static ViewCache a;
  
  private ViewCache()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = this;
  }
  
  public static ViewCache a()
  {
    if (a == null) {
      a = new ViewCache();
    }
    return a;
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    Object localObject = BaseApplicationImpl.a.get(String.valueOf(paramInt));
    if ((localObject != null) && ((localObject instanceof Drawable))) {
      localObject = (Drawable)localObject;
    }
    for (;;)
    {
      return (Drawable)localObject;
      localObject = null;
      try
      {
        paramResources = paramResources.getDrawable(paramInt);
        localObject = paramResources;
        if (paramResources == null) {
          continue;
        }
        BaseApplicationImpl.a.put(String.valueOf(paramInt), paramResources);
        return paramResources;
      }
      catch (OutOfMemoryError paramResources)
      {
        for (;;)
        {
          paramResources = (Resources)localObject;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ViewCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */