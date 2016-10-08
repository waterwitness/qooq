package com.tencent.av.opengl.widgets;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gkd;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class GLYUVTextureView
  extends GLView
{
  public static String a;
  public static String b = "crop-top";
  public static String c = "crop-right";
  public static String d = "crop-bottom";
  public static String e = "stride";
  public static String f = "slice-height";
  private static final String g = "GLYUVTextureView";
  private int jdField_a_of_type_Int;
  private YUVTexture jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = new YUVTexture((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "crop-left";
  }
  
  public GLYUVTextureView(Context paramContext)
  {
    super(paramContext);
    super.a(this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(new gkd(this));
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt % 360)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != paramInt)
      {
        this.jdField_a_of_type_Int = paramInt;
        if (f() == 0) {
          x();
        }
      }
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
  }
  
  public void a(ColorMatrix paramColorMatrix)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramColorMatrix);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.flush(paramBoolean);
    }
  }
  
  public boolean a(ByteBuffer paramByteBuffer, int paramInt1, MediaFormat paramMediaFormat, int paramInt2)
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 16)
    {
      bool1 = false;
      return bool1;
    }
    int i2 = paramMediaFormat.getInteger("width");
    int i1 = paramMediaFormat.getInteger("height");
    int m = paramMediaFormat.getInteger(jdField_a_of_type_JavaLangString);
    int i4 = paramMediaFormat.getInteger(c);
    int i5 = paramMediaFormat.getInteger(b);
    int i3 = paramMediaFormat.getInteger(d);
    int k = paramMediaFormat.getInteger(e);
    int j = paramMediaFormat.getInteger(f);
    int i6 = paramMediaFormat.getInteger("color-format");
    int i = j;
    if (j < i1) {
      i = i1;
    }
    j = k;
    if (k < i2) {
      j = i2;
    }
    int n = i;
    k = i5;
    if (i6 == 2130706688)
    {
      n = i - i5 / 2;
      k = 0;
      m = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLYUVTextureView", 2, "width" + i2 + ",height" + i1 + ",crop_left" + m + ",crop_right" + i4 + ",crop_top" + k + ",crop_bottom" + i3 + ",stride" + j + ",slice_height" + n + ",colorformat" + Integer.toHexString(i6));
    }
    i = j;
    if (j < i2) {
      i = i2;
    }
    if (((2141391876 == i6) || (2130706433 == i6) || (2130706944 == i6)) && (i1 < n)) {}
    for (j = n;; j = i1)
    {
      if (m + i4 + k + i3 == 0)
      {
        m = 0;
        n = i2 - 1;
        i1 -= 1;
        k = 0;
        label346:
        if ((i <= 0) || (j <= 0) || (n <= 0) || (i1 <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GLYUVTextureView", 2, "error decoderInfomations.");
          }
          return false;
        }
      }
      else
      {
        i2 = i4 - m + 1;
        i1 = i3 - k + 1;
        n = i;
        if (i < i2) {
          n = i2;
        }
        if (j >= i1) {
          break label637;
        }
      }
      label637:
      for (i = i1;; i = j)
      {
        j = i;
        i = n;
        n = i4;
        i1 = i3;
        break label346;
        if (QLog.isColorLevel()) {
          QLog.d("GLYUVTextureView", 2, "picWidth: " + i + ", picHeight: " + j + ", winLeft: " + m + ", winRight: " + n + ", winTop: " + k + ", winBottom: " + i1);
        }
        long l1 = SystemClock.elapsedRealtime();
        boolean bool2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.addYUVFrame(paramByteBuffer, paramInt1, i, j, m, n, k, i1, i6, paramInt2);
        long l2 = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d("GLYUVTextureView", 2, "copy data cost time = " + (l2 - l1) + "ms");
        }
        if (bool2)
        {
          x();
          return bool2;
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GLYUVTextureView", 2, "addYUVFrame fail");
        return bool2;
      }
    }
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    Rect localRect = a();
    int j;
    float f1;
    float f5;
    float f6;
    float f2;
    float f4;
    if ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) && (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender()))
    {
      j = g();
      int i = h();
      int k = j - localRect.left - localRect.right;
      int m = localRect.top;
      int n = localRect.bottom;
      j = (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgAngle() + this.jdField_a_of_type_Int + 4) % 4;
      f1 = localRect.left;
      f3 = localRect.top;
      f5 = k;
      f6 = i - m - n;
      if (j % 2 == 0) {
        break label594;
      }
      i = (int)k;
      f2 = f3;
      f4 = f6;
    }
    for (float f3 = f5;; f3 = f6)
    {
      float f7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
      float f8 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
      float f9 = f7 / f8;
      f5 = f4 / f3;
      if (j % 2 == 0)
      {
        f5 = f4 / f9;
        if (f5 > f3)
        {
          f6 = f3 * f9;
          f4 = (f4 - f6) / 2.0F;
          f5 = f3;
          f2 += f4;
          f4 = f6;
          f3 = f1;
          f1 = f5;
          f5 = f4 / f1;
          if (f9 <= f5) {
            break label514;
          }
          f5 *= f8;
          f6 = (f7 - f5) / 2.0F;
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f5, (int)f8);
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c((int)f6);
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d(0);
          label290:
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)f7, (int)f8);
          paramGLCanvas.a(2);
          if (j % 2 == 0) {
            break label564;
          }
          paramGLCanvas.a(-(g() - f1) / 2.0F, -(h() - f4) / 2.0F);
        }
      }
      for (;;)
      {
        paramGLCanvas.b(j * 90, 0.0F, 0.0F, 1.0F);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f4);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)f1);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, (int)f2, (int)f3, (int)f4, (int)f1);
        paramGLCanvas.c();
        return;
        f6 = (f3 - f5) / 2.0F;
        f3 = f5;
        f5 = f1 + f6;
        f1 = f3;
        f3 = f5;
        break;
        f5 = f3 * f9;
        if (f5 > f4)
        {
          f5 = f4 / f9;
          f6 = (f3 - f5) / 2.0F;
          f3 = f5;
          f5 = f1 + f6;
          f1 = f3;
          f3 = f5;
          break;
        }
        f4 = (f4 - f5) / 2.0F;
        f2 += f4;
        f4 = f1;
        f1 = f3;
        f3 = f4;
        f4 = f5;
        break;
        label514:
        f5 = f7 / f5;
        f6 = (f8 - f5) / 2.0F;
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f7, (int)f5);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c(0);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d((int)f6);
        break label290;
        label564:
        paramGLCanvas.a(-(g() - f4) / 2.0F, -(h() - f1) / 2.0F);
      }
      label594:
      f4 = f5;
      f2 = f1;
      f1 = f3;
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\widgets\GLYUVTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */