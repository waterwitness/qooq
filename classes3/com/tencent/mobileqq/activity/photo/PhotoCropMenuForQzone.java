package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PhotoCropMenuForQzone
  extends PhotoCropAction
{
  public PhotoCropMenuForQzone(PhotoCropActivity paramPhotoCropActivity)
  {
    super(paramPhotoCropActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.getIntent().putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoCropMenuForQzone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */