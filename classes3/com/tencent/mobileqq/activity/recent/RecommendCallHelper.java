package com.tencent.mobileqq.activity.recent;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.BitmapTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import oyj;
import oyk;
import oyl;
import oyn;

public class RecommendCallHelper
  implements ViewStub.OnInflateListener
{
  public static final String a = "RecommendCallHelper";
  public ViewPager a;
  public View.OnClickListener a;
  public View a;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AnonymousEntranceView a;
  OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  RecommendAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  boolean jdField_c_of_type_Boolean;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  boolean jdField_d_of_type_Boolean;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  boolean jdField_e_of_type_Boolean;
  
  public RecommendCallHelper(QQAppInterface paramQQAppInterface, View paramView, OnRecentUserOpsListener paramOnRecentUserOpsListener, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131301496));
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301513);
    if (paramBoolean)
    {
      this.jdField_e_of_type_Boolean = false;
      localView.setBackgroundDrawable(null);
    }
    while (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    Drawable localDrawable = BitmapTools.b(BaseApplication.getContext(), 2130838392);
    if (localDrawable != null)
    {
      localView.setBackgroundDrawable(localDrawable);
      return;
    }
    localView.setBackgroundResource(2130838392);
  }
  
  private void b(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_Boolean = false;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentAnonymousEntranceView == null);
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentAnonymousEntranceView.postDelayed(new oyn(this), i);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968608);
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968609);
        this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968610);
        this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968606);
        this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView == null) {
        return;
      }
      Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidViewView.getContext(), 2130968607);
      this.jdField_e_of_type_AndroidWidgetImageView.startAnimation(localAnimation);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("RecommendCallHelper", 2, "playStarAnimation", localException);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getVisibility() != 0) {
        b(0);
      }
    }
    else {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.postDelayed(new oyl(this), 100L);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public List a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a();
    }
    return null;
  }
  
  public void a()
  {
    b(true);
    e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendCallHelper", 2, "setVisibility visibility: " + paramInt);
    }
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramInt != 0) {
        break label285;
      }
      a(false);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() <= 0)) {
        break label190;
      }
      b(true);
      e();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() <= 0)) {
        break label253;
      }
      b(true);
      e();
      if (!this.jdField_d_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004C11", "0X8004C11", 0, 0, "", "", "", "");
      }
    }
    label190:
    label253:
    while (this.jdField_d_of_type_Boolean)
    {
      return;
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368881);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      b(false);
      break;
    }
    ReportController.b(null, "CliOper", "", "", "0X8004C10", "0X8004C10", 0, 0, "", "", "", "");
    return;
    label285:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    a(true);
    b(false);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendCallHelper", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(paramQQAppInterface);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendCallHelper", 2, "updateItem uin: " + paramString);
    }
    int i;
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount())
      {
        View localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(localView, paramString)) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecommendCallHelper", 2, "refreshRecommendFriendList isSuccess: " + paramBoolean);
    }
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() == 0))
      {
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368880);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        b(false);
        b(0);
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          ReportController.b(null, "CliOper", "", "", "0X8004C10", "0X8004C10", 0, 0, "", "", "", "");
        }
      }
    }
    label374:
    do
    {
      for (;;)
      {
        return;
        if ((paramList != null) && (paramList.size() > 0))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(paramList);
          }
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_d_of_type_Boolean = false;
            ReportController.b(null, "CliOper", "", "", "0X8004C11", "0X8004C11", 0, 0, "", "", "", "");
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
        while (this.jdField_a_of_type_AndroidViewView != null)
        {
          a(false);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          if ((paramList == null) || (paramList.size() <= 0)) {
            break label374;
          }
          if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
          {
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, false);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          b(true);
          e();
          return;
          if (((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() == 0)) && (this.jdField_d_of_type_Boolean))
          {
            this.jdField_d_of_type_Boolean = false;
            ReportController.b(null, "CliOper", "", "", "0X8004C10", "0X8004C10", 0, 0, "", "", "", "");
          }
        }
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() != 0));
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368880);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    b(false);
    b(0);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a() <= 0);
  }
  
  public void b()
  {
    b(false);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(null);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter = null;
    }
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentAnonymousEntranceView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendCallHelper", 2, "updateOnlineStatus");
    }
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount())
      {
        View localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(localView);
        i += 1;
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendCallHelper", 2, "onInflate");
    }
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131301512);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter = new RecommendAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131298164));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendAdapter);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301514));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301515));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301516));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301517));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301518));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301519));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301520));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298843));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("返回通话记录界面");
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new oyj(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentAnonymousEntranceView = ((AnonymousEntranceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301521));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentAnonymousEntranceView.setOnClickListener(new oyk(this));
      a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecommendCallHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */