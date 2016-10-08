import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsPublisher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class sqx
  extends TransProcessorHandler
{
  public sqx(FreshNewsPublisher paramFreshNewsPublisher)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if (FreshNewsPublisher.a(this.a).publishTime == ((FileMsg)localObject).c) {}
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).k;
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsPublisher", 2, "mPhotoUploadHandler.handleMessage(), upload success. photo_url = " + paramMessage);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uploadingPhotoIndex = ").append(FreshNewsPublisher.a(this.a).uploadingPhotoIndex.get()).append(", photoUrls size = ").append(FreshNewsPublisher.a(this.a).photoUrls.size()).append(", photoPaths size = ").append(FreshNewsPublisher.a(this.a).photoPaths.size());
      QLog.i("FreshNewsPublisher", 1, ((StringBuilder)localObject).toString());
      FreshNewsPublisher.a(this.a).photoUrls.set(FreshNewsPublisher.a(this.a).uploadingPhotoIndex.get(), paramMessage);
      FreshNewsPublisher.a(this.a).uploadingPhotoIndex.incrementAndGet();
      FreshNewsPublisher.a(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsPublisher", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
    }
    FreshNewsPublisher.b(this.a);
    FreshNewsPublisher.a(this.a).publishState = 3;
    FreshNewsPublisher.a(this.a).d(FreshNewsPublisher.a(this.a));
    FreshNewsPublisher.a(this.a).c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */