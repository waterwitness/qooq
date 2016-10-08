package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.qphone.base.util.QLog;
import pzf;

public class IndividualRedPacketManager$VIPHBStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private AppInterface a;
  
  public IndividualRedPacketManager$VIPHBStrategy(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAppInterface;
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(IndividualRedPacketManager.b(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.a + "content = " + paramRedPacketInfo.b);
    }
    Object localObject = (IndividualRedPacketManager)this.a.getManager(130);
    if ((localObject == null) || (!((IndividualRedPacketManager)localObject).c()))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = IndividualRedPacketManager.b();
        localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo!");
        if (localObject != null) {
          break label130;
        }
      }
      label130:
      for (localObject = "redPacketManager == null";; localObject = ((IndividualRedPacketManager)localObject).a().a + "__" + ((IndividualRedPacketManager)localObject).b())
      {
        QLog.d(str, 2, (String)localObject);
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return;
      }
    }
    ThreadManager.a(new pzf(this, (IndividualRedPacketManager)localObject, paramRedPacketInfo), 8, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\IndividualRedPacketManager$VIPHBStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */