import android.graphics.Point;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wdp
  implements wdr
{
  public wdp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Point a(float paramFloat, Point paramPoint1, Point paramPoint2)
  {
    float f1 = paramPoint1.x;
    float f2 = paramPoint1.y;
    return new Point((int)(f1 + (paramPoint2.x - f1) * paramFloat), (int)(f2 + (paramPoint2.y - f2) * paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */