import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class nlc
  implements FileManagerUtil.TipsClickedInterface
{
  public nlc(GrayTipsItemBuilder paramGrayTipsItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    paramView = DialogUtil.a(this.a.a, 230);
    paramView.setTitle(2131371970);
    paramView.setMessage(2131371988);
    paramView.setNegativeButton(2131367262, new nld(this, paramView));
    paramView.setPositiveButton(2131367263, new nle(this));
    paramView.show();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */