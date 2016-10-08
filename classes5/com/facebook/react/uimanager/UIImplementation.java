package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.csslayout.CSSLayoutContext;
import com.facebook.csslayout.CSSNode;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

public class UIImplementation
{
  private static final String TAG = UIManagerModule.class.getSimpleName();
  private final CSSLayoutContext mLayoutContext = new CSSLayoutContext();
  private final int[] mMeasureBuffer = new int[4];
  public final NativeViewHierarchyManager mNativeViewHierarchyManager;
  private final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
  private final UIViewOperationQueue mOperationsQueue;
  private final ShadowNodeRegistry mShadowNodeRegistry = new ShadowNodeRegistry();
  private final ViewManagerRegistry mViewManagers;
  
  private UIImplementation(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry)
  {
    this(paramViewManagerRegistry, new UIViewOperationQueue(paramReactApplicationContext, new NativeViewHierarchyManager(paramViewManagerRegistry)));
  }
  
  public UIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList)
  {
    this(paramReactApplicationContext, new ViewManagerRegistry(paramList));
  }
  
  protected UIImplementation(ViewManagerRegistry paramViewManagerRegistry, UIViewOperationQueue paramUIViewOperationQueue)
  {
    this.mNativeViewHierarchyManager = paramUIViewOperationQueue.mNativeViewHierarchyManager;
    this.mViewManagers = paramViewManagerRegistry;
    this.mOperationsQueue = paramUIViewOperationQueue;
    this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(this.mOperationsQueue, this.mShadowNodeRegistry);
  }
  
  private void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode paramReactShadowNode)
  {
    Object localObject = (ViewManager)Assertions.assertNotNull(this.mViewManagers.get(paramReactShadowNode.getViewClass()));
    if ((localObject instanceof ViewGroupManager))
    {
      localObject = (ViewGroupManager)localObject;
      if ((localObject != null) && (((ViewGroupManager)localObject).needsCustomLayoutForChildren())) {
        throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + paramReactShadowNode.getViewClass() + "). Use measure instead.");
      }
    }
    else
    {
      throw new IllegalViewOperationException("Trying to use view " + paramReactShadowNode.getViewClass() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }
  }
  
  private void assertViewExists(int paramInt, String paramString)
  {
    if (this.mShadowNodeRegistry.getNode(paramInt) == null) {
      throw new IllegalViewOperationException("Unable to execute operation " + paramString + " on view with " + "tag: " + paramInt + ", since the view does not exists");
    }
  }
  
  private void measureLayout(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt1);
    ReactShadowNode localReactShadowNode3 = this.mShadowNodeRegistry.getNode(paramInt2);
    if ((localReactShadowNode2 == null) || (localReactShadowNode3 == null))
    {
      paramArrayOfInt = new StringBuilder().append("Tag ");
      if (localReactShadowNode2 == null) {}
      for (;;)
      {
        throw new IllegalViewOperationException(paramInt1 + " does not exist");
        paramInt1 = paramInt2;
      }
    }
    if (localReactShadowNode2 != localReactShadowNode3) {
      for (ReactShadowNode localReactShadowNode1 = localReactShadowNode2.getParent(); localReactShadowNode1 != localReactShadowNode3; localReactShadowNode1 = localReactShadowNode1.getParent()) {
        if (localReactShadowNode1 == null) {
          throw new IllegalViewOperationException("Tag " + paramInt2 + " is not an ancestor of tag " + paramInt1);
        }
      }
    }
    measureLayoutRelativeToVerifiedAncestor(localReactShadowNode2, localReactShadowNode3, paramArrayOfInt);
  }
  
  private void measureLayoutRelativeToParent(int paramInt, int[] paramArrayOfInt)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode1 == null) {
      throw new IllegalViewOperationException("No native view for tag " + paramInt + " exists!");
    }
    ReactShadowNode localReactShadowNode2 = localReactShadowNode1.getParent();
    if (localReactShadowNode2 == null) {
      throw new IllegalViewOperationException("View with tag " + paramInt + " doesn't have a parent!");
    }
    measureLayoutRelativeToVerifiedAncestor(localReactShadowNode1, localReactShadowNode2, paramArrayOfInt);
  }
  
  private void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    if (paramReactShadowNode1 != paramReactShadowNode2)
    {
      i = Math.round(paramReactShadowNode1.getLayoutX());
      j = Math.round(paramReactShadowNode1.getLayoutY());
      for (ReactShadowNode localReactShadowNode = paramReactShadowNode1.getParent(); localReactShadowNode != paramReactShadowNode2; localReactShadowNode = localReactShadowNode.getParent())
      {
        Assertions.assertNotNull(localReactShadowNode);
        assertNodeDoesNotNeedCustomLayoutForChildren(localReactShadowNode);
        i += Math.round(localReactShadowNode.getLayoutX());
        j += Math.round(localReactShadowNode.getLayoutY());
      }
      assertNodeDoesNotNeedCustomLayoutForChildren(paramReactShadowNode2);
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = j;
    paramArrayOfInt[2] = paramReactShadowNode1.getScreenWidth();
    paramArrayOfInt[3] = paramReactShadowNode1.getScreenHeight();
  }
  
  private void notifyOnBeforeLayoutRecursive(ReactShadowNode paramReactShadowNode)
  {
    if (!paramReactShadowNode.hasUpdates()) {
      return;
    }
    int i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      notifyOnBeforeLayoutRecursive(paramReactShadowNode.getChildAt(i));
      i += 1;
    }
    paramReactShadowNode.onBeforeLayout();
  }
  
  public void addAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    assertViewExists(paramInt1, "addAnimation");
    this.mOperationsQueue.enqueueAddAnimation(paramInt1, paramInt2, paramCallback);
  }
  
  protected void applyUpdatesRecursive(ReactShadowNode paramReactShadowNode, float paramFloat1, float paramFloat2, EventDispatcher paramEventDispatcher)
  {
    if (!paramReactShadowNode.hasUpdates()) {
      return;
    }
    if (!paramReactShadowNode.isVirtualAnchor())
    {
      i = 0;
      while (i < paramReactShadowNode.getChildCount())
      {
        applyUpdatesRecursive(paramReactShadowNode.getChildAt(i), paramReactShadowNode.getLayoutX() + paramFloat1, paramReactShadowNode.getLayoutY() + paramFloat2, paramEventDispatcher);
        i += 1;
      }
    }
    int i = paramReactShadowNode.getReactTag();
    if (!this.mShadowNodeRegistry.isRootNode(i))
    {
      paramReactShadowNode.dispatchUpdates(paramFloat1, paramFloat2, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer);
      if (paramReactShadowNode.shouldNotifyOnLayout()) {
        paramEventDispatcher.dispatchEvent(OnLayoutEvent.obtain(i, paramReactShadowNode.getScreenX(), paramReactShadowNode.getScreenY(), paramReactShadowNode.getScreenWidth(), paramReactShadowNode.getScreenHeight()));
      }
    }
    paramReactShadowNode.markUpdateSeen();
  }
  
  protected void calculateRootLayout(ReactShadowNode paramReactShadowNode)
  {
    SystraceMessage.beginSection(0L, "cssRoot.calculateLayout").arg("rootTag", paramReactShadowNode.getReactTag()).flush();
    try
    {
      paramReactShadowNode.calculateLayout(this.mLayoutContext);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }
  
  public void clearJSResponder()
  {
    this.mOperationsQueue.enqueueClearJSResponder();
  }
  
  public void configureNextLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperationsQueue.enqueueConfigureLayoutAnimation(paramReadableMap, paramCallback1, paramCallback2);
  }
  
  protected ReactShadowNode createRootShadowNode()
  {
    ReactShadowNode localReactShadowNode = new ReactShadowNode();
    localReactShadowNode.setViewClassName("Root");
    return localReactShadowNode;
  }
  
  protected ReactShadowNode createShadowNode(String paramString)
  {
    return this.mViewManagers.get(paramString).createShadowNodeInstance();
  }
  
  public void createView(int paramInt1, String paramString, int paramInt2, ReadableMap paramReadableMap)
  {
    ReactShadowNode localReactShadowNode1 = createShadowNode(paramString);
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt2);
    localReactShadowNode1.setReactTag(paramInt1);
    localReactShadowNode1.setViewClassName(paramString);
    localReactShadowNode1.setRootNode(localReactShadowNode2);
    localReactShadowNode1.setThemedContext(localReactShadowNode2.getThemedContext());
    this.mShadowNodeRegistry.addNode(localReactShadowNode1);
    paramString = null;
    if (paramReadableMap != null)
    {
      paramString = new CatalystStylesDiffMap(paramReadableMap);
      localReactShadowNode1.updateProperties(paramString);
    }
    handleCreateView(localReactShadowNode1, paramInt2, paramString);
  }
  
  public void dispatchViewManagerCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    assertViewExists(paramInt1, "dispatchViewManagerCommand");
    this.mOperationsQueue.enqueueDispatchCommand(paramInt1, paramInt2, paramReadableArray);
  }
  
  public void dispatchViewUpdates(EventDispatcher paramEventDispatcher, int paramInt)
  {
    int i = 0;
    while (i < this.mShadowNodeRegistry.getRootNodeCount())
    {
      int j = this.mShadowNodeRegistry.getRootTag(i);
      ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(j);
      notifyOnBeforeLayoutRecursive(localReactShadowNode);
      calculateRootLayout(localReactShadowNode);
      View localView = this.mNativeViewHierarchyManager.getView(j);
      if ((localView != null) && ((ViewGroup)localView.getParent() != null))
      {
        j = (int)localReactShadowNode.getFactHeight();
        if ((j > 0) && ((localView instanceof SizeMonitoringFrameLayout))) {
          ((SizeMonitoringFrameLayout)localView).saveFactSize(j);
        }
      }
      applyUpdatesRecursive(localReactShadowNode, 0.0F, 0.0F, paramEventDispatcher);
      i += 1;
    }
    this.mNativeViewHierarchyOptimizer.onBatchComplete();
    this.mOperationsQueue.dispatchViewUpdates(paramInt);
  }
  
  public void findSubviewIn(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueFindTargetForTouch(paramInt, paramFloat1, paramFloat2, paramCallback);
  }
  
  protected void handleCreateView(ReactShadowNode paramReactShadowNode, int paramInt, @Nullable CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    if (!paramReactShadowNode.isVirtual()) {
      this.mNativeViewHierarchyOptimizer.handleCreateView(paramReactShadowNode, paramReactShadowNode.getThemedContext(), paramCatalystStylesDiffMap);
    }
  }
  
  protected void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    if (!paramReactShadowNode.isVirtual()) {
      this.mNativeViewHierarchyOptimizer.handleUpdateView(paramReactShadowNode, paramString, paramCatalystStylesDiffMap);
    }
  }
  
  public void manageChildren(int paramInt, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3, @Nullable ReadableArray paramReadableArray4, @Nullable ReadableArray paramReadableArray5)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    int k;
    if (paramReadableArray1 == null)
    {
      i = 0;
      if (paramReadableArray3 != null) {
        break label75;
      }
      k = 0;
      label25:
      if (paramReadableArray5 != null) {
        break label87;
      }
    }
    label75:
    label87:
    for (int j = 0;; j = paramReadableArray5.size())
    {
      if ((i == 0) || ((paramReadableArray2 != null) && (i == paramReadableArray2.size()))) {
        break label99;
      }
      throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
      i = paramReadableArray1.size();
      break;
      k = paramReadableArray3.size();
      break label25;
    }
    label99:
    if ((k != 0) && ((paramReadableArray4 == null) || (k != paramReadableArray4.size()))) {
      throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
    }
    ViewAtIndex[] arrayOfViewAtIndex = new ViewAtIndex[i + k];
    int[] arrayOfInt1 = new int[i + j];
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    int[] arrayOfInt3 = new int[j];
    int m;
    int n;
    if (i > 0)
    {
      Assertions.assertNotNull(paramReadableArray1);
      Assertions.assertNotNull(paramReadableArray2);
      m = 0;
      while (m < i)
      {
        n = paramReadableArray1.getInt(m);
        int i1 = localReactShadowNode.getChildAt(n).getReactTag();
        arrayOfViewAtIndex[m] = new ViewAtIndex(i1, paramReadableArray2.getInt(m));
        arrayOfInt1[m] = n;
        arrayOfInt2[m] = i1;
        m += 1;
      }
    }
    if (k > 0)
    {
      Assertions.assertNotNull(paramReadableArray3);
      Assertions.assertNotNull(paramReadableArray4);
      m = 0;
      while (m < k)
      {
        arrayOfViewAtIndex[(i + m)] = new ViewAtIndex(paramReadableArray3.getInt(m), paramReadableArray4.getInt(m));
        m += 1;
      }
    }
    if (j > 0)
    {
      Assertions.assertNotNull(paramReadableArray5);
      k = 0;
      while (k < j)
      {
        m = paramReadableArray5.getInt(k);
        n = localReactShadowNode.getChildAt(m).getReactTag();
        arrayOfInt1[(i + k)] = m;
        arrayOfInt2[(i + k)] = n;
        arrayOfInt3[k] = n;
        k += 1;
      }
    }
    Arrays.sort(arrayOfViewAtIndex, ViewAtIndex.COMPARATOR);
    Arrays.sort(arrayOfInt1);
    j = -1;
    int i = arrayOfInt1.length - 1;
    while (i >= 0)
    {
      if (arrayOfInt1[i] == j) {
        throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + paramInt);
      }
      localReactShadowNode.removeChildAt(arrayOfInt1[i]);
      j = arrayOfInt1[i];
      i -= 1;
    }
    paramInt = 0;
    while (paramInt < arrayOfViewAtIndex.length)
    {
      paramReadableArray1 = arrayOfViewAtIndex[paramInt];
      paramReadableArray2 = this.mShadowNodeRegistry.getNode(paramReadableArray1.mTag);
      if (paramReadableArray2 == null) {
        throw new IllegalViewOperationException("Trying to add unknown view tag: " + paramReadableArray1.mTag);
      }
      localReactShadowNode.addChildAt(paramReadableArray2, paramReadableArray1.mIndex);
      paramInt += 1;
    }
    if ((!localReactShadowNode.isVirtual()) && (!localReactShadowNode.isVirtualAnchor())) {
      this.mNativeViewHierarchyOptimizer.handleManageChildren(localReactShadowNode, arrayOfInt1, arrayOfInt2, arrayOfViewAtIndex, arrayOfInt3);
    }
    paramInt = 0;
    while (paramInt < arrayOfInt3.length)
    {
      removeShadowNode(this.mShadowNodeRegistry.getNode(arrayOfInt3[paramInt]));
      paramInt += 1;
    }
  }
  
  public void measure(int paramInt, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueMeasure(paramInt, paramCallback);
  }
  
  public void measureLayout(int paramInt1, int paramInt2, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      measureLayout(paramInt1, paramInt2, this.mMeasureBuffer);
      paramCallback2.invoke(new Object[] { Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3])) });
      return;
    }
    catch (IllegalViewOperationException paramCallback2)
    {
      paramCallback1.invoke(new Object[] { paramCallback2.getMessage() });
    }
  }
  
  public void measureLayoutRelativeToParent(int paramInt, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      measureLayoutRelativeToParent(paramInt, this.mMeasureBuffer);
      paramCallback2.invoke(new Object[] { Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3])) });
      return;
    }
    catch (IllegalViewOperationException paramCallback2)
    {
      paramCallback1.invoke(new Object[] { paramCallback2.getMessage() });
    }
  }
  
  public void onHostDestroy() {}
  
  public void onHostPause()
  {
    this.mOperationsQueue.pauseFrameCallback();
  }
  
  public void onHostResume()
  {
    this.mOperationsQueue.resumeFrameCallback();
  }
  
  public void registerAnimation(Animation paramAnimation)
  {
    this.mOperationsQueue.enqueueRegisterAnimation(paramAnimation);
  }
  
  public void registerRootView(SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, int paramInt1, int paramInt2, int paramInt3, ThemedReactContext paramThemedReactContext)
  {
    ReactShadowNode localReactShadowNode = createRootShadowNode();
    localReactShadowNode.setReactTag(paramInt1);
    localReactShadowNode.setThemedContext(paramThemedReactContext);
    localReactShadowNode.setStyleWidth(paramInt2);
    localReactShadowNode.setStyleHeight(paramInt3);
    this.mShadowNodeRegistry.addRootNode(localReactShadowNode);
    this.mOperationsQueue.addRootView(paramInt1, paramSizeMonitoringFrameLayout, paramThemedReactContext);
  }
  
  public void removeAnimation(int paramInt1, int paramInt2)
  {
    assertViewExists(paramInt1, "removeAnimation");
    this.mOperationsQueue.enqueueRemoveAnimation(paramInt2);
  }
  
  public void removeRootView(int paramInt)
  {
    this.mShadowNodeRegistry.removeRootNode(paramInt);
    this.mOperationsQueue.enqueueRemoveRootView(paramInt);
  }
  
  protected final void removeShadowNode(ReactShadowNode paramReactShadowNode)
  {
    NativeViewHierarchyOptimizer localNativeViewHierarchyOptimizer = this.mNativeViewHierarchyOptimizer;
    NativeViewHierarchyOptimizer.handleRemoveNode(paramReactShadowNode);
    this.mShadowNodeRegistry.removeNode(paramReactShadowNode.getReactTag());
    int i = paramReactShadowNode.getChildCount() - 1;
    while (i >= 0)
    {
      removeShadowNode(paramReactShadowNode.getChildAt(i));
      i -= 1;
    }
    paramReactShadowNode.removeAllChildren();
  }
  
  public void removeSubviewsFromContainerWithID(int paramInt)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null) {
      throw new IllegalViewOperationException("Trying to remove subviews of an unknown view tag: " + paramInt);
    }
    WritableArray localWritableArray = Arguments.createArray();
    int i = 0;
    while (i < localReactShadowNode.getChildCount())
    {
      localWritableArray.pushInt(i);
      i += 1;
    }
    manageChildren(paramInt, null, null, null, null, localWritableArray);
  }
  
  public void replaceExistingNonRootView(int paramInt1, int paramInt2)
  {
    if ((this.mShadowNodeRegistry.isRootNode(paramInt1)) || (this.mShadowNodeRegistry.isRootNode(paramInt2))) {
      throw new IllegalViewOperationException("Trying to add or replace a root tag!");
    }
    Object localObject = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localObject == null) {
      throw new IllegalViewOperationException("Trying to replace unknown view tag: " + paramInt1);
    }
    ReactShadowNode localReactShadowNode = ((ReactShadowNode)localObject).getParent();
    if (localReactShadowNode == null) {
      throw new IllegalViewOperationException("Node is not attached to a parent: " + paramInt1);
    }
    paramInt1 = localReactShadowNode.indexOf((CSSNode)localObject);
    if (paramInt1 < 0) {
      throw new IllegalStateException("Didn't find child tag in parent");
    }
    localObject = Arguments.createArray();
    ((WritableArray)localObject).pushInt(paramInt2);
    WritableArray localWritableArray1 = Arguments.createArray();
    localWritableArray1.pushInt(paramInt1);
    WritableArray localWritableArray2 = Arguments.createArray();
    localWritableArray2.pushInt(paramInt1);
    manageChildren(localReactShadowNode.getReactTag(), null, null, (ReadableArray)localObject, localWritableArray1, localWritableArray2);
  }
  
  protected final ReactShadowNode resolveShadowNode(int paramInt)
  {
    return this.mShadowNodeRegistry.getNode(paramInt);
  }
  
  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mOperationsQueue.enqueueSendAccessibilityEvent(paramInt1, paramInt2);
  }
  
  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
    assertViewExists(paramInt, "setJSResponder");
    for (ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt); (localReactShadowNode.isVirtual()) || (localReactShadowNode.isLayoutOnly()); localReactShadowNode = localReactShadowNode.getParent()) {}
    this.mOperationsQueue.enqueueSetJSResponder(localReactShadowNode.getReactTag(), paramInt, paramBoolean);
  }
  
  public void setLayoutAnimationEnabledExperimental(boolean paramBoolean)
  {
    this.mOperationsQueue.enqueueSetLayoutAnimationEnabled(paramBoolean);
  }
  
  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mOperationsQueue.setViewHierarchyUpdateDebugListener(paramNotThreadSafeViewHierarchyUpdateDebugListener);
  }
  
  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    assertViewExists(paramInt, "showPopupMenu");
    this.mOperationsQueue.enqueueShowPopupMenu(paramInt, paramReadableArray, paramCallback1, paramCallback2);
  }
  
  public void updateRootNodeSize(int paramInt1, int paramInt2, int paramInt3, EventDispatcher paramEventDispatcher)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt1);
    localReactShadowNode.setStyleWidth(paramInt2);
    localReactShadowNode.setStyleHeight(paramInt3);
    if (this.mOperationsQueue.isEmpty()) {
      dispatchViewUpdates(paramEventDispatcher, -1);
    }
  }
  
  public void updateView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    if (this.mViewManagers.get(paramString) == null) {
      if (FLog.isLoggable(4)) {
        FLog.i(TAG, "Got unknown view type: " + paramString);
      }
    }
    ReactShadowNode localReactShadowNode;
    do
    {
      do
      {
        return;
        localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
        if (localReactShadowNode != null) {
          break;
        }
      } while (!FLog.isLoggable(4));
      FLog.i(TAG, "Trying to update non-existent view with tag " + paramInt);
      return;
    } while (paramReadableMap == null);
    paramReadableMap = new CatalystStylesDiffMap(paramReadableMap);
    localReactShadowNode.updateProperties(paramReadableMap);
    handleUpdateView(localReactShadowNode, paramString, paramReadableMap);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\UIImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */