package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class PosixParser
  extends Parser
{
  private Option currentOption;
  private boolean eatTheRest;
  private Options options;
  private final List<String> tokens = new ArrayList();
  
  private void gobble(Iterator<String> paramIterator)
  {
    if (this.eatTheRest) {}
    for (;;)
    {
      if (!paramIterator.hasNext()) {
        return;
      }
      this.tokens.add((String)paramIterator.next());
    }
  }
  
  private void init()
  {
    this.eatTheRest = false;
    this.tokens.clear();
  }
  
  private void processNonOptionToken(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.currentOption == null) || (!this.currentOption.hasArg())))
    {
      this.eatTheRest = true;
      this.tokens.add("--");
    }
    this.tokens.add(paramString);
  }
  
  private void processOptionToken(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.options.hasOption(paramString))) {
      this.eatTheRest = true;
    }
    if (this.options.hasOption(paramString)) {
      this.currentOption = this.options.getOption(paramString);
    }
    this.tokens.add(paramString);
  }
  
  protected void burstToken(String paramString, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      if (i >= paramString.length()) {
        return;
      }
      String str = String.valueOf(paramString.charAt(i));
      if (this.options.hasOption(str))
      {
        this.tokens.add("-" + str);
        this.currentOption = this.options.getOption(str);
        if ((this.currentOption.hasArg()) && (paramString.length() != i + 1)) {
          this.tokens.add(paramString.substring(i + 1));
        }
      }
      else
      {
        if (paramBoolean)
        {
          processNonOptionToken(paramString.substring(i), true);
          return;
        }
        this.tokens.add(paramString);
        return;
      }
      i += 1;
    }
  }
  
  protected String[] flatten(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException
  {
    init();
    this.options = paramOptions;
    Iterator localIterator = Arrays.asList(paramArrayOfString).iterator();
    if (!localIterator.hasNext()) {
      return (String[])this.tokens.toArray(new String[this.tokens.size()]);
    }
    String str = (String)localIterator.next();
    if (("-".equals(str)) || ("--".equals(str))) {
      this.tokens.add(str);
    }
    for (;;)
    {
      gobble(localIterator);
      break;
      if (str.startsWith("--"))
      {
        int i = str.indexOf('=');
        if (i == -1) {}
        List localList;
        for (paramArrayOfString = str;; paramArrayOfString = str.substring(0, i))
        {
          localList = paramOptions.getMatchingOptions(paramArrayOfString);
          if (!localList.isEmpty()) {
            break label175;
          }
          processNonOptionToken(str, paramBoolean);
          break;
        }
        label175:
        if (localList.size() > 1) {
          throw new AmbiguousOptionException(paramArrayOfString, localList);
        }
        this.currentOption = paramOptions.getOption((String)localList.get(0));
        this.tokens.add("--" + this.currentOption.getLongOpt());
        if (i != -1) {
          this.tokens.add(str.substring(i + 1));
        }
      }
      else if (str.startsWith("-"))
      {
        if ((str.length() == 2) || (paramOptions.hasOption(str)))
        {
          processOptionToken(str, paramBoolean);
        }
        else if (!paramOptions.getMatchingOptions(str).isEmpty())
        {
          paramArrayOfString = paramOptions.getMatchingOptions(str);
          if (paramArrayOfString.size() > 1) {
            throw new AmbiguousOptionException(str, paramArrayOfString);
          }
          paramArrayOfString = paramOptions.getOption((String)paramArrayOfString.get(0));
          processOptionToken("-" + paramArrayOfString.getLongOpt(), paramBoolean);
        }
        else
        {
          burstToken(str, paramBoolean);
        }
      }
      else
      {
        processNonOptionToken(str, paramBoolean);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\PosixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */