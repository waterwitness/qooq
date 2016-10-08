import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.playvideo.QQStoryCommentDialog;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class iod
  implements inz
{
  public iod(StoryPlayVideoActivity paramStoryPlayVideoActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQStoryCommentDialog paramQQStoryCommentDialog, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getApplicationContext(), 0, "请输入评论内容", 0).a();
      ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "play_video", "send_comment", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (NetworkUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getApplicationContext())) {
      StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, paramString);
    }
    for (;;)
    {
      paramQQStoryCommentDialog.dismiss();
      break;
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getApplicationContext(), 1, "消息发送失败，请稍后重试", 0).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */