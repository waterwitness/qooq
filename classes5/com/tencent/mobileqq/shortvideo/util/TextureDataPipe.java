package com.tencent.mobileqq.shortvideo.util;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import usw;

public class TextureDataPipe
{
  public static final String a = "TextureDataPipe";
  private static float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 0;
  public static final int g = 1;
  private static final int h = -32361386;
  public int a;
  public TextureDataPipe.FrameMetaData a;
  private TextureDataPipe.OnFrameAvailableListener jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private usw jdField_a_of_type_Usw;
  private AtomicInteger b = new AtomicInteger(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TextureDataPipe(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData = new TextureDataPipe.FrameMetaData();
    this.jdField_a_of_type_Int = paramInt;
    g();
  }
  
  private void g()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      this.jdField_a_of_type_Usw = new usw(this, localLooper);
      return;
    }
    localLooper = Looper.getMainLooper();
    if (localLooper != null)
    {
      this.jdField_a_of_type_Usw = new usw(this, localLooper);
      return;
    }
    this.jdField_a_of_type_Usw = null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Usw != null)
    {
      localMessage = this.jdField_a_of_type_Usw.obtainMessage();
      localMessage.what = -32361386;
      this.jdField_a_of_type_Usw.sendMessage(localMessage);
    }
    while (!QLog.isColorLevel())
    {
      Message localMessage;
      return;
    }
    QLog.d("TextureDataPipe", 2, "postEventNotifyFrame mEventHandler init is null...");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    boolean bool = true;
    TextureDataPipe.FrameMetaData localFrameMetaData = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData;
    if (paramInt == 1) {}
    for (;;)
    {
      localFrameMetaData.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_a_of_type_JavaLangObject = paramObject;
      return;
      bool = false;
    }
  }
  
  public void a(TextureDataPipe.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener = paramOnFrameAvailableListener;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 16) {
      throw new IllegalArgumentException();
    }
    System.arraycopy(jdField_a_of_type_ArrayOfFloat, 0, paramArrayOfFloat, 0, jdField_a_of_type_ArrayOfFloat.length);
  }
  
  public int b()
  {
    return this.b.getAndSet(1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int c()
  {
    return this.b.getAndAdd(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(2);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\TextureDataPipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */