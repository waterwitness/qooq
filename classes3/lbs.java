import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;

public class lbs
  implements IIconListener
{
  private lbs(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.a) && (paramBitmap != null) && (paramInt2 == 200)) {
      this.a.a(1400L, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */