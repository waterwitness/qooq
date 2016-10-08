package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyBaseActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import rdb;
import rdc;
import rdd;
import rde;
import rdf;
import rdh;
import rdi;
import rdk;
import rdl;
import rdm;
import rdn;
import rdo;
import rdp;
import rdq;
import rds;
import rdt;
import rdv;

public class DatingDestinationActivity
  extends NearbyBaseActivity
  implements View.OnClickListener
{
  public static int a = 0;
  static final String jdField_a_of_type_JavaLangString = "DatingDestinationActivity";
  public static final int b = 0;
  public static final String b = "is_select_mode";
  public static final int c = 1;
  public static final String c = "dating_destination_select_type";
  public static final int d = 2;
  public static final String d = "dating_destination_result";
  public static final int e = 3;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new rde(this);
  public View a;
  public EditText a;
  public ImageButton a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public appoint_define.LocaleInfo a;
  DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new rdf(this);
  public NearbyAppInterface a;
  NearbyProcObserver jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver = new rdh(this);
  public ByteStringMicro a;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new rdb(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public rds a;
  public rdt a;
  public boolean a;
  public View b;
  public appoint_define.LocaleInfo b;
  public ByteStringMicro b;
  public XListView b;
  boolean b;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = false;
  View d;
  public boolean d;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public boolean i;
  public boolean j = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 50;
  }
  
  public DatingDestinationActivity()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
    this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
  }
  
  appoint_define.LocaleInfo a(Intent paramIntent)
  {
    switch (this.jdField_f_of_type_Int)
    {
    case 0: 
    case 1: 
    default: 
      return null;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("dating_destination_result");
    if (arrayOfByte != null)
    {
      paramIntent = new appoint_define.LocaleInfo();
      try
      {
        paramIntent.mergeFrom(arrayOfByte);
        return paramIntent;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (!QLog.isColorLevel()) {
          return paramIntent;
        }
      }
      QLog.e("DatingDestinationActivity", 2, "loadSelectVal parse array fail, ask developer who call here", localInvalidProtocolBufferMicroException);
      this.jdField_f_of_type_Int = 0;
      return null;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatingDestinationActivity", 2, "intent data is null, ask developer who call here");
      }
      this.jdField_f_of_type_Int = 0;
      return null;
    }
    return paramIntent;
  }
  
  public appoint_define.LocaleInfo a(String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject = null;
      return (appoint_define.LocaleInfo)localObject;
    }
    if ((paramArrayOfString.length > 2) && (!TextUtils.isEmpty(paramArrayOfString[2]))) {}
    for (this.jdField_i_of_type_JavaLangString = paramArrayOfString[2];; this.jdField_i_of_type_JavaLangString = paramArrayOfString[1]) {
      do
      {
        appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
        if ((paramArrayOfString.length > 0) && (!TextUtils.isEmpty(paramArrayOfString[0]))) {
          localLocaleInfo.str_country.set(paramArrayOfString[0]);
        }
        if ((paramArrayOfString.length > 1) && (!TextUtils.isEmpty(paramArrayOfString[1]))) {
          localLocaleInfo.str_province.set(paramArrayOfString[1]);
        }
        if ((paramArrayOfString.length > 2) && (!TextUtils.isEmpty(paramArrayOfString[2]))) {
          localLocaleInfo.str_city.set(paramArrayOfString[2]);
        }
        if ((paramArrayOfString.length > 3) && (!TextUtils.isEmpty(paramArrayOfString[3]))) {
          localLocaleInfo.str_region.set(paramArrayOfString[3]);
        }
        localObject = localLocaleInfo;
        if (paramArrayOfString.length <= 1) {
          break;
        }
        localObject = localLocaleInfo;
        if (TextUtils.isEmpty(paramArrayOfString[1])) {
          break;
        }
        localObject = localLocaleInfo;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(paramArrayOfString[1])) {
          break;
        }
        this.jdField_i_of_type_JavaLangString = paramArrayOfString[1];
        localLocaleInfo.str_city.set(paramArrayOfString[1]);
        localObject = localLocaleInfo;
        if (paramArrayOfString.length <= 2) {
          break;
        }
        localObject = localLocaleInfo;
        if (TextUtils.isEmpty(paramArrayOfString[2])) {
          break;
        }
        localLocaleInfo.str_region.set(paramArrayOfString[2]);
        return localLocaleInfo;
      } while ((paramArrayOfString.length <= 1) || (TextUtils.isEmpty(paramArrayOfString[1])));
    }
  }
  
  public String a(String[] paramArrayOfString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        localObject2 = localObject1;
      }
    }
    else {
      return (String)localObject2;
    }
    if ((paramArrayOfString.length > 1) && (!TextUtils.isEmpty(paramArrayOfString[1])) && (this.jdField_a_of_type_JavaUtilSet.contains(paramArrayOfString[1])))
    {
      this.jdField_i_of_type_JavaLangString = paramArrayOfString[1];
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DatingDestinationActivity", 2, "turnToCityName:" + (String)localObject1);
      return (String)localObject1;
      if ((paramArrayOfString.length > 2) && (!TextUtils.isEmpty(paramArrayOfString[2])))
      {
        localObject1 = paramArrayOfString[2];
      }
      else
      {
        localObject1 = localObject3;
        if (paramArrayOfString.length > 1)
        {
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(paramArrayOfString[1])) {
            localObject1 = paramArrayOfString[1];
          }
        }
      }
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilSet.add("北京");
    this.jdField_a_of_type_JavaUtilSet.add("天津");
    this.jdField_a_of_type_JavaUtilSet.add("重庆");
    this.jdField_a_of_type_JavaUtilSet.add("上海");
    this.jdField_a_of_type_JavaUtilSet.add("北京市");
    this.jdField_a_of_type_JavaUtilSet.add("天津市");
    this.jdField_a_of_type_JavaUtilSet.add("重庆市");
    this.jdField_a_of_type_JavaUtilSet.add("上海市");
    this.jdField_h_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "current_city_code", ""));
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_f_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "current_city", ""));
    }
    this.jdField_g_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "current_city_code", ""));
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      String str = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "hometown_code", "");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = a(str.split("-"));
      }
    }
    ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2)).a();
    ThreadManager.a(new rdi(this), null, true);
  }
  
  public void a(appoint_define.LocaleInfo paramLocaleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "doSelectDestination:" + paramLocaleInfo.str_name.get());
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("dating_destination_select_type", 3);
    localIntent.putExtra("dating_destination_result", paramLocaleInfo.toByteArray());
    setResult(-1, localIntent);
    finish();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "doSelectHometown");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8004F31", "0X8004F31", 0, 0, "", "", "", "");
    paramString = getIntent();
    paramString.putExtra("dating_destination_select_type", 2);
    if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) {
      paramString.putExtra("dating_destination_result", this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray());
    }
    setResult(-1, paramString);
    finish();
  }
  
  public void a(String paramString, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "executeSearch:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_f_of_type_Boolean);
      if (!paramString.equals(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131371134));
        this.jdField_d_of_type_Boolean = false;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
        }
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro = null;
        this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2)).a(paramString, this.jdField_f_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro);
        this.jdField_e_of_type_Boolean = true;
        this.jdField_f_of_type_Boolean = true;
        return;
      }
    } while ((paramByteStringMicro == this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro) || (this.jdField_d_of_type_Boolean));
    ((DatingHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2)).a(paramString, this.jdField_f_of_type_JavaLangString, paramByteStringMicro);
    f();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    while (k < paramArrayOfString.length)
    {
      localStringBuilder.append(paramArrayOfString[k]);
      if (k != paramArrayOfString.length - 1) {
        localStringBuilder.append("-");
      }
      k += 1;
    }
    if (paramBoolean)
    {
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "current_hometown_code", paramString);
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "hometown_code", paramArrayOfString);
      return;
    }
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "current_city_code", paramString);
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "current_city", paramArrayOfString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "hometown:" + this.jdField_i_of_type_JavaLangString);
    }
    if ("中国".equals(this.jdField_i_of_type_JavaLangString)) {
      return;
    }
    runOnUiThread(new rdk(this));
  }
  
  void c()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -jdField_a_of_type_Int);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130904937);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -jdField_a_of_type_Int, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    ((TranslateAnimation)localObject2).setFillAfter(true);
    rdl localrdl = new rdl(this, (TranslateAnimation)localObject1, localDialog, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localrdl);
    ((TranslateAnimation)localObject2).setAnimationListener(localrdl);
    localDialog.setOnDismissListener(new rdm(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131371858);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new rdv(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new rdn(this));
    localObject1 = (Button)localDialog.findViewById(2131300876);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new rdo(this, localDialog));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131297767));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131297765));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new rdp(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131298733));
    this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837958);
    this.jdField_c_of_type_AndroidViewView = localDialog.getLayoutInflater().inflate(2130904137, null, false);
    this.jdField_b_of_type_ComTencentWidgetXListView.b(this.jdField_c_of_type_AndroidViewView);
    this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_Rdt = new rdt(this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Rdt);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new rdq(this, localInputMethodManager));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(new rdc(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(new rdd(this));
    if (1 == HttpUtil.a()) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8004F33", "0X8004F33", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void d()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904139);
    paramBundle = getIntent();
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("is_select_mode", false);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("dating_destination_select_type", 0);
    this.jdField_b_of_type_AppointDefineAppoint_define$LocaleInfo = a(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().d();
    paramBundle = (LinearLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramBundle.setFitsSystemWindows(true);
    }
    setTitle(2131371781);
    ((TextView)findViewById(2131297139)).setText(2131371781);
    paramBundle = (TextView)findViewById(2131297083);
    Object localObject = getIntent().getExtras().getString("leftViewText");
    paramBundle.setText((CharSequence)localObject);
    paramBundle.setContentDescription("返回" + (String)localObject + "按钮");
    paramBundle.setOnClickListener(this);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130837958));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296895);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131301540));
    paramBundle = getLayoutInflater().inflate(2130904135, null);
    localObject = paramBundle.findViewById(2131301531);
    if (this.jdField_b_of_type_Boolean)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(this);
      localObject = (ImageView)((View)localObject).findViewById(2131301532);
      if ((this.jdField_f_of_type_Int != 1) && (this.jdField_f_of_type_Int != 0)) {
        break label403;
      }
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131301533);
      this.jdField_d_of_type_AndroidViewView = paramBundle.findViewById(2131301530);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(paramBundle);
      this.jdField_a_of_type_Rds = new rds(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Rds);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      if (AppSetting.j) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription("输入你想去的地方 搜索栏");
      }
      a();
      return true;
      label403:
      ((ImageView)localObject).setVisibility(4);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().e();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_d_of_type_AndroidViewView.requestFocus();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    jdField_a_of_type_Int = (int)(50.0F * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "doSelectNoRestraint");
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("dating_destination_select_type", 1);
    localIntent.putExtra("dating_destination_result", "");
    setResult(-1, localIntent);
    finish();
  }
  
  void f()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131297388).setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301535).setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301536).setVisibility(8);
  }
  
  public void g()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131297388).setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301535).setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301536).setVisibility(0);
  }
  
  public void h()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131297388).setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301535).setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301536).setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301530: 
      c();
      return;
    case 2131301531: 
      e();
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("DatingDestinationActivity", 4, "NearbyActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingDestinationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */