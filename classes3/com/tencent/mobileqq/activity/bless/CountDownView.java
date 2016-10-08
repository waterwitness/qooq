package com.tencent.mobileqq.activity.bless;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import ogk;

public class CountDownView
  extends ImageView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130837973, 2130837972, 2130837971 };
  private int jdField_a_of_type_Int;
  private CountDownView.CountDownFinishedListener jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView$CountDownFinishedListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ogk(this);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CountDownView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    AudioUtil.a();
    AudioUtil.a(2131165203, 1, null, null);
  }
  
  public void a()
  {
    post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    setVisibility(0);
  }
  
  public void b()
  {
    setImageResource(jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_Boolean = false;
    Handler localHandler = getHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_Int = 0;
    setVisibility(4);
  }
  
  public void setListener(CountDownView.CountDownFinishedListener paramCountDownFinishedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView$CountDownFinishedListener = paramCountDownFinishedListener;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\CountDownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */