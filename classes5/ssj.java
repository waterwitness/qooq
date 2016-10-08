import com.tencent.mobileqq.freshnews.data.FreshNewsDataFactory;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class ssj
  implements Runnable
{
  public ssj(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    NearbyTopicFeedActivity.a(this.a).clear();
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      NearbyTopicFeedActivity.a(this.a).addAll(this.a.jdField_a_of_type_JavaUtilList);
    }
    FreshNewsDataFactory.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, NearbyTopicFeedActivity.a(this.a), localArrayList);
    this.a.runOnUiThread(new ssk(this, localArrayList));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */