package com.tencent.mobileqq.app;

import android.app.Application;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SystemClassLoaderInjector
{
  private static Object a(Object paramObject)
  {
    return a(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  private static Object a(Object paramObject, Class paramClass, String paramString)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  private static Object a(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    Object localObject1 = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int k = Array.getLength(paramObject2);
    int i;
    label32:
    Object localObject2;
    if (paramBoolean)
    {
      i = j;
      if (!paramBoolean) {
        break label99;
      }
      k = i + k;
      localObject2 = Array.newInstance((Class)localObject1, k);
      j = 0;
      label50:
      if (j >= k) {
        break label141;
      }
      if (j >= i) {
        break label111;
      }
      if (!paramBoolean) {
        break label106;
      }
    }
    label99:
    label106:
    for (localObject1 = paramObject1;; localObject1 = paramObject2)
    {
      Array.set(localObject2, j, Array.get(localObject1, j));
      j += 1;
      break label50;
      i = k;
      break;
      k = j;
      break label32;
    }
    label111:
    if (paramBoolean) {}
    for (localObject1 = paramObject2;; localObject1 = paramObject1)
    {
      Array.set(localObject2, j, Array.get(localObject1, j - i));
      break;
    }
    label141:
    return localObject2;
  }
  
  public static String a(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramString1, paramString2, paramBoolean);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = 1;
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        if (i == 0) {
          return c(paramApplication, paramString1, paramString2, paramBoolean);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    return d(paramApplication, paramString1, paramString2, paramBoolean);
  }
  
  private static void a(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  private static Object b(Object paramObject)
  {
    return a(paramObject, paramObject.getClass(), "dexElements");
  }
  
  private static Object b(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    int k = 1;
    Object localObject1 = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int i;
    label33:
    Object localObject2;
    if (paramBoolean)
    {
      i = j;
      if (!paramBoolean) {
        break label99;
      }
      j = k;
      k = i + j;
      localObject2 = Array.newInstance((Class)localObject1, k);
      j = 0;
      label51:
      if (j >= k) {
        break label137;
      }
      if (j >= i) {
        break label107;
      }
      if (!paramBoolean) {
        break label102;
      }
    }
    label99:
    label102:
    for (localObject1 = Array.get(paramObject1, j);; localObject1 = paramObject2)
    {
      Array.set(localObject2, j, localObject1);
      j += 1;
      break label51;
      i = 1;
      break;
      break label33;
    }
    label107:
    if (paramBoolean) {}
    for (localObject1 = paramObject2;; localObject1 = Array.get(paramObject1, j - i))
    {
      Array.set(localObject2, j, localObject1);
      break;
    }
    label137:
    return localObject2;
  }
  
  private static String b(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    try
    {
      Class localClass = Class.forName("dalvik.system.LexClassLoader");
      paramApplication = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class }).newInstance(new Object[] { paramApplication.getDir("dex", 0).getAbsolutePath() + File.separator + str, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader });
      paramString1 = localClass.getMethod("loadClass", new Class[] { String.class });
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.invoke(paramApplication, new Object[] { paramString2 });
      }
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, localClass, "mRawDexPath"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, localClass, "mFiles"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, localClass, "mZips"), paramBoolean));
      a(localPathClassLoader, PathClassLoader.class, "mLexs", a(a(localPathClassLoader, PathClassLoader.class, "mLexs"), a(paramApplication, localClass, "mDexs"), paramBoolean));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "injectInAliyunOs error: " + Log.getStackTraceString(paramApplication);
  }
  
  private static String c(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    if ((TextUtils.isEmpty(paramString2)) || ("com.tencent.mobileqq.hotpatch.NotVerifyClass".equals(paramString2))) {}
    for (paramApplication = new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());; paramApplication = DexClassLoaderUtil.createDexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader())) {
      try
      {
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramString1 = paramApplication.getClass().getDeclaredMethod("ensureInit", new Class[0]);
          paramString1.setAccessible(true);
          paramString1.invoke(paramApplication, new Object[0]);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          paramApplication.loadClass(paramString2);
        }
        a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, DexClassLoader.class, "mRawDexPath"), paramBoolean));
        a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, DexClassLoader.class, "mFiles"), paramBoolean));
        a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, DexClassLoader.class, "mZips"), paramBoolean));
        a(localPathClassLoader, PathClassLoader.class, "mDexs", a(a(localPathClassLoader, PathClassLoader.class, "mDexs"), a(paramApplication, DexClassLoader.class, "mDexs"), paramBoolean));
        return "Success";
      }
      catch (Throwable paramApplication)
      {
        paramApplication.printStackTrace();
      }
    }
    return "injectBelowApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
  
  private static String d(Application paramApplication, String paramString1, String paramString2, boolean paramBoolean)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    if ((TextUtils.isEmpty(paramString2)) || ("com.tencent.mobileqq.hotpatch.NotVerifyClass".equals(paramString2))) {}
    for (paramApplication = new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());; paramApplication = DexClassLoaderUtil.createDexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader())) {
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {
          paramApplication.loadClass(paramString2);
        }
        paramApplication = a(b(a(localPathClassLoader)), b(a(paramApplication)), paramBoolean);
        paramString1 = a(localPathClassLoader);
        a(paramString1, paramString1.getClass(), "dexElements", paramApplication);
        return "Success";
      }
      catch (Throwable paramApplication) {}
    }
    return "injectAboveEqualApiLevel14 error: " + Log.getStackTraceString(null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\SystemClassLoaderInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */