import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nps
  implements PopupWindow.OnDismissListener
{
  public nps(StructingMsgItemBuilder paramStructingMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    StructingMsgItemBuilder.b(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */