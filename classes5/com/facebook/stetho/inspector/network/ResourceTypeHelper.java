package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.protocol.module.Page.ResourceType;

public class ResourceTypeHelper
{
  private final MimeMatcher<Page.ResourceType> mMimeMatcher = new MimeMatcher();
  
  public ResourceTypeHelper()
  {
    this.mMimeMatcher.addRule("text/css", Page.ResourceType.STYLESHEET);
    this.mMimeMatcher.addRule("image/*", Page.ResourceType.IMAGE);
    this.mMimeMatcher.addRule("application/x-javascript", Page.ResourceType.SCRIPT);
    this.mMimeMatcher.addRule("text/javascript", Page.ResourceType.XHR);
    this.mMimeMatcher.addRule("application/json", Page.ResourceType.XHR);
    this.mMimeMatcher.addRule("text/*", Page.ResourceType.DOCUMENT);
    this.mMimeMatcher.addRule("*", Page.ResourceType.OTHER);
  }
  
  public Page.ResourceType determineResourceType(String paramString)
  {
    paramString = stripContentExtras(paramString);
    return (Page.ResourceType)this.mMimeMatcher.match(paramString);
  }
  
  public String stripContentExtras(String paramString)
  {
    int i = paramString.indexOf(';');
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\ResourceTypeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */