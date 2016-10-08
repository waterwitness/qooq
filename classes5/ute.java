import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.qphone.base.util.QLog;

public class ute
  extends utf
{
  static final int jdField_a_of_type_Int = 1;
  static final int b = 3;
  static final int c = 25;
  static final int i = 25;
  float jdField_a_of_type_Float;
  public boolean a;
  public boolean b;
  public boolean c;
  int d;
  int e;
  public int f;
  int g;
  public int h;
  
  public ute(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = -1;
    this.jdField_a_of_type_Float = 0.0F;
    this.b = false;
    this.e = 0;
    this.c = true;
    this.g = 0;
    this.g = 0;
  }
  
  public int a()
  {
    return this.j + this.g;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.left = this.j;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.right = (this.j + this.k);
    int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.top;
    int k = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.bottom;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.bottom = this.h;
    if (this.jdField_a_of_type_Boolean) {
      a(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.top = j;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect.bottom = k;
      super.a(paramCanvas);
      return;
      a(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsBitmap);
    }
  }
  
  void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
      }
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    paramCanvas.drawBitmap(paramBitmap, null, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(false);
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "isUpRealEvent,preAction = " + this.d);
    }
    if (this.d == 0) {}
    while ((this.d == 2) && (b())) {
      return true;
    }
    return false;
  }
  
  public boolean a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "checkBounds,x = " + paramFloat + ",x_coord = " + this.j + ",x_coord + length = " + (this.j + this.k));
    }
    return (paramFloat > this.j - 25) && (paramFloat < this.j + this.k + 25);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    int j = paramMotionEvent.getAction();
    switch (j)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.b = true;
        this.d = j;
        this.jdField_a_of_type_Float = f1;
        this.e = 0;
        this.jdField_a_of_type_Boolean = false;
        return true;
        this.f = ((int)(f1 - this.jdField_a_of_type_Float));
        this.d = j;
        this.jdField_a_of_type_Float = f1;
        this.e += 1;
        this.c = false;
      } while (!c());
      this.j += this.f;
      return true;
    }
    this.b = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.c = true;
    return true;
  }
  
  boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "isMoveToUpEvent,moveCount = " + this.e + ",diff = " + this.f);
    }
    if (this.f < 0) {}
    for (int j = -this.f; (this.e == 1) && (j <= 1); j = this.f) {
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.f < 0) {}
    for (int j = -this.f; j > 1; j = this.f) {
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */