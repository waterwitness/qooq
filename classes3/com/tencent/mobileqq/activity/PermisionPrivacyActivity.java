package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.LightalkSwitchObserver;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.List;
import lyw;
import lyx;
import lyy;
import lza;
import lzc;
import lzd;
import lze;
import lzf;
import lzg;
import lzh;
import mqq.os.MqqHandler;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PhoneContactManager.IPhoneContactListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.security";
  private int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver;
  private LightalkSwitchManager jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager;
  private LightalkSwitchObserver jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  View jdField_c_of_type_AndroidViewView;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  View jdField_d_of_type_AndroidViewView;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem d;
  View e;
  public FormSwitchItem e;
  public FormSwitchItem f;
  public FormSwitchItem g;
  public FormSwitchItem h;
  
  public PermisionPrivacyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lzc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new lzd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lze(this);
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new lzf(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new lzg(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new lzh(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver = new lyx(this);
  }
  
  private void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void c()
  {
    this.jdField_d_of_type_AndroidViewView = findViewById(2131302420);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131302421);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302419);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302425));
    Object localObject1 = (ContactSyncManager)this.app.getManager(40);
    Object localObject2;
    label239:
    label266:
    boolean bool;
    if (((ContactSyncManager)localObject1).d())
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((ContactSyncManager)localObject1).c());
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131302427));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131302429));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302431));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302432));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302430));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302433));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302434));
      localObject1 = (FriendsManager)this.app.getManager(50);
      localObject2 = ((FriendsManager)localObject1).b(this.app.a());
      if (!((Card)localObject2).allowClick) {
        break label948;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject2).allowPeopleSee);
      if (((Card)localObject2).allowCalInteractive) {
        break label969;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已启用");
      localObject2 = (CardHandler)this.app.a(2);
      ((CardHandler)localObject2).j();
      ((CardHandler)localObject2).k();
      this.g = ((FormSwitchItem)findViewById(2131302435));
      this.g.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
      this.f = ((FormSwitchItem)findViewById(2131302436));
      bool = this.app.a().a();
      this.f.setChecked(bool);
      this.h = ((FormSwitchItem)findViewById(2131302437));
      this.h.setChecked(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.b());
      localObject2 = (TextView)findViewById(2131302438);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      String str = getString(2131371155);
      lyw locallyw = new lyw(this, this, "http://laidian.qq.com");
      SpannableString localSpannableString = new SpannableString(((TextView)localObject2).getText());
      localSpannableString.setSpan(locallyw, str.indexOf("了解详情"), str.length(), 17);
      ((TextView)localObject2).setText(localSpannableString);
      if (this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.a()) {
        break label982;
      }
      this.h.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      label480:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302424));
      localObject2 = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {
        break label998;
      }
      bool = true;
      label519:
      ((FormSwitchItem)localObject2).setChecked(bool);
      ((NearbyRelevantHandler)this.app.a(66)).a();
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.n());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.p());
      ThreadManager.a(new lyy(this), 5, null, true);
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.f.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.g.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.h.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302422));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      localObject1 = ((FriendsManager)localObject1).b();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label1004;
      }
    }
    label948:
    label969:
    label982:
    label998:
    label1004:
    for (localObject1 = "暂无";; localObject1 = ((List)localObject1).size() + "人")
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302423));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ThreadManager.b().post(new lza(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302418));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      d();
      if (AppSetting.j)
      {
        this.jdField_d_of_type_AndroidViewView.setContentDescription("动态权限设置");
        this.jdField_e_of_type_AndroidViewView.setContentDescription(getString(2131370963));
        this.jdField_a_of_type_AndroidViewView.setContentDescription("加好友设置");
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("向好友展示网络状态");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("允许附近的人赞我");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("个性签名同步到说说");
        this.f.setContentDescription("接收约会消息");
        this.h.setContentDescription("接收来电消息");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("连续登录天数对他人可见");
      }
      return;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label239;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("未启用");
      break label266;
      this.h.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      break label480;
      bool = false;
      break label519;
    }
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "bindState = " + i);
    }
    String str2 = "";
    String str1;
    if ((i == 1) || (i == 2)) {
      str1 = "未启用";
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str1);
      return;
      if (((i == 4) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c())) || (i == 3))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().isStopFindMatch) {
          str1 = "未启用";
        } else {
          str1 = "未匹配";
        }
      }
      else if (i != 6)
      {
        str1 = str2;
        if (i == 4)
        {
          str1 = str2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) {}
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c() == 1)
      {
        str1 = "未匹配";
      }
      else
      {
        str1 = "已匹配";
      }
    }
  }
  
  void a()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("title", getString(2131370964));
    startActivity(localIntent.putExtra("url", "http://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(long paramLong) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    d();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004951", "0X8004951", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004952", "0X8004952", 0, 0, "", "", "", "");
  }
  
  public void c(int paramInt) {}
  
  public void d(int paramInt) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    super.setContentView(2130904349);
    setTitle(2131370951);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager = ((LightalkSwitchManager)this.app.getManager(85));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(84));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    c();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver);
    this.app.s();
    this.app.t();
    this.app.c(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131302424: 
    case 2131302425: 
    case 2131302426: 
    case 2131302427: 
    case 2131302428: 
    case 2131302429: 
    default: 
      return;
    case 2131302419: 
      a();
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      return;
    case 2131302420: 
      paramView = QZoneHelper.UserInfo.a();
      paramView.a = this.app.a();
      paramView.b = this.app.b();
      QZoneHelper.b(this, paramView, -1);
      return;
    case 2131302421: 
      startActivity(new Intent(this, QQStoryFriendSettings.class));
      ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "clk_set", 0, 0, "", "", "", "");
      return;
    case 2131302422: 
      startActivity(new Intent(this, SpecailCareListActivity.class));
      return;
    case 2131302423: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004C47", "0X8004C47", 3, 0, "", "", "", "");
      paramView = new Intent(this, UncommonlyUsedContactsActivity.class);
      paramView.putExtra("isBack2Root", true);
      paramView.addFlags(67108864);
      startActivity(paramView);
      return;
    case 2131302418: 
      int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "bindState = " + i);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800689F", "0X800689F", 0, 0, "", "", "", "");
      Object localObject = null;
      paramView = (View)localObject;
      switch (i)
      {
      default: 
        paramView = new Intent(this, SettingActivity2.class);
        paramView.putExtra("kSrouce", 7);
      }
      while (paramView != null)
      {
        paramView.addFlags(67108864);
        startActivity(paramView);
        return;
        ContactUtils.a(4);
        paramView = new Intent(this, BindNumberActivity.class);
        paramView.putExtra("key_from_setting", true);
        ReportController.b(this.app, "CliOper", "", "", "0X80053E1", "0X80053E1", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X80068A0", "0X80068A0", 0, 0, "", "", "", "");
        continue;
        RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
        paramView = (View)localObject;
        if (localRespondQueryQQBindingStat != null)
        {
          paramView = (View)localObject;
          if (localRespondQueryQQBindingStat.lastUsedFlag == 3L)
          {
            paramView = new Intent(this.app.a().getApplicationContext(), PhoneMatchActivity.class);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().isStopFindMatch)
            {
              paramView = new Intent(this, PhoneLaunchActivity.class);
              paramView.putExtra("needAlert", true);
              paramView.putExtra("fromStopAndMatch", true);
              paramView.putExtra("fromPermiPriv", true);
              paramView.putExtra("leftViewText", "返回");
            }
            else
            {
              paramView = new Intent(this, SettingActivity2.class);
              paramView.putExtra("kSrouce", 7);
            }
          }
        }
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
    startActivity(new Intent(this, ShowReactiveActivity.class));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PermisionPrivacyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */