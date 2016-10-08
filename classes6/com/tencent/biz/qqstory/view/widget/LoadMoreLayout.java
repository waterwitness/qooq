package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LoadMoreLayout
  extends FrameLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  protected Context a;
  protected View a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected int g;
  
  public LoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    b();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    b();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
    b();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = "加载更多";
    this.c = "正在加载...";
    this.d = "已加载全部";
    this.b = "加载中...";
    this.e = "加载失败";
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((paramInt2 == 0) || (paramInt2 == 3)) {
              break;
            }
          } while (paramInt2 != 4);
          return true;
          if ((paramInt2 == 0) || (paramInt2 == 3)) {
            break;
          }
        } while (paramInt2 != 4);
        return true;
        if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2)) {
          break;
        }
      } while (paramInt2 != 4);
      return true;
      if ((paramInt2 == 0) || (paramInt2 == 1)) {
        break;
      }
    } while (paramInt2 != 3);
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904511, null));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297479));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296792));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297537);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    c(0);
  }
  
  private boolean c(int paramInt)
  {
    if (!a(this.g, paramInt)) {
      return false;
    }
    this.g = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      continue;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.e);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public boolean a(int paramInt)
  {
    return c(paramInt);
  }
  
  public boolean b(int paramInt)
  {
    return a(this.g, paramInt);
  }
  
  public void setBlackMode() {}
  
  public void setVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void setWillLoadMoreText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\LoadMoreLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */