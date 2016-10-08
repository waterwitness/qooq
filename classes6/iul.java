import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.NewStoryCameraGlFilterListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iul
  implements Runnable
{
  public iul(NewStoryCameraGlFilterListener paramNewStoryCameraGlFilterListener, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        NewStoryCameraGlFilterListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener).setText(this.jdField_a_of_type_JavaLangString);
        NewStoryCameraGlFilterListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener).setVisibility(0);
      }
      return;
    }
    NewStoryCameraGlFilterListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener).setText("");
    NewStoryCameraGlFilterListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */