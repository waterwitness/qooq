package com.tencent.av.funchat.magicface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ghi;

public abstract class MagicfaceBaseDecoder
{
  public MagicfaceBaseDecoder.MagicPlayListener a;
  MagicfaceBaseDecoder.MagicfaceRenderListener jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener;
  protected MagicfaceData a;
  String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  
  public MagicfaceBaseDecoder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public void a()
  {
    d();
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      new Thread(new ghi(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MagicfaceBaseDecoder", 1, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public void a(MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener = paramMagicPlayListener;
  }
  
  public void a(MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData = paramMagicfaceData;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public abstract void e();
  
  public void f() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceBaseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */