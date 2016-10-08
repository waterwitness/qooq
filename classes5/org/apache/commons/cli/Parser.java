package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

@Deprecated
public abstract class Parser
  implements CommandLineParser
{
  protected CommandLine cmd;
  private Options options;
  private List requiredOptions;
  
  private void updateRequiredOptions(Option paramOption)
    throws ParseException
  {
    if (paramOption.isRequired()) {
      getRequiredOptions().remove(paramOption.getKey());
    }
    if (getOptions().getOptionGroup(paramOption) != null)
    {
      OptionGroup localOptionGroup = getOptions().getOptionGroup(paramOption);
      if (localOptionGroup.isRequired()) {
        getRequiredOptions().remove(localOptionGroup);
      }
      localOptionGroup.setSelected(paramOption);
    }
  }
  
  protected void checkRequiredOptions()
    throws MissingOptionException
  {
    if (!getRequiredOptions().isEmpty()) {
      throw new MissingOptionException(getRequiredOptions());
    }
  }
  
  protected abstract String[] flatten(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException;
  
  protected Options getOptions()
  {
    return this.options;
  }
  
  protected List getRequiredOptions()
  {
    return this.requiredOptions;
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString)
    throws ParseException
  {
    return parse(paramOptions, paramArrayOfString, null, false);
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString, Properties paramProperties)
    throws ParseException
  {
    return parse(paramOptions, paramArrayOfString, paramProperties, false);
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString, Properties paramProperties, boolean paramBoolean)
    throws ParseException
  {
    Iterator localIterator = paramOptions.helpOptions().iterator();
    if (!localIterator.hasNext()) {
      localIterator = paramOptions.getOptionGroups().iterator();
    }
    int j;
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        setOptions(paramOptions);
        this.cmd = new CommandLine();
        j = 0;
        paramOptions = paramArrayOfString;
        if (paramArrayOfString == null) {
          paramOptions = new String[0];
        }
        paramOptions = Arrays.asList(flatten(getOptions(), paramOptions, paramBoolean)).listIterator();
        if (paramOptions.hasNext()) {
          break label148;
        }
        processProperties(paramProperties);
        checkRequiredOptions();
        return this.cmd;
        ((Option)localIterator.next()).clearValues();
        break;
      }
      ((OptionGroup)localIterator.next()).setSelected(null);
    }
    label148:
    paramArrayOfString = (String)paramOptions.next();
    int i;
    if ("--".equals(paramArrayOfString)) {
      i = 1;
    }
    for (;;)
    {
      j = i;
      if (i == 0) {
        break;
      }
      for (;;)
      {
        j = i;
        if (!paramOptions.hasNext()) {
          break;
        }
        paramArrayOfString = (String)paramOptions.next();
        if (!"--".equals(paramArrayOfString)) {
          this.cmd.addArg(paramArrayOfString);
        }
      }
      if ("-".equals(paramArrayOfString))
      {
        if (paramBoolean)
        {
          i = 1;
        }
        else
        {
          this.cmd.addArg(paramArrayOfString);
          i = j;
        }
      }
      else if (paramArrayOfString.startsWith("-"))
      {
        if ((paramBoolean) && (!getOptions().hasOption(paramArrayOfString)))
        {
          i = 1;
          this.cmd.addArg(paramArrayOfString);
        }
        else
        {
          processOption(paramArrayOfString, paramOptions);
          i = j;
        }
      }
      else
      {
        this.cmd.addArg(paramArrayOfString);
        i = j;
        if (paramBoolean) {
          i = 1;
        }
      }
    }
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException
  {
    return parse(paramOptions, paramArrayOfString, null, paramBoolean);
  }
  
  public void processArgs(Option paramOption, ListIterator<String> paramListIterator)
    throws ParseException
  {
    if (!paramListIterator.hasNext()) {}
    for (;;)
    {
      if ((paramOption.getValues() != null) || (paramOption.hasOptionalArg())) {
        return;
      }
      throw new MissingArgumentException(paramOption);
      String str = (String)paramListIterator.next();
      if ((getOptions().hasOption(str)) && (str.startsWith("-"))) {
        paramListIterator.previous();
      } else {
        try
        {
          paramOption.addValueForProcessing(Util.stripLeadingAndTrailingQuotes(str));
        }
        catch (RuntimeException localRuntimeException)
        {
          paramListIterator.previous();
        }
      }
    }
  }
  
  protected void processOption(String paramString, ListIterator<String> paramListIterator)
    throws ParseException
  {
    if (!getOptions().hasOption(paramString)) {
      throw new UnrecognizedOptionException("Unrecognized option: " + paramString, paramString);
    }
    paramString = (Option)getOptions().getOption(paramString).clone();
    updateRequiredOptions(paramString);
    if (paramString.hasArg()) {
      processArgs(paramString, paramListIterator);
    }
    this.cmd.addOption(paramString);
  }
  
  protected void processProperties(Properties paramProperties)
    throws ParseException
  {
    label4:
    Enumeration localEnumeration;
    if (paramProperties == null) {
      return;
    } else {
      localEnumeration = paramProperties.propertyNames();
    }
    for (;;)
    {
      if (!localEnumeration.hasMoreElements()) {
        break label4;
      }
      String str = localEnumeration.nextElement().toString();
      Option localOption = this.options.getOption(str);
      if (localOption == null) {
        throw new UnrecognizedOptionException("Default option wasn't defined", str);
      }
      OptionGroup localOptionGroup = this.options.getOptionGroup(localOption);
      int i;
      if ((localOptionGroup != null) && (localOptionGroup.getSelected() != null))
      {
        i = 1;
        label82:
        if ((this.cmd.hasOption(str)) || (i != 0)) {
          break;
        }
        str = paramProperties.getProperty(str);
        if ((localOption.hasArg()) && ((localOption.getValues() != null) && (localOption.getValues().length != 0))) {}
      }
      try
      {
        localOption.addValueForProcessing(str);
        do
        {
          this.cmd.addOption(localOption);
          updateRequiredOptions(localOption);
          break;
          i = 0;
          break label82;
        } while (("yes".equalsIgnoreCase(str)) || ("true".equalsIgnoreCase(str)) || ("1".equalsIgnoreCase(str)));
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;) {}
      }
    }
  }
  
  protected void setOptions(Options paramOptions)
  {
    this.options = paramOptions;
    this.requiredOptions = new ArrayList(paramOptions.getRequiredOptions());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */