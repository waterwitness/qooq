package com.tencent.biz.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import jge;

public class TouchWebView
  extends CustomWebView
  implements WebViewCallbackClient
{
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public TouchWebView.OnOverScrollHandler a;
  TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener;
  public boolean f;
  public boolean g;
  
  public TouchWebView(Context paramContext)
  {
    super(paramContext);
    this.g = false;
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new jge(this);
    b();
  }
  
  public TouchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = false;
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new jge(this);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    setWebViewCallbackClient(this);
    setFadingEdgeLength(0);
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void computeScroll(View paramView)
  {
    super.super_computeScroll();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler != null) && (this.g))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler.a();
      this.g = false;
      this.f = false;
    }
    if (this.g) {
      return false;
    }
    return super.super_dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return super.super_onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if (paramInt2 <= 0) {}
    for (this.f = true;; this.f = false)
    {
      super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.g)) {
      return true;
    }
    return super.super_onTouchEvent(paramMotionEvent);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void setOnOverScrollHandler(TouchWebView.OnOverScrollHandler paramOnOverScrollHandler)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler = paramOnOverScrollHandler;
  }
  
  public void setOnScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\TouchWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */