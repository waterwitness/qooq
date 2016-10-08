package com.tencent.mobileqq.nearpeople.ranking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Random;
import mqq.app.MobileQQ;
import tqp;
import tqq;
import tqr;
import tqs;
import tqu;

public class ShowLoveEditorActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "PHOTO_TYPE";
  public static final String b = "IS_FROM_SHOWLOVE";
  public static final String c = "SHOWLOVE_PIC";
  public static final String d = "SHOWLOVE_MSG";
  private static final String i = "SHOWLOVE_AGE";
  private static final String j = "SHOWLOVE_CONSTE";
  private static final String k = "SHOWLOVE_HOMECODE";
  private static final String l = "SHOWLOVE_NICKNAME";
  public float a;
  public View a;
  public Button a;
  public EditText a;
  public ImageView a;
  private ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener;
  public ConditionSearchManager a;
  NearbyCardHandler jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
  NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver;
  public boolean a;
  public int[] a;
  public String[] a;
  public float b;
  public int b;
  public Button b;
  public boolean b;
  public int c;
  public boolean c;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public ShowLoveEditorActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131372088, 2131372089, 2131372090, 2131372091, 2131372092, 2131372093, 2131372094, 2131372095 };
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.h = "";
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new tqp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new tqs(this);
  }
  
  private void b()
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      super.finish();
      return;
    }
    this.e = ((Intent)localObject).getExtras().getString("PhotoConst.SINGLE_PHOTO_PATH");
    localObject = this.app.getApplication().getSharedPreferences(this.app.a(), 0);
    if (!TextUtils.isEmpty(DatingUtil.c)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("SHOWLOVE_AGE", 0);
      this.jdField_c_of_type_Int = ((SharedPreferences)localObject).getInt("SHOWLOVE_CONSTE", 0);
      this.f = ((SharedPreferences)localObject).getString("SHOWLOVE_HOMECODE", "");
      this.g = ((SharedPreferences)localObject).getString("SHOWLOVE_NICKNAME", this.app.b());
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.a(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302337));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131302338));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131302339));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302340));
    ((ScrollView)findViewById(2131302336)).setOnTouchListener(new tqq(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new tqr(this));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(DatingUtil.c);
      return;
    }
    a();
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("DatingSayHello", 4, "nickName:" + this.g + "|homeCode:" + this.f + "|age:" + this.jdField_b_of_type_Int + "|constellation:" + this.jdField_c_of_type_Int);
    }
    StringBuilder localStringBuilder = new StringBuilder("Hi，我是");
    if (!TextUtils.isEmpty(this.g)) {
      localStringBuilder.append(this.g);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int > 0)
      {
        localStringBuilder.append("，今年");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("岁");
      }
      if (this.jdField_c_of_type_Int != 0)
      {
        localStringBuilder.append("，");
        localStringBuilder.append(Utils.a(this.jdField_c_of_type_Int));
      }
      if ((!TextUtils.isEmpty(this.f)) && (!this.f.equals(this.h)))
      {
        localStringBuilder.append("，来自");
        localStringBuilder.append(this.f);
      }
      int m = Math.abs(new Random().nextInt());
      Object localObject = getString(this.jdField_a_of_type_ArrayOfInt[(m % 8)]);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localStringBuilder.append("，");
        localStringBuilder.append((String)localObject);
      }
      m = 50;
      if (localStringBuilder.length() > 50) {
        m = localStringBuilder.length() + 10;
      }
      localObject = new InputFilter.LengthFilter(m);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localObject });
      this.jdField_a_of_type_AndroidWidgetEditText.setText(localStringBuilder.toString());
      return;
      localStringBuilder.append(this.app.a());
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904327);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(58));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.a(60));
    b();
    c();
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    new tqu(this, null).execute(new Void[0]);
    if (!this.jdField_c_of_type_Boolean) {
      NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.app, 0L, this.app.a(), -1);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    DatingUtil.c = "";
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localBitmapDrawable != null) && (!localBitmapDrawable.getBitmap().isRecycled())) {
      localBitmapDrawable.getBitmap().recycle();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302339: 
      finish();
      return;
    }
    if (!TextUtils.isEmpty(this.e))
    {
      new ArrayList().add(this.e);
      paramView = getIntent();
      paramView.setClassName("com.tencent.mobileqq", ChatActivity.class.getName());
      paramView.putExtra("IS_FROM_SHOWLOVE", true);
      paramView.putExtra("SHOWLOVE_PIC", this.e);
      paramView.putExtra("SHOWLOVE_MSG", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      startActivity(paramView);
      super.finish();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8005294", "0X8005294", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearpeople\ranking\ShowLoveEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */