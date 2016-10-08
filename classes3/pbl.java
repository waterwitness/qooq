import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.tools.QzoneBaseThread;
import com.tencent.mobileqq.shortvideo.tools.QzoneHandlerThreadFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class pbl
  implements Runnable
{
  pbl(pbk parampbk, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Pbk.a.a != null))
    {
      QLog.d("PTV.NewFlowCameraActivity", 2, "ret = " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Pbk.a.a.setVideoPath(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Pbk.a.a.seekTo(NewFlowCameraActivity.a(this.jdField_a_of_type_Pbk.a));
      this.jdField_a_of_type_Pbk.a.a.start();
      if ((!TextUtils.equals(this.jdField_a_of_type_Pbk.a.m, NewFlowCameraActivity.d())) && (!TextUtils.equals(this.jdField_a_of_type_Pbk.a.m, NewFlowCameraActivity.c(this.jdField_a_of_type_Pbk.a)))) {
        QzoneHandlerThreadFactory.a("Normal_HandlerThread").a(new pbm(this));
      }
      for (;;)
      {
        NewFlowCameraActivity.e(this.jdField_a_of_type_Pbk.a, true);
        NewFlowCameraActivity.a(this.jdField_a_of_type_Pbk.a, "608", "9", "0", true);
        return;
        this.jdField_a_of_type_Pbk.a.m = this.jdField_a_of_type_JavaLangString;
      }
    }
    QQToast.a(this.jdField_a_of_type_Pbk.a, "音乐合成失败，请稍后重试", 1).a();
    NewFlowCameraActivity.a(this.jdField_a_of_type_Pbk.a, "608", "9", "1", true);
    QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicToLocalVideo error ret = " + this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */