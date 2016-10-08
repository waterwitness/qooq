import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeModeParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class kmx
  implements Runnable
{
  kmx(kmw paramkmw, String paramString1, int paramInt, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = 0L;
    Object localObject1 = this.jdField_a_of_type_Kmw.a.a();
    Object localObject2 = BuddyTransfileProcessor.a(this.jdField_a_of_type_Kmw.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, 2, null);
    localObject2 = MessageForPtt.getLocalFilePath(((QQRecorder.RecorderParam)localObject1).c, (String)localObject2);
    String str = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".")).concat(".pcm");
    if (!FileUtils.d(this.jdField_a_of_type_JavaLangString, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "copy failed, return");
      }
      return;
    }
    this.jdField_a_of_type_Kmw.a.c = 0L;
    Object localObject3 = new File(str);
    if (((File)localObject3).exists()) {
      l = ((File)localObject3).length();
    }
    double d = QQRecorder.a(this.jdField_a_of_type_Int, 2, 2, l);
    if (QLog.isColorLevel()) {
      QLog.d("sougouptt", 2, "file size = " + l + " timelength = " + d);
    }
    localObject3 = new VoiceChangeBasicParams((String)localObject2, this.jdField_a_of_type_Int, ((QQRecorder.RecorderParam)localObject1).b, ((QQRecorder.RecorderParam)localObject1).c, 0);
    VoiceChangeManager.a(this.jdField_a_of_type_Kmw.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (VoiceChangeBasicParams)localObject3, null, null, VoiceChangeModeParams.a(str));
    this.jdField_a_of_type_Kmw.a.a((String)localObject2, (int)d, (QQRecorder.RecorderParam)localObject1, this.b);
    localObject1 = (InputMethodManager)this.jdField_a_of_type_Kmw.a.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("PCMFilePath", this.jdField_a_of_type_JavaLangString);
    ((InputMethodManager)localObject1).sendAppPrivateCommand(this.jdField_a_of_type_Kmw.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, "com.tencent.mobileqq_handleCompleted", (Bundle)localObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */