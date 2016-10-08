package com.dataline.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cj;
import ck;
import cl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class RouterAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "unbind_flag";
  public static final String b = "guid_flag";
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RouterAdvanceActivity.NotifyReceiver jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver;
  private DeviceInfo jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private View b;
  private String c;
  private String d;
  
  public RouterAdvanceActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new ck(this);
  }
  
  private void a(int paramInt)
  {
    DialogUtil.a(this, 230).setTitle("解除绑定失败").setMessage("解除绑定失败，错误码：" + paramInt).setNegativeButton(2131367976, new cl(this)).show();
  }
  
  private void a(String paramString)
  {
    RecentUserProxy localRecentUserProxy = this.app.a().a();
    paramString = localRecentUserProxy.b(paramString, 6002);
    if (paramString != null) {
      localRecentUserProxy.b(paramString);
    }
  }
  
  private void b()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(super.getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      FMToastUtil.a(2131362820);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
      startActivityForResult(localIntent, 100);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    String str = getString(2131362203);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(str);
    localActionSheet.a(super.getResources().getString(2131362126), 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new cj(this, localActionSheet));
    localActionSheet.show();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "modifyRemark,  DIN[" + this.d + "], 设备信息不存在");
      }
      return;
    }
    String str = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark;
    Intent localIntent = new Intent(this, EditActivity.class);
    boolean bool = true;
    if (TextUtils.isEmpty(str)) {
      bool = false;
    }
    localIntent.putExtra("title", 2131367739).putExtra("limit", 96).putExtra("current", str).putExtra("canPostNull", bool).putExtra("multiLine", false);
    startActivityForResult(localIntent, 1003);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    String str;
    if (paramInt2 == -1) {
      str = null;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    if (str == null) {}
    for (paramIntent = "";; paramIntent = str)
    {
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IphoneTitleBarActivity", 2, "modifyRemark,  DIN[" + this.d + "], 设备信息不存在");
        return;
      }
      if (!paramIntent.equals(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark))
      {
        ((SmartDeviceProxyMgr)this.app.a(51)).a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.serialNum, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId, paramIntent);
        this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark = paramIntent;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903290);
    setTitle(2131364474);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297892);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.b = super.findViewById(2131297895);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297986));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297893));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(FMSettings.a().b());
    paramBundle = new IntentFilter();
    paramBundle.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver = new RouterAdvanceActivity.NotifyReceiver(this);
    registerReceiver(this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver, paramBundle);
    this.c = super.getIntent().getStringExtra("guid_flag");
    this.d = super.getIntent().getStringExtra("uin");
    if (ChatActivityConstants.I)
    {
      localObject = this.leftView.getText().toString();
      paramBundle = (Bundle)localObject;
      if (!getString(2131366637).equals(localObject)) {
        paramBundle = "返回" + (String)localObject + "界面";
      }
      this.leftView.setContentDescription(paramBundle);
      this.leftView.setText(2131362120);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131297985));
    Object localObject = (FormSimpleItem)super.findViewById(2131297984);
    paramBundle = (ImageView)super.findViewById(2131296790);
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(51)).a(Long.parseLong(this.d));
    int i;
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)
    {
      i = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
      ((FormSimpleItem)localObject).setRightText(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.name);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      PrinterOptionActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0.0F, this);
      PrinterOptionActivity.a((FormSimpleItem)localObject, 0.0F, this);
    }
    for (;;)
    {
      localObject = DeviceHeadMgr.a().a(i);
      paramBundle.setBackgroundDrawable(new BitmapDrawable(super.getResources(), (Bitmap)localObject));
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      ((FormSimpleItem)localObject).setVisibility(8);
      i = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297892: 
      b();
      return;
    case 2131297895: 
      c();
      return;
    case 2131297986: 
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null) {
        break;
      }
    }
    for (int i = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;; i = 0)
    {
      ((SmartDeviceProxyMgr)this.app.a(51)).a(this.c, i);
      a(this.d);
      return;
      a();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\RouterAdvanceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */