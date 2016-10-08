import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.NearbyProcess;
import com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface.Stub;
import com.tencent.qphone.base.util.QLog;

public class tkh
  extends NearbyProcessInterface.Stub
{
  public tkh(NearbyProcess paramNearbyProcess)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Message a(Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    return this.a.b(paramMessage);
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    if (paramBasicTypeDataParcel == null) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, paramBasicTypeDataParcel.toString());
      }
      arrayOfObject = this.a.b(paramBasicTypeDataParcel.jdField_a_of_type_Int, paramBasicTypeDataParcel.jdField_a_of_type_ArrayOfJavaLangObject);
    } while (arrayOfObject == null);
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.jdField_a_of_type_Int, arrayOfObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */