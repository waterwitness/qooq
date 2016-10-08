package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

public abstract interface NodeDescriptor
  extends ThreadBound
{
  public abstract void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator);
  
  public abstract void getChildren(Object paramObject, Accumulator<Object> paramAccumulator);
  
  public abstract String getLocalName(Object paramObject);
  
  public abstract String getNodeName(Object paramObject);
  
  public abstract NodeType getNodeType(Object paramObject);
  
  @Nullable
  public abstract String getNodeValue(Object paramObject);
  
  public abstract void getStyles(Object paramObject, StyleAccumulator paramStyleAccumulator);
  
  public abstract void hook(Object paramObject);
  
  public abstract void setAttributesAsText(Object paramObject, String paramString);
  
  public abstract void unhook(Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\NodeDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */