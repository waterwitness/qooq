package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TransReqContext$1
  implements Parcelable.Creator<TransReqContext>
{
  public TransReqContext createFromParcel(Parcel paramParcel)
  {
    return new TransReqContext(paramParcel, null);
  }
  
  public TransReqContext[] newArray(int paramInt)
  {
    return new TransReqContext[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\TransReqContext$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */