import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.download.DownloadParams;
import java.util.ArrayList;

public class grf
  extends DiscussionObserver
{
  public grf(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "onCreateDiscussion isSuccess = " + paramBoolean + ", errCode = " + paramInt + ", roomId = " + paramLong + ", discussName = " + paramString);
    }
    if (paramBoolean)
    {
      this.a.e = String.valueOf(paramLong);
      if ((this.a.e != null) && (this.a.e.length() > 0))
      {
        this.a.c = paramString;
        this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(paramLong, true);
      }
      return;
    }
    this.a.a(1, paramInt);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "onGetFlyTicket isSuccess = " + paramBoolean + ", errorCode = " + paramInt + ", validTime = " + paramLong1 + ", sigUrl = " + paramString1 + ", shortUrl = " + paramString2 + ", discussionUin = " + paramLong2);
    }
    if (paramBoolean)
    {
      if ((this.a.e != null) && (this.a.e.length() > 0))
      {
        this.a.jdField_a_of_type_Grg = new grg(this.a);
        paramString1 = new ArrayList();
        DownloadParams localDownloadParams = new DownloadParams();
        localDownloadParams.a = ("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/createConfCallback?feedkey=" + this.a.b);
        this.a.d = paramString2.substring("http://url.cn/".length(), paramString2.length() - "#flyticket".length());
        if (QLog.isColorLevel()) {
          QLog.d("ConferenceFlyTicketActivity", 2, "onGetFlyTicket mTicket = " + this.a.d);
        }
        localDownloadParams.a = (localDownloadParams.a + "&ret=0&ticket=" + this.a.d);
        paramString1.add(localDownloadParams);
        this.a.jdField_a_of_type_Grg.execute(new ArrayList[] { paramString1 });
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.d(paramLong2);
    this.a.a(1, paramInt);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "onJoinDiscussionByFlyTicket isSuccess = " + paramBoolean + ", discussUin = " + paramLong + ", errorCode = " + paramInt);
    }
    if (paramBoolean)
    {
      this.a.e = String.valueOf(paramLong);
      if ((this.a.e != null) && (this.a.e.length() > 0))
      {
        this.a.a(this.a.e, this.a.c);
        this.a.finish();
      }
      return;
    }
    this.a.a(1, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */