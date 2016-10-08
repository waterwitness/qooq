import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.PttMsgAdapter;
import com.tencent.mobileqq.hotchat.PttMsgAdapter.ViewHolder;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotchat.ui.GlowView.InnerViewOnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;

public class suk
  implements GlowView.InnerViewOnClickListener
{
  public suk(HotChatPttStageControl paramHotChatPttStageControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a(PttMsgAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null)) {}
    PttShowRoomMng localPttShowRoomMng;
    do
    {
      return null;
      localPttShowRoomMng = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
    } while (localPttShowRoomMng == null);
    return localPttShowRoomMng.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.senderuin);
  }
  
  public void a(View paramView)
  {
    paramView = (PttMsgAdapter.ViewHolder)((GlowView)paramView.getParent().getParent()).getTag();
    MessageForPtt localMessageForPtt;
    int i;
    if ((paramView instanceof PttMsgAdapter.ViewHolder))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttShow", 2, "onClick isAutoPlay=" + this.a.f + ",pttmsg=" + paramView.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.toString());
      }
      this.a.f = false;
      localMessageForPtt = paramView.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      i = PttItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      if ((i != 1004) && (i != 1005)) {
        break label129;
      }
      a(paramView);
    }
    label129:
    do
    {
      do
      {
        return;
        if ((i == 2004) || (i == 2005))
        {
          a(paramView);
          return;
        }
      } while ((i != 1003) && (i != 2003));
      if (!localMessageForPtt.isReady())
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, "发生异常，请稍后重试。", 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localMessageForPtt))
      {
        this.a.i();
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006580", "0X8006580", 0, 0, "", "", "", "");
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(localMessageForPtt));
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, 2131368056, 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
    }
    for (;;)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800657F", "0X800657F", 0, 0, "", "", "", "");
      return;
      if (this.a.h >= 0) {
        this.a.i();
      }
      this.a.d = true;
      if (!this.a.a(localMessageForPtt, paramView.jdField_a_of_type_Int))
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, 2131368057, 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        this.a.d = false;
      }
      else
      {
        this.a.f = true;
        this.a.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramView, true);
        this.a.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.b(paramView, true);
      }
    }
  }
  
  public void a(PttMsgAdapter.ViewHolder paramViewHolder)
  {
    MessageForPtt localMessageForPtt = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    if (localMessageForPtt == null) {}
    while ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      return;
    }
    if (localMessageForPtt.isSendFromLocal())
    {
      paramViewHolder = ActionSheet.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.a(2131367890);
      paramViewHolder.c(2131367889);
      paramViewHolder.d(2131367262);
      paramViewHolder.a(new sul(this, localMessageForPtt, paramViewHolder));
      paramViewHolder.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131367686, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131367687, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
      return;
    }
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localMessageForPtt, false, 1, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatPttStageControl", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqHotchatPttMsgAdapter.a(paramViewHolder, 2001, localMessageForPtt);
  }
  
  public boolean a(View paramView)
  {
    paramView = ((GlowView)paramView.getParent().getParent()).getTag();
    if ((paramView != null) && ((paramView instanceof PttMsgAdapter.ViewHolder)))
    {
      localObject = (PttMsgAdapter.ViewHolder)paramView;
      if ((((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null) && (!TextUtils.isEmpty(((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.senderuin))) {}
    }
    else
    {
      return true;
    }
    paramView = ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.senderuin;
    Object localObject = ((PttMsgAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin;
    ActionSheet localActionSheet = ActionSheet.a(this.a.jdField_a_of_type_AndroidContentContext);
    localActionSheet.c(2131372439);
    localActionSheet.d(2131367262);
    localActionSheet.a(new sum(this, (String)localObject, paramView, localActionSheet));
    localActionSheet.show();
    return true;
  }
  
  public boolean a(PttMsgAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null)) {
      return true;
    }
    return this.a.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.senderuin);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */