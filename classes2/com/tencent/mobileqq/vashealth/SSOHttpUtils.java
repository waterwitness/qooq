package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;
import wfg;

public class SSOHttpUtils
{
  public static float a = 0.0F;
  public static final int a = 30000;
  public static long a = 0L;
  public static String a;
  public static boolean a = false;
  private static String[] a;
  public static final int b = 1;
  static long jdField_b_of_type_Long = 0L;
  static String jdField_b_of_type_JavaLangString;
  private static String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final int c = 2;
  private static final long c = 604800000L;
  public static final String c = BaseApplicationImpl.a().getFilesDir() + File.separator + "step.info";
  public static int d = 0;
  public static final String d = "4eY#X@~g.+U)2%$<";
  public static int e = 0;
  static String e;
  public static int f = 0;
  static String f;
  private static final String g = "SSOHttpUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "";
  }
  
  private static int a(String paramString)
  {
    int k = 0;
    int j = 5381;
    String str = "";
    String[] arrayOfString = paramString.split(";");
    paramString = str;
    int m;
    int i;
    if (arrayOfString.length > 0)
    {
      m = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      paramString = str;
      if (i < m)
      {
        paramString = arrayOfString[i];
        if (paramString.indexOf("skey") > 0)
        {
          paramString = paramString.split("=");
          if (paramString.length == 2) {
            paramString = paramString[1];
          }
        }
      }
      else
      {
        m = paramString.length();
        i = k;
        while (i < m)
        {
          j += (j << 5) + paramString.charAt(i);
          i += 1;
        }
      }
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: new 122	com/tencent/qphone/base/util/Cryptor
    //   3: dup
    //   4: invokespecial 123	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   7: astore_0
    //   8: new 125	java/io/RandomAccessFile
    //   11: dup
    //   12: getstatic 75	com/tencent/mobileqq/vashealth/SSOHttpUtils:c	Ljava/lang/String;
    //   15: ldc 127
    //   17: invokespecial 130	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 132	java/io/RandomAccessFile:length	()J
    //   27: l2i
    //   28: newarray <illegal type>
    //   30: astore_3
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 136	java/io/RandomAccessFile:read	([B)I
    //   38: pop
    //   39: aload_2
    //   40: astore_1
    //   41: new 82	java/lang/String
    //   44: dup
    //   45: aload_0
    //   46: aload_3
    //   47: ldc 25
    //   49: invokevirtual 140	java/lang/String:getBytes	()[B
    //   52: invokevirtual 144	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   55: invokespecial 147	java/lang/String:<init>	([B)V
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   65: aload_0
    //   66: astore_1
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 152	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: aload_1
    //   80: invokestatic 156	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	(Ljava/lang/String;)V
    //   83: return
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_2
    //   90: astore_1
    //   91: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +33 -> 127
    //   97: aload_2
    //   98: astore_1
    //   99: ldc 30
    //   101: iconst_2
    //   102: new 43	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   109: ldc -92
    //   111: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 165	java/lang/Exception:toString	()Ljava/lang/String;
    //   118: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 169	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: astore_1
    //   129: aload_2
    //   130: ifnull -51 -> 79
    //   133: aload_2
    //   134: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   137: aload_0
    //   138: astore_1
    //   139: goto -60 -> 79
    //   142: astore_1
    //   143: aload_0
    //   144: astore_1
    //   145: goto -66 -> 79
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   159: aload_0
    //   160: athrow
    //   161: astore_1
    //   162: aload_0
    //   163: astore_1
    //   164: goto -85 -> 79
    //   167: astore_1
    //   168: goto -9 -> 159
    //   171: astore_0
    //   172: goto -21 -> 151
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -89 -> 89
    //   181: astore_3
    //   182: goto -93 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	137	0	localObject1	Object
    //   148	15	0	localObject2	Object
    //   171	1	0	localObject3	Object
    //   177	1	0	localObject4	Object
    //   22	117	1	localObject5	Object
    //   142	1	1	localIOException1	java.io.IOException
    //   144	12	1	localObject6	Object
    //   161	1	1	localIOException2	java.io.IOException
    //   163	1	1	localObject7	Object
    //   167	1	1	localIOException3	java.io.IOException
    //   20	114	2	localRandomAccessFile	java.io.RandomAccessFile
    //   30	17	3	arrayOfByte	byte[]
    //   84	31	3	localException1	Exception
    //   175	1	3	localException2	Exception
    //   181	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	84	java/lang/Exception
    //   133	137	142	java/io/IOException
    //   0	21	148	finally
    //   71	79	161	java/io/IOException
    //   155	159	167	java/io/IOException
    //   23	31	171	finally
    //   33	39	171	finally
    //   41	59	171	finally
    //   61	65	171	finally
    //   91	97	171	finally
    //   99	127	171	finally
    //   23	31	175	java/lang/Exception
    //   33	39	175	java/lang/Exception
    //   41	59	175	java/lang/Exception
    //   61	65	181	java/lang/Exception
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      int i = NetworkUtil.a(BaseApplicationImpl.a());
      paramString = "";
      switch (i)
      {
      }
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "HealthStepReport", "", "ReportResult", paramString, paramInt, 1, jdField_f_of_type_Int, String.valueOf(jdField_e_of_type_Int), String.valueOf(d), str, Build.MODEL);
        return;
        paramString = "no_network";
        continue;
        paramString = "wifi";
        continue;
        paramString = "2g";
        continue;
        paramString = "3g";
        continue;
        paramString = "4g";
        continue;
        paramString = "unknown";
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 1000L) {}
    Object localObject1;
    long l2;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          jdField_b_of_type_Long = System.currentTimeMillis();
        } while ((System.currentTimeMillis() - jdField_a_of_type_Long < 30000L) || (TextUtils.isEmpty(paramString)));
        jdField_a_of_type_Boolean = false;
        try
        {
          localObject1 = new JSONObject(paramString);
          if (((JSONObject)localObject1).getBoolean("isStepCounterEnable")) {
            break;
          }
          QLog.i("SSOHttpUtils", 1, "step counter off.");
          a(-2, "step counter off");
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.e("SSOHttpUtils", 2, "report step count Exception:" + paramString);
      return;
      paramString = new HashMap();
      l2 = a();
      localObject2 = String.valueOf(l2);
    } while ((!((JSONObject)localObject1).has((String)localObject2 + "_total")) || (!((JSONObject)localObject1).has((String)localObject2 + "_init")));
    d = ((JSONObject)localObject1).getInt((String)localObject2 + "_total");
    jdField_e_of_type_Int = ((JSONObject)localObject1).getInt((String)localObject2 + "_init");
    jdField_f_of_type_Int = ((JSONObject)localObject1).getInt((String)localObject2 + "_offset");
    int k = d - jdField_e_of_type_Int + jdField_f_of_type_Int;
    QLog.i("SSOHttpUtils", 1, "file contains cur_init:" + jdField_e_of_type_Int + ",cur_total:" + d + ",cur_offset:" + jdField_f_of_type_Int);
    if (k > 0) {
      paramString.put(Long.valueOf(NetConnInfoCenter.getServerTime() * 1000L), Integer.valueOf(k));
    }
    long l1;
    if (((JSONObject)localObject1).has("last_report_time"))
    {
      l1 = ((JSONObject)localObject1).getLong("last_report_time");
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(l1);
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      l1 = ((Calendar)localObject2).getTimeInMillis();
      if (l2 - l1 <= 604800000L) {
        break label979;
      }
      ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) - 6);
      l1 = ((Calendar)localObject2).getTimeInMillis();
    }
    label979:
    for (;;)
    {
      Object localObject3;
      if (l1 < l2)
      {
        localObject3 = String.valueOf(l1);
        if ((!((JSONObject)localObject1).has((String)localObject3 + "_init")) || (!((JSONObject)localObject1).has((String)localObject3 + "_total")))
        {
          ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) + 1);
          l1 = ((Calendar)localObject2).getTimeInMillis();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("SSOHttpUtils", 2, "report yesterday~");
          }
          int j = ((JSONObject)localObject1).getInt((String)localObject3 + "_total") - ((JSONObject)localObject1).getInt((String)localObject3 + "_init");
          localObject3 = (String)localObject3 + "_offset";
          int i = j;
          if (((JSONObject)localObject1).has((String)localObject3))
          {
            jdField_a_of_type_Boolean = true;
            i = j + ((JSONObject)localObject1).getInt((String)localObject3);
          }
          if (i > 0) {
            paramString.put(Long.valueOf(l1 + 86399000L), Integer.valueOf(i));
          }
          ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) + 1);
          l1 = ((Calendar)localObject2).getTimeInMillis();
        }
      }
      else
      {
        if (paramString.isEmpty())
        {
          a(-3, "parameter is Empty.");
          return;
        }
        if ((k == jdField_a_of_type_Float) && (k > 0) && (paramString.size() == 1))
        {
          localObject1 = BaseApplicationImpl.a().a().getAccount();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(jdField_a_of_type_JavaLangString)))
          {
            QLog.i("SSOHttpUtils", 1, "steps duplicate , return.");
            return;
          }
        }
        localObject1 = new JSONArray();
        paramString = paramString.entrySet().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (Map.Entry)paramString.next();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("type", 1);
          ((JSONObject)localObject3).put("time", ((Long)((Map.Entry)localObject2).getKey()).longValue() / 1000L);
          ((JSONObject)localObject3).put("distance", 0);
          ((JSONObject)localObject3).put("steps", ((Integer)((Map.Entry)localObject2).getValue()).longValue());
          ((JSONObject)localObject3).put("duration", 0);
          ((JSONObject)localObject3).put("calories", 0);
          ((JSONObject)localObject3).put("achieve", 0);
          ((JSONObject)localObject3).put("target", 0);
          ((JSONArray)localObject1).put(localObject3);
        }
        b(((JSONArray)localObject1).toString());
        return;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject1;
    if ((jdField_a_of_type_ArrayOfJavaLangString == null) || (jdField_b_of_type_ArrayOfJavaLangString == null))
    {
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), ClubContentJsonTask.i.jdField_b_of_type_JavaLangString);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("login_report");
      localObject2 = ((JSONObject)localObject2).optString("timmer_report");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        jdField_a_of_type_ArrayOfJavaLangString = ((String)localObject1).split(",");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject2).split(",");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("SSOHttpUtils", 2, "parse json failed:" + localException.toString());
          continue;
          paramInt += 1;
        }
      }
      if ((paramInt != 2) || (jdField_b_of_type_ArrayOfJavaLangString == null) || (jdField_b_of_type_ArrayOfJavaLangString.length == 0)) {
        break label341;
      }
      String str = BaseApplicationImpl.a().a().getAccount();
      if (TextUtils.isEmpty(str)) {
        break label341;
      }
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= jdField_b_of_type_ArrayOfJavaLangString.length) {
          break label341;
        }
        if (str.endsWith(jdField_b_of_type_ArrayOfJavaLangString[paramInt]))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SSOHttpUtils", 2, "timmer report found current uin banned!");
          return false;
        }
        paramInt += 1;
      }
    }
    if (jdField_a_of_type_ArrayOfJavaLangString == null) {
      jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    }
    if (jdField_b_of_type_ArrayOfJavaLangString == null) {
      jdField_b_of_type_ArrayOfJavaLangString = new String[0];
    }
    if (paramInt == 1)
    {
      if ((jdField_a_of_type_ArrayOfJavaLangString == null) || (jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {
        break label341;
      }
      localObject1 = BaseApplicationImpl.a().a().getAccount();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label341;
      }
      paramInt = 0;
      if (paramInt >= jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label341;
      }
      if (((String)localObject1).endsWith(jdField_a_of_type_ArrayOfJavaLangString[paramInt]))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SSOHttpUtils", 2, "login report found current uin banned!");
        }
        return false;
      }
    }
    label341:
    return true;
  }
  
  private static void b(String paramString)
  {
    Object localObject1 = (TicketManager)BaseApplicationImpl.a().a().getManager(2);
    Object localObject2 = BaseApplicationImpl.a().a().getAccount();
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    String str1 = String.format("uin=o0%s; skey=%s; vkey=", new Object[] { localObject2, ((TicketManager)localObject1).getSkey((String)localObject2) });
    if (str1.indexOf(',') != -1) {
      str1.replace(',', ';');
    }
    localObject1 = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("oauth_consumer_key=1002&");
      String str2 = URLEncoder.encode(paramString, "utf-8");
      localStringBuilder.append("data=" + str2);
      localStringBuilder.append("&format=json&key=");
      localStringBuilder.append(Md5Utils.getMD5(paramString + "qlDFDfnbma!@23DKEd["));
      localStringBuilder.append("&version=");
      localStringBuilder.append("6.5.5");
      localStringBuilder.append("&model=");
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        jdField_b_of_type_JavaLangString = URLEncoder.encode(Build.MODEL, "utf-8");
      }
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      if (TextUtils.isEmpty(jdField_e_of_type_JavaLangString))
      {
        paramString = TimeZone.getDefault();
        jdField_e_of_type_JavaLangString = URLEncoder.encode(paramString.getDisplayName(false, 0) + " " + paramString.getID(), "utf-8");
      }
      if (!TextUtils.isEmpty(jdField_e_of_type_JavaLangString))
      {
        localStringBuilder.append("&zone=");
        localStringBuilder.append(jdField_e_of_type_JavaLangString);
      }
      if (TextUtils.isEmpty(jdField_f_of_type_JavaLangString)) {
        jdField_f_of_type_JavaLangString = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getDeviceId();
      }
      if (!TextUtils.isEmpty(jdField_f_of_type_JavaLangString))
      {
        localStringBuilder.append("&imei=");
        localStringBuilder.append(jdField_f_of_type_JavaLangString);
      }
      paramString = BaseApplicationImpl.a().getSharedPreferences((String)localObject2, 0);
      double d1 = paramString.getFloat("search_lbs_logitude", 0.0F);
      double d2 = paramString.getFloat("search_lbs_latitude", 0.0F);
      if ((d1 != 0.0D) && (d2 != 0.0D))
      {
        localStringBuilder.append("&latitude=");
        localStringBuilder.append(String.valueOf(d2));
        localStringBuilder.append("&longitude=");
        localStringBuilder.append(String.valueOf(d1));
      }
      ((JSONObject)localObject1).put("Cookie", str1);
      ((JSONObject)localObject1).put("cmd", "httpagent_sh.http");
      ((JSONObject)localObject1).put("url", "http://open.jiankang.qq.com/cgi-bin/qqhealth_report_health_data?g_tk=" + a(str1));
      ((JSONObject)localObject1).put("Content-Type", "application/x-www-form-urlencoded");
      ((JSONObject)localObject1).put("needCookie", "1");
      ((JSONObject)localObject1).put("method", "POST");
      ((JSONObject)localObject1).put("content", localStringBuilder.toString());
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SSOHttpUtils", 2, "Exception:" + paramString.toString());
        }
      }
    }
    localObject2 = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("6.5.5");
    paramString = new WebSSOAgent.UniSsoServerReq();
    paramString.comm.set((MessageMicro)localObject2);
    paramString.reqdata.set(((JSONObject)localObject1).toString());
    if (QLog.isColorLevel()) {
      QLog.i("SSOHttpUtils", 2, "parameter:" + ((JSONObject)localObject1).toString());
    }
    localObject1 = new NewIntent(BaseApplicationImpl.a().getApplicationContext(), WebSSOAgentServlet.class);
    ((NewIntent)localObject1).putExtra("extra_cmd", "httpagent_sh.http");
    ((NewIntent)localObject1).putExtra("extra_data", paramString.toByteArray());
    ((NewIntent)localObject1).putExtra("extra_callbackid", "callbackId");
    ((NewIntent)localObject1).setObserver(new wfg());
    BaseApplicationImpl.a().a().startServlet((NewIntent)localObject1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vashealth\SSOHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */