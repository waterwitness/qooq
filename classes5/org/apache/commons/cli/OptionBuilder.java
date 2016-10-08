package org.apache.commons.cli;

@Deprecated
public final class OptionBuilder
{
  private static final OptionBuilder INSTANCE;
  private static String argName;
  private static String description;
  private static String longopt;
  private static int numberOfArgs = -1;
  private static boolean optionalArg;
  private static boolean required;
  private static Class<?> type;
  private static char valuesep;
  
  static
  {
    INSTANCE = new OptionBuilder();
    reset();
  }
  
  public static Option create()
    throws IllegalArgumentException
  {
    if (longopt == null)
    {
      reset();
      throw new IllegalArgumentException("must specify longopt");
    }
    return create(null);
  }
  
  public static Option create(char paramChar)
    throws IllegalArgumentException
  {
    return create(String.valueOf(paramChar));
  }
  
  public static Option create(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramString = new Option(paramString, description);
      reset();
    }
    finally
    {
      try
      {
        paramString.setLongOpt(longopt);
        paramString.setRequired(required);
        paramString.setOptionalArg(optionalArg);
        paramString.setArgs(numberOfArgs);
        paramString.setType(type);
        paramString.setValueSeparator(valuesep);
        paramString.setArgName(argName);
        reset();
        return paramString;
      }
      finally {}
      paramString = finally;
    }
    throw paramString;
  }
  
  public static OptionBuilder hasArg()
  {
    numberOfArgs = 1;
    return INSTANCE;
  }
  
  public static OptionBuilder hasArg(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      numberOfArgs = i;
      return INSTANCE;
    }
  }
  
  public static OptionBuilder hasArgs()
  {
    numberOfArgs = -2;
    return INSTANCE;
  }
  
  public static OptionBuilder hasArgs(int paramInt)
  {
    numberOfArgs = paramInt;
    return INSTANCE;
  }
  
  public static OptionBuilder hasOptionalArg()
  {
    numberOfArgs = 1;
    optionalArg = true;
    return INSTANCE;
  }
  
  public static OptionBuilder hasOptionalArgs()
  {
    numberOfArgs = -2;
    optionalArg = true;
    return INSTANCE;
  }
  
  public static OptionBuilder hasOptionalArgs(int paramInt)
  {
    numberOfArgs = paramInt;
    optionalArg = true;
    return INSTANCE;
  }
  
  public static OptionBuilder isRequired()
  {
    required = true;
    return INSTANCE;
  }
  
  public static OptionBuilder isRequired(boolean paramBoolean)
  {
    required = paramBoolean;
    return INSTANCE;
  }
  
  private static void reset()
  {
    description = null;
    argName = null;
    longopt = null;
    type = String.class;
    required = false;
    numberOfArgs = -1;
    optionalArg = false;
    valuesep = '\000';
  }
  
  public static OptionBuilder withArgName(String paramString)
  {
    argName = paramString;
    return INSTANCE;
  }
  
  public static OptionBuilder withDescription(String paramString)
  {
    description = paramString;
    return INSTANCE;
  }
  
  public static OptionBuilder withLongOpt(String paramString)
  {
    longopt = paramString;
    return INSTANCE;
  }
  
  public static OptionBuilder withType(Class<?> paramClass)
  {
    type = paramClass;
    return INSTANCE;
  }
  
  @Deprecated
  public static OptionBuilder withType(Object paramObject)
  {
    return withType((Class)paramObject);
  }
  
  public static OptionBuilder withValueSeparator()
  {
    valuesep = '=';
    return INSTANCE;
  }
  
  public static OptionBuilder withValueSeparator(char paramChar)
  {
    valuesep = paramChar;
    return INSTANCE;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\OptionBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */