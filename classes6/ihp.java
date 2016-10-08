import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep;
import com.tencent.biz.qqstory.base.preload.cachecleaner.TimeCleanStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ihp
  implements Runnable
{
  public ihp(CacheCleaner paramCacheCleaner, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TimeCleanStep localTimeCleanStep = new TimeCleanStep(this.jdField_a_of_type_Boolean);
    localTimeCleanStep.a(new CapacityCleanStep(this.jdField_a_of_type_Boolean));
    localTimeCleanStep.a(CacheCleaner.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */