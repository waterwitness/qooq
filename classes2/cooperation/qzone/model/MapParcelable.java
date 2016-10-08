package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;
import ymp;

public class MapParcelable
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ymp();
  private Map a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MapParcelable(Map paramMap)
  {
    this.a = paramMap;
  }
  
  public Map a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\MapParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */