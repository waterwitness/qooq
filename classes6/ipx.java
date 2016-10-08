import android.view.View;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter;
import com.tencent.biz.qqstory.playvideo.watcherlist.WatcherItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipx
  extends ChildViewClickListener
{
  public ipx(QQStoryWatcherListAdapter paramQQStoryWatcherListAdapter, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramObject instanceof WatcherItem))
    {
      paramView = (WatcherItem)paramObject;
      paramObject = new UserInfo();
      ((UserInfo)paramObject).headUrl = paramView.b;
      ((UserInfo)paramObject).nick = paramView.jdField_a_of_type_JavaLangString;
      ((UserInfo)paramObject).uid = paramView.jdField_a_of_type_Long;
      ((UserInfo)paramObject).type = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListAdapter.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a((UserInfo)paramObject, false, 6, true, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */