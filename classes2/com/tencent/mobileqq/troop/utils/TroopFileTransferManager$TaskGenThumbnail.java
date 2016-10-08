package com.tencent.mobileqq.troop.utils;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Map;

public class TroopFileTransferManager$TaskGenThumbnail
  extends TroopFileTransferManager.Task
{
  public int g;
  
  public TroopFileTransferManager$TaskGenThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    super(paramTroopFileTransferManager, paramItem, 1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = paramInt;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      synchronized (this.b)
      {
        if (this.a.Status == 12) {
          return;
        }
        String str = this.a.getThumbnailFile(this.b.g, this.g);
        localObject3 = str + ".ttmp";
        if (this.g == 383)
        {
          ??? = new BitmapFactory.Options();
          ((BitmapFactory.Options)???).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.a.LocalFile, (BitmapFactory.Options)???);
          ??? = TroopFileItemBuilder.a(((BitmapFactory.Options)???).outWidth, ((BitmapFactory.Options)???).outHeight);
          bool = TroopFileUtils.a(this.a.LocalFile, (String)localObject3, ???[0], ???[1]);
          ??? = this.b;
          if (!bool) {
            break label279;
          }
          try
          {
            localObject3 = new File((String)localObject3);
            ((File)localObject3).renameTo(new File(str));
            ((File)localObject3).deleteOnExit();
            if (this.g != 128) {
              break label403;
            }
            this.a.ThumbnailDownloading_Small = false;
            this.b.a(this.a, this.g);
            this.a.StatusUpdateTimeMs = 0L;
            if (this.b.b.containsKey(this.a.Id)) {
              this.b.a(this.a);
            }
            return;
          }
          finally {}
        }
      }
      boolean bool = TroopFileUtils.a(this.a.LocalFile, (String)localObject3, this.g, this.g);
      continue;
      label279:
      new File((String)localObject3).delete();
      if ((this.a.FilePath != null) && (!new File(this.a.LocalFile).exists()))
      {
        this.b.a(this.a, this.g, false);
        return;
      }
      if (this.g == 128)
      {
        this.a.ThumbnailFileTimeMS_Small = 0L;
      }
      else if (this.g == 640)
      {
        this.a.ThumbnailFileTimeMS_Large = 0L;
      }
      else if (this.g == 383)
      {
        this.a.ThumbnailFileTimeMS_Middle = 0L;
        continue;
        label403:
        if (this.g == 640) {
          this.a.ThumbnailDownloading_Large = false;
        } else if (this.g == 383) {
          this.a.ThumbnailDownloading_Middle = false;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$TaskGenThumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */