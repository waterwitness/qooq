import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.emoticonview.MagicFaceAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class rla
  implements URLDrawableDownListener
{
  public rla(MagicFaceAdapter paramMagicFaceAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if ((((Boolean)paramView.getTag()).booleanValue()) && (paramURLDrawable != null) && (paramURLDrawable.getIntrinsicWidth() > 0)) {}
    try
    {
      paramURLDrawable = ImageUtil.a(paramURLDrawable);
      if ((paramURLDrawable != null) && (paramURLDrawable.getWidth() > 0)) {
        ((ImageView)paramView).setImageBitmap(ImageUtil.a(paramURLDrawable));
      }
      return;
    }
    catch (OutOfMemoryError paramURLDrawable)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w(MagicFaceAdapter.b, 2, "onLoadSuccessed, oom step 1");
          }
          try
          {
            if (this.a.a != null)
            {
              ((ImageView)paramView).setImageDrawable(this.a.a.getResources().getDrawable(2130837545));
              return;
            }
          }
          catch (OutOfMemoryError paramURLDrawable)
          {
            ((ImageView)paramView).setImageDrawable(null);
            if (QLog.isColorLevel())
            {
              QLog.w(MagicFaceAdapter.b, 2, "onLoadSuccessed, oom step 2");
              return;
            }
          }
          catch (Exception paramURLDrawable)
          {
            ((ImageView)paramView).setImageDrawable(null);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.w(MagicFaceAdapter.b, 2, "onLoadSuccessed, err:" + paramURLDrawable.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */