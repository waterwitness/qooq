import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ojd
  extends MessageObserver
{
  public ojd(SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a())
    {
      paramString = SystemMsgListView.a(this.a).getResources().getString(2131367430);
      QQToast.a(SystemMsgListView.a(this.a), 1, paramString, 0).b(this.a.a());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionError");
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = FriendSystemMsgController.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
        paramString1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a()) {
          break label89;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin");
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label89:
      if (!paramBoolean)
      {
        if (!TextUtils.isEmpty(paramString3)) {}
        for (;;)
        {
          QQToast.a(SystemMsgListView.a(this.a), 1, paramString3, 0).b(this.a.a());
          SystemMsgUtils.a(paramString1, paramInt3, paramString2, paramString4);
          return;
          paramString3 = SystemMsgListView.a(this.a).getResources().getString(2131368656);
        }
      }
      paramString3 = SystemMsgListView.a(this.a).getResources().getString(2131367314);
      QQToast.a(SystemMsgListView.a(this.a), 2, paramString3, 0).b(this.a.a());
      long l2 = FriendSystemMsgController.a().a();
      SystemMsgUtils.a(paramString1, paramInt1, paramString2, paramInt2);
      if ((l2 != 0L) && (paramString1 != null)) {}
      try
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0, l2, paramString1.toByteArray());
        if ((paramInt1 != 0) || (paramString1 == null)) {
          continue;
        }
        AutoRemarkActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.getActivity(), 0, String.valueOf(paramString1.req_uin.get()), l1);
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.bengin");
    }
    if (((Activity)SystemMsgListView.a(this.a)).isFinishing()) {
      return;
    }
    if (paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.success");
      }
    }
    for (;;)
    {
      try
      {
        if (SystemMsgListView.a(this.a) != null) {
          SystemMsgListView.a(this.a).c();
        }
        this.a.i();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      SystemMsgListView.a(this.a);
      return;
      if ((paramBoolean2) && (SystemMsgListView.a(this.a)))
      {
        String str = SystemMsgListView.a(this.a).getResources().getString(2131367431);
        QQToast.a(SystemMsgListView.a(this.a), 1, str, 0).b(this.a.a());
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.bengin");
    }
    this.a.k();
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.success");
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1014);
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      this.a.i();
    }
    while ((!paramBoolean2) || (!SystemMsgListView.a(this.a))) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1016);
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgError");
    }
    this.a.k();
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1016);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */