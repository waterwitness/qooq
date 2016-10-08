import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class nqk
  implements View.OnClickListener
{
  public nqk(TextItemBuilder paramTextItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (TextItemBuilder.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = AIOUtils.a(paramView);
          if ((localObject instanceof MessageForText)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w(ChatItemBuilder.a, 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
        return;
        localObject = (MessageForText)localObject;
      } while (((MessageForText)localObject).msgtype != 64533);
      AIOUtils.l = true;
      Object localObject = PkgTools.c(((MessageForText)localObject).action);
      paramView = JumpParser.a(this.a.a, paramView.getContext(), (String)localObject);
    } while (paramView == null);
    paramView.b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */