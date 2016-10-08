import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class wdi
  extends MessageObserver
{
  public wdi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramStatictisInfo.b);
      localStringBuilder.append("errCode: " + paramStatictisInfo.c);
      localStringBuilder.append("retryCount: " + paramStatictisInfo.jdField_d_of_type_Int);
      localStringBuilder.append("detailErrorReason: " + paramStatictisInfo.jdField_d_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramStatictisInfo.a);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */