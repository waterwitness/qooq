package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class Sprite
{
  public static final String b;
  public float a;
  public Texture a;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  protected List a;
  public float b;
  public int b;
  private FloatBuffer b;
  public float c;
  public int c;
  public float d;
  public int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = Sprite.class.getName();
  }
  
  public Sprite()
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_d_of_type_Int = 255;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public Sprite(Context paramContext, SpriteGLView paramSpriteGLView, String paramString)
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_d_of_type_Int = 255;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(paramContext, paramSpriteGLView, paramString);
    c();
  }
  
  public Sprite(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_d_of_type_Int = 255;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(paramSpriteGLView, paramBitmap);
    c();
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void a(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(paramSpriteGLView, paramBitmap);
    c();
  }
  
  public void a(Texture paramTexture)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = paramTexture;
    c();
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) {}
    label176:
    do
    {
      return;
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Action localAction = (Action)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localAction.a())
        {
          if ((localAction.n & 0x1) != 0)
          {
            this.jdField_a_of_type_Float = localAction.i;
            this.jdField_b_of_type_Float = localAction.j;
          }
          if ((localAction.n & 0x2) != 0) {
            this.jdField_c_of_type_Float = localAction.jdField_a_of_type_Float;
          }
          if ((localAction.n & 0x4) != 0) {
            this.jdField_d_of_type_Int = localAction.k;
          }
          if ((localAction.n & 0x8) != 0) {
            this.jdField_d_of_type_Float = localAction.l;
          }
        }
        int j = i;
        if (localAction.b)
        {
          if (!localAction.jdField_a_of_type_Boolean) {
            break label176;
          }
          localAction.a();
        }
        for (j = i;; j = i - 1)
        {
          i = j + 1;
          break;
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      paramGL10.glLoadIdentity();
      paramGL10.glOrthof(-paramInt1 / 2, paramInt1 / 2, -paramInt2 / 2, paramInt2 / 2, 1.0F, -1.0F);
      paramGL10.glEnable(3553);
      paramGL10.glEnableClientState(32884);
      paramGL10.glEnableClientState(32888);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.b();
      try
      {
        paramGL10.glBindTexture(3553, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_Int);
        paramGL10.glVertexPointer(2, 5126, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
        paramGL10.glTexCoordPointer(2, 5126, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
        paramGL10.glTranslatef(this.jdField_a_of_type_Float - paramInt1 / 2, paramInt2 / 2 - this.jdField_b_of_type_Float, 0.0F);
        paramGL10.glScalef(this.jdField_c_of_type_Float, this.jdField_c_of_type_Float, 1.0F);
        paramGL10.glRotatef(this.jdField_d_of_type_Float, 0.0F, 0.0F, 1.0F);
        float f = this.jdField_d_of_type_Int / 255.0F;
        paramGL10.glColor4f(f, f, f, f);
        paramGL10.glDrawElements(5, 6, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
        return;
      }
      catch (Exception paramGL10) {}
    } while (!QLog.isColorLevel());
    QLog.d(jdField_b_of_type_JavaLangString, 2, QLog.getStackTraceString(paramGL10));
  }
  
  public void a(Action... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Action localAction = paramVarArgs[i];
      localAction.a();
      this.jdField_a_of_type_JavaUtilList.add(localAction);
      i += 1;
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(new float[] { -this.jdField_b_of_type_Int / 2, -this.jdField_c_of_type_Int / 2, this.jdField_b_of_type_Int / 2, -this.jdField_c_of_type_Int / 2, -this.jdField_b_of_type_Int / 2, this.jdField_c_of_type_Int / 2, this.jdField_b_of_type_Int / 2, this.jdField_c_of_type_Int / 2 });
    localByteBuffer = ByteBuffer.allocateDirect(12);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(new short[] { 0, 1, 2, 1, 2, 3 });
    localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F });
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\gl\Sprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */