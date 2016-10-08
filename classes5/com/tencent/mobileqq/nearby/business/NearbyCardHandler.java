package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import QQService.RespHead;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.dating.GodEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyCardHandler
  extends BusinessHandler
{
  public static final int a = 60;
  private static final String a = "NearbyCardHandler";
  public static final int b = 61;
  public static final int c = 46;
  public static final int d = 48;
  public static final int e = 50;
  public static final int f = 51;
  public static final int g = 40;
  public static final int h = 32;
  public static final int i = 57;
  protected Set a;
  
  public NearbyCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      a(57, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            a(57, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        a(57, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + (String)paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          a(57, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int j = 0;
          while (j < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(j)).toStringUtf8());
            j += 1;
          }
          a(57, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          a(57, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, "", Integer.valueOf(-1), Integer.valueOf(-1), "数据错误" });
      return;
    }
    String str;
    label86:
    int j;
    label96:
    int k;
    label106:
    int i3;
    int m;
    label146:
    int n;
    label165:
    label183:
    label201:
    Object localObject;
    if (paramToServiceMsg.extraData == null)
    {
      str = "";
      if (paramToServiceMsg.extraData != null) {
        break label541;
      }
      if (paramToServiceMsg.extraData != null) {
        break label555;
      }
      j = -1;
      if (paramToServiceMsg.extraData != null) {
        break label570;
      }
      k = -1;
      paramToServiceMsg = new cmd0x9c8.RspBody();
      i3 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i3 != 0) {
        break label843;
      }
      if (!paramToServiceMsg.uint32_tag_type.has()) {
        break label585;
      }
      m = paramToServiceMsg.uint32_tag_type.get();
      if (!paramToServiceMsg.uint32_next_pos.has()) {
        break label591;
      }
      n = paramToServiceMsg.uint32_next_pos.get();
      if (!paramToServiceMsg.rpt_msg_tag_list.has()) {
        break label597;
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_tag_list.get();
      if (!paramToServiceMsg.rpt_msg_sel_list.has()) {
        break label602;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_sel_list.get();
      localObject = this.b.a(this.b.getAccount()).createEntityManager();
      if ((j != 0) || (!TextUtils.isEmpty(str)) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label607;
      }
    }
    label541:
    label555:
    label570:
    label585:
    label591:
    label597:
    label602:
    label607:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("DELETE FROM ");
        ((StringBuilder)paramObject).append(InterestTagInfo.class.getSimpleName());
        ((StringBuilder)paramObject).append(" WHERE ");
        ((StringBuilder)paramObject).append("tagType = ");
        ((StringBuilder)paramObject).append(m);
        ((StringBuilder)paramObject).append(";");
        ((EntityManager)localObject).b(((StringBuilder)paramObject).toString());
        paramObject = this.b.getApplication().getSharedPreferences("dating_pref" + this.b.a(), 0).edit();
        ((SharedPreferences.Editor)paramObject).putLong("list_last_update_time_" + m, NetConnInfoCenter.getServerTimeMillis());
        ((SharedPreferences.Editor)paramObject).putInt("list_fetch_pos_" + m, n);
        ((SharedPreferences.Editor)paramObject).commit();
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label960;
      }
      paramObject = new ArrayList();
      int i2 = 0;
      while (i2 < paramFromServiceMsg.size())
      {
        InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramFromServiceMsg.get(i2));
        if (localInterestTagInfo != null)
        {
          localInterestTagInfo.tagType = m;
          ((List)paramObject).add(localInterestTagInfo);
          if (i1 != 0) {
            ((EntityManager)localObject).a(localInterestTagInfo);
          }
        }
        i2 += 1;
      }
      str = paramToServiceMsg.extraData.getString("key_word");
      break;
      paramToServiceMsg.extraData.getInt("tag_type");
      break label86;
      j = paramToServiceMsg.extraData.getInt("fetch_start");
      break label96;
      k = paramToServiceMsg.extraData.getInt("person_flag");
      break label106;
      m = -1;
      break label146;
      n = -1;
      break label165;
      paramFromServiceMsg = null;
      break label183;
      paramToServiceMsg = null;
      break label201;
    }
    label843:
    label960:
    for (paramFromServiceMsg = (FromServiceMsg)paramObject;; paramFromServiceMsg = null)
    {
      ((EntityManager)localObject).a();
      localObject = null;
      paramObject = localObject;
      if (paramToServiceMsg != null)
      {
        paramObject = localObject;
        if (!paramToServiceMsg.isEmpty())
        {
          paramObject = new ArrayList();
          i1 = 0;
          while (i1 < paramToServiceMsg.size())
          {
            localObject = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramToServiceMsg.get(i1));
            if (localObject != null) {
              ((List)paramObject).add(localObject);
            }
            i1 += 1;
          }
        }
      }
      a(1, true, new Object[] { Integer.valueOf(m), Integer.valueOf(n), paramFromServiceMsg, paramObject, str, Integer.valueOf(j), Integer.valueOf(k), null });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i3), Boolean.valueOf(true), Integer.valueOf(m), Integer.valueOf(n), paramFromServiceMsg, paramObject, str, Integer.valueOf(j), Integer.valueOf(k) });
      return;
      if (paramToServiceMsg.str_error.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error.get();; paramToServiceMsg = "")
      {
        a(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, str, Integer.valueOf(j), Integer.valueOf(k), paramToServiceMsg });
        NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i3), Boolean.valueOf(false), paramToServiceMsg });
        return;
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "handleEditProfileCard");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(3, false, null);
      return;
    }
    Object localObject = new cmd0x9c9.RspBody();
    int j = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l2 = SystemClock.elapsedRealtime();
    long l3 = paramToServiceMsg.extraData.getLong("startSaveTime");
    boolean bool1;
    EntityManager localEntityManager;
    if (paramToServiceMsg.extraData.containsKey("is_head_changed"))
    {
      bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      if (j != 0) {
        break label1057;
      }
      localEntityManager = this.b.a(this.b.getAccount()).createEntityManager();
      paramFromServiceMsg = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.b.a() });
      if (paramFromServiceMsg != null) {
        break label1095;
      }
      paramFromServiceMsg = new NearbyPeopleCard();
      paramFromServiceMsg.uin = this.b.a();
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "handleEditProfileCard get nearbyCard from db is null.");
      }
    }
    label231:
    label1009:
    label1015:
    label1021:
    label1027:
    label1057:
    label1095:
    for (;;)
    {
      if (paramToServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
        paramFromServiceMsg.godFlag = false;
      }
      if (((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.has())
      {
        paramObject = ((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.get().toByteArray();
        paramObject = paramFromServiceMsg.updateEditPicInfos((byte[])paramObject, (PicInfo)paramToServiceMsg.extraData.getParcelable("avatar_picinfo"));
        if ((paramObject != null) && (!((List)paramObject).isEmpty())) {
          NearbySPUtil.a(this.b.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
        }
        paramObject = paramToServiceMsg.extraData.getByteArray("9c7_body");
        if ((paramObject == null) || (paramObject.length <= 0)) {}
      }
      try
      {
        localObject = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject).mergeFrom((byte[])paramObject);
        paramFromServiceMsg.updateInterestTags(paramFromServiceMsg.tagFlag, ((cmd0x9c7.ReqBody)localObject).rpt_msg_tags.get());
        if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
          paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
        }
        if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
          paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
        }
        if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
          paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
        }
        if (paramToServiceMsg.extraData.containsKey("sex"))
        {
          paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
          paramObject = (NearbyCardManager)this.b.getManager(105);
          if (paramObject != null) {
            ((NearbyCardManager)paramObject).b(paramFromServiceMsg.gender);
          }
        }
        if (paramToServiceMsg.extraData.containsKey("birthday"))
        {
          paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
          paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
          paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
          paramObject = (NearbyCardManager)this.b.getManager(105);
          if (paramObject != null) {
            ((NearbyCardManager)paramObject).a(paramFromServiceMsg.age);
          }
        }
        if (paramToServiceMsg.extraData.containsKey("profession")) {
          paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
        }
        if (paramToServiceMsg.extraData.containsKey("company")) {
          paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
        }
        if (paramToServiceMsg.extraData.containsKey("college")) {
          paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
        }
      }
      catch (Exception paramObject)
      {
        try
        {
          do
          {
            NearbySPUtil.a(this.b.a(), "self_school_name", paramFromServiceMsg.college);
            if (paramToServiceMsg.extraData.containsKey("hometown"))
            {
              paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
              paramFromServiceMsg.hometownCountry = paramObject[0];
              paramFromServiceMsg.hometownProvice = paramObject[1];
              paramFromServiceMsg.hometownCity = paramObject[2];
              paramFromServiceMsg.hometownDistrict = paramObject[3];
            }
            if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
            {
              if (paramToServiceMsg.extraData.getShort("key_qzone_switch") != 0) {
                break label1009;
              }
              bool2 = true;
              paramFromServiceMsg.switchQzone = bool2;
            }
            if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
            {
              if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                break label1015;
              }
              bool2 = true;
              paramFromServiceMsg.switchHobby = bool2;
            }
            if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
            {
              if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") != 0) {
                break label1021;
              }
              l1 = 0L;
              paramFromServiceMsg.switchGiftVisible = l1;
            }
            if (paramFromServiceMsg.getStatus() != 1000) {
              break label1027;
            }
            localEntityManager.b(paramFromServiceMsg);
            bool2 = true;
            paramToServiceMsg = paramFromServiceMsg;
            paramFromServiceMsg = "";
            a(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), "" });
            paramObject = new HashMap();
            ((HashMap)paramObject).put("errorCode", String.valueOf(j));
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "actEditNearbyProfile", bool2, l2 - l3, 0L, (HashMap)paramObject, "");
            NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg });
            return;
            bool1 = false;
            break;
            paramObject = null;
            break label231;
            paramObject = paramObject;
          } while ((!NearbyCardConstants.a) || (!QLog.isColorLevel()));
          QLog.d("Q.nearby_people_card.", 2, "rsp_9c7" + ((Exception)paramObject).getMessage());
        }
        catch (Throwable paramObject)
        {
          for (;;)
          {
            ((Throwable)paramObject).printStackTrace();
            continue;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            long l1 = 1L;
            continue;
            if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
              localEntityManager.a(paramFromServiceMsg);
            }
          }
        }
      }
      boolean bool2 = false;
      if (((cmd0x9c9.RspBody)localObject).str_errorinfo.has()) {}
      for (paramToServiceMsg = ((cmd0x9c9.RspBody)localObject).str_errorinfo.get();; paramToServiceMsg = "")
      {
        paramObject = null;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)paramObject;
        break;
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.f(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int j = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int k;
      if (paramFromServiceMsg != null)
      {
        k = paramFromServiceMsg.uint32_result.get();
        j = k;
        bool1 = bool2;
        if (k == 0)
        {
          bool1 = true;
          j = k;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + j + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        j = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          k = localRspBody.uint32_config_seq.get();
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(k));
        }
        if (localRspBody.uint32_config_time.has())
        {
          k = localRspBody.uint32_config_time.get();
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(k));
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
        if ((j == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
        }
        int m;
        int n;
        int i1;
        int i2;
        for (;;)
        {
          this.b.a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, (Oidb_0x686.NearbyFeedConfig)paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break;
          }
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i2 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          a(60, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (m - j < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (j == 1)
          {
            localObject1 = localObject3;
            localObject2 = localObject4;
            if (localRspBody.msg_notify_event.has())
            {
              localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
              localObject1 = localObject3;
            }
          }
        }
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i4 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          a(61, true, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (m - j < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  /* Error */
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 792
    //   7: invokevirtual 427	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +33 -> 50
    //   20: ldc_w 794
    //   23: iconst_2
    //   24: new 73	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 796
    //   34: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 799	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   41: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: invokestatic 789	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   53: ifeq +2944 -> 2997
    //   56: invokestatic 804	java/lang/System:currentTimeMillis	()J
    //   59: lstore 14
    //   61: aload_1
    //   62: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   65: ldc_w 806
    //   68: invokevirtual 427	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   71: istore 26
    //   73: aload_1
    //   74: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   77: ldc_w 808
    //   80: invokevirtual 419	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   83: lstore 16
    //   85: invokestatic 413	android/os/SystemClock:elapsedRealtime	()J
    //   88: lstore 18
    //   90: aload_2
    //   91: invokevirtual 799	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   94: istore 10
    //   96: aconst_null
    //   97: astore 4
    //   99: aload_2
    //   100: invokevirtual 123	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   103: ifeq +1026 -> 1129
    //   106: aload_3
    //   107: instanceof 810
    //   110: ifeq +1019 -> 1129
    //   113: iconst_1
    //   114: istore 24
    //   116: iload 24
    //   118: ifeq +2874 -> 2992
    //   121: aload_0
    //   122: aload_2
    //   123: invokevirtual 813	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   126: ldc_w 815
    //   129: new 817	SummaryCard/RespHead
    //   132: dup
    //   133: invokespecial 818	SummaryCard/RespHead:<init>	()V
    //   136: invokevirtual 821	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 817	SummaryCard/RespHead
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +991 -> 1135
    //   147: aload_2
    //   148: getfield 824	SummaryCard/RespHead:iResult	I
    //   151: ifne +984 -> 1135
    //   154: iconst_1
    //   155: istore 24
    //   157: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +44 -> 204
    //   163: new 73	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 826
    //   173: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: astore 5
    //   178: aload_2
    //   179: ifnonnull +962 -> 1141
    //   182: ldc_w 828
    //   185: astore 4
    //   187: ldc_w 794
    //   190: iconst_2
    //   191: aload 5
    //   193: aload 4
    //   195: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_1
    //   205: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   208: ldc_w 833
    //   211: invokevirtual 366	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   214: istore 11
    //   216: iload 24
    //   218: ifeq +2747 -> 2965
    //   221: aload_3
    //   222: checkcast 810	SummaryCard/RespSummaryCard
    //   225: astore 6
    //   227: aload_0
    //   228: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: invokevirtual 836	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   234: invokevirtual 276	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   237: astore 4
    //   239: aload 4
    //   241: invokevirtual 839	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   244: astore 5
    //   246: aload 5
    //   248: invokevirtual 842	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   251: aload_1
    //   252: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   255: ldc_w 844
    //   258: lconst_0
    //   259: invokevirtual 847	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   262: lstore 20
    //   264: aconst_null
    //   265: astore_1
    //   266: lload 20
    //   268: lconst_0
    //   269: lcmp
    //   270: ifle +30 -> 300
    //   273: aload 4
    //   275: ldc_w 429
    //   278: ldc_w 849
    //   281: iconst_1
    //   282: anewarray 433	java/lang/String
    //   285: dup
    //   286: iconst_0
    //   287: lload 20
    //   289: invokestatic 852	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   292: aastore
    //   293: invokevirtual 436	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   296: checkcast 429	com/tencent/mobileqq/data/NearbyPeopleCard
    //   299: astore_1
    //   300: aload_1
    //   301: astore_3
    //   302: aload_1
    //   303: ifnonnull +45 -> 348
    //   306: aload_1
    //   307: astore_3
    //   308: aload 6
    //   310: getfield 855	SummaryCard/RespSummaryCard:lUIN	J
    //   313: lconst_0
    //   314: lcmp
    //   315: ifle +33 -> 348
    //   318: aload 4
    //   320: ldc_w 429
    //   323: ldc_w 431
    //   326: iconst_1
    //   327: anewarray 433	java/lang/String
    //   330: dup
    //   331: iconst_0
    //   332: aload 6
    //   334: getfield 855	SummaryCard/RespSummaryCard:lUIN	J
    //   337: invokestatic 852	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   340: aastore
    //   341: invokevirtual 436	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   344: checkcast 429	com/tencent/mobileqq/data/NearbyPeopleCard
    //   347: astore_3
    //   348: aload_3
    //   349: ifnonnull +841 -> 1190
    //   352: new 429	com/tencent/mobileqq/data/NearbyPeopleCard
    //   355: dup
    //   356: invokespecial 437	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   359: astore_3
    //   360: aload 6
    //   362: getfield 859	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   365: astore_1
    //   366: aload_3
    //   367: aload 6
    //   369: getfield 855	SummaryCard/RespSummaryCard:lUIN	J
    //   372: invokestatic 852	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   375: putfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   378: lload 20
    //   380: lconst_0
    //   381: lcmp
    //   382: ifle +843 -> 1225
    //   385: aload_3
    //   386: lload 20
    //   388: putfield 861	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   391: iload 11
    //   393: ifeq +20 -> 413
    //   396: aload_3
    //   397: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   400: aload_0
    //   401: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   404: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   407: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   410: ifeq +826 -> 1236
    //   413: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq +48 -> 464
    //   419: ldc_w 794
    //   422: iconst_2
    //   423: new 73	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 866
    //   433: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 6
    //   438: getfield 869	SummaryCard/RespSummaryCard:iVoteCount	I
    //   441: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 871
    //   447: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 6
    //   452: getfield 874	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   455: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_3
    //   465: aload 6
    //   467: getfield 869	SummaryCard/RespSummaryCard:iVoteCount	I
    //   470: putfield 877	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   473: aload_3
    //   474: aload 6
    //   476: getfield 874	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   479: putfield 880	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   482: aload_3
    //   483: aload 6
    //   485: getfield 883	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   488: putfield 504	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   491: aload_3
    //   492: aload 6
    //   494: getfield 886	SummaryCard/RespSummaryCard:vRichSign	[B
    //   497: putfield 499	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   500: aload_3
    //   501: aload_1
    //   502: getfield 891	SummaryCard/DateCard:bMarriage	B
    //   505: putfield 514	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   508: aload_3
    //   509: aload 6
    //   511: getfield 894	SummaryCard/RespSummaryCard:bSex	B
    //   514: putfield 519	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   517: aload_3
    //   518: aload 6
    //   520: getfield 897	SummaryCard/RespSummaryCard:bAge	B
    //   523: putfield 536	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   526: aload_3
    //   527: aload 6
    //   529: getfield 900	SummaryCard/RespSummaryCard:iBirthday	I
    //   532: putfield 532	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   535: aload_3
    //   536: aload_1
    //   537: getfield 903	SummaryCard/DateCard:uProfession	J
    //   540: l2i
    //   541: putfield 548	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   544: aload_3
    //   545: aload_1
    //   546: getfield 906	SummaryCard/DateCard:bConstellation	B
    //   549: putfield 541	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   552: aload_3
    //   553: aload_1
    //   554: getfield 909	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   557: putfield 912	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   560: aload_3
    //   561: aload_1
    //   562: getfield 915	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   565: putfield 918	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   568: aload_3
    //   569: aload 6
    //   571: getfield 921	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   574: putfield 924	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   577: aload_3
    //   578: aload_1
    //   579: getfield 927	SummaryCard/DateCard:vDateInfo	[B
    //   582: putfield 930	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   585: aload_3
    //   586: aload_1
    //   587: getfield 933	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   590: putfield 552	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   593: aload_3
    //   594: aload_1
    //   595: getfield 936	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   598: putfield 556	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   601: aload_3
    //   602: aload_1
    //   603: getfield 939	SummaryCard/DateCard:uHomeCountry	J
    //   606: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   609: putfield 567	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   612: aload_3
    //   613: aload_1
    //   614: getfield 946	SummaryCard/DateCard:uHomeProvince	J
    //   617: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   620: putfield 570	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   623: aload_3
    //   624: aload_1
    //   625: getfield 949	SummaryCard/DateCard:uHomeCity	J
    //   628: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   631: putfield 573	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   634: aload_3
    //   635: aload_1
    //   636: getfield 952	SummaryCard/DateCard:uHomeZone	J
    //   639: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   642: putfield 576	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   645: aload_3
    //   646: aload 6
    //   648: getfield 955	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   651: putfield 958	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   654: aload_3
    //   655: aload 6
    //   657: getfield 961	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   660: putfield 964	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   663: aload_3
    //   664: aload 6
    //   666: getfield 967	SummaryCard/RespSummaryCard:ulShowControl	J
    //   669: putfield 970	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   672: aload_3
    //   673: aload 6
    //   675: getfield 973	SummaryCard/RespSummaryCard:lUserFlag	J
    //   678: putfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   681: aload_3
    //   682: aload 6
    //   684: getfield 979	SummaryCard/RespSummaryCard:vSeed	[B
    //   687: putfield 980	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   690: aload_3
    //   691: aload 6
    //   693: getfield 983	SummaryCard/RespSummaryCard:lCacheControl	J
    //   696: invokevirtual 987	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   699: aload_3
    //   700: invokestatic 804	java/lang/System:currentTimeMillis	()J
    //   703: putfield 990	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   706: aload_3
    //   707: iload 11
    //   709: putfield 993	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   712: aload_3
    //   713: aload 6
    //   715: getfield 996	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   718: putfield 997	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   721: aload_3
    //   722: aload_1
    //   723: getfield 1000	SummaryCard/DateCard:uSchoolId	J
    //   726: putfield 1003	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   729: invokestatic 789	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   732: ifeq +33 -> 765
    //   735: ldc_w 794
    //   738: iconst_4
    //   739: new 73	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 1005
    //   749: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_1
    //   753: getfield 1000	SummaryCard/DateCard:uSchoolId	J
    //   756: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   759: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_3
    //   766: aload 6
    //   768: getfield 1008	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   771: putfield 1009	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   774: aload_3
    //   775: aload 6
    //   777: getfield 1013	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   780: putfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   783: aload_3
    //   784: aload 6
    //   786: getfield 1017	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   789: putfield 1018	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   792: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   795: ifeq +61 -> 856
    //   798: ldc 10
    //   800: iconst_2
    //   801: new 73	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   808: ldc_w 1020
    //   811: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload 6
    //   816: getfield 1008	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   819: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: ldc_w 1022
    //   825: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 6
    //   830: getfield 1013	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   833: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   836: ldc_w 1024
    //   839: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: aload 6
    //   844: getfield 1017	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   847: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   850: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: aload 6
    //   858: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   861: ifnull +54 -> 915
    //   864: aload_3
    //   865: aload 6
    //   867: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   870: getfield 1033	SummaryCard/PanSocialInfo:uCharm	J
    //   873: putfield 1036	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   876: aload_3
    //   877: aload 6
    //   879: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   882: getfield 1039	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   885: l2i
    //   886: putfield 1042	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   889: aload_3
    //   890: aload 6
    //   892: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   895: getfield 1045	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   898: l2i
    //   899: putfield 1048	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   902: aload_3
    //   903: aload 6
    //   905: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   908: getfield 1051	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   911: l2i
    //   912: putfield 1054	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   915: iload 11
    //   917: ifeq +20 -> 937
    //   920: aload_3
    //   921: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   924: aload_0
    //   925: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   928: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   931: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   934: ifeq +323 -> 1257
    //   937: iconst_1
    //   938: istore 25
    //   940: aload_3
    //   941: aload_1
    //   942: getfield 1057	SummaryCard/DateCard:vFaces	[B
    //   945: aload 6
    //   947: getfield 1061	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   950: iload 25
    //   952: invokevirtual 1065	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   955: pop
    //   956: aload_3
    //   957: aload 6
    //   959: getfield 1069	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   962: getfield 1074	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   965: putfield 1075	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   968: aload 6
    //   970: getfield 1078	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   973: ifne +290 -> 1263
    //   976: aload_3
    //   977: iconst_1
    //   978: putfield 1081	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   981: aload_2
    //   982: ifnull +11 -> 993
    //   985: aload_3
    //   986: aload_2
    //   987: getfield 1084	SummaryCard/RespHead:vCookies	[B
    //   990: putfield 1085	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   993: aload_3
    //   994: getfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   997: ldc2_w 1086
    //   1000: land
    //   1001: lconst_0
    //   1002: lcmp
    //   1003: ifeq +268 -> 1271
    //   1006: aload_3
    //   1007: iconst_1
    //   1008: putfield 585	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1011: aload_3
    //   1012: getfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1015: ldc2_w 1088
    //   1018: land
    //   1019: lconst_0
    //   1020: lcmp
    //   1021: ifeq +258 -> 1279
    //   1024: aload_3
    //   1025: iconst_1
    //   1026: putfield 590	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1029: aload_3
    //   1030: invokevirtual 1092	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1033: ifne +310 -> 1343
    //   1036: aload_3
    //   1037: ldc -18
    //   1039: putfield 1095	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1042: aload_3
    //   1043: ldc -18
    //   1045: putfield 1098	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1048: aload_3
    //   1049: ldc -18
    //   1051: putfield 1101	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1054: aload 6
    //   1056: getfield 1105	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1059: astore_1
    //   1060: aload_1
    //   1061: ifnull +282 -> 1343
    //   1064: aload_1
    //   1065: getfield 1111	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1068: ifnull +275 -> 1343
    //   1071: aload_1
    //   1072: getfield 1111	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1075: invokevirtual 1112	java/util/ArrayList:size	()I
    //   1078: ifle +265 -> 1343
    //   1081: iconst_0
    //   1082: istore 8
    //   1084: iload 8
    //   1086: aload_1
    //   1087: getfield 1111	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1090: invokevirtual 1112	java/util/ArrayList:size	()I
    //   1093: if_icmpge +250 -> 1343
    //   1096: iload 8
    //   1098: ifne +189 -> 1287
    //   1101: aload_3
    //   1102: aload_1
    //   1103: getfield 1111	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1106: iload 8
    //   1108: invokevirtual 1113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1111: checkcast 1115	SummaryCard/PhotoInfo
    //   1114: getfield 1118	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1117: putfield 1095	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1120: iload 8
    //   1122: iconst_1
    //   1123: iadd
    //   1124: istore 8
    //   1126: goto -42 -> 1084
    //   1129: iconst_0
    //   1130: istore 24
    //   1132: goto -1016 -> 116
    //   1135: iconst_0
    //   1136: istore 24
    //   1138: goto -981 -> 157
    //   1141: aload_2
    //   1142: getfield 824	SummaryCard/RespHead:iResult	I
    //   1145: istore 8
    //   1147: iload 8
    //   1149: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: astore 4
    //   1154: goto -967 -> 187
    //   1157: astore 5
    //   1159: aload 4
    //   1161: astore_2
    //   1162: aload 5
    //   1164: astore 4
    //   1166: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1169: ifeq +15 -> 1184
    //   1172: ldc_w 794
    //   1175: iconst_2
    //   1176: aload 4
    //   1178: invokevirtual 1119	java/lang/Exception:toString	()Ljava/lang/String;
    //   1181: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1184: iconst_0
    //   1185: istore 24
    //   1187: goto -983 -> 204
    //   1190: aload_3
    //   1191: invokevirtual 598	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1194: istore 8
    //   1196: aload_3
    //   1197: invokevirtual 1122	com/tencent/mobileqq/data/NearbyPeopleCard:getId	()J
    //   1200: lstore 22
    //   1202: new 429	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1205: dup
    //   1206: invokespecial 437	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1209: astore_3
    //   1210: aload_3
    //   1211: iload 8
    //   1213: invokevirtual 1125	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1216: aload_3
    //   1217: lload 22
    //   1219: invokevirtual 1128	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1222: goto -862 -> 360
    //   1225: aload_3
    //   1226: aload_1
    //   1227: getfield 1131	SummaryCard/DateCard:lTinyId	J
    //   1230: putfield 861	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1233: goto -842 -> 391
    //   1236: aload_3
    //   1237: aload 6
    //   1239: getfield 869	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1242: putfield 877	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1245: aload_3
    //   1246: aload 6
    //   1248: getfield 874	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1251: putfield 880	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1254: goto -772 -> 482
    //   1257: iconst_0
    //   1258: istore 25
    //   1260: goto -320 -> 940
    //   1263: aload_3
    //   1264: iconst_0
    //   1265: putfield 1081	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1268: goto -287 -> 981
    //   1271: aload_3
    //   1272: iconst_0
    //   1273: putfield 585	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1276: goto -265 -> 1011
    //   1279: aload_3
    //   1280: iconst_0
    //   1281: putfield 590	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1284: goto -255 -> 1029
    //   1287: iload 8
    //   1289: iconst_1
    //   1290: if_icmpne +25 -> 1315
    //   1293: aload_3
    //   1294: aload_1
    //   1295: getfield 1111	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1298: iload 8
    //   1300: invokevirtual 1113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1303: checkcast 1115	SummaryCard/PhotoInfo
    //   1306: getfield 1118	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1309: putfield 1098	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1312: goto -192 -> 1120
    //   1315: iload 8
    //   1317: iconst_2
    //   1318: if_icmpne -198 -> 1120
    //   1321: aload_3
    //   1322: aload_1
    //   1323: getfield 1111	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1326: iload 8
    //   1328: invokevirtual 1113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1331: checkcast 1115	SummaryCard/PhotoInfo
    //   1334: getfield 1118	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1337: putfield 1101	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1340: goto -220 -> 1120
    //   1343: aload 6
    //   1345: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1348: astore_1
    //   1349: aload_1
    //   1350: ifnull +17 -> 1367
    //   1353: aload_1
    //   1354: getfield 1134	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1357: lconst_1
    //   1358: lcmp
    //   1359: ifne +143 -> 1502
    //   1362: aload_3
    //   1363: iconst_1
    //   1364: putfield 449	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1367: aload 6
    //   1369: getfield 1137	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1372: ifnull +29 -> 1401
    //   1375: aload_3
    //   1376: aload_0
    //   1377: aload 6
    //   1379: getfield 1137	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1382: ldc_w 1139
    //   1385: new 1141	GameCenter/RespLastGameInfo
    //   1388: dup
    //   1389: invokespecial 1142	GameCenter/RespLastGameInfo:<init>	()V
    //   1392: invokevirtual 821	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1395: checkcast 1141	GameCenter/RespLastGameInfo
    //   1398: invokevirtual 1146	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1401: aload 6
    //   1403: getfield 1028	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1406: astore_1
    //   1407: aload_1
    //   1408: ifnull +12 -> 1420
    //   1411: aload_3
    //   1412: aload_1
    //   1413: getfield 1149	SummaryCard/PanSocialInfo:uChatflag	J
    //   1416: l2i
    //   1417: putfield 1152	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1420: new 166	java/util/ArrayList
    //   1423: dup
    //   1424: invokespecial 167	java/util/ArrayList:<init>	()V
    //   1427: astore_1
    //   1428: aload 6
    //   1430: getfield 1155	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1433: ifnull +387 -> 1820
    //   1436: aload 6
    //   1438: getfield 1155	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1441: invokevirtual 1112	java/util/ArrayList:size	()I
    //   1444: ifle +376 -> 1820
    //   1447: iconst_0
    //   1448: istore 8
    //   1450: iload 8
    //   1452: aload 6
    //   1454: getfield 1155	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1457: invokevirtual 1112	java/util/ArrayList:size	()I
    //   1460: if_icmpge +360 -> 1820
    //   1463: aload 6
    //   1465: getfield 1155	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   1468: iload 8
    //   1470: invokevirtual 1113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1473: checkcast 657	[B
    //   1476: astore 7
    //   1478: aload 7
    //   1480: ifnonnull +30 -> 1510
    //   1483: iconst_0
    //   1484: istore 9
    //   1486: iload 9
    //   1488: bipush 10
    //   1490: if_icmpgt +28 -> 1518
    //   1493: iload 8
    //   1495: iconst_1
    //   1496: iadd
    //   1497: istore 8
    //   1499: goto -49 -> 1450
    //   1502: aload_3
    //   1503: iconst_0
    //   1504: putfield 449	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1507: goto -140 -> 1367
    //   1510: aload 7
    //   1512: arraylength
    //   1513: istore 9
    //   1515: goto -29 -> 1486
    //   1518: aload 7
    //   1520: iconst_1
    //   1521: invokestatic 1160	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   1524: l2i
    //   1525: istore 12
    //   1527: aload 7
    //   1529: iconst_5
    //   1530: invokestatic 1160	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   1533: l2i
    //   1534: istore 13
    //   1536: iload 12
    //   1538: ifle -45 -> 1493
    //   1541: iload 12
    //   1543: bipush 9
    //   1545: iadd
    //   1546: iload 9
    //   1548: if_icmpge -55 -> 1493
    //   1551: iload 12
    //   1553: newarray <illegal type>
    //   1555: astore_2
    //   1556: aload_2
    //   1557: iconst_0
    //   1558: aload 7
    //   1560: bipush 9
    //   1562: iload 12
    //   1564: invokestatic 1163	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   1567: new 1165	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1570: dup
    //   1571: invokespecial 1166	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1574: astore 7
    //   1576: aload 7
    //   1578: aload_2
    //   1579: invokevirtual 1167	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1582: pop
    //   1583: aload 7
    //   1585: getfield 1171	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1588: invokevirtual 1174	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1591: istore 9
    //   1593: iload 9
    //   1595: ifne +157 -> 1752
    //   1598: new 1176	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   1601: dup
    //   1602: invokespecial 1177	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   1605: astore_2
    //   1606: aload_2
    //   1607: aload 7
    //   1609: getfield 1180	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1612: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1615: putfield 1182	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   1618: aload 7
    //   1620: getfield 1186	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1623: ifnull +102 -> 1725
    //   1626: aload_2
    //   1627: aload 7
    //   1629: getfield 1186	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1632: getfield 1191	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1635: invokevirtual 395	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1638: putfield 1193	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1641: aload_2
    //   1642: aload 7
    //   1644: getfield 1186	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1647: getfield 1196	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1650: invokevirtual 395	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1653: putfield 1198	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   1656: aload_2
    //   1657: aload 7
    //   1659: getfield 1186	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1662: getfield 1201	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1665: invokevirtual 395	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1668: putfield 1203	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   1671: aload_2
    //   1672: aload 7
    //   1674: getfield 1186	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   1677: getfield 1206	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1680: invokevirtual 395	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1683: putfield 1208	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   1686: aload_2
    //   1687: invokevirtual 1210	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   1690: ifne -197 -> 1493
    //   1693: aload_1
    //   1694: aload_2
    //   1695: invokeinterface 201 2 0
    //   1700: pop
    //   1701: goto -208 -> 1493
    //   1704: astore_2
    //   1705: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1708: ifeq -215 -> 1493
    //   1711: ldc_w 794
    //   1714: iconst_2
    //   1715: aload_2
    //   1716: invokevirtual 1119	java/lang/Exception:toString	()Ljava/lang/String;
    //   1719: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1722: goto -229 -> 1493
    //   1725: aload_2
    //   1726: ldc -18
    //   1728: putfield 1193	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1731: aload_2
    //   1732: ldc -18
    //   1734: putfield 1198	com/tencent/mobileqq/profile/ProfileBusiEntry:b	Ljava/lang/String;
    //   1737: aload_2
    //   1738: ldc -18
    //   1740: putfield 1203	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   1743: aload_2
    //   1744: ldc -18
    //   1746: putfield 1208	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   1749: goto -63 -> 1686
    //   1752: invokestatic 789	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1755: ifeq -262 -> 1493
    //   1758: ldc_w 794
    //   1761: iconst_4
    //   1762: new 73	java/lang/StringBuilder
    //   1765: dup
    //   1766: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   1769: ldc_w 1212
    //   1772: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: aload 7
    //   1777: getfield 1180	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1780: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1783: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1786: ldc_w 1214
    //   1789: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: iload 9
    //   1794: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1797: ldc_w 1214
    //   1800: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: aload 7
    //   1805: getfield 1217	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1808: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1811: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1814: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1817: goto -324 -> 1493
    //   1820: aload_3
    //   1821: aload_1
    //   1822: invokevirtual 1221	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   1825: aload 6
    //   1827: getfield 1225	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   1830: ifnonnull +172 -> 2002
    //   1833: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1836: ifeq +13 -> 1849
    //   1839: ldc_w 794
    //   1842: iconst_2
    //   1843: ldc_w 1227
    //   1846: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1849: aload 6
    //   1851: getfield 1231	SummaryCard/RespSummaryCard:stUserFeed	LSummaryCard/UserFeed;
    //   1854: ifnull +237 -> 2091
    //   1857: aload 6
    //   1859: getfield 1231	SummaryCard/RespSummaryCard:stUserFeed	LSummaryCard/UserFeed;
    //   1862: getfield 1236	SummaryCard/UserFeed:uFlag	J
    //   1865: lstore 20
    //   1867: new 1238	appoint/define/appoint_define$FeedInfo
    //   1870: dup
    //   1871: invokespecial 1239	appoint/define/appoint_define$FeedInfo:<init>	()V
    //   1874: astore_1
    //   1875: aload_1
    //   1876: aload 6
    //   1878: getfield 1231	SummaryCard/RespSummaryCard:stUserFeed	LSummaryCard/UserFeed;
    //   1881: getfield 1242	SummaryCard/UserFeed:vFeedInfo	[B
    //   1884: invokevirtual 1243	appoint/define/appoint_define$FeedInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1887: pop
    //   1888: aload_3
    //   1889: aload_1
    //   1890: invokevirtual 1247	com/tencent/mobileqq/data/NearbyPeopleCard:updateFreshNewsInfo	(Lappoint/define/appoint_define$FeedInfo;)V
    //   1893: aload 6
    //   1895: getfield 1250	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   1898: ifnull +736 -> 2634
    //   1901: new 1252	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   1904: dup
    //   1905: invokespecial 1253	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   1908: astore_1
    //   1909: aload_1
    //   1910: aload 6
    //   1912: getfield 1250	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   1915: invokevirtual 1254	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1918: pop
    //   1919: aload_1
    //   1920: ifnull +1067 -> 2987
    //   1923: aload_1
    //   1924: getfield 1257	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1927: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1930: astore_1
    //   1931: new 166	java/util/ArrayList
    //   1934: dup
    //   1935: invokespecial 167	java/util/ArrayList:<init>	()V
    //   1938: astore_2
    //   1939: aload_1
    //   1940: ifnull +197 -> 2137
    //   1943: aload_1
    //   1944: invokeinterface 181 1 0
    //   1949: astore_1
    //   1950: aload_1
    //   1951: invokeinterface 186 1 0
    //   1956: ifeq +181 -> 2137
    //   1959: aload_1
    //   1960: invokeinterface 190 1 0
    //   1965: checkcast 1259	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   1968: astore 7
    //   1970: aload 7
    //   1972: getfield 1262	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1975: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1978: iconst_1
    //   1979: if_icmpne +152 -> 2131
    //   1982: iconst_1
    //   1983: istore 25
    //   1985: aload_2
    //   1986: aload 7
    //   1988: iload 25
    //   1990: invokestatic 1268	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   1993: invokeinterface 201 2 0
    //   1998: pop
    //   1999: goto -49 -> 1950
    //   2002: aload 6
    //   2004: getfield 1225	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2007: getfield 1271	SummaryCard/InterestTagInfo:uFlag	J
    //   2010: lstore 20
    //   2012: new 1273	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   2015: dup
    //   2016: invokespecial 1274	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   2019: astore_1
    //   2020: aload_1
    //   2021: aload 6
    //   2023: getfield 1225	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2026: getfield 1277	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   2029: invokevirtual 1278	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2032: pop
    //   2033: aload_3
    //   2034: lload 20
    //   2036: aload_1
    //   2037: getfield 1281	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2040: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2043: invokevirtual 493	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   2046: goto -197 -> 1849
    //   2049: astore_1
    //   2050: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2053: ifeq -204 -> 1849
    //   2056: ldc_w 1283
    //   2059: iconst_2
    //   2060: aload_1
    //   2061: invokevirtual 1119	java/lang/Exception:toString	()Ljava/lang/String;
    //   2064: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2067: goto -218 -> 1849
    //   2070: astore_1
    //   2071: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2074: ifeq -181 -> 1893
    //   2077: ldc_w 794
    //   2080: iconst_2
    //   2081: aload_1
    //   2082: invokevirtual 1119	java/lang/Exception:toString	()Ljava/lang/String;
    //   2085: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2088: goto -195 -> 1893
    //   2091: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2094: ifeq -201 -> 1893
    //   2097: ldc_w 794
    //   2100: iconst_2
    //   2101: ldc_w 1285
    //   2104: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2107: goto -214 -> 1893
    //   2110: astore_2
    //   2111: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2114: ifeq -195 -> 1919
    //   2117: ldc_w 794
    //   2120: iconst_2
    //   2121: aload_2
    //   2122: invokevirtual 1119	java/lang/Exception:toString	()Ljava/lang/String;
    //   2125: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2128: goto -209 -> 1919
    //   2131: iconst_0
    //   2132: istore 25
    //   2134: goto -149 -> 1985
    //   2137: aload_2
    //   2138: invokeinterface 177 1 0
    //   2143: ifle +844 -> 2987
    //   2146: iconst_0
    //   2147: istore 8
    //   2149: iload 8
    //   2151: aload_2
    //   2152: invokeinterface 177 1 0
    //   2157: if_icmpge +830 -> 2987
    //   2160: aload_2
    //   2161: iload 8
    //   2163: invokeinterface 232 2 0
    //   2168: checkcast 1264	com/tencent/mobileqq/data/HotChatInfo
    //   2171: astore_1
    //   2172: aload_1
    //   2173: ifnull +452 -> 2625
    //   2176: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2179: ifeq +30 -> 2209
    //   2182: ldc_w 794
    //   2185: iconst_2
    //   2186: new 73	java/lang/StringBuilder
    //   2189: dup
    //   2190: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   2193: ldc_w 1287
    //   2196: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: aload_1
    //   2200: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2203: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2206: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2209: aload_1
    //   2210: ifnull +8 -> 2218
    //   2213: aload_3
    //   2214: aload_1
    //   2215: invokevirtual 1291	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   2218: aload 6
    //   2220: getfield 1295	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   2223: ifnull +27 -> 2250
    //   2226: aload_3
    //   2227: aload 6
    //   2229: getfield 1295	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   2232: getfield 1300	SummaryCard/GiftInfo:uOpenFlag	J
    //   2235: putfield 595	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   2238: aload_3
    //   2239: aload 6
    //   2241: getfield 1295	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   2244: getfield 1301	SummaryCard/GiftInfo:vGiftInfo	[B
    //   2247: putfield 1302	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   2250: aload_0
    //   2251: bipush 51
    //   2253: iconst_1
    //   2254: aload_3
    //   2255: iload 26
    //   2257: invokevirtual 1305	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;Z)V
    //   2260: aload_0
    //   2261: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2264: bipush 105
    //   2266: invokevirtual 523	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2269: checkcast 525	com/tencent/mobileqq/nearby/NearbyCardManager
    //   2272: aload_3
    //   2273: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2276: invokestatic 413	android/os/SystemClock:elapsedRealtime	()J
    //   2279: invokevirtual 1308	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   2282: invokestatic 789	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2285: ifeq +45 -> 2330
    //   2288: ldc_w 374
    //   2291: iconst_4
    //   2292: new 73	java/lang/StringBuilder
    //   2295: dup
    //   2296: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   2299: ldc_w 1310
    //   2302: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: aload_3
    //   2306: getfield 861	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   2309: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2312: ldc_w 1312
    //   2315: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2318: invokestatic 413	android/os/SystemClock:elapsedRealtime	()J
    //   2321: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2324: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2327: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2330: aload_0
    //   2331: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2334: bipush 50
    //   2336: invokevirtual 523	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2339: checkcast 1314	com/tencent/mobileqq/app/FriendsManager
    //   2342: astore_1
    //   2343: invokestatic 1316	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   2346: ifeq +54 -> 2400
    //   2349: ldc 10
    //   2351: iconst_5
    //   2352: anewarray 103	java/lang/Object
    //   2355: dup
    //   2356: iconst_0
    //   2357: ldc_w 1318
    //   2360: aastore
    //   2361: dup
    //   2362: iconst_1
    //   2363: iload 11
    //   2365: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2368: aastore
    //   2369: dup
    //   2370: iconst_2
    //   2371: aload_3
    //   2372: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2375: aastore
    //   2376: dup
    //   2377: iconst_3
    //   2378: aload_0
    //   2379: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2382: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2385: aastore
    //   2386: dup
    //   2387: iconst_4
    //   2388: aload 6
    //   2390: getfield 855	SummaryCard/RespSummaryCard:lUIN	J
    //   2393: invokestatic 1323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2396: aastore
    //   2397: invokestatic 1326	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2400: iload 11
    //   2402: ifeq +20 -> 2422
    //   2405: aload_3
    //   2406: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2409: aload_0
    //   2410: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2413: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2416: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2419: ifeq +72 -> 2491
    //   2422: aload_1
    //   2423: aload_3
    //   2424: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2427: invokevirtual 1329	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2430: astore_2
    //   2431: aload_2
    //   2432: aload_3
    //   2433: getfield 880	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   2436: putfield 1334	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2439: aload_2
    //   2440: aload_3
    //   2441: getfield 877	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   2444: i2l
    //   2445: putfield 1337	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2448: aload_0
    //   2449: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2452: invokevirtual 267	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2455: aload_2
    //   2456: getfield 1337	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2459: aload_2
    //   2460: getfield 1334	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2463: invokestatic 1340	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   2466: pop
    //   2467: aload_1
    //   2468: aload_2
    //   2469: invokevirtual 1343	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   2472: pop
    //   2473: aload_0
    //   2474: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2477: invokevirtual 267	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2480: ldc_w 558
    //   2483: aload_3
    //   2484: getfield 556	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   2487: invokestatic 472	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   2490: pop
    //   2491: aload_0
    //   2492: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2495: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2498: aload_3
    //   2499: getfield 440	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2502: invokevirtual 864	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2505: ifeq +29 -> 2534
    //   2508: aload_3
    //   2509: getfield 1042	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   2512: ifle +22 -> 2534
    //   2515: aload_0
    //   2516: getfield 262	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2519: bipush 59
    //   2521: invokevirtual 523	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2524: checkcast 1345	com/tencent/mobileqq/app/HotChatManager
    //   2527: aload_3
    //   2528: getfield 1042	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   2531: invokevirtual 1346	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   2534: aload_1
    //   2535: aload_3
    //   2536: invokevirtual 1349	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   2539: aload_3
    //   2540: invokevirtual 598	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2543: sipush 1000
    //   2546: if_icmpne +362 -> 2908
    //   2549: aload 4
    //   2551: iconst_0
    //   2552: ldc_w 429
    //   2555: invokevirtual 293	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2558: aconst_null
    //   2559: aconst_null
    //   2560: aconst_null
    //   2561: aconst_null
    //   2562: aconst_null
    //   2563: aconst_null
    //   2564: aconst_null
    //   2565: invokevirtual 1352	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2568: astore_2
    //   2569: aload_2
    //   2570: ifnull +213 -> 2783
    //   2573: aload_2
    //   2574: astore_1
    //   2575: aload_2
    //   2576: invokeinterface 1357 1 0
    //   2581: istore 8
    //   2583: aload_2
    //   2584: astore_1
    //   2585: aload_2
    //   2586: invokeinterface 1360 1 0
    //   2591: pop
    //   2592: iload 8
    //   2594: sipush 200
    //   2597: if_icmple +186 -> 2783
    //   2600: iload 8
    //   2602: bipush 100
    //   2604: if_icmple +57 -> 2661
    //   2607: aload_2
    //   2608: astore_1
    //   2609: aload_2
    //   2610: invokeinterface 1363 1 0
    //   2615: pop
    //   2616: iload 8
    //   2618: iconst_1
    //   2619: isub
    //   2620: istore 8
    //   2622: goto -22 -> 2600
    //   2625: iload 8
    //   2627: iconst_1
    //   2628: iadd
    //   2629: istore 8
    //   2631: goto -482 -> 2149
    //   2634: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2637: ifeq -419 -> 2218
    //   2640: ldc_w 794
    //   2643: iconst_2
    //   2644: ldc_w 1365
    //   2647: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2650: goto -432 -> 2218
    //   2653: astore_2
    //   2654: aload_2
    //   2655: invokevirtual 790	java/lang/Exception:printStackTrace	()V
    //   2658: goto -167 -> 2491
    //   2661: aload_2
    //   2662: astore_1
    //   2663: aload_2
    //   2664: aload_2
    //   2665: ldc_w 1367
    //   2668: invokeinterface 1370 2 0
    //   2673: invokeinterface 1373 2 0
    //   2678: istore 8
    //   2680: aload_2
    //   2681: astore_1
    //   2682: new 73	java/lang/StringBuilder
    //   2685: dup
    //   2686: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   2689: astore 6
    //   2691: aload_2
    //   2692: astore_1
    //   2693: aload 6
    //   2695: ldc_w 1375
    //   2698: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2701: pop
    //   2702: aload_2
    //   2703: astore_1
    //   2704: aload 6
    //   2706: ldc_w 429
    //   2709: invokevirtual 293	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2712: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2715: pop
    //   2716: aload_2
    //   2717: astore_1
    //   2718: aload 6
    //   2720: ldc_w 1377
    //   2723: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: pop
    //   2727: aload_2
    //   2728: astore_1
    //   2729: aload 6
    //   2731: ldc_w 1367
    //   2734: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: pop
    //   2738: aload_2
    //   2739: astore_1
    //   2740: aload 6
    //   2742: ldc_w 1379
    //   2745: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2748: pop
    //   2749: aload_2
    //   2750: astore_1
    //   2751: aload 6
    //   2753: iload 8
    //   2755: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2758: pop
    //   2759: aload_2
    //   2760: astore_1
    //   2761: aload 6
    //   2763: ldc_w 299
    //   2766: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: pop
    //   2770: aload_2
    //   2771: astore_1
    //   2772: aload 4
    //   2774: aload 6
    //   2776: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2779: invokevirtual 304	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   2782: pop
    //   2783: aload_2
    //   2784: astore_1
    //   2785: aload 4
    //   2787: aload_3
    //   2788: invokevirtual 600	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   2791: aload_2
    //   2792: astore_1
    //   2793: aload 5
    //   2795: invokevirtual 1381	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   2798: aload_2
    //   2799: ifnull +9 -> 2808
    //   2802: aload_2
    //   2803: invokeinterface 1384 1 0
    //   2808: aload 5
    //   2810: invokevirtual 1386	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   2813: aload 4
    //   2815: invokevirtual 372	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   2818: new 602	java/util/HashMap
    //   2821: dup
    //   2822: invokespecial 603	java/util/HashMap:<init>	()V
    //   2825: astore_1
    //   2826: aload_1
    //   2827: ldc_w 605
    //   2830: iload 10
    //   2832: invokestatic 608	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2835: invokevirtual 612	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2838: pop
    //   2839: invokestatic 618	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2842: invokestatic 623	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2845: aload_0
    //   2846: getfield 626	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   2849: invokevirtual 629	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   2852: ldc_w 1388
    //   2855: iload 24
    //   2857: lload 18
    //   2859: lload 16
    //   2861: lsub
    //   2862: lconst_0
    //   2863: aload_1
    //   2864: ldc -18
    //   2866: invokevirtual 634	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2869: invokestatic 789	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2872: ifeq -2859 -> 13
    //   2875: ldc_w 794
    //   2878: iconst_4
    //   2879: new 73	java/lang/StringBuilder
    //   2882: dup
    //   2883: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   2886: ldc_w 1390
    //   2889: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2892: invokestatic 804	java/lang/System:currentTimeMillis	()J
    //   2895: lload 14
    //   2897: lsub
    //   2898: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2901: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2904: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2907: return
    //   2908: aload_3
    //   2909: invokevirtual 598	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2912: sipush 1001
    //   2915: if_icmpeq +13 -> 2928
    //   2918: aload_3
    //   2919: invokevirtual 598	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2922: sipush 1002
    //   2925: if_icmpne +10 -> 2935
    //   2928: aload 4
    //   2930: aload_3
    //   2931: invokevirtual 647	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   2934: pop
    //   2935: aconst_null
    //   2936: astore_2
    //   2937: goto -146 -> 2791
    //   2940: astore_2
    //   2941: aconst_null
    //   2942: astore_1
    //   2943: aload_1
    //   2944: ifnull +9 -> 2953
    //   2947: aload_1
    //   2948: invokeinterface 1384 1 0
    //   2953: aload 5
    //   2955: invokevirtual 1386	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   2958: aload 4
    //   2960: invokevirtual 372	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   2963: aload_2
    //   2964: athrow
    //   2965: aload_0
    //   2966: bipush 51
    //   2968: iconst_0
    //   2969: aconst_null
    //   2970: iload 26
    //   2972: invokevirtual 1305	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;Z)V
    //   2975: goto -157 -> 2818
    //   2978: astore_2
    //   2979: goto -36 -> 2943
    //   2982: astore 4
    //   2984: goto -1818 -> 1166
    //   2987: aconst_null
    //   2988: astore_1
    //   2989: goto -813 -> 2176
    //   2992: aconst_null
    //   2993: astore_2
    //   2994: goto -2790 -> 204
    //   2997: lconst_0
    //   2998: lstore 14
    //   3000: goto -2939 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3003	0	this	NearbyCardHandler
    //   0	3003	1	paramToServiceMsg	ToServiceMsg
    //   0	3003	2	paramFromServiceMsg	FromServiceMsg
    //   0	3003	3	paramObject	Object
    //   97	2862	4	localObject1	Object
    //   2982	1	4	localException1	Exception
    //   176	71	5	localObject2	Object
    //   1157	1797	5	localException2	Exception
    //   225	2550	6	localObject3	Object
    //   1476	511	7	localObject4	Object
    //   1082	1672	8	j	int
    //   1484	309	9	k	int
    //   94	2737	10	m	int
    //   214	2187	11	n	int
    //   1525	38	12	i1	int
    //   1534	1	13	i2	int
    //   59	2940	14	l1	long
    //   83	2777	16	l2	long
    //   88	2770	18	l3	long
    //   262	1773	20	l4	long
    //   1200	18	22	l5	long
    //   114	2742	24	bool1	boolean
    //   938	1195	25	bool2	boolean
    //   71	2900	26	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   121	143	1157	java/lang/Exception
    //   1576	1593	1704	java/lang/Exception
    //   1598	1686	1704	java/lang/Exception
    //   1686	1701	1704	java/lang/Exception
    //   1725	1749	1704	java/lang/Exception
    //   1752	1817	1704	java/lang/Exception
    //   2012	2046	2049	java/lang/Exception
    //   1867	1893	2070	java/lang/Exception
    //   1909	1919	2110	java/lang/Exception
    //   2473	2491	2653	java/lang/Exception
    //   2539	2569	2940	finally
    //   2908	2928	2940	finally
    //   2928	2935	2940	finally
    //   2575	2583	2978	finally
    //   2585	2592	2978	finally
    //   2609	2616	2978	finally
    //   2663	2680	2978	finally
    //   2682	2691	2978	finally
    //   2693	2702	2978	finally
    //   2704	2716	2978	finally
    //   2718	2727	2978	finally
    //   2729	2738	2978	finally
    //   2740	2749	2978	finally
    //   2751	2759	2978	finally
    //   2761	2770	2978	finally
    //   2772	2783	2978	finally
    //   2785	2791	2978	finally
    //   2793	2798	2978	finally
    //   147	154	2982	java/lang/Exception
    //   157	178	2982	java/lang/Exception
    //   187	204	2982	java/lang/Exception
    //   1141	1147	2982	java/lang/Exception
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool2 = bool4;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool2 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool1 = true;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool3 = bool1;
          }
        }
        bool1 = bool3;
        if (bool3) {}
        bool1 = bool3;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        try
        {
          NearbyCardManager.a(this.b);
          bool1 = bool3;
          a(46, bool1, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;) {}
        }
        paramToServiceMsg = paramToServiceMsg;
        bool3 = bool2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
        bool1 = bool3;
        continue;
        bool1 = false;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = (ToServiceMsg)localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = (ToServiceMsg)localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = (ToServiceMsg)localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = (ToServiceMsg)localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = (ToServiceMsg)localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = (ToServiceMsg)localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = (ToServiceMsg)localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = ((UpdatePhotoList.RspBody)paramObject).rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(((UpdatePhotoList.RspBody)paramObject).uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(((UpdatePhotoList.RspBody)paramObject).uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(((UpdatePhotoList.RspBody)paramObject).uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(((UpdatePhotoList.RspBody)paramObject).uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    a(48, bool1, localToServiceMsg);
  }
  
  /* Error */
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 10
    //   6: iconst_0
    //   7: istore 11
    //   9: iconst_0
    //   10: istore 6
    //   12: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 1429
    //   21: iconst_2
    //   22: new 73	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 1431
    //   32: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 123	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 668	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 4
    //   51: aconst_null
    //   52: astore 5
    //   54: aload 5
    //   56: astore_1
    //   57: iload 10
    //   59: istore 9
    //   61: aload_2
    //   62: invokevirtual 123	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 5
    //   70: astore_1
    //   71: iload 10
    //   73: istore 9
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 81	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 656	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 657	[B
    //   92: checkcast 657	[B
    //   95: invokevirtual 658	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 81	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 659	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 659	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 7
    //   125: iload 7
    //   127: ifne +406 -> 533
    //   130: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 1429
    //   139: iconst_2
    //   140: new 73	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1433
    //   150: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 659	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 8
    //   171: ifeq +349 -> 520
    //   174: new 1409	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 1410	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 85	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 91	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 97	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 1411	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 1409	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 103	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 1414	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 1417	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 1420	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 1423	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 1426	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 73	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 1435
    //   283: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 174	java/util/List
    //   299: astore_3
    //   300: iload 6
    //   302: aload_3
    //   303: invokeinterface 177 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 6
    //   314: invokeinterface 232 2 0
    //   319: checkcast 1437	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 4
    //   324: aload_2
    //   325: ldc_w 1439
    //   328: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 4
    //   333: getfield 1442	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 1444
    //   345: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 4
    //   350: getfield 1447	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 395	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1449
    //   362: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 4
    //   367: getfield 1452	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 112	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 1454
    //   379: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 6
    //   385: iconst_1
    //   386: iadd
    //   387: istore 6
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 1456
    //   396: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 1458
    //   408: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 1460
    //   420: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 1462
    //   432: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 831	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 1429
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 8
    //   455: istore 9
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 9
    //   462: aload_1
    //   463: invokevirtual 57	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 11
    //   470: istore 8
    //   472: aload 4
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 8
    //   479: istore 9
    //   481: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 1429
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 1400	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 8
    //   502: istore 9
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 4
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 8
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 8
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	NearbyCardHandler
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   49	460	4	localHeadInfo	tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo
    //   52	17	5	localObject	Object
    //   10	378	6	j	int
    //   123	3	7	k	int
    //   1	534	8	bool1	boolean
    //   59	444	9	bool2	boolean
    //   4	68	10	bool3	boolean
    //   7	462	11	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp))) {
      paramToServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
    }
    for (boolean bool = true;; bool = false)
    {
      a(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    paramFromServiceMsg = new Bundle();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int j = paramToServiceMsg.extraData.getInt("favoriteSource");
    int k = paramToServiceMsg.extraData.getInt("iCount");
    int m = paramToServiceMsg.extraData.getInt("from");
    paramFromServiceMsg.putString("targetUin", Long.toString(l1));
    paramFromServiceMsg.putString("selfUin", Long.toString(l2));
    paramFromServiceMsg.putInt("favoriteSource", j);
    paramFromServiceMsg.putInt("iCount", k);
    paramFromServiceMsg.putInt("from", m);
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)localObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        ((HashMap)paramObject).put("param_FailCode", "0");
      }
      for (;;)
      {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, (HashMap)paramObject, "", false);
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = this.b.a().createEntityManager();
          paramObject = (NearbyPeopleCard)paramToServiceMsg.a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            ((NearbyPeopleCard)paramObject).likeCount += k;
            ((NearbyPeopleCard)paramObject).bVoted = 1;
            ((NearbyPeopleCard)paramObject).bAvailVoteCnt = ((short)(((NearbyPeopleCard)paramObject).bAvailVoteCnt - k));
            if (((NearbyPeopleCard)paramObject).bAvailVoteCnt < 0) {
              ((NearbyPeopleCard)paramObject).bAvailVoteCnt = 0;
            }
            paramToServiceMsg.a((Entity)paramObject);
          }
          paramObject = (GodEntity)paramToServiceMsg.a(GodEntity.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            ((GodEntity)paramObject).praiseCount += k;
            ((GodEntity)paramObject).praiseflag = 1;
            paramToServiceMsg.a((Entity)paramObject);
          }
          VoteUtil.a(this.b, l1, k);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1 + "," + k);
        }
        a(32, bool1, paramFromServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        ((HashMap)paramObject).put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (localObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label588:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (localObject == null) {
        break label664;
      }
    }
    label664:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      ((HashMap)paramObject).put("param_FailCode", paramToServiceMsg);
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, (HashMap)paramObject, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label588;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyCardHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      if (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() != 4) {
        break;
      }
      a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  protected Class a()
  {
    return NearbyCardObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new Oidb_0x686.ReqBody();
    Object localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int j = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(j);
    j = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(j);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.d());
    localObject1 = a("OidbSvc.0x686");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "reqCharmEvent() uin=" + ((ToServiceMsg)localObject1).getUin() + ", type=" + paramInt + ", seqNum=" + j);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    NearbyCmdHelper.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2 + ",voteNum|" + paramInt2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    a(localToServiceMsg);
  }
  
  public void a(Bundle paramBundle, ArrayList paramArrayList, InterestTag[] paramArrayOfInterestTag, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "editProfileCard");
    }
    cmd0x9c9.ReqBody localReqBody = new cmd0x9c9.ReqBody();
    Object localObject2;
    Object localObject1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject2 = new UpdatePhotoList.ReqBody();
      Iterator localIterator = paramArrayList.iterator();
      for (paramBoolean3 = false; localIterator.hasNext(); paramBoolean3 = true)
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        if (localPicInfo.jdField_a_of_type_Int < 0) {
          break label2378;
        }
        localObject1 = new UpdatePhotoList.RichHead();
        ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(localPicInfo.f)) {
          ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.f);
        }
        if (localObject1 == null) {
          break label2375;
        }
        ((UpdatePhotoList.ReqBody)localObject2).rpt_msg_rich_headids.add((MessageMicro)localObject1);
      }
      label154:
      if (paramBoolean3)
      {
        localObject1 = LbsUtils.a(getClass().getSimpleName());
        if (localObject1 != null) {
          ((UpdatePhotoList.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
        }
        localReqBody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject2).toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "editProfileCard, photoList = " + paramArrayList + ", isHasNearbyAvatar = " + paramBoolean3);
      }
    }
    for (;;)
    {
      int k;
      int j;
      if ((paramArrayOfInterestTag != null) && (paramArrayOfInterestTag.length > 0))
      {
        localObject1 = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
        k = paramArrayOfInterestTag.length;
        j = 0;
        if (j < k)
        {
          localObject2 = paramArrayOfInterestTag[j];
          if (localObject2 == null) {}
          for (;;)
          {
            j += 1;
            break;
            ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add(((InterestTag)localObject2).a());
          }
        }
        localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
        if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          j = 0;
          while (j < paramArrayOfInterestTag.length)
          {
            ((StringBuilder)localObject2).append(paramArrayOfInterestTag[j].toString()).append(",");
            j += 1;
          }
          QLog.d("Q.nearby_people_card.", 2, "editProfileCard, tags = " + ((StringBuilder)localObject2).toString());
        }
      }
      for (paramArrayOfInterestTag = (InterestTag[])localObject1;; paramArrayOfInterestTag = null)
      {
        j = 0;
        k = 0;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("nick"))
          {
            j = 1;
            localObject1 = paramBundle.getString("nick");
            localReqBody.str_nick.set((String)localObject1);
            k = j;
            if (NearbyCardConstants.a)
            {
              k = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_nick|" + (String)localObject1);
                k = j;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("sex"))
          {
            k += 1;
            m = paramBundle.getByte("sex") + 1;
            localReqBody.uint32_gender.set(m);
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gender|" + m);
                j = k;
              }
            }
          }
          int m = j;
          if (paramBundle.containsKey("college"))
          {
            j += 1;
            localObject1 = paramBundle.getString("college");
            localReqBody.str_college.set((String)localObject1);
            m = j;
            if (NearbyCardConstants.a)
            {
              m = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_college|" + (String)localObject1);
                m = j;
              }
            }
          }
          k = m;
          if (paramBundle.containsKey("key_constellation"))
          {
            j = m + 1;
            m = paramBundle.getInt("key_constellation");
            localReqBody.uint32_constellation.set(m);
            k = j;
            if (NearbyCardConstants.a)
            {
              k = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_constellation|" + m);
                k = j;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("birthday"))
          {
            k += 1;
            m = paramBundle.getInt("birthday");
            localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(PkgTools.b(m)));
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "bytes_birthday|" + m);
                j = k;
              }
            }
          }
          k = j;
          if (paramBundle.containsKey("hometown"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("hometown");
            k = 0;
            while (k < 3)
            {
              PkgTools.a((byte[])localObject2, k * 4, PkgTools.b(ConditionSearchManager.a(localObject1[k])), 4);
              k += 1;
            }
            localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
            k = ConditionSearchManager.a(localObject1[3]);
            localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(PkgTools.b(k)));
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              k = 0;
              while (k < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[k]).append(", ");
                k += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_city_id|" + ((StringBuilder)localObject2).toString());
            }
            k = j + 2;
          }
          m = k;
          if (paramBundle.containsKey("location"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("location");
            j = 0;
            while (j < 3)
            {
              PkgTools.a((byte[])localObject2, j * 4, PkgTools.b(ConditionSearchManager.a(localObject1[j])), 4);
              j += 1;
            }
            localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
            j = ConditionSearchManager.a(localObject1[3]);
            localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(PkgTools.b(j)));
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              j = 0;
              while (j < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[j]).append(", ");
                j += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_location|" + ((StringBuilder)localObject2).toString());
            }
            m = k + 2;
          }
          j = m;
          if (paramBundle.containsKey("age"))
          {
            k = m + 1;
            j = paramBundle.getInt("age");
            localReqBody.uint32_age.set(j);
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "set birthday|age = " + paramBundle.getInt("age"));
                j = k;
              }
            }
          }
          k = j;
          if (paramBundle.containsKey("company"))
          {
            j += 1;
            localObject1 = paramBundle.getString("company");
            localReqBody.str_company.set((String)localObject1);
            k = j;
            if (NearbyCardConstants.a)
            {
              k = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_company|" + (String)localObject1);
                k = j;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_new_nickname"))
          {
            k += 1;
            localObject1 = paramBundle.getString("key_new_nickname");
            localReqBody.str_stranger_nick.set((String)localObject1);
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_stranger_nick|" + (String)localObject1);
                j = k;
              }
            }
          }
          k = j;
          if (paramBundle.containsKey("key_xuan_yan"))
          {
            localObject1 = paramBundle.getByteArray("key_xuan_yan");
            if (localObject1 != null) {
              localReqBody.bytes_stranger_declare.set(ByteStringMicro.copyFrom((byte[])localObject1));
            }
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder().append("str_stranger_declare|");
              if (localObject1 != null) {
                break label2351;
              }
              localObject1 = "null";
              QLog.d("Q.nearby_people_card.", 2, localObject1);
            }
            k = j + 1;
          }
          j = k;
          if (paramBundle.containsKey("key_marital_status"))
          {
            k += 1;
            m = paramBundle.getByte("key_marital_status");
            localReqBody.uint32_love_status.set(m);
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_love_status|" + m);
                j = k;
              }
            }
          }
          k = j;
          if (paramBundle.containsKey("profession"))
          {
            int n = paramBundle.getInt("profession");
            m = j;
            if (NearbyProfileUtil.a(n))
            {
              m = j + 1;
              localReqBody.uint32_profession.set(n);
            }
            k = m;
            if (NearbyCardConstants.a)
            {
              k = m;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_profession|" + n);
                k = m;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_qzone_switch"))
          {
            k += 1;
            m = paramBundle.getShort("key_qzone_switch");
            localReqBody.uint32_qzone_visible.set(m);
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_qzone_visible|" + m);
                j = k;
              }
            }
          }
          k = j;
          if (paramBundle.containsKey("key_hobby_switch"))
          {
            j += 1;
            m = paramBundle.getShort("key_hobby_switch");
            localReqBody.uint32_interest_visible.set(m);
            k = j;
            if (NearbyCardConstants.a)
            {
              k = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_interest_visible|" + m);
                k = j;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_flower_visible_switch"))
          {
            k += 1;
            m = paramBundle.getShort("key_flower_visible_switch");
            localReqBody.uint32_gift_visible.set(m);
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gift_visible|" + m);
                j = k;
              }
            }
          }
        }
        localReqBody.uint32_stranger_profile_flag.set(1);
        if (paramBoolean3) {
          localReqBody.uint32_face_flag.set(1);
        }
        localReqBody.uint32_guide_flag.set(0);
        if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
          QLog.d("Q.nearby_people_card.", 2, "fieldCount|" + (j + 1));
        }
        localObject1 = a("OidbSvc.0x9c9_0", 2505, 0, localReqBody.toByteArray());
        if (paramBundle != null) {
          ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
        }
        if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
          ((ToServiceMsg)localObject1).extraData.putParcelable("avatar_picinfo", (Parcelable)paramArrayList.get(0));
        }
        paramArrayList = ((ToServiceMsg)localObject1).extraData;
        if (paramArrayOfInterestTag == null) {}
        for (paramBundle = null;; paramBundle = paramArrayOfInterestTag.toByteArray())
        {
          paramArrayList.putByteArray("9c7_body", paramBundle);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_lost_god_flag", paramBoolean1);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_head_changed", paramBoolean2);
          ((ToServiceMsg)localObject1).extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
          b((ToServiceMsg)localObject1);
          return;
          label2351:
          localObject1 = Integer.valueOf(localObject1.length);
          break;
        }
      }
      label2375:
      break label154;
      label2378:
      localObject1 = null;
      break;
      paramBoolean3 = false;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (a(paramFromServiceMsg.getServiceCmd()));
      String str = paramFromServiceMsg.getServiceCmd();
      if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c8_0".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c5_0".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c9_0".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c7_0".equals(str))
      {
        NearbyCmdHelper.d(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x682".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getRandomUserInfo| uin = " + paramString);
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
    paramString = a("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyCardHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l = Long.parseLong(paramString);
          if (l != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.b.getManager(51);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = a("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            b((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyCardHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new cmd0x9c8.ReqBody();
    ((cmd0x9c8.ReqBody)localObject).str_keyword.set(paramString);
    ((cmd0x9c8.ReqBody)localObject).uint32_tag_type.set(paramInt1);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_start.set(paramInt2);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_count.set(paramInt3);
    ((cmd0x9c8.ReqBody)localObject).uint32_match_op.set(paramInt4);
    ((cmd0x9c8.ReqBody)localObject).uint32_personal_info_flag.set(paramInt5);
    localObject = a("OidbSvc.0x9c8_0", 2504, 0, ((cmd0x9c8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_word", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("tag_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("person_flag", paramInt5);
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean1).append(",uLikeSource = ").append(paramLong6);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt1);
      paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      paramString1.extraData.putByte("isFriend", paramByte);
      paramString1.extraData.putLong("troopCode", paramLong2);
      paramString1.extraData.putLong("troopUin", paramLong3);
      paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
      paramString1.extraData.putString("strSearchName", paramString3);
      paramString1.extraData.putLong("lGetControl", paramLong4);
      paramString1.extraData.putInt("EAddFriendSource", paramInt2);
      paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      paramString1.extraData.putLong("tinyId", paramLong5);
      paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean1);
      paramString1.extraData.putBoolean("partlyRefresh", paramBoolean2);
      paramString1.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
      paramString1.extraData.putLong("likeSource", paramLong6);
      a(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSummayCard", paramString1);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int j = 0;
      while (j < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(j)).append(", ");
        j += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = a("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    b(paramArrayList);
  }
  
  public void a(List paramList, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c8_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c5_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c9_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x682");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x686");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
      this.jdField_a_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo");
    }
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    oidb_0x5eb.RspBody localRspBody;
    String str;
    int m;
    int n;
    if (a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      localRspBody = new oidb_0x5eb.RspBody();
      paramObject = null;
      str = "";
      m = -1;
      n = 0;
      if (paramToServiceMsg.bytes_rspbody_5eb.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_rspbody_5eb.get().toByteArray();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramToServiceMsg);
      int k = n;
      int j = m;
      paramFromServiceMsg = str;
      paramToServiceMsg = (ToServiceMsg)paramObject;
      if (localRspBody.rpt_msg_uin_data.has())
      {
        k = n;
        j = m;
        paramFromServiceMsg = str;
        paramToServiceMsg = (ToServiceMsg)paramObject;
        if (localRspBody.rpt_msg_uin_data.size() > 0)
        {
          paramObject = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0);
          paramToServiceMsg = Long.valueOf(((oidb_0x5eb.UdcUinData)paramObject).uint64_uin.get());
          paramFromServiceMsg = ((oidb_0x5eb.UdcUinData)paramObject).bytes_stranger_nick.get().toStringUtf8();
          j = ((oidb_0x5eb.UdcUinData)paramObject).uint32_gender.get();
          k = ((oidb_0x5eb.UdcUinData)paramObject).uint32_age.get();
        }
      }
      a(12, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k) });
      if (QLog.isDevelopLevel()) {
        QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo---->uin =" + paramToServiceMsg + "nickName = " + paramFromServiceMsg + " gender = " + j + "age =" + k);
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramToServiceMsg);
        }
      }
    }
    a(12, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(-1), Integer.valueOf(-1) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\business\NearbyCardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */