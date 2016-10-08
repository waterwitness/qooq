package cooperation.qzone.font;

import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.util.Singleton;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import yma;
import ymb;
import ymc;
import ymd;
import yme;
import ymf;

public class FontManager
{
  public static final int a = 1000;
  private static final Singleton jdField_a_of_type_ComTencentMobileqqLyricUtilSingleton = new yma();
  private static FileCacheService jdField_a_of_type_CooperationQzoneCacheFileCacheService;
  static final String jdField_a_of_type_JavaLangString = "FontManager";
  public static final String b = "http://qzonestyle.gtimg.cn/qzone/space_item/qzone_act/ziti/HYMiaoXJJF.zip";
  public static final String c = ".ttf";
  public static final String d = ".ftf";
  protected ETEngine a;
  private FileFilter jdField_a_of_type_JavaIoFileFilter = new ymd(this);
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private FileFilter jdField_b_of_type_JavaIoFileFilter = new yme(this);
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private String e;
  private String f;
  private String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FontManager()
  {
    a();
    ThreadManager.a();
  }
  
  private int a(File paramFile)
  {
    try
    {
      paramFile = paramFile.getName();
      int i = Integer.parseInt(paramFile.substring(0, paramFile.indexOf('.')));
      return i;
    }
    catch (Exception paramFile) {}
    return -1;
  }
  
  public static FontManager a()
  {
    return (FontManager)jdField_a_of_type_ComTencentMobileqqLyricUtilSingleton.b(null);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return this.e + File.separator;
    }
    this.e = CacheManager.a();
    File localFile = new File(this.e);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return this.e + File.separator;
  }
  
  private String a(int paramInt)
  {
    return c() + paramInt + ".zip";
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    return a() + c(paramInt1, paramInt2);
  }
  
  private void a()
  {
    Object localObject = new File(a());
    if (!((File)localObject).exists())
    {
      QLog.d("FontManager", 1, "cache font dir not found, cache font size = 0.");
      return;
    }
    localObject = a((File)localObject);
    if ((localObject != null) && (localObject.length > 0))
    {
      HashSet localHashSet = new HashSet();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = a(localObject[i]);
        if (b(k)) {
          localHashSet.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = localHashSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((Integer)((Iterator)localObject).next()).intValue());
      }
    }
    QLog.d("FontManager", 1, "cache font size = " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Object localObject2 = (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
        if (localObject2 == null) {
          continue;
        }
        ??? = ((ArrayList)localObject2).iterator();
        FontInterface.FontResult localFontResult;
        do
        {
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject2 = (ymf)((Iterator)???).next();
          localFontResult = (FontInterface.FontResult)((ymf)localObject2).jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localFontResult == null);
        localFontResult.a(paramInt, b(paramInt, ((ymf)localObject2).b), ((ymf)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, FontInterface.FontResult paramFontResult)
  {
    if (paramFontResult == null) {
      return;
    }
    ThreadManager.a(new ymb(this, paramInt1, paramInt2, paramFontResult, paramString2, paramString1), 8, null, false);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean, FontInterface.FontResult paramFontResult)
  {
    if (paramFontResult == null) {
      return;
    }
    if (!NetworkState.d())
    {
      paramFontResult.a(paramInt1, null, paramString2);
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = NetworkState.c();
      int i = QzoneConfig.a().a("QzCustomFont", "DownloadFontAnyway", 0);
      if ((!paramBoolean) && (i == 0))
      {
        paramFontResult.a(paramInt1, null, paramString2);
        return;
      }
    }
    a(paramInt1, paramString1, paramInt2, paramString2, paramFontResult);
  }
  
  /* Error */
  private boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 150	cooperation/qzone/font/FontManager:a	(I)Ljava/lang/String;
    //   5: astore_2
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 271	cooperation/qzone/font/FontManager:b	(I)Ljava/lang/String;
    //   11: astore_3
    //   12: new 71	java/io/File
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: new 71	java/io/File
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: invokestatic 276	cooperation/qzone/util/FileUtils:c	(Ljava/io/File;Ljava/io/File;)Z
    //   31: istore 8
    //   33: iload 8
    //   35: ifeq +371 -> 406
    //   38: new 71	java/io/File
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 280	java/io/File:listFiles	()[Ljava/io/File;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +308 -> 361
    //   56: aload 4
    //   58: arraylength
    //   59: ifle +302 -> 361
    //   62: aload 4
    //   64: iconst_0
    //   65: aaload
    //   66: astore 4
    //   68: invokestatic 286	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   71: pop
    //   72: aload 4
    //   74: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: invokestatic 292	com/etrump/mixlayout/ETEngine:native_getFontType	(Ljava/lang/String;)I
    //   80: istore 6
    //   82: iload 6
    //   84: iconst_2
    //   85: if_icmpne +125 -> 210
    //   88: new 71	java/io/File
    //   91: dup
    //   92: aload_0
    //   93: iload_1
    //   94: iconst_1
    //   95: invokespecial 294	cooperation/qzone/font/FontManager:a	(II)Ljava/lang/String;
    //   98: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 5
    //   103: aload 5
    //   105: invokevirtual 154	java/io/File:exists	()Z
    //   108: ifne +12 -> 120
    //   111: aload 4
    //   113: aload 5
    //   115: invokevirtual 298	java/io/File:renameTo	(Ljava/io/File;)Z
    //   118: istore 8
    //   120: iload 8
    //   122: istore 7
    //   124: iload 8
    //   126: ifeq +19 -> 145
    //   129: invokestatic 94	cooperation/qzone/font/FontManager:b	()Lcooperation/qzone/cache/FileCacheService;
    //   132: aload 5
    //   134: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: iconst_1
    //   138: invokevirtual 303	cooperation/qzone/cache/FileCacheService:a	(Ljava/lang/String;Z)V
    //   141: iload 8
    //   143: istore 7
    //   145: iload 7
    //   147: ifeq +142 -> 289
    //   150: new 305	cooperation/qzone/font/FontInfo
    //   153: dup
    //   154: invokespecial 306	cooperation/qzone/font/FontInfo:<init>	()V
    //   157: astore 4
    //   159: aload 4
    //   161: iload_1
    //   162: putfield 308	cooperation/qzone/font/FontInfo:jdField_a_of_type_Int	I
    //   165: aload_0
    //   166: getfield 49	cooperation/qzone/font/FontManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   169: aload 4
    //   171: getfield 308	cooperation/qzone/font/FontInfo:jdField_a_of_type_Int	I
    //   174: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aload 4
    //   179: invokevirtual 312	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: new 71	java/io/File
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   191: invokestatic 314	cooperation/qzone/util/FileUtils:a	(Ljava/io/File;)Z
    //   194: pop
    //   195: new 71	java/io/File
    //   198: dup
    //   199: aload_3
    //   200: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: invokestatic 314	cooperation/qzone/util/FileUtils:a	(Ljava/io/File;)Z
    //   206: pop
    //   207: iload 7
    //   209: ireturn
    //   210: iload 6
    //   212: iconst_1
    //   213: if_icmpne +249 -> 462
    //   216: new 71	java/io/File
    //   219: dup
    //   220: aload_0
    //   221: iload_1
    //   222: iconst_0
    //   223: invokespecial 294	cooperation/qzone/font/FontManager:a	(II)Ljava/lang/String;
    //   226: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: astore 5
    //   231: aload 5
    //   233: invokevirtual 154	java/io/File:exists	()Z
    //   236: ifne +12 -> 248
    //   239: aload 4
    //   241: aload 5
    //   243: invokevirtual 298	java/io/File:renameTo	(Ljava/io/File;)Z
    //   246: istore 8
    //   248: iload 8
    //   250: istore 7
    //   252: iload 8
    //   254: ifeq -109 -> 145
    //   257: invokestatic 94	cooperation/qzone/font/FontManager:b	()Lcooperation/qzone/cache/FileCacheService;
    //   260: aload 5
    //   262: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   265: iconst_1
    //   266: invokevirtual 303	cooperation/qzone/cache/FileCacheService:a	(Ljava/lang/String;Z)V
    //   269: aload_0
    //   270: aload 5
    //   272: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   275: aload_0
    //   276: iload_1
    //   277: iconst_1
    //   278: invokespecial 294	cooperation/qzone/font/FontManager:a	(II)Ljava/lang/String;
    //   281: invokespecial 317	cooperation/qzone/font/FontManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   284: istore 7
    //   286: goto -141 -> 145
    //   289: ldc 12
    //   291: iconst_1
    //   292: new 110	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 319
    //   302: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 4
    //   307: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   310: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: goto -136 -> 183
    //   322: astore 4
    //   324: ldc 12
    //   326: iconst_1
    //   327: ldc_w 323
    //   330: aload 4
    //   332: invokestatic 327	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   335: new 71	java/io/File
    //   338: dup
    //   339: aload_2
    //   340: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: invokestatic 314	cooperation/qzone/util/FileUtils:a	(Ljava/io/File;)Z
    //   346: pop
    //   347: new 71	java/io/File
    //   350: dup
    //   351: aload_3
    //   352: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   355: invokestatic 314	cooperation/qzone/util/FileUtils:a	(Ljava/io/File;)Z
    //   358: pop
    //   359: iconst_0
    //   360: ireturn
    //   361: ldc 12
    //   363: iconst_1
    //   364: ldc_w 329
    //   367: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: iload 8
    //   372: istore 7
    //   374: goto -191 -> 183
    //   377: astore 4
    //   379: new 71	java/io/File
    //   382: dup
    //   383: aload_2
    //   384: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   387: invokestatic 314	cooperation/qzone/util/FileUtils:a	(Ljava/io/File;)Z
    //   390: pop
    //   391: new 71	java/io/File
    //   394: dup
    //   395: aload_3
    //   396: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   399: invokestatic 314	cooperation/qzone/util/FileUtils:a	(Ljava/io/File;)Z
    //   402: pop
    //   403: aload 4
    //   405: athrow
    //   406: ldc 12
    //   408: iconst_1
    //   409: new 110	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 331
    //   419: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_2
    //   423: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: iload 8
    //   434: istore 7
    //   436: goto -253 -> 183
    //   439: astore_2
    //   440: aload_2
    //   441: invokevirtual 334	java/lang/Exception:printStackTrace	()V
    //   444: iload 7
    //   446: ireturn
    //   447: astore_2
    //   448: aload_2
    //   449: invokevirtual 334	java/lang/Exception:printStackTrace	()V
    //   452: iconst_0
    //   453: ireturn
    //   454: astore_2
    //   455: aload_2
    //   456: invokevirtual 334	java/lang/Exception:printStackTrace	()V
    //   459: goto -56 -> 403
    //   462: iconst_0
    //   463: istore 7
    //   465: goto -320 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	FontManager
    //   0	468	1	paramInt	int
    //   5	418	2	str1	String
    //   439	2	2	localException1	Exception
    //   447	2	2	localException2	Exception
    //   454	2	2	localException3	Exception
    //   11	385	3	str2	String
    //   49	257	4	localObject1	Object
    //   322	9	4	localException4	Exception
    //   377	27	4	localObject2	Object
    //   101	170	5	localFile	File
    //   80	134	6	i	int
    //   122	342	7	bool1	boolean
    //   31	402	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	33	322	java/lang/Exception
    //   38	51	322	java/lang/Exception
    //   56	62	322	java/lang/Exception
    //   68	82	322	java/lang/Exception
    //   88	103	322	java/lang/Exception
    //   103	120	322	java/lang/Exception
    //   129	141	322	java/lang/Exception
    //   150	183	322	java/lang/Exception
    //   216	231	322	java/lang/Exception
    //   231	248	322	java/lang/Exception
    //   257	286	322	java/lang/Exception
    //   289	319	322	java/lang/Exception
    //   361	370	322	java/lang/Exception
    //   406	432	322	java/lang/Exception
    //   12	33	377	finally
    //   38	51	377	finally
    //   56	62	377	finally
    //   68	82	377	finally
    //   88	103	377	finally
    //   103	120	377	finally
    //   129	141	377	finally
    //   150	183	377	finally
    //   216	231	377	finally
    //   231	248	377	finally
    //   257	286	377	finally
    //   289	319	377	finally
    //   324	335	377	finally
    //   361	370	377	finally
    //   406	432	377	finally
    //   183	207	439	java/lang/Exception
    //   335	359	447	java/lang/Exception
    //   379	403	454	java/lang/Exception
  }
  
  private boolean a(int paramInt1, String paramString1, int paramInt2, String arg4, FontInterface.FontResult paramFontResult)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("FontManager", 1, "fontUrl is empty.");
      return false;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    ymf localymf = new ymf(this, null);
    localymf.jdField_a_of_type_Int = paramInt1;
    localymf.b = paramInt2;
    localymf.jdField_a_of_type_JavaLangString = ???;
    localymf.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFontResult);
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      paramFontResult = (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if (paramFontResult == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FontManager", 4, "add new download task. fontId =" + paramInt1);
        }
        paramFontResult = new ArrayList();
        paramFontResult.add(localymf);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramFontResult);
        ThreadManager.a(new ymc(this, paramString1, paramInt1), 5, null, false);
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("FontManager", 4, "attache download task. fontId =" + paramInt1);
      }
      paramFontResult.add(localymf);
      return true;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    Object localObject = paramString2 + "." + b() + ".tmp";
    boolean bool;
    try
    {
      ETEngine.getInstance();
      bool = ETEngine.native_ftf2ttf(paramString1, (String)localObject);
      if (!bool) {
        break label178;
      }
      paramString1 = new File((String)localObject);
      localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        bool = paramString1.renameTo((File)localObject);
      }
      if (!bool)
      {
        QLog.e("FontManager", 1, "failed to move trueType font file, from path = " + paramString1.getAbsolutePath());
        return bool;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("FontManager", 1, "call native_ftf2ttf error, errMsg = " + paramString1.toString());
      return false;
    }
    b().a(paramString2, true);
    return bool;
    label178:
    QLog.e("FontManager", 1, "call native_ftf2ttf error");
    return bool;
  }
  
  private File[] a(File paramFile)
  {
    return paramFile.listFiles(this.jdField_a_of_type_JavaIoFileFilter);
  }
  
  private static FileCacheService b()
  {
    if (jdField_a_of_type_CooperationQzoneCacheFileCacheService == null) {
      jdField_a_of_type_CooperationQzoneCacheFileCacheService = CacheManager.c();
    }
    return jdField_a_of_type_CooperationQzoneCacheFileCacheService;
  }
  
  private String b()
  {
    String str;
    int i;
    if (TextUtils.isEmpty(this.g))
    {
      str = BaseApplicationImpl.a().getProcessName();
      i = str.indexOf(':');
      if ((i <= 0) || (i >= str.length() - 1)) {
        break label54;
      }
    }
    label54:
    for (this.g = str.substring(i + 1);; this.g = str) {
      return this.g;
    }
  }
  
  private String b(int paramInt)
  {
    String str = c() + paramInt;
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator;
  }
  
  private String b(int paramInt1, int paramInt2)
  {
    String str2 = a(paramInt1, paramInt2);
    String str1 = str2;
    if (!new File(str2).exists()) {
      str1 = null;
    }
    return str1;
  }
  
  private void b(int paramInt)
  {
    FontInfo localFontInfo = new FontInfo(paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localFontInfo);
  }
  
  private boolean b(int paramInt)
  {
    return paramInt > 0;
  }
  
  private String c()
  {
    if (!TextUtils.isEmpty(this.f)) {
      return this.f + File.separator;
    }
    this.f = (a() + b());
    File localFile = new File(this.f);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return this.f + File.separator;
  }
  
  private String c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {}
    for (String str = ".ttf";; str = ".ftf")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1).append(str);
      return localStringBuilder.toString();
      if (paramInt2 != 0) {
        break;
      }
    }
    throw new IllegalArgumentException("fontType = " + paramInt2);
  }
  
  public String a(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getFullTypeFont fontId:" + paramInt + ", strUrl = " + paramString1);
    }
    if (!b(paramInt)) {
      return null;
    }
    if ((FontInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null)
    {
      a(paramInt, paramString1, 0, paramString2, false, paramFullTypeResult);
      return null;
    }
    String str = a(paramInt, 0);
    if (!new File(str).exists())
    {
      a(paramInt, paramString1, 0, paramString2, false, paramFullTypeResult);
      return null;
    }
    b().a(str, true);
    return str;
  }
  
  public String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getTrueTypeFont fontId:" + paramInt + ", strUrl = " + paramString1);
    }
    if (!b(paramInt)) {
      return null;
    }
    if ((FontInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null)
    {
      a(paramInt, paramString1, 1, paramString2, paramBoolean, paramTrueTypeResult);
      return null;
    }
    String str = a(paramInt, 1);
    if (!new File(str).exists())
    {
      a(paramInt, paramString1, 1, paramString2, paramBoolean, paramTrueTypeResult);
      return null;
    }
    b().a(str, true);
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\font\FontManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */