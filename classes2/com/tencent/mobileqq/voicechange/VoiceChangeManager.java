package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import wgp;

public class VoiceChangeManager
  implements Manager
{
  public static final String a = "VoiceChangeManager";
  public static HashMap a;
  public static String[] a;
  public static String b;
  public QQAppInterface a;
  public DownloadListener a;
  public ArrayList a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaLangString = AppConstants.bj + "voiceChange/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { null, null, null };
  }
  
  public VoiceChangeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new wgp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: i2d
    //   5: dstore 5
    //   7: dload 5
    //   9: invokestatic 78	com/tencent/mobileqq/utils/QQRecorder:a	(D)I
    //   12: istore_0
    //   13: getstatic 31	com/tencent/mobileqq/voicechange/VoiceChangeManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   16: aload_1
    //   17: invokevirtual 82	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 84	com/tencent/mobileqq/voicechange/VoiceChangeParams
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +88 -> 115
    //   30: aload 7
    //   32: getfield 87	com/tencent/mobileqq/voicechange/VoiceChangeParams:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeParams$IOnCompressFinish	Lcom/tencent/mobileqq/voicechange/VoiceChangeParams$IOnCompressFinish;
    //   35: ifnull +84 -> 119
    //   38: aload_1
    //   39: aload_2
    //   40: iload_3
    //   41: invokestatic 92	com/tencent/mobileqq/voicechange/VoiceTuneUtil:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   44: aload 7
    //   46: getfield 87	com/tencent/mobileqq/voicechange/VoiceChangeParams:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeParams$IOnCompressFinish	Lcom/tencent/mobileqq/voicechange/VoiceChangeParams$IOnCompressFinish;
    //   49: aload_1
    //   50: iload 4
    //   52: iload_0
    //   53: invokeinterface 97 4 0
    //   58: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +46 -> 107
    //   64: ldc 10
    //   66: iconst_2
    //   67: new 33	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   74: ldc 105
    //   76: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 107
    //   85: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_0
    //   89: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 112
    //   94: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_3
    //   98: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: getstatic 31	com/tencent/mobileqq/voicechange/VoiceChangeManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   110: aload_1
    //   111: invokevirtual 119	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: ldc 2
    //   117: monitorexit
    //   118: return
    //   119: aload 7
    //   121: iconst_1
    //   122: putfield 121	com/tencent/mobileqq/voicechange/VoiceChangeParams:jdField_a_of_type_Boolean	Z
    //   125: aload 7
    //   127: iload_0
    //   128: putfield 124	com/tencent/mobileqq/voicechange/VoiceChangeParams:jdField_a_of_type_Int	I
    //   131: goto -16 -> 115
    //   134: astore_1
    //   135: ldc 2
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramInt1	int
    //   0	140	1	paramString1	String
    //   0	140	2	paramString2	String
    //   0	140	3	paramInt2	int
    //   0	140	4	paramInt3	int
    //   5	3	5	d	double
    //   23	103	7	localVoiceChangeParams	VoiceChangeParams
    // Exception table:
    //   from	to	target	type
    //   7	25	134	finally
    //   30	107	134	finally
    //   107	115	134	finally
    //   119	131	134	finally
  }
  
  public static void a(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    if ((VoiceChangeParams)jdField_a_of_type_JavaUtilHashMap.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString) == null) {
      b(paramContext, paramVoiceChangeBasicParams, paramString, paramIVoiceChangeListener);
    }
    ((VoiceChangeParams)jdField_a_of_type_JavaUtilHashMap.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString)).jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.c();
  }
  
  public static void a(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener, VoiceChangeModeParams paramVoiceChangeModeParams)
  {
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)jdField_a_of_type_JavaUtilHashMap.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    if (localVoiceChangeParams != null) {
      localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.jdField_a_of_type_Boolean = false;
    }
    localVoiceChangeParams = new VoiceChangeParams();
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = paramVoiceChangeBasicParams;
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams = paramVoiceChangeModeParams;
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = new QQVoiceChangerThread(paramContext, paramVoiceChangeBasicParams, paramVoiceChangeModeParams, paramString, paramIVoiceChangeListener);
    jdField_a_of_type_JavaUtilHashMap.put(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, localVoiceChangeParams);
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.start();
  }
  
  public static void a(VoiceChangeBasicParams paramVoiceChangeBasicParams)
  {
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)jdField_a_of_type_JavaUtilHashMap.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    if (localVoiceChangeParams != null)
    {
      localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.d();
      jdField_a_of_type_JavaUtilHashMap.remove(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    }
  }
  
  public static boolean a(String paramString, VoiceChangeParams.IOnCompressFinish paramIOnCompressFinish)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "queryStateByPath called path=" + paramString);
        }
        VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localVoiceChangeParams == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "no task path=" + paramString);
          }
          bool = false;
          return bool;
        }
        if (localVoiceChangeParams.jdField_a_of_type_Boolean)
        {
          VoiceTuneUtil.a(paramString, localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f);
          jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          paramIOnCompressFinish.a(paramString, localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e, localVoiceChangeParams.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "queryStateByPath onCompressFinished filePath=" + paramString + " time=" + localVoiceChangeParams.jdField_a_of_type_Int + " voiceType=" + localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
          }
        }
        else
        {
          localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeParams$IOnCompressFinish = paramIOnCompressFinish;
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  public static void b(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    a(paramContext, paramVoiceChangeBasicParams, paramString, paramIVoiceChangeListener, VoiceChangeModeParams.a());
  }
  
  public static void b(VoiceChangeBasicParams paramVoiceChangeBasicParams)
  {
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)jdField_a_of_type_JavaUtilHashMap.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    if (localVoiceChangeParams != null)
    {
      localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.jdField_a_of_type_Boolean = false;
      jdField_a_of_type_JavaUtilHashMap.remove(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    boolean bool = false;
    Object localObject1 = new File(jdField_b_of_type_JavaLangString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeManager", 2, "preCheckData start");
    }
    JSONObject localJSONObject = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.o, false);
    int[] arrayOfInt = ListenChangeVoicePanel.a;
    if (localJSONObject == null)
    {
      QLog.e("VoiceChangeManager", 1, "preCheckData null == xydata");
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener.onDone(null);
      return bool;
    }
    long l1;
    int k;
    label119:
    Object localObject3;
    label236:
    Object localObject2;
    try
    {
      l1 = localJSONObject.getLong("timestamp");
      long l2 = System.currentTimeMillis() / 1000L;
      JSONArray localJSONArray = localJSONObject.getJSONArray("VoiceChangeModels");
      k = 0;
      if (k >= localJSONArray.length()) {
        break label1011;
      }
      localObject3 = localJSONArray.getJSONObject(k);
      if ((localObject3 == null) || (((JSONObject)localObject3).getJSONArray("baseInfo") == null) || (((JSONObject)localObject3).getJSONArray("baseInfo").getJSONObject(0) == null) || (((JSONObject)localObject3).getJSONArray("operationInfo") == null))
      {
        QLog.e("VoiceChangeManager", 1, "preCheckData JsonErr:i=" + k + ", timestamp:" + l1);
        break label1232;
      }
      localObject4 = ((JSONObject)localObject3).getJSONArray("operationInfo");
      localObject1 = null;
      i = 0;
      if (i < ((JSONArray)localObject4).length())
      {
        localObject2 = ((JSONObject)localObject3).getJSONArray("operationInfo").getJSONObject(i);
        if ((localObject2 == null) || (!((JSONObject)localObject2).has("platformId"))) {
          break label1252;
        }
        j = ((JSONObject)localObject2).getInt("platformId");
        label283:
        localObject1 = localObject2;
        if (j == 0) {
          break label1243;
        }
        localObject1 = localObject2;
        if (j == 2) {
          break label1243;
        }
        if (!QLog.isColorLevel()) {
          break label1241;
        }
        QLog.d("VoiceChangeManager", 2, "preCheckData continue platformId=" + j + ", i=" + k + ", timestamp:" + l1 + ", o=" + i);
        break label1241;
      }
      if (localObject1 != null) {
        break label1227;
      }
      localObject2 = new JSONObject();
      if (!QLog.isColorLevel()) {
        break label1258;
      }
      QLog.d("VoiceChangeManager", 2, "preCheckData continue null == itemJsonOpera, i=" + k + ", timestamp:" + l1);
    }
    catch (Exception paramArrayList)
    {
      label426:
      QLog.e("VoiceChangeManager", 1, "preCheckData jsonEx:" + paramArrayList.getMessage());
      bool = true;
    }
    Object localObject4 = ((JSONObject)localObject3).getJSONArray("baseInfo").getJSONObject(0);
    int j = ((JSONObject)localObject4).getInt("voiceID");
    int i = 6;
    for (;;)
    {
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] == j)
        {
          label472:
          if (i >= 0) {
            break label569;
          }
          if (!QLog.isColorLevel()) {
            break label1232;
          }
          QLog.d("VoiceChangeManager", 2, "preCheckData not in VOICE_TYPES[] out:i=" + k + ", timestamp:" + l1);
          break label1232;
          break;
        }
        i += 1;
        continue;
        label569:
        if (paramArrayList == null) {
          break label1261;
        }
        localObject1 = (VoiceChangeData)paramArrayList.get(i);
        label583:
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            break label1232;
          }
          QLog.d("VoiceChangeManager", 2, "preCheckData null == voiceChangeData out:i=" + k + ", timestamp:" + l1);
          break label1232;
        }
        if (!((JSONObject)localObject2).has("isShow")) {
          break label1266;
        }
        j = ((JSONObject)localObject2).getInt("isShow");
        label653:
        i = j;
        if (j != 0)
        {
          i = j;
          if (((JSONObject)localObject2).has("QQVersion"))
          {
            i = j;
            if (IndividuationConfigInfo.a(((JSONObject)localObject2).getString("QQVersion"), "6.5.5"))
            {
              j = 0;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("VoiceChangeManager", 2, "preCheckData Version out:i=" + k + ", timestamp:" + l1);
                i = j;
              }
            }
          }
        }
        if (i == 0)
        {
          ((VoiceChangeData)localObject1).jdField_b_of_type_Int = i;
          break label1232;
        }
        if (!((JSONObject)localObject2).has("isEnable")) {
          break label1278;
        }
        if (((JSONObject)localObject2).getInt("isEnable") != 1) {
          break label1272;
        }
        i = 2;
        label789:
        localObject3 = ((JSONObject)localObject4).getString("icon");
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          QLog.e("VoiceChangeManager", 1, "preCheckData url Error null:");
          ((VoiceChangeData)localObject1).jdField_b_of_type_Int = i;
          if (1 != i) {
            break label934;
          }
          ((VoiceChangeData)localObject1).j = 1;
          ((VoiceChangeData)localObject1).f = 0;
          label838:
          if (!TextUtils.isEmpty(((JSONObject)localObject4).getString("name"))) {
            break label987;
          }
          localObject2 = ((VoiceChangeData)localObject1).jdField_a_of_type_JavaLangString;
          label857:
          ((VoiceChangeData)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          if (!TextUtils.isEmpty(((JSONObject)localObject4).getString("description"))) {
            break label999;
          }
        }
        label934:
        label953:
        label978:
        label987:
        label999:
        for (localObject2 = ((VoiceChangeData)localObject1).jdField_b_of_type_JavaLangString;; localObject2 = ((JSONObject)localObject4).getString("description"))
        {
          ((VoiceChangeData)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
          ((VoiceChangeData)localObject1).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString = ((String)localObject3);
          break label1232;
          localObject3 = ClubContentJsonTask.e + (String)localObject3;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
          break;
          if (!((JSONObject)localObject2).has("feeType")) {
            break label1281;
          }
          i = ((JSONObject)localObject2).getInt("feeType");
          ((VoiceChangeData)localObject1).j = i;
          if (!((JSONObject)localObject2).has("tag")) {
            break label1287;
          }
          i = ((JSONObject)localObject2).getInt("tag");
          ((VoiceChangeData)localObject1).f = i;
          break label838;
          localObject2 = ((JSONObject)localObject4).getString("name");
          break label857;
        }
        label1011:
        if ((TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[0])) || (TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[1])) || (TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[2])))
        {
          paramArrayList = localJSONObject.getJSONArray("commmonData");
          if (paramArrayList == null) {
            break label1302;
          }
        }
      }
    }
    label1227:
    label1232:
    label1241:
    label1243:
    label1252:
    label1258:
    label1261:
    label1266:
    label1272:
    label1278:
    label1281:
    label1287:
    label1302:
    for (paramArrayList = paramArrayList.getJSONObject(0);; paramArrayList = null)
    {
      if (paramArrayList != null)
      {
        localObject1 = new String[3];
        localObject1[0] = "vipIcon";
        localObject1[1] = "svipIcon";
        localObject1[2] = "activityIcon";
        i = 0;
      }
      for (;;)
      {
        if (i < localObject1.length)
        {
          localObject2 = paramArrayList.getJSONObject(localObject1[i]);
          if (localObject2 != null)
          {
            localObject2 = ((JSONObject)localObject2).getString("src");
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              QLog.e("VoiceChangeManager", 1, "preCheckData common url Error null:" + localObject1[i]);
            }
            else
            {
              localObject2 = ClubContentJsonTask.e + (String)localObject2;
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              jdField_a_of_type_ArrayOfJavaLangString[i] = localObject2;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "preCheckData run ok");
          }
          bool = true;
          break;
          i = -1;
          break label472;
          localObject2 = localObject1;
          break label426;
          k += 1;
          break label119;
          localObject1 = null;
          i += 1;
          break label236;
          j = -1;
          break label283;
          break label426;
          localObject1 = null;
          break label583;
          j = 2;
          break label653;
          i = 1;
          break label789;
          break label789;
          i = 1;
          break label953;
          i = 0;
          break label978;
        }
        i += 1;
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\voicechange\VoiceChangeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */