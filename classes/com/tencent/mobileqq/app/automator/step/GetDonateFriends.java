package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class GetDonateFriends
  extends AsyncStep
{
  public GetDonateFriends()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    Object localObject = this.a.b.getApplication().getApplicationContext().getSharedPreferences(this.a.b.a(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l <= i * 60) {}
    for (;;)
    {
      return 7;
      localObject = this.a.b.a();
      String str = ((TicketManager)this.a.b.getManager(2)).getSkey((String)localObject);
      ((VipInfoHandler)this.a.b.a(27)).a(str, (String)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetDonateFriends.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */