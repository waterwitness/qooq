package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;
import com.tencent.widget.SingleLineTextView;
import java.util.Random;
import mqq.os.MqqHandler;

public class NewVoteAnimHelper
  implements Handler.Callback, Animation.AnimationListener
{
  public static final int a = 0;
  static final long jdField_a_of_type_Long = 1000L;
  public static final int[] a;
  public static final int b = 1;
  static final long jdField_b_of_type_Long = 3000L;
  public static final int c = 2;
  static final long c = 1500L;
  public static final int d = 6;
  static final long d = 1000L;
  public static final int e = 7;
  public static final int f = 3;
  public static final int g = 15;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  static final int l = 0;
  static final int m = 1;
  static final int n = 2;
  public static final int o = 20;
  public static final int p = 0;
  public static final int q = 1;
  static final int r = 0;
  static final int s = 1;
  static final int t = 2;
  static final int u = 3;
  private int A;
  private int B;
  private int C = -1;
  private int D = 0;
  private double jdField_a_of_type_Double;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public NewVoteAnimHelper.NewVoteHolder a;
  FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  private Random jdField_a_of_type_JavaUtilRandom;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  public boolean a;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public boolean b;
  public boolean c;
  public boolean d;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 10, 25, 45, 60, 75, 100 };
  }
  
  public NewVoteAnimHelper(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Double = paramContext.getResources().getDisplayMetrics().density;
    this.x = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder = new NewVoteAnimHelper.NewVoteHolder();
  }
  
  public NewVoteAnimHelper(Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAppInterface, paramInt1);
    this.D = paramInt2;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) {
      return;
    }
    if ((this.x == 1) || (this.x == 2)) {}
    for (RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();; localLayoutParams1 = null)
    {
      String str2;
      String str1;
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        str2 = String.valueOf(this.y);
        str1 = str2;
        if (localLayoutParams1 != null)
        {
          localLayoutParams1.topMargin = 0;
          str1 = str2;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
        if (localLayoutParams1 == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(localLayoutParams1);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i1;
      int i2;
      if (paramBoolean2)
      {
        i1 = 2130843322;
        if (this.x == 0) {
          localLayoutParams2.topMargin = ((int)(7.0D * this.jdField_a_of_type_Double));
        }
        for (;;)
        {
          localLayoutParams2.width = ((int)(6.0D * this.jdField_a_of_type_Double + 0.5D));
          localLayoutParams2.height = ((int)(6.0D * this.jdField_a_of_type_Double + 0.5D));
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          str2 = String.valueOf(this.y);
          i2 = i1;
          str1 = str2;
          if (localLayoutParams1 != null)
          {
            localLayoutParams1.topMargin = 0;
            str1 = str2;
            i2 = i1;
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(i2);
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
          break;
          if (this.x == 1)
          {
            localLayoutParams2.topMargin = 0;
            localLayoutParams2.rightMargin = ((int)(3.0D * this.jdField_a_of_type_Double + 0.5D));
          }
          else if (this.x == 2)
          {
            localLayoutParams2.addRule(15, 0);
            localLayoutParams2.leftMargin = 0;
          }
        }
      }
      if (this.x == 0)
      {
        i1 = 2130843329;
        localLayoutParams2.topMargin = 0;
      }
      for (;;)
      {
        localLayoutParams2.width = -2;
        localLayoutParams2.height = -2;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.z);
        str2 = String.valueOf(this.y - this.z);
        i2 = i1;
        str1 = str2;
        if (localLayoutParams1 == null) {
          break;
        }
        localLayoutParams1.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double + 0.5D));
        i2 = i1;
        str1 = str2;
        break;
        if (this.x == 1)
        {
          i1 = 2130843325;
          localLayoutParams2.topMargin = 0;
          localLayoutParams2.rightMargin = 0;
        }
        else if (this.x == 2)
        {
          i1 = 2130843329;
          localLayoutParams2.addRule(15);
          localLayoutParams2.leftMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 4.0F);
        }
        else
        {
          i1 = 2130843325;
        }
      }
    }
  }
  
  public void a()
  {
    DatingUtil.a("voteAnim", new Object[] { "reset" });
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.v = 0;
    this.w = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) && (!this.d))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    a(false, false, 8);
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, TextView paramTextView, SingleLineTextView paramSingleLineTextView, HeartLayout paramHeartLayout)
  {
    if ((paramView == null) || (paramTextView == null) || (paramSingleLineTextView == null)) {
      label14:
      return;
    }
    if (paramHeartLayout != null) {
      this.d = true;
    }
    int i2;
    label32:
    int i1;
    if (paramInt1 >= 0)
    {
      i2 = paramInt1;
      if (paramInt2 <= i2) {
        break label289;
      }
      i1 = i2 % 20;
    }
    for (;;)
    {
      label45:
      DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (i1 <= 0)
      {
        if (this.v != 0) {
          a();
        }
        label90:
        DatingUtil.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(this.y), Integer.valueOf(this.z), Integer.valueOf(this.v), Integer.valueOf(i2), Integer.valueOf(i1) });
        this.y = i2;
        if (i1 - this.z <= 0) {
          break label431;
        }
      }
      label289:
      label431:
      for (paramInt1 = i1 - this.z;; paramInt1 = 0)
      {
        this.z = i1;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = paramSingleLineTextView;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView = paramView;
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
        FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
        switch (this.v)
        {
        case 1: 
        default: 
          return;
        case 0: 
          if (this.z <= 0) {
            break label570;
          }
          if (!this.c) {
            break label452;
          }
          a(true, true, 0);
          return;
          i2 = 0;
          break label32;
          if (paramInt2 >= 0) {
            break label579;
          }
          i1 = 0;
          break label45;
          if ((this.y != i2) || (this.z != i1))
          {
            if ((this.v == 1) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a(paramView, paramTextView, paramSingleLineTextView, paramHeartLayout)))
            {
              this.A = paramInt1;
              this.B = paramInt2;
              if ((this.d) && (!VersionUtils.e()))
              {
                a();
                return;
              }
              if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
                break label14;
              }
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
              return;
            }
            a();
            break label90;
          }
          if ((this.v != 2) || ((!this.jdField_b_of_type_Boolean) && (!this.c))) {
            break label90;
          }
          this.v = 3;
          break label90;
        }
      }
      a(true, true, 0);
      return;
      a(true, false, 0);
      return;
      label452:
      if (this.d)
      {
        paramInt2 = 0;
        a(true, false, paramInt2);
        i1 = 1;
        paramInt2 = i1;
        if (this.d) {
          if (paramInt1 > 0)
          {
            paramInt2 = i1;
            if (VersionUtils.e()) {}
          }
          else
          {
            paramInt2 = 0;
          }
        }
        if (paramInt2 == 0) {
          break;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
        paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, paramInt1, 0);
        paramTextView = this.jdField_a_of_type_MqqOsMqqHandler;
        if (!this.d) {
          break label562;
        }
      }
      label562:
      for (long l1 = 1000L;; l1 = 1500L)
      {
        paramTextView.sendMessageDelayed(paramView, l1);
        this.v = 1;
        this.w = 0;
        return;
        paramInt2 = 4;
        break;
      }
      label570:
      a(false, false, 8);
      return;
      label579:
      i1 = paramInt2;
    }
  }
  
  protected void b()
  {
    DatingUtil.a("voteAnim", new Object[] { "finishAnim" });
    this.v = 2;
    this.w = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()) && (!this.d))
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    a(true, false, 0);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface)) {
        ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).c("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    DatingUtil.a("voteAnim", new Object[] { "endAnim", Integer.valueOf(this.v), Integer.valueOf(this.w) });
    if (this.v == 1)
    {
      if (this.w == 2) {
        b();
      }
    }
    else {
      return;
    }
    if (this.w == 0)
    {
      a();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    b();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i2;
      int i1;
      if ((this.v == 1) && (this.w == 0) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a()))
      {
        this.w = 1;
        if (this.d)
        {
          i2 = paramMessage.arg1;
          if (i2 > 0)
          {
            i1 = i2;
            if (i2 > 20) {
              i1 = 20;
            }
            if (this.D == 1)
            {
              if (this.C == -1) {
                this.C = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), 0).getInt("profilecard_host_last_newvote_animation_num", 0);
              }
              if ((this.z > 0) && (this.z != this.C))
              {
                this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, i1, 0).sendToTarget();
                this.C = this.z;
                this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", this.C).commit();
              }
            }
          }
        }
      }
      for (;;)
      {
        DatingUtil.a("voteAnim", new Object[] { "MSG_ANIM_1", Integer.valueOf(this.v), Integer.valueOf(this.w), this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder });
        break;
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, i1, 0).sendToTarget();
        continue;
        a();
        continue;
        float f1 = 1.0F;
        float f2 = 1.0F;
        if (this.x == 2)
        {
          f1 = 0.5F;
          f2 = 0.5F;
        }
        if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f1, 1, f2);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
          this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
          label378:
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
          if (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) {
            break label505;
          }
          this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(400L);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 1100L);
          break;
          this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
          break label378;
          label505:
          this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
        }
        a();
      }
      a(this.A, this.B, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      continue;
      if ((this.v == 1) && (this.w == 1))
      {
        this.w = 2;
        b();
      }
      else
      {
        c();
        continue;
        i1 = paramMessage.arg1;
        if (i1 > 0)
        {
          paramMessage = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLocationInWindow(paramMessage);
          if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
            this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2130841113);
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.a(), (float)(paramMessage[0] + this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.b() * 0.5D), paramMessage[1]);
          int i3 = i1 - 1;
          if (i3 > 0)
          {
            paramMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, i3, 0);
            if (this.jdField_a_of_type_JavaUtilRandom == null) {
              this.jdField_a_of_type_JavaUtilRandom = new Random();
            }
            i2 = jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(jdField_a_of_type_ArrayOfInt.length)];
            i1 = i2;
            if (i3 < 10.0D) {
              i1 = i2 * 2;
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, i1);
          }
          else
          {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 3100L);
          }
        }
        else
        {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 100L);
        }
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = false;
    if (paramAnimation == null) {
      break label6;
    }
    label6:
    while ((paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) && (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation)) {
      return;
    }
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) {
        bool2 = true;
      }
      DatingUtil.a("voteAnim", new Object[] { "end", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      if ((this.w != 1) || (this.v != 1)) {
        break;
      }
      this.w = 2;
      b();
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((paramAnimation == null) || (!this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.a())) {}
    do
    {
      return;
      if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
      {
        DatingUtil.a("voteAnim", new Object[] { "start", "anim1_1" });
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation);
    DatingUtil.a("voteAnim", new Object[] { "start", "anim1_2" });
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper$NewVoteHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\NewVoteAnimHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */