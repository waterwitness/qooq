import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class ntu
  implements View.OnClickListener
{
  public ntu(AIOGallerySceneWithBusiness paramAIOGallerySceneWithBusiness)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof StructMsgForImageShare)) {}
    }
    do
    {
      do
      {
        return;
        this.a.b((StructMsgForImageShare)paramView, "5");
        return;
        if (paramView != this.a.b) {
          break;
        }
        paramView = paramView.getTag();
      } while (!(paramView instanceof StructMsgForImageShare));
      this.a.c((StructMsgForImageShare)paramView, "5");
      return;
    } while (paramView != this.a.c);
    paramView = paramView.getTag();
    if ((paramView instanceof StructMsgForImageShare)) {
      paramView = (StructMsgForImageShare)paramView;
    }
    this.a.r();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */