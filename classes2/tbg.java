import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView.MagicfaceGestureListener;

public class tbg
  extends GestureDetector.SimpleOnGestureListener
{
  public tbg(MagicfaceContainerView paramMagicfaceContainerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (MagicfaceContainerView.a(this.a) != null) {
      MagicfaceContainerView.a(this.a).a(5);
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 150.0F) {
      if (MagicfaceContainerView.a(this.a) != null) {
        MagicfaceContainerView.a(this.a).a(0);
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= -150.0F) {
            break;
          }
        } while (MagicfaceContainerView.a(this.a) == null);
        MagicfaceContainerView.a(this.a).a(1);
        return false;
        if (paramMotionEvent1.getY() - paramMotionEvent2.getY() <= 150.0F) {
          break;
        }
      } while (MagicfaceContainerView.a(this.a) == null);
      MagicfaceContainerView.a(this.a).a(2);
      return false;
    } while ((paramMotionEvent1.getY() - paramMotionEvent2.getY() >= -150.0F) || (MagicfaceContainerView.a(this.a) == null));
    MagicfaceContainerView.a(this.a).a(3);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (MagicfaceContainerView.a(this.a) != null) {
      MagicfaceContainerView.a(this.a).a(4);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */