package com.tencent.mobileqq.app;

import EncounterSvc.EntranceContent;
import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEntrance;
import EncounterSvc.RespGetRecommender;
import LBSAddrProtocol.GPS;
import LBSAddrProtocol.RspGetPositionApi;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.Switch;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.NearbyRecommendTroop;
import com.tencent.mobileqq.dating.CarrierHelper.EntranceConfig;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.facetoface.NearbyUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsReq;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.nearby.entrance.NearbyEntranceContent;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.NearbyUser;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.ReqBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.RspBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.ReqBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo;

public class LBSHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "LBSHandler";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 8;
  public static final int e = 9;
  public static final int f = 10;
  public static final int g = 11;
  public static final int h = 12;
  public static final int i = 13;
  public static final int j = 14;
  public static final int k = 15;
  public static final int l = 16;
  public static final int m = 17;
  public static final int n = 18;
  public static final int o = 19;
  public static final int p = 24;
  public static final int q = 25;
  public static final int r = 26;
  public static final int s = 27;
  
  public LBSHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = DialogUtil.a(paramContext, 230, null, paramString, 2131367262, 2131367902, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131297851)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131296852);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(DisplayUtil.a(paramContext, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    DatingUtil.b("LBSHandler", new Object[] { "handleGetEntrance", paramObject });
    if ((paramObject instanceof Object[]))
    {
      paramFromServiceMsg = (Object[])paramObject;
      paramObject = (NeighborComm.RespHeader)paramFromServiceMsg[0];
      paramToServiceMsg = (RespGetEntrance)paramFromServiceMsg[1];
      Object localObject1;
      label142:
      label195:
      EntranceContent localEntranceContent;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("handleGetEntrance---->respHeader=").append(paramObject).append("|error code=");
        if (paramObject == null)
        {
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if ((paramObject == null) || (((NeighborComm.RespHeader)paramObject).eReplyCode != 0) || (paramToServiceMsg == null)) {
          break label792;
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder().append("handleGetEntrance---->RespGetEntrance.entrance_list size=");
          if (paramToServiceMsg.entrance_list != null) {
            break label477;
          }
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
        paramFromServiceMsg = new Object[2];
        paramObject = new LinkedList();
        if ((paramToServiceMsg.entrance_list == null) || (paramToServiceMsg.entrance_list.isEmpty())) {
          break label545;
        }
        localObject1 = paramToServiceMsg.entrance_list.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label545;
        }
        localEntranceContent = (EntranceContent)((Iterator)localObject1).next();
        localObject2 = new AdData();
        if (localEntranceContent.type != 100) {
          break label491;
        }
      }
      label477:
      label491:
      for (int i1 = 5;; i1 = localEntranceContent.type)
      {
        ((AdData)localObject2).ad_source = i1;
        NearbyEntranceContent localNearbyEntranceContent = new NearbyEntranceContent();
        try
        {
          localNearbyEntranceContent.mergeFrom(localEntranceContent.content_buff);
          ((AdData)localObject2).id = localNearbyEntranceContent.int64_id.get();
          ((AdData)localObject2).idType = localNearbyEntranceContent.int32_id_type.get();
          ((AdData)localObject2).jump_url = localNearbyEntranceContent.str_url.get();
          ((AdData)localObject2).picType = localNearbyEntranceContent.int32_pic_type.get();
          ((AdData)localObject2).title = localNearbyEntranceContent.str_title.get();
          ((AdData)localObject2).content = localNearbyEntranceContent.str_content.get();
          ((AdData)localObject2).content2 = localNearbyEntranceContent.str_content2.get();
          ((AdData)localObject2).img_url = localNearbyEntranceContent.pic_url.get();
          ((AdData)localObject2).fontColor = AdData.parseAdColor(((AdData)localObject2).ad_source, false, localNearbyEntranceContent.txt_color.get());
          ((AdData)localObject2).bgColor = AdData.parseAdColor(((AdData)localObject2).ad_source, true, localNearbyEntranceContent.bg_color.get());
          ((AdData)localObject2).wording = AdData.getWording(((AdData)localObject2).ad_source, localNearbyEntranceContent.corner_wording.get());
          ((AdData)localObject2).distance = localNearbyEntranceContent.str_distance.get();
          i1 = 1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("LBSHandler", 2, "handleGetEntrance error:" + localInvalidProtocolBufferMicroException.getMessage());
            }
            i1 = 0;
          }
        }
        if (i1 == 0) {
          break label195;
        }
        ((LinkedList)paramObject).add(localObject2);
        break label195;
        paramFromServiceMsg = Integer.valueOf(((NeighborComm.RespHeader)paramObject).eReplyCode);
        break;
        paramFromServiceMsg = Integer.valueOf(paramToServiceMsg.entrance_list.size());
        break label142;
      }
      label545:
      paramFromServiceMsg[0] = paramObject;
      if ((paramToServiceMsg.xml_list != null) && (paramToServiceMsg.xml_list.size() > 0))
      {
        paramObject = new ArrayList();
        paramToServiceMsg = paramToServiceMsg.xml_list.iterator();
        while (paramToServiceMsg.hasNext())
        {
          localObject1 = (String)paramToServiceMsg.next();
          if (!StringUtil.b((String)localObject1))
          {
            localObject2 = new CarrierHelper.EntranceConfig();
            ((ArrayList)paramObject).add(localObject2);
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject1);
              if (localJSONObject.has("type")) {
                ((CarrierHelper.EntranceConfig)localObject2).type = localJSONObject.getInt("type");
              }
              if (localJSONObject.has("icon_url")) {
                ((CarrierHelper.EntranceConfig)localObject2).iconUrl = localJSONObject.getString("icon_url");
              }
              if (localJSONObject.has("wording")) {
                ((CarrierHelper.EntranceConfig)localObject2).wording = localJSONObject.getString("wording");
              }
              if (localJSONObject.has("jump_url")) {
                ((CarrierHelper.EntranceConfig)localObject2).jumpUrl = localJSONObject.getString("jump_url");
              }
            }
            catch (JSONException localJSONException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LBSHandler", 2, "handleGetEntrance---->JSONException was thrown when parse JSON. string=" + (String)localObject1);
              }
              localJSONException.printStackTrace();
            }
          }
        }
        paramFromServiceMsg[1] = paramObject;
      }
      a(24, true, paramFromServiceMsg);
      return;
      label792:
      a(24, false, null);
      return;
    }
    a(24, false, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    return paramQQAppInterface.a().a(paramString, 1001).hasReply;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNearbyRecommender");
    }
    int i2;
    if ((paramObject instanceof Object[]))
    {
      paramFromServiceMsg = (Object[])paramObject;
      Object localObject = (NeighborComm.RespHeader)paramFromServiceMsg[0];
      paramObject = (RespGetRecommender)paramFromServiceMsg[1];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handleGetNearbyRecommender---->respHeader=").append(localObject).append("|error code=");
        if (localObject == null)
        {
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if ((localObject == null) || (((NeighborComm.RespHeader)localObject).eReplyCode != 0)) {
          break label583;
        }
        i2 = paramToServiceMsg.extraData.getInt("timingType", -1);
        if ((paramObject == null) || (((RespGetRecommender)paramObject).vEncounterInfos == null) || (((RespGetRecommender)paramObject).vEncounterInfos.size() <= 0)) {
          break label549;
        }
        localObject = ((RespGetRecommender)paramObject).vEncounterInfos;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder().append("handleGetNearbyRecommender---->RespGetRecommender.vEncounterInfos size=");
          if (localObject != null) {
            break label372;
          }
        }
      }
      label372:
      for (paramFromServiceMsg = "null";; paramFromServiceMsg = Integer.valueOf(((List)localObject).size()))
      {
        QLog.d("LBSHandler", 2, paramFromServiceMsg + ",resasonType=" + ((RespGetRecommender)paramObject).eReasonType);
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.addAll((Collection)localObject);
        if (i2 == 0) {
          NearbyRecommenderUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((RespGetRecommender)paramObject).strBrief, ((RespGetRecommender)paramObject).uRecommendTime);
        }
        NearbyRecommenderUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), b(), paramFromServiceMsg);
        a(27, true, new Object[] { localObject, Integer.valueOf(i2) });
        if (localObject == null) {
          break label386;
        }
        paramFromServiceMsg = "";
        int i1 = 0;
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i1 >= ((List)localObject).size()) {
            break;
          }
          paramFromServiceMsg = paramFromServiceMsg + Long.toString(((RespEncounterInfo)((List)localObject).get(i1)).lEctID) + ";";
          i1 += 1;
        }
        paramFromServiceMsg = Integer.valueOf(((NeighborComm.RespHeader)localObject).eReplyCode);
        break;
      }
      label386:
      paramToServiceMsg = "";
      if ("".equals(paramToServiceMsg)) {
        break label601;
      }
    }
    label549:
    label583:
    label601:
    for (paramFromServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1);; paramFromServiceMsg = paramToServiceMsg)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FA", "0X80055FA", 0, 0, Integer.toString(((RespGetRecommender)paramObject).eReasonType), "", paramFromServiceMsg, "");
      paramToServiceMsg = new Bundle();
      if (paramObject != null)
      {
        paramToServiceMsg.putInt("key_login_pull_interval", ((RespGetRecommender)paramObject).iOuterInterval);
        paramToServiceMsg.putInt("key_msgbox_pull_interval", ((RespGetRecommender)paramObject).iInnerInterval);
        paramToServiceMsg.putInt("key_expiretime", ((RespGetRecommender)paramObject).iExpiretime);
        paramToServiceMsg.putString("key_nearbyrecommender_title", ((RespGetRecommender)paramObject).strTitle);
        paramToServiceMsg.putInt("key_nearbyrecommender_reasontype", ((RespGetRecommender)paramObject).eReasonType);
      }
      paramToServiceMsg.putString("key_nearbyrecommender_uins", paramFromServiceMsg);
      if (i2 == 0) {
        paramToServiceMsg.putLong("key_login_pull_time", System.currentTimeMillis());
      }
      for (;;)
      {
        NearbyRecommenderUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
        return;
        a(27, false, null);
        paramFromServiceMsg = "";
        break;
        if (i2 == 1) {
          paramToServiceMsg.putLong("key_msgbox_pull_time", System.currentTimeMillis());
        }
      }
      a(27, false, null);
      return;
      a(27, false, null);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    label62:
    int i1;
    label109:
    int i2;
    label128:
    boolean bool2;
    int i3;
    label194:
    label249:
    label295:
    label338:
    String str;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      paramToServiceMsg = null;
      if (bool1)
      {
        for (;;)
        {
          try
          {
            paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
            paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
              break label908;
            }
            bool1 = true;
            if (bool1)
            {
              paramObject = new cmd0x9c0.RspBody();
              ((cmd0x9c0.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              if (!((cmd0x9c0.RspBody)paramObject).uint32_req_interval.has()) {
                break label914;
              }
              i1 = ((cmd0x9c0.RspBody)paramObject).uint32_req_interval.get();
            }
          }
          catch (Exception paramObject)
          {
            List localList;
            label382:
            i4 = -1;
            paramToServiceMsg = null;
            i2 = -1;
            bool2 = false;
            i1 = i2;
            i3 = i4;
            paramFromServiceMsg = paramToServiceMsg;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg Exception " + ((Exception)paramObject).getMessage());
            i1 = i2;
            i3 = i4;
            paramFromServiceMsg = paramToServiceMsg;
            bool1 = bool2;
            continue;
            if (!QLog.isColorLevel()) {
              break label963;
            }
          }
          try
          {
            if (!((cmd0x9c0.RspBody)paramObject).uint32_heartbeat_interval.has()) {
              break label920;
            }
            i2 = ((cmd0x9c0.RspBody)paramObject).uint32_heartbeat_interval.get();
          }
          catch (Exception paramObject)
          {
            paramToServiceMsg = null;
            i2 = -1;
            i4 = i1;
            continue;
          }
          try
          {
            localList = ((cmd0x9c0.RspBody)paramObject).rpt_nearby_user_list.get();
            if ((localList != null) && (localList.size() > 0)) {
              break label879;
            }
            bool2 = false;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("LBSHandler", 2, "rcv nearbyUserList is null!");
              bool1 = bool2;
            }
          }
          catch (Exception paramObject)
          {
            paramToServiceMsg = null;
            i4 = i1;
            continue;
            continue;
          }
        }
        if (bool1)
        {
          paramToServiceMsg = new ArrayList();
          i3 = 0;
          try
          {
            if (i3 < localList.size())
            {
              if (!((cmd0x9c0.NearbyUser)localList.get(i3)).uint64_nearby_uin.has()) {
                break label926;
              }
              paramFromServiceMsg = String.valueOf(((cmd0x9c0.NearbyUser)localList.get(i3)).uint64_nearby_uin.get());
              if (!((cmd0x9c0.NearbyUser)localList.get(i3)).uint32_is_frd.has()) {
                break label939;
              }
              if (((cmd0x9c0.NearbyUser)localList.get(i3)).uint32_is_frd.get() != 1) {
                break label933;
              }
              bool2 = true;
              if (!((cmd0x9c0.NearbyUser)localList.get(i3)).bytes_remark.has()) {
                break label945;
              }
              paramObject = ((cmd0x9c0.NearbyUser)localList.get(i3)).bytes_remark.get().toStringUtf8();
              if (!((cmd0x9c0.NearbyUser)localList.get(i3)).bytes_nick.has()) {
                break label952;
              }
              str = ((cmd0x9c0.NearbyUser)localList.get(i3)).bytes_nick.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: i: " + i3 + ", nearbyUin: " + paramFromServiceMsg + ", isFriend: " + bool2 + ", remark: " + (String)paramObject + ", nick: " + str);
              }
              if (TextUtils.isEmpty(paramFromServiceMsg)) {
                break label893;
              }
              paramToServiceMsg.add(new NearbyUser(paramFromServiceMsg, bool2, (String)paramObject, str));
              break label893;
            }
            if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
              break label873;
            }
            if (QLog.isColorLevel()) {
              QLog.d("LBSHandler", 2, "faceTofaceNearbyUserList is empty!");
            }
            bool1 = false;
          }
          catch (Exception paramObject)
          {
            for (;;)
            {
              i4 = i1;
            }
          }
          paramFromServiceMsg = paramToServiceMsg;
          i3 = i1;
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      label528:
      a(25, bool1, new Object[] { paramFromServiceMsg, Integer.valueOf(i3), Integer.valueOf(i1) });
      return;
      if (paramFromServiceMsg != null)
      {
        i1 = paramFromServiceMsg.uint32_result.get();
        switch (i1)
        {
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label963;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : " + i1);
        break label963;
        if (!QLog.isColorLevel()) {
          break label963;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : body uin is not equal bodyhead uin");
        break label963;
        int i4;
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : get nearbylist fail");
        break label963;
        if (!QLog.isColorLevel()) {
          break label963;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : judge friend ralationship fail");
        break label963;
        if (!QLog.isColorLevel()) {
          break label963;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : get remark fail");
        break label963;
        if (!QLog.isColorLevel()) {
          break label963;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendReg  fail resultCode : get nick fail");
        break label963;
        if (QLog.isColorLevel()) {
          QLog.d("LBSHandler", 2, "ssoPkg is null");
        }
        paramFromServiceMsg = null;
        i1 = -1;
        i3 = -1;
        break label528;
        label873:
        label879:
        i3 = -1;
        paramFromServiceMsg = null;
        i1 = -1;
        break label528;
        label893:
        i3 += 1;
        break label194;
        bool1 = false;
        break;
        label908:
        bool1 = false;
        break label62;
        label914:
        i1 = -1;
        break label109;
        label920:
        i2 = -1;
        break label128;
        label926:
        paramFromServiceMsg = "";
        break label249;
        label933:
        bool2 = false;
        break label295;
        label939:
        bool2 = false;
        break label295;
        label945:
        paramObject = "";
        break label338;
        label952:
        str = "";
        break label382;
      }
      label963:
      paramFromServiceMsg = null;
      i1 = -1;
      i3 = -1;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("currentAccountUin");
      if (!bool1) {
        break label344;
      }
    }
    label344:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramObject = new cmd0x9c1.RspBody();
        ((cmd0x9c1.RspBody)paramObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!((cmd0x9c1.RspBody)paramObject).uint64_uin.has()) {
          continue;
        }
        paramToServiceMsg = String.valueOf(((cmd0x9c1.RspBody)paramObject).uint64_uin.get());
        if (QLog.isColorLevel()) {
          QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg RspUin " + paramToServiceMsg + " ReqUin " + paramFromServiceMsg);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg Exception " + paramToServiceMsg.getMessage());
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg ssoPkg is null");
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  isSuccess " + bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      paramToServiceMsg = "";
      continue;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  fail resultCode : " + paramToServiceMsg.uint32_result.get());
        bool1 = bool2;
      }
    }
  }
  
  protected Class a()
  {
    return LBSObserver.class;
  }
  
  public void a()
  {
    a(new ToServiceMsg("mobileqq.service", b(), "NeighborSvc.ReqGetSwitches"));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LBSHandler", 2, "getNearbyRecommender| timingType = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "NeighborRecommender.ReqGetRecommender");
    localToServiceMsg.extraData.putInt("timingType", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, true, false, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "LbsShareSvr.nearby_shops");
    LBSShare.NearByShopsReq localNearByShopsReq = new LBSShare.NearByShopsReq();
    localNearByShopsReq.lat.set(paramInt1);
    localNearByShopsReq.lng.set(paramInt2);
    localNearByShopsReq.coordinate.set(paramInt3);
    localNearByShopsReq.begin.set(paramInt4);
    localNearByShopsReq.limit.set(paramInt5);
    localNearByShopsReq.version.set(1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("latitude", paramInt1);
    localBundle.putInt("longitude", paramInt2);
    localBundle.putInt("coordinate", paramInt3);
    localBundle.putInt("begin", paramInt4);
    localBundle.putInt("count", paramInt5);
    localToServiceMsg.extraData.putBundle("req", localBundle);
    localToServiceMsg.putWupBuffer(localNearByShopsReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt5 > 100)) {
      return;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "LbsShareSvr.location");
    LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
    localLocationReq.lat.set(paramInt1);
    localLocationReq.lng.set(paramInt2);
    localLocationReq.coordinate.set(paramInt3);
    localLocationReq.keyword.set(str);
    localLocationReq.category.set(paramString1);
    localLocationReq.page.set(paramInt4);
    localLocationReq.count.set(paramInt5);
    localLocationReq.requireMyLbs.set(paramInt6);
    Object localObject = DeviceInfoUtil.a();
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = "";
    }
    localLocationReq.imei.set(paramString2);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("latitude", paramInt1);
    ((Bundle)localObject).putInt("longitude", paramInt2);
    ((Bundle)localObject).putInt("coordinate", paramInt3);
    ((Bundle)localObject).putString("keyword", str);
    ((Bundle)localObject).putString("category", paramString1);
    ((Bundle)localObject).putInt("page", paramInt4);
    ((Bundle)localObject).putInt("count", paramInt5);
    ((Bundle)localObject).putInt("requireMyLbs", paramInt6);
    ((Bundle)localObject).putString("imei", paramString2);
    localToServiceMsg.extraData.putBundle("req", (Bundle)localObject);
    localToServiceMsg.putWupBuffer(localLocationReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "NearbyGroup.ReqGetAreaList");
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("radius", paramInt3);
    localToServiceMsg.extraData.putBoolean("clickable", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    if (a(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label705:
    label749:
    label756:
    label803:
    label809:
    label852:
    do
    {
      return;
      a(paramFromServiceMsg);
      if ("LBS.AddressService".equals(paramFromServiceMsg.getServiceCmd()))
      {
        paramFromServiceMsg = (RspGetPositionApi)paramObject;
        paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("devicedata");
        if (paramFromServiceMsg != null)
        {
          a(1, true, new Object[] { paramToServiceMsg, String.valueOf(paramFromServiceMsg.stUsrLoc.iLat / 1000000.0D), String.valueOf(paramFromServiceMsg.stUsrLoc.iLon / 1000000.0D), paramFromServiceMsg.strCity.trim() + paramFromServiceMsg.strDistrict.trim() + paramFromServiceMsg.strRoad.trim() });
          return;
        }
        a(1, false, paramToServiceMsg);
        return;
      }
      if ("NeighborSvc.ReqSetUserState".equals(paramFromServiceMsg.getServiceCmd()))
      {
        NearbyCmdHelper.b(this, 3, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("EncounterSvc.ReqGetEntrance".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramFromServiceMsg, paramToServiceMsg, paramObject);
        return;
      }
      int i1;
      boolean bool1;
      if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool2 = paramToServiceMsg.extraData.getBoolean("first");
        i1 = paramToServiceMsg.extraData.getInt("iFilterId");
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          a(8, bool1, new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool2), paramObject });
          return;
        }
      }
      if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool2 = paramToServiceMsg.extraData.getBoolean("clickable");
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          a(12, bool1, new Object[] { Boolean.valueOf(bool2), paramObject });
          return;
        }
      }
      if ("NearbyGroup.ReqGetGroupInArea".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          a(13, bool1, new Object[] { paramObject });
          return;
        }
      }
      if ("OidbSvc.0x568_20".equals(paramFromServiceMsg.getServiceCmd()))
      {
        int i2;
        long l1;
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
        {
          i2 = 1;
          l1 = paramToServiceMsg.extraData.getLong("key_troopuin", 0L);
          bool1 = paramToServiceMsg.extraData.getBoolean("key_show");
          i1 = i2;
          if (i2 == 0) {}
        }
        for (;;)
        {
          try
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            i1 = paramToServiceMsg.uint32_result.get();
            if (i1 != 0) {
              continue;
            }
            i1 = 1;
          }
          catch (Exception paramToServiceMsg)
          {
            i1 = 0;
            continue;
            a(14, false, null);
            return;
          }
          if (i1 == 0) {
            continue;
          }
          a(14, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool1) });
          return;
          i2 = 0;
          break;
          i1 = 0;
        }
      }
      if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool1 = paramToServiceMsg.extraData.getBoolean("k_be_share", false);
        if ((paramObject == null) || (((RespSetStateSwitch)paramObject).stHeader.eReplyCode != 0))
        {
          bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.n();
          bool2 = false;
        }
        for (;;)
        {
          a(9, bool2, Boolean.valueOf(bool1));
          return;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(bool1, true);
        }
      }
      if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if ((paramObject != null) && (((RespGetSwitches)paramObject).stHeader.eReplyCode == 0))
        {
          paramToServiceMsg = ((RespGetSwitches)paramObject).switches.iterator();
          if (paramToServiceMsg.hasNext())
          {
            paramFromServiceMsg = (Switch)paramToServiceMsg.next();
            if (paramFromServiceMsg.type != 64) {
              break label809;
            }
            paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramFromServiceMsg.is_open != 1) {
              break label803;
            }
            bool1 = true;
            ((QQAppInterface)paramObject).b(bool1, true);
            i1 = paramFromServiceMsg.type;
            if (paramFromServiceMsg.is_open != 1) {
              break label852;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            a(10, true, new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1) });
            break label705;
            break;
            bool1 = false;
            break label749;
            if (paramFromServiceMsg.type != 1) {
              break label756;
            }
            paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            if (paramFromServiceMsg.is_open == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              NearbySPUtil.b((String)paramObject, bool1);
              break;
            }
          }
        }
        a(10, false, null);
        return;
      }
      if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {}
        for (i1 = 11;; i1 = 18)
        {
          NearbyCmdHelper.a(this, i1, paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      }
      if ("LbsShareSvr.location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(15, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        a(15, false, null);
        return;
      }
      if ("LbsShareSvr.nearby_shops".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(16, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        a(16, false, null);
        return;
      }
      if ("LbsShareSvr.get_shops_by_ids".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(17, true, new Object[] { paramToServiceMsg, paramObject });
          return;
        }
        a(17, false, null);
        return;
      }
      if ("OidbSvc.0x9c0_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c1_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramFromServiceMsg, paramToServiceMsg, paramObject);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "EncounterSvc.ReqGetEntrance");
    if (paramGeoPoint != null)
    {
      int i1 = paramGeoPoint.getLatitudeE6();
      int i2 = paramGeoPoint.getLongitudeE6();
      if ((i1 != 0) && (i2 != 0))
      {
        localToServiceMsg.extraData.putInt("localLat", i1);
        localToServiceMsg.extraData.putInt("localLon", i2);
      }
    }
    DatingUtil.b("LBSHandler", new Object[] { "getEntrance" });
    a(localToServiceMsg);
  }
  
  public void a(String paramString)
  {
    Object localObject = new cmd0x9c1.ReqBody();
    ((cmd0x9c1.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2497);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x9c1.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x9c1_0");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("currentAccountUin", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "Face2FaceAddFriendActivity reqFacetoFaceAddFriendUnreg");
    }
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "NearbyGroup.ReqGetGroupInArea");
    localToServiceMsg.extraData.putString("areaName", paramString);
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("startIndex", paramInt3);
    localToServiceMsg.extraData.putInt("count", paramInt4);
    localToServiceMsg.extraData.putInt("iFilterId", paramInt5);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "LbsShareSvr.get_shops_by_ids");
    LBSShare.GetShopsByIdsReq localGetShopsByIdsReq = new LBSShare.GetShopsByIdsReq();
    localGetShopsByIdsReq.ids.set(paramArrayList);
    localToServiceMsg.putWupBuffer(localGetShopsByIdsReq.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      a(19, false, Integer.valueOf(0));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "handleNearbyRecommendTroopPush:" + paramList.size());
    }
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(b()).createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    int i1 = 0;
    try
    {
      while (i1 < paramList.size())
      {
        submsgtype0x67.GroupInfo localGroupInfo = (submsgtype0x67.GroupInfo)paramList.get(i1);
        NearbyRecommendTroop localNearbyRecommendTroop = new NearbyRecommendTroop();
        localNearbyRecommendTroop.uin = (localGroupInfo.uint64_group_code.get() + "");
        localNearbyRecommendTroop.name = localGroupInfo.str_group_name.get();
        localNearbyRecommendTroop.intro = localGroupInfo.str_group_memo.get();
        localNearbyRecommendTroop.memberNum = localGroupInfo.uint32_member_num.get();
        localNearbyRecommendTroop.troopType = localGroupInfo.uint32_group_type.get();
        localEntityManager.b(localNearbyRecommendTroop);
        i1 += 1;
      }
      localEntityTransaction.c();
      a(19, true, Integer.valueOf(paramList.size()));
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("recommendTroopPush", 2, "handleNearbyRecommendTroopPush exception" + paramList.toString());
      }
      return;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public void a(SubMsgType0x27.NewComeinUserNotify paramNewComeinUserNotify)
  {
    String str1 = null;
    if (paramNewComeinUserNotify == null) {
      return;
    }
    Object localObject;
    label53:
    boolean bool;
    label77:
    String str2;
    if (paramNewComeinUserNotify.msg_new_comein_user.has())
    {
      localObject = (SubMsgType0x27.NewComeinUser)paramNewComeinUserNotify.msg_new_comein_user.get();
      if (localObject == null) {
        break label332;
      }
      if (!((SubMsgType0x27.NewComeinUser)localObject).uint64_uin.has()) {
        break label298;
      }
      str1 = String.valueOf(((SubMsgType0x27.NewComeinUser)localObject).uint64_uin.get());
      if (!((SubMsgType0x27.NewComeinUser)localObject).uint32_is_frd.has()) {
        break label311;
      }
      if (((SubMsgType0x27.NewComeinUser)localObject).uint32_is_frd.get() != 1) {
        break label305;
      }
      bool = true;
      if (!((SubMsgType0x27.NewComeinUser)localObject).bytes_remark.has()) {
        break label317;
      }
      str2 = ((SubMsgType0x27.NewComeinUser)localObject).bytes_remark.get().toStringUtf8();
      label99:
      if (!((SubMsgType0x27.NewComeinUser)localObject).bytes_nick.has()) {
        break label325;
      }
      localObject = ((SubMsgType0x27.NewComeinUser)localObject).bytes_nick.get().toStringUtf8();
      label120:
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: push nearbyUin: " + str1 + ", isFriend: " + bool + ", remark: " + str2 + ", nick: " + (String)localObject);
      }
      if (TextUtils.isEmpty(str1)) {
        break label366;
      }
      localObject = new NearbyUser(str1, bool, str2, (String)localObject);
    }
    for (;;)
    {
      label205:
      if (paramNewComeinUserNotify.uint32_msg_type.has()) {
        paramNewComeinUserNotify.uint32_msg_type.get();
      }
      if (paramNewComeinUserNotify.bool_strong_notify.has())
      {
        bool = paramNewComeinUserNotify.bool_strong_notify.get();
        label242:
        if (!paramNewComeinUserNotify.uint32_push_time.has()) {
          break label360;
        }
      }
      label298:
      label305:
      label311:
      label317:
      label325:
      label332:
      label360:
      for (int i1 = paramNewComeinUserNotify.uint32_push_time.get();; i1 = -1)
      {
        a(26, true, new Object[] { localObject, Boolean.valueOf(bool), Integer.valueOf(i1) });
        return;
        localObject = null;
        break;
        str1 = "";
        break label53;
        bool = false;
        break label77;
        bool = false;
        break label77;
        str2 = "";
        break label99;
        localObject = "";
        break label120;
        localObject = str1;
        if (!QLog.isColorLevel()) {
          break label205;
        }
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser  push NewComeinUser is null ");
        localObject = str1;
        break label205;
        bool = false;
        break label242;
      }
      label366:
      localObject = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    NearbyCmdHelper.a(this, paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    short s2 = 0;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "NearbyGroup.GetGroupList");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      localToServiceMsg.extraData.putString("strGroupArea", paramString);
    }
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    short s1 = s2;
    switch (paramInt3)
    {
    default: 
      s1 = s2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "shSortType:" + s1 + ",iFilterId:" + paramInt4);
      }
      localToServiceMsg.extraData.putShort("shSortType", s1);
      a(localToServiceMsg);
      return;
      s1 = 1;
      continue;
      s1 = 2;
      continue;
      s1 = 3;
      localToServiceMsg.extraData.putInt("iFilterId", paramInt4);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("LBS.AddressService");
      this.jdField_b_of_type_JavaUtilSet.add("NeighborSvc.ReqSetUserState");
      this.jdField_b_of_type_JavaUtilSet.add("EncounterSvc.ReqGetEntrance");
      this.jdField_b_of_type_JavaUtilSet.add("NeighborRecommender.ReqGetRecommender");
      this.jdField_b_of_type_JavaUtilSet.add("NearbyGroup.GetGroupList");
      this.jdField_b_of_type_JavaUtilSet.add("NeighborSvc.ReqSetStateSwitch");
      this.jdField_b_of_type_JavaUtilSet.add("NeighborSvc.ReqGetSwitches");
      this.jdField_b_of_type_JavaUtilSet.add("NeighborSvc.ReqGetPoint");
      this.jdField_b_of_type_JavaUtilSet.add("NearbyGroup.ReqGetAreaList");
      this.jdField_b_of_type_JavaUtilSet.add("NearbyGroup.ReqGetGroupInArea");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x568_20");
      this.jdField_b_of_type_JavaUtilSet.add("LbsShareSvr.location");
      this.jdField_b_of_type_JavaUtilSet.add("LbsShareSvr.nearby_shops");
      this.jdField_b_of_type_JavaUtilSet.add("LbsShareSvr.get_shops_by_ids");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x9c0_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x9c1_0");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = new cmd0x9c0.ReqBody();
    ((cmd0x9c0.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    paramString = ((cmd0x9c0.ReqBody)localObject).uint32_heartbeat;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      paramString.set(i1);
      if (paramBoolean) {
        break label90;
      }
      paramString = LbsUtils.a(getClass().getSimpleName());
      if (paramString != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "lbsInfo is null");
      }
      return false;
    }
    ((cmd0x9c0.ReqBody)localObject).msg_lbs_info.set(paramString);
    label90:
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2496);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x9c0.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x9c0_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public void b()
  {
    NearbyCmdHelper.a(this, false, true, 0, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", b(), "NeighborSvc.ReqSetStateSwitch");
    localToServiceMsg.extraData.putBoolean("k_be_share", paramBoolean);
    a(localToServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\LBSHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */