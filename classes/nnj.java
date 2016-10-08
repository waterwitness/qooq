import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nnj
  implements View.OnClickListener
{
  long jdField_a_of_type_Long;
  
  public nnj(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)((BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView)).a;
    l = System.currentTimeMillis();
    if (localMessageForQQStoryComment.createTime * 1000L + 86400000L < l)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext, QQStoryWarningActivity.class);
      paramView.putExtra("tipsResource", 2131366434);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "clk", 0, 0, "", "", "", "");
      return;
    }
    paramView = localMessageForQQStoryComment.selfuin;
    if (localMessageForQQStoryComment.isSend()) {
      paramView = localMessageForQQStoryComment.frienduin;
    }
    for (;;)
    {
      StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext, localMessageForQQStoryComment.vid, new Long(paramView).longValue());
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */