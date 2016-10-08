package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.GraphicTabBarView;
import com.tencent.mobileqq.widget.GraphicTabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vem;
import ven;
import veo;
import vep;
import veq;
import ver;
import ves;

public class NearbyTroopsActivity
  extends AbsBaseWebViewActivity
  implements Handler.Callback, View.OnTouchListener
{
  public static final int a = 886;
  public static final String a = "TAB_INDEX";
  public static final boolean a;
  protected static final int[] a;
  public static final String b = "http://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&atvtype=city&source=nearby";
  protected static final int[] b;
  public static final String c = "http://qqweb.qq.com/m/qunactivity/discover.html?_wv=3&_bid=244&from=nearby_dyn";
  public static final int d = 1229;
  public static final String d = "NearbyTroopsActivity";
  public static final int e = 1339;
  public static final int f = -1;
  public static final int g = 0;
  public static final int h = 1;
  public static final String h = "886.100170";
  public static final int i = 2;
  public static final String i = "886.100171";
  public static final String j = "886.100172";
  public static final int k = -1;
  public static final String k = "tab_index";
  public static final int l = 0;
  public static final String l = "selectedIndex";
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  public Context a;
  public Drawable a;
  protected View.OnClickListener a;
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  public TroopMemberApiClient a;
  public NearbyTroopsBaseView.INearbyTroopContext a;
  public NearbyTroopsBaseView a;
  protected GraphicTabBarView.OnTabChangeListener a;
  public GraphicTabBarView a;
  public MqqWeakReferenceHandler a;
  protected PopupMenuDialog a;
  ArrayList a;
  public String[] a;
  public int[][] a;
  public int b;
  protected View.OnClickListener b;
  protected TextView b;
  protected NearbyTroopsBaseView b;
  boolean b;
  protected String[] b;
  public int c;
  protected boolean c;
  public String e;
  public String f;
  public String g = "";
  public int j = -1;
  public int r = 0;
  public int s = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = AppSetting.j;
    jdField_a_of_type_ArrayOfInt = new int[] { 2131364044, 2131364973 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130839391, 2130839390 };
  }
  
  public NearbyTroopsActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Array2dOfInt = new int[][] { { 2130839475, 2130839474 }, { 2130839471, 2130839470 }, { 2130839473, 2130839472 } };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "886.100170", "886.100171", "886.100172" };
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vem(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView$OnTabChangeListener = new veq(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ves(this);
  }
  
  private Intent a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    return localIntent;
  }
  
  private NearbyTroopsBaseView a(int paramInt)
  {
    Object localObject;
    if (paramInt == -1) {
      localObject = null;
    }
    NearbyTroopsBaseView localNearbyTroopsBaseView;
    do
    {
      return (NearbyTroopsBaseView)localObject;
      localNearbyTroopsBaseView = (NearbyTroopsBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localNearbyTroopsBaseView;
    } while (localNearbyTroopsBaseView != null);
    switch (paramInt)
    {
    default: 
      localObject = new NearbyTroopsView(this);
      ((NearbyTroopsBaseView)localObject).a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      return (NearbyTroopsBaseView)localObject;
      localObject = new NearbyTroopsView(this);
      ((NearbyTroopsBaseView)localObject).a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
      continue;
      localObject = new NearbyActivityView(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = ((NearbyTroopsBaseView)localObject);
      ((NearbyTroopsBaseView)localObject).a(a("http://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&atvtype=city&source=nearby"), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
      continue;
      localObject = new NearbyActivityView(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = ((NearbyTroopsBaseView)localObject);
      ((NearbyTroopsBaseView)localObject).a(a("http://qqweb.qq.com/m/qunactivity/discover.html?_wv=3&_bid=244&from=nearby_dyn"), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    a(paramContext, paramQQAppInterface, paramString, paramInt1, paramInt2, null, -1, -1);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    if ((paramContext == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyTroopsActivity", 2, "openNearbyTroopsActivity failed! from：" + paramInt1);
      }
      return;
    }
    Intent localIntent = new Intent(paramContext, NearbyTroopsActivity.class);
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("mode", paramInt2);
    if ((paramInt3 != -1) && (paramInt4 != -1))
    {
      localIntent.putExtra("lat", paramInt3);
      localIntent.putExtra("lon", paramInt4);
    }
    if (paramString2 != null) {
      localIntent.putExtra("location_name", paramString2);
    }
    paramQQAppInterface = paramQQAppInterface.a().a();
    if (paramQQAppInterface != null)
    {
      paramInt1 = 0;
      if (paramInt1 < paramQQAppInterface.size())
      {
        paramString2 = (ResourcePluginInfo)paramQQAppInterface.get(paramInt1);
        if (paramString2.uiResId != 886L) {}
      }
    }
    for (paramQQAppInterface = paramString2.strResName;; paramQQAppInterface = null)
    {
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localIntent.putExtra("config_res_plugin_item_name", paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        paramInt1 = Integer.valueOf(paramString1).intValue();
        localIntent.putExtra("TAB_INDEX", paramInt1);
        paramContext.startActivity(localIntent);
        return;
        paramInt1 += 1;
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyTroopsActivity", 2, "NumberFormatException");
          }
          paramInt1 = 0;
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = new vep(this);
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < jdField_a_of_type_ArrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i1;
      localMenuItem.jdField_a_of_type_JavaLangString = getString(jdField_a_of_type_ArrayOfInt[i1]);
      localMenuItem.jdField_b_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[i1];
      localArrayList.add(localMenuItem);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new ver(this));
  }
  
  public void a()
  {
    View localView = findViewById(2131299690);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(localView, localView.getWidth() - getResources().getDimensionPixelSize(2131493351) - getResources().getDimensionPixelSize(2131493355), getResources().getDimensionPixelSize(2131493356));
  }
  
  public void a(int paramInt)
  {
    NearbyTroopsBaseView localNearbyTroopsBaseView = a(paramInt);
    if (localNearbyTroopsBaseView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView == localNearbyTroopsBaseView);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = localNearbyTroopsBaseView;
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.g();
    if (isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.c();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(null);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int[] arrayOfInt = paramBundle.getIntArray("iNewFlags");
    paramBundle = paramBundle.getIntArray("types");
    int i1 = this.j;
    int i2 = i1;
    if (arrayOfInt != null)
    {
      i2 = i1;
      if (paramBundle != null)
      {
        i2 = i1;
        if (arrayOfInt.length == paramBundle.length)
        {
          i2 = i1;
          if (arrayOfInt.length == this.jdField_b_of_type_ArrayOfJavaLangString.length)
          {
            int i3 = 0;
            i2 = i1;
            i1 = i3;
            while (i1 < paramBundle.length)
            {
              i3 = i2;
              if (arrayOfInt[i1] != 0)
              {
                i3 = i2;
                if (paramBundle[i1] != -1)
                {
                  RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(i1);
                  if (localRedDotTextView != null) {
                    localRedDotTextView.a(true);
                  }
                  i3 = i2;
                  if (i2 == -1) {
                    i3 = i1;
                  }
                }
              }
              i1 += 1;
              i2 = i3;
            }
          }
        }
      }
    }
    if (i2 == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setTabSelected(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setTabSelected(i2);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    super.setTitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      localObject = this.rightViewImg.getLayoutParams();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      ((ViewGroup.LayoutParams)localObject).width = (localDisplayMetrics.densityDpi * 36 / 160);
      ((ViewGroup.LayoutParams)localObject).height = -2;
      this.rightViewImg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i1 = localDisplayMetrics.densityDpi * 100 / 160;
      this.rightViewImg.setMaxWidth(i1);
      this.rightViewImg.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.rightViewText.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299602));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView = ((GraphicTabBarView)findViewById(2131297692));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(0, getString(2131364970), this.jdField_a_of_type_Array2dOfInt[0][0]);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(1, getString(2131364971), this.jdField_a_of_type_Array2dOfInt[1][1]);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.a(2, getString(2131364972), this.jdField_a_of_type_Array2dOfInt[2][1]);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView$OnTabChangeListener);
      f();
    }
    this.f = paramIntent.getExtras().getString("leftViewText");
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(this.f);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("mode", 0);
    Object localObject = paramIntent.getStringExtra("config_res_plugin_item_name");
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setVisibility(8);
      paramIntent = paramIntent.getStringExtra("location_name");
      if (TextUtils.isEmpty(paramIntent)) {
        break label440;
      }
      if (TextUtils.isEmpty(paramIntent)) {
        break label445;
      }
      b(paramIntent);
      label333:
      if ((this.jdField_c_of_type_Int != 10) && (this.jdField_c_of_type_Int != 23) && (this.jdField_c_of_type_Int != 11)) {
        break label456;
      }
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131364987);
      label387:
      if (this.jdField_c_of_type_Int != 23) {
        break label506;
      }
      this.r = 5;
    }
    for (;;)
    {
      if ((!paramBoolean) || (this.jdField_b_of_type_Int != 0)) {
        break label540;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_b_of_type_ArrayOfJavaLangString, new ven(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setVisibility(0);
      label440:
      paramIntent = (Intent)localObject;
      break;
      label445:
      b(2131367336, -1);
      break label333;
      label456:
      this.rightViewImg.setVisibility(0);
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setBackgroundResource(2130843457);
      this.rightViewImg.setImageResource(2130838587);
      this.rightViewImg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      break label387;
      label506:
      if (this.jdField_c_of_type_Int == 10) {
        this.r = 3;
      } else if (this.jdField_c_of_type_Int == 11) {
        this.r = 4;
      }
    }
    label540:
    if (this.j == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setTabSelected(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGraphicTabBarView.setTabSelected(this.j);
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("is_show_mapentry", false);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("from", 0);
    a(paramBoolean, paramIntent);
    return true;
  }
  
  public void b()
  {
    if (c()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
    ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_order", 0, 0, "3", "", "", "");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      setTitle(paramInt1);
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramInt2 == -1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams.topMargin = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = DisplayUtil.a(BaseApplication.getContext(), 6.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt2);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(CharSequence paramCharSequence)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    a(paramCharSequence);
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i1 = 0;
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    super.doOnCreate(paramBundle);
    setContentView(2130903680);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.g = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    }
    if (TextUtils.isEmpty(this.g))
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    paramBundle = getIntent();
    paramBundle.putExtra("portraitOnly", true);
    this.j = paramBundle.getIntExtra("TAB_INDEX", -1);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    c();
    a(true, paramBundle);
    getWindow().setBackgroundDrawable(null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = findViewById(2131297831);
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    paramBundle = this.app;
    Class localClass = getClass();
    int i2 = hashCode();
    if (this.jdField_c_of_type_Int == 23) {
      i1 = 1;
    }
    ViewExposeUtil.a(paramBundle, localClass, i2, "0X8004EC7", i1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      NearbyTroopsBaseView localNearbyTroopsBaseView = (NearbyTroopsBaseView)((Iterator)localObject).next();
      if (localNearbyTroopsBaseView != null) {
        localNearbyTroopsBaseView.a();
      }
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
    super.doOnDestroy();
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null) {
      ReportController.b(this.app, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).b), "", "", "");
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.j = paramIntent.getIntExtra("TAB_INDEX", -1);
    a(false, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.a(paramIntent);
    }
    getWindow().setBackgroundDrawable(null);
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.d();
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.c();
    }
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.e();
    }
    super.doOnStop();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if (paramMessage.what == 1229) {
      if (paramMessage.arg1 == 0)
      {
        bool = true;
        runOnUiThread(new veo(this, bool));
      }
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        NearbyTroopsBaseView localNearbyTroopsBaseView = (NearbyTroopsBaseView)localIterator.next();
        if (localNearbyTroopsBaseView != null) {
          localNearbyTroopsBaseView.a(paramMessage);
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onRestart()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.h();
    }
    super.onRestart();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setContentView(int paramInt)
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    super.setContentView(paramInt);
    View localView = findViewById(2131297082);
    if (localView != null) {
      localView.setVisibility(8);
    }
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130843153));
    localView = findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localView.setFitsSystemWindows(true);
    }
    this.vg = ((ViewGroup)findViewById(2131299690));
    setLayerType(this.vg);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.vg.findViewById(2131297139));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.vg.findViewById(2131299692));
    this.rightViewText = ((TextView)this.vg.findViewById(2131297183));
    this.rightViewImg = ((ImageView)this.vg.findViewById(2131297392));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.vg.findViewById(2131297445));
    this.leftView = ((TextView)this.vg.findViewById(2131297083));
    this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setLayerType(this.leftView);
  }
  
  protected String setLastActivityName()
  {
    if (this.jdField_b_of_type_Boolean) {
      return getString(2131367541);
    }
    return super.setLastActivityName();
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public boolean startTitleProgress()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)) {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    while (!QLog.isColorLevel()) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startTitleProgress, ad !instanceof Animatable, isNull=");
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      bool = true;
    }
    QLog.d("NearbyTroopsActivity", 2, bool);
    return true;
  }
  
  public boolean stopTitleProgress()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    while (!QLog.isColorLevel())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("stopTitleProgress, ad !instanceof Animatable, isNull=");
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NearbyTroopsActivity", 2, bool);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyTroopsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */