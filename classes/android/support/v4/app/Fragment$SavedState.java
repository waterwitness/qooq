package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Fragment$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Fragment.SavedState.1();
  final Bundle mState;
  
  Fragment$SavedState(Bundle paramBundle)
  {
    this.mState = paramBundle;
  }
  
  Fragment$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    this.mState = paramParcel.readBundle();
    if ((paramClassLoader != null) && (this.mState != null)) {
      this.mState.setClassLoader(paramClassLoader);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mState);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\android\support\v4\app\Fragment$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */