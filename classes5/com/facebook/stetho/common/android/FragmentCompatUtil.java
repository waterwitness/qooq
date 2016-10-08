package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;
import javax.annotation.Nullable;

public final class FragmentCompatUtil
{
  @Nullable
  public static Object findFragmentForView(View paramView)
  {
    Activity localActivity = ViewUtil.tryGetActivity(paramView);
    if (localActivity == null) {
      return null;
    }
    return findFragmentForViewInActivity(localActivity, paramView);
  }
  
  @Nullable
  private static Object findFragmentForViewInActivity(Activity paramActivity, View paramView)
  {
    Object localObject = FragmentCompat.getSupportLibInstance();
    if ((localObject != null) && (((FragmentCompat)localObject).getFragmentActivityClass().isInstance(paramActivity)))
    {
      localObject = findFragmentForViewInActivity((FragmentCompat)localObject, paramActivity, paramView);
      if (localObject != null) {
        paramActivity = (Activity)localObject;
      }
    }
    do
    {
      return paramActivity;
      localObject = FragmentCompat.getFrameworkInstance();
      if (localObject == null) {
        break;
      }
      paramView = findFragmentForViewInActivity((FragmentCompat)localObject, paramActivity, paramView);
      paramActivity = paramView;
    } while (paramView != null);
    return null;
  }
  
  private static Object findFragmentForViewInActivity(FragmentCompat paramFragmentCompat, Activity paramActivity, View paramView)
  {
    paramActivity = paramFragmentCompat.forFragmentActivity().getFragmentManager(paramActivity);
    if (paramActivity != null) {
      return findFragmentForViewInFragmentManager(paramFragmentCompat, paramActivity, paramView);
    }
    return null;
  }
  
  @Nullable
  private static Object findFragmentForViewInFragment(FragmentCompat paramFragmentCompat, Object paramObject, View paramView)
  {
    FragmentAccessor localFragmentAccessor = paramFragmentCompat.forFragment();
    if (localFragmentAccessor.getView(paramObject) == paramView) {
      return paramObject;
    }
    paramObject = localFragmentAccessor.getChildFragmentManager(paramObject);
    if (paramObject != null) {
      return findFragmentForViewInFragmentManager(paramFragmentCompat, paramObject, paramView);
    }
    return null;
  }
  
  @Nullable
  private static Object findFragmentForViewInFragmentManager(FragmentCompat paramFragmentCompat, Object paramObject, View paramView)
  {
    List localList = paramFragmentCompat.forFragmentManager().getAddedFragments(paramObject);
    int i;
    int j;
    if (localList != null)
    {
      i = 0;
      j = localList.size();
    }
    for (;;)
    {
      if (i >= j) {
        paramObject = null;
      }
      Object localObject;
      do
      {
        return paramObject;
        localObject = findFragmentForViewInFragment(paramFragmentCompat, localList.get(i), paramView);
        paramObject = localObject;
      } while (localObject != null);
      i += 1;
    }
  }
  
  public static boolean isDialogFragment(Object paramObject)
  {
    FragmentCompat localFragmentCompat = FragmentCompat.getSupportLibInstance();
    if ((localFragmentCompat != null) && (localFragmentCompat.getDialogFragmentClass().isInstance(paramObject))) {}
    do
    {
      return true;
      localFragmentCompat = FragmentCompat.getFrameworkInstance();
    } while ((localFragmentCompat != null) && (localFragmentCompat.getDialogFragmentClass().isInstance(paramObject)));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\FragmentCompatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */