package com.tencent.av.random.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersUI.MVMembersInfo;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.AvAddFriendHelper.IAvAddFriendCallBack;
import com.tencent.av.utils.AvImpeachUtil;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import glz;
import gmb;
import gmc;
import gmd;
import gmi;
import gmj;
import gmm;
import gmq;
import gmr;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.BaseActivity;

public class RandomMultiActivity
  extends BaseActivity
  implements AvAddFriendHelper.IAvAddFriendCallBack
{
  public static String a;
  public static boolean b;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new gmb(this);
  Button jdField_a_of_type_AndroidWidgetButton = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gmm(this);
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new gmj(this);
  RandomController.RandomListener jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener = new glz(this);
  public RandomController a;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  public MultiMembersAudioUI a;
  public AvAddFriendHelper a;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new gmc(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  SensorHelper jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
  public SparkDot a;
  public TipsManager a;
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  public gmr a;
  public Runnable a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public Button b;
  public RelativeLayout b;
  public TextView b;
  public Runnable b;
  String b;
  Button jdField_c_of_type_AndroidWidgetButton;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = new gmi(this);
  public String c;
  public Button d;
  public TextView d;
  public String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "RandomMultiActivity";
  }
  
  public RandomMultiActivity()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Gmr = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = new gmd(this);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString) == null) || (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString) == null)) {}
    for (;;)
    {
      return;
      if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1300L);
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, false);
      Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, true);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean));
      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)) {
        if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), (Bitmap)localObject2);
          SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Boolean = true;
          if (!this.jdField_d_of_type_AndroidWidgetTextView.isShown())
          {
            if (TextUtils.isEmpty(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString)) {
              break label856;
            }
            this.jdField_d_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          label300:
          if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean) {
            continue;
          }
          if ((this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) && (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Boolean))
          {
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), 2130839235, (BitmapFactory.Options)localObject1);
            ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
          }
        }
      }
      try
      {
        localObject1 = BitmapFactory.decodeResource(getResources(), 2130839235, (BitmapFactory.Options)localObject1);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), (Bitmap)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.b().iterator();
        label424:
        String str;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (VideoController.GAudioFriends)((Iterator)localObject1).next();
          str = String.valueOf(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long);
        } while (str.equals(this.jdField_c_of_type_JavaLangString));
        Object localObject3 = this.jdField_a_of_type_ComTencentAvVideoController.a(str, this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long, a(str, this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean));
        if (localObject3 != null) {
          this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long, (Bitmap)localObject3);
        }
        for (;;)
        {
          if ((!this.jdField_c_of_type_JavaLangString.equals(str)) && (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null))
          {
            int i = this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(str);
            a(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long, i);
          }
          if ((SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str))) {
            break label424;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005417", "0X8005417", 0, 0, "", "", "", "");
          SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_Boolean = true;
          break label424;
          if (this.jdField_a_of_type_ComTencentAvRandomRandomController.b())
          {
            this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), (Bitmap)localObject2);
            break;
          }
          this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), (Bitmap)localObject1);
          break;
          if (localObject1 != null)
          {
            this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), (Bitmap)localObject1);
            if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_c_of_type_JavaLangString) == -1)
            {
              this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_c_of_type_JavaLangString);
              break;
            }
            this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_c_of_type_JavaLangString, false);
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "addMemsToStage self face is not ready");
          }
          if (this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_c_of_type_JavaLangString) == -1) {
            this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_c_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_c_of_type_JavaLangString, false);
          return;
          label856:
          this.jdField_a_of_type_ComTencentAvRandomRandomController.i();
          break label300;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "addMemsToStage uin : " + str + ", face is not ready");
          }
          localObject3 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
          BitmapFactory.decodeResource(getResources(), 2130839235, (BitmapFactory.Options)localObject3);
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
          try
          {
            localObject3 = BitmapFactory.decodeResource(getResources(), 2130839235, (BitmapFactory.Options)localObject3);
            this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long, (Bitmap)localObject3);
            if (this.jdField_a_of_type_ComTencentAvRandomRandomController.a(str) == -1)
            {
              this.jdField_a_of_type_ComTencentAvRandomRandomController.a(str);
              continue;
            }
            this.jdField_a_of_type_ComTencentAvRandomRandomController.a(str, false);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            for (;;) {}
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;) {}
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_c_of_type_JavaLangString.equals(paramString);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "quitChat");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.j(this.jdField_a_of_type_ComTencentAvVideoController.a().H);
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.c();
    }
    SessionMgr.a().a().c();
    SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_JavaLangString = null;
    finish();
  }
  
  public void BtnOnClick(View paramView)
  {
    label476:
    int j;
    int i;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131299241: 
    case 2131299239: 
    case 2131299408: 
    case 2131299409: 
    case 2131299240: 
    case 2131299410: 
    case 2131299405: 
    case 2131299402: 
      do
      {
        do
        {
          do
          {
            return;
            paramView = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString);
            if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).c) {}
            for (boolean bool = true;; bool = false)
            {
              paramView.c = bool;
              if (!SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).c) {
                break;
              }
              ReportController.b(null, "CliOper", "", "", "0X80053C2", "0X80053C2", 0, 0, "", "", "", "");
              this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
              this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long, false);
              return;
            }
            this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long, true);
            return;
            this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
            return;
            if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean) {
              ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "1", "", "", "");
            }
            for (;;)
            {
              if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
              {
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                paramView = AnimationUtils.loadAnimation(this, 2130968681);
                paramView.setFillBefore(true);
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(paramView);
                ReportController.b(null, "CliOper", "", "", "0X800696F", "0X800696F", 0, 0, "", "", "", "");
              }
              if (this.jdField_a_of_type_Gmr == null) {
                break;
              }
              this.jdField_a_of_type_Gmr.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.b());
              this.jdField_a_of_type_Gmr.notifyDataSetChanged();
              paramView = (TextView)findViewById(2131299417);
              if (!this.jdField_a_of_type_Gmr.isEmpty()) {
                break label476;
              }
              paramView.setVisibility(0);
              return;
              ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "0", "", "", "");
            }
            paramView.setVisibility(8);
            return;
            ReportController.b(null, "CliOper", "", "", "0X80067B5", "0X80067B5", 0, 0, "", "", "", "");
            e();
            return;
            ReportController.b(null, "CliOper", "", "", "0X80067B6", "0X80067B6", 0, 0, "", "", "", "");
            this.jdField_a_of_type_ComTencentAvRandomRandomController.c();
            return;
            ReportController.b(null, "CliOper", "", "", "0X80053C3", "0X80053C3", 0, 0, "", "", "", "");
            finish();
            j = 2130968685;
            i = j;
            if (this.jdField_a_of_type_ComTencentAvVideoController != null)
            {
              paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
              i = j;
              if (paramView != null) {
                i = SmallScreenUtils.a(paramView.J);
              }
            }
            overridePendingTransition(0, i);
          } while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
          return;
        } while ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString) != 0));
        ReportController.b(null, "CliOper", "", "", "0X80053C5", "0X80053C5", 0, 0, "", "", "", "");
        if (a(this.jdField_d_of_type_JavaLangString) < 30L)
        {
          paramView = (TextView)findViewById(2131299406);
          paramView.setVisibility(0);
          paramView.setText(getResources().getString(2131363805));
          paramView.setContentDescription(getResources().getString(2131363805));
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString, 3023);
        a(this.jdField_d_of_type_JavaLangString, 1, true);
        return;
      } while ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString) != 2));
      ReportController.b(null, "CliOper", "", "", "0X80053C7", "0X80053C7", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(this.jdField_d_of_type_JavaLangString);
      return;
    case 2131299401: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(false);
      return;
    case 2131299404: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "send flower");
      }
      if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "5", "", "", "");
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label1534;
        }
        localObject1 = Utils.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfByte);
        if (localObject1 != null) {
          break label1640;
        }
        localObject1 = "";
      }
      break;
    }
    label995:
    label1015:
    label1130:
    label1534:
    label1637:
    label1640:
    for (;;)
    {
      String str1;
      Object localObject2;
      Object localObject3;
      if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
      {
        str1 = "1";
        paramView = NearbyURLSafeUtil.a(this.jdField_c_of_type_JavaLangString);
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.b().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1130;
        }
        localObject3 = String.valueOf(((VideoController.GAudioFriends)((Iterator)localObject2).next()).jdField_a_of_type_Long);
        if (((String)localObject3).equals(this.jdField_c_of_type_JavaLangString)) {
          break label1637;
        }
        paramView = paramView + "," + NearbyURLSafeUtil.a((String)localObject3);
      }
      for (;;)
      {
        break label1015;
        ReportController.b(null, "CliOper", "", "", "0X800696E", "0X800696E", 0, 0, "4", "", "", "");
        break;
        str1 = "0";
        break label995;
        String str2;
        VideoController.GAudioFriends localGAudioFriends1;
        if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean)
        {
          localObject3 = "";
          str2 = "";
          i = "voice_hall_avatar_".length();
          VideoController.GAudioFriends localGAudioFriends2 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString);
          localGAudioFriends1 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString);
          localObject2 = localObject3;
          if (localGAudioFriends2 != null)
          {
            localObject2 = localObject3;
            if (!TextUtils.isEmpty(localGAudioFriends2.jdField_c_of_type_JavaLangString))
            {
              localObject2 = localObject3;
              if (!TextUtils.equals(localGAudioFriends2.jdField_c_of_type_JavaLangString, "null"))
              {
                j = localGAudioFriends2.jdField_c_of_type_JavaLangString.lastIndexOf("voice_hall_avatar_");
                localObject2 = localGAudioFriends2.jdField_c_of_type_JavaLangString.substring(j + i);
              }
            }
          }
          localObject3 = str2;
          if (localGAudioFriends1 != null)
          {
            localObject3 = str2;
            if (!TextUtils.isEmpty(localGAudioFriends1.jdField_c_of_type_JavaLangString))
            {
              localObject3 = str2;
              if (!TextUtils.equals(localGAudioFriends1.jdField_c_of_type_JavaLangString, "null"))
              {
                j = localGAudioFriends1.jdField_c_of_type_JavaLangString.lastIndexOf("voice_hall_avatar_");
                localObject3 = localGAudioFriends1.jdField_c_of_type_JavaLangString.substring(j + i);
              }
            }
          }
          str2 = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_JavaLangString;
          if (localGAudioFriends1 == null) {}
        }
        for (localObject2 = (String)localObject2 + "|" + str2 + "|" + (String)localObject3 + "|" + localGAudioFriends1.jdField_b_of_type_JavaLangString + "|0";; localObject2 = "")
        {
          paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050&uidList=%s&anonyInfo=%s", new Object[] { NearbyURLSafeUtil.a(this.jdField_d_of_type_JavaLangString), ((String)localObject1).toLowerCase(), Integer.valueOf(4), "ran.card.s", str1, paramView, localObject2 });
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "url = " + paramView);
          }
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          startActivity((Intent)localObject1);
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            return;
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "uin is empty!");
            }
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          a(false);
          this.jdField_d_of_type_JavaLangString = null;
          return;
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            AvImpeachUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_d_of_type_JavaLangString);
          }
          ReportController.b(null, "CliOper", "", "", "0X8005725", "0X8005725", 0, 0, "", "", "", "");
          return;
        }
      }
    }
  }
  
  long a(String paramString)
  {
    VideoController.GAudioFriends localGAudioFriends = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
    long l = 0L;
    if (localGAudioFriends != null) {
      l = localGAudioFriends.jdField_b_of_type_Long;
    }
    l = (SystemClock.elapsedRealtime() - l) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getChatingTime with uin :" + paramString + " second: " + l);
    }
    return l;
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    String str = null;
    if (a(paramString)) {
      if (paramBoolean)
      {
        str = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_JavaLangString;
        paramString = str;
        if (str != null) {
          paramString = str + getResources().getString(2131363810);
        }
      }
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (TextUtils.isEmpty(paramString))) {
        break label145;
      }
      return paramString;
      str = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_JavaLangString;
      break;
      VideoController.GAudioFriends localGAudioFriends = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
      paramString = str;
      if (localGAudioFriends != null) {
        if (paramBoolean) {
          paramString = localGAudioFriends.jdField_b_of_type_JavaLangString;
        } else {
          paramString = localGAudioFriends.jdField_a_of_type_JavaLangString;
        }
      }
    }
    label145:
    return "";
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processIntentData");
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Intent localIntent = super.getIntent();
    this.jdField_a_of_type_ComTencentAvVideoController.d(0);
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController.b())
    {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).e;
      this.jdField_b_of_type_JavaLangString = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString);
      }
      return;
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("session_name");
      this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.h = localIntent.getStringExtra("online_num");
      this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  void a(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams(localLayoutParams);
  }
  
  public void a(long paramLong)
  {
    String str = String.valueOf(paramLong);
    if ((!QLog.isColorLevel()) || ((str.equals(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.isShown()))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.b(str);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
          ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i)).h = paramInt;
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramInt);
    }
  }
  
  public void a(MultiMembersUI.MVMembersInfo paramMVMembersInfo, int paramInt)
  {
    String str = String.valueOf(paramMVMembersInfo.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setShadeStatus uin :" + str + ",pos" + paramInt);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground() == null)
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      paramInt = ((BitmapFactory.Options)localObject1).outWidth / UITools.a(getApplicationContext());
      i = ((BitmapFactory.Options)localObject1).outHeight / UITools.b(getApplicationContext());
      if (paramInt >= i) {
        break label302;
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = paramInt;
    }
    for (;;)
    {
      if (((BitmapFactory.Options)localObject1).inSampleSize <= 0) {
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      }
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      try
      {
        localObject1 = BitmapFactory.decodeResource(getResources(), 2130839236, (BitmapFactory.Options)localObject1);
        if (localObject1 != null)
        {
          localObject1 = BitmapTools.a((Bitmap)localObject1, 20);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject1);
        }
        paramInt = this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(str);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject1 = (RelativeLayout)findViewById(2131299394);
        ((ImageView)findViewById(2131299397)).setImageBitmap(paramMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        ((RelativeLayout)findViewById(2131299396)).setContentDescription(paramMVMembersInfo.jdField_b_of_type_JavaLangString + getResources().getString(2131363796));
        localObject1 = (TextView)findViewById(2131299399);
        ((TextView)localObject1).setText(paramMVMembersInfo.jdField_a_of_type_JavaLangString);
        ((TextView)localObject1).setContentDescription(paramMVMembersInfo.jdField_a_of_type_JavaLangString);
        ((TextView)localObject1).setTextSize(20.0F);
        a(str, paramInt, true);
        return;
        label302:
        ((BitmapFactory.Options)localObject1).inSampleSize = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject3 = null;
          Object localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "bg = null !");
            localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onAddFriendEvent uin :" + paramString);
    }
    a(Long.valueOf(paramString).longValue(), this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString));
    if (paramString.equals(this.jdField_d_of_type_JavaLangString)) {
      a(paramString, this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString), false);
    }
  }
  
  void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setShadeBtnStatus uin : " + paramString + ", status : " + paramInt);
    }
    Button localButton = (Button)findViewById(2131299405);
    localButton.setEnabled(true);
    ((Button)findViewById(2131299401)).setEnabled(true);
    ((Button)findViewById(2131299402)).setEnabled(true);
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131299403);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131299400);
    ImageView localImageView = (ImageView)findViewById(2131299398);
    TextView localTextView = (TextView)findViewById(2131299406);
    switch (paramInt)
    {
    case 3: 
    default: 
      paramString = null;
    }
    while (paramString != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(paramString);
      return;
      if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X80053C6", "0X80053C6", 0, 0, "", "", "", "");
      }
      paramString = getResources().getDrawable(2130838971);
      localLinearLayout1.setVisibility(8);
      localLinearLayout2.setVisibility(0);
      localTextView.setVisibility(0);
      localTextView.setText(getResources().getString(2131363802));
      localTextView.setContentDescription(getResources().getString(2131363802));
      continue;
      paramString = getResources().getDrawable(2130838973);
      localLinearLayout1.setVisibility(0);
      localButton.setEnabled(false);
      localLinearLayout2.setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(getResources().getString(2131363801));
      localTextView.setContentDescription(getResources().getString(2131363801));
      continue;
      paramString = getResources().getDrawable(2130838972);
      localLinearLayout1.setVisibility(0);
      localButton.setEnabled(false);
      localLinearLayout2.setVisibility(8);
      localTextView.setVisibility(0);
      localTextView.setText(getResources().getString(2131363804));
      localTextView.setContentDescription(getResources().getString(2131363804));
      continue;
      localTextView.setVisibility(8);
      localLinearLayout1.setVisibility(0);
      localLinearLayout2.setVisibility(8);
      paramString = null;
    }
    localImageView.setVisibility(8);
  }
  
  /* Error */
  protected boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 763
    //   4: invokespecial 766	mqq/app/BaseActivity:setContentView	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: ldc_w 767
    //   12: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   15: checkcast 208	com/tencent/av/ui/MultiMembersAudioUI
    //   18: putfield 58	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI	Lcom/tencent/av/ui/MultiMembersAudioUI;
    //   21: aload_0
    //   22: getfield 58	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI	Lcom/tencent/av/ui/MultiMembersAudioUI;
    //   25: aload_0
    //   26: getfield 136	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener	Lcom/tencent/av/utils/MultiVideoMembersClickListener;
    //   29: invokevirtual 771	com/tencent/av/ui/MultiMembersAudioUI:setOnItemClickListener	(Lcom/tencent/av/utils/MultiVideoMembersClickListener;)V
    //   32: aload_0
    //   33: invokevirtual 772	com/tencent/av/random/ui/RandomMultiActivity:c	()V
    //   36: aload_0
    //   37: aload_0
    //   38: ldc_w 773
    //   41: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   44: checkcast 409	android/widget/RelativeLayout
    //   47: putfield 81	com/tencent/av/random/ui/RandomMultiActivity:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   50: aload_0
    //   51: aload_0
    //   52: ldc_w 774
    //   55: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   58: checkcast 776	com/tencent/widget/XListView
    //   61: putfield 83	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   64: aload_0
    //   65: new 430	gmr
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 777	gmr:<init>	(Lcom/tencent/av/random/ui/RandomMultiActivity;)V
    //   73: putfield 85	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_Gmr	Lgmr;
    //   76: aload_0
    //   77: getfield 83	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   80: aload_0
    //   81: getfield 85	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_Gmr	Lgmr;
    //   84: invokevirtual 781	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   87: aload_0
    //   88: getfield 83	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   91: new 783	gme
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 784	gme:<init>	(Lcom/tencent/av/random/ui/RandomMultiActivity;)V
    //   99: invokevirtual 787	com/tencent/widget/XListView:setOnItemClickListener	(Lcom/tencent/widget/AdapterView$OnItemClickListener;)V
    //   102: aload_0
    //   103: ldc_w 788
    //   106: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   109: new 790	gmf
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 791	gmf:<init>	(Lcom/tencent/av/random/ui/RandomMultiActivity;)V
    //   117: invokevirtual 795	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   120: aload_0
    //   121: aload_0
    //   122: ldc_w 796
    //   125: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   128: checkcast 409	android/widget/RelativeLayout
    //   131: putfield 79	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   134: aload_0
    //   135: aload_0
    //   136: ldc_w 797
    //   139: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   142: checkcast 392	android/widget/Button
    //   145: putfield 65	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   148: aload_0
    //   149: aload_0
    //   150: ldc_w 798
    //   153: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   156: checkcast 392	android/widget/Button
    //   159: putfield 67	com/tencent/av/random/ui/RandomMultiActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   162: aload_0
    //   163: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   166: ldc_w 799
    //   169: invokevirtual 756	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   172: astore_1
    //   173: aload_0
    //   174: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   177: ldc_w 799
    //   180: ldc_w 800
    //   183: invokestatic 805	com/tencent/av/utils/TintStateDrawable:a	(Landroid/content/res/Resources;II)Lcom/tencent/av/utils/TintStateDrawable;
    //   186: astore_2
    //   187: aload_2
    //   188: iconst_0
    //   189: iconst_0
    //   190: aload_1
    //   191: invokevirtual 810	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   194: aload_1
    //   195: invokevirtual 813	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   198: invokevirtual 817	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   201: aload_0
    //   202: getfield 67	com/tencent/av/random/ui/RandomMultiActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   205: aconst_null
    //   206: aload_2
    //   207: aconst_null
    //   208: aconst_null
    //   209: invokevirtual 821	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   212: aload_0
    //   213: aload_0
    //   214: ldc_w 822
    //   217: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   220: checkcast 219	android/widget/TextView
    //   223: putfield 69	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   226: aload_0
    //   227: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   230: ldc_w 823
    //   233: invokevirtual 756	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   236: astore_1
    //   237: aload_0
    //   238: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   241: ldc_w 823
    //   244: ldc_w 800
    //   247: invokestatic 805	com/tencent/av/utils/TintStateDrawable:a	(Landroid/content/res/Resources;II)Lcom/tencent/av/utils/TintStateDrawable;
    //   250: astore_2
    //   251: aload_2
    //   252: iconst_0
    //   253: iconst_0
    //   254: aload_1
    //   255: invokevirtual 810	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   258: aload_1
    //   259: invokevirtual 813	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   262: invokevirtual 817	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   265: aload_0
    //   266: getfield 69	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   269: aconst_null
    //   270: aload_2
    //   271: aconst_null
    //   272: aconst_null
    //   273: invokevirtual 824	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   276: aload_0
    //   277: aload_0
    //   278: ldc_w 825
    //   281: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   284: checkcast 219	android/widget/TextView
    //   287: putfield 71	com/tencent/av/random/ui/RandomMultiActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   290: aload_0
    //   291: aload_0
    //   292: ldc_w 826
    //   295: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   298: checkcast 219	android/widget/TextView
    //   301: putfield 73	com/tencent/av/random/ui/RandomMultiActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   304: aload_0
    //   305: aload_0
    //   306: ldc_w 827
    //   309: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   312: checkcast 219	android/widget/TextView
    //   315: putfield 75	com/tencent/av/random/ui/RandomMultiActivity:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   318: aload_0
    //   319: aload_0
    //   320: ldc_w 828
    //   323: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   326: checkcast 830	com/tencent/av/utils/SparkDot
    //   329: putfield 97	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUtilsSparkDot	Lcom/tencent/av/utils/SparkDot;
    //   332: aload_0
    //   333: getfield 97	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUtilsSparkDot	Lcom/tencent/av/utils/SparkDot;
    //   336: iconst_0
    //   337: putfield 831	com/tencent/av/utils/SparkDot:jdField_a_of_type_Boolean	Z
    //   340: aload_0
    //   341: getfield 97	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUtilsSparkDot	Lcom/tencent/av/utils/SparkDot;
    //   344: bipush 6
    //   346: invokevirtual 834	com/tencent/av/utils/SparkDot:setDotCount	(I)V
    //   349: aload_0
    //   350: aload_0
    //   351: ldc_w 835
    //   354: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   357: checkcast 392	android/widget/Button
    //   360: putfield 837	com/tencent/av/random/ui/RandomMultiActivity:jdField_c_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   363: aload_0
    //   364: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   367: ldc_w 838
    //   370: invokevirtual 756	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   373: astore_1
    //   374: aload_0
    //   375: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   378: ldc_w 838
    //   381: ldc_w 800
    //   384: invokestatic 805	com/tencent/av/utils/TintStateDrawable:a	(Landroid/content/res/Resources;II)Lcom/tencent/av/utils/TintStateDrawable;
    //   387: astore_2
    //   388: aload_2
    //   389: iconst_0
    //   390: iconst_0
    //   391: aload_1
    //   392: invokevirtual 810	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   395: aload_1
    //   396: invokevirtual 813	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   399: invokevirtual 817	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   402: aload_0
    //   403: getfield 837	com/tencent/av/random/ui/RandomMultiActivity:jdField_c_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   406: aconst_null
    //   407: aload_2
    //   408: aconst_null
    //   409: aconst_null
    //   410: invokevirtual 821	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   413: aload_0
    //   414: aload_0
    //   415: ldc_w 839
    //   418: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   421: checkcast 392	android/widget/Button
    //   424: putfield 77	com/tencent/av/random/ui/RandomMultiActivity:jdField_d_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   427: aload_0
    //   428: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   431: ldc_w 840
    //   434: invokevirtual 756	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   437: astore_1
    //   438: aload_0
    //   439: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   442: ldc_w 840
    //   445: ldc_w 800
    //   448: invokestatic 805	com/tencent/av/utils/TintStateDrawable:a	(Landroid/content/res/Resources;II)Lcom/tencent/av/utils/TintStateDrawable;
    //   451: astore_2
    //   452: aload_2
    //   453: iconst_0
    //   454: iconst_0
    //   455: aload_1
    //   456: invokevirtual 810	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   459: aload_1
    //   460: invokevirtual 813	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   463: invokevirtual 817	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   466: aload_0
    //   467: getfield 77	com/tencent/av/random/ui/RandomMultiActivity:jdField_d_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   470: aconst_null
    //   471: aload_2
    //   472: aconst_null
    //   473: aconst_null
    //   474: invokevirtual 821	android/widget/Button:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   477: aload_0
    //   478: new 842	gmh
    //   481: dup
    //   482: aload_0
    //   483: invokespecial 843	gmh:<init>	(Lcom/tencent/av/random/ui/RandomMultiActivity;)V
    //   486: putfield 99	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   489: aload_0
    //   490: getfield 95	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUtilsTipsManager	Lcom/tencent/av/utils/TipsManager;
    //   493: ifnonnull +30 -> 523
    //   496: aload_0
    //   497: ldc_w 844
    //   500: invokespecial 845	mqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   503: checkcast 743	android/widget/LinearLayout
    //   506: astore_1
    //   507: aload_0
    //   508: new 847	com/tencent/av/utils/TipsManager
    //   511: dup
    //   512: aload_0
    //   513: getfield 52	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   516: aload_1
    //   517: invokespecial 850	com/tencent/av/utils/TipsManager:<init>	(Lcom/tencent/av/app/VideoAppInterface;Landroid/widget/LinearLayout;)V
    //   520: putfield 95	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_ComTencentAvUtilsTipsManager	Lcom/tencent/av/utils/TipsManager;
    //   523: ldc_w 852
    //   526: invokestatic 855	com/tencent/av/utils/ImageResUtil:a	(Ljava/lang/String;)Z
    //   529: ifeq +205 -> 734
    //   532: aload_0
    //   533: ldc_w 856
    //   536: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   539: new 858	android/graphics/drawable/BitmapDrawable
    //   542: dup
    //   543: aload_0
    //   544: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   547: new 341	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   554: invokestatic 860	com/tencent/av/utils/ImageResUtil:b	()Ljava/lang/String;
    //   557: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 852
    //   563: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokespecial 863	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/lang/String;)V
    //   572: invokevirtual 864	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   575: aload_0
    //   576: invokevirtual 681	com/tencent/av/random/ui/RandomMultiActivity:getApplicationContext	()Landroid/content/Context;
    //   579: invokestatic 686	com/tencent/av/utils/UITools:a	(Landroid/content/Context;)I
    //   582: istore 4
    //   584: aload_0
    //   585: ldc_w 844
    //   588: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   591: checkcast 743	android/widget/LinearLayout
    //   594: astore_1
    //   595: aload_0
    //   596: getfield 71	com/tencent/av/random/ui/RandomMultiActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   599: invokevirtual 865	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   602: checkcast 638	android/widget/RelativeLayout$LayoutParams
    //   605: astore_2
    //   606: aload_1
    //   607: invokevirtual 866	android/widget/LinearLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   610: checkcast 638	android/widget/RelativeLayout$LayoutParams
    //   613: astore_3
    //   614: iload 4
    //   616: sipush 480
    //   619: if_icmpgt +77 -> 696
    //   622: aload_2
    //   623: aload_0
    //   624: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   627: ldc_w 867
    //   630: invokevirtual 870	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   633: putfield 641	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   636: aload_0
    //   637: getfield 71	com/tencent/av/random/ui/RandomMultiActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   640: aload_2
    //   641: invokevirtual 871	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   644: aload_3
    //   645: aload_0
    //   646: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   649: ldc_w 872
    //   652: invokevirtual 870	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   655: putfield 641	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   658: aload_1
    //   659: aload_3
    //   660: invokevirtual 873	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   663: aload_0
    //   664: getfield 73	com/tencent/av/random/ui/RandomMultiActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   667: invokevirtual 865	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   670: checkcast 638	android/widget/RelativeLayout$LayoutParams
    //   673: astore_1
    //   674: aload_1
    //   675: aload_0
    //   676: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   679: ldc_w 874
    //   682: invokevirtual 870	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   685: putfield 641	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   688: aload_0
    //   689: getfield 73	com/tencent/av/random/ui/RandomMultiActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   692: aload_1
    //   693: invokevirtual 871	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   696: iconst_1
    //   697: ireturn
    //   698: astore_1
    //   699: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq +30 -> 732
    //   705: getstatic 46	com/tencent/av/random/ui/RandomMultiActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   708: iconst_2
    //   709: new 341	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   716: ldc_w 876
    //   719: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload_1
    //   723: invokevirtual 879	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: iconst_0
    //   733: ireturn
    //   734: aload_0
    //   735: ldc_w 856
    //   738: invokevirtual 441	com/tencent/av/random/ui/RandomMultiActivity:findViewById	(I)Landroid/view/View;
    //   741: aload_0
    //   742: invokevirtual 252	com/tencent/av/random/ui/RandomMultiActivity:getResources	()Landroid/content/res/Resources;
    //   745: ldc_w 695
    //   748: invokevirtual 756	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   751: invokevirtual 864	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   754: goto -179 -> 575
    //   757: astore_1
    //   758: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   761: ifeq -186 -> 575
    //   764: ldc_w 881
    //   767: iconst_2
    //   768: new 341	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   775: ldc_w 883
    //   778: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: aload_1
    //   782: invokevirtual 879	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 886	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: goto -216 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	RandomMultiActivity
    //   172	521	1	localObject1	Object
    //   698	25	1	localOutOfMemoryError1	OutOfMemoryError
    //   757	25	1	localOutOfMemoryError2	OutOfMemoryError
    //   186	455	2	localObject2	Object
    //   613	47	3	localLayoutParams	RelativeLayout.LayoutParams
    //   582	38	4	i	int
    // Exception table:
    //   from	to	target	type
    //   0	7	698	java/lang/OutOfMemoryError
    //   523	575	757	java/lang/OutOfMemoryError
    //   734	754	757	java/lang/OutOfMemoryError
  }
  
  void b()
  {
    if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentAvVideoController.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "refreshGAList --> VideoController is null");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {}
    b();
    int i;
    int j;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) || (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null))
    {
      i = UITools.a(getApplicationContext());
      if (i >= 1080)
      {
        j = getResources().getDimensionPixelSize(2131494138);
        i = getResources().getDimensionPixelSize(2131494139);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 4)
      {
        if (!this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a())
        {
          this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setTwoLineState(true);
          a(i);
        }
        label99:
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      TextView localTextView;
      for (;;)
      {
        if (this.jdField_a_of_type_Gmr != null)
        {
          this.jdField_a_of_type_Gmr.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.b());
          this.jdField_a_of_type_Gmr.notifyDataSetChanged();
          localTextView = (TextView)findViewById(2131299417);
          if (!this.jdField_a_of_type_Gmr.isEmpty()) {
            break label310;
          }
          localTextView.setVisibility(0);
        }
        return;
        if (i >= 720)
        {
          j = getResources().getDimensionPixelSize(2131494141);
          i = getResources().getDimensionPixelSize(2131494142);
          break;
        }
        if (i >= 480)
        {
          j = getResources().getDimensionPixelSize(2131494144);
          i = getResources().getDimensionPixelSize(2131494145);
          break;
        }
        if (i < 320) {
          break label317;
        }
        j = getResources().getDimensionPixelSize(2131494147);
        i = getResources().getDimensionPixelSize(2131494148);
        break;
        if (!this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a()) {
          break label99;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setTwoLineState(false);
        a(j);
        break label99;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "notifyDataChange --> MemberUI is null");
        }
      }
      label310:
      localTextView.setVisibility(8);
      return;
      label317:
      i = 0;
      j = 0;
    }
  }
  
  public void d()
  {
    Object localObject = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString);
    if (localObject == null) {
      return;
    }
    int i = ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMatchingStatus : " + i);
    }
    localObject = (SparkDot)findViewById(2131299114);
    switch (i)
    {
    case 3: 
    default: 
      return;
    case 0: 
    case 5: 
      ((SparkDot)localObject).b();
      ((SparkDot)localObject).setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, false);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(32, false);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_b_of_type_JavaLangRunnable);
      return;
    case 1: 
    case 2: 
      if ((localObject != null) && (!((SparkDot)localObject).isShown())) {
        ((SparkDot)localObject).setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, true);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(32, true);
    }
    ((SparkDot)localObject).setVisibility(0);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startChange");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a();
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(31, true);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentAvRandomRandomController.d();
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      this.jdField_a_of_type_Boolean = true;
      finish();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp is null!");
      }
      this.jdField_a_of_type_Boolean = true;
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mVideoController is null!");
      }
      this.jdField_a_of_type_Boolean = true;
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvRandomRandomController = RandomController.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvRandomRandomController.a(2, getIntent());
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mSessionInfo is null after setType");
      }
      this.jdField_a_of_type_Boolean = true;
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvRandomRandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener);
    if (!a())
    {
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = new SensorHelper(this, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper = new AvAddFriendHelper(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    paramBundle = super.getIntent();
    if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.b())
    {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.a(paramBundle);
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
      boolean bool = getApplicationContext().getSharedPreferences("qav_SP", 0).getBoolean("qav_random_speakeron", false);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "qav_random_speakeron: " + bool);
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        ReportController.b(null, "CliOper", "", "", "0X80053BE", "0X80053BE", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
        {
          QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(SessionMgr.a(this.jdField_a_of_type_ComTencentAvVideoController.E, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long), new int[0]));
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.E, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
          SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).c();
        }
        SessionMgr.a().b(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvVideoController.c(false);
        a();
        this.jdField_a_of_type_ComTencentAvRandomRandomController.b();
        d();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        paramBundle = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        return;
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "IsAccompanyReturn");
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    a();
    this.jdField_a_of_type_ComTencentAvRandomRandomController.e();
    paramBundle = SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString);
    if (paramBundle.c)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramBundle.e, 7, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setRandomMultiIsMask(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Boolean);
      a(false);
      c();
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().size() > 1) {
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.D != 0) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(37, this.jdField_a_of_type_ComTencentAvVideoController.D);
      this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setVisibility(0);
      break;
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_Long, true);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    }
    if ((this.jdField_b_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((this.jdField_c_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if ((this.jdField_a_of_type_ComTencentAvRandomRandomController != null) && (this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener != null)) {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.b(this.jdField_a_of_type_ComTencentAvRandomRandomController$RandomListener);
    }
    if (this.jdField_a_of_type_ComTencentAvRandomRandomController != null) {
      this.jdField_a_of_type_ComTencentAvRandomRandomController.h();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      if (this.jdField_a_of_type_ComTencentAvRandomRandomController != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a();
      this.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
      }
    } while ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (!this.jdField_b_of_type_AndroidWidgetRelativeLayout.isShown()));
    paramKeyEvent = AnimationUtils.loadAnimation(this, 2130968682);
    paramKeyEvent.setFillBefore(true);
    paramKeyEvent.setAnimationListener(new gmq(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(paramKeyEvent);
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(false);
  }
  
  protected void onResume()
  {
    jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    super.onResume();
    this.jdField_a_of_type_ComTencentAvRandomRandomController.e();
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_JavaLangString) == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_JavaLangString = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(true);
  }
  
  protected void onStart()
  {
    super.onStart();
    QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localQAVNotification != null) {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.E();
    this.jdField_a_of_type_ComTencentAvRandomRandomController.e();
  }
  
  protected void onStop()
  {
    super.onStop();
    jdField_b_of_type_Boolean = false;
    QAVNotification localQAVNotification;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (!SessionMgr.a().a()))
    {
      localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString) == null) {
        return;
      }
      if (SessionMgr.a().a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b <= 4) {
        break label129;
      }
    }
    label129:
    for (int i = 52;; i = 51)
    {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvRandomRandomController.jdField_d_of_type_JavaLangString, "", null, null, i, 1011, 3);
      this.jdField_a_of_type_ComTencentAvVideoController.D();
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(this.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\random\ui\RandomMultiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */