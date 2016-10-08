package com.tencent.mobileqq.msf.core.auth;

import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Comparator;

class f
  implements Comparator
{
  f(d paramd) {}
  
  public int a(SimpleAccount paramSimpleAccount1, SimpleAccount paramSimpleAccount2)
  {
    long l = Long.parseLong(paramSimpleAccount1.getAttribute("_loginTime", "0"));
    if (Long.parseLong(paramSimpleAccount2.getAttribute("_loginTime", "0")) > l) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\auth\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */