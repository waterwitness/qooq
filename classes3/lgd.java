import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lgd
  implements DialogInterface.OnClickListener
{
  lgd(lgb paramlgb, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DiscussionInfoCardActivity.a(this.jdField_a_of_type_Lgb.a).a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Lgb.a.app.a().a();
    paramDialogInterface.b(paramDialogInterface.a(this.jdField_a_of_type_JavaLangString, 3000));
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("isNeedFinish", true);
    this.jdField_a_of_type_Lgb.a.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_Lgb.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */