import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.PgcSearchActivity;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.pgc.adapter.SearchResultAdapter;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;

public class ilh
  implements View.OnClickListener
{
  public ilh(SearchResultAdapter paramSearchResultAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    UserInfo localUserInfo;
    if ((localObject != null) && ((localObject instanceof UserInfo))) {
      localUserInfo = (UserInfo)localObject;
    }
    switch (paramView.getId())
    {
    default: 
    case 2131298071: 
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.isFinishing());
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(localUserInfo, 4);
      StoryReportor.a("search", "clk_card", this.a.jdField_a_of_type_Int, localUserInfo.type, new String[] { String.valueOf(localUserInfo.unionId) });
      return;
    }
    if (NetworkUtil.h(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity))
    {
      int i;
      if (SearchResultAdapter.a(this.a, paramView))
      {
        i = 1;
        if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity instanceof QQStoryDiscoverActivity)) {
          break label333;
        }
        ((QQStoryDiscoverActivity)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity).a(localUserInfo, i);
        label195:
        if (i != 1) {
          break label365;
        }
      }
      label333:
      label365:
      for (localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getResources().getDrawable(2130838321);; localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity.getResources().getDrawable(2130838319))
      {
        SearchResultAdapter.a(this.a, (ImageView)paramView.findViewById(2131302846));
        SearchResultAdapter.a(this.a, (TextView)paramView.findViewById(2131297202));
        SearchResultAdapter.a(this.a).setImageDrawable((Drawable)localObject);
        ((Animatable)localObject).start();
        SearchResultAdapter.a(this.a).setVisibility(8);
        SearchResultAdapter.a(this.a).setVisibility(0);
        StoryReportor.a("search", "follow", this.a.jdField_a_of_type_Int, localUserInfo.type, new String[] { String.valueOf(localUserInfo.unionId) });
        return;
        i = 0;
        break;
        if (!(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity instanceof PgcSearchActivity)) {
          break label195;
        }
        ((PgcSearchActivity)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryBaseActivity).a(localUserInfo, i);
        break label195;
      }
    }
    ToastUtil.a().a("当前网络不可用，请检查你的网络设置");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */