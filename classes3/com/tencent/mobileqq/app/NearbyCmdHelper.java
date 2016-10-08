package com.tencent.mobileqq.app;

import EncounterSvc.ReqGetEncounterV2;
import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.RishState;
import EncounterSvc.UserData;
import NearbyPubAcct.ReqGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetPoint;
import NeighborSvc.ReqSetUserState;
import NeighborSvc.RespGetPoint;
import NeighborSvc.RespSetUserState;
import NeighborSvc.UserDetailLocalInfo;
import QQService.ReqFavorite;
import QQService.ReqHead;
import QQService.RespFavorite;
import QQService.RespHead;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.LocaleInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qba;
import tencent.im.oidb.cmd0x5fb.ReqInfo;
import tencent.im.oidb.cmd0x682.ChatInfo;
import tencent.im.oidb.cmd0x682.ReqBody;
import tencent.im.oidb.cmd0x682.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyCmdHelper
{
  static final int a = 2;
  public static final String a = "session_switch_value";
  private static final int b = 40493;
  public static final String b = "toplist_set_refuse_rank";
  public static final String c = "showlove_chat_sig";
  public static final String d = "NearbyCmdHelper";
  
  public NearbyCmdHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(ToServiceMsg paramToServiceMsg)
  {
    int j = 0;
    int i = j;
    if (paramToServiceMsg != null)
    {
      int k = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      long l = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      i = j;
      if (k != 0)
      {
        i = j;
        if (l != 0L) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  private static NearbyPubAcct.LBSInfo a(NearbyGroup.LBSInfo paramLBSInfo)
  {
    Object localObject1 = null;
    if (paramLBSInfo != null)
    {
      localObject1 = new NearbyPubAcct.GPS(paramLBSInfo.stGps.iLat, paramLBSInfo.stGps.iLon, paramLBSInfo.stGps.iAlt, paramLBSInfo.stGps.eType);
      NearbyPubAcct.Attr localAttr = new NearbyPubAcct.Attr(paramLBSInfo.stAttr.strImei, paramLBSInfo.stAttr.strImsi, paramLBSInfo.stAttr.strPhonenum);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = paramLBSInfo.vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new NearbyPubAcct.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      paramLBSInfo = paramLBSInfo.vCells.iterator();
      while (paramLBSInfo.hasNext())
      {
        localObject3 = (NearbyGroup.Cell)paramLBSInfo.next();
        ((ArrayList)localObject2).add(new NearbyPubAcct.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      localObject1 = new NearbyPubAcct.LBSInfo((NearbyPubAcct.GPS)localObject1, localArrayList, (ArrayList)localObject2, localAttr);
    }
    return (NearbyPubAcct.LBSInfo)localObject1;
  }
  
  public static Object a(AppInterface paramAppInterface, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, BaseProtocolCoder paramBaseProtocolCoder)
  {
    RespHeader localRespHeader = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    UserData localUserData;
    boolean bool;
    int i;
    if (localRespHeader != null)
    {
      ReportLog.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + localRespHeader.eReplyCode);
      localUserData = null;
      bool = false;
      if (localRespHeader == null) {
        break label492;
      }
      i = localRespHeader.eReplyCode;
      if ((i != 0) && (i != 300)) {
        break label420;
      }
      paramFromServiceMsg = (RespGetEncounterV2)a(paramFromServiceMsg.getWupBuffer(), "RespGetEncounterV2", new RespGetEncounterV2());
      if (paramFromServiceMsg == null) {
        break label501;
      }
      localUserData = paramFromServiceMsg.stUserData;
      i = a(paramToServiceMsg);
      if (!(paramBaseProtocolCoder instanceof NearbyProtocolCoder)) {
        break label389;
      }
      ((NearbyProtocolCoder)paramBaseProtocolCoder).a[i] = localUserData;
      label140:
      if (NearbyUtils.b())
      {
        if (localUserData != null) {
          break label411;
        }
        paramAppInterface = "user data is null";
        label154:
        NearbyUtils.a("NearbyCmdHelper", new Object[] { "decodeGetEncounter", Integer.valueOf(i), paramAppInterface });
      }
      if (localUserData != null)
      {
        DatingManager.a(paramToServiceMsg.extraData.getString("account"), localUserData.iLon, localUserData.iLat, localUserData.lTime);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCmdHelper", 2, "respone stUserData.lTime=" + localUserData.lTime + " iLat=" + localUserData.iLat + " iLon" + localUserData.iLon + " lOriginGrid=" + localUserData.lOriginGrid + " lNextGrid=" + localUserData.lNextGrid + " strProvince=" + localUserData.strProvince + " strCookie" + localUserData.strCookie);
        }
      }
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
    for (;;)
    {
      return new Object[] { localRespHeader, paramAppInterface, Boolean.valueOf(bool) };
      ReportLog.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + null);
      break;
      label389:
      if (!(paramBaseProtocolCoder instanceof LBSService)) {
        break label140;
      }
      ((LBSService)paramBaseProtocolCoder).a[i] = localUserData;
      break label140;
      label411:
      paramAppInterface = localUserData.strProvince;
      break label154;
      label420:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyCmdHelper", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + " ReplyCode = " + i + ",strResult=" + localRespHeader.strResult);
      }
      NearbyHandler.a(paramAppInterface, i);
      paramAppInterface = localUserData;
      continue;
      label492:
      NearbyHandler.a(paramAppInterface, 64425);
      return null;
      label501:
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
  }
  
  public static Object a(BaseProtocolCoder paramBaseProtocolCoder, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramBaseProtocolCoder = (RespGetPoint)paramBaseProtocolCoder.a(paramFromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint());
      if (paramBaseProtocolCoder != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), url: " + new String(paramBaseProtocolCoder.stUDLinfo.SOSOUrl) + " , cityId = " + paramBaseProtocolCoder.stUDLinfo.cityId);
        }
        return paramBaseProtocolCoder;
      }
    }
    return null;
  }
  
  public static final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (RuntimeException paramArrayOfByte)
    {
      return (Object)null;
    }
    catch (Exception paramArrayOfByte) {}
    return (Object)null;
  }
  
  public static void a(int paramInt1, Activity paramActivity, NearbyAppInterface paramNearbyAppInterface, RespEncounterInfo paramRespEncounterInfo, int paramInt2)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramNearbyAppInterface == null) || (paramRespEncounterInfo == null)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyCmdHelper", "enter nearby profile", new Object[] { Long.valueOf(paramRespEncounterInfo.lEctID) });
    }
    Object localObject = String.valueOf(paramRespEncounterInfo.lEctID);
    Intent localIntent;
    if (((String)localObject).equals(paramNearbyAppInterface.a()))
    {
      ProfilePerformanceReport.b();
      localIntent = paramActivity.getIntent();
      if ((localIntent == null) || (localIntent.getIntExtra("FROM_WHERE", -1) != 0) || (!localIntent.getBooleanExtra("IS_HAS_REDTOUCH", false))) {
        break label499;
      }
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, 0);
      ((ProfileActivity.AllInOne)localObject).h = paramRespEncounterInfo.strNick;
      ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Int = paramRespEncounterInfo.cAge;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Byte = paramRespEncounterInfo.cSex;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Short = paramRespEncounterInfo.wFace;
      ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Byte = paramRespEncounterInfo.marriage;
      ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_Int = paramRespEncounterInfo.profession_id;
      ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_Byte = paramRespEncounterInfo.constellation;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_ArrayOfByte = paramRespEncounterInfo.richState.vState;
      ((ProfileActivity.AllInOne)localObject).f = paramInt2;
      ((ProfileActivity.AllInOne)localObject).g = paramInt1;
      localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      localIntent.putExtra("param_mode", 2);
      localIntent.putExtra("param_tiny_id", paramRespEncounterInfo.tiny_id);
      localIntent.putExtra("IS_NEARBY_REDDOT_INCOME", bool);
      paramActivity.startActivityForResult(localIntent, 1000);
      ThreadManager.a(new qba(paramNearbyAppInterface), 5, null, false);
      return;
      ProfilePerformanceReport.b();
      paramNearbyAppInterface = new ProfileActivity.AllInOne((String)localObject, 41);
      paramNearbyAppInterface.h = paramRespEncounterInfo.strNick;
      paramNearbyAppInterface.jdField_b_of_type_Int = paramRespEncounterInfo.cAge;
      paramNearbyAppInterface.jdField_a_of_type_Byte = paramRespEncounterInfo.cSex;
      paramNearbyAppInterface.jdField_a_of_type_Short = paramRespEncounterInfo.wFace;
      paramNearbyAppInterface.jdField_b_of_type_Byte = paramRespEncounterInfo.marriage;
      paramNearbyAppInterface.jdField_c_of_type_Int = paramRespEncounterInfo.profession_id;
      paramNearbyAppInterface.jdField_c_of_type_Byte = paramRespEncounterInfo.constellation;
      paramNearbyAppInterface.jdField_a_of_type_ArrayOfByte = paramRespEncounterInfo.richState.vState;
      paramNearbyAppInterface.jdField_b_of_type_JavaLangString = paramRespEncounterInfo.strDescription;
      paramNearbyAppInterface.jdField_b_of_type_ArrayOfByte = paramRespEncounterInfo.sig;
      paramNearbyAppInterface.o = paramRespEncounterInfo.enc_id;
      paramNearbyAppInterface.p = paramRespEncounterInfo.uid;
      paramNearbyAppInterface.f = paramInt2;
      paramNearbyAppInterface.g = paramInt1;
      localObject = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
      ((Intent)localObject).putExtra("AllInOne", paramNearbyAppInterface);
      ((Intent)localObject).putExtra("param_mode", 3);
      ((Intent)localObject).putExtra("param_tiny_id", paramRespEncounterInfo.tiny_id);
      paramActivity.startActivity((Intent)localObject);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      NearbyUtils.a("NearbyCmdHelper", "enter nearby profile", new Object[] { paramNearbyAppInterface.jdField_a_of_type_JavaLangString, Integer.valueOf(paramNearbyAppInterface.jdField_b_of_type_ArrayOfByte.length) });
      return;
      label499:
      bool = false;
    }
  }
  
  private static void a(AppInterface paramAppInterface, int paramInt)
  {
    String str = "";
    if ((paramInt & 0x4) == 4)
    {
      str = "0X8005283";
      paramAppInterface.a("CliOper", "", "", str, str, 0, 0, "", "", "", "");
      DatingUtil.c("getShowLove", new Object[] { "report value ", str });
      str = "";
      if ((paramInt & 0x1) != 1) {
        break label184;
      }
      str = "0X8005288";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramAppInterface.a("CliOper", "", "", str, str, 0, 0, "", "", "", "");
        DatingUtil.c("getShowLove", new Object[] { "report value2 ", str });
      }
      return;
      if ((paramInt & 0x8) == 8)
      {
        str = "0X8005284";
        break;
      }
      if ((paramInt & 0x10) == 16)
      {
        str = "0X8005285";
        break;
      }
      if ((paramInt & 0x20) != 32) {
        break;
      }
      str = "0X8005281";
      break;
      label184:
      if ((paramInt & 0x2) == 2) {
        str = "0X8005289";
      }
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, byte paramByte)
  {
    try
    {
      long l = Long.parseLong(paramBusinessHandler.b());
      Object localObject = new byte[13];
      PkgTools.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 40493);
      PkgTools.a((byte[])localObject, 9, (short)2);
      PkgTools.a((byte[])localObject, 11, (short)paramByte);
      localObject = paramBusinessHandler.a("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("session_switch_value", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      paramBusinessHandler.b((ToServiceMsg)localObject);
      DatingUtil.a("send_oidb_0x4ff_9", new Object[] { Byte.valueOf(paramByte) });
      return;
    }
    catch (Exception paramBusinessHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramBusinessHandler);
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, int paramInt)
  {
    Oidb_0x686.ReqBody localReqBody = new Oidb_0x686.ReqBody();
    Object localObject = LbsUtils.a(paramBusinessHandler.getClass().getSimpleName());
    if (localObject != null) {
      localReqBody.msg_lbs_info.set((MessageMicro)localObject);
    }
    int i = ((Integer)NearbySPUtil.a(paramBusinessHandler.b(), "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    localReqBody.uint32_last_config_seq.set(i);
    i = ((Integer)NearbySPUtil.a(paramBusinessHandler.b(), "key_last_config_time", Integer.valueOf(0))).intValue();
    localReqBody.uint32_last_config_time.set(i);
    i = ((Integer)NearbySPUtil.a(paramBusinessHandler.b(), "sp_nearby_mytab", 0, "key_nearby_push_signin_redtouch", Integer.valueOf(1))).intValue();
    if (i == 1)
    {
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(Integer.valueOf(100524));
      localReqBody.uint32_push_redpoint_id.set((List)localObject);
    }
    paramBusinessHandler.b(paramBusinessHandler.a("OidbSvc.0x686", 1670, paramInt, localReqBody.toByteArray()));
    if (QLog.isColorLevel()) {
      NearbyUtils.a("reqCharmEvent", new Object[] { Integer.valueOf(localReqBody.uint32_last_config_seq.get()), Integer.valueOf(localReqBody.uint32_last_config_time.get()), Integer.valueOf(i) });
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ByteBuffer localByteBuffer = null;
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = (RespGetPoint)paramObject;
      paramObject = paramFromServiceMsg.stUDLinfo;
      if (bool1) {
        if ((paramObject != null) && (((UserDetailLocalInfo)paramObject).SOSOUrl.length > 0)) {
          paramBusinessHandler.a(paramInt, true, ((UserDetailLocalInfo)paramObject).SOSOUrl);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!bool2);
      paramToServiceMsg = localByteBuffer;
      if (((UserDetailLocalInfo)paramObject).cityId != null)
      {
        paramToServiceMsg = localByteBuffer;
        if (((UserDetailLocalInfo)paramObject).cityId.length == 16)
        {
          localByteBuffer = ByteBuffer.wrap(((UserDetailLocalInfo)paramObject).cityId);
          paramToServiceMsg = new String[4];
          paramToServiceMsg[0] = ConditionSearchManager.a(localByteBuffer.getInt());
          paramToServiceMsg[1] = ConditionSearchManager.a(localByteBuffer.getInt());
          paramToServiceMsg[2] = ConditionSearchManager.a(localByteBuffer.getInt());
          paramToServiceMsg[3] = "0";
        }
      }
      paramBusinessHandler.a(paramInt, true, new Object[] { "", ((UserDetailLocalInfo)paramObject).strProvince, ((UserDetailLocalInfo)paramObject).strCity, ((UserDetailLocalInfo)paramObject).strDistrict, ((UserDetailLocalInfo)paramObject).strTown, "", ((UserDetailLocalInfo)paramObject).strRoad, "", Integer.valueOf(paramFromServiceMsg.stGps.iLat), Integer.valueOf(paramFromServiceMsg.stGps.iLon), Integer.valueOf(paramFromServiceMsg.stGps.iAlt), paramToServiceMsg });
      return;
      if (bool1)
      {
        paramBusinessHandler.a(paramInt, false, null);
        return;
      }
    } while (!bool2);
    paramBusinessHandler.a(paramInt, false, null);
  }
  
  public static void a(BusinessHandler paramBusinessHandler, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    if (paramList == null)
    {
      d(paramBusinessHandler, paramInt1, null, null, null);
      return;
    }
    cmd0x9c7.ReqBody localReqBody = new cmd0x9c7.ReqBody();
    localReqBody.uint32_set_mode.set(paramInt2);
    localReqBody.uint32_test_mode.set(paramInt3);
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      InterestTag localInterestTag = (InterestTag)paramList.get(paramInt1);
      if (localInterestTag != null) {
        localReqBody.rpt_msg_tags.add(localInterestTag.a());
      }
      paramInt1 += 1;
    }
    paramList = paramBusinessHandler.a("OidbSvc.0x9c7_0", 2503, 0, localReqBody.toByteArray());
    paramList.extraData.putInt("set_mode", paramInt2);
    paramList.extraData.putInt("test_mode", paramInt3);
    paramBusinessHandler.b(paramList);
  }
  
  public static void a(BusinessHandler paramBusinessHandler, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new cmd0x682.ReqBody();
    ((cmd0x682.ReqBody)localObject).rpt_uint64_touinlist.add(Long.valueOf(paramLong));
    localObject = paramBusinessHandler.a("OidbSvc.0x682", 1666, 0, ((cmd0x682.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putByteArray("showlove_chat_sig", paramArrayOfByte);
    paramBusinessHandler.b((ToServiceMsg)localObject);
    a(paramBusinessHandler.a, paramInt);
    DatingUtil.c("getShowLove", new Object[] { "from type " + paramInt });
  }
  
  public static void a(BusinessHandler paramBusinessHandler, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "setPeopleVisibleSwitch| visible = " + paramBoolean);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBusinessHandler.b(), "NeighborSvc.ReqSetUserState");
    localToServiceMsg.extraData.putBoolean("k_visible_for_near_people", paramBoolean);
    paramBusinessHandler.a(localToServiceMsg);
  }
  
  public static void a(BusinessHandler paramBusinessHandler, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBusinessHandler.b(), "NeighborSvc.ReqGetPoint");
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    if (paramBoolean1) {
      localToServiceMsg.extraData.putBoolean("req_street_view", true);
    }
    for (;;)
    {
      paramBusinessHandler.a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespFavorite)a(paramFromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
  }
  
  public static boolean a(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, BaseProtocolCoder paramBaseProtocolCoder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCmdHelper", 2, "handleGetEncounter start...");
    }
    int i = a(paramToServiceMsg);
    if ((paramBaseProtocolCoder instanceof NearbyProtocolCoder)) {
      paramBaseProtocolCoder = ((NearbyProtocolCoder)paramBaseProtocolCoder).a[i];
    }
    for (;;)
    {
      Object localObject1;
      label53:
      int m;
      int n;
      int j;
      boolean bool1;
      label133:
      boolean bool3;
      NeighborComm.ReqHeader localReqHeader;
      EncounterSvc.ReqUserInfo localReqUserInfo1;
      label297:
      EncounterSvc.ReqUserInfo localReqUserInfo2;
      int k;
      boolean bool2;
      if (NearbyUtils.b())
      {
        if (paramBaseProtocolCoder == null)
        {
          localObject1 = "user data is null";
          NearbyUtils.a("NearbyCmdHelper", new Object[] { "handleGetEncounter", Integer.valueOf(i), localObject1 });
        }
      }
      else
      {
        m = paramToServiceMsg.extraData.getInt("lat");
        n = paramToServiceMsg.extraData.getInt("lon");
        j = paramToServiceMsg.extraData.getInt("roamMode");
        if ((m == 0) || (n == 0)) {
          break label591;
        }
        localObject1 = null;
        bool1 = true;
        if ((localObject1 == null) && (!bool1)) {
          break label1709;
        }
        bool3 = paramToServiceMsg.extraData.getBoolean("first");
        localReqHeader = new NeighborComm.ReqHeader();
        localReqHeader.shVersion = 3;
        localReqHeader.lMID = BaseProtocolCoder.a(Long.parseLong(paramToServiceMsg.getUin()));
        localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
        localReqHeader.eBusiType = 0;
        localReqHeader.eMqqSysType = 2;
        localReqUserInfo1 = new EncounterSvc.ReqUserInfo();
        localReqUserInfo1.strAuthName = "B1_QQ_Neighbor_android";
        localReqUserInfo1.strAuthPassword = "NzVK_qGE";
        localReqUserInfo1.eListType = 0;
        if (!bool1) {
          break label636;
        }
        localReqUserInfo1.vCells = new ArrayList(1);
        localReqUserInfo1.vMacs = new ArrayList(1);
        localReqUserInfo1.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        localReqUserInfo1.stGps = new EncounterSvc.GPS(m, n, 0, 1);
        localReqUserInfo2 = new EncounterSvc.ReqUserInfo();
        i = paramToServiceMsg.extraData.getInt("localLat");
        k = paramToServiceMsg.extraData.getInt("localLon");
        if ((i != 0) && (k != 0))
        {
          localReqUserInfo2.vCells = new ArrayList(1);
          localReqUserInfo2.vMacs = new ArrayList(1);
          localReqUserInfo2.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
          localReqUserInfo2.stGps = new EncounterSvc.GPS(i, k, 0, 1);
        }
        if ((paramBaseProtocolCoder != null) && (!bool3)) {
          break label1844;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("temp==ull:");
          if (paramBaseProtocolCoder != null) {
            break label868;
          }
          bool2 = true;
          label432:
          QLog.i("NearbyCmdHelper", 2, bool2 + " first:" + bool3);
        }
      }
      label591:
      label636:
      label868:
      label1379:
      label1492:
      label1612:
      label1627:
      label1702:
      label1709:
      label1844:
      for (Object localObject2 = new UserData();; localObject2 = paramBaseProtocolCoder)
      {
        k = paramToServiceMsg.extraData.getInt("gender");
        Object localObject5 = paramToServiceMsg.extraData.getLongArray("tags");
        Object localObject4 = null;
        Object localObject3 = localObject4;
        if (localObject5 != null)
        {
          localObject3 = localObject4;
          if (localObject5.length > 0)
          {
            localObject4 = new ArrayList();
            i = 0;
            for (;;)
            {
              localObject3 = localObject4;
              if (i >= localObject5.length) {
                break;
              }
              ((ArrayList)localObject4).add(Long.valueOf(localObject5[i]));
              i += 1;
            }
            if (!(paramBaseProtocolCoder instanceof LBSService)) {
              break label1850;
            }
            paramBaseProtocolCoder = ((LBSService)paramBaseProtocolCoder).a[i];
            break;
            localObject1 = paramBaseProtocolCoder.strProvince;
            break label53;
            l1 = System.currentTimeMillis();
            SosoInterface.a(60000L, "NearbyProtocolCoder.Encounter");
            localObject1 = SosoInterface.a();
            l2 = System.currentTimeMillis();
            paramToServiceMsg.extraData.putLong("lbsTime", l2 - l1);
            bool1 = false;
            break label133;
            localReqUserInfo1.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
            localReqUserInfo1.stGps = new EncounterSvc.GPS((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
            localReqUserInfo1.vSOSOCells = new ArrayList();
            if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
            {
              localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
                localReqUserInfo1.vSOSOCells.add(new SOSO_Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).jdField_b_of_type_Int, ((SosoInterface.SosoCell)localObject3).jdField_c_of_type_Int, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e));
              }
            }
            localReqUserInfo1.vSOSOMac = new ArrayList();
            if (((SosoInterface.SosoLbsInfo)localObject1).b == null) {
              break label297;
            }
            localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
              localReqUserInfo1.vSOSOMac.add(new SOSO_Wifi(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int));
            }
            break label297;
            bool2 = false;
            break label432;
          }
        }
        localObject4 = a(m, n, bool3);
        byte b1 = paramToServiceMsg.extraData.getByte("constellation");
        byte b2 = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
        m = paramToServiceMsg.extraData.getInt("timeInterval");
        byte b3 = paramToServiceMsg.extraData.getByte("ageLow");
        byte b4 = paramToServiceMsg.extraData.getByte("ageUp");
        n = paramToServiceMsg.extraData.getInt("careerID");
        int i1 = paramToServiceMsg.extraData.getInt("hometownCountry");
        int i2 = paramToServiceMsg.extraData.getInt("hometownProvince");
        int i3 = paramToServiceMsg.extraData.getInt("hometownCity");
        localObject5 = paramToServiceMsg.extraData.getString("adExtra");
        long l1 = paramToServiceMsg.extraData.getLong("adCtrl");
        byte b5 = paramToServiceMsg.extraData.getByte("rankListNum");
        int i4 = paramToServiceMsg.extraData.getInt("neighbor_list_source");
        long l2 = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
        if ((QLog.isColorLevel()) && (paramBaseProtocolCoder != null)) {
          QLog.d("NearbyCmdHelper", 2, "request stUserData.lTime=" + paramBaseProtocolCoder.lTime + " iLat=" + paramBaseProtocolCoder.iLat + " iLon" + paramBaseProtocolCoder.iLon + " lOriginGrid=" + paramBaseProtocolCoder.lOriginGrid + " lNextGrid=" + paramBaseProtocolCoder.lNextGrid + " strProvince=" + paramBaseProtocolCoder.strProvince + " strCookie" + paramBaseProtocolCoder.strCookie);
        }
        if (NearbyUtils.b()) {
          NearbyUtils.a("NearbyCmdHelper", "handleGetEncounter interest", new Object[] { Byte.valueOf(b2), Long.valueOf(l2) });
        }
        paramToServiceMsg = (DatingFilters)paramToServiceMsg.extraData.getParcelable("datingFilter");
        paramBaseProtocolCoder = new cmd0x5fb.ReqInfo();
        if (paramToServiceMsg != null)
        {
          paramBaseProtocolCoder.uint32_time.set(paramToServiceMsg.e);
          paramBaseProtocolCoder.uint32_subject.set(paramToServiceMsg.g);
          paramBaseProtocolCoder.uint32_gender.set(paramToServiceMsg.d);
          paramBaseProtocolCoder.uint32_age_low.set(DatingFilters.b[paramToServiceMsg.h]);
          paramBaseProtocolCoder.uint32_age_up.set(DatingFilters.jdField_a_of_type_ArrayOfInt[paramToServiceMsg.h]);
          PBUInt32Field localPBUInt32Field = paramBaseProtocolCoder.uint32_profession;
          if (paramToServiceMsg.i >= 0) {
            break label1612;
          }
          i = 0;
          localPBUInt32Field.set(i);
          paramBaseProtocolCoder.bytes_cookie.set(ByteStringMicro.copyFrom(new byte[0]));
          if ((paramToServiceMsg.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (paramToServiceMsg.g == 5)) {
            paramBaseProtocolCoder.msg_destination.set(paramToServiceMsg.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo);
          }
        }
        if (((Boolean)NearbySPUtil.a(paramAppInterface.getAccount(), "is_nearby_novice", Boolean.valueOf(false))).booleanValue())
        {
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.i("NearbyCmdHelper", 2, "handleGetEncounter isNearbyNovice: " + i);
          }
          if (!bool1) {
            break label1627;
          }
          paramToServiceMsg = new ReqGetEncounterV2(localReqUserInfo1, (UserData)localObject2, k, -1, (ArrayList)localObject3, new byte[1], (byte)j, 2000, -1, 0, null, (byte[])localObject4, 0, (byte)1, b1, b3, b4, m, n, i2, i3, (byte)1, i1, localReqUserInfo2, 15, paramBaseProtocolCoder.toByteArray(), (byte)0, (byte)0, b2, (String)localObject5, l1, 0L, b5, i, i4, l2);
          paramUniPacket.setEncodeName("utf-8");
          paramUniPacket.setServantName("EncounterObj");
          paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
          paramUniPacket.put("ReqHeader", localReqHeader);
          paramUniPacket.put("ReqGetEncounterV2", paramToServiceMsg);
          paramUniPacket = new HashMap();
          if (localObject1 == null) {
            break label1702;
          }
        }
        for (paramToServiceMsg = "lbs is not null";; paramToServiceMsg = "isUseGps is true")
        {
          paramUniPacket.put("param_reason", paramToServiceMsg);
          paramUniPacket.put("param_NetType", NetworkUtil.a(null) + "");
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramAppInterface.a(), "GET_ENCOUNTER_LOCATION", true, 0L, 0L, paramUniPacket, "");
          return true;
          i = paramToServiceMsg.i;
          break;
          i = 0;
          break label1379;
          paramToServiceMsg = new ReqGetEncounterV2(localReqUserInfo1, (UserData)localObject2, k, -1, (ArrayList)localObject3, new byte[1], (byte)0, 2000, -1, 0, null, (byte[])localObject4, 0, (byte)1, b1, b3, b4, m, n, i2, i3, (byte)1, i1, null, 15, paramBaseProtocolCoder.toByteArray(), (byte)0, (byte)0, b2, (String)localObject5, l1, 0L, b5, i, i4, l2);
          break label1492;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCmdHelper", 2, "handleGetEncounter lbsInfo=" + localObject1 + ", isUseGps=" + bool1);
        }
        if (localObject1 == null) {
          paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_reason", "all is null");
        paramToServiceMsg.put("param_NetType", NetworkUtil.a(null) + "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramAppInterface.a(), "GET_ENCOUNTER_LOCATION", false, 0L, 0L, paramToServiceMsg, "");
        return false;
      }
      label1850:
      paramBaseProtocolCoder = null;
    }
  }
  
  public static boolean a(BaseProtocolCoder paramBaseProtocolCoder, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    if (((bool1) && (i != 0) && (j != 0)) || (bool2))
    {
      NeighborSvc.ReqHeader localReqHeader = new NeighborSvc.ReqHeader();
      localReqHeader.shVersion = 2;
      localReqHeader.lMID = BaseProtocolCoder.a(Long.parseLong(paramToServiceMsg.getUin()));
      localReqHeader.iAppID = AppSetting.jdField_a_of_type_Int;
      localReqHeader.eBusiType = 0;
      localReqHeader.eMqqSysType = 2;
      NeighborSvc.ReqUserInfo localReqUserInfo = new NeighborSvc.ReqUserInfo();
      localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
      localReqUserInfo.strAuthPassword = "NzVK_qGE";
      localReqUserInfo.eListType = 0;
      label218:
      byte b1;
      if (bool1)
      {
        localReqUserInfo.vCells = new ArrayList(1);
        localReqUserInfo.vMacs = new ArrayList(1);
        localReqUserInfo.stGps = new NeighborSvc.GPS(i, j, 0, 1);
        localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        if (!bool1) {
          break label640;
        }
        i = 1;
        b1 = (byte)i;
        if (!bool2) {
          break label646;
        }
      }
      label640:
      label646:
      for (i = 1;; i = 0)
      {
        paramBaseProtocolCoder = new ReqGetPoint(localReqUserInfo, b1, (byte)i);
        paramUniPacket.setServantName("NeighborObj");
        paramUniPacket.setFuncName("CMD_GET_POINT");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetPoint", paramBaseProtocolCoder);
        paramToServiceMsg.setTimeout(30000L);
        paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetPoint");
        return true;
        if ((bool2 == true) && (i != 0) && (j != 0))
        {
          localReqUserInfo.vCells = new ArrayList(1);
          localReqUserInfo.vMacs = new ArrayList(1);
          localReqUserInfo.stGps = new NeighborSvc.GPS(i, j, 0, 1);
          break;
        }
        SosoInterface.a(60000L, paramBaseProtocolCoder.getClass().getSimpleName() + ".Point");
        paramBaseProtocolCoder = SosoInterface.a();
        if (paramBaseProtocolCoder == null) {
          return false;
        }
        if (paramBaseProtocolCoder.vWifis != null)
        {
          localReqUserInfo.vMacs = new ArrayList(paramBaseProtocolCoder.vWifis.size());
          i = 0;
          while (i < paramBaseProtocolCoder.vWifis.size())
          {
            localReqUserInfo.vMacs.add(Long.valueOf(((NearbyGroup.Wifi)paramBaseProtocolCoder.vWifis.get(i)).lMac));
            i += 1;
          }
        }
        localReqUserInfo.vMacs = new ArrayList();
        if (paramBaseProtocolCoder.vCells != null)
        {
          localReqUserInfo.vCells = new ArrayList(paramBaseProtocolCoder.vCells.size());
          i = 0;
          while (i < paramBaseProtocolCoder.vCells.size())
          {
            NearbyGroup.Cell localCell = (NearbyGroup.Cell)paramBaseProtocolCoder.vCells.get(i);
            localReqUserInfo.vCells.add(new NeighborSvc.Cell(localCell.shMcc, localCell.shMnc, localCell.iLac, localCell.iCellId));
            i += 1;
          }
        }
        localReqUserInfo.vCells = new ArrayList();
        if (paramBaseProtocolCoder.stGps == null) {
          break;
        }
        paramBaseProtocolCoder = paramBaseProtocolCoder.stGps;
        localReqUserInfo.stGps = new NeighborSvc.GPS(paramBaseProtocolCoder.iLat, paramBaseProtocolCoder.iLon, paramBaseProtocolCoder.iAlt, paramBaseProtocolCoder.eType);
        break;
        i = 0;
        break label218;
      }
    }
    paramBaseProtocolCoder = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    paramBaseProtocolCoder.setMsgFail();
    try
    {
      paramToServiceMsg.actionListener.onActionResult(paramBaseProtocolCoder);
      return false;
    }
    catch (RemoteException paramBaseProtocolCoder)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(PeopleAroundAdapter paramPeopleAroundAdapter, NearbyAppInterface paramNearbyAppInterface, long paramLong, int paramInt)
  {
    boolean bool2;
    if ((paramNearbyAppInterface == null) || (paramLong <= 0L) || (paramPeopleAroundAdapter == null))
    {
      bool2 = false;
      return bool2;
    }
    if ((paramPeopleAroundAdapter != null) && (paramPeopleAroundAdapter.a != null) && (paramPeopleAroundAdapter.a.size() > 0))
    {
      Iterator localIterator = paramPeopleAroundAdapter.a.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          paramPeopleAroundAdapter = null;
          if ((localObject instanceof RespEncounterInfo)) {
            paramPeopleAroundAdapter = (RespEncounterInfo)localObject;
          }
          if ((paramPeopleAroundAdapter != null) && (paramPeopleAroundAdapter.lEctID > 0L) && (paramNearbyAppInterface.a().equals(String.valueOf(paramPeopleAroundAdapter.lEctID)))) {
            if (paramPeopleAroundAdapter.iVoteIncrement != paramInt)
            {
              paramPeopleAroundAdapter.iVoteIncrement = paramInt;
              bool2 = true;
              label137:
              if (paramPeopleAroundAdapter.iVoteNum != paramLong)
              {
                paramPeopleAroundAdapter.iVoteNum = ((int)paramLong);
                bool2 = true;
              }
              bool1 = bool2;
              if (paramLong > paramPeopleAroundAdapter.iVoteNum) {
                paramNearbyAppInterface.b(0);
              }
            }
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      NearbyUtils.a("NearbyFragment", "updateMyVoteInfo", new Object[] { Boolean.valueOf(bool1), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return bool1;
      bool2 = false;
      break label137;
    }
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vCookies");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    localObject = new ReqFavorite(new ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, (byte[])localObject), l2, 0, i, j);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqFavorite");
    paramUniPacket.put("ReqFavorite", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqFavorite");
    return true;
  }
  
  private static byte[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        break label100;
      }
      localObject = new NearbyPubAcct.LBSInfo();
      ((NearbyPubAcct.LBSInfo)localObject).stGps = new NearbyPubAcct.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      localObject = new ReqGetNearbyPubAcctInfo((short)2, new byte[0], 2, (NearbyPubAcct.LBSInfo)localObject);
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setRequestId(1);
      localUniPacket.setServantName("PubAccountSvc.nearby_pubacct");
      localUniPacket.setFuncName("nearby_pubacct");
      localUniPacket.put("nearby_pubacct", localObject);
      localObject = localUniPacket.encode();
      return (byte[])localObject;
      label100:
      localObject = a(SosoInterface.a());
    }
  }
  
  public static Object b(BaseProtocolCoder paramBaseProtocolCoder, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramBaseProtocolCoder = (RespSetUserState)paramBaseProtocolCoder.a(paramFromServiceMsg.getWupBuffer(), "RespSetUserState", new RespSetUserState());
    if (paramBaseProtocolCoder != null) {
      return paramBaseProtocolCoder;
    }
    return null;
  }
  
  public static void b(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("k_visible_for_near_people");
    try
    {
      paramToServiceMsg = (RespHeader)paramBusinessHandler.a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
      if (paramObject != null)
      {
        bool1 = true;
        if (paramToServiceMsg == null) {
          break label192;
        }
        i = paramToServiceMsg.eReplyCode;
        if (!bool1) {
          break label201;
        }
        NearbySPUtil.b(paramBusinessHandler.b(), bool2);
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_reason", String.valueOf(i));
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramBusinessHandler.b(), "CMD_SET_PEOPLE_VISIBLE", bool1, 0L, 0L, paramToServiceMsg, "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "CMD_SET_PEOPLE_VISIBLE| visible:" + bool2 + ",isSuc:" + bool1 + ",replyCode:" + i);
        }
        paramBusinessHandler.a(paramInt, bool1, Boolean.valueOf(bool2));
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
        continue;
        boolean bool1 = false;
        continue;
        label192:
        int i = paramFromServiceMsg.getResultCode();
        continue;
        label201:
        bool2 = NearbySPUtil.b(paramBusinessHandler.b());
      }
    }
  }
  
  public static boolean b(BaseProtocolCoder paramBaseProtocolCoder, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramBaseProtocolCoder = new NeighborSvc.ReqHeader();
    paramBaseProtocolCoder.shVersion = 2;
    paramBaseProtocolCoder.lMID = BaseProtocolCoder.a(Long.parseLong(paramToServiceMsg.getUin()));
    paramBaseProtocolCoder.iAppID = AppSetting.jdField_a_of_type_Int;
    if (paramToServiceMsg.extraData.getBoolean("k_visible_for_near_people")) {}
    for (int i = 1;; i = 0)
    {
      paramBaseProtocolCoder = new ReqSetUserState(paramBaseProtocolCoder, i);
      paramUniPacket.setServantName("NeighborObj");
      paramUniPacket.setFuncName("CMD_SET_USER_STATE");
      paramUniPacket.put("ReqSetUserState", paramBaseProtocolCoder);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("NeighborSvc.ReqSetUserState");
      return true;
    }
  }
  
  public static void c(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          NearbySPUtil.a(paramBusinessHandler.a.getAccount(), "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          NearbySPUtil.a(paramBusinessHandler.a.getAccount(), "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
          if (!(paramBusinessHandler.a instanceof NearbyAppInterface)) {
            break label624;
          }
          ((NearbyAppInterface)paramBusinessHandler.a).a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, (Oidb_0x686.NearbyFeedConfig)paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break label661;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramBusinessHandler.a(paramInt, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          paramBusinessHandler.a.a("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i != 1) {
            break;
          }
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (!localRspBody.msg_notify_event.has()) {
            break;
          }
          localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
          localObject1 = localObject3;
          break;
          label624:
          if ((paramBusinessHandler.a instanceof QQAppInterface)) {
            ((QQAppInterface)paramBusinessHandler.a).a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, (Oidb_0x686.NearbyFeedConfig)paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          }
        }
        label661:
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramBusinessHandler.a(paramInt, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          paramBusinessHandler.a.a("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
        }
      }
      return;
    }
    catch (Exception paramBusinessHandler) {}
  }
  
  public static void d(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      paramBusinessHandler.a(paramInt, false, new Object[] { "", null, "数据错误", Integer.valueOf(-1), Integer.valueOf(-1) });
      return;
    }
    int i;
    int j;
    label69:
    cmd0x9c7.RspBody localRspBody;
    int m;
    if (paramToServiceMsg.extraData == null)
    {
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label224;
      }
      j = -1;
      localRspBody = new cmd0x9c7.RspBody();
      m = BusinessHandler.a(paramFromServiceMsg, paramObject, localRspBody);
      if (m != 0) {
        break label466;
      }
      if (!localRspBody.str_test_result_url.has()) {
        break label239;
      }
      paramToServiceMsg = localRspBody.str_test_result_url.get();
      label113:
      if (!localRspBody.rpt_msg_tags.has()) {
        break label246;
      }
    }
    label224:
    label239:
    label246:
    for (paramFromServiceMsg = localRspBody.rpt_msg_tags.get();; paramFromServiceMsg = null)
    {
      paramObject = new ArrayList();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label251;
      }
      int k = 0;
      while (k < paramFromServiceMsg.size())
      {
        InterestTag localInterestTag = InterestTag.a((appoint_define.InterestTag)paramFromServiceMsg.get(k));
        if (localInterestTag != null) {
          ((List)paramObject).add(localInterestTag);
        }
        k += 1;
      }
      i = paramToServiceMsg.extraData.getInt("set_mode");
      break;
      j = paramToServiceMsg.extraData.getInt("test_mode");
      break label69;
      paramToServiceMsg = "";
      break label113;
    }
    label251:
    if (((List)paramObject).size() <= 0)
    {
      paramBusinessHandler.a(4, false, new Object[] { "", null, "数据错误", Integer.valueOf(i), Integer.valueOf(j) });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), null, paramToServiceMsg });
      return;
    }
    if ((paramBusinessHandler.a instanceof NearbyAppInterface)) {
      ((NearbyAppInterface)paramBusinessHandler.a).a().a(localRspBody);
    }
    for (;;)
    {
      paramBusinessHandler.a(paramInt, true, new Object[] { paramToServiceMsg, paramObject, "", Integer.valueOf(i), Integer.valueOf(j) });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), paramObject, paramToServiceMsg });
      return;
      if (paramBusinessHandler.b != null) {
        paramBusinessHandler.b.a().a(localRspBody);
      }
    }
    label466:
    if (localRspBody.str_error.has()) {}
    for (paramToServiceMsg = localRspBody.str_error.get();; paramToServiceMsg = "")
    {
      paramBusinessHandler.a(paramInt, false, new Object[] { "", null, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
  }
  
  public static void e(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.dating", 2, "handle_oidb_0x4ff_9 ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.a(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(paramBusinessHandler.b())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_9 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = (FromServiceMsg)paramObject;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((paramBusinessHandler.a instanceof QQAppInterface)) {
        if (paramInt == 7)
        {
          paramInt = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
          if (bool1)
          {
            paramToServiceMsg = ((QQAppInterface)paramBusinessHandler.a).a();
            if (paramInt != 0) {
              break label293;
            }
            paramToServiceMsg.a(bool2);
          }
          paramBusinessHandler.a(7, bool1, null);
        }
      }
      label258:
      label293:
      byte b1;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.dating", 2, "handle_oidb_0x4ff_9, isSuccess:" + bool1);
          return;
          bool2 = false;
          break;
          if ((paramBusinessHandler.a instanceof NearbyAppInterface))
          {
            paramObject = (NearbyAppInterface)paramBusinessHandler.a;
            if (paramInt == 10)
            {
              b1 = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
              if (bool1) {
                ((NearbyAppInterface)paramObject).a().a(b1);
              }
              paramBusinessHandler.a(10, bool1, null);
            }
            else if (paramInt == 27)
            {
              paramObject = (DatingManager)((NearbyAppInterface)paramObject).getManager(212);
              if (!TextUtils.isEmpty(paramFromServiceMsg))
              {
                b1 = paramToServiceMsg.extraData.getByte("toplist_set_refuse_rank", (byte)0).byteValue();
                if (bool1) {
                  if (b1 != 1) {
                    break label452;
                  }
                }
              }
            }
          }
        }
      }
      label452:
      for (bool2 = true;; bool2 = false)
      {
        ((DatingManager)paramObject).a(bool2, paramFromServiceMsg);
        paramBusinessHandler.a(27, bool1, new Object[] { Byte.valueOf(b1) });
        break label258;
        break;
      }
      paramFromServiceMsg = null;
      bool1 = true;
      continue;
      paramFromServiceMsg = null;
      bool1 = false;
    }
  }
  
  public static void f(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x682.RspBody localRspBody = new cmd0x682.RspBody();
    int i = BusinessHandler.a(paramFromServiceMsg, paramObject, localRspBody);
    DatingUtil.a("getShowLove", new Object[] { "handleGetShowLoveLimit result = " + i });
    long l;
    int n;
    boolean bool1;
    boolean bool2;
    if ((i == 0) && (localRspBody.rpt_msg_chatinfo.has()) && (localRspBody.rpt_msg_chatinfo.size() > 0))
    {
      paramObject = (cmd0x682.ChatInfo)localRspBody.rpt_msg_chatinfo.get(0);
      l = ((cmd0x682.ChatInfo)paramObject).uint64_touin.get();
      paramInt = ((cmd0x682.ChatInfo)paramObject).uint32_chatflag.get();
      int j = ((cmd0x682.ChatInfo)paramObject).uint32_goldflag.get();
      int k = ((cmd0x682.ChatInfo)paramObject).uint32_totalexpcount.get();
      int m = ((cmd0x682.ChatInfo)paramObject).uint32_curexpcount.get();
      n = ((cmd0x682.ChatInfo)paramObject).uint32_totalFlag.get();
      int i1 = ((cmd0x682.ChatInfo)paramObject).uint32_curdayFlag.get();
      paramFromServiceMsg = ((cmd0x682.ChatInfo)paramObject).express_tips_msg.get().toStringUtf8();
      paramObject = ((cmd0x682.ChatInfo)paramObject).express_msg.get().toStringUtf8();
      bool1 = false;
      boolean bool3 = false;
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("showlove_chat_sig");
      if (((paramInt & 0x2) == 2) || (j == 2)) {
        bool1 = true;
      }
      bool2 = bool3;
      if (j == 1)
      {
        bool2 = bool3;
        if (n == 0)
        {
          bool2 = bool3;
          if (i1 == 0) {
            bool2 = true;
          }
        }
      }
      if ((paramBusinessHandler instanceof DatingHandler))
      {
        paramBusinessHandler.a(23, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
        if (QLog.isColorLevel()) {
          QLog.d("DatingSayHello", 2, "toUin:" + l + ",chatFlag:" + paramInt + ",godFlag:" + j + ",totalCount:" + k + ",curCount" + m + ",totalFlag:" + n + ",curdayFlag:" + i1 + ",canChat:" + bool1 + ",canShowLove:" + bool2 + ",wordStr:" + paramFromServiceMsg + "showloveStr: " + (String)paramObject);
        }
        if (i1 != 1) {
          break label585;
        }
        paramBusinessHandler.a.a("CliOper", "", "", "0X8005290", "0X8005290", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "handleGetShowLoveLimit,result：" + i);
      }
      return;
      if (!(paramBusinessHandler instanceof NearbyCardHandler)) {
        break;
      }
      paramBusinessHandler.a(9, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      break;
      label585:
      if (n == 1)
      {
        paramBusinessHandler.a.a("CliOper", "", "", "0X8005291", "0X8005291", 0, 0, "", "", "", "");
        continue;
        paramBusinessHandler.a(paramInt, false, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyCmdHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */