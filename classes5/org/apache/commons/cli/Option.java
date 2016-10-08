package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option
  implements Cloneable, Serializable
{
  public static final int UNINITIALIZED = -1;
  public static final int UNLIMITED_VALUES = -2;
  private static final long serialVersionUID = 1L;
  private String argName;
  private String description;
  private String longOpt;
  private int numberOfArgs = -1;
  private final String opt;
  private boolean optionalArg;
  private boolean required;
  private Class<?> type = String.class;
  private List<String> values = new ArrayList();
  private char valuesep;
  
  public Option(String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    this(paramString1, null, false, paramString2);
  }
  
  public Option(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
    throws IllegalArgumentException
  {
    OptionValidator.validateOption(paramString1);
    this.opt = paramString1;
    this.longOpt = paramString2;
    if (paramBoolean) {
      this.numberOfArgs = 1;
    }
    this.description = paramString3;
  }
  
  public Option(String paramString1, boolean paramBoolean, String paramString2)
    throws IllegalArgumentException
  {
    this(paramString1, null, paramBoolean, paramString2);
  }
  
  private Option(Builder paramBuilder)
  {
    this.argName = paramBuilder.argName;
    this.description = paramBuilder.description;
    this.longOpt = paramBuilder.longOpt;
    this.numberOfArgs = paramBuilder.numberOfArgs;
    this.opt = paramBuilder.opt;
    this.optionalArg = paramBuilder.optionalArg;
    this.required = paramBuilder.required;
    this.type = paramBuilder.type;
    this.valuesep = paramBuilder.valuesep;
  }
  
  private void add(String paramString)
  {
    if (!acceptsArg()) {
      throw new RuntimeException("Cannot add value, list full.");
    }
    this.values.add(paramString);
  }
  
  public static Builder builder()
  {
    return builder(null);
  }
  
  public static Builder builder(String paramString)
  {
    return new Builder(paramString, null);
  }
  
  private boolean hasNoValues()
  {
    return this.values.isEmpty();
  }
  
  private void processValue(String paramString)
  {
    String str = paramString;
    int j;
    if (hasValueSeparator()) {
      j = getValueSeparator();
    }
    for (int i = paramString.indexOf(j);; i = paramString.indexOf(j))
    {
      if (i == -1) {
        str = paramString;
      }
      do
      {
        add(str);
        return;
        str = paramString;
      } while (this.values.size() == this.numberOfArgs - 1);
      add(paramString.substring(0, i));
      paramString = paramString.substring(i + 1);
    }
  }
  
  boolean acceptsArg()
  {
    return ((hasArg()) || (hasArgs()) || (hasOptionalArg())) && ((this.numberOfArgs <= 0) || (this.values.size() < this.numberOfArgs));
  }
  
  @Deprecated
  public boolean addValue(String paramString)
  {
    throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
  }
  
  void addValueForProcessing(String paramString)
  {
    if (this.numberOfArgs == -1) {
      throw new RuntimeException("NO_ARGS_ALLOWED");
    }
    processValue(paramString);
  }
  
  void clearValues()
  {
    this.values.clear();
  }
  
  public Object clone()
  {
    try
    {
      Option localOption = (Option)super.clone();
      localOption.values = new ArrayList(this.values);
      return localOption;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException("A CloneNotSupportedException was thrown: " + localCloneNotSupportedException.getMessage());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Option)paramObject;
      if (this.opt != null)
      {
        if (this.opt.equals(((Option)paramObject).opt)) {}
      }
      else {
        while (((Option)paramObject).opt != null) {
          return false;
        }
      }
      if (this.longOpt == null) {
        break;
      }
    } while (this.longOpt.equals(((Option)paramObject).longOpt));
    for (;;)
    {
      return false;
      if (((Option)paramObject).longOpt == null) {
        break;
      }
    }
  }
  
  public String getArgName()
  {
    return this.argName;
  }
  
  public int getArgs()
  {
    return this.numberOfArgs;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getId()
  {
    return getKey().charAt(0);
  }
  
  String getKey()
  {
    if (this.opt == null) {
      return this.longOpt;
    }
    return this.opt;
  }
  
  public String getLongOpt()
  {
    return this.longOpt;
  }
  
  public String getOpt()
  {
    return this.opt;
  }
  
  public Object getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    if (hasNoValues()) {
      return null;
    }
    return (String)this.values.get(0);
  }
  
  public String getValue(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (hasNoValues()) {
      return null;
    }
    return (String)this.values.get(paramInt);
  }
  
  public String getValue(String paramString)
  {
    String str = getValue();
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public char getValueSeparator()
  {
    return this.valuesep;
  }
  
  public String[] getValues()
  {
    if (hasNoValues()) {
      return null;
    }
    return (String[])this.values.toArray(new String[this.values.size()]);
  }
  
  public List<String> getValuesList()
  {
    return this.values;
  }
  
  public boolean hasArg()
  {
    return (this.numberOfArgs > 0) || (this.numberOfArgs == -2);
  }
  
  public boolean hasArgName()
  {
    return (this.argName != null) && (this.argName.length() > 0);
  }
  
  public boolean hasArgs()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.numberOfArgs <= 1)
    {
      bool1 = bool2;
      if (this.numberOfArgs != -2) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean hasLongOpt()
  {
    return this.longOpt != null;
  }
  
  public boolean hasOptionalArg()
  {
    return this.optionalArg;
  }
  
  public boolean hasValueSeparator()
  {
    return this.valuesep > 0;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.opt != null) {}
    for (int i = this.opt.hashCode();; i = 0)
    {
      if (this.longOpt != null) {
        j = this.longOpt.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public boolean isRequired()
  {
    return this.required;
  }
  
  boolean requiresArg()
  {
    if (this.optionalArg) {
      return false;
    }
    if (this.numberOfArgs == -2) {
      return this.values.isEmpty();
    }
    return acceptsArg();
  }
  
  public void setArgName(String paramString)
  {
    this.argName = paramString;
  }
  
  public void setArgs(int paramInt)
  {
    this.numberOfArgs = paramInt;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setLongOpt(String paramString)
  {
    this.longOpt = paramString;
  }
  
  public void setOptionalArg(boolean paramBoolean)
  {
    this.optionalArg = paramBoolean;
  }
  
  public void setRequired(boolean paramBoolean)
  {
    this.required = paramBoolean;
  }
  
  public void setType(Class<?> paramClass)
  {
    this.type = paramClass;
  }
  
  @Deprecated
  public void setType(Object paramObject)
  {
    setType((Class)paramObject);
  }
  
  public void setValueSeparator(char paramChar)
  {
    this.valuesep = paramChar;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[ option: ");
    localStringBuilder.append(this.opt);
    if (this.longOpt != null) {
      localStringBuilder.append(" ").append(this.longOpt);
    }
    localStringBuilder.append(" ");
    if (hasArgs()) {
      localStringBuilder.append("[ARG...]");
    }
    for (;;)
    {
      localStringBuilder.append(" :: ").append(this.description);
      if (this.type != null) {
        localStringBuilder.append(" :: ").append(this.type);
      }
      localStringBuilder.append(" ]");
      return localStringBuilder.toString();
      if (hasArg()) {
        localStringBuilder.append(" [ARG]");
      }
    }
  }
  
  public static final class Builder
  {
    private String argName;
    private String description;
    private String longOpt;
    private int numberOfArgs = -1;
    private final String opt;
    private boolean optionalArg;
    private boolean required;
    private Class<?> type = String.class;
    private char valuesep;
    
    private Builder(String paramString)
      throws IllegalArgumentException
    {
      OptionValidator.validateOption(paramString);
      this.opt = paramString;
    }
    
    public Builder argName(String paramString)
    {
      this.argName = paramString;
      return this;
    }
    
    public Option build()
    {
      if ((this.opt == null) && (this.longOpt == null)) {
        throw new IllegalArgumentException("Either opt or longOpt must be specified");
      }
      return new Option(this, null);
    }
    
    public Builder desc(String paramString)
    {
      this.description = paramString;
      return this;
    }
    
    public Builder hasArg()
    {
      return hasArg(true);
    }
    
    public Builder hasArg(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = -1)
      {
        this.numberOfArgs = i;
        return this;
      }
    }
    
    public Builder hasArgs()
    {
      this.numberOfArgs = -2;
      return this;
    }
    
    public Builder longOpt(String paramString)
    {
      this.longOpt = paramString;
      return this;
    }
    
    public Builder numberOfArgs(int paramInt)
    {
      this.numberOfArgs = paramInt;
      return this;
    }
    
    public Builder optionalArg(boolean paramBoolean)
    {
      this.optionalArg = paramBoolean;
      return this;
    }
    
    public Builder required()
    {
      return required(true);
    }
    
    public Builder required(boolean paramBoolean)
    {
      this.required = paramBoolean;
      return this;
    }
    
    public Builder type(Class<?> paramClass)
    {
      this.type = paramClass;
      return this;
    }
    
    public Builder valueSeparator()
    {
      return valueSeparator('=');
    }
    
    public Builder valueSeparator(char paramChar)
    {
      this.valuesep = paramChar;
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\Option.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */