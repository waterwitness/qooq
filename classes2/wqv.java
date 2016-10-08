import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.open.agent.CardContainer;

public class wqv
  implements Runnable
{
  public wqv(CardContainer paramCardContainer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = Drawable.createFromPath(LastModifySupportDownloader.a(this.a.a()));
    if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */