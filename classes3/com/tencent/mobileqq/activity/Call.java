package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.InviteStartAudioDialog;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.activity.recent.RecentCallObserver;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactHelper;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CallTabLightalkConfig;
import com.tencent.mobileqq.jumplightalk.JumpLightalkUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.huangye.C2BUtils;
import cooperation.huangye.HYBridgeActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import krk;
import krl;
import krm;
import krn;
import kro;
import krs;
import krt;
import kru;
import krv;
import krw;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

public class Call
  extends Frame
  implements Handler.Callback, ViewStub.OnInflateListener, OnRecentUserOpsListener, AbsListView.OnScrollListener, OverScrollViewListener, Observer
{
  public static final int a = 1020;
  private static final String jdField_a_of_type_JavaLangString = "CallTab";
  public static final int b = 1021;
  public static final int c = 1022;
  public static final int d = 1025;
  public static final int e = 1027;
  public static final int f = 1030;
  public static final int g = 16;
  protected static final int h = 0;
  protected static final int i = 1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected Handler.Callback a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  private RecentCallHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
  private RecentCallObserver jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  private RedDotTextView jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public MqqHandler a;
  public boolean a;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  boolean c;
  boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private int j;
  
  public Call()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 0;
    this.c = true;
    this.d = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new krk(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new krm(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver = new krn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kro(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new krs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new krt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new kru(this);
    this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new krv(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new krw(this);
  }
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(BaseApplication.getContext(), 2131367256, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
    }
    while (paramString == null) {
      return;
    }
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Intent localIntent = new Intent(a(), MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    ArrayList localArrayList = ((DiscussionManager)localObject).a(paramString);
    if (localArrayList != null)
    {
      int m = localArrayList.size();
      localObject = new long[m];
      int k = 0;
      while (k < m)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(k);
        if (localDiscussionMemberInfo != null) {
          localObject[k] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        k += 1;
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", (long[])localObject);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", 3000);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString);
      long l = Long.valueOf(paramString).longValue();
      localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l));
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent);
      a(localIntent);
      a().overridePendingTransition(2130968590, 0);
      return;
      localObject = null;
    }
  }
  
  private boolean a(String paramString, List paramList)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramString = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.uin)) && (!paramString.uin.equals("0")))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        InviteBaseData localInviteBaseData = (InviteBaseData)paramList.next();
        if ((localInviteBaseData.jdField_a_of_type_JavaLangString != null) && (localInviteBaseData.jdField_a_of_type_JavaLangString.equals(paramString.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallTab", 2, "showCallTimeUseUpBar:" + paramString);
    }
  }
  
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "setFirstDrawComplete, " + this.g);
    }
    if (this.g) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.g = true;
    if (!this.h) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    i();
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131296895));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297137));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297394));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297393));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)a(2131297395));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = new RecentCallHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetLinearLayout, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.j();
  }
  
  private void o()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
  }
  
  private void p()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", a(2131363438));
    localIntent.putExtra("param_done_button_wording", a(2131369290));
    localIntent.putExtra("param_done_button_highlight_wording", a(2131370215));
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    a(localIntent, 1400);
    a().overridePendingTransition(2130968590, 2130968591);
  }
  
  private void q()
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)2);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CallTab", 2, localException.toString());
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      }
      QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localQCallFacade != null) {
        localQCallFacade.deleteObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    }
    try
    {
      a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CallTab", 2, localException.toString());
    }
  }
  
  public void A_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CallTab", 4, "onDrawComplete, [" + this.g + "," + this.f + "]");
    }
    if ((!this.g) && (!this.f)) {
      m();
    }
    while (!this.g) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(2130903158, null);
  }
  
  protected String a()
  {
    return a(2131367567);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localQCallFacade != null) {
        localQCallFacade.b(MessageCache.a());
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 == 1400)
          {
            str1 = paramIntent.getStringExtra("roomId");
            localObject = paramIntent.getStringArrayListExtra("qqPhoneUserList");
            paramInt1 = paramIntent.getIntExtra("from", 6);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().put(Long.valueOf(str1), "CREATE_FROM_CALL");
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, str1, true, true, true, null, (ArrayList)localObject, 4, paramInt1);
            if (this.jdField_b_of_type_Boolean)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 10, 0, "", "", "", "");
              this.jdField_b_of_type_Boolean = false;
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 7, 0, "", "", "", "");
            return;
          }
        } while (paramInt1 != 111);
        paramInt1 = paramIntent.getIntExtra("audioType", -1);
        if (paramInt1 == 1)
        {
          paramInt1 = paramIntent.getIntExtra("uinType", 0);
          str1 = paramIntent.getStringExtra("peerUin");
          localObject = paramIntent.getStringExtra("name");
          str2 = paramIntent.getStringExtra("phoneNum");
          paramIntent = paramIntent.getStringExtra("from");
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, str1, (String)localObject, str2, true, null, true, true, null, paramIntent);
          return;
        }
        if (paramInt1 != 2) {
          break;
        }
        paramInt1 = paramIntent.getIntExtra("uinType", 3000);
        str1 = paramIntent.getStringExtra("roomId");
        localObject = paramIntent.getStringArrayListExtra("qqPhoneUserList");
        paramInt2 = paramIntent.getIntExtra("callType", 2);
        int k = paramIntent.getIntExtra("from", 3);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, str1, true, true, true, null, (ArrayList)localObject, paramInt2, k);
        paramInt1 = paramIntent.getIntExtra("reportType", 0);
        if (paramInt1 == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 5, 0, "", "", "", "");
          return;
        }
      } while (paramInt1 != 2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 6, 0, "", "", "", "");
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = paramIntent.getIntExtra("uinType", 0);
        str1 = paramIntent.getStringExtra("peerUin");
        localObject = paramIntent.getStringExtra("name");
        str2 = paramIntent.getStringExtra("phoneNum");
        paramInt2 = paramIntent.getIntExtra("from", 3);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, str1, (String)localObject, str2, true, null, true, true, null, null, paramInt2, true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 4);
    paramInt1 = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("peerUin");
    Object localObject = paramIntent.getStringExtra("name");
    String str2 = paramIntent.getStringExtra("phoneNum");
    String str3 = paramIntent.getStringExtra("selfPhoneNum");
    paramInt2 = paramIntent.getIntExtra("from", 3);
    paramIntent = new PstnSessionInfo();
    paramIntent.jdField_a_of_type_Int = paramInt1;
    paramIntent.jdField_a_of_type_JavaLangString = str1;
    paramIntent.d = ((String)localObject);
    paramIntent.b = str2;
    paramIntent.jdField_c_of_type_JavaLangString = str3;
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramIntent, paramInt2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject1;
    QCallRecent localQCallRecent;
    if ((paramRecentBaseData instanceof RecentCallItem))
    {
      localObject1 = (RecentCallItem)paramRecentBaseData;
      localQCallRecent = ((RecentCallItem)localObject1).a();
      switch (((RecentCallItem)localObject1).c())
      {
      case 2: 
      default: 
        localObject1 = "99";
      }
    }
    for (;;)
    {
      Object localObject3 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
      int k = ((PstnManager)localObject3).a();
      Object localObject4 = ((PstnManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      int m;
      label137:
      Object localObject2;
      label171:
      String str;
      if (localQCallRecent != null)
      {
        m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localQCallRecent.uin);
        if ((m == 2) || (m == 4))
        {
          localQCallRecent.isVideo = 1;
          m = localQCallRecent.type;
          localObject2 = null;
          paramRecentBaseData = null;
          if ((m != 1006) && (m != 2016)) {
            break label283;
          }
          paramRecentBaseData = localQCallRecent.uin;
          str = localQCallRecent.troopUin;
          if ((paramView == null) || (paramView.getId() != 2131301466)) {
            break label2368;
          }
          if (k != 0) {
            break label1700;
          }
          if (!localQCallRecent.isVideo()) {
            break label4861;
          }
        }
      }
      label283:
      label536:
      label856:
      label919:
      label1283:
      label1323:
      label1340:
      label1387:
      label1462:
      label1648:
      label1686:
      label1693:
      label1700:
      label2045:
      label2368:
      label2793:
      label3065:
      label3362:
      label3425:
      label3789:
      label3829:
      label3846:
      label3893:
      label4747:
      label4785:
      label4792:
      label4841:
      label4861:
      for (paramBoolean = false;; paramBoolean = true)
      {
        if (localQCallRecent.type == 26) {
          OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), localQCallRecent.uin, 0, null, 3);
        }
        long l1;
        long l2;
        do
        {
          return;
          localObject1 = "0";
          break;
          localObject1 = "1";
          break;
          localObject1 = "2";
          break;
          if ((m != 1) && (m != 3)) {
            break label137;
          }
          localQCallRecent.isVideo = 0;
          break label137;
          localObject2 = localQCallRecent.uin;
          break label171;
          if (localQCallRecent.isSystemCall == 1)
          {
            if (localQCallRecent.phoneNumber != null)
            {
              paramRecentBaseData = localQCallRecent.phoneNumber;
              if (paramRecentBaseData != null)
              {
                paramView = PhoneContactHelper.a(paramRecentBaseData);
                l1 = MessageCache.a();
                a(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView)));
                paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                if (m != 9502) {
                  break label536;
                }
                if (TextUtils.isEmpty(localQCallRecent.phoneNumber)) {
                  localQCallRecent.phoneNumber = localQCallRecent.uin;
                }
                paramRecentBaseData.a(localQCallRecent.uin, paramString, localQCallRecent.businessLogo, localQCallRecent.businessSeId, 9502, l1, localQCallRecent.phoneNumber);
              }
            }
            for (;;)
            {
              ReportController.b(null, "CliOper", "", "", "0X8005422", "0X8005422", 0, 0, "", "", "", "");
              return;
              if ((m == 1006) || (m == 56938) || (m == 9502))
              {
                paramRecentBaseData = localQCallRecent.uin;
                break;
              }
              paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(localQCallRecent.uin);
              if (paramView == null) {
                break;
              }
              paramRecentBaseData = paramView.mobileNo;
              break;
              paramRecentBaseData.a(localQCallRecent.uin, m, localQCallRecent.contactId, l1, paramView);
            }
          }
          if ((localQCallRecent.type == 3000) || (localQCallRecent.type == 1))
          {
            try
            {
              l1 = Long.parseLong((String)localObject2);
              k = UITools.a(localQCallRecent.type);
              l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1);
              if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e())) {
                break label919;
              }
              paramRecentBaseData = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, localQCallRecent.type);
              paramView = new ArrayList();
              if (!TextUtils.isEmpty(paramRecentBaseData))
              {
                paramRecentBaseData = PstnUtils.a(paramRecentBaseData);
                if (paramRecentBaseData != null)
                {
                  k = 0;
                  while (k < paramRecentBaseData.size())
                  {
                    paramView.add(((AVPhoneUserInfo)paramRecentBaseData.get(k)).telInfo.mobile);
                    k += 1;
                  }
                }
              }
            }
            catch (NumberFormatException paramView)
            {
              for (;;)
              {
                l1 = 0L;
              }
              if (paramView.size() > 0)
              {
                paramRecentBaseData = PstnUtils.b(paramView);
                if (QLog.isColorLevel()) {
                  QLog.d("CallTab", 2, "R.id.qq_call_bottom_left --> jsonString = " + paramRecentBaseData);
                }
              }
              if (TextUtils.isEmpty(localQCallRecent.pstnInfo)) {
                break label856;
              }
            }
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, localQCallRecent.troopUin, true, true, true, null, paramView, 2, 3);
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800486A", "0X800486A", 0, 0, (String)localObject1, "", "", "");
              return;
              ReportController.b(null, "CliOper", "", "", "0X800552A", "0X800552A", 0, 0, "", "", "", "");
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, localQCallRecent.troopUin, true, true, true, null, paramView, 3, 3);
              continue;
              if (l2 == 0L)
              {
                paramView = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (paramView != null)
                {
                  paramRecentBaseData = paramView.a((String)localObject2);
                  paramView = new ArrayList();
                  paramRecentBaseData = paramRecentBaseData.iterator();
                  while (paramRecentBaseData.hasNext())
                  {
                    paramString = (DiscussionMemberInfo)paramRecentBaseData.next();
                    if (!paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                      paramView.add(new InviteBaseData(paramString));
                    }
                  }
                  paramString = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, localQCallRecent.type);
                  paramRecentBaseData = new ArrayList();
                  if (!TextUtils.isEmpty(paramString))
                  {
                    paramString = PstnUtils.a(paramString);
                    if (paramString != null)
                    {
                      paramString = paramString.iterator();
                      while (paramString.hasNext())
                      {
                        localObject2 = (AVPhoneUserInfo)paramString.next();
                        if (!a(((AVPhoneUserInfo)localObject2).telInfo.mobile, paramView)) {
                          paramView.add(new InviteBaseData((AVPhoneUserInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                        }
                        paramRecentBaseData.add(((AVPhoneUserInfo)localObject2).telInfo.mobile);
                      }
                    }
                  }
                  paramString = a();
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  localObject3 = a();
                  localObject4 = localQCallRecent.troopUin;
                  if (TextUtils.isEmpty(localQCallRecent.pstnInfo)) {}
                  for (k = 2;; k = 1)
                  {
                    new InviteStartAudioDialog(paramString, (QQAppInterface)localObject2, (BaseActivity)localObject3, paramView, paramRecentBaseData, (String)localObject4, k).show();
                    break;
                  }
                }
              }
              else
              {
                a((String)localObject2);
              }
            }
          }
          if (m != 1024) {
            break label1462;
          }
          if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, m))
          {
            CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString, (String)localObject2, "IvrCallItemEngineFalse");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
            if (!paramBoolean) {
              break label1648;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject1, "", "", "");
            paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!localQCallRecent.isVideo()) {
              break label1686;
            }
            paramView = "1";
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject1, "", "");
            paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!localQCallRecent.isMissedCall()) {
              break label1693;
            }
            paramView = "0";
            ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
            return;
          }
          QQToast.a(paramView.getContext(), 2131363560, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492908));
        } while (!QLog.isColorLevel());
        QLog.d("CallTab", 2, "Don't support ivr");
        return;
        localObject3 = null;
        if ((localQCallRecent.bindType == 2) || (localQCallRecent.bindType == 3) || (localQCallRecent.extraType == 25))
        {
          localObject3 = new HashMap();
          ((Map)localObject3).put("dstClient", "Lightalk");
          ((Map)localObject3).put("bindType", String.valueOf(localQCallRecent.bindType));
          ((Map)localObject3).put("bindId", localQCallRecent.bindId);
          ((Map)localObject3).put("extraType", String.valueOf(localQCallRecent.extraType));
          localObject4 = localQCallRecent.phoneNumber;
          paramView = (View)localObject4;
          paramRecentBaseData = (RecentBaseData)localObject3;
          if (localQCallRecent.lightalkSig != null)
          {
            ((Map)localObject3).put("sig", HexUtil.a(localQCallRecent.lightalkSig));
            paramRecentBaseData = (RecentBaseData)localObject3;
            paramView = (View)localObject4;
          }
        }
        for (;;)
        {
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), m, (String)localObject2, paramString, paramView, paramBoolean, str, true, true, null, "from_internal", paramRecentBaseData);
          break label1283;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject1, "", "", "");
          break label1323;
          paramView = "0";
          break label1340;
          paramView = "1";
          break label1387;
          if (k != 1) {
            break;
          }
          paramView = new Intent(a(), QCallDetailActivity.class);
          paramView.putExtra("uin", localQCallRecent.uin);
          paramView.putExtra("troop_uin", localQCallRecent.troopUin);
          paramView.putExtra("uintype", m);
          paramView.putExtra("uinname", paramString);
          paramView.putExtra("bind_type", localQCallRecent.bindType);
          paramView.putExtra("bind_id", localQCallRecent.bindId);
          paramView.putExtra("extra_type", localQCallRecent.extraType);
          paramView.putExtra("phonenum", localQCallRecent.phoneNumber);
          paramView.putExtra("key_huangye_logo_url", localQCallRecent.businessLogo);
          if (!TextUtils.isEmpty(localQCallRecent.businessSeId)) {
            paramView.putExtra("key_huangye_business_se_id", localQCallRecent.businessSeId);
          }
          paramView.putExtra("sig", localQCallRecent.lightalkSig);
          paramView.putExtra("entrance", "Call");
          if (localQCallRecent.type == 3000)
          {
            localObject2 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(localQCallRecent.troopUin);
            paramString = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localQCallRecent.troopUin, 3000);
            paramRecentBaseData = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
            if (!TextUtils.isEmpty(paramString))
            {
              paramString = PstnUtils.b(paramString);
              if ((localObject2 == null) || (((Map)localObject2).keySet() == null)) {
                break label4841;
              }
              localObject2 = ((Map)localObject2).keySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if ((paramString != null) && (localObject3 != null) && (!paramString.contains(paramRecentBaseData.b((String)localObject3))) && (!((String)localObject3).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
                {
                  paramBoolean = false;
                  paramView.putExtra("key_from_lightalk_phone_num", paramBoolean);
                }
              }
            }
          }
          for (;;)
          {
            a(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
            if (localQCallRecent.type == 3000) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject1, "", "", "");
            }
            for (;;)
            {
              if (localQCallRecent.type == 3000)
              {
                if (paramBoolean)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 4, 0, "", "", "", "");
                  return;
                  paramBoolean = false;
                  break;
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject1, "", "", "");
                  continue;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 3, 0, "", "", "", "");
                return;
              }
            }
            if (localQCallRecent.callType == 1)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 1, 0, "", "", "", "");
              return;
            }
            if (localQCallRecent.callType != 2) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F6", "0X80063F6", 2, 0, "", "", "", "");
            return;
            if (k == 0)
            {
              paramView = new Intent(a(), QCallDetailActivity.class);
              paramView.putExtra("uin", localQCallRecent.uin);
              paramView.putExtra("troop_uin", localQCallRecent.troopUin);
              paramView.putExtra("uintype", m);
              paramView.putExtra("uinname", paramString);
              paramView.putExtra("bind_type", localQCallRecent.bindType);
              paramView.putExtra("bind_id", localQCallRecent.bindId);
              paramView.putExtra("extra_type", localQCallRecent.extraType);
              paramView.putExtra("phonenum", localQCallRecent.phoneNumber);
              paramView.putExtra("key_huangye_logo_url", localQCallRecent.businessLogo);
              if (!TextUtils.isEmpty(localQCallRecent.businessSeId)) {
                paramView.putExtra("key_huangye_business_se_id", localQCallRecent.businessSeId);
              }
              paramView.putExtra("sig", localQCallRecent.lightalkSig);
              paramView.putExtra("entrance", "Call");
              a(paramView);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
              if (localQCallRecent.type == 3000)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject1, "", "", "");
                return;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject1, "", "", "");
              return;
            }
            if (localQCallRecent.isVideo()) {}
            for (paramBoolean = false;; paramBoolean = true)
            {
              if (localQCallRecent.type == 26)
              {
                paramView = new PstnSessionInfo();
                paramView = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, localQCallRecent.uin, localQCallRecent.type);
                if ((paramView.b != null) && (paramView.jdField_c_of_type_JavaLangString != null))
                {
                  m = 1;
                  int n = 0;
                  k = n;
                  if (m != 0)
                  {
                    k = n;
                    if (localObject4 != null)
                    {
                      if (((PstnCardInfo)localObject4).pstn_c2c_call_time <= 0) {
                        break label2793;
                      }
                      k = 1;
                    }
                  }
                }
                for (;;)
                {
                  OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), localQCallRecent.uin, k, paramView, 2);
                  return;
                  m = 0;
                  break;
                  if ((((PstnManager)localObject3).b() == 1) && (((PstnCardInfo)localObject4).pstn_c2c_try_status == 0)) {
                    k = 2;
                  } else {
                    k = 5;
                  }
                }
              }
              if (localQCallRecent.isSystemCall == 1)
              {
                if (localQCallRecent.phoneNumber != null)
                {
                  paramRecentBaseData = localQCallRecent.phoneNumber;
                  if (paramRecentBaseData != null)
                  {
                    paramView = PhoneContactHelper.a(paramRecentBaseData);
                    l1 = MessageCache.a();
                    a(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView)));
                    paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                    if (m != 9502) {
                      break label3065;
                    }
                    if (TextUtils.isEmpty(localQCallRecent.phoneNumber)) {
                      localQCallRecent.phoneNumber = localQCallRecent.uin;
                    }
                    paramRecentBaseData.a(localQCallRecent.uin, paramString, localQCallRecent.businessLogo, localQCallRecent.businessSeId, 9502, l1, localQCallRecent.phoneNumber);
                  }
                }
                for (;;)
                {
                  ReportController.b(null, "CliOper", "", "", "0X8005422", "0X8005422", 0, 0, "", "", "", "");
                  return;
                  if ((m == 1006) || (m == 56938) || (m == 9502))
                  {
                    paramRecentBaseData = localQCallRecent.uin;
                    break;
                  }
                  paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(localQCallRecent.uin);
                  if (paramView == null) {
                    break;
                  }
                  paramRecentBaseData = paramView.mobileNo;
                  break;
                  paramRecentBaseData.a(localQCallRecent.uin, m, localQCallRecent.contactId, l1, paramView);
                }
              }
              if ((localQCallRecent.type == 3000) || (localQCallRecent.type == 1))
              {
                try
                {
                  l1 = Long.parseLong((String)localObject2);
                  k = UITools.a(localQCallRecent.type);
                  l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l1)) {
                    break label3425;
                  }
                  paramRecentBaseData = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, localQCallRecent.type);
                  paramView = new ArrayList();
                  if (!TextUtils.isEmpty(paramRecentBaseData))
                  {
                    paramRecentBaseData = PstnUtils.a(paramRecentBaseData);
                    if (paramRecentBaseData != null)
                    {
                      k = 0;
                      while (k < paramRecentBaseData.size())
                      {
                        paramView.add(((AVPhoneUserInfo)paramRecentBaseData.get(k)).telInfo.mobile);
                        k += 1;
                      }
                    }
                  }
                }
                catch (NumberFormatException paramView)
                {
                  for (;;)
                  {
                    l1 = 0L;
                  }
                  if (paramView.size() > 0)
                  {
                    paramRecentBaseData = PstnUtils.b(paramView);
                    if (QLog.isColorLevel()) {
                      QLog.d("CallTab", 2, "R.id.qq_call_bottom_left --> jsonString = " + paramRecentBaseData);
                    }
                  }
                  if (TextUtils.isEmpty(localQCallRecent.pstnInfo)) {
                    break label3362;
                  }
                }
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, localQCallRecent.troopUin, true, true, true, null, paramView, 2, 3);
                for (;;)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800486A", "0X800486A", 0, 0, (String)localObject1, "", "", "");
                  return;
                  ReportController.b(null, "CliOper", "", "", "0X800552A", "0X800552A", 0, 0, "", "", "", "");
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, localQCallRecent.troopUin, true, true, true, null, paramView, 3, 3);
                  continue;
                  if (l2 == 0L)
                  {
                    paramView = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                    if (paramView != null)
                    {
                      paramRecentBaseData = paramView.a((String)localObject2);
                      paramView = new ArrayList();
                      paramRecentBaseData = paramRecentBaseData.iterator();
                      while (paramRecentBaseData.hasNext())
                      {
                        paramString = (DiscussionMemberInfo)paramRecentBaseData.next();
                        if (!paramString.memberUin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
                          paramView.add(new InviteBaseData(paramString));
                        }
                      }
                      paramString = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, localQCallRecent.type);
                      paramRecentBaseData = new ArrayList();
                      if (!TextUtils.isEmpty(paramString))
                      {
                        paramString = PstnUtils.a(paramString);
                        if (paramString != null)
                        {
                          paramString = paramString.iterator();
                          while (paramString.hasNext())
                          {
                            localObject2 = (AVPhoneUserInfo)paramString.next();
                            if (!a(((AVPhoneUserInfo)localObject2).telInfo.mobile, paramView)) {
                              paramView.add(new InviteBaseData((AVPhoneUserInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                            }
                            paramRecentBaseData.add(((AVPhoneUserInfo)localObject2).telInfo.mobile);
                          }
                        }
                      }
                      paramString = a();
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      localObject3 = a();
                      localObject4 = localQCallRecent.troopUin;
                      if (TextUtils.isEmpty(localQCallRecent.pstnInfo)) {}
                      for (k = 2;; k = 1)
                      {
                        new InviteStartAudioDialog(paramString, (QQAppInterface)localObject2, (BaseActivity)localObject3, paramView, paramRecentBaseData, (String)localObject4, k).show();
                        break;
                      }
                    }
                  }
                  else
                  {
                    a((String)localObject2);
                  }
                }
              }
              if (m == 1024)
              {
                if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, m))
                {
                  CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString, (String)localObject2, "IvrCallItemEngineFalse");
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
                  if (!paramBoolean) {
                    break label4747;
                  }
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject1, "", "", "");
                  paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  if (!localQCallRecent.isVideo()) {
                    break label4785;
                  }
                  paramView = "1";
                  ReportController.b(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject1, "", "");
                  paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  if (!localQCallRecent.isMissedCall()) {
                    break label4792;
                  }
                  paramView = "0";
                  ReportController.b(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
                  return;
                }
                QQToast.a(paramView.getContext(), 2131363560, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492908));
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("CallTab", 2, "Don't support ivr");
                return;
              }
              if ((m == 1006) || (m == 56938) || (m == 9502)) {
                paramRecentBaseData = localQCallRecent.uin;
              }
              for (;;)
              {
                if ((localQCallRecent.bindType == 2) || (localQCallRecent.bindType == 3) || (localQCallRecent.extraType == 25))
                {
                  paramView = new HashMap();
                  paramView.put("dstClient", "Lightalk");
                  paramView.put("bindType", String.valueOf(localQCallRecent.bindType));
                  paramView.put("bindId", localQCallRecent.bindId);
                  paramView.put("extraType", String.valueOf(localQCallRecent.extraType));
                  if (localQCallRecent.lightalkSig != null) {
                    paramView.put("sig", HexUtil.a(localQCallRecent.lightalkSig));
                  }
                  paramRecentBaseData = localQCallRecent.phoneNumber;
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), m, (String)localObject2, paramString, paramRecentBaseData, paramBoolean, str, true, true, null, "from_internal", paramView);
                  return;
                  if (m == 0)
                  {
                    localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                    if (localObject3 != null)
                    {
                      localObject3 = ((PhoneContactManager)localObject3).a(localQCallRecent.uin);
                      if (localObject3 != null) {
                        paramRecentBaseData = ((PhoneContact)localObject3).mobileNo;
                      }
                    }
                  }
                }
                else
                {
                  if (localQCallRecent.isVideo())
                  {
                    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), m, (String)localObject2, paramString, paramRecentBaseData, paramBoolean, str, true, true, null, "from_internal", null);
                    return;
                  }
                  if (m == 1024)
                  {
                    if (CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, m))
                    {
                      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramString, (String)localObject2, "IvrCallItemEngineFalse");
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
                      break label3789;
                    }
                    QQToast.a(paramView.getContext(), 2131363560, 1).b(paramView.getContext().getResources().getDimensionPixelSize(2131492908));
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("CallTab", 2, "Don't support ivr");
                    return;
                  }
                  if (m == 1008)
                  {
                    paramView = new Bundle();
                    paramView.putString("businessName", paramString);
                    paramView.putString("uin", (String)localObject2);
                    paramView.putString("from_where", "callHistoryPage");
                    C2BUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView);
                    break label3789;
                  }
                  if ((localQCallRecent.getState(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 5) || (localQCallRecent.getState(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 6) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e()))
                  {
                    if (localQCallRecent.callType == 1)
                    {
                      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), m, (String)localObject2, paramString, paramRecentBaseData, true, null, true, true, null, "from_internal");
                      break label3789;
                    }
                    if (localQCallRecent.callType == 2)
                    {
                      if (m == 2016) {
                        paramRecentBaseData = (RecentBaseData)localObject2;
                      }
                      paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
                      localObject3 = new PstnSessionInfo();
                      ((PstnSessionInfo)localObject3).jdField_c_of_type_JavaLangString = (paramView.nationCode + paramView.mobileNo);
                      ((PstnSessionInfo)localObject3).b = paramRecentBaseData;
                      ((PstnSessionInfo)localObject3).d = paramString;
                      ((PstnSessionInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
                      ((PstnSessionInfo)localObject3).jdField_a_of_type_Int = m;
                      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (PstnSessionInfo)localObject3, 3);
                      break label3789;
                    }
                    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), m, (String)localObject2, paramString, paramRecentBaseData, true, null, true, true, null, null, 3, true);
                    break label3789;
                  }
                  paramView = new ArrayList();
                  localObject3 = new InviteBaseData();
                  ((InviteBaseData)localObject3).b = paramString;
                  ((InviteBaseData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
                  ((InviteBaseData)localObject3).jdField_c_of_type_Int = m;
                  ((InviteBaseData)localObject3).jdField_c_of_type_JavaLangString = paramRecentBaseData;
                  paramView.add(localObject3);
                  new InviteStartAudioDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView, localQCallRecent.callType).show();
                  break label3789;
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject1, "", "", "");
                  break label3829;
                  paramView = "0";
                  break label3846;
                  paramView = "1";
                  break label3893;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("CallTab", 2, "onRecentBaseDataClick|call is null, data = " + paramRecentBaseData);
                  return;
                }
              }
            }
            paramBoolean = true;
            break label2045;
            paramBoolean = true;
          }
          paramView = paramRecentBaseData;
          paramRecentBaseData = (RecentBaseData)localObject3;
        }
      }
      localObject1 = "99";
      localQCallRecent = null;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    label673:
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() == 2131297818)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
            paramView = new Intent(a(), ForwardRecentActivity.class);
            paramView.putExtra("forward_type", 13);
            a(paramView);
            return;
          }
          if (paramView.getId() == 2131301472)
          {
            paramView = a();
            paramObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
            if (!((PhoneContactManagerImp)paramObject).d())
            {
              a(new Intent(paramView, GuideBindPhoneActivity.class));
              return;
            }
            if ((((PhoneContactManagerImp)paramObject).a() != null) && (((PhoneContactManagerImp)paramObject).a().isStopFindMatch))
            {
              paramObject = new Intent(paramView, PhoneLaunchActivity.class);
              ((Intent)paramObject).putExtra("needAlert", true);
              ((Intent)paramObject).putExtra("fromStopAndMatch", true);
              ((Intent)paramObject).putExtra("fromCall", true);
              ((Intent)paramObject).putExtra("leftViewText", "返回");
              paramView.startActivity((Intent)paramObject);
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F82", "0X8004F82", 0, 0, "", "", "", "");
              return;
              paramView = new Intent(a(), PhoneFrameActivity.class);
              paramView.putExtra("key_req_type", 4);
              paramView.putExtra("kSrouce", 6);
              a().startActivity(paramView);
            }
          }
          if (paramView.getId() != 2131301482) {
            break;
          }
        } while (HYBridgeActivity.a());
        paramView = paramView.findViewById(2131297405);
        if ((paramView != null) && (paramView.getVisibility() != 8)) {
          paramView.setVisibility(8);
        }
        paramView = BaseApplicationImpl.getContext().getSharedPreferences("qqhuangye", 0);
        if (paramView.getBoolean("show_reddot", true)) {
          paramView.edit().putBoolean("show_reddot", false).commit();
        }
        paramView = new Intent(a(), HYBridgeActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
        a(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052C3", "0X80052C3", 0, 0, "", "", "", "");
        return;
        if (paramView.getId() == 2131301425)
        {
          paramView = CallTabLightalkConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if (paramView != null)
          {
            if (!JumpLightalkUtil.a(a())) {
              break label673;
            }
            JumpLightalkUtil.a(a(), null, "10001", "com.tencent.mobileqq", "", "0", "0");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8B", "0X8005C8B", 0, 2, "", "", "", "");
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8B", "0X8005C8B", 0, 0, "", "", "", "");
            paramView = BaseApplicationImpl.getContext().getSharedPreferences("call_tab_lightalk_entrance" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
            if (!paramView.getBoolean("show_reddot", true)) {
              break;
            }
            paramView.edit().putBoolean("show_reddot", false).commit();
            return;
            JumpLightalkUtil.a(a(), paramView.h);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8B", "0X8005C8B", 0, 1, "", "", "", "");
          }
        }
        if (paramView.getId() == 2131301492)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C0C", "0X8004C0C", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() == 2131301481)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F85", "0X8004F85", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView.getId() != 2131297720) && (paramView.getId() != 2131297721) && (paramView.getId() != 2131297722) && (paramView.getId() != 2131297723) && (paramView.getId() != 2131297724) && (paramView.getId() != 2131297725) && (paramView.getId() != 2131297726)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("CallTab", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, (String)paramObject, null, true, null, true, true, null, null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C0D", "0X8004C0D", 0, 0, "", "", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b())) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C12", "0X8004C12", 0, 0, "", "", "", "");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false);
      return;
      if (paramView.getId() == 2131301486)
      {
        if ((a() instanceof SplashActivity)) {
          ((SplashActivity)a()).a(36, 16, null);
        }
        PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, 17);
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("101300.101301");
        return;
      }
      if (paramView.getId() == 2131301490)
      {
        PhoneContactSelectActivity.a(a(), this.jdField_b_of_type_Boolean, 1400);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063F7", "0X80063F7", 0, 0, "", "", "", "");
        return;
      }
    } while (paramView.getId() != 2131301491);
    paramView = new Intent(a(), RecentT9SearchActivity.class);
    paramView.putExtra("key_is_from_try", false);
    a().startActivity(paramView);
    a().overridePendingTransition(2130968592, 2130968589);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if ((localQCallFacade != null) && (paramRecentBaseData != null)) {}
    try
    {
      localQCallFacade.b(paramRecentBaseData.a(), paramRecentBaseData.a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
      if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2")))
      {
        if (paramRecentBaseData.a() == 3000) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
        }
      }
      else {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CallTab", 2, "delRecentCallByUin Error");
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      do
      {
        return;
        this.j = paramInt;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramAbsListView, paramInt);
    } while ((paramInt != 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean));
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "onScrollStateChanged list idle refresh list");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_b_of_type_MqqOsMqqHandler);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.d = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.c();
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
      if (localObject != null)
      {
        if (((PstnManager)localObject).a() != 1) {
          break label281;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText("");
        this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(null);
      }
    }
    this.e = true;
    a().getWindow().setSoftInputMode(32);
    this.j = 0;
    if (this.g)
    {
      if (!this.h) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
      }
      i();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) && (paramBoolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(true, true, this.jdField_b_of_type_MqqOsMqqHandler);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (localObject != null) {
          ((QCallFacade)localObject).b(MessageCache.a());
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
        PhoneContactSelectActivity.a(a(), this.jdField_b_of_type_Boolean, 1400);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        if (localObject != null) {
          ((RedTouchManager)localObject).a(System.currentTimeMillis());
        }
      }
      return;
      label281:
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(a(2131367568));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      boolean bool = NetworkUtil.e(BaseApplication.getContext());
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(paramInt, paramView, paramListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqOsMqqHandler, bool);
    }
    return true;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "isRefreshRecentDataNecesary: mIsForeground|" + this.e + ", msg.arg1|" + paramMessage.arg1);
    }
    return ((this.e) || (paramMessage.arg1 != 0)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.b(paramInt, paramView, paramListView);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler == null) {
      this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.c(), this);
    }
    r();
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      if (this.jdField_b_of_type_MqqOsMqqHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CallTab", 2, "filldata|change account, clear data ,and refresh");
        }
        Message localMessage = Message.obtain();
        localMessage.what = 16;
        localMessage.arg1 = 1;
        this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
    }
    j();
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CallTab", 4, "fillData()");
    }
    b(true);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    n();
    b(false);
  }
  
  public void e()
  {
    super.e();
    this.e = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.d();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(16);
    }
  }
  
  protected boolean e_()
  {
    return (this.j != 0) && (this.j != 1);
  }
  
  protected void f()
  {
    this.f = true;
    this.jdField_a_of_type_Boolean = false;
    s();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.e();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    super.f();
  }
  
  protected void g()
  {
    s();
  }
  
  protected void h()
  {
    super.h();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.f) || (a() == null) || (a().isFinishing())) {}
    do
    {
      do
      {
        return true;
      } while ((paramMessage.what != 16) || (!a(paramMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper == null));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqOsMqqHandler);
    } while (!QLog.isColorLevel());
    QLog.d("CallTab", 2, "Call.handleMessage");
    return true;
  }
  
  public void i()
  {
    RecentCallHelper localRecentCallHelper;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null)
    {
      if (!this.e) {
        break label44;
      }
      localRecentCallHelper = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
      if (e_()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localRecentCallHelper.a(bool, true, this.jdField_b_of_type_MqqOsMqqHandler);
      return;
    }
    label44:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.jdField_b_of_type_Boolean = true;
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 176	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 1277	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 176	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: bipush 37
    //   23: invokevirtual 182	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   26: checkcast 514	com/tencent/mobileqq/qcall/QCallFacade
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +8 -> 39
    //   34: aload_1
    //   35: aload_0
    //   36: invokevirtual 1358	com/tencent/mobileqq/qcall/QCallFacade:addObserver	(Ljava/util/Observer;)V
    //   39: aload_0
    //   40: getfield 176	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 1361	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   46: invokevirtual 1365	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	()V
    //   49: aload_0
    //   50: getfield 176	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   56: aload_0
    //   57: getfield 113	com/tencent/mobileqq/activity/Call:jdField_a_of_type_ComTencentAvGaudioAVObserver	Lcom/tencent/av/gaudio/AVObserver;
    //   60: invokevirtual 1366	com/tencent/av/gaudio/AVNotifyCenter:addObserver	(Ljava/util/Observer;)V
    //   63: goto -49 -> 14
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Call
    //   29	6	1	localQCallFacade	QCallFacade
    //   66	4	1	localObject	Object
    //   9	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	10	66	finally
    //   17	30	66	finally
    //   34	39	66	finally
    //   39	63	66	finally
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.j();
    }
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(a().getColor(2131428295));
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    }
  }
  
  public void l()
  {
    super.l();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.l();
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a(a(), paramViewStub, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this, this, this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof QCallFacade))
    {
      if (!(paramObject instanceof Boolean)) {
        break label103;
      }
      if (((Boolean)paramObject).booleanValue())
      {
        paramObservable = null;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          paramObservable = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        }
        if (paramObservable != null) {
          paramObservable.a(false);
        }
      }
    }
    for (;;)
    {
      if ((!this.e) && (this.jdField_a_of_type_MqqOsMqqHandler != null) && (RecentUtil.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1027))) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1027, 100L);
      }
      return;
      label103:
      a().runOnUiThread(new krl(this));
      i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */