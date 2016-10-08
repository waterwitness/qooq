package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

public class ReadInJoyXListView
  extends XListView
  implements AbsListView.OnScrollListener, OverScrollViewListener
{
  public static final int a = 0;
  public static final int b = 1;
  private static final int h = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  private ReadInJoyXListView.OnDrawCompleteListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener;
  public ReadInJoyXListView.RefreshCallback a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  protected int c;
  private boolean c;
  protected int d;
  private boolean d;
  protected int e;
  protected int f;
  protected int g;
  
  public ReadInJoyXListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ac);
    this.jdField_c_of_type_Boolean = paramAttributeSet.getBoolean(0, false);
    this.b = paramAttributeSet.getBoolean(1, false);
    paramAttributeSet.recycle();
    if (this.jdField_c_of_type_Boolean) {
      f();
    }
    if (this.b) {
      g();
    }
    this.g = paramContext.getResources().getDisplayMetrics().heightPixels;
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
  
  private void c(int paramInt)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.au == 0)
      {
        QLog.d("XListView", 2, "scroll2Top : stop on top,refresh ! from : " + paramInt);
        c();
        this.jdField_d_of_type_Boolean = false;
      }
    }
    else {
      return;
    }
    QLog.d("XListView", 2, "scroll2Top : not on top, jump to top and refresh. from : " + paramInt);
    if (paramInt != 3)
    {
      this.jdField_d_of_type_Boolean = false;
      if ((a() instanceof HeaderViewListAdapter)) {
        setAdapter(((HeaderViewListAdapter)a()).getWrappedAdapter());
      }
      for (;;)
      {
        c();
        return;
        setAdapter(a());
      }
    }
    b();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2130903499, this, false));
    setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    setOverScrollListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130903764, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298748));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298749));
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void h()
  {
    if ((b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366425);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      a(0);
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback.b(this);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    L();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramView != this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      c(3);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.e < 0) && (this.jdField_c_of_type_Int != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2)) {
      h();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    PullRefreshHeader localPullRefreshHeader;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) && (this.jdField_a_of_type_Boolean))
    {
      a(800L);
      localPullRefreshHeader = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) && (this.jdField_a_of_type_Boolean))
    {
      a(1500L);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0, paramString);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(2);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    do
    {
      do
      {
        return true;
      } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramView != this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback == null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback.a(this);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    View localView;
    boolean bool;
    if (this.au == 0)
    {
      localView = getChildAt(0);
      if (localView == null) {
        bool = false;
      }
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_d_of_type_Boolean = true;
        e(0);
      }
      for (;;)
      {
        QLog.d("XListView", 2, "scroll2TopAndRefresh needScroll : " + bool);
        return;
        if (localView.getTop() - getPaddingTop() != 0) {
          break label92;
        }
        bool = false;
        break;
        c();
      }
      label92:
      bool = true;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) || (paramView != this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.e = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366426);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(-this.f);
    }
    setFooterView(paramBoolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    L();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      c(2);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    H();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback.f();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener.a(this);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener = null;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new ReadInJoyXListView.UICallBack(this, this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.f < 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.f = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      a(-this.f);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      QLog.d("XListView", 2, "scroll2Top catch user touch event!");
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_d_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.e = ((int)paramMotionEvent.getRawY() - this.jdField_d_of_type_Int);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      c(1);
    }
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        g();
      }
      if (n() <= 0) {
        b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        g();
      }
    } while (n() <= 0);
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.b = paramBoolean;
    g();
  }
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    f();
  }
  
  public void setOnDrawCompleteListener(ReadInJoyXListView.OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener = paramOnDrawCompleteListener;
  }
  
  public void setRefreshCallback(ReadInJoyXListView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$RefreshCallback = paramRefreshCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyXListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */