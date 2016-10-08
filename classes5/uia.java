import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class uia
  implements IIconListener
{
  public uia(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((EditActivity.a(this.a).actionId == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      EditActivity.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */