package com.tencent.biz.lebasearch;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public abstract interface SearchProtocol$SearchObserver
{
  public abstract void a(int paramInt, SearchProtocol.WordItem paramWordItem);
  
  public abstract void a(int paramInt, ArrayList paramArrayList);
  
  public abstract void a(int paramInt, List paramList);
  
  public abstract void a(int paramInt, JSONArray paramJSONArray);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\SearchProtocol$SearchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */