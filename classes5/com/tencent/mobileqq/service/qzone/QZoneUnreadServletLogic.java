package com.tencent.mobileqq.service.qzone;

import NS_QMALL_COVER.QzmallCustomVip;
import NS_QMALL_COVER.UndealCountQzmallDeco;
import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.master_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.operat_data;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.yellow_info;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import cooperation.qzone.util.QZoneLogTags;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import upj;

public class QZoneUnreadServletLogic
{
  private static final int a = 1;
  public static final String a = "getMapLastGetTime";
  public static HashMap a = new HashMap();
  public static final String b = "navigator_bar_style";
  private static final String c;
  private static String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = QZoneLogTags.jdField_b_of_type_JavaLangString + "QZoneUnreadServletLogic";
    d = "key_personalization_undeal_Count";
  }
  
  public static Map a(long paramLong)
  {
    return QzoneMapUtil.a(LocalMultiProcConfig.a("EXTEND_INFO" + paramLong, ""));
  }
  
  public static Map a(Long paramLong)
  {
    localHashMap = new HashMap();
    paramLong = LocalMultiProcConfig.a("getMapLastGetTime", "", paramLong.longValue());
    if (!TextUtils.isEmpty(paramLong))
    {
      paramLong = new JSONTokener(paramLong);
      try
      {
        paramLong = (JSONArray)paramLong.nextValue();
        int i = 0;
        while (i < paramLong.length())
        {
          JSONObject localJSONObject = paramLong.getJSONObject(i);
          localHashMap.put(Long.valueOf(localJSONObject.getLong("key")), Long.valueOf(localJSONObject.getLong("value")));
          i += 1;
        }
        return localHashMap;
      }
      catch (JSONException paramLong)
      {
        QLog.d(c, 2, "getMapLastGetTime JSONException");
      }
    }
  }
  
  public static Map a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    label30:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        break label58;
      }
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      try
      {
        label58:
        localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(c, 2, localUnsupportedEncodingException.toString());
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, localThrowable.toString());
      }
    }
  }
  
  public static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.a("creditlevel", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        LocalMultiProcConfig.a("creditmessage", paramString, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.a("qzone_jinyan", (int)(0x8000 & paramLong), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    while ((parammobile_count_rsp_new.stMasterInfo == null) || (paramQQAppInterface == null)) {
      return;
    }
    a(parammobile_count_rsp_new.stMasterInfo.iLevel, parammobile_count_rsp_new.stMasterInfo.strMessage, paramQQAppInterface);
    a(parammobile_count_rsp_new.stMasterInfo.host_unimbitmap, paramQQAppInterface);
  }
  
  private static void a(mobile_count_rsp_new parammobile_count_rsp_new, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (parammobile_count_rsp_new == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramQZoneNotifyServlet == null);
        if (parammobile_count_rsp_new.iNextTimeout > 0)
        {
          paramQZoneNotifyServlet.jdField_a_of_type_Long = (parammobile_count_rsp_new.iNextTimeout * 1000);
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "onReceive getFeedInterval:" + paramQZoneNotifyServlet.jdField_a_of_type_Long);
          }
        }
      } while (parammobile_count_rsp_new.switchTimeout <= 0);
      paramQZoneNotifyServlet.jdField_b_of_type_Long = (parammobile_count_rsp_new.switchTimeout * 1000);
    } while (!QLog.isColorLevel());
    QLog.d(c, 2, "onReceive getActiveAppInterval:" + paramQZoneNotifyServlet.jdField_b_of_type_Long);
  }
  
  public static void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    paramIntent = paramFromServiceMsg.getWupBuffer();
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramFromServiceMsg = QZoneFeedCountPackeger.a(paramIntent, paramQQAppInterface, "getUndealCount");
      } while ((paramFromServiceMsg == null) || (!(paramFromServiceMsg instanceof mobile_count_rsp_new)));
      paramFromServiceMsg = (mobile_count_rsp_new)paramFromServiceMsg;
    } while (paramFromServiceMsg == null);
    if (QLog.isDevelopLevel()) {
      QLog.d(c, 4, "onResponseCMD_STRING_GET_UNDEAL_COUNT rsp has data");
    }
    a(paramFromServiceMsg.mapLastGetTime, Long.valueOf(paramQQAppInterface.a()));
    QZoneManager localQZoneManager = (QZoneManager)paramQQAppInterface.getManager(9);
    if (localQZoneManager != null) {
      localQZoneManager.c(0);
    }
    LocalMultiProcConfig.a("qzone_preget_passive_open", paramFromServiceMsg.isPreLoad, paramQQAppInterface.getLongAccountUin());
    a(paramIntent, paramFromServiceMsg, paramQQAppInterface, paramQZoneNotifyServlet);
    b(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQZoneNotifyServlet);
    c(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.vecOperateInfo, paramQQAppInterface.a());
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      StatisticCollector.a(paramQQAppInterface.a()).a(paramQQAppInterface.a(), "actQzoneUnread", true, l - QZoneNotifyServlet.c, 0L, localHashMap, "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, Long paramLong)
  {
    if (paramQQAppInterface == null) {}
    HashMap localHashMap;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getManager(9);
      } while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof QZoneManagerImp)));
      localHashMap = (HashMap)a.get(Integer.valueOf(paramInt));
      a.remove(Integer.valueOf(paramInt));
    } while ((localHashMap == null) || (localHashMap.isEmpty()));
    if ((paramLong.longValue() != -1L) && (localHashMap.get(Integer.valueOf(1)) != null))
    {
      QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)localHashMap.get(Integer.valueOf(1));
      localQZoneCountInfo.jdField_a_of_type_Long = paramLong.longValue();
      localHashMap.put(Integer.valueOf(1), localQZoneCountInfo);
    }
    ((QZoneManagerImp)paramQQAppInterface).a(localHashMap);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, FromServiceMsg paramFromServiceMsg, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramQZoneNotifyServlet != null) {
      paramQZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    if (paramQQAppInterface != null)
    {
      paramIntent = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.a(paramFromServiceMsg);
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("param_FailCode", String.valueOf(9311));
      paramFromServiceMsg.put("param_errorDesc", paramIntent);
      StatisticCollector.a(paramQQAppInterface.a()).a(paramQQAppInterface.a(), "actQzoneUnread", false, QZoneNotifyServlet.d - QZoneNotifyServlet.c, 0L, paramFromServiceMsg, "");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramQZoneNotifyServlet != null) {
      paramQZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    if (paramQQAppInterface != null)
    {
      paramArrayOfByte = "|wufbuf: " + HexUtil.a(paramArrayOfByte);
      paramQZoneNotifyServlet = new HashMap();
      paramQZoneNotifyServlet.put("param_FailCode", String.valueOf(9045));
      paramQZoneNotifyServlet.put("param_errorDesc", paramArrayOfByte);
      StatisticCollector.a(paramQQAppInterface.a()).a(paramQQAppInterface.a(), "actQzoneUnread", false, QZoneNotifyServlet.d - QZoneNotifyServlet.c, 0L, paramQZoneNotifyServlet, "");
    }
  }
  
  public static void a(String paramString, Map paramMap)
  {
    paramMap = QzoneMapUtil.a(paramMap);
    LocalMultiProcConfig.a("EXTEND_INFO" + paramString, paramMap);
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(c, 4, "QZoneFeedCountPackeger execCmds");
    }
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        operat_data localoperat_data = (operat_data)paramArrayList.next();
        if (localoperat_data != null)
        {
          if (QLog.isDevelopLevel())
          {
            QLog.d(c, 4, "QZoneFeedCountPackeger operat_data cmd: " + localoperat_data.cmd);
            QLog.d(c, 4, "QZoneFeedCountPackeger operat_data desc: " + localoperat_data.desc);
          }
          QZoneDistributedAppCtrl.Control localControl = new QZoneDistributedAppCtrl.Control();
          localControl.jdField_a_of_type_Int = localoperat_data.cmd;
          if ((localoperat_data.mapExt != null) && (localoperat_data.mapExt.size() > 0)) {
            localControl.jdField_a_of_type_JavaUtilMap.putAll(localoperat_data.mapExt);
          }
          localControl.jdField_a_of_type_JavaUtilMap.put("key_desc", localoperat_data.desc);
          QZoneDistributedAppCtrl.a(paramString).a(localControl);
        }
      }
    }
  }
  
  public static void a(Map paramMap, Long paramLong)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    JSONArray localJSONArray;
    do
    {
      return;
      localJSONArray = new JSONArray();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("key", localEntry.getKey());
          localJSONObject.put("value", localEntry.getValue());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException paramMap)
        {
          QLog.d(c, 2, "setMapLastGetTime JSONException");
          return;
        }
      }
    } while (localJSONArray.length() <= 0);
    LocalMultiProcConfig.a("getMapLastGetTime", localJSONArray.toString(), paramLong.longValue());
  }
  
  private static void a(byte[] paramArrayOfByte, mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    HashMap localHashMap = new HashMap();
    boolean bool = a(parammobile_count_rsp_new, localHashMap, paramQQAppInterface);
    int i = 0;
    if (bool) {
      i = RemoteHandleManager.a().a().a(paramQQAppInterface.getLongAccountUin());
    }
    if (localHashMap == null) {}
    do
    {
      return;
      if (localHashMap.size() == 0) {
        break label113;
      }
      if (bool) {
        break;
      }
    } while (paramQQAppInterface == null);
    paramArrayOfByte = paramQQAppInterface.getManager(9);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof QZoneManagerImp))) {
      ((QZoneManagerImp)paramArrayOfByte).a(localHashMap);
    }
    for (;;)
    {
      a(paramQQAppInterface);
      return;
      a.put(Integer.valueOf(i), localHashMap);
    }
    label113:
    a(paramQQAppInterface, paramArrayOfByte, paramQZoneNotifyServlet);
  }
  
  private static boolean a(entrance_cfg paramentrance_cfg1, entrance_cfg paramentrance_cfg2)
  {
    if ((paramentrance_cfg1 == null) && (paramentrance_cfg2 == null)) {}
    do
    {
      return true;
      if (paramentrance_cfg1 == null) {
        return false;
      }
      if (paramentrance_cfg2 == null) {
        return false;
      }
    } while ((paramentrance_cfg1.iEntranceId == paramentrance_cfg2.iEntranceId) && (TextUtils.equals(paramentrance_cfg1.sEntranceAction, paramentrance_cfg2.sEntranceAction)) && (TextUtils.equals(paramentrance_cfg1.sEntranceName, paramentrance_cfg2.sEntranceName)) && (TextUtils.equals(paramentrance_cfg1.sEntranceIcon, paramentrance_cfg2.sEntranceIcon)));
    return false;
  }
  
  public static boolean a(mobile_count_rsp_new parammobile_count_rsp_new, HashMap paramHashMap, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(c, 4, "onResponse");
    }
    boolean bool2;
    if (parammobile_count_rsp_new == null)
    {
      bool2 = false;
      return bool2;
    }
    if (parammobile_count_rsp_new.stMapCountInfo == null) {
      return false;
    }
    if (parammobile_count_rsp_new.stMapCountInfo.size() == 0) {
      return false;
    }
    if (paramHashMap == null) {
      return false;
    }
    int i = 1;
    boolean bool1 = false;
    label61:
    if (i < 33)
    {
      count_info localcount_info = (count_info)parammobile_count_rsp_new.stMapCountInfo.get(Integer.valueOf(i));
      if (localcount_info == null) {
        break label429;
      }
      QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
      if (localcount_info.stCount == null) {
        break label426;
      }
      localQZoneCountInfo.jdField_a_of_type_Long = localcount_info.stCount.uCount;
      localQZoneCountInfo.jdField_a_of_type_Int = localcount_info.stCount.iControl;
      if (QLog.isDevelopLevel()) {
        QLog.d(c, 4, "onResponse unread cout: " + localcount_info.stCount.uCount + "unread type: " + i);
      }
      if ((i != 1) || (localQZoneCountInfo.jdField_a_of_type_Long <= 0L) || (parammobile_count_rsp_new.isPreLoad != 1) || (TextUtils.isEmpty(parammobile_count_rsp_new.undealCountTime)) || (LocalMultiProcConfig.a("qzone_passive_undealtime", "", paramQQAppInterface.getLongAccountUin()).equals(parammobile_count_rsp_new.undealCountTime))) {
        break label426;
      }
      bool1 = true;
      label239:
      if ((localcount_info.vecUinList != null) && (localcount_info.vecUinList.size() > 0))
      {
        localQZoneCountInfo.jdField_b_of_type_Long = ((feed_host_info)localcount_info.vecUinList.get(0)).uUin;
        localQZoneCountInfo.jdField_a_of_type_JavaLangString = ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc;
        if (QLog.isDevelopLevel()) {
          QLog.d(c, 4, "onResponse unread list first uin: " + ((feed_host_info)localcount_info.vecUinList.get(0)).uUin + ",actiondesc: " + ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc);
        }
      }
      localQZoneCountInfo.jdField_b_of_type_JavaLangString = localcount_info.trace_info;
      paramHashMap.put(Integer.valueOf(i), localQZoneCountInfo);
    }
    label426:
    label429:
    for (;;)
    {
      i += 1;
      break label61;
      bool2 = bool1;
      if (parammobile_count_rsp_new.extendinfo == null) {
        break;
      }
      bool2 = bool1;
      if (paramQQAppInterface == null) {
        break;
      }
      a(paramQQAppInterface.f(), parammobile_count_rsp_new.extendinfo);
      return bool1;
      break label239;
    }
  }
  
  private static boolean a(ArrayList paramArrayList, entrance_cfg paramentrance_cfg)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      if (paramentrance_cfg != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (a(paramentrance_cfg, (entrance_cfg)paramArrayList.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static byte[] a(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Map paramMap, String paramString2)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString1 = new mobile_count_req();
    paramString1.iRelationType = 1;
    paramString1.iVisitQZoneType = paramInt3;
    paramString1.mapTimeStamp = b(paramLong);
    paramString1.mapLastGetTime = a(Long.valueOf(paramLong));
    paramString1.stMapCountInfo = paramMap;
    paramString1.extendinfo = a(paramLong);
    paramString1.lastGetFeedTime = paramString2;
    return QZoneFeedCountPackeger.a(paramString1, "getUndealCount", paramLong, paramInt1, paramInt2, paramInt4);
  }
  
  public static Map b(long paramLong)
  {
    Map localMap = a(LocalMultiProcConfig.a("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  private static void b(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    if (parammobile_count_rsp_new == null) {}
    while ((parammobile_count_rsp_new.stYellowInfo == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.a()))) {
      return;
    }
    Object localObject1 = localObject2;
    if (parammobile_count_rsp_new.QzmallProfileDecoGetRsp != null) {
      paramQQAppInterface = new UndealCountQzmallDeco();
    }
    try
    {
      localObject1 = new JceInputStream(parammobile_count_rsp_new.QzmallProfileDecoGetRsp);
      ((JceInputStream)localObject1).setServerEncoding("utf8");
      paramQQAppInterface.readFrom((JceInputStream)localObject1);
      localObject1 = localObject2;
      if (paramQQAppInterface != null)
      {
        localObject1 = localObject2;
        if (paramQQAppInterface.stCustomVip != null)
        {
          localObject1 = localObject2;
          if (paramQQAppInterface.stCustomVip.iItemId != -1) {
            localObject1 = paramQQAppInterface.stCustomVip.strSrcUrl;
          }
        }
      }
      QZoneVipInfoManager.a().a(parammobile_count_rsp_new.stYellowInfo.iYellowType, parammobile_count_rsp_new.stYellowInfo.iYellowLevel, parammobile_count_rsp_new.stYellowInfo.isAnnualVip, parammobile_count_rsp_new.stuStarInfo, parammobile_count_rsp_new.stuCombineDiamondInfo, (String)localObject1);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
    }
  }
  
  private static boolean b(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    boolean bool = true;
    if (paramArrayList1 == null) {}
    int j;
    label85:
    for (;;)
    {
      return false;
      if ((paramArrayList2 != null) && (paramArrayList1.size() == paramArrayList2.size()) && (paramArrayList1.size() != 0))
      {
        int i = 1;
        j = 0;
        if (j >= paramArrayList1.size()) {
          break;
        }
        entrance_cfg localentrance_cfg = (entrance_cfg)paramArrayList1.get(j);
        if ((i != 0) && (a(paramArrayList2, localentrance_cfg))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label85;
          }
          j += 1;
          break;
        }
      }
    }
    if (j == paramArrayList1.size()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static void c(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    do
    {
      do
      {
        return;
        LocalMultiProcConfig.a("navigator_bar_style", parammobile_count_rsp_new.isShowNewStyles, paramQQAppInterface.getLongAccountUin());
      } while ((parammobile_count_rsp_new.mapEntranceCfg == null) || (parammobile_count_rsp_new.mapEntranceCfg.size() == 0));
      parammobile_count_rsp_new = (ArrayList)parammobile_count_rsp_new.mapEntranceCfg.get(Integer.valueOf(2));
    } while ((parammobile_count_rsp_new == null) || (parammobile_count_rsp_new.size() == 0));
    if (QLog.isDevelopLevel()) {
      QLog.d(c, 4, "handleNavigatorBarInfo rsp entracesize is:" + parammobile_count_rsp_new.size());
    }
    ThreadManager.a(new upj(paramQQAppInterface, parammobile_count_rsp_new), 8, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\qzone\QZoneUnreadServletLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */