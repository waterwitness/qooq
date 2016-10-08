package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import javax.annotation.Nullable;

public class NativeViewHierarchyOptimizer
{
  private static final boolean ENABLED = true;
  private final ShadowNodeRegistry mShadowNodeRegistry;
  private final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
  private final UIViewOperationQueue mUIViewOperationQueue;
  
  public NativeViewHierarchyOptimizer(UIViewOperationQueue paramUIViewOperationQueue, ShadowNodeRegistry paramShadowNodeRegistry)
  {
    this.mUIViewOperationQueue = paramUIViewOperationQueue;
    this.mShadowNodeRegistry = paramShadowNodeRegistry;
  }
  
  private void addLayoutOnlyNodeToLayoutOnlyNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    ReactShadowNode localReactShadowNode = paramReactShadowNode1.getParent();
    if (localReactShadowNode == null) {
      return;
    }
    paramInt += localReactShadowNode.getNativeOffsetForChild(paramReactShadowNode1);
    if (localReactShadowNode.isLayoutOnly())
    {
      addLayoutOnlyNodeToLayoutOnlyNode(localReactShadowNode, paramReactShadowNode2, paramInt);
      return;
    }
    addLayoutOnlyNodeToNonLayoutOnlyNode(localReactShadowNode, paramReactShadowNode2, paramInt);
  }
  
  private void addLayoutOnlyNodeToNonLayoutOnlyNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    int i = 0;
    if (i < paramReactShadowNode2.getChildCount())
    {
      ReactShadowNode localReactShadowNode = paramReactShadowNode2.getChildAt(i);
      boolean bool;
      if (localReactShadowNode.getNativeParent() == null)
      {
        bool = true;
        label31:
        Assertions.assertCondition(bool);
        if (!localReactShadowNode.isLayoutOnly()) {
          break label83;
        }
        int j = paramReactShadowNode1.getNativeChildCount();
        addLayoutOnlyNodeToNonLayoutOnlyNode(paramReactShadowNode1, localReactShadowNode, paramInt);
        paramInt += paramReactShadowNode1.getNativeChildCount() - j;
      }
      for (;;)
      {
        i += 1;
        break;
        bool = false;
        break label31;
        label83:
        addNonLayoutNodeToNonLayoutNode(paramReactShadowNode1, localReactShadowNode, paramInt);
        paramInt += 1;
      }
    }
  }
  
  private void addNodeToNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    paramInt = paramReactShadowNode1.getNativeOffsetForChild(paramReactShadowNode1.getChildAt(paramInt));
    boolean bool1 = paramReactShadowNode1.isLayoutOnly();
    boolean bool2 = paramReactShadowNode2.isLayoutOnly();
    if ((!bool1) && (!bool2))
    {
      addNonLayoutNodeToNonLayoutNode(paramReactShadowNode1, paramReactShadowNode2, paramInt);
      return;
    }
    if (!bool2)
    {
      addNonLayoutOnlyNodeToLayoutOnlyNode(paramReactShadowNode1, paramReactShadowNode2, paramInt);
      return;
    }
    if (!bool1)
    {
      addLayoutOnlyNodeToNonLayoutOnlyNode(paramReactShadowNode1, paramReactShadowNode2, paramInt);
      return;
    }
    addLayoutOnlyNodeToLayoutOnlyNode(paramReactShadowNode1, paramReactShadowNode2, paramInt);
  }
  
  private void addNonLayoutNodeToNonLayoutNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    paramReactShadowNode1.addNativeChildAt(paramReactShadowNode2, paramInt);
    this.mUIViewOperationQueue.enqueueManageChildren(paramReactShadowNode1.getReactTag(), null, new ViewAtIndex[] { new ViewAtIndex(paramReactShadowNode2.getReactTag(), paramInt) }, null);
  }
  
  private void addNonLayoutOnlyNodeToLayoutOnlyNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    ReactShadowNode localReactShadowNode = paramReactShadowNode1.getParent();
    if (localReactShadowNode == null) {
      return;
    }
    paramInt += localReactShadowNode.getNativeOffsetForChild(paramReactShadowNode1);
    if (localReactShadowNode.isLayoutOnly())
    {
      addNonLayoutOnlyNodeToLayoutOnlyNode(localReactShadowNode, paramReactShadowNode2, paramInt);
      return;
    }
    addNonLayoutNodeToNonLayoutNode(localReactShadowNode, paramReactShadowNode2, paramInt);
  }
  
  private void applyLayoutBase(ReactShadowNode paramReactShadowNode)
  {
    int i = paramReactShadowNode.getReactTag();
    if (this.mTagsWithLayoutVisited.get(i)) {
      return;
    }
    this.mTagsWithLayoutVisited.put(i, true);
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
    int j = paramReactShadowNode.getScreenX();
    i = paramReactShadowNode.getScreenY();
    while ((localReactShadowNode != null) && (localReactShadowNode.isLayoutOnly()))
    {
      j += Math.round(localReactShadowNode.getLayoutX());
      i += Math.round(localReactShadowNode.getLayoutY());
      localReactShadowNode = localReactShadowNode.getParent();
    }
    applyLayoutRecursive(paramReactShadowNode, j, i);
  }
  
  private void applyLayoutRecursive(ReactShadowNode paramReactShadowNode, int paramInt1, int paramInt2)
  {
    if ((!paramReactShadowNode.isLayoutOnly()) && (paramReactShadowNode.getNativeParent() != null))
    {
      i = paramReactShadowNode.getReactTag();
      this.mUIViewOperationQueue.enqueueUpdateLayout(paramReactShadowNode.getNativeParent().getReactTag(), i, paramInt1, paramInt2, paramReactShadowNode.getScreenWidth(), paramReactShadowNode.getScreenHeight());
      return;
    }
    int i = 0;
    label50:
    ReactShadowNode localReactShadowNode;
    int j;
    if (i < paramReactShadowNode.getChildCount())
    {
      localReactShadowNode = paramReactShadowNode.getChildAt(i);
      j = localReactShadowNode.getReactTag();
      if (!this.mTagsWithLayoutVisited.get(j)) {
        break label95;
      }
    }
    for (;;)
    {
      i += 1;
      break label50;
      break;
      label95:
      this.mTagsWithLayoutVisited.put(j, true);
      applyLayoutRecursive(localReactShadowNode, localReactShadowNode.getScreenX() + paramInt1, localReactShadowNode.getScreenY() + paramInt2);
    }
  }
  
  public static void handleRemoveNode(ReactShadowNode paramReactShadowNode)
  {
    paramReactShadowNode.removeAllNativeChildren();
  }
  
  private static boolean isLayoutOnlyAndCollapsable(@Nullable CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    if (paramCatalystStylesDiffMap == null) {}
    do
    {
      while (!paramCatalystStylesDiffMap.hasNextKey())
      {
        return true;
        if ((paramCatalystStylesDiffMap.hasKey("collapsable")) && (!paramCatalystStylesDiffMap.getBoolean("collapsable", true))) {
          return false;
        }
        paramCatalystStylesDiffMap = paramCatalystStylesDiffMap.mBackingMap.keySetIterator();
      }
    } while (ViewProps.isLayoutOnly(paramCatalystStylesDiffMap.nextKey()));
    return false;
  }
  
  private void removeNodeFromParent(ReactShadowNode paramReactShadowNode, boolean paramBoolean)
  {
    Object localObject = paramReactShadowNode.getNativeParent();
    int i;
    if (localObject != null)
    {
      i = ((ReactShadowNode)localObject).indexOfNativeChild(paramReactShadowNode);
      ((ReactShadowNode)localObject).removeNativeChildAt(i);
      UIViewOperationQueue localUIViewOperationQueue = this.mUIViewOperationQueue;
      int j = ((ReactShadowNode)localObject).getReactTag();
      if (paramBoolean)
      {
        localObject = new int[1];
        localObject[0] = paramReactShadowNode.getReactTag();
        paramReactShadowNode = (ReactShadowNode)localObject;
        localUIViewOperationQueue.enqueueManageChildren(j, new int[] { i }, null, paramReactShadowNode);
      }
    }
    for (;;)
    {
      return;
      paramReactShadowNode = null;
      break;
      i = paramReactShadowNode.getChildCount() - 1;
      while (i >= 0)
      {
        removeNodeFromParent(paramReactShadowNode.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
  }
  
  private void transitionLayoutOnlyViewToNativeView(ReactShadowNode paramReactShadowNode, @Nullable CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    boolean bool = false;
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
    if (localReactShadowNode == null)
    {
      paramReactShadowNode.setIsLayoutOnly(false);
      return;
    }
    int i = localReactShadowNode.indexOf(paramReactShadowNode);
    localReactShadowNode.removeChildAt(i);
    removeNodeFromParent(paramReactShadowNode, false);
    paramReactShadowNode.setIsLayoutOnly(false);
    this.mUIViewOperationQueue.enqueueCreateView(paramReactShadowNode.getRootNode().getThemedContext(), paramReactShadowNode.getReactTag(), paramReactShadowNode.getViewClass(), paramCatalystStylesDiffMap);
    localReactShadowNode.addChildAt(paramReactShadowNode, i);
    addNodeToNode(localReactShadowNode, paramReactShadowNode, i);
    i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      addNodeToNode(paramReactShadowNode, paramReactShadowNode.getChildAt(i), i);
      i += 1;
    }
    if (this.mTagsWithLayoutVisited.size() == 0) {
      bool = true;
    }
    Assertions.assertCondition(bool);
    applyLayoutBase(paramReactShadowNode);
    i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      applyLayoutBase(paramReactShadowNode.getChildAt(i));
      i += 1;
    }
    this.mTagsWithLayoutVisited.clear();
  }
  
  public void handleCreateView(ReactShadowNode paramReactShadowNode, ThemedReactContext paramThemedReactContext, @Nullable CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    if ((paramReactShadowNode.getViewClass().equals("RCTView")) && (isLayoutOnlyAndCollapsable(paramCatalystStylesDiffMap))) {}
    for (boolean bool = true;; bool = false)
    {
      paramReactShadowNode.setIsLayoutOnly(bool);
      if (!bool) {
        this.mUIViewOperationQueue.enqueueCreateView(paramThemedReactContext, paramReactShadowNode.getReactTag(), paramReactShadowNode.getViewClass(), paramCatalystStylesDiffMap);
      }
      return;
    }
  }
  
  public void handleManageChildren(ReactShadowNode paramReactShadowNode, int[] paramArrayOfInt1, int[] paramArrayOfInt2, ViewAtIndex[] paramArrayOfViewAtIndex, int[] paramArrayOfInt3)
  {
    int i = 0;
    if (i < paramArrayOfInt2.length)
    {
      int k = paramArrayOfInt2[i];
      boolean bool2 = false;
      int j = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (j < paramArrayOfInt3.length)
        {
          if (paramArrayOfInt3[j] == k) {
            bool1 = true;
          }
        }
        else
        {
          removeNodeFromParent(this.mShadowNodeRegistry.getNode(k), bool1);
          i += 1;
          break;
        }
        j += 1;
      }
    }
    i = 0;
    while (i < paramArrayOfViewAtIndex.length)
    {
      paramArrayOfInt1 = paramArrayOfViewAtIndex[i];
      addNodeToNode(paramReactShadowNode, this.mShadowNodeRegistry.getNode(paramArrayOfInt1.mTag), paramArrayOfInt1.mIndex);
      i += 1;
    }
  }
  
  public void handleUpdateLayout(ReactShadowNode paramReactShadowNode)
  {
    applyLayoutBase(paramReactShadowNode);
  }
  
  public void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    int i;
    if ((paramReactShadowNode.isLayoutOnly()) && (!isLayoutOnlyAndCollapsable(paramCatalystStylesDiffMap)))
    {
      i = 1;
      if (i == 0) {
        break label35;
      }
      transitionLayoutOnlyViewToNativeView(paramReactShadowNode, paramCatalystStylesDiffMap);
    }
    label35:
    while (paramReactShadowNode.isLayoutOnly())
    {
      return;
      i = 0;
      break;
    }
    this.mUIViewOperationQueue.enqueueUpdateProperties(paramReactShadowNode.getReactTag(), paramString, paramCatalystStylesDiffMap);
  }
  
  public void onBatchComplete()
  {
    this.mTagsWithLayoutVisited.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\NativeViewHierarchyOptimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */