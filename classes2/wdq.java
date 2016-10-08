import android.graphics.PointF;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wdq
  implements wdr
{
  public wdq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    return new PointF(f1 + (paramPointF2.x - f1) * paramFloat, f2 + (paramPointF2.y - f2) * paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */