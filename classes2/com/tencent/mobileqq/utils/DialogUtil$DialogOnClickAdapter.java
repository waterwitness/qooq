package com.tencent.mobileqq.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DialogUtil$DialogOnClickAdapter
  implements DialogInterface.OnClickListener
{
  public DialogUtil$DialogOnClickAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\DialogUtil$DialogOnClickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */