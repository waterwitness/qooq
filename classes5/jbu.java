import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jbu
  implements View.OnTouchListener
{
  public jbu(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0)
      {
        this.a.b.setImageResource(2130841628);
      }
      else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.a.b.setImageResource(2130841627);
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (!QRDisplayActivity.a(paramView, i, j))
        {
          this.a.b.setImageResource(2130841627);
          continue;
          if (paramMotionEvent.getAction() == 0)
          {
            this.a.c.setImageResource(2130841630);
          }
          else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
          {
            this.a.c.setImageResource(2130841629);
          }
          else if (paramMotionEvent.getAction() == 2)
          {
            i = (int)paramMotionEvent.getRawX();
            j = (int)paramMotionEvent.getRawY();
            if (!QRDisplayActivity.a(paramView, i, j))
            {
              this.a.c.setImageResource(2130841629);
              continue;
              if (paramMotionEvent.getAction() == 0)
              {
                this.a.d.setImageResource(2130841632);
              }
              else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
              {
                this.a.d.setImageResource(2130841631);
              }
              else if (paramMotionEvent.getAction() == 2)
              {
                i = (int)paramMotionEvent.getRawX();
                j = (int)paramMotionEvent.getRawY();
                if (!QRDisplayActivity.a(paramView, i, j)) {
                  this.a.d.setImageResource(2130841631);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */