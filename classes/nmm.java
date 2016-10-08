import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nmm
  implements View.OnClickListener
{
  public nmm(MixedMsgItemBuilder paramMixedMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    if (MixedMsgItemBuilder.a(this.a)) {
      return;
    }
    MixedMsgItemBuilder.a(this.a).onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */