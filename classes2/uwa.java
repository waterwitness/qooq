import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.qphone.base.util.QLog;

public class uwa
  extends URLDrawableDownListener.Adapter
{
  public uwa(StructMsgItemCover paramStructMsgItemCover)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgItemCover.b(), 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgItemCover.b(), 2, "onLoadFailed ,cause = " + paramThrowable);
    }
    this.a.a(paramView, 0, 1001);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgItemCover.b(), 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {
      return;
    }
    paramView.setBackgroundDrawable(null);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    if (QLog.isColorLevel()) {
      QLog.d(StructMsgItemCover.b(), 2, "onLoadSuccessed");
    }
    this.a.a(paramView, 1, 1001);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */