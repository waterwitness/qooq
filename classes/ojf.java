import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ojf
  extends MessageObserver
{
  public ojf(SystemRequestInfoView paramSystemRequestInfoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    if (this.a.a())
    {
      paramString = this.a.getResources().getString(2131367430);
      QQToast.a(this.a.getContext(), 1, paramString, 0).b(this.a.a());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionError");
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionFin");
    }
    if (!this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemRequestInfoView", 2, "onSendSystemMsgActionFin stopProgress = fasle");
      }
    }
    long l1;
    structmsg.StructMsg localStructMsg;
    for (;;)
    {
      return;
      long l2 = FriendSystemMsgController.a().b();
      l1 = l2;
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        l1 = Long.parseLong(paramString1);
        localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3))
          {
            QQToast.a(this.a.getContext(), 1, paramString3, 0).b(this.a.a());
            if (!SystemMsgUtils.a(localStructMsg, paramInt3, paramString2, paramString4)) {
              continue;
            }
            SystemRequestInfoView.a(this.a).finish();
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
        if (paramInt1 != 1) {
          break label231;
        }
      }
    }
    SystemRequestInfoView.a(this.a).finish();
    paramString1 = this.a.getResources().getString(2131367315);
    for (;;)
    {
      QQToast.a(this.a.getContext(), 2, paramString1, 0).b(this.a.a());
      return;
      label231:
      if ((paramInt1 == 0) && (localStructMsg != null))
      {
        paramString1 = this.a.getResources().getString(2131367314);
        AutoRemarkActivity.a(SystemRequestInfoView.a(this.a), 1017, String.valueOf(localStructMsg.req_uin.get()), l1);
      }
      else
      {
        paramString1 = null;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */