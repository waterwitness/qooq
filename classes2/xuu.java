import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class xuu
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private int b;
  private int c;
  private int d;
  
  public xuu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.jdField_a_of_type_Int = paramInt4;
    this.jdField_a_of_type_JavaUtilArrayList = a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList(paramInt4);
    int j = (int)((paramInt2 - paramInt1) / (paramInt4 - 1.0F));
    int i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    if (paramInt1 < paramInt4)
    {
      if (paramInt1 == 0) {}
      for (i = 0;; i = j)
      {
        Point localPoint = new Point(i + paramInt2, paramInt3);
        localArrayList.add(localPoint);
        paramInt2 = localPoint.x;
        paramInt1 += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, xuq paramxuq)
  {
    int i = paramPaint.getColor();
    float f1 = paramPaint.getStrokeWidth();
    paramPaint.setColor(paramxuq.c);
    paramPaint.setStrokeWidth(paramxuq.e);
    paramCanvas.drawLine(this.b, this.d, this.c, this.d, paramPaint);
    paramxuq = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramxuq.hasNext())
    {
      Point localPoint = (Point)paramxuq.next();
      float f2 = localPoint.x;
      float f3 = localPoint.y;
      float f4 = this.jdField_a_of_type_Float / 2.0F;
      float f5 = localPoint.x;
      float f6 = localPoint.y;
      paramCanvas.drawLine(f2, f3 - f4, f5, this.jdField_a_of_type_Float / 2.0F + f6, paramPaint);
    }
    paramPaint.setColor(i);
    paramPaint.setStrokeWidth(f1);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return (int)((this.c - this.b) / (this.jdField_a_of_type_Int - 1.0F));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xuu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */