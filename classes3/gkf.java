import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.utils.NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack;
import com.tencent.av.utils.NearbyPeopleProfileHelper.NearbyProfileData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gkf
  implements NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack
{
  public gkf(RandomController paramRandomController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, NearbyPeopleProfileHelper.NearbyProfileData paramNearbyProfileData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "onGetNearbyPeopleProfile uin :" + paramString + ", nickname:" + paramNearbyProfileData.b + ", gender:" + paramNearbyProfileData.a);
    }
    if (paramString.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
    {
      if (paramNearbyProfileData.a != -1) {
        this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(paramNearbyProfileData.a);
      }
      if (this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a())
      {
        if (!this.a.c) {
          break label199;
        }
        this.a.c = false;
        this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.jdField_a_of_type_Boolean, this.a.m, this.a.n);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.b);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new gkg(this));
      return;
      label199:
      if (this.a.d)
      {
        this.a.d = false;
        this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.jdField_a_of_type_Boolean, this.a.m);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.b);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */