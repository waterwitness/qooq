package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqwifi.QQWiFiHelper;
import mgw;
import mgx;
import mgz;
import mha;
import mhc;
import mhd;
import mhe;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "QQSetting2Activity";
  private static final int jdField_b_of_type_Int = 0;
  private static final boolean jdField_b_of_type_Boolean = AppSetting.j;
  private static final int jdField_c_of_type_Int = 2001;
  public int a;
  private long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new mhe(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new mhc(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mhd(this);
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new mgz(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new mgw(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean a;
  private long jdField_b_of_type_Long;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private boolean jdField_c_of_type_Boolean;
  ImageView jdField_d_of_type_AndroidWidgetImageView = null;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  public TextView e = null;
  TextView f = null;
  private TextView g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    int j = 0;
    if ((this.f == null) || (this.jdField_d_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    if (!paramBoolean)
    {
      this.f.setText("");
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    if (paramBundle == null)
    {
      this.f.setText(2131370980);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.f.setVisibility(0);
    String str = paramBundle.getString("phone");
    if (!TextUtils.isEmpty(str))
    {
      this.f.setText(str);
      if (paramBundle.getInt("need_unify", 0) != 1) {
        break label175;
      }
      label142:
      paramBundle = this.jdField_d_of_type_AndroidWidgetImageView;
      if (i == 0) {
        break label181;
      }
    }
    label175:
    label181:
    for (i = j;; i = 8)
    {
      paramBundle.setVisibility(i);
      return;
      this.f.setText(2131370980);
      break;
      i = 0;
      break label142;
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100194");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void c(Card paramCard)
  {
    Object localObject;
    if ((paramCard != null) && (paramCard.isShowXMan()))
    {
      if (paramCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.a = paramCard.lQQMasterLogindays;
        if (paramCard.allowClick) {
          break label148;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
        b(paramCard);
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("updataQQLoginDays card.lQQMasterLogindays=");
          ((StringBuffer)localObject).append(paramCard.lQQMasterLogindays);
          ((StringBuffer)localObject).append(";card.allowClick=");
          ((StringBuffer)localObject).append(paramCard.allowClick);
          QLog.d("QQSetting2Activity", 2, ((StringBuffer)localObject).toString());
        }
        return;
        FriendProfileCardActivity.a = 30L;
        break;
        label148:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        a(paramCard);
      }
    }
    StringBuffer localStringBuffer;
    if (QLog.isColorLevel())
    {
      localStringBuffer = new StringBuffer(200);
      localStringBuffer.append("updataQQLoginDays card=");
      if (paramCard != null) {
        break label320;
      }
      localObject = "null";
      label229:
      localStringBuffer.append((String)localObject);
      localStringBuffer.append(";card.isShowXMan()=");
      if (paramCard != null) {
        break label327;
      }
    }
    label320:
    label327:
    for (paramCard = "null";; paramCard = Boolean.toString(paramCard.isShowXMan()))
    {
      localStringBuffer.append(paramCard);
      QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramCard = findViewById(2131302443);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) || (paramCard == null) || (paramCard.getVisibility() == 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      return;
      localObject = "obj";
      break label229;
    }
  }
  
  private void d()
  {
    View localView = findViewById(2131302453);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843324);
    if (a())
    {
      a(localView, 0, localDrawable);
      return;
    }
    a(localView, 8, localDrawable);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("timelog", 2, "QQSettingSettingActivity qqwifi click:" + System.currentTimeMillis());
    }
    if (!ProfileActivity.a(this.jdField_b_of_type_Long, System.currentTimeMillis())) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.app != null) && (!this.app.isLogin()))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
      localIntent.putExtra("intervalTime", QQWiFiHelper.a);
      sendBroadcast(localIntent);
      return;
    }
    QQWiFiHelper.a(this, this.app);
    ((RedTouchManager)this.app.getManager(35)).b("100190.100191");
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_qqwifi", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    if (!NetworkUtil.e(this))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      QQToast.a(this, getString(2131370739), 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.a(34);
    if (localSecSvcHandler != null)
    {
      localSecSvcHandler.b();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {}
    do
    {
      do
      {
        return;
        TextView localTextView = (TextView)localView.findViewById(2131302365);
        localTextView.setText(paramInt2);
        if (jdField_b_of_type_Boolean) {
          localTextView.setContentDescription(getString(paramInt2));
        }
        if (paramInt3 > 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
        }
        localView.setBackgroundResource(paramInt4);
        localView.setOnClickListener(this);
        if (paramInt1 == 2131302448)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
          this.jdField_d_of_type_AndroidWidgetTextView = localTextView;
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298415));
          this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131297388));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298414));
          return;
        }
        if (paramInt1 == 2131302449)
        {
          localView.findViewById(2131297388).setVisibility(8);
          localView.findViewById(2131298414).setVisibility(8);
          this.e = ((TextView)localView.findViewById(2131298415));
          this.e.setText(getString(2131370779));
          this.e.setVisibility(0);
          return;
        }
        if (paramInt1 == 2131302451)
        {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
          c();
          localView.findViewById(2131297388).setVisibility(8);
          localView.findViewById(2131298414).setVisibility(8);
          ((TextView)localView.findViewById(2131298415)).setVisibility(8);
          return;
        }
        if (paramInt1 == 2131302446)
        {
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
          b();
          return;
        }
        if (paramInt1 == 2131302444)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302366));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302359));
          return;
        }
        if (paramInt1 != 2131302443) {
          break;
        }
        this.f = ((TextView)localView.findViewById(2131298415));
        if (this.f != null)
        {
          this.f.setVisibility(0);
          this.f.setText(2131369870);
          if (jdField_b_of_type_Boolean) {
            this.f.setContentDescription(null);
          }
        }
        this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131297388));
        if (this.jdField_b_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298414));
      } while (this.jdField_d_of_type_AndroidWidgetImageView == null);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843321);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while (!jdField_b_of_type_Boolean);
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131302368);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131302367)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131302363);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCard.lLoginDays + "天");
    if (paramCard.lLoginDays >= FriendProfileCardActivity.a)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840978);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-155129);
      if (jdField_b_of_type_Boolean)
      {
        paramCard = String.format(getString(2131362042), new Object[] { Long.valueOf(paramCard.lLoginDays) });
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramCard);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840977);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-5855578);
    } while (!jdField_b_of_type_Boolean);
    paramCard = String.format(getString(2131362043), new Object[] { Long.valueOf(paramCard.lLoginDays) });
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramCard);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        if (localFriendsManager != null) {
          ThreadManager.a(new mgx(this, localFriendsManager, paramString), 8, null, true);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("QQSetting2Activity", 2, "updateQQLevelInfo Exception!");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (PhoneUnityManager)this.app.getManager(101);
    if ((System.currentTimeMillis() - ((PhoneUnityManager)localObject).jdField_b_of_type_Long > 1800000L) || (((PhoneUnityManager)localObject).jdField_a_of_type_Boolean) || (paramBoolean))
    {
      ((PhoneUnityManager)localObject).jdField_b_of_type_Long = System.currentTimeMillis();
      ((PhoneUnityManager)localObject).jdField_a_of_type_Boolean = false;
      localObject = (SecSvcHandler)this.app.a(34);
      if (localObject != null)
      {
        this.jdField_a_of_type_Int += 1;
        ((SecSvcHandler)localObject).a(0, 31, null, null);
      }
      if (this.jdField_b_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.f != null) {
        this.f.setVisibility(8);
      }
      return;
    }
    a(true, ((PhoneUnityManager)localObject).jdField_b_of_type_AndroidOsBundle);
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label56;
        }
      }
    }
    label56:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  void b(Card paramCard)
  {
    if ((paramCard.lLoginDays == 1L) || (paramCard.lLoginDays == 0L))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843495);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131369653), new Object[] { Integer.valueOf((int)FriendProfileCardActivity.a) }));
      if (jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131369653), new Object[] { Integer.valueOf((int)FriendProfileCardActivity.a) }));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramCard.lLoginDays <= 1L) || (paramCard.lLoginDays >= FriendProfileCardActivity.a)) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843495);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131369654), new Object[] { Integer.valueOf((int)paramCard.lLoginDays), Integer.valueOf((int)(FriendProfileCardActivity.a - paramCard.lLoginDays)) }));
        } while (!jdField_b_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131369654), new Object[] { Integer.valueOf((int)paramCard.lLoginDays), Integer.valueOf((int)(FriendProfileCardActivity.a - paramCard.lLoginDays)) }));
        return;
      } while (paramCard.lLoginDays < FriendProfileCardActivity.a);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843494);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131369655), new Object[] { Integer.valueOf((int)paramCard.lLoginDays) }));
    } while (!jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131369655), new Object[] { Integer.valueOf((int)paramCard.lLoginDays) }));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramBoolean)
    {
      EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131370706));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840672);
      return;
    }
    EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131370705));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840671);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      if (paramInt2 != 0)
      {
        paramInt1 = j;
        if (paramInt2 != -1) {}
      }
      else
      {
        paramInt1 = j;
        if (paramIntent != null)
        {
          paramInt1 = j;
          if (paramIntent.getExtras() != null)
          {
            bool = paramIntent.getExtras().getBoolean("auth_dev_open", false);
            b(bool);
            paramInt1 = i;
            if (this.jdField_c_of_type_Boolean != bool) {
              paramInt1 = 1;
            }
            this.jdField_c_of_type_Boolean = bool;
          }
        }
      }
      if (paramInt1 != 0) {
        a(true);
      }
    }
    while (paramInt1 != 2001)
    {
      boolean bool;
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904350);
    setTitle(getString(2131367542));
    if (AppSetting.j)
    {
      paramBundle = getString(2131367542);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302442));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131370956));
    if (jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131370956));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(2131302443, 2131370946, 0, 2130838355);
    a(2131302444, 2131370947, 0, 2130838352);
    a(2131302445, 2131370948, 0, 2130838357);
    a(2131302446, 2131370975, 0, 2130838352);
    a(2131302447, 2131370951, 0, 2130838357);
    a(2131302448, 2131370952, 0, 2130838355);
    a(2131302449, 2131370778, 0, 2130838355);
    a(2131302450, 2131370954, 0, 2130838352);
    a(2131302453, 2131370955, 0, 2130838349);
    paramBundle = FaceDrawable.a(this.app, this.app.a(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302439));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302440));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302441));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.app.a());
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    }
  }
  
  protected void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131428295);
      this.mSystemBarComp.a(i);
    }
    super.doOnResume();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    c();
    b();
    a();
    ((PhoneUnityManager)this.app.getManager(101)).a();
    ThreadManager.a().post(new mha(this));
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.app, this.app.a(), (byte)3);
    if (localFaceDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localFaceDrawable.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    a(true);
    a();
    a(this.app.a());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131302452: 
    default: 
      return;
    case 2131302442: 
      startActivity(new Intent(this, AccountManageActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
      return;
    case 2131302445: 
      startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      return;
    case 2131302446: 
      ((RedTouchManager)this.app.getManager(35)).b("100190.100194");
      paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      getActivity().startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
      return;
    case 2131302447: 
      startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      return;
    case 2131302448: 
      startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      return;
    case 2131302449: 
      startActivity(new Intent(this, SecurityDetectActivity.class));
      return;
    case 2131302450: 
      startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      return;
    case 2131302451: 
      e();
      return;
    case 2131302453: 
      startActivity(new Intent(getActivity(), AboutActivity.class));
      if (a()) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", UpgradeController.a(), "");
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
      return;
    case 2131302444: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("url", "http://ti.qq.com/xman/self.html?_wv=1027&adtag=setting&_bid=297");
      paramView.putExtra("hide_more_button", true);
      startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
    int i = ((PhoneContactManager)this.app.getManager(10)).d();
    if ((i == 1) || (i == 2)) {
      ReportController.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
    }
    paramView = new Intent(this, PhoneUnityBindInfoActivity.class);
    paramView.putExtra("kSrouce", 1);
    startActivityForResult(paramView, 2001);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.app, this.app.a(), (byte)3);
    if (localFaceDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon width =" + localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon height =" + localFaceDrawable.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQSettingSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */