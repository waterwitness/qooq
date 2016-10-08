package com.tencent.mobileqq.secspy;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugReporter;
import com.tencent.mobileqq.unifiedebug.UnifiedFileUtil;
import com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.TraceRouteInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;
import uok;
import uol;

public class SecSpyFileManager
  implements Manager
{
  private static final int A = 1;
  private static final int B = 2;
  private static final int C = 3;
  private static final int D = 0;
  private static final int E = -1;
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 10485760L;
  public static final String a = "SecSpyFileManager";
  private static final int b = 2;
  private static final int c = 3;
  private static final int jdField_d_of_type_Int = 4;
  private static final String jdField_d_of_type_JavaLangString = "文件过大";
  private static final int jdField_e_of_type_Int = 257;
  private static final String jdField_e_of_type_JavaLangString = "文件不存在";
  private static final int f = 258;
  private static final int g = 259;
  private static final int h = 260;
  private static final int i = 261;
  private static final int j = 262;
  private static final int k = 263;
  private static final int l = 264;
  private static final int m = 265;
  private static final int n = 266;
  private static final int o = 267;
  private static final int p = 268;
  private static final int q = 269;
  private static final int r = 270;
  private static final int s = 271;
  private static final int t = 272;
  private static final int u = 273;
  private static final int v = 274;
  private static final int w = 275;
  private static final int x = 276;
  private static final int y = 280;
  private static final int z = 291;
  public Handler a;
  public QQAppInterface a;
  public UnifiedDebugManager a;
  public UnifiedDebugReporter a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String b;
  public String c;
  
  public SecSpyFileManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "http://logic.content.qq.com/public/file_upload2?";
    this.c = ".mgz";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRunnable = new uok(this);
    ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public File a(String paramString)
  {
    Object localObject2 = paramString;
    Object localObject1;
    Object localObject3;
    Context localContext;
    try
    {
      if (paramString.startsWith("/data/data/com.tencent.mobileqq/"))
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (!paramString.endsWith("/"))
        {
          localObject2 = paramString;
          localObject1 = paramString + "/";
        }
        localObject2 = localObject1;
        int i1 = ((String)localObject1).indexOf("/data/data/com.tencent.mobileqq/");
        localObject2 = localObject1;
        localObject3 = ((String)localObject1).substring("/data/data/com.tencent.mobileqq/".length() + i1);
        localObject2 = localObject1;
        paramString = ((String)localObject3).substring(0, ((String)localObject3).indexOf("/"));
        localObject2 = localObject1;
        localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("/") + 1);
        localObject2 = localObject1;
        localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
        localObject2 = localObject1;
        if (paramString.equals("files"))
        {
          localObject2 = localObject1;
          return new File(localContext.getFilesDir(), (String)localObject3);
        }
        localObject2 = localObject1;
        if (paramString.equals("cache"))
        {
          localObject2 = localObject1;
          paramString = new File(localContext.getCacheDir(), (String)localObject3);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      localObject3 = null;
      localObject1 = localObject2;
      localObject2 = paramString;
      paramString = (String)localObject3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SecSpyFileManager", 2, "wrong to parse file from path :" + (String)localObject1, (Throwable)localObject2);
      }
      ((Exception)localObject2).printStackTrace();
      return paramString;
      localObject2 = localObject1;
      if (paramString.startsWith("app_"))
      {
        localObject2 = localObject1;
        paramString = paramString.substring("app_".length());
        localObject2 = localObject1;
        return new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getDir(paramString, 0), (String)localObject3);
      }
      localObject2 = localObject1;
      if (paramString.equalsIgnoreCase("databases"))
      {
        localObject2 = localObject1;
        paramString = localContext.getDatabasePath((String)localObject3);
        localObject2 = paramString;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("now get database: ");
          if (paramString != null) {}
          for (localObject2 = paramString.getPath();; localObject2 = "none")
          {
            QLog.i("SecSpyFileManager", 2, (String)localObject2);
            return paramString;
          }
          localObject2 = localObject1;
          return new File((String)localObject1);
          localObject2 = paramString;
          if (paramString.startsWith("sdcard/"))
          {
            localObject2 = paramString;
            localObject1 = paramString.replace("sdcard/", "");
            localObject2 = paramString;
            if ("mounted".equals(Environment.getExternalStorageState()))
            {
              localObject2 = paramString;
              if (Environment.getExternalStorageDirectory().canWrite())
              {
                localObject2 = paramString;
                return new File(Environment.getExternalStorageDirectory().getPath() + "/" + (String)localObject1);
              }
            }
          }
          else
          {
            localObject2 = paramString;
            paramString = new File(paramString);
            return paramString;
          }
          localObject2 = null;
        }
        return (File)localObject2;
      }
      catch (Exception localException) {}
    }
  }
  
  public String a(TreeMap paramTreeMap, String paramString)
  {
    Iterator localIterator = paramTreeMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + paramTreeMap.get(str2)) {
      str2 = (String)localIterator.next();
    }
    return MD5.toMD5(str1 + paramString);
  }
  
  public List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i1);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localJSONArray.put(paramCollection.next());
    }
    return localJSONArray;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong);
  }
  
  public void a(long paramLong, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, null);
        return;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
    case 2: 
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("sizes", paramVarArgs[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, localJSONObject);
      return;
    case 3: 
      localJSONObject = new JSONObject();
      if (paramVarArgs.length > 0) {
        localJSONObject.put("percent", paramVarArgs[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, localJSONObject);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramVarArgs.length > 0) {
      localJSONObject.put("msg", paramVarArgs[0]);
    }
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, paramInt, localJSONObject);
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, -1, new Object[] { paramString });
  }
  
  public void a(long paramLong, String paramString, Map paramMap, List paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localJSONArray.put(((UnifiedTraceRouter.TraceRouteInfo)paramList.get(i1)).a());
      i1 += 1;
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
        continue;
        paramList.clear();
      }
    }
    catch (Exception paramString)
    {
      a(paramLong, -1, new Object[] { paramString.getMessage() });
    }
    for (;;)
    {
      return;
      localJSONObject.put("dns", this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a());
      localJSONObject.put("ip", this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.b(paramString));
      localJSONObject.put("traceRoute", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, localJSONObject.toString());
      }
      a(paramLong, localJSONObject);
    }
  }
  
  public void a(long paramLong, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter.a(paramLong, 0, paramJSONObject);
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramInt, paramLong1, paramLong2, paramString2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    File localFile = new File(paramString1);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      a(paramLong, 2, new Object[] { Long.valueOf(localFile.length()) });
      if (!a(paramString1, paramLong, paramString2, false)) {
        break label103;
      }
      if (paramBoolean)
      {
        localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("SecSpyFileManager", 2, paramString1 + " delete success");
        }
      }
    }
    return;
    label103:
    a(paramLong, -1, new Object[] { "file upload failed" });
  }
  
  public void a(List paramList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramLong)) {
      b(paramList, paramLong, paramString);
    }
  }
  
  public void a(submsgtype0x7c.MsgBody paramMsgBody, int paramInt)
  {
    if (paramInt < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSpyFileManager", 2, "retry to max retry number ");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.a("SecSpyFile", 0);
      localHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager = new UnifiedDebugManager(new SnapshotResultReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsHandler));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter == null) {
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugReporter = new UnifiedDebugReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new uol(this, paramMsgBody, paramInt));
  }
  
  public boolean a(File paramFile)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    paramFile = a(paramFile.getAbsolutePath() + this.c);
    if (paramFile == null)
    {
      if (localFileInputStream != null) {}
      try
      {
        localFileInputStream.close();
        return false;
      }
      catch (Exception paramFile)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("SecSpyFileManager", 2, "compress file error!", paramFile);
        return false;
      }
    }
    paramFile = new GZIPOutputStream(new FileOutputStream(paramFile));
    byte[] arrayOfByte = new byte['⠀'];
    for (;;)
    {
      int i1 = localFileInputStream.read(arrayOfByte, 0, 10240);
      if (i1 == -1) {
        break;
      }
      paramFile.write(arrayOfByte, 0, i1);
    }
    try
    {
      paramFile.finish();
      paramFile.flush();
      paramFile.close();
      localFileInputStream.close();
      return true;
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SecSpyFileManager", 2, "compress file error!", paramFile);
        }
      }
    }
  }
  
  /* Error */
  public boolean a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 9
    //   18: new 514	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 515	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:<init>	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;)V
    //   26: astore 13
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 11
    //   35: aload 11
    //   37: ifnull +19 -> 56
    //   40: aload 11
    //   42: invokevirtual 408	java/io/File:exists	()Z
    //   45: ifeq +11 -> 56
    //   48: aload 11
    //   50: invokevirtual 411	java/io/File:isFile	()Z
    //   53: ifne +165 -> 218
    //   56: aload_0
    //   57: lload_2
    //   58: iconst_m1
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: ldc 34
    //   67: aastore
    //   68: invokevirtual 359	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   71: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +29 -> 103
    //   77: ldc 24
    //   79: iconst_2
    //   80: new 140	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 517
    //   90: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_0
    //   104: ifeq +11 -> 115
    //   107: new 519	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 519	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: iconst_0
    //   128: ifeq +11 -> 139
    //   131: new 519	java/lang/NullPointerException
    //   134: dup
    //   135: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   138: athrow
    //   139: iload 5
    //   141: ifeq +45 -> 186
    //   144: aload_0
    //   145: new 140	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   152: aload_1
    //   153: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   160: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +15 -> 186
    //   174: aload_1
    //   175: invokevirtual 408	java/io/File:exists	()Z
    //   178: ifeq +8 -> 186
    //   181: aload_1
    //   182: invokevirtual 426	java/io/File:delete	()Z
    //   185: pop
    //   186: aload 13
    //   188: iconst_1
    //   189: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   192: pop
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_1
    //   196: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +13 -> 212
    //   202: ldc 24
    //   204: iconst_2
    //   205: ldc_w 525
    //   208: aload_1
    //   209: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_1
    //   213: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   216: iconst_0
    //   217: ireturn
    //   218: aload 11
    //   220: invokevirtual 414	java/io/File:length	()J
    //   223: ldc2_w 20
    //   226: lcmp
    //   227: ifle +169 -> 396
    //   230: aload_0
    //   231: lload_2
    //   232: iconst_m1
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: ldc 30
    //   241: aastore
    //   242: invokevirtual 359	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   245: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +33 -> 281
    //   251: ldc 24
    //   253: iconst_2
    //   254: new 140	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 527
    //   264: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 11
    //   269: invokevirtual 414	java/io/File:length	()J
    //   272: invokevirtual 530	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: iconst_0
    //   282: ifeq +11 -> 293
    //   285: new 519	java/lang/NullPointerException
    //   288: dup
    //   289: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   292: athrow
    //   293: iconst_0
    //   294: ifeq +11 -> 305
    //   297: new 519	java/lang/NullPointerException
    //   300: dup
    //   301: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   304: athrow
    //   305: iconst_0
    //   306: ifeq +11 -> 317
    //   309: new 519	java/lang/NullPointerException
    //   312: dup
    //   313: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   316: athrow
    //   317: iload 5
    //   319: ifeq +45 -> 364
    //   322: aload_0
    //   323: new 140	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   330: aload_1
    //   331: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   338: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   347: astore_1
    //   348: aload_1
    //   349: ifnull +15 -> 364
    //   352: aload_1
    //   353: invokevirtual 408	java/io/File:exists	()Z
    //   356: ifeq +8 -> 364
    //   359: aload_1
    //   360: invokevirtual 426	java/io/File:delete	()Z
    //   363: pop
    //   364: aload 13
    //   366: iconst_1
    //   367: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   370: pop
    //   371: iconst_0
    //   372: ireturn
    //   373: astore_1
    //   374: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +13 -> 390
    //   380: ldc 24
    //   382: iconst_2
    //   383: ldc_w 525
    //   386: aload_1
    //   387: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   390: aload_1
    //   391: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   394: iconst_0
    //   395: ireturn
    //   396: aload_1
    //   397: aload_1
    //   398: bipush 47
    //   400: invokevirtual 534	java/lang/String:lastIndexOf	(I)I
    //   403: iconst_1
    //   404: iadd
    //   405: invokevirtual 161	java/lang/String:substring	(I)Ljava/lang/String;
    //   408: astore 12
    //   410: aload 12
    //   412: astore 8
    //   414: aload 11
    //   416: astore 7
    //   418: iload 5
    //   420: ifeq +356 -> 776
    //   423: new 140	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   430: aload 12
    //   432: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc_w 536
    //   438: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: astore 8
    //   446: aload_0
    //   447: aload 11
    //   449: invokevirtual 538	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/io/File;)Z
    //   452: ifeq +209 -> 661
    //   455: aload_0
    //   456: new 140	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   463: aload_1
    //   464: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   471: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   480: astore 11
    //   482: aload 11
    //   484: ifnull +23 -> 507
    //   487: aload 11
    //   489: invokevirtual 408	java/io/File:exists	()Z
    //   492: ifeq +15 -> 507
    //   495: aload 11
    //   497: astore 7
    //   499: aload 11
    //   501: invokevirtual 411	java/io/File:isFile	()Z
    //   504: ifne +272 -> 776
    //   507: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +36 -> 546
    //   513: ldc 24
    //   515: iconst_2
    //   516: new 140	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 540
    //   526: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_0
    //   534: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   537: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: iconst_0
    //   547: ifeq +11 -> 558
    //   550: new 519	java/lang/NullPointerException
    //   553: dup
    //   554: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   557: athrow
    //   558: iconst_0
    //   559: ifeq +11 -> 570
    //   562: new 519	java/lang/NullPointerException
    //   565: dup
    //   566: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   569: athrow
    //   570: iconst_0
    //   571: ifeq +11 -> 582
    //   574: new 519	java/lang/NullPointerException
    //   577: dup
    //   578: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   581: athrow
    //   582: iload 5
    //   584: ifeq +45 -> 629
    //   587: aload_0
    //   588: new 140	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   595: aload_1
    //   596: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_0
    //   600: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   603: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   612: astore_1
    //   613: aload_1
    //   614: ifnull +15 -> 629
    //   617: aload_1
    //   618: invokevirtual 408	java/io/File:exists	()Z
    //   621: ifeq +8 -> 629
    //   624: aload_1
    //   625: invokevirtual 426	java/io/File:delete	()Z
    //   628: pop
    //   629: aload 13
    //   631: iconst_1
    //   632: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   635: pop
    //   636: iconst_0
    //   637: ireturn
    //   638: astore_1
    //   639: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +13 -> 655
    //   645: ldc 24
    //   647: iconst_2
    //   648: ldc_w 525
    //   651: aload_1
    //   652: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   655: aload_1
    //   656: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   659: iconst_0
    //   660: ireturn
    //   661: iconst_0
    //   662: ifeq +11 -> 673
    //   665: new 519	java/lang/NullPointerException
    //   668: dup
    //   669: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   672: athrow
    //   673: iconst_0
    //   674: ifeq +11 -> 685
    //   677: new 519	java/lang/NullPointerException
    //   680: dup
    //   681: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   684: athrow
    //   685: iconst_0
    //   686: ifeq +11 -> 697
    //   689: new 519	java/lang/NullPointerException
    //   692: dup
    //   693: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   696: athrow
    //   697: iload 5
    //   699: ifeq +45 -> 744
    //   702: aload_0
    //   703: new 140	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   710: aload_1
    //   711: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload_0
    //   715: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   718: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   727: astore_1
    //   728: aload_1
    //   729: ifnull +15 -> 744
    //   732: aload_1
    //   733: invokevirtual 408	java/io/File:exists	()Z
    //   736: ifeq +8 -> 744
    //   739: aload_1
    //   740: invokevirtual 426	java/io/File:delete	()Z
    //   743: pop
    //   744: aload 13
    //   746: iconst_1
    //   747: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   750: pop
    //   751: iconst_0
    //   752: ireturn
    //   753: astore_1
    //   754: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +13 -> 770
    //   760: ldc 24
    //   762: iconst_2
    //   763: ldc_w 525
    //   766: aload_1
    //   767: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   770: aload_1
    //   771: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   774: iconst_0
    //   775: ireturn
    //   776: new 263	java/util/TreeMap
    //   779: dup
    //   780: invokespecial 541	java/util/TreeMap:<init>	()V
    //   783: astore 11
    //   785: aload 11
    //   787: ldc_w 543
    //   790: lload_2
    //   791: invokestatic 420	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   794: invokevirtual 546	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   797: pop
    //   798: aload 11
    //   800: ldc_w 548
    //   803: ldc_w 550
    //   806: invokevirtual 546	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   809: pop
    //   810: aload 11
    //   812: ldc_w 552
    //   815: aload 8
    //   817: invokevirtual 546	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   820: pop
    //   821: aload 11
    //   823: ldc_w 554
    //   826: aload 7
    //   828: invokevirtual 414	java/io/File:length	()J
    //   831: invokestatic 420	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   834: invokevirtual 546	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   837: pop
    //   838: aload 11
    //   840: ldc_w 556
    //   843: iconst_0
    //   844: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   847: invokevirtual 546	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   850: pop
    //   851: aload 11
    //   853: ldc_w 563
    //   856: aload_0
    //   857: aload 11
    //   859: aload 4
    //   861: invokevirtual 565	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/util/TreeMap;Ljava/lang/String;)Ljava/lang/String;
    //   864: invokevirtual 546	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   867: pop
    //   868: aload_0
    //   869: getfield 96	com/tencent/mobileqq/secspy/SecSpyFileManager:b	Ljava/lang/String;
    //   872: astore 4
    //   874: aload 11
    //   876: invokevirtual 267	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   879: invokeinterface 273 1 0
    //   884: astore 12
    //   886: aload 12
    //   888: invokeinterface 278 1 0
    //   893: ifeq +62 -> 955
    //   896: aload 12
    //   898: invokeinterface 282 1 0
    //   903: checkcast 129	java/lang/String
    //   906: astore 14
    //   908: new 140	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   915: aload 4
    //   917: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload 14
    //   922: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: ldc_w 567
    //   928: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: aload 11
    //   933: aload 14
    //   935: invokevirtual 286	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   938: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   941: ldc_w 569
    //   944: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: astore 4
    //   952: goto -66 -> 886
    //   955: aload 4
    //   957: ldc_w 569
    //   960: invokevirtual 138	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   963: ifeq +1098 -> 2061
    //   966: aload 4
    //   968: iconst_0
    //   969: aload 4
    //   971: invokevirtual 157	java/lang/String:length	()I
    //   974: iconst_1
    //   975: isub
    //   976: invokevirtual 164	java/lang/String:substring	(II)Ljava/lang/String;
    //   979: astore 4
    //   981: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   984: ifeq +30 -> 1014
    //   987: ldc 24
    //   989: iconst_2
    //   990: new 140	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   997: ldc_w 571
    //   1000: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: aload 4
    //   1005: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1014: new 573	java/net/URL
    //   1017: dup
    //   1018: aload 4
    //   1020: invokespecial 574	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1023: invokevirtual 578	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1026: checkcast 580	java/net/HttpURLConnection
    //   1029: astore 4
    //   1031: aload 4
    //   1033: iconst_0
    //   1034: invokevirtual 584	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1037: aload 4
    //   1039: iconst_1
    //   1040: invokevirtual 587	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1043: aload_0
    //   1044: getfield 102	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1047: iconst_2
    //   1048: invokevirtual 591	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1051: checkcast 593	mqq/app/TicketManagerImpl
    //   1054: astore 6
    //   1056: aload 4
    //   1058: ldc_w 595
    //   1061: new 140	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1068: ldc_w 597
    //   1071: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: getfield 102	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1078: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1081: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 600
    //   1087: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload 6
    //   1092: aload_0
    //   1093: getfield 102	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1096: invokevirtual 598	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1099: invokevirtual 603	mqq/app/TicketManagerImpl:getSkey	(Ljava/lang/String;)Ljava/lang/String;
    //   1102: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokevirtual 607	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: aload 4
    //   1113: ldc_w 609
    //   1116: invokevirtual 612	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1119: aload 4
    //   1121: ldc_w 614
    //   1124: ldc_w 616
    //   1127: invokevirtual 607	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1130: aload 4
    //   1132: ldc_w 618
    //   1135: ldc_w 620
    //   1138: invokevirtual 607	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1141: aload 4
    //   1143: ldc_w 622
    //   1146: new 140	java/lang/StringBuilder
    //   1149: dup
    //   1150: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1153: ldc_w 624
    //   1156: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: ldc_w 626
    //   1162: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: invokevirtual 607	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1171: new 628	java/io/DataOutputStream
    //   1174: dup
    //   1175: aload 4
    //   1177: invokevirtual 632	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1180: invokespecial 633	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1183: astore 6
    //   1185: aload 6
    //   1187: new 140	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1194: ldc_w 635
    //   1197: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: ldc_w 626
    //   1203: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: ldc_w 637
    //   1209: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokevirtual 640	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1218: aload 6
    //   1220: new 140	java/lang/StringBuilder
    //   1223: dup
    //   1224: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1227: ldc_w 642
    //   1230: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: aload 8
    //   1235: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: ldc_w 644
    //   1241: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: ldc_w 637
    //   1247: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokevirtual 640	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1256: aload 6
    //   1258: ldc_w 637
    //   1261: invokevirtual 640	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1264: new 476	java/io/FileInputStream
    //   1267: dup
    //   1268: aload 7
    //   1270: invokespecial 479	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1273: astore 7
    //   1275: aload 7
    //   1277: invokevirtual 647	java/io/FileInputStream:available	()I
    //   1280: istore 15
    //   1282: iload 15
    //   1284: ldc_w 648
    //   1287: invokestatic 654	java/lang/Math:min	(II)I
    //   1290: istore 16
    //   1292: iload 16
    //   1294: newarray <illegal type>
    //   1296: astore 8
    //   1298: aload 13
    //   1300: iload 15
    //   1302: i2f
    //   1303: invokestatic 657	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;F)F
    //   1306: pop
    //   1307: aload_0
    //   1308: getfield 328	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1311: invokevirtual 660	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	()Landroid/os/Handler;
    //   1314: new 662	uom
    //   1317: dup
    //   1318: aload_0
    //   1319: aload 13
    //   1321: lload_2
    //   1322: invokespecial 665	uom:<init>	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;J)V
    //   1325: ldc2_w 666
    //   1328: invokevirtual 671	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1331: pop
    //   1332: aload 7
    //   1334: aload 8
    //   1336: iconst_0
    //   1337: iload 16
    //   1339: invokevirtual 501	java/io/FileInputStream:read	([BII)I
    //   1342: istore 15
    //   1344: iload 15
    //   1346: ifle +50 -> 1396
    //   1349: aload 6
    //   1351: aload 8
    //   1353: iconst_0
    //   1354: iload 16
    //   1356: invokevirtual 672	java/io/DataOutputStream:write	([BII)V
    //   1359: aload 13
    //   1361: iload 15
    //   1363: i2f
    //   1364: invokestatic 674	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:b	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;F)F
    //   1367: pop
    //   1368: aload 7
    //   1370: invokevirtual 647	java/io/FileInputStream:available	()I
    //   1373: ldc_w 648
    //   1376: invokestatic 654	java/lang/Math:min	(II)I
    //   1379: istore 16
    //   1381: aload 7
    //   1383: aload 8
    //   1385: iconst_0
    //   1386: iload 16
    //   1388: invokevirtual 501	java/io/FileInputStream:read	([BII)I
    //   1391: istore 15
    //   1393: goto -49 -> 1344
    //   1396: aload 6
    //   1398: ldc_w 637
    //   1401: invokevirtual 640	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1404: aload 6
    //   1406: new 140	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1413: ldc_w 635
    //   1416: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: ldc_w 626
    //   1422: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: ldc_w 635
    //   1428: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: ldc_w 637
    //   1434: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokevirtual 640	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   1443: aload 4
    //   1445: invokevirtual 677	java/net/HttpURLConnection:getResponseCode	()I
    //   1448: istore 15
    //   1450: aload 4
    //   1452: invokevirtual 680	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1455: astore 8
    //   1457: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1460: ifeq +40 -> 1500
    //   1463: ldc 24
    //   1465: iconst_2
    //   1466: new 140	java/lang/StringBuilder
    //   1469: dup
    //   1470: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1473: ldc -13
    //   1475: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: iload 15
    //   1480: invokevirtual 683	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1483: ldc_w 685
    //   1486: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: aload 8
    //   1491: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1497: invokestatic 394	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1500: aload 6
    //   1502: invokevirtual 686	java/io/DataOutputStream:flush	()V
    //   1505: aload 6
    //   1507: invokevirtual 687	java/io/DataOutputStream:close	()V
    //   1510: aload 7
    //   1512: invokevirtual 487	java/io/FileInputStream:close	()V
    //   1515: iload 15
    //   1517: sipush 200
    //   1520: if_icmpne +535 -> 2055
    //   1523: iconst_1
    //   1524: istore 17
    //   1526: aload 6
    //   1528: ifnull +8 -> 1536
    //   1531: aload 6
    //   1533: invokevirtual 687	java/io/DataOutputStream:close	()V
    //   1536: iconst_0
    //   1537: ifeq +11 -> 1548
    //   1540: new 519	java/lang/NullPointerException
    //   1543: dup
    //   1544: invokespecial 520	java/lang/NullPointerException:<init>	()V
    //   1547: athrow
    //   1548: aload 4
    //   1550: ifnull +8 -> 1558
    //   1553: aload 4
    //   1555: invokevirtual 690	java/net/HttpURLConnection:disconnect	()V
    //   1558: iload 5
    //   1560: ifeq +45 -> 1605
    //   1563: aload_0
    //   1564: new 140	java/lang/StringBuilder
    //   1567: dup
    //   1568: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1571: aload_1
    //   1572: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: aload_0
    //   1576: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   1579: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1585: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   1588: astore_1
    //   1589: aload_1
    //   1590: ifnull +15 -> 1605
    //   1593: aload_1
    //   1594: invokevirtual 408	java/io/File:exists	()Z
    //   1597: ifeq +8 -> 1605
    //   1600: aload_1
    //   1601: invokevirtual 426	java/io/File:delete	()Z
    //   1604: pop
    //   1605: aload 13
    //   1607: iconst_1
    //   1608: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   1611: pop
    //   1612: iload 17
    //   1614: ireturn
    //   1615: astore_1
    //   1616: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1619: ifeq +13 -> 1632
    //   1622: ldc 24
    //   1624: iconst_2
    //   1625: ldc_w 525
    //   1628: aload_1
    //   1629: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1632: aload_1
    //   1633: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   1636: iload 17
    //   1638: ireturn
    //   1639: astore 8
    //   1641: aconst_null
    //   1642: astore 6
    //   1644: aconst_null
    //   1645: astore 7
    //   1647: aconst_null
    //   1648: astore 4
    //   1650: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1653: ifeq +14 -> 1667
    //   1656: ldc 24
    //   1658: iconst_2
    //   1659: ldc_w 692
    //   1662: aload 8
    //   1664: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1667: aload_0
    //   1668: lload_2
    //   1669: iconst_m1
    //   1670: iconst_1
    //   1671: anewarray 4	java/lang/Object
    //   1674: dup
    //   1675: iconst_0
    //   1676: aload 8
    //   1678: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1681: aastore
    //   1682: invokevirtual 359	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1685: aload 6
    //   1687: ifnull +8 -> 1695
    //   1690: aload 6
    //   1692: invokevirtual 687	java/io/DataOutputStream:close	()V
    //   1695: aload 4
    //   1697: ifnull +8 -> 1705
    //   1700: aload 4
    //   1702: invokevirtual 487	java/io/FileInputStream:close	()V
    //   1705: aload 7
    //   1707: ifnull +8 -> 1715
    //   1710: aload 7
    //   1712: invokevirtual 690	java/net/HttpURLConnection:disconnect	()V
    //   1715: iload 5
    //   1717: ifeq +45 -> 1762
    //   1720: aload_0
    //   1721: new 140	java/lang/StringBuilder
    //   1724: dup
    //   1725: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1728: aload_1
    //   1729: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: aload_0
    //   1733: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   1736: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1742: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   1745: astore_1
    //   1746: aload_1
    //   1747: ifnull +15 -> 1762
    //   1750: aload_1
    //   1751: invokevirtual 408	java/io/File:exists	()Z
    //   1754: ifeq +8 -> 1762
    //   1757: aload_1
    //   1758: invokevirtual 426	java/io/File:delete	()Z
    //   1761: pop
    //   1762: aload 13
    //   1764: iconst_1
    //   1765: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   1768: pop
    //   1769: iconst_0
    //   1770: ireturn
    //   1771: astore_1
    //   1772: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1775: ifeq +13 -> 1788
    //   1778: ldc 24
    //   1780: iconst_2
    //   1781: ldc_w 525
    //   1784: aload_1
    //   1785: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1788: aload_1
    //   1789: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   1792: iconst_0
    //   1793: ireturn
    //   1794: astore 4
    //   1796: aload 10
    //   1798: astore 7
    //   1800: aload 9
    //   1802: astore 8
    //   1804: aload 7
    //   1806: ifnull +8 -> 1814
    //   1809: aload 7
    //   1811: invokevirtual 687	java/io/DataOutputStream:close	()V
    //   1814: aload 8
    //   1816: ifnull +8 -> 1824
    //   1819: aload 8
    //   1821: invokevirtual 487	java/io/FileInputStream:close	()V
    //   1824: aload 6
    //   1826: ifnull +8 -> 1834
    //   1829: aload 6
    //   1831: invokevirtual 690	java/net/HttpURLConnection:disconnect	()V
    //   1834: iload 5
    //   1836: ifeq +45 -> 1881
    //   1839: aload_0
    //   1840: new 140	java/lang/StringBuilder
    //   1843: dup
    //   1844: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1847: aload_1
    //   1848: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: aload_0
    //   1852: getfield 100	com/tencent/mobileqq/secspy/SecSpyFileManager:c	Ljava/lang/String;
    //   1855: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1861: invokevirtual 484	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   1864: astore_1
    //   1865: aload_1
    //   1866: ifnull +15 -> 1881
    //   1869: aload_1
    //   1870: invokevirtual 408	java/io/File:exists	()Z
    //   1873: ifeq +8 -> 1881
    //   1876: aload_1
    //   1877: invokevirtual 426	java/io/File:delete	()Z
    //   1880: pop
    //   1881: aload 13
    //   1883: iconst_1
    //   1884: invokestatic 523	com/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$UploadProgressInfo;Z)Z
    //   1887: pop
    //   1888: aload 4
    //   1890: athrow
    //   1891: astore_1
    //   1892: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1895: ifeq +13 -> 1908
    //   1898: ldc 24
    //   1900: iconst_2
    //   1901: ldc_w 525
    //   1904: aload_1
    //   1905: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1908: aload_1
    //   1909: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   1912: goto -24 -> 1888
    //   1915: astore 7
    //   1917: aload 4
    //   1919: astore 6
    //   1921: aload 7
    //   1923: astore 4
    //   1925: aload 9
    //   1927: astore 8
    //   1929: aload 10
    //   1931: astore 7
    //   1933: goto -129 -> 1804
    //   1936: astore 8
    //   1938: aload 6
    //   1940: astore 7
    //   1942: aload 4
    //   1944: astore 6
    //   1946: aload 8
    //   1948: astore 4
    //   1950: aload 9
    //   1952: astore 8
    //   1954: goto -150 -> 1804
    //   1957: astore 9
    //   1959: aload 7
    //   1961: astore 8
    //   1963: aload 6
    //   1965: astore 7
    //   1967: aload 4
    //   1969: astore 6
    //   1971: aload 9
    //   1973: astore 4
    //   1975: goto -171 -> 1804
    //   1978: astore 10
    //   1980: aload 7
    //   1982: astore 8
    //   1984: aload 6
    //   1986: astore 7
    //   1988: aload 4
    //   1990: astore 9
    //   1992: aload 10
    //   1994: astore 4
    //   1996: aload 8
    //   1998: astore 6
    //   2000: aload 9
    //   2002: astore 8
    //   2004: goto -200 -> 1804
    //   2007: astore 8
    //   2009: aconst_null
    //   2010: astore 9
    //   2012: aconst_null
    //   2013: astore 6
    //   2015: aload 4
    //   2017: astore 7
    //   2019: aload 9
    //   2021: astore 4
    //   2023: goto -373 -> 1650
    //   2026: astore 8
    //   2028: aload 4
    //   2030: astore 7
    //   2032: aconst_null
    //   2033: astore 4
    //   2035: goto -385 -> 1650
    //   2038: astore 8
    //   2040: aload 4
    //   2042: astore 9
    //   2044: aload 7
    //   2046: astore 4
    //   2048: aload 9
    //   2050: astore 7
    //   2052: goto -402 -> 1650
    //   2055: iconst_0
    //   2056: istore 17
    //   2058: goto -532 -> 1526
    //   2061: goto -1080 -> 981
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2064	0	this	SecSpyFileManager
    //   0	2064	1	paramString1	String
    //   0	2064	2	paramLong	long
    //   0	2064	4	paramString2	String
    //   0	2064	5	paramBoolean	boolean
    //   10	2004	6	localObject1	Object
    //   416	1394	7	localObject2	Object
    //   1915	7	7	localObject3	Object
    //   1931	120	7	localObject4	Object
    //   412	1078	8	localObject5	Object
    //   1639	38	8	localException1	Exception
    //   1802	126	8	localObject6	Object
    //   1936	11	8	localObject7	Object
    //   1952	51	8	localObject8	Object
    //   2007	1	8	localException2	Exception
    //   2026	1	8	localException3	Exception
    //   2038	1	8	localException4	Exception
    //   16	1935	9	localObject9	Object
    //   1957	15	9	localObject10	Object
    //   1990	59	9	str1	String
    //   13	1917	10	localObject11	Object
    //   1978	15	10	localObject12	Object
    //   33	899	11	localObject13	Object
    //   408	489	12	localObject14	Object
    //   26	1856	13	localUploadProgressInfo	SecSpyFileManager.UploadProgressInfo
    //   906	28	14	str2	String
    //   1280	241	15	i1	int
    //   1290	97	16	i2	int
    //   1524	533	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   107	115	195	java/lang/Exception
    //   119	127	195	java/lang/Exception
    //   131	139	195	java/lang/Exception
    //   144	170	195	java/lang/Exception
    //   174	186	195	java/lang/Exception
    //   186	193	195	java/lang/Exception
    //   285	293	373	java/lang/Exception
    //   297	305	373	java/lang/Exception
    //   309	317	373	java/lang/Exception
    //   322	348	373	java/lang/Exception
    //   352	364	373	java/lang/Exception
    //   364	371	373	java/lang/Exception
    //   550	558	638	java/lang/Exception
    //   562	570	638	java/lang/Exception
    //   574	582	638	java/lang/Exception
    //   587	613	638	java/lang/Exception
    //   617	629	638	java/lang/Exception
    //   629	636	638	java/lang/Exception
    //   665	673	753	java/lang/Exception
    //   677	685	753	java/lang/Exception
    //   689	697	753	java/lang/Exception
    //   702	728	753	java/lang/Exception
    //   732	744	753	java/lang/Exception
    //   744	751	753	java/lang/Exception
    //   1531	1536	1615	java/lang/Exception
    //   1540	1548	1615	java/lang/Exception
    //   1553	1558	1615	java/lang/Exception
    //   1563	1589	1615	java/lang/Exception
    //   1593	1605	1615	java/lang/Exception
    //   1605	1612	1615	java/lang/Exception
    //   28	35	1639	java/lang/Exception
    //   40	56	1639	java/lang/Exception
    //   56	103	1639	java/lang/Exception
    //   218	281	1639	java/lang/Exception
    //   396	410	1639	java/lang/Exception
    //   423	482	1639	java/lang/Exception
    //   487	495	1639	java/lang/Exception
    //   499	507	1639	java/lang/Exception
    //   507	546	1639	java/lang/Exception
    //   776	886	1639	java/lang/Exception
    //   886	952	1639	java/lang/Exception
    //   955	981	1639	java/lang/Exception
    //   981	1014	1639	java/lang/Exception
    //   1014	1031	1639	java/lang/Exception
    //   1690	1695	1771	java/lang/Exception
    //   1700	1705	1771	java/lang/Exception
    //   1710	1715	1771	java/lang/Exception
    //   1720	1746	1771	java/lang/Exception
    //   1750	1762	1771	java/lang/Exception
    //   1762	1769	1771	java/lang/Exception
    //   28	35	1794	finally
    //   40	56	1794	finally
    //   56	103	1794	finally
    //   218	281	1794	finally
    //   396	410	1794	finally
    //   423	482	1794	finally
    //   487	495	1794	finally
    //   499	507	1794	finally
    //   507	546	1794	finally
    //   776	886	1794	finally
    //   886	952	1794	finally
    //   955	981	1794	finally
    //   981	1014	1794	finally
    //   1014	1031	1794	finally
    //   1809	1814	1891	java/lang/Exception
    //   1819	1824	1891	java/lang/Exception
    //   1829	1834	1891	java/lang/Exception
    //   1839	1865	1891	java/lang/Exception
    //   1869	1881	1891	java/lang/Exception
    //   1881	1888	1891	java/lang/Exception
    //   1031	1185	1915	finally
    //   1185	1275	1936	finally
    //   1275	1344	1957	finally
    //   1349	1393	1957	finally
    //   1396	1500	1957	finally
    //   1500	1515	1957	finally
    //   1650	1667	1978	finally
    //   1667	1685	1978	finally
    //   1031	1185	2007	java/lang/Exception
    //   1185	1275	2026	java/lang/Exception
    //   1275	1344	2038	java/lang/Exception
    //   1349	1393	2038	java/lang/Exception
    //   1396	1500	2038	java/lang/Exception
    //   1500	1515	2038	java/lang/Exception
  }
  
  public void b(List paramList, long paramLong, String paramString)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a(paramList), paramLong, paramString, false);
    UnifiedFileUtil.a(paramList);
    paramList.clear();
  }
  
  public void onDestroy()
  {
    UnifiedDebugManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\secspy\SecSpyFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */