import android.graphics.Bitmap;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;

public class ssd
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public ssd(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(Long.valueOf(paramString).longValue(), paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */