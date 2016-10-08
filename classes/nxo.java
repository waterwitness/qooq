import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nxo
  implements DialogInterface.OnClickListener
{
  nxo(nxn paramnxn, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DiscussionManager)this.jdField_a_of_type_Nxn.a.a.getManager(52)).a(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Nxn.a.a.a().a();
    RecentUser localRecentUser = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.b(localRecentUser);
    }
    this.jdField_a_of_type_Nxn.a.x();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */