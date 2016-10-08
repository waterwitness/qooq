import android.util.SparseArray;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ior
  extends QQStoryObserver
{
  public ior(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo)
  {
    if ((paramBoolean) && (paramUserInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      Object localObject2 = localUserManager.c(this.a.jdField_b_of_type_Long);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new QQUserUIItem();
        ((QQUserUIItem)localObject1).isVip = true;
        ((QQUserUIItem)localObject1).uid = this.a.jdField_b_of_type_Long;
        ((QQUserUIItem)localObject1).setUnionId(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId);
      }
      ((QQUserUIItem)localObject1).headUrl = this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.headUrl;
      ((QQUserUIItem)localObject1).nickName = this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick;
      ((QQUserUIItem)localObject1).remark = this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark;
      localUserManager.a((QQUserUIItem)localObject1);
      localObject2 = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
      if (localObject2 != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2, (QQUserUIItem)localObject1);
      }
      if (this.a.K - 1 >= 0)
      {
        localObject2 = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(this.a.K - 1);
        if (localObject2 != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2, (QQUserUIItem)localObject1);
        }
      }
      if (this.a.K + 1 < StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size())
      {
        localObject2 = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(this.a.K + 1);
        if (localObject2 != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2, (QQUserUIItem)localObject1);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView == null) {
        break label326;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, this.a.jdField_b_of_type_Boolean);
    }
    label326:
    while (!this.a.jdField_b_of_type_Boolean) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this.a, this.a.app);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(paramUserInfo, false, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */