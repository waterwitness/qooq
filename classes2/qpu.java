import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ModelResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qpu
  implements Parcelable.Creator
{
  public qpu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ModelResource a(Parcel paramParcel)
  {
    return new ModelResource(paramParcel);
  }
  
  public ModelResource[] a(int paramInt)
  {
    return new ModelResource[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */