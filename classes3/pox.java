import android.os.Build.VERSION;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.MqqNearbyGdt.ExposeRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.struct.AdData;
import mqq.app.NewIntent;

public class pox
  implements Runnable
{
  public pox(PeopleAroundAdapter paramPeopleAroundAdapter, AdData paramAdData, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a.a(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "QQNeartyGdt.Report");
    MqqNearbyGdt.ExposeRequest localExposeRequest = new MqqNearbyGdt.ExposeRequest();
    localExposeRequest.resolution.set("216*150");
    localExposeRequest.apurl.set(this.jdField_a_of_type_ComTencentMobileqqStructAdData.expose_url);
    localExposeRequest.qua.set(Build.VERSION.RELEASE);
    localExposeRequest.platform_type.set(1);
    localExposeRequest.ad_source.set(1);
    localNewIntent.putExtra("data", localExposeRequest.toByteArray());
    localNewIntent.setObserver(PeopleAroundAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter));
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a.startServlet(localNewIntent);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a.a("CliOper", "", "", "0X8005B66", "0X8005B66", 0, 0, Integer.toString(this.jdField_a_of_type_Int), "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */