package com.tencent.upload.network;

import android.util.SparseArray;
import com.tencent.upload.uinterface.IUploadAction;
import java.util.ArrayList;
import java.util.LinkedList;

final class l
  implements Runnable
{
  l(c paramc) {}
  
  public final void run()
  {
    int j = 0;
    while (c.c(this.b).size() > 0)
    {
      ??? = (IUploadAction)c.c(this.b).remove(0);
      if (??? != null)
      {
        int i = j;
        if (j == 0) {
          if ((((IUploadAction)???).getSendState() != 1) && (((IUploadAction)???).getSendState() != 2)) {
            break label97;
          }
        }
        label97:
        for (i = 1;; i = 0)
        {
          c.h(this.b).remove(((IUploadAction)???).getActionSequence());
          ((IUploadAction)???).onCancel(this.a);
          j = i;
          break;
        }
      }
    }
    c.c(this.b).clear();
    c.h(this.b).clear();
    c.i(this.b).clear();
    if (j != 0) {
      c.f(this.b);
    }
    synchronized (c.g(this.b))
    {
      c.g(this.b).notify();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */