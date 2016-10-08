import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.widget.RadarMembersView.OnFirstScanFinishListener;

public class vdr
  implements RadarMembersView.OnFirstScanFinishListener
{
  public vdr(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */