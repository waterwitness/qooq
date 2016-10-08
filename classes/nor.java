import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nor
  implements DialogInterface.OnClickListener
{
  public nor(ShortVideoItemBuilder paramShortVideoItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */