import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.dingdong.DingdongOpenIdProvider.Callback;
import cooperation.dingdong.data.DingdongOfficeOpenService;
import java.util.List;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;

public class ybo
  implements DingdongOpenIdProvider.Callback
{
  public ybo(DingdongOfficeOpenService paramDingdongOfficeOpenService, String paramString, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (oidb_0x589.GetUserOpenIdRsp)paramList.get(0);
      if (paramList.uint32_result.get() == 0) {
        paramList = paramList.bytes_open_id.get().toStringUtf8();
      }
    }
    for (boolean bool = this.jdField_a_of_type_JavaLangString.equals(paramList);; bool = false)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("CheckOpenIdResult", bool);
      DingdongOfficeOpenService.a(this.jdField_a_of_type_CooperationDingdongDataDingdongOfficeOpenService).a(47, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */