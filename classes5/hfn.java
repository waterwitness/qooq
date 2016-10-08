import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hfn
  implements Runnable
{
  public hfn(ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ProtoUtils.TroopProtocolObserver.a(this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */