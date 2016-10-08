import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ine
  implements DialogInterface.OnClickListener
{
  public ine(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.q();
    this.a.a.setSelected(true);
    this.a.g = true;
    this.a.m = true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */