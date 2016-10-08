package com.tencent.mobileqq.activity.converse;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NetworkBanner
  extends BaseBanner
{
  public static final int e = 0;
  public static final int f = 1;
  private TextView a;
  
  public NetworkBanner(View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 100;
    this.b = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public View a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(paramContext, 2130903419, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297821));
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramInt == 1) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370154);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370153);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\converse\NetworkBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */