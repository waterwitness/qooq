import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class qri
  implements Runnable
{
  public qri(ArkLocalAppMgr paramArkLocalAppMgr, qrp paramqrp, qrs paramqrs)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Qrp.a = NetworkUtil.h(BaseApplication.getContext());
    ArkLocalAppMgr localArkLocalAppMgr = (ArkLocalAppMgr)ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr).get();
    if (localArkLocalAppMgr != null) {
      ArkLocalAppMgr.a(localArkLocalAppMgr).post(new qrj(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */