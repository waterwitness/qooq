import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class osk
  extends Handler
{
  private final WeakReference a;
  
  public osk(SendPhotoActivity paramSendPhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramSendPhotoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.a.get();
    if (localSendPhotoActivity != null) {}
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    case 1: 
      return;
    }
    if (localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.hasMessages(2))
    {
      Logger.b(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage", "remove delayed Message:MSG_CANCLE_PROGRESS");
      localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
    SendPhotoActivity.a();
    Object localObject2 = localSendPhotoActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    Object localObject1 = new String[((ArrayList)localObject2).size()];
    ((ArrayList)localObject2).toArray((Object[])localObject1);
    int i = localSendPhotoActivity.getIntent().getIntExtra("uintype", 1003);
    localObject2 = localSendPhotoActivity.app;
    if ((paramMessage.obj != null) && ("TimeOut".equals(paramMessage.obj.toString())))
    {
      bool = true;
      ThreadManager.a(new osl(this, bool, (String[])localObject1, i, (QQAppInterface)localObject2), 5, null, true);
      if ((localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask == null) || (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.a == null) || (!localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.a.isShowing())) {
        break label682;
      }
    }
    label682:
    for (boolean bool = true;; bool = false)
    {
      if (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask != null) {}
      try
      {
        localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.a();
        localObject2 = localSendPhotoActivity.getIntent();
        ((Intent)localObject2).putExtra(AlbumConstants.i, 2);
        if (!((Intent)localObject2).hasExtra("extra_image_sender_tag")) {
          ((Intent)localObject2).putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
        }
        localObject1 = null;
        Object localObject3 = paramMessage.getData();
        int j = 0;
        ArrayList localArrayList = new ArrayList();
        i = j;
        paramMessage = (Message)localObject1;
        if (localObject3 != null)
        {
          ((Bundle)localObject3).setClassLoader(CompressInfo.class.getClassLoader());
          localObject1 = ((Bundle)localObject3).getParcelableArrayList("flag_compressinfolist");
          i = j;
          paramMessage = (Message)localObject1;
          if (localObject1 != null)
          {
            paramMessage = ((ArrayList)localObject1).iterator();
            for (;;)
            {
              if (paramMessage.hasNext())
              {
                localObject3 = (CompressInfo)paramMessage.next();
                Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage print CompressInfo", "info:" + localObject3);
                localArrayList.add(((CompressInfo)localObject3).e);
                continue;
                bool = false;
                break;
              }
            }
            i = ((ArrayList)localObject1).size();
            paramMessage = (Message)localObject1;
          }
        }
        long l1 = System.nanoTime();
        long l2 = (l1 - localSendPhotoActivity.jdField_a_of_type_Long) / 1000000L;
        Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "CompressLog", "compress startTime = " + localSendPhotoActivity.jdField_a_of_type_Long + "ns,finishTime = " + l1 + "ns,duration = " + l2 + "ms,count = " + i + ",isShowing = " + bool);
        StatisticConstants.a(l2, i, bool);
        localSendPhotoActivity.app.a().a(l1);
        Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "TimeCompare", "CompressFinish Time = " + l1 + "ns");
        ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
        SendPhotoActivity.a(localSendPhotoActivity, localArrayList);
        ((Intent)localObject2).removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
        localSendPhotoActivity.setResult(-1, localSendPhotoActivity.getIntent());
        localSendPhotoActivity.finish();
        bool = localSendPhotoActivity.getIntent().getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "sendPhotoActivity isWaitForResult=" + bool);
        }
        if (!bool)
        {
          localObject1 = localSendPhotoActivity.getIntent();
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          ((Intent)localObject1).addFlags(603979776);
          localSendPhotoActivity.startActivity((Intent)localObject1);
        }
        Utils.a(BaseApplication.getContext(), paramMessage);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */