package org.apache.commons.cli;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CommandLine
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final List<String> args = new LinkedList();
  private final List<Option> options = new ArrayList();
  
  private Option resolveOption(String paramString)
  {
    String str = Util.stripLeadingHyphens(paramString);
    Iterator localIterator = this.options.iterator();
    Option localOption;
    do
    {
      if (!localIterator.hasNext()) {
        paramString = null;
      }
      do
      {
        return paramString;
        localOption = (Option)localIterator.next();
        paramString = localOption;
      } while (str.equals(localOption.getOpt()));
    } while (!str.equals(localOption.getLongOpt()));
    return localOption;
  }
  
  protected void addArg(String paramString)
  {
    this.args.add(paramString);
  }
  
  protected void addOption(Option paramOption)
  {
    this.options.add(paramOption);
  }
  
  public List<String> getArgList()
  {
    return this.args;
  }
  
  public String[] getArgs()
  {
    String[] arrayOfString = new String[this.args.size()];
    this.args.toArray(arrayOfString);
    return arrayOfString;
  }
  
  public Object getOptionObject(char paramChar)
  {
    return getOptionObject(String.valueOf(paramChar));
  }
  
  @Deprecated
  public Object getOptionObject(String paramString)
  {
    try
    {
      Object localObject = getParsedOptionValue(paramString);
      return localObject;
    }
    catch (ParseException localParseException)
    {
      System.err.println("Exception found converting " + paramString + " to desired type: " + localParseException.getMessage());
    }
    return null;
  }
  
  public Properties getOptionProperties(String paramString)
  {
    Properties localProperties = new Properties();
    Iterator localIterator = this.options.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localProperties;
      }
      Object localObject = (Option)localIterator.next();
      if ((paramString.equals(((Option)localObject).getOpt())) || (paramString.equals(((Option)localObject).getLongOpt())))
      {
        localObject = ((Option)localObject).getValuesList();
        if (((List)localObject).size() >= 2) {
          localProperties.put(((List)localObject).get(0), ((List)localObject).get(1));
        } else if (((List)localObject).size() == 1) {
          localProperties.put(((List)localObject).get(0), "true");
        }
      }
    }
  }
  
  public String getOptionValue(char paramChar)
  {
    return getOptionValue(String.valueOf(paramChar));
  }
  
  public String getOptionValue(char paramChar, String paramString)
  {
    return getOptionValue(String.valueOf(paramChar), paramString);
  }
  
  public String getOptionValue(String paramString)
  {
    paramString = getOptionValues(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString[0];
  }
  
  public String getOptionValue(String paramString1, String paramString2)
  {
    paramString1 = getOptionValue(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public String[] getOptionValues(char paramChar)
  {
    return getOptionValues(String.valueOf(paramChar));
  }
  
  public String[] getOptionValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.options.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!localArrayList.isEmpty()) {
          break;
        }
        return null;
      }
      Option localOption = (Option)localIterator.next();
      if ((paramString.equals(localOption.getOpt())) || (paramString.equals(localOption.getLongOpt()))) {
        localArrayList.addAll(localOption.getValuesList());
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public Option[] getOptions()
  {
    List localList = this.options;
    return (Option[])localList.toArray(new Option[localList.size()]);
  }
  
  public Object getParsedOptionValue(String paramString)
    throws ParseException
  {
    String str = getOptionValue(paramString);
    paramString = resolveOption(paramString);
    if ((paramString == null) || (str == null)) {
      return null;
    }
    return TypeHandler.createValue(str, paramString.getType());
  }
  
  public boolean hasOption(char paramChar)
  {
    return hasOption(String.valueOf(paramChar));
  }
  
  public boolean hasOption(String paramString)
  {
    return this.options.contains(resolveOption(paramString));
  }
  
  public Iterator<Option> iterator()
  {
    return this.options.iterator();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\CommandLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */