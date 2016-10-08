package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.EncodeHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import piz;
import pja;

public class SendVideoActivity$SendBlessPTVTask
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Intent jdField_a_of_type_AndroidContentIntent;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  String c;
  
  public SendVideoActivity$SendBlessPTVTask(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidContentIntent = paramBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_business_type", 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "SendBlessPTVTask ");
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new pja(paramContext), null).show();
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    paramVarArgs = null;
    boolean bool2 = true;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject4 = (BaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject4 == null) {
      return Integer.valueOf(5);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_existed_bless_ptv", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "SendBlessPTVTask, isExistedPlessPTV is true");
      }
      return Integer.valueOf(1);
    }
    SendVideoActivity.a(this.jdField_a_of_type_AndroidContentIntent);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.L = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_frame_count", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.K = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_record_time", 0);
    if (!FileUtils.b(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(2);
    }
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject1);
    ((URLDrawable)localObject1).downloadImediatly();
    if (((URLDrawable)localObject1).getStatus() == 1)
    {
      localObject1 = ShortVideoBusiManager.a(0, this.jdField_a_of_type_Int);
      localObject2 = ShortVideoBusiManager.a(this.jdField_a_of_type_AndroidContentIntent, (ShortVideoReq)localObject1);
      ((ShortVideoUploadInfo)localObject2).d = true;
      ((ShortVideoUploadInfo)localObject2).b = false;
      ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)new AioShortVideoOperator(((BaseActivity)localObject4).app).a((ShortVideoUploadInfo)localObject2));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo instanceof MessageForBlessPTV))
      {
        ((MessageForBlessPTV)this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo).uinList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bless_uin_list");
        ((MessageForBlessPTV)this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo).videoFileName = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendBlessPTVTask# run(): ShortVideoReq and mr success");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)) {
        break label981;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo instanceof MessageForBlessPTV))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label384;
        }
      }
      if (FileUtils.b((String)localObject2)) {
        return Integer.valueOf(5);
      }
    }
    else
    {
      return Integer.valueOf(2);
    }
    LogTag.a();
    localObject1 = new EncodeThread((Context)localObject4, new ShortVideoPTVItemBuilder.EncodeHandler(Looper.getMainLooper()), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mVideoFileSourceDir, null, null);
    ((EncodeThread)localObject1).run();
    Object localObject2 = ((EncodeThread)localObject1).jdField_a_of_type_JavaLangString;
    LogTag.a("SendVideoActivity", "EncodeThread");
    localObject1 = localObject2;
    if (!FileUtils.b((String)localObject2)) {
      return Integer.valueOf(8);
    }
    label384:
    localObject2 = new File((String)localObject1);
    long l = ((File)localObject2).length();
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendVideoActivity", 2, "mVideoSize = 0");
      }
      return Integer.valueOf(8);
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder().append("videoFile ");
      if (localObject2 != null) {
        break label599;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("SendVideoActivity", 2, bool1 + " size: " + l);
      try
      {
        localObject2 = new FileInputStream((File)localObject2);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("FileInputStream ");
          bool1 = bool3;
          if (localObject2 == null) {
            bool1 = true;
          }
          QLog.d("SendVideoActivity", 2, bool1);
        }
        if (localObject2 == null) {
          break label845;
        }
        localObject2 = HexUtil.bytes2HexStr(MD5.toMD5Byte((InputStream)localObject2, l));
        paramVarArgs = (Void[])localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label845;
        }
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "processThumb: mVideoMd5 is empty, " + (String)localObject2);
        }
        return Integer.valueOf(5);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        label599:
        localFileNotFoundException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SendVideoActivity", 2, "FileNotFoundException ");
        localFileNotFoundException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label675;
        }
        Object localObject3 = new StringBuilder().append("FileInputStream ");
        bool1 = bool4;
        if (0 != 0) {
          break label660;
        }
        bool1 = true;
        QLog.d("SendVideoActivity", 2, bool1);
        if (0 == 0) {
          break label845;
        }
        localObject3 = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l));
        paramVarArgs = (Void[])localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label845;
        }
        if (!QLog.isColorLevel()) {
          break label730;
        }
        QLog.e("SendVideoActivity", 2, "processThumb: mVideoMd5 is empty, " + (String)localObject3);
        return Integer.valueOf(5);
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label779;
        }
        localObject1 = new StringBuilder().append("FileInputStream ");
        if (0 != 0) {
          break label837;
        }
        for (bool1 = bool2;; bool1 = false)
        {
          QLog.d("SendVideoActivity", 2, bool1);
          if (0 == 0) {
            break;
          }
          localObject1 = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("SendVideoActivity", 2, "processThumb: mVideoMd5 is empty, " + (String)localObject1);
          }
          return Integer.valueOf(5);
        }
      }
    }
    label660:
    label675:
    label730:
    label779:
    label837:
    label845:
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "FileInputStream： mVideoMd5" + this.jdField_b_of_type_JavaLangString + " mVideoPath: " + this.c);
    }
    this.jdField_b_of_type_JavaLangString = paramVarArgs;
    this.c = ((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize = ((int)l);
    if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath))
    {
      paramVarArgs = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg");
      if (!paramVarArgs.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath))
      {
        if (!FileUtils.c(paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath)) {
          return Integer.valueOf(5);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath = paramVarArgs;
      }
    }
    label981:
    return Integer.valueOf(1);
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131558973);
        this.jdField_a_of_type_AndroidAppProgressDialog.setOnKeyListener(new piz(this));
        this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "onPostExecute, result: " + paramInteger);
        }
        switch (paramInteger.intValue())
        {
        case 7: 
        default: 
          return;
        }
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      paramInteger = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramInteger != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("SendVideoActivity", 2, "QQAppInterface is null...");
    return;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_existed_bless_ptv", false))
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = MessageRecordFactory.b(paramInteger, (String)localObject, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin"), i);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo instanceof MessageForBlessPTV)) {
        ((MessageForBlessPTV)this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo).uinList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bless_uin_list");
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("existed_bless_ptv_msgdata");
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.doParse();
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (!SendVideoActivity.a()))
      {
        localObject = (SendVideoActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        SendVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
        localObject = ShortVideoBusiManager.a(0, 3);
        ShortVideoUploadInfo localShortVideoUploadInfo = ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (ShortVideoReq)localObject);
        localShortVideoUploadInfo.d = true;
        localShortVideoUploadInfo.b = false;
        ((ShortVideoReq)localObject).a(localShortVideoUploadInfo);
        ShortVideoBusiManager.a((ShortVideoReq)localObject, paramInteger);
        return;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_b_of_type_JavaLangString;
          localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          if (!this.c.equals(localObject))
          {
            FileUtils.c(this.c, (String)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("SendVideoActivity", 2, "onPostExecute destVideoPath " + (String)localObject);
            }
          }
          com.tencent.mobileqq.activity.BlessPTVActivity.l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
          com.tencent.mobileqq.activity.BlessPTVActivity.m = (String)localObject;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
          i = 1;
        }
      }
      else
      {
        if (SendVideoActivity.a() == null) {
          break;
        }
        SendVideoActivity.a().sendEmptyMessage(1);
        return;
        b((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 2131371525);
        return;
        b((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 2131371532);
        return;
        b((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 2131371530);
        return;
        b((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 2131371533);
        return;
      }
      i = 0;
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 2131370344);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\SendVideoActivity$SendBlessPTVTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */