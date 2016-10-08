package com.tencent.av.opengl.glrenderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.texture.BasicTexture;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public abstract interface GLCanvas
{
  public static final int a = 36197;
  public static final int b = -1;
  public static final int c = 1;
  public static final int d = 2;
  
  public abstract float a();
  
  public abstract int a(ByteBuffer paramByteBuffer);
  
  public abstract int a(FloatBuffer paramFloatBuffer);
  
  public abstract GLId a();
  
  public abstract TextureProgramFactory a();
  
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(BasicTexture paramBasicTexture);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4);
  
  public abstract void a(BasicTexture paramBasicTexture, Bitmap paramBitmap);
  
  public abstract void a(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2);
  
  public abstract void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(float[] paramArrayOfFloat, int paramInt);
  
  public abstract boolean a(BasicTexture paramBasicTexture);
  
  public abstract void b();
  
  public abstract void b(float paramFloat);
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint);
  
  public abstract void b(int paramInt);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\glrenderer\GLCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */