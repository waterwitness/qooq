package com.tencent.av.opengl.texture;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.GlStringParser;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLId;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import gjx;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class YUVTexture
  extends BasicTexture
{
  private static String jdField_a_of_type_JavaLangString = "YUVTexture";
  public static float[] a;
  static boolean jdField_b_of_type_Boolean = false;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public float a;
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private GlStringParser jdField_a_of_type_ComTencentAvOpenglGlStringParser;
  private YUVTexture.GLRenderListener jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$GLRenderListener;
  private gjx jdField_a_of_type_Gjx;
  boolean jdField_a_of_type_Boolean = false;
  public float b;
  private long jdField_b_of_type_Long;
  protected float[] b;
  public float c;
  private boolean c;
  private int mNativeContext;
  protected int u;
  public int v = -1;
  private int w;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 9.3E-4F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 9.9E-4F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  }
  
  public YUVTexture(Context paramContext)
  {
    super(null, 0);
    this.jdField_b_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 9.3E-4F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 9.9E-4F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
    this.jdField_a_of_type_Float = 1.2F;
    this.jdField_b_of_type_Float = 1.93F;
    this.jdField_c_of_type_Float = 1.05F;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (!jdField_b_of_type_Boolean) {}
    try
    {
      SoLoadUtil.a(paramContext, "xplatform", 0, false);
      jdField_b_of_type_Boolean = true;
      Looper localLooper1 = Looper.myLooper();
      if (localLooper1 != null)
      {
        this.jdField_a_of_type_Gjx = new gjx(this, localLooper1);
        if (!jdField_b_of_type_Boolean) {}
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          Init(Utils.a(paramContext), new WeakReference(this));
          return;
        }
        catch (Exception paramContext)
        {
          Looper localLooper2;
          paramContext.printStackTrace();
          return;
        }
        catch (Error paramContext)
        {
          paramContext.printStackTrace();
        }
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
        localUnsatisfiedLinkError.printStackTrace();
        continue;
        localLooper2 = Looper.getMainLooper();
        if (localLooper2 != null) {
          this.jdField_a_of_type_Gjx = new gjx(this, localLooper2);
        } else {
          this.jdField_a_of_type_Gjx = null;
        }
      }
    }
  }
  
  static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    paramObject1 = (YUVTexture)((WeakReference)paramObject1).get();
    if (paramObject1 != null)
    {
      if (paramInt != 0) {
        break label27;
      }
      ((YUVTexture)paramObject1).a(0, 0, paramObject2);
    }
    label27:
    do
    {
      return;
      if (paramInt == 2)
      {
        ((YUVTexture)paramObject1).a(2, 0, paramObject2);
        return;
      }
      if (paramInt == 1)
      {
        ((YUVTexture)paramObject1).a(1, 0, paramObject2);
        return;
      }
    } while (paramInt != 3);
    ((YUVTexture)paramObject1).a(3, 0, paramObject2);
  }
  
  native void Init(int paramInt, Object paramObject);
  
  native void Uninit();
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  /* Error */
  public int a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 155	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc -100
    //   15: invokestatic 160	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   18: sipush 3553
    //   21: sipush 10240
    //   24: ldc -95
    //   26: invokestatic 160	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   29: sipush 3553
    //   32: sipush 10242
    //   35: ldc -94
    //   37: invokestatic 160	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   40: sipush 3553
    //   43: sipush 10243
    //   46: ldc -94
    //   48: invokestatic 160	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   51: aload_0
    //   52: getfield 82	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   55: invokevirtual 168	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: iload_1
    //   59: invokevirtual 174	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 180	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload_3
    //   70: invokevirtual 185	java/io/InputStream:close	()V
    //   73: aload 4
    //   75: ifnull +61 -> 136
    //   78: sipush 3553
    //   81: iconst_0
    //   82: aload 4
    //   84: iconst_0
    //   85: invokestatic 191	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   88: aload 4
    //   90: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   100: goto -27 -> 73
    //   103: astore 4
    //   105: aload_3
    //   106: invokevirtual 185	java/io/InputStream:close	()V
    //   109: iconst_m1
    //   110: ireturn
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   116: goto -7 -> 109
    //   119: astore 4
    //   121: aload_3
    //   122: invokevirtual 185	java/io/InputStream:close	()V
    //   125: aload 4
    //   127: athrow
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   133: goto -8 -> 125
    //   136: iconst_m1
    //   137: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	YUVTexture
    //   0	138	1	paramInt1	int
    //   0	138	2	paramInt2	int
    //   62	8	3	localInputStream	java.io.InputStream
    //   95	11	3	localIOException1	java.io.IOException
    //   111	11	3	localIOException2	java.io.IOException
    //   128	2	3	localIOException3	java.io.IOException
    //   67	22	4	localBitmap	android.graphics.Bitmap
    //   103	1	4	localOutOfMemoryError	OutOfMemoryError
    //   119	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	73	95	java/io/IOException
    //   63	69	103	java/lang/OutOfMemoryError
    //   105	109	111	java/io/IOException
    //   63	69	119	finally
    //   121	125	128	java/io/IOException
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_Gjx != null)
    {
      paramObject = this.jdField_a_of_type_Gjx.obtainMessage(paramInt1, 0, 0, paramObject);
      if (paramInt2 == 0) {
        this.jdField_a_of_type_Gjx.sendMessage((Message)paramObject);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_Gjx.sendMessageDelayed((Message)paramObject, paramInt2);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "notifyUpdateUI|mEventHandler == null");
  }
  
  public void a(ColorMatrix paramColorMatrix)
  {
    paramColorMatrix = paramColorMatrix.getArray();
    float[] arrayOfFloat = new float[16];
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      if (j < 4)
      {
        if (i == 3) {
          arrayOfFloat[(i * 4 + j)] = paramColorMatrix[(j * 5 + i + 1)];
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfFloat[(i * 4 + j)] = paramColorMatrix[(j * 5 + i)];
        }
      }
      i += 1;
    }
    Matrix.multiplyMM(this.jdField_b_of_type_ArrayOfFloat, 0, arrayOfFloat, 0, jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public void a(YUVTexture.GLRenderListener paramGLRenderListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$GLRenderListener = paramGLRenderListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(GLCanvas paramGLCanvas)
  {
    if (!c())
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[3];
      }
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = paramGLCanvas.a().a();
        i += 1;
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      this.u = uploadContent(this.jdField_a_of_type_ArrayOfInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "YUVTexture yuvFormat: " + this.u + " isBind " + this.jdField_c_of_type_Boolean);
    }
    GLES20.glUniform1i(a(paramGLCanvas).a()[10].a, this.u);
    this.h = 1;
    if ((this.jdField_a_of_type_Boolean) && (this.v == -1))
    {
      this.v = paramGLCanvas.a().a();
      this.v = a(2130838580, this.v);
    }
    return true;
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = a(paramGLCanvas);
    paramGLCanvas = super.a(paramGLCanvas);
    try
    {
      GLES20.glUniform1f(localTextureProgram.a()[7].a, getImgWidth());
      GLES20.glUniform1f(localTextureProgram.a()[8].a, getImgHeight());
      GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].a, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
      if ((this.jdField_a_of_type_Boolean) && (this.v != -1))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glActiveTexture(33987);
        Utils.a();
        GLES20.glBindTexture(j(), this.v);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[11].a, 3);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[12].a, 1);
        Utils.a();
      }
      return paramGLCanvas;
    }
    catch (Exception localException) {}
    return paramGLCanvas;
  }
  
  public native boolean addYUVFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public native boolean addYuvFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public float c()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public int c()
  {
    return 1;
  }
  
  public native boolean canRender();
  
  public native void flush(boolean paramBoolean);
  
  native int getFrameCount();
  
  native int getFrameIndex();
  
  public native int getImgAngle();
  
  public native int getImgHeight();
  
  public native int getImgWidth();
  
  public int j()
  {
    return 3553;
  }
  
  public native void onPause();
  
  public native void onResume();
  
  native int uploadContent(int[] paramArrayOfInt);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\YUVTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */