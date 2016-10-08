package com.tencent.mobileqq.app;

import VipRecommend.MQQ.UserInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class VIPRecommendPayHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "VIPRecommendPayHandler";
  public static final String b = "VipPayLogicServer.getCommPayInfo ";
  
  protected VIPRecommendPayHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class a()
  {
    return VIPRecommendPayObserver.class;
  }
  
  public void a(UserInfo paramUserInfo)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "VipPayLogicServer.getCommPayInfo ");
    localToServiceMsg.extraData.putSerializable("VIPRecommendPayRequest", paramUserInfo);
    super.a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      a(1, false, null);
    }
    String str;
    do
    {
      return;
      str = paramToServiceMsg.getServiceCmd();
      if (TextUtils.isEmpty(str))
      {
        a(1, false, null);
        return;
      }
      if ((str.compareTo("VipPayLogicServer.getCommPayInfo ") == 0) && (QLog.isColorLevel())) {
        QLog.i("VIPRecommendPayHandler", 2, "req---" + paramToServiceMsg + ",res----" + paramFromServiceMsg + ",data-----" + paramObject);
      }
    } while (str.compareTo("VipPayLogicServer.getCommPayInfo ") != 0);
    a(1, true, paramObject);
    FileUtils.a(this.b.a() + "_" + "VIPRecommendPayFile.txt", paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\VIPRecommendPayHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */