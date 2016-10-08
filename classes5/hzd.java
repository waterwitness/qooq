import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class hzd
  implements Runnable
{
  public hzd(InterestLabelInfoModule paramInterestLabelInfoModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    List localList = this.a.a.a(InterestLabelInfo.class, true, null, null, null, null, null, null);
    this.a.c(localList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */