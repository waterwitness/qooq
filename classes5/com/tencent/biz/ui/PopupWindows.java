package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jga;

public class PopupWindows
{
  public Context a;
  protected Drawable a;
  protected WindowManager a;
  public PopupWindow a;
  public View b;
  
  public PopupWindows(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchInterceptor(new jga(this));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
  }
  
  protected void b()
  {
    if (this.b == null) {
      throw new IllegalStateException("setContentView was not called with a view to display.");
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.b);
      return;
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void b(int paramInt)
  {
    b(((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(paramInt, null));
  }
  
  public void b(View paramView)
  {
    this.b = paramView;
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramView);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\PopupWindows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */