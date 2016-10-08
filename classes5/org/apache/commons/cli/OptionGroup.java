package org.apache.commons.cli;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OptionGroup
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Map<String, Option> optionMap = new HashMap();
  private boolean required;
  private String selected;
  
  public OptionGroup addOption(Option paramOption)
  {
    this.optionMap.put(paramOption.getKey(), paramOption);
    return this;
  }
  
  public Collection<String> getNames()
  {
    return this.optionMap.keySet();
  }
  
  public Collection<Option> getOptions()
  {
    return this.optionMap.values();
  }
  
  public String getSelected()
  {
    return this.selected;
  }
  
  public boolean isRequired()
  {
    return this.required;
  }
  
  public void setRequired(boolean paramBoolean)
  {
    this.required = paramBoolean;
  }
  
  public void setSelected(Option paramOption)
    throws AlreadySelectedException
  {
    if (paramOption == null)
    {
      this.selected = null;
      return;
    }
    if ((this.selected == null) || (this.selected.equals(paramOption.getKey())))
    {
      this.selected = paramOption.getKey();
      return;
    }
    throw new AlreadySelectedException(this, paramOption);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = getOptions().iterator();
    localStringBuilder.append("[");
    if (!localIterator.hasNext())
    {
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    Option localOption = (Option)localIterator.next();
    if (localOption.getOpt() != null)
    {
      localStringBuilder.append("-");
      localStringBuilder.append(localOption.getOpt());
    }
    for (;;)
    {
      if (localOption.getDescription() != null)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localOption.getDescription());
      }
      if (!localIterator.hasNext()) {
        break;
      }
      localStringBuilder.append(", ");
      break;
      localStringBuilder.append("--");
      localStringBuilder.append(localOption.getLongOpt());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\OptionGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */