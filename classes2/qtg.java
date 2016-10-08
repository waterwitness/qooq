import android.os.Message;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

public class qtg
  extends TransProcessorHandler
{
  public qtg(SelectCoverActivity paramSelectCoverActivity)
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
      label272:
      do
      {
        return;
        if (((FileMsg)localObject).e == 48)
        {
          paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).k;
          if (QLog.isColorLevel()) {
            QLog.i(SelectCoverActivity.a(), 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + paramMessage);
          }
          paramMessage = (CardHandler)this.a.app.a(2);
          int i;
          String str1;
          String str2;
          if (paramMessage != null)
          {
            paramMessage.a(true, this.a.app.a(), 0);
            if (((Integer)NearbySPUtil.a(this.a.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
              NearbySPUtil.a(this.a.app.getAccount(), "qq_avatar_type", Integer.valueOf(1));
            }
            localObject = this.a.app;
            i = this.a.o;
            str1 = this.a.c;
            str2 = this.a.d;
            if (!this.a.a) {
              break label272;
            }
          }
          for (paramMessage = "1";; paramMessage = "0")
          {
            ReportController.b((QQAppInterface)localObject, "dc00898", "", "", "0X800711D", "0X800711D", 0, 0, String.valueOf(i), str1, str2, paramMessage);
            this.a.setResult(-1);
            this.a.finish();
            return;
            ProfileCardUtil.a(null);
            break;
          }
        }
        if (((FileMsg)localObject).e == 36)
        {
          paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).l;
          if (QLog.isColorLevel()) {
            QLog.i(SelectCoverActivity.a(), 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + paramMessage);
          }
          ThreadManager.a(new qth(this), 8, null, true);
          return;
        }
        if (((FileMsg)localObject).e == 37)
        {
          paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).l;
          if (QLog.isColorLevel()) {
            QLog.i(SelectCoverActivity.a(), 2, "mPhotoUploadHandler.handleMessage(), medium video upload success. videoId = " + paramMessage);
          }
          ThreadManager.a(new qti(this), 8, null, true);
          return;
        }
      } while (((FileMsg)localObject).e != 38);
      paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).l;
      if (QLog.isColorLevel()) {
        QLog.i(SelectCoverActivity.a(), 2, "mPhotoUploadHandler.handleMessage(), small video upload success. videoId = " + paramMessage);
      }
      DynamicUtils.a(this.a.app, this.a.b);
      ProfileCardUtil.a(this.a.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(SelectCoverActivity.a(), 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
    }
    SelectCoverActivity.a(this.a, 2, "上传失败，请重试", 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */