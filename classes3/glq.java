import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.AvAddFriendHelper.IAvAddFriendCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class glq
  implements AvAddFriendHelper.IAvAddFriendCallBack
{
  public glq(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RandomDoubleActivity", 2, "onAddFriendEvent uin :" + paramString + ", status : " + this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString));
    }
    if (!paramString.equals(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.f)) {
      return;
    }
    this.a.a(paramString, this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */