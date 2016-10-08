import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class thp
  implements Runnable
{
  thp(tho paramtho, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyFakeActivity.a(this.jdField_a_of_type_Tho.a, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_JavaLangObject);
    synchronized (this.jdField_a_of_type_Tho.a.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = NearbyFakeActivity.a(this.jdField_a_of_type_Tho.a);
      NearbyFakeActivity.b(this.jdField_a_of_type_Tho.a, true);
      if (QLog.isColorLevel()) {
        QLog.i(NearbyFakeActivity.jdField_a_of_type_JavaLangString, 2, "DataPreload ok. procDone? " + bool + " consume:" + NearbyFakeActivity.c(this.jdField_a_of_type_Tho.a));
      }
      if (bool) {
        this.jdField_a_of_type_Tho.a.runOnUiThread(new thq(this));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */