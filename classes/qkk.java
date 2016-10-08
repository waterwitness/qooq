import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qkk
  implements Runnable
{
  public qkk(LbsInfoMgr paramLbsInfoMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    long l = System.currentTimeMillis();
    LbsInfoMgr.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    LbsInfoMgr.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.i("LbsInfoMgr", 2, "上报操作完成，耗时: " + (System.currentTimeMillis() - l));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LbsInfoMgr", 2, "reportLbsInfoToServer: time = " + this.a.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */