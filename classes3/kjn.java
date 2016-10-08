import android.app.Dialog;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class kjn
  extends MessageObserver
{
  public kjn(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    if (AddRequestActivity.d(this.a))
    {
      paramString = this.a.getString(2131367430);
      QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      AddRequestActivity.a(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionError");
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (!AddRequestActivity.b(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionFin");
      }
      return;
    }
    long l2 = FriendSystemMsgController.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    structmsg.StructMsg localStructMsg;
    try
    {
      l1 = Long.parseLong(paramString1);
      localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
      if (!paramBoolean) {
        if (!TextUtils.isEmpty(paramString3))
        {
          QQToast.a(this.a, 1, paramString3, 0).b(this.a.getTitleBarHeight());
          if (SystemMsgUtils.a(localStructMsg, paramInt3, paramString2, paramString4)) {
            this.a.finish();
          }
          AddRequestActivity.a(this.a, false);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        l1 = l2;
        continue;
        paramString3 = this.a.getResources().getString(2131368656);
      }
      SystemMsgUtils.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((AddRequestActivity.c(this.a)) && (localStructMsg != null)) {
        localStructMsg.msg.friend_info.msg_blacklist.setHasFlag(false);
      }
      if (paramInt1 != 1) {
        break label254;
      }
    }
    this.a.setResult(-1);
    this.a.finish();
    paramString1 = this.a.getResources().getString(2131367315);
    for (;;)
    {
      QQToast.a(this.a, 2, paramString1, 0).b(this.a.getTitleBarHeight());
      break;
      label254:
      if ((paramInt1 == 0) && (localStructMsg != null))
      {
        paramString1 = this.a.getResources().getString(2131367314);
        AutoRemarkActivity.a(this.a, 0, String.valueOf(localStructMsg.req_uin.get()), l1);
      }
      else
      {
        paramString1 = null;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.dismissDialog(2);
    }
    this.a.a(2130838452, this.a.getString(2131368701));
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.dismissDialog(2);
    }
    this.a.a(2130838452, this.a.getString(2131368702));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */