import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.share.QZoneShareActivity;

public class ypc
  implements Runnable
{
  public ypc(QZoneShareActivity paramQZoneShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Editable localEditable;
    if (this.a.a != null)
    {
      localEditable = this.a.a.getText();
      if (localEditable == null) {
        break label51;
      }
    }
    label51:
    for (int i = localEditable.length();; i = 0)
    {
      this.a.a.setSelection(i);
      this.a.h();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */