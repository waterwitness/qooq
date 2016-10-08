package com.tencent.bitapp;

public class Project
{
  Project(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    com.tencent.bitapp.pre.PreConst.mCacheSaveFolder = paramString;
    com.tencent.bitapp.pre.PreConst.isTestPerformance = paramBoolean3;
    Const.isTestPerformance = paramBoolean3;
    Const.isDebug = paramBoolean1;
    Const.isAddTextToBitmap = paramBoolean2;
    Const.isCheckBundleModify = paramBoolean5;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static class Builder
  {
    private String mCacheSaveFolder;
    private boolean mIsAddTextToBitmap = false;
    private boolean mIsCheckBundleModify = true;
    private boolean mIsDebug = false;
    private boolean mIsPreload = true;
    private boolean mIsTestPerformance = false;
    
    public Project build()
    {
      return new Project(this.mCacheSaveFolder, this.mIsDebug, this.mIsAddTextToBitmap, this.mIsTestPerformance, this.mIsPreload, this.mIsCheckBundleModify);
    }
    
    public Builder setCacheSaveFolder(String paramString)
    {
      this.mCacheSaveFolder = paramString;
      return this;
    }
    
    public Builder setDebug(boolean paramBoolean)
    {
      this.mIsDebug = paramBoolean;
      return this;
    }
    
    public Builder setIsAddTextToBitmap(boolean paramBoolean)
    {
      this.mIsAddTextToBitmap = paramBoolean;
      return this;
    }
    
    public Builder setIsCheckBundleModify(boolean paramBoolean)
    {
      this.mIsCheckBundleModify = paramBoolean;
      return this;
    }
    
    public Builder setIsPreload(boolean paramBoolean)
    {
      this.mIsPreload = paramBoolean;
      return this;
    }
    
    public Builder setIsTestPerformance(boolean paramBoolean)
    {
      this.mIsTestPerformance = paramBoolean;
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\Project.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */