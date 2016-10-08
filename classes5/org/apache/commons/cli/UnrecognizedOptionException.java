package org.apache.commons.cli;

public class UnrecognizedOptionException
  extends ParseException
{
  private static final long serialVersionUID = -252504690284625623L;
  private String option;
  
  public UnrecognizedOptionException(String paramString)
  {
    super(paramString);
  }
  
  public UnrecognizedOptionException(String paramString1, String paramString2)
  {
    this(paramString1);
    this.option = paramString2;
  }
  
  public String getOption()
  {
    return this.option;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\UnrecognizedOptionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */