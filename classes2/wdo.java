import android.graphics.Rect;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wdo
  implements wdr
{
  public wdo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Rect a(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    return new Rect(paramRect1.left + (int)((paramRect2.left - paramRect1.left) * paramFloat), paramRect1.top + (int)((paramRect2.top - paramRect1.top) * paramFloat), paramRect1.right + (int)((paramRect2.right - paramRect1.right) * paramFloat), paramRect1.bottom + (int)((paramRect2.bottom - paramRect1.bottom) * paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */