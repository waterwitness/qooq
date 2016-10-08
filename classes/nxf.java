import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

public class nxf
  extends ICompressionCallBack.Stub
{
  WeakReference a;
  final String b;
  
  public nxf(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = DeviceMsgChatPie.class.getSimpleName();
    this.a = new WeakReference(paramDeviceMsgChatPie);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "DeviceMsgChatPie, compress success, localUUID:" + paramCompressInfo.a);
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "DeviceMsgChatPie, compress fail, localUUID:" + paramCompressInfo.a);
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "DeviceMsgChatPie, compress complete, localUUID:" + paramCompressInfo.a);
    }
    DeviceMsgChatPie localDeviceMsgChatPie = (DeviceMsgChatPie)this.a.get();
    if (localDeviceMsgChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.b, 2, "onCompressComplete, error: activity is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.b, 2, "onCompressComplete, new path:" + paramCompressInfo.e);
    }
    localDeviceMsgChatPie.d(paramCompressInfo.e);
    DeviceMsgChatPie.a(localDeviceMsgChatPie).a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */