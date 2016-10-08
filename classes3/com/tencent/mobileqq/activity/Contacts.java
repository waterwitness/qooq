package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lbe;
import lbf;
import lbg;
import lbh;
import lbi;
import lbj;
import lbk;
import lbl;
import lbm;
import lbn;
import lbo;
import lbp;
import lbq;
import lbr;
import lbs;
import mqq.os.MqqHandler;

public class Contacts
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, RadioGroup.OnCheckedChangeListener, CommonLoadingView.OnFirstDrawListener, NewFriendManager.INewFriendListener, PhoneContactManager.IPhoneContactListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, OverScrollViewListener
{
  private static final int A = 9527;
  private static final int B = 9528;
  private static final String jdField_a_of_type_JavaLangString = "last_buddy_list_refresh_time";
  static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "Contacts";
  static final int jdField_c_of_type_Int = 2;
  static final int jdField_d_of_type_Int = 3;
  static final int jdField_e_of_type_Int = 4;
  static final int jdField_f_of_type_Int = 6;
  static final int jdField_g_of_type_Int = 800;
  static final int h = 1000;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 5;
  public static final int o = 6;
  public static final int p = 7;
  public static final int q = 8;
  public static final int r = 9;
  public static final int s = 10;
  public static final int t = 11;
  public static final int u = 12;
  public static final int v = 13;
  public static final int w = 14;
  public static final int x = 15;
  public static final int y = 16;
  private static final int z = 1400;
  public int a;
  View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final SmartDeviceObserver jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver;
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private AllBuddyListAdapter jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter;
  public BuddyListAdapter a;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public FPSPinnedHeaderExpandableListView a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public PullRefreshHeader a;
  private RedDotTextView jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private final lbo jdField_a_of_type_Lbo;
  private final lbq jdField_a_of_type_Lbq;
  private final lbr jdField_a_of_type_Lbr;
  private final lbs jdField_a_of_type_Lbs;
  public MqqHandler a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private GameCenterObserver jdField_b_of_type_ComTencentMobileqqObserverGameCenterObserver;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  public PullRefreshHeader b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  public boolean e;
  private View jdField_f_of_type_AndroidViewView;
  public boolean f;
  private boolean jdField_g_of_type_Boolean;
  
  public Contacts()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaLangString = "com.tencent.mobileqq";
    this.jdField_a_of_type_Lbq = new lbq(this, null);
    this.jdField_a_of_type_Lbo = new lbo(this, null);
    this.jdField_a_of_type_Lbr = new lbr(this, null);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new lbp(this, null);
    this.jdField_a_of_type_Lbs = new lbs(this, null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new lbe(this);
    this.jdField_b_of_type_ComTencentMobileqqObserverGameCenterObserver = new lbg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new lbk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new lbl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new lbm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new lbn(this);
    this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver = new lbf(this);
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(a()).inflate(2130903203, paramViewGroup, false);
    paramViewGroup.setOnClickListener(this);
    return paramViewGroup;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null)) {
      return;
    }
    Object localObject = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    int i1;
    if (paramInt == 0)
    {
      localObject = ((NewFriendManager)localObject).a();
      if ((localObject == null) || (!((NewFriendMessage)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label226;
      }
      localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((NewFriendMessage)localObject).a());
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (paramBoolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
      }
      i1 = 1;
    }
    for (;;)
    {
      if (i1 == 1) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        CustomWidgetUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i1, paramInt, 0);
        a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i1);
        return;
        if (paramInt <= 0) {
          break label226;
        }
        if (paramBoolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
        }
        i1 = 3;
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      label226:
      i1 = 0;
    }
  }
  
  private void a(View paramView)
  {
    Object localObject = paramView.getTag(-2);
    paramView = paramView.getTag(-10);
    if ((!(localObject instanceof Integer)) || ((!(paramView instanceof Friends)) && (!(paramView instanceof TroopInfo)) && (!(paramView instanceof DiscussionInfo)))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("Contacts", 2, "handleRightMenuClick onClick tag is not int");
      }
    }
    do
    {
      int i1;
      do
      {
        return;
        if (!NetworkUtil.h(a()))
        {
          QQToast.a(a(), 1, 2131367256, 1).a();
          return;
        }
        if (!(paramView instanceof Friends)) {
          break;
        }
        i1 = ((Integer)localObject).intValue();
        paramView = (Friends)paramView;
        localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (i1 == com.tencent.mobileqq.adapter.contacts.BuddyListFriends.a[1])
        {
          ((FriendListHandler)localObject).a(1, new String[] { paramView.uin }, new boolean[] { true });
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
          return;
        }
      } while (i1 != com.tencent.mobileqq.adapter.contacts.BuddyListFriends.a[0]);
      ((FriendListHandler)localObject).a(1, new String[] { paramView.uin }, new boolean[] { false });
      return;
      if ((paramView instanceof TroopInfo))
      {
        paramView = (TroopInfo)paramView;
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramView.troopcode, 1);
        return;
      }
    } while (!(paramView instanceof DiscussionInfo));
    paramView = (DiscussionInfo)paramView;
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).f(Long.valueOf(paramView.uin).longValue());
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int i1 = a().getDimensionPixelSize(2131493348);
    switch (paramInt)
    {
    case 4: 
    default: 
      paramInt = i1;
    }
    for (;;)
    {
      paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      if ((paramTextView == null) || ((paramTextView.leftMargin == paramInt) && (paramTextView.bottomMargin == paramInt))) {
        break;
      }
      paramTextView.setMargins(paramInt, 0, 0, paramInt);
      return;
      paramInt = a().getDimensionPixelSize(2131493348);
      continue;
      paramInt = a().getDimensionPixelSize(2131493350);
      continue;
      paramInt = a().getDimensionPixelSize(2131493349);
      continue;
      paramInt = a().getDimensionPixelSize(2131493350);
    }
  }
  
  private void a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountInfo.getUin(), "Pb_account_lifeservice", "mp_msg_sys_4", "contacts_aio");
    Intent localIntent;
    if (paramPublicAccountInfo.extendType == 2)
    {
      localIntent = new Intent(a(), ChatActivity.class);
      localIntent.putExtra("chat_subType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("uin", String.valueOf(paramPublicAccountInfo.uin));
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramPublicAccountInfo.name);
      a(localIntent);
      return;
      localIntent = new Intent(a(), ChatActivity.class);
    }
  }
  
  private boolean a(Object paramObject)
  {
    Object localObject1;
    if ((paramObject instanceof Friends))
    {
      localObject1 = (Friends)paramObject;
      if (AppConstants.ai.equals(((Friends)localObject1).uin)) {
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
        }
      }
    }
    try
    {
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("100701.100702");
      boolean bool1;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        if (SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label212;
        }
        a(new Intent(a(), SmartDevicePluginDownloadActivity.class));
        bool1 = true;
      }
      try
      {
        boolean bool2 = BaseApplicationImpl.a().getSharedPreferences("smartdevice_entry", 4).getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
        bool1 = bool2;
      }
      catch (Exception paramObject)
      {
        int i1;
        label212:
        Object localObject2;
        int i2;
        long l1;
        for (;;) {}
      }
      if (bool1)
      {
        i1 = 1;
        SmartDeviceReport.a(null, "Usr_NewDevice_Click", i1, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 1000L);
        return true;
        i1 = 0;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
        localIntent.putExtra("bitmap", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2, false));
        localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
        localObject2 = "com.tencent.device.activities.DeviceSearchActivity";
        int i3 = 2;
        i2 = i3;
        localObject1 = localObject2;
        try
        {
          SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("smartdevice_entry", 4);
          i1 = i3;
          paramObject = localObject2;
          i2 = i3;
          localObject1 = localObject2;
          if (localSharedPreferences.getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true))
          {
            paramObject = "com.tencent.device.activities.DeviceSquareActivity";
            i1 = 3;
          }
          i2 = i1;
          localObject1 = paramObject;
          bool1 = localSharedPreferences.getBoolean("search_device_enable_https_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
          i2 = i1;
          localObject1 = paramObject;
          if ((VersionUtils.d()) && (bool1))
          {
            i2 = i1;
            localObject1 = paramObject;
            localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          }
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            i1 = i2;
            paramObject = localObject1;
          }
        }
        SmartDevicePluginLoader.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, (String)paramObject, 0, null, SmartDevicePluginProxyActivity.class);
        SmartDeviceReport.a(null, "Usr_NewDevice_Click", i1, 0, 0);
      }
      if (AppConstants.aj.equals(((Friends)localObject1).uin))
      {
        paramObject = new Intent(a(), LiteActivity.class);
        ((Intent)paramObject).putExtra("targetUin", AppConstants.aj);
        a((Intent)paramObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
        return true;
      }
      if (AppConstants.ak.equals(((Friends)localObject1).uin))
      {
        paramObject = new Intent(a(), LiteActivity.class);
        ((Intent)paramObject).putExtra("targetUin", AppConstants.ak);
        a((Intent)paramObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006041", "0X8006041", 0, 0, "", "", "", "");
        return true;
      }
      if (AppConstants.al.equals(((Friends)localObject1).uin))
      {
        a(new Intent(a(), PrinterActivity.class));
        return true;
      }
      if (AppConstants.aG.equals(((Friends)localObject1).uin))
      {
        if (!this.jdField_c_of_type_Boolean) {
          return true;
        }
        this.jdField_c_of_type_Boolean = false;
        paramObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        localObject1 = ((SmartDeviceProxyMgr)paramObject).a(((Friends)localObject1).signature, ((Friends)localObject1).iTermType);
        ((SmartDeviceProxyMgr)paramObject).a(a(), (DeviceInfo)localObject1, false);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 1000L);
        l1 = ((DeviceInfo)localObject1).din;
        if (((DeviceInfo)localObject1).isAdmin == 1)
        {
          i1 = 1;
          SmartDeviceReport.a(null, l1, "Usr_LiteApp_Open", i1, 0, ((DeviceInfo)localObject1).productId);
          l1 = ((DeviceInfo)localObject1).din;
          if (((DeviceInfo)localObject1).userStatus != 10) {
            break label833;
          }
          i1 = 1;
          label809:
          SmartDeviceReport.a(null, l1, "Usr_LiteApp_Open_Online", i1, 0, ((DeviceInfo)localObject1).productId);
        }
      }
      label833:
      do
      {
        return false;
        i1 = 2;
        break;
        i1 = 2;
        break label809;
        if (QLog.isColorLevel()) {
          QLog.d("Hyim", 2, "onItemClick:" + ((Friends)localObject1).name + ((Friends)localObject1).uin + "--[" + ((Friends)localObject1).detalStatusFlag + "] [" + ((Friends)localObject1).iTermType + "] [" + ((Friends)localObject1).getLastLoginType() + "] [" + ((Friends)localObject1).showLoginClient + "]");
        }
        paramObject = new ProfileActivity.AllInOne(((Friends)localObject1).uin, 1);
        ((ProfileActivity.AllInOne)paramObject).g = 59;
        if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() == 2131297693) {}
        for (i1 = 2;; i1 = 3)
        {
          ((ProfileActivity.AllInOne)paramObject).i = i1;
          ProfileActivity.b(a(), (ProfileActivity.AllInOne)paramObject);
          return true;
        }
        if ((paramObject instanceof PublicAccountInfo))
        {
          paramObject = (PublicAccountInfo)paramObject;
          if (PublicAccountInfo.isLooker((PublicAccountInfo)paramObject))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Clk_lifeservice", 49, 0, "", "", "", "");
            AddContactsActivity.a(a());
          }
          for (;;)
          {
            return true;
            a((PublicAccountInfo)paramObject);
          }
        }
        if ((paramObject instanceof PhoneContact))
        {
          paramObject = (PhoneContact)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d("Contacts", 2, "onItemClick:" + ((PhoneContact)paramObject).name + ((PhoneContact)paramObject).mobileCode + "--[" + ((PhoneContact)paramObject).detalStatusFlag + "] [" + ((PhoneContact)paramObject).iTermType + "]");
          }
          localObject1 = new ProfileActivity.AllInOne(((PhoneContact)paramObject).mobileCode, 34);
          ((ProfileActivity.AllInOne)localObject1).g = 59;
          ((ProfileActivity.AllInOne)localObject1).h = ((PhoneContact)paramObject).name;
          if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() == 2131297693) {}
          for (i1 = 2;; i1 = 3)
          {
            ((ProfileActivity.AllInOne)localObject1).i = i1;
            ProfileActivity.b(a(), (ProfileActivity.AllInOne)localObject1);
            if ((((PhoneContact)paramObject).highLightTimeStamp != 0L) || (((PhoneContact)paramObject).isNewRecommend)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80058E0", "0X80058E0", 0, 0, "1", "", "", "");
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
            return true;
          }
        }
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (paramObject != null)
          {
            localObject1 = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
            ((Intent)localObject1).putExtra("uin", ((TroopInfo)paramObject).troopuin);
            localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(((TroopInfo)paramObject).troopuin);
            if ((localObject2 != null) && (((TroopInfo)localObject2).troopcode != null)) {
              ((Intent)localObject1).putExtra("troop_uin", ((TroopInfo)localObject2).troopcode);
            }
            ((Intent)localObject1).putExtra("uintype", 1);
            ((Intent)localObject1).putExtra("uinname", ((TroopInfo)paramObject).troopname);
            a((Intent)localObject1);
          }
          return true;
        }
      } while (!(paramObject instanceof DiscussionInfo));
      paramObject = (DiscussionInfo)paramObject;
      localObject1 = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
      ((Intent)localObject1).putExtra("uin", ((DiscussionInfo)paramObject).uin);
      ((Intent)localObject1).putExtra("uintype", 3000);
      ((Intent)localObject1).putExtra("uinname", ((DiscussionInfo)paramObject).discussionName);
      a((Intent)localObject1);
      return true;
    }
    catch (Exception paramObject)
    {
      for (;;) {}
    }
  }
  
  private void b(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView) {
      if (paramListView.s() > 0) {
        super.a(new lbh(this));
      }
    }
    while (paramListView.s() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean);
    }
    if (NetworkUtil.h(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true, true);
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a();
        SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if (localSmartDeviceProxyMgr.a()) {
          localSmartDeviceProxyMgr.f();
        }
        if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() == 2131297693) {
          ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(true, false);
        }
      }
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Contacts", 2, "updateBuddyList succeeded");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList falied");
    }
    return false;
  }
  
  private void n()
  {
    ThreadManager.b().post(new lbj(this));
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("101200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidViewView = a().findViewById(2131298442);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131296895));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131296896));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131297691));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)a(2131297183));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription("添加");
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131368603);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a(21).e(10).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)a(2131297692));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131297139));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131297137));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131297690));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.e();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter = new BuddyListAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView, this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(this.jdField_e_of_type_Boolean, AppConstants.aj);
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(this.jdField_f_of_type_Boolean, AppConstants.ak);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter = new AllBuddyListAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter);
    }
  }
  
  private void r()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.t();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a().getCount();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() == 0) && (i1 == i2 - 1))
    {
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      this.jdField_d_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    this.jdField_d_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
  }
  
  private void s()
  {
    int i1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).e();
    if (i1 <= 0)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      int i2 = localPhoneContactManagerImp.d();
      if ((localPhoneContactManagerImp.b()) || (i2 == 5)) {
        i1 = localPhoneContactManagerImp.a(false).size() + i1;
      }
    }
    for (;;)
    {
      if (i1 > 0)
      {
        if (((this.jdField_e_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null)) || ((this.jdField_f_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null))) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
        }
        if ((this.jdField_e_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null))
        {
          this.jdField_e_of_type_AndroidViewView = a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.b(this.jdField_e_of_type_AndroidViewView);
        }
        if ((this.jdField_f_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null))
        {
          this.jdField_f_of_type_AndroidViewView = a(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.b(this.jdField_f_of_type_AndroidViewView);
        }
      }
      do
      {
        return;
        if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.b(this.jdField_e_of_type_AndroidViewView);
          this.jdField_e_of_type_AndroidViewView = null;
        }
      } while ((this.jdField_f_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView == null));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.b(this.jdField_f_of_type_AndroidViewView);
      this.jdField_f_of_type_AndroidViewView = null;
      return;
    }
  }
  
  private void t()
  {
    if (!SettingCloneUtil.readValue(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_all_contacts_key", false)) {}
    for (int i1 = 2131297693;; i1 = 2131297694)
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(i1);
      return;
    }
  }
  
  private void u()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localSmartDeviceProxyMgr.a())
    {
      DeviceInfo[] arrayOfDeviceInfo = localSmartDeviceProxyMgr.a();
      if (arrayOfDeviceInfo != null) {
        localSmartDeviceProxyMgr.a(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
      }
    }
  }
  
  private void v()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a(String.valueOf(101000));
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E0", "0X80060E0", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      ((RedTouchManager)localObject).a(localAppInfo);
      this.jdField_d_of_type_Boolean = false;
      if (PublicAccountConfigUtil.jdField_d_of_type_Boolean)
      {
        localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if ((localObject != null) && (((PublicAccountDataManager)localObject).b()))
        {
          int i1 = 1;
          long l1 = 0L;
          localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          if (localObject != null)
          {
            boolean bool = ((SharedPreferences)localObject).getBoolean("public_account_manage_notify", true);
            l2 = ((SharedPreferences)localObject).getLong("public_account_manage_contacts_enter_time", 0L);
            l1 = l2;
            i1 = bool;
            if (QLog.isColorLevel())
            {
              QLog.d("Contacts", 2, "upDataPARedTouch->receiveNotify:" + bool + ", lastEnterTime:" + l2);
              i1 = bool;
              l1 = l2;
            }
          }
          l1 = PublicAccountUtil.b(l1) / PublicAccountConfigUtil.c;
          long l2 = PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis()) / PublicAccountConfigUtil.c;
          if ((i1 != 0) && (l2 - l1 >= 30L))
          {
            this.jdField_d_of_type_Boolean = true;
            if (!this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a()) {
              this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(new BusinessInfoCheckUpdate.RedTypeInfo());
            }
          }
        }
      }
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return LayoutInflater.from(a()).inflate(2130903208, null);
  }
  
  protected String a()
  {
    return a().getString(2131367540);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      y();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onNotCompleteVisable");
    }
    ((PullRefreshHeader)paramView).c(a());
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i1 = 9527;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      b(paramBoolean);
      return;
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(9527)) {
        return;
      }
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localMqqHandler.sendEmptyMessageDelayed(i1, paramLong);
      return;
      i1 = 4;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    r();
  }
  
  void a(ListView paramListView)
  {
    if (paramListView == null) {}
    ThemeBackground localThemeBackground;
    label102:
    do
    {
      for (;;)
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          paramListView.setContentBackground(2130837959);
          if (paramListView.getTag() != null) {
            paramListView.setTag(null);
          }
        }
        else
        {
          if ((paramListView.getTag() instanceof ThemeBackground)) {}
          for (localThemeBackground = (ThemeBackground)paramListView.getTag(); ThemeBackground.getThemeBackground(paramListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localThemeBackground); localThemeBackground = new ThemeBackground())
          {
            if (!"null".equals(localThemeBackground.path)) {
              break label102;
            }
            paramListView.setContentBackground(2130837959);
            return;
          }
        }
      }
    } while (localThemeBackground.img == null);
    paramListView.setContentBackground(localThemeBackground.img);
    paramListView.setTag(localThemeBackground);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    super.a(paramBoolean);
    a(1400L, true);
    t();
    if (paramBoolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)1);
    }
    int i2 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId();
    if (i2 == 2131297693) {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
      {
        int i3 = this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.getGroupCount();
        i2 = 0;
        while (i1 < i3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.e(i1))
          {
            if (paramBoolean) {
              this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(i1);
            }
            i2 = 1;
          }
          i1 += 1;
        }
        if (i2 != 0) {
          n();
        }
      }
    }
    for (;;)
    {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(this);
      Object localObject = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      ((NewFriendManager)localObject).a(this);
      a(((NewFriendManager)localObject).b(), true);
      if (AppSetting.j)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
        localObject = a(2131367540);
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131367540));
      }
      v();
      o();
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(System.currentTimeMillis());
      ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).d();
      return;
      if (i2 == 2131297694) {
        n();
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a()
  {
    return this.g;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewCompleteVisableAndReleased");
    }
    n();
    ((PullRefreshHeader)paramView).a(a());
    paramView = (Contacts.OverScrollViewTag)paramView.getTag();
    if (!b())
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      localMessage.obj = paramListView;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
      paramView.jdField_a_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() != 2131297693) {
        break label143;
      }
    }
    label143:
    for (paramInt = 51;; paramInt = 52)
    {
      ReportController.b(paramView, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", paramInt, 0, "", "", "", "");
      return true;
      paramView.jdField_a_of_type_Boolean = true;
      break;
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onBindStateChanged bindState=" + paramInt);
    }
    s();
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewCompleteVisable");
    }
    ((PullRefreshHeader)paramView).b(a());
  }
  
  public void b(String paramString)
  {
    char c1 = paramString.charAt(0);
    if ((!paramString.equals("$")) && (c1 != '+'))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.a(c1);
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i1 + 3);
      }
      return;
    }
    if (c1 == '+')
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JustGo", 2, "<<--doRefreshBuddyList");
    }
    s();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
    {
      if (!paramBoolean) {
        break label57;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.notifyDataSetChanged();
      }
      return;
      label57:
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Lbq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Lbo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Lbr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localStatusManager != null)
      {
        localStatusManager.b(this.jdField_a_of_type_Lbs);
        localStatusManager.a(this.jdField_a_of_type_Lbs);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    }
    else
    {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    q();
    u();
    try
    {
      this.jdField_c_of_type_JavaLangString = a().getApplicationContext().getPackageManager().getPackageInfo(a().getApplicationContext().getPackageName(), 0).packageName;
      EquipmentLockImpl.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, 0L);
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).c();
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewNotCompleteVisableAndReleased");
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = (a().getTitleBarHeight() - (int)DisplayUtils.a(a(), 5.0F));
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)a(2131297685));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131297695));
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
    }
    if (this.jdField_b_of_type_AndroidViewViewStub == null)
    {
      this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)a(2131297696));
      this.jdField_b_of_type_AndroidViewViewStub.setOnInflateListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_b_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  public void d(int paramInt) {}
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.d();
    }
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(this);
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).b(this);
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Lbq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Lbo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Lbr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_Lbs);
    }
  }
  
  protected void g()
  {
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(this);
  }
  
  protected void h()
  {
    super.h();
    if (!this.g) {}
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId();
      if (i1 == 2131297693)
      {
        int i2 = this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.getGroupCount();
        i1 = 0;
        while (i1 < i2)
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.d(i1);
          i1 += 1;
        }
        b(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
        return;
      }
      if (i1 == 2131297694)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Contacts", 2, "onFrameTabClick: " + i1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return true;
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.H();
          return true;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.H();
          return true;
          QQToast.a(a(), 1, 2131368597, 0).b(this.jdField_a_of_type_Int);
        } while (!(paramMessage.obj instanceof ListView));
        ((ListView)paramMessage.obj).H();
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      a(0L, false);
      return true;
    case 9527: 
      a(0L, true);
      return true;
    case 9528: 
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
      c();
      if (!this.g) {
        a(true);
      }
      this.g = true;
      return true;
    }
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  public void i()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void k()
  {
    long l1 = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l1).commit();
  }
  
  public void l() {}
  
  public void m()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(a().getColor(2131428295));
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    }
    BuddyListItem.a.clear();
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131297694)
    {
      this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (Utils.a("tag_swip_icon_menu_item", paramView.getTag())) {
        a(paramView);
      }
      break;
    }
    label402:
    label506:
    label669:
    label674:
    do
    {
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053E3", "0X80053E3", 0, 0, "", "", "", "");
      paramView = new Intent(a(), NewFriendActivity.class);
      paramView.putExtra("EntranceId", 2);
      paramView.setFlags(67108864);
      a(paramView);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Contacts_tab", "Clk_grp", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800661E", "0X800661E", 0, 0, "", "", "", "");
      a(new Intent(a(), TroopActivity.class));
      return;
      GroupManagerActivity.a(a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
      return;
      paramView = new Intent(a(), AddContactsActivity.class);
      paramView.putExtra("EntranceId", 3);
      a(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      try
      {
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(101200));
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int i1;
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() == 2131297693)
      {
        i1 = 51;
        ReportController.b(paramView, "CliOper", "", "", "Contacts_tab", "Clk_contactslist", i1, 0, "3", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d(PublicAccountListActivity.a, 2, "enterPublicAccountActivity: " + System.currentTimeMillis());
        }
        PAStartupTracker.a(null, "pubAcc_follow_list_display", "");
        PublicAccountListActivity.a(a());
        if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (!this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a())) {
          break label669;
        }
        i1 = 1;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (i1 == 0) {
          break label674;
        }
      }
      for (int i2 = 2;; i2 = 1)
      {
        ReportController.b(paramView, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F24", "0X8005F24", i2, 0, "", "", "", "");
        paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        BusinessInfoCheckUpdate.AppInfo localAppInfo = paramView.a(String.valueOf(101000));
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E1", "0X80060E1", 0, 0, "", "", "", "");
        }
        paramView.b(String.valueOf(101000));
        if ((i1 == 0) || (!this.jdField_d_of_type_Boolean)) {
          break;
        }
        ThreadManager.c(new lbi(this, NetConnInfoCenter.getServerTimeMillis()));
        return;
        i1 = 52;
        break label402;
        i1 = 0;
        break label506;
      }
      a(new Intent(a(), UncommonlyUsedContactsActivity.class));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
      return;
      paramView = (BuddyListItem.ViewTag)paramView.getTag();
    } while ((paramView == null) || (paramView.a == null));
    a(paramView.a);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    int i1 = paramViewStub.getId();
    Object localObject1;
    Object localObject2;
    if (i1 == 2131297695)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView = ((FPSPinnedHeaderExpandableListView)paramView.findViewById(2131297733));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setSelector(2131427379);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOverscrollHeader(a().getDrawable(2130838317));
      paramViewStub = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView;
      localObject1 = LayoutInflater.from(a());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(paramViewStub, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, a(), null, 2);
      paramView = ((LayoutInflater)localObject1).inflate(2130903219, paramViewStub, false);
      paramViewStub.a(paramView);
      localObject2 = paramView.findViewById(2131297753);
      View localView1 = paramView.findViewById(2131297758);
      View localView2 = paramView.findViewById(2131297761);
      View localView3 = paramView.findViewById(2131297762);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject2).findViewById(2131297755));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131297757));
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), localView3).a(53).a();
      ((View)localObject2).setOnClickListener(this);
      localView1.setOnClickListener(this);
      localView2.setOnClickListener(this);
      paramView.findViewById(2131297747).setOnClickListener(this);
      localObject2 = (PullRefreshHeader)((LayoutInflater)localObject1).inflate(2130903499, paramViewStub, false);
      ((PullRefreshHeader)localObject2).setTag(new Contacts.OverScrollViewTag());
      paramViewStub.setOverScrollHeader((View)localObject2);
      paramViewStub.setOverScrollListener(this);
      if (i1 != 2131297695) {
        break label614;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localObject2);
    }
    for (;;)
    {
      a(paramViewStub);
      q();
      s();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)paramView.findViewById(2131297698));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)paramView.findViewById(2131297699));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "+", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOverscrollHeader(a().getDrawable(2130838317));
      paramViewStub = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      break;
      label614:
      localObject1 = ((LayoutInflater)localObject1).inflate(2130903210, paramViewStub, false);
      ((View)localObject1).setOnClickListener(this);
      paramViewStub.a((View)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localObject2);
      this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131297752);
      this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131297749);
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
      this.jdField_d_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    }
  }
  
  protected void z_()
  {
    super.z_();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\Contacts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */