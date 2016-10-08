package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class GnuParser
  extends Parser
{
  protected String[] flatten(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    int i = 0;
    if (i >= paramArrayOfString.length) {
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    String str1 = paramArrayOfString[i];
    label72:
    int j;
    if ("--".equals(str1))
    {
      bool = true;
      localArrayList.add("--");
      j = i;
      if (bool) {
        i += 1;
      }
    }
    for (;;)
    {
      if (i >= paramArrayOfString.length)
      {
        j = i;
        i = j + 1;
        break;
        if ("-".equals(str1))
        {
          localArrayList.add("-");
          break label72;
        }
        if (str1.startsWith("-"))
        {
          String str2 = Util.stripLeadingHyphens(str1);
          if (paramOptions.hasOption(str2))
          {
            localArrayList.add(str1);
            break label72;
          }
          if ((str2.indexOf('=') != -1) && (paramOptions.hasOption(str2.substring(0, str2.indexOf('=')))))
          {
            localArrayList.add(str1.substring(0, str1.indexOf('=')));
            localArrayList.add(str1.substring(str1.indexOf('=') + 1));
            break label72;
          }
          if (paramOptions.hasOption(str1.substring(0, 2)))
          {
            localArrayList.add(str1.substring(0, 2));
            localArrayList.add(str1.substring(2));
            break label72;
          }
          bool = paramBoolean;
          localArrayList.add(str1);
          break label72;
        }
        localArrayList.add(str1);
        break label72;
      }
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\GnuParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */