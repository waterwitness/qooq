package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class SVFilterEncodeDoubleCache$SharedMemoryCache
{
  public int a;
  private long jdField_a_of_type_Long;
  public CameraFilterGLView.SharedMemWriteFile a;
  public ByteBuffer a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public SVFilterEncodeDoubleCache$SharedMemoryCache(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.b = 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 * paramInt2 * paramInt3;
    if ((this.jdField_a_of_type_Boolean) && (this.b == i) && (this.jdField_a_of_type_JavaNioByteBuffer != null)) {
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    try
    {
      this.jdField_a_of_type_Long = PtvFilterUtils.getNativePtrIndex(paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Long == 0L) {
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
      }
      try
      {
        this.jdField_a_of_type_JavaNioByteBuffer = PtvFilterUtils.allocateSharedMem(this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
          return false;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaNioByteBuffer = null;
        }
        this.jdField_a_of_type_Boolean = true;
        this.b = i;
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\SVFilterEncodeDoubleCache$SharedMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */