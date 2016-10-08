import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemManager;

public class tqj
  implements View.OnTouchListener
{
  private tqj(ItemManager paramItemManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    Object localObject = this.a;
    boolean bool1 = bool3;
    if (i != 1) {
      if (i != 3) {
        break label103;
      }
    }
    label103:
    for (bool1 = bool3;; bool1 = false)
    {
      ((ItemManager)localObject).c = bool1;
      if ((this.a.c) && (this.a.d != 2)) {
        this.a.b();
      }
      localObject = this.a.a.a();
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((View.OnTouchListener)localObject).onTouch(paramView, paramMotionEvent);
      }
      return bool1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */