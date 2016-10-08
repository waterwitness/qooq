package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.anim.MainEnterOutAni;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lun;
import luo;
import lup;
import luq;
import lur;
import lus;
import lut;
import luu;
import luv;
import luw;
import lux;
import luy;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MainFragment
  extends FrameHelperActivity
{
  public static int a = 0;
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  public static final String a = "MainFragment";
  public static boolean a = false;
  public static int b = 0;
  public static final String b = "tab_index";
  public static boolean b = false;
  public static int c = 0;
  public static final String c = "消息";
  public static int d = 0;
  public static final String d = "联系人";
  public static int e = 0;
  public static final String e = "动态";
  public static int f = 0;
  public static final String f = "电话";
  public static final int g = 16;
  public static final String g = "NOW";
  public static final int h = 17;
  public static final String h = "_icon";
  public static final int i = 18;
  public static final String i = "_num";
  public static final int j = 19;
  public static final String j = "_img";
  public static final int k = 32;
  public static final String k = "_new";
  public static final int l = 33;
  public static final String l = "_text";
  public static final int m = 34;
  public static final int n = 35;
  public static final int o = 36;
  public static final int p = 37;
  public Dialog a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public MainAssistObserver a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new lup(this);
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new luo(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  public boolean c;
  public boolean d;
  private boolean f;
  private boolean g;
  public String m;
  private String p;
  int jdField_q_of_type_Int = 3;
  private String jdField_q_of_type_JavaLangString;
  private String r;
  private String s = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
    jdField_f_of_type_Int = 5;
    jdField_a_of_type_Boolean = true;
  }
  
  public MainFragment()
  {
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public static int a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("main_tab_id"))) {
      return Integer.MIN_VALUE;
    }
    switch (paramBundle.getInt("main_tab_id"))
    {
    default: 
      return Integer.MIN_VALUE;
    case 1: 
      return jdField_a_of_type_Int;
    case 2: 
      return jdField_b_of_type_Int;
    case 3: 
      return jdField_c_of_type_Int;
    case 4: 
      return jdField_d_of_type_Int;
    case 5: 
      return jdField_e_of_type_Int;
    }
    return jdField_f_of_type_Int;
  }
  
  private int a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      return 0;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_new");
    int i1;
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      i1 = 2;
    }
    for (;;)
    {
      return i1;
      localObject = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_num");
      if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() > 0))
      {
        i1 = 3;
      }
      else
      {
        paramString = this.jdField_b_of_type_JavaUtilHashMap.get(paramString + "_icon");
        if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
    }
  }
  
  public static View a(int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (BaseApplicationImpl.a == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.a, 2130903400, null);
    ((ImageView)localView.findViewById(2131298446)).setBackgroundResource(paramInt);
    if (paramDragFrameLayout != null)
    {
      DragTextView localDragTextView = (DragTextView)localView.findViewById(2131298447);
      localDragTextView.setOnModeChangeListener(paramDragFrameLayout);
      localDragTextView.setDragViewType(2);
    }
    return localView;
  }
  
  public static MainFragment a()
  {
    MainFragment localMainFragment = new MainFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localMainFragment.setArguments(localBundle);
    return localMainFragment;
  }
  
  private void a(int paramInt, luy paramluy)
  {
    if (paramluy == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, paramluy.jdField_a_of_type_JavaLangString + " is execute");
          }
          if (paramInt == 2131296444)
          {
            paramluy = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
            if ((paramluy == null) || (paramluy.a == null))
            {
              if (QLog.isColorLevel()) {
                QLog.w("MainFragment", 2, "mWrapper is null");
              }
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131492908));
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
              return;
              if (paramluy.a.iUpgradeType == 0) {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, "已是最新版本", 0).b(getResources().getDimensionPixelSize(2131492908));
              } else if ((paramluy != null) && (paramluy.a != null)) {
                UpgradeDetailActivity.a(getActivity(), UpgradeController.a().a(), false, false, true);
              }
            }
          }
          if (paramInt != 2131296446) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
        } while (!PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity()));
        e();
        return;
        if (paramInt == 2131296447)
        {
          d();
          return;
        }
      } while (paramluy.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
      AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramluy.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    } while (!"com.tencent.Feedback_5_8".equals(paramluy.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
  }
  
  private void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((paramRedTouch != null) && (paramRedTypeInfo != null)) {
      switch (paramRedTypeInfo.red_type.get())
      {
      case 1: 
      case 2: 
      case 3: 
      default: 
        paramRedTouch.a();
        paramRedTouch.a(paramRedTypeInfo);
      }
    }
    while (paramRedTouch == null) {
      for (;;)
      {
        return;
        paramRedTouch.b(15).a();
        this.s = "有更新";
        continue;
        paramRedTouch.b(0).a();
        this.s = (paramRedTypeInfo.red_content.get() + "条更新");
      }
    }
    paramRedTouch.a();
    paramRedTouch.a(null);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      paramString2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while (paramString2 == null);
    StringBuilder localStringBuilder = new StringBuilder();
    label49:
    int i1;
    Object localObject;
    if ("消息".equals(paramString1))
    {
      localStringBuilder.append("消息 ");
      i1 = a(paramString1);
      localObject = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_num");
      if (i1 != 2) {
        break label208;
      }
      localStringBuilder.append("有更新");
    }
    for (;;)
    {
      if ("动态".equals(paramString1)) {
        localStringBuilder.append(this.s);
      }
      paramString2.setContentDescription(localStringBuilder.toString());
      return;
      if ("联系人".equals(paramString1))
      {
        localStringBuilder.append("联系人 ");
        break label49;
      }
      if ("动态".equals(paramString1))
      {
        localStringBuilder.append("动态 ");
        break label49;
      }
      if ("电话".equals(paramString1))
      {
        localStringBuilder.append("电话 ");
        break label49;
      }
      if (!"NOW".equals(paramString1)) {
        break;
      }
      localStringBuilder.append("日迹 ");
      break label49;
      label208:
      if (i1 == 3)
      {
        if ("消息".equals(paramString1))
        {
          localObject = ((TextView)localObject).getText().toString();
          if ("".equals(localObject)) {
            localStringBuilder.append("多于99条未读");
          } else {
            localStringBuilder.append((String)localObject + "条未读");
          }
        }
        else
        {
          String str;
          if ("电话".equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0) {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99个新的未接来电");
              } else {
                localStringBuilder.append(str + "个新的未接来电");
              }
            }
          }
          else if ("联系人".equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0) {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99个手机通讯录新联系人");
              } else {
                localStringBuilder.append(str + "个手机通讯录新联系人");
              }
            }
          }
          else if ("NOW".equals(paramString1))
          {
            str = ((TextView)localObject).getText().toString();
            if (((TextView)localObject).getVisibility() == 0) {
              if ("99+".equals(str)) {
                localStringBuilder.append("多于99个新的日迹");
              } else {
                localStringBuilder.append(str + "个新的日迹");
              }
            }
          }
        }
      }
      else if (i1 == 1) {
        localStringBuilder.append("有新消息");
      }
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    int i1 = 0;
    int i2 = 1;
    if (paramBoolean)
    {
      jdField_a_of_type_Int = 0;
      jdField_b_of_type_Int = 1;
      jdField_c_of_type_Int = 2;
      jdField_d_of_type_Int = 3;
      jdField_f_of_type_Int = -100;
      jdField_e_of_type_Int = -100;
    }
    while (paramInt < 0) {
      return;
    }
    if (paramInt <= 0) {
      i1 = 1;
    }
    jdField_a_of_type_Int = i1;
    if (1 >= paramInt) {}
    for (i1 = 2;; i1 = 1)
    {
      jdField_c_of_type_Int = i1;
      i1 = i2;
      if (2 >= paramInt) {
        i1 = 3;
      }
      jdField_d_of_type_Int = i1;
      jdField_f_of_type_Int = paramInt;
      jdField_b_of_type_Int = -100;
      jdField_e_of_type_Int = -100;
      return;
    }
  }
  
  public static View[] a(LayoutInflater paramLayoutInflater)
  {
    View[] arrayOfView = new View[6];
    arrayOfView[0] = paramLayoutInflater.inflate(2130903399, null);
    DragFrameLayout localDragFrameLayout = (DragFrameLayout)arrayOfView[0].findViewById(2131298442);
    arrayOfView[1] = localDragFrameLayout;
    arrayOfView[2] = a(2130843380, localDragFrameLayout);
    arrayOfView[3] = new RedTouch(paramLayoutInflater.getContext(), a(2130843379, null)).a(49).d(5).b(true).a();
    arrayOfView[4] = new RedTouch(paramLayoutInflater.getContext(), a(2130843381, null)).a(49).d(5).b(true).a();
    return arrayOfView;
  }
  
  private View[] a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(12);
    View[] arrayOfView = ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView;
    ((SplashActivity)getActivity()).jdField_a_of_type_ArrayOfAndroidViewView = null;
    if (arrayOfView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)arrayOfView[1]);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { arrayOfView[2], null, arrayOfView[3], arrayOfView[4], null };
      this.jdField_a_of_type_JavaUtilHashMap.put("消息", this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人", this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      this.jdField_a_of_type_JavaUtilHashMap.put("动态", this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      this.jdField_a_of_type_JavaUtilHashMap.put("消息_num", this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131298447));
      this.jdField_a_of_type_JavaUtilHashMap.put("联系人_num", this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131298447));
      this.jdField_a_of_type_JavaUtilHashMap.put("动态_num", this.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131298447));
      paramView = (QQTabWidget)paramView.findViewById(16908307);
      if (paramView == null) {
        break label358;
      }
      paramView.setTabWidgetMoveListener(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ArrayOfAndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)paramView.findViewById(2131298442));
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { a(2130843380, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout), null, new RedTouch(getActivity(), a(2130843379, null)).a(49).d(5).b(true).a(), new RedTouch(getActivity(), a(2130843381, null)).a(49).d(5).b(true).a(), null };
      break;
      label358:
      QLog.i("MainFragment", 1, "initTabs tabWidget is null");
    }
  }
  
  private String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "getCurrentTabTag. mTabHost is null");
      }
      localObject = null;
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return (String)localObject;
        str1 = "";
        str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag();
        localObject = str1;
      } while (str2 == null);
      if (str2.equals(Conversation.class.getName())) {
        return "消息";
      }
      if (str2.equals(Contacts.class.getName())) {
        return "联系人";
      }
      if (str2.equals(Leba.class.getName())) {
        return "动态";
      }
      if (str2.equals(Call.class.getName())) {
        return "电话";
      }
      localObject = str1;
    } while (!str2.equals(Now.class.getName()));
    return "NOW";
  }
  
  private void c(boolean paramBoolean)
  {
    int i1;
    if ((paramBoolean) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m) && (this.jdField_a_of_type_ArrayOfAndroidViewView[1] == null)) || ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m) && (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)) || (this.jdField_q_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null)) || ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainFragment", 2, "setFrames" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m);
      }
      this.jdField_q_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.clearAllTabs();
      }
      int i2 = this.jdField_a_of_type_ArrayOfAndroidViewView.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[i1];
        if (localObject != null)
        {
          ((View)localObject).setSelected(false);
          ((View)localObject).setId(i1 + 16);
        }
        i1 += 1;
      }
      Object localObject = a(Conversation.class);
      if (localObject != null) {
        ((Conversation)localObject).f(true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m) {
        break label591;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = new RedTouch(getActivity(), a(2130843378, null)).a(49).d(5).b(true).a();
      this.jdField_a_of_type_JavaUtilHashMap.put("电话", this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
      this.jdField_a_of_type_JavaUtilHashMap.put("电话_num", this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131298447));
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
      this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
      a(Now.class);
    }
    for (;;)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g;
      if ((i1 == 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Conversation.class, this.jdField_a_of_type_ArrayOfAndroidViewView[0]);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m) {
        a(this.jdField_a_of_type_AndroidViewView, Call.class, this.jdField_a_of_type_ArrayOfAndroidViewView[1]);
      }
      if ((i1 == 1) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Contacts.class, this.jdField_a_of_type_ArrayOfAndroidViewView[2]);
      if ((i1 == 2) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_AndroidViewView, Leba.class, this.jdField_a_of_type_ArrayOfAndroidViewView[3]);
      if ((i1 == 3) && (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)) {
        a(this.jdField_a_of_type_AndroidViewView, Now.class, this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g);
      return;
      label591:
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g < 4) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g >= 0) && (QQStoryManager.d()))
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[4] = new RedTouch(getActivity(), a(2130843382, null)).a(49).d(5).b(true).a();
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW", this.jdField_a_of_type_ArrayOfAndroidViewView[4]);
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_num", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131298447));
        this.jdField_a_of_type_JavaUtilHashMap.put("NOW_img", this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131298448));
        this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话");
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话_num");
        a(Call.class);
        r();
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[1] = null;
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话");
        this.jdField_a_of_type_JavaUtilHashMap.remove("电话_num");
        a(Call.class);
        this.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
        this.jdField_a_of_type_JavaUtilHashMap.remove("NOW");
        this.jdField_a_of_type_JavaUtilHashMap.remove("NOW_num");
        a(Now.class);
      }
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) {
      return false;
    }
    if (a() == jdField_f_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.redPointclearStoryRedPointIfNeeded", 2, "当前是nowtab的话，清理红点==>isCurrentTabNowTab:" + bool);
      }
      if ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
        break;
      }
      a(37, null);
      return true;
    }
  }
  
  private boolean d()
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("动态");
    if (localRedTouch == null) {
      return false;
    }
    return localRedTouch.a();
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    d();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new luy();
    ((luy)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131369597);
    localArrayList.add(new Pair(Integer.valueOf(2131296444), localObject));
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      luy localluy = new luy();
      localluy.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localluy.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131296445), localluy));
    }
    localObject = new luy();
    ((luy)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131367775);
    localArrayList.add(new Pair(Integer.valueOf(2131296446), localObject));
    localObject = new luy();
    ((luy)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131367976);
    localArrayList.add(new Pair(Integer.valueOf(2131296447), localObject));
    localObject = ActionSheet.c(getActivity());
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      if (2131296447 == ((Integer)((Pair)localArrayList.get(i1)).first).intValue()) {
        ((ActionSheet)localObject).d(((luy)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((ActionSheet)localObject).c(((luy)((Pair)localArrayList.get(i1)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).a(new lut(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new luu(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void r()
  {
    if (c()) {}
    label242:
    for (;;)
    {
      return;
      Object localObject3 = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("NOW_num"))
      {
        if (((TroopRedTouchManager)localObject3).a() == null)
        {
          a(37, null);
          return;
        }
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        Object localObject2 = ((TroopRedTouchManager)localObject3).a(8);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((TroopRedTouchManager)localObject3).a(9);
          if (localObject1 == null) {}
        }
        else
        {
          localRedTypeInfo.red_type.set(0);
          localRedTypeInfo.red_content.set("");
          localRedTypeInfo.red_desc.set("");
          localObject3 = "";
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label242;
          }
          a(37, localRedTypeInfo);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MainFragmentQ.qqstory.redPoint", 2, "redDotInfo==>style:" + 0 + ", num:" + 0 + ", text:" + (String)localObject1);
          return;
          localObject2 = ((TroopRedTouchManager)localObject3).a(11);
          if (localObject2 != null)
          {
            localObject1 = ((oidb_0x791.RedDotInfo)localObject2).str_custom_buffer.get().toStringUtf8();
            localRedTypeInfo.red_type.set(4);
            localRedTypeInfo.red_content.set((String)localObject1);
            localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
          }
          else
          {
            localObject1 = "";
          }
        }
      }
    }
  }
  
  public int a()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
    }
    while (!QLog.isColorLevel()) {
      return i1;
    }
    QLog.e("MainFragment", 2, "getCurrentTab");
    return 0;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(getActivity(), 2131558973);
    localDialog.setContentView(2130903341);
    TextView localTextView = (TextView)localDialog.findViewById(2131297840);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296852);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297843);
    if (paramString1 != null) {
      paramString1.setText(2131367262);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297844);
    if (paramString1 != null) {
      paramString1.setText(2131367263);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  protected String a()
  {
    if (a()) {
      return getString(2131366637);
    }
    return super.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDrawComplete");
    }
    super.a();
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.A_();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.c();
      jdField_a_of_type_Boolean = false;
    }
    StartupTracker.a("Main_Start", null);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    boolean bool;
    String str2;
    Object localObject;
    label56:
    String str1;
    label87:
    TextView localTextView;
    do
    {
      return;
      bool = false;
      str2 = "";
      switch (paramInt1)
      {
      case 34: 
      case 35: 
      default: 
        localObject = "";
        switch (paramInt2)
        {
        default: 
          str1 = null;
          localTextView = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        }
        break;
      }
    } while ((localTextView == null) || (str1 == null));
    int i1;
    if ((paramObject instanceof Integer)) {
      i1 = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      label145:
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      label230:
      int i3;
      int i5;
      label315:
      int i7;
      int i6;
      label360:
      int i2;
      int i4;
      if (str1.equals((String)localObject + "_num"))
      {
        localSharedPreferences.edit().putInt(str1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i1).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(str1, paramObject);
        i1 = 0;
        i3 = a((String)localObject);
        if (i3 != 3) {
          break label923;
        }
        localObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_num");
        i5 = i1;
        paramObject = str2;
        if ((localObject instanceof Integer))
        {
          i5 = ((Integer)localObject).intValue();
          paramObject = str2;
        }
        if (paramInt1 != 32) {
          break label1136;
        }
        if (i5 <= 99) {
          break label993;
        }
        i7 = getResources().getDimensionPixelSize(2131493344);
        i6 = getResources().getDimensionPixelSize(2131493341);
        i3 = 4;
        i1 = 2130843328;
        localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        i2 = i1;
        i4 = i3;
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).setMargins(i6, i7, 0, 0);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          i4 = i3;
          i2 = i1;
        }
      }
      for (;;)
      {
        localObject = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
        if (paramInt1 == 36)
        {
          i7 = getResources().getDimensionPixelSize(2131493342);
          int i8 = getResources().getDimensionPixelSize(2131493341);
          if (i5 > 99)
          {
            i1 = 2130843328;
            i6 = getResources().getDimensionPixelSize(2131493344);
            i3 = 4;
            label481:
            localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
            if (localObject != null)
            {
              ((RelativeLayout.LayoutParams)localObject).setMargins(i8, i6, 0, 0);
              localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            localObject = b();
            if ((localObject == null) || (!(localObject instanceof Call))) {
              break label1112;
            }
            i2 = 1;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMain, [").append("tabIndex = ").append(paramInt1).append(",").append("type = ").append(paramInt2).append(",").append("style = ").append(i3).append(",").append("num = ").append(i5).append(",").append("isVisable = ").append(bool).append(",").append("tv = ").append(localTextView.toString()).append(" ]");
            QLog.d("MainFragment", 4, ((StringBuilder)localObject).toString());
          }
          localObject = localTextView;
          if (i2 != 0) {
            localObject = null;
          }
          CustomWidgetUtil.a((TextView)localObject, i3, i5, i1, 99, (String)paramObject);
          if (!AppSetting.j) {
            break;
          }
          a("消息", b());
          a("联系人", b());
          a("动态", b());
          a("电话", b());
          a("NOW", b());
          return;
          localObject = "消息";
          break label56;
          localObject = "联系人";
          break label56;
          localObject = "电话";
          break label56;
          str1 = (String)localObject + "_num";
          break label87;
          str1 = (String)localObject + "_icon";
          break label87;
          str1 = (String)localObject + "_new";
          break label87;
          if (!(paramObject instanceof Boolean)) {
            break label1146;
          }
          bool = ((Boolean)paramObject).booleanValue();
          i1 = 0;
          break label145;
          localSharedPreferences.edit().putBoolean(str1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool).commit();
          break label230;
          label923:
          i5 = i1;
          paramObject = str2;
          if (i3 != 5) {
            break label315;
          }
          localObject = this.jdField_b_of_type_JavaUtilHashMap.get((String)localObject + "_text");
          i5 = i1;
          paramObject = str2;
          if (!(localObject instanceof String)) {
            break label315;
          }
          paramObject = (String)localObject;
          i5 = i1;
          break label315;
          label993:
          i7 = getResources().getDimensionPixelSize(2131493342);
          i6 = getResources().getDimensionPixelSize(2131493341);
          i1 = 0;
          break label360;
          if (i5 > 0)
          {
            i1 = 0;
            i6 = i7;
            i3 = i4;
            break label481;
          }
          i6 = i7;
          i1 = i2;
          i3 = i4;
          if (localObject == null) {
            break label481;
          }
          i6 = i7;
          i1 = i2;
          i3 = i4;
          if (!((PstnManager)localObject).c()) {
            break label481;
          }
          i6 = i7;
          i1 = i2;
          i3 = i4;
          if (((PstnManager)localObject).d()) {
            break label481;
          }
          i1 = 0;
          i3 = 1;
          i6 = i7;
          break label481;
          label1112:
          i2 = 0;
          continue;
          i6 = 0;
          i3 = i4;
          i1 = i2;
          i2 = i6;
        }
        label1136:
        i2 = 0;
        i4 = i3;
      }
      label1146:
      i1 = 0;
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "WL_DEBUG updateTabRedTouch tabIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt)
            {
            default: 
              return;
            }
          } while (this.jdField_a_of_type_JavaUtilHashMap == null);
          a((RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("联系人"), paramRedTypeInfo);
          return;
          a((RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("动态"), paramRedTypeInfo);
          return;
        } while (this.jdField_a_of_type_JavaUtilHashMap == null);
        a((RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("NOW"), paramRedTypeInfo);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramRedTypeInfo);
      return;
    } while (this.jdField_a_of_type_JavaUtilHashMap == null);
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get("电话");
    if ((localRedTouch != null) && (paramRedTypeInfo != null)) {
      switch (paramRedTypeInfo.red_type.get())
      {
      case 1: 
      case 2: 
      case 3: 
      default: 
        localRedTouch.a();
        localRedTouch.a(paramRedTypeInfo);
      }
    }
    for (;;)
    {
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localRedTouch.b(15).a();
      break;
      localRedTouch.b(0).a();
      break;
      if (localRedTouch != null)
      {
        localRedTouch.a();
        localRedTouch.a(null);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onNewIntent ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null)
      {
        bool = true;
        QLog.d("MainFragment", 2, bool);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
        break label59;
      }
    }
    label59:
    do
    {
      return;
      bool = false;
      break;
      localObject1 = paramIntent.getExtras();
    } while (localObject1 == null);
    if (Boolean.valueOf(((Bundle)localObject1).getBoolean("EXIT", false)).booleanValue())
    {
      getActivity().finish();
      return;
    }
    int i1;
    if (((Bundle)localObject1).containsKey("tab_index")) {
      i1 = ((Bundle)localObject1).getInt("tab_index");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onNewIntent tabIndex: " + i1);
      }
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (i1 >= 0))
      {
        int i2 = i1;
        if (i1 == jdField_a_of_type_Int)
        {
          int i3 = ((Bundle)localObject1).getInt("conversation_index", -1);
          bool = ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          i2 = i1;
          if (1 == i3)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m)) {
              break label339;
            }
            i1 = jdField_b_of_type_Int;
            localObject2 = (Call)a(Call.class);
            i2 = i1;
            if (localObject2 != null)
            {
              i2 = i1;
              if (bool)
              {
                ((Call)localObject2).jdField_a_of_type_Boolean = true;
                i2 = i1;
              }
            }
          }
        }
        if ((i2 == jdField_a_of_type_Int) && (i2 == a()))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MainFragment", 4, "doOnNewIntent, same tab");
          }
          paramIntent = (Conversation)a(Conversation.class);
          if ("10003".equals(((Bundle)localObject1).getString("from")))
          {
            paramIntent.jdField_d_of_type_Boolean = true;
            return;
            if (!((Bundle)localObject1).containsKey("main_tab_id")) {
              break label618;
            }
            i1 = a((Bundle)localObject1);
            continue;
            try
            {
              label339:
              paramIntent = (Conversation)a(Conversation.class);
              paramIntent.jdField_a_of_type_Boolean = true;
              if (bool) {
                paramIntent.jdField_b_of_type_Boolean = true;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
              return;
            }
            catch (Exception paramIntent)
            {
              return;
            }
          }
          paramIntent.jdField_d_of_type_Boolean = false;
          return;
        }
        if ((i2 == jdField_b_of_type_Int) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m))
        {
          i1 = jdField_a_of_type_Int;
          bool = ((Bundle)localObject1).getBoolean("isOpenSelectMember", false);
          try
          {
            paramIntent = (Conversation)a(Conversation.class);
            paramIntent.jdField_a_of_type_Boolean = true;
            if (bool) {
              paramIntent.jdField_b_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i1);
            return;
          }
          catch (Exception paramIntent)
          {
            return;
          }
        }
        if ((i2 >= 0) && (i2 < this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount()))
        {
          localObject2 = (Conversation)a(Conversation.class);
          if (!"10003".equals(((Bundle)localObject1).getString("from"))) {
            break label592;
          }
          ((Conversation)localObject2).jdField_d_of_type_Boolean = true;
          label506:
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(i2);
        }
      }
      for (;;)
      {
        try
        {
          if (paramIntent.getIntExtra("forward", -1) == 2)
          {
            localObject1 = paramIntent.getParcelableExtra("AllInOne");
            if ((localObject1 instanceof ProfileActivity.AllInOne))
            {
              localObject1 = (ProfileActivity.AllInOne)localObject1;
              ((ProfileActivity.AllInOne)localObject1).jdField_f_of_type_Int = 100;
              ((ProfileActivity.AllInOne)localObject1).g = 6;
              ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
            }
          }
          paramIntent.removeExtra("forward");
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MainFragment", 2, "", paramIntent);
        return;
        label592:
        ((Conversation)localObject2).jdField_d_of_type_Boolean = false;
        break label506;
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "MainActivity:onNewIntent mTabHost is null");
        }
      }
      label618:
      i1 = -1;
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
    if (TroopAssistantManager.a().d()) {
      TroopAssistantManager.a().a(false);
    }
    TroopAssistantManager.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    LoadingStateManager.a().a(1);
    super.a(paramLogoutReason);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      q();
    }
    do
    {
      do
      {
        return true;
        if (paramInt != 4) {
          break;
        }
        paramKeyEvent = b();
      } while ((paramKeyEvent != null) && (paramKeyEvent.c()));
      try
      {
        getActivity().moveTaskToBack(true);
        return true;
      }
      catch (Throwable paramKeyEvent) {}
    } while (!QLog.isColorLevel());
    QLog.e("MainFragment", 2, "", paramKeyEvent);
    return true;
    return false;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    com.tencent.mobileqq.app.FriendListHandler.ca = -1;
    this.g = false;
    SharedPreUtils.a(getActivity().getApplication(), "");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.m)) && (this.m.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {}
    }
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)getActivity().getSystemService("notification");
      localNotificationManager.cancel(120);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(122);
      localNotificationManager.cancel(123);
      localNotificationManager.cancel(129);
      localNotificationManager.cancel(144);
      localNotificationManager.cancel(193);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
  }
  
  void c()
  {
    ThreadManager.b().postDelayed(new lur(this), 500L);
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void e()
  {
    f();
    Dialog localDialog = a("退出", "你确定退出QQ？", new luv(this));
    Object localObject = (TextView)localDialog.findViewById(2131297844);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new luw(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131297843);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new lux(this));
    }
    localObject = getString(2131369617);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131298193);
    if ((bool) && (this.jdField_d_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void g()
  {
    super.g();
    Frame localFrame = a(Conversation.class);
    if (localFrame != null) {
      ((Conversation)localFrame).a();
    }
    localFrame = a(Contacts.class);
    if (localFrame != null) {
      ((Contacts)localFrame).m();
    }
    localFrame = a(Leba.class);
    if (localFrame != null) {
      ((Leba)localFrame).o();
    }
    localFrame = a(Call.class);
    if (localFrame != null) {
      ((Call)localFrame).k();
    }
  }
  
  public void h()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).b()))
    {
      localObject = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
      if (localObject != null)
      {
        VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
        if ((localVipGiftDownloadInfo != null) && (isResumed()) && (localVipGiftDownloadInfo.d == 2L)) {
          ((VipGiftManager)localObject).a(localVipGiftDownloadInfo, getActivity());
        }
      }
    }
  }
  
  public void i()
  {
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.l();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver((SplashActivity)getActivity());
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130968631)
      {
        localObject = new MainEnterOutAni();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131623944));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
      }
      for (;;)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
        return (Animation)localObject;
        localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      }
    }
    ((Animation)localObject).reset();
    return (Animation)localObject;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onCreateView + rootView =  " + this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      paramViewGroup = getActivity().findViewById(2131298407);
      if (paramViewGroup != null)
      {
        ViewParent localViewParent = paramViewGroup.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(paramViewGroup);
        }
      }
      paramViewGroup = (SplashActivity)getActivity();
      if (paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewView[0];
        paramLayoutInflater = new lun(this);
        if (!StartService.jdField_a_of_type_Boolean) {
          break label172;
        }
        paramLayoutInflater.run();
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      break;
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        break;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      break;
      label172:
      ThreadManager.b().postDelayed(paramLayoutInflater, 1000L);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      if (!this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
        this.jdField_f_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
    ScreenCapture.clearSnapCacheFile(getActivity());
    if (getActivity().isFinishing()) {}
    try
    {
      UniformDownloadMgr.a().c();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "MainActivity.onDestory");
      }
      if (DownloadManager.a()) {
        DownloadManager.a().e();
      }
      AppNotificationManager.a().a();
      TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Intent localIntent;
        localThrowable.printStackTrace();
        continue;
        boolean bool = false;
      }
      label246:
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false)) {
        break label297;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startPCActivePolling(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "exitApp");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(true);
      return;
      label297:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      bool = true;
      jdField_b_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isClearTaskBySystem = jdField_b_of_type_Boolean;
        if (!jdField_b_of_type_Boolean) {
          break label246;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop = true;
        localIntent = new Intent("mqq.intent.action.EXIT" + getActivity().getPackageName());
        getActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroyView");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
    this.jdField_f_of_type_Boolean = true;
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    QLog.d("MainFragment", 1, "onHiddenChanged" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_e_of_type_Boolean = true;
      onPause();
      onStop();
      this.jdField_e_of_type_Boolean = false;
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      if (Build.VERSION.SDK_INT < 18) {
        this.jdField_a_of_type_AndroidViewView.requestFocus();
      }
      if (getActivity().getIntent().getBooleanExtra("isFromAioFragment", false))
      {
        onStart();
        onResume();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.jdField_c_of_type_Int != 1) && (!this.jdField_e_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onPause return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onPause");
    }
    if ((this.jdField_b_of_type_Long != 0L) && (this.p != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.p, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.jdField_b_of_type_Long = 0L;
    d();
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.jdField_f_of_type_Int == 2) {
      o();
    }
    FrameHelperActivity.b(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.jdField_c_of_type_Int != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onResume return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onResume");
    }
    StartupTracker.a(null, "Main_OnResume");
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    FrameHelperActivity.b(true);
    if (DrawerFrame.jdField_f_of_type_Int > 0)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.removeMessages(1031);
      }
      o();
    }
    c(false);
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    ThreadManager.b().postDelayed(new luq(this), 1000L);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    StartupTracker.a("Main_OnResume", null);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.jdField_c_of_type_Int != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart");
      }
    } while ((this.jdField_q_of_type_JavaLangString == null) || (this.jdField_q_of_type_JavaLangString.length() <= 0) || (!"pakage_from_h5".equalsIgnoreCase(this.r)));
    JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_q_of_type_JavaLangString);
    localJumpAction.b(this.r);
    localJumpAction.b();
    this.jdField_q_of_type_JavaLangString = null;
    this.r = null;
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.jdField_c_of_type_Int != 1) && (!this.jdField_e_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStop return");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onStop");
      }
    } while (DrawerFrame.jdField_f_of_type_Int <= 0);
    o();
  }
  
  public void onTabChanged(String paramString)
  {
    if ((this.jdField_b_of_type_Long != 0L) && (this.p != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.p, (int)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long), 0, null);
    }
    this.p = paramString;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    Object localObject = a();
    int i2 = jdField_a_of_type_Int;
    if ((localObject != null) && ((localObject instanceof Call))) {
      i2 = jdField_b_of_type_Int;
    }
    for (;;)
    {
      super.onTabChanged(paramString);
      com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
      int i1 = jdField_a_of_type_Int;
      if (paramString.equals(Conversation.class.getName())) {
        i1 = jdField_a_of_type_Int;
      }
      label541:
      label628:
      for (;;)
      {
        if ((i2 == jdField_b_of_type_Int) && (i1 != jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          paramString = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
          if (paramString != null) {
            paramString.b(MessageCache.a());
          }
        }
        localObject = (DragTextView)this.jdField_a_of_type_JavaUtilHashMap.get("消息_num");
        if (i1 == jdField_a_of_type_Int) {}
        for (paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;; paramString = null)
        {
          ((DragTextView)localObject).setOnModeChangeListener(paramString);
          if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
            this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
          }
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lus(this, i1), 100L);
          c();
          return;
          if (paramString.equals(Contacts.class.getName()))
          {
            i1 = jdField_c_of_type_Int;
            c();
            break;
          }
          if (paramString.equals(Leba.class.getName()))
          {
            int i3 = jdField_d_of_type_Int;
            paramString = b();
            i1 = i3;
            if (paramString == null) {
              break;
            }
            i1 = i3;
            if (!(paramString instanceof Leba)) {
              break;
            }
            boolean bool = d();
            ((Leba)paramString).b(bool);
            i1 = i3;
            break;
          }
          if (paramString.equals(Call.class.getName()))
          {
            i1 = jdField_b_of_type_Int;
            if ((this.jdField_a_of_type_JavaUtilHashMap != null) && ((this.jdField_a_of_type_JavaUtilHashMap.get("电话" + "_num") instanceof TextView)))
            {
              paramString = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get("电话" + "_num");
              if ((paramString == null) || (paramString.getVisibility() != 0)) {
                break label541;
              }
              paramString.setVisibility(8);
              paramString = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
              if ((paramString != null) && (paramString.c())) {
                paramString.d(true);
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004ED9", "0X8004ED9", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                paramString = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
                if (paramString != null) {
                  paramString.b(MessageCache.a());
                }
                ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("101300");
              }
              break;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EDA", "0X8004EDA", 0, 0, "", "", "", "");
            }
          }
          if (!paramString.equals(Now.class.getName())) {
            break label628;
          }
          i1 = jdField_f_of_type_Int;
          StoryReportor.a("story_tab", "clk", 0, ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).d(), new String[0]);
          break;
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onViewCreated");
    }
    super.onViewCreated(paramView, paramBundle);
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnDrawCompleteListener(this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\MainFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */