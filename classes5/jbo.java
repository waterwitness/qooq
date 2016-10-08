import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;

class jbo
  extends TouchDelegate
{
  jbo(jbn paramjbn, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (QRDisplayActivity.a(this.a.a) != null)
      {
        QRDisplayActivity.a(this.a.a, false);
        QRDisplayActivity.a(this.a.a).start();
        continue;
        if (QRDisplayActivity.a(this.a.a) != null) {
          QRDisplayActivity.a(this.a.a).cancel();
        }
        if (!QRDisplayActivity.a(this.a.a))
        {
          AccessibilityUtil.d(this.a.a.d);
          this.a.a.onClick(this.a.a.d);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */