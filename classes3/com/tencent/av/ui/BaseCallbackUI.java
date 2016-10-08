package com.tencent.av.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gqa;

public class BaseCallbackUI
{
  public static final int a = 1001;
  public static final int b = 1002;
  private static final int d = 30000;
  private static final int e = 400;
  private static final int f = 5;
  public Handler a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private TextView b;
  public int c;
  
  public BaseCallbackUI()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public BaseCallbackUI(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity.findViewById(2131298957));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramActivity.findViewById(2131298961));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramActivity.findViewById(2131298960));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131298958));
    this.b = ((TextView)paramActivity.findViewById(2131298959));
    if (paramInt == 1001)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramActivity.getResources().getString(2131372447));
    }
    for (;;)
    {
      paramActivity = new AlphaAnimation(0.1F, 1.0F);
      paramActivity.setDuration(1000L);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramActivity);
      this.b.startAnimation(paramActivity);
      b();
      this.jdField_a_of_type_JavaLangRunnable = new gqa(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
      return;
      if (paramInt == 1002)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramActivity.getResources().getString(2131372452));
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setEnabled(true);
    if (paramInt == 4)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setEnabled(false);
      this.c = 0;
      return;
    }
    this.c = (paramInt + 1);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[this.c].setEnabled(false);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[5];
    int i = 0;
    while (i < 5)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setEnabled(true);
      i += 1;
    }
    this.c = 0;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[this.c].setEnabled(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\BaseCallbackUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */