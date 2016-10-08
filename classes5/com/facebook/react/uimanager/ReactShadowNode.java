package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.csslayout.CSSNode;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactShadowNode
  extends CSSNode
{
  private float mAbsoluteBottom;
  private float mAbsoluteLeft;
  private float mAbsoluteRight;
  private float mAbsoluteTop;
  private boolean mIsLayoutOnly;
  @Nullable
  private ArrayList<ReactShadowNode> mNativeChildren;
  @Nullable
  private ReactShadowNode mNativeParent;
  private boolean mNodeUpdated = true;
  private int mReactTag;
  @Nullable
  private ReactShadowNode mRootNode;
  private boolean mShouldNotifyOnLayout;
  @Nullable
  private ThemedReactContext mThemedContext;
  private int mTotalNativeChildren = 0;
  @Nullable
  private String mViewClassName;
  
  private void updateNativeChildrenCountInParent(int paramInt)
  {
    if (this.mIsLayoutOnly) {}
    for (ReactShadowNode localReactShadowNode = getParent();; localReactShadowNode = localReactShadowNode.getParent()) {
      if (localReactShadowNode != null)
      {
        localReactShadowNode.mTotalNativeChildren += paramInt;
        if (localReactShadowNode.mIsLayoutOnly) {}
      }
      else
      {
        return;
      }
    }
  }
  
  public void addChildAt(CSSNode paramCSSNode, int paramInt)
  {
    super.addChildAt(paramCSSNode, paramInt);
    markUpdated();
    paramCSSNode = (ReactShadowNode)paramCSSNode;
    if (paramCSSNode.mIsLayoutOnly) {}
    for (paramInt = paramCSSNode.mTotalNativeChildren;; paramInt = 1)
    {
      this.mTotalNativeChildren += paramInt;
      updateNativeChildrenCountInParent(paramInt);
      return;
    }
  }
  
  public void addNativeChildAt(ReactShadowNode paramReactShadowNode, int paramInt)
  {
    boolean bool2 = true;
    if (!this.mIsLayoutOnly)
    {
      bool1 = true;
      Assertions.assertCondition(bool1);
      if (paramReactShadowNode.mIsLayoutOnly) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.assertCondition(bool1);
      if (this.mNativeChildren == null) {
        this.mNativeChildren = new ArrayList(4);
      }
      this.mNativeChildren.add(paramInt, paramReactShadowNode);
      paramReactShadowNode.mNativeParent = this;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void dirty()
  {
    if (!isVirtual()) {
      super.dirty();
    }
  }
  
  void dispatchUpdates(float paramFloat1, float paramFloat2, UIViewOperationQueue paramUIViewOperationQueue, NativeViewHierarchyOptimizer paramNativeViewHierarchyOptimizer)
  {
    if (this.mNodeUpdated) {
      onCollectExtraUpdates(paramUIViewOperationQueue);
    }
    if (hasNewLayout())
    {
      this.mAbsoluteLeft = Math.round(getLayoutX() + paramFloat1);
      this.mAbsoluteTop = Math.round(getLayoutY() + paramFloat2);
      this.mAbsoluteRight = Math.round(getLayoutX() + paramFloat1 + getLayoutWidth());
      this.mAbsoluteBottom = Math.round(getLayoutY() + paramFloat2 + getLayoutHeight());
      paramNativeViewHierarchyOptimizer.handleUpdateLayout(this);
    }
  }
  
  public final ReactShadowNode getChildAt(int paramInt)
  {
    return (ReactShadowNode)super.getChildAt(paramInt);
  }
  
  public float getFactHeight()
  {
    float f1 = getLayoutHeight();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ReactShadowNode localReactShadowNode = getChildAt(i);
      float f2 = f1;
      if (localReactShadowNode != null)
      {
        float f3 = localReactShadowNode.getFactHeight();
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
    }
    return f1;
  }
  
  public int getNativeChildCount()
  {
    if (this.mNativeChildren == null) {
      return 0;
    }
    return this.mNativeChildren.size();
  }
  
  public int getNativeOffsetForChild(ReactShadowNode paramReactShadowNode)
  {
    int i = 0;
    int m = 0;
    int j = 0;
    int k = m;
    ReactShadowNode localReactShadowNode;
    if (j < getChildCount())
    {
      localReactShadowNode = getChildAt(j);
      if (paramReactShadowNode == localReactShadowNode) {
        k = 1;
      }
    }
    else
    {
      if (k != 0) {
        return i;
      }
      throw new RuntimeException("Child " + paramReactShadowNode.mReactTag + " was not a child of " + this.mReactTag);
    }
    if (localReactShadowNode.mIsLayoutOnly) {}
    for (k = localReactShadowNode.getTotalNativeChildren();; k = 1)
    {
      i += k;
      j += 1;
      break;
    }
    return i;
  }
  
  @Nullable
  public ReactShadowNode getNativeParent()
  {
    return this.mNativeParent;
  }
  
  @Nullable
  public final ReactShadowNode getParent()
  {
    return (ReactShadowNode)super.getParent();
  }
  
  public final int getReactTag()
  {
    return this.mReactTag;
  }
  
  public final ReactShadowNode getRootNode()
  {
    return (ReactShadowNode)Assertions.assertNotNull(this.mRootNode);
  }
  
  public int getScreenHeight()
  {
    return Math.round(this.mAbsoluteBottom - this.mAbsoluteTop);
  }
  
  public int getScreenWidth()
  {
    return Math.round(this.mAbsoluteRight - this.mAbsoluteLeft);
  }
  
  public int getScreenX()
  {
    return Math.round(getLayoutX());
  }
  
  public int getScreenY()
  {
    return Math.round(getLayoutY());
  }
  
  public ThemedReactContext getThemedContext()
  {
    return (ThemedReactContext)Assertions.assertNotNull(this.mThemedContext);
  }
  
  public int getTotalNativeChildren()
  {
    return this.mTotalNativeChildren;
  }
  
  public final String getViewClass()
  {
    return (String)Assertions.assertNotNull(this.mViewClassName);
  }
  
  public final boolean hasUpdates()
  {
    return (this.mNodeUpdated) || (hasNewLayout()) || (isDirty());
  }
  
  public int indexOfNativeChild(ReactShadowNode paramReactShadowNode)
  {
    Assertions.assertNotNull(this.mNativeChildren);
    return this.mNativeChildren.indexOf(paramReactShadowNode);
  }
  
  public boolean isLayoutOnly()
  {
    return this.mIsLayoutOnly;
  }
  
  public boolean isVirtual()
  {
    return false;
  }
  
  public boolean isVirtualAnchor()
  {
    return false;
  }
  
  public final void markUpdateSeen()
  {
    this.mNodeUpdated = false;
    if (hasNewLayout()) {
      markLayoutSeen();
    }
  }
  
  protected void markUpdated()
  {
    if (this.mNodeUpdated) {}
    ReactShadowNode localReactShadowNode;
    do
    {
      return;
      this.mNodeUpdated = true;
      localReactShadowNode = getParent();
    } while (localReactShadowNode == null);
    localReactShadowNode.markUpdated();
  }
  
  public void onAfterUpdateTransaction() {}
  
  public void onBeforeLayout() {}
  
  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue) {}
  
  public void removeAllChildren()
  {
    int j = 0;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      ReactShadowNode localReactShadowNode = (ReactShadowNode)super.removeChildAt(i);
      if (localReactShadowNode.mIsLayoutOnly) {}
      for (int k = localReactShadowNode.mTotalNativeChildren;; k = 1)
      {
        j += k;
        i -= 1;
        break;
      }
    }
    markUpdated();
    this.mTotalNativeChildren -= j;
    updateNativeChildrenCountInParent(-j);
  }
  
  public void removeAllNativeChildren()
  {
    if (this.mNativeChildren != null)
    {
      int i = this.mNativeChildren.size() - 1;
      while (i >= 0)
      {
        ((ReactShadowNode)this.mNativeChildren.get(i)).mNativeParent = null;
        i -= 1;
      }
      this.mNativeChildren.clear();
    }
  }
  
  public ReactShadowNode removeChildAt(int paramInt)
  {
    ReactShadowNode localReactShadowNode = (ReactShadowNode)super.removeChildAt(paramInt);
    markUpdated();
    if (localReactShadowNode.mIsLayoutOnly) {}
    for (paramInt = localReactShadowNode.mTotalNativeChildren;; paramInt = 1)
    {
      this.mTotalNativeChildren -= paramInt;
      updateNativeChildrenCountInParent(-paramInt);
      return localReactShadowNode;
    }
  }
  
  public ReactShadowNode removeNativeChildAt(int paramInt)
  {
    Assertions.assertNotNull(this.mNativeChildren);
    ReactShadowNode localReactShadowNode = (ReactShadowNode)this.mNativeChildren.remove(paramInt);
    localReactShadowNode.mNativeParent = null;
    return localReactShadowNode;
  }
  
  public void setIsLayoutOnly(boolean paramBoolean)
  {
    if (getParent() != null) {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "Must remove from no opt parent first");
      }
    }
    do
    {
      do
      {
        return;
        if (this.mNativeParent == null) {
          break;
        }
      } while (!FLog.isLoggable(6));
      FLog.e("Exception", "Must remove from native parent first");
      return;
      if (getNativeChildCount() == 0) {
        break;
      }
    } while (!FLog.isLoggable(6));
    FLog.e("Exception", "Must remove all native children first");
    return;
    this.mIsLayoutOnly = paramBoolean;
  }
  
  final void setReactTag(int paramInt)
  {
    this.mReactTag = paramInt;
  }
  
  final void setRootNode(ReactShadowNode paramReactShadowNode)
  {
    this.mRootNode = paramReactShadowNode;
  }
  
  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    this.mShouldNotifyOnLayout = paramBoolean;
  }
  
  protected void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    this.mThemedContext = paramThemedReactContext;
  }
  
  final void setViewClassName(String paramString)
  {
    this.mViewClassName = paramString;
  }
  
  boolean shouldNotifyOnLayout()
  {
    return this.mShouldNotifyOnLayout;
  }
  
  public final void updateProperties(CatalystStylesDiffMap paramCatalystStylesDiffMap)
  {
    Map localMap = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(getClass());
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramCatalystStylesDiffMap.mBackingMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      ViewManagersPropertyCache.PropSetter localPropSetter = (ViewManagersPropertyCache.PropSetter)localMap.get(localReadableMapKeySetIterator.nextKey());
      if (localPropSetter != null) {
        localPropSetter.updateShadowNodeProp(this, paramCatalystStylesDiffMap);
      }
    }
    onAfterUpdateTransaction();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ReactShadowNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */