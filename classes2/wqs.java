import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.BragActivity;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class wqs
  implements ImageLoader.ImageLoadListener
{
  public wqs(BragActivity paramBragActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.a.a.setImageBitmap(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */