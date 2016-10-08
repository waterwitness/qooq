import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;

public class tob
  extends TransProcessorHandler
{
  public tob(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
          if (((FileMsg)localObject).e == 39)
          {
            paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).l;
            ((PicInfo)this.a.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag()).f = paramMessage;
            if (QLog.isColorLevel()) {
              QLog.i("Q.nearby_people_card.upload_local_photo", 2, "mPicUploadHandler.handleMessage(), big video upload success. videoId = " + paramMessage);
            }
            ThreadManager.a(new toc(this), 8, null, true);
            return;
          }
          if (((FileMsg)localObject).e == 40)
          {
            paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).l;
            if (QLog.isColorLevel()) {
              QLog.i("Q.nearby_people_card.upload_local_photo", 2, "mPicUploadHandler.handleMessage(), medium video upload success. videoId = " + paramMessage);
            }
            ThreadManager.a(new tod(this), 8, null, true);
            return;
          }
          if (((FileMsg)localObject).e == 41)
          {
            paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).l;
            if (QLog.isColorLevel()) {
              QLog.i("Q.nearby_people_card.upload_local_photo", 2, "mPicUploadHandler.handleMessage(), small video upload success. videoId = " + paramMessage);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new toe(this));
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
            int i = this.a.l;
            String str1 = this.a.b;
            String str2 = this.a.c;
            if (this.a.jdField_a_of_type_Boolean) {}
            for (paramMessage = "1";; paramMessage = "0")
            {
              ReportController.b((QQAppInterface)localObject, "dc00898", "", "", "0X800711D", "0X800711D", 1, 0, String.valueOf(i), str1, str2, paramMessage);
              return;
            }
          }
        } while (((FileMsg)localObject).e != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + NearbyPeoplePhotoUploadProcessor.aH);
        }
      } while (NearbyProfileEditPanel.a(this.a) == null);
      NearbyProfileEditPanel.a(this.a).a = NearbyPeoplePhotoUploadProcessor.aH;
      NearbyProfileEditPanel.b(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a();
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b("上传失败");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */