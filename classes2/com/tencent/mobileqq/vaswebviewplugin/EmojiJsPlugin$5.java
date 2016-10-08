package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class EmojiJsPlugin$5
  implements DialogInterface.OnClickListener
{
  EmojiJsPlugin$5(EmojiJsPlugin paramEmojiJsPlugin, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putInt("id", this.val$emoPackId);
    paramDialogInterface.putInt("businessType", this.val$businessType);
    paramDialogInterface = DataFactory.a("startDownloadEmoji", this.val$callbackid, this.this$0.mOnRemoteResp.key, paramDialogInterface);
    this.this$0.addDownloadingStateObserver(new Pair(Integer.valueOf(this.val$emoPackId), this.val$callbackid));
    WebIPCOperator.a().b(paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiJsPlugin$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */