package com.tencent.mobileqq.shortvideo.util;

import android.opengl.EGLContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GlPostProcessThread$FilterInitParam
{
  int jdField_a_of_type_Int;
  EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  Object jdField_a_of_type_JavaLangObject;
  int b;
  
  public GlPostProcessThread$FilterInitParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\GlPostProcessThread$FilterInitParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */