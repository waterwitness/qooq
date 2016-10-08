import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class slb
  extends DiscussionObserver
{
  public slb(ForwardBaseOption paramForwardBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateDiscussionInfo start: isSuccess=" + paramBoolean);
    }
    String str = (String)paramArrayOfObject[0];
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if ((paramArrayOfObject.equals(str)) && (paramBoolean) && (bool))
    {
      paramArrayOfObject = ((DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramArrayOfObject);
      if ((paramArrayOfObject != null) && (!TextUtils.isEmpty(paramArrayOfObject.discussionName)) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle("发送到 多人聊天" + paramArrayOfObject.discussionName);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\slb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */