package com.tencent.mobileqq.activity.converse;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BaseBanner
{
  int jdField_a_of_type_Int;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  
  public BaseBanner()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = null;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public View a(Context paramContext)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean a(int paramInt)
  {
    if (this.d == paramInt) {
      return false;
    }
    a(paramInt);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\converse\BaseBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */