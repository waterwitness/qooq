package com.tencent.mobileqq.shortvideo.mediaplay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TMMProgressView
  extends FrameLayout
{
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public TMMProgressView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public TMMProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TMMProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setBackgroundColor(-16777216);
    getBackground().setAlpha(70);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext());
    addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(200, 200, 200));
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void setMax(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(paramInt);
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt * 100 / this.jdField_a_of_type_AndroidWidgetProgressBar.getMax() + "%");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediaplay\TMMProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */