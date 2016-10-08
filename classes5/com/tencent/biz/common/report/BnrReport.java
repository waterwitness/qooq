package com.tencent.biz.common.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.bnr.BnrReport.BNRConfigMsg;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfig;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigReq;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigRsp;
import com.tencent.mobileqq.bnr.BnrReport.BNReportGroupInfo;
import com.tencent.mobileqq.bnr.BnrReport.ExtInfo;
import com.tencent.mobileqq.bnr.BnrReport.RetInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BnrReport
{
  protected static final long a = 43200000L;
  protected static final String a = "BnrReport";
  protected static ArrayList a;
  protected static boolean a = false;
  protected static long b = 0L;
  protected static final String b = "bnr_last_up_time";
  protected static boolean b = false;
  protected static final String c = "bnr_open_report_id";
  protected static final String d = "bnr_group_update_ver";
  protected static final String e = "qb_report_config.json";
  
  public BnrReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static int a(int paramInt)
  {
    if (a == null) {
      return -1;
    }
    int i = 0;
    int j = a.size();
    while (i < j)
    {
      if (((Integer)a.get(i)).intValue() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected static long a()
  {
    return BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).getLong("bnr_last_up_time", 0L);
  }
  
  /* Error */
  protected static SparseIntArray a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 43	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 81	java/util/ArrayList:<init>	()V
    //   10: pop
    //   11: invokestatic 84	com/tencent/biz/common/report/BnrReport:a	()Lorg/json/JSONObject;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 86	android/util/SparseIntArray
    //   24: dup
    //   25: invokespecial 87	android/util/SparseIntArray:<init>	()V
    //   28: astore_0
    //   29: aload_1
    //   30: ldc 89
    //   32: invokevirtual 95	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 100	org/json/JSONArray:length	()I
    //   40: istore 5
    //   42: iconst_0
    //   43: istore_3
    //   44: iload_3
    //   45: iload 5
    //   47: if_icmpge +40 -> 87
    //   50: aload_0
    //   51: aload_1
    //   52: iload_3
    //   53: invokevirtual 104	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   56: ldc 106
    //   58: invokevirtual 110	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   61: iconst_0
    //   62: invokevirtual 114	android/util/SparseIntArray:put	(II)V
    //   65: iload_3
    //   66: iconst_1
    //   67: iadd
    //   68: istore_3
    //   69: goto -25 -> 44
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   84: goto -19 -> 65
    //   87: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   90: ldc 65
    //   92: iconst_0
    //   93: invokevirtual 69	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   96: ldc 25
    //   98: ldc 119
    //   100: invokeinterface 123 3 0
    //   105: astore_1
    //   106: invokestatic 129	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   109: ifeq +28 -> 137
    //   112: ldc 11
    //   114: iconst_4
    //   115: new 131	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   122: ldc -122
    //   124: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_1
    //   128: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_1
    //   138: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +69 -> 210
    //   144: aload_1
    //   145: ldc -103
    //   147: invokevirtual 159	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   150: astore_1
    //   151: aload_1
    //   152: arraylength
    //   153: istore 5
    //   155: iload 4
    //   157: istore_3
    //   158: iload_3
    //   159: iload 5
    //   161: if_icmpge +49 -> 210
    //   164: aload_1
    //   165: iload_3
    //   166: aaload
    //   167: ldc -95
    //   169: invokevirtual 159	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   172: astore_2
    //   173: aload_0
    //   174: aload_2
    //   175: iconst_0
    //   176: aaload
    //   177: invokestatic 165	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   180: invokevirtual 56	java/lang/Integer:intValue	()I
    //   183: aload_2
    //   184: iconst_1
    //   185: aaload
    //   186: invokestatic 165	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   189: invokevirtual 56	java/lang/Integer:intValue	()I
    //   192: invokevirtual 114	android/util/SparseIntArray:put	(II)V
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: goto -41 -> 158
    //   202: astore_2
    //   203: aload_2
    //   204: invokevirtual 166	java/lang/NumberFormatException:printStackTrace	()V
    //   207: goto -12 -> 195
    //   210: aload_0
    //   211: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	23	0	localSparseIntArray	SparseIntArray
    //   72	139	0	localJSONException1	JSONException
    //   14	151	1	localObject	Object
    //   79	2	2	localJSONException2	JSONException
    //   172	12	2	arrayOfString	String[]
    //   202	2	2	localNumberFormatException	NumberFormatException
    //   43	156	3	i	int
    //   1	155	4	j	int
    //   40	122	5	k	int
    // Exception table:
    //   from	to	target	type
    //   29	36	72	org/json/JSONException
    //   50	65	79	org/json/JSONException
    //   164	195	202	java/lang/NumberFormatException
  }
  
  protected static BnrReport.BNRConfigMsg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
      paramString = "";
    }
    catch (NumberFormatException paramString)
    {
      Object localObject1;
      label43:
      Object localObject3;
      String str;
      int j;
      int i;
      paramString.printStackTrace();
      return null;
    }
    try
    {
      localObject1 = BaseApplication.getContext();
      localObject1 = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 0).versionName;
      paramString = (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      break label43;
      localObject2 = new BnrReport.BNRConfigMsg();
      ((BnrReport.BNRConfigMsg)localObject2).uin.set(l);
      ((BnrReport.BNRConfigMsg)localObject2).cmd.set(0);
      ((BnrReport.BNRConfigMsg)localObject2).seq.set(0);
      ((BnrReport.BNRConfigMsg)localObject2).ext_info.set(localNameNotFoundException);
      ((BnrReport.BNRConfigMsg)localObject2).msg_req_body.set(paramString);
    }
    localObject1 = Build.BRAND;
    localObject3 = Build.MODEL;
    str = Build.VERSION.RELEASE;
    Object localObject2 = new StringBuffer("android");
    ((StringBuffer)localObject2).append(" ").append(Build.VERSION.SDK_INT);
    ((StringBuffer)localObject2).append(" ").append(str);
    ((StringBuffer)localObject2).append(" ").append((String)localObject1);
    ((StringBuffer)localObject2).append(" ").append((String)localObject3);
    localObject1 = new BnrReport.ExtInfo();
    ((BnrReport.ExtInfo)localObject1).app_ver.set(paramString);
    ((BnrReport.ExtInfo)localObject1).sys_ver.set(((StringBuffer)localObject2).toString());
    paramString = new BnrReport.BNReportConfigReq();
    localObject2 = a();
    if (localObject2 != null)
    {
      j = ((SparseIntArray)localObject2).size();
      i = 0;
      while (i < j)
      {
        int k = ((SparseIntArray)localObject2).keyAt(i);
        int m = ((SparseIntArray)localObject2).get(k);
        localObject3 = new BnrReport.BNReportGroupInfo();
        ((BnrReport.BNReportGroupInfo)localObject3).id.set(k);
        ((BnrReport.BNReportGroupInfo)localObject3).seqno.set(m);
        paramString.group_info.add((MessageMicro)localObject3);
        i += 1;
      }
    }
    return (BnrReport.BNRConfigMsg)localObject2;
  }
  
  protected static JSONObject a()
  {
    try
    {
      InputStream localInputStream = BaseApplication.getContext().getAssets().open("qb_report_config.json");
      Object localObject = Util.a(localInputStream);
      try
      {
        localInputStream.close();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
      }
      catch (IOException localIOException2)
      {
        do
        {
          for (;;)
          {
            localIOException2.printStackTrace();
          }
          try
          {
            localObject = new JSONObject((String)localObject);
            return (JSONObject)localObject;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        } while (!QLog.isColorLevel());
        QLog.i("BnrReport", 2, "error : loadAllConfig");
        return null;
      }
      return null;
    }
    catch (IOException localIOException1) {}
  }
  
  public static void a()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "BnrReport init");
    }
    jdField_b_of_type_Boolean = true;
  }
  
  protected static void a(SparseIntArray paramSparseIntArray)
  {
    if (paramSparseIntArray == null) {}
    StringBuffer localStringBuffer;
    do
    {
      return;
      localStringBuffer = new StringBuffer("");
      int j = paramSparseIntArray.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          localStringBuffer.append("|");
        }
        int k = paramSparseIntArray.keyAt(i);
        localStringBuffer.append(k).append("-").append(paramSparseIntArray.get(k));
        i += 1;
      }
      paramSparseIntArray = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
      paramSparseIntArray.putString("bnr_group_update_ver", localStringBuffer.toString());
      paramSparseIntArray.commit();
    } while (!QLog.isDevelopLevel());
    QLog.d("BnrReport", 4, "server ver:" + localStringBuffer.toString());
  }
  
  protected static void a(AppInterface paramAppInterface) {}
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    a(paramAppInterface, paramInt, "", 0, 0, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (a(paramInt1))
    {
      ReportController.b(null, "P_CliOper", "AppBernoulliReport", "", paramInt1 + "", paramString1, paramInt2, paramInt3, paramString2, paramString3, paramString3, paramString4);
      if (!QLog.isDevelopLevel()) {}
    }
    if (paramAppInterface != null) {
      a(paramAppInterface);
    }
  }
  
  protected static void a(BnrReport.BNReportConfigRsp paramBNReportConfigRsp)
  {
    if ((paramBNReportConfigRsp == null) || (((BnrReport.RetInfo)((BnrReport.RetInfo)paramBNReportConfigRsp.ret_info.get()).get()).ret_code.get() != 0L)) {}
    List localList;
    JSONObject localJSONObject;
    do
    {
      do
      {
        return;
        localList = paramBNReportConfigRsp.cfglist.get();
      } while (localList == null);
      localJSONObject = a();
    } while (localJSONObject == null);
    paramBNReportConfigRsp = a();
    if (paramBNReportConfigRsp == null) {
      paramBNReportConfigRsp = new SparseIntArray();
    }
    for (;;)
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        BnrReport.BNReportConfig localBNReportConfig = (BnrReport.BNReportConfig)((BnrReport.BNReportConfig)localList.get(i)).get();
        int k = localBNReportConfig.id.get();
        int m = localBNReportConfig.seqno.get();
        localSparseIntArray.put(k, m);
        if ((paramBNReportConfigRsp.get(k) > 0) && (paramBNReportConfigRsp.get(k) == m)) {}
        for (;;)
        {
          i += 1;
          break;
          a(localJSONObject, k, false);
          a(localJSONObject, localBNReportConfig.idList.get(), false);
        }
      }
      a(localSparseIntArray);
      d();
      b();
      return;
    }
  }
  
  /* Error */
  protected static void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +23 -> 24
    //   4: iload_1
    //   5: iconst_1
    //   6: if_icmplt +18 -> 24
    //   9: getstatic 41	com/tencent/biz/common/report/BnrReport:a	Ljava/util/ArrayList;
    //   12: ifnull +12 -> 24
    //   15: getstatic 41	com/tencent/biz/common/report/BnrReport:a	Ljava/util/ArrayList;
    //   18: invokevirtual 47	java/util/ArrayList:size	()I
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: ldc 106
    //   28: invokevirtual 110	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   31: istore 4
    //   33: iload 4
    //   35: invokestatic 445	com/tencent/biz/common/report/BnrReport:a	(I)I
    //   38: iconst_m1
    //   39: if_icmple +15 -> 54
    //   42: getstatic 41	com/tencent/biz/common/report/BnrReport:a	Ljava/util/ArrayList;
    //   45: iload 4
    //   47: invokestatic 445	com/tencent/biz/common/report/BnrReport:a	(I)I
    //   50: invokevirtual 448	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   53: pop
    //   54: aload_0
    //   55: ldc 89
    //   57: invokevirtual 95	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull -38 -> 24
    //   65: aload_0
    //   66: invokevirtual 100	org/json/JSONArray:length	()I
    //   69: istore 5
    //   71: iconst_0
    //   72: istore 4
    //   74: iload 4
    //   76: iload 5
    //   78: if_icmpge -54 -> 24
    //   81: aload_0
    //   82: iload 4
    //   84: invokevirtual 104	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   87: astore_3
    //   88: aload_3
    //   89: ldc 106
    //   91: invokevirtual 110	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   94: iload_1
    //   95: if_icmpeq +7 -> 102
    //   98: iload_2
    //   99: ifeq +9 -> 108
    //   102: aload_3
    //   103: iload_1
    //   104: iconst_1
    //   105: invokestatic 427	com/tencent/biz/common/report/BnrReport:a	(Lorg/json/JSONObject;IZ)V
    //   108: iload 4
    //   110: iconst_1
    //   111: iadd
    //   112: istore 4
    //   114: goto -40 -> 74
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   122: return
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   128: aconst_null
    //   129: astore_0
    //   130: goto -69 -> 61
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   138: goto -30 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramJSONObject	JSONObject
    //   0	141	1	paramInt	int
    //   0	141	2	paramBoolean	boolean
    //   87	16	3	localJSONObject	JSONObject
    //   133	2	3	localJSONException	JSONException
    //   31	82	4	i	int
    //   69	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   25	33	117	org/json/JSONException
    //   54	61	123	org/json/JSONException
    //   81	98	133	org/json/JSONException
    //   102	108	133	org/json/JSONException
  }
  
  /* Error */
  protected static void a(JSONObject paramJSONObject, List paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokeinterface 416 1 0
    //   14: ifne +4 -> 18
    //   17: return
    //   18: getstatic 41	com/tencent/biz/common/report/BnrReport:a	Ljava/util/ArrayList;
    //   21: ifnonnull +13 -> 34
    //   24: new 43	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 81	java/util/ArrayList:<init>	()V
    //   31: putstatic 41	com/tencent/biz/common/report/BnrReport:a	Ljava/util/ArrayList;
    //   34: aload_0
    //   35: ldc 106
    //   37: invokevirtual 110	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   40: istore 4
    //   42: aload_1
    //   43: iload 4
    //   45: invokestatic 451	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: invokeinterface 455 2 0
    //   53: iconst_m1
    //   54: if_icmpgt +7 -> 61
    //   57: iload_2
    //   58: ifeq +103 -> 161
    //   61: iconst_1
    //   62: istore_2
    //   63: aconst_null
    //   64: astore_3
    //   65: aload_0
    //   66: ldc 89
    //   68: invokevirtual 95	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   71: astore_0
    //   72: aload_0
    //   73: ifnull +63 -> 136
    //   76: aload_0
    //   77: invokevirtual 100	org/json/JSONArray:length	()I
    //   80: istore 5
    //   82: iconst_0
    //   83: istore 4
    //   85: iload 4
    //   87: iload 5
    //   89: if_icmpge -72 -> 17
    //   92: aload_0
    //   93: iload 4
    //   95: invokevirtual 104	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   98: aload_1
    //   99: iload_2
    //   100: invokestatic 437	com/tencent/biz/common/report/BnrReport:a	(Lorg/json/JSONObject;Ljava/util/List;Z)V
    //   103: iload 4
    //   105: iconst_1
    //   106: iadd
    //   107: istore 4
    //   109: goto -24 -> 85
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   117: return
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   123: aload_3
    //   124: astore_0
    //   125: goto -53 -> 72
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 117	org/json/JSONException:printStackTrace	()V
    //   133: goto -30 -> 103
    //   136: iload_2
    //   137: ifeq -120 -> 17
    //   140: iload 4
    //   142: invokestatic 376	com/tencent/biz/common/report/BnrReport:a	(I)Z
    //   145: ifne -128 -> 17
    //   148: getstatic 41	com/tencent/biz/common/report/BnrReport:a	Ljava/util/ArrayList;
    //   151: iload 4
    //   153: invokestatic 451	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: invokevirtual 458	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   159: pop
    //   160: return
    //   161: iconst_0
    //   162: istore_2
    //   163: goto -100 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramJSONObject	JSONObject
    //   0	166	1	paramList	List
    //   0	166	2	paramBoolean	boolean
    //   64	60	3	localObject	Object
    //   128	2	3	localJSONException	JSONException
    //   40	112	4	i	int
    //   80	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   34	42	112	org/json/JSONException
    //   65	72	118	org/json/JSONException
    //   92	103	128	org/json/JSONException
  }
  
  public static boolean a(int paramInt)
  {
    return true;
  }
  
  protected static void b()
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    jdField_b_of_type_Long = System.currentTimeMillis();
    localEditor.putLong("bnr_last_up_time", jdField_b_of_type_Long);
    localEditor.commit();
  }
  
  protected static void b(AppInterface paramAppInterface) {}
  
  protected static void c()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).getString("bnr_open_report_id", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = ((String)localObject).split("\\|");
    a = new ArrayList();
    int j = localObject.length;
    int i = 0;
    while (i < j) {
      try
      {
        int k = Integer.valueOf(localObject[i]).intValue();
        a.add(Integer.valueOf(k));
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
        }
      }
    }
  }
  
  protected static void d()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if (a == null) {
      a = new ArrayList();
    }
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(a.get(i));
      i += 1;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    localEditor.putString("bnr_open_report_id", localStringBuffer.toString());
    localEditor.commit();
  }
  
  protected static void e()
  {
    if (a == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while (!QLog.isDevelopLevel());
      str = "mReportIdList:";
      int i = 0;
      int j = a.size();
      while (i < j)
      {
        str = str + a.get(i) + ",";
        i += 1;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("BnrReport", 4, "outReportId:" + str);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\report\BnrReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */