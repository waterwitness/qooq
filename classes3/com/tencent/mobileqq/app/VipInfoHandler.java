package com.tencent.mobileqq.app;

import MQQ.VipUserInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class VipInfoHandler
  extends BusinessHandler
{
  public static int a = 1;
  public static final String a = "ClubInfoSvc.GetVipInfoReq";
  static String b;
  static String c;
  static String d;
  public static final String e = "VIPCenter_url_key";
  private static String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    f = "VipInfoHandler";
    jdField_b_of_type_JavaLangString = "k_uin";
    c = "k_type";
    d = "k_skey";
  }
  
  VipInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(VipUserInfo paramVipUserInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipUserInfo == null) || (paramInt1 > 2) || (paramInt1 < 1)) {
      return paramInt2;
    }
    if (1 == paramInt1) {}
    for (paramInt1 = paramVipUserInfo.iOpenVip;; paramInt1 = paramVipUserInfo.iOpenSVip) {
      return (paramInt1 << 8 | (byte)paramVipUserInfo.iVipType) << 16 | (short)paramVipUserInfo.iVipLevel;
    }
  }
  
  protected Class a()
  {
    return VipInfoObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.getServiceCmd();
    int i = Integer.valueOf(paramToServiceMsg.extraData.getInt(c)).intValue();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    if ("ClubInfoSvc.GetVipInfoReq".equals(localObject))
    {
      bool2 = bool1;
      if (i == a)
      {
        if (!bool1) {
          break label628;
        }
        paramFromServiceMsg = paramToServiceMsg.extraData.getString(jdField_b_of_type_JavaLangString);
        paramToServiceMsg = (VipUserInfo)paramObject;
        if ((paramToServiceMsg == null) || (paramToServiceMsg.iOpenVip < 0) || (paramToServiceMsg.iOpenSVip < 0)) {
          break label622;
        }
        localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        Friends localFriends = ((FriendsManager)localObject).b(paramFromServiceMsg);
        localFriends.qqVipInfo = a(paramToServiceMsg, 1, localFriends.qqVipInfo);
        localFriends.superVipInfo = a(paramToServiceMsg, 2, localFriends.superVipInfo);
        SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        localSharedPreferences.edit().putLong("sp_vip_info_request_time", paramToServiceMsg.iUpdateTime);
        localSharedPreferences.edit().putInt("sp_vip_info_update_freq", paramToServiceMsg.iUpdateFreq);
        if (paramToServiceMsg.iCanUseRed >= 0) {
          localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", paramToServiceMsg.iCanUseRed);
        }
        if (paramToServiceMsg.iRedDisable >= 0) {
          localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramToServiceMsg.iRedDisable);
        }
        localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramToServiceMsg.iRedPackId);
        localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramToServiceMsg.sRedPackRemard);
        localSharedPreferences.edit().commit();
        if (QLog.isColorLevel()) {
          QLog.d(f, 2, "redpacketinfo : icanusedred = " + paramToServiceMsg.iCanUseRed + ";iRedDisable = " + paramToServiceMsg.iRedDisable + "iRedPacketId = " + paramToServiceMsg.iRedPackId + ";sRedPackRemard = " + paramToServiceMsg.sRedPackRemard);
        }
        ((FriendsManager)localObject).a(localFriends);
        if ((!TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) && ((paramToServiceMsg.iCanUseRed >= 0) || (paramToServiceMsg.iRedDisable >= 0)))
        {
          paramFromServiceMsg = (IndividualRedPacketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
          paramFromServiceMsg.a(paramToServiceMsg.iCanUseRed, paramToServiceMsg.iRedDisable, true);
          paramFromServiceMsg.a(paramToServiceMsg.iRedPackId, paramToServiceMsg.sRedPackRemard);
        }
        paramFromServiceMsg = paramToServiceMsg.sUri;
        if (!TextUtils.isEmpty(paramFromServiceMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.d(f, 2, "vip url = " + paramFromServiceMsg);
          }
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4).edit().putString("VIPCenter_url_key", paramFromServiceMsg);
          if (Build.VERSION.SDK_INT >= 9) {
            break label613;
          }
          paramFromServiceMsg.commit();
        }
        AioVipDonateHelper.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
      }
    }
    label564:
    for (boolean bool2 = bool1;; bool2 = bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool2);
      }
      a(a, bool2, paramObject);
      return;
      label613:
      paramFromServiceMsg.apply();
      break;
      label622:
      bool1 = false;
      break label564;
      label628:
      ReportCenter.a().a("ClubInfoSvc.GetVipInfoReq", 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1000277, "[CMD:ClubInfoSvc.GetVipInfoReqfailed]", true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ClubInfoSvc.GetVipInfoReq");
    localToServiceMsg.extraData.putString(jdField_b_of_type_JavaLangString, paramString2);
    localToServiceMsg.extraData.putInt(c, a);
    localToServiceMsg.extraData.putString(d, paramString1);
    a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.GetVipInfoReq");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\VipInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */