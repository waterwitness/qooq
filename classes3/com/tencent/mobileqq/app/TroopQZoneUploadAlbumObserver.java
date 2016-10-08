package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopQZoneUploadAlbumObserver
  implements BusinessObserver
{
  private final String a;
  
  public TroopQZoneUploadAlbumObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "TroopQZoneUploadAlbumObserver";
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 999) {
      a(paramBoolean, paramObject);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\TroopQZoneUploadAlbumObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */