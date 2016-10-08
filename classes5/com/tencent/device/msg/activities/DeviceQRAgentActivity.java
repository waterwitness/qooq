package com.tencent.device.msg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DeviceQRAgentActivity
  extends IphoneTitleBarActivity
{
  public DeviceQRAgentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    String str = paramBundle.getStringExtra("qrurl");
    if (!TextUtils.isEmpty(str))
    {
      super.setContentView(2130903289);
      super.setTitle(2131362410);
      super.setLeftViewName(2131362410);
      SmartDeviceReport.a().a(1);
      SmartDeviceReport.a().b = "";
      SmartDeviceReport.a().a = 0;
      int i = paramBundle.getIntExtra("entrance", 1);
      SmartDeviceReport.a().a(BaseApplicationImpl.a().a(), "Usr_Entrance", i);
      DeviceScanner.a(this, null, str);
      super.finish();
      return true;
    }
    super.finish();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\activities\DeviceQRAgentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */