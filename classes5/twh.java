import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class twh
  implements Handler.Callback
{
  public twh(ProfileHeaderView paramProfileHeaderView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (ProfileHeaderView.d == paramMessage.what)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView handleMessage msg what is check tips time=" + this.a.c);
      }
      if ((this.a.b.get()) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        this.a.o(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      }
    }
    do
    {
      do
      {
        return true;
        if (ProfileHeaderView.f == paramMessage.what)
        {
          this.a.a(false);
          return true;
        }
      } while (ProfileHeaderView.g != paramMessage.what);
      localObject = (View)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    } while (!(localObject instanceof ImageView));
    Object localObject = (ImageView)localObject;
    paramMessage = (ExtensionInfo)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.isPendantValid()))
    {
      this.a.jdField_a_of_type_Long = paramMessage.pendantId;
      paramMessage = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      ((ImageView)localObject).setVisibility(0);
      if (AvatarPendantUtil.a(this.a.jdField_a_of_type_Long))
      {
        paramMessage.a(this.a.jdField_a_of_type_Long).a((View)localObject, 2, PendantInfo.i);
        return true;
      }
      paramMessage.a(this.a.jdField_a_of_type_Long).a((View)localObject, 1, PendantInfo.i);
      return true;
    }
    ((ImageView)localObject).setVisibility(4);
    this.a.jdField_a_of_type_Long = 0L;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */