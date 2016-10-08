package com.tencent.mobileqq.activity.aio.photo;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class AIOPhotoListUtils
{
  public AIOPhotoListUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l / 1024L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOPhotoListUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */