package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public final class Headers
{
  private final String[] namesAndValues;
  
  private Headers(Builder paramBuilder)
  {
    this.namesAndValues = ((String[])paramBuilder.namesAndValues.toArray(new String[paramBuilder.namesAndValues.size()]));
  }
  
  private Headers(String[] paramArrayOfString)
  {
    this.namesAndValues = paramArrayOfString;
  }
  
  private static String get(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    for (;;)
    {
      if (i < 0) {
        return null;
      }
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
  }
  
  public static Headers of(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("Expected map with header names and values");
    }
    String[] arrayOfString = new String[paramMap.size() * 2];
    int i = 0;
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext()) {
        return new Headers(arrayOfString);
      }
      Object localObject = (Map.Entry)paramMap.next();
      if ((((Map.Entry)localObject).getKey() == null) || (((Map.Entry)localObject).getValue() == null)) {
        throw new IllegalArgumentException("Headers cannot be null");
      }
      String str = ((String)((Map.Entry)localObject).getKey()).trim();
      localObject = ((String)((Map.Entry)localObject).getValue()).trim();
      if ((str.length() == 0) || (str.indexOf(0) != -1) || (((String)localObject).indexOf(0) != -1)) {
        throw new IllegalArgumentException("Unexpected header: " + str + ": " + (String)localObject);
      }
      arrayOfString[i] = str;
      arrayOfString[(i + 1)] = localObject;
      i += 2;
    }
  }
  
  public static Headers of(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length % 2 != 0)) {
      throw new IllegalArgumentException("Expected alternating header names and values");
    }
    paramVarArgs = (String[])paramVarArgs.clone();
    int i = 0;
    if (i >= paramVarArgs.length) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramVarArgs.length)
      {
        return new Headers(paramVarArgs);
        if (paramVarArgs[i] == null) {
          throw new IllegalArgumentException("Headers cannot be null");
        }
        paramVarArgs[i] = paramVarArgs[i].trim();
        i += 1;
        break;
      }
      String str1 = paramVarArgs[i];
      String str2 = paramVarArgs[(i + 1)];
      if ((str1.length() == 0) || (str1.indexOf(0) != -1) || (str2.indexOf(0) != -1)) {
        throw new IllegalArgumentException("Unexpected header: " + str1 + ": " + str2);
      }
      i += 2;
    }
  }
  
  public String get(String paramString)
  {
    return get(this.namesAndValues, paramString);
  }
  
  public Date getDate(String paramString)
  {
    paramString = get(paramString);
    if (paramString != null) {
      return HttpDate.parse(paramString);
    }
    return null;
  }
  
  public String name(int paramInt)
  {
    paramInt *= 2;
    if ((paramInt < 0) || (paramInt >= this.namesAndValues.length)) {
      return null;
    }
    return this.namesAndValues[paramInt];
  }
  
  public Set<String> names()
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j) {
        return Collections.unmodifiableSet(localTreeSet);
      }
      localTreeSet.add(name(i));
      i += 1;
    }
  }
  
  public Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    Collections.addAll(localBuilder.namesAndValues, this.namesAndValues);
    return localBuilder;
  }
  
  public int size()
  {
    return this.namesAndValues.length / 2;
  }
  
  public Map<String, List<String>> toMultimap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j) {
        return localLinkedHashMap;
      }
      String str = name(i);
      List localList = (List)localLinkedHashMap.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(2);
        localLinkedHashMap.put(str, localObject);
      }
      ((List)localObject).add(value(i));
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(name(i)).append(": ").append(value(i)).append("\n");
      i += 1;
    }
  }
  
  public String value(int paramInt)
  {
    paramInt = paramInt * 2 + 1;
    if ((paramInt < 0) || (paramInt >= this.namesAndValues.length)) {
      return null;
    }
    return this.namesAndValues[paramInt];
  }
  
  public List<String> values(String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j)
      {
        if (localObject1 == null) {
          break;
        }
        return Collections.unmodifiableList((List)localObject1);
      }
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(name(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(value(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    return Collections.emptyList();
  }
  
  public static final class Builder
  {
    private final List<String> namesAndValues = new ArrayList(20);
    
    private void checkNameAndValue(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("name == null");
      }
      if (paramString1.isEmpty()) {
        throw new IllegalArgumentException("name is empty");
      }
      int i = 0;
      int j = paramString1.length();
      int k;
      for (;;)
      {
        if (i >= j)
        {
          if (paramString2 != null) {
            break;
          }
          throw new IllegalArgumentException("value == null");
        }
        k = paramString1.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
        }
        i += 1;
      }
      i = 0;
      j = paramString2.length();
      for (;;)
      {
        if (i >= j) {
          return;
        }
        k = paramString2.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString2 }));
        }
        i += 1;
      }
    }
    
    public Builder add(String paramString)
    {
      int i = paramString.indexOf(":");
      if (i == -1) {
        throw new IllegalArgumentException("Unexpected header: " + paramString);
      }
      return add(paramString.substring(0, i).trim(), paramString.substring(i + 1));
    }
    
    public Builder add(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      return addLenient(paramString1, paramString2);
    }
    
    Builder addLenient(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1) {
        return addLenient(paramString.substring(0, i), paramString.substring(i + 1));
      }
      if (paramString.startsWith(":")) {
        return addLenient("", paramString.substring(1));
      }
      return addLenient("", paramString);
    }
    
    Builder addLenient(String paramString1, String paramString2)
    {
      this.namesAndValues.add(paramString1);
      this.namesAndValues.add(paramString2.trim());
      return this;
    }
    
    public Headers build()
    {
      return new Headers(this, null);
    }
    
    public String get(String paramString)
    {
      int i = this.namesAndValues.size() - 2;
      for (;;)
      {
        if (i < 0) {
          return null;
        }
        if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i))) {
          return (String)this.namesAndValues.get(i + 1);
        }
        i -= 2;
      }
    }
    
    public Builder removeAll(String paramString)
    {
      int j;
      for (int i = 0;; i = j + 2)
      {
        if (i >= this.namesAndValues.size()) {
          return this;
        }
        j = i;
        if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
        {
          this.namesAndValues.remove(i);
          this.namesAndValues.remove(i);
          j = i - 2;
        }
      }
    }
    
    public Builder set(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      removeAll(paramString1);
      addLenient(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */