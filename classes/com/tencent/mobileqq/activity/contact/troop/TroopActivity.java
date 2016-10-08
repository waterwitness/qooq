package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import oke;
import okf;
import okg;
import okh;
import oki;
import okj;
import okk;
import okl;
import okm;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback
{
  public static final int a = 0;
  protected static final int[] a;
  public static final int b = 0;
  protected static final int[] b;
  public static final int c = 1;
  public static final int d = 1;
  public static final int e = 4;
  public static final String e = "onlyOneSegement";
  public static final int f = 0;
  public static final String f = "_key_mode";
  public static final int g = 1;
  public static final String g = "messageTab";
  public static final int h = 2;
  public static final String h = "key_tab_mode";
  protected static final String j = "last_tab_mode";
  public static final int k = 1234;
  protected static final String k = "noti_and_rec_last_tab_mode";
  protected View.OnClickListener a;
  protected FrameLayout a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected BaseTroopView.ITroopContext a;
  public BaseTroopView a;
  protected ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  protected TabBarView.OnTabChangeListener a;
  public TabBarView a;
  public MqqWeakReferenceHandler a;
  protected PopupMenuDialog a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  boolean e;
  public int i;
  protected String i;
  public int j = 0;
  protected int l;
  protected int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2131364044, 2131369696, 2131364046, 2131364047 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130839391, 2130839395, 2130839392, 2130838405 };
  }
  
  public TroopActivity()
  {
    this.jdField_i_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = "DEFAULT";
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new okj(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new okl(this);
  }
  
  private int a()
  {
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.a(), 0)) {
      return localSharedPreferences.getInt("last_tab_mode", 0);
    }
  }
  
  private BaseTroopView a(int paramInt)
  {
    Object localObject;
    if (paramInt >= 4) {
      localObject = null;
    }
    BaseTroopView localBaseTroopView;
    do
    {
      return (BaseTroopView)localObject;
      localBaseTroopView = (BaseTroopView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localBaseTroopView;
    } while (localBaseTroopView != null);
    if (this.j != 2) {
      switch (paramInt)
      {
      default: 
        localObject = new TroopView(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext);
      return (BaseTroopView)localObject;
      localObject = new TroopView(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 1: 
        localObject = new RecommendTroopView(this);
        break;
      case 0: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(31);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.a(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = new okf(this);
  }
  
  private void c(int paramInt)
  {
    if (AppSetting.j)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.getChildCount();
      int n = 0;
      while (n < i1)
      {
        RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(n);
        StringBuilder localStringBuilder = new StringBuilder(24);
        if (paramInt == n) {
          localStringBuilder.append("已选定");
        }
        localStringBuilder.append(localRedDotTextView.getText()).append(" 按钮");
        localRedDotTextView.setContentDescription(localStringBuilder);
        n += 1;
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = findViewById(2131296895);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131297083);
    localObject1 = getIntent().getExtras().getString("leftViewText");
    if (localObject1 == null) {
      localObject1 = getString(2131367975);
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297392));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131297692));
      Object localObject2;
      if (this.j != 2) {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localObject2 = (TextView)findViewById(2131297139);
          if (getIntent().getBooleanExtra("onlyOneSegement", false))
          {
            findViewById(2131299601).setVisibility(8);
            if (this.jdField_i_of_type_Int != 0) {
              break label591;
            }
            ((TextView)localObject2).setText(2131367544);
          }
          label189:
          if (this.j == 2) {
            break label609;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131367544));
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131367547));
          label229:
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            ((TextView)localObject2).setText(2131364859);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299602));
          h();
          f();
          g();
          if (AppSetting.j)
          {
            if (!this.jdField_a_of_type_Boolean) {
              break label651;
            }
            localTextView.setContentDescription(((TextView)localObject2).getText() + "页面，已选中" + (String)localObject1 + "按钮");
            localTextView.postDelayed(new okh(this, localTextView), 1000L);
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多选项");
        }
        if (getIntent().getBooleanExtra("param_from_dingdong_office", false)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843457);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        ((ViewGroup.LayoutParams)localObject2).width = (localDisplayMetrics.densityDpi * 36 / 160);
        ((ViewGroup.LayoutParams)localObject2).height = -2;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        int n = localDisplayMetrics.densityDpi * 100 / 160;
        this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(n);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838587);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new okg(this));
        break;
        label591:
        if (1 != this.jdField_i_of_type_Int) {
          break label189;
        }
        ((TextView)localObject2).setText(2131367547);
        break label189;
        label609:
        ((TextView)localObject2).setText(2131367545);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131367305));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131367546));
        break label229;
        label651:
        localTextView.setContentDescription(localTextView.getText() + "返回按钮");
      }
    }
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131364825, 5);
    localActionSheet.a(2131364826, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new oki(this, localActionSheet));
    if ((!localActionSheet.isShowing()) && (this != null) && (!isFinishing())) {}
    try
    {
      localActionSheet.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (isFinishing()) {}
    BaseTroopView localBaseTroopView1;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.j != 2);
        localBaseTroopView1 = a(1);
        BaseTroopView localBaseTroopView2 = a(0);
        if (this.jdField_i_of_type_Int == 1)
        {
          int n = GroupSystemMsgController.a().a(this.app);
          if ((!localBaseTroopView2.a()) && (n > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(true);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(false);
          return;
        }
      } while (this.jdField_i_of_type_Int != 0);
      bool = ((RecommendTroopManagerImp)this.app.getManager(21)).b();
    } while ((this.j != 0) && (this.j != 2));
    if ((!localBaseTroopView1.a()) && (bool))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(false);
  }
  
  private void g()
  {
    if (this.j != 2)
    {
      switch (this.jdField_i_of_type_Int)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    switch (this.jdField_i_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
  }
  
  private void h()
  {
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    while (n < jdField_a_of_type_ArrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = n;
      localMenuItem.jdField_a_of_type_JavaLangString = getString(jdField_a_of_type_ArrayOfInt[n]);
      localMenuItem.jdField_b_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[n];
      localArrayList.add(localMenuItem);
      n += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new okk(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131370424));
    localIntent.putExtra("param_done_button_wording", getString(2131370179));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131370180));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    startActivityForResult(localIntent, 1300);
    ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.b().getWidth() - getResources().getDimensionPixelSize(2131493351) - getResources().getDimensionPixelSize(2131493355), getResources().getDimensionPixelSize(2131493356));
  }
  
  public void a(int paramInt)
  {
    BaseTroopView localBaseTroopView = a(paramInt);
    if (localBaseTroopView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == localBaseTroopView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView = localBaseTroopView;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    if (isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903657);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = new oke(this);
    }
    this.c = getIntent().getBooleanExtra("fromH5", false);
    this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("troopType");
    this.j = getIntent().getIntExtra("key_tab_mode", 0);
    this.jdField_i_of_type_Int = getIntent().getIntExtra("_key_mode", a());
    if (this.jdField_i_of_type_Int == 4) {
      this.jdField_i_of_type_Int = a();
    }
    if (this.j == 2)
    {
      if (GroupSystemMsgController.a().a(this.app) <= 0) {
        break label284;
      }
      this.jdField_i_of_type_Int = 0;
      if (this.jdField_i_of_type_Int != 1) {
        break label302;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.j = getIntent().getIntExtra("key_tab_mode", 0);
      c();
      d();
      return true;
      label284:
      if (RecommendTroopManagerImp.b(this.app) <= 0) {
        break;
      }
      this.jdField_i_of_type_Int = 1;
      break;
      label302:
      if (this.jdField_i_of_type_Int == 0) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.h();
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
      b(this.jdField_i_of_type_Int);
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Intent localIntent;
    if ((paramInt == 4) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      localIntent = new Intent();
      if (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isDataChanged", bool);
      setResult(-1, localIntent);
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
    this.e = false;
    if (!this.jdField_a_of_type_Boolean) {
      b(this.jdField_i_of_type_Int);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    this.e = true;
    f();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
    if (this.c)
    {
      a(4, this.jdField_i_of_type_JavaLangString);
      this.c = false;
      this.jdField_i_of_type_JavaLangString = "DEFAULT";
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968587, 2130968588);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new okm(this));
    }
    for (;;)
    {
      return true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
        if (localBaseTroopView != null) {
          localBaseTroopView.a(paramMessage);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.jdField_i_of_type_Int = 1;
      g();
      if (paramIntent != null)
      {
        String str1 = paramIntent.getStringExtra("roomId");
        if (str1 != null)
        {
          String str2 = ContactUtils.a(this.app, getApplicationContext(), str1);
          Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
          localIntent.putExtra("uin", str1);
          localIntent.putExtra("uintype", 3000);
          localIntent.putExtra("uinname", str2);
          startActivity(localIntent);
          ReportController.b(this.app, "CliOper", "", "", "0X8006264", "0X8006264", 0, 0, "", "", "", "");
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\TroopActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */