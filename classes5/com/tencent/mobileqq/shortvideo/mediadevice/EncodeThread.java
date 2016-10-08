package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEncodeHelper;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.io.IOException;

public class EncodeThread
  implements MaxVideoConst, Runnable
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EncodeVideo jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo;
  public String a;
  protected boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public EncodeThread(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo = new EncodeVideo(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.d = false;
    this.e = false;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.e) {
      CodecParam.a(this.e);
    }
    int[] arrayOfInt = CodecParam.a();
    CodecParam.a(false);
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int != 0))
    {
      EncodeVideo localEncodeVideo = this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo;
      EncodeVideo.setMosaicData(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    }
    long l1 = SystemClock.uptimeMillis();
    int i = this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo.startQQEncode(paramString1, paramString2, paramString3, paramString4, arrayOfInt);
    StoryReportor.b("take_video", "create_mp4_result", 0, i, new String[0]);
    if (i == 0)
    {
      long l2 = SystemClock.uptimeMillis();
      StoryReportor.b("take_video", "create_mp4_time", 0, 0, new String[] { "" + (l2 - l1) });
    }
    CodecParam.R = 0;
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int != 0)) {
      EncodeVideo.setMosaicData(null, 0);
    }
    return i;
  }
  
  public static void a() {}
  
  private void a(int paramInt, String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = paramInt;
    localMessage.getData().putString("maxvideo.file.mp4", paramString);
    localMessage.getData().putString("source_path", this.jdField_b_of_type_JavaLangString);
    localMessage.getData().putString("client_key", this.jdField_c_of_type_JavaLangString);
    a(localMessage);
  }
  
  private void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    a(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      a(5100, null);
      QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "9", null);
      label47:
      return;
    }
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      a(5100, null);
      QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "9", null);
      return;
    }
    String[] arrayOfString = localFile.list();
    if (arrayOfString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty dir, mSourceDirString = " + this.jdField_b_of_type_JavaLangString);
      }
      a(5101, null);
      QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "9", null);
      return;
    }
    int j = arrayOfString.length;
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    if (i < j)
    {
      String str2 = arrayOfString[i];
      if (str2.endsWith(".vf"))
      {
        localObject4 = this.jdField_b_of_type_JavaLangString + File.separator + str2;
        localObject3 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        break;
        if (str2.endsWith(".af"))
        {
          localObject3 = this.jdField_b_of_type_JavaLangString + File.separator + str2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (str2.endsWith(".ini"))
          {
            str1 = this.jdField_b_of_type_JavaLangString + File.separator + str2;
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
        }
      }
    }
    if ((!FileUtils.a((String)localObject2)) || (!FileUtils.a((String)localObject1)) || (!FileUtils.a(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty file, mSourceDirString = " + this.jdField_b_of_type_JavaLangString + ",vfFilePath = " + (String)localObject2 + ",afFilePath = " + (String)localObject1 + ",manifestFilePath = " + str1);
      }
      a(5101, null);
      QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "9", null);
      return;
    }
    if (this.d) {
      FileUtils.d((String)localObject1);
    }
    try
    {
      FileUtils.a((String)localObject1);
      localObject4 = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1300;
      }
      localObject3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
      localObject4 = new File((String)localObject3);
      if ((!((File)localObject4).mkdirs()) && (!((File)localObject4).isDirectory()))
      {
        a(5102, null);
        QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "10", null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread: createFile audiofile... ", localIOException);
      }
      a(5108, null);
      return;
    }
    Object localObject4 = VidUtil.a(localFile);
    Object localObject3 = (String)localObject3 + File.separator + (String)localObject4 + ".mp4";
    this.jdField_a_of_type_JavaLangString = ((String)localObject3);
    label720:
    b();
    if (this.jdField_b_of_type_Boolean) {
      localObject4 = new HwEncodeHelper((String)localObject2, localIOException, this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      try
      {
        i = ((HwEncodeHelper)localObject4).a();
        if (i == 0)
        {
          this.jdField_a_of_type_JavaLangString = ((HwEncodeHelper)localObject4).a();
          boolean bool = FileUtils.b(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode success, mTargetFilePath = " + this.jdField_a_of_type_JavaLangString + ", isExist = " + bool);
          }
          QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "record_hw_success", "0", null);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode serrcode = " + i);
          }
          int k = 0;
          j = i;
          i = k;
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode start soft errcode = " + j + " mEnableHardEncode=" + this.jdField_b_of_type_Boolean);
          }
          if (j == -1)
          {
            if (!this.jdField_a_of_type_Boolean) {
              continue;
            }
            localObject4 = "";
            i = a((String)localObject2, (String)localObject4, str1, (String)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode start soft over ret = " + i);
            }
            if (i != 0) {
              continue;
            }
            QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "record_sw_success", "0", null);
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("vfFilePath is " + (String)localObject2);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("afFilePath is " + localIOException);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("manifestFilePath is " + str1);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("targetFile is " + (String)localObject3);
            QLog.i("MaxVideo.Plugin", 2, ((StringBuilder)localObject4).toString());
          }
          if (i != 0) {
            continue;
          }
          QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "record_success", "0", null);
          switch (i)
          {
          default: 
            i = 0;
            if (i == 5103) {
              break label47;
            }
            a(i, (String)localObject3);
            return;
            label1300:
            localFile = new File((String)localObject4).getParentFile();
            localObject3 = localObject4;
            if (localFile == null) {
              break label720;
            }
            localObject3 = localObject4;
            if (localFile.exists()) {
              break label720;
            }
            localFile.mkdirs();
            localObject3 = localObject4;
          }
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        i = -1;
        continue;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        localNoSuchMethodError.printStackTrace();
        i = -1;
        continue;
        QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "record_hw_success", "1", i + "_" + Build.MODEL);
        continue;
        localObject4 = localIOException;
        continue;
        QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "record_sw_success", "1", i + "_" + Build.MODEL);
        continue;
        QzoneVideoBeaconReport.a(GloableValue.a + "", "qzone_video_record", "record_success", "1", i + "_" + Build.MODEL);
        continue;
        j = 0;
        i = j;
        if (!this.jdField_c_of_type_Boolean) {
          continue;
        }
        FileUtils.a(this.jdField_b_of_type_JavaLangString);
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread encode success delete cache...");
        i = j;
        continue;
        i = 5104;
        continue;
        i = 5105;
        continue;
        i = 5106;
        continue;
        i = 5107;
        continue;
        i = 5103;
        continue;
      }
      i = 0;
      j = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\EncodeThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */