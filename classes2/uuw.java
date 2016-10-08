import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class uuw
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public uuw(AbsShareMsg paramAbsShareMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    Object localObject1;
    Context localContext;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!AbsShareMsg.class.isInstance(localObject1)));
        localObject1 = (AbsShareMsg)localObject1;
        localContext = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localContext)) && (!ChatActivity.class.isInstance(localContext)));
      if (localContext == null)
      {
        QLog.e("StructMsg", 1, "context is null, never do click, return");
        return;
      }
      localObject2 = ((FragmentActivity)localContext).getChatFragment();
      if (localObject2 == null)
      {
        QLog.e("StructMsg", 1, "context.getChatFragment is null, never do click, return");
        return;
      }
      localObject2 = ((ChatFragment)localObject2).a();
    } while (localObject2 == null);
    Object localObject3 = new uux(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, (QQAppInterface)localObject2, paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAction;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "mSourceOnClickListener sourceAction = " + paramView);
    }
    if ("app".equals(paramView)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        paramView = new Intent(localContext, VipComicJumpActivity.class);
        paramView.putExtra("options", "{\"from\":28}");
        localContext.startActivity(paramView);
        localObject3 = AIOGallerySceneWithBusiness.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData);
        if ((localObject3 != null) && (localObject3.length >= 8))
        {
          if (!localObject3[7].equals("link")) {
            break label689;
          }
          paramView = localObject3[4];
        }
      }
    }
    for (;;)
    {
      VipComicReportUtils.a(null, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, localContext, "3009", "2", "40059", localObject3[0], new String[] { localObject3[2], localObject3[4], paramView });
      paramView = "";
      label321:
      ReportCenter.a().a(((QQAppInterface)localObject2).getAccount(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid), "1000", "80", "0", false);
      for (;;)
      {
        Util.a((QQAppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "sourceclick", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID, paramView);
        ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
        ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID + "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.adverSign == 1) {
          ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.uin, "0X800631F", "0X800631F", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.msgId, "", "", "");
        }
        if ((!(localObject1 instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localObject1).mIsPAVideoStructMsg)) {
          break label915;
        }
        paramView = (StructMsgForGeneralShare)localObject1;
        localObject3 = paramView.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
          if ((localObject4 instanceof StructMsgItemLayout5))
          {
            localObject4 = ((StructMsgItemLayout5)localObject4).a.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (AbsStructMsgElement)((Iterator)localObject4).next();
              if ((localObject5 instanceof StructMsgItemVideo))
              {
                localObject5 = (StructMsgItemVideo)localObject5;
                if (((StructMsgItemVideo)localObject5).a()) {
                  VideoReporter.a("0X80065FE", paramView.uinType, VideoReporter.a(((StructMsgItemVideo)localObject5).n, paramView.mSourceName), ((StructMsgItemVideo)localObject5).cY, "");
                }
              }
            }
          }
        }
        label689:
        if ((!localObject3[7].equals("scrawl_link")) || (localObject3.length < 9)) {
          break label1021;
        }
        paramView = localObject3[8];
        break;
        if (((uux)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData))
        {
          paramView = "run";
          break label321;
        }
        if (((uux)localObject3).a(((FragmentActivity)localContext).getActivity(), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid, ((AbsShareMsg)localObject1).mSourceName, ((AbsShareMsg)localObject1).mSourceActionData, ((AbsShareMsg)localObject1).mSource_A_ActionData))
        {
          paramView = "setup";
          break label321;
        }
        ((uux)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
        paramView = "setup";
        break label321;
        if ("web".equals(paramView))
        {
          ((uux)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl);
          paramView = "setup";
        }
        else if ("plugin".equals(paramView))
        {
          ((uux)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
          paramView = "plugin";
        }
        else
        {
          ((uux)localObject3).a(paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceActionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSource_A_ActionData);
        }
      }
      label915:
      if ((((AbsShareMsg)localObject1).mMsgServiceID != 81) || (localObject1 == null) || (TextUtils.isEmpty(((AbsShareMsg)localObject1).mMsg_A_ActionData))) {
        break;
      }
      localObject1 = JumpParser.a((QQAppInterface)localObject2, localContext, ((AbsShareMsg)localObject1).mMsg_A_ActionData);
      if (localObject1 == null) {
        break;
      }
      paramView = ((JumpAction)localObject1).a("usertype");
      localObject1 = ((JumpAction)localObject1).a("unionid");
      if ((TextUtils.isEmpty(paramView)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break;
      }
      int i = 0;
      try
      {
        int j = Integer.parseInt(paramView);
        i = j;
      }
      catch (NumberFormatException paramView)
      {
        for (;;) {}
      }
      StoryReportor.a("share_uin_obj", "clk_tail", 0, i, new String[] { localObject1 });
      return;
      label1021:
      paramView = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uuw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */