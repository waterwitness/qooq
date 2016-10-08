package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class AccountDetailXListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "AccountDetailXListView";
  public static final int b = 1;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  public AccountDetailXListView.RefreshCallback a;
  boolean jdField_a_of_type_Boolean = true;
  protected int c = 0;
  protected int d;
  protected int e;
  
  public AccountDetailXListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    c();
    this.e = paramContext.getResources().getDisplayMetrics().heightPixels;
    setOnScrollListener(this);
  }
  
  private boolean b()
  {
    if (a() == null) {}
    while ((n() <= 0) || (t() != a().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130903734, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298748));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298749));
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void d()
  {
    if ((b()) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$RefreshCallback != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadingMore");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372664);
      a(0);
      this.c = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$RefreshCallback.a(this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadMoreFail");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372666);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      a(0);
      this.c = 0;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.c == 0) && (paramAbsListView.t() == paramAbsListView.d_() - 1) && (this.jdField_a_of_type_Boolean)) {
      d();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        c();
      }
      if (n() <= 0) {
        b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (n() <= 0)) {
      return;
    }
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadMoreComplete hasMoreData = " + paramBoolean);
      }
      this.c = 0;
      if (!paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372665);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.d < 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.d = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      a(-this.d);
    }
  }
  
  public void setRefreshCallback(AccountDetailXListView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView$RefreshCallback = paramRefreshCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetail\view\AccountDetailXListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */