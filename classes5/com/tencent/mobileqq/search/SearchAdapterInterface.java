package com.tencent.mobileqq.search;

import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import java.util.List;

public abstract interface SearchAdapterInterface
  extends FaceDecoder.DecodeTaskCompletionListener
{
  public static final int a = 0;
  public static final int b = 1;
  
  public abstract void a();
  
  public abstract void a(SearchAdapterInterface.SearchResultCallBack paramSearchResultCallBack);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List paramList);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void e();
  
  public abstract int getCount();
  
  public abstract Object getItem(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\SearchAdapterInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */