import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class npm
  implements PopupWindow.OnDismissListener
{
  public npm(StructingMsgItemBuilder paramStructingMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    StructingMsgItemBuilder.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\npm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */