import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.biz.qrcode.util.QRCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class jay
  implements View.OnClickListener
{
  public jay(QRCardActivity paramQRCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      if (((Integer)localObject).intValue() != 0) {
        break label101;
      }
    }
    label101:
    for (String str = (String)((TextView)paramView.findViewById(2131297013)).getText();; str = null)
    {
      if (((Integer)localObject).intValue() == 1)
      {
        this.a.a((String)this.a.a.d.get(this.a.j));
        return;
      }
      QRCardActivity.a(this.a, paramView.getContext(), ((Integer)localObject).intValue(), null, str);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */