import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lve
  implements Runnable
{
  public lve(ModifyFriendInfoActivity paramModifyFriendInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = ((FriendsManager)this.a.app.getManager(50)).a(this.a.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      this.a.c = ((Card)localObject).strReMark;
    }
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 1;
    ((Message)localObject).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */