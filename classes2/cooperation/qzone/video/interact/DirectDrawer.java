package cooperation.qzone.video.interact;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class DirectDrawer
{
  static float[] jdField_a_of_type_ArrayOfFloat;
  static float[] jdField_b_of_type_ArrayOfFloat;
  static float[] jdField_c_of_type_ArrayOfFloat;
  static final float[] jdField_d_of_type_ArrayOfFloat = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private static final int e = 2;
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString = "attribute vec4 vPosition;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 texCoord;\nvoid main()\n{\ngl_Position = vPosition;\ntexCoord = inputTextureCoordinate;\n}\n";
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  private short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 0, 2, 3 };
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 texCoord;\nuniform samplerExternalOES s_texture;\nvoid main() {\nvec2 coord = texCoord - vec2(0.5, 0.5);\nfloat factor=0.485;\nfloat scale = 1.0/(0.49-factor);\nfloat radius = length(coord);\nvec4 color = texture2D( s_texture, vec2(0.75*texCoord.x,texCoord.y) );\nfloat stepA = 1.0-step(0.49, radius);\nfloat stepB = 1.0-step(factor, radius);\nvec4 innerColor = stepB * color;\nvec4 midColor = (stepA-stepB) * (1.0-(radius-factor) * scale) * color;\ngl_FragColor = innerColor + midColor;\n}";
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private final int f = 8;
  private int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    c = new float[] { 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  }
  
  public DirectDrawer(int paramInt, byte paramByte)
  {
    this.g = paramInt;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(this.jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(jdField_d_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    a(paramByte);
    this.jdField_b_of_type_JavaNioFloatBuffer.put(c);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
    paramInt = a(35633, "attribute vec4 vPosition;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 texCoord;\nvoid main()\n{\ngl_Position = vPosition;\ntexCoord = inputTextureCoordinate;\n}\n");
    int i = a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 texCoord;\nuniform samplerExternalOES s_texture;\nvoid main() {\nvec2 coord = texCoord - vec2(0.5, 0.5);\nfloat factor=0.485;\nfloat scale = 1.0/(0.49-factor);\nfloat radius = length(coord);\nvec4 color = texture2D( s_texture, vec2(0.75*texCoord.x,texCoord.y) );\nfloat stepA = 1.0-step(0.49, radius);\nfloat stepB = 1.0-step(factor, radius);\nvec4 innerColor = stepB * color;\nvec4 midColor = (stepA-stepB) * (1.0-(radius-factor) * scale) * color;\ngl_FragColor = innerColor + midColor;\n}");
    this.jdField_a_of_type_Int = GLES20.glCreateProgram();
    GLES20.glAttachShader(this.jdField_a_of_type_Int, paramInt);
    GLES20.glAttachShader(this.jdField_a_of_type_Int, i);
    GLES20.glLinkProgram(this.jdField_a_of_type_Int);
    Log.d("Shader", "Program : " + GLES20.glGetProgramInfoLog(this.jdField_a_of_type_Int));
  }
  
  private int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    Log.i("Shader", GLES20.glGetShaderInfoLog(paramInt));
    return paramInt;
  }
  
  private static float[] a(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = (1.0F - paramArrayOfFloat[i]);
      arrayOfFloat[(i + 1)] = paramArrayOfFloat[(i + 1)];
      i += 2;
    }
    return arrayOfFloat;
  }
  
  private static float[] b(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i];
      arrayOfFloat[(i + 1)] = (1.0F - paramArrayOfFloat[(i + 1)]);
      i += 2;
    }
    return arrayOfFloat;
  }
  
  public void a(byte paramByte)
  {
    if ((paramByte & 0x1) != 0) {}
    for (float[] arrayOfFloat = jdField_d_of_type_ArrayOfFloat;; arrayOfFloat = jdField_b_of_type_ArrayOfFloat)
    {
      c = arrayOfFloat;
      if ((paramByte & 0x4) != 0) {
        c = b(c);
      }
      if ((paramByte & 0x2) != 0) {
        c = a(c);
      }
      return;
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.g);
    this.jdField_b_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "vPosition");
    GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "inputTextureCoordinate");
    GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
    GLES20.glDrawElements(4, this.jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
    GLES20.glDisableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\interact\DirectDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */