package com.tencent.open.agent.report;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BaseData
  implements Serializable
{
  protected static final long serialVersionUID = 10000L;
  public final HashMap attrs;
  
  public BaseData(Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.attrs = new HashMap();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.attrs.put(str, paramBundle.getString(str));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\report\BaseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */