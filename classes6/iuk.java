import android.view.View;
import com.tencent.biz.qqstory.takevideo.NewStoryCameraGlFilterListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iuk
  implements Runnable
{
  public iuk(NewStoryCameraGlFilterListener paramNewStoryCameraGlFilterListener, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NewStoryCameraGlFilterListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener).setVisibility(8);
      return;
    }
    NewStoryCameraGlFilterListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener).setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */