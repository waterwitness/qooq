import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class mff
  implements IIconListener
{
  public mff(QQSettingMe paramQQSettingMe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.b) && (paramBitmap != null) && (QQSettingMe.a(this.a).a().actionId == paramInt1) && (paramInt2 == 200)) {
      this.a.x();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */