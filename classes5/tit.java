import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tit
  extends TransProcessorHandler
{
  public tit(NearbyGuideActivity paramNearbyGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      if (localFileMsg.a <= 0L) {
        break;
      }
    }
    for (int i = (int)(localFileMsg.f * 100L / localFileMsg.a); QLog.isColorLevel(); i = 0)
    {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity .mPicUploadHandler.handleMessage, send process : " + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload success. photo_id = " + NearbyPeoplePhotoUploadProcessor.aH);
      }
      i = NearbyPeoplePhotoUploadProcessor.aH;
      if (i >= 0) {
        this.a.a.set(0, Integer.valueOf(i));
      }
      this.a.a(this.a.a);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload fail.");
      }
      this.a.l();
      this.a.c("上传失败");
      this.a.a(true, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */