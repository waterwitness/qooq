package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.widget.HotChatAnnounceDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import vnr;
import vns;

public class TroopFeedsCenterLogic
  implements Observer
{
  protected static final String a;
  protected static final int b = 250;
  public static final String c = "http://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031";
  protected int a;
  public View a;
  protected Animation.AnimationListener a;
  public TranslateAnimation a;
  protected ImageView a;
  public RelativeLayout a;
  public SessionInfo a;
  public QQAppInterface a;
  protected TroopInfoManager a;
  public TroopAioTips a;
  public TroopFeedsDataManager a;
  HotChatAnnounceDialog a;
  public WeakReference a;
  protected boolean a;
  public TranslateAnimation b;
  public ImageView b;
  protected RelativeLayout b;
  protected String b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  protected boolean g;
  protected boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopFeedsCenterLogic.class.getSimpleName();
  }
  
  public TroopFeedsCenterLogic(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, TroopAioTips paramTroopAioTips, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new vnr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
    this.j = paramBoolean;
    this.k = paramQQAppInterface.a(true).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = paramFragmentActivity.getResources().getDimensionPixelSize(2131493363);
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)paramQQAppInterface.getManager(36));
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.associatePubAccount <= 0L) {
            break label267;
          }
          paramBoolean = true;
          this.l = paramBoolean;
        }
      }
      return;
    }
    catch (NumberFormatException paramFragmentActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "NumberFormatException, mSessionInfo.curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", "TroopFeedsCenterLogic init", "", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        continue;
        label267:
        paramBoolean = false;
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break;
          }
        } while ((!this.l) && (a()));
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((BaseActivity)localObject).findViewById(2131297084));
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "mRightTitleLayout == null," + localObject.getClass().getName());
      return;
      int m = AIOUtils.a(10.0F, ((FragmentActivity)localObject).getResources());
      int n = AIOUtils.a(8.0F, ((FragmentActivity)localObject).getResources());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(((BaseActivity)localObject).getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843321);
      localObject = new RelativeLayout.LayoutParams(m, m);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131297404);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131297404);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, n, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    } while ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a()
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFragmentActivity == null) {
      return;
    }
    if (a())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_fold", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131364330));
      b();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131364332));
    d(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog = new HotChatAnnounceDialog(paramQQAppInterface, paramContext, paramString1, paramString2);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog.show();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean2;
    d(paramBoolean1);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (this.l) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
      }
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        localObject = AnimationUtils.loadInterpolator(((BaseActivity)localObject).getActivity(), 17432582);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int * -1);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      }
    } while (this.i);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void c()
  {
    if ((!this.d) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
    {
      this.c = false;
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).a(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    b();
  }
  
  public void d()
  {
    this.f = true;
    d(false);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.l) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject1 == null);
    this.g = paramBoolean;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Boolean))
    {
      if (this.g) {
        this.d = false;
      }
      this.c = true;
      e(false);
      TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
    }
    for (this.jdField_b_of_type_JavaLangString = "1";; this.jdField_b_of_type_JavaLangString = "0")
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = true;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        localObject2 = AnimationUtils.loadInterpolator(((BaseActivity)localObject1).getActivity(), 17432582);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Int * -1, 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject2);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillEnabled(true);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break label479;
      }
      Object localObject2 = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
      this.jdField_a_of_type_AndroidViewView = new TroopAioFeedsCenterView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((TroopGagMgr)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setId(2131296416);
      localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      int m = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1;
      while (m >= 0)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(m);
        if ((localObject2 instanceof TroopAioFeedsCenterView))
        {
          ((TroopAioFeedsCenterView)localObject2).c();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject2);
        }
        m -= 1;
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject1);
    this.c = true;
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    if (this.c) {
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
    }
    while (!this.c) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() > 0))
      {
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          return;
          label479:
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(4);
            this.jdField_a_of_type_AndroidViewView.requestLayout();
            this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
            if (this.c) {
              ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
            }
          }
        }
        else
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", this.jdField_b_of_type_JavaLangString, "");
        }
      }
      else
      {
        if (!paramBoolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", this.jdField_b_of_type_JavaLangString, "");
        return;
      }
    }
    this.h = true;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString + ".troop.notification_center", 2, "destory");
    }
    g(false);
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
    {
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).c();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36));
      }
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHotChatAnnounceDialog.dismiss();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.l) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localFragmentActivity == null);
    if (paramBoolean)
    {
      this.c = true;
      if (!a())
      {
        this.jdField_a_of_type_Boolean = true;
        g(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131364331));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    g(false);
    this.jdField_b_of_type_Boolean = false;
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131364332));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131364330));
  }
  
  public void f(boolean paramBoolean)
  {
    g(paramBoolean);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() != 104) {
        break label42;
      }
      this.c = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new vns(this));
    }
    label42:
    label157:
    label196:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 103)) {
            break;
          }
          if (this.h)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() <= 0)) {
              break label196;
            }
            if (this.g) {
              break label157;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          }
          while (paramObservable.intValue() == 103)
          {
            this.c = true;
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            continue;
            if (!this.g) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
            } else {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
            }
          }
        }
      } while (((paramObservable.intValue() != 1008) && (paramObservable.intValue() != 1009)) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() <= 0));
      paramObject = (TroopFeedItem)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(0);
      if ((((TroopFeedItem)paramObject).type != 5) && (((TroopFeedItem)paramObject).type != 19))
      {
        d(false);
        return;
      }
    } while (paramObservable.intValue() != 1009);
    e(false);
    TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\logic\TroopFeedsCenterLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */