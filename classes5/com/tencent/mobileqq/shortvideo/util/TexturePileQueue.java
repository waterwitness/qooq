package com.tencent.mobileqq.shortvideo.util;

import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class TexturePileQueue
{
  public static final int a = 0;
  private static final int b = 3;
  private static final int c = 0;
  private static final int d = 1;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int[] jdField_a_of_type_ArrayOfInt;
  private TextureDataPipe[] jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe;
  
  public TexturePileQueue()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe = new TextureDataPipe[3];
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public TextureDataPipe a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length) {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].b() == 0)
      {
        localTextureDataPipe = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
        localTextureDataPipe.d();
      }
    }
    for (;;)
    {
      return localTextureDataPipe;
      i += 1;
      break;
      localTextureDataPipe = null;
    }
  }
  
  public void a()
  {
    int i = 0;
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i] = new TextureDataPipe(this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void a(TextureDataPipe.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    if (b())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a(paramOnFrameAvailableListener);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public TextureDataPipe b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() != 0)
      {
        i += 1;
        break;
      }
      localTextureDataPipe = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
      localTextureDataPipe.d();
    }
    for (;;)
    {
      return localTextureDataPipe;
      localTextureDataPipe = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i] != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].b();
          this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i] = null;
        }
        this.jdField_a_of_type_ArrayOfInt[i] = 0;
        i += 1;
      }
    }
  }
  
  public TextureDataPipe c()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!b()) {}
    int i;
    label16:
    do
    {
      return (TextureDataPipe)localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length);
    TextureDataPipe localTextureDataPipe;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() == 2)
    {
      localTextureDataPipe = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
      if (localObject1 == null) {
        localObject1 = localTextureDataPipe;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      AVIOStruct localAVIOStruct = (AVIOStruct)((TextureDataPipe)localObject1).a.a;
      localObject2 = (AVIOStruct)localTextureDataPipe.a.a;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        ((TextureDataPipe)localObject1).c();
        localObject1 = localTextureDataPipe;
      }
    }
  }
  
  public TextureDataPipe d()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!b()) {}
    int i;
    do
    {
      return (TextureDataPipe)localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe.length);
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i].a() == 2)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoUtilTextureDataPipe[i];
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      AVIOStruct localAVIOStruct1 = (AVIOStruct)((TextureDataPipe)localObject1).a.a;
      AVIOStruct localAVIOStruct2 = (AVIOStruct)((TextureDataPipe)localObject2).a.a;
      long l = localAVIOStruct1.vFrameTime;
      if (localAVIOStruct2.vFrameTime < l) {
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\TexturePileQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */