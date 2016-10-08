package org.apache.commons.cli;

public class MissingArgumentException
  extends ParseException
{
  private static final long serialVersionUID = -7098538588704965017L;
  private Option option;
  
  public MissingArgumentException(String paramString)
  {
    super(paramString);
  }
  
  public MissingArgumentException(Option paramOption)
  {
    this("Missing argument for option: " + paramOption.getKey());
    this.option = paramOption;
  }
  
  public Option getOption()
  {
    return this.option;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\MissingArgumentException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */