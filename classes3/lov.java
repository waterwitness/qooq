import com.tencent.mobileqq.activity.HotChatAnnounceActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class lov
  extends HotChatObserver
{
  public lov(HotChatAnnounceActivity paramHotChatAnnounceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = ((HotChatManager)this.a.app.getManager(59)).a(this.a.e);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.memo = this.a.h;
        paramArrayOfByte.memoUrl = this.a.i;
        paramArrayOfByte.memoShowed = false;
      }
      QQToast.a(this.a, 2, "设置公告成功", 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramArrayOfByte = "设置公告失败";
    if (paramInt == 1288) {
      paramArrayOfByte = "公告含有敏感词，设置失败";
    }
    QQToast.a(this.a, 1, paramArrayOfByte, 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetUserCreateHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString2);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString1 = ((HotChatManager)this.a.app.getManager(59)).a(this.a.e);
      if (paramString1 != null)
      {
        paramString1.memo = this.a.h;
        paramString1.memoUrl = this.a.i;
        paramString1.memoShowed = false;
      }
      QQToast.a(this.a, 2, "设置公告成功", 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramString1 = "设置公告失败";
    if (paramInt == 1282) {
      paramString1 = "公告含有敏感词，设置失败";
    }
    QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */