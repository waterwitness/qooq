package com.sixgod.pluginsdk.apkmanager;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Window;
import com.sixgod.pluginsdk.a.d;
import com.sixgod.pluginsdk.a.e;
import com.sixgod.pluginsdk.a.f;
import com.sixgod.pluginsdk.a.g;
import com.sixgod.pluginsdk.common.Constants;
import com.sixgod.pluginsdk.exception.SixGodException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
{
  Context a;
  com.sixgod.pluginsdk.a.a b;
  HashMap c;
  HashMap d;
  public HashMap e;
  public HashMap f;
  Object g;
  protected ClassLoader h;
  
  public a(Context paramContext, com.sixgod.pluginsdk.a.a parama, ClassLoader paramClassLoader)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.f = new HashMap();
    this.h = paramClassLoader;
  }
  
  private Application a(ApplicationInfo paramApplicationInfo, ClassLoader paramClassLoader, Object paramObject)
  {
    if (paramApplicationInfo.className == null) {
      paramApplicationInfo.className = "android.app.Application";
    }
    boolean bool = false;
    Object localObject1 = this.b.aq.a(null);
    if (localObject1 != null)
    {
      localObject2 = this.b.M.a(localObject1, new Object[] { paramObject, null, this.g });
      if ((localObject2 instanceof Exception)) {
        bool = false;
      }
    }
    for (Object localObject2 = "result = " + localObject2 + " contextObj = " + localObject1;; localObject2 = "")
    {
      if ((localObject1 == null) || (!bool))
      {
        localObject1 = this.b.R.a(null, new Object[] { this.g, paramObject });
        localObject2 = (String)localObject2 + "createAppContext";
        new StringBuilder().append((String)localObject2).append(" & ContextImpl.class constructor = ").append(e.a(this.b.j.b));
      }
      if ((localObject1 == null) || ((localObject1 instanceof Exception)) || ((localObject1 instanceof Boolean))) {
        localObject1 = this.b.aU.a(this.a);
      }
      for (int i = 1;; i = 0)
      {
        if ((Constants.ANDROID_VERSION > 10) && (i == 0)) {
          this.b.bf.a(localObject1, this.a.getPackageName());
        }
        if (i != 0)
        {
          localObject2 = paramApplicationInfo.packageName;
          localObject2 = (c)this.e.get(localObject2);
          localObject2 = new SixGodAppContext((Context)localObject1, paramApplicationInfo.packageName, paramClassLoader, ((c)localObject2).k.a(), ((c)localObject2).k.b(), this.a);
        }
        for (;;)
        {
          try
          {
            paramApplicationInfo = (Application)paramClassLoader.loadClass(paramApplicationInfo.className).newInstance();
          }
          catch (Exception paramClassLoader)
          {
            paramApplicationInfo = null;
          }
          try
          {
            this.b.Q.a(paramApplicationInfo, new Object[] { localObject2 });
            if (paramApplicationInfo != null) {
              break label443;
            }
            throw new SixGodException("app null");
          }
          catch (Exception paramClassLoader)
          {
            for (;;) {}
          }
          if (!(localObject2 instanceof Boolean)) {
            break;
          }
          bool = ((Boolean)localObject2).booleanValue();
          break;
          localObject2 = new SixGodAppContext((Context)localObject1, paramApplicationInfo.packageName, this.a);
          continue;
          paramClassLoader.printStackTrace();
        }
        label443:
        this.b.aU.a(paramApplicationInfo, localObject2);
        this.b.bi.a(paramApplicationInfo, paramObject);
        if (i == 0) {
          this.b.N.a(localObject1, new Object[] { paramApplicationInfo });
        }
        this.b.bi.a(localObject2, paramObject);
        ((ArrayList)this.b.aS.a(this.g)).add(paramApplicationInfo);
        return paramApplicationInfo;
      }
      bool = false;
    }
  }
  
  private PackageInfo a(String paramString, Object paramObject, ApplicationInfo paramApplicationInfo, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int j = 0;
    PackageInfo localPackageInfo = new PackageInfo();
    localPackageInfo.applicationInfo = paramApplicationInfo;
    localPackageInfo.packageName = paramString;
    paramString = (Integer)this.b.aE.a(paramObject);
    if (paramString != null) {
      localPackageInfo.versionCode = paramString.intValue();
    }
    localPackageInfo.versionName = ((String)this.b.aF.a(paramObject));
    localPackageInfo.sharedUserId = ((String)this.b.aG.a(paramObject));
    paramString = (Integer)this.b.aH.a(paramObject);
    if (paramString != null) {
      localPackageInfo.sharedUserLabel = paramString.intValue();
    }
    int i;
    if (paramArrayList1.size() > 0)
    {
      paramString = new ActivityInfo[paramArrayList1.size()];
      i = 0;
      while (i < paramArrayList1.size())
      {
        paramString[i] = ((ActivityInfo)paramArrayList1.get(i));
        i += 1;
      }
      localPackageInfo.activities = paramString;
    }
    paramString = (ArrayList)this.b.aZ.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new ActivityInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramArrayList1 = paramString.get(i);
        paramApplicationInfo[i] = ((ActivityInfo)this.b.aC.a(paramArrayList1));
        i += 1;
      }
      localPackageInfo.receivers = paramApplicationInfo;
    }
    if (paramArrayList2.size() > 0)
    {
      paramString = new ServiceInfo[paramArrayList2.size()];
      i = 0;
      while (i < paramArrayList2.size())
      {
        paramString[i] = ((ServiceInfo)paramArrayList2.get(i));
        i += 1;
      }
      localPackageInfo.services = paramString;
    }
    paramString = (ArrayList)this.b.aA.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new ProviderInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((ProviderInfo)this.b.bj.a(paramString.get(i)));
        i += 1;
      }
      localPackageInfo.providers = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aJ.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new InstrumentationInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((InstrumentationInfo)this.b.bk.a(paramString.get(i)));
        i += 1;
      }
      localPackageInfo.instrumentation = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aL.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new ConfigurationInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((ConfigurationInfo)paramString.get(i));
        i += 1;
      }
      localPackageInfo.configPreferences = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aM.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new FeatureInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((FeatureInfo)paramString.get(i));
        i += 1;
      }
      localPackageInfo.reqFeatures = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aB.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new PermissionInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((PermissionInfo)this.b.bl.a(paramString.get(i)));
        i += 1;
      }
      localPackageInfo.permissions = paramApplicationInfo;
    }
    paramString = (List)this.b.aK.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramObject = new String[paramString.size()];
      i = j;
      while (i < paramString.size())
      {
        paramObject[i] = ((String)paramString.get(i));
        i += 1;
      }
      localPackageInfo.requestedPermissions = ((String[])paramObject);
    }
    localPackageInfo.signatures = c();
    return localPackageInfo;
  }
  
  private Object a(ApplicationInfo paramApplicationInfo)
  {
    Object localObject1;
    Object localObject2;
    if (this.b.aj.a())
    {
      localObject1 = this.g;
      localObject2 = this.g;
      paramApplicationInfo = this.b.aj.a(new Object[] { localObject1, paramApplicationInfo, localObject2, null, Boolean.valueOf(false), Boolean.valueOf(true) });
      com.sixgod.pluginsdk.log.a.a("use conLoadedApkV10");
      return paramApplicationInfo;
    }
    if (this.b.ak.a())
    {
      localObject1 = this.g;
      paramApplicationInfo = this.b.ak.a(new Object[] { localObject1, paramApplicationInfo, null, null, Boolean.valueOf(true), Boolean.valueOf(false) });
      com.sixgod.pluginsdk.log.a.a("use conLoadedApkV19s");
      return paramApplicationInfo;
    }
    if (this.b.al.a())
    {
      localObject1 = this.g;
      localObject2 = this.g;
      paramApplicationInfo = this.b.al.a(new Object[] { localObject1, paramApplicationInfo, null, localObject2, null, Boolean.valueOf(false), Boolean.valueOf(true) });
      com.sixgod.pluginsdk.log.a.a("use conLoadedApkV19");
      return paramApplicationInfo;
    }
    if (this.b.am.a())
    {
      localObject1 = this.g;
      paramApplicationInfo = this.b.am.a(new Object[] { localObject1, paramApplicationInfo, null, null, Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false) });
      com.sixgod.pluginsdk.log.a.a("use conLoadedApkV20");
      return paramApplicationInfo;
    }
    Object localObject3;
    if (this.b.an.a())
    {
      localObject1 = this.g;
      localObject2 = paramApplicationInfo.packageName;
      localObject3 = this.a.getApplicationContext();
      localObject1 = this.b.an.a(new Object[] { localObject1, localObject2, localObject3, paramApplicationInfo });
      com.sixgod.pluginsdk.log.a.a("use conLoadedApkV10a");
    }
    for (;;)
    {
      this.b.bn.a(localObject1, paramApplicationInfo.sourceDir);
      this.b.br.a(localObject1, paramApplicationInfo);
      this.b.aw.a(localObject1, paramApplicationInfo.packageName);
      this.b.av.a(localObject1, paramApplicationInfo.sourceDir);
      this.b.bo.a(localObject1, paramApplicationInfo.dataDir);
      if (paramApplicationInfo.dataDir != null) {
        this.b.bp.a(localObject1, new File(paramApplicationInfo.dataDir));
      }
      this.b.bq.a(localObject1, paramApplicationInfo.nativeLibraryDir);
      return localObject1;
      if (this.b.ap.a())
      {
        localObject1 = this.g;
        localObject2 = this.a.getApplicationContext();
        localObject3 = paramApplicationInfo.packageName;
        localObject1 = this.b.ap.a(new Object[] { localObject1, localObject2, localObject3, paramApplicationInfo, null });
        com.sixgod.pluginsdk.log.a.a("use conLoadedApkV19a");
      }
      else
      {
        if (!this.b.ao.a()) {
          break;
        }
        localObject1 = this.g;
        localObject1 = this.b.ao.a(new Object[] { localObject1 });
        com.sixgod.pluginsdk.log.a.a("use conLoadedApkV19sa");
      }
    }
    com.sixgod.pluginsdk.log.a.b("new LoadedApk failed!");
    return null;
  }
  
  private c b(String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    com.sixgod.pluginsdk.log.a.a("loadApkV2 :apkPath = " + paramString1 + " resourceFlags = " + paramInt + "needLibs = " + paramBoolean1 + "defaultUseActionBar = " + paramBoolean2 + ", verName=" + paramString2);
    long l = System.currentTimeMillis();
    PackageInfo localPackageInfo = this.a.getPackageManager().getPackageArchiveInfo(paramString1, 20885);
    if (localPackageInfo == null)
    {
      paramString2 = b(new File(paramString1));
      com.sixgod.pluginsdk.log.a.b("PackageInfo null! " + paramString2);
      throw new SixGodException("parsepackage failed! + apkPath = " + paramString1 + ";" + paramString2);
    }
    localPackageInfo.signatures = c();
    Object localObject1 = null;
    Object localObject3 = localPackageInfo.activities;
    int k = localObject3.length;
    int i = 0;
    int j = 0;
    Object localObject4;
    Object localObject2;
    if (i < k)
    {
      localObject4 = localObject3[i];
      com.sixgod.pluginsdk.log.a.a("load apk parse activity pkg = " + ((ActivityInfo)localObject4).packageName + " className = " + ((ActivityInfo)localObject4).name);
      localObject2 = new ComponentName(((ActivityInfo)localObject4).packageName, ((ActivityInfo)localObject4).name);
      this.c.put(localObject2, localObject4);
      if (j != 0) {
        break label1020;
      }
      j = 1;
      localObject1 = localObject2;
    }
    label1020:
    for (;;)
    {
      i += 1;
      break;
      localObject2 = localPackageInfo.services;
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        com.sixgod.pluginsdk.log.a.a("load apk parse service pkg = " + ((ServiceInfo)localObject3).packageName + " className = " + ((ServiceInfo)localObject3).name);
        localObject4 = new ComponentName(((ServiceInfo)localObject3).packageName, ((ServiceInfo)localObject3).name);
        this.d.put(localObject4, localObject3);
        i += 1;
      }
      ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
      localApplicationInfo.sourceDir = paramString1;
      localApplicationInfo.uid = this.a.getApplicationInfo().uid;
      localApplicationInfo.dataDir = com.sixgod.pluginsdk.common.a.b(this.a, localApplicationInfo.packageName);
      localApplicationInfo.publicSourceDir = paramString1;
      localApplicationInfo.processName = this.a.getApplicationInfo().processName;
      if (this.g == null) {
        this.g = this.b.s.a(null, null);
      }
      com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.parseApk dtime =  " + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      localObject4 = a(localApplicationInfo);
      com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.newLoadedApk dtime = " + (System.currentTimeMillis() - l));
      String str1 = (String)this.b.aw.a(localObject4);
      if (this.e.containsKey(str1)) {
        return null;
      }
      l = System.currentTimeMillis();
      String str2 = com.sixgod.pluginsdk.common.a.b(this.a, str1, paramString2);
      localObject3 = (DexClassLoader)com.sixgod.pluginsdk.a.a(str1);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = str2 + File.pathSeparator + this.a.getApplicationInfo().dataDir + "/lib";
        paramString2 = com.sixgod.pluginsdk.common.a.a(this.a, str1, paramString2);
        localObject3 = new File(paramString2);
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject2 = new DexClassLoader(paramString1, paramString2, (String)localObject2, this.h);
        com.sixgod.pluginsdk.a.a(str1, (ClassLoader)localObject2);
      }
      this.b.au.a(localObject4, localObject2);
      com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.classLoader dtime = " + (System.currentTimeMillis() - l));
      paramString2 = new PluginResources(this.a, paramInt, paramString1);
      this.b.aN.a(localObject4, paramString2.a());
      if (Build.VERSION.SDK_INT >= 9)
      {
        localApplicationInfo.nativeLibraryDir = str2;
        com.sixgod.pluginsdk.log.a.a("after nativeLibraryDir = " + localApplicationInfo.nativeLibraryDir);
      }
      localObject3 = new c(this);
      ((c)localObject3).h = null;
      ((c)localObject3).c = localApplicationInfo;
      ((c)localObject3).b = ((ClassLoader)localObject2);
      ((c)localObject3).d = localObject4;
      ((c)localObject3).f = ((ComponentName)localObject1);
      ((c)localObject3).g = paramBoolean2;
      ((c)localObject3).i = paramString1;
      ((c)localObject3).j = localPackageInfo;
      ((c)localObject3).k = paramString2;
      ((c)localObject3).a = str1;
      com.sixgod.pluginsdk.log.a.a("insert pluginAppInfo pkg = " + str1);
      this.e.put(str1, localObject3);
      l = System.currentTimeMillis();
      paramString1 = a(localApplicationInfo, (ClassLoader)localObject2, localObject4);
      this.b.bg.a(localObject4, paramString1);
      com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.createApp dtime = " + (System.currentTimeMillis() - l));
      ((c)localObject3).e = paramString1;
      return (c)localObject3;
    }
  }
  
  /* Error */
  private static String b(File paramFile)
  {
    // Byte code:
    //   0: new 633	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 634	java/lang/StringBuffer:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: new 75	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 636
    //   16: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 639	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: aload_3
    //   34: new 75	java/lang/StringBuilder
    //   37: dup
    //   38: ldc_w 644
    //   41: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 647	java/io/File:length	()J
    //   48: invokevirtual 533	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: pop
    //   58: aload_3
    //   59: new 75	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 649
    //   66: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokestatic 653	com/sixgod/pluginsdk/b/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   73: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload_3
    //   84: new 75	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 655
    //   91: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: invokestatic 656	com/sixgod/pluginsdk/b/a:b	(Ljava/io/File;)Ljava/lang/String;
    //   98: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   107: pop
    //   108: new 658	java/util/zip/ZipFile
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 661	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   116: astore_1
    //   117: aload_1
    //   118: astore_0
    //   119: aload_3
    //   120: new 75	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 663
    //   127: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 664	java/util/zip/ZipFile:size	()I
    //   134: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload_1
    //   145: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   148: new 75	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 669
    //   155: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload_3
    //   159: invokevirtual 670	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   162: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore_0
    //   169: aload_0
    //   170: invokestatic 371	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   180: goto -72 -> 108
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   188: goto -40 -> 148
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: astore_0
    //   196: aload_2
    //   197: invokevirtual 672	java/util/zip/ZipException:printStackTrace	()V
    //   200: aload_1
    //   201: ifnull -53 -> 148
    //   204: aload_1
    //   205: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   208: goto -60 -> 148
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   216: goto -68 -> 148
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: astore_0
    //   224: aload_2
    //   225: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   228: aload_1
    //   229: ifnull -81 -> 148
    //   232: aload_1
    //   233: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   236: goto -88 -> 148
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   244: goto -96 -> 148
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_0
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   258: aload_1
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   265: goto -7 -> 258
    //   268: astore_1
    //   269: goto -19 -> 250
    //   272: astore_2
    //   273: goto -51 -> 222
    //   276: astore_2
    //   277: goto -83 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramFile	File
    //   116	29	1	localZipFile	java.util.zip.ZipFile
    //   175	2	1	localIOException1	java.io.IOException
    //   193	40	1	localObject1	Object
    //   247	12	1	localObject2	Object
    //   268	1	1	localObject3	Object
    //   191	6	2	localZipException1	java.util.zip.ZipException
    //   219	6	2	localIOException2	java.io.IOException
    //   272	1	2	localIOException3	java.io.IOException
    //   276	1	2	localZipException2	java.util.zip.ZipException
    //   7	152	3	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   83	108	175	java/io/IOException
    //   144	148	183	java/io/IOException
    //   108	117	191	java/util/zip/ZipException
    //   204	208	211	java/io/IOException
    //   108	117	219	java/io/IOException
    //   232	236	239	java/io/IOException
    //   108	117	247	finally
    //   254	258	260	java/io/IOException
    //   119	144	268	finally
    //   196	200	268	finally
    //   224	228	268	finally
    //   119	144	272	java/io/IOException
    //   119	144	276	java/util/zip/ZipException
  }
  
  private Signature[] c()
  {
    Object localObject = this.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(this.a.getPackageName(), 64).signatures;
      return (Signature[])localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return null;
  }
  
  public final Activity a(ActivityInfo paramActivityInfo, Intent paramIntent, Bundle paramBundle, ClassLoader paramClassLoader, IBinder paramIBinder, Activity paramActivity)
  {
    Object localObject2 = paramIntent.getComponent();
    String str = ((ComponentName)localObject2).getPackageName();
    c localc = (c)this.e.get(str);
    Object localObject1 = (c)this.e.get(str);
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = this.g;
    }
    for (;;)
    {
      Object localObject4;
      Activity localActivity;
      Application localApplication;
      Object localObject5;
      boolean bool;
      int i;
      try
      {
        localObject4 = this.b.aT.a(localObject3);
        localActivity = (Activity)this.b.V.a(localObject4, new Object[] { paramClassLoader, ((ComponentName)localObject2).getClassName(), paramIntent });
        localApplication = localc.e;
        localObject2 = localActivity;
        if (localActivity == null) {
          break label1361;
        }
        localObject2 = this.b.aq.a(null);
        if (localObject2 == null) {
          break label1516;
        }
        localObject5 = this.b.M.a(localObject2, new Object[] { localObject1, null, localObject3 });
        if (!(localObject5 instanceof Exception)) {
          break label687;
        }
        bool = false;
        if ((localObject2 != null) && (bool)) {
          break label827;
        }
        if (!this.b.S.a()) {
          break label708;
        }
        localObject1 = this.b.S.a(null, new Object[] { localObject3, localObject1, paramIBinder });
        if ((localObject1 != null) && (!(localObject1 instanceof Exception)) && (!(localObject1 instanceof Boolean))) {
          break label834;
        }
        localObject1 = paramActivity.getBaseContext();
        com.sixgod.pluginsdk.log.a.a("startActivityNow use default context");
        i = 1;
        localObject2 = paramActivityInfo.loadLabel((PackageManager)this.b.W.a(localObject1, null));
        localObject5 = new Configuration((Configuration)this.b.bc.a(localObject3));
        com.sixgod.pluginsdk.log.a.a("context = " + localObject1);
        if (i == 0) {
          break label862;
        }
        com.sixgod.pluginsdk.log.a.a("use default!");
        paramClassLoader = new SixGodContext((Context)localObject1, str, paramClassLoader, localc.k.a(), localc.k.b(), this, this.a);
        if (!this.b.X.a()) {
          break label886;
        }
        this.b.X.a(localActivity, new Object[] { paramClassLoader, localObject3, localObject4, paramIBinder, localApplication, paramIntent, paramActivityInfo, localObject2, null, paramActivityInfo.targetActivity, null, localObject5 });
        this.b.aU.a(localActivity, paramClassLoader);
        this.b.aV.a(localActivity, paramClassLoader);
        this.b.bd.a(localActivity, Boolean.valueOf(false));
        i = paramActivityInfo.getThemeResource();
        if (i != 0) {
          localActivity.setTheme(i);
        }
        bool = ((c)this.e.get(str)).g;
        if (!bool) {
          this.b.L.a(localActivity, new Object[] { paramActivity });
        }
        this.b.be.a(localActivity, Boolean.valueOf(false));
        paramActivityInfo = this.b.ad.a(localObject4, new Object[] { localActivity, paramBundle });
        if (!(paramActivityInfo instanceof Exception)) {
          break label1341;
        }
        throw ((Exception)paramActivityInfo);
      }
      catch (Exception paramActivityInfo)
      {
        throw new SixGodException("new Activity failed , e = " + paramActivityInfo.getMessage());
      }
      localObject1 = ((c)localObject1).d;
      break;
      label687:
      if ((localObject5 instanceof Boolean))
      {
        bool = ((Boolean)localObject5).booleanValue();
        continue;
        label708:
        if (this.b.T.a())
        {
          localObject1 = this.b.T.a(null, new Object[] { localObject3, localObject1, Integer.valueOf(0), null });
        }
        else if (this.b.U.a())
        {
          localObject1 = this.b.U.a(null, new Object[] { localObject3, localObject1, paramIBinder, Integer.valueOf(0), null });
        }
        else
        {
          com.sixgod.pluginsdk.log.a.a("createActivityContext failed!");
          label827:
          localObject1 = localObject2;
          continue;
          label834:
          this.b.N.a(localObject1, new Object[] { localActivity });
          i = 0;
          continue;
          label862:
          paramClassLoader = new SixGodContext((Context)localObject1, str, this, this.a);
          continue;
          label886:
          if (this.b.Y.a())
          {
            this.b.Y.a(localActivity, new Object[] { paramClassLoader, localObject3, localObject4, paramIBinder, localApplication, paramIntent, paramActivityInfo, localObject2, null, paramActivityInfo.targetActivity, null, localObject5 });
          }
          else if (this.b.Z.a())
          {
            this.b.Z.a(localActivity, new Object[] { paramClassLoader, localObject3, localObject4, paramIBinder, Integer.valueOf(0), localApplication, paramIntent, paramActivityInfo, localObject2, null, paramActivityInfo.targetActivity, null, localObject5, null });
          }
          else if (this.b.aa.a())
          {
            this.b.aa.a(localActivity, new Object[] { paramClassLoader, localObject3, localObject4, paramIBinder, Integer.valueOf(0), localApplication, paramIntent, paramActivityInfo, localObject2, null, paramActivityInfo.targetActivity, null, localObject5, null, null });
          }
          else if (this.b.ab.a())
          {
            this.b.ab.a(localActivity, new Object[] { paramClassLoader, localObject3, localObject4, paramIBinder, Integer.valueOf(0), localApplication, paramIntent, paramActivityInfo, localObject2, null, paramActivityInfo.targetActivity, null, localObject5, null, null, null });
          }
          else
          {
            com.sixgod.pluginsdk.log.a.b("Activity attach failed!");
            continue;
            label1341:
            if (((paramActivityInfo instanceof Boolean)) && (!((Boolean)paramActivityInfo).booleanValue()))
            {
              localObject2 = null;
              label1361:
              return (Activity)localObject2;
            }
            try
            {
              if ((Constants.ANDROID_VERSION <= 20) && (Constants.ANDROID_VERSION >= 11)) {
                if ((localActivity.getWindow().hasFeature(8)) && (localActivity.getActionBar() == null)) {
                  this.b.af.a(localActivity, null);
                }
              }
              for (;;)
              {
                if (bool) {
                  this.b.L.a(localActivity, new Object[] { paramActivity });
                }
                this.b.t.a(localActivity, null);
                return localActivity;
                if ((Constants.ANDROID_VERSION > 20) && (localActivity.getWindow().hasFeature(8)) && (localActivity.getActionBar() == null)) {
                  this.b.ag.a(localActivity, null);
                }
              }
            }
            catch (Exception paramActivityInfo)
            {
              for (;;)
              {
                com.sixgod.pluginsdk.log.a.b(paramActivityInfo.getMessage());
              }
            }
          }
        }
      }
      else
      {
        label1516:
        bool = false;
      }
    }
  }
  
  public final ActivityInfo a(ComponentName paramComponentName)
  {
    return (ActivityInfo)this.c.get(paramComponentName);
  }
  
  public final c a(String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    com.sixgod.pluginsdk.log.a.a("loadApk :apkPath = " + paramString1 + " resourceFlags = " + paramInt + "needLibs = " + paramBoolean1 + "defaultUseActionBar = " + paramBoolean2 + ", verName=" + paramString2);
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      throw new SixGodException("apk file not exists! apkPath = " + paramString1);
    }
    new b(this, (File)localObject1).start();
    long l = System.currentTimeMillis();
    localObject1 = null;
    if (this.b.ah.a())
    {
      localObject1 = this.b.ah.a(new Object[] { paramString1 });
      localObject2 = null;
      if (localObject1 == null) {
        break label369;
      }
      if (!this.b.q.a()) {
        break label304;
      }
      localObject1 = this.b.q.a(localObject1, new Object[] { new File(paramString1), null, this.a.getResources().getDisplayMetrics(), Integer.valueOf(2) });
    }
    for (;;)
    {
      if ((localObject1 != null) && (!(localObject1 instanceof Exception)) && (!(localObject1 instanceof Boolean))) {
        break label382;
      }
      return b(paramString1, paramInt, paramBoolean1, paramBoolean2, paramString2);
      if (this.b.ai.a())
      {
        localObject1 = this.b.ai.a(null);
        break;
      }
      com.sixgod.pluginsdk.log.a.b("new PackageParser failed!");
      break;
      label304:
      if (this.b.r.a())
      {
        localObject1 = this.b.r.a(localObject1, new Object[] { new File(paramString1), Integer.valueOf(2) });
      }
      else
      {
        com.sixgod.pluginsdk.log.a.b("reflect failed!");
        localObject1 = localObject2;
        continue;
        label369:
        com.sixgod.pluginsdk.log.a.b("packageParserObj null");
        localObject1 = localObject2;
      }
    }
    label382:
    Object localObject3 = (ArrayList)this.b.ay.a(localObject1);
    Object localObject5 = new ArrayList();
    Object localObject2 = null;
    Object localObject4 = ((ArrayList)localObject3).iterator();
    Object localObject6;
    Object localObject7;
    Object localObject8;
    if (((Iterator)localObject4).hasNext())
    {
      localObject6 = ((Iterator)localObject4).next();
      localObject7 = (ActivityInfo)this.b.aC.a(localObject6);
      com.sixgod.pluginsdk.log.a.a("load apk parse activity pkg = " + ((ActivityInfo)localObject7).packageName + " className = " + ((ActivityInfo)localObject7).name);
      localObject3 = new ComponentName(((ActivityInfo)localObject7).packageName, ((ActivityInfo)localObject7).name);
      this.c.put(localObject3, localObject7);
      ((ArrayList)localObject5).add(localObject7);
      localObject6 = (ArrayList)this.b.aW.a(localObject6);
      if ((localObject2 != null) || (localObject6 == null) || (((ArrayList)localObject6).size() <= 0)) {
        break label1548;
      }
      localObject7 = ((ArrayList)localObject6).iterator();
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = (IntentFilter)((Iterator)localObject7).next();
        localObject8 = (ArrayList)this.b.aX.a(localObject8);
        if ((localObject8 != null) && (((ArrayList)localObject8).contains("android.intent.category.LAUNCHER"))) {
          localObject2 = localObject3;
        }
      }
    }
    label1548:
    for (;;)
    {
      this.f.put(localObject3, localObject6);
      break;
      localObject6 = new ArrayList();
      localObject3 = ((ArrayList)this.b.az.a(localObject1)).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject4 = (ServiceInfo)this.b.aD.a(localObject4);
        com.sixgod.pluginsdk.log.a.a("load apk parse service pkg = " + ((ServiceInfo)localObject4).packageName + " className = " + ((ServiceInfo)localObject4).name);
        localObject7 = new ComponentName(((ServiceInfo)localObject4).packageName, ((ServiceInfo)localObject4).name);
        this.d.put(localObject7, localObject4);
        ((ArrayList)localObject6).add(localObject4);
      }
      localObject8 = (ApplicationInfo)this.b.ar.a(localObject1);
      ((ApplicationInfo)localObject8).sourceDir = paramString1;
      ((ApplicationInfo)localObject8).uid = this.a.getApplicationInfo().uid;
      ((ApplicationInfo)localObject8).dataDir = com.sixgod.pluginsdk.common.a.b(this.a, ((ApplicationInfo)localObject8).packageName);
      ((ApplicationInfo)localObject8).publicSourceDir = paramString1;
      ((ApplicationInfo)localObject8).metaData = ((Bundle)this.b.aI.a(localObject1));
      ((ApplicationInfo)localObject8).processName = this.a.getApplicationInfo().processName;
      if (this.g == null) {
        this.g = this.b.s.a(null, null);
      }
      com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.parseApk dtime =  " + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      localObject7 = a((ApplicationInfo)localObject8);
      com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.newLoadedApk dtime = " + (System.currentTimeMillis() - l));
      localObject3 = (String)this.b.aw.a(localObject7);
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if ((TextUtils.isEmpty(((ApplicationInfo)localObject8).packageName)) && (localObject2 != null))
        {
          ((ApplicationInfo)localObject8).packageName = ((ComponentName)localObject2).getPackageName();
          localObject3 = ((ComponentName)localObject2).getPackageName();
        }
      }
      while (this.e.containsKey(localObject3))
      {
        return null;
        localObject3 = ((ApplicationInfo)localObject8).packageName;
        continue;
        if (TextUtils.isEmpty(((ApplicationInfo)localObject8).packageName)) {
          ((ApplicationInfo)localObject8).packageName = ((String)localObject3);
        }
      }
      l = System.currentTimeMillis();
      String str = com.sixgod.pluginsdk.common.a.b(this.a, (String)localObject3, paramString2);
      localObject4 = (DexClassLoader)com.sixgod.pluginsdk.a.a((String)localObject3);
      if (localObject4 == null)
      {
        localObject4 = str + File.pathSeparator + this.a.getApplicationInfo().dataDir + "/lib";
        paramString2 = com.sixgod.pluginsdk.common.a.a(this.a, (String)localObject3, paramString2);
        File localFile = new File(paramString2);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramString2 = new DexClassLoader(paramString1, paramString2, (String)localObject4, this.h);
        com.sixgod.pluginsdk.a.a((String)localObject3, paramString2);
      }
      for (;;)
      {
        this.b.au.a(localObject7, paramString2);
        com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.classLoader dtime = " + (System.currentTimeMillis() - l));
        localObject4 = new PluginResources(this.a, paramInt, paramString1);
        this.b.aN.a(localObject7, ((PluginResources)localObject4).a());
        if (Build.VERSION.SDK_INT >= 9)
        {
          ((ApplicationInfo)localObject8).nativeLibraryDir = str;
          com.sixgod.pluginsdk.log.a.a("nativeLibraryDir = " + ((ApplicationInfo)localObject8).nativeLibraryDir);
        }
        localObject6 = a((String)localObject3, localObject1, (ApplicationInfo)localObject8, (ArrayList)localObject5, (ArrayList)localObject6);
        localObject5 = new c(this);
        ((c)localObject5).h = ((ArrayList)this.b.aZ.a(localObject1));
        ((c)localObject5).c = ((ApplicationInfo)localObject8);
        ((c)localObject5).b = paramString2;
        ((c)localObject5).d = localObject7;
        ((c)localObject5).f = ((ComponentName)localObject2);
        ((c)localObject5).g = paramBoolean2;
        ((c)localObject5).i = paramString1;
        ((c)localObject5).j = ((PackageInfo)localObject6);
        ((c)localObject5).k = ((PluginResources)localObject4);
        ((c)localObject5).a = ((String)localObject3);
        com.sixgod.pluginsdk.log.a.a("insert pluginAppInfo pkg = " + (String)localObject3);
        this.e.put(localObject3, localObject5);
        l = System.currentTimeMillis();
        paramString1 = a((ApplicationInfo)localObject8, paramString2, localObject7);
        this.b.bg.a(localObject7, paramString1);
        com.sixgod.pluginsdk.log.a.a("ODPerf", "loadedApk.createApp dtime = " + (System.currentTimeMillis() - l));
        ((c)localObject5).e = paramString1;
        return (c)localObject5;
        paramString2 = (String)localObject4;
      }
    }
  }
  
  public final Object a()
  {
    return this.g;
  }
  
  public final void a(String paramString)
  {
    com.sixgod.pluginsdk.log.a.a("unLaunch");
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (c)this.e.remove(paramString);
      if (localObject != null)
      {
        com.sixgod.pluginsdk.log.a.a("unLaunch appInfo call onTerminate!");
        ((c)localObject).e.onTerminate();
      }
      localObject = new ArrayList();
      Iterator localIterator = this.c.keySet().iterator();
      ComponentName localComponentName;
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        if (localComponentName.getPackageName().equals(paramString)) {
          ((List)localObject).add(localComponentName);
        }
      }
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        this.c.remove(localComponentName);
      }
      ((List)localObject).clear();
      localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        if (localComponentName.getPackageName().equals(paramString)) {
          ((List)localObject).add(localComponentName);
        }
      }
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        this.d.remove(localComponentName);
      }
      ((List)localObject).clear();
      localIterator = this.f.keySet().iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        if (localComponentName.getPackageName().equals(paramString)) {
          ((List)localObject).add(localComponentName);
        }
      }
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (ComponentName)paramString.next();
        this.f.remove(localObject);
      }
    }
  }
  
  public final void b()
  {
    if (this.g == null) {
      this.g = this.b.s.a(null, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\apkmanager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */