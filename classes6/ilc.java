import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.pgc.ShareUtil;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.share.StoryAccountShare;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.widget.ActionSheet;

public class ilc
  implements AdapterView.OnItemClickListener
{
  public ilc(ShareUtil paramShareUtil, UserInfo paramUserInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131369529;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_Int = -1;
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131369530;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_Int = ((int)paramLong);
        paramAdapterView = new StoryAccountShare(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo);
        switch (this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          StoryReportor.a("share_uin", "clk_plat", this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_Int + 1, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId });
          return;
          paramAdapterView.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_AndroidContentContext);
          continue;
          paramView = (QQAppInterface)BaseApplicationImpl.a().a();
          paramAdapterView.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_AndroidContentContext, paramView);
          continue;
          paramAdapterView.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryPgcShareUtil.jdField_a_of_type_Int);
        }
      }
      paramInt = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */