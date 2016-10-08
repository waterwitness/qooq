import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.imageCollection.ImageCollectionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class hvh
  implements View.OnTouchListener
{
  public hvh(ImageCollectionActivity paramImageCollectionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ImageCollectionActivity.c(this.a) == 0) {}
    for (;;)
    {
      return false;
      if (ImageCollectionActivity.c(this.a) == ImageCollectionActivity.c(this.a).size()) {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        default: 
          break;
        case 1: 
          ImageCollectionActivity.a(this.a, paramMotionEvent.getRawX());
          ImageCollectionActivity.b(this.a, paramMotionEvent.getRawY());
          if (QLog.isDevelopLevel()) {
            QLog.d("ImageCollectionActivity", 2, "onTouch->mTouchUpX:" + ImageCollectionActivity.a(this.a) + ", mTouchUpY:" + ImageCollectionActivity.b(this.a));
          }
          break;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */