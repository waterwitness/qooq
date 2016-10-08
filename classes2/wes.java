import android.os.Message;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class wes
  implements Runnable
{
  public wes(PendantInfo paramPendantInfo, int paramInt, long paramLong, VipPendantDrawable paramVipPendantDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getDrawable, Runnable in");
    }
    Object localObject = AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    if (2 == this.jdField_a_of_type_Int) {
      localObject = AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, 8);
    }
    if (FileUtils.a((String)localObject))
    {
      if (2 == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a();
        if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_ArrayOfJavaLangString == null) {
          PendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if ((PendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo) == -1) || (PendantInfo.b(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo) == -1)) {
                    break;
                  }
                } while ((PendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo) == 0) || (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler == null));
                localObject = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
              } while (!PendantInfo.a((Message)localObject, this.jdField_a_of_type_Long));
              this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
              return;
              localObject = new File(AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, 4));
              if (!this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a((File)localObject, this.jdField_a_of_type_Int)) {
                break label283;
              }
              if (PendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo) != 0) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("PendantInfo", 2, "static type request dynamic resources");
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler == null);
          localObject = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
        } while (!PendantInfo.a((Message)localObject, this.jdField_a_of_type_Long));
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        return;
        label283:
        PendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable, false, this.jdField_a_of_type_Long);
      return;
    }
    PendantInfo.a(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */