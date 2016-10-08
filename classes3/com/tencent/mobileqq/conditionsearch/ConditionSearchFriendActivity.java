package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import qyv;
import qyw;
import qyx;
import qyy;
import qyz;
import qza;
import qzb;
import qzc;
import qzd;

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 20000L;
  public static final String b = "key_first_req_location";
  private static final String jdField_d_of_type_JavaLangString = "ConditionSearchFriendActivity";
  private static final String jdField_e_of_type_JavaLangString = "不限";
  private static final boolean jdField_e_of_type_Boolean = true;
  static final int j = 0;
  static final int k = 1;
  static final int l = 2;
  static final int m = 3;
  private static final int o = 1002;
  private static final int p = 1003;
  private static final int q = 1004;
  private static final int s = 0;
  private static final int t = 1;
  private static final int u = 2;
  private static final int v = 3;
  private static final int x = 1000;
  public int a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener;
  ConditionSearchManager.ISearchListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener;
  public ConditionSearchManager a;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver;
  BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener;
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  public IphonePickerView a;
  public FormSimpleItem a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  public String a;
  public boolean a;
  public int[] a;
  public BaseAddress[] a;
  public Object[] a;
  public String[] a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  public boolean b;
  public int c;
  View c;
  public TextView c;
  public FormSimpleItem c;
  public String c;
  public boolean c;
  public int d;
  public View d;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  public int e;
  public View e;
  public FormSimpleItem e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int n;
  private final int r;
  private int w;
  
  public ConditionSearchFriendActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.r = 20;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new qyw(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new qyx(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new qyy(this);
    this.jdField_a_of_type_AndroidOsHandler = new qza(this);
    this.n = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener = new qzb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new qzc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new qzd(this);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private int a(ArrayList paramArrayList, String paramString)
  {
    int i2 = paramArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((BaseAddress)paramArrayList.get(i1)).b.equals(paramString)) {
        return i1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private String a()
  {
    Object localObject = new StringBuilder();
    if ((!"0".equals(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null))
    {
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString).append("-");
      int i1 = 0;
      while (i1 < this.h)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i1] != null) && (!"0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i1].b))) {
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i1].jdField_a_of_type_JavaLangString).append("-");
        }
        i1 += 1;
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Intent localIntent;
    if ((this.h <= 0) || (this.h > 3)) {
      if (!"0".equals(this.jdField_c_of_type_JavaLangString))
      {
        localIntent = new Intent(this, CountrySelectActivity.class);
        localIntent.putExtra("key_country_code", this.jdField_c_of_type_JavaLangString);
        localIntent.putExtra("key_no_limit_allow", true);
        if (paramInt == 1) {
          startActivityForResult(localIntent, 1003);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 2);
        startActivityForResult(localIntent, 1004);
        return;
        if (!paramBoolean)
        {
          b(paramInt);
          e();
        }
        if (paramInt == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(a()));
          c(1);
          return;
        }
      } while (paramInt != 2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(a()));
      c(2);
      return;
      if (paramInt == 1)
      {
        if ("不限".equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.b().getText())) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(a()));
        }
        c(1);
        return;
      }
    } while (paramInt != 2);
    if ("不限".equals(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.b().getText())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(a()));
    }
    c(2);
  }
  
  private void b(int paramInt)
  {
    int i1 = 1;
    Object localObject = null;
    String[] arrayOfString;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      this.jdField_c_of_type_JavaLangString = localObject[0];
      if (this.jdField_c_of_type_JavaLangString.equals("0"))
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
        this.jdField_c_of_type_JavaLangString = arrayOfString[0];
        localObject = arrayOfString;
        if (this.jdField_c_of_type_JavaLangString.equals("0"))
        {
          this.jdField_c_of_type_JavaLangString = "1";
          localObject = arrayOfString;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
      if (localObject == null) {
        break;
      }
      int i2 = localObject.length;
      while (i1 < i2)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i1 - 1)] = localObject[i1];
        i1 += 1;
      }
      if (paramInt == 2)
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
        this.jdField_c_of_type_JavaLangString = arrayOfString[0];
        localObject = arrayOfString;
        if (this.jdField_c_of_type_JavaLangString.equals("0"))
        {
          this.jdField_c_of_type_JavaLangString = "1";
          localObject = arrayOfString;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "initLocationCode|type : " + paramInt + ", mLocationCountyCode : " + this.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_first_req_location", false);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    this.jdField_b_of_type_Int = localObject[0];
    this.jdField_c_of_type_Int = localObject[1];
    this.f = localObject[0];
    this.g = localObject[1];
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296899));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    localObject = getResources().getDrawable(2130843266);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new qyv(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301437));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301439));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301440));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301438));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301441));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301442));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301432);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301434);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131301436);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301433));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301435));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131371441));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
    if (AppSetting.j) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + (String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131371442));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchManager.d[this.jdField_e_of_type_Int]);
    if (AppSetting.j) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("职业" + ConditionSearchManager.d[this.jdField_e_of_type_Int]);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131371443));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject));
    if (AppSetting.j) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("所在地" + (String)localObject);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131371444));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(str));
    if (AppSetting.j) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + str);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131371445));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchManager.c[this.jdField_d_of_type_Int]);
    if (AppSetting.j) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("星座" + ConditionSearchManager.c[this.jdField_d_of_type_Int]);
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (AppSetting.j) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362101));
    }
    f();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "init|mIsFirstReqLocation : " + this.jdField_b_of_type_Boolean + ", locDesc : " + (String)localObject);
    }
    if ((this.jdField_b_of_type_Boolean) || ("不限".equals(localObject))) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = -1;
    this.i = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296881);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130904203, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    int i1;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      i1 = a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
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
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.post(new qyz(this, i1, paramInt));
        return;
        if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
          i1 = a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem);
          paramInt = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
        }
        else
        {
          i1 = 0;
          while (i1 < this.h)
          {
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i1, this.jdField_a_of_type_ArrayOfInt[i1]);
            i1 += 1;
          }
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131301807));
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null) {}
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString;; localObject = "中国")
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
            if (AppSetting.j) {
              this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("已选定," + (String)localObject + "按钮");
            }
            if (paramInt != 1) {
              break label438;
            }
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
            i1 = a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
            paramInt = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
            break;
          }
          label438:
          if (paramInt == 2)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
            i1 = a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
            paramInt = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
          }
          else
          {
            paramInt = -1;
            i1 = i2;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ConditionSearchFriendActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
    this.jdField_a_of_type_ArrayOfJavaLangObject = null;
    this.h = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      this.h = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.a();
      this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.h];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[this.h];
      this.jdField_a_of_type_ArrayOfInt = new int[this.h];
      if (this.h != 0) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      int i3 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      int i2 = 0;
      int i1 = 0;
      if (i2 < i3)
      {
        if ("0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i2])) {}
        do
        {
          i2 += 1;
          break;
          this.jdField_a_of_type_ArrayOfJavaLangObject[i1] = ((BaseAddress)localObject1).a();
          BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
          localObject2 = (BaseAddress)((BaseAddress)localObject1).jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i2]);
          arrayOfBaseAddress[i1] = localObject2;
          this.jdField_a_of_type_ArrayOfInt[i1] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[i1], this.jdField_a_of_type_ArrayOfJavaLangString[i2]);
          i1 += 1;
          localObject1 = localObject2;
        } while (localObject2 != null);
        return;
      }
      if (i1 < this.h)
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[i1] = ((BaseAddress)localObject1).a();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i1] = ((BaseAddress)((BaseAddress)localObject1).jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0)));
        this.jdField_a_of_type_ArrayOfInt[i1] = 0;
      }
    }
    Object localObject2 = new StringBuilder().append("initLocationData|mLocationColumCount : ").append(this.h).append(", mLocationCountry.name : ");
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {}
    for (Object localObject1 = "null";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString)
    {
      QLog.d("ConditionSearchFriendActivity", 2, (String)localObject1);
      return;
    }
  }
  
  private void f()
  {
    View localView;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_c_of_type_AndroidViewView.setSelected(true);
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      if (AppSetting.j)
      {
        localView = this.jdField_c_of_type_AndroidViewView;
        if (!this.jdField_c_of_type_AndroidViewView.isSelected()) {
          break label180;
        }
        str = "已选定，不限，按钮";
        label56:
        localView.setContentDescription(str);
        localView = this.jdField_b_of_type_AndroidViewView;
        if (!this.jdField_b_of_type_AndroidViewView.isSelected()) {
          break label187;
        }
        str = "已选定，男，按钮";
        label80:
        localView.setContentDescription(str);
        localView = this.jdField_a_of_type_AndroidViewView;
        if (!this.jdField_a_of_type_AndroidViewView.isSelected()) {
          break label194;
        }
      }
    }
    label180:
    label187:
    label194:
    for (String str = "已选定，女，按钮";; str = "女，按钮")
    {
      localView.setContentDescription(str);
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidViewView.setSelected(false);
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
        this.jdField_b_of_type_AndroidViewView.setSelected(true);
        break;
      }
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_c_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      break;
      str = "不限，按钮";
      break label56;
      str = "男，按钮";
      break label80;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog | type = " + this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.n = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|checkUpdate result = " + i1);
    }
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(i1);
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|update updateResult = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131371450));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131371450));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|type : " + paramInt + ", mNeedInitLocation" + this.jdField_d_of_type_Boolean + ", mNeedInitHome : " + this.jdField_c_of_type_Boolean + ", mLocationColumCount : " + this.h + ", mLocationCountyCode : " + this.jdField_c_of_type_JavaLangString);
    }
    if (paramInt == 1)
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label335;
      }
      b(1);
      e();
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      a(paramInt, bool1);
      return;
      if (paramInt != 2) {
        break;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        b(2);
        e();
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = true;
      }
      for (bool1 = bool2;; bool1 = false)
      {
        a(paramInt, bool1);
        return;
      }
      label335:
      bool1 = false;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "showWaitingDialog | type = " + paramInt + ", str = " + paramString);
    }
    this.n = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | requestCode = " + paramInt1);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1002) {
        break label123;
      }
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("param_id", 0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchManager.d[this.jdField_e_of_type_Int]);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_e_of_type_Int);
      if (AppSetting.j) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("职业" + ConditionSearchManager.d[this.jdField_e_of_type_Int]);
      }
    }
    label123:
    label594:
    label607:
    label609:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramIntent = paramIntent.getStringExtra("key_country_code");
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | codes = " + paramIntent);
            }
          } while ((TextUtils.isEmpty(paramIntent)) || (paramIntent.equals(this.jdField_c_of_type_JavaLangString)));
          this.jdField_c_of_type_JavaLangString = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_c_of_type_JavaLangString);
        } while (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null);
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.a();
        if ((paramInt2 <= 0) || (paramInt2 > 3))
        {
          d();
          e();
          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
        }
        for (;;)
        {
          if (paramInt1 != 1003) {
            break label609;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
          if (!AppSetting.j) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("所在地" + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
          return;
          paramIntent = new String[4];
          paramIntent[0] = this.jdField_c_of_type_JavaLangString;
          paramIntent[1] = this.jdField_a_of_type_ArrayOfJavaLangString[0];
          paramIntent[2] = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          paramIntent[3] = this.jdField_a_of_type_ArrayOfJavaLangString[2];
          String str = a();
          if (paramInt1 == 1003)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, str);
            this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(paramIntent);
          }
          else if (paramInt1 == 1004)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1, str);
            this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(paramIntent);
            continue;
            d();
            e();
            if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130904203, null));
              }
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
              paramInt2 = 0;
            }
            while (paramInt2 < this.h)
            {
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(paramInt2, 0);
              paramInt2 += 1;
              continue;
              if (paramInt1 != 1003) {
                break label594;
              }
              c(1);
            }
            for (;;)
            {
              if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
                break label607;
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
              if (!AppSetting.j) {
                break;
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("已选定," + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString + "按钮");
              break;
              if (paramInt1 == 1004) {
                c(2);
              }
            }
          }
        }
      } while (paramInt1 != 1004);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
    } while (!AppSetting.j);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("故乡" + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.jdField_a_of_type_JavaLangString);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904109);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131296895);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131300716);
    setContentBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    setTitle(2131371437);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramView, arrayOfString, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, 1);
      a(3, getString(2131371452));
      return;
      c(0);
      return;
      paramView = new Intent(this, JobSelectionActivity.class);
      paramView.putExtra("param_id", this.jdField_e_of_type_Int);
      paramView.putExtra("param_from_consearch", true);
      paramView.putExtra("param_need_no_limit", true);
      startActivityForResult(paramView, 1002);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
      a(2);
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
      ReportController.b(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
      a(1);
      return;
      c(3);
      return;
      this.jdField_a_of_type_Int = 2;
      f();
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_Int);
      ReportController.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      return;
      this.jdField_a_of_type_Int = 1;
      f();
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_Int);
      ReportController.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      return;
      this.jdField_a_of_type_Int = 0;
      f();
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_Int);
      ReportController.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      return;
      paramView = new Intent(this, CountrySelectActivity.class);
      paramView.putExtra("key_country_code", this.jdField_c_of_type_JavaLangString);
      paramView.putExtra("key_no_limit_allow", true);
      if (this.i == 1)
      {
        startActivityForResult(paramView, 1003);
        return;
      }
    } while (this.i != 2);
    startActivityForResult(paramView, 1004);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\conditionsearch\ConditionSearchFriendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */