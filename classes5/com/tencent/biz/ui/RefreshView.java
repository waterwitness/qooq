package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.OverScrollViewListener;
import jgb;
import jgc;

public class RefreshView
  extends CustomScrollView
{
  static final int e = 2;
  static final int f = 3;
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public IPullRefreshHeader a;
  private RefreshView.OnRefreshListener jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  public int g;
  private int k;
  private final int l;
  
  public RefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = 0;
    this.l = 0;
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler = new jgb(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new jgc(this);
    b(paramContext);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().getMeasuredHeight();
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(paramContext).inflate(2130903499, null));
    addView(this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(), 0);
    e();
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    int m = getScrollY();
    if (m < 0)
    {
      if (m <= -a()) {
        break label92;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label61;
      }
      if ((this.k == 0) || (this.k == 2)) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, null, null);
      }
    }
    for (;;)
    {
      this.k = 1;
      return false;
      label61:
      if ((this.k == 1) || (this.k == 2)) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.c(0, null, null);
      }
    }
    label92:
    boolean bool1;
    if (this.jdField_a_of_type_Boolean) {
      if (this.k != 0)
      {
        bool1 = bool2;
        if (this.k != 1) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.b(0, null, null);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.k = 2;
      return bool1;
      bool1 = bool2;
      if (this.k == 2) {
        bool1 = this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, null, null);
      }
    }
  }
  
  private void e()
  {
    float f1 = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setMinimumHeight((int)(f1 * 60.0F));
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setVisibility(8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener != null)
    {
      this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener.a();
      return;
    }
    b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener == null)
    {
      super.a();
      return;
    }
    d();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Boolean = true;
    if (this.g != 2) {
      d();
    }
  }
  
  protected boolean a()
  {
    return (this.b) || (this.g == 3);
  }
  
  public void b()
  {
    this.b = true;
    super.a();
  }
  
  public void c()
  {
    this.b = true;
    this.g = 3;
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a() == 0L)
    {
      b();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a());
  }
  
  public final void d()
  {
    this.g = 3;
    b();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().layout(0, -this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().getMeasuredHeight(), this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().getMeasuredWidth(), 0);
  }
  
  public void setDelayBeforeScrollBack(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader instanceof PullRefreshHeader)) {
      ((PullRefreshHeader)this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader).a = paramLong;
    }
  }
  
  public void setHeader(IPullRefreshHeader paramIPullRefreshHeader)
  {
    if (paramIPullRefreshHeader == null) {
      return;
    }
    removeViewAt(0);
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = paramIPullRefreshHeader;
    addView(this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(), 0);
    e();
  }
  
  public final void setHeaderBgColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgColor(paramInt);
    }
  }
  
  public final void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgDrawable(paramDrawable);
    }
  }
  
  public final void setHeaderBgRes(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgRes(paramInt);
    }
  }
  
  public final void setHeaderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setTextColor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setOnCancelListener(RefreshView.OnCancelListener paramOnCancelListener) {}
  
  public void setOnRefreshListener(RefreshView.OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener = paramOnRefreshListener;
    if (paramOnRefreshListener == null)
    {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\RefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */