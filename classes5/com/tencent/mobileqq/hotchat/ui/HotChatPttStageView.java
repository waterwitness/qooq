package com.tencent.mobileqq.hotchat.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.HCTopicSeatsView;
import com.tencent.mobileqq.hotchat.TimeLineView;
import com.tencent.mobileqq.hotchat.anim.ComboAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.WaveView;
import svj;
import svk;
import svl;
import svm;

public class HotChatPttStageView
  extends RelativeLayout
  implements Handler.Callback
{
  public static final int a = 135;
  private static final String jdField_a_of_type_JavaLangString = "HotChatPttStageView";
  Context jdField_a_of_type_AndroidContentContext;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HCTopicSeatsView jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView;
  public ComboAnimator a;
  HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public WaveView a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public HotChatPttStageView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotChatPttStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (VersionUtils.e()) {
      setLayerType(2, null);
    }
    setClickable(true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(paramContext.getMainLooper(), this);
    a();
  }
  
  public HCTopicSeatsView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView;
  }
  
  public HorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)inflate(this.jdField_a_of_type_AndroidContentContext, 2130904198, this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297649));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301797));
    this.jdField_a_of_type_ComTencentWidgetWaveView = ((WaveView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301798));
    this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView = ((HCTopicSeatsView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301799));
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131493624);
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(paramInt, paramFloat1, paramFloat2, -1L, 0);
    }
  }
  
  public void a(int paramInt1, float paramFloat1, float paramFloat2, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(paramInt1, paramFloat1, paramFloat2, paramLong, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetWaveView != null) {
      this.jdField_a_of_type_ComTencentWidgetWaveView.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!VersionUtils.e()) {}
    while ((this.jdField_a_of_type_Boolean == paramBoolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.setDuration(500L);
      localValueAnimator.addUpdateListener(new svj(this));
      localValueAnimator.addListener(new svk(this));
      localValueAnimator.setInterpolator(new AccelerateInterpolator());
      localValueAnimator.start();
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new svl(this));
    localValueAnimator.addListener(new svm(this));
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.start();
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    if (!VersionUtils.e()) {}
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator.b();
      }
      while ((paramViewGroup != null) && ((paramViewGroup instanceof RelativeLayout)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.removeAllViews();
        }
        Object localObject = paramViewGroup.findViewById(2131296554);
        if (localObject != null) {
          paramViewGroup.removeView((View)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = new HeartLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setId(2131296554);
        this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908);
        int i = this.c + AIOUtils.a(135.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, (ViewGroup.LayoutParams)localObject);
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a();
        if (paramViewGroup != null)
        {
          paramViewGroup.l = 4000;
          paramViewGroup.g = i;
          paramViewGroup.f = (i / 2);
        }
        return true;
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator = new ComboAnimator(this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.clearAnimation();
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetWaveView != null) {
      this.jdField_a_of_type_ComTencentWidgetWaveView.b();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!VersionUtils.e()) {}
    while (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = 0;
    label35:
    Object localObject;
    if (i <= m - k)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof TimeLineView))) {
        if ((!this.jdField_a_of_type_Boolean) || (paramBoolean)) {
          break label110;
        }
      }
    }
    label110:
    for (int j = 2130840825;; j = 2130840824)
    {
      localObject = (TimeLineView)localObject;
      ((TimeLineView)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(j);
      ((TimeLineView)localObject).jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(j);
      i += 1;
      break label35;
      break;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimComboAnimator.b();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHCTopicSeatsView.f();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    while (((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1)) || (getParent() == null)) {
      return bool;
    }
    getParent().requestDisallowInterceptTouchEvent(false);
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\ui\HotChatPttStageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */