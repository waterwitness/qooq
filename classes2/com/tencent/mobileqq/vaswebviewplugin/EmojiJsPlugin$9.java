package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiJsPlugin$9
  implements Runnable
{
  EmojiJsPlugin$9(EmojiJsPlugin paramEmojiJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.this$0.progressDialog != null)
    {
      this.this$0.progressDialog.cancel();
      this.this$0.progressDialog = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\EmojiJsPlugin$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */