package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import pix;
import pjb;

public class SendVideoActivity
  extends BaseActivity
  implements Handler.Callback
{
  static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 45000L;
  private static MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private static MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  public static final String a = "SendVideoActivity";
  static final int jdField_b_of_type_Int = 2;
  private static boolean jdField_b_of_type_Boolean = false;
  static final int c = 3;
  static final int d = 4;
  static final int e = 6;
  static final int f = 5;
  static final int g = 8;
  private static final int h = 1;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  boolean jdField_a_of_type_Boolean;
  
  public SendVideoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      CodecParam.D = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      CodecParam.E = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      CodecParam.F = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      CodecParam.G = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      CodecParam.H = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      CodecParam.I = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      CodecParam.J = i;
    }
    CodecParam.M = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    CodecParam.N = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    CodecParam.O = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    CodecParam.P = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    CodecParam.Q = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    CodecParam.a(paramIntent.getBooleanExtra("sv_encode_baseline_mp4", false));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("file_send_business_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "doOnCreate(), ===>> busiType=" + i + ",VideoFileDir = " + getIntent().getStringExtra("file_video_source_dir"));
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
      }
      return true;
      new SendVideoActivity.SendVideoTask(this, null).execute(new Void[0]);
      continue;
      paramBundle = getIntent().getStringExtra("activity_before_enter_send_video");
      if ((paramBundle != null) && (ShortVideoPreviewActivity.class.getName().equals(paramBundle)))
      {
        new SendVideoActivity.SendAppShortVideoTask(this).execute(new Void[0]);
      }
      else
      {
        ThreadManager.b().post(new pjb(this, null));
        continue;
        String str = getIntent().getStringExtra("uin");
        ArrayList localArrayList = getIntent().getStringArrayListExtra("bless_uin_list");
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("doOnCreate, uin= ").append(str).append(" uinList= ");
          if (localArrayList == null) {
            break label368;
          }
        }
        label368:
        for (paramBundle = localArrayList.toString();; paramBundle = null)
        {
          QLog.d("SendVideoActivity", 2, paramBundle);
          if ((str == null) || (!str.equals("0")) || (localArrayList == null)) {
            break label445;
          }
          int j = getIntent().getIntExtra("uintype", -1);
          if (j == 0) {
            break label373;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "doOnCreate error, uinType= " + j + " busiType= " + i);
          }
          finish();
          break;
        }
        label373:
        jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
        b = false;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new pix(this);
        this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        new SendVideoActivity.SendBlessPTVTask(this.app, this).execute(new Void[0]);
        jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1, 45000L);
        continue;
        label445:
        ThreadManager.b().post(new pjb(this, null));
        continue;
        ThreadManager.b().post(new pjb(this, null));
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        paramMessage = this.app.a().a(jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        if ((paramMessage != null) && (ShortVideoUploadProcessor.class.isInstance(paramMessage)))
        {
          boolean bool = ((BaseTransProcessor)paramMessage).c();
          int i = jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus;
          if ((bool) || (i == 1002) || (i == 1001)) {
            this.app.a().c(jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          }
        }
      }
      b = true;
      setResult(-2);
      finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\SendVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */