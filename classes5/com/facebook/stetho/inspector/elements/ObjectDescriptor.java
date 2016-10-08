package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;

public final class ObjectDescriptor
  extends Descriptor
{
  public void getAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator) {}
  
  public void getChildren(Object paramObject, Accumulator<Object> paramAccumulator) {}
  
  public String getLocalName(Object paramObject)
  {
    return getNodeName(paramObject);
  }
  
  public String getNodeName(Object paramObject)
  {
    return paramObject.getClass().getName();
  }
  
  public NodeType getNodeType(Object paramObject)
  {
    return NodeType.ELEMENT_NODE;
  }
  
  public String getNodeValue(Object paramObject)
  {
    return null;
  }
  
  public void getStyles(Object paramObject, StyleAccumulator paramStyleAccumulator) {}
  
  public void hook(Object paramObject) {}
  
  public void setAttributesAsText(Object paramObject, String paramString) {}
  
  public void unhook(Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\ObjectDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */