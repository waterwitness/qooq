package fb.support.v4.app;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, Runnable
{
  static final int OP_ADD = 1;
  static final int OP_ATTACH = 7;
  static final int OP_DETACH = 6;
  static final int OP_HIDE = 4;
  static final int OP_NULL = 0;
  static final int OP_REMOVE = 3;
  static final int OP_REPLACE = 2;
  static final int OP_SHOW = 5;
  static final String TAG = "BackStackEntry";
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  Op mHead;
  int mIndex;
  final FragmentManagerImpl mManager;
  String mName;
  int mNumOp;
  int mPopEnterAnim;
  int mPopExitAnim;
  Op mTail;
  int mTransition;
  int mTransitionStyle;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
      }
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    }
    paramString = new Op();
    paramString.cmd = paramInt2;
    paramString.fragment = paramFragment;
    addOp(paramString);
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(Op paramOp)
  {
    if (this.mHead == null)
    {
      this.mTail = paramOp;
      this.mHead = paramOp;
    }
    for (;;)
    {
      paramOp.enterAnim = this.mEnterAnim;
      paramOp.exitAnim = this.mExitAnim;
      paramOp.popEnterAnim = this.mPopEnterAnim;
      paramOp.popExitAnim = this.mPopExitAnim;
      this.mNumOp += 1;
      return;
      paramOp.prev = this.mTail;
      this.mTail.next = paramOp;
      this.mTail = paramOp;
    }
  }
  
  public FragmentTransaction addToBackStack(String paramString)
  {
    if (!this.mAllowAddToBackStack) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.mAddToBackStack = true;
    this.mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 7;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!this.mAddToBackStack) {
      return;
    }
    if (FragmentManagerImpl.DEBUG) {
      Log.v("BackStackEntry", "Bump nesting in " + this + " by " + paramInt);
    }
    Op localOp = this.mHead;
    label50:
    Fragment localFragment;
    int i;
    if (localOp != null)
    {
      localFragment = localOp.fragment;
      localFragment.mBackStackNesting += paramInt;
      if (FragmentManagerImpl.DEBUG) {
        Log.v("BackStackEntry", "Bump nesting of " + localOp.fragment + " to " + localOp.fragment.mBackStackNesting);
      }
      if (localOp.removed != null) {
        i = localOp.removed.size() - 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        localOp = localOp.next;
        break label50;
        break;
      }
      localFragment = (Fragment)localOp.removed.get(i);
      localFragment.mBackStackNesting += paramInt;
      if (FragmentManagerImpl.DEBUG) {
        Log.v("BackStackEntry", "Bump nesting of " + localFragment + " to " + localFragment.mBackStackNesting);
      }
      i -= 1;
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (this.mCommitted) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG) {
      Log.v("BackStackEntry", "Commit: " + this);
    }
    this.mCommitted = true;
    if (this.mAddToBackStack) {}
    for (this.mIndex = this.mManager.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  public FragmentTransaction detach(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 6;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack()
  {
    if (this.mAddToBackStack) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mName=");
    paramPrintWriter.print(this.mName);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mCommitted=");
    paramPrintWriter.println(this.mCommitted);
    if (this.mTransition != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTransition=#");
      paramPrintWriter.print(Integer.toHexString(this.mTransition));
      paramPrintWriter.print(" mTransitionStyle=#");
      paramPrintWriter.println(Integer.toHexString(this.mTransitionStyle));
    }
    if ((this.mEnterAnim != 0) || (this.mExitAnim != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
      paramPrintWriter.print(" mExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
    }
    if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mPopEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
      paramPrintWriter.print(" mPopExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
    }
    if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
      paramPrintWriter.print(" mBreadCrumbTitleText=");
      paramPrintWriter.println(this.mBreadCrumbTitleText);
    }
    if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
      paramPrintWriter.print(" mBreadCrumbShortTitleText=");
      paramPrintWriter.println(this.mBreadCrumbShortTitleText);
    }
    if (this.mHead != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      paramArrayOfString = paramString + "    ";
    }
    int i;
    for (paramFileDescriptor = this.mHead;; paramFileDescriptor = paramFileDescriptor.next)
    {
      if (paramFileDescriptor == null) {
        return;
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  Op #");
      paramPrintWriter.print(0);
      paramPrintWriter.println(":");
      paramPrintWriter.print(paramArrayOfString);
      paramPrintWriter.print("cmd=");
      paramPrintWriter.print(paramFileDescriptor.cmd);
      paramPrintWriter.print(" fragment=");
      paramPrintWriter.println(paramFileDescriptor.fragment);
      if ((paramFileDescriptor.enterAnim != 0) || (paramFileDescriptor.exitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("enterAnim=#");
        paramPrintWriter.print(Integer.toHexString(paramFileDescriptor.enterAnim));
        paramPrintWriter.print(" exitAnim=#");
        paramPrintWriter.println(Integer.toHexString(paramFileDescriptor.exitAnim));
      }
      if ((paramFileDescriptor.popEnterAnim != 0) || (paramFileDescriptor.popExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("popEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(paramFileDescriptor.popEnterAnim));
        paramPrintWriter.print(" popExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(paramFileDescriptor.popExitAnim));
      }
      if ((paramFileDescriptor.removed != null) && (paramFileDescriptor.removed.size() > 0))
      {
        i = 0;
        if (i < paramFileDescriptor.removed.size()) {
          break;
        }
      }
    }
    paramPrintWriter.print(paramArrayOfString);
    if (paramFileDescriptor.removed.size() == 1) {
      paramPrintWriter.print("Removed: ");
    }
    for (;;)
    {
      paramPrintWriter.println(paramFileDescriptor.removed.get(i));
      i += 1;
      break;
      paramPrintWriter.println("Removed:");
      paramPrintWriter.print(paramArrayOfString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(0);
      paramPrintWriter.print(": ");
    }
  }
  
  public CharSequence getBreadCrumbShortTitle()
  {
    if (this.mBreadCrumbShortTitleRes != 0) {
      return this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes);
    }
    return this.mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return this.mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle()
  {
    if (this.mBreadCrumbTitleRes != 0) {
      return this.mManager.mActivity.getText(this.mBreadCrumbTitleRes);
    }
    return this.mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes()
  {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return this.mIndex;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTransition()
  {
    return this.mTransition;
  }
  
  public int getTransitionStyle()
  {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 4;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public boolean isAddToBackStackAllowed()
  {
    return this.mAllowAddToBackStack;
  }
  
  public boolean isEmpty()
  {
    return this.mNumOp == 0;
  }
  
  public void popFromBackStack(boolean paramBoolean)
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("BackStackEntry", "popFromBackStack: " + this);
    }
    bumpBackStackNesting(-1);
    Op localOp = this.mTail;
    if (localOp == null)
    {
      if (paramBoolean) {
        this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle, true);
      }
      if (this.mIndex >= 0)
      {
        this.mManager.freeBackStackIndex(this.mIndex);
        this.mIndex = -1;
      }
      return;
    }
    Fragment localFragment;
    switch (localOp.cmd)
    {
    default: 
      throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
    case 1: 
      localFragment = localOp.fragment;
      localFragment.mNextAnim = localOp.popExitAnim;
      this.mManager.removeFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
    }
    for (;;)
    {
      localOp = localOp.prev;
      break;
      localFragment = localOp.fragment;
      localFragment.mNextAnim = localOp.popExitAnim;
      this.mManager.removeFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
      if (localOp.removed != null)
      {
        int i = 0;
        while (i < localOp.removed.size())
        {
          localFragment = (Fragment)localOp.removed.get(i);
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.addFragment(localFragment, false);
          i += 1;
        }
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popEnterAnim;
        this.mManager.addFragment(localFragment, false);
        continue;
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popEnterAnim;
        this.mManager.showFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        continue;
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popExitAnim;
        this.mManager.hideFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        continue;
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popEnterAnim;
        this.mManager.attachFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        continue;
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popEnterAnim;
        this.mManager.detachFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
      }
    }
  }
  
  public FragmentTransaction remove(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 3;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public void run()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("BackStackEntry", "Run: " + this);
    }
    if ((this.mAddToBackStack) && (this.mIndex < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    bumpBackStackNesting(1);
    Op localOp = this.mHead;
    if (localOp == null)
    {
      this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, true);
      if (this.mAddToBackStack) {
        this.mManager.addBackStackState(this);
      }
      return;
    }
    Fragment localFragment1;
    switch (localOp.cmd)
    {
    default: 
      throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
    case 1: 
      localFragment1 = localOp.fragment;
      localFragment1.mNextAnim = localOp.enterAnim;
      this.mManager.addFragment(localFragment1, false);
    }
    for (;;)
    {
      localOp = localOp.next;
      break;
      localFragment1 = localOp.fragment;
      int i;
      if (this.mManager.mAdded != null) {
        i = 0;
      }
      for (;;)
      {
        if (i >= this.mManager.mAdded.size())
        {
          localFragment1.mNextAnim = localOp.enterAnim;
          this.mManager.addFragment(localFragment1, false);
          break;
        }
        Fragment localFragment2 = (Fragment)this.mManager.mAdded.get(i);
        if (FragmentManagerImpl.DEBUG) {
          Log.v("BackStackEntry", "OP_REPLACE: adding=" + localFragment1 + " old=" + localFragment2);
        }
        if (localFragment2.mContainerId == localFragment1.mContainerId)
        {
          if (localOp.removed == null) {
            localOp.removed = new ArrayList();
          }
          localOp.removed.add(localFragment2);
          localFragment2.mNextAnim = localOp.exitAnim;
          if (this.mAddToBackStack)
          {
            localFragment2.mBackStackNesting += 1;
            if (FragmentManagerImpl.DEBUG) {
              Log.v("BackStackEntry", "Bump nesting of " + localFragment2 + " to " + localFragment2.mBackStackNesting);
            }
          }
          this.mManager.removeFragment(localFragment2, this.mTransition, this.mTransitionStyle);
        }
        i += 1;
      }
      localFragment1 = localOp.fragment;
      localFragment1.mNextAnim = localOp.exitAnim;
      this.mManager.removeFragment(localFragment1, this.mTransition, this.mTransitionStyle);
      continue;
      localFragment1 = localOp.fragment;
      localFragment1.mNextAnim = localOp.exitAnim;
      this.mManager.hideFragment(localFragment1, this.mTransition, this.mTransitionStyle);
      continue;
      localFragment1 = localOp.fragment;
      localFragment1.mNextAnim = localOp.enterAnim;
      this.mManager.showFragment(localFragment1, this.mTransition, this.mTransitionStyle);
      continue;
      localFragment1 = localOp.fragment;
      localFragment1.mNextAnim = localOp.exitAnim;
      this.mManager.detachFragment(localFragment1, this.mTransition, this.mTransitionStyle);
      continue;
      localFragment1 = localOp.fragment;
      localFragment1.mNextAnim = localOp.enterAnim;
      this.mManager.attachFragment(localFragment1, this.mTransition, this.mTransitionStyle);
    }
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt)
  {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt)
  {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 5;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  static final class Op
  {
    int cmd;
    int enterAnim;
    int exitAnim;
    Fragment fragment;
    Op next;
    int popEnterAnim;
    int popExitAnim;
    Op prev;
    ArrayList<Fragment> removed;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\fb\support\v4\app\BackStackRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */