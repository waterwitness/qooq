import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.comic.VipComicReportUtils;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public final class uvq
  implements View.OnClickListener
{
  public uvq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131296312);
    if (localObject1 == null) {}
    do
    {
      return;
      paramView = ((View)localObject1).getTag(2131296312);
    } while (!(paramView instanceof StructMsgForImageShare));
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)paramView;
    Context localContext = ((View)localObject1).getContext();
    int i;
    Intent localIntent;
    try
    {
      paramView = (QQAppInterface)((BaseApplicationImpl)localContext.getApplicationContext()).getAppRuntime(localStructMsgForImageShare.currentAccountUin);
      AbsShareMsg.doReport(paramView, localStructMsgForImageShare);
      if (localStructMsgForImageShare.msgId > 0L)
      {
        ReportController.b(paramView, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForImageShare.msgId), "");
        ThreadManager.b().postDelayed(new uvr(this, localStructMsgForImageShare, paramView), 0L);
      }
      ReportController.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForImageShare.mMsgServiceID + "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      i = 0;
      localObject2 = localStructMsgForImageShare.getFirstImageElement();
      if (localObject2 == null) {
        break label847;
      }
      if ((!MsgUtils.b(localStructMsgForImageShare.mIsSend)) && (((StructMsgItemImage)localObject2).a != null))
      {
        paramView = PicItemBuilder.a(localContext, ((StructMsgItemImage)localObject2).a);
        if (paramView != null) {
          if (paramView.getStatus() == 2)
          {
            paramView.restartDownload();
            return;
          }
        }
      }
    }
    catch (AccountNotMatchException paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramView.getStackTrace().toString());
        }
      }
      if ((paramView.getStatus() == 0) && (!paramView.isDownloadStarted()))
      {
        paramView.startDownload();
        return;
      }
      localIntent = new Intent(localContext, AIOGalleryActivity.class);
      localIntent.putExtra("curType", localStructMsgForImageShare.uinType);
      localIntent.putExtra("_id", localStructMsgForImageShare.uniseq);
      localIntent.putExtra("urlAtServer", ((StructMsgItemImage)localObject2).p);
      localIntent.putExtra("KEY_FILE_ID", ((StructMsgItemImage)localObject2).c);
      localIntent.putExtra("picMD5", ((StructMsgItemImage)localObject2).q);
      localIntent.putExtra("url", ((StructMsgItemImage)localObject2).o);
      localIntent.putExtra("friendUin", localStructMsgForImageShare.uin);
      localIntent.putExtra("KEY_MSG_VERSION_CODE", localStructMsgForImageShare.messageVersion);
      localIntent.putExtra("isSend", localStructMsgForImageShare.mIsSend);
      localIntent.putExtra("KEY_BUSI_TYPE", 1030);
      localIntent.putExtra("IS_FROMOTHER_TERMINAL_KEY", MsgUtils.c(localStructMsgForImageShare.mIsSend));
      localIntent.putExtra("uin", localStructMsgForImageShare.uin);
      if (localStructMsgForImageShare.mIsSend != 1) {
        break label1025;
      }
    }
    paramView = localStructMsgForImageShare.currentAccountUin;
    localIntent.putExtra("KEY_TROOP_CODE", paramView);
    localIntent.putExtra("fileSize", ((StructMsgItemImage)localObject2).d);
    localIntent.putExtra("KEY_TIME", ((StructMsgItemImage)localObject2).e);
    localIntent.putExtra("KEY_SUB_VERSION", 5);
    localIntent.putExtra("KEY_FILE_SIZE_FLAG", 0);
    localIntent.putExtra("uniSeq", localStructMsgForImageShare.uniseq);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a((View)localObject1));
    Object localObject2 = ((StructMsgItemImage)localObject2).a;
    if (localObject2 != null)
    {
      localIntent.addFlags(603979776);
      paramView = ((MessageForPic)localObject2).selfuin;
      if (!((MessageForPic)localObject2).isMultiMsg) {
        break label1074;
      }
    }
    label847:
    label1025:
    label1074:
    for (;;)
    {
      try
      {
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject1 = paramView;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject1 = ((AppRuntime)localObject3).getAccount();
        }
        paramView = (View)localObject1;
      }
      catch (Exception localException)
      {
        Object localObject3;
        String[] arrayOfString;
        int j;
        continue;
        if ((!arrayOfString[7].equals("scrawl_link")) || (arrayOfString.length < 9)) {
          continue;
        }
        String str = arrayOfString[8];
        continue;
        str = "";
        continue;
      }
      localObject3 = new AIOImageProviderService(paramView, ((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).istroop, (ChatMessage)localObject2);
      localObject2 = AIOGalleryUtils.a((MessageForPic)localObject2);
      if (localStructMsgForImageShare.message != null) {
        ((AIOImageData)localObject2).g = localStructMsgForImageShare.message.time;
      }
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        ((AIOImageData)localObject2).h = 1;
        ((AIOImageData)localObject2).a = localStructMsgForImageShare.getBytes();
        arrayOfString = AIOGallerySceneWithBusiness.a(localStructMsgForImageShare);
        ((AIOImageData)localObject2).j = AIOGallerySceneWithBusiness.a(arrayOfString);
        if ((arrayOfString != null) && (arrayOfString.length >= 8))
        {
          if (!arrayOfString[7].equals("link")) {
            continue;
          }
          localObject1 = arrayOfString[4];
          VipComicReportUtils.a(null, paramView, localContext, "3009", "2", "40054", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], localObject1 });
        }
      }
      paramView = new Bundle();
      paramView.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject3).asBinder()));
      paramView.putParcelable("extra.EXTRA_CURRENT_IMAGE", (Parcelable)localObject2);
      paramView.putInt("forward_source_uin_type", localStructMsgForImageShare.uinType);
      localIntent.putExtras(paramView);
      localContext.startActivity(localIntent);
      i = 1;
      j = 0;
      if (i != 0) {
        j = 1;
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, j, "" + localStructMsgForImageShare.msgId, "" + localStructMsgForImageShare.templateIDForPortal, "", localStructMsgForImageShare.mMsgUrl);
      paramView = new StringBuilder().append("MSGID=").append(Long.toString(localStructMsgForImageShare.msgId)).append(";TEPLATEID=").append(localStructMsgForImageShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(localStructMsgForImageShare.mMsgUrl));
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, j, paramView.toString(), "", "", "");
      return;
      paramView = localStructMsgForImageShare.uin;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */