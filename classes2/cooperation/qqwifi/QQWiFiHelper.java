package cooperation.qqwifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQWiFiMainManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQWiFiHelper
{
  public static int a = 0;
  public static long a = 0L;
  public static final String a = "com.tencent.mobileqq.qqwifi.scanStateChange";
  public static final int b = 0;
  public static long b = 3600000L;
  public static final String b = "intervalTime";
  public static final int c = 1;
  private static final long jdField_c_of_type_Long = 604800000L;
  private static final String jdField_c_of_type_JavaLangString = "QQWiFiHelper";
  private static final String d = "com.tencent.mobileqq.qqwifi.QQWiFiInterface";
  private static final String e = "com.tencent.mobileqq.qqwifi.QQWiFiMapInterface";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 10104;
    jdField_a_of_type_Long = 5000L;
  }
  
  private static IPluginManager.PluginParams a(Intent paramIntent, String paramString)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "QQWifiPlugin.apk";
    localPluginParams.d = "QQWifiPlugin";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.tencent.wifisdk.service.QQWTFService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    return localPluginParams;
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +12 -> 17
    //   8: aload_0
    //   9: invokevirtual 82	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 84	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: new 87	java/io/BufferedReader
    //   30: dup
    //   31: new 89	java/io/FileReader
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 92	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   39: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 99	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +73 -> 126
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: aload 4
    //   61: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -22 -> 43
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +33 -> 107
    //   77: aload_1
    //   78: astore_0
    //   79: ldc 22
    //   81: iconst_2
    //   82: new 84	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   89: ldc 110
    //   91: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 113	java/io/IOException:toString	()Ljava/lang/String;
    //   98: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_3
    //   108: astore_2
    //   109: aload_1
    //   110: ifnull -93 -> 17
    //   113: aload_1
    //   114: invokevirtual 120	java/io/BufferedReader:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: aload_1
    //   127: astore_0
    //   128: aload_1
    //   129: invokevirtual 120	java/io/BufferedReader:close	()V
    //   132: aload_1
    //   133: astore_0
    //   134: aload_2
    //   135: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore_2
    //   139: aload_2
    //   140: astore_0
    //   141: aload_0
    //   142: astore_2
    //   143: aload_1
    //   144: ifnull -127 -> 17
    //   147: aload_1
    //   148: invokevirtual 120	java/io/BufferedReader:close	()V
    //   151: aload_0
    //   152: areturn
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   158: aload_0
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 120	java/io/BufferedReader:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_1
    //   182: goto -19 -> 163
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -119 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramFile	File
    //   42	106	1	localBufferedReader	java.io.BufferedReader
    //   153	2	1	localIOException1	java.io.IOException
    //   160	12	1	localObject1	Object
    //   181	1	1	localObject2	Object
    //   187	1	1	localObject3	Object
    //   3	56	2	localObject4	Object
    //   68	27	2	localIOException2	java.io.IOException
    //   108	35	2	localObject5	Object
    //   185	1	2	localIOException3	java.io.IOException
    //   1	107	3	localObject6	Object
    //   49	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   45	51	68	java/io/IOException
    //   58	65	68	java/io/IOException
    //   128	132	68	java/io/IOException
    //   134	139	68	java/io/IOException
    //   113	117	119	java/io/IOException
    //   147	151	153	java/io/IOException
    //   19	43	160	finally
    //   167	171	173	java/io/IOException
    //   45	51	181	finally
    //   58	65	181	finally
    //   71	77	181	finally
    //   79	107	181	finally
    //   128	132	181	finally
    //   134	139	181	finally
    //   19	43	185	java/io/IOException
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 78	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: ldc -128
    //   9: iconst_0
    //   10: invokevirtual 134	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   13: ldc -120
    //   15: invokespecial 139	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: invokestatic 141	cooperation/qqwifi/QQWiFiHelper:a	(Ljava/io/File;)Ljava/lang/String;
    //   21: astore_0
    //   22: aload_0
    //   23: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: new 149	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 152	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: ldc -102
    //   41: invokevirtual 158	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   44: astore_1
    //   45: new 160	java/util/ArrayList
    //   48: dup
    //   49: invokespecial 161	java/util/ArrayList:<init>	()V
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 167	org/json/JSONArray:length	()I
    //   57: istore 4
    //   59: iload_3
    //   60: iload 4
    //   62: if_icmpge +43 -> 105
    //   65: aload_0
    //   66: aload_1
    //   67: iload_3
    //   68: invokevirtual 171	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   71: invokeinterface 177 2 0
    //   76: pop
    //   77: iload_3
    //   78: iconst_1
    //   79: iadd
    //   80: istore_3
    //   81: goto -28 -> 53
    //   84: astore_2
    //   85: aload_2
    //   86: invokevirtual 178	java/lang/Exception:printStackTrace	()V
    //   89: goto -12 -> 77
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 178	java/lang/Exception:printStackTrace	()V
    //   97: aload_0
    //   98: areturn
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_0
    //   102: goto -9 -> 93
    //   105: aload_0
    //   106: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramContext	Context
    //   44	23	1	localJSONArray	JSONArray
    //   92	2	1	localException1	Exception
    //   99	1	1	localException2	Exception
    //   84	2	2	localException3	Exception
    //   1	80	3	i	int
    //   57	6	4	j	int
    // Exception table:
    //   from	to	target	type
    //   65	77	84	java/lang/Exception
    //   53	59	92	java/lang/Exception
    //   85	89	92	java/lang/Exception
    //   22	29	99	java/lang/Exception
    //   31	53	99	java/lang/Exception
  }
  
  public static Map a(Context paramContext)
  {
    HashMap localHashMap;
    try
    {
      paramContext = a(new File(paramContext.getDir("qqwifi_dir", 0), "params_file"));
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = new JSONObject(paramContext);
        localHashMap = new HashMap();
        Iterator localIterator = paramContext.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramContext.getString(str));
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiHelper", 2, "readParams exception: " + paramContext.toString());
      }
    }
    return localHashMap;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.qqwifi.QQWiFiInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "QQWifiPlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.qqwifi.QQWiFiInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label97;
      }
      QLog.e("QQWiFiHelper", 2, "*createQQWiFiAppInterface exception:" + paramBaseApplicationImpl.toString());
      label97:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiHelper", 2, "*createQQWiFiAppInterface load class fail");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    boolean bool;
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      bool = ((IPluginManager)paramQQAppInterface.getManager(26)).isPlugininstalled("QQWifiPlugin.apk");
      if (bool) {
        b(paramActivity, paramQQAppInterface);
      }
    }
    else
    {
      return;
    }
    Intent localIntent = paramActivity.getIntent();
    if (localIntent == null) {
      localIntent = new Intent(paramActivity, QQWiFiPluginInstallActivity.class);
    }
    for (;;)
    {
      localIntent.putExtra("key_is_qqwifi", true);
      localIntent.putExtra("isWifiPluginInstalled", bool);
      localIntent.putExtra("uin", paramQQAppInterface.a());
      paramActivity.startActivity(localIntent);
      return;
      localIntent.setClass(paramActivity, QQWiFiPluginInstallActivity.class);
    }
  }
  
  public static void a(AppInterface paramAppInterface, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      localSerializable = paramIntent.getSerializableExtra("services");
      if (localSerializable == null) {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiHelper", 2, "loadQQWiFiService services null return");
        }
      }
    }
    while ((!a(paramAppInterface, paramIntent)) || (!QLog.isColorLevel()))
    {
      Serializable localSerializable;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "loadQQWiFiService services:" + localSerializable.toString());
      }
      paramIntent.putExtra("autoconnect", true);
    }
    QLog.d("QQWiFiHelper", 2, "loadQQWiFiService autoconnect");
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramAppInterface.a(), QQWiFiAssistService.class);
    localIntent.putExtra("useSkinEngine", -1);
    localIntent.putExtra("isStartForReport", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "Start QQWiFiService load,isStartReport：" + paramBoolean);
    }
    IPluginManager.b(paramAppInterface.a(), a(localIntent, paramAppInterface.a()));
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("qqwifi_dir", 0);
      if (!paramContext.exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("QQWiFiHelper", 2, "isHistoryRecordExits dirfile not exists");
          return false;
        }
      }
      else
      {
        paramContext = new File(paramContext, "data_history_WiFiUsedData");
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiHelper", 2, "isHistoryRecordExits data_history_WiFiUsedData exites:" + paramContext.exists());
        }
        if ((paramContext.exists()) && (paramContext.length() > 10L))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQWiFiHelper", 2, "isHistoryRecordExits data_history_WiFiUsedData exites,length=" + paramContext.length());
          }
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQWiFiHelper", 2, "isHistoryRecordExits", paramContext);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "func readEnableInfo begins, ctx:" + paramContext);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "func readEnableInfo enable:" + false);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        localFile = new File(paramContext.getDir("qqwifi_dir", 0), "freetime_file");
      }
      catch (Exception paramContext)
      {
        File localFile;
        paramString = null;
        continue;
      }
      try
      {
        paramContext = a(localFile);
        if (TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONObject();
          if ((paramContext.has("mFreeTime_" + paramString)) && (paramContext.getInt("mFreeTime_" + paramString) == paramInt)) {
            break label195;
          }
          paramContext.put("mFreeTime_" + paramString, paramInt);
          return a(localFile, paramContext.toString());
        }
        paramContext = new JSONObject(paramContext);
        continue;
        QLog.e("QQWiFiHelper", 2, "func updateFreeTime err:" + paramContext.toString());
      }
      catch (Exception paramContext)
      {
        paramString = localFile;
        if (paramString != null) {
          paramString.delete();
        }
        if (!QLog.isColorLevel()) {
          break label195;
        }
      }
    }
    return false;
    label195:
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localFile = new File(paramContext.getDir("qqwifi_dir", 0), "enable_file");
      }
      catch (Exception paramContext)
      {
        File localFile;
        paramString = null;
        continue;
      }
      try
      {
        paramContext = a(localFile);
        if (TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONObject();
          if ((paramContext.has("mIsQQWiFiEnable_" + paramString)) && (paramContext.getBoolean("mIsQQWiFiEnable_" + paramString) == paramBoolean)) {
            break label195;
          }
          paramContext.put("mIsQQWiFiEnable_" + paramString, false);
          return a(localFile, paramContext.toString());
        }
        paramContext = new JSONObject(paramContext);
        continue;
        QLog.d("QQWiFiHelper", 2, "updateEnableInfo err:" + paramContext.toString());
      }
      catch (Exception paramContext)
      {
        paramString = localFile;
        if (paramString != null) {
          paramString.delete();
        }
        if (!QLog.isColorLevel()) {
          break label195;
        }
      }
    }
    return false;
    label195:
    return false;
  }
  
  public static boolean a(Context paramContext, List paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    File localFile;
    int i;
    if (paramList != null)
    {
      localFile = new File(paramContext.getDir("qqwifi_dir", 0), "ssids_file");
      List localList = a(paramContext);
      paramContext = new JSONArray();
      Object localObject;
      if (localList != null)
      {
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramContext.put((String)((Iterator)localObject).next());
        }
      }
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || ((localList != null) && (localList.contains(localObject)))) {
          break label193;
        }
        paramContext.put(localObject);
        i = 1;
      }
    }
    label193:
    for (;;)
    {
      break;
      bool1 = bool2;
      if (i != 0) {
        paramList = new JSONObject();
      }
      try
      {
        paramList.put("ssidList", paramContext);
        bool1 = a(localFile, paramList.toString());
        return bool1;
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, Map paramMap)
  {
    Object localObject1;
    String str;
    if (paramMap != null)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
      localObject1 = "";
      if (paramMap.containsKey("blackBarAdapter"))
      {
        localObject2 = (String)paramMap.get("blackBarAdapter");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (localSharedPreferences != null)
          {
            localSharedPreferences.edit().putString("blackBarAdapter", (String)localObject2).commit();
            localObject1 = localObject2;
          }
        }
      }
      if (!paramMap.containsKey("whiteBarAdapter")) {
        break label442;
      }
      str = (String)paramMap.get("whiteBarAdapter");
      localObject2 = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = str;
        if (localSharedPreferences != null)
        {
          localSharedPreferences.edit().putString("whiteBarAdapter", str).commit();
          localObject2 = str;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiHelper", 2, "updateParams:blackBarAdapter=" + (String)localObject1 + " whiteBarAdapter=" + (String)localObject2);
      }
    }
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localObject1 = new File(paramContext.getDir("qqwifi_dir", 0), "params_file");
        int i;
        boolean bool;
        return false;
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = a((File)localObject1);
          if (TextUtils.isEmpty(paramContext))
          {
            paramContext = new JSONObject();
            if (paramMap == null) {
              break label452;
            }
            localObject2 = paramMap.keySet().iterator();
            i = 0;
            j = i;
            if (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if ((paramContext.has(str)) && (paramContext.get(str).equals(paramMap.get(str)))) {
                break label439;
              }
              paramContext.put(str, paramMap.get(str));
              i = 1;
              break label449;
            }
          }
          else
          {
            paramContext = new JSONObject(paramContext);
            continue;
          }
          if (j == 0) {
            break label431;
          }
          bool = a((File)localObject1, paramContext.toString());
          return bool;
        }
        catch (Exception paramContext)
        {
          paramMap = (Map)localObject1;
          continue;
        }
        paramContext = paramContext;
        paramMap = (Map)localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("QQWiFiHelper", 2, "updateParams exception: " + paramContext.toString());
        }
        if ((paramMap != null) && (paramMap.length() == 0L))
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQWiFiHelper", 2, "updateParams paramsFile存在但是是个空文件 ");
          }
          paramMap.delete();
        }
      }
      label431:
      label439:
      break label449;
      label442:
      localObject2 = "";
      break;
      label449:
      continue;
      label452:
      int j = 0;
    }
  }
  
  private static boolean a(AppInterface paramAppInterface, Intent paramIntent)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "loadQQWiFiService app null,return");
      }
      return false;
    }
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "loadQQWiFiService intent null,return");
      }
      return false;
    }
    IPluginManager localIPluginManager = (IPluginManager)paramAppInterface.getManager(26);
    if ((localIPluginManager == null) || (!localIPluginManager.isPlugininstalled("QQWifiPlugin.apk")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "loadQQWiFiService plugin has not installed,return");
      }
      if (paramIntent.hasExtra("downloadjar")) {
        if ((localIPluginManager != null) && (localIPluginManager.isReady())) {
          localIPluginManager.installPlugin("QQWifiPlugin.apk", new QQWiFiHelper.QQWIFIInstallListener(null, 0, paramAppInterface, paramIntent));
        }
      }
      for (;;)
      {
        return false;
        if ((paramIntent.hasExtra("campus")) && (localIPluginManager != null)) {
          localIPluginManager.installPlugin("QQWifiPlugin.apk", new QQWiFiHelper.QQWIFIInstallListener(null, 1, paramAppInterface, paramIntent));
        }
      }
    }
    paramIntent.setClass(paramAppInterface.a(), QQWiFiAssistService.class);
    paramIntent.putExtra("useSkinEngine", -1);
    paramIntent.putExtra("app_id", AppSetting.jdField_a_of_type_Int);
    paramIntent.putExtra("version_name", "6.5.5");
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "loadQQWiFiService downloadjar.");
    }
    IPluginManager.b(paramAppInterface.a(), a(paramIntent, paramAppInterface.a()));
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +26 -> 33
    //   10: iload 4
    //   12: istore_3
    //   13: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +15 -> 31
    //   19: ldc 22
    //   21: iconst_2
    //   22: ldc_w 542
    //   25: invokestatic 357	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iload 4
    //   30: istore_3
    //   31: iload_3
    //   32: ireturn
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual 546	java/lang/String:getBytes	()[B
    //   39: astore_1
    //   40: new 548	java/io/FileOutputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 549	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_0
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 553	java/io/FileOutputStream:write	([B)V
    //   54: iconst_1
    //   55: istore_3
    //   56: aload_0
    //   57: ifnull -26 -> 31
    //   60: aload_0
    //   61: invokevirtual 554	java/io/FileOutputStream:close	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_0
    //   67: iconst_1
    //   68: ireturn
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_0
    //   72: iload 4
    //   74: istore_3
    //   75: aload_0
    //   76: ifnull -45 -> 31
    //   79: aload_0
    //   80: invokevirtual 554	java/io/FileOutputStream:close	()V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_0
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_0
    //   89: aload_2
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 554	java/io/FileOutputStream:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_1
    //   102: goto -3 -> 99
    //   105: astore_2
    //   106: aload_0
    //   107: astore_1
    //   108: aload_2
    //   109: astore_0
    //   110: goto -19 -> 91
    //   113: astore_1
    //   114: goto -42 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramFile	File
    //   0	117	1	paramString	String
    //   34	56	2	localObject1	Object
    //   105	4	2	localObject2	Object
    //   12	63	3	bool1	boolean
    //   1	72	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   60	64	66	java/io/IOException
    //   35	49	69	java/lang/Exception
    //   79	83	85	java/io/IOException
    //   35	49	88	finally
    //   95	99	101	java/io/IOException
    //   49	54	105	finally
    //   49	54	113	java/lang/Exception
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.qqwifi.QQWiFiMapInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "QQWifiPlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.qqwifi.QQWiFiMapInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label99;
      }
      QLog.e("QQWiFiHelper", 2, "*createQQWiFiMapAppInterface exception:" + paramBaseApplicationImpl.toString());
      label99:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiHelper", 2, "*createQQWiFiMapAppInterface load class fail");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit().putLong("KEY_QQWIFI_PLUGIN_CREATE_TIME", System.currentTimeMillis()).commit();
      QQWiFiHelper.PluginLoadDialog localPluginLoadDialog = new QQWiFiHelper.PluginLoadDialog(paramActivity, "QQ WiFi");
      Intent localIntent = paramActivity.getIntent();
      if (localIntent == null) {
        localIntent = new Intent(paramActivity, QQWiFiPluginInstallActivity.class);
      }
      for (;;)
      {
        localIntent.putExtra("param_plugin_gesturelock", true);
        localIntent.putExtra("userQqResources", -1);
        localIntent.putExtra("useSkinEngine", true);
        localIntent.putExtra("app_id", AppSetting.jdField_a_of_type_Int);
        localIntent.putExtra("version_name", "6.5.5");
        localIntent.putExtra("resultReceiver", ((QQWiFiMainManager)paramQQAppInterface.getManager(77)).a);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
        localPluginParams.jdField_b_of_type_JavaLangString = "QQWifiPlugin.apk";
        localPluginParams.d = "QQWifiPlugin";
        localPluginParams.jdField_a_of_type_AndroidAppDialog = localPluginLoadDialog;
        localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
        localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
        localPluginParams.e = "com.tencent.wifisdk.activity.WiFiConnectActivity";
        localPluginParams.jdField_a_of_type_JavaLangClass = QQWiFiConnectProxyActivity.class;
        localPluginParams.jdField_b_of_type_Int = 19;
        localPluginParams.c = 15000;
        localPluginParams.jdField_a_of_type_Boolean = false;
        localPluginParams.f = null;
        IPluginManager.a(paramActivity, localPluginParams);
        a(paramQQAppInterface, false);
        return;
        localIntent.setClass(paramActivity, QQWiFiPluginInstallActivity.class);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWiFiHelper", 2, "starterro", paramQQAppInterface);
      }
      QQToast.a(paramActivity, "启动失败，请稍候重试", 0).a();
    }
  }
  
  public static void b(AppInterface paramAppInterface, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.putExtra("campus", true);
    }
    if ((a(paramAppInterface, paramIntent)) && (QLog.isColorLevel())) {
      QLog.d("QQWiFiHelper", 2, "loadQQWiFiServiceForCampusConnect");
    }
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("qqwifi_dir", 0);
      if (!paramContext.exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("QQWiFiHelper", 2, "isStatusRecordExits dirfile not exists");
          return false;
        }
      }
      else
      {
        paramContext = new File(paramContext, "data_buffer_WiFiStatus_");
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiHelper", 2, "isStatusRecordExits data_buffer_WiFiStatus_ exites:" + paramContext.exists());
        }
        if ((paramContext.exists()) && (paramContext.length() > 10L))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQWiFiHelper", 2, "isStatusRecordExits data_buffer_WiFiStatus_ exites,length=" + paramContext.length());
          }
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQWiFiHelper", 2, "isStatusRecordExits", paramContext);
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\QQWiFiHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */