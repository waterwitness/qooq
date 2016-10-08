package com.tencent.av.opengl.glrenderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.opengl.program.DrawProgram;
import com.tencent.av.opengl.program.MeshProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class GLES20Canvas
  implements GLCanvas
{
  public static final float a = 0.95F;
  private static final GLId jdField_a_of_type_ComTencentAvOpenglGlrendererGLId = new GLES20Id();
  private static final String jdField_a_of_type_JavaLangString;
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private static final int jdField_e_of_type_Int = 4;
  private static final int jdField_f_of_type_Int = 2;
  private static final int jdField_g_of_type_Int = 8;
  private static final int jdField_h_of_type_Int = 4;
  private static final int jdField_i_of_type_Int = 2;
  private static final int j = 4;
  private static final int k = 0;
  private static final int l = 4;
  private static final int m = 6;
  private static final int n = 8;
  private static final int o = 16;
  private static final int u = 0;
  private static final int v = 1;
  private int A;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private DrawProgram jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram;
  private MeshProgram jdField_a_of_type_ComTencentAvOpenglProgramMeshProgram;
  TextureProgramFactory jdField_a_of_type_ComTencentAvOpenglProgramTextureProgramFactory;
  private IntArray jdField_a_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(12);
  float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private final int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private float[][] jdField_a_of_type_Array2dOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 16 });
  private float jdField_b_of_type_Float = 3.0F;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private final IntArray jdField_b_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private float jdField_c_of_type_Float;
  private final IntArray jdField_c_of_type_ComTencentAvOpenglUtilsIntArray = new IntArray();
  private float[] jdField_c_of_type_ArrayOfFloat = new float[8];
  private float jdField_d_of_type_Float = 180.0F;
  private float[] jdField_d_of_type_ArrayOfFloat = new float[16];
  private float jdField_e_of_type_Float;
  private float[] jdField_e_of_type_ArrayOfFloat = new float[16];
  private float[] jdField_f_of_type_ArrayOfFloat;
  private final float[] jdField_g_of_type_ArrayOfFloat;
  private final float[] jdField_h_of_type_ArrayOfFloat;
  private final float[] jdField_i_of_type_ArrayOfFloat;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int w = -1;
  private int x;
  private int y;
  private int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GLES20Canvas.class.getSimpleName();
    jdField_b_of_type_ArrayOfFloat = new float[] { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  }
  
  public GLES20Canvas()
  {
    this.g = new float[32];
    this.h = new float[4];
    this.i = new float[16];
    Matrix.setIdentityM(this.i, 0);
    this.jdField_c_of_type_ArrayOfFloat[this.p] = 1.0F;
    this.t = a(a(jdField_b_of_type_ArrayOfFloat));
    this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram = new DrawProgram();
    this.jdField_a_of_type_ComTencentAvOpenglProgramMeshProgram = new MeshProgram();
    GLES20.glBlendFunc(1, 771);
    Utils.a();
  }
  
  private int a(Buffer paramBuffer, int paramInt)
  {
    jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(1, this.jdField_a_of_type_ArrayOfInt, 0);
    Utils.a();
    int i1 = this.jdField_a_of_type_ArrayOfInt[0];
    GLES20.glBindBuffer(34962, i1);
    Utils.a();
    GLES20.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    Utils.a();
    return i1;
  }
  
  private static FloatBuffer a(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat, 0, paramArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.frustumM(this.jdField_d_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a());
    Utils.a();
    if (paramFloat > 0.0F)
    {
      GLES20.glLineWidth(paramFloat);
      Utils.a();
    }
    float[] arrayOfFloat = a(paramInt2);
    if (arrayOfFloat[3] < 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      if (bool)
      {
        GLES20.glBlendColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
        Utils.a();
      }
      GLES20.glUniform4fv(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a()[2].a, 1, arrayOfFloat, 0);
      a(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a(), paramInt1);
      Utils.a();
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, float paramFloat5)
  {
    a(paramInt2, paramInt4, paramFloat5);
    a(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a(), paramInt1, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint.a(), paramGLPaint.a());
  }
  
  private void a(RectF paramRectF)
  {
    this.i[0] = paramRectF.width();
    this.i[5] = paramRectF.height();
    this.i[12] = paramRectF.left;
    this.i[13] = paramRectF.top;
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
  
  private static void a(BasicTexture paramBasicTexture, RectF paramRectF)
  {
    int i1 = paramBasicTexture.d();
    int i2 = paramBasicTexture.e();
    int i3 = paramBasicTexture.f();
    int i4 = paramBasicTexture.g();
    paramRectF.set(i1, i2, i3 + i1, i4 + i2);
  }
  
  private void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, RectF paramRectF)
  {
    ShaderParameter[] arrayOfShaderParameter = paramBasicTexture.a(this);
    a(arrayOfShaderParameter, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, paramArrayOfFloat, 0);
    Utils.a();
    if (paramBasicTexture.a())
    {
      a(2);
      a(0.0F, paramRectF.centerY());
      b(1.0F, -1.0F, 1.0F);
      a(0.0F, -paramRectF.centerY());
    }
    a(arrayOfShaderParameter, 5, 4, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
    if (paramBasicTexture.a()) {
      c();
    }
    this.y += 1;
  }
  
  private static void a(String paramString, float[] paramArrayOfFloat, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    int i1 = 0;
    while (i1 < 16)
    {
      paramString.append(' ');
      if (i1 % 4 == 0) {
        paramString.append('\n');
      }
      paramString.append(paramArrayOfFloat[(paramInt + i1)]);
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      Utils.a();
      return;
    }
    GLES20.glDisable(3042);
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    h();
    a(paramFloat1, paramFloat2, 0.0F);
    b(paramFloat3, paramFloat4, 1.0F);
    GLES20.glUniformMatrix4fv(paramArrayOfShaderParameter[1].a, 1, false, a(), 0);
    i();
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, int paramInt)
  {
    GLES20.glBindBuffer(34962, this.t);
    Utils.a();
    GLES20.glVertexAttribPointer(paramArrayOfShaderParameter[0].a, 2, 5126, false, 8, paramInt * 8);
    Utils.a();
    GLES20.glBindBuffer(34962, 0);
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramArrayOfShaderParameter, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int i1 = paramArrayOfShaderParameter[0].a;
    GLES20.glEnableVertexAttribArray(i1);
    Utils.a();
    GLES20.glDrawArrays(paramInt1, 0, paramInt2);
    Utils.a();
    GLES20.glDisableVertexAttribArray(i1);
    Utils.a();
  }
  
  private float[] a()
  {
    Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_e_of_type_ArrayOfFloat, 0, this.f, 0);
    Matrix.multiplyMM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  private float[] a(int paramInt)
  {
    float f1 = (paramInt >>> 24 & 0xFF) / 255.0F * a();
    float f2 = (paramInt >>> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >>> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    this.h[0] = (f2 * f1);
    this.h[1] = (f3 * f1);
    this.h[2] = (f4 * f1);
    this.h[3] = f1;
    return this.h;
  }
  
  private void b(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    a(paramRectF1);
    a(paramBasicTexture, this.i, paramRectF2);
  }
  
  public float a()
  {
    return this.jdField_c_of_type_ArrayOfFloat[this.p];
  }
  
  public int a()
  {
    return this.r;
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
    if (this.jdField_a_of_type_ComTencentAvOpenglProgramTextureProgramFactory == null) {
      this.jdField_a_of_type_ComTencentAvOpenglProgramTextureProgramFactory = new TextureProgramFactory();
    }
    return this.jdField_a_of_type_ComTencentAvOpenglProgramTextureProgramFactory;
  }
  
  public void a()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Utils.a();
    GLES20.glClear(16384);
    Utils.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_ArrayOfFloat[this.p] = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.f, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    Utils.a();
    GLES20.glClear(16384);
    Utils.a();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.jdField_e_of_type_Float = paramFloat3;
    Matrix.setLookAtM(this.jdField_e_of_type_ArrayOfFloat, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    a(5, 0, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 0.0F);
    this.z += 1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(3, 4, 2, paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramGLPaint);
    this.A += 1;
  }
  
  public void a(int paramInt)
  {
    int i2 = 0;
    int i1;
    float f1;
    if ((paramInt & 0x1) == 1)
    {
      i1 = 1;
      if (i1 != 0)
      {
        f1 = a();
        this.p += 1;
        if (this.jdField_c_of_type_ArrayOfFloat.length <= this.p) {
          if (Build.VERSION.SDK_INT < 9) {
            break label119;
          }
        }
      }
    }
    label119:
    float[] arrayOfFloat;
    for (this.jdField_c_of_type_ArrayOfFloat = Arrays.copyOf(this.jdField_c_of_type_ArrayOfFloat, this.jdField_c_of_type_ArrayOfFloat.length * 2);; this.jdField_c_of_type_ArrayOfFloat = arrayOfFloat)
    {
      this.jdField_c_of_type_ArrayOfFloat[this.p] = f1;
      i1 = i2;
      if ((paramInt & 0x2) == 2) {
        i1 = 1;
      }
      if (i1 != 0) {
        h();
      }
      this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray.a(paramInt);
      return;
      i1 = 0;
      break;
      arrayOfFloat = new float[this.jdField_c_of_type_ArrayOfFloat.length * 2];
      i1 = 0;
      while (i1 < this.jdField_c_of_type_ArrayOfFloat.length)
      {
        arrayOfFloat[i1] = this.jdField_c_of_type_ArrayOfFloat[i1];
        i1 += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.r = paramInt1;
    this.s = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    g();
    a(-paramInt1 / 4, paramInt1 / 4, -paramInt2 / 4, paramInt2 / 4, paramInt2, 1000000.0F);
    a(0.0F, 0.0F, paramInt2 * 2, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    a(0.0F, paramInt2 / 2, 0.0F);
    b(1.0F, -1.0F, 1.0F);
    a(-paramInt1 / 2, 0.0F, 0.0F);
    Utils.a();
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect.left = Math.round(this.g[16]);
    paramRect.right = Math.round(this.g[20]);
    paramRect.top = Math.round(this.g[17]);
    paramRect.bottom = Math.round(this.g[21]);
    paramRect.sort();
  }
  
  public void a(BasicTexture paramBasicTexture)
  {
    int i2 = paramBasicTexture.j();
    int[] arrayOfInt = paramBasicTexture.a();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.a()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLES20.glTexParameteri(i2, 10242, 33071);
    GLES20.glTexParameteri(i2, 10243, 33071);
    GLES20.glTexParameterf(i2, 10241, 9729.0F);
    GLES20.glTexParameterf(i2, 10240, 9729.0F);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramBasicTexture, this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5);
    a(paramBasicTexture, paramInt1, paramFloat, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    a(1);
    float f1 = a();
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    a((1.0F - paramFloat) * f1);
    a(paramBasicTexture, paramRectF1, paramRectF2);
    a(f1 * paramFloat);
    a(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height(), paramInt);
    c();
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int i2 = paramBasicTexture.j();
    int[] arrayOfInt = paramBasicTexture.a();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.a()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLES20.glTexImage2D(i2, 0, paramInt1, paramBasicTexture.h(), paramBasicTexture.i(), 0, paramInt1, paramInt2, null);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    a(paramBasicTexture, this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, paramBasicTexture);
    b(paramBasicTexture, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return;
    }
    paramBasicTexture.a(this);
    GLES20.glBindBuffer(34963, paramInt5);
    Utils.a();
    GLES20.glBindBuffer(34962, paramInt3);
    Utils.a();
    paramInt3 = this.jdField_a_of_type_ComTencentAvOpenglProgramMeshProgram.a()[0].a;
    GLES20.glVertexAttribPointer(paramInt3, 2, 5126, false, 8, 0);
    Utils.a();
    GLES20.glBindBuffer(34962, paramInt4);
    Utils.a();
    paramInt4 = this.jdField_a_of_type_ComTencentAvOpenglProgramMeshProgram.a()[2].a;
    GLES20.glVertexAttribPointer(paramInt4, 2, 5126, false, 8, 0);
    Utils.a();
    GLES20.glBindBuffer(34962, 0);
    Utils.a();
    GLES20.glEnableVertexAttribArray(paramInt3);
    Utils.a();
    GLES20.glEnableVertexAttribArray(paramInt4);
    Utils.a();
    a(this.jdField_a_of_type_ComTencentAvOpenglProgramMeshProgram.a(), paramInt1, paramInt2, 1.0F, 1.0F);
    GLES20.glDrawElements(5, paramInt6, 5121, 0);
    Utils.a();
    GLES20.glDisableVertexAttribArray(paramInt3);
    Utils.a();
    GLES20.glDisableVertexAttribArray(paramInt4);
    Utils.a();
    GLES20.glBindBuffer(34963, 0);
    Utils.a();
    this.x += 1;
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int i2 = paramBasicTexture.j();
    int[] arrayOfInt = paramBasicTexture.a();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.a()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLUtils.texSubImage2D(i2, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void a(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int i2 = paramBasicTexture.j();
    int[] arrayOfInt = paramBasicTexture.a();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.a()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLUtils.texImage2D(i2, 0, paramBitmap, 0);
  }
  
  public void a(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF1);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramRectF2);
    a(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, paramBasicTexture);
    b(paramBasicTexture, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(paramBasicTexture, paramArrayOfFloat, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public void a(float[] paramArrayOfFloat, int paramInt) {}
  
  public boolean a(BasicTexture paramBasicTexture)
  {
    boolean bool = paramBasicTexture.c();
    if (bool) {}
    for (;;)
    {
      synchronized (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray)
      {
        paramBasicTexture = paramBasicTexture.a();
        if (paramBasicTexture != null) {
          break label68;
        }
        return bool;
        if (i1 < paramBasicTexture.length)
        {
          this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray.a(paramBasicTexture[i1]);
          i1 += 1;
          continue;
        }
        return bool;
      }
      return bool;
      label68:
      int i1 = 0;
    }
  }
  
  public int b()
  {
    return this.s;
  }
  
  public void b()
  {
    a(-1);
  }
  
  public void b(float paramFloat)
  {
    a(a() * paramFloat);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.f, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.f, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(2, 6, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint);
    this.A += 1;
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray)
    {
      this.jdField_c_of_type_ComTencentAvOpenglUtilsIntArray.a(paramInt);
      return;
    }
  }
  
  public void c()
  {
    int i2 = 1;
    int i3 = this.jdField_a_of_type_ComTencentAvOpenglUtilsIntArray.a();
    if ((i3 & 0x1) == 1)
    {
      i1 = 1;
      if (i1 != 0) {
        this.p -= 1;
      }
      if ((i3 & 0x2) != 2) {
        break label67;
      }
    }
    label67:
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.q -= 16;
        i();
      }
      return;
      i1 = 0;
      break;
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray)
    {
      IntArray localIntArray2 = this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray;
      if (this.jdField_b_of_type_ComTencentAvOpenglUtilsIntArray.b() > 0)
      {
        jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.a(null, localIntArray2.b(), localIntArray2.a(), 0);
        localIntArray2.a();
      }
      localIntArray2 = this.jdField_c_of_type_ComTencentAvOpenglUtilsIntArray;
      if (localIntArray2.b() > 0)
      {
        jdField_a_of_type_ComTencentAvOpenglGlrendererGLId.b(null, localIntArray2.b(), localIntArray2.a(), 0);
        localIntArray2.a();
      }
      return;
    }
  }
  
  public void e()
  {
    String str = String.format("MESH:%d, TEX_RECT:%d, FILL_RECT:%d, LINE:%d", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.z), Integer.valueOf(this.A) });
    this.x = 0;
    this.y = 0;
    this.z = 0;
    this.A = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, str);
    }
  }
  
  public void f()
  {
    GLES20.glViewport(0, 0, this.r, this.s);
    GLES20.glDisable(2929);
    GLES20.glBlendFunc(1, 771);
    Utils.a();
  }
  
  public void g()
  {
    this.f = new float[16];
    Matrix.setRotateM(this.f, 0, 0.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void h()
  {
    this.w += 1;
    int i1 = 0;
    while (i1 < 16)
    {
      this.jdField_a_of_type_Array2dOfFloat[this.w][i1] = this.f[i1];
      i1 += 1;
    }
  }
  
  public void i()
  {
    int i1 = 0;
    while (i1 < 16)
    {
      this.f[i1] = this.jdField_a_of_type_Array2dOfFloat[this.w][i1];
      i1 += 1;
    }
    this.w -= 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\glrenderer\GLES20Canvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */