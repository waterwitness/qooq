package cooperation.qzone.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.plugin.PluginInfoUtil;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import yog;
import yom;

public class QZonePluginUtils
{
  public static final String a = "com.tencent.mobileqq:qzonelive";
  public static final String b = "qzone_live_pluginid";
  private static final String c = "qzone_downloaded_plugins";
  private static final String d = "qzone_plugin_info";
  private static final String e = "qzone_installed_plugin";
  private static final String f = "patch";
  
  public QZonePluginUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static PluginRecord a(File paramFile)
  {
    // Byte code:
    //   0: new 41	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 50	java/io/File:length	()J
    //   15: l2i
    //   16: newarray <illegal type>
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 54	java/io/FileInputStream:read	([B)I
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: new 56	java/lang/String
    //   32: dup
    //   33: aload_0
    //   34: iconst_0
    //   35: invokestatic 62	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   38: invokespecial 65	java/lang/String:<init>	([B)V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: new 67	cooperation/qzone/plugin/PluginRecord
    //   47: dup
    //   48: invokespecial 68	cooperation/qzone/plugin/PluginRecord:<init>	()V
    //   51: astore_0
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: aload_3
    //   56: invokevirtual 71	cooperation/qzone/plugin/PluginRecord:a	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +9 -> 71
    //   65: aload_2
    //   66: invokevirtual 74	java/io/FileInputStream:close	()V
    //   69: aload_0
    //   70: astore_1
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 78	java/io/FileNotFoundException:printStackTrace	()V
    //   91: aload_0
    //   92: astore_1
    //   93: aload_2
    //   94: ifnull -23 -> 71
    //   97: aload_2
    //   98: invokevirtual 74	java/io/FileInputStream:close	()V
    //   101: aload_0
    //   102: areturn
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   108: aload_0
    //   109: areturn
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   121: aload_0
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull -53 -> 71
    //   127: aload_2
    //   128: invokevirtual 74	java/io/FileInputStream:close	()V
    //   131: aload_0
    //   132: areturn
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   138: aload_0
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 74	java/io/FileInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   158: goto -7 -> 151
    //   161: astore_0
    //   162: goto -19 -> 143
    //   165: astore_3
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -53 -> 115
    //   171: astore_3
    //   172: goto -57 -> 115
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -93 -> 85
    //   181: astore_3
    //   182: goto -97 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramFile	File
    //   10	62	1	localObject1	Object
    //   73	2	1	localIOException1	java.io.IOException
    //   86	7	1	localObject2	Object
    //   103	2	1	localIOException2	java.io.IOException
    //   116	7	1	localObject3	Object
    //   133	2	1	localIOException3	java.io.IOException
    //   142	6	1	localObject4	Object
    //   153	2	1	localIOException4	java.io.IOException
    //   8	120	2	localFileInputStream	java.io.FileInputStream
    //   41	15	3	str	String
    //   80	8	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   110	8	3	localIOException5	java.io.IOException
    //   165	1	3	localIOException6	java.io.IOException
    //   171	1	3	localIOException7	java.io.IOException
    //   175	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   181	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   65	69	73	java/io/IOException
    //   0	9	80	java/io/FileNotFoundException
    //   97	101	103	java/io/IOException
    //   0	9	110	java/io/IOException
    //   127	131	133	java/io/IOException
    //   0	9	140	finally
    //   147	151	153	java/io/IOException
    //   11	19	161	finally
    //   21	27	161	finally
    //   29	42	161	finally
    //   44	52	161	finally
    //   54	59	161	finally
    //   87	91	161	finally
    //   117	121	161	finally
    //   11	19	165	java/io/IOException
    //   21	27	165	java/io/IOException
    //   29	42	165	java/io/IOException
    //   44	52	165	java/io/IOException
    //   54	59	171	java/io/IOException
    //   11	19	175	java/io/FileNotFoundException
    //   21	27	175	java/io/FileNotFoundException
    //   29	42	175	java/io/FileNotFoundException
    //   44	52	175	java/io/FileNotFoundException
    //   54	59	181	java/io/FileNotFoundException
  }
  
  public static File a(Context paramContext)
  {
    return PluginUtils.getPluginInstallDir(paramContext);
  }
  
  public static File a(Context paramContext, String paramString)
  {
    return new File(a(paramContext), paramString);
  }
  
  public static String a()
  {
    int j = 0;
    int i = 0;
    String str = LocalMultiProcConfig.a("qzone_live_pluginid", "qzone_live_video_plugin_hack.apk");
    int k = QzoneConfig.a().a("LiveSetting", "useQQPluginManager", 0);
    List localList;
    if ((k == 0) && (!"qzone_live_video_plugin_hack.apk".equals(str)))
    {
      localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
      while (i < localList.size())
      {
        if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)localList.get(i)).processName))
        {
          if (QLog.isColorLevel()) {
            QLog.i("patch", 2, "切换时 qzonelive 进程存在 pluginid 保持不变，getLoadQZoneLivePluginId:" + str);
          }
          return str;
        }
        i += 1;
      }
      str = "qzone_live_video_plugin_hack.apk";
      LocalMultiProcConfig.a("qzone_live_pluginid", "qzone_live_video_plugin_hack.apk");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "getLoadQZoneLivePluginId:" + str);
      }
      return str;
      if ((k == 1) && (!"qzone_live_video_plugin.apk".equals(str)))
      {
        localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
        i = j;
        for (;;)
        {
          if (i >= localList.size()) {
            break label271;
          }
          if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)localList.get(i)).processName))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("patch", 2, "切换时 qzonelive 进程存在 pluginid 保持不变，getLoadQZoneLivePluginId:" + str);
            return str;
          }
          i += 1;
        }
        label271:
        str = "qzone_live_video_plugin.apk";
        LocalMultiProcConfig.a("qzone_live_pluginid", "qzone_live_video_plugin.apk");
      }
    }
  }
  
  public static void a(Context paramContext, Map paramMap)
  {
    int j = 0;
    int i = 0;
    Object localObject = paramContext.getDir("qzone_plugin_info", 0);
    boolean bool = PluginInfoUtil.a((File)localObject);
    paramContext = a((File)localObject);
    if (bool)
    {
      j = paramContext.length;
      while (i < j)
      {
        paramMap = paramContext[i];
        if (paramMap.exists()) {
          paramMap.delete();
        }
        i += 1;
      }
      PluginInfoUtil.a((File)localObject);
    }
    for (;;)
    {
      return;
      if (paramContext != null)
      {
        int k = paramContext.length;
        i = j;
        while (i < k)
        {
          localObject = paramContext[i];
          if (((File)localObject).exists())
          {
            localObject = a((File)localObject);
            if (localObject != null) {
              paramMap.put(((PluginRecord)localObject).g, localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a(Context paramContext, Map paramMap, yog paramyog)
  {
    paramContext = a(paramContext.getDir("qzone_installed_plugin", 0));
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      if (i < j)
      {
        File localFile = paramContext[i];
        if (localFile.exists())
        {
          PluginRecord localPluginRecord = a(localFile);
          if (localPluginRecord != null)
          {
            boolean bool = true;
            if (paramyog != null) {
              bool = paramyog.a(localPluginRecord, localFile);
            }
            if (!bool) {
              break label98;
            }
            paramMap.put(localPluginRecord.g, localPluginRecord);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label98:
          localFile.delete();
        }
      }
    }
  }
  
  public static void a(PluginRecord paramPluginRecord)
  {
    try
    {
      File localFile = c(BaseApplicationImpl.getContext(), paramPluginRecord.g);
      if ((localFile.isFile()) && (localFile.exists()))
      {
        localFile.delete();
        localFile.createNewFile();
      }
      a(localFile, paramPluginRecord);
      return;
    }
    catch (Exception paramPluginRecord) {}
  }
  
  public static boolean a()
  {
    List localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < localList.size())
      {
        if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)localList.get(i)).processName)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  static boolean a(PluginRecord paramPluginRecord, Context paramContext)
  {
    if ((paramPluginRecord == null) || (paramContext == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramPluginRecord.j)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (paramPluginRecord.j.equalsIgnoreCase(localRunningAppProcessInfo.processName)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean a(File paramFile, PluginRecord paramPluginRecord)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: invokevirtual 262	cooperation/qzone/plugin/PluginRecord:a	()Ljava/lang/String;
    //   11: astore 4
    //   13: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +29 -> 45
    //   19: ldc 23
    //   21: iconst_2
    //   22: new 157	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 264
    //   32: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload 4
    //   47: invokevirtual 273	java/lang/String:getBytes	()[B
    //   50: iconst_0
    //   51: invokestatic 276	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   54: astore_1
    //   55: new 278	java/io/FileOutputStream
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore_0
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 282	java/io/FileOutputStream:write	([B)V
    //   69: iconst_1
    //   70: istore 6
    //   72: iload 6
    //   74: istore 5
    //   76: aload_0
    //   77: ifnull +11 -> 88
    //   80: aload_0
    //   81: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   84: iload 6
    //   86: istore 5
    //   88: iload 5
    //   90: ireturn
    //   91: astore_0
    //   92: aload_2
    //   93: astore_0
    //   94: aload_0
    //   95: ifnull -7 -> 88
    //   98: aload_0
    //   99: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_0
    //   108: aload_3
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: goto -6 -> 118
    //   127: astore_2
    //   128: aload_0
    //   129: astore_1
    //   130: aload_2
    //   131: astore_0
    //   132: goto -22 -> 110
    //   135: astore_1
    //   136: goto -42 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramFile	File
    //   0	139	1	paramPluginRecord	PluginRecord
    //   6	87	2	localObject1	Object
    //   127	4	2	localObject2	Object
    //   4	105	3	localObject3	Object
    //   11	35	4	str	String
    //   1	88	5	bool1	boolean
    //   70	15	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	45	91	java/lang/Exception
    //   45	64	91	java/lang/Exception
    //   98	102	104	java/io/IOException
    //   7	45	107	finally
    //   45	64	107	finally
    //   80	84	120	java/io/IOException
    //   114	118	123	java/io/IOException
    //   64	69	127	finally
    //   64	69	135	java/lang/Exception
  }
  
  public static File[] a(File paramFile)
  {
    return paramFile.listFiles(new yom());
  }
  
  public static File b(Context paramContext, String paramString)
  {
    return PluginUtils.getPluginLibPath(paramContext, paramString);
  }
  
  public static void b(PluginRecord paramPluginRecord)
  {
    try
    {
      File localFile = d(BaseApplicationImpl.getContext(), paramPluginRecord.g);
      if ((localFile.isFile()) && (localFile.exists()))
      {
        localFile.delete();
        localFile.createNewFile();
      }
      a(localFile, paramPluginRecord);
      return;
    }
    catch (Exception paramPluginRecord) {}
  }
  
  public static File c(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_plugin_info", 0), paramString + ".cfg");
  }
  
  public static void c(PluginRecord paramPluginRecord)
  {
    try
    {
      paramPluginRecord = d(BaseApplicationImpl.getContext(), paramPluginRecord.g);
      if ((paramPluginRecord.isFile()) && (paramPluginRecord.exists())) {
        paramPluginRecord.delete();
      }
      return;
    }
    catch (Exception paramPluginRecord) {}
  }
  
  public static File d(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_installed_plugin", 0), paramString + ".cfg");
  }
  
  public static File e(Context paramContext, String paramString)
  {
    return new File(paramContext.getDir("qzone_downloaded_plugins", 0), paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePluginUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */