package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import taw;

public abstract class MagicfaceDecoder
{
  public static final int a = 480;
  public static final int b = 640;
  public static final int c = 852;
  public static final int d = 720;
  protected MagicfaceData a;
  public MagicfaceDecoder.MagicPlayListener a;
  public MagicfaceDecoder.MagicfaceRenderListener a;
  public volatile boolean a;
  public int e;
  public int f;
  
  public MagicfaceDecoder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 8;
    this.f = (1000 / this.e);
    g();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.f = (1000 / paramInt);
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData = paramMagicfaceData;
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = paramMagicPlayListener;
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void c() {}
  
  public void d()
  {
    f();
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      new Thread(new taw(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagicfaceDecoder", 2, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\model\MagicfaceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */