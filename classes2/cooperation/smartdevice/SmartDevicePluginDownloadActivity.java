package cooperation.smartdevice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Observable;
import java.util.Observer;

public class SmartDevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  private static String jdField_a_of_type_JavaLangString = "SmartDevicePluginDownloadActivity";
  protected Button a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131492908));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368770);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903288);
    super.setTitle(2131362164);
    SmartDevicePluginLoader.a().addObserver(this);
    this.leftView.setText(2131366637);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297982));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297981));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297390));
    if (!NetworkUtil.i(this.app.a())) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    if (!SmartDevicePluginLoader.a().a(this.app))
    {
      a();
      SmartDevicePluginLoader.a().a();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nickname", this.app.b());
    localIntent.putExtra("bitmap", this.app.a(this.app.a(), (byte)2, false));
    localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
    localObject2 = "com.tencent.device.activities.DeviceSearchActivity";
    localObject1 = localObject2;
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("smartdevice_entry", 4);
      paramView = (View)localObject2;
      localObject1 = localObject2;
      if (localSharedPreferences.getBoolean("enable_public_device_" + this.app.a(), true)) {
        paramView = "com.tencent.device.activities.DeviceSquareActivity";
      }
      localObject1 = paramView;
      boolean bool = localSharedPreferences.getBoolean("search_device_enable_https_" + this.app.a(), false);
      localObject2 = paramView;
      localObject1 = paramView;
      if (VersionUtils.d())
      {
        localObject2 = paramView;
        if (bool)
        {
          localObject1 = paramView;
          localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          localObject2 = paramView;
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
    SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), localIntent, (String)localObject2, 0, null, SmartDevicePluginProxyActivity.class);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      b();
      if (paramObservable.intValue() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372038);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\smartdevice\SmartDevicePluginDownloadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */