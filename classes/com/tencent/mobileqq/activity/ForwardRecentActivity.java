package com.tencent.mobileqq.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.DisplayData;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.ForwardViewHolder;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardConstants;
import com.tencent.mobileqq.forward.ForwardH5PTVOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ljg;
import ljh;
import lji;
import ljj;
import ljk;
import ljl;
import ljm;
import ljn;
import ljo;
import ljp;
import ljq;

public class ForwardRecentActivity
  extends ForwardBaseActivity
  implements ForwardConstants
{
  public static final int a = 10;
  static final String jdField_a_of_type_JavaLangString = "ForwardOption.ForwardEntranceActivity";
  public static final int b = 20000;
  public static final String b = "k_cancel_button";
  public static final int c = 20001;
  public static final String c = "k_forward_title";
  public static final int d = 20002;
  public static final String d = "call_by_forward";
  public static final int e = 20003;
  protected static final String e = "forward_type";
  protected static final String f = "forward_thumb";
  protected static final String g = "forward_text";
  protected static final String h = "key_jump_from_qzone_feed";
  protected static final String i = "key_jump_from_qzone_feed_left_title";
  public Uri a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private ForwardRecentListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public ForwardBaseOption a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  View c;
  View d;
  View e;
  int jdField_f_of_type_Int;
  View jdField_f_of_type_AndroidViewView;
  View g;
  View h;
  private View i;
  String j;
  public String k;
  
  public ForwardRecentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.k = "";
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ljp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ljq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ljh(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new lji(this);
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int m = paramContext.getColumnIndexOrThrow("_data");
        paramContext.moveToFirst();
        paramUri = paramContext.getString(m);
        paramContext.close();
        return paramUri;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private List a(List paramList)
  {
    return this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(paramList);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296895));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296896));
    super.findViewById(2131297083).setVisibility(8);
    super.findViewById(2131297391).setVisibility(8);
    super.findViewById(2131297392).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.b());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297183));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367262);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.j) {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297417));
    if (AppSetting.j) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentWidgetXListView, 2);
    }
    Object localObject = LayoutInflater.from(this);
    View localView = ((LayoutInflater)localObject).inflate(2130904932, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    localView.findViewById(2131300876).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131300895);
    localEditText.setFocusable(false);
    localEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    this.i = ((LayoutInflater)localObject).inflate(2130903362, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.i.setOverScrollMode(2);
    }
    if (this.jdField_f_of_type_Int != 9501) {
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.i);
    }
    this.jdField_a_of_type_AndroidViewView = this.i.findViewById(2131298279);
    this.jdField_b_of_type_AndroidViewView = this.i.findViewById(2131297753);
    this.c = this.i.findViewById(2131297758);
    this.d = this.i.findViewById(2131298277);
    this.e = this.i.findViewById(2131298281);
    this.jdField_f_of_type_AndroidViewView = this.i.findViewById(2131298274);
    this.g = this.i.findViewById(2131298275);
    this.h = this.i.findViewById(2131298276);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject = ((LayoutInflater)localObject).inflate(2130903211, null);
    ((View)localObject).setFocusable(true);
    ((TextView)((View)localObject).findViewById(2131297700)).setText(2131367570);
    this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f)) {
      c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.k)) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.g)) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.e)) {
      f();
    }
  }
  
  private void a(int paramInt)
  {
    int m = 32;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) {
      m = 33;
    }
    paramInt = m;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.i)) {
      paramInt = m | 0x100;
    }
    m = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.j)) {
      m = paramInt | 0x4;
    }
    paramInt = m;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.h)) {
      paramInt = m | 0x800;
    }
    m = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)) {
      m = paramInt | 0x8;
    }
    paramInt = m;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) {
      paramInt = m | 0x10;
    }
    ContactSearchComponentActivity.a(this, null, 7, paramInt, 561243);
    ReportController.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
  }
  
  private void b()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.i);
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
          }
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.m)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
          }
          this.h.setVisibility(8);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
          }
          this.g.setVisibility(8);
        }
      } while (!(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardH5PTVOption));
      if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.h.setVisibility(8);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b));
    if (QLog.isColorLevel()) {
      QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends");
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private void c()
  {
    View localView = getLayoutInflater().inflate(2130904907, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131296790)).setBackgroundResource(2130840319);
    TextView localTextView = (TextView)localView.findViewById(2131297741);
    localTextView.setText("我的电脑");
    localTextView.setContentDescription("我的电脑");
    localView.setOnClickListener(new ljj(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    if (((RegisterProxySvcPackHandler)this.app.a(10)).f() != 0)
    {
      localView = getLayoutInflater().inflate(2130904907, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      ((ImageView)localView.findViewById(2131296790)).setBackgroundResource(2130840317);
      localTextView = (TextView)localView.findViewById(2131297741);
      localTextView.setText("我的iPad");
      localTextView.setContentDescription("我的iPad");
      localView.setOnClickListener(new ljk(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    }
  }
  
  private void d()
  {
    View localView = getLayoutInflater().inflate(2130904907, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131296790)).setBackgroundResource(2130840309);
    ((TextView)localView.findViewById(2131297741)).setText(2131365926);
    localView.setOnClickListener(new ljl(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
  }
  
  private void e()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.app.a(51);
    DeviceInfo[] arrayOfDeviceInfo;
    if (localSmartDeviceProxyMgr.a())
    {
      arrayOfDeviceInfo = localSmartDeviceProxyMgr.a();
      if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
        break label35;
      }
    }
    label35:
    do
    {
      return;
      arrayOfDeviceInfo = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(arrayOfDeviceInfo);
    } while (arrayOfDeviceInfo == null);
    int n = arrayOfDeviceInfo.length;
    int m = 0;
    label55:
    DeviceInfo localDeviceInfo;
    if (m < n)
    {
      localDeviceInfo = arrayOfDeviceInfo[m];
      if (localDeviceInfo.isAdmin != 2) {
        break label84;
      }
    }
    for (;;)
    {
      m += 1;
      break label55;
      break;
      label84:
      if ((!localSmartDeviceProxyMgr.d(localDeviceInfo.din)) || (localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17)))
      {
        View localView = super.getLayoutInflater().inflate(2130904907, this.jdField_a_of_type_ComTencentWidgetXListView, false);
        ((ImageView)localView.findViewById(2131296790)).setImageBitmap(DeviceHeadMgr.a().a(String.valueOf(localDeviceInfo.din)));
        TextView localTextView = (TextView)localView.findViewById(2131297741);
        String str = SmartDeviceUtil.a(localDeviceInfo);
        localTextView.setText(str);
        localView.setOnClickListener(new ljm(this, super.getResources(), localDeviceInfo, str));
        this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
      }
    }
  }
  
  private void f()
  {
    View localView = getLayoutInflater().inflate(2130904907, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131296790)).setBackgroundResource(2130842640);
    ((TextView)localView.findViewById(2131297741)).setText(2131369288);
    localView.setOnClickListener(new ljn(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
  }
  
  private void g()
  {
    if (this.app.e())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.app.a().a().a(true));
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter == null)
      {
        ljo localljo = new ljo(this);
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter = new ForwardRecentListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, localljo);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void h()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject = new Bundle(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
    ((Bundle)localObject).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((Bundle)localObject).getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    PhotoUtils.a(this, localIntent, localArrayList, 0, false);
    if (NetworkUtil.a(BaseApplication.getContext()) != 0) {
      QQToast.a(this.app.a(), 2, 2131369287, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, long paramLong)
  {
    paramAdapterView = (ForwardRecentListAdapter.ForwardViewHolder)paramView.getTag();
    paramView = paramAdapterView.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter$DisplayData.a;
    if ((this.jdField_a_of_type_Boolean) && (paramView != null)) {}
    Bundle localBundle;
    switch (paramView.type)
    {
    default: 
      if (paramView != null)
      {
        localBundle = new Bundle();
        localBundle.putInt("uintype", paramView.type);
        localBundle.putString("uin", paramView.uin);
        localBundle.putString("troop_uin", paramView.troopUin);
        if (paramView.type != 3000) {
          break label296;
        }
        localBundle.putString("uinname", ForwardUtils.a(this.app, paramAdapterView.jdField_a_of_type_JavaLangString, paramView.uin));
      }
      break;
    }
    for (;;)
    {
      localBundle.putBoolean("forward_report_confirm", true);
      localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
      localBundle.putString("forward_report_confirm_reverse2", "5");
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), localBundle);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.d();
      return;
      ReportCenter.a().a(this.app.getAccount(), "", this.k, "1000", "30", "0", false);
      break;
      ReportCenter.a().a(this.app.getAccount(), "", this.k, "1000", "31", "0", false);
      break;
      ReportCenter.a().a(this.app.getAccount(), "", this.k, "1000", "32", "0", false);
      break;
      label296:
      localBundle.putString("uinname", paramAdapterView.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected boolean a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(getIntent(), this.app, this);
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a();
      if (isFinishing()) {
        return false;
      }
    }
    else
    {
      finish();
      return false;
    }
    paramBundle = getIntent();
    try
    {
      this.jdField_f_of_type_Int = paramBundle.getIntExtra("forward_source_uin_type", 0);
      this.jdField_a_of_type_AndroidNetUri = paramBundle.getData();
      if (paramBundle.getIntExtra("forward_type", -1) == 11) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.j = paramBundle.getStringExtra("pkg_name");
      long l = paramBundle.getLongExtra("req_share_id", 0L);
      if (l > 0L) {
        this.k = String.valueOf(l);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->doOnCreate_init--isSdkShare = " + this.jdField_a_of_type_Boolean + ", pkgName = " + this.j + ", appid =" + this.k);
      }
      a();
      if (this.app.a() == null) {
        finish();
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.c();
      b();
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "exception in ForwardRecentActivity", paramBundle);
        }
        finish();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa end:" + System.currentTimeMillis());
    }
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 1) || (20000 != paramInt1))
    {
      do
      {
        return;
        if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
          setResult(10, paramIntent);
        }
        for (;;)
        {
          finish();
          return;
          setResult(-1, paramIntent);
        }
        setResult(-1, paramIntent);
        finish();
        return;
        if (paramIntent.getBooleanExtra("select_memeber_single_friend", false))
        {
          localObject1 = paramIntent.getExtras();
          paramInt2 = paramIntent.getIntExtra("select_memeber_single_friend_type", 2);
          paramInt1 = paramInt2;
          if (paramInt2 == 4) {
            paramInt1 = 1;
          }
          paramInt2 = paramInt1;
          if (paramInt1 == 0) {
            paramInt2 = 2;
          }
          ((Bundle)localObject1).putBoolean("forward_report_confirm", true);
          ((Bundle)localObject1).putString("forward_report_confirm_action_name", "0X8005A14");
          ((Bundle)localObject1).putString("forward_report_confirm_reverse2", Integer.toString(paramInt2));
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), (Bundle)localObject1);
          ReportCenter.a().a(this.app.getAccount(), "", this.k, "1000", "30", "0", false);
          return;
        }
        localObject1 = paramIntent.getStringExtra("roomId");
        if (!StringUtil.b((String)localObject1))
        {
          g();
          ReportController.b(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
          paramInt1 = paramIntent.getIntExtra("select_memeber_discussion_memeber_count", 0);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
          ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A15");
          ((Bundle)localObject2).putString("forward_report_confirm_reverse2", Integer.toString(paramInt1));
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a((String)localObject1, paramIntent.getStringExtra("discussName"), (Bundle)localObject2);
        }
        ReportCenter.a().a(this.app.getAccount(), "", this.k, "1000", "32", "0", false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(paramInt1, paramInt2, paramIntent);
        return;
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().getString("EditImagePath");
      } while (paramIntent == null);
      Object localObject1 = this.app.getAccount();
      Object localObject2 = this.app.b();
      String str = this.app.a(false, (String)localObject1);
      if ((getIntent().getFlags() & 0x2000000) == 33554432) {
        QLog.e("ForwardOption.ForwardEntranceActivity", 2, "contain FLAG_ACTIVITY_FORWARD_RESULT Flag");
      }
      PhotoMagicStickUtils.a(paramIntent, this, true, 4, (String)localObject1, (String)localObject2, str);
      overridePendingTransition(2130968620, 2130968621);
      return;
      SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
      return;
    }
    finish();
  }
  
  public void doOnBackPressed()
  {
    if (!isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131559171);
    super.doOnCreate(paramBundle);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    setContentViewNoTitle(2130903364);
    return a(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.b();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.q();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    int m = 1;
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "ForwardOption.ForwardEntranceActivity onNewIntent()");
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        break label54;
      }
    }
    label54:
    int n;
    label270:
    label286:
    for (;;)
    {
      return;
      paramIntent = (String)paramIntent.get(0);
      Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a();
      n = localBundle.getInt("key_forward_ability_type", 0);
      String str1 = localBundle.getString("uin");
      int i1 = localBundle.getInt("uintype", -1);
      String str2 = localBundle.getString("troop_uin");
      localBundle.getString("uinname");
      boolean bool = localBundle.getBoolean("FORWARD_IS_QZONE_SHARE");
      localBundle.putBoolean("FORWARD_IS_EDITED", true);
      if (!bool) {
        break;
      }
      if ((n == ForwardAbility.ForwardAbilityType.f.intValue()) || (n == ForwardAbility.ForwardAbilityType.l.intValue()))
      {
        LiteActivity.a(this.app, paramIntent, this);
        bool = true;
        m = 0;
        if (!bool) {
          break label270;
        }
        setResult(-1);
      }
      for (;;)
      {
        if (m != 0) {
          break label286;
        }
        finish();
        return;
        if (n == ForwardAbility.ForwardAbilityType.g.intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_filepath", paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.o();
          bool = true;
          break;
        }
        bool = ForwardSendPicUtil.a(this.app, paramIntent, str1, i1, str2, true, this);
        m = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "failed to send pic from qzone");
        }
      }
    }
    if ((n == ForwardAbility.ForwardAbilityType.f.intValue()) || (n == ForwardAbility.ForwardAbilityType.l.intValue()))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_extra", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.b(n);
      return;
    }
    if (n == ForwardAbility.ForwardAbilityType.g.intValue())
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.o();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    h();
    ReportController.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (AppSetting.j)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("取消");
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(new ljg(this), 1000L);
    }
    if (BaseApplicationImpl.c > 0L) {
      Log.d("AutoMonitor", "actStartSel, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.c));
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968583, 2130968584);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\ForwardRecentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */