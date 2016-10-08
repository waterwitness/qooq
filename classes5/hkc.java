import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public final class hkc
  implements DialogInterface.OnClickListener
{
  public hkc(int paramInt, Handler paramHandler, QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Int == 1)
      {
        paramDialogInterface.dismiss();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-1);
        return;
      }
      LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, false, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      l = NetConnInfoCenter.getServerTimeMillis();
      ((RedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(this.jdField_a_of_type_Long), false, l);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      l = NetConnInfoCenter.getServerTimeMillis();
      ((RedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(this.jdField_a_of_type_Long), true, l);
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */