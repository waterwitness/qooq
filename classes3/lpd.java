import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;

public class lpd
  implements WebProcessManager.WebProcessStartListener
{
  public lpd(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */