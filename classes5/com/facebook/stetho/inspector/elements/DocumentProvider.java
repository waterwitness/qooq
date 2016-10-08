package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

public abstract interface DocumentProvider
  extends ThreadBound
{
  public abstract void dispose();
  
  @Nullable
  public abstract NodeDescriptor getNodeDescriptor(@Nullable Object paramObject);
  
  @Nullable
  public abstract Object getRootElement();
  
  public abstract void hideHighlight();
  
  public abstract void highlightElement(Object paramObject, int paramInt);
  
  public abstract void setAttributesAsText(Object paramObject, String paramString);
  
  public abstract void setInspectModeEnabled(boolean paramBoolean);
  
  public abstract void setListener(DocumentProviderListener paramDocumentProviderListener);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\DocumentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */