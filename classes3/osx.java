import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.qqcard.QQCardHeader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.ADView;

public class osx
  implements URLDrawableDownListener
{
  public osx(QQCardHeader paramQQCardHeader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    int i = (int)(paramURLDrawable.getIntrinsicHeight() / paramURLDrawable.getIntrinsicWidth() * (float)DeviceInfoUtil.h() + 0.5F);
    ((LinearLayout.LayoutParams)this.a.a.getLayoutParams()).height = i;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */