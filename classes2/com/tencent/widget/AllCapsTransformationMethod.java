package com.tencent.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class AllCapsTransformationMethod
  implements TransformationMethod2
{
  private static final String jdField_a_of_type_JavaLangString = "AllCapsTransformationMethod";
  private Locale jdField_a_of_type_JavaUtilLocale;
  private boolean jdField_a_of_type_Boolean;
  
  public AllCapsTransformationMethod(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.jdField_a_of_type_JavaUtilLocale);
      }
      return null;
    }
    QLog.w("AllCapsTransformationMethod", 2, "Caller did not enable length changes; not transforming text");
    return paramCharSequence;
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\AllCapsTransformationMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */