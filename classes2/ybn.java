import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.OfficeCenterProtoManager.Callback;
import cooperation.dingdong.data.DingdongOfficeOpenService;

public class ybn
  extends OfficeCenterProtoManager.Callback
{
  public ybn(DingdongOfficeOpenService paramDingdongOfficeOpenService, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("AddAppResult", paramInt);
    DingdongOfficeOpenService.a(this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService).a(47, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */