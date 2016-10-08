package com.tencent.av.opengl.glrenderer;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

public class GLES11Id
  implements GLId
{
  private static int jdField_a_of_type_Int = 1;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      int i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      return i;
    }
  }
  
  public void a(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    localObject = jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      int i = paramInt1 - 1;
      if (paramInt1 > 0) {}
      try
      {
        paramInt1 = jdField_a_of_type_Int;
        jdField_a_of_type_Int = paramInt1 + 1;
        paramArrayOfInt[(paramInt2 + i)] = paramInt1;
        paramInt1 = i;
      }
      finally {}
    }
  }
  
  public void a(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramGL11.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
  }
  
  public void a(GL11ExtensionPack paramGL11ExtensionPack, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramGL11ExtensionPack.glDeleteFramebuffersOES(paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
  }
  
  public int[] a(int paramInt)
  {
    return null;
  }
  
  public void b(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramGL11.glDeleteBuffers(paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\glrenderer\GLES11Id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */