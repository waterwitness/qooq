package com.tencent.av.opengl.glrenderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gjv;
import gjw;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;
import junit.framework.Assert;

public class GLES11Canvas
  implements GLCanvas
{
  private static final float jdField_a_of_type_Float = 0.95F;
  private static GLId jdField_a_of_type_ComTencentAvOpenglGlrendererGLId = new GLES11Id();
  private static final String jdField_a_of_type_JavaLangString = "GLCanvasImp";
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static float[] jdField_g_of_type_ArrayOfFloat;
  private static final int j = 0;
  private static final int k = 4;
  private static final int l = 6;
  private static final int n = 4;
  private static final int o = 1;
  private static final int p = 0;
  private static final int q = 5;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final IntArray jdField_a_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private gjv jdField_a_of_type_Gjv;
  private gjw jdField_a_of_type_Gjw;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private GL11 jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private final IntArray jdField_b_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private final float[] c = new float[16];
  private final float[] d = new float[4];
  int jdField_e_of_type_Int;
  private final float[] jdField_e_of_type_ArrayOfFloat = new float[4];
  int jdField_f_of_type_Int;
  private final float[] jdField_f_of_type_ArrayOfFloat = new float[32];
  int jdField_g_of_type_Int;
  int h;
  int i;
  private int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    jdField_g_of_type_ArrayOfFloat = new float[4];
  }
  
  public GLES11Canvas(GL11 paramGL11)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11 = paramGL11;
    this.jdField_a_of_type_Gjw = new gjw(paramGL11);
    FloatBuffer localFloatBuffer = a(jdField_a_of_type_ArrayOfFloat.length * 32 / 8).asFloatBuffer();
    localFloatBuffer.put(jdField_a_of_type_ArrayOfFloat, 0, jdField_a_of_type_ArrayOfFloat.length).position(0);
    int[] arrayOfInt = new int[1];
    jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(1, arrayOfInt, 0);
    this.m = arrayOfInt[0];
    paramGL11.glBindBuffer(34962, this.m);
    paramGL11.glBufferData(34962, localFloatBuffer.capacity() * 4, localFloatBuffer, 35044);
    paramGL11.glVertexPointer(2, 5126, 0, 0);
    paramGL11.glTexCoordPointer(2, 5126, 0, 0);
    paramGL11.glClientActiveTexture(33985);
    paramGL11.glTexCoordPointer(2, 5126, 0, 0);
    paramGL11.glClientActiveTexture(33984);
    paramGL11.glEnableClientState(32888);
  }
  
  private int a(Buffer paramBuffer, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(arrayOfInt.length, arrayOfInt, 0);
    int i1 = arrayOfInt[0];
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindBuffer(34962, i1);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    return i1;
  }
  
  private gjv a()
  {
    if (this.jdField_a_of_type_Gjv != null)
    {
      gjv localgjv = this.jdField_a_of_type_Gjv;
      this.jdField_a_of_type_Gjv = localgjv.jdField_a_of_type_Gjv;
      return localgjv;
    }
    return new gjv(null);
  }
  
  private static ByteBuffer a(int paramInt)
  {
    return ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder());
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    float f1 = (1.0F - paramFloat1) * paramFloat2;
    paramFloat1 = paramFloat2 * paramFloat1 / (1.0F - f1) * (paramInt >>> 24) / 65025.0F;
    d((paramInt >>> 16 & 0xFF) * paramFloat1, (paramInt >>> 8 & 0xFF) * paramFloat1, paramFloat1 * (paramInt & 0xFF), f1);
    GL11 localGL11 = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
    localGL11.glTexEnvfv(8960, 8705, this.jdField_e_of_type_ArrayOfFloat, 0);
    localGL11.glTexEnvf(8960, 34161, 34165.0F);
    localGL11.glTexEnvf(8960, 34162, 34165.0F);
    localGL11.glTexEnvf(8960, 34177, 34166.0F);
    localGL11.glTexEnvf(8960, 34193, 768.0F);
    localGL11.glTexEnvf(8960, 34185, 34166.0F);
    localGL11.glTexEnvf(8960, 34201, 770.0F);
    localGL11.glTexEnvf(8960, 34178, 34166.0F);
    localGL11.glTexEnvf(8960, 34194, 770.0F);
    localGL11.glTexEnvf(8960, 34186, 34166.0F);
    localGL11.glTexEnvf(8960, 34202, 770.0F);
  }
  
  private void a(RectF paramRectF)
  {
    e(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  private static void a(RectF paramRectF1, RectF paramRectF2, BasicTexture paramBasicTexture)
  {
    int i1 = paramBasicTexture.h();
    int i2 = paramBasicTexture.i();
    paramRectF1.left /= i1;
    paramRectF1.right /= i1;
    paramRectF1.top /= i2;
    paramRectF1.bottom /= i2;
  }
  
  private void a(BasicTexture paramBasicTexture, int paramInt1, float paramFloat1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat2)
  {
    if (paramFloat1 <= 0.01F)
    {
      a(paramBasicTexture, paramInt2, paramInt3, paramInt4, paramInt5, paramFloat2);
      return;
    }
    if (paramFloat1 >= 1.0F)
    {
      a(paramInt2, paramInt3, paramInt4, paramInt5, paramInt1);
      return;
    }
    gjw localgjw = this.jdField_a_of_type_Gjw;
    if ((this.jdField_a_of_type_Boolean) && ((!paramBasicTexture.b()) || (!Utils.a(paramInt1)) || (paramFloat2 < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localgjw.a(bool);
      if (!b(paramBasicTexture)) {
        break;
      }
      this.jdField_a_of_type_Gjw.a(34160);
      a(paramInt1, paramFloat1, paramFloat2);
      b(paramBasicTexture, paramInt2, paramInt3, paramInt4, paramInt5);
      this.jdField_a_of_type_Gjw.a(7681);
      return;
    }
  }
  
  private void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    gjw localgjw = this.jdField_a_of_type_Gjw;
    if ((this.jdField_a_of_type_Boolean) && ((!paramBasicTexture.b()) || (paramFloat < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localgjw.a(bool);
      if (!b(paramBasicTexture)) {
        break;
      }
      this.jdField_a_of_type_Gjw.b(paramFloat);
      b(paramBasicTexture, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
  
  private void a(gjv paramgjv)
  {
    paramgjv.jdField_a_of_type_Gjv = this.jdField_a_of_type_Gjv;
    this.jdField_a_of_type_Gjv = paramgjv;
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glMatrixMode(5890);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glLoadMatrixf(paramArrayOfFloat, 0);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glMatrixMode(5888);
  }
  
  private static boolean a(float[] paramArrayOfFloat)
  {
    boolean bool = false;
    if ((Math.abs(paramArrayOfFloat[4]) > 1.0E-5F) || (Math.abs(paramArrayOfFloat[1]) > 1.0E-5F) || (paramArrayOfFloat[0] < -1.0E-5F) || (paramArrayOfFloat[5] > 1.0E-5F)) {
      bool = true;
    }
    return bool;
  }
  
  private float[] a(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float[] arrayOfFloat = this.d;
    float f1 = paramArrayOfFloat[0];
    float f2 = paramInt1;
    float f3 = paramArrayOfFloat[4];
    float f4 = paramInt2;
    float f5 = paramArrayOfFloat[12];
    float f6 = paramArrayOfFloat[1];
    float f7 = paramInt1;
    float f8 = paramArrayOfFloat[5];
    float f9 = paramInt2;
    float f10 = paramArrayOfFloat[13];
    float f11 = paramArrayOfFloat[3] * paramInt1 + paramArrayOfFloat[7] * paramInt2 + paramArrayOfFloat[15];
    arrayOfFloat[0] = ((f1 * f2 + f3 * f4 + f5) / f11);
    arrayOfFloat[1] = ((f6 * f7 + f8 * f9 + f10) / f11);
    f1 = paramArrayOfFloat[0];
    f2 = paramInt3;
    f3 = paramArrayOfFloat[4];
    f4 = paramInt4;
    f5 = paramArrayOfFloat[12];
    f6 = paramArrayOfFloat[1];
    f7 = paramInt3;
    f8 = paramArrayOfFloat[5];
    f9 = paramInt4;
    f10 = paramArrayOfFloat[13];
    f11 = paramArrayOfFloat[3] * paramInt3 + paramArrayOfFloat[7] * paramInt4 + paramArrayOfFloat[15];
    arrayOfFloat[2] = ((f1 * f2 + f3 * f4 + f5) / f11);
    arrayOfFloat[3] = ((f6 * f7 + f8 * f9 + f10) / f11);
    return arrayOfFloat;
  }
  
  private void b(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (a(this.jdField_b_of_type_ArrayOfFloat))
    {
      e(0.0F, 0.0F, paramBasicTexture.f() / paramBasicTexture.h(), paramBasicTexture.g() / paramBasicTexture.i());
      c(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    do
    {
      return;
      paramBasicTexture = a(this.jdField_b_of_type_ArrayOfFloat, paramInt1, paramInt2 + paramInt4, paramInt1 + paramInt3, paramInt2);
      paramInt1 = (int)(paramBasicTexture[0] + 0.5F);
      paramInt2 = (int)(paramBasicTexture[1] + 0.5F);
      paramInt3 = (int)(paramBasicTexture[2] + 0.5F) - paramInt1;
      paramInt4 = (int)(paramBasicTexture[3] + 0.5F) - paramInt2;
    } while ((paramInt3 <= 0) || (paramInt4 <= 0));
    ((GL11Ext)this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11).glDrawTexiOES(paramInt1, paramInt2, 0, paramInt3, paramInt4);
    this.i += 1;
  }
  
  private boolean b(BasicTexture paramBasicTexture)
  {
    if (!paramBasicTexture.a(this)) {
      return false;
    }
    int i1 = paramBasicTexture.j();
    this.jdField_a_of_type_Gjw.b(i1);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindTexture(i1, paramBasicTexture.a()[0]);
    return true;
  }
  
  private void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GL11 localGL11 = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
    g();
    a(paramFloat1, paramFloat2);
    b(paramFloat3, paramFloat4, 1.0F);
    localGL11.glLoadMatrixf(this.jdField_b_of_type_ArrayOfFloat, 0);
    localGL11.glDrawArrays(5, 0, 4);
    h();
    this.h += 1;
  }
  
  private void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.jdField_e_of_type_ArrayOfFloat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
    arrayOfFloat[3] = paramFloat4;
  }
  
  private void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glMatrixMode(5890);
    this.c[0] = (paramFloat3 - paramFloat1);
    this.c[5] = (paramFloat4 - paramFloat2);
    this.c[10] = 1.0F;
    this.c[12] = paramFloat1;
    this.c[13] = paramFloat2;
    this.c[15] = 1.0F;
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glLoadMatrixf(this.c, 0);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glMatrixMode(5888);
  }
  
  private void g()
  {
    System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_f_of_type_ArrayOfFloat, 0, 16);
  }
  
  private void h()
  {
    System.arraycopy(this.jdField_f_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0, 16);
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, 1);
  }
  
  public int a(FloatBuffer paramFloatBuffer)
  {
    return a(paramFloatBuffer, 4);
  }
  
  public GLId a()
  {
    return jdField_a_of_type_ComTencentAvOpenglGlrendererGLId;
  }
  
  public TextureProgramFactory a()
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glClear(16384);
  }
  
  public void a(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jdField_b_of_type_Float = paramFloat;
      return;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat[12] += arrayOfFloat[0] * paramFloat1 + arrayOfFloat[4] * paramFloat2;
    arrayOfFloat[13] += arrayOfFloat[1] * paramFloat1 + arrayOfFloat[5] * paramFloat2;
    arrayOfFloat[14] += arrayOfFloat[2] * paramFloat1 + arrayOfFloat[6] * paramFloat2;
    arrayOfFloat[15] += arrayOfFloat[3] * paramFloat1 + arrayOfFloat[7] * paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glClear(16384);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    this.jdField_a_of_type_Gjw.a(paramInt, this.jdField_b_of_type_Float);
    GL11 localGL11 = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
    g();
    a(paramFloat1, paramFloat2);
    b(paramFloat3, paramFloat4, 1.0F);
    localGL11.glLoadMatrixf(this.jdField_b_of_type_ArrayOfFloat, 0);
    localGL11.glDrawArrays(5, 0, 4);
    h();
    this.jdField_f_of_type_Int += 1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    GL11 localGL11 = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
    this.jdField_a_of_type_Gjw.a(paramGLPaint.a(), this.jdField_b_of_type_Float);
    this.jdField_a_of_type_Gjw.a(paramGLPaint.a());
    g();
    a(paramFloat1, paramFloat2);
    b(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, 1.0F);
    localGL11.glLoadMatrixf(this.jdField_b_of_type_ArrayOfFloat, 0);
    localGL11.glDrawArrays(3, 4, 2);
    h();
    this.jdField_e_of_type_Int += 1;
  }
  
  public void a(int paramInt)
  {
    gjv localgjv = a();
    if ((paramInt & 0x1) != 0)
    {
      localgjv.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
      if ((paramInt & 0x2) == 0) {
        break label60;
      }
      System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localgjv.jdField_a_of_type_ArrayOfFloat, 0, 16);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localgjv);
      return;
      localgjv.jdField_a_of_type_Float = -1.0F;
      break;
      label60:
      localgjv.jdField_a_of_type_ArrayOfFloat[0] = Float.NEGATIVE_INFINITY;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jdField_b_of_type_Float = 1.0F;
      Object localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
      ((GL11)localObject).glViewport(0, 0, paramInt1, paramInt2);
      ((GL11)localObject).glMatrixMode(5889);
      ((GL11)localObject).glLoadIdentity();
      GLU.gluOrtho2D((GL10)localObject, 0.0F, paramInt1, 0.0F, paramInt2);
      ((GL11)localObject).glMatrixMode(5888);
      ((GL11)localObject).glLoadIdentity();
      localObject = this.jdField_b_of_type_ArrayOfFloat;
      Matrix.setIdentityM((float[])localObject, 0);
      Matrix.translateM((float[])localObject, 0, 0.0F, paramInt2, 0.0F);
      Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
      return;
    }
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(BasicTexture paramBasicTexture)
  {
    int i1 = paramBasicTexture.f();
    int i2 = paramBasicTexture.g();
    jdField_g_of_type_ArrayOfFloat[0] = 0.0F;
    jdField_g_of_type_ArrayOfFloat[1] = i2;
    jdField_g_of_type_ArrayOfFloat[2] = i1;
    jdField_g_of_type_ArrayOfFloat[3] = (-i2);
    i1 = paramBasicTexture.j();
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindTexture(i1, paramBasicTexture.a()[0]);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexParameterfv(i1, 35741, jdField_g_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexParameteri(i1, 10242, 33071);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexParameteri(i1, 10243, 33071);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexParameterf(i1, 10241, 9729.0F);
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexParameterf(i1, 10240, 9729.0F);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramBasicTexture, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, this.jdField_b_of_type_Float);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    if (paramFloat <= 0.01F)
    {
      a(paramBasicTexture, paramRectF1, paramRectF2);
      return;
    }
    if (paramFloat >= 1.0F)
    {
      a(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height(), paramInt);
      return;
    }
    float f1 = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF1);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramRectF2);
    paramRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramRectF2 = this.jdField_b_of_type_AndroidGraphicsRectF;
    gjw localgjw = this.jdField_a_of_type_Gjw;
    if ((this.jdField_a_of_type_Boolean) && ((!paramBasicTexture.b()) || (!Utils.a(paramInt)) || (f1 < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localgjw.a(bool);
      if (!b(paramBasicTexture)) {
        break;
      }
      this.jdField_a_of_type_Gjw.a(34160);
      a(paramInt, paramFloat, f1);
      a(paramRectF1, paramRectF2, paramBasicTexture);
      a(paramRectF1);
      c(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height());
      this.jdField_a_of_type_Gjw.a(7681);
      return;
    }
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int i1 = paramBasicTexture.j();
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindTexture(i1, paramBasicTexture.a()[0]);
    int i2 = paramBasicTexture.h();
    int i3 = paramBasicTexture.i();
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexImage2D(i1, 0, paramInt1, i2, i3, 0, paramInt1, paramInt2, null);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramBasicTexture, paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_b_of_type_Float);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = this.jdField_b_of_type_Float;
    if (!b(paramBasicTexture)) {
      return;
    }
    gjw localgjw = this.jdField_a_of_type_Gjw;
    if ((this.jdField_a_of_type_Boolean) && ((!paramBasicTexture.b()) || (f1 < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localgjw.a(bool);
      this.jdField_a_of_type_Gjw.b(f1);
      e(0.0F, 0.0F, 1.0F, 1.0F);
      g();
      a(paramInt1, paramInt2);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glLoadMatrixf(this.jdField_b_of_type_ArrayOfFloat, 0);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindBuffer(34962, paramInt3);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glVertexPointer(2, 5126, 0, 0);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindBuffer(34962, paramInt4);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexCoordPointer(2, 5126, 0, 0);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindBuffer(34963, paramInt5);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glDrawElements(5, paramInt6, 5121, 0);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindBuffer(34962, this.m);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glVertexPointer(2, 5126, 0, 0);
      this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glTexCoordPointer(2, 5126, 0, 0);
      h();
      this.jdField_g_of_type_Int += 1;
      return;
    }
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int i1 = paramBasicTexture.j();
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindTexture(i1, paramBasicTexture.a()[0]);
    GLUtils.texSubImage2D(i1, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void a(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int i1 = paramBasicTexture.j();
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11.glBindTexture(i1, paramBasicTexture.a()[0]);
    GLUtils.texImage2D(i1, 0, paramBitmap, 0);
  }
  
  public void a(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF1);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramRectF2);
    paramRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramRectF2 = this.jdField_b_of_type_AndroidGraphicsRectF;
    gjw localgjw = this.jdField_a_of_type_Gjw;
    if ((this.jdField_a_of_type_Boolean) && ((!paramBasicTexture.b()) || (this.jdField_b_of_type_Float < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localgjw.a(bool);
      if (!b(paramBasicTexture)) {
        break;
      }
      a(paramRectF1, paramRectF2, paramBasicTexture);
      a(paramRectF1);
      this.jdField_a_of_type_Gjw.b(this.jdField_b_of_type_Float);
      c(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height());
      return;
    }
  }
  
  public void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    gjw localgjw = this.jdField_a_of_type_Gjw;
    if ((this.jdField_a_of_type_Boolean) && ((!paramBasicTexture.b()) || (this.jdField_b_of_type_Float < 0.95F))) {}
    for (boolean bool = true;; bool = false)
    {
      localgjw.a(bool);
      if (b(paramBasicTexture)) {
        break;
      }
      return;
    }
    a(paramArrayOfFloat);
    this.jdField_a_of_type_Gjw.b(this.jdField_b_of_type_Float);
    c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(float[] paramArrayOfFloat, int paramInt)
  {
    float[] arrayOfFloat = this.jdField_f_of_type_ArrayOfFloat;
    Matrix.multiplyMM(arrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0, paramArrayOfFloat, paramInt);
    System.arraycopy(arrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0, 16);
  }
  
  public boolean a(BasicTexture paramBasicTexture)
  {
    synchronized (this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray)
    {
      if (!paramBasicTexture.c()) {
        return false;
      }
      this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray.a(paramBasicTexture.a()[0]);
      return true;
    }
  }
  
  public void b()
  {
    a(-1);
  }
  
  public void b(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jdField_b_of_type_Float *= paramFloat;
      return;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 == 0.0F) {
      return;
    }
    float[] arrayOfFloat = this.jdField_f_of_type_ArrayOfFloat;
    Matrix.setRotateM(arrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    Matrix.multiplyMM(arrayOfFloat, 16, this.jdField_b_of_type_ArrayOfFloat, 0, arrayOfFloat, 0);
    System.arraycopy(arrayOfFloat, 16, this.jdField_b_of_type_ArrayOfFloat, 0, 16);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    GL11 localGL11 = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11;
    this.jdField_a_of_type_Gjw.a(paramGLPaint.a(), this.jdField_b_of_type_Float);
    this.jdField_a_of_type_Gjw.a(paramGLPaint.a());
    g();
    a(paramFloat1, paramFloat2);
    b(paramFloat3, paramFloat4, 1.0F);
    localGL11.glLoadMatrixf(this.jdField_b_of_type_ArrayOfFloat, 0);
    localGL11.glDrawArrays(2, 6, 4);
    h();
    this.jdField_e_of_type_Int += 1;
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray)
    {
      this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray.a(paramInt);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      throw new IllegalStateException();
    }
    gjv localgjv = (gjv)this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    localgjv.a(this);
    a(localgjv);
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray)
    {
      IntArray localIntArray2 = this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray;
      if (localIntArray2.b() > 0)
      {
        jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11, localIntArray2.b(), localIntArray2.a(), 0);
        localIntArray2.a();
      }
      localIntArray2 = this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray;
      if (localIntArray2.b() > 0)
      {
        jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.b(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL11, localIntArray2.b(), localIntArray2.a(), 0);
        localIntArray2.a();
      }
      return;
    }
  }
  
  public void e()
  {
    String str = String.format("MESH:%d, TEX_OES:%d, TEX_RECT:%d, FILL_RECT:%d, LINE:%d", new Object[] { Integer.valueOf(this.jdField_g_of_type_Int), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.jdField_f_of_type_Int), Integer.valueOf(this.jdField_e_of_type_Int) });
    this.jdField_g_of_type_Int = 0;
    this.h = 0;
    this.i = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GLCanvasImp", 2, str);
    }
  }
  
  public void f() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\glrenderer\GLES11Canvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */