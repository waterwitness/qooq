import android.content.res.Resources;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.im.oidb.cmd0x9ce.oidb_0x9ce.RspBody;

public class sqg
  implements Runnable
{
  public sqg(FreshNewsHandler paramFreshNewsHandler, oidb_0x9ce.RspBody paramRspBody)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a.a();
    StringBuilder localStringBuilder = new StringBuilder().append("发布失败");
    if (this.jdField_a_of_type_TencentImOidbCmd0x9ceOidb_0x9ce$RspBody.str_error_tips.has()) {}
    for (String str = "," + this.jdField_a_of_type_TencentImOidbCmd0x9ceOidb_0x9ce$RspBody.str_error_tips.get();; str = "")
    {
      QQToast.a(localBaseApplication, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a.a().getResources().getDimensionPixelSize(2131492908));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */