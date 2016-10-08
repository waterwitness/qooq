package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;
import pxp;
import pxq;
import pxr;

public class FrameHelperActivity
  extends FrameFragment
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static final int A = 6;
  public static final int B = 9;
  public static final int C = 10;
  public static final int D = 11;
  public static final int E = 12;
  private static final String jdField_a_of_type_JavaLangString = "Q.recent";
  public static WeakReference a;
  protected static final String o = "conversation_head_edu";
  protected static final int r = 4096;
  protected static final int s = 4097;
  protected static final int t = 4098;
  protected static final int u = 6;
  public static final int v = 1;
  public static final int w = 2;
  public static final int x = 3;
  public static final int y = 4;
  public static final int z = 5;
  public Handler a;
  public ViewGroup a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView a;
  public DrawerFrame a;
  private FrameHelperActivity.DrawerListener jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener;
  private FrameHelperActivity.QQSettingMeListener jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
  public RedTouch a;
  private boolean jdField_a_of_type_Boolean;
  public DrawerFrame.IDrawerCallbacks[] a;
  protected View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_b_of_type_Boolean;
  protected View c;
  private boolean c;
  private boolean d;
  
  public FrameHelperActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = new DrawerFrame.IDrawerCallbacks[] { null, null, null, null };
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static FrameHelperActivity a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = ((FragmentActivity)paramBaseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (paramBaseActivity != null) {
      return (FrameHelperActivity)paramBaseActivity;
    }
    return null;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.jdField_b_of_type_Boolean = paramBoolean;
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameTouchable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get(); localDrawerFrame == null; localDrawerFrame = null) {
      return false;
    }
    if ((localDrawerFrame.b()) || (localDrawerFrame.c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.setDrawerEnabled(paramBoolean);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameEnable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  private int c()
  {
    Frame localFrame = b();
    if ((localFrame instanceof Conversation)) {}
    do
    {
      return 1;
      if ((localFrame instanceof Call)) {
        return 2;
      }
      if ((localFrame instanceof Contacts)) {
        return 3;
      }
    } while (!(localFrame instanceof Leba));
    return 4;
  }
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "frameHelper_initDrawerFrame: mDrawerFrame=  " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame + "mDrawerBg= " + this.jdField_a_of_type_AndroidViewViewGroup + "mIsInflated = " + this.d);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null)
      {
        localObject = (Conversation)a(Conversation.class);
        if (localObject != null) {
          ((Conversation)localObject).m();
        }
      }
      if (!this.d) {
        k();
      }
      Object localObject = (ViewGroup)getActivity().findViewById(2131298442);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(getActivity(), (ViewGroup)localObject, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(), null, this.jdField_a_of_type_AndroidViewViewGroup);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(new pxp(this));
        m();
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener.e(true);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "frameHelper_initDrawerFrame exception, " + localException.toString());
          }
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ImageView localImageView1;
    ImageView localImageView2;
    ImageView localImageView3;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302402);
      localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302403);
      localImageView3 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301086);
      if (!ThemeUtil.isNowThemeIsDefault(getActivity().app, paramBoolean, null)) {}
    }
    else
    {
      try
      {
        localImageView1.setImageResource(2130841266);
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(0);
        localImageView3.setVisibility(8);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localImageView1.setImageResource(0);
          localImageView1.setVisibility(8);
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
    localImageView2.setVisibility(8);
    localImageView1.setImageResource(0);
    localImageView1.setVisibility(8);
    localImageView3.setImageResource(2130840576);
    localImageView3.setVisibility(0);
  }
  
  private void d()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidViewView = getActivity().findViewById(2131298443);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.setMargins(0, ImmersiveUtils.a(getActivity()), 0, 0);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131301497));
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131301498);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    AccessibilityUtil.b(this.jdField_b_of_type_AndroidViewView, Button.class.getName());
    l();
  }
  
  public static void n()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null) {
        localDrawerFrame.f();
      }
      return;
    }
  }
  
  public static void o()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if ((localDrawerFrame != null) && (localDrawerFrame.b())) {
        localDrawerFrame.e();
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = null;
    if ((getActivity() == null) || (getActivity().app == null))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("doDrawerActionReport, getActivity =  ").append(getActivity()).append(" app = ");
        if (getActivity() != null) {
          break label78;
        }
      }
      for (;;)
      {
        QLog.i("Q.recent", 2, localObject);
        return;
        label78:
        localObject = getActivity().app;
      }
    }
    switch (paramInt1)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        ReportController.b(getActivity().app, "CliOper", "", "", (String)localObject, (String)localObject, paramInt2, 0, "", "", "", "");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt1 + ", tag = " + (String)localObject);
      return;
      if (paramBoolean)
      {
        localObject = "0X800402E";
      }
      else
      {
        localObject = "0X800402F";
        continue;
        localObject = "0X8004032";
        continue;
        localObject = "0X8004030";
        continue;
        localObject = "0X8004031";
      }
    }
  }
  
  public void a(FrameHelperActivity.DrawerListener paramDrawerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener = paramDrawerListener;
  }
  
  public void a(FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener = paramQQSettingMeListener;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null;
  }
  
  public void g()
  {
    c(true);
    m();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_b_of_type_Boolean) || (getActivity() == null)) {}
    do
    {
      do
      {
        return false;
        switch (paramMessage.what)
        {
        case 7: 
        case 8: 
        default: 
          return false;
        }
      } while (this.jdField_c_of_type_Boolean);
      d();
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
        c();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a()));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    return false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(getActivity().app);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    return false;
    if (paramMessage.arg1 == 0)
    {
      ThreadManager.b().post(new pxq(this));
      paramMessage = Message.obtain();
      paramMessage.what = 2;
      paramMessage.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 20000L);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "frameHelper_infalter time out, need do in UI thread ");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
    return false;
    l();
    return false;
    m();
    return false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    c();
    return false;
    if (!this.jdField_c_of_type_Boolean) {
      d();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131492908));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    return false;
    if (!this.jdField_c_of_type_Boolean) {
      d();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131492908), 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    return false;
    if (!this.jdField_c_of_type_Boolean) {
      d();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
    return false;
  }
  
  public void k()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "frameHelper_inflateUI, " + this.d + "mDrawerBgView=" + this.jdField_a_of_type_AndroidViewViewGroup);
        }
        if (!this.d)
        {
          localObject1 = getActivity();
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = LayoutInflater.from(getActivity());
        try
        {
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)localObject1).inflate(2130904344, null));
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.jdField_a_of_type_AndroidViewViewGroup);
          }
          this.d = true;
        }
        catch (Exception localException2)
        {
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label292;
          }
        }
        localObject1 = "in main thread ";
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, (String)localObject1 + localException2.toString());
        }
        try
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.d());
          ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
          StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
          String str2 = getActivity().app.a();
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label309;
          }
          localStatisticCollector.a(str2, "actFrameHelperSubInflate", false, l, 0L, (HashMap)localObject1, "");
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, localException1.toString());
        continue;
        String str1 = "not in main thread ";
      }
      finally {}
      label292:
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.d = false;
      continue;
      label309:
      l = 1L;
    }
  }
  
  public void l()
  {
    ThreadManager.a().post(new pxr(this));
  }
  
  void m()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "setThemeDiyBgSetting");
    }
    Object localObject1;
    if ((!this.d) || (this.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("FrameHelperActivity.setThemeDiyBgSetting,mIsInflated=").append(this.d).append("mDrawerBgView=");
        if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
          break label91;
        }
      }
      label91:
      for (bool = true;; bool = false)
      {
        QLog.i("Q.recent", 2, bool);
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        i = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() - 1;
        localObject1 = null;
        if (i < 0) {
          break label466;
        }
        localObject4 = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
        localObject3 = localObject1;
        if (localObject4 != null)
        {
          localObject3 = localObject1;
          if ((((View)localObject4).getTag() instanceof ThemeBackground))
          {
            localObject3 = localObject1;
            if ((localObject4 instanceof ImageView))
            {
              localObject1 = (ImageView)localObject4;
              localObject3 = localObject1;
              if ((((ImageView)localObject1).getTag() instanceof ThemeBackground))
              {
                localObject3 = (ThemeBackground)((ImageView)localObject1).getTag();
                if (ThemeBackground.getThemeBackgroundEnable()) {
                  break label243;
                }
                if (localObject1 == null) {
                  break;
                }
                ((ImageView)localObject1).setTag(null);
                this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject1);
                return;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.i("Q.recent", 1, "FrameHelperActivity.setThemeDiyBgSetting error" + localException.getMessage());
        return;
      }
      i -= 1;
      Object localObject2 = localObject3;
      continue;
      label243:
      Object localObject4 = localObject3;
      if (localObject3 == null) {
        localObject4 = new ThemeBackground();
      }
      if (!ThemeBackground.getThemeBackground(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), "theme_bg_setting_path_png", getActivity().app.a(), (ThemeBackground)localObject4)) {
        break;
      }
      Object localObject3 = new StringBuilder().append("FrameHelperActivity.setThemeDiyBgSetting,path=").append(((ThemeBackground)localObject4).path).append(", mThemeBackgroundSt.img=");
      if (((ThemeBackground)localObject4).img != null) {
        bool = true;
      }
      QLog.i("Q.recent", 1, bool);
      if (("null".equals(((ThemeBackground)localObject4).path)) || (((ThemeBackground)localObject4).img == null))
      {
        if (localObject2 == null) {
          break;
        }
        ((ImageView)localObject2).setTag(null);
        this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject2);
        return;
      }
      if (((ThemeBackground)localObject4).img == null) {
        break;
      }
      localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = new ImageView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject3).setBackgroundColor(getResources().getColor(2131427409));
        ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      }
      ((ThemeBackground)localObject4).img.setAlpha(128);
      ((ImageView)localObject3).setImageDrawable(((ThemeBackground)localObject4).img);
      ((ImageView)localObject3).setTag(localObject4);
      return;
      label466:
      localObject3 = null;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_b_of_type_AndroidViewView) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
        c();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a();
      }
      ReportController.b(getActivity().app, "CliOper", "", "", "Setting_tab", "My_settab", c(), 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a()) && (UpgradeController.a(getActivity().app))) {
        ReportController.b(getActivity().app, "CliOper", "", "", "0X8004DAF", "0X8004DAF", c(), 0, "", "", UpgradeController.a(), "");
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Boolean = false;
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Boolean = true;
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.c != 1) && (!this.e)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.b();
    }
    ((LocalRedTouchManager)getActivity().app.getManager(159)).d(1);
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.c != 1) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()));
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a();
    l();
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.c != 1) {}
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.c != 1) && (!this.e)) {}
  }
  
  public void p()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      Animation localAnimation = this.jdField_c_of_type_AndroidViewView.getAnimation();
      if (localAnimation != null) {
        localAnimation.setAnimationListener(null);
      }
      this.jdField_c_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.invalidate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FrameHelperActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */