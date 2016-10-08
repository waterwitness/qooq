package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Options
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Map<String, Option> longOpts = new LinkedHashMap();
  private final Map<String, OptionGroup> optionGroups = new HashMap();
  private final List<Object> requiredOpts = new ArrayList();
  private final Map<String, Option> shortOpts = new LinkedHashMap();
  
  public Options addOption(String paramString1, String paramString2)
  {
    addOption(paramString1, null, false, paramString2);
    return this;
  }
  
  public Options addOption(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    addOption(new Option(paramString1, paramString2, paramBoolean, paramString3));
    return this;
  }
  
  public Options addOption(String paramString1, boolean paramBoolean, String paramString2)
  {
    addOption(paramString1, null, paramBoolean, paramString2);
    return this;
  }
  
  public Options addOption(Option paramOption)
  {
    String str = paramOption.getKey();
    if (paramOption.hasLongOpt()) {
      this.longOpts.put(paramOption.getLongOpt(), paramOption);
    }
    if (paramOption.isRequired())
    {
      if (this.requiredOpts.contains(str)) {
        this.requiredOpts.remove(this.requiredOpts.indexOf(str));
      }
      this.requiredOpts.add(str);
    }
    this.shortOpts.put(str, paramOption);
    return this;
  }
  
  public Options addOptionGroup(OptionGroup paramOptionGroup)
  {
    if (paramOptionGroup.isRequired()) {
      this.requiredOpts.add(paramOptionGroup);
    }
    Iterator localIterator = paramOptionGroup.getOptions().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return this;
      }
      Option localOption = (Option)localIterator.next();
      localOption.setRequired(false);
      addOption(localOption);
      this.optionGroups.put(localOption.getKey(), paramOptionGroup);
    }
  }
  
  public List<String> getMatchingOptions(String paramString)
  {
    String str = Util.stripLeadingHyphens(paramString);
    ArrayList localArrayList = new ArrayList();
    if (this.longOpts.keySet().contains(str))
    {
      paramString = Collections.singletonList(str);
      return paramString;
    }
    Iterator localIterator = this.longOpts.keySet().iterator();
    for (;;)
    {
      paramString = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (String)localIterator.next();
      if (paramString.startsWith(str)) {
        localArrayList.add(paramString);
      }
    }
  }
  
  public Option getOption(String paramString)
  {
    paramString = Util.stripLeadingHyphens(paramString);
    if (this.shortOpts.containsKey(paramString)) {
      return (Option)this.shortOpts.get(paramString);
    }
    return (Option)this.longOpts.get(paramString);
  }
  
  public OptionGroup getOptionGroup(Option paramOption)
  {
    return (OptionGroup)this.optionGroups.get(paramOption.getKey());
  }
  
  Collection<OptionGroup> getOptionGroups()
  {
    return new HashSet(this.optionGroups.values());
  }
  
  public Collection<Option> getOptions()
  {
    return Collections.unmodifiableCollection(helpOptions());
  }
  
  public List getRequiredOptions()
  {
    return Collections.unmodifiableList(this.requiredOpts);
  }
  
  public boolean hasLongOption(String paramString)
  {
    paramString = Util.stripLeadingHyphens(paramString);
    return this.longOpts.containsKey(paramString);
  }
  
  public boolean hasOption(String paramString)
  {
    paramString = Util.stripLeadingHyphens(paramString);
    return (this.shortOpts.containsKey(paramString)) || (this.longOpts.containsKey(paramString));
  }
  
  public boolean hasShortOption(String paramString)
  {
    paramString = Util.stripLeadingHyphens(paramString);
    return this.shortOpts.containsKey(paramString);
  }
  
  List<Option> helpOptions()
  {
    return new ArrayList(this.shortOpts.values());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ Options: [ short ");
    localStringBuilder.append(this.shortOpts.toString());
    localStringBuilder.append(" ] [ long ");
    localStringBuilder.append(this.longOpts);
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\Options.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */