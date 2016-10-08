import android.content.Context;
import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nsj
  implements ActionSheet.OnButtonClickListener
{
  public nsj(VideoItemBuilder paramVideoItemBuilder, VideoActionSheet paramVideoActionSheet, MessageForVideo paramMessageForVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramView = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
      if (paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.selfuin))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext.getString(2131363683);
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext, 230, null, paramView, 2131363532, 2131363160, new nsk(this), null).show();
        return;
      }
      if (paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false).a)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext.getString(2131363682);
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext, 230, null, paramView, 2131363532, 2131363160, new nsl(this), null).show();
        return;
      }
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo);
      return;
    }
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DC7", "0X8005DC7", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */