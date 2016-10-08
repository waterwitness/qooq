package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import lvw;
import lvx;
import lvy;
import lvz;
import lwa;

public class NearPeopleFilterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final long a = 20000L;
  static final String jdField_a_of_type_JavaLangString = "NearPeopleFilterActivity";
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 1000;
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  int jdField_a_of_type_Int;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener;
  private ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener;
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  public IphonePickerView a;
  public FormSimpleItem a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  String jdField_b_of_type_JavaLangString;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public FormSimpleItem c;
  public int d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public int e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public int j;
  
  public NearPeopleFilterActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0", "0" };
    this.jdField_b_of_type_JavaLangString = "不限";
    this.jdField_a_of_type_AndroidOsHandler = new lvw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new lvx(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new lvy(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new lvz(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new lwa(this);
  }
  
  private void a(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296881)).a = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130904203, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(true);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_e_of_type_Int);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
        }
        else if (paramInt == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("NearPeopleFilterActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  public static void a(Activity paramActivity, Fragment paramFragment, NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = paramNearPeopleFilters;
    if (paramNearPeopleFilters == null) {
      localNearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
    }
    paramNearPeopleFilters = new Intent(paramActivity, NearPeopleFilterActivity.class);
    paramNearPeopleFilters.putExtra("gender", localNearPeopleFilters.i);
    paramNearPeopleFilters.putExtra("time", localNearPeopleFilters.j);
    paramNearPeopleFilters.putExtra("age", localNearPeopleFilters.k);
    paramNearPeopleFilters.putExtra("xingzuo", localNearPeopleFilters.m);
    paramNearPeopleFilters.putExtra("interest", localNearPeopleFilters.l);
    paramNearPeopleFilters.putExtra("key_career", localNearPeopleFilters.n);
    paramNearPeopleFilters.putExtra("key_hometown_country", localNearPeopleFilters.d[0]);
    paramNearPeopleFilters.putExtra("key_hometown_province", localNearPeopleFilters.d[1]);
    paramNearPeopleFilters.putExtra("key_hometown_city", localNearPeopleFilters.d[2]);
    paramNearPeopleFilters.putExtra("key_hometown_string", localNearPeopleFilters.jdField_a_of_type_JavaLangString);
    if ((paramFragment != null) && ((paramActivity instanceof FragmentActivity)))
    {
      ((FragmentActivity)paramActivity).startActivityFromFragment(paramFragment, paramNearPeopleFilters, paramInt);
      return;
    }
    paramActivity.startActivityForResult(paramNearPeopleFilters, paramInt);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void d()
  {
    Object localObject;
    if (AppSetting.j)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_AndroidViewView.isSelected()) {
        break label371;
      }
      str = "不限性别 当前已选中";
      ((View)localObject).setContentDescription(str);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_b_of_type_AndroidViewView.isSelected()) {
        break label378;
      }
      str = "男 当前已选中";
      label49:
      ((View)localObject).setContentDescription(str);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (!this.jdField_c_of_type_AndroidViewView.isSelected()) {
        break label385;
      }
      str = "女 当前已选中";
      label73:
      ((View)localObject).setContentDescription(str);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!this.jdField_c_of_type_AndroidWidgetTextView.isSelected()) {
        break label392;
      }
      str = "30分钟 当前已选中";
      label97:
      ((TextView)localObject).setContentDescription(str);
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (!this.jdField_d_of_type_AndroidWidgetTextView.isSelected()) {
        break label399;
      }
      str = "一小时 当前已选中";
      label121:
      ((TextView)localObject).setContentDescription(str);
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if (!this.jdField_e_of_type_AndroidWidgetTextView.isSelected()) {
        break label406;
      }
      str = "四小时 当前已选中";
      label145:
      ((TextView)localObject).setContentDescription(str);
      localObject = this.jdField_f_of_type_AndroidWidgetTextView;
      if (!this.jdField_f_of_type_AndroidWidgetTextView.isSelected()) {
        break label413;
      }
    }
    label371:
    label378:
    label385:
    label392:
    label399:
    label406:
    label413:
    for (String str = "不限时间 当前已选中";; str = "不限时间 ，连按两次来选中")
    {
      ((TextView)localObject).setContentDescription(str);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int] + " ，连按两次来更改");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("兴趣" + NearPeopleFilterActivity.NearPeopleFilters.b[this.jdField_d_of_type_Int] + " ，连按两次来更改");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("职业" + com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_f_of_type_Int] + " ，连按两次来更改");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("星座" + NearPeopleFilterActivity.NearPeopleFilters.c[this.jdField_e_of_type_Int] + " ，连按两次来更改");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + this.jdField_b_of_type_JavaLangString + " ，连按两次来更改");
      return;
      str = "不限性别 ，连按两次来选中";
      break;
      str = "男 ，连按两次来选中";
      break label49;
      str = "女 ，连按两次来选中";
      break label73;
      str = "30分钟 ，连按两次来选中";
      break label97;
      str = "一小时 ，连按两次来选中";
      break label121;
      str = "四小时 ，连按两次来选中";
      break label145;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.jdField_c_of_type_AndroidViewView.setSelected(false);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131428268));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427379));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427379));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838637, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838635, 0, 0, 0);
      if (this.jdField_b_of_type_Int != 0) {
        break label546;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setSelected(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131428268));
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.b[this.jdField_d_of_type_Int]);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.c[this.jdField_e_of_type_Int]);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_f_of_type_Int]);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(Integer.valueOf(this.jdField_f_of_type_Int));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(this.jdField_a_of_type_ArrayOfJavaLangString);
      if (AppSetting.j) {
        d();
      }
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
        this.jdField_c_of_type_AndroidViewView.setSelected(false);
        this.jdField_b_of_type_AndroidViewView.setSelected(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838638, 0, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838635, 0, 0, 0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131428268));
        break;
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
      this.jdField_c_of_type_AndroidViewView.setSelected(true);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838637, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838636, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427379));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131428268));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427379));
      break;
      label546:
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_f_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131428268));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
      }
      else if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131428268));
        this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
      }
      else if ((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 3))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_f_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427379));
        this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131428268));
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 1);
    int n = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (n != 0)
    {
      n = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(n);
      if (QLog.isColorLevel()) {
        QLog.d("NearPeopleFilterActivity", 2, "startLocationSelectActivity | update result = " + n);
      }
      if (n == 2)
      {
        QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
        return;
      }
      if (n == 0)
      {
        a(getString(2131371450));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(getString(2131371450));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    String[] arrayOfString2 = (String[])this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag();
    String[] arrayOfString1;
    if (arrayOfString2 != null)
    {
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 4) {}
    }
    else
    {
      arrayOfString1 = new String[4];
      arrayOfString1[0] = "0";
      arrayOfString1[1] = "0";
      arrayOfString1[2] = "0";
      arrayOfString1[3] = "0";
    }
    localIntent.putExtra("param_location", arrayOfString1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString1));
    startActivityForResult(localIntent, 1);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt2 != -1);
          localObject = paramIntent.getStringExtra("param_name");
          paramInt1 = paramIntent.getIntExtra("param_id", -1);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(Integer.valueOf(paramInt1));
          this.jdField_f_of_type_Int = paramInt1;
        } while (!AppSetting.j);
        d();
        return;
      } while (paramInt2 != -1);
      Object localObject = paramIntent.getStringArrayExtra("param_location");
      paramIntent = paramIntent.getStringExtra("param_location_param");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(localObject);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
      this.jdField_b_of_type_JavaLangString = paramIntent;
    } while (!AppSetting.j);
    d();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.setTheme(2131559165);
    super.doOnCreate(paramBundle);
    super.setContentView(2130904265);
    super.setTitle(2131371842);
    super.setRightButton(2131368729, this);
    super.setLeftButton(2131367262, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301436);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301434);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131301432);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301435));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301433));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302095));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302096));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302097));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302098));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301243));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302099));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298400));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301429));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302069));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    paramBundle = new NearPeopleFilterActivity.NearPeopleFilters();
    paramBundle.i = getIntent().getIntExtra("gender", 0);
    paramBundle.j = getIntent().getIntExtra("time", 0);
    paramBundle.k = getIntent().getIntExtra("age", 0);
    paramBundle.l = getIntent().getIntExtra("interest", 0);
    paramBundle.m = getIntent().getIntExtra("xingzuo", 0);
    paramBundle.n = getIntent().getIntExtra("key_career", 0);
    paramBundle.d[0] = getIntent().getStringExtra("key_hometown_country");
    paramBundle.d[1] = getIntent().getStringExtra("key_hometown_province");
    paramBundle.d[2] = getIntent().getStringExtra("key_hometown_city");
    paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_hometown_string");
    this.jdField_a_of_type_Int = paramBundle.i;
    this.jdField_b_of_type_Int = paramBundle.j;
    this.jdField_c_of_type_Int = paramBundle.k;
    this.jdField_d_of_type_Int = paramBundle.l;
    this.jdField_e_of_type_Int = paramBundle.m;
    this.jdField_f_of_type_Int = paramBundle.n;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramBundle.d;
    if (!TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) {}
    for (this.jdField_b_of_type_JavaLangString = paramBundle.jdField_a_of_type_JavaLangString;; this.jdField_b_of_type_JavaLangString = "不限")
    {
      if (TextUtils.isEmpty(paramBundle.d[0])) {
        paramBundle.d[0] = "0";
      }
      if (TextUtils.isEmpty(paramBundle.d[1])) {
        paramBundle.d[0] = "0";
      }
      if (TextUtils.isEmpty(paramBundle.d[2])) {
        paramBundle.d[0] = "0";
      }
      a();
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
  }
  
  protected boolean onBackEvent()
  {
    super.finish();
    overridePendingTransition(0, 2130968593);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301243: 
      this.j = 0;
      a(this.j);
      return;
    case 2131302099: 
      this.j = 2;
      a(this.j);
      return;
    case 2131298400: 
      this.j = 1;
      a(this.j);
      return;
    case 2131297391: 
      onBackEvent();
      return;
    case 2131297183: 
      paramView = new Intent();
      paramView.putExtra("gender", this.jdField_a_of_type_Int);
      paramView.putExtra("time", this.jdField_b_of_type_Int);
      paramView.putExtra("age", this.jdField_c_of_type_Int);
      paramView.putExtra("interest", this.jdField_d_of_type_Int);
      paramView.putExtra("xingzuo", this.jdField_e_of_type_Int);
      paramView.putExtra("key_career", this.jdField_f_of_type_Int);
      paramView.putExtra("key_hometown_country", this.jdField_a_of_type_ArrayOfJavaLangString[0]);
      paramView.putExtra("key_hometown_province", this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      paramView.putExtra("key_hometown_city", this.jdField_a_of_type_ArrayOfJavaLangString[2]);
      paramView.putExtra("key_hometown_string", this.jdField_b_of_type_JavaLangString);
      setResult(-1, paramView);
      super.finish();
      overridePendingTransition(0, 2130968593);
      return;
    case 2131301436: 
      this.jdField_a_of_type_Int = 0;
      a();
      return;
    case 2131301434: 
      this.jdField_a_of_type_Int = 1;
      a();
      return;
    case 2131301432: 
      this.jdField_a_of_type_Int = 2;
      a();
      return;
    case 2131302095: 
      this.jdField_b_of_type_Int = 0;
      a();
      return;
    case 2131302096: 
      this.jdField_b_of_type_Int = 1;
      a();
      return;
    case 2131302097: 
      this.jdField_b_of_type_Int = 2;
      a();
      return;
    case 2131302098: 
      this.jdField_b_of_type_Int = 4;
      a();
      return;
    case 2131301429: 
      paramView = new Intent(this, JobSelectionActivity.class);
      if ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag() instanceof Integer))) {
        paramView.putExtra("param_id", (Integer)this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag());
      }
      paramView.putExtra("param_need_no_limit", true);
      startActivityForResult(paramView, 2);
      return;
    }
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\NearPeopleFilterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */