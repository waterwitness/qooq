package com.tencent.mobileqq.activity.recent;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ows;

public class PollBanner
  implements Animation.AnimationListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "PollBanner";
  private static final int jdField_b_of_type_Int = 3000;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  public Handler a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private BannerFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private List jdField_a_of_type_JavaUtilList;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private int c;
  
  public PollBanner(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ows(this);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout = new BannerFrameLayout(paramBaseActivity);
    a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968772);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.b = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968773);
    this.b.setFillAfter(false);
  }
  
  public void a(Banner paramBanner, boolean paramBoolean)
  {
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PollBanner", 2, "addBanner " + paramBanner.toString() + ", isShow = " + paramBoolean);
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramBanner));
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    paramBanner.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_JavaUtilList.add(paramBanner);
    localObject = paramBanner.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.addView(paramBanner.jdField_a_of_type_AndroidViewView);
      if (paramBoolean) {
        this.c = this.jdField_a_of_type_JavaUtilList.indexOf(paramBanner);
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() < 2) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "stopAnim isRemove = " + paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.getChildAt(i);
      if (localView != null) {
        localView.clearAnimation();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.setAnimEnd(true);
    if (paramBoolean) {
      this.c = 0;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "removeAll");
    }
    a(true);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.removeAllViews();
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((Banner)localIterator.next()).jdField_a_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "startAnim mBannerList = " + this.jdField_a_of_type_JavaUtilList + ", size = " + i);
    }
    if (i <= 1) {
      return;
    }
    Banner localBanner1 = (Banner)this.jdField_a_of_type_JavaUtilList.get(this.c % i);
    Banner localBanner2 = (Banner)this.jdField_a_of_type_JavaUtilList.get((this.c + 1) % i);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.indexOfChild(localBanner1.jdField_a_of_type_AndroidViewView) == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.addView(localBanner1.jdField_a_of_type_AndroidViewView);
      localBanner1.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.indexOfChild(localBanner2.jdField_a_of_type_AndroidViewView) == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.addView(localBanner2.jdField_a_of_type_AndroidViewView);
      localBanner2.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    localBanner1.jdField_a_of_type_AndroidViewView.startAnimation(this.b);
    localBanner2.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    int j = this.c + 1;
    this.c = j;
    this.c = (j % i);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationEnd");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.setAnimEnd(true);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 2)
    {
      paramAnimation = ((Banner)this.jdField_a_of_type_JavaUtilList.get((this.c + 1) % i)).jdField_a_of_type_AndroidViewView;
      if (this.c == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.removeViewAt(i - 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.addView(paramAnimation);
        paramAnimation.setVisibility(8);
        ((Banner)this.jdField_a_of_type_JavaUtilList.get(this.c)).jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.removeViewAt(this.c - 1);
      break;
      paramAnimation = ((Banner)this.jdField_a_of_type_JavaUtilList.get((this.c + 1) % i)).jdField_a_of_type_AndroidViewView;
      ((Banner)this.jdField_a_of_type_JavaUtilList.get(this.c)).jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramAnimation.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationStart");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.setAnimEnd(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\PollBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */