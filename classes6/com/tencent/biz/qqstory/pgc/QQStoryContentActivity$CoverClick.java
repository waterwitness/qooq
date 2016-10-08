package com.tencent.biz.qqstory.pgc;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class QQStoryContentActivity$CoverClick
  implements View.OnClickListener
{
  protected int a;
  protected Story a;
  
  public QQStoryContentActivity$CoverClick(QQStoryContentActivity paramQQStoryContentActivity, int paramInt, Story paramStory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory = paramStory;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int + 1 < this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_Int + 1);
      StoryReportor.a("play_page", "clk", this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "1" });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.finish();
    StoryReportor.a("play_page", "clk", this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "2" });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\QQStoryContentActivity$CoverClick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */