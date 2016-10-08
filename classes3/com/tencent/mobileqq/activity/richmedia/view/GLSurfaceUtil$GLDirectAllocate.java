package com.tencent.mobileqq.activity.richmedia.view;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;

public class GLSurfaceUtil$GLDirectAllocate
{
  public GLSurfaceUtil$GLDirectAllocate()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ByteBuffer a(int paramInt1, int paramInt2)
  {
    try
    {
      if (GLSurfaceUtil.c)
      {
        ByteBuffer localByteBuffer1 = CameraGLSurfaceView.allocate(paramInt1, paramInt2);
        GLSurfaceUtil.b = true;
        ByteBuffer localByteBuffer2 = localByteBuffer1;
        if (localByteBuffer1 == null)
        {
          localByteBuffer2 = ByteBuffer.allocateDirect(paramInt2);
          GLSurfaceUtil.b = false;
        }
        return localByteBuffer2;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        localObject = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\GLSurfaceUtil$GLDirectAllocate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */