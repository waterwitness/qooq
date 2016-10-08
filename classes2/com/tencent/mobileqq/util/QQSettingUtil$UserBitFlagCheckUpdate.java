package com.tencent.mobileqq.util;

import KQQ.ReqItem;
import KQQ.RespItem;
import KQQ.UserBitFlagReq;
import KQQ.UserBitFlagRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQSettingUtil$UserBitFlagCheckUpdate
  implements CheckUpdateItemInterface
{
  private QQAppInterface a;
  
  public QQSettingUtil$UserBitFlagCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 106;
    UserBitFlagReq localUserBitFlagReq = new UserBitFlagReq();
    localUserBitFlagReq.cEmotionMall = 0;
    localUserBitFlagReq.cMyWallet = ((byte)QQSettingUtil.a(this.a));
    localUserBitFlagReq.cPtt2Text = 0;
    localUserBitFlagReq.cAccout2Dis = 0;
    localReqItem.vecParam = localUserBitFlagReq.toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting", 2, "handleCheckUpdateItemData");
    }
    if (paramRespItem.eServiceID == 106)
    {
      UserBitFlagRes localUserBitFlagRes = new UserBitFlagRes();
      localUserBitFlagRes.readFrom(new JceInputStream(paramRespItem.vecUpdate));
      int i = localUserBitFlagRes.cEmotionMall;
      int j = localUserBitFlagRes.cMyWallet;
      int k = localUserBitFlagRes.cAccout2Dis;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "vEmotion=" + i + ",cMyWallet=" + j + ",cPtt2Text=" + localUserBitFlagRes.cPtt2Text + " ,cAccout2Dis=" + k);
      }
      if (this.a != null)
      {
        this.a.a().getApplicationContext().getSharedPreferences(this.a.a(), 0).edit().putInt("mywallet_flag", j).putInt("select_member_contacts_flag", k).commit();
        paramRespItem = this.a;
        if (localUserBitFlagRes.cPtt2Text != 1) {
          break label207;
        }
      }
    }
    for (;;)
    {
      SttManager.a(paramRespItem, bool);
      return;
      label207:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\QQSettingUtil$UserBitFlagCheckUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */