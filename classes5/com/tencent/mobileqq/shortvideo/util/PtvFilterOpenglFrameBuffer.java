package com.tencent.mobileqq.shortvideo.util;

import android.opengl.GLES20;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PtvFilterOpenglFrameBuffer
{
  public static final boolean a = false;
  private int jdField_a_of_type_Int;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  private boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt;
  private int[] d;
  
  public PtvFilterOpenglFrameBuffer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_b_of_type_ArrayOfInt = new int[1];
    this.jdField_c_of_type_ArrayOfInt = new int[1];
    this.d = new int[1];
  }
  
  public static void a(String paramString) {}
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterOpenglFrameBuffer", 2, paramString);
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      GLES20.glGenRenderbuffers(1, this.jdField_c_of_type_ArrayOfInt, 0);
      a("glGenRenderbuffers");
      GLES20.glBindRenderbuffer(36161, this.jdField_c_of_type_ArrayOfInt[0]);
      a("glBindRenderbuffer:0");
      GLES20.glRenderbufferStorage(36161, 33189, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      a("glRenderbufferStorage:0");
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.jdField_c_of_type_ArrayOfInt[0]);
      a("glFramebufferRenderbuffer:0");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      GLES20.glGenRenderbuffers(1, this.d, 0);
      a("glGenRenderbuffers");
      GLES20.glBindRenderbuffer(36161, this.d[0]);
      a("glBindRenderbuffer:0");
      GLES20.glRenderbufferStorage(36161, 36168, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, this.d[0]);
    }
  }
  
  public void a()
  {
    GLES20.glBindFramebuffer(36160, this.jdField_b_of_type_ArrayOfInt[0]);
  }
  
  public void a(int paramInt)
  {
    a();
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    a("glFramebufferTexture2D");
    paramInt = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt != 36053) {
      a("glCheckFramebufferStatus: status=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, paramInt1);
    a("glBindTexture");
    GLES20.glTexParameteri(3553, 10240, 9728);
    a("glTexParameteri");
    GLES20.glTexParameteri(3553, 10241, 9728);
    a("glTexParameteri");
    GLES20.glTexParameteri(3553, 10242, 33071);
    a("glTexParameteri");
    GLES20.glTexParameteri(3553, 10243, 33071);
    a("glTexParameteri");
    GLES20.glTexImage2D(3553, 0, 6408, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 6408, 5121, null);
    a("glTexImage2D");
    GLES20.glBindTexture(3553, 0);
    a("glBindTexture");
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    a("glIsTexture");
    GLES20.glGenFramebuffers(1, this.jdField_b_of_type_ArrayOfInt, 0);
    a("glGenFramebuffers");
    GLES20.glBindFramebuffer(36160, this.jdField_b_of_type_ArrayOfInt[0]);
    a("glBindFramebuffer");
    d();
    return true;
  }
  
  public void b()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void c()
  {
    b();
    if (this.jdField_b_of_type_Boolean) {
      GLES20.glDeleteRenderbuffers(1, this.jdField_c_of_type_ArrayOfInt, 0);
    }
    if (this.jdField_c_of_type_Boolean) {
      GLES20.glDeleteRenderbuffers(1, this.d, 0);
    }
    GLES20.glDeleteFramebuffers(1, this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_b_of_type_ArrayOfInt[0] = 0;
    this.jdField_c_of_type_ArrayOfInt[0] = 0;
    this.d[0] = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\PtvFilterOpenglFrameBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */