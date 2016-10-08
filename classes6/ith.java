import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ith
  implements View.OnClickListener
{
  public ith(StoryListPresenter paramStoryListPresenter, StoryItem paramStoryItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131305446: 
    case 2131305447: 
      do
      {
        do
        {
          return;
          paramView = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a, QQStoryShieldActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.user.uid + "");
          paramView.putExtra("from", 2);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a.startActivityForResult(paramView, 1001);
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.type == 1)
          {
            StoryReportor.a("last_update", "clk_block", 0, 0, new String[0]);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.type != 0);
        StoryReportor.a("friend_story", "clk_block", 0, 0, new String[0]);
        return;
        StoryListPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a, "" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.user.uid);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.type == 1)
        {
          StoryReportor.a("last_update", "send_msg", 0, 0, new String[0]);
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.type != 0);
      StoryReportor.a("friend_story", "send_msg", 0, 0, new String[0]);
      return;
    }
    paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a, 230);
    paramView.setTitle("取消订阅");
    paramView.setMessage("取消订阅后将不再收到其更新的内容");
    paramView.setPositiveButton("不再订阅", new iti(this));
    paramView.setNegativeButton("仍然订阅", new itj(this));
    paramView.show();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ith.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */