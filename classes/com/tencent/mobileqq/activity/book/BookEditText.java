package com.tencent.mobileqq.activity.book;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.UnsupportedEncodingException;
import ogl;

public class BookEditText
  extends EditText
{
  private int jdField_a_of_type_Int = 80;
  private BookEditText.BookEditTextInputListener jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText$BookEditTextInputListener;
  private boolean jdField_a_of_type_Boolean;
  private InputFilter[] jdField_a_of_type_ArrayOfAndroidTextInputFilter = { new ogl(this) };
  
  public BookEditText(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BookEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setInputType(131072);
    setSingleLine(false);
    setHorizontallyScrolling(false);
    setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      int i = paramString.toString().getBytes("utf8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramString.toString().getBytes().length;
  }
  
  public void setCanInputWhenLenghtLimit(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setInputListener(BookEditText.BookEditTextInputListener paramBookEditTextInputListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText$BookEditTextInputListener = paramBookEditTextInputListener;
  }
  
  public void setTextLengthLimit(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\book\BookEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */