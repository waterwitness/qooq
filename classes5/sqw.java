import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsPublisher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTransFileController;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class sqw
  implements Runnable
{
  public sqw(FreshNewsPublisher paramFreshNewsPublisher)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (FreshNewsPublisher.a(this.a).uploadingPhotoIndex.get() < FreshNewsPublisher.a(this.a).photoPaths.size())
    {
      if ("_".equals(FreshNewsPublisher.a(this.a).photoUrls.get(FreshNewsPublisher.a(this.a).uploadingPhotoIndex.get())))
      {
        Object localObject = (String)FreshNewsPublisher.a(this.a).photoPaths.get(FreshNewsPublisher.a(this.a).uploadingPhotoIndex.get());
        CompressInfo localCompressInfo = new CompressInfo((String)localObject, 0);
        localCompressInfo.f = 0;
        CompressOperator.a(localCompressInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FreshNewsPublisher", 2, "uploadPhoto(), raw_file_path=" + (String)localObject + ", compressed_file_path = " + localCompressInfo.e);
        }
        if (!StringUtil.b(localCompressInfo.e))
        {
          localObject = new TransferRequest();
          ((TransferRequest)localObject).jdField_a_of_type_Boolean = true;
          ((TransferRequest)localObject).i = localCompressInfo.e;
          ((TransferRequest)localObject).b = 21;
          ((TransferRequest)localObject).jdField_a_of_type_Long = FreshNewsPublisher.a(this.a).publishTime;
          FreshNewsPublisher.a(this.a).a().a((TransferRequest)localObject);
          return;
        }
        FreshNewsPublisher.a(this.a).uploadingPhotoIndex.incrementAndGet();
        FreshNewsPublisher.a(this.a);
        return;
      }
      FreshNewsPublisher.a(this.a).uploadingPhotoIndex.incrementAndGet();
      FreshNewsPublisher.a(this.a);
      return;
    }
    FreshNewsPublisher.b(this.a);
    FreshNewsPublisher.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */