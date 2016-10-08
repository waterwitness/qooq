package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class MediaInfo
{
  public static final int ITEM_TYPE_AUDIO = 2;
  public static final int ITEM_TYPE_MUSIC = 1;
  public static final int ITEM_TYPE_NONE = 0;
  public static final int ITEM_TYPE_PIC = 4;
  public static final int ITEM_TYPE_VIDEO = 3;
  protected static final String TAG = "publish_mediaInfo";
  
  public MediaInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract String getJsonText();
  
  public abstract View getView(Context paramContext, View.OnClickListener paramOnClickListener);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */