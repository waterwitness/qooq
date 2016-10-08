import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iog
  implements DialogInterface.OnClickListener
{
  public iog(StoryPlayVideoActivity paramStoryPlayVideoActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.P);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a("");
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_JavaLangString)) {
      ((StoryVideoUploadManager)SuperManager.a(3)).a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.P);
      return;
      new DeleteStoryVideoHandler().a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */