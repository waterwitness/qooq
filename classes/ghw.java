import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ghw
  extends MqqHandler
{
  WeakReference a;
  
  public ghw(Looper paramLooper, AVNotifyCenter paramAVNotifyCenter)
  {
    super(paramLooper);
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public ghw(AVNotifyCenter paramAVNotifyCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.a.get();
    if (localAVNotifyCenter == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!localAVNotifyCenter.i());
        if (QLog.isColorLevel()) {
          QLog.d("AVNotifyCenter", 2, "handleMessage-->opType=" + paramMessage.what);
        }
        if ((paramMessage.what >= 10003) && (paramMessage.what <= 10009))
        {
          localIntent = new Intent("tencent.video.q2v.MultiVideo");
          localIntent.putExtra("type", 35);
          localIntent.setPackage(localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
          localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
        }
        switch (paramMessage.what)
        {
        case 10006: 
        case 10007: 
        case 10008: 
        case 10009: 
        default: 
          return;
        case 10002: 
          localAVNotifyCenter.a();
          return;
        case 10003: 
          localIntent = new Intent("tencent.video.q2v.MultiVideo");
          localIntent.putExtra("type", 26);
          localIntent.putExtra("discussId", ((Long)paramMessage.obj).longValue());
          localIntent.putExtra("memberUin", localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localIntent.setPackage(localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
          localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
          return;
        case 10004: 
          paramMessage = (Object[])paramMessage.obj;
          localIntent = new Intent("tencent.video.q2v.MultiVideo");
          localIntent.putExtra("type", 24);
          localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
          localIntent.putExtra("cmdUin", (String)paramMessage[1]);
          localIntent.putExtra("uins", (String[])paramMessage[2]);
          localIntent.setPackage(localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
          localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
          return;
        case 10005: 
          paramMessage = (Object[])paramMessage.obj;
          localIntent = new Intent("tencent.video.q2v.MultiVideo");
          localIntent.putExtra("type", 31);
          localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
          localIntent.putExtra("cmdUin", (String)paramMessage[1]);
          localIntent.putExtra("uins", (String[])paramMessage[2]);
          localIntent.setPackage(localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
          localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
          return;
        case 10010: 
          localAVNotifyCenter.d(((Boolean)paramMessage.obj).booleanValue());
          return;
        case 10011: 
          localIntent = new Intent("tencent.video.q2v.MultiVideo");
          localIntent.putExtra("type", 34);
          localIntent.putExtra("relationId", ((Long)paramMessage.obj).longValue());
          localIntent.setPackage(localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
          localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
          return;
        case 10012: 
          paramMessage = (MeetingInfo)paramMessage.obj;
        }
      } while (paramMessage == null);
      localAVNotifyCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramMessage.getDiscuss_uin(), paramMessage);
      localAVNotifyCenter.a(2, paramMessage.getDiscuss_uin());
      return;
      paramMessage = (MeetingInfo)paramMessage.obj;
    } while ((paramMessage == null) || (!localAVNotifyCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessage.getDiscuss_uin())));
    localAVNotifyCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessage.getDiscuss_uin());
    localAVNotifyCenter.b(2, paramMessage.getDiscuss_uin());
    return;
    paramMessage = (String[])paramMessage.obj;
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_RECV_C2B_PUSH_MSG");
    localIntent.putExtra("uin", paramMessage[0]);
    localIntent.putExtra("context", paramMessage[1]);
    localIntent.setPackage(localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
    localAVNotifyCenter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ghw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */