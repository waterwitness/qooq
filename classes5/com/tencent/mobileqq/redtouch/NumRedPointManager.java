package com.tencent.mobileqq.redtouch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.app.NumRedPointHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.pb.getnumred.NumRedPoint.NumRedBusi;
import com.tencent.pb.getnumred.NumRedPoint.NumRedPath;
import com.tencent.pb.getnumred.NumRedPoint.NumRedRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class NumRedPointManager
  implements Manager
{
  public static final int a = 100510;
  public static final String a = "NumRedPointManager";
  public static String[][] a;
  protected QQAppInterface a;
  private NumRedPoint.NumRedRspBody jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "100510", "0" } };
  }
  
  public NumRedPointManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  private int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/mobileqq/redtouch/NumRedPointManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_3
    //   12: monitorexit
    //   13: iconst_m1
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 56	com/tencent/mobileqq/redtouch/NumRedPointManager:b	()Ljava/util/List;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnonnull +13 -> 36
    //   26: aload_0
    //   27: ldc 58
    //   29: invokespecial 61	com/tencent/mobileqq/redtouch/NumRedPointManager:a	(Ljava/lang/String;)V
    //   32: aload_3
    //   33: monitorexit
    //   34: iconst_0
    //   35: ireturn
    //   36: aload 4
    //   38: invokeinterface 67 1 0
    //   43: astore 4
    //   45: iconst_0
    //   46: istore 9
    //   48: aload 4
    //   50: invokeinterface 73 1 0
    //   55: ifeq +99 -> 154
    //   58: aload 4
    //   60: invokeinterface 77 1 0
    //   65: checkcast 79	com/tencent/pb/getnumred/NumRedPoint$NumRedBusi
    //   68: getfield 83	com/tencent/pb/getnumred/NumRedPoint$NumRedBusi:rpt_num_red_path	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   71: invokevirtual 88	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   74: astore 5
    //   76: aload 5
    //   78: ifnull -30 -> 48
    //   81: iconst_0
    //   82: istore 8
    //   84: iload 9
    //   86: istore 7
    //   88: iload 7
    //   90: istore 9
    //   92: iload 8
    //   94: aload 5
    //   96: invokeinterface 92 1 0
    //   101: if_icmpge -53 -> 48
    //   104: aload 5
    //   106: iload 8
    //   108: invokeinterface 95 2 0
    //   113: checkcast 97	com/tencent/pb/getnumred/NumRedPoint$NumRedPath
    //   116: astore 6
    //   118: aload 6
    //   120: getfield 101	com/tencent/pb/getnumred/NumRedPoint$NumRedPath:str_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   123: invokevirtual 106	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   126: aload_1
    //   127: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +34 -> 164
    //   133: aload 6
    //   135: getfield 114	com/tencent/pb/getnumred/NumRedPoint$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   138: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   141: iload_2
    //   142: if_icmpne +22 -> 164
    //   145: iload 7
    //   147: iconst_1
    //   148: iadd
    //   149: istore 7
    //   151: goto +16 -> 167
    //   154: aload_3
    //   155: monitorexit
    //   156: iload 9
    //   158: ireturn
    //   159: astore_1
    //   160: aload_3
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: goto +3 -> 167
    //   167: iload 8
    //   169: iconst_1
    //   170: iadd
    //   171: istore 8
    //   173: goto -85 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	NumRedPointManager
    //   0	176	1	paramString	String
    //   0	176	2	paramInt	int
    //   4	157	3	localObject1	Object
    //   19	40	4	localObject2	Object
    //   74	31	5	localList	List
    //   116	18	6	localNumRedPath	NumRedPoint.NumRedPath
    //   86	64	7	i	int
    //   82	90	8	j	int
    //   46	111	9	k	int
    // Exception table:
    //   from	to	target	type
    //   11	13	159	finally
    //   15	21	159	finally
    //   26	34	159	finally
    //   36	45	159	finally
    //   48	76	159	finally
    //   92	145	159	finally
    //   154	156	159	finally
    //   160	162	159	finally
  }
  
  private int a(String paramString1, String paramString2)
  {
    int k = -1;
    int i;
    if ((paramString1 == null) || (paramString2 == null))
    {
      i = -2;
      return i;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int j = 0;
    for (;;)
    {
      try
      {
        if ((j < arrayOfString1.length) && (j < arrayOfString2.length))
        {
          m = Integer.parseInt(arrayOfString1[j]);
          int n = Integer.parseInt(arrayOfString2[j]);
          i = k;
          if (m < n) {
            break;
          }
          if (m <= n) {
            break label128;
          }
          return 1;
        }
        if (arrayOfString1.length > j) {
          return 1;
        }
        int m = arrayOfString2.length;
        i = k;
        if (m > j) {
          break;
        }
        return 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      label128:
      j += 1;
    }
  }
  
  private NumRedPoint.NumRedBusi a(int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject1 = b();
        if (localObject1 == null)
        {
          a("getNumRedBusiInfoByAppId : numRedBusiList == null ");
          return null;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (NumRedPoint.NumRedBusi)localIterator.next();
          if (paramInt != ((NumRedPoint.NumRedBusi)localObject1).uint32_appid.get()) {
            continue;
          }
          if (localObject1 == null)
          {
            a("getNumRedBusiInfoByAppId : cannot find the info by appid");
            return null;
          }
          return (NumRedPoint.NumRedBusi)localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  private NumRedPoint.NumRedBusi a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null)
    {
      a("numRedPushInfo2NumRedBusi : busiInfo is null");
      return null;
    }
    NumRedPoint.NumRedBusi localNumRedBusi = new NumRedPoint.NumRedBusi();
    localNumRedBusi.uint32_appid.set(paramNumRedBusiInfo.uint32_android_app_id.get());
    localNumRedBusi.i_new_flag.set(0);
    localNumRedBusi.uint32_modify_ts.set(0);
    localNumRedBusi.int32_appset.set(paramNumRedBusiInfo.int32_appset.get());
    ArrayList localArrayList = new ArrayList();
    NumRedPoint.NumRedPath localNumRedPath = new NumRedPoint.NumRedPath();
    localNumRedPath.str_path.set(paramNumRedBusiInfo.str_android_path.get());
    localNumRedPath.str_missionid.set(paramNumRedBusiInfo.str_missionid.get());
    localNumRedPath.uint64_msgid.set(paramNumRedBusiInfo.uint64_msgid.get());
    localNumRedPath.uint32_msg_status.set(paramNumRedBusiInfo.uint32_status.get());
    localNumRedPath.uint32_expire_time.set(paramNumRedBusiInfo.uint32_expire_time.get());
    localNumRedPath.uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
    localArrayList.add(localNumRedPath);
    localNumRedBusi.rpt_num_red_path.set(localArrayList);
    return localNumRedBusi;
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
  }
  
  private List a(NumRedPoint.NumRedBusi paramNumRedBusi)
  {
    if (paramNumRedBusi == null)
    {
      a("getNumRedPathList : mNumRed is null");
      return null;
    }
    return paramNumRedBusi.rpt_num_red_path.get();
  }
  
  private void a(int paramInt1, List paramList, int paramInt2, String paramString)
  {
    a("onReport : appid == " + paramInt1 + ",msgIs == " + paramList + ",data == " + paramString);
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localReportReqBody.clientver.set("6.5.5.2880");
    localReportReqBody.platid.set(109);
    ArrayList localArrayList = new ArrayList();
    localReportReqBody.missionid.set(localArrayList);
    localReportReqBody.appid.set(paramInt1);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.msgids.set(paramList);
    localArrayList = new ArrayList();
    try
    {
      paramList = new JSONObject();
      if (paramList != null) {}
      try
      {
        paramList.put("cmd", paramInt2);
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = paramList;
        if (localJSONObject == null) {
          break label297;
        }
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          paramString = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
          localReportStaticsData.key.set(paramString);
          localReportStaticsData.value.set(localJSONObject.getString(paramString));
          localArrayList.add(localReportStaticsData);
        }
        paramString.printStackTrace();
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        label297:
        paramList = null;
      }
    }
    paramString = paramList;
    if (paramString != null) {
      localReportReqBody.buffer.set(paramString.toString());
    }
    localReportReqBody.reportdata.set(localArrayList);
    paramList = a("RedTouchSvc.ClientReport");
    paramList.putWupBuffer(localReportReqBody.toByteArray());
    a(paramList);
  }
  
  private void a(int paramInt, List paramList, String paramString)
  {
    a(paramInt, paramList, 8, paramString);
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NumRedPointManager", 2, paramString);
    }
  }
  
  private boolean a(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    try
    {
      a("saveRsp2File : startime==" + System.currentTimeMillis());
      boolean bool = FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "NumRedShowFileName_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).getAbsolutePath(), paramNumRedRspBody.toByteArray(), false);
      a("saveRsp2File : endtime==" + System.currentTimeMillis());
      c(paramNumRedRspBody);
      b();
      c();
      a(100, true, paramNumRedRspBody);
      return bool;
    }
    finally
    {
      paramNumRedRspBody = finally;
      throw paramNumRedRspBody;
    }
  }
  
  private boolean a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null) {}
    while ((paramNumRedBusiInfo.uint32_plat_id.get() != 109) && (paramNumRedBusiInfo.uint32_plat_id.get() != 109110)) {
      return false;
    }
    return true;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramInt1);
      if (localObject2 == null)
      {
        a("getNumFromFileByAppid : cannot find the info by appid");
        return 0;
      }
      localObject2 = ((NumRedPoint.NumRedBusi)localObject2).rpt_num_red_path.get();
      if (localObject2 == null)
      {
        a("getNumFromFileByAppid : path list is null");
        return 0;
      }
    }
    Iterator localIterator = ((List)localObject3).iterator();
    paramInt1 = 0;
    for (;;)
    {
      NumRedPoint.NumRedPath localNumRedPath;
      int i;
      if (localIterator.hasNext())
      {
        localNumRedPath = (NumRedPoint.NumRedPath)localIterator.next();
        i = paramInt1;
        if (100 == paramInt2)
        {
          if (localNumRedPath.uint32_msg_status.get() == 0) {
            break label164;
          }
          i = paramInt1;
          if (1 == localNumRedPath.uint32_msg_status.get()) {
            break label164;
          }
        }
      }
      for (;;)
      {
        if (localNumRedPath.uint32_msg_status.get() == paramInt2)
        {
          paramInt1 = i + 1;
          break;
          return paramInt1;
        }
        paramInt1 = i;
        break;
        label164:
        i = paramInt1 + 1;
      }
    }
  }
  
  private void b()
  {
    int i = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      while (i < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        int j = Integer.valueOf(jdField_a_of_type_Array2dOfJavaLangString[i][0]).intValue();
        ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
        int k = b(j, 0);
        int m = b(j, 1);
        int n = b(j, 3);
        int i1 = b(j, 4);
        int i2 = b(j, 100);
        localConcurrentHashMap.put(Integer.valueOf(0), Integer.valueOf(k));
        localConcurrentHashMap.put(Integer.valueOf(1), Integer.valueOf(m));
        localConcurrentHashMap.put(Integer.valueOf(3), Integer.valueOf(n));
        localConcurrentHashMap.put(Integer.valueOf(4), Integer.valueOf(i1));
        localConcurrentHashMap.put(Integer.valueOf(100), Integer.valueOf(i2));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(j), localConcurrentHashMap);
        i += 1;
      }
      return;
    }
  }
  
  private void b(int paramInt, long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    a(paramInt, localArrayList, 1, paramString);
  }
  
  private void b(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    if (paramNumRedRspBody == null) {}
    do
    {
      return;
      localObject2 = paramNumRedRspBody.rpt_num_red.get();
    } while (localObject2 == null);
    NumRedPoint.NumRedRspBody localNumRedRspBody;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localNumRedRspBody = a();
      if (localNumRedRspBody == null)
      {
        a(paramNumRedRspBody);
        return;
      }
    }
    List localList = localNumRedRspBody.rpt_num_red.get();
    if (localList == null)
    {
      a(paramNumRedRspBody);
      return;
    }
    Object localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    int i;
    label106:
    int j;
    label167:
    label239:
    NumRedPoint.NumRedPath localNumRedPath;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NumRedPoint.NumRedBusi)((Iterator)localObject2).next();
        i = 0;
        if (i >= localList.size()) {
          break label428;
        }
        if (((NumRedPoint.NumRedBusi)localList.get(i)).uint32_appid.get() != ((NumRedPoint.NumRedBusi)localObject3).uint32_appid.get()) {
          break label436;
        }
        j = 1;
        paramNumRedRspBody = (NumRedPoint.NumRedBusi)localList.get(i);
        i = j;
        if (i == 0)
        {
          localList.add(localObject3);
        }
        else
        {
          Object localObject4 = ((NumRedPoint.NumRedBusi)localObject3).rpt_num_red_path.get();
          if ((localObject4 != null) && (paramNumRedRspBody != null))
          {
            localObject3 = paramNumRedRspBody.rpt_num_red_path.get();
            if (localObject3 == null)
            {
              paramNumRedRspBody.rpt_num_red_path.set((List)localObject4);
            }
            else
            {
              localObject4 = ((List)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localNumRedPath = (NumRedPoint.NumRedPath)((Iterator)localObject4).next();
                i = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((List)localObject3).size())
      {
        if (localNumRedPath.uint64_msgid.get() == ((NumRedPoint.NumRedPath)((List)localObject3).get(i)).uint64_msgid.get())
        {
          j = 1;
          paramNumRedRspBody = (NumRedPoint.NumRedPath)((List)localObject3).get(i);
        }
      }
      else
      {
        for (i = j;; i = 0)
        {
          if (i == 0)
          {
            ((List)localObject3).add(localNumRedPath);
            break label239;
          }
          if (paramNumRedRspBody == null) {
            break label239;
          }
          paramNumRedRspBody.str_path.set(localNumRedPath.str_path.get());
          paramNumRedRspBody.str_missionid.set(localNumRedPath.str_missionid.get());
          paramNumRedRspBody.uint32_msg_status.set(localNumRedPath.uint32_msg_status.get());
          paramNumRedRspBody.uint32_expire_time.set(localNumRedPath.uint32_expire_time.get());
          break label239;
          break;
          a(localNumRedRspBody);
          return;
          paramNumRedRspBody = null;
        }
        label428:
        paramNumRedRspBody = null;
        i = 0;
        break label167;
        label436:
        i += 1;
        break label106;
      }
      i += 1;
    }
  }
  
  private boolean b(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    boolean bool = true;
    String str = paramNumRedBusiInfo.str_client_ver_begin.get();
    paramNumRedBusiInfo = paramNumRedBusiInfo.str_client_ver_end.get();
    if ((str == null) && (paramNumRedBusiInfo == null)) {
      return false;
    }
    int i = a(str, "6.5.5");
    int j = a("6.5.5", paramNumRedBusiInfo);
    if ((i == -1) || (i == 0))
    {
      i = 1;
      if ((j != 1) && (j != 0) && (!paramNumRedBusiInfo.equals("0.0.0"))) {
        break label100;
      }
      j = 1;
      label83:
      if ((i == 0) || (j == 0)) {
        break label106;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label100:
      j = 0;
      break label83;
      label106:
      bool = false;
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < jdField_a_of_type_Array2dOfJavaLangString.length)
        {
          Object localObject2 = a(Integer.valueOf(jdField_a_of_type_Array2dOfJavaLangString[i][0]).intValue());
          if (localObject2 == null) {
            break label234;
          }
          localObject2 = a((NumRedPoint.NumRedBusi)localObject2);
          if (localObject2 == null) {
            break label234;
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label234;
          }
          NumRedPoint.NumRedPath localNumRedPath = (NumRedPoint.NumRedPath)((Iterator)localObject2).next();
          int j = a(localNumRedPath.str_path.get(), 0);
          int k = a(localNumRedPath.str_path.get(), 1);
          int m = a(localNumRedPath.str_path.get(), 3);
          int n = a(localNumRedPath.str_path.get(), 4);
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          localConcurrentHashMap.put(Integer.valueOf(0), Integer.valueOf(j));
          localConcurrentHashMap.put(Integer.valueOf(1), Integer.valueOf(k));
          localConcurrentHashMap.put(Integer.valueOf(3), Integer.valueOf(m));
          localConcurrentHashMap.put(Integer.valueOf(4), Integer.valueOf(n));
          this.b.put(localNumRedPath.str_path.get(), localConcurrentHashMap);
          continue;
        }
      }
      finally {}
      return;
      label234:
      i += 1;
    }
  }
  
  private void c(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody = paramNumRedRspBody;
      return;
    }
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    label119:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = b();
        if (localObject2 == null)
        {
          a("getNumRedShowNumByAppSet : numRedBusiList is null");
          return 0;
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          NumRedPoint.NumRedBusi localNumRedBusi = (NumRedPoint.NumRedBusi)((Iterator)localObject2).next();
          if ((paramInt == localNumRedBusi.int32_appset.get()) && (a(localNumRedBusi.uint32_appid.get())))
          {
            i = a(localNumRedBusi.uint32_appid.get(), 100) + i;
            break label119;
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject = new ConcurrentHashMap();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      localObject = localConcurrentHashMap;
      if (localConcurrentHashMap.contains(Integer.valueOf(paramInt2))) {
        return ((Integer)localConcurrentHashMap.get(Integer.valueOf(paramInt2))).intValue();
      }
    }
    int i = b(paramInt1, paramInt2);
    ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(i));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
    return i;
  }
  
  public NumRedPoint.NumRedRspBody a()
  {
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody;
        return (NumRedPoint.NumRedRspBody)localObject2;
      }
      ??? = new NumRedPoint.NumRedRspBody();
      localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "NumRedShowFileName_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (!((File)localObject2).exists()) {
        a("numredshownum pb file does not exist");
      }
    }
    try
    {
      ((File)localObject2).createNewFile();
      try
      {
        localObject2 = FileUtils.a((File)localObject2);
        if (localObject2 != null) {
          break label136;
        }
        a("Can not translate numredshownum pb file to byte");
        return null;
      }
      finally {}
      arrayOfByte = finally;
      throw arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    try
    {
      label136:
      localNumRedRspBody.mergeFrom(arrayOfByte);
      c(localNumRedRspBody);
      return localNumRedRspBody;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a("merge numredshownum file to rspbody fail");
    }
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < jdField_a_of_type_Array2dOfJavaLangString.length)
    {
      int j = Integer.valueOf(jdField_a_of_type_Array2dOfJavaLangString[i][0]).intValue();
      Object localObject = a(j);
      NumRedPoint.NumRedBusi localNumRedBusi = new NumRedPoint.NumRedBusi();
      localNumRedBusi.uint32_appid.set(j);
      localNumRedBusi.uint32_modify_ts.set((int)(System.currentTimeMillis() / 1000L));
      localNumRedBusi.i_new_flag.set(0);
      if (localObject != null)
      {
        localObject = a((NumRedPoint.NumRedBusi)localObject);
        if ((localObject == null) || (((List)localObject).size() < 1))
        {
          localNumRedBusi.i_new_flag.set(0);
          localArrayList1.add(localNumRedBusi);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ArrayList localArrayList2 = new ArrayList();
        j = 0;
        while (j < ((List)localObject).size())
        {
          NumRedPoint.NumRedPath localNumRedPath = (NumRedPoint.NumRedPath)((List)localObject).get(j);
          if ((localNumRedPath.uint32_msg_status.get() == 0) || (localNumRedPath.uint32_msg_status.get() == 1)) {
            localArrayList2.add(localNumRedPath);
          }
          if (localNumRedPath.uint32_msg_status.get() == 0) {
            localNumRedBusi.i_new_flag.set(1);
          }
          j += 1;
        }
        localNumRedBusi.rpt_num_red_path.set(localArrayList2);
        localArrayList1.add(localNumRedBusi);
      }
    }
    return localArrayList1;
  }
  
  public List a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramInt);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((NumRedPoint.NumRedBusi)localObject2).rpt_num_red_path.get();
      return (List)localObject2;
    }
  }
  
  public void a()
  {
    List localList1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      NumRedPoint.NumRedRspBody localNumRedRspBody1 = a();
      if (localNumRedRspBody1 == null) {
        return;
      }
      localList1 = localNumRedRspBody1.rpt_num_red.get();
      if (localList1 == null) {
        return;
      }
    }
    int j = 0;
    int i = 0;
    List localList2;
    int m;
    if (j < localList1.size())
    {
      localList2 = ((NumRedPoint.NumRedBusi)localList1.get(j)).rpt_num_red_path.get();
      if (localList2 != null) {
        break label190;
      }
      m = i;
    }
    for (;;)
    {
      m = i;
      int k;
      if (k < localList2.size())
      {
        NumRedPoint.NumRedPath localNumRedPath = (NumRedPoint.NumRedPath)localList2.get(k);
        if (localNumRedPath.uint32_push_num_red_ts.get() + localNumRedPath.uint32_expire_time.get() < (int)(System.currentTimeMillis() / 1000L))
        {
          localNumRedPath.uint32_msg_status.set(4);
          i = 1;
          break label196;
          if (i != 0) {
            a(localNumRedRspBody2);
          }
        }
      }
      else
      {
        j += 1;
        i = m;
        break;
        label190:
        k = 0;
        continue;
      }
      label196:
      k += 1;
    }
  }
  
  public void a(int paramInt)
  {
    int j = 0;
    List localList;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      NumRedPoint.NumRedRspBody localNumRedRspBody1 = a();
      if (localNumRedRspBody1 == null) {
        return;
      }
      localList = localNumRedRspBody1.rpt_num_red.get();
      if (localList == null) {
        return;
      }
    }
    int i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < localList.size())
      {
        localObject2 = (NumRedPoint.NumRedBusi)localList.get(i);
        if (((NumRedPoint.NumRedBusi)localObject2).uint32_appid.get() != paramInt) {
          break label166;
        }
        localList = ((NumRedPoint.NumRedBusi)localObject2).rpt_num_red_path.get();
        if (localList != null) {
          paramInt = j;
        }
      }
      for (;;)
      {
        if (paramInt < localList.size())
        {
          localObject2 = (NumRedPoint.NumRedPath)localList.get(paramInt);
          if (((NumRedPoint.NumRedPath)localObject2).uint32_msg_status.get() == 0) {
            ((NumRedPoint.NumRedPath)localObject2).uint32_msg_status.set(1);
          }
        }
        else
        {
          a(localNumRedRspBody2);
          return;
        }
        paramInt += 1;
      }
      label166:
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      NumRedPoint.NumRedRspBody localNumRedRspBody1 = a();
      localObject2 = a(paramInt1);
      if (localObject2 == null) {
        return;
      }
      localObject2 = a((NumRedPoint.NumRedBusi)localObject2);
      if (localObject2 == null) {
        return;
      }
    }
    paramInt1 = 0;
    if (paramInt1 < ((List)localObject2).size()) {
      if (((NumRedPoint.NumRedPath)((List)localObject2).get(paramInt1)).uint64_msgid.get() == paramInt2) {
        ((NumRedPoint.NumRedPath)((List)localObject2).get(paramInt1)).uint32_msg_status.set(paramInt3);
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        a(localNumRedRspBody2);
      }
      return;
      paramInt1 += 1;
      break;
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    a(paramInt, localArrayList, 9, paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = a(paramInt);
      if (localObject2 == null) {
        return;
      }
      localObject3 = ((NumRedPoint.NumRedBusi)localObject2).rpt_num_red_path.get();
      if (localObject3 == null)
      {
        a("onReportShowMsgs : NumRedPaths is null");
        return;
      }
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((List)localObject2).add(Long.valueOf(((NumRedPoint.NumRedPath)((Iterator)localObject3).next()).uint64_msgid.get()));
    }
    a(paramInt, (List)localObject2, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    NumRedPointHandler localNumRedPointHandler = (NumRedPointHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(55);
    if (localNumRedPointHandler != null)
    {
      localNumRedPointHandler.a(paramInt, paramBoolean, paramObject);
      a("notifyObserver");
    }
    RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    if (paramNumRedRspBody == null) {}
    Object localObject;
    label70:
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
      if (!paramNumRedRspBody.i_inteval.has()) {
        break label158;
      }
      if (paramNumRedRspBody.i_inteval.get() <= 0) {
        break;
      }
      i = paramNumRedRspBody.i_inteval.get();
      ((SharedPreferences.Editor)localObject).putInt("NumRedTimeInterval", i);
      ((SharedPreferences.Editor)localObject).putInt("NumRedLastTime", (int)(System.currentTimeMillis() / 1000L));
      ((SharedPreferences.Editor)localObject).commit();
      localObject = paramNumRedRspBody.rpt_num_red.get();
    } while (localObject == null);
    int i = 0;
    label110:
    if (i < ((List)localObject).size())
    {
      List localList = ((NumRedPoint.NumRedBusi)((List)localObject).get(i)).rpt_num_red_path.get();
      if (localList == null) {}
      for (;;)
      {
        i += 1;
        break label110;
        i = 0;
        break;
        label158:
        ((SharedPreferences.Editor)localObject).remove("NumRedTimeInterval");
        break label70;
        int j = 0;
        while (j < localList.size())
        {
          ((NumRedPoint.NumRedPath)localList.get(j)).uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
          j += 1;
        }
      }
    }
    a("handleNumRedRsp : modify pushtime end");
    b(paramNumRedRspBody);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = new Submsgtype0x89.MsgBody();
        ((Submsgtype0x89.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localObject = ((Submsgtype0x89.MsgBody)localObject).rpt_msg_num_red.get();
        if (localObject == null) {
          return;
        }
        paramArrayOfByte = new ArrayList();
        i = 0;
        if (i < ((List)localObject).size())
        {
          Submsgtype0x89.NumRedBusiInfo localNumRedBusiInfo = (Submsgtype0x89.NumRedBusiInfo)((List)localObject).get(i);
          if ((!a(localNumRedBusiInfo)) || (!b(localNumRedBusiInfo))) {
            break label148;
          }
          b(localNumRedBusiInfo.uint32_app_id.get(), localNumRedBusiInfo.uint64_msgid.get(), "");
          paramArrayOfByte.add(a(localNumRedBusiInfo));
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      Object localObject = new NumRedPoint.NumRedRspBody();
      ((NumRedPoint.NumRedRspBody)localObject).rpt_num_red.set(paramArrayOfByte);
      b((NumRedPoint.NumRedRspBody)localObject);
      return;
      label148:
      i += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (a(paramInt, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public List b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      if (localObject2 == null)
      {
        a("getNumRedBusiInfoByAppId : rsp == null ");
        return null;
      }
      localObject2 = ((NumRedPoint.NumRedRspBody)localObject2).rpt_num_red.get();
      return (List)localObject2;
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\NumRedPointManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */