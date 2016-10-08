import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iai
  implements View.OnTouchListener
{
  public iai(VideoPlayManager paramVideoPlayManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    label150:
    for (;;)
    {
      return false;
      if (paramView.getId() == 2131296592)
      {
        paramView = (ImageView)paramView;
        if (Build.VERSION.SDK_INT >= 16) {
          paramView.setImageAlpha(120);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "set volume image half-transparent");
          break;
          paramView.setAlpha(120);
        }
        if (paramView.getId() == 2131296592)
        {
          paramView = (ImageView)paramView;
          if (Build.VERSION.SDK_INT >= 16) {
            paramView.setImageAlpha(255);
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label150;
            }
            QLog.d("Q.readinjoy.video", 2, "set volume image recover");
            break;
            paramView.setAlpha(255);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */