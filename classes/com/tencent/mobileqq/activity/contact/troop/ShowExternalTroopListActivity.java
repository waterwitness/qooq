package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.MultiLineLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.OnTroopListClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import ojy;
import ojz;
import okb;
import okc;
import okd;

public class ShowExternalTroopListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ShowExternalTroopListAdapter.OnTroopListClickListener, OverScrollViewListener
{
  public static final int a = 0;
  public static final String a = "isHost";
  public static final int b = 1;
  public static final String b = "dest_uin_str";
  public static final String c = "from_troop_uin";
  public static final int d = 1;
  public static final String d = "is_from_show_ext_troop_list";
  static final int e = 100;
  public static final String e = "from";
  static final int f = 101;
  static final int g = 1000;
  public static final String h = "isDataChanged";
  protected static final String i = "rec_last_ext_show_troop_list_refresh_time";
  public Activity a;
  public Handler a;
  public View.OnClickListener a;
  protected View a;
  protected Button a;
  protected RelativeLayout a;
  protected TextView a;
  public ShowExternalTroopListAdapter a;
  public TroopManager a;
  protected TroopObserver a;
  public PullRefreshHeader a;
  protected RedDotTextView a;
  public XListView a;
  public boolean a;
  protected TextView b;
  public boolean b;
  public int c;
  protected TextView c;
  protected boolean c;
  public TextView d;
  public String f;
  public String g;
  
  public ShowExternalTroopListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = null;
    this.g = null;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ojy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new okc(this);
    this.jdField_a_of_type_AndroidOsHandler = new okd(this);
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).getLong("rec_last_ext_show_troop_list_refresh_time", 0L);
  }
  
  private boolean a()
  {
    if (NetworkUtil.h(getActivity()))
    {
      ((TroopHandler)this.app.a(20)).a(this.f, 0, 0);
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    QQToast.a(this, 2130838454, getString(2131364197), 0).b(getResources().getDimensionPixelSize(2131492908));
    return false;
  }
  
  private void b()
  {
    setContentViewNoTitle(2130903939);
    Object localObject1 = (LinearLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((LinearLayout)localObject1).setFitsSystemWindows(true);
    }
    setTitle(2131364857);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Boolean = localIntent.getExtras().getBoolean("isHost");
    Object localObject2 = localIntent.getExtras().getString("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131367975);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)findViewById(2131297183));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription(getString(2131364856));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131364855);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300572));
      localObject1 = LayoutInflater.from(this).inflate(2130903937, null);
      this.d = ((TextView)((View)localObject1).findViewById(2131299652));
      this.d.setText(getString(2131364858));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300574));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300749));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300748));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130843563);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903889, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject1);
      }
      this.f = localIntent.getExtras().getString("dest_uin_str");
      this.g = localIntent.getExtras().getString("from_troop_uin");
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter = new ShowExternalTroopListAdapter(getActivity(), this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Boolean, this.f);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      localObject2 = this.app;
      str = this.f;
      if (!this.jdField_a_of_type_Boolean) {
        break label546;
      }
    }
    label546:
    for (localObject1 = "0";; localObject1 = "1")
    {
      ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_join", "", "person_data", "exp_grp", 0, 0, str, (String)localObject1, "" + localIntent.getIntExtra("from", 0), "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
      break;
    }
  }
  
  private void c()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297535);
    Object localObject = ImageUtil.a();
    localImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.f, 3, (Drawable)localObject, (Drawable)localObject));
    localObject = a(this.app.a(this.f, (byte)1, true));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297013).bringToFront();
    if (localObject != null) {}
    try
    {
      StackBlur.a((Bitmap)localObject, 10);
      localObject = new BitmapDrawable((Bitmap)localObject);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131296895).setBackgroundDrawable((Drawable)localObject);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300570);
      ThreadManager.a(new ojz(this, (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296818), (TextView)localObject), 8, null, true);
      localImageView.setOnClickListener(new okb(this, localImageView));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void d()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).edit().putLong("rec_last_ext_show_troop_list_refresh_time", l).commit();
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int m = 0;
    if (paramBitmap == null)
    {
      paramBitmap = null;
      return paramBitmap;
    }
    int n = getResources().getDisplayMetrics().widthPixels;
    int i1 = (int)(120.0F * this.mDensity);
    int j = paramBitmap.getHeight();
    int k = paramBitmap.getWidth();
    if (k * i1 > j * n)
    {
      i1 = n * j / i1;
      n = (k - i1) / 2;
      k = i1;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, n, m, k, j);
      paramBitmap = localBitmap;
      if (localBitmap.isMutable()) {
        break;
      }
      paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, true);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      return paramBitmap;
      n = i1 * k / n;
      m = (j - n) / 2;
      j = n;
      n = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840162, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131364860);
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "exp_blank", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840120, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131364862);
      QQToast.a(this, 1, getString(2131364863), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = TroopInfoActivity.a(paramString, 18);
    Activity localActivity = getActivity();
    if (this.jdField_a_of_type_Boolean) {}
    for (int j = 1;; j = 2)
    {
      ChatSettingForTroop.a(localActivity, localBundle, j);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "1", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "0", "", "");
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    MultiLineLayout localMultiLineLayout = (MultiLineLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300571);
    localMultiLineLayout.setShowLine(2);
    localMultiLineLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < paramList.size())
      {
        TextView localTextView = new TextView(this);
        localTextView.setBackgroundResource(2130840205);
        localTextView.setTextSize(2, 14.0F);
        if (paramBoolean) {
          localTextView.setMaxWidth((int)(77.0F * this.mDensity));
        }
        localTextView.setSingleLine();
        localTextView.setTextColor(-1);
        localTextView.setShadowLayer(0.0F, 0.0F, 2.0F, Color.parseColor("#000000"));
        localTextView.setGravity(17);
        localTextView.setText((CharSequence)paramList.get(j));
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localMultiLineLayout.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        j += 1;
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if ((!a()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null)) {
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("isDataChanged", false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppActivity = this;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(51));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.b();
    }
    super.doOnDestroy();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.jdField_c_of_type_Boolean);
      setResult(-1, localIntent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b().size() == 0))
      {
        a();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter);
    }
    a();
    c();
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    switch (j)
    {
    default: 
    case 2131297183: 
    case 2131300749: 
      do
      {
        return;
        paramView = new Intent();
        paramView.putExtra("onlyOneSegement", true);
        paramView.putExtra("_key_mode", 0);
        paramView.putExtra("key_tab_mode", 1);
        paramView.putExtra("is_from_show_ext_troop_list", true);
        paramView.setClass(this, TroopActivity.class);
        startActivityForResult(paramView, 1);
        if (j == 2131297183)
        {
          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_mana", 0, 0, "", "", "", "");
          return;
        }
      } while (j != 2131300749);
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_set", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Intent();
    paramView.putExtra("isDataChanged", this.jdField_c_of_type_Boolean);
    setResult(-1, paramView);
    onBackPressed();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\ShowExternalTroopListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */