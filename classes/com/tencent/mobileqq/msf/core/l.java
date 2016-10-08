package com.tencent.mobileqq.msf.core;

import java.io.File;
import java.util.Comparator;

class l
  implements Comparator
{
  l(k paramk) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */