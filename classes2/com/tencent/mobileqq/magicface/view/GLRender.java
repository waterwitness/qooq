package com.tencent.mobileqq.magicface.view;

import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.model.MagicFaceGLDisplayer;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tbf;

public class GLRender
  implements GLSurfaceView.Renderer
{
  public static final String a;
  private MagicFaceGLDisplayer jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer;
  private tbf jdField_a_of_type_Tbf;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GLRender.class.getSimpleName();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func copyFrame2Render begins, datas:" + paramArrayOfByte1);
    }
    tbf localtbf = new tbf(this);
    if (localtbf.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean)) {}
    try
    {
      this.jdField_a_of_type_Tbf = null;
      this.jdField_a_of_type_Tbf = localtbf;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func copyFrame2Render ends, mCurData:" + this.jdField_a_of_type_Tbf);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: getstatic 26	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 39	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   19: ldc 72
    //   21: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   38: ifnull +10 -> 48
    //   41: aload_0
    //   42: getfield 74	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer	Lcom/tencent/mobileqq/magicface/model/MagicFaceGLDisplayer;
    //   45: ifnonnull +53 -> 98
    //   48: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +44 -> 95
    //   54: getstatic 26	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: iconst_2
    //   58: new 39	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   65: ldc 76
    //   67: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   74: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: ldc 78
    //   79: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 74	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer	Lcom/tencent/mobileqq/magicface/model/MagicFaceGLDisplayer;
    //   86: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: aload_0
    //   99: getfield 74	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer	Lcom/tencent/mobileqq/magicface/model/MagicFaceGLDisplayer;
    //   102: aload_0
    //   103: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   106: getfield 81	tbf:jdField_a_of_type_ArrayOfByte	[B
    //   109: aload_0
    //   110: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   113: getfield 84	tbf:jdField_b_of_type_ArrayOfByte	[B
    //   116: aload_0
    //   117: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   120: getfield 88	tbf:c	I
    //   123: aload_0
    //   124: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   127: getfield 90	tbf:d	I
    //   130: aload_0
    //   131: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   134: getfield 92	tbf:jdField_a_of_type_Int	I
    //   137: aload_0
    //   138: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   141: getfield 94	tbf:jdField_b_of_type_Int	I
    //   144: aload_0
    //   145: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   148: getfield 97	tbf:jdField_a_of_type_Float	F
    //   151: aload_0
    //   152: getfield 66	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_Tbf	Ltbf;
    //   155: getfield 99	tbf:jdField_a_of_type_Boolean	Z
    //   158: invokevirtual 103	com/tencent/mobileqq/magicface/model/MagicFaceGLDisplayer:a	([B[BIIIIFZ)V
    //   161: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq -69 -> 95
    //   167: getstatic 26	com/tencent/mobileqq/magicface/view/GLRender:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   170: iconst_2
    //   171: ldc 105
    //   173: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: goto -81 -> 95
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	GLRender
    //   0	184	1	paramGL10	GL10
    // Exception table:
    //   from	to	target	type
    //   2	34	179	finally
    //   34	48	179	finally
    //   48	95	179	finally
    //   98	176	179	finally
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onSurfaceCreated begins");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer = new MagicFaceGLDisplayer();
      this.jdField_a_of_type_Tbf = null;
      paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func onSurfaceCreated ends");
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\view\GLRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */