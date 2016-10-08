import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hef
  implements DialogInterface.OnDismissListener
{
  public hef(JoinGroupHandler paramJoinGroupHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.c();
    this.a.jdField_a_of_type_Long = 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */