import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class qrc
  implements Runnable
{
  public qrc(ArkLocalAppMgr paramArkLocalAppMgr, qrq paramqrq, qrt paramqrt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Qrq.a = ArkLocalAppMgr.a();
    ArkLocalAppMgr localArkLocalAppMgr = (ArkLocalAppMgr)ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr).get();
    if (localArkLocalAppMgr != null) {
      ArkLocalAppMgr.a(localArkLocalAppMgr).post(new qrd(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */