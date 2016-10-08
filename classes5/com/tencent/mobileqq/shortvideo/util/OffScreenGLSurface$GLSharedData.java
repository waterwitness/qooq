package com.tencent.mobileqq.shortvideo.util;

import android.opengl.EGLContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OffScreenGLSurface$GLSharedData
{
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  public TexturePileQueue a;
  private Object jdField_a_of_type_JavaLangObject;
  
  public OffScreenGLSurface$GLSharedData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = null;
      return;
    }
  }
  
  public void a(EGLContext paramEGLContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\OffScreenGLSurface$GLSharedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */