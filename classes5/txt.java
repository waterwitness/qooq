import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class txt
  extends BitmapDrawable
{
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static int h;
  private static int i;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AccelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int g;
  
  public txt(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Float = 0.5F;
    this.jdField_b_of_type_Int = 50;
    this.jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator = new AccelerateInterpolator(1.5F);
  }
  
  public static txt[] a(int paramInt, Resources paramResources, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramResources != null))
    {
      txt[] arrayOftxt2 = new txt[paramInt];
      i = paramBitmap.getWidth() / 2;
      h = paramBitmap.getHeight() / 2;
      int j = 0;
      for (;;)
      {
        arrayOftxt1 = arrayOftxt2;
        if (j >= paramInt) {
          break;
        }
        arrayOftxt2[j] = new txt(paramResources, paramBitmap);
        j += 1;
      }
    }
    txt[] arrayOftxt1 = null;
    return arrayOftxt1;
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Float = ((float)paramLong);
    this.jdField_a_of_type_Int = paramInt;
    this.g = 1;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int j = k;
    switch (this.g)
    {
    default: 
      j = k;
    }
    float f2;
    for (;;)
    {
      if (j == 0) {
        invalidateSelf();
      }
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.g = 2;
      j = 0;
      continue;
      f2 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
      if (f2 <= 1.0F) {
        break;
      }
      this.g = 3;
      j = k;
    }
    paramCanvas.save();
    float f3 = this.jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator.getInterpolation(f2);
    if (f3 > 0.5F) {}
    for (float f1 = -f3 * this.jdField_b_of_type_Int;; f1 = -(1.0F - f3) * this.jdField_b_of_type_Int)
    {
      paramCanvas.translate(f1, this.jdField_a_of_type_Int - f3 * this.jdField_a_of_type_Int);
      paramCanvas.scale(this.jdField_b_of_type_Float * f2, this.jdField_b_of_type_Float * f2, i, h);
      setAlpha((int)(255.0F - f2 * 255.0F));
      super.draw(paramCanvas);
      paramCanvas.restore();
      j = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */