package org.apache.commons.cli;

public abstract interface CommandLineParser
{
  public abstract CommandLine parse(Options paramOptions, String[] paramArrayOfString)
    throws ParseException;
  
  public abstract CommandLine parse(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\CommandLineParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */