package com.tencent.mobileqq.dating.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import rgo;

public class InputBar
  extends LinearLayout
{
  public static final int a = 61;
  public static final int b = 60;
  private View jdField_a_of_type_AndroidViewView;
  private InputBar.IIputBarCallback jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public InputBar(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InputBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View a(AdapterView paramAdapterView, int paramInt)
  {
    int k = 0;
    while (k < paramAdapterView.getChildCount())
    {
      View localView = paramAdapterView.getChildAt(k);
      if (paramInt == a(paramAdapterView, localView)) {
        return localView;
      }
      k += 1;
    }
    return null;
  }
  
  public int a(AdapterView paramAdapterView, View paramView)
  {
    int m = paramAdapterView.a(paramView);
    int k = m;
    if ((paramAdapterView instanceof ListView)) {
      k = m - ((ListView)paramAdapterView).m();
    }
    return k;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void a(boolean paramBoolean, ListView paramListView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
      } while (paramListView == null);
      this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
      this.c = paramInt1;
      this.h = this.jdField_a_of_type_ComTencentWidgetListView.m();
      this.g = paramInt2;
      paramListView = a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1);
    } while (paramListView == null);
    this.d = paramListView.getBottom();
    this.e = paramListView.getMeasuredHeight();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.j == 0) {
      this.j = paramInt4;
    }
    do
    {
      do
      {
        while (!this.jdField_a_of_type_Boolean)
        {
          return;
          if ((paramInt4 == this.j) && (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback != null)) {
            this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback.e();
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.e("InputBar", 4, "inputBar onLayout top is: " + paramInt2 + "changed is: " + paramBoolean);
        }
      } while (paramInt2 <= 0);
      if (this.f <= 0)
      {
        this.f = paramInt2;
        this.i = paramInt2;
        return;
      }
      if ((paramInt2 != this.f) && (paramInt2 == this.i))
      {
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_a_of_type_AndroidViewView);
        }
        this.f = paramInt2;
        return;
      }
    } while ((paramInt2 == this.f) || (paramInt2 == this.i));
    getHandler().post(new rgo(this, paramInt2));
    this.f = paramInt2;
  }
  
  public void setmCallback(InputBar.IIputBarCallback paramIIputBarCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar$IIputBarCallback = paramIIputBarCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\widget\InputBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */