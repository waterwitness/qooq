package com.tencent.av.utils;

import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class NotificationStyleDiscover
{
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  Integer jdField_a_of_type_JavaLangInteger;
  String jdField_a_of_type_JavaLangString;
  float jdField_b_of_type_Float;
  Integer jdField_b_of_type_JavaLangInteger;
  final String jdField_b_of_type_JavaLangString;
  final String c;
  
  public NotificationStyleDiscover(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "NotificationStyleDiscover";
    this.jdField_a_of_type_JavaLangInteger = null;
    this.jdField_a_of_type_Float = 14.0F;
    this.jdField_b_of_type_JavaLangInteger = null;
    this.jdField_b_of_type_Float = 16.0F;
    this.jdField_b_of_type_JavaLangString = "SearchForText";
    this.c = "SearchForTitle";
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    if ((this.jdField_a_of_type_JavaLangInteger != null) && (this.jdField_b_of_type_JavaLangInteger != null)) {
      return;
    }
    try
    {
      Object localObject = new Notification();
      ((Notification)localObject).setLatestEventInfo(this.jdField_a_of_type_AndroidContentContext, "SearchForTitle", "SearchForText", null);
      paramContext = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = (ViewGroup)((Notification)localObject).contentView.apply(this.jdField_a_of_type_AndroidContentContext, paramContext);
      a((ViewGroup)localObject);
      b((ViewGroup)localObject);
      paramContext.removeAllViews();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "erro");
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_b_of_type_Float = localTextView.getTextSize();
          this.jdField_b_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public Integer b()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
  
  boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_a_of_type_Float = localTextView.getTextSize();
          this.jdField_a_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\NotificationStyleDiscover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */