package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

class ShadowNodeRegistry
{
  private final SparseBooleanArray mRootTags = new SparseBooleanArray();
  private final SparseArray<ReactShadowNode> mTagsToCSSNodes = new SparseArray();
  
  public void addNode(ReactShadowNode paramReactShadowNode)
  {
    this.mTagsToCSSNodes.put(paramReactShadowNode.getReactTag(), paramReactShadowNode);
  }
  
  public void addRootNode(ReactShadowNode paramReactShadowNode)
  {
    int i = paramReactShadowNode.getReactTag();
    this.mTagsToCSSNodes.put(i, paramReactShadowNode);
    this.mRootTags.put(i, true);
  }
  
  public ReactShadowNode getNode(int paramInt)
  {
    return (ReactShadowNode)this.mTagsToCSSNodes.get(paramInt);
  }
  
  public int getRootNodeCount()
  {
    return this.mRootTags.size();
  }
  
  public int getRootTag(int paramInt)
  {
    return this.mRootTags.keyAt(paramInt);
  }
  
  public boolean isRootNode(int paramInt)
  {
    return this.mRootTags.get(paramInt);
  }
  
  public void removeNode(int paramInt)
  {
    if (this.mRootTags.get(paramInt)) {
      throw new IllegalViewOperationException("Trying to remove root node " + paramInt + " without using removeRootNode!");
    }
    this.mTagsToCSSNodes.remove(paramInt);
  }
  
  public void removeRootNode(int paramInt)
  {
    if (!this.mRootTags.get(paramInt)) {
      throw new IllegalViewOperationException("View with tag " + paramInt + " is not registered as a root view");
    }
    this.mTagsToCSSNodes.remove(paramInt);
    this.mRootTags.delete(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ShadowNodeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */