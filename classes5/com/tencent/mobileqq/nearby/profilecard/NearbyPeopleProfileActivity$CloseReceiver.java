package com.tencent.mobileqq.nearby.profilecard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class NearbyPeopleProfileActivity$CloseReceiver
  extends BroadcastReceiver
{
  public NearbyPeopleProfileActivity$CloseReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramContext != null) && ((paramContext instanceof NearbyPeopleProfileActivity)))
    {
      paramContext = (NearbyPeopleProfileActivity)paramContext;
      paramIntent = paramIntent.getStringExtra("uin");
      if ((!TextUtils.isEmpty(paramIntent)) && (Utils.a(paramIntent, paramContext.E)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onReceive,close on uin:" + paramIntent);
        }
        paramContext.finish();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\NearbyPeopleProfileActivity$CloseReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */