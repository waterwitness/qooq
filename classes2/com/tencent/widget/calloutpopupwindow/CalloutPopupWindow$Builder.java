package com.tencent.widget.calloutpopupwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class CalloutPopupWindow$Builder
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d;
  
  private CalloutPopupWindow$Builder(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 17170445;
    this.jdField_a_of_type_Boolean = true;
    this.c = 5;
    this.d = 49;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public CalloutPopupWindow a()
  {
    try
    {
      int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 250.0F);
      int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 120.0F);
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setTextSize(12.0F);
      ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(17170443));
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localLinearLayout.addView((View)localObject);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        int k = localLinearLayout.getPaddingLeft();
        int m = localLinearLayout.getPaddingTop();
        int n = localLinearLayout.getPaddingRight();
        int i1 = localLinearLayout.getPaddingBottom();
        localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localLinearLayout.setPadding(k, m, n, i1);
      }
      ((TextView)localObject).setMaxWidth(i);
      ((TextView)localObject).setMaxHeight(j);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      ((TextView)localObject).setTextColor(this.jdField_a_of_type_Int);
      localLinearLayout.measure(i, j);
      localObject = new CalloutPopupWindow(this.jdField_a_of_type_AndroidContentContext, localLinearLayout.getMeasuredWidth(), this.d);
      ((CalloutPopupWindow)localObject).c(this.jdField_b_of_type_Int);
      ((CalloutPopupWindow)localObject).a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      ((CalloutPopupWindow)localObject).setContentView(localLinearLayout);
      ((CalloutPopupWindow)localObject).a(83);
      if (!this.jdField_a_of_type_Boolean) {
        ((CalloutPopupWindow)localObject).setOutsideTouchable(false);
      }
      ((CalloutPopupWindow)localObject).b(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F));
      CalloutPopupWindow.a((CalloutPopupWindow)localObject, this.c);
      return (CalloutPopupWindow)localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("CalloutPopupWindow", "[build] failed to build window", localThrowable);
    }
    return null;
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder b(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\calloutpopupwindow\CalloutPopupWindow$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */