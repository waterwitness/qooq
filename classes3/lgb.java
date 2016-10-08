import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class lgb
  extends DiscussionObserver
{
  public lgb(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        paramString1 = "获取多人聊天链接失败";
      }
      for (;;)
      {
        this.a.a(2130838442, paramString1);
        return;
        paramString1 = "多人聊天不存在";
        continue;
        paramString1 = "你已不在此多人聊天";
      }
    }
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("qrcode", 0).edit();
    localEditor.putLong("discussionvalidtime" + DiscussionInfoCardActivity.a(this.a), paramLong1);
    localEditor.putString("discussion" + DiscussionInfoCardActivity.a(this.a), paramString2);
    localEditor.putString("discussionfullSig" + DiscussionInfoCardActivity.a(this.a), paramString1);
    localEditor.commit();
    this.a.jdField_a_of_type_Long = paramLong1;
    this.a.c = paramString2;
    this.a.d = paramString1;
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramLong == Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue()))
    {
      DiscussionInfoCardActivity.a(this.a);
      this.a.a(2, this.a.getString(2131369493));
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a)))) {}
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if ((paramBoolean) && (paramLong1 != null) && (String.valueOf(paramLong1).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      DiscussionInfoCardActivity.a(this.a);
      return;
    }
    QQToast.a(this.a, 1, this.a.getString(2131368263), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label155;
      }
      paramString = DiscussionInfoCardActivity.a(this.a).a(paramString);
      if (paramString != null)
      {
        DiscussionInfoCardActivity.a(this.a, paramString.discussionName);
        DiscussionInfoCardActivity.a(this.a).setRightText(DiscussionInfoCardActivity.b(this.a));
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131369490));
        DiscussionInfoCardActivity.a(this.a).c(2130838452);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
      }
    }
    label155:
    do
    {
      return;
      DiscussionInfoCardActivity.a(this.a).setRightText(DiscussionInfoCardActivity.b(this.a));
    } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131369491));
    DiscussionInfoCardActivity.a(this.a).c(2130838452);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((DiscussionInfoCardActivity.a(this.a).equals(str)) && (paramBoolean) && (bool))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a));
      DiscussionInfoCardActivity.a(this.a);
      this.a.a();
      this.a.i();
      DiscussionInfoCardActivity.b(this.a);
    }
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    paramArrayOfObject = (String)paramArrayOfObject[2];
    if ((paramArrayOfObject == null) || (paramArrayOfObject.trim().equals(""))) {
      paramArrayOfObject = this.a.getString(2131369499);
    }
    for (;;)
    {
      if (DiscussionInfoCardActivity.a(this.a).equals(str))
      {
        if ((10001 == i) || (10002 == i)) {
          DialogUtil.a(this.a, 230, null, paramArrayOfObject, new lgd(this, str), null).show();
        }
      }
      else {
        return;
      }
      this.a.a(1, paramArrayOfObject);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onCollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.a))))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
      if (!this.a.isFinishing())
      {
        paramLong = this.a.app.a().getSharedPreferences(this.a.app.a(), 0);
        if (paramLong.getBoolean("multi_chat_set_common_use_key", true))
        {
          this.a.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.a, 230, this.a.getString(2131370165), this.a.getString(2131370166), 2131367262, 2131370504, new lgc(this), null);
          this.a.jdField_a_of_type_AndroidAppDialog.show();
          paramLong.edit().putBoolean("multi_chat_set_common_use_key", false).commit();
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.a).equals(paramString))
    {
      if (!paramBoolean) {
        break label111;
      }
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131369497));
        DiscussionInfoCardActivity.a(this.a).c(2130838452);
        DiscussionInfoCardActivity.a(this.a).b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16, 1500L);
      }
    }
    label111:
    while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing())) {
      return;
    }
    DiscussionInfoCardActivity.a(this.a).a(this.a.getString(2131369498));
    DiscussionInfoCardActivity.a(this.a).c(2130838442);
    DiscussionInfoCardActivity.a(this.a).b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */