package fb.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator()
  {
    public BackStackState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }
    
    public BackStackState[] newArray(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final int mTransition;
  final int mTransitionStyle;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }
  
  public BackStackState(FragmentManagerImpl paramFragmentManagerImpl, BackStackRecord paramBackStackRecord)
  {
    int i = 0;
    paramFragmentManagerImpl = paramBackStackRecord.mHead;
    for (;;)
    {
      if (paramFragmentManagerImpl == null)
      {
        this.mOps = new int[paramBackStackRecord.mNumOp * 7 + i];
        if (paramBackStackRecord.mAddToBackStack) {
          break;
        }
        throw new IllegalStateException("Not on back stack");
      }
      j = i;
      if (paramFragmentManagerImpl.removed != null) {
        j = i + paramFragmentManagerImpl.removed.size();
      }
      paramFragmentManagerImpl = paramFragmentManagerImpl.next;
      i = j;
    }
    paramFragmentManagerImpl = paramBackStackRecord.mHead;
    i = 0;
    if (paramFragmentManagerImpl == null)
    {
      this.mTransition = paramBackStackRecord.mTransition;
      this.mTransitionStyle = paramBackStackRecord.mTransitionStyle;
      this.mName = paramBackStackRecord.mName;
      this.mIndex = paramBackStackRecord.mIndex;
      this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
      this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
      this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
      this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
      return;
    }
    int[] arrayOfInt = this.mOps;
    int j = i + 1;
    arrayOfInt[i] = paramFragmentManagerImpl.cmd;
    arrayOfInt = this.mOps;
    i = j + 1;
    arrayOfInt[j] = paramFragmentManagerImpl.fragment.mIndex;
    arrayOfInt = this.mOps;
    j = i + 1;
    arrayOfInt[i] = paramFragmentManagerImpl.enterAnim;
    arrayOfInt = this.mOps;
    i = j + 1;
    arrayOfInt[j] = paramFragmentManagerImpl.exitAnim;
    arrayOfInt = this.mOps;
    j = i + 1;
    arrayOfInt[i] = paramFragmentManagerImpl.popEnterAnim;
    arrayOfInt = this.mOps;
    int m = j + 1;
    arrayOfInt[j] = paramFragmentManagerImpl.popExitAnim;
    if (paramFragmentManagerImpl.removed != null)
    {
      int k = paramFragmentManagerImpl.removed.size();
      this.mOps[m] = k;
      j = 0;
      i = m + 1;
      label312:
      if (j < k) {}
    }
    for (;;)
    {
      paramFragmentManagerImpl = paramFragmentManagerImpl.next;
      break;
      this.mOps[i] = ((Fragment)paramFragmentManagerImpl.removed.get(j)).mIndex;
      j += 1;
      i += 1;
      break label312;
      arrayOfInt = this.mOps;
      i = m + 1;
      arrayOfInt[m] = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int i = 0;
    if (i >= this.mOps.length)
    {
      localBackStackRecord.mTransition = this.mTransition;
      localBackStackRecord.mTransitionStyle = this.mTransitionStyle;
      localBackStackRecord.mName = this.mName;
      localBackStackRecord.mIndex = this.mIndex;
      localBackStackRecord.mAddToBackStack = true;
      localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
      localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
      localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
      localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
      localBackStackRecord.bumpBackStackNesting(1);
      return localBackStackRecord;
    }
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    Object localObject = this.mOps;
    int j = i + 1;
    localOp.cmd = localObject[i];
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "BSE " + localBackStackRecord + " set base fragment #" + this.mOps[j]);
    }
    localObject = paramFragmentManagerImpl.mActive;
    int[] arrayOfInt = this.mOps;
    i = j + 1;
    localOp.fragment = ((Fragment)((ArrayList)localObject).get(arrayOfInt[j]));
    localObject = this.mOps;
    j = i + 1;
    localOp.enterAnim = localObject[i];
    localObject = this.mOps;
    i = j + 1;
    localOp.exitAnim = localObject[j];
    localObject = this.mOps;
    j = i + 1;
    localOp.popEnterAnim = localObject[i];
    localObject = this.mOps;
    i = j + 1;
    localOp.popExitAnim = localObject[j];
    localObject = this.mOps;
    j = i + 1;
    int m = localObject[i];
    i = j;
    if (m > 0)
    {
      localOp.removed = new ArrayList(m);
      int k = 0;
      i = j;
      j = k;
    }
    for (;;)
    {
      if (j >= m)
      {
        localBackStackRecord.addOp(localOp);
        break;
      }
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "BSE " + localBackStackRecord + " set remove fragment #" + this.mOps[i]);
      }
      localObject = (Fragment)paramFragmentManagerImpl.mActive.get(this.mOps[i]);
      localOp.removed.add(localObject);
      j += 1;
      i += 1;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeInt(this.mTransitionStyle);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\fb\support\v4\app\BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */