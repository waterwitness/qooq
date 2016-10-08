package com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.CameraGlFilterListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iuj;
import iuk;
import iul;

public class NewStoryCameraGlFilterListener
  extends NewStoryPart
  implements CameraFilterGLView.CameraGlFilterListener
{
  protected static final String a = "Q.qqstory.record.NewStoryCameraGlFilterListener";
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public NewStoryCameraGlFilterListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.t;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.record.NewStoryCameraGlFilterListener", "filterSurfaceCreateOK");
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    SLog.b("Q.qqstory.record.NewStoryCameraGlFilterListener", "filterTriggerTypeTips, show=" + paramBoolean + ", message=" + paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.runOnUiThread(new iul(this, paramBoolean, paramString));
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.record.NewStoryCameraGlFilterListener", "filterFirstFrameOK");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.n();
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_AndroidViewView = a(2131301607);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131302869));
  }
  
  public void c()
  {
    SLog.b("Q.qqstory.record.NewStoryCameraGlFilterListener", "filterAllMemoryBufferIsFree isCanPreview=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.runOnUiThread(new iuj(this));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a = false;
  }
  
  public void h_(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.record.NewStoryCameraGlFilterListener", "filterDetectedFace, detected=" + paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.runOnUiThread(new iuk(this, paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryCameraGlFilterListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */