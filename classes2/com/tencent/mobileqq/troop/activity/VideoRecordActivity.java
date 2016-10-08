package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import vku;
import vkv;

public class VideoRecordActivity
  extends FlowCameraActivity2
  implements View.OnClickListener
{
  public static final String e = "time_limit";
  public static final String f = "video_path";
  public static final String g = "video_record_type";
  public static final int r = 1048576;
  public static final int s = 160768;
  private EncodeThread jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceEncodeThread;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected final String d;
  private String h;
  private boolean q;
  private int t;
  private int u;
  private int v;
  
  public VideoRecordActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = "VideoRecordActivity";
    this.t = 30000;
    this.u = 30;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (this.v == 1)
    {
      this.b.setText("");
      this.b.setBackgroundResource(2130839091);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.i = 10;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.i, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.i, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.b = localBitmap;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.a = localBitmap;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoRecordActivity", 2, "previewSizeAdjustUI exp:", localThrowable);
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (this.v == 1)
    {
      this.b.setText("");
      this.b.setBackgroundResource(2130839091);
    }
  }
  
  public void a(String paramString)
  {
    Toast.makeText(VideoEnvironment.a(), paramString, 1).show();
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    if (this.v == 1)
    {
      this.b.setText("");
      this.b.setBackgroundResource(2130839091);
      this.q = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131301332) && (this.v == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
        return;
      }
      if (!this.q)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
        this.b.setText("");
        this.b.setBackgroundResource(2130839092);
        this.q = true;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      this.b.setText("");
      this.b.setBackgroundResource(2130839091);
      this.q = false;
      return;
    }
    if (paramView.getId() == 2131301599)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
        this.h = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
        RecordManager.a().a().recordSubmit();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
        {
          CodecParam.K = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double;
          CodecParam.L = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
        }
        ThreadManager.a(new vku(this), 5, null, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new vkv(this, this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131364820, new Object[] { Integer.valueOf(0) }));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(f());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      QQToast.a(this, 2131364821, 0).a();
      a(this);
      return;
    }
    super.onClick(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.t = localIntent.getIntExtra("time_limit", 30000);
      this.v = localIntent.getIntExtra("video_record_type", 0);
    }
    com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.d = 1048576;
    super.onCreate(paramBundle);
    y();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, "1", this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar.setMax(CodecParam.g, this.t);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.j.setOnClickListener(this);
    if (this.v == 1)
    {
      this.b.setText("");
      this.b.setOnTouchListener(null);
      this.b.setLongClickable(false);
      this.b.setOnClickListener(this);
    }
    RecordManager.a().a().b();
    RecordManager.a().a();
    RecordManager.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    RecordManager.a().a().a();
  }
  
  protected void onDestroy()
  {
    com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.d = 160768;
    com.tencent.mobileqq.shortvideo.common.GloableValue.a = -1L;
    super.onDestroy();
  }
  
  public void y()
  {
    CodecParam.g = this.u;
    CodecParam.d = this.t;
    com.tencent.mobileqq.shortvideo.common.GloableValue.a = -1L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\VideoRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */