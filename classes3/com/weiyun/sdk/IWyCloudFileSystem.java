package com.weiyun.sdk;

import com.weiyun.sdk.data.WyCategoryInfo;
import java.util.List;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ExtensionReq;

public abstract interface IWyCloudFileSystem
{
  public abstract IWyFileSystem.WyCommand deleteWyFile(String paramString, int paramInt, IWyFileSystem.IWyCallback<Void> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand getPreviewAddress(String paramString, IWyFileSystem.IWyCallback<IWyFileSystem.PreviewAdderss> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand getPreviewUrl(String paramString1, String paramString2, IWyFileSystem.IWyCallback<String> paramIWyCallback);
  
  public abstract boolean hasQueriedVerifyPassword();
  
  public abstract IWyFileSystem.WyCommand listCategory(IWyFileSystem.IWyCallback<List<WyCategoryInfo>> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand listCloudFiles(String paramString, int paramInt1, int paramInt2, long paramLong, IWyFileSystem.IWyCallback<IWyFileSystem.ListFiles> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand listOfflineFiles(int paramInt1, int paramInt2, int paramInt3, IWyFileSystem.IWyCallback<IWyFileSystem.ListOfflineFile> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand needVerifyIndependentPassword(IWyFileSystem.IWyCallback<Boolean> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand sendWyFile2Ftn(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString3, IWyFileSystem.IWyCallback<IWyFileSystem.CommonFtnFile> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand sendWyFile2Ftn(String paramString1, String paramString2, long paramLong1, int paramInt1, String paramString3, long paramLong2, int paramInt2, String paramString4, Cmd0X31B.ExtensionReq paramExtensionReq, IWyFileSystem.IWyCallback<IWyFileSystem.CommonFtnFile> paramIWyCallback);
  
  public abstract IWyFileSystem.WyCommand verifyIndependentPassword(String paramString1, String paramString2, IWyFileSystem.IWyCallback<String> paramIWyCallback);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\IWyCloudFileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */