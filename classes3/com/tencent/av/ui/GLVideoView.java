package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLPaint;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.texture.StringTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YuvFboTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import guf;
import gug;

public class GLVideoView
  extends GLView
{
  public static final float a = 1.1111112F;
  protected static final long a = 80L;
  private static final String jdField_b_of_type_JavaLangString = "GLVideoView";
  protected int a;
  protected Context a;
  protected Matrix a;
  protected RectF a;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private GLPaint jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint;
  protected BasicTexture a;
  protected StringTexture a;
  private YUVTexture jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture;
  public Runnable a;
  protected String a;
  protected boolean a;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  protected float b;
  protected int b;
  protected long b;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  protected RectF b;
  protected BasicTexture b;
  protected boolean b;
  protected int c;
  protected RectF c;
  protected boolean c;
  int d;
  protected boolean d;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private float o;
  private float p;
  
  public GLVideoView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = true;
    this.o = 1.0F;
    this.p = 5.0F;
    this.jdField_a_of_type_ArrayOfFloat = new float[9];
    this.i = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Float = 20.0F;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = Integer.MAX_VALUE;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new gug(this);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint = new GLPaint();
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = new YuvFboTexture(this.jdField_a_of_type_AndroidContentContext, this);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(new guf(this));
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_INSIDE;
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493914);
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_e_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE) {
        if (!this.g) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgAngle() % 2 == 0) && (super.g() > super.h())) {
            return false;
          }
        } while ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgAngle() % 2 == 0) || (super.g() >= super.h()));
        return false;
      } while (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_CROP);
      return false;
      if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_INSIDE) {
        break;
      }
    } while ((this.g) || (paramInt % 2 == 0));
    while (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_CROP) {
      return false;
    }
    return false;
  }
  
  public float a()
  {
    return this.o;
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public PointF a()
  {
    PointF localPointF = new PointF();
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    localPointF.x = this.jdField_a_of_type_ArrayOfFloat[2];
    localPointF.y = this.jdField_a_of_type_ArrayOfFloat[5];
    return localPointF;
  }
  
  public ImageView.ScaleType a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  public YUVTexture a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.a();
  }
  
  public void a(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    int k = super.g();
    int m = super.h();
    if (this.jdField_f_of_type_Int == 1) {
      paramInt1 = k - paramInt1;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat, paramFloat, paramInt2, paramInt1);
      this.jdField_b_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      float f1 = this.jdField_a_of_type_ArrayOfFloat[0];
      float f2 = this.o * 1.0F / 1.1111112F;
      float f3 = this.p;
      if ((f1 <= f2) || (f1 >= f3 * 1.1111112F))
      {
        return;
        if (this.jdField_f_of_type_Int == 2)
        {
          paramInt2 = m - paramInt2;
          k -= paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = k;
          continue;
        }
        if (this.jdField_f_of_type_Int == 3) {
          paramInt2 = m - paramInt2;
        }
      }
      else
      {
        this.jdField_a_of_type_ArrayOfFloat[0] = f1;
        this.jdField_a_of_type_ArrayOfFloat[4] = f1;
        this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
        if (QLog.isColorLevel()) {
          QLog.d("GLVideoView", 2, "setScale scale: " + paramFloat + ", x: " + paramInt2 + ", y: " + paramInt1 + ", newScale: " + f1);
        }
        super.x();
        return;
      }
      k = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = k;
    }
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
      if (this.jdField_f_of_type_Int != paramInt)
      {
        this.jdField_f_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        if (f() == 0) {
          super.x();
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
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setTranslation x: " + paramInt1 + ", y: " + paramInt2 + ", isEnd: " + paramBoolean);
    }
    if (this.jdField_f_of_type_Int == 1) {
      paramInt1 = -paramInt1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      float f2 = this.jdField_a_of_type_ArrayOfFloat[2] + paramInt2;
      float f3 = this.jdField_a_of_type_ArrayOfFloat[5] + paramInt1;
      this.jdField_a_of_type_ArrayOfFloat[2] = f2;
      this.jdField_a_of_type_ArrayOfFloat[5] = f3;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
      RectF localRectF;
      float f1;
      if (paramBoolean)
      {
        localRectF = new RectF();
        this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
        if ((localRectF.left >= this.jdField_a_of_type_AndroidGraphicsRectF.left) || (localRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
          break label369;
        }
        if (localRectF.width() <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) {
          break label348;
        }
        f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.right - localRectF.right);
        label213:
        if ((localRectF.top >= this.jdField_a_of_type_AndroidGraphicsRectF.top) || (localRectF.bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom)) {
          break label541;
        }
        if (localRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
          break label520;
        }
        f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.bottom - localRectF.bottom);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfFloat[2] = f1;
        this.jdField_a_of_type_ArrayOfFloat[5] = f2;
        this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
        super.x();
        return;
        if (this.jdField_f_of_type_Int == 2)
        {
          paramInt1 = -paramInt1;
          k = -paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = k;
          break;
        }
        if (this.jdField_f_of_type_Int != 3) {
          break label692;
        }
        paramInt2 = -paramInt2;
        break;
        label348:
        f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX());
        break label213;
        label369:
        if ((localRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) && (localRectF.right > this.jdField_a_of_type_AndroidGraphicsRectF.right))
        {
          if (localRectF.width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
          {
            f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.left - localRectF.left);
            break label213;
          }
          f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX());
          break label213;
        }
        f1 = f2;
        if (localRectF.left <= this.jdField_a_of_type_AndroidGraphicsRectF.left) {
          break label213;
        }
        f1 = f2;
        if (localRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
          break label213;
        }
        f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX());
        break label213;
        label520:
        f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY());
        continue;
        label541:
        if ((localRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top) && (localRectF.bottom > this.jdField_a_of_type_AndroidGraphicsRectF.bottom))
        {
          if (localRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
            f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.top - localRectF.top);
          } else {
            f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY());
          }
        }
        else
        {
          f2 = f3;
          if (localRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top)
          {
            f2 = f3;
            if (localRectF.bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
              f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY());
            }
          }
        }
      }
      label692:
      int k = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = k;
    }
  }
  
  public void a(ColorMatrix paramColorMatrix)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramColorMatrix);
    }
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setScaleType scaleType: " + paramScaleType);
    }
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != localScaleType)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = localScaleType;
      super.x();
    }
  }
  
  protected void a(GLCanvas paramGLCanvas)
  {
    if (!this.i) {
      this.i = false;
    }
    int k = super.g();
    int m = super.h();
    Rect localRect = super.a();
    int n = k - localRect.left - localRect.right;
    int i1 = m - localRect.top - localRect.bottom;
    if (this.jdField_e_of_type_Int == -1) {
      this.jdField_e_of_type_Int = Utils.a(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_e_of_type_Int == 1)
    {
      if (((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture == null) || (!a()) || (!this.i)) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)) {
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, n, i1);
      }
      return;
    }
    paramGLCanvas.a(-k / 2, -m / 2);
    if (this.h)
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label674;
      }
      if ((localRect.left > 0) && (localRect.top > 0) && (localRect.right > 0) && (localRect.bottom > 0))
      {
        float f1 = localRect.left / 2.0F;
        float f2 = localRect.top / 2.0F;
        float f3 = localRect.right / 2.0F;
        float f4 = localRect.bottom / 2.0F;
        float f5 = localRect.left * 3 / 4.0F;
        float f6 = m - localRect.bottom;
        float f7 = k - f3;
        float f8 = localRect.top * 3 / 4.0F;
        float f9 = k - localRect.right * 3 / 4.0F;
        float f10 = m - localRect.bottom * 3 / 4.0F;
        float f11 = localRect.left / 4.0F;
        float f12 = localRect.top / 4.0F;
        float f13 = k - localRect.right / 4.0F;
        float f14 = m - localRect.bottom / 4.0F;
        float f15 = m - f4;
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(-1);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f1);
        paramGLCanvas.a(f5, localRect.top, f5, f6, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f2);
        paramGLCanvas.a(f1, f8, f7, f8, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f3);
        paramGLCanvas.a(f9, localRect.top, f9, f6, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f4);
        paramGLCanvas.a(f1, f10, f7, f10, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(1140850688);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f1);
        paramGLCanvas.a(f11, f2, f11, f15, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f2);
        paramGLCanvas.a(0.0F, f12, k, f12, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f3);
        paramGLCanvas.a(f13, f2, f13, f15, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(f4);
        paramGLCanvas.a(0.0F, f14, k, f14, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
    }
    for (;;)
    {
      paramGLCanvas.a(k / 2, m / 2);
      if (!this.h) {
        break label922;
      }
      if (((a()) && (this.i)) || (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture == null)) {
        break;
      }
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, n, i1);
      return;
      label674:
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(-1);
      if (localRect.left > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.left);
        paramGLCanvas.a(localRect.left / 2, 0.0F, localRect.left / 2, m, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.top > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.top);
        paramGLCanvas.a(0.0F, localRect.top / 2, k, localRect.top / 2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.right > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.right);
        paramGLCanvas.a(k - localRect.right / 2, 0.0F, k - localRect.right / 2, m, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.bottom > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.bottom);
        paramGLCanvas.a(0.0F, m - localRect.bottom / 2, k, m - localRect.bottom / 2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
    }
    paramGLCanvas.a(0, 0, n, i1, this.K);
    return;
    label922:
    if (((!a()) || (!this.i)) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null))
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, k, m);
      return;
    }
    paramGLCanvas.a(0.0F, 0.0F, k, m, this.K);
  }
  
  public void a(Boolean paramBoolean)
  {
    this.h = paramBoolean.booleanValue();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setText text: " + paramString);
    }
    if (((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString))) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_d_of_type_Boolean = true;
      super.x();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setIsPC mIsPC: " + this.g + ", isPC: " + paramBoolean);
    }
    this.g = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    super.x();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      return this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender();
    }
    return false;
  }
  
  public float b()
  {
    return this.p;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    if (paramInt != 0) {
      this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture = new ResourceTexture(this.jdField_a_of_type_AndroidContentContext, paramInt);
    }
    super.x();
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    Rect localRect = super.a();
    int i1;
    int i3;
    int m;
    int k;
    int i2;
    int i4;
    float f2;
    float f5;
    float f6;
    int n;
    float f4;
    float f3;
    if ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) && (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender()) && (this.i))
    {
      e(false);
      i1 = super.g();
      i3 = super.h();
      m = i1 - localRect.left - localRect.right;
      k = i3 - localRect.top - localRect.bottom;
      i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgAngle();
      i4 = (this.jdField_f_of_type_Int + i2 + 4) % 4;
      f2 = localRect.left;
      f1 = localRect.top;
      f5 = m;
      f6 = k;
      if (i4 % 2 == 0) {
        break label1557;
      }
      n = (int)m;
      m = k;
      k = n;
      f4 = f1;
      f3 = f6;
    }
    for (float f1 = f5;; f1 = f6)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f4, f2, m + f4, k + f2);
      f6 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
      float f7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
      float f8 = f6 / f7;
      f5 = f3 / f1;
      boolean bool = a(i4);
      if (bool) {
        if (i4 % 2 == 0)
        {
          f5 = f3 / f8;
          if (f5 > f1)
          {
            f5 = f1 * f8;
            f4 += (f3 - f5) / 2.0F;
            f3 = f5;
            f5 = f3 / f1;
          }
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidGraphicsRectF.set(f4, f2, f3 + f4, f1 + f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
        if (f8 > f5)
        {
          f2 = f5 * f7;
          f1 = f2;
          if (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
            f1 = f2 * f6 / Utils.a((int)f6);
          }
          f2 = (f6 - f1) / 2.0F;
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f1, (int)f7);
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c((int)f2);
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d(0);
          label382:
          if (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1)
          {
            this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f6, (int)f7);
            this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c(0);
            this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d((int)0.0F);
          }
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)f6, (int)f7);
          paramGLCanvas.a(2);
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_f_of_type_Int % 2 != 0) {
              break label1186;
            }
            paramGLCanvas.b(-1.0F, 1.0F, 1.0F);
          }
          label470:
          paramGLCanvas.b(i4 * 90, 0.0F, 0.0F, 1.0F);
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
          if (this.jdField_e_of_type_Boolean) {
            break label1200;
          }
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, (int)(this.jdField_c_of_type_AndroidGraphicsRectF.left - (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_AndroidGraphicsRectF.width()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.left), (int)(this.jdField_c_of_type_AndroidGraphicsRectF.top - (this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_c_of_type_AndroidGraphicsRectF.height()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.top), (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
          label614:
          paramGLCanvas.c();
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null))
          {
            this.jdField_a_of_type_Int %= 360;
            k = super.g();
            m = super.h();
            i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.f();
            n = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.g();
            if (i1 <= k) {
              break label1547;
            }
          }
        }
        for (;;)
        {
          if (n > m) {}
          for (;;)
          {
            paramGLCanvas.a(2);
            this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, k, m);
            paramGLCanvas.c();
            long l = System.currentTimeMillis();
            if (l - this.jdField_b_of_type_Long >= 80L)
            {
              this.jdField_b_of_type_Long = l;
              this.jdField_a_of_type_Int += 8;
            }
            if (this.j)
            {
              if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture != null)
              {
                k = super.g();
                super.h();
                m = localRect.left;
                n = localRect.right;
                i1 = localRect.left;
                i1 = localRect.bottom;
                this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, k - m - n, 36);
              }
              if (this.jdField_d_of_type_Boolean)
              {
                if (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture == null) {
                  this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture = new StringTexture();
                }
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a();
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(this.jdField_a_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(this.jdField_b_of_type_Float);
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.e(this.jdField_b_of_type_Int);
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.f(this.jdField_c_of_type_Int);
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.g(super.g());
                this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.e();
                this.jdField_d_of_type_Boolean = false;
              }
              if ((this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
              {
                n = super.g();
                i1 = super.h();
                i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.f();
                i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.g();
                if (!this.jdField_c_of_type_Boolean) {
                  break label1511;
                }
                k = 8;
                m = i1 - i3 - 8;
              }
            }
            for (;;)
            {
              paramGLCanvas.a(2);
              paramGLCanvas.a((i2 - n) / 2, (i3 - i1) / 2);
              this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(paramGLCanvas, k, m, i2, i3);
              paramGLCanvas.c();
              return;
              f2 += (f1 - f5) / 2.0F;
              f1 = f5;
              break;
              f5 = f1 * f8;
              if (f5 > f3)
              {
                f5 = f3 / f8;
                f2 += (f1 - f5) / 2.0F;
                f1 = f5;
                break;
              }
              f4 += (f3 - f5) / 2.0F;
              f3 = f5;
              break;
              f2 = f6 / f5;
              f1 = f2;
              if (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
                f1 = f2 * f7 / Utils.a((int)f7);
              }
              f2 = (f7 - f1) / 2.0F;
              this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f6, (int)f1);
              this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c(0);
              this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d((int)f2);
              break label382;
              label1186:
              paramGLCanvas.b(1.0F, -1.0F, 1.0F);
              break label470;
              label1200:
              if ((i1 < i3) && (bool))
              {
                f1 = this.jdField_c_of_type_AndroidGraphicsRectF.height();
                if (i2 == 3) {
                  f1 = this.jdField_c_of_type_AndroidGraphicsRectF.width();
                }
                k = (int)((i3 - f1) / 2.0F);
                if (k > this.jdField_d_of_type_Int)
                {
                  k -= this.jdField_d_of_type_Int;
                  label1262:
                  n = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.left - (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_AndroidGraphicsRectF.width()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.left);
                  i1 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.top - (this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_c_of_type_AndroidGraphicsRectF.height()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.top);
                  if (i2 != 0) {
                    break label1381;
                  }
                  m = -k;
                }
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, n, m, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
                  break;
                  k = 0;
                  break label1262;
                  label1381:
                  if (i2 == 2)
                  {
                    m = k;
                  }
                  else
                  {
                    m = i1;
                    if (i2 == 3)
                    {
                      n = -k;
                      m = i1;
                    }
                  }
                }
              }
              this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, (int)(this.jdField_c_of_type_AndroidGraphicsRectF.left - (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_AndroidGraphicsRectF.width()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.left), (int)(this.jdField_c_of_type_AndroidGraphicsRectF.top - (this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_c_of_type_AndroidGraphicsRectF.height()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.top), (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
              break label614;
              label1511:
              if (this.jdField_f_of_type_Boolean)
              {
                k = 8;
                m = 8;
              }
              else
              {
                k = 30;
                m = 70;
              }
            }
            m = n;
          }
          label1547:
          k = i1;
        }
      }
      label1557:
      f3 = f5;
      f4 = f2;
      f2 = f1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setMirror mMirror: " + this.jdField_a_of_type_Boolean + ", mirror: " + paramBoolean);
    }
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      super.x();
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public float c()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setTextSize textSize: " + paramFloat);
    }
    if (this.jdField_b_of_type_Float != paramFloat)
    {
      this.jdField_b_of_type_Float = paramFloat;
      this.jdField_d_of_type_Boolean = true;
      super.x();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setMaxLength maxLength: " + paramInt);
    }
    if ((paramInt > 0) && (this.jdField_c_of_type_Int != paramInt))
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_d_of_type_Boolean = true;
      super.x();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setTextInBottom inBottom: " + paramBoolean);
    }
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      super.x();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public float d()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setTextColor textColor: 0x" + Integer.toHexString(paramInt).toUpperCase());
    }
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_d_of_type_Boolean = true;
      super.x();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "showText showText: " + paramBoolean + ", mShowText: " + this.j);
    }
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      super.x();
    }
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void e(boolean paramBoolean)
  {
    GLRootView localGLRootView;
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GLVideoView", 2, "enableLoading loading: " + paramBoolean + ", mLoading: " + this.jdField_b_of_type_Boolean);
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label106;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture == null) {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = new ResourceTexture(this.jdField_a_of_type_AndroidContentContext, 2130839261);
      }
      localGLRootView = a();
      if (localGLRootView != null) {
        localGLRootView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    label106:
    do
    {
      return;
      localGLRootView = a();
    } while (localGLRootView == null);
    localGLRootView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean e()
  {
    return this.j;
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.flush(paramBoolean);
    }
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void finalize()
  {
    super.finalize();
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = null;
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_Boolean = false;
    this.j = false;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "setNeedRenderVideo bRender: " + paramBoolean + ", mNeedRenderVideo: " + this.i);
    }
    this.i = paramBoolean;
    super.x();
  }
  
  public boolean g()
  {
    return this.i;
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean h()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\GLVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */