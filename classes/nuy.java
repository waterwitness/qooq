import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;

public class nuy
  implements ICompressionCallBack
{
  private IBinder a;
  
  public nuy(IBinder paramIBinder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack";
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.jdField_a_of_type_AndroidOsIBinder.transact(1, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.jdField_a_of_type_AndroidOsIBinder;
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.jdField_a_of_type_AndroidOsIBinder.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.jdField_a_of_type_AndroidOsIBinder.transact(3, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */