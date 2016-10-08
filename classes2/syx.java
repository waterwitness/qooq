import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;

public class syx
  implements QQRecorder.OnQQRecorderListener, VoicePlayer.VoicePlayerListener
{
  public static final int a = 350;
  public static final String a = "WEB_RECORDER";
  public static final int b = 250;
  public static final String b = "LAST_DELETE_TIME";
  public static final int c = 200;
  static final int d = 16711686;
  static final int e = 16711687;
  static final int f = 16711688;
  private static final int j = 1;
  private static final int k = 2000;
  private static final int l = 16711689;
  private static final int m = 16711690;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  protected sza a;
  private boolean jdField_a_of_type_Boolean;
  private String c;
  int g;
  private int h;
  private int i;
  
  public syx(WebRecordApiPlugin paramWebRecordApiPlugin, AppInterface paramAppInterface, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 1;
    this.i = 60000;
    this.jdField_a_of_type_Boolean = true;
    this.g = 0;
    this.jdField_a_of_type_AndroidOsHandler = new syy(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private String a()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    String str1 = AppConstants.bj + "webrecord/";
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(WebRecordApiPlugin.a, 2, "getTransferFilePath dir: " + str1);
      }
      String str2 = a();
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new File(str1 + str2 + (String)localObject);
      if ((paramBoolean) && (!((File)localObject).exists())) {}
      try
      {
        ((File)localObject).createNewFile();
        if (QLog.isColorLevel()) {
          QLog.d(WebRecordApiPlugin.a, 2, "getTransferFilePath : " + ((File)localObject).getAbsoluteFile().toString());
        }
        return ((File)localObject).getAbsoluteFile().toString();
        localObject = ".amr";
        continue;
        localObject = ".slk";
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  private int b()
  {
    return this.g;
  }
  
  private void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  private void e(String paramString)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    if (((Time)localObject).hour < 3) {}
    String str;
    do
    {
      return;
      localObject = SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "LAST_DELETE_TIME");
      str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    } while ((localObject != null) && (str.equals(localObject)));
    ThreadManager.a(new syz(this, paramString), 8, null, false);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':0,'recordID':'" + this.c + "','msg':''}" });
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onBeginReceiveData() is called");
    }
    this.i -= 200;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, this.i);
    return this.i + 200;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderVolumeStateChanged() is called");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      this.h = paramInt1;
    }
    if ((paramInt2 > 0) && (paramInt2 * 1000 < this.i)) {
      this.i = (paramInt2 * 1000);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'is recording now'}" });
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      paramInt1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (paramInt1 == 0)) {
        break label249;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        localObject = DeviceInfoUtil.b();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          if (AudioHelper.b(1))
          {
            this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367659) + "," + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367660) + "'}" });
            return;
            paramInt1 = 0;
            break;
            label249:
            paramInt1 = 0;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d(WebRecordApiPlugin.a, 2, "startRecord() is called");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          }
          e(AppConstants.bj + "webrecord/");
          if (this.h == 0) {
            localObject = new QQRecorder.RecorderParam(RecordParams.f, 0, 0);
          }
          for (this.c = a(2, true);; this.c = a(25, true))
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((QQRecorder.RecorderParam)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("QQRecorder", 2, "path: " + this.c);
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
            AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this.c);
            c(0);
            return;
            localObject = new QQRecorder.RecorderParam(RecordParams.i, 16000, 1);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367685) + "'}" });
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367684) + "'}" });
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    c(paramString);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderNotReady() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderNotReady is called'}" });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderPrepare() is called");
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131165202, false);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderEnd() is called");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int n = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + n);
    }
    if (n == 0)
    {
      PttBuffer.b(paramString);
      SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c, Double.toString(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + paramString + "','msg':''}" });
    }
    while (n != 1) {
      return;
    }
    PttBuffer.a(paramString);
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderError() is called");
    }
    PttBuffer.a(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderError is called'}" });
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderSilceEnd() is called");
    }
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    int n = 0;
    if (n < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optString(n, "");
      File localFile = new File((String)localObject);
      String str = SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject);
      long l1;
      if ((localFile.exists()) && (!TextUtils.isEmpty(str)))
      {
        double d1 = Double.valueOf(str).doubleValue();
        localFile = new File((String)localObject);
        if (localFile.exists())
        {
          l1 = localFile.length();
          label97:
          localObject = new AudioInfo((String)localObject, (int)d1, l1);
          this.jdField_a_of_type_Sza = new sza(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidOsHandler, paramString1, paramString2, (AudioInfo)localObject);
          ThreadManager.a(this.jdField_a_of_type_Sza, 5, null, true);
        }
      }
      for (;;)
      {
        n += 1;
        break;
        l1 = 0L;
        break label97;
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + (String)localObject + "','msg':'record not found or its duration is 0'}" });
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(WebRecordApiPlugin.a, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.g = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString) != null))
    {
      double d1 = Double.valueOf(SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString)).doubleValue();
      long l1;
      if (((File)localObject).exists())
      {
        l1 = ((File)localObject).length();
        localObject = new AudioInfo(paramString, (int)d1, l1);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
          break label196;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(((AudioInfo)localObject).path, new Handler(), ((AudioInfo)localObject).getAudioType());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':0,'recordID':'" + paramString + "'}" });
        return;
        l1 = 0L;
        break;
        label196:
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.d();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':3,'recordID':'" + paramString + "'}" });
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderAbnormal() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderAbnormal is called'}" });
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':2,'recordID':'" + paramString + "'}" });
    }
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onInitFailed is called'}" });
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + paramString + "'}" });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */