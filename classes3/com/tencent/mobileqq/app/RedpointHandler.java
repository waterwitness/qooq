package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.LbsCellInfo;
import com.tencent.mobileqq.redtouch.LbsWLanInfo;
import com.tencent.mobileqq.redtouch.RedLbsInfoUtil;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsCellInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsDetailInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsLocationInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsSubnation;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsWlanInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import qfi;
import qfj;

public class RedpointHandler
  extends BusinessHandler
  implements BusinessInfoCheckUpdateItem
{
  public static final HashSet a;
  public static final String h;
  public static final String i = "QQClubComm.getNewFlag";
  SosoInterface.OnLocationListener a;
  public int cf = 600000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    h = RedpointHandler.class.getSimpleName();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  protected RedpointHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new qfi(this, 0, false, true, this.cf, false, false, h);
  }
  
  private BusinessInfoCheckUpdate.LbsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    BusinessInfoCheckUpdate.LbsInfo localLbsInfo = new BusinessInfoCheckUpdate.LbsInfo();
    BusinessInfoCheckUpdate.LbsLocationInfo localLbsLocationInfo = new BusinessInfoCheckUpdate.LbsLocationInfo();
    localLbsLocationInfo.coordinate.set(1);
    localLbsLocationInfo.latitude.set((int)(paramSosoLocation.jdField_a_of_type_Double * 1000000.0D));
    localLbsLocationInfo.longitude.set((int)(paramSosoLocation.b * 1000000.0D));
    double d = paramSosoLocation.jdField_e_of_type_Double;
    float f = paramSosoLocation.jdField_a_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "getLbsInfo: altitude = " + d + ";accuracy = " + f);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(d).append(",").append(f).append(",0,0,0");
    localLbsLocationInfo.additional.set(((StringBuilder)localObject1).toString());
    BusinessInfoCheckUpdate.LbsDetailInfo localLbsDetailInfo = new BusinessInfoCheckUpdate.LbsDetailInfo();
    BusinessInfoCheckUpdate.LbsSubnation localLbsSubnation = new BusinessInfoCheckUpdate.LbsSubnation();
    Object localObject2;
    label210:
    Object localObject3;
    label224:
    Object localObject4;
    label238:
    Object localObject5;
    label252:
    String str1;
    label266:
    String str2;
    label280:
    label293:
    label442:
    label457:
    int j;
    if (TextUtils.isEmpty(paramSosoLocation.jdField_c_of_type_JavaLangString))
    {
      localObject1 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.d)) {
        break label741;
      }
      localObject2 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.jdField_e_of_type_JavaLangString)) {
        break label750;
      }
      localObject3 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.f)) {
        break label759;
      }
      localObject4 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.g)) {
        break label768;
      }
      localObject5 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.h)) {
        break label777;
      }
      str1 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.i)) {
        break label786;
      }
      str2 = "";
      if (!TextUtils.isEmpty(paramSosoLocation.j)) {
        break label795;
      }
      paramSosoLocation = "";
      localLbsSubnation.nation.set((String)localObject1);
      localLbsSubnation.province.set((String)localObject2);
      localLbsSubnation.city.set((String)localObject3);
      localLbsSubnation.district.set((String)localObject4);
      localLbsSubnation.town.set((String)localObject5);
      localLbsSubnation.village.set(str1);
      localLbsSubnation.street.set(str2);
      localLbsSubnation.street_no.set(paramSosoLocation);
      localLbsDetailInfo.subnation.set(localLbsSubnation);
      localObject3 = new RedLbsInfoUtil(this.b.a());
      localObject2 = new ArrayList();
      localObject4 = ((RedLbsInfoUtil)localObject3).a();
      if (localObject4 != null)
      {
        localObject5 = new BusinessInfoCheckUpdate.LbsWlanInfo();
        if (((LbsWLanInfo)localObject4).jdField_a_of_type_JavaLangString == null) {
          break label803;
        }
        paramSosoLocation = ((LbsWLanInfo)localObject4).jdField_a_of_type_JavaLangString;
        if (((LbsWLanInfo)localObject4).b == null) {
          break label809;
        }
        localObject1 = ((LbsWLanInfo)localObject4).b;
        ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).mac.set(paramSosoLocation);
        ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).rssi.set(((LbsWLanInfo)localObject4).jdField_a_of_type_Int);
        ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).ssid.set((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "wlanInfo : mac = " + paramSosoLocation + ";rssi = " + ((LbsWLanInfo)localObject4).jdField_a_of_type_Int + ";ssid = " + (String)localObject1);
        }
        ((List)localObject2).add(localObject5);
      }
      localObject1 = ((RedLbsInfoUtil)localObject3).a();
      if (localObject1 == null) {
        break label822;
      }
      j = 0;
      label569:
      if (j >= ((List)localObject1).size()) {
        break label822;
      }
      if (j < 4)
      {
        localObject5 = new BusinessInfoCheckUpdate.LbsWlanInfo();
        if (((LbsWLanInfo)((List)localObject1).get(j)).jdField_a_of_type_JavaLangString == null) {
          break label816;
        }
      }
    }
    label741:
    label750:
    label759:
    label768:
    label777:
    label786:
    label795:
    label803:
    label809:
    label816:
    for (paramSosoLocation = ((LbsWLanInfo)((List)localObject1).get(j)).jdField_a_of_type_JavaLangString;; paramSosoLocation = "")
    {
      ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).mac.set(paramSosoLocation);
      ((BusinessInfoCheckUpdate.LbsWlanInfo)localObject5).rssi.set(((LbsWLanInfo)((List)localObject1).get(j)).jdField_a_of_type_Int);
      if ((QLog.isColorLevel()) && (localObject4 != null)) {
        QLog.d(h, 2, "near wlanInfo : mac = " + paramSosoLocation + ";rssi = " + ((LbsWLanInfo)localObject4).jdField_a_of_type_Int);
      }
      ((List)localObject2).add(localObject5);
      j += 1;
      break label569;
      localObject1 = paramSosoLocation.jdField_c_of_type_JavaLangString;
      break;
      localObject2 = paramSosoLocation.d;
      break label210;
      localObject3 = paramSosoLocation.jdField_e_of_type_JavaLangString;
      break label224;
      localObject4 = paramSosoLocation.f;
      break label238;
      localObject5 = paramSosoLocation.g;
      break label252;
      str1 = paramSosoLocation.h;
      break label266;
      str2 = paramSosoLocation.i;
      break label280;
      paramSosoLocation = paramSosoLocation.j;
      break label293;
      paramSosoLocation = "";
      break label442;
      localObject1 = "";
      break label457;
    }
    label822:
    paramSosoLocation = new ArrayList();
    localObject1 = ((RedLbsInfoUtil)localObject3).a();
    if (localObject1 != null)
    {
      localObject4 = new BusinessInfoCheckUpdate.LbsCellInfo();
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).cellid.set(((LbsCellInfo)localObject1).d);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).lac.set(((LbsCellInfo)localObject1).jdField_c_of_type_Int);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).mcc.set(((LbsCellInfo)localObject1).jdField_a_of_type_Int);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).mnc.set(((LbsCellInfo)localObject1).b);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).rssi.set(((LbsCellInfo)localObject1).e);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).stationLat.set(((LbsCellInfo)localObject1).f);
      ((BusinessInfoCheckUpdate.LbsCellInfo)localObject4).stationLng.set(((LbsCellInfo)localObject1).g);
      paramSosoLocation.add(localObject4);
    }
    localObject1 = ((RedLbsInfoUtil)localObject3).b();
    if (localObject1 != null)
    {
      j = 0;
      while (j < ((List)localObject1).size())
      {
        if (j < 4)
        {
          localObject3 = new BusinessInfoCheckUpdate.LbsCellInfo();
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).cellid.set(((LbsCellInfo)((List)localObject1).get(j)).d);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).lac.set(((LbsCellInfo)((List)localObject1).get(j)).jdField_c_of_type_Int);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).mcc.set(((LbsCellInfo)((List)localObject1).get(j)).jdField_a_of_type_Int);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).mnc.set(((LbsCellInfo)((List)localObject1).get(j)).b);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).rssi.set(((LbsCellInfo)((List)localObject1).get(j)).e);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).stationLat.set(((LbsCellInfo)((List)localObject1).get(j)).f);
          ((BusinessInfoCheckUpdate.LbsCellInfo)localObject3).stationLng.set(((LbsCellInfo)((List)localObject1).get(j)).g);
          paramSosoLocation.add(localObject3);
        }
        j += 1;
      }
    }
    localLbsInfo.cells.set(paramSosoLocation);
    localLbsInfo.location.set(localLbsLocationInfo);
    localLbsInfo.wlan.set((List)localObject2);
    localLbsInfo.detail_info.set(localLbsDetailInfo);
    return localLbsInfo;
  }
  
  private void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.a(new qfj(this, paramInt, paramSosoLbsInfo), 5, null, true);
      return;
    }
    b(paramInt, paramSosoLbsInfo);
  }
  
  private void a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilHashSet == null) {}
    do
    {
      return;
      if (paramLong == 1113L)
      {
        jdField_a_of_type_JavaUtilHashSet.add("1113.100800");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100801");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100802");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100803");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100804");
        return;
      }
    } while (paramLong != 100001113L);
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100800");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100801");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100802");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100803");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100804");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).a();
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), GameCenterServlet.class);
    ((NewIntent)localObject).setAction("gc_refresh_ui");
    ((NewIntent)localObject).putExtra("gc_notify_type", 6);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {}
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody;
    Object localObject2;
    int j;
    label189:
    int k;
    label330:
    Object localObject4;
    for (;;)
    {
      return;
      try
      {
        localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
        localTimeRspBody.mergeFrom((byte[])paramObject);
        if (localTimeRspBody != null) {
          if (localTimeRspBody.iResult.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(h, 2, "handleResponse,return fail ,TimeRspBody result:" + localTimeRspBody.iResult.get());
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
          QLog.e(h, 1, "mergeFrom failed");
          localTimeRspBody = null;
        }
        paramObject = this.b.a().getSharedPreferences("check_update_sp_key", 0);
        localObject1 = ((SharedPreferences)paramObject).edit();
        if (localTimeRspBody.iInterval.has())
        {
          localObject2 = "businessinfo_check_update_interval_" + this.b.a();
          if (localTimeRspBody.iInterval.get() > 0) {
            j = localTimeRspBody.iInterval.get();
          }
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, j);
          ((SharedPreferences.Editor)localObject1).putInt("businessinfo_check_update_interval_lbsinfo_" + this.b.a(), localTimeRspBody.iLbsInterval.get());
          ((SharedPreferences.Editor)localObject1).putInt("businessinfo_last_check_update_timestamp_" + this.b.a(), (int)(System.currentTimeMillis() / 1000L));
          ((SharedPreferences.Editor)localObject1).commit();
          localObject1 = ResourcePluginInfo.getAll(this.b.a().createEntityManager(), 64, false);
          localObject2 = (RedTouchManager)this.b.getManager(35);
          try
          {
            if (!localTimeRspBody.rptMsgAppInfo.has()) {
              break label912;
            }
            k = localTimeRspBody.rptMsgAppInfo.size();
            j = 0;
            if (j >= k) {
              break label912;
            }
            localObject3 = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(j);
            if ((localObject3 != null) && (1 == ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get()))
            {
              if (a((List)localObject1, (BusinessInfoCheckUpdate.AppInfo)localObject3)) {
                break label567;
              }
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
              ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(0);
              localTimeRspBody.rptMsgAppInfo.set(j, (MessageMicro)localObject3);
              if (QLog.isColorLevel()) {
                QLog.d(h, 2, "verifyDataCorrect,return false ,appInfo.path.get():" + ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get());
              }
            }
            for (;;)
            {
              if ((localObject3 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject3).use_cache.get()))
              {
                localObject4 = ((RedTouchManager)localObject2).a(((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get());
                if (localObject4 != null)
                {
                  ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject4).buffer.get());
                  localTimeRspBody.rptMsgAppInfo.set(j, (MessageMicro)localObject3);
                }
              }
              j += 1;
              break label330;
              j = 0;
              break;
              ((SharedPreferences.Editor)localObject1).remove("businessinfo_check_update_interval_" + this.b.a());
              break label189;
              label567:
              if (((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.get() == 769) {
                ((SharedPreferences)paramObject).edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.b.a(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).commit();
              }
            }
            ((RedTouchManager)localObject2).a(localTimeRspBody);
          }
          catch (Exception paramObject)
          {
            ((Exception)paramObject).printStackTrace();
          }
        }
      }
    }
    paramObject = (IndividuationABTestManager)this.b.getManager(176);
    if ((!((IndividuationABTestManager)paramObject).b) && (!((IndividuationABTestManager)paramObject).a)) {
      ((IndividuationABTestManager)paramObject).a(this.b.a());
    }
    if ((((IndividuationABTestManager)paramObject).jdField_c_of_type_Int != 0) && (!TextUtils.isEmpty(((IndividuationABTestManager)paramObject).jdField_c_of_type_JavaLangString)) && (((IndividuationABTestManager)paramObject).d == 0))
    {
      if (localTimeRspBody.rptMsgAppInfo.has())
      {
        k = localTimeRspBody.rptMsgAppInfo.size();
        j = 0;
        label732:
        if (j < k)
        {
          paramObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(j);
          if ((paramObject == null) || (!String.valueOf(100005).equals(((BusinessInfoCheckUpdate.AppInfo)paramObject).path.get()))) {
            break label1247;
          }
          ((BusinessInfoCheckUpdate.AppInfo)paramObject).iNewFlag.set(0);
          ((BusinessInfoCheckUpdate.AppInfo)paramObject).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "individuation jump open");
      }
    }
    if ((localTimeRspBody != null) && (localTimeRspBody.rptSetting != null) && (localTimeRspBody.rptSetting.get() != null)) {
      LebaShowListManager.a().a(localTimeRspBody.rptSetting.get());
    }
    if (QLog.isColorLevel()) {
      QLog.i(h, 2, "update NearbyNumAppinfo");
    }
    NearbyMineHelper.a(this.b);
    if (QLog.isColorLevel()) {
      QLog.i(h, 2, "on pull Appinfos");
    }
    ((LocalRedTouchManager)this.b.getManager(159)).d();
    a(this.b);
    return;
    label912:
    Object localObject1 = localTimeRspBody.rptSetting.get();
    paramObject = ((RedTouchManager)localObject2).b();
    Object localObject3 = new ArrayList();
    if ((localObject1 != null) && (paramObject != null))
    {
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject4 = (BusinessInfoCheckUpdate.AppSetting)((List)localObject1).get(j);
        k = 0;
        label973:
        if (k < ((List)paramObject).size())
        {
          if (((BusinessInfoCheckUpdate.AppSetting)((List)paramObject).get(k)).appid.get() != ((BusinessInfoCheckUpdate.AppSetting)localObject4).appid.get()) {
            break label1274;
          }
          ((List)paramObject).set(k, localObject4);
          k = 1;
          label1026:
          if (k != 0) {
            break label1265;
          }
          ((List)localObject3).add(localObject4);
          break label1265;
        }
      }
      else
      {
        ((List)paramObject).addAll((Collection)localObject3);
      }
    }
    for (;;)
    {
      label1053:
      localTimeRspBody.rptSetting.set((List)paramObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("redinfo:");
      if (localTimeRspBody.rptMsgAppInfo.has())
      {
        k = localTimeRspBody.rptMsgAppInfo.size();
        j = 0;
        label1105:
        if (j < k)
        {
          localObject1 = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(j);
          if (localObject1 == null) {
            break label1283;
          }
          ((StringBuilder)paramObject).append("appid = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.get());
          ((StringBuilder)paramObject).append("path = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get());
          ((StringBuilder)paramObject).append("inewflag = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get());
          ((StringBuilder)paramObject).append(";");
          break label1283;
        }
      }
      QLog.d(h, 2, ((StringBuilder)paramObject).toString());
      break;
      label1247:
      j += 1;
      break label732;
      label1265:
      label1274:
      label1283:
      do
      {
        break label1053;
        k = 0;
        break label1026;
        j += 1;
        break;
        k += 1;
        break label973;
        j += 1;
        break label1105;
      } while (paramObject != null);
      paramObject = localObject1;
    }
  }
  
  public static boolean a(List paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return false;
      if (paramAppInfo.appset.get() == 3) {
        return true;
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        int k = paramList.size();
        j = 0;
        while (j < k)
        {
          long l = ((ResourcePluginInfo)paramList.get(j)).uiResId;
          String str = "100600." + (100000000L + l) + "";
          if (((((ResourcePluginInfo)paramList.get(j)).uiResId + "").equals(paramAppInfo.path.get())) || (str.equals(paramAppInfo.path.get()))) {
            return true;
          }
          if ((jdField_a_of_type_JavaUtilHashSet != null) && (jdField_a_of_type_JavaUtilHashSet.contains(paramAppInfo.path.get()))) {
            return true;
          }
          j += 1;
        }
      }
      int j = 0;
      while (j < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        paramList = paramAppInfo.path.get();
        if (jdField_a_of_type_Array2dOfJavaLangString[j][1].equals(paramList)) {
          return true;
        }
        j += 1;
      }
    }
  }
  
  private void b(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("6.5.5.2880");
    localTimeReqBody.uiUin.set(Long.parseLong(this.b.a()));
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if (paramSosoLbsInfo != null) {
        localTimeReqBody.lbs.set(paramSosoLbsInfo);
      }
    }
    List localList = ResourcePluginInfo.getAll(this.b.a().createEntityManager(), 64, false);
    Object localObject3 = (RedTouchManager)this.b.getManager(35);
    Object localObject1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label173:
    int j;
    Object localObject2;
    int m;
    int k;
    if (localObject3 == null)
    {
      localObject1 = null;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      if (localList == null) {
        break label464;
      }
      paramSosoLbsInfo = null;
      if (localObject1 != null) {
        break label284;
      }
      paramInt = 0;
      j = 0;
      if (j >= localList.size()) {
        break label464;
      }
      localObject2 = ((ResourcePluginInfo)localList.get(j)).uiResId + "";
      m = (int)((ResourcePluginInfo)localList.get(j)).uiResId;
      k = 0;
      label244:
      if (k >= paramInt) {
        break label306;
      }
      paramSosoLbsInfo = (BusinessInfoCheckUpdate.AppSetting)((List)localObject1).get(k);
      if (paramSosoLbsInfo != null) {
        break label294;
      }
    }
    label284:
    label294:
    while (m != paramSosoLbsInfo.appid.get())
    {
      k += 1;
      break label244;
      localObject1 = ((RedTouchManager)localObject3).b();
      break;
      paramInt = ((List)localObject1).size();
      break label173;
    }
    label306:
    if ((k == paramInt) || (paramSosoLbsInfo == null))
    {
      paramSosoLbsInfo = new BusinessInfoCheckUpdate.AppSetting();
      paramSosoLbsInfo.appid.set(m);
      paramSosoLbsInfo.setting.set(true);
      paramSosoLbsInfo.modify_ts.set(0L);
    }
    for (;;)
    {
      if (!paramSosoLbsInfo.setting.get())
      {
        long l = 100000000L + ((ResourcePluginInfo)localList.get(j)).uiResId;
        localObject2 = "100600." + l + "";
        a(l);
      }
      for (;;)
      {
        localTimeReqBody.rptSetting.add(paramSosoLbsInfo);
        localArrayList1.add(localObject2);
        j += 1;
        break;
        a(((ResourcePluginInfo)localList.get(j)).uiResId);
      }
      label464:
      localArrayList1.addAll(jdField_a_of_type_JavaUtilHashSet);
      paramInt = 0;
      while (paramInt < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        localArrayList1.add(jdField_a_of_type_Array2dOfJavaLangString[paramInt][1]);
        paramInt += 1;
      }
      if (localObject3 != null)
      {
        paramSosoLbsInfo = ((RedTouchManager)localObject3).a(3).iterator();
        while (paramSosoLbsInfo.hasNext()) {
          localArrayList1.add(((BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.next()).path.get());
        }
        if (((RedTouchManager)localObject3).a() == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(h, 2, "BusinessInfoCheckUpdateItem pb file does not exist");
          }
          localArrayList2.addAll(localArrayList1);
        }
      }
      else
      {
        localTimeReqBody.rptMsgAppInfo.set(localArrayList3);
        localTimeReqBody.rptNoRedPath.set(localArrayList2);
        if ((!((FontManager)this.b.getManager(41)).a) && (localTimeReqBody.rptMsgAppInfo.has()))
        {
          paramInt = 0;
          label644:
          if (paramInt < localTimeReqBody.rptMsgAppInfo.size())
          {
            if (!"100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get())) {
              break label1149;
            }
            localTimeReqBody.rptMsgAppInfo.remove(paramInt);
          }
        }
        if (!QLog.isColorLevel()) {
          break label1186;
        }
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("req red pathlist:");
        if (!localTimeReqBody.rptMsgAppInfo.has()) {
          break label1156;
        }
        paramInt = 0;
        while (paramInt < localTimeReqBody.rptMsgAppInfo.size())
        {
          localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramSosoLbsInfo.append((String)localObject1);
            paramSosoLbsInfo.append(";");
          }
          paramInt += 1;
        }
      }
      paramSosoLbsInfo = ((RedTouchManager)localObject3).a();
      if (paramSosoLbsInfo.rptMsgAppInfo.has())
      {
        j = 0;
        label805:
        if (j < localArrayList1.size())
        {
          localObject1 = (String)localArrayList1.get(j);
          paramInt = 0;
          label832:
          if (paramInt >= paramSosoLbsInfo.rptMsgAppInfo.size()) {
            break label1355;
          }
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.rptMsgAppInfo.get(paramInt);
          if (!((String)localObject1).equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get())) {
            break label1129;
          }
          localObject3 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get();
          paramInt = 0;
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
            paramInt = 1;
          }
          if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) || (paramInt == 0)) {
            break label939;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          localArrayList2.add(localObject1);
        }
        j += 1;
        break label805;
        break;
        label939:
        localObject3 = new BusinessInfoCheckUpdate.AppInfo();
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).type.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).push_red_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).mission_level.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).mission_level.get());
        paramInt = 0;
        while (paramInt < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
        {
          ((BusinessInfoCheckUpdate.AppInfo)localObject3).missions.add(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(paramInt));
          paramInt += 1;
        }
        localArrayList3.add(localObject3);
        paramInt = 0;
        continue;
        label1129:
        paramInt += 1;
        break label832;
        localArrayList2.addAll(localArrayList1);
        break;
        label1149:
        paramInt += 1;
        break label644;
        label1156:
        QLog.d(h, 2, "getNewFlagOp rptMsginfoPath:" + paramSosoLbsInfo.toString());
        label1186:
        if (QLog.isColorLevel())
        {
          paramSosoLbsInfo = new StringBuilder();
          paramSosoLbsInfo.append("req nored pathlist:");
          if (localTimeReqBody.rptNoRedPath.has())
          {
            paramInt = 0;
            while (paramInt < localTimeReqBody.rptNoRedPath.size())
            {
              localObject1 = (String)localTimeReqBody.rptNoRedPath.get(paramInt);
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                paramSosoLbsInfo.append((String)localObject1);
                paramSosoLbsInfo.append(";");
              }
              paramInt += 1;
            }
          }
          QLog.d(h, 2, "getNewFlagOp rptNoRedPath:" + paramSosoLbsInfo.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "getNewFlagOp local message ok");
        }
        paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.b.a(), "QQClubComm.getNewFlag");
        paramSosoLbsInfo.putWupBuffer(localTimeReqBody.toByteArray());
        b(paramSosoLbsInfo);
        return;
        label1355:
        paramInt = 1;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "getNewFlagOp:sendredInfo start");
    }
    SharedPreferences localSharedPreferences = this.b.a().getSharedPreferences("check_update_sp_key", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int j = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.b.a(), 600);
    this.cf = (j * 1000);
    int k = localSharedPreferences.getInt("businessinfo_check_update_interval_lbsinfo_" + this.b.a(), 43200000);
    int m = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.b.a(), 0);
    int n = (int)(System.currentTimeMillis() / 1000L);
    if ((!paramBoolean) && (n - m <= j) && (n >= m))
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "getNewFlagOp:sendredInfo error:systemTimestamp = " + n + ";lastUpdateTimestamp = " + m + ";updateInterval = " + j);
      }
      return;
    }
    localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.b.a(), (int)(System.currentTimeMillis() / 1000L)).commit();
    if ((n - m <= k) && (n >= m))
    {
      a(-1, null);
      return;
    }
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int j = 1;; j = 0)
    {
      if (("QQClubComm.getNewFlag".equals(paramFromServiceMsg.getServiceCmd())) && (j != 0)) {
        a(paramObject);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\RedpointHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */