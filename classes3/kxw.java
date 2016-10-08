import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kxw
  implements DialogInterface.OnClickListener
{
  public kxw(ChatHistoryImageView paramChatHistoryImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null)
    {
      this.a.a.b = false;
      this.a.a.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */