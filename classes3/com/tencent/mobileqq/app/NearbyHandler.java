package com.tencent.mobileqq.app;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import NeighborComm.RespHeader;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.ReportRecord;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearpeople.EncounterHolder;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfig;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfigExtraVal;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x4f0.cmd0x4f0.ReqBody;
import tencent.im.oidb.cmd0x4f0.cmd0x4f0.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspConfigItem;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspLikeInfo;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspPansocialInfo;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;
import tencent.im.oidb.cmd0x6be.Oidb_0x6be.ReqBody;
import tencent.im.oidb.cmd0x77f.cmd0x77f.ReqBody;
import tencent.im.oidb.cmd0x77f.cmd0x77f.VisitProfRec;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;
import tencent.sso.roam.Roam.RoamQualifyReq;
import tencent.sso.roam.Roam.RoamQualifyRsp;
import tencent.sso.roam.Roam.RoamReqHead;

public class NearbyHandler
  extends BusinessHandler
{
  public static final int a = -11;
  static final String jdField_a_of_type_JavaLangString = NearbyHandler.class.getSimpleName();
  public static final int b = -111;
  public static final int c = -1111;
  public static int d;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof NearbyAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    paramAppInterface.a("CliOper", "", "", "Neiggbor", "ReqGetEncounter", 0, paramInt, "", "", "", "");
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    Object localObject = new cmd0x4f0.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    boolean bool = paramToServiceMsg.extraData.getBoolean("is_first_page");
    if (i == 0)
    {
      label87:
      long l1;
      label109:
      long l2;
      label131:
      long l3;
      if (((cmd0x4f0.RspBody)localObject).bytes_cookie.has())
      {
        paramToServiceMsg = ((cmd0x4f0.RspBody)localObject).bytes_cookie.get().toByteArray();
        if (!((cmd0x4f0.RspBody)localObject).uint32_completed.has()) {
          break label231;
        }
        i = ((cmd0x4f0.RspBody)localObject).uint32_completed.get();
        if (!((cmd0x4f0.RspBody)localObject).uint32_total_visitor.has()) {
          break label237;
        }
        l1 = ((cmd0x4f0.RspBody)localObject).uint32_total_visitor.get();
        if (!((cmd0x4f0.RspBody)localObject).uint32_unread_visitor.has()) {
          break label243;
        }
        l2 = ((cmd0x4f0.RspBody)localObject).uint32_unread_visitor.get();
        l3 = l1 - l2;
        if (!((cmd0x4f0.RspBody)localObject).rpt_msg_vistor_info.has()) {
          break label249;
        }
      }
      label231:
      label237:
      label243:
      label249:
      for (paramFromServiceMsg = ((cmd0x4f0.RspBody)localObject).rpt_msg_vistor_info.get();; paramFromServiceMsg = null)
      {
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
          break label254;
        }
        paramObject = new ArrayList();
        localObject = paramFromServiceMsg.iterator();
        for (;;)
        {
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramFromServiceMsg = StrangerInfo.convertFrom((appoint_define.PublisherInfo)((Iterator)localObject).next());
          if (paramFromServiceMsg != null) {
            ((ArrayList)paramObject).add(paramFromServiceMsg);
          }
        }
        paramToServiceMsg = null;
        break;
        i = 0;
        break label87;
        l1 = 0L;
        break label109;
        l2 = 0L;
        break label131;
      }
      label254:
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby.visitor", 2, "handleGetRecentVisitors|c");
      }
      int j;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder().append("handleGetRecentVisitors|cookie lenght: ");
        if (paramToServiceMsg != null) {
          break label495;
        }
        j = 0;
        paramObject = ((StringBuilder)paramObject).append(j).append(",compleFlag: ").append(i).append(",totalVisitor: ").append(l1).append(",newVisitor:").append(l2).append(",hisVisitor:").append(l3).append(",visitorCount: ");
        if (paramFromServiceMsg != null) {
          break label502;
        }
        j = 0;
        label355:
        localObject = ((StringBuilder)paramObject).append(j).append(",visitor info is: ");
        if (paramFromServiceMsg != null) {
          break label511;
        }
      }
      label495:
      label502:
      label511:
      for (paramObject = null;; paramObject = paramFromServiceMsg.toString())
      {
        QLog.i("Q.nearby.visitor", 2, (String)paramObject);
        if ((!bool) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
          break label599;
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().createEntityManager();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DELETE FROM ");
        ((StringBuilder)localObject).append(StrangerInfo.class.getSimpleName());
        ((StringBuilder)localObject).append(";");
        ((EntityManager)paramObject).b(((StringBuilder)localObject).toString());
        localObject = paramFromServiceMsg.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((EntityManager)paramObject).a((StrangerInfo)((Iterator)localObject).next());
        }
        j = paramToServiceMsg.length;
        break;
        j = paramFromServiceMsg.size();
        break label355;
      }
      paramObject = NearbySPUtil.a("nearby_visitor_file", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 0).edit();
      if (l1 > 0L)
      {
        ((SharedPreferences.Editor)paramObject).putLong("sp_nearby_total_visitor", l1);
        if (l2 > 0L) {
          ((SharedPreferences.Editor)paramObject).putLong("sp_nearby_new_visitor", l2);
        }
        if (l3 > 0L) {
          ((SharedPreferences.Editor)paramObject).putLong("sp_nearby_his_visitor", l3);
        }
        ((SharedPreferences.Editor)paramObject).commit();
      }
      label599:
      a(11, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i), Long.valueOf(l1), "", Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l3) });
      return;
    }
    if (((cmd0x4f0.RspBody)localObject).str_error_tips.has()) {}
    for (paramToServiceMsg = ((cmd0x4f0.RspBody)localObject).str_error_tips.get();; paramToServiceMsg = "")
    {
      a(11, false, new Object[] { null, null, Integer.valueOf(-1), Long.valueOf(-1L), paramToServiceMsg, Boolean.valueOf(bool), Long.valueOf(-1L), Long.valueOf(-1L) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetRecentVisitors: result is: " + i + " errorTips: " + paramToServiceMsg);
      return;
    }
  }
  
  public long a(int paramInt1, boolean paramBoolean1, long[] paramArrayOfLong, GeoPoint paramGeoPoint1, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, byte paramByte3, byte paramByte4, int paramInt4, int paramInt5, int paramInt6, int paramInt7, GeoPoint paramGeoPoint2, DatingFilters paramDatingFilters, String paramString1, long paramLong1, byte paramByte5, boolean paramBoolean2, String paramString2, int paramInt8, long paramLong2)
  {
    long l = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "EncounterSvc.ReqGetEncounter");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("gender", paramInt1);
    localToServiceMsg.extraData.putBoolean("first", paramBoolean1);
    localToServiceMsg.extraData.putLongArray("tags", paramArrayOfLong);
    localToServiceMsg.extraData.putInt("roamMode", paramInt2);
    localToServiceMsg.extraData.putByte("constellation", paramByte1);
    localToServiceMsg.extraData.putByte("neighbor_interest_id", paramByte2);
    localToServiceMsg.extraData.putInt("timeInterval", paramInt3);
    localToServiceMsg.extraData.putByte("ageLow", paramByte3);
    localToServiceMsg.extraData.putByte("ageUp", paramByte4);
    localToServiceMsg.extraData.putLong("requestId", l);
    localToServiceMsg.extraData.putInt("careerID", paramInt4);
    localToServiceMsg.extraData.putInt("hometownCountry", paramInt5);
    localToServiceMsg.extraData.putInt("hometownProvince", paramInt6);
    localToServiceMsg.extraData.putInt("hometownCity", paramInt7);
    localToServiceMsg.extraData.putString("adExtra", paramString1);
    localToServiceMsg.extraData.putLong("adCtrl", paramLong1);
    localToServiceMsg.extraData.putByte("rankListNum", paramByte5);
    localToServiceMsg.extraData.putLong("requestTime", l);
    localToServiceMsg.extraData.putBoolean("fromNearby", paramBoolean2);
    paramString1 = localToServiceMsg.extraData;
    paramArrayOfLong = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramArrayOfLong = "";
    }
    paramString1.putString("account", paramArrayOfLong);
    if (paramGeoPoint1 != null)
    {
      paramInt1 = paramGeoPoint1.getLatitudeE6();
      paramInt2 = paramGeoPoint1.getLongitudeE6();
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        localToServiceMsg.extraData.putInt("lat", paramInt1);
        localToServiceMsg.extraData.putInt("lon", paramInt2);
      }
    }
    if (paramGeoPoint2 != null)
    {
      paramInt1 = paramGeoPoint2.getLatitudeE6();
      paramInt2 = paramGeoPoint2.getLongitudeE6();
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        localToServiceMsg.extraData.putInt("localLat", paramInt1);
        localToServiceMsg.extraData.putInt("localLon", paramInt2);
      }
    }
    localToServiceMsg.extraData.putParcelable("datingFilter", paramDatingFilters);
    localToServiceMsg.extraData.putInt("neighbor_list_source", paramInt8);
    localToServiceMsg.extraData.putLong("neighbor_sub_interest_id", paramLong2);
    a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "LBSHandler.getEncounter()");
    }
    return l;
  }
  
  protected Class a()
  {
    return NearbyObserver.class;
  }
  
  cmd0x77f.VisitProfRec a(NearbyReportManager.ReportRecord paramReportRecord)
  {
    cmd0x77f.VisitProfRec localVisitProfRec = new cmd0x77f.VisitProfRec();
    localVisitProfRec.uint64_tinyid.set(paramReportRecord.jdField_a_of_type_Long);
    localVisitProfRec.uint32_seq.set(paramReportRecord.jdField_a_of_type_Int);
    if (paramReportRecord.c > 0) {
      localVisitProfRec.uint32_enter_count.set(paramReportRecord.c);
    }
    if (paramReportRecord.d > 0) {
      localVisitProfRec.uint32_visit_duration.set(paramReportRecord.d);
    }
    if (paramReportRecord.e > 0) {
      localVisitProfRec.uint32_visit_pic_count.set(paramReportRecord.e);
    }
    if (paramReportRecord.f > 0) {
      localVisitProfRec.uint32_opflag.set(paramReportRecord.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "convert2VisitRec ,record =" + paramReportRecord);
    }
    return localVisitProfRec;
  }
  
  public void a()
  {
    String str = b();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", str, "RoamClientSvr.GetQualify");
    Roam.RoamReqHead localRoamReqHead = new Roam.RoamReqHead();
    localRoamReqHead.protocol_ver.set(1);
    localRoamReqHead.client_plat_id.set(109);
    localRoamReqHead.client_ver.set("6.5.5");
    localRoamReqHead.os_ver.set(Build.VERSION.RELEASE);
    Object localObject = localRoamReqHead.uin;
    if (TextUtils.isDigitsOnly(str)) {}
    for (long l = Long.parseLong(str);; l = 0L)
    {
      ((PBUInt64Field)localObject).set(l);
      localObject = new Roam.RoamQualifyReq();
      ((Roam.RoamQualifyReq)localObject).head.set(localRoamReqHead);
      localToServiceMsg.putWupBuffer(((Roam.RoamQualifyReq)localObject).toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRoamQualify client_ver=6.5.5,os_ver=" + Build.VERSION.RELEASE + ",uin=" + str);
      }
      b(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "clearRedTouch| appid = " + paramInt);
    }
    Object localObject = new Oidb_0x6be.ReqBody();
    ((Oidb_0x6be.ReqBody)localObject).uint32_appid.set(paramInt);
    localObject = a("OidbSvc.0x6be", 1643, 0, ((Oidb_0x6be.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    ((ToServiceMsg)localObject).extraData.putLong("request_start_time", SystemClock.uptimeMillis());
    a((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    cmd0x4f0.ReqBody localReqBody = new cmd0x4f0.ReqBody();
    localReqBody.uint32_req_count.set(paramInt);
    boolean bool = true;
    if (paramArrayOfByte != null)
    {
      localReqBody.bytes_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      bool = false;
    }
    paramArrayOfByte = a("OidbSvc.0x4f0_0", 1264, 0, localReqBody.toByteArray());
    paramArrayOfByte.extraData.putBoolean("is_first_page", bool);
    b(paramArrayOfByte);
  }
  
  public void a(NearbyMyTabCard paramNearbyMyTabCard)
  {
    a(4, true, new Object[] { paramNearbyMyTabCard });
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (!NearbyUtils.c())
    {
      a(1, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, paramObject });
      return;
    }
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("first", false);
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("fromNearby", false);
    int m = paramToServiceMsg.extraData.getByte("neighbor_interest_id", (byte)0).byteValue();
    int i2 = paramToServiceMsg.extraData.getInt("neighbor_list_source");
    if (i2 == 3) {}
    for (int j = 13;; j = 1)
    {
      Object localObject4 = null;
      RespHeader localRespHeader;
      int k;
      label139:
      Object localObject3;
      Object localObject1;
      label185:
      ArrayList localArrayList;
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        localRespHeader = (RespHeader)paramObject[0];
        paramObject = (RespGetEncounterV2)paramObject[1];
        if (localRespHeader != null)
        {
          i = localRespHeader.eReplyCode;
          k = i;
          if ((paramObject == null) || (k != 0)) {
            break label1236;
          }
          NearbySPUtil.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
          localObject3 = new StringBuilder().append("CMD_GET_ENCOUNTER size:");
          if (((RespGetEncounterV2)paramObject).vEncounterInfos != null) {
            break label526;
          }
          localObject1 = null;
          ReportLog.a("LBS", localObject1);
          paramFromServiceMsg.setMsgSuccess();
          localArrayList = ((RespGetEncounterV2)paramObject).vEncounterInfos;
          if (m <= 0) {
            break label541;
          }
          bool1 = true;
          label219:
          paramFromServiceMsg = EncounterHolder.getHolders(localArrayList, bool1);
          localObject1 = new ArrayList(paramFromServiceMsg.size());
          ((List)localObject1).addAll(paramFromServiceMsg);
          localObject3 = EncounterHolder.getEncHolderOpts((List)localObject1);
          if (i2 != 3) {
            break label547;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject4;
          if (localArrayList != null) {
            break label799;
          }
        }
      }
      label526:
      label541:
      label547:
      label575:
      label782:
      label799:
      for (int i = 0;; i = localArrayList.size())
      {
        if ((i > 0) && (bool2))
        {
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (RespEncounterInfo)((Iterator)localObject1).next();
            if ((localObject4 != null) && (((RespEncounterInfo)localObject4).lEctID > 0L) && (String.valueOf(((RespEncounterInfo)localObject4).lEctID).equals(b()))) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a((RespEncounterInfo)localObject4);
            }
          }
        }
        if (i <= 0) {
          break label830;
        }
        localObject1 = new StringBuilder();
        localObject4 = localArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)((Iterator)localObject4).next();
          if (localRespEncounterInfo != null) {
            ((StringBuilder)localObject1).append("[").append(localRespEncounterInfo.tiny_id).append(",").append(localRespEncounterInfo.strNick).append(",").append(localRespEncounterInfo.ruleId).append("]");
          }
        }
        i = paramFromServiceMsg.getResultCode();
        break;
        k = paramFromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
          NearbyUtils.a("handleGetEncounter", new Object[] { Boolean.valueOf(false), Integer.valueOf(k), Boolean.valueOf(bool2), "data is null" });
        }
        paramObject = null;
        localRespHeader = null;
        break label139;
        localObject1 = Integer.valueOf(((RespGetEncounterV2)paramObject).vEncounterInfos.size());
        break label185;
        bool1 = false;
        break label219;
        if (((RespGetEncounterV2)paramObject).stUDLinfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a = ((RespGetEncounterV2)paramObject).stUDLinfo;
        }
        if (((RespGetEncounterV2)paramObject).useInterestTag == 0)
        {
          bool1 = false;
          paramToServiceMsg.extraData.putBoolean("hasEditInterest", bool1);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetEncounter hasEditInterestId:" + bool1);
          }
          localObject4 = (NearbyDataManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(209);
          if (!bool3) {
            break label782;
          }
        }
        for (;;)
        {
          try
          {
            localObject1 = BaseApplicationImpl.getContext().getFileStreamPath(b() + "v5.8.gods");
            if (((RespGetEncounterV2)paramObject).NearRankingsResp.length > 0) {
              paramFromServiceMsg = new cmd0x683.RankListInfo();
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
          {
            paramFromServiceMsg = null;
          }
          try
          {
            paramFromServiceMsg.mergeFrom(((RespGetEncounterV2)paramObject).NearRankingsResp);
            FileUtils.a(((File)localObject1).getAbsolutePath(), ((RespGetEncounterV2)paramObject).NearRankingsResp, false);
            ((NearbyDataManager)localObject4).a(((RespGetEncounterV2)paramObject).alumnus_conf);
            if (bool3)
            {
              localObject1 = ((NearbyDataManager)localObject4).a(bool2, (List)localObject3, ((RespGetEncounterV2)paramObject).ad_list);
              if (bool2) {
                ((NearbyDataManager)localObject4).a((List)localObject1, bool1);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            int n;
            int i1;
            Object localObject2;
            for (;;) {}
          }
          bool1 = true;
          break label575;
          if ((localObject1 != null) && (((File)localObject1).exists())) {
            ((File)localObject1).delete();
          }
          paramFromServiceMsg = null;
          continue;
          localInvalidProtocolBufferMicroException1.printStackTrace();
        }
      }
      NearbyUtils.a("Q.nearby", "handleGetEncounter", new Object[] { localInvalidProtocolBufferMicroException1.toString() });
      label830:
      if (QLog.isColorLevel())
      {
        if (localArrayList == null)
        {
          m = 0;
          label844:
          if (((RespGetEncounterV2)paramObject).ad_list != null) {
            break label1212;
          }
          n = 0;
          label854:
          if (paramFromServiceMsg != null) {
            break label1224;
          }
          i1 = 0;
          label861:
          NearbyUtils.a("handleGetEncounter", new Object[] { Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        }
      }
      else {
        localObject2 = localObject3;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        a(j, bool1, new Object[] { localRespHeader, paramObject, paramFromServiceMsg, paramToServiceMsg, localObject2 });
        if (i2 == 3) {
          break;
        }
        paramFromServiceMsg = new HashMap();
        paramFromServiceMsg.put("param_reason", String.valueOf(k));
        paramFromServiceMsg.put("param_size", String.valueOf(i));
        paramFromServiceMsg.put("param_NetType", NetworkUtil.a(null) + "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(b(), "CMD_GET_ENCOUNTER", bool1, 0L, 0L, paramFromServiceMsg, "");
        bool3 = paramToServiceMsg.extraData.getBoolean("isPreloadData", false);
        if ((!bool2) || (bool3)) {
          break;
        }
        long l1 = paramToServiceMsg.extraData.getLong("lbsTime", 0L);
        long l2 = paramToServiceMsg.extraData.getLong("requestTime", 0L);
        long l3 = System.currentTimeMillis();
        paramFromServiceMsg = new HashMap();
        paramFromServiceMsg.put("param_reason", String.valueOf(k));
        paramFromServiceMsg.put("param_NetType", NetworkUtil.a(null) + "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(b(), "actNearbyFirstDataCost", bool1, l3 - l2, l1, paramFromServiceMsg, "");
        if (!QLog.isColorLevel()) {
          break;
        }
        NearbyUtils.a("handleGetEncounter time:", new Object[] { Long.valueOf(l2) });
        return;
        m = localArrayList.size();
        break label844;
        label1212:
        n = ((RespGetEncounterV2)paramObject).ad_list.size();
        break label854;
        label1224:
        i1 = paramFromServiceMsg.rpt_msg_godinfo.size();
        break label861;
        label1236:
        if (QLog.isColorLevel()) {
          NearbyUtils.a("handleGetEncounter", new Object[] { Boolean.valueOf(false), Integer.valueOf(k) });
        }
        localObject2 = null;
        paramFromServiceMsg = null;
        i = 0;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (a(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label160:
    label277:
    do
    {
      return;
      a(paramFromServiceMsg);
      if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd()))
      {
        String str1;
        if (QLog.isColorLevel())
        {
          String str2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder().append("cmd = ").append(paramFromServiceMsg.getServiceCmd());
          if (paramObject != null)
          {
            str1 = " has data";
            QLog.d(str2, 2, str1);
          }
        }
        else if (paramObject == null)
        {
          if (paramFromServiceMsg.isSuccess()) {
            break label160;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, -111);
        }
        for (;;)
        {
          a(paramFromServiceMsg, paramToServiceMsg, paramObject);
          return;
          str1 = " has no data";
          break;
          if (d != 0) {
            a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, d);
          }
        }
      }
      if ("RoamClientSvr.GetQualify".equals(paramFromServiceMsg.getServiceCmd()))
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        if ((bool) && (paramObject != null))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handleGetRoamQualify isSuccess=").append(bool).append(",data is ");
          if (paramObject == null) {
            break label277;
          }
        }
        for (paramToServiceMsg = "not null";; paramToServiceMsg = "null")
        {
          QLog.d("LBSHandler", 2, paramToServiceMsg);
          a(2, false, null);
          return;
        }
      }
      if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NeighborSvc.ReqSetUserState".equals(paramFromServiceMsg.getServiceCmd()))
      {
        NearbyCmdHelper.b(this, 7, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {}
        for (int i = 5;; i = 6)
        {
          NearbyCmdHelper.a(this, i, paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      }
      if ("OidbSvc.0x9c7_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        NearbyCmdHelper.d(this, 10, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
      {
        NearbyCmdHelper.c(this, 8, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f0_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x6be".equals(paramFromServiceMsg.getServiceCmd()));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getNearbyMyTabCard| uin = " + paramString);
    }
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody1 = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody1.rpt_uint64_uins.set(localArrayList);
    localReqBody1.uint32_req_nick.set(1);
    localReqBody1.uint32_req_stranger_nick.set(1);
    localReqBody1.uint32_req_gender.set(1);
    localReqBody1.uint32_req_god_flag.set(1);
    localReqBody1.uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    paramString = a("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    paramString.extraData.putLong("request_start_time", SystemClock.uptimeMillis());
    a(paramString);
  }
  
  public void a(List paramList, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    int j = 0;
    int k = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reportNearbyListBehavior,dataSize = " + k + ",isCache = " + paramBoolean);
    }
    if (k < 1) {
      return;
    }
    if (k <= 200)
    {
      localObject1 = new cmd0x77f.ReqBody();
      Object localObject2 = ((cmd0x77f.ReqBody)localObject1).uint32_listtype;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject2).set(i);
        ((cmd0x77f.ReqBody)localObject1).uint32_list_ruleid.set(((NearbyReportManager.ReportRecord)paramList.get(0)).b);
        i = j;
        while (i < k)
        {
          localObject2 = a((NearbyReportManager.ReportRecord)paramList.get(i));
          ((cmd0x77f.ReqBody)localObject1).rpt_msg_visit_prof_rec.add((MessageMicro)localObject2);
          i += 1;
        }
      }
      paramList = a("OidbSvc.0x77f_1", 1919, 1, ((cmd0x77f.ReqBody)localObject1).toByteArray());
      paramList.extraData.putBoolean("req_pb_protocol_flag", true);
      a(paramList);
      return;
    }
    Object localObject1 = paramList.subList(0, 200);
    paramList = paramList.subList(200, k);
    a((List)localObject1, paramBoolean);
    a(paramList, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    NearbyCmdHelper.a(this, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("EncounterSvc.ReqGetEncounter");
      this.b.add("RoamClientSvr.GetQualify");
      this.b.add("OidbSvc.0x66b");
      this.b.add("NeighborSvc.ReqSetUserState");
      this.b.add("NeighborSvc.ReqGetPoint");
      this.b.add("OidbSvc.0x9c7_0");
      this.b.add("OidbSvc.0x686");
      this.b.add("OidbSvc.0x4f0_0");
      this.b.add("OidbSvc.0x6be");
    }
    return !this.b.contains(paramString);
  }
  
  public void b(int paramInt)
  {
    NearbyCmdHelper.a(this, paramInt);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetRoamQualify");
    }
    try
    {
      paramToServiceMsg = (Roam.RoamQualifyRsp)new Roam.RoamQualifyRsp().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.head != null))
      {
        a(2, true, paramToServiceMsg.head);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetRoamQualify RoamQualifyRsp.head error");
      }
      a(2, false, null);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetRoamQualify exception msg=" + paramToServiceMsg.getMessage());
      }
      paramToServiceMsg.printStackTrace();
      a(2, false, null);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "handleClearRedTouch| isSuccess = " + paramFromServiceMsg.isSuccess());
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab");
    }
    Object localObject1 = new Oidb_0x66b.RspBody();
    int k = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    label745:
    label801:
    label1274:
    boolean bool2;
    if (k == 0)
    {
      paramFromServiceMsg = new oidb_0x5eb.RspBody();
      paramObject = new NearbyMyTabCard();
      Object localObject2;
      if (((Oidb_0x66b.RspBody)localObject1).bytes_rspbody_5eb.has()) {
        localObject2 = ((Oidb_0x66b.RspBody)localObject1).bytes_rspbody_5eb.get().toByteArray();
      }
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])localObject2);
        if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.size() > 0))
        {
          paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0);
          ((NearbyMyTabCard)paramObject).uin = Long.valueOf(paramFromServiceMsg.uint64_uin.get());
          ((NearbyMyTabCard)paramObject).nickName = paramFromServiceMsg.bytes_stranger_nick.get().toStringUtf8();
          ((NearbyMyTabCard)paramObject).carrier = paramFromServiceMsg.uint32_profession.get();
          ((NearbyMyTabCard)paramObject).gender = paramFromServiceMsg.uint32_gender.get();
          ((NearbyMyTabCard)paramObject).age = paramFromServiceMsg.uint32_age.get();
          ((NearbyMyTabCard)paramObject).godFlag = paramFromServiceMsg.uint32_god_flag.get();
        }
        if (((Oidb_0x66b.RspBody)localObject1).stLikeInfo.has())
        {
          paramFromServiceMsg = (Oidb_0x66b.RspLikeInfo)((Oidb_0x66b.RspBody)localObject1).stLikeInfo.get();
          i = paramFromServiceMsg.uint32_total.get();
          j = paramFromServiceMsg.uint32_new.get();
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
          if ((paramFromServiceMsg == null) || (i > paramFromServiceMsg.likeTotalNum))
          {
            ((NearbyMyTabCard)paramObject).likeTotalNum = i;
            ((NearbyMyTabCard)paramObject).newLikeNum = j;
            this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(0);
          }
        }
        else
        {
          if (((Oidb_0x66b.RspBody)localObject1).stPansocialInfo.has())
          {
            paramFromServiceMsg = (Oidb_0x66b.RspPansocialInfo)((Oidb_0x66b.RspBody)localObject1).stPansocialInfo.get();
            ((NearbyMyTabCard)paramObject).charmValue = paramFromServiceMsg.uint32_charm.get();
            ((NearbyMyTabCard)paramObject).charmLevel = paramFromServiceMsg.uint32_charmlevel.get();
            ((NearbyMyTabCard)paramObject).currentCharm = paramFromServiceMsg.uint32_charmlevelvalue.get();
            ((NearbyMyTabCard)paramObject).nextCharm = paramFromServiceMsg.uint32_nextcharmlevelvalue.get();
          }
          if (((Oidb_0x66b.RspBody)localObject1).bytes_rspbody_gift.has())
          {
            localObject2 = ((Oidb_0x66b.RspBody)localObject1).bytes_rspbody_gift.get().toByteArray();
            paramFromServiceMsg = new flower_info.SFlowerInfoRsp();
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          for (;;)
          {
            paramFromServiceMsg.mergeFrom((byte[])localObject2);
            ((NearbyMyTabCard)paramObject).giftNum = paramFromServiceMsg.num.get();
            if (!((Oidb_0x66b.RspBody)localObject1).stConfigList.has()) {
              break label801;
            }
            localObject2 = ((Oidb_0x66b.RspBody)localObject1).stConfigList.get();
            paramFromServiceMsg = new boolean[2];
            FromServiceMsg tmp420_419 = paramFromServiceMsg;
            tmp420_419[0] = 0;
            FromServiceMsg tmp426_420 = tmp420_419;
            tmp426_420[1] = 0;
            tmp426_420;
            localObject2 = ((List)localObject2).iterator();
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label745;
              }
              localRspConfigItem = (Oidb_0x66b.RspConfigItem)((Iterator)localObject2).next();
              if ((!localRspConfigItem.uint32_id.has()) || (localRspConfigItem.uint32_id.get() != 10001)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.nearby", 2, "handleGetNearbyMyTab|shield date entrance");
              }
            }
            paramFromServiceMsg = paramFromServiceMsg;
            if (QLog.isColorLevel()) {
              QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramFromServiceMsg);
            }
          }
          ((NearbyMyTabCard)paramObject).likeTotalNum = paramFromServiceMsg.likeTotalNum;
          ((NearbyMyTabCard)paramObject).newLikeNum = paramFromServiceMsg.newLikeNum;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            Oidb_0x66b.RspConfigItem localRspConfigItem;
            ((NearbyMyTabCard)paramObject).giftNum = 0;
            if (QLog.isColorLevel())
            {
              QLog.e("NewNearbyMyTab", 2, "fail to decode SFlowerInfoRsp", localInvalidProtocolBufferMicroException);
              continue;
              NearbyMyTabCard.NearbyMyTabConfig localNearbyMyTabConfig = new NearbyMyTabCard.NearbyMyTabConfig();
              localNearbyMyTabConfig.configId = localRspConfigItem.uint32_id.get();
              localNearbyMyTabConfig.strName = localRspConfigItem.str_name.get();
              localNearbyMyTabConfig.strUrl = localRspConfigItem.str_url.get();
              localNearbyMyTabConfig.iconUrl = localRspConfigItem.str_picurl.get();
              localNearbyMyTabConfig.tips = localRspConfigItem.str_tips.get();
              localNearbyMyTabConfig.extraVal = ((NearbyMyTabCard.NearbyMyTabConfigExtraVal)NearbyMineHelper.a.get(Integer.valueOf(localNearbyMyTabConfig.configId)));
              ((NearbyMyTabCard)paramObject).configList.add(localNearbyMyTabConfig);
              if ((localNearbyMyTabConfig.extraVal != null) && (localNearbyMyTabConfig.extraVal.pathId != 0)) {
                if (localNearbyMyTabConfig.extraVal.pathId == 100511) {
                  paramFromServiceMsg[0] = 1;
                } else if (localNearbyMyTabConfig.extraVal.pathId == 100517) {
                  paramFromServiceMsg[1] = 1;
                }
              }
            }
          }
          int j = 0;
          int i = 0;
          boolean bool1;
          while (i < paramFromServiceMsg.length)
          {
            j |= this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(i, paramFromServiceMsg[i]);
            i += 1;
          }
          if (bool1) {
            a(12, true, null);
          }
          if (((Oidb_0x66b.RspBody)localObject1).rpt_msg_vistor_info.has())
          {
            ((NearbyMyTabCard)paramObject).visitors.clear();
            paramFromServiceMsg = ((Oidb_0x66b.RspBody)localObject1).rpt_msg_vistor_info.get().iterator();
            while (paramFromServiceMsg.hasNext())
            {
              localObject1 = (appoint_define.PublisherInfo)paramFromServiceMsg.next();
              if (localObject1 != null)
              {
                localObject1 = StrangerInfo.convertFrom((appoint_define.PublisherInfo)localObject1);
                if (localObject1 != null) {
                  ((NearbyMyTabCard)paramObject).visitors.add(localObject1);
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetNearbyMyTab visitor info is: " + ((NearbyMyTabCard)paramObject).visitors.toString());
            }
          }
          for (;;)
          {
            NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, (NearbyMyTabCard)paramObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a((NearbyMyTabCard)paramObject);
            a(3, true, new Object[] { paramObject });
            if (!QLog.isDevelopLevel()) {
              break label1274;
            }
            paramFromServiceMsg = "";
            i = 0;
            while (i < ((NearbyMyTabCard)paramObject).configList.size())
            {
              paramFromServiceMsg = paramFromServiceMsg + ((NearbyMyTabCard.NearbyMyTabConfig)((NearbyMyTabCard)paramObject).configList.get(i)).configId + ((NearbyMyTabCard.NearbyMyTabConfig)((NearbyMyTabCard)paramObject).configList.get(i)).strName + ((NearbyMyTabCard.NearbyMyTabConfig)((NearbyMyTabCard)paramObject).configList.get(i)).strUrl + "\n";
              i += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetNearbyMyTay has no visitor info.");
            }
          }
          QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab---->uin =" + ((NearbyMyTabCard)paramObject).uin + "nickName = " + ((NearbyMyTabCard)paramObject).nickName + " profression = " + ((NearbyMyTabCard)paramObject).carrier + " gender = " + ((NearbyMyTabCard)paramObject).gender + "age =" + ((NearbyMyTabCard)paramObject).age + " likeTotalNum = " + ((NearbyMyTabCard)paramObject).likeTotalNum + "likeNewNum = " + ((NearbyMyTabCard)paramObject).newLikeNum + "charmVale =" + ((NearbyMyTabCard)paramObject).charmValue + "charmLevel =" + ((NearbyMyTabCard)paramObject).charmLevel + "charmCurrent =" + ((NearbyMyTabCard)paramObject).currentCharm + "charmNext" + ((NearbyMyTabCard)paramObject).nextCharm + " giftNum = " + ((NearbyMyTabCard)paramObject).giftNum + "config = " + paramFromServiceMsg);
        }
      }
      if (k != 0) {
        break label1439;
      }
      bool2 = true;
      label1282:
      paramObject = new HashMap();
      if (!bool2) {
        break label1445;
      }
    }
    label1439:
    label1445:
    for (paramFromServiceMsg = "0";; paramFromServiceMsg = "-1")
    {
      ((HashMap)paramObject).put("param_FailCode", paramFromServiceMsg);
      ((HashMap)paramObject).put("param_NetType", String.valueOf(NetworkUtil.a(BaseApplication.getContext())));
      ((HashMap)paramObject).put("param_DeviceType", String.valueOf(StatisticConstants.a()));
      long l = paramToServiceMsg.extraData.getLong("request_start_time");
      l = SystemClock.uptimeMillis() - l;
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(b(), "actGetNearbyMyTab", bool2, l, 0L, (HashMap)paramObject, "");
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetNearbyMyTab, isSuccess=" + bool2 + ",duration=" + l);
      }
      return;
      a(3, false, null);
      break;
      bool2 = false;
      break label1282;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */