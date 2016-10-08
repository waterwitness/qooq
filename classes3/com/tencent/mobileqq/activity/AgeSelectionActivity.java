package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kjx;
import kjy;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "param_age";
  public static final String b = "param_constellation_id";
  public static final String c = "param_constellation";
  static final int d = 1896;
  public static final String d = "param_year";
  public static final String e = "param_month";
  public static final String f = "param_day";
  public static final String g = "param_birthday";
  public int a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private kjy jdField_a_of_type_Kjy;
  int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  int c;
  public int e;
  public int f;
  public int g;
  int jdField_h_of_type_Int;
  String jdField_h_of_type_JavaLangString;
  
  public AgeSelectionActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 2014;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new kjx(this);
  }
  
  public static int a(String paramString)
  {
    return Arrays.asList(NearbyProfileUtil.c).indexOf(paramString);
  }
  
  private void a()
  {
    this.jdField_h_of_type_Int = (this.jdField_a_of_type_Int - (this.e + 1896));
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, this.f + 1, this.g + 1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, this.jdField_b_of_type_Int, this.c);
    if (localCalendar1.after(localCalendar2)) {
      this.jdField_h_of_type_Int -= 1;
    }
    if (this.jdField_h_of_type_Int < 0) {
      this.jdField_h_of_type_Int = 0;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_Int + "岁");
    this.jdField_h_of_type_JavaLangString = Utils.a(this.f + 1, this.g + 1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904068);
    setTitle("选择出生日期");
    setLeftViewName(2131366637);
    paramBundle = Calendar.getInstance();
    paramBundle.setTimeInMillis(System.currentTimeMillis());
    this.jdField_a_of_type_Int = paramBundle.get(1);
    this.jdField_b_of_type_Int = (paramBundle.get(2) + 1);
    this.c = paramBundle.get(5);
    int i = getIntent().getIntExtra("param_birthday", 0);
    if (i == 0)
    {
      this.e = 94;
      this.f = 0;
    }
    for (this.g = 0;; this.g = ((i & 0xFF) - 1))
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      i = getResources().getColor(2131428320);
      findViewById(2131301245).setBackgroundColor(i);
      i = getResources().getColor(2131428319);
      findViewById(2131298986).setBackgroundColor(i);
      findViewById(2131298987).setBackgroundColor(i);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301243));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301244));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)findViewById(2131301246));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(getResources().getColor(2131428291));
      this.jdField_a_of_type_Kjy = new kjy(this, null);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Kjy);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.e);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.f);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.g);
      a();
      return true;
      this.e = ((i >>> 16) - 1896);
      this.f = (((0xFF00 & i) >>> 8) - 1);
    }
  }
  
  protected boolean onBackEvent()
  {
    this.e = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.f = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
    this.g = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    a();
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.jdField_h_of_type_Int);
    localIntent.putExtra("param_constellation_id", a(this.jdField_h_of_type_JavaLangString));
    localIntent.putExtra("param_constellation", this.jdField_h_of_type_JavaLangString);
    localIntent.putExtra("param_year", (short)(this.e + 1896));
    localIntent.putExtra("param_month", (byte)(this.f + 1));
    localIntent.putExtra("param_day", (byte)(this.g + 1));
    setResult(-1, localIntent);
    return super.onBackEvent();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AgeSelectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */