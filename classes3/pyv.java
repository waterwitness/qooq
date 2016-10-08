import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pyv
  implements Runnable
{
  public pyv(HotChatShare paramHotChatShare)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = "stranger_" + String.valueOf(200) + "_" + this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin;
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url))) {
      this.a.c = (((Setting)localObject).url + "140");
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.fromdb.ownerHeadUrl=" + this.a.c);
    }
    if (!TextUtils.isEmpty(this.a.c)) {
      if (this.a.jdField_a_of_type_Int == 0) {
        this.a.jdField_a_of_type_Int = 2;
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Int == 3) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new pyw(this));
      }
      return;
      if (this.a.jdField_a_of_type_Int == 1)
      {
        this.a.jdField_a_of_type_Int = 3;
        continue;
        ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin, 200, (byte)1, (byte)3);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */