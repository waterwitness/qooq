package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import hwj;
import hwk;
import hwl;
import hwm;

public class ReadInJoyAccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a;
  public static final String b = "ReadInJoyAccountDetailActivity";
  Intent jdField_a_of_type_AndroidContentIntent;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  public ActionSheet a;
  Switch jdField_a_of_type_ComTencentWidgetSwitch;
  boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AppConstants.aZ;
  }
  
  public ReadInJoyAccountDetailActivity()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    b();
  }
  
  public void b()
  {
    super.setContentView(2130904903);
    this.jdField_a_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_key", true);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    Object localObject;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (bool)
      {
        i = getResources().getColor(2131427765);
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        this.mSystemBarComp.init();
        this.mSystemBarComp.b(i);
      }
    }
    else
    {
      localObject = findViewById(2131296895);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          ((View)localObject).setFitsSystemWindows(true);
        }
        ((View)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131367975));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297183));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label454;
      }
      i = 0;
      label208:
      ((ImageView)localObject).setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840081);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131364687));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298931));
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (!this.jdField_a_of_type_Boolean) {
        break label460;
      }
      localObject = "进入QQ看点";
      label271:
      localButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_download_pic_flag", false);
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)super.findViewById(2131304697));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setTrackResource(2130839413);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setThumbResource(2130839412);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new hwj(this));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299947));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362977));
      findViewById(2131304698).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131296808);
      if (!bool) {
        break label466;
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    label454:
    label460:
    label466:
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      return;
      i = getResources().getColor(2131427764);
      break;
      i = 8;
      break label208;
      localObject = "加关注";
      break label271;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131364475, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new hwk(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new hwl(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void d()
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.a(getString(2131364479, new Object[] { "QQ看点" }));
    localActionSheet.a(2131364475, 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new hwm(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    a();
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297083: 
      finish();
      return;
    case 2131298931: 
      if (this.jdField_a_of_type_Boolean)
      {
        finish();
        return;
      }
      SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_key", true);
      ReadInJoyHelper.a(true);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetButton.setText("进入QQ看点");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    case 2131297183: 
      c();
      return;
    }
    ReadInJoyActivityHelper.a(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\activity\ReadInJoyAccountDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */