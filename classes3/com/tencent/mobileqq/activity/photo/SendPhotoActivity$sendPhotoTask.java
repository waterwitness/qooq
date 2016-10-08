package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.widget.TextView;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import osm;

public class SendPhotoActivity$sendPhotoTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  public ProgressDialog a;
  public Intent a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public WeakReference a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  int b;
  public ArrayList b;
  public boolean b;
  public ArrayList c;
  public boolean c;
  
  public SendPhotoActivity$sendPhotoTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidContentIntent = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", 1003);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("send_in_background", false);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    if (QLog.isColorLevel()) {
      QLog.d(SendPhotoActivity.a, 2, " sendPhotoTask(),  mBusiType :" + this.jdField_a_of_type_Int + ", mNeedCompress:" + this.jdField_a_of_type_Boolean + ", mCurType:" + this.jdField_b_of_type_Int + ",mIsWaitForResult:" + this.jdField_b_of_type_Boolean + ",picQualityType: " + i + ",mSendBackground = " + this.jdField_c_of_type_Boolean + "mPaths :" + Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()));
    }
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131370344);
  }
  
  private void a(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    boolean bool1 = false;
    int i = -1;
    if (paramPicReq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(SendPhotoActivity.a, 2, "sendPhoto,sendReq is null,return!");
      }
      return;
    }
    Object localObject;
    ArrayList localArrayList;
    if (paramPicReq.a.jdField_b_of_type_Int == 9501)
    {
      localObject = (DeviceMsgHandle)paramBaseActivity.app.a(49);
      localArrayList = new ArrayList();
      localArrayList.add(paramPicReq.a.g);
      ((DeviceMsgHandle)localObject).a().a(DeviceMsgHandle.d, paramPicReq.a.c, localArrayList);
      paramBaseActivity.finish();
      return;
    }
    int j;
    if (((paramPicReq.n == 2) || (paramPicReq.n == 4)) && ((paramPicReq.a.jdField_b_of_type_Int == 9500) || (paramPicReq.a.jdField_b_of_type_Int == 9501)))
    {
      localObject = paramBaseActivity.getIntent();
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
      ((Intent)localObject).putExtra("uin", paramPicReq.a.c);
      localArrayList = new ArrayList();
      localArrayList.add(paramPicReq.a.g);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      ((Intent)localObject).addFlags(603979776);
      ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
      j = ((Intent)localObject).getIntExtra(AlbumConstants.i, -1);
      if ((j != 80) && (j != 82)) {
        ((Intent)localObject).putExtra(AlbumConstants.i, 82);
      }
      paramBaseActivity.startActivityForResult((Intent)localObject, 2);
    }
    for (;;)
    {
      try
      {
        localObject = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
        this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject);
        boolean bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (bool2) {
          i = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        }
        if (paramPicReq.a == null) {
          break;
        }
        j = this.jdField_b_of_type_Int;
        if (paramPicReq.a.i == 2) {
          bool1 = true;
        }
        StatisticConstants.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      PicBusiManager.a(paramPicReq, paramBaseActivity.app);
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(SendPhotoActivity.a, 2, "TestPicSend finish compress,currentTime = " + System.currentTimeMillis());
      }
    } while ((this.jdField_a_of_type_AndroidAppProgressDialog == null) || (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()));
    this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
        {
          a();
          if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
            break;
          }
          this.jdField_a_of_type_AndroidAppProgressDialog.show();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Logger.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", paramContext.toString());
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131558973);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(SendPhotoActivity.a, 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("presend_handler"))
    {
      if (QLog.isColorLevel()) {
        QLog.d(SendPhotoActivity.a, 2, "presendPic ,sendPhotoTask return directly!");
      }
      return;
    }
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!FileUtils.b(str))
      {
        QLog.e(SendPhotoActivity.a, 2, "sendPhotoTask. path invalid,path:" + str);
      }
      else
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", str);
        PicReq localPicReq = PicBusiManager.a(2, this.jdField_a_of_type_Int);
        PicUploadInfo localPicUploadInfo = PicBusiManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
        if (!localPicReq.a(localPicUploadInfo))
        {
          QLog.e(SendPhotoActivity.a, 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          CompressInfo localCompressInfo = PicBusiManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
          if (localCompressInfo == null)
          {
            QLog.e(SendPhotoActivity.a, 2, "sendPhotoTask. compressInfo is null!");
          }
          else
          {
            localCompressInfo.j = this.jdField_b_of_type_Int;
            localCompressInfo.jdField_g_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d(SendPhotoActivity.a, 2, "SendPhoto,compressInfo.uinType" + localCompressInfo.j);
            }
            if (QLog.isColorLevel()) {
              QLog.d(SendPhotoActivity.a, 2, "sendPhotoTask, compress start.compressInfo.src = " + localCompressInfo.c);
            }
            RichmediaService.a(localCompressInfo);
            localPicUploadInfo.g = localCompressInfo.jdField_e_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.d(SendPhotoActivity.a, 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + localPicUploadInfo.g);
            }
            if ((localCompressInfo.jdField_g_of_type_Int != 2) && (PeakUtils.a(localCompressInfo.jdField_e_of_type_JavaLangString))) {
              LogTag.a();
            }
            try
            {
              localPicUploadInfo.jdField_a_of_type_JavaUtilArrayList = PeakUtils.a(localCompressInfo.jdField_e_of_type_JavaLangString);
              if ((localPicUploadInfo.jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
                QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + localPicUploadInfo.jdField_a_of_type_JavaUtilArrayList.toString());
              }
              LogTag.a("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + localCompressInfo.jdField_e_of_type_JavaLangString + ")");
              this.jdField_b_of_type_JavaUtilArrayList.add(str);
              this.jdField_c_of_type_JavaUtilArrayList.add(localCompressInfo);
              if (localCompressInfo.jdField_e_of_type_Boolean)
              {
                localPicUploadInfo.h = 1;
                Logger.a(localPicUploadInfo, "fixProtocolType", "sendReq.upInfo.protocolType");
                a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localPicReq);
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + localCompressInfo.jdField_e_of_type_JavaLangString + "'s size is " + FileUtils.a(localCompressInfo.jdField_e_of_type_JavaLangString));
                  continue;
                  localPicUploadInfo.h = localPicUploadInfo.a();
                }
              }
            }
          }
        }
        else
        {
          localPicUploadInfo.g = str;
          this.jdField_b_of_type_JavaUtilArrayList.add(str);
          a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localPicReq);
        }
      }
    }
    Logger.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l));
    SendPhotoActivity.a();
    SendPhotoActivity.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaUtilArrayList);
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).runOnUiThread(new osm(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\SendPhotoActivity$sendPhotoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */