import android.app.Application;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class gnr
  implements IBinder.DeathRecipient
{
  gnr(gnq paramgnq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void binderDied()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "video process died!");
    }
    if (TextUtils.isEmpty(this.a.a.d)) {
      this.a.a.d = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    String str2 = this.a.a.c;
    String str3 = this.a.a.d;
    String str1;
    Object localObject;
    int j;
    if ((this.a.a.jdField_a_of_type_Int == 1004) || (this.a.a.jdField_a_of_type_Int == 1000) || (this.a.a.jdField_a_of_type_Int == 1020))
    {
      str1 = this.a.a.e;
      localObject = str2;
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "video chatting!");
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "linkToVideoProcessDeath-->uinType=" + this.a.a.jdField_a_of_type_Int + " friendUin=" + (String)localObject + " senderUin=" + str1);
        }
        if (this.a.a.jdField_b_of_type_Boolean) {
          VideoMsgTools.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_Int, 45, true, (String)localObject, str1, true, null, true, new Object[0]);
        }
      }
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.av.v2q.StopVideoChat");
      ((Intent)localObject).putExtra("uinType", this.a.a.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("bindType", this.a.a.jdField_b_of_type_Int);
      ((Intent)localObject).putExtra("bindId", this.a.a.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("peerUin", this.a.a.c);
      ((Intent)localObject).putExtra("extraUin", this.a.a.e);
      ((Intent)localObject).putExtra("stopReason", 0);
      ((Intent)localObject).setPackage(this.a.a.getApplication().getPackageName());
      if ((this.a.a.c != null) && ((this.a.a.jdField_a_of_type_Int != 1006) || (this.a.a.e != null))) {
        this.a.a.sendBroadcast((Intent)localObject);
      }
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        long l1 = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        int i = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        j = (int)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, l1);
        if ((l1 > 0L) && (this.a.a.jdField_b_of_type_Boolean))
        {
          long l2 = Long.valueOf(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
          localObject = new Intent();
          ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
          ((Intent)localObject).putExtra("type", 23);
          ((Intent)localObject).putExtra("friendUin", l2);
          ((Intent)localObject).putExtra("relationType", i);
          ((Intent)localObject).putExtra("relationId", l1);
          ((Intent)localObject).putExtra("from", "QQServiceForAV");
          ((Intent)localObject).putExtra("MultiAVType", this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l1));
          if (j <= 1) {
            break label845;
          }
          ((Intent)localObject).putExtra("roomUserNum", j - 1);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).setPackage(this.a.a.getApplication().getPackageName());
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "linkToVideoProcessDeath MULTI_VIDEO_V2Q -->uinType=" + this.a.a.jdField_a_of_type_Int + " roomNum=" + j);
      }
      this.a.a.sendBroadcast((Intent)localObject);
      this.a.a.jdField_b_of_type_Boolean = false;
      this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0, 0);
      QAVNotification.a(this.a.a.getApplicationContext());
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = null;
      return;
      localObject = str2;
      str1 = str3;
      if (this.a.a.jdField_a_of_type_Int != 1006) {
        break;
      }
      localObject = str2;
      str1 = str3;
      if (str2.startsWith("+")) {
        break;
      }
      localObject = this.a.a.e;
      str1 = str3;
      break;
      label845:
      ((Intent)localObject).putExtra("roomUserNum", 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */