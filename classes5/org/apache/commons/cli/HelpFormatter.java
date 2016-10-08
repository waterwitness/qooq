package org.apache.commons.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter
{
  public static final String DEFAULT_ARG_NAME = "arg";
  public static final int DEFAULT_DESC_PAD = 3;
  public static final int DEFAULT_LEFT_PAD = 1;
  public static final String DEFAULT_LONG_OPT_PREFIX = "--";
  public static final String DEFAULT_LONG_OPT_SEPARATOR = " ";
  public static final String DEFAULT_OPT_PREFIX = "-";
  public static final String DEFAULT_SYNTAX_PREFIX = "usage: ";
  public static final int DEFAULT_WIDTH = 74;
  @Deprecated
  public String defaultArgName = "arg";
  @Deprecated
  public int defaultDescPad = 3;
  @Deprecated
  public int defaultLeftPad = 1;
  @Deprecated
  public String defaultLongOptPrefix = "--";
  @Deprecated
  public String defaultNewLine = System.getProperty("line.separator");
  @Deprecated
  public String defaultOptPrefix = "-";
  @Deprecated
  public String defaultSyntaxPrefix = "usage: ";
  @Deprecated
  public int defaultWidth = 74;
  private String longOptSeparator = " ";
  protected Comparator<Option> optionComparator = new OptionComparator(null);
  
  private void appendOption(StringBuffer paramStringBuffer, Option paramOption, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramStringBuffer.append("[");
    }
    Object localObject;
    if (paramOption.getOpt() != null)
    {
      paramStringBuffer.append("-").append(paramOption.getOpt());
      if ((paramOption.hasArg()) && ((paramOption.getArgName() == null) || (paramOption.getArgName().length() != 0)))
      {
        if (paramOption.getOpt() != null) {
          break label137;
        }
        localObject = this.longOptSeparator;
        label69:
        paramStringBuffer.append((String)localObject);
        localObject = paramStringBuffer.append("<");
        if (paramOption.getArgName() == null) {
          break label144;
        }
      }
    }
    label137:
    label144:
    for (paramOption = paramOption.getArgName();; paramOption = getArgName())
    {
      ((StringBuffer)localObject).append(paramOption).append(">");
      if (!paramBoolean) {
        paramStringBuffer.append("]");
      }
      return;
      paramStringBuffer.append("--").append(paramOption.getLongOpt());
      break;
      localObject = " ";
      break label69;
    }
  }
  
  private void appendOptionGroup(StringBuffer paramStringBuffer, OptionGroup paramOptionGroup)
  {
    if (!paramOptionGroup.isRequired()) {
      paramStringBuffer.append("[");
    }
    Object localObject = new ArrayList(paramOptionGroup.getOptions());
    if (getOptionComparator() != null) {
      Collections.sort((List)localObject, getOptionComparator());
    }
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        if (!paramOptionGroup.isRequired()) {
          paramStringBuffer.append("]");
        }
        return;
      }
      appendOption(paramStringBuffer, (Option)((Iterator)localObject).next(), true);
      if (((Iterator)localObject).hasNext()) {
        paramStringBuffer.append(" | ");
      }
    }
  }
  
  private Appendable renderWrappedTextBlock(StringBuffer paramStringBuffer, int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new BufferedReader(new StringReader(paramString));
        int i = 1;
        String str = paramString.readLine();
        if (str == null) {
          return paramStringBuffer;
        }
        if (i == 0)
        {
          paramStringBuffer.append(getNewLine());
          renderWrappedText(paramStringBuffer, paramInt1, paramInt2, str);
        }
        else
        {
          i = 0;
        }
      }
      catch (IOException paramString)
      {
        return paramStringBuffer;
      }
    }
  }
  
  protected String createPadding(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    Arrays.fill(arrayOfChar, ' ');
    return new String(arrayOfChar);
  }
  
  protected int findWrapPos(String paramString, int paramInt1, int paramInt2)
  {
    int j = -1;
    int i = paramString.indexOf('\n', paramInt2);
    if ((i != -1) && (i <= paramInt1)) {
      i += 1;
    }
    do
    {
      do
      {
        return i;
        i = paramString.indexOf('\t', paramInt2);
        if ((i != -1) && (i <= paramInt1)) {
          return i + 1;
        }
        i = j;
      } while (paramInt2 + paramInt1 >= paramString.length());
      i = paramInt2 + paramInt1;
      for (;;)
      {
        if (i < paramInt2) {}
        int k;
        do
        {
          if (i <= paramInt2) {
            break;
          }
          return i;
          k = paramString.charAt(i);
        } while ((k == 32) || (k == 10) || (k == 13));
        i -= 1;
      }
      paramInt1 = paramInt2 + paramInt1;
      i = j;
    } while (paramInt1 == paramString.length());
    return paramInt1;
  }
  
  public String getArgName()
  {
    return this.defaultArgName;
  }
  
  public int getDescPadding()
  {
    return this.defaultDescPad;
  }
  
  public int getLeftPadding()
  {
    return this.defaultLeftPad;
  }
  
  public String getLongOptPrefix()
  {
    return this.defaultLongOptPrefix;
  }
  
  public String getLongOptSeparator()
  {
    return this.longOptSeparator;
  }
  
  public String getNewLine()
  {
    return this.defaultNewLine;
  }
  
  public String getOptPrefix()
  {
    return this.defaultOptPrefix;
  }
  
  public Comparator<Option> getOptionComparator()
  {
    return this.optionComparator;
  }
  
  public String getSyntaxPrefix()
  {
    return this.defaultSyntaxPrefix;
  }
  
  public int getWidth()
  {
    return this.defaultWidth;
  }
  
  public void printHelp(int paramInt, String paramString1, String paramString2, Options paramOptions, String paramString3)
  {
    printHelp(paramInt, paramString1, paramString2, paramOptions, paramString3, false);
  }
  
  public void printHelp(int paramInt, String paramString1, String paramString2, Options paramOptions, String paramString3, boolean paramBoolean)
  {
    PrintWriter localPrintWriter = new PrintWriter(System.out);
    printHelp(localPrintWriter, paramInt, paramString1, paramString2, paramOptions, getLeftPadding(), getDescPadding(), paramString3, paramBoolean);
    localPrintWriter.flush();
  }
  
  public void printHelp(PrintWriter paramPrintWriter, int paramInt1, String paramString1, String paramString2, Options paramOptions, int paramInt2, int paramInt3, String paramString3)
  {
    printHelp(paramPrintWriter, paramInt1, paramString1, paramString2, paramOptions, paramInt2, paramInt3, paramString3, false);
  }
  
  public void printHelp(PrintWriter paramPrintWriter, int paramInt1, String paramString1, String paramString2, Options paramOptions, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException("cmdLineSyntax not provided");
    }
    if (paramBoolean) {
      printUsage(paramPrintWriter, paramInt1, paramString1, paramOptions);
    }
    for (;;)
    {
      if ((paramString2 != null) && (paramString2.trim().length() > 0)) {
        printWrapped(paramPrintWriter, paramInt1, paramString2);
      }
      printOptions(paramPrintWriter, paramInt1, paramOptions, paramInt2, paramInt3);
      if ((paramString3 != null) && (paramString3.trim().length() > 0)) {
        printWrapped(paramPrintWriter, paramInt1, paramString3);
      }
      return;
      printUsage(paramPrintWriter, paramInt1, paramString1);
    }
  }
  
  public void printHelp(String paramString1, String paramString2, Options paramOptions, String paramString3)
  {
    printHelp(paramString1, paramString2, paramOptions, paramString3, false);
  }
  
  public void printHelp(String paramString1, String paramString2, Options paramOptions, String paramString3, boolean paramBoolean)
  {
    printHelp(getWidth(), paramString1, paramString2, paramOptions, paramString3, paramBoolean);
  }
  
  public void printHelp(String paramString, Options paramOptions)
  {
    printHelp(getWidth(), paramString, null, paramOptions, null, false);
  }
  
  public void printHelp(String paramString, Options paramOptions, boolean paramBoolean)
  {
    printHelp(getWidth(), paramString, null, paramOptions, null, paramBoolean);
  }
  
  public void printOptions(PrintWriter paramPrintWriter, int paramInt1, Options paramOptions, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    renderOptions(localStringBuffer, paramInt1, paramOptions, paramInt2, paramInt3);
    paramPrintWriter.println(localStringBuffer.toString());
  }
  
  public void printUsage(PrintWriter paramPrintWriter, int paramInt, String paramString)
  {
    int i = paramString.indexOf(' ');
    printWrapped(paramPrintWriter, paramInt, getSyntaxPrefix().length() + (i + 1), getSyntaxPrefix() + paramString);
  }
  
  public void printUsage(PrintWriter paramPrintWriter, int paramInt, String paramString, Options paramOptions)
  {
    paramString = new StringBuffer(getSyntaxPrefix()).append(paramString).append(" ");
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList(paramOptions.getOptions());
    if (getOptionComparator() != null) {
      Collections.sort((List)localObject, getOptionComparator());
    }
    localObject = ((List)localObject).iterator();
    label189:
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        printWrapped(paramPrintWriter, paramInt, paramString.toString().indexOf(' ') + 1, paramString.toString());
        return;
      }
      Option localOption = (Option)((Iterator)localObject).next();
      OptionGroup localOptionGroup = paramOptions.getOptionGroup(localOption);
      if (localOptionGroup != null) {
        if (!localArrayList.contains(localOptionGroup))
        {
          localArrayList.add(localOptionGroup);
          appendOptionGroup(paramString, localOptionGroup);
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label189;
        }
        paramString.append(" ");
        break;
        appendOption(paramString, localOption, localOption.isRequired());
      }
    }
  }
  
  public void printWrapped(PrintWriter paramPrintWriter, int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    renderWrappedTextBlock(localStringBuffer, paramInt1, paramInt2, paramString);
    paramPrintWriter.println(localStringBuffer.toString());
  }
  
  public void printWrapped(PrintWriter paramPrintWriter, int paramInt, String paramString)
  {
    printWrapped(paramPrintWriter, paramInt, 0, paramString);
  }
  
  protected StringBuffer renderOptions(StringBuffer paramStringBuffer, int paramInt1, Options paramOptions, int paramInt2, int paramInt3)
  {
    Object localObject1 = createPadding(paramInt2);
    String str1 = createPadding(paramInt3);
    paramInt2 = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramOptions.helpOptions();
    if (getOptionComparator() != null) {
      Collections.sort((List)localObject2, getOptionComparator());
    }
    Iterator localIterator = ((List)localObject2).iterator();
    int i;
    if (!localIterator.hasNext())
    {
      i = 0;
      paramOptions = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!paramOptions.hasNext())
      {
        return paramStringBuffer;
        Option localOption = (Option)localIterator.next();
        StringBuffer localStringBuffer1 = new StringBuffer();
        if (localOption.getOpt() == null) {
          localStringBuffer1.append((String)localObject1).append("   ").append(getLongOptPrefix()).append(localOption.getLongOpt());
        }
        String str2;
        for (;;)
        {
          if (localOption.hasArg())
          {
            str2 = localOption.getArgName();
            if ((str2 == null) || (str2.length() != 0)) {
              break label280;
            }
            localStringBuffer1.append(' ');
          }
          localArrayList.add(localStringBuffer1);
          i = paramInt2;
          if (localStringBuffer1.length() > paramInt2) {
            i = localStringBuffer1.length();
          }
          paramInt2 = i;
          break;
          localStringBuffer1.append((String)localObject1).append(getOptPrefix()).append(localOption.getOpt());
          if (localOption.hasLongOpt()) {
            localStringBuffer1.append(',').append(getLongOptPrefix()).append(localOption.getLongOpt());
          }
        }
        label280:
        label293:
        StringBuffer localStringBuffer2;
        if (localOption.hasLongOpt())
        {
          paramOptions = this.longOptSeparator;
          localStringBuffer1.append(paramOptions);
          localStringBuffer2 = localStringBuffer1.append("<");
          if (str2 == null) {
            break label341;
          }
        }
        label341:
        for (paramOptions = localOption.getArgName();; paramOptions = getArgName())
        {
          localStringBuffer2.append(paramOptions).append(">");
          break;
          paramOptions = " ";
          break label293;
        }
      }
      localObject1 = (Option)paramOptions.next();
      localObject2 = new StringBuilder(((StringBuffer)localArrayList.get(i)).toString());
      if (((StringBuilder)localObject2).length() < paramInt2) {
        ((StringBuilder)localObject2).append(createPadding(paramInt2 - ((StringBuilder)localObject2).length()));
      }
      ((StringBuilder)localObject2).append(str1);
      if (((Option)localObject1).getDescription() != null) {
        ((StringBuilder)localObject2).append(((Option)localObject1).getDescription());
      }
      renderWrappedText(paramStringBuffer, paramInt1, paramInt2 + paramInt3, ((StringBuilder)localObject2).toString());
      if (paramOptions.hasNext()) {
        paramStringBuffer.append(getNewLine());
      }
      i += 1;
    }
  }
  
  protected StringBuffer renderWrappedText(StringBuffer paramStringBuffer, int paramInt1, int paramInt2, String paramString)
  {
    int j = findWrapPos(paramString, paramInt1, 0);
    if (j == -1)
    {
      paramStringBuffer.append(rtrim(paramString));
      return paramStringBuffer;
    }
    paramStringBuffer.append(rtrim(paramString.substring(0, j))).append(getNewLine());
    int i = paramInt2;
    if (paramInt2 >= paramInt1) {
      i = 1;
    }
    String str = createPadding(i);
    paramInt2 = j;
    for (;;)
    {
      paramString = str + paramString.substring(paramInt2).trim();
      j = findWrapPos(paramString, paramInt1, 0);
      if (j == -1)
      {
        paramStringBuffer.append(paramString);
        return paramStringBuffer;
      }
      paramInt2 = j;
      if (paramString.length() > paramInt1)
      {
        paramInt2 = j;
        if (j == i - 1) {
          paramInt2 = paramInt1;
        }
      }
      paramStringBuffer.append(rtrim(paramString.substring(0, paramInt2))).append(getNewLine());
    }
  }
  
  protected String rtrim(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    int i = paramString.length();
    for (;;)
    {
      if ((i <= 0) || (!Character.isWhitespace(paramString.charAt(i - 1)))) {
        return paramString.substring(0, i);
      }
      i -= 1;
    }
  }
  
  public void setArgName(String paramString)
  {
    this.defaultArgName = paramString;
  }
  
  public void setDescPadding(int paramInt)
  {
    this.defaultDescPad = paramInt;
  }
  
  public void setLeftPadding(int paramInt)
  {
    this.defaultLeftPad = paramInt;
  }
  
  public void setLongOptPrefix(String paramString)
  {
    this.defaultLongOptPrefix = paramString;
  }
  
  public void setLongOptSeparator(String paramString)
  {
    this.longOptSeparator = paramString;
  }
  
  public void setNewLine(String paramString)
  {
    this.defaultNewLine = paramString;
  }
  
  public void setOptPrefix(String paramString)
  {
    this.defaultOptPrefix = paramString;
  }
  
  public void setOptionComparator(Comparator<Option> paramComparator)
  {
    this.optionComparator = paramComparator;
  }
  
  public void setSyntaxPrefix(String paramString)
  {
    this.defaultSyntaxPrefix = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.defaultWidth = paramInt;
  }
  
  private static class OptionComparator
    implements Comparator<Option>, Serializable
  {
    private static final long serialVersionUID = 5305467873966684014L;
    
    public int compare(Option paramOption1, Option paramOption2)
    {
      return paramOption1.getKey().compareToIgnoreCase(paramOption2.getKey());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\HelpFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */