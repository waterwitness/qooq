import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class uvo
  extends URLDrawableDownListener.Adapter
{
  public uvo(StructMsgForHypertext paramStructMsgForHypertext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */