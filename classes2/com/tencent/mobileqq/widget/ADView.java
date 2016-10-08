package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.qphone.base.util.QLog;
import wkk;
import wkl;

public class ADView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = -2;
  protected float a;
  public WorkSpaceView a;
  private wkl jdField_a_of_type_Wkl;
  private boolean jdField_a_of_type_Boolean;
  public LinearLayout b;
  protected int d;
  protected boolean d;
  protected int e;
  public boolean e;
  protected int f;
  protected int g;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Int = 2130837535;
    this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.f = 2;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Wkl = new wkl(this);
    a(paramContext);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_d_of_type_Int = 2130837535;
    this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.f = 2;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Wkl = new wkl(this);
    a(paramContext);
  }
  
  private void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams;
    if (this.g > 0)
    {
      localLayoutParams = new LinearLayout.LayoutParams((int)(this.g * this.jdField_a_of_type_Float), (int)(this.g * this.jdField_a_of_type_Float));
      localLayoutParams.setMargins(0, 0, (int)(this.f * this.jdField_a_of_type_Float), 0);
      localImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      try
      {
        localImageView.setImageDrawable(getContext().getResources().getDrawable(this.jdField_e_of_type_Int));
        if (!paramBoolean) {
          continue;
        }
        localImageView.setEnabled(true);
      }
      catch (Exception localException)
      {
        localImageView.setImageResource(this.jdField_d_of_type_Int);
        continue;
        int i = 4;
        continue;
      }
      paramLinearLayout.addView(localImageView);
      if (paramLinearLayout.getChildCount() <= 1) {
        continue;
      }
      i = 0;
      paramLinearLayout.setVisibility(i);
      return;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      break;
      localImageView.setEnabled(false);
    }
  }
  
  public int a(int paramInt)
  {
    if (this.b == null) {}
    while (paramInt >= this.b.getChildCount()) {
      return 0;
    }
    Object localObject = (RelativeLayout)this.b.getChildAt(paramInt);
    if (localObject != null) {}
    for (localObject = (WorkSpaceView)((RelativeLayout)localObject).getChildAt(0);; localObject = null)
    {
      if (localObject != null) {}
      for (paramInt = ((WorkSpaceView)localObject).getChildCount();; paramInt = 0) {
        return paramInt;
      }
    }
  }
  
  public ViewGroup a(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(paramInt);
    if (localRelativeLayout != null) {
      return (WorkSpaceView)localRelativeLayout.getChildAt(0);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    LinearLayout localLinearLayout = (LinearLayout)this.b.getChildAt(paramInt1);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)localLinearLayout.getChildAt(0);
    localWorkSpaceView.removeViewAt(paramInt2);
    localLinearLayout = (LinearLayout)localLinearLayout.getChildAt(1);
    localLinearLayout.removeViewAt(paramInt2);
    if (localLinearLayout.getChildCount() > 1) {}
    for (paramInt1 = i;; paramInt1 = 4)
    {
      localLinearLayout.setVisibility(paramInt1);
      if (paramInt2 > 0) {
        localWorkSpaceView.a(paramInt2 - 1);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView)
  {
    int i = 0;
    try
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)localRelativeLayout.getChildAt(0);
      localWorkSpaceView.removeView(paramView);
      paramView = (LinearLayout)localRelativeLayout.getChildAt(1);
      paramView.removeViewAt(paramInt2);
      if (paramView.getChildCount() > 1) {}
      for (paramInt1 = i;; paramInt1 = 4)
      {
        paramView.setVisibility(paramInt1);
        if (paramInt2 > 0) {
          localWorkSpaceView.a(paramInt2 - 1);
        }
        return;
      }
      return;
    }
    catch (Exception paramView) {}
  }
  
  public void a(Context paramContext)
  {
    setPadding(0, 0, 0, 0);
    this.b = new LinearLayout(paramContext);
    addView(this.b, new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject;
    if (this.b.getChildCount() == 0)
    {
      this.b.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new LinearLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new wkk(this, (LinearLayout)localObject));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      a((LinearLayout)localObject);
      localRelativeLayout.addView((View)localObject);
      this.b.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        a((LinearLayout)localObject, bool);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent.banner", 4, "addViewToWorkspace");
        }
        return;
      }
      catch (Exception paramView) {}
      localObject = (ViewGroup)this.b.getChildAt(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)localObject).getChildAt(0));
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
    }
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(14, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130838665);
    paramLinearLayout.setPadding((int)(4.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a(paramBoolean);
    }
  }
  
  public void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(0);
    if (localRelativeLayout == null) {
      return;
    }
    ((WorkSpaceView)localRelativeLayout.getChildAt(0)).removeAllViews();
    this.b.removeAllViews();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Wkl.removeMessages(0);
    try
    {
      PushBanner localPushBanner = (PushBanner)this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a()).getTag();
      i = localPushBanner.a;
      setContentDescription(localPushBanner.n);
      i *= 1000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 5000;
      }
    }
    this.jdField_a_of_type_Wkl.sendEmptyMessageDelayed(0, i);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Wkl.sendEmptyMessage(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_d_of_type_Boolean)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCircle(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setCircle(paramBoolean);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ADView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */