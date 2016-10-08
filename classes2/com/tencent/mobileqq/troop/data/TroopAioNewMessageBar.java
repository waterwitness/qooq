package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.MsgUtils;
import vls;
import vlt;

public class TroopAioNewMessageBar
  extends TroopAioAgent
  implements Animation.AnimationListener
{
  public static int d = 1;
  public static int e = 2;
  protected static int f;
  protected static int g = 1;
  protected static int h = 2;
  protected static int i = 3;
  public static int j;
  protected static final int m = (int)BaseApplicationImpl.a().getResources().getDimension(2131492881);
  protected float a;
  protected Handler a;
  protected Animation a;
  public LinearLayout a;
  protected TextView a;
  protected Animation b;
  public LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  protected boolean b;
  protected Animation c;
  public boolean c;
  public int k;
  protected int l = f;
  protected int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopAioNewMessageBar()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new vls(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Object localObject;
    if (paramInt == e)
    {
      paramTextView.setText(2131364629);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839288, 0);
      paramTextView.setCompoundDrawablePadding(4);
      paramTextView.setGravity(17);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != d);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setGravity(19);
      localObject = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (localObject == null);
    MsgSummary localMsgSummary = new MsgSummary();
    MsgUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QQMessageFacade.Message)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMsgSummary, ((QQMessageFacade.Message)localObject).nickName, false, false);
    paramTextView.setText(localMsgSummary.a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.k = paramInt;
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.l == f)
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
      this.l = g;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
    }
    do
    {
      return;
      if (this.l == g)
      {
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
        return;
      }
      if (this.l == h)
      {
        a(this.jdField_b_of_type_AndroidWidgetTextView, paramInt);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
          return;
        }
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
        return;
      }
    } while (this.l != i);
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
    this.l = g;
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131296339);
      Object localObject = new RelativeLayout.LayoutParams(-1, m);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131297409);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296406);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838120);
      localObject = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      setChanged();
      notifyObservers(TroopAioAgent.Message.a(2131296339));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new LinearLayout.LayoutParams(-1, m * 2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296407);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428300));
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296408);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428300));
      localObject = new RelativeLayout.LayoutParams(-1, m);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, m);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296407);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new vlt(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.l == g)
    {
      f();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.l = i;
    }
    while (this.l != h) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.l = i;
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat < -0.2F)
    {
      if (e == this.k) {
        e();
      }
      return;
    }
    if (this.l != f)
    {
      this.jdField_a_of_type_Float = 0.0F;
      return;
    }
    this.jdField_a_of_type_Float += paramFloat;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      if (paramInt > this.n) {
        b(d);
      }
    }
    for (;;)
    {
      this.n = paramInt;
      return;
      if (this.n > 0) {
        e();
      } else if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.d_() - 11)
      {
        if ((f == this.l) && (this.jdField_b_of_type_Boolean)) {
          b(e);
        }
      }
      else if (e == this.k) {
        e();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      a(this.n);
      this.jdField_b_of_type_Boolean = false;
    }
    while (e != this.k) {
      return;
    }
    e();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout != null;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, m, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, m);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - m);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(j);
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      f();
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Float = 0.0F;
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.l = f;
    }
    do
    {
      do
      {
        return;
        if (!paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {
          break;
        }
        this.l = h;
      } while (this.k != e);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, j), 3000L);
      return;
    } while (!paramAnimation.equals(this.jdField_c_of_type_AndroidViewAnimationAnimation));
    a(this.jdField_a_of_type_AndroidWidgetTextView, this.k);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopAioNewMessageBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */