package com.tencent.mobileqq.hotchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TimeLineView
  extends LinearLayout
{
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public TextView b;
  public TextView c;
  
  public TimeLineView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130904199, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301803));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301804));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131301800));
    this.b = ((TextView)localView.findViewById(2131301801));
    this.c = ((TextView)localView.findViewById(2131301802));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str.split("#");
    if (paramString.length == 2)
    {
      this.b.setText(paramString[0]);
      this.c.setText(paramString[1]);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!paramBoolean) {
        break label151;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840824);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840824);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label151:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840825);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840825);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\TimeLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */