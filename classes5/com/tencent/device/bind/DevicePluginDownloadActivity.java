package com.tencent.device.bind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import jvl;
import jvm;

public class DevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private static String a = "DevicePluginDownloadActivity";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903291);
    super.setTitle(2131362164);
    SmartDevicePluginLoader.a().addObserver(this);
    this.leftView.setText(2131366637);
    if (!SmartDevicePluginLoader.a().a(this.app)) {
      SmartDevicePluginLoader.a().a();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      if (paramObservable.intValue() != 0)
      {
        paramObservable = DialogUtil.a(this, 230);
        paramObservable.setNegativeButton(2131367262, new jvl(this));
        paramObservable.setPositiveButton(2131362416, new jvm(this));
        paramObservable.setTitle(2131362419);
        paramObservable.setMessage(2131362420);
        paramObservable.show();
      }
    }
    else
    {
      return;
    }
    paramObservable = new Intent();
    paramObject = super.getIntent();
    paramObservable.putExtra("DevicePID", ((Intent)paramObject).getStringExtra("DevicePID"));
    paramObservable.putExtra("DeviceSN", ((Intent)paramObject).getStringExtra("DeviceSN"));
    paramObservable.putExtra("DeviceToken", ((Intent)paramObject).getStringExtra("DeviceToken"));
    paramObservable.putExtra("DataReportSeq", SmartDeviceReport.a().a);
    SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\bind\DevicePluginDownloadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */