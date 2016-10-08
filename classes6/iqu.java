import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqu
  implements DialogInterface.OnClickListener
{
  public iqu(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a, QQSettingMsgHistoryActivity.class);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */