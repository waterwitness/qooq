package com.facebook.stetho.common.android;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import fb.support.v4.app.DialogFragment;
import fb.support.v4.app.Fragment;
import fb.support.v4.app.FragmentActivity;
import fb.support.v4.app.FragmentManager;
import javax.annotation.Nullable;

final class FragmentCompatSupportLib
  extends FragmentCompat<Fragment, DialogFragment, FragmentManager, FragmentActivity>
{
  private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor;
  private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib(null);
  private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib(null);
  private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor;
  
  static
  {
    sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib(null);
    sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection();
  }
  
  public DialogFragmentAccessorSupportLib forDialogFragment()
  {
    return sDialogFragmentAccessor;
  }
  
  public FragmentAccessorSupportLib forFragment()
  {
    return sFragmentAccessor;
  }
  
  public FragmentActivityAccessorSupportLib forFragmentActivity()
  {
    return sFragmentActivityAccessor;
  }
  
  public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager()
  {
    return sFragmentManagerAccessor;
  }
  
  public Class<DialogFragment> getDialogFragmentClass()
  {
    return DialogFragment.class;
  }
  
  public Class<FragmentActivity> getFragmentActivityClass()
  {
    return FragmentActivity.class;
  }
  
  public Class<Fragment> getFragmentClass()
  {
    return Fragment.class;
  }
  
  private static class DialogFragmentAccessorSupportLib
    extends FragmentCompatSupportLib.FragmentAccessorSupportLib
    implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager>
  {
    private DialogFragmentAccessorSupportLib()
    {
      super(null);
    }
    
    public Dialog getDialog(DialogFragment paramDialogFragment)
    {
      return paramDialogFragment.getDialog();
    }
  }
  
  private static class FragmentAccessorSupportLib
    implements FragmentAccessor<Fragment, FragmentManager>
  {
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment paramFragment)
    {
      return null;
    }
    
    @Nullable
    public FragmentManager getFragmentManager(Fragment paramFragment)
    {
      return paramFragment.getFragmentManager();
    }
    
    public int getId(Fragment paramFragment)
    {
      return paramFragment.getId();
    }
    
    public Resources getResources(Fragment paramFragment)
    {
      return paramFragment.getResources();
    }
    
    @Nullable
    public String getTag(Fragment paramFragment)
    {
      return paramFragment.getTag();
    }
    
    @Nullable
    public View getView(Fragment paramFragment)
    {
      return paramFragment.getView();
    }
  }
  
  private static class FragmentActivityAccessorSupportLib
    implements FragmentActivityAccessor<FragmentActivity, FragmentManager>
  {
    @Nullable
    public FragmentManager getFragmentManager(FragmentActivity paramFragmentActivity)
    {
      return paramFragmentActivity.getSupportFragmentManager();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\FragmentCompatSupportLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */