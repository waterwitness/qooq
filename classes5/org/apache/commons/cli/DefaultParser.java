package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class DefaultParser
  implements CommandLineParser
{
  protected CommandLine cmd;
  protected Option currentOption;
  protected String currentToken;
  protected List expectedOpts;
  protected Options options;
  protected boolean skipParsing;
  protected boolean stopAtNonOption;
  
  private void checkRequiredArgs()
    throws ParseException
  {
    if ((this.currentOption != null) && (this.currentOption.requiresArg())) {
      throw new MissingArgumentException(this.currentOption);
    }
  }
  
  private void checkRequiredOptions()
    throws MissingOptionException
  {
    if (!this.expectedOpts.isEmpty()) {
      throw new MissingOptionException(this.expectedOpts);
    }
  }
  
  private String getLongPrefix(String paramString)
  {
    paramString = Util.stripLeadingHyphens(paramString);
    int i = paramString.length() - 2;
    for (;;)
    {
      if (i <= 1) {
        return null;
      }
      String str = paramString.substring(0, i);
      if (this.options.hasLongOption(str)) {
        return str;
      }
      i -= 1;
    }
  }
  
  private void handleLongOption(String paramString)
    throws ParseException
  {
    if (paramString.indexOf('=') == -1)
    {
      handleLongOptionWithoutEqual(paramString);
      return;
    }
    handleLongOptionWithEqual(paramString);
  }
  
  private void handleLongOptionWithEqual(String paramString)
    throws ParseException
  {
    int i = paramString.indexOf('=');
    String str = paramString.substring(i + 1);
    paramString = paramString.substring(0, i);
    List localList = this.options.getMatchingOptions(paramString);
    if (localList.isEmpty())
    {
      handleUnknownToken(this.currentToken);
      return;
    }
    if (localList.size() > 1) {
      throw new AmbiguousOptionException(paramString, localList);
    }
    paramString = this.options.getOption((String)localList.get(0));
    if (paramString.acceptsArg())
    {
      handleOption(paramString);
      this.currentOption.addValueForProcessing(str);
      this.currentOption = null;
      return;
    }
    handleUnknownToken(this.currentToken);
  }
  
  private void handleLongOptionWithoutEqual(String paramString)
    throws ParseException
  {
    List localList = this.options.getMatchingOptions(paramString);
    if (localList.isEmpty())
    {
      handleUnknownToken(this.currentToken);
      return;
    }
    if (localList.size() > 1) {
      throw new AmbiguousOptionException(paramString, localList);
    }
    handleOption(this.options.getOption((String)localList.get(0)));
  }
  
  private void handleOption(Option paramOption)
    throws ParseException
  {
    checkRequiredArgs();
    paramOption = (Option)paramOption.clone();
    updateRequiredOptions(paramOption);
    this.cmd.addOption(paramOption);
    if (paramOption.hasArg())
    {
      this.currentOption = paramOption;
      return;
    }
    this.currentOption = null;
  }
  
  private void handleProperties(Properties paramProperties)
    throws ParseException
  {
    if (paramProperties == null) {}
    for (;;)
    {
      return;
      Enumeration localEnumeration = paramProperties.propertyNames();
      while (localEnumeration.hasMoreElements())
      {
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
            break label152;
          }
          str = paramProperties.getProperty(str);
          if (!localOption.hasArg()) {
            break label154;
          }
          if ((localOption.getValues() == null) || (localOption.getValues().length == 0)) {
            localOption.addValueForProcessing(str);
          }
        }
        label152:
        label154:
        while (("yes".equalsIgnoreCase(str)) || ("true".equalsIgnoreCase(str)) || ("1".equalsIgnoreCase(str)))
        {
          handleOption(localOption);
          this.currentOption = null;
          break;
          i = 0;
          break label82;
          break;
        }
      }
    }
  }
  
  private void handleShortAndLongOption(String paramString)
    throws ParseException
  {
    String str = Util.stripLeadingHyphens(paramString);
    int i = str.indexOf('=');
    if (str.length() == 1)
    {
      if (this.options.hasShortOption(str))
      {
        handleOption(this.options.getOption(str));
        return;
      }
      handleUnknownToken(paramString);
      return;
    }
    if (i == -1)
    {
      if (this.options.hasShortOption(str))
      {
        handleOption(this.options.getOption(str));
        return;
      }
      if (!this.options.getMatchingOptions(str).isEmpty())
      {
        handleLongOptionWithoutEqual(paramString);
        return;
      }
      localObject = getLongPrefix(str);
      if ((localObject != null) && (this.options.getOption((String)localObject).acceptsArg()))
      {
        handleOption(this.options.getOption((String)localObject));
        this.currentOption.addValueForProcessing(str.substring(((String)localObject).length()));
        this.currentOption = null;
        return;
      }
      if (isJavaProperty(str))
      {
        handleOption(this.options.getOption(str.substring(0, 1)));
        this.currentOption.addValueForProcessing(str.substring(1));
        this.currentOption = null;
        return;
      }
      handleConcatenatedOptions(paramString);
      return;
    }
    Object localObject = str.substring(0, i);
    str = str.substring(i + 1);
    if (((String)localObject).length() == 1)
    {
      localObject = this.options.getOption((String)localObject);
      if ((localObject != null) && (((Option)localObject).acceptsArg()))
      {
        handleOption((Option)localObject);
        this.currentOption.addValueForProcessing(str);
        this.currentOption = null;
        return;
      }
      handleUnknownToken(paramString);
      return;
    }
    if (isJavaProperty((String)localObject))
    {
      handleOption(this.options.getOption(((String)localObject).substring(0, 1)));
      this.currentOption.addValueForProcessing(((String)localObject).substring(1));
      this.currentOption.addValueForProcessing(str);
      this.currentOption = null;
      return;
    }
    handleLongOptionWithEqual(paramString);
  }
  
  private void handleToken(String paramString)
    throws ParseException
  {
    this.currentToken = paramString;
    if (this.skipParsing) {
      this.cmd.addArg(paramString);
    }
    for (;;)
    {
      if ((this.currentOption != null) && (!this.currentOption.acceptsArg())) {
        this.currentOption = null;
      }
      return;
      if ("--".equals(paramString)) {
        this.skipParsing = true;
      } else if ((this.currentOption != null) && (this.currentOption.acceptsArg()) && (isArgument(paramString))) {
        this.currentOption.addValueForProcessing(Util.stripLeadingAndTrailingQuotes(paramString));
      } else if (paramString.startsWith("--")) {
        handleLongOption(paramString);
      } else if ((paramString.startsWith("-")) && (!"-".equals(paramString))) {
        handleShortAndLongOption(paramString);
      } else {
        handleUnknownToken(paramString);
      }
    }
  }
  
  private void handleUnknownToken(String paramString)
    throws ParseException
  {
    if ((paramString.startsWith("-")) && (paramString.length() > 1) && (!this.stopAtNonOption)) {
      throw new UnrecognizedOptionException("Unrecognized option: " + paramString, paramString);
    }
    this.cmd.addArg(paramString);
    if (this.stopAtNonOption) {
      this.skipParsing = true;
    }
  }
  
  private boolean isArgument(String paramString)
  {
    return (!isOption(paramString)) || (isNegativeNumber(paramString));
  }
  
  private boolean isJavaProperty(String paramString)
  {
    paramString = paramString.substring(0, 1);
    paramString = this.options.getOption(paramString);
    return (paramString != null) && ((paramString.getArgs() >= 2) || (paramString.getArgs() == -2));
  }
  
  private boolean isLongOption(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString.startsWith("-")) || (paramString.length() == 1))
    {
      bool1 = false;
      return bool1;
    }
    int i = paramString.indexOf("=");
    if (i == -1) {}
    for (String str = paramString;; str = paramString.substring(0, i))
    {
      bool1 = bool2;
      if (!this.options.getMatchingOptions(str).isEmpty()) {
        break;
      }
      if (getLongPrefix(paramString) != null)
      {
        bool1 = bool2;
        if (!paramString.startsWith("--")) {
          break;
        }
      }
      return false;
    }
  }
  
  private boolean isNegativeNumber(String paramString)
  {
    try
    {
      Double.parseDouble(paramString);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  private boolean isOption(String paramString)
  {
    return (isLongOption(paramString)) || (isShortOption(paramString));
  }
  
  private boolean isShortOption(String paramString)
  {
    return (paramString.startsWith("-")) && (paramString.length() >= 2) && (this.options.hasShortOption(paramString.substring(1, 2)));
  }
  
  private void updateRequiredOptions(Option paramOption)
    throws AlreadySelectedException
  {
    if (paramOption.isRequired()) {
      this.expectedOpts.remove(paramOption.getKey());
    }
    if (this.options.getOptionGroup(paramOption) != null)
    {
      OptionGroup localOptionGroup = this.options.getOptionGroup(paramOption);
      if (localOptionGroup.isRequired()) {
        this.expectedOpts.remove(localOptionGroup);
      }
      localOptionGroup.setSelected(paramOption);
    }
  }
  
  protected void handleConcatenatedOptions(String paramString)
    throws ParseException
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
        handleOption(this.options.getOption(str));
        if ((this.currentOption != null) && (paramString.length() != i + 1)) {
          this.currentOption.addValueForProcessing(paramString.substring(i + 1));
        }
      }
      else
      {
        str = paramString;
        if (this.stopAtNonOption)
        {
          str = paramString;
          if (i > 1) {
            str = paramString.substring(i);
          }
        }
        handleUnknownToken(str);
        return;
      }
      i += 1;
    }
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString)
    throws ParseException
  {
    return parse(paramOptions, paramArrayOfString, null);
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString, Properties paramProperties)
    throws ParseException
  {
    return parse(paramOptions, paramArrayOfString, paramProperties, false);
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString, Properties paramProperties, boolean paramBoolean)
    throws ParseException
  {
    int i = 0;
    this.options = paramOptions;
    this.stopAtNonOption = paramBoolean;
    this.skipParsing = false;
    this.currentOption = null;
    this.expectedOpts = new ArrayList(paramOptions.getRequiredOptions());
    paramOptions = paramOptions.getOptionGroups().iterator();
    int j;
    if (!paramOptions.hasNext())
    {
      this.cmd = new CommandLine();
      if (paramArrayOfString != null) {
        j = paramArrayOfString.length;
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        checkRequiredArgs();
        handleProperties(paramProperties);
        checkRequiredOptions();
        return this.cmd;
        ((OptionGroup)paramOptions.next()).setSelected(null);
        break;
      }
      handleToken(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  public CommandLine parse(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException
  {
    return parse(paramOptions, paramArrayOfString, null, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\DefaultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */