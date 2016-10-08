package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class EmojiManager$SyncFetchEmoticonKeyObserver
{
  protected WeakReference a;
  
  public EmojiManager$SyncFetchEmoticonKeyObserver(EmojiManager paramEmojiManager, EmoticonHandler paramEmoticonHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramEmoticonHandler);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\EmojiManager$SyncFetchEmoticonKeyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */