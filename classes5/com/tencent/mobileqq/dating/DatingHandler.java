package com.tencent.mobileqq.dating;

import EncounterSvc.UserDetailLocalInfo;
import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define.AddressInfo;
import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.LocaleInfo;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.ShopID;
import appoint.define.appoint_define.TravelInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.data.PublishDatingOption.ShopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rdx;
import tencent.im.oidb.cmd0x5f9.cmd0x5f9.ReqBody;
import tencent.im.oidb.cmd0x5f9.cmd0x5f9.RspBody;
import tencent.im.oidb.cmd0x5fa.ReqBody;
import tencent.im.oidb.cmd0x5fa.RspBody;
import tencent.im.oidb.cmd0x5fc.ReqBody;
import tencent.im.oidb.cmd0x5fc.RspBody;
import tencent.im.oidb.cmd0x5fd.ReqBody;
import tencent.im.oidb.cmd0x5fd.RspBody;
import tencent.im.oidb.cmd0x5fe.ReqBody;
import tencent.im.oidb.cmd0x5fe.RspBody;
import tencent.im.oidb.cmd0x5ff.ReqBody;
import tencent.im.oidb.cmd0x5ff.RspBody;
import tencent.im.oidb.cmd0x683.cmd0x683.GodInfo;
import tencent.im.oidb.cmd0x683.cmd0x683.Location;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListReq;
import tencent.im.oidb.cmd0x683.cmd0x683.ReqBody;
import tencent.im.oidb.cmd0x683.cmd0x683.RspBody;
import tencent.im.oidb.cmd0x7ca.ReqBody;
import tencent.im.oidb.cmd0x7ca.RspBody;
import tencent.im.oidb.cmd0x7cb.DateRequest;
import tencent.im.oidb.cmd0x7cb.ReqBody;
import tencent.im.oidb.cmd0x7cb.RspBody;
import tencent.im.oidb.cmd0x7cd.ReqBody;
import tencent.im.oidb.cmd0x7cd.RspBody;
import tencent.im.oidb.cmd0x7ce.AppintDetail;
import tencent.im.oidb.cmd0x7ce.ReqBody;
import tencent.im.oidb.cmd0x7ce.RspBody;
import tencent.im.oidb.cmd0x7cf.ReqBody;
import tencent.im.oidb.cmd0x7cf.RspBody;
import tencent.im.oidb.cmd0x7da.ReqBody;
import tencent.im.oidb.cmd0x7da.RspBody;
import tencent.im.oidb.cmd0x7db.ReqBody;
import tencent.im.oidb.cmd0x7db.RspBody;
import tencent.im.oidb.cmd0x7dc.ReqBody;
import tencent.im.oidb.cmd0x7dc.RspBody;
import tencent.im.oidb.cmd0x7de.BusiReqHead;
import tencent.im.oidb.cmd0x7de.BusiRespHead;
import tencent.im.oidb.cmd0x7de.ReqBody;
import tencent.im.oidb.cmd0x7de.RspBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.ReqBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.RspBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DatingHandler
  extends BusinessHandler
{
  private static String A = "list_type";
  private static String B = "time_stamp";
  private static String C = "last_tiny_id";
  private static String D = "fetch_account";
  private static String E = "specified_tiny_id";
  private static String F = "is_need_jump_to_self_pos";
  private static final int jdField_a_of_type_Int = 41804;
  public static final String a = "appoint_id";
  private static final int b = 1;
  public static final String b = "appoint_ids";
  private static final int c = 2;
  public static final String c = "appoint_action";
  public static final String d = "open_id";
  public static final String e = "filter_time";
  public static final String f = "filter_subject";
  public static final String g = "filter_gender";
  public static final String h = "filter_lowage";
  public static final String i = "filter_upage";
  public static final String j = "filter_profession";
  public static final String k = "public_subject";
  public static final String l = "public_type";
  public static final String m = "public_time";
  public static final String n = "public_gender";
  public static final String o = "public_introduce";
  public static final String p = "public_zone";
  public static final String q = "public_addr_name";
  public static final String r = "public_addr";
  public static final String s = "public_shop_pic_url";
  public static final String t = "public_shop_url";
  public static final String u = "download_type";
  public static final String v = "refer_idx";
  public static final String w = "date_comment_id";
  public static final String x = "last_from";
  public static final String y = "toplist_set_refuse_rank";
  public static final String z = "toplist_rank";
  private long jdField_a_of_type_Long;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DatingHandler(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, boolean paramBoolean, UserDetailLocalInfo paramUserDetailLocalInfo, appoint_define.LBSInfo paramLBSInfo)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long > 0L) && (l1 - this.jdField_a_of_type_Long < 30000L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "DatingHandler requestRankList. smaller than 30s timemout time. waiting for the last resp.");
      }
      return;
    }
    this.jdField_a_of_type_Long = l1;
    if ((paramLong2 > 0L) || (paramBoolean)) {
      paramInt3 = 50;
    }
    if (QLog.isColorLevel()) {
      QLog.i("toplist_rank", 2, "DatingHandler requestRankList type = " + paramInt1 + " | timeStamp = " + paramInt2 + " | lastTinyId = " + paramLong1 + " |  fetchAccount = " + paramInt3 + " | specifiedTinyID = " + paramLong2 + " | isNeedJumpToSelfPos = " + paramBoolean);
    }
    cmd0x683.RankListReq localRankListReq = new cmd0x683.RankListReq();
    localRankListReq.uint32_listtype.set(paramInt1);
    localRankListReq.uint32_lasttime.set(paramInt2);
    localRankListReq.uint64_lasttinyid.set(paramLong1);
    localRankListReq.uint32_fetchcount.set(paramInt3);
    cmd0x683.ReqBody localReqBody = new cmd0x683.ReqBody();
    cmd0x683.Location localLocation = new cmd0x683.Location();
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("DatingHandler requestRankList udlInfo = ");
      if (paramUserDetailLocalInfo == null)
      {
        str = "null";
        QLog.i("toplist_rank", 2, str);
      }
    }
    else
    {
      if (paramUserDetailLocalInfo == null) {
        break label422;
      }
      localLocation.strProvince.set(paramUserDetailLocalInfo.strProvince);
      localLocation.strCity.set(paramUserDetailLocalInfo.strCity);
    }
    for (;;)
    {
      localReqBody.msg_location.set(localLocation);
      localReqBody.rpt_msg_ranklist_req.add(localRankListReq);
      paramUserDetailLocalInfo = a("OidbSvc.0x683_0", 1667, 0, localReqBody.toByteArray());
      paramUserDetailLocalInfo.extraData.putInt(A, paramInt1);
      paramUserDetailLocalInfo.extraData.putInt(B, paramInt2);
      paramUserDetailLocalInfo.extraData.putLong(C, paramLong1);
      paramUserDetailLocalInfo.extraData.putInt(D, paramInt3);
      paramUserDetailLocalInfo.extraData.putLong(E, paramLong2);
      paramUserDetailLocalInfo.extraData.putBoolean(F, paramBoolean);
      paramUserDetailLocalInfo.setTimeout(30000L);
      b(paramUserDetailLocalInfo);
      return;
      str = paramUserDetailLocalInfo.strCity;
      break;
      label422:
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "DatingHandler requestRankList udlInfo gps.lat = " + paramLBSInfo.msg_gps.int32_lat.get() + " | lon = " + paramLBSInfo.msg_gps.int32_lon.get() + " | type = " + paramLBSInfo.msg_gps.int32_type.get());
      }
      localLocation.msg_lbs_info.set(paramLBSInfo);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("appoint_id");
    int i2 = paramToServiceMsg.extraData.getInt("refer_idx");
    int i3 = paramToServiceMsg.extraData.getInt("appoint_action");
    cmd0x5fa.RspBody localRspBody = new cmd0x5fa.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool = false;
    paramFromServiceMsg = null;
    paramObject = null;
    paramToServiceMsg = null;
    int i4;
    int i5;
    if (i1 == 0)
    {
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if (paramToServiceMsg != null) {
        break label371;
      }
      paramToServiceMsg = null;
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      if (localRspBody.rpt_msg_stranger_info.has())
      {
        List localList = localRspBody.rpt_msg_stranger_info.get();
        paramFromServiceMsg = (FromServiceMsg)paramObject;
        if (localList != null)
        {
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          if (!localList.isEmpty()) {
            paramFromServiceMsg = DatingStranger.a(localList);
          }
        }
      }
      i4 = localRspBody.uint32_reach_start.get();
      i5 = localRspBody.uint32_reach_end.get();
      if (paramToServiceMsg != null)
      {
        if (!paramBoolean) {
          break label387;
        }
        i1 = 0;
        label174:
        if (i2 != -1) {
          break label405;
        }
        paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, true);
        if (i4 == 0) {
          break label393;
        }
        bool = true;
        label197:
        paramToServiceMsg.setReachOver(i1, true, bool);
        if (i5 == 0) {
          break label399;
        }
      }
    }
    label371:
    label387:
    label393:
    label399:
    for (bool = true;; bool = false)
    {
      paramToServiceMsg.setReachOver(i1, false, bool);
      if (QLog.isColorLevel()) {
        QLog.e("Q.dating.detail", 2, "handle getStranger is visitor :" + paramBoolean + " over is: " + i4 + " " + i5);
      }
      bool = true;
      a(16, bool, new Object[] { Boolean.valueOf(paramBoolean), str, Integer.valueOf(i3), Integer.valueOf(i2), paramToServiceMsg });
      DatingUtil.a("handleGetDatingStrangers", new Object[] { Boolean.valueOf(paramBoolean), str, Integer.valueOf(i3), Integer.valueOf(i2), paramFromServiceMsg });
      return;
      paramToServiceMsg = paramToServiceMsg.a().a(str, true, true, true);
      break;
      i1 = 2;
      break label174;
      bool = false;
      break label197;
    }
    label405:
    if (i3 == 1)
    {
      paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, false);
      if (i4 != 0) {}
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, true, bool);
        break;
      }
    }
    if (i3 == 2)
    {
      paramToServiceMsg.addStranger(paramBoolean, false, paramFromServiceMsg, false);
      if (i5 != 0) {}
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, false, bool);
        break;
      }
    }
    if (paramBoolean)
    {
      paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, true);
      if (i4 != 0)
      {
        bool = true;
        label509:
        paramToServiceMsg.setReachOver(i1, true, bool);
        if (i5 == 0) {
          break label544;
        }
      }
      label544:
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, false, bool);
        break;
        bool = false;
        break label509;
      }
    }
    if ((!paramToServiceMsg.isGetList) && (paramToServiceMsg.isInit) && (paramToServiceMsg.isCanMerge(i1, false, paramFromServiceMsg)))
    {
      paramToServiceMsg.addStranger(paramBoolean, false, paramFromServiceMsg, false);
      if (i5 != 0) {}
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.setReachOver(i1, false, bool);
        paramToServiceMsg.isGetList = true;
        break;
      }
    }
    paramToServiceMsg.addStranger(paramBoolean, true, paramFromServiceMsg, true);
    if (i4 != 0)
    {
      bool = true;
      label632:
      paramToServiceMsg.setReachOver(i1, true, bool);
      if (i5 == 0) {
        break label667;
      }
    }
    label667:
    for (bool = true;; bool = false)
    {
      paramToServiceMsg.setReachOver(i1, false, bool);
      break;
      bool = false;
      break label632;
    }
  }
  
  private void b(int paramInt)
  {
    String str = "";
    if ((paramInt & 0x4) == 4)
    {
      str = "0X8005283";
      DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, str);
      DatingUtil.c("getShowLove", new Object[] { "report value ", str });
      str = "";
      if ((paramInt & 0x1) != 1) {
        break label142;
      }
      str = "0X8005288";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, str);
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
      label142:
      if ((paramInt & 0x2) == 2) {
        str = "0X8005289";
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    Object localObject = new cmd0x7ce.RspBody();
    int i5 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = null;
    paramFromServiceMsg = (FromServiceMsg)paramObject;
    boolean bool2;
    if (i5 == 0)
    {
      bool2 = true;
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      bool1 = bool2;
      if (((cmd0x7ce.RspBody)localObject).rpt_msg_appoints_info.has())
      {
        paramFromServiceMsg = ((cmd0x7ce.RspBody)localObject).rpt_msg_appoints_info.get();
        bool1 = bool2;
      }
    }
    paramObject = paramToServiceMsg.extraData.getString("appoint_id");
    paramToServiceMsg.extraData.getInt("last_from");
    cmd0x7ce.AppintDetail localAppintDetail = DatingUtil.a(paramFromServiceMsg, (String)paramObject);
    int i2 = 0;
    localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    int i1 = i2;
    if (localAppintDetail != null)
    {
      i1 = i2;
      if (localAppintDetail.uint32_limited.has()) {
        i1 = localAppintDetail.uint32_limited.get();
      }
    }
    label269:
    label359:
    int i3;
    label380:
    int i4;
    if (localObject == null)
    {
      paramToServiceMsg = null;
      if ((!bool1) || (localAppintDetail == null) || (paramToServiceMsg == null)) {
        break label687;
      }
      paramFromServiceMsg = paramToServiceMsg.a(DatingUtil.a(localAppintDetail), true, true, true);
      DatingUtil.a(paramFromServiceMsg, localAppintDetail);
      paramToServiceMsg.a(paramFromServiceMsg, 3);
      if (paramFromServiceMsg != null)
      {
        if (localAppintDetail.rpt_msg_stranger_info.has()) {
          DatingStranger.a(localAppintDetail.rpt_msg_stranger_info.get());
        }
        paramToServiceMsg = null;
        if (localAppintDetail.rpt_msg_vistor_info.has()) {
          paramToServiceMsg = DatingStranger.a(localAppintDetail.rpt_msg_vistor_info.get());
        }
        paramFromServiceMsg.addStranger(true, true, paramToServiceMsg, true);
        paramFromServiceMsg.setReachOver(0, true, true);
        if (localAppintDetail.uint32_view_over.get() == 0) {
          break label548;
        }
        bool2 = true;
        paramFromServiceMsg.setReachOver(0, false, bool2);
        if (localAppintDetail.rpt_msg_comment_list.has()) {
          DatingComment.a(localAppintDetail.rpt_msg_comment_list.get());
        }
        paramFromServiceMsg.isInit = true;
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = System.currentTimeMillis();
        }
        paramFromServiceMsg.lastUpdateTime = l1;
      }
      if (QLog.isColorLevel())
      {
        if (!localAppintDetail.uint32_view_over.has()) {
          break label554;
        }
        i2 = localAppintDetail.uint32_view_over.get();
        if (!localAppintDetail.uint32_comment_over.has()) {
          break label560;
        }
        i3 = localAppintDetail.uint32_comment_over.get();
        if (!localAppintDetail.uint32_join_over.has()) {
          break label566;
        }
        i4 = localAppintDetail.uint32_join_over.get();
        label401:
        QLog.i("Q.dating.detail", 2, "handle_oidb_0x7ce_0 limit is: " + i1 + " over is: " + i2 + " " + i3 + " " + i4);
      }
    }
    label548:
    label554:
    label560:
    label566:
    label684:
    label687:
    for (paramToServiceMsg = paramFromServiceMsg;; paramToServiceMsg = null)
    {
      if (i1 != 0) {}
      for (;;)
      {
        a(4, bool1, new Object[] { paramObject, paramToServiceMsg, Integer.valueOf(i1) });
        DatingUtil.a("handle_oidb_0x7ce_0", new Object[] { Integer.valueOf(i5), Boolean.valueOf(bool1), paramObject, paramToServiceMsg, Integer.valueOf(i1) });
        return;
        paramToServiceMsg = ((DatingManager)localObject).a();
        break;
        bool2 = false;
        break label269;
        i2 = -1;
        break label359;
        i3 = -1;
        break label380;
        i4 = -1;
        break label401;
        if (paramToServiceMsg == null)
        {
          if ((localObject != null) && (((DatingManager)localObject).a().a(1, (String)paramObject).booleanValue())) {
            i1 = 2;
          } else if ((localObject != null) && (((DatingManager)localObject).a().a(2, (String)paramObject).booleanValue())) {
            i1 = 2;
          }
        }
        else
        {
          if ((paramToServiceMsg != null) && (paramToServiceMsg.owner == 1)) {}
          for (i2 = 1;; i2 = 2)
          {
            if ((localObject == null) || (!((DatingManager)localObject).a().a(i2, (String)paramObject).booleanValue())) {
              break label684;
            }
            i1 = 2;
            paramToServiceMsg.nLimit = 2;
            break;
          }
        }
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    cmd0x5f9.RspBody localRspBody = new cmd0x5f9.RspBody();
    if (a(paramFromServiceMsg, paramObject, localRspBody) == 0) {
      if (localRspBody.rpt_msg_district == null) {
        break label174;
      }
    }
    label174:
    for (paramToServiceMsg = localRspBody.rpt_msg_district.get();; paramToServiceMsg = null)
    {
      if (localRspBody.rpt_msg_poi != null) {}
      for (paramFromServiceMsg = localRspBody.rpt_msg_poi.get();; paramFromServiceMsg = null)
      {
        paramObject = localObject1;
        if (localRspBody.bytes_cookie != null) {
          paramObject = localRspBody.bytes_cookie.get();
        }
        boolean bool1;
        boolean bool2;
        if (localRspBody.uint32_ended != null) {
          if (localRspBody.uint32_ended.get() == 1)
          {
            bool1 = true;
            bool2 = true;
          }
        }
        for (;;)
        {
          a(21, bool2, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject, Boolean.valueOf(bool1) });
          return;
          bool1 = false;
          break;
          bool1 = false;
          paramFromServiceMsg = null;
          paramToServiceMsg = null;
          bool2 = false;
          paramObject = localObject2;
          continue;
          bool1 = false;
          bool2 = true;
        }
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    Object localObject1 = new cmd0x683.RspBody();
    int i2 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("toplist_rank", 2, "DatingHandle handleGetRankListResp result = " + i2);
    }
    this.jdField_a_of_type_Long = 0L;
    long l1;
    long l2;
    boolean bool2;
    int i4;
    label195:
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object[] arrayOfObject;
    boolean bool1;
    label319:
    label335:
    int i5;
    if (i2 == 0)
    {
      if (!((cmd0x683.RspBody)localObject1).rpt_msg_ranklist_info.has()) {
        break label1136;
      }
      l1 = paramToServiceMsg.extraData.getLong(C);
      l2 = paramToServiceMsg.extraData.getLong(E);
      bool2 = paramToServiceMsg.extraData.getBoolean(F);
      i4 = paramToServiceMsg.extraData.getInt(A);
      paramFromServiceMsg = ((cmd0x683.RspBody)localObject1).rpt_msg_ranklist_info.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0))
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder().append("DatingHandle handleGetRankListResp list size = ");
          if (paramFromServiceMsg != null) {
            break label195;
          }
        }
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.size()))
        {
          QLog.i("toplist_rank", 2, paramToServiceMsg);
          a(26, false, null);
          return;
        }
      }
      paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      localArrayList1 = new ArrayList(paramFromServiceMsg.size());
      localArrayList2 = new ArrayList(paramFromServiceMsg.size());
      arrayOfObject = new Object[6];
      arrayOfObject[0] = localArrayList1;
      arrayOfObject[1] = localArrayList2;
      arrayOfObject[2] = Long.valueOf(l1);
      arrayOfObject[3] = Boolean.valueOf(true);
      arrayOfObject[4] = Integer.valueOf(-1);
      arrayOfObject[5] = Boolean.valueOf(false);
      if (((cmd0x683.RspBody)localObject1).uint32_refuse_rank.get() == 1)
      {
        bool1 = true;
        ((DatingManager)paramObject).a(bool1, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
        i1 = 0;
        if (i1 >= paramFromServiceMsg.size()) {
          break label1119;
        }
        localObject1 = (cmd0x683.RankListInfo)paramFromServiceMsg.get(i1);
        if (!((cmd0x683.RankListInfo)localObject1).uint32_listtype.has()) {
          break label491;
        }
        i5 = ((cmd0x683.RankListInfo)localObject1).uint32_listtype.get();
        paramToServiceMsg = ((DatingManager)paramObject).a(i5);
        if (paramToServiceMsg != null) {
          break label1154;
        }
        paramToServiceMsg = new GodListConfig();
        paramToServiceMsg.listType = i5;
      }
    }
    label491:
    label754:
    label1093:
    label1119:
    label1136:
    label1154:
    for (;;)
    {
      localArrayList1.add(i1, paramToServiceMsg);
      if (((cmd0x683.RankListInfo)localObject1).uint32_listtime.has()) {}
      for (i2 = ((cmd0x683.RankListInfo)localObject1).uint32_listtime.get();; i2 = 0)
      {
        if ((i2 != paramToServiceMsg.lastTime) && (l1 != 0L))
        {
          arrayOfObject[5] = Boolean.valueOf(true);
          a(26, true, arrayOfObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("toplist_rank", 2, "DatingHandle handleGetRankListResp list changed, need back top to pull down list to fresh.");
          return;
          bool1 = false;
          break label319;
          if (QLog.isColorLevel()) {
            QLog.i("toplist_rank", 2, "parse rank list fail: no listType");
          }
          i1 += 1;
          break label335;
        }
        if (((cmd0x683.RankListInfo)localObject1).uint32_imgod_flag.has())
        {
          if (((cmd0x683.RankListInfo)localObject1).uint32_imgod_flag.get() == 1)
          {
            bool1 = true;
            paramToServiceMsg.insideRank = bool1;
          }
        }
        else if (((cmd0x683.RankListInfo)localObject1).uint32_reach_end_flag.has()) {
          if (((cmd0x683.RankListInfo)localObject1).uint32_reach_end_flag.get() == 1) {
            break label754;
          }
        }
        Object localObject2;
        Object localObject3;
        GodEntity localGodEntity;
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg.hasMore = bool1;
          paramToServiceMsg.lastTime = i2;
          if (!((cmd0x683.RankListInfo)localObject1).rpt_msg_godinfo.has()) {
            break label1093;
          }
          localObject2 = ((cmd0x683.RankListInfo)localObject1).rpt_msg_godinfo.get();
          localObject1 = new ArrayList(((List)localObject2).size());
          if (QLog.isColorLevel()) {
            QLog.i("toplist_rank", 2, "DatingHandler handleGetRankListResp godInfos size = " + ((List)localObject2).size() + ", requstTinyId = " + l1 + ", cfg.lastUpdateTime = " + paramToServiceMsg.lastUpdateTime);
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (cmd0x683.GodInfo)((Iterator)localObject2).next();
            localGodEntity = new GodEntity();
            localGodEntity.init((cmd0x683.GodInfo)localObject3, paramToServiceMsg.listType);
            ((List)localObject1).add(localGodEntity);
          }
          bool1 = false;
          break;
        }
        ((DatingManager)paramObject).a((List)localObject1, paramToServiceMsg.listType, l1);
        paramToServiceMsg.lastTinyId = ((GodEntity)((List)localObject1).get(((List)localObject1).size() - 1)).tinyId;
        localArrayList2.add(i1, localObject1);
        int i3;
        if ((i4 == paramToServiceMsg.listType) && ((l2 > 0L) || (bool2)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localGodEntity = (GodEntity)((Iterator)localObject3).next();
            if ((l2 == localGodEntity.tinyId) || ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(localGodEntity.uin))))
            {
              i3 = ((List)localObject1).indexOf(localGodEntity);
              arrayOfObject[4] = Integer.valueOf(i3);
            }
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("toplist_rank", 2, "DatingHandler handleGetRankListResp specifiedPos = " + i3);
          }
          if ((i3 < 0) && (paramToServiceMsg.hasMore)) {
            a(paramToServiceMsg.listType, paramToServiceMsg.lastTime, paramToServiceMsg.lastTinyId, paramToServiceMsg.fetchAccount, l2, bool2);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("toplist_rank", 2, "DatingHandler handleGetRankListResp listType = " + i5 + ", lastTime = " + i2 + ", insideRank = " + paramToServiceMsg.insideRank + ", hasMore = " + paramToServiceMsg.hasMore);
            }
            if (l1 == 0L) {
              paramToServiceMsg.lastUpdateTime = System.currentTimeMillis();
            }
            ((DatingManager)paramObject).a(paramToServiceMsg);
            a(26, true, arrayOfObject);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("toplist_rank", 2, "DatingHandler handleGetRankListResp listInfo.rpt_msg_godinfo.has() false");
            }
            ((DatingManager)paramObject).a(paramToServiceMsg.listType);
          }
          for (i1 = 1; i1 == 0; i1 = 0)
          {
            a(26, false, null);
            return;
          }
          break;
          i3 = -1;
        }
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new cmd0x7da.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (i1 == 0)
    {
      bool = true;
      if (!((cmd0x7da.RspBody)localObject1).rpt_msg_appoint_info.has()) {
        break label347;
      }
      paramFromServiceMsg = ((cmd0x7da.RspBody)localObject1).rpt_msg_appoint_info.get();
      paramObject = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("appoint_ids");
      localObject1 = null;
      DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      paramToServiceMsg = (ToServiceMsg)localObject1;
      if (localDatingManager != null)
      {
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (paramFromServiceMsg != null)
        {
          paramToServiceMsg = (ToServiceMsg)localObject1;
          if (paramFromServiceMsg.size() > 0)
          {
            paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
            localObject1 = paramFromServiceMsg.iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (appoint_define.AppointInfo)((Iterator)localObject1).next();
                localObject2 = localDatingManager.a().a((appoint_define.AppointInfo)localObject2);
                if (localObject2 != null)
                {
                  paramToServiceMsg.add(localObject2);
                  continue;
                  if (!((cmd0x7da.RspBody)localObject1).str_wording.has()) {
                    break label347;
                  }
                  paramObject = ((cmd0x7da.RspBody)localObject1).str_wording.get();
                  bool = false;
                  paramFromServiceMsg = null;
                  break;
                }
              }
            }
          }
        }
      }
      if ((i2 == 0) && (bool) && (localDatingManager != null))
      {
        localObject1 = localDatingManager.c();
        if ((localArrayList != null) && (localArrayList.contains(localObject1))) {
          localDatingManager.b(null);
        }
      }
      a(6, bool, new Object[] { Integer.valueOf(i2), localArrayList, paramToServiceMsg, paramObject });
      DatingUtil.a("handle_0x7da_0", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), localArrayList, paramFromServiceMsg, paramObject });
      return;
      label347:
      paramObject = null;
      paramFromServiceMsg = null;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7da.RspBody localRspBody = new cmd0x7da.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      paramFromServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("appoint_ids");
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a(1, false, paramToServiceMsg, bool);
      a(12, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_0x7da_1", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        paramFromServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7da.RspBody localRspBody = new cmd0x7da.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      paramFromServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("appoint_ids");
      paramObject = new ArrayList();
      ((ArrayList)paramObject).add(paramToServiceMsg);
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a(1, true, (ArrayList)paramObject, bool);
      a(13, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_0x7da_2", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        paramFromServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    cmd0x7db.RspBody localRspBody = new cmd0x7db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    Object localObject3 = null;
    paramObject = null;
    paramFromServiceMsg = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    int i2;
    if (i1 == 0)
    {
      bool2 = true;
      paramObject = paramFromServiceMsg;
      if (localRspBody.msg_appoint_info.has()) {
        paramObject = (appoint_define.AppointInfo)localRspBody.msg_appoint_info.get();
      }
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      localObject1 = localObject4;
      localObject2 = localObject3;
      bool1 = bool2;
      if (localRspBody.bytes_SigC2C.has())
      {
        paramFromServiceMsg = (FromServiceMsg)paramObject;
        localObject1 = localObject4;
        localObject2 = localObject3;
        bool1 = bool2;
        if (localRspBody.bytes_SigC2C.get() != null)
        {
          localObject1 = localRspBody.bytes_SigC2C.get().toByteArray();
          bool1 = bool2;
          localObject2 = localObject3;
          paramFromServiceMsg = (FromServiceMsg)paramObject;
        }
      }
      i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramObject = paramToServiceMsg.extraData.getString("appoint_id");
      if (paramFromServiceMsg == null) {
        break label418;
      }
      paramToServiceMsg = DatingUtil.a(paramFromServiceMsg);
      if (Utils.a(paramToServiceMsg, paramObject)) {
        break label418;
      }
      DatingUtil.a("handle_oidb_0x7db_0", new Object[] { paramObject, paramToServiceMsg });
    }
    label231:
    label418:
    for (paramToServiceMsg = null;; paramToServiceMsg = paramFromServiceMsg)
    {
      paramFromServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if ((bool1) && (paramFromServiceMsg != null)) {
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = paramFromServiceMsg.a().a(paramToServiceMsg);
          if ((localObject1 != null) && (paramToServiceMsg != null)) {
            paramToServiceMsg.detailSigC2C = ((byte[])localObject1);
          }
          if (i2 == 1) {
            paramFromServiceMsg.a().a((String)paramObject, 2);
          }
        }
      }
      for (;;)
      {
        a(7, bool1, new Object[] { Integer.valueOf(i2), paramObject, paramToServiceMsg, localObject1, localObject2 });
        DatingUtil.a("handle_oidb_0x7db_0", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1), Integer.valueOf(i2), paramObject, localObject2 });
        return;
        paramFromServiceMsg = (FromServiceMsg)paramObject;
        localObject1 = localObject4;
        localObject2 = localObject3;
        bool1 = bool2;
        if (!localRspBody.str_wording.has()) {
          break;
        }
        localObject2 = localRspBody.str_wording.get();
        paramFromServiceMsg = (FromServiceMsg)paramObject;
        localObject1 = localObject4;
        bool1 = bool2;
        break;
        if (i2 == 0) {
          paramFromServiceMsg.a().a(paramToServiceMsg, 2);
        }
        continue;
        paramToServiceMsg = null;
        break label231;
        paramToServiceMsg = null;
      }
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7db.RspBody localRspBody = new cmd0x7db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      paramFromServiceMsg = null;
      bool = true;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("appoint_id");
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a(2, false, paramToServiceMsg, bool);
      a(14, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_oidb_0x7db_1", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        paramFromServiceMsg = null;
        bool = false;
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x7db.RspBody localRspBody = new cmd0x7db.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i1 == 0)
    {
      bool = true;
      paramFromServiceMsg = null;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("appoint_action");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("appoint_id");
      paramObject = new ArrayList();
      ((ArrayList)paramObject).add(paramToServiceMsg);
      ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a(2, true, (ArrayList)paramObject, bool);
      a(15, bool, new Object[] { Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg });
      DatingUtil.a("handle_oidb_0x7db_2", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), paramObject, paramFromServiceMsg });
      return;
      if (localRspBody.str_wording.has())
      {
        paramFromServiceMsg = localRspBody.str_wording.get();
        bool = false;
      }
      else
      {
        bool = false;
        paramFromServiceMsg = null;
      }
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    DatingManager localDatingManager = null;
    Object localObject = new cmd0x7ca.RspBody();
    int i2 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = null;
    long l1 = 0L;
    int i1 = paramToServiceMsg.extraData.getInt("appoint_action");
    boolean bool;
    if (i2 == 0)
    {
      paramFromServiceMsg = localDatingManager;
      if (((cmd0x7ca.RspBody)localObject).bytes_SigC2C.has()) {
        paramFromServiceMsg = ((cmd0x7ca.RspBody)localObject).bytes_SigC2C.get().toByteArray();
      }
      if (((cmd0x7ca.RspBody)localObject).uint64_peer_uin.has()) {
        l1 = ((cmd0x7ca.RspBody)localObject).uint64_peer_uin.get();
      }
      if (!((cmd0x7ca.RspBody)localObject).uint32_op_type.has()) {
        break label369;
      }
      i1 = ((cmd0x7ca.RspBody)localObject).uint32_op_type.get();
      bool = true;
    }
    for (;;)
    {
      long l2 = paramToServiceMsg.extraData.getLong("open_id");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("appoint_id");
      localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if ((bool) && (localDatingManager != null))
      {
        if (i1 == 2)
        {
          localObject = localDatingManager.a().a(paramToServiceMsg, true, false, false);
          if ((localObject != null) && (((DatingInfo)localObject).updateJoinListData(l2, 1))) {
            localDatingManager.a().a((DatingInfo)localObject, 3);
          }
        }
        if (paramFromServiceMsg != null) {
          localDatingManager.a().a(paramToServiceMsg, l2, paramFromServiceMsg);
        }
      }
      a(1, bool, new Object[] { Integer.valueOf(i1), Long.valueOf(l2), Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg, paramObject });
      DatingUtil.a("handle_oidb_0x7ca_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool), Integer.valueOf(i1), Long.valueOf(l2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      return;
      if (((cmd0x7ca.RspBody)localObject).str_error_wording.has())
      {
        paramObject = ((cmd0x7ca.RspBody)localObject).str_error_wording.get();
        bool = false;
        paramFromServiceMsg = null;
        l1 = 0L;
      }
      else
      {
        bool = false;
        paramFromServiceMsg = null;
        l1 = 0L;
        continue;
        label369:
        bool = true;
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new cmd0x7dc.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramToServiceMsg = null;
    if (i1 == 0)
    {
      if (((cmd0x7dc.RspBody)localObject1).rpt_msg_appoint_info.has()) {
        paramToServiceMsg = ((cmd0x7dc.RspBody)localObject1).rpt_msg_appoint_info.get();
      }
      if (paramToServiceMsg == null) {
        break label403;
      }
      if (paramToServiceMsg.size() > 0)
      {
        bool = true;
        paramObject = "";
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)paramObject;
      }
    }
    for (;;)
    {
      label72:
      paramObject = "";
      if (bool)
      {
        Object localObject2 = (appoint_define.AppointInfo)paramFromServiceMsg.get(0);
        if (localObject2 != null)
        {
          if (((appoint_define.AppointInfo)localObject2).msg_appoint_id.has()) {
            paramObject = DatingUtil.a(((appoint_define.AppointInfo)localObject2).msg_appoint_id);
          }
          localObject1 = new DatingInfo();
          DatingUtil.a((DatingInfo)localObject1, (appoint_define.AppointInfo)localObject2);
          label134:
          localObject2 = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
          ((DatingManager)localObject2).a().a((DatingInfo)localObject1, 1);
          ((DatingManager)localObject2).b((String)paramObject);
          if ((paramFromServiceMsg.size() > 1) && (paramFromServiceMsg.get(1) != null))
          {
            localObject1 = (appoint_define.AppointInfo)paramFromServiceMsg.get(1);
            paramFromServiceMsg = DatingUtil.a(((appoint_define.AppointInfo)localObject1).msg_appoint_id);
            ((DatingManager)localObject2).a().a((appoint_define.AppointInfo)localObject1);
          }
        }
      }
      for (;;)
      {
        a(8, bool, new Object[] { paramObject, paramFromServiceMsg, paramToServiceMsg });
        if (QLog.isColorLevel()) {
          QLog.d("Q.dating", 2, "result:" + i1 + " isSuccess:" + bool + " new_id:" + (String)paramObject + " old_id:" + paramFromServiceMsg + " errMsg:" + paramToServiceMsg);
        }
        return;
        bool = false;
        break;
        if (((cmd0x7dc.RspBody)localObject1).str_wording.has())
        {
          paramToServiceMsg = ((cmd0x7dc.RspBody)localObject1).str_wording.get();
          paramFromServiceMsg = null;
          break label72;
        }
        if (i1 != 1002) {
          break label394;
        }
        paramFromServiceMsg = null;
        paramToServiceMsg = "约会发布失败，请检查网络链接";
        break label72;
        paramFromServiceMsg = "";
        continue;
        paramObject = "";
        localObject1 = null;
        break label134;
        paramFromServiceMsg = "";
        paramObject = "";
      }
      label394:
      paramFromServiceMsg = null;
      paramToServiceMsg = "";
      continue;
      label403:
      paramObject = "";
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = (ToServiceMsg)paramObject;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    cmd0x7cb.RspBody localRspBody = new cmd0x7cb.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    if ((i1 == 0) && (localRspBody.uint32_time_stamp.has()) && (localRspBody.uint32_time_gap.has()) && (localRspBody.rpt_comment_configs.has()) && (localRspBody.str_attend_tips_to_A.has()) && (localRspBody.str_first_msg_tips.has()) && (localRspBody.rpt_cancle_config.has()) && (localRspBody.msg_date_request.has()))
    {
      paramFromServiceMsg = DatingConfig.createDatingConfig(localRspBody);
      paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if (paramObject == null)
      {
        if (paramToServiceMsg != null) {
          paramToServiceMsg.a(paramFromServiceMsg);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().c();
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a(2, bool, new Object[] { paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.d("handle_oidb_0x7cb_0", 2, "result:" + i1 + " isSuccess:" + bool);
      }
      return;
      paramToServiceMsg = ((DatingManager)paramObject).a();
      break;
      paramToServiceMsg = null;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = new cmd0x7de.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    DatingUtil.a("handleGetDatingFeeds", new Object[] { Integer.valueOf(i1) });
    paramObject = null;
    Object localObject1 = null;
    boolean bool1;
    label118:
    label143:
    int i2;
    label164:
    int i3;
    if (i1 == 0) {
      if (((cmd0x7de.RspBody)localObject2).msg_head.has())
      {
        paramFromServiceMsg = (cmd0x7de.BusiRespHead)((cmd0x7de.RspBody)localObject2).msg_head.get();
        if (paramFromServiceMsg != null) {
          if (paramFromServiceMsg.int32_reply_code.has())
          {
            i1 = paramFromServiceMsg.int32_reply_code.get();
            if (i1 == 0)
            {
              bool1 = true;
              if (!paramFromServiceMsg.str_result.has()) {
                break label545;
              }
              paramFromServiceMsg = paramFromServiceMsg.str_result.get();
              if (!bool1) {
                break label531;
              }
              if (!((cmd0x7de.RspBody)localObject2).rpt_msg_user_list.has()) {
                break label526;
              }
              paramObject = ((cmd0x7de.RspBody)localObject2).rpt_msg_user_list.get();
              if (!((cmd0x7de.RspBody)localObject2).uint32_ended.has()) {
                break label520;
              }
              i2 = ((cmd0x7de.RspBody)localObject2).uint32_ended.get();
              if (!((cmd0x7de.RspBody)localObject2).bytes_cookie.has()) {
                break label497;
              }
              localObject2 = ((cmd0x7de.RspBody)localObject2).bytes_cookie.get().toByteArray();
              localObject1 = paramObject;
              i3 = i2;
              i2 = i1;
              paramObject = paramFromServiceMsg;
              paramFromServiceMsg = (FromServiceMsg)localObject1;
              i1 = i3;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      boolean bool2;
      if ((i1 & 0x1) == 0)
      {
        bool2 = true;
        label222:
        if ((i1 & 0x2) != 0) {
          break label378;
        }
      }
      boolean bool4;
      boolean bool5;
      label378:
      for (boolean bool3 = true;; bool3 = false)
      {
        bool4 = paramToServiceMsg.extraData.getBoolean("isMore", false);
        bool5 = paramToServiceMsg.extraData.getBoolean("isManual", false);
        boolean bool6 = paramToServiceMsg.extraData.getBoolean("isWebFilter", false);
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
        if (paramToServiceMsg == null) {
          break label492;
        }
        paramToServiceMsg = paramToServiceMsg.a().a(0, paramFromServiceMsg, bool4, bool6);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
          break label384;
        }
        localObject2 = paramToServiceMsg.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          DatingInfo localDatingInfo = (DatingInfo)((Iterator)localObject2).next();
          if (localDatingInfo != null) {
            localDatingInfo.lastUpdateTime = 0L;
          }
        }
        bool1 = false;
        break;
        bool1 = false;
        break;
        bool2 = false;
        break label222;
      }
      for (;;)
      {
        label384:
        a(9, bool1, new Object[] { paramToServiceMsg, Boolean.valueOf(bool2), Boolean.valueOf(bool3), localObject1, paramObject, Boolean.valueOf(bool4), Boolean.valueOf(bool5) });
        DatingUtil.a("handleGetDatingFeeds", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool1), paramFromServiceMsg, Integer.valueOf(i1), localObject1, paramObject });
        return;
        label492:
        paramToServiceMsg = null;
      }
      label497:
      i3 = i1;
      localObject2 = paramFromServiceMsg;
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      i1 = i2;
      paramObject = localObject2;
      i2 = i3;
      continue;
      label520:
      i2 = -1;
      break label164;
      label526:
      paramObject = null;
      break label143;
      label531:
      i2 = i1;
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = null;
      i1 = -1;
      continue;
      label545:
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      break label118;
      bool1 = false;
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      break label118;
      paramFromServiceMsg = null;
      break;
      paramObject = null;
      i2 = i1;
      bool1 = false;
      paramFromServiceMsg = null;
      i1 = -1;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false)) {
      NearbyCmdHelper.e(this, 10, paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramToServiceMsg.extraData.getBoolean("setRefuseRankSetting", false)) {
      return;
    }
    NearbyCmdHelper.e(this, 27, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i5 = 0;
    int i2 = 0;
    int i4 = 0;
    int i3 = 0;
    cmd0x7cd.RspBody localRspBody = new cmd0x7cd.RspBody();
    int i6 = a(paramFromServiceMsg, paramObject, localRspBody);
    int i7 = paramToServiceMsg.extraData.getInt("download_type");
    int i1;
    boolean bool;
    if (i6 == 0) {
      if (localRspBody.uint32_next.has())
      {
        i1 = localRspBody.uint32_next.get();
        if (localRspBody.uint32_over.has()) {
          i2 = localRspBody.uint32_over.get();
        }
        if (localRspBody.uint32_stamp.has()) {
          i3 = localRspBody.uint32_stamp.get();
        }
        if (localRspBody.rpt_msg_appoints_info.has()) {
          localRspBody.rpt_msg_appoints_info.get();
        }
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
        bool = true;
      }
    }
    for (;;)
    {
      a(3, bool, new Object[] { null, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i7) });
      DatingUtil.a("handle_oidb_0x7cd_0", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i6), null, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
      return;
      i1 = 0;
      break;
      bool = false;
      i1 = 0;
      i2 = i5;
      i3 = i4;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i5 = 0;
    int i2 = 0;
    int i4 = 0;
    int i3 = 0;
    int i6 = paramToServiceMsg.extraData.getInt("download_type");
    paramToServiceMsg = new cmd0x7cf.RspBody();
    int i7 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int i1;
    boolean bool;
    if (i7 == 0) {
      if (paramToServiceMsg.uint32_next.has())
      {
        i1 = paramToServiceMsg.uint32_next.get();
        if (paramToServiceMsg.uint32_over.has()) {
          i2 = paramToServiceMsg.uint32_over.get();
        }
        if (paramToServiceMsg.uint32_stamp.has()) {
          i3 = paramToServiceMsg.uint32_stamp.get();
        }
        if (paramToServiceMsg.rpt_msg_appoints_info.has()) {
          paramToServiceMsg.rpt_msg_appoints_info.get();
        }
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
        bool = true;
      }
    }
    for (;;)
    {
      a(5, bool, new Object[] { null, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6) });
      if (0 == 0)
      {
        DatingUtil.a("handle_oidb_0x7cf_0", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i7), null, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
        return;
      }
      throw new NullPointerException();
      i1 = 0;
      break;
      bool = false;
      i1 = 0;
      i2 = i5;
      i3 = i4;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("appoint_id");
    Object localObject = new cmd0x5fd.RspBody();
    int i3 = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int i1 = 0;
    int i2;
    if (i3 == 0)
    {
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        if (((cmd0x5fd.RspBody)localObject).msg_comment.has()) {
          paramFromServiceMsg = DatingComment.a(((cmd0x5fd.RspBody)localObject).msg_comment.get());
        }
        i2 = ((cmd0x5fd.RspBody)localObject).uint32_clear_cache_flag.get();
        if (!((cmd0x5fd.RspBody)localObject).uint32_comment_num.has()) {
          break label330;
        }
        i1 = ((cmd0x5fd.RspBody)localObject).uint32_comment_num.get();
        label122:
        if (!((cmd0x5fd.RspBody)localObject).str_comment_wording.has()) {
          break label336;
        }
        paramObject = ((cmd0x5fd.RspBody)localObject).str_comment_wording.get();
        label142:
        if (paramToServiceMsg != null)
        {
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            if (i2 == 0) {
              break label343;
            }
            bool = true;
            label167:
            paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, bool);
          }
          paramToServiceMsg.setReachOver(1, true, true);
          paramToServiceMsg.datingCommentNum = i1;
          paramToServiceMsg.datingCommentWording = ((String)paramObject);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating.detail", 2, "handlePubDatingComment commentNum is: " + i1);
        }
        paramFromServiceMsg = null;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a(17, bool, new Object[] { str, paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i1) });
      DatingUtil.a("handlPubDateComment", new Object[] { Integer.valueOf(i3), str, Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i1) });
      return;
      paramToServiceMsg = paramToServiceMsg.a().a(str, true, true, true);
      break;
      label330:
      i1 = 0;
      break label122;
      label336:
      paramObject = "";
      break label142;
      label343:
      bool = false;
      break label167;
      paramFromServiceMsg = ((cmd0x5fd.RspBody)localObject).str_error_tips.get();
      paramObject = paramToServiceMsg.extraData.getString("beReplyedCommentId");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("commentContent");
      localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if ((localObject != null) && (!TextUtils.isEmpty(paramToServiceMsg))) {
        ((DatingManager)localObject).a(str, (String)paramObject, paramToServiceMsg);
      }
      paramToServiceMsg = null;
      i2 = 0;
    }
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("appoint_id");
    String str2 = paramToServiceMsg.extraData.getString("date_comment_id");
    paramToServiceMsg = new cmd0x5ff.RspBody();
    if (a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = null;
        if (paramToServiceMsg != null) {
          paramToServiceMsg.delComment(str2);
        }
        paramToServiceMsg = null;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      a(18, bool, new Object[] { str1, str2, paramToServiceMsg });
      DatingUtil.a("handleDelDateComment", new Object[] { str1, str2, paramToServiceMsg });
      return;
      paramToServiceMsg = paramToServiceMsg.a().a(str1, true, true, true);
      break;
      paramToServiceMsg = paramToServiceMsg.str_error_tips.get();
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str1 = paramToServiceMsg.extraData.getString("appoint_id");
    String str2 = paramToServiceMsg.extraData.getString("date_comment_id");
    int i3 = paramToServiceMsg.extraData.getInt("appoint_action");
    cmd0x5fe.RspBody localRspBody = new cmd0x5fe.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool = false;
    if (i1 == 0) {
      if (!localRspBody.msg_comment.has()) {
        break label642;
      }
    }
    label161:
    label177:
    label206:
    label368:
    label374:
    label380:
    label532:
    label565:
    label571:
    label577:
    label642:
    for (paramFromServiceMsg = DatingComment.a(localRspBody.msg_comment.get());; paramFromServiceMsg = null)
    {
      i1 = localRspBody.uint32_fetch_old_over.get();
      int i2 = localRspBody.uint32_fetch_new_over.get();
      paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = null;
        if (paramToServiceMsg != null)
        {
          if (!"0".equals(str2)) {
            break label380;
          }
          paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, true);
          if (i2 == 0) {
            break label368;
          }
          bool = true;
          paramToServiceMsg.setReachOver(1, true, bool);
          if (i1 == 0) {
            break label374;
          }
          bool = true;
          paramToServiceMsg.setReachOver(1, false, bool);
        }
        if (!localRspBody.uint32_fetch_new_over.has()) {
          break label571;
        }
        i1 = localRspBody.uint32_fetch_new_over.get();
        if (!localRspBody.uint32_fetch_old_over.has()) {
          break label577;
        }
      }
      for (i2 = localRspBody.uint32_fetch_old_over.get();; i2 = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating.detail", 2, "handle getDatingComment over is: " + i1 + " " + i2);
        }
        paramFromServiceMsg = null;
        bool = true;
        a(19, bool, new Object[] { str1, Integer.valueOf(i3), str2, paramToServiceMsg, paramFromServiceMsg });
        DatingUtil.a("handleGetDateCommentList", new Object[] { str1, Integer.valueOf(i3), str2, paramToServiceMsg, paramFromServiceMsg });
        return;
        paramToServiceMsg = paramToServiceMsg.a().a(str1, true, true, true);
        break;
        bool = false;
        break label161;
        bool = false;
        break label177;
        if (i3 == 1)
        {
          paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, false);
          if (i2 != 0) {}
          for (bool = true;; bool = false)
          {
            paramToServiceMsg.setReachOver(1, true, bool);
            break;
          }
        }
        if (i3 == 2)
        {
          paramToServiceMsg.addDatingComment(false, paramFromServiceMsg, false);
          if (i1 != 0) {}
          for (bool = true;; bool = false)
          {
            paramToServiceMsg.setReachOver(1, false, bool);
            break;
          }
        }
        if ((!paramToServiceMsg.isGetList) && (paramToServiceMsg.isInit) && (paramToServiceMsg.isCanMerge(1, false, paramFromServiceMsg)))
        {
          paramToServiceMsg.addDatingComment(false, paramFromServiceMsg, false);
          if (i1 != 0) {}
          for (bool = true;; bool = false)
          {
            paramToServiceMsg.setReachOver(1, false, bool);
            paramToServiceMsg.isGetList = true;
            break;
          }
        }
        paramToServiceMsg.addDatingComment(true, paramFromServiceMsg, true);
        if (i2 != 0)
        {
          bool = true;
          paramToServiceMsg.setReachOver(1, true, bool);
          if (i1 == 0) {
            break label565;
          }
        }
        for (bool = true;; bool = false)
        {
          paramToServiceMsg.setReachOver(1, false, bool);
          break;
          bool = false;
          break label532;
        }
        i1 = -1;
        break label206;
      }
      if (i3 == 3)
      {
        paramToServiceMsg = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
        if (paramToServiceMsg == null) {
          paramToServiceMsg = null;
        }
      }
      for (;;)
      {
        paramFromServiceMsg = localRspBody.str_error_tips.get();
        break;
        paramToServiceMsg = paramToServiceMsg.a().a(str1, false, false, false);
        continue;
        paramToServiceMsg = null;
      }
    }
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("last_nearby_event_id");
    long l2 = paramToServiceMsg.extraData.getLong("read_nearby_event_id");
    paramToServiceMsg = new cmd0x5fc.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = null;
    paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    boolean bool;
    if (i1 == 0)
    {
      if ((paramObject == null) || (!paramToServiceMsg.rpt_msg_nearby_event_list.has())) {
        break label199;
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_nearby_event_list.get();
      bool = true;
      paramToServiceMsg = null;
    }
    for (;;)
    {
      if (paramObject != null)
      {
        ((DatingManager)paramObject).a().a(bool, paramFromServiceMsg, l1, l2);
        DatingUtil.a("handleGetRankEventList", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramFromServiceMsg, paramToServiceMsg });
        return;
        paramToServiceMsg = paramToServiceMsg.str_error_tips.get();
        bool = false;
      }
      else
      {
        DatingUtil.b("handleGetRankEventList", new Object[] { Long.valueOf(l1), Long.valueOf(l2), paramFromServiceMsg, paramToServiceMsg });
        return;
        label199:
        bool = true;
        paramToServiceMsg = null;
      }
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l2 = paramToServiceMsg.extraData.getLong("last_event_id");
    long l3 = paramToServiceMsg.extraData.getLong("read_event_id");
    cmd0x5fc.RspBody localRspBody = new cmd0x5fc.RspBody();
    int i1 = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = null;
    paramObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    if (i1 == 0) {
      if ((paramObject != null) && (localRspBody.rpt_act_appoint_ids.has()))
      {
        paramToServiceMsg = localRspBody.rpt_act_appoint_ids.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          paramFromServiceMsg = paramToServiceMsg.iterator();
          while (paramFromServiceMsg.hasNext())
          {
            Object localObject = (appoint_define.AppointID)paramFromServiceMsg.next();
            if (localObject != null)
            {
              localObject = DatingUtil.a((appoint_define.AppointID)localObject);
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                ((DatingManager)paramObject).b((String)localObject);
              }
            }
          }
        }
        if (paramToServiceMsg == null)
        {
          paramToServiceMsg = "null";
          DatingUtil.a("handleGetDateEventList", new Object[] { paramToServiceMsg });
        }
      }
      else
      {
        if (!localRspBody.rpt_msg_event_list.has()) {
          break label358;
        }
      }
    }
    label315:
    label358:
    for (paramToServiceMsg = localRspBody.rpt_msg_event_list.get();; paramToServiceMsg = null)
    {
      long l1 = localRspBody.uint64_max_event_id.get();
      boolean bool = true;
      paramFromServiceMsg = null;
      for (;;)
      {
        if (paramObject == null) {
          break label315;
        }
        ((DatingManager)paramObject).a().a(bool, paramToServiceMsg, l2, l3, l1);
        DatingUtil.a("handleGetDateEventList", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
        return;
        paramToServiceMsg = Integer.valueOf(paramToServiceMsg.size());
        break;
        paramFromServiceMsg = localRspBody.str_error_tips.get();
        bool = false;
        l1 = 0L;
      }
      DatingUtil.b("handleGetDateEventList", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), paramToServiceMsg, paramFromServiceMsg });
      return;
    }
  }
  
  protected Class a()
  {
    return DatingObserver.class;
  }
  
  public void a()
  {
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(Short.valueOf((short)24002));
    ((List)localObject2).add(Short.valueOf((short)20043));
    ((List)localObject2).add(Short.valueOf((short)20032));
    ((List)localObject2).add(Short.valueOf((short)20041));
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject1 = ByteBuffer.allocate(((List)localObject2).size() * 2 + 7);
    ((ByteBuffer)localObject1).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()));
    ((ByteBuffer)localObject1).put((byte)0);
    ((ByteBuffer)localObject1).putShort((short)((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ByteBuffer)localObject1).putShort(((Short)((Iterator)localObject2).next()).shortValue());
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject1).array()));
    localObject1 = a("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject1).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("toplist_rank", 2, "DatingHandler setRefuseRankSetting refuse = " + paramByte);
    }
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount());
      Object localObject = new byte[13];
      PkgTools.a((byte[])localObject, 0, l1);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 41804);
      PkgTools.a((byte[])localObject, 9, (short)2);
      PkgTools.a((byte[])localObject, 11, (short)paramByte);
      localObject = a("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("toplist_set_refuse_rank", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("setRefuseRankSetting", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "setRefuseRankSetting() send_oidb_0x4ff_9 error", localException);
    }
  }
  
  public void a(int paramInt)
  {
    cmd0x7cb.ReqBody localReqBody = new cmd0x7cb.ReqBody();
    localReqBody.uint32_time_stamp.set(paramInt);
    b(a("OidbSvc.0x7cb_0", 1995, 0, localReqBody.toByteArray()));
    DatingUtil.a("send_oidb_0x7cb_0", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(20, true, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cmd0x7cd.ReqBody localReqBody = new cmd0x7cd.ReqBody();
    Object localObject1 = LbsUtils.a(getClass().getSimpleName());
    if (localObject1 != null) {
      localReqBody.msg_lbs_info.set((MessageMicro)localObject1);
    }
    localReqBody.uint32_stamp.set(paramInt1);
    localReqBody.uint32_start.set(paramInt2);
    localReqBody.uint32_want.set(paramInt3);
    Object localObject2 = ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a();
    if (((DatingCacheDel)localObject2).a(2, 1))
    {
      String str = ((DatingCacheDel)localObject2).a(2);
      localObject1 = new ArrayList();
      if (TextUtils.isEmpty(str))
      {
        localObject1 = ((DatingCacheDel)localObject2).a(2);
        localReqBody.uint32_appoint_operation.set(3);
      }
      for (;;)
      {
        int i1 = 0;
        while (i1 < ((ArrayList)localObject1).size())
        {
          localObject2 = DatingUtil.a((String)((ArrayList)localObject1).get(i1));
          if (localObject2 != null) {
            localReqBody.rpt_msg_appoint_ids.add((MessageMicro)localObject2);
          }
          i1 += 1;
        }
        ((ArrayList)localObject1).add(str);
        localReqBody.uint32_appoint_operation.set(4);
      }
    }
    localObject1 = a("OidbSvc.0x7cd_0", 1997, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("download_type", paramInt4);
    b((ToServiceMsg)localObject1);
    DatingUtil.a("send_oidb_0x7cd_0", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), LbsUtils.a(getClass().getSimpleName()) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    cmd0x7cf.ReqBody localReqBody = new cmd0x7cf.ReqBody();
    localReqBody.uint32_stamp.set(paramInt1);
    localReqBody.uint32_start.set(paramInt2);
    localReqBody.uint32_want.set(paramInt3);
    localReqBody.uint32_req_valid_only.set(paramInt4);
    Object localObject2 = ((DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212)).a();
    if (((DatingCacheDel)localObject2).a(1, 1))
    {
      String str = ((DatingCacheDel)localObject2).a(1);
      localObject1 = new ArrayList();
      if (TextUtils.isEmpty(str))
      {
        localObject1 = ((DatingCacheDel)localObject2).a(1);
        localReqBody.uint32_appoint_operation.set(1);
      }
      for (;;)
      {
        paramInt4 = 0;
        while (paramInt4 < ((ArrayList)localObject1).size())
        {
          localObject2 = DatingUtil.a((String)((ArrayList)localObject1).get(paramInt4));
          if (localObject2 != null) {
            localReqBody.rpt_msg_appoint_ids.add((MessageMicro)localObject2);
          }
          paramInt4 += 1;
        }
        ((ArrayList)localObject1).add(str);
        localReqBody.uint32_appoint_operation.set(2);
      }
    }
    Object localObject1 = a("OidbSvc.0x7cf_0", 1999, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("download_type", paramInt5);
    b((ToServiceMsg)localObject1);
    DatingUtil.a("send_oidb_0x7cf_0", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    UserDetailLocalInfo localUserDetailLocalInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a;
    if ((localUserDetailLocalInfo != null) && (!TextUtils.isEmpty(localUserDetailLocalInfo.strProvince)) && (!TextUtils.isEmpty(localUserDetailLocalInfo.strCity)))
    {
      a(paramInt1, paramInt2, paramLong1, paramInt3, paramLong2, paramBoolean, localUserDetailLocalInfo, null);
      return;
    }
    SosoInterface.a(new rdx(this, 0, true, true, 60000L, false, false, "DatingHandler", paramInt1, paramInt2, paramLong1, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    b(paramInt);
    NearbyCmdHelper.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = new cmd0x5fc.ReqBody();
    ((cmd0x5fc.ReqBody)localObject).uint64_last_nearby_event_id.set(paramLong1);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_nearby_event_id.set(paramLong2);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_nearby_event_count.set(paramInt);
    localObject = a("OidbSvc.0x5fc_0", 1532, 0, ((cmd0x5fc.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("last_nearby_event_id", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("read_nearby_event_id", paramLong2);
    ((ToServiceMsg)localObject).extraData.putBoolean("isRankEvent", true);
    b((ToServiceMsg)localObject);
    DatingUtil.a("getRankEventList", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
  }
  
  public void a(PublishDatingOption paramPublishDatingOption, int paramInt)
  {
    Object localObject1 = new cmd0x7dc.ReqBody();
    appoint_define.AppointContent localAppointContent = new appoint_define.AppointContent();
    localAppointContent.uint32_appoint_subject.set(paramPublishDatingOption.themeId);
    localAppointContent.uint32_pay_type.set(paramPublishDatingOption.payTypeId);
    localAppointContent.uint32_appoint_date.set((int)(paramPublishDatingOption.time / 1000L));
    localAppointContent.uint32_appoint_gender.set(paramPublishDatingOption.genderId);
    localAppointContent.str_appoint_introduce.set(paramPublishDatingOption.introduce);
    Object localObject2 = new appoint_define.AddressInfo();
    ((appoint_define.AddressInfo)localObject2).str_company_zone.set(paramPublishDatingOption.shopInfo.shopZone);
    ((appoint_define.AddressInfo)localObject2).str_company_name.set(paramPublishDatingOption.shopInfo.shopName);
    ((appoint_define.AddressInfo)localObject2).str_company_addr.set(paramPublishDatingOption.shopInfo.shopAddr);
    ((appoint_define.AddressInfo)localObject2).str_company_pic_url.set(paramPublishDatingOption.shopInfo.shopPicUrl);
    ((appoint_define.AddressInfo)localObject2).str_company_url.set(paramPublishDatingOption.shopInfo.shopUrl);
    appoint_define.ShopID localShopID = new appoint_define.ShopID();
    localShopID.str_shopid.set(paramPublishDatingOption.shopInfo.shopId);
    localShopID.uint32_sp.set(paramPublishDatingOption.shopInfo.shopSp);
    ((appoint_define.AddressInfo)localObject2).msg_company_id.set(localShopID);
    localAppointContent.msg_appoint_address.set((MessageMicro)localObject2);
    localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((cmd0x7dc.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    ((cmd0x7dc.ReqBody)localObject1).uint32_seq.set(0);
    ((cmd0x7dc.ReqBody)localObject1).msg_appointment.set(localAppointContent);
    ((cmd0x7dc.ReqBody)localObject1).uint32_overwrite.set(paramInt);
    localObject1 = a("OidbSvc.0x7dc_0", 2012, 0, ((cmd0x7dc.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("public_subject", paramPublishDatingOption.themeId);
    ((ToServiceMsg)localObject1).extraData.putInt("public_type", paramPublishDatingOption.payTypeId);
    ((ToServiceMsg)localObject1).extraData.putInt("public_time", (int)paramPublishDatingOption.time);
    ((ToServiceMsg)localObject1).extraData.putInt("public_gender", paramPublishDatingOption.genderId);
    ((ToServiceMsg)localObject1).extraData.putString("public_introduce", paramPublishDatingOption.introduce);
    ((ToServiceMsg)localObject1).extraData.putString("public_zone", paramPublishDatingOption.shopInfo.shopZone);
    ((ToServiceMsg)localObject1).extraData.putString("public_addr_name", paramPublishDatingOption.shopInfo.shopName);
    ((ToServiceMsg)localObject1).extraData.putString("public_addr", paramPublishDatingOption.shopInfo.shopAddr);
    ((ToServiceMsg)localObject1).extraData.putString("public_shop_pic_url", paramPublishDatingOption.shopInfo.shopPicUrl);
    ((ToServiceMsg)localObject1).extraData.putString("public_shop_url", paramPublishDatingOption.shopInfo.shopUrl);
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "publishNorDating|dating option[" + paramPublishDatingOption.toString() + "]");
    }
  }
  
  public void a(GodEntity paramGodEntity)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()).longValue());
    localToServiceMsg.extraData.putLong("targetUin", Long.valueOf(paramGodEntity.uin).longValue());
    if (TextUtils.isEmpty(paramGodEntity.cookie)) {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "zanFromTopList  cookie null ");
      }
    }
    do
    {
      return;
      localToServiceMsg.extraData.putByteArray("vCookies", paramGodEntity.cookie.getBytes());
      localToServiceMsg.extraData.putBoolean("nearby_people", true);
      localToServiceMsg.extraData.putInt("favoriteSource", 43);
      localToServiceMsg.extraData.putInt("toplist_type", paramGodEntity.listType);
      a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.i("toplist_rank", 2, "DatingHandler zanFromTopList  selfUin " + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() + ", targetUin " + paramGodEntity.uin + ", vCookies " + paramGodEntity.cookie + ", toplist_type " + paramGodEntity.listType);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if ("OidbSvc.0x7ca_0".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7cb_0".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7cd_0".equals(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7ce_0".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7cf_0".equals(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7da_0".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7db_0".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7dc_0".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7de_0".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_9".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7da_1".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7da_2".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7db_1".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7db_2".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x5fa_2".equals(str)) || ("OidbSvc.0x5fa_1".equals(str)))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, "OidbSvc.0x5fa_2".equals(str));
        return;
      }
      if ("OidbSvc.0x5fd_0".equals(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ff_0".equals(str))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5fe_0".equals(str))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5fc_0".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("isRankEvent", false))
        {
          x(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5f9_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x683_0".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x682".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x480_9".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x9e4_22".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    Object localObject1 = new cmd0x7ce.ReqBody();
    Object localObject2 = DatingUtil.a(paramString);
    ((cmd0x7ce.ReqBody)localObject1).rpt_appoint_ids.add((MessageMicro)localObject2);
    ((cmd0x7ce.ReqBody)localObject1).uint32_join_start.set(0);
    ((cmd0x7ce.ReqBody)localObject1).uint32_join_want.set(20);
    ((cmd0x7ce.ReqBody)localObject1).uint32_view_start.set(0);
    ((cmd0x7ce.ReqBody)localObject1).uint32_view_want.set(20);
    ((cmd0x7ce.ReqBody)localObject1).uint32_view_comment_count.set(20);
    localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((cmd0x7ce.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    localObject1 = a("OidbSvc.0x7ce_0", 1998, 4, ((cmd0x7ce.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("last_from", paramInt);
    b((ToServiceMsg)localObject1);
    DatingUtil.a("getDatingDetail", new Object[] { paramString, localObject2 });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new cmd0x7da.ReqBody();
    Object localObject2 = DatingUtil.a(paramString);
    ((cmd0x7da.ReqBody)localObject1).rpt_msg_appoint_ids.add((MessageMicro)localObject2);
    ((cmd0x7da.ReqBody)localObject1).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject1).uint32_operation_reason.set(paramInt2);
    if (((cmd0x7da.ReqBody)localObject1).rpt_msg_appoint_ids.size() > 0)
    {
      localObject1 = a("OidbSvc.0x7da_0", 2010, 0, ((cmd0x7da.ReqBody)localObject1).toByteArray());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramString);
      ((ToServiceMsg)localObject1).extraData.putStringArrayList("appoint_ids", (ArrayList)localObject2);
      ((ToServiceMsg)localObject1).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject1);
    }
    DatingUtil.a("send_oidb_0x7da_0", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a(22, true, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = new cmd0x7ca.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7ca.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x7ca.ReqBody)localObject).uint64_tinyid.set(paramLong);
    ((cmd0x7ca.ReqBody)localObject).uint32_op_type.set(paramInt);
    localObject = a("OidbSvc.0x7ca_0", 1994, 0, ((cmd0x7ca.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("open_id", paramLong);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7ca_0", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString1, appoint_define.DateComment paramDateComment, int paramInt, String paramString2)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = new cmd0x5fd.ReqBody();
    ((cmd0x5fd.ReqBody)localObject).msg_comment.set(paramDateComment);
    ((cmd0x5fd.ReqBody)localObject).uint32_max_fetch_count.set(paramInt);
    ((cmd0x5fd.ReqBody)localObject).str_last_comment_id.set(paramString2);
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x5fd_0", 1533, 0, ((cmd0x5fd.ReqBody)localObject).toByteArray());
    localToServiceMsg.extraData.putString("appoint_id", paramString1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramDateComment.msg_reply_info.has())
    {
      localObject = paramDateComment.msg_reply_info.str_comment_id.get();
      localBundle.putString("beReplyedCommentId", (String)localObject);
      localObject = localToServiceMsg.extraData;
      if (!paramDateComment.msg_content.has()) {
        break label198;
      }
    }
    label198:
    for (paramDateComment = DatingComment.a((appoint_define.RichText)paramDateComment.msg_content.get());; paramDateComment = "")
    {
      ((Bundle)localObject).putString("commentContent", paramDateComment);
      b(localToServiceMsg);
      DatingUtil.a("pubDateComment", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
      return;
      localObject = "";
      break;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = new cmd0x5ff.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString1);
    ((cmd0x5ff.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x5ff.ReqBody)localObject).str_comment_id.set(paramString2);
    localObject = a("OidbSvc.0x5ff_0", 1535, 0, ((cmd0x5ff.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("date_comment_id", paramString2);
    b((ToServiceMsg)localObject);
    DatingUtil.a("delDateComment", new Object[] { paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = new cmd0x5fe.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString1);
    ((cmd0x5fe.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x5fe.ReqBody)localObject).str_comment_id.set(paramString2);
    ((cmd0x5fe.ReqBody)localObject).uint32_fetch_old_count.set(paramInt1);
    ((cmd0x5fe.ReqBody)localObject).uint32_fetch_new_count.set(paramInt2);
    int i1 = DatingUtil.a(paramInt2, paramInt1);
    localObject = a("OidbSvc.0x5fe_0", 1534, 0, ((cmd0x5fe.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("date_comment_id", paramString2);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", i1);
    b((ToServiceMsg)localObject);
    DatingUtil.a("getDateCommentList", new Object[] { paramString1, paramString2, Integer.valueOf(i1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(String paramString1, String paramString2, ByteStringMicro paramByteStringMicro)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "北京";
    }
    paramString2 = new cmd0x5f9.ReqBody();
    paramString2.str_keyword.set(paramString1);
    paramString2.str_srccity.set(str);
    if (paramByteStringMicro != null) {
      paramString2.bytes_cookie.set(paramByteStringMicro);
    }
    b(a("OidbSvc.0x5f9_0", 1529, 0, paramString2.toByteArray()));
    DatingUtil.a("send_oidb_0x5f9_0", new Object[] { paramString1 });
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    Object localObject = new cmd0x7db.ReqBody();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      appoint_define.AppointID localAppointID = DatingUtil.a((String)paramArrayList.get(i1));
      if (localAppointID != null) {
        ((cmd0x7db.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
      }
      i1 += 1;
    }
    ((cmd0x7db.ReqBody)localObject).uint32_appoint_action.set(paramInt);
    ((cmd0x7db.ReqBody)localObject).uint32_overwrite.set(1);
    localObject = a("OidbSvc.0x7db_1", 2011, 1, ((cmd0x7db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putStringArrayList("appoint_id", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7db_1", new Object[] { paramArrayList, Integer.valueOf(paramInt) });
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x7da.ReqBody();
    if (paramArrayList == null) {}
    for (int i1 = 0;; i1 = paramArrayList.size())
    {
      int i2 = 0;
      while (i2 < i1)
      {
        appoint_define.AppointID localAppointID = DatingUtil.a((String)paramArrayList.get(i2));
        if (localAppointID != null) {
          ((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
        }
        i2 += 1;
      }
    }
    ((cmd0x7da.ReqBody)localObject).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject).uint32_operation_reason.set(paramInt2);
    if (((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.size() > 0)
    {
      localObject = a("OidbSvc.0x7da_0", 2010, 0, ((cmd0x7da.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putStringArrayList("appoint_ids", paramArrayList);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject);
    }
    DatingUtil.a("send_oidb_0x7da_0", new Object[] { paramArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(List paramList)
  {
    cmd0x9e4.ReqBody localReqBody = new cmd0x9e4.ReqBody();
    try
    {
      Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount());
      localReqBody.rpt_uint64_uins.set(paramList);
      localReqBody.uint32_req_god_flag.set(1);
      localReqBody.uint32_req_profession.set(1);
      localReqBody.uint32_req_age.set(1);
      localReqBody.uint32_req_gender.set(1);
      localReqBody.uint32_req_love_status.set(1);
      localReqBody.uint32_req_constellation.set(1);
      localReqBody.uint32_req_vip_flag.set(1);
      localReqBody.uint32_req_charm_shown.set(1);
      localReqBody.uint32_req_charm_level.set(1);
      localReqBody.uint32_req_common_label.set(1);
      b(a("OidbSvc.0x9e4_22", 2532, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DatingHandler", 2, "send_oidb_0x5eb_15 error", paramList);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt3 + paramInt4 < 0) || (paramInt3 + paramInt4 > 200))
    {
      DatingUtil.a("getDatingStrangers", new Object[] { "invalide params", paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    Object localObject = new cmd0x5fa.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x5fa.ReqBody)localObject).rpt_appoint_ids.set(localAppointID);
    ((cmd0x5fa.ReqBody)localObject).uint32_refer_idx.set(paramInt1);
    ((cmd0x5fa.ReqBody)localObject).uint32_get_refer_rec.set(paramInt2);
    ((cmd0x5fa.ReqBody)localObject).uint32_req_next_count.set(paramInt3);
    ((cmd0x5fa.ReqBody)localObject).uint32_req_prev_count.set(paramInt4);
    paramInt2 = DatingUtil.a(paramInt4, paramInt3);
    if (paramBoolean) {}
    for (localObject = a("OidbSvc.0x5fa_2", 1530, 2, ((cmd0x5fa.ReqBody)localObject).toByteArray());; localObject = a("OidbSvc.0x5fa_1", 1530, 1, ((cmd0x5fa.ReqBody)localObject).toByteArray()))
    {
      ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("refer_idx", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt2);
      b((ToServiceMsg)localObject);
      DatingUtil.a("getDatingStrangers", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, appoint_define.LocaleInfo paramLocaleInfo, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = LbsUtils.a(getClass().getSimpleName());
    DatingUtil.a("getDatingFeeds", new Object[] { localObject });
    if (localObject == null)
    {
      DatingUtil.b("getDatingFeeds", new Object[] { "lbs is null" });
      return false;
    }
    cmd0x7de.BusiReqHead localBusiReqHead = new cmd0x7de.BusiReqHead();
    localBusiReqHead.int32_version.set(1);
    localBusiReqHead.int32_seq.set(0);
    cmd0x7de.ReqBody localReqBody = new cmd0x7de.ReqBody();
    localReqBody.msg_head.set(localBusiReqHead);
    localReqBody.msg_lbs_info.set((MessageMicro)localObject);
    localReqBody.uint32_time.set(paramInt1);
    localReqBody.uint32_subject.set(paramInt2);
    localReqBody.uint32_gender.set(paramInt3);
    localReqBody.uint32_age_low.set(paramInt4);
    localReqBody.uint32_age_up.set(paramInt5);
    localReqBody.uint32_profession.set(paramInt6);
    localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = new byte[0];
    }
    localReqBody.bytes_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
    if ((paramLocaleInfo != null) && (paramInt2 == 5)) {
      localReqBody.msg_destination.set(paramLocaleInfo);
    }
    paramLocaleInfo = a("OidbSvc.0x7de_0", 2014, 0, localReqBody.toByteArray());
    paramLocaleInfo.extraData.putInt("filter_time", paramInt1);
    paramLocaleInfo.extraData.putInt("filter_subject", paramInt2);
    paramLocaleInfo.extraData.putInt("filter_gender", paramInt3);
    paramLocaleInfo.extraData.putInt("filter_lowage", paramInt4);
    paramLocaleInfo.extraData.putInt("filter_upage", paramInt5);
    paramLocaleInfo.extraData.putInt("filter_profession", paramInt6);
    paramLocaleInfo.extraData.putBoolean("isMore", paramBoolean1);
    paramLocaleInfo.extraData.putBoolean("isManual", paramBoolean2);
    paramLocaleInfo.extraData.putBoolean("isWebFilter", paramBoolean3);
    b(paramLocaleInfo);
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("OidbSvc.0x7ca_0");
      this.b.add("OidbSvc.0x7cb_0");
      this.b.add("OidbSvc.0x7cd_0");
      this.b.add("OidbSvc.0x7ce_0");
      this.b.add("OidbSvc.0x7cf_0");
      this.b.add("OidbSvc.0x7da_0");
      this.b.add("OidbSvc.0x7db_0");
      this.b.add("OidbSvc.0x7dc_0");
      this.b.add("OidbSvc.0x7de_0");
      this.b.add("OidbSvc.0x4ff_9");
      this.b.add("OidbSvc.0x7da_1");
      this.b.add("OidbSvc.0x7da_2");
      this.b.add("OidbSvc.0x7db_1");
      this.b.add("OidbSvc.0x7db_2");
      this.b.add("OidbSvc.0x5f9_0");
      this.b.add("OidbSvc.0x5fa_1");
      this.b.add("OidbSvc.0x5fa_2");
      this.b.add("OidbSvc.0x5fd_0");
      this.b.add("OidbSvc.0x5ff_0");
      this.b.add("OidbSvc.0x5fe_0");
      this.b.add("OidbSvc.0x5fc_0");
      this.b.add("OidbSvc.0x683_0");
      this.b.add("OidbSvc.0x682");
      this.b.add("OidbSvc.0x480_9");
      this.b.add("OidbSvc.0x4ff_9");
      this.b.add("VisitorSvc.ReqFavorite");
    }
    return !this.b.contains(paramString);
  }
  
  public void b(byte paramByte)
  {
    NearbyCmdHelper.a(this, paramByte);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = new cmd0x5fc.ReqBody();
    ((cmd0x5fc.ReqBody)localObject).uint64_last_event_id.set(paramLong1);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_event_id.set(paramLong2);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_count.set(paramInt);
    localObject = a("OidbSvc.0x5fc_0", 1532, 0, ((cmd0x5fc.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("last_event_id", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("read_event_id", paramLong2);
    b((ToServiceMsg)localObject);
    DatingUtil.a("getDateEventList", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
  }
  
  public void b(PublishDatingOption paramPublishDatingOption, int paramInt)
  {
    Object localObject1 = new cmd0x7dc.ReqBody();
    appoint_define.AppointContent localAppointContent = new appoint_define.AppointContent();
    localAppointContent.uint32_appoint_subject.set(paramPublishDatingOption.themeId);
    localAppointContent.uint32_appoint_date.set((int)(paramPublishDatingOption.time / 1000L));
    localAppointContent.uint32_appoint_gender.set(paramPublishDatingOption.genderId);
    localAppointContent.str_appoint_introduce.set(paramPublishDatingOption.introduce);
    Object localObject2 = new appoint_define.TravelInfo();
    if (paramPublishDatingOption.depLocal != null) {
      ((appoint_define.TravelInfo)localObject2).msg_depart_locale.set(paramPublishDatingOption.depLocal);
    }
    if (paramPublishDatingOption.desLocal != null) {
      ((appoint_define.TravelInfo)localObject2).msg_destination.set(paramPublishDatingOption.desLocal);
    }
    ((appoint_define.TravelInfo)localObject2).uint32_partner_count.set(paramPublishDatingOption.partCountId);
    ((appoint_define.TravelInfo)localObject2).uint32_vehicle.set(paramPublishDatingOption.vehicleId);
    localAppointContent.msg_travel_info.set((MessageMicro)localObject2);
    localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((cmd0x7dc.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    ((cmd0x7dc.ReqBody)localObject1).uint32_seq.set(0);
    ((cmd0x7dc.ReqBody)localObject1).msg_appointment.set(localAppointContent);
    ((cmd0x7dc.ReqBody)localObject1).uint32_overwrite.set(paramInt);
    localObject1 = a("OidbSvc.0x7dc_0", 2012, 0, ((cmd0x7dc.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("public_subject", paramPublishDatingOption.themeId);
    ((ToServiceMsg)localObject1).extraData.putInt("public_time", (int)paramPublishDatingOption.time);
    ((ToServiceMsg)localObject1).extraData.putInt("public_gender", paramPublishDatingOption.genderId);
    ((ToServiceMsg)localObject1).extraData.putString("public_introduce", paramPublishDatingOption.introduce);
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "publishTraDating|dating option[" + paramPublishDatingOption.toString() + "]");
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.f(this, 23, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7db.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7db.ReqBody)localObject).msg_appoint_id.set(localAppointID);
    ((cmd0x7db.ReqBody)localObject).uint32_appoint_action.set(paramInt);
    localObject = a("OidbSvc.0x7db_0", 2011, 0, ((cmd0x7db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7db_0", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x7da.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
    ((cmd0x7da.ReqBody)localObject).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject).uint32_operation_reason.set(paramInt2);
    ((cmd0x7da.ReqBody)localObject).uint32_overwrite.set(1);
    if (((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.size() > 0)
    {
      localObject = a("OidbSvc.0x7da_2", 2010, 2, ((cmd0x7da.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("appoint_ids", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject);
    }
    DatingUtil.a("send_oidb_0x7da_2", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void b(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x7da.ReqBody();
    if (paramArrayList == null) {}
    for (int i1 = 0;; i1 = paramArrayList.size())
    {
      int i2 = 0;
      while (i2 < i1)
      {
        appoint_define.AppointID localAppointID = DatingUtil.a((String)paramArrayList.get(i2));
        if (localAppointID != null) {
          ((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
        }
        i2 += 1;
      }
    }
    ((cmd0x7da.ReqBody)localObject).uint32_appoint_operation.set(paramInt1);
    ((cmd0x7da.ReqBody)localObject).uint32_operation_reason.set(paramInt2);
    ((cmd0x7da.ReqBody)localObject).uint32_overwrite.set(1);
    if (((cmd0x7da.ReqBody)localObject).rpt_msg_appoint_ids.size() > 0)
    {
      localObject = a("OidbSvc.0x7da_1", 2010, 1, ((cmd0x7da.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putStringArrayList("appoint_ids", paramArrayList);
      ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt1);
      b((ToServiceMsg)localObject);
    }
    DatingUtil.a("send_oidb_0x7da_1", new Object[] { paramArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new cmd0x9e4.RspBody();
    if ((a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (paramToServiceMsg.rpt_msg_uin_data.has()) && (paramToServiceMsg.rpt_msg_uin_data.size() > 0))
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_uin_data.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (cmd0x9e4.UdcUinData)paramFromServiceMsg.next();
        FansEntity localFansEntity = new FansEntity();
        localFansEntity.init((cmd0x9e4.UdcUinData)paramObject);
        paramToServiceMsg.add(localFansEntity);
      }
      DatingUtil.c("sayhellolist", new Object[] { "onget tags size is " + paramToServiceMsg.size() });
      a(25, true, new Object[] { paramToServiceMsg });
      return;
    }
    a(25, false, null);
  }
  
  public void c(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7db.ReqBody();
    appoint_define.AppointID localAppointID = DatingUtil.a(paramString);
    ((cmd0x7db.ReqBody)localObject).rpt_msg_appoint_ids.add(localAppointID);
    ((cmd0x7db.ReqBody)localObject).uint32_appoint_action.set(paramInt);
    ((cmd0x7db.ReqBody)localObject).uint32_overwrite.set(1);
    localObject = a("OidbSvc.0x7db_2", 2011, 2, ((cmd0x7db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("appoint_id", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("appoint_action", paramInt);
    b((ToServiceMsg)localObject);
    DatingUtil.a("send_oidb_0x7db_2", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {}
    String str6;
    for (boolean bool = true;; bool = false)
    {
      str6 = "";
      if (bool) {}
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        localObject2 = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label757;
        }
        Utils.a(((ByteBuffer)localObject2).getInt());
        ((ByteBuffer)localObject2).get();
        i4 = ((ByteBuffer)localObject2).getShort();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DatingHandler", 2, "handleGetHometownAndLocalCode, request success, tlvCount = " + i4);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject2;
          int i4;
          int i3;
          int i5;
          int i6;
          int i1;
          int i7;
          String str4;
          String str2;
          int i2;
          String str5;
          String str3;
          Object localObject1;
          label757:
          paramToServiceMsg = "";
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = str6;
          if (QLog.isColorLevel())
          {
            QLog.d("DatingHandler", 2, "handleGetDetailInfo", localException1);
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = str6;
            continue;
            paramFromServiceMsg = "";
            continue;
            paramToServiceMsg = "";
            continue;
            i3 = 0;
            str4 = "0";
            str2 = "0";
            paramObject = "0";
            paramFromServiceMsg = "0";
            str5 = "0";
            str3 = "0";
            String str1 = "0";
            paramToServiceMsg = "0";
            i2 = 0;
            i1 = 0;
            continue;
            switch (i5)
            {
            }
            continue;
            i3 += 1;
          }
        }
      }
      if ((((ByteBuffer)localObject2).hasRemaining()) && (i3 < i4))
      {
        i5 = ((ByteBuffer)localObject2).getShort();
        i6 = ((ByteBuffer)localObject2).getShort();
        if (QLog.isColorLevel())
        {
          QLog.d("DatingHandler", 2, "handleGetDetailInfo, TLV type: " + i5 + ",legnth: " + i6);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "invalid type: " + i5);
          }
          ((ByteBuffer)localObject2).position(((ByteBuffer)localObject2).position() + i6);
          continue;
          i1 = 1;
          i5 = ((ByteBuffer)localObject2).getInt();
          i6 = ((ByteBuffer)localObject2).getInt();
          i7 = ((ByteBuffer)localObject2).getInt();
          if (QLog.isColorLevel()) {
            QLog.d("DatingHandler", 2, "hometown, countryId " + i5 + ", provinceId " + i6 + ", cityId " + i7);
          }
          str4 = ConditionSearchManager.a(i5);
          str2 = ConditionSearchManager.a(i6);
          paramObject = ConditionSearchManager.a(i7);
          continue;
          i1 = 1;
          i5 = ((ByteBuffer)localObject2).getInt();
          if (QLog.isColorLevel()) {
            QLog.d("DatingHandler", 2, "hometown, districtId " + i5);
          }
          paramFromServiceMsg = ConditionSearchManager.a(i5);
          continue;
          i2 = 1;
          i5 = ((ByteBuffer)localObject2).getInt();
          i6 = ((ByteBuffer)localObject2).getInt();
          i7 = ((ByteBuffer)localObject2).getInt();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "location, countryId " + i5 + ", provinceId " + i6 + ", cityId " + i7);
          }
          str5 = ConditionSearchManager.a(i5);
          str3 = ConditionSearchManager.a(i6);
          localObject1 = ConditionSearchManager.a(i7);
          continue;
          i2 = 1;
          i5 = ((ByteBuffer)localObject2).getInt();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "location, districtId " + i5);
          }
          paramToServiceMsg = ConditionSearchManager.a(i5);
          continue;
        }
      }
      else if (i2 != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str5).append("-");
        ((StringBuilder)localObject2).append(str3).append("-");
        ((StringBuilder)localObject2).append((String)localObject1).append("-");
        ((StringBuilder)localObject2).append(paramToServiceMsg);
        paramToServiceMsg = ((StringBuilder)localObject2).toString();
        if (i1 != 0) {
          for (;;)
          {
            try
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str4).append("-");
              ((StringBuilder)localObject1).append(str2).append("-");
              ((StringBuilder)localObject1).append((String)paramObject).append("-");
              ((StringBuilder)localObject1).append(paramFromServiceMsg);
              paramFromServiceMsg = ((StringBuilder)localObject1).toString();
              paramObject = paramFromServiceMsg;
              paramFromServiceMsg = paramToServiceMsg;
              a(24, bool, new Object[] { paramObject, paramFromServiceMsg });
              return;
            }
            catch (Exception localException2)
            {
              continue;
              i1 = 64425;
              continue;
            }
            if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
              continue;
            }
            i1 = paramToServiceMsg.uint32_result.get();
            if (QLog.isColorLevel()) {
              QLog.d("DatingHandler", 2, "request error, ret " + i1);
            }
            paramFromServiceMsg = "";
            paramObject = str6;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */