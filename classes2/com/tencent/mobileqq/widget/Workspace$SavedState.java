package com.tencent.mobileqq.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import wow;

public class Workspace$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new wow();
  int currentScreen = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Workspace$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.currentScreen = paramParcel.readInt();
  }
  
  Workspace$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.currentScreen);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\Workspace$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */