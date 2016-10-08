import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qtd
  implements Runnable
{
  public qtd(SelectCoverActivity paramSelectCoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = VideoDrawableHandler.a(this.a.a);
    if (this.a.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (localBitmap != null) {
        this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(4, localBitmap).sendToTarget();
      }
      while (this.a.m == 1)
      {
        SelectCoverActivity.a(this.a);
        return;
        this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qtd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */