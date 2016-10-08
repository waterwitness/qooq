import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.Holder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class uxa
  implements View.OnClickListener
{
  public uxa(StructMsgItemVideo paramStructMsgItemVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    paramView = paramView.getTag(2131296577);
    if ((paramView != null) && ((paramView instanceof StructMsgItemVideo.Holder)))
    {
      paramView = (StructMsgItemVideo.Holder)paramView;
      localObject = StructMsgVideoController.a();
      if (((StructMsgVideoController)localObject).a()) {
        break label74;
      }
      if ((this.a.a instanceof StructMsgForGeneralShare))
      {
        paramView = (StructMsgForGeneralShare)this.a.a;
        this.a.a(localContext, paramView, 0L);
      }
    }
    label74:
    do
    {
      return;
      if (!((StructMsgVideoController)localObject).a(localContext, this.a.a.message.uniseq)) {
        break;
      }
    } while (!(this.a.a instanceof StructMsgForGeneralShare));
    Object localObject = (StructMsgForGeneralShare)this.a.a;
    long l;
    if ((paramView.a.getDrawable() != null) && ((paramView.a.getDrawable() instanceof URLDrawable)))
    {
      URLDrawable localURLDrawable = (URLDrawable)paramView.a.getDrawable();
      if ((localURLDrawable.getStatus() == 1) && ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
      {
        l = ((QQLiveDrawable)localURLDrawable.getCurrDrawable()).getCurrentPosition();
        StructMsgVideoController.a().a = this.a.a.message.uniseq;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("structmsg.StructMsgItemVideo", 2, "onCLick(): playPosition = " + l);
      }
      this.a.a(localContext, (StructMsgForGeneralShare)localObject, l);
      VideoReporter.a("0X80065E5", paramView.a.k, paramView.a.a(), paramView.a.b, "" + l);
      return;
      if (!HttpUtil.a(localContext))
      {
        QQToast.a(localContext, 2131367256, 0).a();
        return;
      }
      if (NetworkUtils.isMobileConnected(localContext))
      {
        DialogUtil.a(localContext, 232, localContext.getString(2131371551), localContext.getString(2131371552), localContext.getString(2131367262), "继续观看", new uxb(this, localContext), new uxc(this, paramView)).show();
        return;
      }
      this.a.a(localContext, (StructMsgForGeneralShare)this.a.a, 0L);
      return;
      l = 0L;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */