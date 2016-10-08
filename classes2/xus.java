import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class xus
{
  public int a;
  public Bitmap a;
  public int b;
  
  public xus(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(paramInt1, paramInt2);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.jdField_a_of_type_Int = (paramInt1 - i / 2);
    this.b = (paramInt2 - j / 2);
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.b, paramPaint);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */