package com.tencent.device.msg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import kac;
import kae;
import kaf;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceMsgSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  protected static final String a = "DeviceMsgSettingActivity";
  public Handler a;
  public CompoundButton a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public DeviceInfo a;
  public QQProgressDialog a;
  public ArrayList a;
  String b;
  String c;
  String d;
  String e;
  
  public DeviceMsgSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.b);
    localBundle.putString("din", this.d);
    localBundle.putString("pid", this.c);
    localBundle.putString("appid", "1300000607");
    localBundle.putString("data", paramString);
    SmartDeviceUtil.a("set_lightapp_property", localBundle, this.app, new kae(this));
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.b);
    localBundle.putString("din", this.d);
    localBundle.putString("pid", this.c);
    localBundle.putString("appid", "1300000607");
    SmartDeviceUtil.a("get_lightapp_property", localBundle, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new kac(this));
  }
  
  private void c()
  {
    Object localObject = (TextView)super.findViewById(2131297977);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = super.findViewById(2131297978);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label99;
        }
        ((View)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = super.findViewById(2131297975);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label107;
        }
        ((View)localObject).setVisibility(0);
        LogUtility.c("DeviceMsgSettingActivity", "show none background");
      }
      return;
      ((TextView)localObject).setVisibility(0);
      break;
      label99:
      ((View)localObject).setVisibility(0);
    }
    label107:
    LogUtility.c("DeviceMsgSettingActivity", "hide none background");
    ((View)localObject).setVisibility(8);
  }
  
  public void a()
  {
    c();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j)
    {
      kaf localkaf = (kaf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(localkaf.jdField_a_of_type_JavaLangString);
      localFormSwitchItem.setFocusable(true);
      label75:
      Switch localSwitch;
      if (j == 1)
      {
        localFormSwitchItem.setBgType(0);
        localSwitch = localFormSwitchItem.a();
        localSwitch.setTag(Integer.valueOf(localkaf.jdField_a_of_type_Int));
        if (localkaf.b != 1) {
          break label168;
        }
      }
      label168:
      for (boolean bool = true;; bool = false)
      {
        localSwitch.setChecked(bool);
        localSwitch.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
        i += 1;
        break;
        if (i == 0)
        {
          localFormSwitchItem.setBgType(1);
          break label75;
        }
        if (i == j - 1)
        {
          localFormSwitchItem.setBgType(3);
          break label75;
        }
        localFormSwitchItem.setBgType(2);
        break label75;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903287);
    super.setTitle(2131362412);
    paramBundle = super.getIntent();
    this.c = String.valueOf(paramBundle.getIntExtra("pid", 0));
    this.d = paramBundle.getStringExtra("din");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)super.getAppRuntime());
    this.b = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297979));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362429);
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    b();
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(51)).a(Long.parseLong(this.d));
    SmartDeviceReport.a(this.app, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din, "Usr_MsgMgr_Open", 0, 0, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362433);
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (kaf)localIterator.next();
      if (((kaf)localObject).jdField_a_of_type_Int == j)
      {
        int k = ((kaf)localObject).b;
        long l;
        if (paramBoolean)
        {
          i = 1;
          if (k != i) {
            break label169;
          }
          paramCompoundButton = this.app;
          l = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din;
          if (!paramBoolean) {
            break label163;
          }
        }
        label163:
        for (int i = 1;; i = 2)
        {
          SmartDeviceReport.a(paramCompoundButton, l, "Usr_MsgMgr_Setting", i, 1, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
          return;
          i = 0;
          break;
        }
        for (;;)
        {
          try
          {
            label169:
            localObject = new JSONObject().put("id", ((kaf)localObject).jdField_a_of_type_Int);
            if (!paramBoolean) {
              break label224;
            }
            i = 1;
            localJSONArray.put(((JSONObject)localObject).put("enable", i));
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          break;
          label224:
          i = 0;
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetCompoundButton = paramCompoundButton;
    a(localJSONArray.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\activities\DeviceMsgSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */