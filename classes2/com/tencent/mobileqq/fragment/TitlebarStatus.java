package com.tencent.mobileqq.fragment;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TitlebarStatus
{
  public int a;
  public View.OnClickListener a;
  public BaseFragment a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public String e;
  
  public TitlebarStatus(BaseFragment paramBaseFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment = paramBaseFragment;
  }
  
  public TitlebarStatus a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public TitlebarStatus a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public TitlebarStatus a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public TitlebarStatus a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    return this;
  }
  
  public TitlebarStatus a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public TitlebarStatus b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public TitlebarStatus b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public TitlebarStatus c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\TitlebarStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */