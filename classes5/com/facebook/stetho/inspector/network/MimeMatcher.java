package com.facebook.stetho.inspector.network;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class MimeMatcher<T>
{
  private final ArrayList<MimeMatcher<T>.MimeMatcherRule> mRuleMap = new ArrayList();
  
  public void addRule(String paramString, T paramT)
  {
    this.mRuleMap.add(new MimeMatcherRule(paramString, paramT));
  }
  
  public void clear()
  {
    this.mRuleMap.clear();
  }
  
  @Nullable
  public T match(String paramString)
  {
    int j = this.mRuleMap.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return null;
      }
      MimeMatcherRule localMimeMatcherRule = (MimeMatcherRule)this.mRuleMap.get(i);
      if (localMimeMatcherRule.match(paramString)) {
        return (T)localMimeMatcherRule.getResultIfMatched();
      }
      i += 1;
    }
  }
  
  @SuppressLint({"BadMethodUse-java.lang.String.length"})
  private class MimeMatcherRule
  {
    private final boolean mHasWildcard;
    private final String mMatchPrefix;
    private final T mResultIfMatched;
    
    public MimeMatcherRule(T paramT)
    {
      if (paramT.endsWith("*")) {
        this.mHasWildcard = true;
      }
      for (this.mMatchPrefix = paramT.substring(0, paramT.length() - 1); this.mMatchPrefix.contains("*"); this.mMatchPrefix = paramT)
      {
        throw new IllegalArgumentException("Multiple wildcards present in rule expression " + paramT);
        this.mHasWildcard = false;
      }
      Object localObject;
      this.mResultIfMatched = localObject;
    }
    
    public T getResultIfMatched()
    {
      return (T)this.mResultIfMatched;
    }
    
    public boolean match(String paramString)
    {
      if (!paramString.startsWith(this.mMatchPrefix)) {}
      while ((!this.mHasWildcard) && (paramString.length() != this.mMatchPrefix.length())) {
        return false;
      }
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\network\MimeMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */