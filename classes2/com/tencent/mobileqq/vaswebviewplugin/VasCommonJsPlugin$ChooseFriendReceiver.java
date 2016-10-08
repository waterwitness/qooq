package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class VasCommonJsPlugin$ChooseFriendReceiver
  extends ResultReceiver
{
  private VasCommonJsPlugin mJsPlugin;
  
  public VasCommonJsPlugin$ChooseFriendReceiver(VasCommonJsPlugin paramVasCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mJsPlugin = paramVasCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.doChooseFriendResult(null, null, null);
      return;
    }
    ArrayList localArrayList1 = paramBundle.getStringArrayList("choose_friend_uins");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("choose_friend_phones");
    paramBundle = paramBundle.getStringArrayList("choose_friend_names");
    this.mJsPlugin.doChooseFriendResult(localArrayList1, localArrayList2, paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasCommonJsPlugin$ChooseFriendReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */