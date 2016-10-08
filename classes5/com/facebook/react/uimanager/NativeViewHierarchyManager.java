package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.common.logging.FLog;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationListener;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class NativeViewHierarchyManager
{
  private static final String TAG = NativeViewHierarchyManager.class.getSimpleName();
  private final AnimationRegistry mAnimationRegistry = new AnimationRegistry();
  private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();
  private boolean mLayoutAnimationEnabled;
  private final LayoutAnimationController mLayoutAnimator = new LayoutAnimationController();
  private final SparseBooleanArray mRootTags;
  private final RootViewManager mRootViewManager = new RootViewManager();
  private final SparseArray<ViewManager> mTagsToViewManagers;
  private final SparseArray<View> mTagsToViews;
  private final ViewManagerRegistry mViewManagers;
  
  public NativeViewHierarchyManager(ViewManagerRegistry paramViewManagerRegistry)
  {
    this.mViewManagers = paramViewManagerRegistry;
    this.mTagsToViews = new SparseArray();
    this.mTagsToViewManagers = new SparseArray();
    this.mRootTags = new SparseBooleanArray();
  }
  
  private static String constructManageChildrenErrorMessage(ViewGroup paramViewGroup, ViewGroupManager paramViewGroupManager, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View tag:" + paramViewGroup.getId() + "\n");
      localStringBuilder.append("  children(" + paramViewGroupManager.getChildCount(paramViewGroup) + "): [\n");
      int i = 0;
      int j;
      while (i < paramViewGroupManager.getChildCount(paramViewGroup))
      {
        j = 0;
        while ((i + j < paramViewGroupManager.getChildCount(paramViewGroup)) && (j < 16))
        {
          localStringBuilder.append(paramViewGroupManager.getChildAt(paramViewGroup, i + j).getId() + ",");
          j += 1;
        }
        localStringBuilder.append("\n");
        i += 16;
      }
      localStringBuilder.append(" ],\n");
      if (paramArrayOfInt1 != null)
      {
        localStringBuilder.append("  indicesToRemove(" + paramArrayOfInt1.length + "): [\n");
        i = 0;
        while (i < paramArrayOfInt1.length)
        {
          j = 0;
          while ((i + j < paramArrayOfInt1.length) && (j < 16))
          {
            localStringBuilder.append(paramArrayOfInt1[(i + j)] + ",");
            j += 1;
          }
          localStringBuilder.append("\n");
          i += 16;
        }
        localStringBuilder.append(" ],\n");
      }
      if (paramArrayOfViewAtIndex != null)
      {
        localStringBuilder.append("  viewsToAdd(" + paramArrayOfViewAtIndex.length + "): [\n");
        i = 0;
        while (i < paramArrayOfViewAtIndex.length)
        {
          j = 0;
          while ((i + j < paramArrayOfViewAtIndex.length) && (j < 16))
          {
            localStringBuilder.append("[" + paramArrayOfViewAtIndex[(i + j)].mIndex + "," + paramArrayOfViewAtIndex[(i + j)].mTag + "],");
            j += 1;
          }
          localStringBuilder.append("\n");
          i += 16;
        }
        localStringBuilder.append(" ],\n");
      }
      if (paramArrayOfInt2 != null)
      {
        localStringBuilder.append("  tagsToDelete(" + paramArrayOfInt2.length + "): [\n");
        i = 0;
        while (i < paramArrayOfInt2.length)
        {
          j = 0;
          while ((i + j < paramArrayOfInt2.length) && (j < 16))
          {
            localStringBuilder.append(paramArrayOfInt2[(i + j)] + ",");
            j += 1;
          }
          localStringBuilder.append("\n");
          i += 16;
        }
        localStringBuilder.append(" ]\n");
      }
      paramViewGroup = localStringBuilder.toString();
      return paramViewGroup;
    }
    catch (Exception paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    return "";
  }
  
  private void dropView(View paramView)
  {
    for (;;)
    {
      int i;
      try
      {
        
        if (paramView == null) {
          return;
        }
        if (!this.mRootTags.get(paramView.getId())) {
          resolveViewManager(paramView.getId()).onDropViewInstance((ThemedReactContext)paramView.getContext(), paramView);
        }
        Object localObject = (ViewManager)this.mTagsToViewManagers.get(paramView.getId());
        if (((paramView instanceof ViewGroup)) && ((localObject instanceof ViewGroupManager)))
        {
          ViewGroup localViewGroup = (ViewGroup)paramView;
          localObject = (ViewGroupManager)localObject;
          i = ((ViewGroupManager)localObject).getChildCount(localViewGroup) - 1;
          if (i >= 0)
          {
            View localView = ((ViewGroupManager)localObject).getChildAt(localViewGroup, i);
            if (this.mTagsToViews.get(localView.getId()) != null) {
              dropView(localView);
            }
          }
          else
          {
            ((ViewGroupManager)localObject).removeAllViews(localViewGroup);
          }
        }
        else
        {
          this.mTagsToViews.remove(paramView.getId());
          this.mTagsToViewManagers.remove(paramView.getId());
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      i -= 1;
    }
  }
  
  private ThemedReactContext getReactContextForView(int paramInt)
  {
    try
    {
      Object localObject = (View)this.mTagsToViews.get(paramInt);
      if (localObject == null)
      {
        if (FLog.isLoggable(4)) {
          FLog.i(TAG, "Could not find view with tag " + paramInt);
        }
      }
      else
      {
        localObject = (ThemedReactContext)((View)localObject).getContext();
        return (ThemedReactContext)localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    return null;
  }
  
  private void updateLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if ((this.mLayoutAnimationEnabled) && (this.mLayoutAnimator.shouldAnimateLayout(paramView)))
      {
        this.mLayoutAnimator.applyLayoutUpdate(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, ThemedReactContext paramThemedReactContext)
  {
    addRootViewGroup(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
  }
  
  protected final void addRootViewGroup(int paramInt, ViewGroup paramViewGroup, ThemedReactContext paramThemedReactContext)
  {
    try
    {
      
      if (paramViewGroup.getId() != -1)
      {
        if (FLog.isLoggable(4)) {
          FLog.i(TAG, "Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addMeasuredRootView.");
        }
      }
      else
      {
        this.mTagsToViews.put(paramInt, paramViewGroup);
        this.mTagsToViewManagers.put(paramInt, this.mRootViewManager);
        this.mRootTags.put(paramInt, true);
        paramViewGroup.setId(paramInt);
        return;
      }
    }
    catch (Exception paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
  }
  
  public void clearJSResponder()
  {
    try
    {
      this.mJSResponderHandler.clearJSResponder();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void clearLayoutAnimation()
  {
    try
    {
      this.mLayoutAnimator.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void clearMaps()
  {
    this.mTagsToViews.clear();
    this.mRootTags.clear();
  }
  
  void configureLayoutAnimation(ReadableMap paramReadableMap)
  {
    try
    {
      this.mLayoutAnimator.initializeFromConfig(paramReadableMap);
      return;
    }
    catch (Exception paramReadableMap)
    {
      paramReadableMap.printStackTrace();
    }
  }
  
  public void createView(ThemedReactContext paramThemedReactContext, int paramInt, String paramString, @Nullable CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    UiThreadUtil.assertOnUiThread();
    SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_createView").arg("tag", paramInt).arg("className", paramString).flush();
    try
    {
      paramString = this.mViewManagers.get(paramString);
      paramThemedReactContext = paramString.createView(paramThemedReactContext, this.mJSResponderHandler);
      if (paramThemedReactContext != null)
      {
        this.mTagsToViews.put(paramInt, paramThemedReactContext);
        this.mTagsToViewManagers.put(paramInt, paramString);
        paramThemedReactContext.setId(paramInt);
        if (paramCatalystStylesDiffMap != null) {
          paramString.updateProperties(paramThemedReactContext, paramCatalystStylesDiffMap);
        }
      }
      return;
    }
    catch (Exception paramThemedReactContext)
    {
      paramThemedReactContext.printStackTrace();
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }
  
  public void dispatchCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      View localView = (View)this.mTagsToViews.get(paramInt1);
      if (localView == null)
      {
        if (FLog.isLoggable(4)) {
          FLog.i(TAG, "Trying to send command to a non-existing view with tag " + paramInt1);
        }
      }
      else
      {
        resolveViewManager(paramInt1).receiveCommand(localView, paramInt2, paramReadableArray);
        return;
      }
    }
    catch (Exception paramReadableArray)
    {
      paramReadableArray.printStackTrace();
    }
  }
  
  public int findTargetTagForTouch(int paramInt, float paramFloat1, float paramFloat2)
  {
    try
    {
      View localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
      {
        if (FLog.isLoggable(4))
        {
          FLog.i(TAG, "Could not find view with tag " + paramInt);
          return -1;
        }
      }
      else
      {
        paramInt = TouchTargetHelper.findTargetTagForTouch(paramFloat1, paramFloat2, (ViewGroup)localView);
        return paramInt;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public AnimationRegistry getAnimationRegistry()
  {
    return this.mAnimationRegistry;
  }
  
  public View getView(int paramInt)
  {
    return (View)this.mTagsToViews.get(paramInt);
  }
  
  public ViewManager getViewManager(int paramInt)
  {
    return (ViewManager)this.mTagsToViewManagers.get(paramInt);
  }
  
  public void manageChildren(int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    ViewGroup localViewGroup;
    ViewGroupManager localViewGroupManager;
    int j;
    int i;
    int m;
    int k;
    try
    {
      localViewGroup = (ViewGroup)this.mTagsToViews.get(paramInt);
      localViewGroupManager = (ViewGroupManager)resolveViewManager(paramInt);
      if (localViewGroup == null)
      {
        if (!FLog.isLoggable(4)) {
          break label472;
        }
        FLog.i(TAG, "Trying to manageChildren view with tag " + paramInt + " which doesn't exist");
        return;
      }
      j = localViewGroupManager.getChildCount(localViewGroup);
      if (paramArrayOfInt1 == null) {
        break label486;
      }
      i = paramArrayOfInt1.length - 1;
      if (i < 0) {
        break label486;
      }
      m = paramArrayOfInt1[i];
      if (m < 0)
      {
        k = j;
        if (FLog.isLoggable(4))
        {
          FLog.i(TAG, "Trying to remove a negative view index:" + m + " view tag: " + paramInt);
          k = j;
        }
      }
      else if (m >= localViewGroupManager.getChildCount(localViewGroup))
      {
        k = j;
        if (!FLog.isLoggable(4)) {
          break label473;
        }
        FLog.i(TAG, "Trying to remove a view index above child count " + m + " view tag: " + paramInt);
        k = j;
      }
    }
    catch (Exception paramArrayOfInt1)
    {
      paramArrayOfInt1.printStackTrace();
      return;
    }
    if (m >= j)
    {
      k = j;
      if (FLog.isLoggable(4))
      {
        FLog.i(TAG, "Trying to remove an out of order view index:" + m + " view tag: " + paramInt);
        k = j;
      }
    }
    else
    {
      localViewGroupManager.removeViewAt(localViewGroup, paramArrayOfInt1[i]);
      k = m;
      break label473;
      label311:
      if (paramInt >= paramArrayOfViewAtIndex.length) {
        break label502;
      }
      paramArrayOfInt1 = paramArrayOfViewAtIndex[paramInt];
      View localView = (View)this.mTagsToViews.get(paramArrayOfInt1.mTag);
      if (localView == null)
      {
        if (!FLog.isLoggable(4)) {
          break label495;
        }
        FLog.i(TAG, "Trying to add unknown view tag: " + paramArrayOfInt1.mTag);
        break label495;
      }
      localViewGroupManager.addView(localViewGroup, localView, paramArrayOfInt1.mIndex);
      break label495;
    }
    for (;;)
    {
      if (paramInt < paramArrayOfInt2.length)
      {
        i = paramArrayOfInt2[paramInt];
        paramArrayOfInt1 = (View)this.mTagsToViews.get(i);
        if (paramArrayOfInt1 == null)
        {
          if (FLog.isLoggable(4)) {
            FLog.i(TAG, "Trying to destroy unknown view tag: " + i);
          }
        }
        else {
          dropView(paramArrayOfInt1);
        }
      }
      else
      {
        label472:
        label473:
        label486:
        label495:
        label502:
        do
        {
          return;
          i -= 1;
          j = k;
          break;
          if (paramArrayOfViewAtIndex != null)
          {
            paramInt = 0;
            break label311;
            paramInt += 1;
            break label311;
          }
        } while (paramArrayOfInt2 == null);
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }
  
  public void measure(int paramInt, int[] paramArrayOfInt)
  {
    View localView1;
    View localView2;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView1 = (View)this.mTagsToViews.get(paramInt);
      if (localView1 == null)
      {
        if (!FLog.isLoggable(4)) {
          return;
        }
        FLog.i(TAG, "No native view for " + paramInt + " currently exists");
        return;
      }
      localView2 = (View)RootViewUtil.getRootView(localView1);
      if (localView2 == null) {
        throw new NoSuchNativeViewException("Native view " + paramInt + " is no longer on screen");
      }
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
      return;
    }
    localView2.getLocationInWindow(paramArrayOfInt);
    paramInt = paramArrayOfInt[0];
    int i = paramArrayOfInt[1];
    localView1.getLocationInWindow(paramArrayOfInt);
    paramArrayOfInt[0] -= paramInt;
    paramArrayOfInt[1] -= i;
    paramArrayOfInt[2] = localView1.getWidth();
    paramArrayOfInt[3] = localView1.getHeight();
  }
  
  public void removeRootView(int paramInt)
  {
    try
    {
      
      if (!this.mRootTags.get(paramInt)) {
        return;
      }
      dropView((View)this.mTagsToViews.get(paramInt));
      this.mRootTags.delete(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected final View resolveView(int paramInt)
  {
    View localView = (View)this.mTagsToViews.get(paramInt);
    if ((localView == null) && (FLog.isLoggable(4))) {
      FLog.i(TAG, "Trying to resolve view with tag " + paramInt + " which doesn't exist");
    }
    return localView;
  }
  
  protected final ViewManager resolveViewManager(int paramInt)
  {
    ViewManager localViewManager = (ViewManager)this.mTagsToViewManagers.get(paramInt);
    if ((localViewManager == null) && (FLog.isLoggable(4))) {
      FLog.i(TAG, "ViewManager for tag " + paramInt + " could not be found");
    }
    return localViewManager;
  }
  
  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    try
    {
      View localView = (View)this.mTagsToViews.get(paramInt1);
      if (localView == null)
      {
        if (FLog.isLoggable(4)) {
          FLog.i(TAG, "Could not find view with tag " + paramInt1);
        }
      }
      else
      {
        AccessibilityHelper.sendAccessibilityEvent(localView, paramInt2);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setJSResponder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      this.mJSResponderHandler.setJSResponder(paramInt2, null);
      return;
    }
    catch (Exception localException)
    {
      View localView;
      localException.printStackTrace();
      return;
    }
    localView = (View)this.mTagsToViews.get(paramInt1);
    if ((paramInt2 != paramInt1) && ((localView instanceof ViewParent)))
    {
      this.mJSResponderHandler.setJSResponder(paramInt2, (ViewParent)localView);
      return;
    }
    if (this.mRootTags.get(paramInt1)) {
      SoftAssertions.assertUnreachable("Cannot block native responder on " + paramInt1 + " that is a root view");
    }
    this.mJSResponderHandler.setJSResponder(paramInt2, localException.getParent());
  }
  
  public void setLayoutAnimationEnabled(boolean paramBoolean)
  {
    this.mLayoutAnimationEnabled = paramBoolean;
  }
  
  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      Object localObject = (View)this.mTagsToViews.get(paramInt);
      if (localObject == null)
      {
        if (FLog.isLoggable(4)) {
          FLog.i(TAG, "Could not find view with tag " + paramInt);
        }
      }
      else
      {
        localObject = new PopupMenu(getReactContextForView(paramInt), (View)localObject);
        Menu localMenu = ((PopupMenu)localObject).getMenu();
        paramInt = 0;
        while (paramInt < paramReadableArray.size())
        {
          localMenu.add(0, 0, paramInt, paramReadableArray.getString(paramInt));
          paramInt += 1;
        }
        paramReadableArray = new PopupMenuCallbackHandler(paramCallback, null);
        ((PopupMenu)localObject).setOnMenuItemClickListener(paramReadableArray);
        ((PopupMenu)localObject).setOnDismissListener(paramReadableArray);
        ((PopupMenu)localObject).show();
        return;
      }
    }
    catch (Exception paramReadableArray)
    {
      paramReadableArray.printStackTrace();
    }
  }
  
  void startAnimationForNativeView(int paramInt, Animation paramAnimation, @Nullable final Callback paramCallback)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      View localView = (View)this.mTagsToViews.get(paramInt);
      final int i = paramAnimation.getAnimationID();
      if (localView != null)
      {
        paramAnimation.setAnimationListener(new AnimationListener()
        {
          public void onCancel()
          {
            if (NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(i) == null) {
              if (FLog.isLoggable(6)) {
                FLog.e("Exception", "Animation was already removed somehow!");
              }
            }
            while (paramCallback == null) {
              return;
            }
            paramCallback.invoke(new Object[] { Boolean.valueOf(false) });
          }
          
          public void onFinished()
          {
            if (NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(i) == null) {
              if (FLog.isLoggable(6)) {
                FLog.e("Exception", "Animation was already removed somehow!");
              }
            }
            while (paramCallback == null) {
              return;
            }
            paramCallback.invoke(new Object[] { Boolean.valueOf(true) });
          }
        });
        paramAnimation.start(localView);
        return;
      }
      if (FLog.isLoggable(4))
      {
        FLog.i(TAG, "View with tag " + paramInt + " not found");
        return;
      }
    }
    catch (Exception paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  /* Error */
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    // Byte code:
    //   0: invokestatic 165	com/facebook/react/bridge/UiThreadUtil:assertOnUiThread	()V
    //   3: lconst_0
    //   4: ldc_w 489
    //   7: invokestatic 271	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   10: ldc_w 491
    //   13: iload_1
    //   14: invokevirtual 279	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   17: ldc_w 273
    //   20: iload_2
    //   21: invokevirtual 279	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   24: invokevirtual 287	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   27: aload_0
    //   28: iload_2
    //   29: invokevirtual 493	com/facebook/react/uimanager/NativeViewHierarchyManager:resolveView	(I)Landroid/view/View;
    //   32: astore 7
    //   34: aload 7
    //   36: iload 5
    //   38: ldc_w 494
    //   41: invokestatic 500	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   44: iload 6
    //   46: ldc_w 494
    //   49: invokestatic 500	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   52: invokevirtual 502	android/view/View:measure	(II)V
    //   55: aload_0
    //   56: getfield 80	com/facebook/react/uimanager/NativeViewHierarchyManager:mRootTags	Landroid/util/SparseBooleanArray;
    //   59: iload_1
    //   60: invokevirtual 169	android/util/SparseBooleanArray:get	(I)Z
    //   63: ifne +106 -> 169
    //   66: aload_0
    //   67: getfield 75	com/facebook/react/uimanager/NativeViewHierarchyManager:mTagsToViewManagers	Landroid/util/SparseArray;
    //   70: iload_1
    //   71: invokevirtual 188	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   74: checkcast 181	com/facebook/react/uimanager/ViewManager
    //   77: astore 8
    //   79: aload 8
    //   81: instanceof 114
    //   84: ifeq +41 -> 125
    //   87: aload 8
    //   89: checkcast 114	com/facebook/react/uimanager/ViewGroupManager
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull +24 -> 120
    //   99: aload 8
    //   101: invokevirtual 506	com/facebook/react/uimanager/ViewGroupManager:needsCustomLayoutForChildren	()Z
    //   104: ifne +16 -> 120
    //   107: aload_0
    //   108: aload 7
    //   110: iload_3
    //   111: iload 4
    //   113: iload 5
    //   115: iload 6
    //   117: invokespecial 508	com/facebook/react/uimanager/NativeViewHierarchyManager:updateLayout	(Landroid/view/View;IIII)V
    //   120: lconst_0
    //   121: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   124: return
    //   125: iconst_4
    //   126: invokestatic 205	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   129: ifeq +35 -> 164
    //   132: getstatic 41	com/facebook/react/uimanager/NativeViewHierarchyManager:TAG	Ljava/lang/String;
    //   135: new 89	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 510
    //   145: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_2
    //   149: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: ldc_w 512
    //   155: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 211	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: lconst_0
    //   165: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   168: return
    //   169: aload_0
    //   170: aload 7
    //   172: iload_3
    //   173: iload 4
    //   175: iload 5
    //   177: iload 6
    //   179: invokespecial 508	com/facebook/react/uimanager/NativeViewHierarchyManager:updateLayout	(Landroid/view/View;IIII)V
    //   182: goto -62 -> 120
    //   185: astore 7
    //   187: aload 7
    //   189: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   192: lconst_0
    //   193: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   196: return
    //   197: astore 7
    //   199: lconst_0
    //   200: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   203: aload 7
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	NativeViewHierarchyManager
    //   0	206	1	paramInt1	int
    //   0	206	2	paramInt2	int
    //   0	206	3	paramInt3	int
    //   0	206	4	paramInt4	int
    //   0	206	5	paramInt5	int
    //   0	206	6	paramInt6	int
    //   32	139	7	localView	View
    //   185	3	7	localException	Exception
    //   197	7	7	localObject1	Object
    //   77	23	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	94	185	java/lang/Exception
    //   99	120	185	java/lang/Exception
    //   125	164	185	java/lang/Exception
    //   169	182	185	java/lang/Exception
    //   27	94	197	finally
    //   99	120	197	finally
    //   125	164	197	finally
    //   169	182	197	finally
    //   187	192	197	finally
  }
  
  public void updateProperties(int paramInt, CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      resolveViewManager(paramInt).updateProperties(resolveView(paramInt), paramCatalystStylesDiffMap);
      return;
    }
    catch (Exception paramCatalystStylesDiffMap)
    {
      paramCatalystStylesDiffMap.printStackTrace();
    }
  }
  
  public void updateViewExtraData(int paramInt, Object paramObject)
  {
    try
    {
      UiThreadUtil.assertOnUiThread();
      resolveViewManager(paramInt).updateExtraData(resolveView(paramInt), paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  private static class PopupMenuCallbackHandler
    implements PopupMenu.OnMenuItemClickListener, PopupMenu.OnDismissListener
  {
    boolean mConsumed = false;
    final Callback mSuccess;
    
    private PopupMenuCallbackHandler(Callback paramCallback)
    {
      this.mSuccess = paramCallback;
    }
    
    public void onDismiss(PopupMenu paramPopupMenu)
    {
      if (!this.mConsumed)
      {
        this.mSuccess.invoke(new Object[] { "dismissed" });
        this.mConsumed = true;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (!this.mConsumed)
      {
        this.mSuccess.invoke(new Object[] { "itemSelected", Integer.valueOf(paramMenuItem.getOrder()) });
        this.mConsumed = true;
        return true;
      }
      return false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\NativeViewHierarchyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */