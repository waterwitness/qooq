package com.tencent.bitapp.compression;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class AbstractCompression
  implements ICompression
{
  public boolean compress(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (paramString1.length() > 0)
      {
        bool1 = bool2;
        if (paramString2 != null)
        {
          bool1 = bool2;
          if (paramString2.length() > 0)
          {
            File localFile = new File(paramString1);
            new File(paramString2).getParentFile().mkdirs();
            if (!localFile.isDirectory()) {
              break label106;
            }
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramString1);
            bool1 = compress(localArrayList, localFile.getAbsolutePath(), paramString2);
          }
        }
      }
    }
    return bool1;
    label106:
    return compressFile(paramString1, paramString2);
  }
  
  public boolean compress(List<String> paramList, String paramString)
  {
    new File(paramString).getParentFile().mkdirs();
    return compress(paramList, "", paramString);
  }
  
  protected abstract boolean compress(List<String> paramList, String paramString1, String paramString2);
  
  protected abstract boolean compressFile(String paramString1, String paramString2);
  
  protected boolean listFiles(String paramString, Set<String> paramSet)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramSet != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length() > 0)
        {
          File localFile = new File(paramString);
          bool1 = bool2;
          if (localFile.exists())
          {
            bool1 = true;
            bool2 = true;
            if (!localFile.isDirectory()) {
              break label155;
            }
            paramString = localFile.listFiles();
            if (paramString != null)
            {
              i = 0;
              int j = paramString.length;
              bool1 = bool2;
              if (i < j) {
                break label93;
              }
            }
          }
        }
      }
    }
    label90:
    return bool1;
    label93:
    bool2 = bool1;
    if (paramString[i] != null) {
      if ((!bool1) || (!listFiles(paramString[i].getAbsolutePath(), paramSet))) {
        break label149;
      }
    }
    label149:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break label90;
      }
      i += 1;
      bool1 = bool2;
      break;
    }
    label155:
    paramSet.add(paramString);
    return true;
  }
  
  protected boolean listFiles(List<String> paramList, Set<String> paramSet)
  {
    boolean bool1 = false;
    if (paramList != null)
    {
      bool1 = true;
      paramList = paramList.iterator();
      if (paramList.hasNext()) {}
    }
    else
    {
      return bool1;
    }
    String str = (String)paramList.next();
    if ((bool1) && (listFiles(str, paramSet))) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (bool2) {
        break;
      }
      return bool2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\compression\AbstractCompression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */